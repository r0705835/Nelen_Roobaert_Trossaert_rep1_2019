package domain.db;

import domain.model.PartyItem;
import domain.model.state.Available;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartyItemDb {
    private Map<String, PartyItem> items = new HashMap<>();

    public PartyItemDb() {
        PartyItem hat = new PartyItem("hat", 7);
        add(hat);
        PartyItem nose = new PartyItem("nose", 2);
        add(nose);
        PartyItem confetti = new PartyItem("confetti", 1.5);
        add(confetti);
        PartyItem jukebox = new PartyItem("jukebox", 50);
        add(jukebox);
    }

    public PartyItem get(String name) {
        if (name == null || name.isEmpty()) {
            throw new DbException("No name given");
        }
        return items.get(name);
    }

    public List<PartyItem> getAll() {
        return new ArrayList<>(items.values());
    }

    // TODO implement this in the DB class or in the ShowController? or ShowView?
    public List<PartyItem> getAllAvailable() {
        return items.values().stream().filter(item -> item.getState() instanceof Available).collect(Collectors.toList());
    }

    public void add(PartyItem item) {
        if (item == null) {
            throw new DbException("No party item given");
        }
        if (items.containsKey(item.getName())) {
            throw new DbException("Party item already exists");
        }
        try {
            items.put(item.getName(), item);
        } catch (Exception e) {
            throw new DbException(e);
        }
    }

    public void remove(String name) {
        if (name == null || name.isEmpty()) {
            throw new DbException("No name given");
        }
        try {
            // TODO does this logic belong in this class?
            PartyItem item = get(name);
            item.remove();
            // items.remove(name);

        } catch (Exception e) {
            throw new DbException(e);
        }
    }
}