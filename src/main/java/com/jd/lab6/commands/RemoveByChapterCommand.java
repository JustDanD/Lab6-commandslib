package com.jd.lab6.commands;

import com.jd.lab6.data.Chapter;
import com.jd.lab6.data.SpaceMarine;

import java.util.TreeSet;

/**
 * @author Пименов Данила P3130
 * Команда удаления элемента коллекция с таким chapter
 */
public class RemoveByChapterCommand extends  Command {
    public RemoveByChapterCommand(String[] args, TreeSet<SpaceMarine> trg, Cmd cmd) {
        super(args, trg, cmd);
    }


    @Override
    public void execute() {
        Chapter chapter;
        if(curCMD.getIsInteractive())
         chapter = Generators.chapterGenerate();
        else
            chapter = Generators.chapterJSONGenerate(arguments.get(1));
        if (chapter == null) {
            System.out.println("Битый входной элемент");
            return;
        }
        for (SpaceMarine marine : target) {
            if (marine.getChapter().equals(chapter)) {
                target.remove(marine);
                System.out.println("Элемент успешно удалён");
                return;
            }
        }
        System.out.println("Не существует элемента с таким значением chapter");
    }
}