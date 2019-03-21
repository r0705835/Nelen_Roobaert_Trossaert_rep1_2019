package domain.model;

public interface ItemState {

    void remove();
    void rent();
    void giveBackNormal();
    void giveBackDamaged();
    void repair();
}