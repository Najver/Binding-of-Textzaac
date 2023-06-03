package util;

public enum ConsoleColors {
    RESET("\033[0m"),
    GREEN("\033[0;32m");
    public final String colorCode;

    ConsoleColors(String colorCode) {
        this.colorCode = colorCode;
    }


}
