import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

    public Server(){
        Registry registry = null;
        try{
            registry = LocateRegistry.createRegistry(1099);
            Management management = new ManagementImpl();
            Naming.rebind("rmi://localhost:1099/promotion", management);
            System.out.println("Connected");
            System.out.println("Waiting for client...");

        } catch (Exception e){
            System.out.println("Trouble: " + e);

        }
    }

    public static void main(String[] args) {
        new Server();
    }
}
