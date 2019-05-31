package domain.model;

// Concrete strategy subclass
public class CaesarCipherStrategy implements CipherStrategy {

    private CipherContext context;

    public CaesarCipherStrategy() {
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
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < content.length(); i++) {
            char currentChar = content.charAt(i);
            if (!Character.isLetter(currentChar) && Character.isSpaceChar(currentChar))
                builder.append(currentChar);
            else if (Character.isLetter(currentChar)) {
                char ch = (char) (((int) currentChar + (29) - 97) % 26 + 97);
                builder.append(ch);
            }
        }
        getContext().setText(builder.toString());
    }

    @Override
    public void encode() {
        String content = getContext().getText().toLowerCase();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < content.length(); i++) {
            char currentChar = content.charAt(i);
            if (!Character.isLetter(currentChar) && Character.isSpaceChar(currentChar))
                builder.append(currentChar);
            else if (Character.isLetter(currentChar)) {
                char ch = (char) (((int) currentChar + (-3) - 97) % 26 + 97);
                builder.append(ch);
            }
            getContext().setText(builder.toString());
        }
    }
}
