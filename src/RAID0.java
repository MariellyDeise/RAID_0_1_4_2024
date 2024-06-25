public class RAID0 {
    static void processamento(String entrada){

        String bold = "\033[1m";
        String reset = "\033[0m";

        int indice = entrada.length()/2;
        char[] bloco01 = new char[indice];
        char[] bloco02 = new char[indice];
        int x = 0;
        int y = 0;

        for(int i = 0; i < entrada.length(); i++){
            if((i % 2) == 0){
                bloco01[x] = entrada.charAt(i);
                x++;
            }else{
                bloco02[y] = entrada.charAt(i);
                y++;
            }
        }

        String bloco001 = new String(bloco01);
        String bloco002 = new String(bloco02);

        System.out.println(bold + "BLOCO 1 = " + reset + bloco001);
        System.out.println(bold + "BLOCO 2 =   " + reset + bloco002);
    }
}
