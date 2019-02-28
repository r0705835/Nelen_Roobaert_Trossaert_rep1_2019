package domain.model;

// Concrete strategy subclass
public class MirrorCipher implements Cipher {

    @Override
    public void decode(Text text) {
        String content = text.getContent();
        String decodedContent = new StringBuilder(content).reverse().toString();
        text.setContent(decodedContent);
    }

    @Override
    public void encode(Text text) {
        decode(text);
    }
}