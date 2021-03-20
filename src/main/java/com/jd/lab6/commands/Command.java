package com.jd.lab6.commands;

import com.jd.lab6.data.SpaceMarine;

import java.io.Serializable;
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
    protected ArrayList<String> arguments;
    protected TreeSet<SpaceMarine> target;
    protected boolean valid;

    public Command(String[] args, TreeSet<SpaceMarine> trg) {
        if (args != null) {
            arguments = new ArrayList<>();
            arguments.addAll(Arrays.asList(args));
        }
        if (trg != null)
            target = trg;
        valid = true;
    }

    public boolean getValid() {
        return valid;
    }
    /**
     * Метод, исполяющий команду
     */
    public abstract void execute();

}
