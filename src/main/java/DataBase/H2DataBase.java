package DataBase;

import org.h2.tools.Server;

import java.sql.SQLException;

public class H2DataBase {
    private static Server tcpServer;


    public static void startServer()  {
        // Start H2 TCP server
        try {
            tcpServer = Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            tcpServer.start();
            System.out.println("H2 TCP Server started and connection is open.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static void stopServer() {
        if (tcpServer != null && tcpServer.isRunning(true)) {
            tcpServer.stop();
            System.out.println("H2 TCP Server stopped and connection is closed.");
        }
    }
}
