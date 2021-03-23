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
    protected ArrayList<String> arguments;
    protected TreeSet<SpaceMarine> target;
    protected boolean valid;
    protected boolean isInteractive;

    public Command() {

    }

    public Command(String[] args, TreeSet<SpaceMarine> trg, boolean isInteractive) {
        if (args != null) {
            arguments = new ArrayList<>();
            arguments.addAll(Arrays.asList(args));
        }
        if (trg != null)
            target = trg;
        valid = true;
        this.isInteractive = isInteractive;
    }

    public boolean getValid() {
        return valid;
    }

    public void setTarget(TreeSet<SpaceMarine> target) {
        this.target = target;
    }

    /**
     * Метод, исполяющий команду
     */
    public abstract String execute();

}
