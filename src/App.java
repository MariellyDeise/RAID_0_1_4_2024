import java.util.Scanner;

public class App {
   
    public static void main(String[] args) throws Exception {
        Scanner scanf = new Scanner(System.in);

        String red = "\033[0;31m";
        String green = "\u001B[32m";
        String blue = "\u001B[34m";
        String bold = "\033[1m";
        String reset = "\033[0m";

        System.out.println("Insicara uma cadeia de caracteres: ");
        String entrada = scanf.nextLine();

        System.out.println(red + bold + "\n--------------- RAID 0 ---------------\n" + reset);
        RAID0 raid0 = new RAID0();
        raid0.processamento(entrada);

        System.out.println(blue + bold + "\n--------------- RAID 1 ---------------\n" + reset);
        RAID1 raid1 = new RAID1();
        raid1.processamento(entrada);

        System.out.println(green + bold + "\n--------------- RAID 4 ---------------\n" + reset);
        RAID4 raid4 = new RAID4();
        raid4.processamento(entrada);

        scanf.close();
    }
}
