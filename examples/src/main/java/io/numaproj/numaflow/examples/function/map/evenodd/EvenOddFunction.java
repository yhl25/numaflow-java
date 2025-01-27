package io.numaproj.numaflow.examples.function.map.evenodd;

import io.numaproj.numaflow.function.FunctionServer;
import io.numaproj.numaflow.function.handlers.MapHandler;
import io.numaproj.numaflow.function.interfaces.Datum;
import io.numaproj.numaflow.function.types.Message;
import io.numaproj.numaflow.function.types.MessageList;
import lombok.extern.slf4j.Slf4j;

/**
 * This is a simple User Defined Function example which receives a message,
 * and attaches keys to the message based on the value, if the value is even
 * the key will be set as "even" if the value is odd the key will be set as
 * "odd"
 */

@Slf4j
public class EvenOddFunction extends MapHandler {

    public static void main(String[] args) throws Exception {
        new FunctionServer().registerMapHandler(new EvenOddFunction()).start();
    }

    public MessageList processMessage(String[] keys, Datum data) {
        int value = 0;
        try {
            value = Integer.parseInt(new String(data.getValue()));
        } catch (NumberFormatException e) {
            log.error("Error occurred while parsing int");
            return MessageList.newBuilder().addMessage(Message.toDrop()).build();
        }

        String[] outputKeys = value % 2 == 0 ? new String[]{"even"}:new String[]{"odd"};

        // tags will be used for conditional forwarding
        String[] tags = value % 2 == 0 ? new String[]{"even-tag"}:new String[]{"odd-tag"};

        return MessageList
                .newBuilder()
                .addMessage(new Message(data.getValue(), outputKeys, tags))
                .build();
    }
}
