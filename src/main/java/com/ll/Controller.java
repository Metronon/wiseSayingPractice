package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private final Scanner sc;
    private final Service service;

    public Controller(Scanner sc) {
        this.sc = sc;
        this.service = new Service();
    }

    public void actionAdd() {
        System.out.print("명언 : ");
        String content = sc.nextLine().trim();

        System.out.print("작가 : ");
        String author = sc.nextLine().trim();

        WiseSaying wiseSaying = Service.add(content, author);
        System.out.println(wiseSaying.getId() + "번 명언이 등록되었습니다.");
    }

    public void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        List<WiseSaying> wiseList = service.findAll();

        for (WiseSaying wiseSaying : wiseList) {
            System.out.println(wiseSaying.getId() + " / " + wiseSaying.getAuthor() + " / " + wiseSaying.getContent());

        }
    }
}
