package ma.emsi.dhissiayman.projet.jrpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class ServeurGrpc {
    public static void main(String arg[]) throws IOException, InterruptedException {
        Server server= ServerBuilder.forPort(9082).addService(new UserService()).build();
        server.start();
        System.out.println("Serveur demarre au port : "+server.getPort());
        server.awaitTermination();
    }
}