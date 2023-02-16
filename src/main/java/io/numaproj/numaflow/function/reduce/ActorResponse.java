package io.numaproj.numaflow.function.reduce;

import io.numaproj.numaflow.function.v1.Udfunction;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ActorResponse {
    String key;
    Udfunction.DatumList datumList;
}
