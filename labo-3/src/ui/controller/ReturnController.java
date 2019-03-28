package ui.controller;

import domain.model.PartyItem;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.view.ReturnView;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class ReturnController {

    private ReturnView view;
    private Stage primaryStage;
    private MainController mainController;

    ReturnController() {
        this.view = new ReturnView();
    }

    void launch(MainController controller) {
        this.mainController = controller;
        this.primaryStage = mainController.getPrimaryStage();
        view.setCancelListener(() -> mainController.launch(primaryStage));
        view.setConfirmListener(this::handleInput);
        showAllPartyItems();
        Scene addScene = new Scene(view.getRootView(), 500, 600);
        primaryStage.setScene(addScene);
        primaryStage.show();
    }

    private void handleInput(String number, String damaged) {
        List<PartyItem> partyItems = getPartyItemsSorted();
        try {
            PartyItem item = partyItems.get(Integer.parseInt(number) - 1);
            if (damaged != null && damaged.toLowerCase().equals("yes")){
                item.giveBack(true);
                // TODO does this minus one logic belong here?
                double repairCost = Math.round(item.getRepairCost() * 100.0) / 100.0;
                view.repaintPartyItems(partyItems, repairCost);
            } else if (damaged != null && damaged.toLowerCase().equals("no")) {
                item.giveBack(false);
                view.repaintPartyItems(partyItems, 0);
            } else {
                view.setChoiceTextField("Indicate whether the returning item is damaged or not.");
            }
        } catch (NumberFormatException e) {
            view.clearTextField();
        } catch (IllegalStateException e) {
            view.setChoiceTextField("Can't return item not being rented.");
        }
    }

    private void showAllPartyItems() {
        List<PartyItem> partyItems = getPartyItemsSorted();
        view.setPartyItems(partyItems);
    }

    private List<PartyItem> getPartyItemsSorted() {
        List<PartyItem> partyItems = mainController.getPartyItemDb().getAll();
        return partyItems.stream().sorted(Comparator.comparing(PartyItem::getName)).collect(Collectors.toList());
    }
}
