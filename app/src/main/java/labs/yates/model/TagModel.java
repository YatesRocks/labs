package labs.yates.model;

import javax.swing.table.AbstractTableModel;
import java.util.Vector;

/**
 * The backend for any JTables you see in the application
 */
public class TagModel extends AbstractTableModel {
    private Vector<Tag<String, Integer>> tags;
    private static final int COLS = 2;

    public TagModel() {

    }

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return COLS;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        return null;
    }
}
