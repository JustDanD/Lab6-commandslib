package com.jd.lab6.commands;

import com.jd.lab6.data.SpaceMarine;

import java.util.TreeSet;

/**
 * @author Пименов Данила
 * Команда, очищающая коллекцию. Собсвтенно всё.
 */
public class ClearCommand extends  Command {
    public ClearCommand(String[] args, TreeSet<SpaceMarine> trg, Cmd cmd) {
        super(args, trg, cmd);
    }

    @Override
    public void execute() {
        target.clear();
        System.out.println("Коллекция успешно очищена");
    }
}