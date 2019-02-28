package domain.model;

// Concrete strategy subclass
public class CaesarCipher implements Cipher {

    @Override
    public void decode(Text text) {
        String content = text.getContent();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < content.length(); i++) {
            char currentChar = content.charAt(i);
            if (currentChar == ' ')
                builder.append(currentChar);
            else {
                char ch = (char) (((int) currentChar + (29) - 97) % 26 + 97);
                builder.append(ch);
            }
        }
        text.setContent(builder.toString());
    }

    @Override
    public void encode(Text text) {
        String content = text.getContent();
        String flatContent = content.toLowerCase()
                .replaceAll("\\d", "")
                .replaceAll("[-+^!?,.]*", "");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < flatContent.length(); i++) {
            char currentChar = flatContent.charAt(i);
            if (currentChar == ' ')
                builder.append(currentChar);
            else {
                char ch = (char) (((int) currentChar + (-3) - 97) % 26 + 97);
                builder.append(ch);
            }
            text.setContent(builder.toString());
        }
    }
}