package com.example

import com.example.JijinServiceGrpc.JijinServiceImplBase
import com.example.JijinServiceGrpc.JijinServiceStub
import io.grpc.stub.StreamObserver
import jakarta.inject.Singleton

@Singleton
@Suppress("unused")
class JijinEndpoint(): JijinServiceImplBase() {
    override fun send(request: JijinRequest, responseObserver: StreamObserver<JijinReply>) {
//        super.send(request, responseObserver)
        val reply = JijinReply.newBuilder().setMessage("hello " + request.name).build()
        responseObserver.onNext(reply)
        responseObserver.onCompleted()
    }

    override fun run(request: JijinReplyTwo, responseObserver: StreamObserver<JijinReplyTwo>) {
        val replyBuilder = JijinReplyTwo.newBuilder()
        replyBuilder.setMessage("Hello " + request.message)
        replyBuilder.setCode(request.code+1)
        replyBuilder.setSuccess(!request.success)

        responseObserver.onNext(replyBuilder.build())
        responseObserver.onCompleted()
    }
}