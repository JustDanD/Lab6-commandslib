package com.jd.lab6.data;
/**
 * @author Пименов Данила, P3130
 * Перечисление, описывающее доступные варианты оружия
 * POWER_SWORD, CHAIN_AXE, POWER_BLADE, POWER_FIST;
 * Содержит парсер строки в оружие
 */
public enum MeleeWeapon {
    POWER_SWORD,
    CHAIN_AXE,
    POWER_BLADE,
    POWER_FIST;

    public static MeleeWeapon parseMeleeWeapon(String input) {
        switch (input) {
            default:
                return null;
            case "POWER_SWORD":
                return POWER_SWORD;
            case "CHAIN_AXE":
                return CHAIN_AXE;
            case "POWER_BLADE":
                return POWER_BLADE;
            case "POWER_FIST":
                return POWER_FIST;
        }
    }
}
