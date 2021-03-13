package com.jd.lab6.commands;

import com.google.gson.Gson;
import com.jd.lab6.data.Chapter;
import com.jd.lab6.data.Coordinates;
import com.jd.lab6.data.MeleeWeapon;
import com.jd.lab6.data.SpaceMarine;

import java.util.Scanner;

/**
 * @author Пименов Данила P3130
 * Класс, содержащий в себе генераторы объектов из тех или иных входных данных
 */
public class Generators {
    /**
     * Генератор объекта космического корабля из пользовательского ввода.
     *
     * @return SpaceMarine
     */
    public static SpaceMarine marineGenerate() {
        Scanner in = new Scanner(System.in);
        String input;
        String name;
        long x;
        float y;
        double health;
        long heartCount;
        boolean loyal;
        MeleeWeapon meleeWeapon;
        Chapter chapter;
        System.out.println("Введите имя корабля:");
        while (true) {
            if (!(input = in.nextLine()).equals("")) {
                name = input;
                break;
            }
            System.out.println("Введено неправильное имя. Повторите ввод:");
        }
        System.out.println("Введите коодинату x:");
        while (true) {
            try {
                x = Long.parseLong(in.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат координаты. Повторите ввод:");
            }
        }
        System.out.println("Введите коодинату y:");
        while (true) {
            try {
                y = Float.parseFloat(in.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат координаты. Повторите ввод:");
            }
        }
        System.out.println("Введите количество здоровья:");
        while (true) {
            try {
                health = Double.parseDouble(in.nextLine());
                if (health <= 0)
                    System.out.println("Здоровье должно быть больше 0. Повторите ввод:");
                else
                    break;
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат значения здоровья. Повторите ввод:");
            }
        }
        System.out.println("Введите количество жизней:");
        while (true) {
            try {
                heartCount = Long.parseLong(in.nextLine());
                if (heartCount <= 0)
                    System.out.println("Жизней должно быть больше 0. Повторите ввод:");
                else if (heartCount > 3)
                    System.out.println("Жизней должно быть не больше 3.  Повторите ввод:");
                else
                    break;
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат значения жизней. Повторите ввод:");
            }
        }
        System.out.println("Введите знгачение преданности (true/false):");
        while (true) {
            input = in.nextLine();
            if (!input.equals("true") && !input.equals("false"))
                System.out.println("Неверный формат. Повторите ввод:");
            else {
                loyal = Boolean.parseBoolean(input);
                break;
            }
        }
        System.out.println("Введите оружие (POWER_SWORD/CHAIN_AXE/POWER_BLADE/POWER_FIST):");
        while (true) {
            meleeWeapon = MeleeWeapon.parseMeleeWeapon(in.nextLine());
            if (meleeWeapon == null)
                System.out.println("Неверный формат. Повторите ввод:");
            else
                break;
        }
        chapter = chapterGenerate();
        return new SpaceMarine(name, new Coordinates(x, y), health, heartCount, loyal, meleeWeapon, chapter);
    }

    /**
     * Генератор объекта части из пользовательского ввода.
     *
     * @return Chapter
     */
    public static Chapter chapterGenerate() {
        Scanner in = new Scanner(System.in);
        String input;
        String chapterName;
        String parentLegion;
        System.out.println("Введите название части:");
        while (true) {
            if (!(input = in.nextLine()).equals("")) {
                chapterName = input;
                break;
            }
            System.out.println("Введено неправильное имя. Повторите ввод:");
        }
        System.out.println("Введите название головного легиона:");
        if (!(input = in.nextLine()).equals(""))
            parentLegion = input;
        else
            parentLegion = null;
        return new Chapter(chapterName, parentLegion);
    }

    /**
     * Генератор объекта космического корабля из JSON-объекта.
     *
     * @return SpaceMarine
     */
    public static SpaceMarine marineJSONGenerate(String input) {
        Gson gson = new Gson();
        try {
            SpaceMarine marine = gson.fromJson(input, SpaceMarine.class);
            if (marine.getName().equals("")) {
                System.out.println("Broken input element");
                return null;
            }
            if (marine.getHealth() <= 0) {
                System.out.println("Broken input element");
                return null;
            }
            if (marine.getHeartCount() <= 0 || marine.getHeartCount() > 3) {
                System.out.println("Broken input element");
                return null;
            }
            if (marine.getChapter().getName().equals("")) {

                System.out.println("Broken input element");
                return null;
            }
            marine.setId(1L);
            marine.setCreationDateAuto();
            return marine;
        } catch (Exception e) {
            System.out.println("Broken input element");
            return null;
        }

    }

    /**
     * Генератор объекта части из JSON-объекта.
     *
     * @return SpaceMarine
     */
    public static Chapter chapterJSONGenerate(String input) {
        Gson gson = new Gson();
        try {
            Chapter chapter = gson.fromJson(input, Chapter.class);
            if (chapter.getName().equals("")) {
                System.out.println("Broken chapter");
                return null;
            }
            return chapter;
        } catch (Exception e) {
            System.out.println("Broken chapter");
            return null;
        }
    }
}
