import DataBase.H2DataBase;

public class Main {
    public static void main(String[] args) {
        H2DataBase.startServer();
        System.out.println("Hello world!");
        H2DataBase.stopServer();
    }
}