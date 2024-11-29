package com.ll;

import java.util.Scanner;

public class App {
    private final Scanner sc;
    private final Controller controller;
    private final SysController sysController;

    public App(Scanner sc) {
        this.sc = sc;
        this.controller = new Controller(sc);
        this.sysController = new SysController();
    }

    public void run() {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String command = sc.nextLine().trim();
            String order = command.substring(0, 2);

            switch (order) {
                case("종료"):
                    sysController.actionExit();
                    return;
                case("등록"):
                    controller.actionAdd();
                    break;
                case("목록"):
                    controller.actionList();
                    break;
                case("삭제"):
                    controller.actionDelete(command);
                    break;
                case("수정"):
                    controller.actionModify(command);
                    break;
            }

        }
    }
}
