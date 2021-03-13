package com.jd.lab6.commands;

import com.jd.lab6.data.SpaceMarine;

import java.util.TreeSet;

/**
 * @author Пименов Данила P3130
 * * Команда добавления элемента в коллекцию.
 * В зависиомсти от сценария прнимает JSON-объект или предлагает пользовательский ввод.
 */
public class AddCommand extends Command {
    public AddCommand(String[] args, TreeSet<SpaceMarine> trg, Cmd cmd) {
        super(args, trg, cmd);
    }


    @Override
    public void execute() {
        if (curCMD.getIsInteractive()) {
            target.add(Generators.marineGenerate());
            System.out.println("Элемент успешно добавлен");
        } else {
            SpaceMarine newMarine = Generators.marineJSONGenerate(arguments.get(1));
            if (newMarine != null) {
                target.add(newMarine);
                System.out.println("Элемент успешно добавлен");
            } else
                System.out.println("Элемент добавить не удалось");
        }
    }
}
