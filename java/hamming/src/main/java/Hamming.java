
class Principal{
    public static void main(String[] args) {
        System.out.println(new Hamming("", "").getHammingDistance());
        System.out.println(new Hamming("A", "A").getHammingDistance());
        System.out.println(new Hamming("G", "T").getHammingDistance());
        System.out.println(new Hamming("GGACTGAAATCTG", "GGACTGAAATCTG").getHammingDistance());
        System.out.println(new Hamming("GGACGGATTCTG", "AGGACGGATTCT").getHammingDistance());
        System.out.println(new Hamming("AATG", "AAA").getHammingDistance());
        System.out.println(new Hamming("ATA", "AGTG").getHammingDistance());
        System.out.println(new Hamming("", "G").getHammingDistance());
        System.out.println(new Hamming("G", "").getHammingDistance());
    }
}


public class Hamming {

    private String leftStrand;
    private String rightStrand;

    public Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;

        int longitudLeftStrand = this.leftStrand.length();
        int longitudRightStrand = this.rightStrand.length();
        boolean mismaLongitud = longitudLeftStrand ==  longitudRightStrand;
        if(!mismaLongitud) {
            throw new IllegalArgumentException("strands must be of equal length");
        }
    }

    public int getHammingDistance() {
        //int longitudLeftStrand = this.leftStrand.length();
        //int longitudRightStrand = this.rightStrand.length();

        int contadorDiferencias = 0;

        boolean isEmptyLeftStrand = this.leftStrand.isEmpty() || this.leftStrand.isBlank();
        boolean isEmptyRightStrand = this.rightStrand.isEmpty() || this.rightStrand.isBlank();

        if(isEmptyLeftStrand && isEmptyRightStrand) {
            return 0;
        }

        for(int i = 0; i < this.leftStrand.length(); i++) {
            char caracterLeftStrand =  leftStrand.charAt(i);
            char caracterRightStrand = rightStrand.charAt(i);

            if(caracterLeftStrand != caracterRightStrand) {
                contadorDiferencias++;
            }
        }
        return contadorDiferencias;
    }
}
