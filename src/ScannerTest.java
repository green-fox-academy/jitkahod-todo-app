import java.util.Scanner;

public class ScannerTest {
       static boolean ukoncit = false;
       static Scanner in = new Scanner(System.in);
    public static void main(String[] arg) throws Exception {
        while (!ukoncit) {
            ukazMenu();
        }
    }
    public static void ukazMenu(){
        System.out.print ("1) Scitat\n2) Odcitat\n0) Ukoncit\nZadejte vasi volbu: ");
        switch (in.nextInt()){
            case 1:
                scitej();
                break;
            case 2:
                odecitej();
                break;
            case 0:
                ukoncit = true;
                break;
            default:
                ukazMenu("Neplatna volba! Zadejte znovu.");
        }
    }
    public static void scitej(){
        System.out.println("zadej I. scitanec");
        int prvni = in.nextInt();
        System.out.println("zadej II");
        int druhy = in.nextInt();
        System.out.println("vysledek je: "+ (prvni + druhy));
    }
    public static void odecitej(){
        System.out.println("zadej I. mensenec");
        int prvni = in.nextInt();
        System.out.println("zadej II");
        int druhy = in.nextInt();
        System.out.println("vysledek je: "+ (prvni - druhy));
    }
    public static void ukazMenu(String zprava){
        System.out.println(zprava);
        ukazMenu();
    }
}
