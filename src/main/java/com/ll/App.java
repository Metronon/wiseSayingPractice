package com.ll;

import java.util.Scanner;

public class App {
    Scanner sc = new Scanner(System.in);
    Controller controll = new Controller(sc);
    SysController sysControll = new SysController();

    public void run() {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String command = sc.nextLine().trim();
            String order = command.substring(0, 2);

            switch (order) {
                case("종료"):
                    sysControll.actionExit();
                    return;
                case("등록"):
                    controll.actionAdd();
                    break;
                case("목록"):
                    controll.actionList();
                    break;
                case("삭제"):
                    controll.actionDelete(command);
                    break;
                case("수정"):
                    controll.actionModify(command);
                    break;
            }

        }
    }
}
