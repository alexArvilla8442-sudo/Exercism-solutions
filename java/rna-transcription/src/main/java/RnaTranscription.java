import java.util.Map;

class Principal{
    public static void main(String[] args) {
        var rnaTranscription = new RnaTranscription();
        System.out.println(rnaTranscription.transcribe(""));
        System.out.println(rnaTranscription.transcribe("C"));
        System.out.println(rnaTranscription.transcribe("G"));
        System.out.println(rnaTranscription.transcribe("T"));
        System.out.println(rnaTranscription.transcribe("A"));
        System.out.println(rnaTranscription.transcribe("ACGTGGTCTTAA"));
    }
}

class RnaTranscription {

    /*
    * G -> C
C -> G
T -> A
A -> U
    * */
    Map<Character, Character> transcribe = Map.of(
      'G', 'C',
      'C', 'G',
      'T', 'A',
      'A', 'U'
    );

    String transcribe(String dnaStrand) {
        StringBuilder transcribeResult = new StringBuilder();

        for (int i = 0; i < dnaStrand.length(); i++) {
            char llave = dnaStrand.charAt(i);
            char value = this.getValue(llave);

            if(value == '0'){
                return "error, vuelve a intentarlo";
            }
            transcribeResult.append(value);
        }
        String imprimirMensaje = transcribeResult.toString();
        return imprimirMensaje;
    }

    public char getValue(char llave){
        char value = this.transcribe.getOrDefault(llave, '0');
        if(value == '0'){
            return value;
        }
        return value;
    }

}
