package com.ll;

import java.util.List;

public class Service {
    Repository repository = new Repository();
    public WiseSaying add(String content, String author) {
        WiseSaying wiseSaying = new WiseSaying(0, content, author);
        Repository.save(wiseSaying);
        return wiseSaying;
    }

    public List<WiseSaying> findAll() {
        return repository.findAll();
    }
}
