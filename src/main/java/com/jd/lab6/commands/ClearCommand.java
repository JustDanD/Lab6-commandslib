package com.jd.lab6.commands;

import com.jd.lab6.data.SpaceMarine;

import java.io.Serializable;
import java.util.TreeSet;

/**
 * @author Пименов Данила
 * Команда, очищающая коллекцию. Собсвтенно всё.
 */
public class ClearCommand extends  Command implements Serializable {
    private static final long serialVersionUID = 4L;
    public ClearCommand(String[] args, TreeSet<SpaceMarine> trg) {
        super(args, trg);
    }

    @Override
    public void execute() {
        target.clear();
        System.out.println("Коллекция успешно очищена");
    }
}