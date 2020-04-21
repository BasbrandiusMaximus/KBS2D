package ontwerp;

public class Main {
    public static void main(String[] args){
        //declaratie van servers
        Server db1 = new Server(5100, 0.90);
        Server db2 = new Server(7700, 0.95);
        Server db3 = new Server(12200, 0.98);

        Server wb1 = new Server(2200, 0.80);
        Server wb2 = new Server(3200, 0.90);
        Server wb3 = new Server(5100, 0.95);

        //voer hier de serversamenstelling in
        Berekening.Bereken(db1, db1, db1);

    }
}
