package com.jd.lab6.commands;

import com.jd.lab6.data.SpaceMarine;

import java.util.TreeSet;

/**
 * @author Пименов Данила P3130
 * Команда, выводящая на экран коллекцию.
 */
public class ShowCommand extends  Command {
    public ShowCommand(String[] args, TreeSet<SpaceMarine> trg, Cmd cmd) {
        super(args, trg, cmd);
    }

    @Override
    public void execute() {
        if (target.size() == 0)
            System.out.println("Пустая коллекция");
        for (SpaceMarine marine : super.target)
            System.out.print(marine.toString());
    }
}