package org.demo.birds.store;

import org.demo.birds.entities.Bird;

import java.util.*;

/**
 * Отнаследоваться от AbstractBirdStore.
 * <p>
 * Реализовать паттерн Singleton.
 */
public class BirdStore extends AbstractBirdStore {

    private static BirdStore instance;
    private Map<String, Bird> mapStorage = new HashMap<>();

    private BirdStore() {
    }

    public static BirdStore getInstance() {
        return instance == null ? new BirdStore() : instance;
    }

    @Override
    public void addBird(Bird b) {

        if (mapStorage.containsKey(b.getName())) {
            System.out.println("Bird with name " + b.getName() + " already exists!");
        } else {
            mapStorage.put(b.getName(), b);
        }
    }

    @Override
    public Bird searchByName(String nameToSearch) {

        if (mapStorage.containsKey(nameToSearch)) {
            return mapStorage.get(nameToSearch);
        }
        return null;
    }

    @Override
    public List searchByLivingArea(String livingAreaToFind) {

        List<Bird> listBirds = new ArrayList<>();
        for (Map.Entry<String, Bird> entry : mapStorage.entrySet()) {
            if (entry.getValue().getLivingArea().equals(livingAreaToFind)) {
                listBirds.add(entry.getValue());
            }
        }
        return listBirds;
    }
}
