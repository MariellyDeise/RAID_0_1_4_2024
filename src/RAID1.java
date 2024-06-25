public class RAID1 {
    static void processamento(String entrada){

        String bold = "\033[1m";
        String reset = "\033[0m";

        String bloco01 = new String(entrada);
        String bloco02 = new String(entrada);

        System.out.println(bold + "BLOCO 1 =  " + reset + bloco01);
        System.out.println(bold + "BLOCO 2 = "+ reset + bloco02);
    }
}
