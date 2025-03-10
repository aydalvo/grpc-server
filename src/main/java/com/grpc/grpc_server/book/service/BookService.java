package com.grpc.grpc_server.book.service;

import com.proto.generated.constants.Type;
import com.proto.generated.employee.BookRequest;
import com.proto.generated.employee.BookResponse;
import com.proto.generated.employee.BookServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class BookService extends BookServiceGrpc.BookServiceImplBase {

    /**
     * Unary operation to get the book based on book id
     *
     * @param request
     * @param responseObserver
     */
    @Override
    public void getBook(BookRequest request, StreamObserver<BookResponse> responseObserver) {

        // We have mocked the employee data.
        // In real world this should be fetched from database or from some other source
        BookResponse empResp = BookResponse.newBuilder().setBookId(request.getBookId()).setName("javainuse")
                .setType(Type.AUTOBIOGRAPHY).build();

        // set the response object
        responseObserver.onNext(empResp);

        // mark process is completed
        responseObserver.onCompleted();
    }
}
