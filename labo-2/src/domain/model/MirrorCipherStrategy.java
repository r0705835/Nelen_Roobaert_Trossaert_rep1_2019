package domain.model;

// Concrete strategy subclass
public class MirrorCipherStrategy implements CipherStrategy {

    @Override
    public void decode(CipherContext cipherContext) {
        String content = cipherContext.getText();
        String decodedContent = new StringBuilder(content).reverse().toString();
        cipherContext.setText(decodedContent);
    }

    @Override
    public void encode(CipherContext cipherContext) {
        decode(cipherContext);
    }
}