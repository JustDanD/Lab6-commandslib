package com.jd.lab6.commands;

import com.jd.lab6.data.Chapter;
import com.jd.lab6.data.SpaceMarine;

import java.io.Serializable;
import java.util.Optional;
import java.util.TreeSet;

/**
 * @author Пименов Данила P3130
 * Команда удаления элемента коллекция с таким chapter
 */
public class RemoveByChapterCommand extends  Command implements Serializable {
    private static final long serialVersionUID = 10L;
    private Chapter chapterToRemove;
    public RemoveByChapterCommand(String[] args, TreeSet<SpaceMarine> trg, boolean isInteractive) {
        super(args, trg, isInteractive);
        if (isInteractive)
            chapterToRemove = Generators.chapterGenerate();
        else {
            Chapter newChapter = Generators.chapterJSONGenerate(arguments.get(1));
            if (newChapter != null)
                chapterToRemove = newChapter;
            else {
                valid = false;
                chapterToRemove = null;
                System.out.println("Битая глава");
            }
        }
    }

    @Override
    public synchronized String execute() {

        if (chapterToRemove == null) {
            return "Битый входной элемент";
        }
        SpaceMarine marine = target.stream().filter(x->x.getChapter().equals(chapterToRemove)).findFirst().orElse(null);
        if (marine != null) {
            marine.clear();
            target.remove(marine);
            System.out.println("Элемент успешно удалён");
        }
        return "Не существует элемента с таким значением chapter";
    }
    public String toString() {
        return "remove_any_by_chapter";
    }
}