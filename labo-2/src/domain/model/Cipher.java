package domain.model;

// Strategy interface
public interface Cipher {

    // Algorithm method
    void decode(Text text);

    // Algorith method
    void encode(Text text);
}