

public class LogLevels {
    public static void main(String[] args) {

        message("[ERROR]: Stack overflow");
        message("[WARNING]: Disk almost full");
        message("[INFO]: File moved");
        message("[WARNING]:   \tTimezone not set  \r\n");

        logLevel("[ERROR]: Disk full");
        logLevel("[WARNING]: Unsafe password");
        logLevel("[INFO]: Timezone changed");

        reformat("[ERROR]: Segmentation fault");
        reformat("[WARNING]: Decreased performance");
        reformat("[INFO]: Disk defragmented");
        reformat("[ERROR]: \t Corrupt disk\t \t \n");





    }
    public static String message(String logLine) {
        int dosPuntosPosicion = logLine.indexOf(":");
        String nuevaCadena = logLine.substring(dosPuntosPosicion + 1);

        return nuevaCadena.trim();
    }

    public static String logLevel(String logLine) {
        int segundoCorcheteIndice = logLine.indexOf("]");
        String mensajeError =  logLine.substring(1, segundoCorcheteIndice).toLowerCase();

        return mensajeError;
    }

    public static String reformat(String logLine) {
        int segundoCorchete = logLine.indexOf("]");
        int dosPuntos = logLine.indexOf(":");
        String mensajeError =  logLine.substring(1, segundoCorchete).toLowerCase();
        String mensaje = logLine.substring(dosPuntos + 1).trim();
        return mensaje + " (" + mensajeError + ")";
    }
}
