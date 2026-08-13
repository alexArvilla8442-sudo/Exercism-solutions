import java.util.*;
import java.util.stream.Collectors;

class Principal{
    public static void main(String[] args) {
        var handshakeCalculator = new HandshakeCalculator();

        System.out.println(handshakeCalculator.calculateHandshake(1));
        System.out.println(handshakeCalculator.calculateHandshake(2));
        System.out.println(handshakeCalculator.calculateHandshake(4));
        System.out.println(handshakeCalculator.calculateHandshake(8));
        System.out.println(handshakeCalculator.calculateHandshake(3));
        System.out.println(handshakeCalculator.calculateHandshake(19));
        System.out.println(handshakeCalculator.calculateHandshake(24));
        System.out.println(handshakeCalculator.calculateHandshake(16));
        System.out.println(handshakeCalculator.calculateHandshake(15));
        System.out.println(handshakeCalculator.calculateHandshake(31));
        System.out.println(handshakeCalculator.calculateHandshake(0));
        System.out.println(handshakeCalculator.calculateHandshake(51));
        System.out.println(handshakeCalculator.calculateHandshake(35));
        System.out.println(handshakeCalculator.calculateHandshake(111));



    }
}


class HandshakeCalculator {

    /*
    00001 = wink
    00010 = double blink
    00100 = close your eyes
    01000 = jump
    10000 = Reverse the order of the operations in the secret handshake.
    */

    private Map<Integer, Signal> signalsMap = Map.of(
            1, Signal.WINK,
            2, Signal.DOUBLE_BLINK,
            4, Signal.CLOSE_YOUR_EYES,
            8, Signal.JUMP
    );

    public List<Signal> calculateHandshake(int number) {
        List<Signal> handshake = new LinkedList<>();

        List<Integer> listaBinario = this.convertirDecimalBinario(number);

        int valorQuintaPosicion = listaBinario.get(4);
        if(valorQuintaPosicion == 0){
            handshake = this.getListSignal(listaBinario);
        }else{
            listaBinario.remove(4);
            handshake = this.getListSignal(listaBinario);
            Collections.reverse(handshake);
        }
        //System.out.println(listaBinario);
        //System.out.println(handshake);

        return handshake;
    }

    public List<Integer> convertirDecimalBinario(int number) {
        List<Integer> listaBinario = new LinkedList<>();
        do{
            int residuo = number % 2;
            number /= 2;

            int valorBinario = (residuo == 0) ? 0 : 1;
            listaBinario.add(valorBinario);
        }while(number != 0);

        int tamanioLista = listaBinario.size();
        boolean isGreaterFive = tamanioLista > 5;
        boolean isLessFive = tamanioLista < 5;

        List<Integer> listaModificada = (isGreaterFive || isLessFive) ? this.modifyList(listaBinario) : listaBinario;
        return listaModificada;
    }

    public List<Integer> modifyList(List<Integer> listaBinario){
        int tamanioLista = listaBinario.size();
        boolean isGreaterFive = tamanioLista > 5;
        boolean isLessFive = tamanioLista < 5;
        List<Integer> listaFinal = new LinkedList<>(listaBinario);

        if(isGreaterFive){
            //cortar
            listaFinal = listaBinario.stream()
                    .limit(5)
                    .collect(Collectors.toList());
        }else if(isLessFive){
            //agregar ceros
            for (int i = tamanioLista + 1; i <= 5; i++) {
                listaFinal.add(0);
            }
        }
        return listaFinal;
    }

    public List<Signal> getListSignal(List<Integer> listaBinario){
        List<Signal> handshake = new LinkedList<>();

        for(int i = 0; i < listaBinario.size(); i++){
            int valorLista = listaBinario.get(i);

            if(valorLista == 1){
                int valorMapComprobar = (int) Math.pow(2, i);
                Signal signal = signalsMap.get(valorMapComprobar);
                handshake.add(signal);
            }
        }
        return handshake;
    }

}
