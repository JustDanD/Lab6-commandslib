package com.jd.lab6.commands;

import com.jd.lab6.data.SpaceMarine;

import java.io.Serializable;
import java.util.TreeSet;

/**
 * @author Пименов Данила P3130
 * Команда, выводящая на экран коллекцию.
 */
public class ShowCommand extends Command implements Serializable {
    private static final long serialVersionUID = 14L;

    public ShowCommand(String[] args, TreeSet<SpaceMarine> trg, boolean isInteractive) {
        super(args, trg, isInteractive);
    }

    @Override
    public String execute() {
        StringBuilder ret = new StringBuilder();
        if (target.size() == 0)
            return "Пустая коллекция";
        for (SpaceMarine marine : super.target)
            ret.append(marine.toString());
        return ret.toString();
    }

    public String toString() {
        return "show";
    }
}