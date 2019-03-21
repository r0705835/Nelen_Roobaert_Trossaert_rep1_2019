package domain.model;

public interface ItemState {

    void remove();
    void rent();
    void giveBack(boolean damaged);
    void repair();
}