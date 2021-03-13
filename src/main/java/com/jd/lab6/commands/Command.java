package com.jd.lab6.commands;

import com.jd.lab6.data.SpaceMarine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author Пименов Данила P3130
 * Абстрактный класс команды. Является родительским для всех классов команд.
 * Поля:
 * arguments - содержит аргументы команды в их строковом представлении
 * target - коллекция, с которой взаимодействует команда
 * curCMD - объект окружения, вызвавшего команду
 */
public abstract class Command {
    ArrayList<String> arguments;
    TreeSet<SpaceMarine> target;
    Cmd curCMD;

    public Command(String[] args, TreeSet<SpaceMarine> trg, Cmd cmd) {
        if (args != null) {
            arguments = new ArrayList<>();
            arguments.addAll(Arrays.asList(args));
        }
        if (trg != null)
            target = trg;
        curCMD = cmd;
    }

    /**
     * Метод, исполяющий команду
     */
    public abstract void execute();

}
