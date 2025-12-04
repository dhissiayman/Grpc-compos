package ma.emsi.dhissiayman.projet.jrpc;

import app.grpc.userGrpc;           // stub gRPC généré
import app.grpc.User;               // messages générés (LoginRequest, LoginResponse)
import io.grpc.stub.StreamObserver; // observer gRPC

public class UserService extends userGrpc.userImplBase {
    @Override
    public void login(User.LoginRequest request, StreamObserver<User.LoginResponse> responseObserver) {
        String username=request.getUserName();
        String password=request.getPassword();
        User.LoginResponse.Builder response= User.LoginResponse.newBuilder();
        if(username.equals(password)) {
            response.setIdResponse(0).setMsgResponse("SUCCES");
        }
        else
            response.setIdResponse(100).setMsgResponse("NON VALIDE");
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}
