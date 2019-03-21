package domain.model.state;

import domain.model.ItemState;
import domain.model.PartyItem;

public class Removed implements ItemState {

    private PartyItem item;

    public Removed(PartyItem item) {
        this.item = item;
    }

    @Override
    public void remove() {
        throw new IllegalStateException("You can't do anything with a removed party item");
    }

    @Override
    public void rent() {
        throw new IllegalStateException("You can't do anything with a removed party item");
    }

    @Override
    public void giveBackNormal() {
        throw new IllegalStateException("You can't do anything with a removed party item");
    }

    @Override
    public void giveBackDamaged() {
        throw new IllegalStateException("You can't do anything with a removed party item");
    }

    @Override
    public void repair() {
        throw new IllegalStateException("You can't do anything with a removed party item");
    }
}