package com.ll;

import java.util.List;
import java.util.Optional;
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

        WiseSaying wiseSaying = service.add(content, author);
        System.out.println(wiseSaying.getId() + "번 명언이 등록되었습니다.");
    }

    public void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        List<WiseSaying> wiseList = service.findAll();

        for (WiseSaying wiseSaying : wiseList.reversed()) {
            System.out.println(wiseSaying.getId() + " / " + wiseSaying.getAuthor() + " / " + wiseSaying.getContent());

        }
    }

    public void actionDelete(String command) {
        int id = 0;
        id = returnId(command);

        boolean isDeleted = service.deleteById(id);
        if (id == 0) {
            System.out.println("새로운 명령어를 입력해주세요.");
        } else if (!isDeleted){
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
        } else {
            System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
        }
    }

    public void actionModify(String command) {
        int id = 0;
        id = returnId(command);

        Optional<WiseSaying> opWiseSaying = service.findById(id);

        if (id == 0) {
            System.out.println("새로운 명령어를 입력해주세요.");
            return;
        } else if (opWiseSaying.isEmpty()) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            return;
        }

        WiseSaying foundWiseSaying = opWiseSaying.get();

        System.out.println("명언(기존) : " + foundWiseSaying.getContent());
        System.out.print("명언 : ");
        String content = sc.nextLine().trim();

        System.out.println("작가(기존) : " + foundWiseSaying.getAuthor());
        System.out.print("작가 : ");
        String author = sc.nextLine().trim();

        service.modify(foundWiseSaying, content, author);

        System.out.printf("%d번 명언이 수정되었습니다.\n", id);

    }

    public int returnId(String command) {
        int id = 0;
        try {
            if (command.length() > 6) {
                String idStr = command.substring(6);
                id = Integer.parseInt(idStr);
                return id;
            } else {
                System.out.println("명령어를 잘못 입력하셨습니다.");
            }
        } catch (NumberFormatException e) {
            System.out.println("명령어를 잘못 입력하셨습니다.");
        }
        return id;
    }
}

