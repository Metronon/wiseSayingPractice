package com.ll;

import java.util.List;
import java.util.Optional;

public class Service {
    Repository repository = new Repository();
    public WiseSaying add(String content, String author) {
        WiseSaying wiseSaying = new WiseSaying(0, content, author);
        repository.save(wiseSaying);
        return wiseSaying;
    }

    public List<WiseSaying> findAll() {
        return repository.findAll();
    }

    public boolean deleteById(int id) {
        return repository.deleteById(id);
    }

    public Optional<WiseSaying> findById(int id) {
        return repository.findById(id);
    }

    public void modify(WiseSaying wiseSaying, String content, String author) {
        wiseSaying.setContent(content);
        wiseSaying.setAuthor(author);

        repository.modify(wiseSaying);
    }
}

