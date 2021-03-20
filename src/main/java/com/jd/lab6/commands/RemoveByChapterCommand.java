package com.jd.lab6.commands;

import com.jd.lab6.data.Chapter;
import com.jd.lab6.data.SpaceMarine;

import java.io.Serializable;
import java.util.TreeSet;

/**
 * @author Пименов Данила P3130
 * Команда удаления элемента коллекция с таким chapter
 */
public class RemoveByChapterCommand extends  Command implements Serializable {
    private static final long serialVersionUID = 10L;
    private Chapter chapterToRemove;
    public RemoveByChapterCommand(String[] args, TreeSet<SpaceMarine> trg) {
        super(args, trg);
        chapterToRemove = Generators.chapterGenerate();
    }

    @Override
    public void execute() {

        if (chapterToRemove == null) {
            System.out.println("Битый входной элемент");
            return;
        }
        for (SpaceMarine marine : target) {
            if (marine.getChapter().equals(chapterToRemove)) {
                target.remove(marine);
                System.out.println("Элемент успешно удалён");
                return;
            }
        }
        System.out.println("Не существует элемента с таким значением chapter");
    }
}