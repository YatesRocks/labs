package labs.yates.view.components;

import labs.yates.model.TagModel;

import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.util.ArrayList;
import java.util.List;

// TODO: Document
public class TagTable extends JTable {
    public void initSorter(TagModel tagModel) {
        TableRowSorter<TagModel> sorter = new TableRowSorter<>();
        setModel(tagModel);
        sorter.setModel(tagModel);
        sorter.setSortsOnUpdates(true);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(1, SortOrder.DESCENDING));
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);
        setRowSorter(sorter);
    }
}
