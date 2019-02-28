package domain.model;

// Strategy interface
public interface CipherStrategy {

    // Algorithm method
    void decode(CipherContext cipherContext);

    // Algorith method
    void encode(CipherContext cipherContext);
}