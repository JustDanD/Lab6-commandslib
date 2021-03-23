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
        long[] groups = new long[3];
        StringBuilder ret = new StringBuilder();
        groups[0] = target.stream().filter(x -> x.getHeartCount() == 1).count();
        groups[1] = target.stream().filter(x -> x.getHeartCount() == 2).count();
        groups[2] = target.stream().filter(x -> x.getHeartCount() == 3).count();
        for (int i = 1; i <= 3; i++)
            ret.append(i).append("-").append(groups[i - 1]).append("\n");
        return ret.toString();
    }
    @Override
    public String toString() {
        return "group_counting_by_heart_count";
    }
}