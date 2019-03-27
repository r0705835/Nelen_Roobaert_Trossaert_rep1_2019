package domain.model.state;

import domain.model.ItemState;
import domain.model.PartyItem;

public class Available implements ItemState {

    private PartyItem item;

    public Available(PartyItem item) {
        this.item = item;
    }

    @Override
    public void remove() {
        item.setState(item.getRemoved());
    }

    @Override
    public void rent() {
        item.setState(item.getRented());
    }

    @Override
    public void giveBack(boolean damaged) {
        throw new IllegalStateException("You can't give back a party item that's not being rented");
    }

    @Override
    public void repair() {
        throw new IllegalStateException("You can't repair a party item that's currently available to rent");
    }


    @Override
    public String toString() {
        return "AVAILABLE";
    }
}