class Principal{
    public static void main(String[] args) {
        System.out.println(new RotationalCipher(0).rotate("a"));
        System.out.println(new RotationalCipher(1).rotate("a"));
        System.out.println(new RotationalCipher(26).rotate("a"));
        System.out.println(new RotationalCipher(13).rotate("m"));
        System.out.println(new RotationalCipher(13).rotate("n"));
        System.out.println( new RotationalCipher(5).rotate("OMG"));
        System.out.println(new RotationalCipher(5).rotate("O M G"));
        System.out.println(new RotationalCipher(4).rotate("Testing 1 2 3 testing"));
        System.out.println(new RotationalCipher(21).rotate("Let's eat, Grandma!"));
        System.out.println(new RotationalCipher(13).rotate("Gur dhvpx oebja sbk whzcf bire gur ynml qbt."));


    }
}

class RotationalCipher {
    private int shiftKey;


    RotationalCipher(int shiftKey) {
        this.shiftKey = shiftKey;
    }

    String rotate(String data) {
        int posicionNuevaLetra = this.getShiftKey();

        if(posicionNuevaLetra == 0 || posicionNuevaLetra == 26){
            return data;
        }

        String textoOriginal = data;
        StringBuilder cipherText = new StringBuilder();
        int tamanioTexto = textoOriginal.length();

        for (int i = 0; i < tamanioTexto; i++) {
            char caracter = textoOriginal.charAt(i);
            boolean isLetter = this.CaracterEsLetra(caracter);
            if (isLetter) {
                boolean isUpperCase = this.LetterIsUppperOrLower(caracter);
                char newLetter = this.getNewLetter(caracter);
                if (isUpperCase) {
                    newLetter = Character.toUpperCase(newLetter);
                }
                cipherText.append(newLetter);
            }else{
                cipherText.append(caracter);
            }
        }
        return cipherText.toString();
    }

    private boolean CaracterEsLetra(char caracter){
        boolean isLetter = Character.isLetter(caracter);
        return isLetter;
    }

    private boolean LetterIsUppperOrLower(char caracter){
        boolean isUpperorLower = Character.isUpperCase(caracter);
        return isUpperorLower;
    }

    private char getNewLetter(char letra){
        int posicionCambioLetra = this.getShiftKey();
        char letter = Character.toLowerCase(letra);
        String abecedario = "abcdefghijklmnopqrstuvwxyz";

        int indiceLetraAbecedario = abecedario.indexOf(letter);

        String nuevoABC = this.getNewABC(indiceLetraAbecedario, abecedario);
        char nuevaLetra = nuevoABC.charAt(posicionCambioLetra);

        return nuevaLetra;
    }

    private String getNewABC(int indiceLetraAbecedario, String abecedario){
        String primerSubString = abecedario.substring(indiceLetraAbecedario);
        String segundoSubString = abecedario.substring(0, indiceLetraAbecedario);
        return primerSubString + segundoSubString;
    }

    private int getShiftKey() {
        return shiftKey;
    }

}
