package org.demo.birds.store;

import org.demo.birds.entities.Bird;

import java.util.*;

/**
 * Отнаследоваться от AbstractBirdStore.
 * <p>
 * Реализовать паттерн Singleton.
 */
public class BirdStore extends AbstractBirdStore {

    private static BirdStore birdStore;
    private Map<String, Bird> mapStorage = new HashMap<>();

    private BirdStore() {
        birdStore = new BirdStore();
    }

    public static BirdStore getBirdStore() {
        return birdStore;
    }

    @Override
    public void addBird(Bird b) {
        if (mapStorage.containsKey(b.getName())) {
            System.out.println("Bird With name " + b.getName() + " already exists!");
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
                listBirds.add((Bird) entry);
            }
        }
        return listBirds;
    }
}
