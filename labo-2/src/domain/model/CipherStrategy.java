package domain.model;

// Strategy interface
public interface CipherStrategy {

    CipherContext getContext();

    void setContext(CipherContext context);

    // Algorithm method
    void decode();

    // Algorith method
    void encode();
}