package models;

public enum Symbol {
    CROSS{
        @Override
        public String getSymbolString() {
            return "X";
        }
    },
    CIRCLE {
        @Override
        public String getSymbolString() {
            return "O";
        }
    };

    public abstract String getSymbolString();

    public static Symbol getSymbol(String symbol) throws Exception {
        return switch (symbol) {
            case "X" -> Symbol.CROSS;
            case "O" -> Symbol.CIRCLE;
            default -> throw new Exception("Invalid Game Symbol - " + symbol + " Valid ones are X and O");
        };
    }
}
