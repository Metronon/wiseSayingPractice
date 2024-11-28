package com.ll;

import java.util.ArrayList;
import java.util.List;

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
}
