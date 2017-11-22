package com.kysylytsia.service;

import com.kysylytsia.controller.Logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by SERAFIM on 15.11.2017.
 */
public class ServiceMenu {

    public int welcom() {

        {
            System.out.println("Виберіть дію яку ви хочете виконати:");
            System.out.println("1: Додати нового працівника");
            System.out.println("2: Переглянути данні працівника");
            System.out.println("3: Редагувати існуючого працівника");
            System.out.println("4: Видалити існуючого працівника");
            System.out.println("5: Згенерувати звіт");
            System.out.println();
            return Logic.makeChoice();
        }

    }

    public static boolean delete() {

        System.out.println("Ви дійсно хочете видалити цього працівника?");
        System.out.println("1: так");
        System.out.println("2: ні");

        if (Logic.readInt(2) == 1){
            return true;
        } else {
            return false;
        }
    }

}
