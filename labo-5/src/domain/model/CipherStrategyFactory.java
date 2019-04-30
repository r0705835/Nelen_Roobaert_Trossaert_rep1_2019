package domain.model;

public class CipherStrategyFactory {

    public static CipherStrategy createCipherStrategy(String description, CipherContext cipherContext) {
        CipherStrategyEnum cipherStrategyEnum = CipherStrategyEnum.valueOf(description.toUpperCase());
        String className = cipherStrategyEnum.getClassName();
        CipherStrategy cipherStrategy = null;
        try {
            Class cipherClass = Class.forName(className);
            Object cipherObject = cipherClass.newInstance();
            cipherStrategy = (CipherStrategy) cipherObject;
            cipherStrategy.setContext(cipherContext);
        } catch (Exception ignored) {}
        return cipherStrategy;
    }
}
