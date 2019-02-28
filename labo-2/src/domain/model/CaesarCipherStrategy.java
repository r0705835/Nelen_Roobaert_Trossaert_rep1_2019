package domain.model;

// Concrete strategy subclass
public class CaesarCipherStrategy implements CipherStrategy {

    @Override
    public void decode(CipherContext cipherContext) {
        String content = cipherContext.getText();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < content.length(); i++) {
            char currentChar = content.charAt(i);
            if (!Character.isLetter(currentChar))
                builder.append(currentChar);
            else {
                char ch = (char) (((int) currentChar + (29) - 97) % 26 + 97);
                builder.append(ch);
            }
        }
        cipherContext.setText(builder.toString());
    }

    @Override
    public void encode(CipherContext cipherContext) {
        String content = cipherContext.getText().toLowerCase();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < content.length(); i++) {
            char currentChar = content.charAt(i);
            if (!Character.isLetter(currentChar))
                builder.append(currentChar);
            else {
                char ch = (char) (((int) currentChar + (-3) - 97) % 26 + 97);
                builder.append(ch);
            }
            cipherContext.setText(builder.toString());
        }
    }
}