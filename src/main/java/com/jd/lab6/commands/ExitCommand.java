package com.jd.lab6.commands;

import com.jd.lab6.data.SpaceMarine;

import java.util.TreeSet;

/**
 * @author Пименов Данила P3130
 * Команда, выполнаяющая выход из программы...Усё. Совсем всё. Уходите.
 */
public class ExitCommand extends Command {
    public ExitCommand(String[] args, TreeSet<SpaceMarine> trg) {
        super(args, trg, true);
    }

    @Override
    public String execute() {
        System.out.println("Спасибо за визит! Хорошо вам провести время!");
        System.exit(0);
        return null;
    }
}
