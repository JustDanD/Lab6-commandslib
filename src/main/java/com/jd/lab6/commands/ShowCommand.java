package com.jd.lab6.commands;

import com.jd.lab6.data.SpaceMarine;

import java.io.Serializable;
import java.util.TreeSet;

/**
 * @author Пименов Данила P3130
 * Команда, выводящая на экран коллекцию.
 */
public class ShowCommand extends  Command implements Serializable {
    private static final long serialVersionUID = 14L;

    public ShowCommand(String[] args, TreeSet<SpaceMarine> trg) {
        super(args, trg);
    }

    @Override
    public void execute() {
        if (target.size() == 0)
            System.out.println("Пустая коллекция");
        for (SpaceMarine marine : super.target)
            System.out.print(marine.toString());
    }
}