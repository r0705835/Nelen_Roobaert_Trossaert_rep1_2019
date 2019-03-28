package domain.model.state;

import domain.model.ItemState;
import domain.model.PartyItem;

public class Damaged implements ItemState {

    private PartyItem item;

    public Damaged(PartyItem item) {
        this.item = item;
    }

    @Override
    public void remove() {
        item.setState(item.getRemoved());
    }

    @Override
    public void rent() {
        throw new IllegalStateException("You can't rent a damaged party item");
    }

    @Override
    public void giveBack(boolean damaged) {
        throw new IllegalStateException("You can't return a party item that's already marked as damaged");
    }

    @Override
    public void repair() {
        item.setState(item.getAvailable());
    }


    @Override
    public String toString() {
        return "DAMAGED";
    }
}