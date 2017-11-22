package com.kysylytsia.dispatcher;

import com.kysylytsia.controller.Controller;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        /**
         * Запускаємо програму та передаємо управління виконанням.
         */
        Controller controller = new Controller();
        controller.listener();
    }
}
