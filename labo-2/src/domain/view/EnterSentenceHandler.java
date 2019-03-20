package domain.view;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class EnterSentenceHandler implements EventHandler {

    private TextField sentenceTextField;
    private String sentence;

    EnterSentenceHandler(TextField sentenceTextField, String sentence)
    {
        this.sentenceTextField = sentenceTextField;
        this.sentence = sentence;
    }

    @Override
    public void handle(Event event) {
        sentenceTextField.setText(sentence);
    }
}