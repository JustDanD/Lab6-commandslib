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

    public GroupCommand(String[] args, TreeSet<SpaceMarine> trg, boolean isInteractive) {
        super(args, trg, isInteractive);
    }

    @Override
    public String execute() {
        int[] groups = new int[4];
        StringBuilder ret = new StringBuilder();
        for (SpaceMarine marine : target)
            groups[(int) (marine.getHeartCount())]++;
        for (int i = 1; i <= 3; i++)
            ret.append("").append(i).append("-").append(groups[i]);
        return ret.toString();
    }
    @Override
    public String toString() {
        return "group_counting_by_heart_count";
    }
}