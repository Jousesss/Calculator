public enum Season {
    SPRING("10-15"), AUTUMN("0-10"), SUMMER("17-35"), WINTER("-32-2");

    private String temps;

    Season (String temps) {
        this.temps = temps;
    }

    public String getTemps() {
        return temps;
    }
}
