package domain.model;

public enum CipherStrategyEnum {

    CAESARCIJFER("Caesarcijfer", "domain.model.CaesarCipherStrategy"),
    CAPITALISATIE("Capitalisatie", "domain.model.CapitalisationCipherStrategy"),
    SPIEGELING("Spiegeling", "domain.model.MirrorCipherStrategy"),
    WILLEKEURIG("Willekeurig", "domain.model.RandomCipherStrategy");

    private final String description;
    private final String className;

    CipherStrategyEnum(String description, String className) {
        this.description = description;
        this.className = className;
    }

    public String getDescription() {
        return this.description;
    }

    public String getClassName() {
        return this.className;
    }
}
