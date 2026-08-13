import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.vdurmont.emoji.EmojiManager;
import com.vdurmont.emoji.EmojiParser;

class Principal{
    public static void main(String[] args) {
        MicroBlog microBlog = new MicroBlog();

        System.out.println(microBlog.truncate("Hi"));
        System.out.println(microBlog.truncate("Hello there"));
        System.out.println(microBlog.truncate("brühe"));
        System.out.println(microBlog.truncate("Bärteppich"));
        System.out.println(microBlog.truncate("Добър"));
        System.out.println(microBlog.truncate("υγειά"));
        System.out.println(microBlog.truncate("a=πr²"));
        System.out.println(microBlog.truncate("∅⊊ℕ⊊ℤ⊊ℚ⊊ℝ⊊ℂ"));
        System.out.println(microBlog.truncate("Fly 🛫"));
        System.out.println(microBlog.truncate("💇"));
        System.out.println(microBlog.truncate("❄🌡🤧🤒🏥🕰😀"));
        System.out.println(microBlog.truncate("🃎🂸🃅🃋🃍🃁🃊"));
    }
}


class MicroBlog {

    public String truncate(String input) {

        StringBuilder mensaje = new StringBuilder();
        int longitudMaxima = 5;
        int longitudCadena = input.length();
        int longitudMaximaCadena = Math.min(input.length(), longitudMaxima);
        int contador = 0;
        int i = 0;

        while(i < longitudCadena){

            if(contador == longitudMaximaCadena){
                break;
            }

            int codePoint = input.codePointAt(i);
            String elemento = Character.toString(codePoint);
            //System.out.println("Encontrado en índice " + i + ": " + elemento);
            mensaje.append(elemento);

            i += Character.charCount(codePoint);
            contador++;
        }

        return mensaje.toString();
    }

    /*public boolean contieneEmoji(String cadena){
        return EmojiManager.containsEmoji(cadena);
    }*/

}



//boolean contieneEmoji = ContieneEmoji(input);
//System.out.println("contiene emoji: " +  contieneEmoji);

//if(!contieneEmoji){

           /* while(i < longitudCadena){

                if(contador == longitudMaximaCadena){
                    break;
                }

                int codePoint = input.codePointAt(i);
                String elemento = Character.toString(codePoint);
                //System.out.println("Encontrado en índice " + i + ": " + elemento);
                mensaje.append(elemento);

                i += Character.charCount(codePoint);
                contador++;
            }
            System.out.println(mensaje.toString());*/

            /*int longitud = input.length();
            System.out.println(input);
            System.out.println("longitud " + longitud);
            if(longitud <= 5){
                return input;
            }
            nuevaCadena = input.substring(0, longitudMaxima);
            return nuevaCadena;*/
//}
