package domain.model;


// Context class
public class Text {

    private String content;
    private Cipher cipher;

    public Text(String string) {
        setContent(string);
    }

    public String getContent() {
        return content;
    }

    void setContent(String content) {
        this.content = content;
    }

    private Cipher getCipher() {
        return cipher;
    }

    public void setCipher(Cipher cipher) {
        this.cipher = cipher;
    }

    // Concrete method
    public void decode() {
        getCipher().decode(this);
    }

    // Concrete method
    public void encode() {
        getCipher().encode(this);
    }

    public void display() {
        System.out.println(getContent());
    }
}