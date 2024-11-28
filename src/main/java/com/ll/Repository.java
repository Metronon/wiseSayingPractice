package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Repository {
    private List<WiseSaying> wiseList;
    public int id;

    public Repository() {
        this.wiseList = new ArrayList<>();
        this.id = id;
    }

    public WiseSaying save(WiseSaying wiseSaying) {
        wiseSaying.setId(++id);
        wiseList.add(wiseSaying);
        return wiseSaying;
    }

    public List<WiseSaying> findAll() {
        return wiseList;
    }

    public boolean deleteById(int id) {
        return wiseList.removeIf(e -> e.getId() == id);
    }

    public Optional<WiseSaying> findById(int id) {
        return wiseList.stream()
                .filter(e -> e.getId() == id)
                .findFirst();
    }

    public void modify(WiseSaying wiseSaying) {
    }
}
