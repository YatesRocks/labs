package labs.yates.model;

import javax.swing.table.AbstractTableModel;
import java.util.Vector;

/**
 * The backend for any JTables you see in the application
 */
public class TagModel extends AbstractTableModel {
    private final Vector<Tag<String, Integer>> tags = new Vector<>();
    private static final int COLS = 2;

    public TagModel() {

    }

    public void emplaceTag(Tag<String, Integer> tag) {
        if (tag.value() <= 1)
            return;
        tags.addLast(tag);
    }

    public Vector<Tag<String, Integer>> getTags() {
        return tags;
    }

    @Override
    public int getRowCount() {
        return tags.size();
    }

    @Override
    public Class<?> getColumnClass(int col) {
        return switch (col) {
            case 0 -> String.class;
            case 1 -> Integer.class;
            default -> throw new IndexOutOfBoundsException();
        };
    }

    @Override
    public int getColumnCount() {
        return COLS;
    }

    @Override
    public Object getValueAt(int x, int y) {
        return switch (y) {
            case 0 -> tags.get(x).key();
            case 1 -> tags.get(x).value();
            default -> throw new IndexOutOfBoundsException("value: " + y + " - for length 2");
        };
    }

    @Override
    public String getColumnName(int col) {
        return switch (col) {
            case 0 -> "Tag";
            case 1 -> "Occurrences";
            default -> throw new IndexOutOfBoundsException("column: " + col);
        };
    }
}
