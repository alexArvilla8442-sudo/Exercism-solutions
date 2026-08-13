//import jdk.incubator.vector.VectorSpecies;

import java.util.*;

class principal{
    public static void main(String[] args) {
        var logLine = new LogLine("[TRC]: Line 84 - System.out.println(\"Hello World\");");
        System.out.println(logLine.getLogLevel());

        var logLine2 = new LogLine("[DBG]: ; expected");
        System.out.println(logLine2.getLogLevel());

        var logLine3 = new LogLine("[INF]: Timezone changed");
        System.out.println(logLine3.getLogLevel());

        var logLine4 = new LogLine("[WRN]: Timezone not set");
        System.out.println(logLine4.getLogLevel());

        var logLine5 = new LogLine("[ERR]: Disk full");
        System.out.println(logLine5.getLogLevel());

        var logLine6 = new LogLine("[FTL]: Not enough memory");
        System.out.println(logLine6.getLogLevel());

        var logLine7 = new LogLine("[XYZ]: Gibberish message.. beep boop..");
        System.out.println(logLine7.getLogLevel());

        var logLine8 = new LogLine("[ABC]: Gibberish message.. beep boop..");
        System.out.println(logLine8.getLogLevel());

        var logLine9 = new LogLine("[ABC]: We're no strangers to love");
        System.out.println(logLine9.getOutputForShortLog());

        var logLine10 = new LogLine("[TRC]: You know the rules and so do I");
        System.out.println(logLine10.getOutputForShortLog());

        var logLine11 = new LogLine("[DBG]: A full commitment's what I'm thinking of");
        System.out.println(logLine11.getOutputForShortLog());

        var logLine12 = new LogLine("[INF]: You wouldn't get this from any other guy");
        System.out.println(logLine12.getOutputForShortLog());

        var logLine13 = new LogLine("[WRN]: I just wanna tell you how I'm feeling");
        System.out.println(logLine13.getOutputForShortLog());

        var logLine14 = new LogLine("[ERR]: Gotta make you understand");
        System.out.println(logLine14.getOutputForShortLog());

        var logLine15 = new LogLine("[FTL]: Never gonna give you up");
        System.out.println(logLine15.getOutputForShortLog());

    }
}


public class LogLine {

    EnumMap<LogLevel, String> logLevelMap = new EnumMap<LogLevel, String>(LogLevel.class);

    String abreviatura;
    String mensajeLog;

    public LogLine(String logLine) {
        int ultimoCorchete = logLine.indexOf("]");
        int indiceDosPuntos = logLine.indexOf(":");

        this.abreviatura = logLine.substring(1, ultimoCorchete);
        this.mensajeLog = logLine.substring(indiceDosPuntos + 2);

        logLevelMap.put(LogLevel.TRACE, LogLevel.TRACE.getLogLineAbreviatura());
        logLevelMap.put(LogLevel.DEBUG, LogLevel.DEBUG.getLogLineAbreviatura());
        logLevelMap.put(LogLevel.INFO, LogLevel.INFO.getLogLineAbreviatura());
        logLevelMap.put(LogLevel.WARNING, LogLevel.WARNING.getLogLineAbreviatura());
        logLevelMap.put(LogLevel.ERROR, LogLevel.ERROR.getLogLineAbreviatura());
        logLevelMap.put(LogLevel.FATAL, LogLevel.FATAL.getLogLineAbreviatura());
    }
    public String getAbreviatura() {
        return abreviatura;
    }

    public LogLevel getLogLevel() {
        boolean existeLogLevel = logLevelMap.containsValue(this.abreviatura);
        LogLevel imprimirTipoLogLevel;
        if (existeLogLevel) {
            imprimirTipoLogLevel = logLevelMap.entrySet().stream()
                    .filter(e -> Objects.equals(e.getValue(), this.abreviatura))
                    .map(Map.Entry::getKey)
                    .findFirst()
                    .orElse(null);


        }else{
            imprimirTipoLogLevel = LogLevel.UNKNOWN;
        }

        //System.out.println("Log Level: " + imprimirTipoLogLevel);
        return imprimirTipoLogLevel;
    }

    public String getOutputForShortLog() {
        LogLevel tipoLogLevel = this.getLogLevel();
        int nivelLogLevel = tipoLogLevel.nivelLogLevel();

        return String.format("%d:%s", nivelLogLevel, this.mensajeLog);
    }
}
