package domain.model;

import domain.model.state.Damaged;
import domain.model.state.Removed;
import domain.model.state.Available;
import domain.model.state.Rented;

public class PartyItem {

    private String name;
    private double value;
    private double rentCost;
    private double repairCost;

    private ItemState available;
    private ItemState rented;
    private ItemState damaged;
    private ItemState removed;
    private ItemState state = available;

    public PartyItem(String name, double value) {
        setName(name);
        setValue(value);
        setAvailable(new Available(this));
        setRented(new Rented(this));
        setDamaged(new Damaged(this));
        setRemoved(new Removed(this));
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return this.value;
    }

    private void setValue(double value) {
        this.value = value;
        setRentCost(value);
        setRepairCost(value);
    }

    public double getRentCost() {
        return rentCost;
    }

    private void setRentCost(double value) {
        double RENT_RATE = 0.2;
        this.rentCost = value * RENT_RATE;
    }

    public double getRepairCost() {
        return repairCost;
    }

    private void setRepairCost(double value) {
        double REPAIR_RATE = 1.0 / 3.0;
        this.repairCost = value * REPAIR_RATE;
    }

    public void remove() {
        state.remove();
    }

    public void rent() {
        state.rent();
    }

    public void giveBack(boolean damaged) {
        state.giveBack(damaged);
    }

    public void repair() {
        state.repair();
    }

    public ItemState getState() {
        return state;
    }

    public void setState(ItemState state) {
        this.state = state;
    }

    public ItemState getAvailable() {
        return available;
    }

    private void setAvailable(ItemState state) {
        this.available = state;
    }

    public ItemState getRented() {
        return rented;
    }

    private void setRented(ItemState state) {
        this.rented = state;
    }

    public ItemState getDamaged() {
        return damaged;
    }

    private void setDamaged(ItemState state) {
        this.damaged = state;
    }

    public ItemState getRemoved() {
        return removed;
    }

    private void setRemoved(ItemState state) {
        this.removed = state;
    }

    @Override
    public String toString() {
        return "Party item: " + this.getName().toUpperCase() + " - Price: €" + this.getValue();
    }
}