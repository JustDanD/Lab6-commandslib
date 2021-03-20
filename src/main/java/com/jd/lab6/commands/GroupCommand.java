package com.jd.lab6.commands;

import com.jd.lab6.data.SpaceMarine;

import java.io.Serializable;
import java.util.TreeSet;

/**
 * @author Пименов Данила P3130
 * Команда группировки по значению heartCount
 */
public class GroupCommand extends  Command implements Serializable {
    private static final long serialVersionUID = 5L;

    public GroupCommand(String[] args, TreeSet<SpaceMarine> trg) {
        super(args, trg);
    }

    @Override
    public void execute() {
        int[] groups = new int[4];

        for (SpaceMarine marine : target)
            groups[(int) (marine.getHeartCount())]++;
        for (int i = 1; i <= 3; i++)
            System.out.println((i) + "-" + groups[i]);
    }
}