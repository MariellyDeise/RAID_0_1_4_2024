import java.util.Scanner;
public class RAID4 {

    String bold = "\033[1m";
    String green = "\u001B[32m";
    String reset = "\033[0m";

    void processamento(String entrada){
        Scanner scanf = new Scanner(System.in);

        int indice = entrada.length()/2;

        char[] bloco01 = new char[indice];
        char[] bloco02 = new char[indice];
        char[] bloco03 = new char[indice];
        char[] bloco_restaurado = new char[indice];
        char[] beckup = new char[indice];

        int[] bloco01_int = new int[indice];
        int[] bloco02_int = new int[indice];
        int[] bloco03_int = new int[indice];
        int[] beckup_int = new int[indice];

        int x = 0;
        int y = 0;
        int z = 0;

        for(int i = 0; i < entrada.length(); i++){
            if((i % 3) == 0){
                bloco01[x] = entrada.charAt(i);
                x++;
            }else if(((i-1) % 3) == 0){
                bloco02[y] = entrada.charAt(i);
                y++;
            }else{
                bloco03[z] = entrada.charAt(i);
                z++;
            }
        }

        for(int i = 0; i < indice; i++){
            bloco01_int[i] = (int) bloco01[i];
            //String provisoria_1 = Integer.toBinaryString(bloco01_int[i]);
            //bloco01_int[i] = Integer.parseInt(provisoria_1);

            bloco02_int[i] = (int) bloco02[i];
            //String provisoria_2 = Integer.toBinaryString(bloco02_int[i]);
            //bloco02_int[i] = Integer.parseInt(provisoria_2);

            bloco03_int[i] = (int) bloco03[i];// Eu até transformei os números em binários, mas não consegui fazer o calculo da xor depois.
            //String provisoria_3 = Integer.toBinaryString(bloco03_int[i]);
           //bloco03_int[i] = Integer.parseInt(provisoria_3);
        }

        

        for(int i = 0; i < indice; i++){
            beckup[i] = (char) (bloco01_int[i] ^ bloco02_int[i] ^ bloco03_int[i]);
        }

        String bloco01_String = new String(bloco01);
        String bloco02_String = new String(bloco02);
        String bloco03_String = new String(bloco03);
        String beckup_String = new String(beckup);

        System.out.println(bold + "BLOCO 1 =   "+ reset + bloco01_String);
        System.out.println(bold + "BLOCO 2 =   "+ reset +  bloco02_String);
        System.out.println(bold + "BLOCO 3 =   "+ reset +  bloco03_String);
        System.out.println(green + bold + "BECKUP =   "+ reset +  beckup_String + "\n");

        System.out.println("Qual bloco corrompeu? ");
        int bloco_corrompido = scanf.nextInt();

        for(int i = 0; i < indice; i++){
            beckup_int[i] = (int) beckup[i];

        }

        switch (bloco_corrompido) {
            case 1:
                for(int i = 0; i < indice; i++){
                    bloco_restaurado[i] = (char) (beckup_int[i] ^ bloco02_int[i] ^ bloco03_int[i]);
                 }
                break;
            case 2:
                for(int i = 0; i < indice; i++){
                    bloco_restaurado[i] = (char) (bloco01_int[i] ^ beckup_int[i] ^ bloco03_int[i]);
                }
            break;
            case 3:
                 for(int i = 0; i < indice; i++){
                      bloco_restaurado[i] = (char) (bloco01_int[i] ^ bloco02_int[i] ^ beckup_int[i]);
                 }
            break;
        }

        System.out.println(bold + "\n--------------- Bloco restaurado --------------\n" + reset);

        String bloco_restaurado_String = new String (bloco_restaurado);

        switch (bloco_corrompido) {
            case 1:
                System.out.println(green + bold + "BLOCO RESTAURADO =   "+ reset + bloco_restaurado_String);
                System.out.println(bold + "BLOCO 2 =   "+ reset + bloco02_String);
                System.out.println(bold + "BLOCO 3 =   "+ reset + bloco03_String + "\n");
            break;

            case 2:
                System.out.println(bold + "BLOCO 1 =   "+ reset + bloco01_String);
                System.out.println(green + bold + "BLOCO RESTAURADO =   "+ reset + bloco_restaurado_String);
                System.out.println(bold + "BLOCO 3 =   "+ reset + bloco03_String + "\n");
            break;

            case 3:
                System.out.println(bold + "BLOCO 1 =   "+ reset + bloco01_String);
                System.out.println(bold + "BLOCO 2 =   "+ reset + bloco02_String);
                System.out.println(green + bold + "BLOCO RESTAURADO =   "+ reset + bloco_restaurado_String + "\n");
            break;
        }
    }
}
