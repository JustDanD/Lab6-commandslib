package com.jd.lab6.commands;

import com.jd.lab6.data.SpaceMarine;

import java.io.Serializable;
import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * @author Пименов Данила P3130
 * Команда, выводящая коллекцию в порядке убывания
 */
public class PrintDescendingCommand extends  Command implements Serializable {
    private static final long serialVersionUID = 9L;
    public PrintDescendingCommand(String[] args, TreeSet<SpaceMarine> trg) {
        super(args, trg);
    }

    @Override
    public void execute() {
        NavigableSet<SpaceMarine> descended = target.descendingSet();
        for (SpaceMarine marine : descended)
            System.out.print(marine.toString());
    }
}