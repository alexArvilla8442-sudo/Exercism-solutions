import java.util.*;

class Principal{
    public static void main(String[] args) {
        var proteinTranslator = new ProteinTranslator();

        System.out.println(proteinTranslator.translate(""));
        System.out.println(proteinTranslator.translate("AUG"));
        System.out.println(proteinTranslator.translate("UUU"));
        System.out.println(proteinTranslator.translate("UUC"));
        System.out.println(proteinTranslator.translate("UUA"));
        System.out.println(proteinTranslator.translate("UUG"));
        System.out.println(proteinTranslator.translate("UCU"));
        System.out.println(proteinTranslator.translate("UCC"));
        System.out.println(proteinTranslator.translate("UCA"));
        System.out.println(proteinTranslator.translate("UCG"));
        System.out.println(proteinTranslator.translate("UAU"));
        System.out.println(proteinTranslator.translate("UAC"));
        System.out.println(proteinTranslator.translate("UGU"));
        System.out.println(proteinTranslator.translate("UGC"));
        System.out.println(proteinTranslator.translate("UGG"));
        System.out.println(proteinTranslator.translate("UAA"));
        System.out.println(proteinTranslator.translate("UAG"));
        System.out.println(proteinTranslator.translate("UGA"));
        System.out.println(proteinTranslator.translate("UUUUUU"));
        System.out.println(proteinTranslator.translate("UUAUUG"));
        System.out.println(proteinTranslator.translate("AUGUUUUGG"));
        System.out.println(proteinTranslator.translate("UAGUGG"));
        System.out.println(proteinTranslator.translate("UGGUAG"));
        System.out.println(proteinTranslator.translate("AUGUUUUAA"));
        System.out.println(proteinTranslator.translate("UGGUAGUGG"));
        System.out.println(proteinTranslator.translate("UGGUGUUAUUAAUGGUUU"));
        System.out.println(proteinTranslator.translate("AUGAUG"));
        System.out.println(proteinTranslator.translate("AAA"));
        System.out.println(proteinTranslator.translate("XYZ"));
        System.out.println(proteinTranslator.translate("AUGU"));
        System.out.println(proteinTranslator.translate("UUCUUCUAAUGGU"));
    }
}

class ProteinTranslator {

    private Map<String, Set<String>> rnaSequencesMap = new LinkedHashMap<>();

    public ProteinTranslator(){
        rnaSequencesMap.computeIfAbsent("Methionine", s -> Set.of("AUG"));
        rnaSequencesMap.computeIfAbsent("Phenylalanine", s->Set.of("UUU", "UUC"));
        rnaSequencesMap.computeIfAbsent("Leucine", s->Set.of("UUA", "UUG"));
        rnaSequencesMap.computeIfAbsent("Serine", s->Set.of("UCU", "UCC", "UCA", "UCG"));
        rnaSequencesMap.computeIfAbsent("Tyrosine", s->Set.of("UAU", "UAC"));
        rnaSequencesMap.computeIfAbsent("Cysteine", s->Set.of("UGU", "UGC"));
        rnaSequencesMap.computeIfAbsent("Tryptophan", s->Set.of("UGG"));
        rnaSequencesMap.computeIfAbsent("STOP", s->Set.of("UAA", "UAG", "UGA"));
    }

    List<String> translate(String rnaSequence) {

        int tamanioRNA = rnaSequence.length();

        int tiposRNA = tamanioRNA / 3;
        List<String> rnaSequencesList = new ArrayList<>();

        int desde = 0;
        int hasta = 3;

        //verificar si existe el STOP
        String secuenciaRNA;
        for (int i = 0; i < tiposRNA; i++) {
            String tipoRNA = rnaSequence.substring(desde,hasta);

            if(tipoRNA.equals("UAA") || tipoRNA.equals("UAG") || tipoRNA.equals("UGA")){
                rnaSequence = rnaSequence.substring(0,desde);
                tamanioRNA = rnaSequence.length();
                tiposRNA = tamanioRNA / 3;

                break;
            }
            desde = hasta;
            hasta += 3;
        }

        if(tamanioRNA % 3 != 0){
            throw new IllegalArgumentException("Invalid codon");
        }

        int desde2 = 0;
        int hasta2 = 3;


        for (int i = 0; i < tiposRNA; i++) {
            boolean existe = false;
            String tipoRNA = rnaSequence.substring(desde2,hasta2);

            for (Map.Entry<String, Set<String>> entry : rnaSequencesMap.entrySet()) {
                String AminoAcid = entry.getKey();
                Set<String> Codon = entry.getValue();

                String aminoAcid = AminoAcid;
                Set<String> codon = Codon;

                if (codon.contains(tipoRNA)) {
                    rnaSequencesList.add(aminoAcid);
                    existe = true;
                    break;
                }
            }

            if (!existe) {
                throw new IllegalArgumentException("Invalid codon");
            }

            desde2 = hasta2;
            hasta2 += 3;
        }

        return  rnaSequencesList;
    }
}
