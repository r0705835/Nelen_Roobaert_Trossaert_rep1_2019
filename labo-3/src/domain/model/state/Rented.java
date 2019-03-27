package domain.model.state;

import domain.model.ItemState;
import domain.model.PartyItem;

public class Rented implements ItemState {

    private PartyItem item;

    public Rented(PartyItem item) {
        this.item = item;
    }

    @Override
    public void remove() {
        throw new IllegalStateException("You can't remove a party item that's currently being rented");
    }

    @Override
    public void rent() {
        throw new IllegalStateException("You can't rent a party item that's currently being rented");
    }

    @Override
    public void giveBack(boolean damaged) {
        if (damaged)
            item.setState(item.getDamaged());
        else
            item.setState(item.getAvailable());
    }

    @Override
    public void repair() {
        throw new IllegalStateException("You can't repair a party item that's currently being rented");
    }

    @Override
    public String toString() {
        return "RENTED";
    }
}