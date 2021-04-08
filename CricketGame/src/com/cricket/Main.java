package com.cricket;

import com.cricket.controller.GameController;
import com.cricket.controller.implementation.FiveOverGameController;

public class Main {

    public static void main(String[] args) {

        GameController controller=new FiveOverGameController();
        controller.playGame();
    }
}
