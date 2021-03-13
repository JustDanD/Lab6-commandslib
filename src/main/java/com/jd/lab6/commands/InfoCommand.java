package com.jd.lab6.commands;

import com.jd.lab6.data.SpaceMarine;

import java.time.format.DateTimeFormatter;
import java.util.TreeSet;

/**
 * @author Пименов Данила P3130
 * Команда, выводящая информацию о коллекции
 */
public class InfoCommand extends Command {
    public InfoCommand(String[] args, TreeSet<SpaceMarine> trg, Cmd cmd) {
        super(args, trg, cmd);
    }

    @Override
    public void execute() {
        System.out.println("Информация о коллекции:\nДата инициалиазции: " + curCMD.getStartDate().format(DateTimeFormatter.ISO_LOCAL_DATE) + " " + curCMD.getStartDate().format(DateTimeFormatter.ISO_LOCAL_TIME) +
                "\nТип коллекции: " + target.getClass() + "\nТип элементов: SpaceMarine" +
                "\nРазмер коллекции: " + target.size());
    }
}