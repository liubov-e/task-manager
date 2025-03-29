package ru.spbu.liubove.gui.model;

import ru.spbu.liubove.domain.model.OpenQuestionCard;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class QuestionTableModel extends AbstractTableModel {
    private final String[] columnNames = new String[]{"id", "Вопрос", "Ожидаемыый ответ"};
    private final List<OpenQuestionCard> tasks;

    public QuestionTableModel(List<OpenQuestionCard> tasks) {
        this.tasks = tasks;
    }

    @Override
    public int getRowCount() {
        return tasks.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return tasks.get(rowIndex).getId();
        } else if (columnIndex == 1){
            return tasks.get(rowIndex).getQuestion();
        } else {
            return tasks.get(rowIndex).getExpectedAnswer();
        }
    }
}
