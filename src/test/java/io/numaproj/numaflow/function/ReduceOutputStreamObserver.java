package io.numaproj.numaflow.function;

import io.grpc.stub.StreamObserver;
import io.numaproj.numaflow.function.v1.Udfunction;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;

@Slf4j
public class ReduceOutputStreamObserver implements StreamObserver<Udfunction.DatumList> {
    public Udfunction.DatumList resultDatum;
    public AtomicReference<Throwable> t = new AtomicReference<>();

    @Override
    public void onNext(Udfunction.DatumList datum) {
        System.out.println("got the result");
        System.out.println(datum);
        resultDatum = datum;
    }

    @Override
    public void onError(Throwable throwable) {
        t.set(throwable);
        throwable.printStackTrace();
        System.out.println("got the error");
    }

    @Override
    public void onCompleted() {
        log.info("on completed executed");
    }
}
