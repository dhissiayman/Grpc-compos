package ma.emsi.dhissiayman.projet.jrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import app.grpc.User;
import app.grpc.userGrpc;

public class ClientGrpc {

    public static void main(String[] args) {

        // 1. Créer le channel vers le serveur
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 9082)
                .usePlaintext()        // pas de SSL
                .build();

        // 2. Créer le stub (client gRPC)
        userGrpc.userBlockingStub stub = userGrpc.newBlockingStub(channel);

        // 3. Construire la requête
        User.LoginRequest request = User.LoginRequest.newBuilder()
                .setUserName("admin")    // tu peux changer pour tester
                .setPassword("admin")    // pareil ici
                .build();

        // 4. Appeler le service distant
        User.LoginResponse response = stub.login(request);

        // 5. Afficher la réponse
        System.out.println("Message : " + response.getMsgResponse());
        System.out.println("Code    : " + response.getIdResponse());

        // 6. Fermer le channel
        channel.shutdown();
    }
}
