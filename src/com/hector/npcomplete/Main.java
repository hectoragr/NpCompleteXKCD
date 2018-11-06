package com.hector.npcomplete;

public class Main {
    private static final int[] menu = { 580, 420, 355, 335, 275, 215 };
    private static int tries = 0;

    public static void main(String[] args) {
        int total = 1505;
        calculate(total, "", 0);
        System.out.println(String.format("Tries: %s", tries));
    }

    private static void calculate(final int total, final String result, final int index){
        if (index >= menu.length) {
            tries++;
            if (total == 0) {
                System.out.println(result);
            }
            return;
        }

        int qty = total/menu[index];
        do {
            calculate(total - qty * menu[index], String.format("%s $%02f - %s", result, (menu[index]/100.0), qty), index + 1);
        } while(index < menu.length - 1 && --qty >= 0);
    }
}
