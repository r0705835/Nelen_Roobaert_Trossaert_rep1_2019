package domain.model;

// Concrete strategy subclass
public class MirrorCipherStrategy implements CipherStrategy {

    private CipherContext context;

    public MirrorCipherStrategy() {
    }

    @Override
    public CipherContext getContext() {
        return context;
    }

    @Override
    public void setContext(CipherContext context) {
        this.context = context;
    }

    @Override
    public void decode() {
        String content = getContext().getText();
        String decodedContent = new StringBuilder(content).reverse().toString();
        getContext().setText(decodedContent);
    }

    @Override
    public void encode() {
        decode();
    }
}
