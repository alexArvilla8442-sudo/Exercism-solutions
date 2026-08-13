public enum LogLevel {
    /**
     *
     */
    // TODO: define members for each log level
    TRACE("TRC"){
        @Override
        public String getCompleteLogLineMessage() {
            return "trace";
        }
        @Override
        public int nivelLogLevel(){
            return 1;
        }
    },
    DEBUG("DBG"){
        @Override
        public String getCompleteLogLineMessage() {
            return "debug";
        }
        @Override
        public int nivelLogLevel(){
            return 2;
        }
    },
    INFO("INF"){
        @Override
        public String getCompleteLogLineMessage() {
            return "info";
        }
        @Override
        public int nivelLogLevel(){
            return 4;
        }
    },
    WARNING("WRN"){
        @Override
        public String getCompleteLogLineMessage() {
            return "warning";
        }
        @Override
        public int nivelLogLevel(){
            return 5;
        }
    },
    ERROR("ERR"){
        @Override
        public String getCompleteLogLineMessage() {
            return "error";
        }
        @Override
        public int nivelLogLevel(){
            return 6;
        }
    },
    FATAL("FTL"){
        @Override
        public String getCompleteLogLineMessage() {
            return "fatal";
        }
        @Override
        public int nivelLogLevel(){
            return 42;
        }
    },
    UNKNOWN("UNK"){
        @Override
        public String getCompleteLogLineMessage() {
            return "NO EXISTE";
        }
        @Override
        public int nivelLogLevel(){
            return 0;
        }
    };

    private final String logLineAbreviatura;

    LogLevel(String abreviatura) {
        this.logLineAbreviatura = abreviatura;
    }

    public String getLogLineAbreviatura() {
        return logLineAbreviatura;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public abstract String getCompleteLogLineMessage();
    public abstract int nivelLogLevel();
}
