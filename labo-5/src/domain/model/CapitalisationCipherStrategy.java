package domain.model;

/**
 * Puts lower case letters in upper case and vice versa.
 */
public class CapitalisationCipherStrategy implements CipherStrategy {

    private CipherContext context;

    public CapitalisationCipherStrategy(CipherContext context) {
        setContext(context);
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
            if (Character.isLetter(currentChar))
                if(Character.isUpperCase(currentChar))
                    builder.append(Character.toLowerCase(currentChar));
                else
                    builder.append(Character.toUpperCase(currentChar));
            else
                builder.append(currentChar);
        }
        getContext().setText(builder.toString());
    }

    @Override
    public void encode() {
        decode();
    }
}