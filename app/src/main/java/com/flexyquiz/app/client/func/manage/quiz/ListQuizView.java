package com.flexyquiz.app.client.func.manage.quiz;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.flexyquiz.app.client.core.mvp.BaseView;
import com.flexyquiz.app.client.core.mvp.View;
import com.flexyquiz.app.client.core.widget.grid.GridResources;
import com.flexyquiz.app.shared.func.model.Quiz;
import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.IdentityColumn;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.HasCellPreviewHandlers;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.ProvidesKey;

@View(forActivity = ListQuizActivity.class)
public class ListQuizView extends BaseView implements ListQuizActivity.Display {
  interface ListQuizViewUiBinder extends UiBinder<Widget, ListQuizView> {
  }

  private static ListQuizViewUiBinder uiBinder = GWT.create(ListQuizViewUiBinder.class);

  @UiField(provided = true)
  DataGrid<Quiz> dataGrid;

  private ListDataProvider<Quiz> dataProvider = new ListDataProvider<Quiz>(new ArrayList<Quiz>());

  public static final ProvidesKey<Quiz> KEY_PROVIDER = new ProvidesKey<Quiz>() {
    public Object getKey(Quiz item) {
      return item == null ? null : item.getId();
    }
  };

  public ListQuizView() {
    initDataGrid();
    initWidget(uiBinder.createAndBindUi(this));
  }

  private void initDataGrid() {
    dataGrid = new DataGrid<Quiz>(1000, new GridResources(), KEY_PROVIDER);
    dataGrid.setHeight("100%");
    Label noDataLabel = new Label("No data to display");
    noDataLabel.setStyleName("label label-warning");
    dataGrid.setEmptyTableWidget(noDataLabel);

    initGridColumns();

    dataProvider.addDataDisplay(dataGrid);
    ListHandler<Quiz> sortHandler = new ListHandler<Quiz>(dataProvider.getList());
    sortHandler.setComparator(dataGrid.getColumn(0), new Comparator<Quiz>() {
      public int compare(Quiz o1, Quiz o2) {
        return o1.getName().compareTo(o2.getName());
      }
    });
    sortHandler.setComparator(dataGrid.getColumn(1), new Comparator<Quiz>() {
      public int compare(Quiz o1, Quiz o2) {
        return o1.getDescription().compareTo(o2.getDescription());
      }
    });
    dataGrid.addColumnSortHandler(sortHandler);
  }

  private void initGridColumns() {
    Column<Quiz, Quiz> nameColumn = new IdentityColumn<Quiz>(new AbstractCell<Quiz>() {
      @Override
      public void render(final Context context, final Quiz value, final SafeHtmlBuilder sb) {
        sb.appendEscaped(value.getName());
      }
    });
    nameColumn.setSortable(true);
    dataGrid.addColumn(nameColumn, "Name");
    dataGrid.setColumnWidth(nameColumn, 20, Unit.PCT);

    Column<Quiz, Quiz> descriptionColumn = new IdentityColumn<Quiz>(new AbstractCell<Quiz>() {
      @Override
      public void render(final Context context, final Quiz value, final SafeHtmlBuilder sb) {
        sb.appendEscaped(value.getDescription());
      }
    });
    descriptionColumn.setSortable(true);
    dataGrid.addColumn(descriptionColumn, "Description");
    dataGrid.setColumnWidth(descriptionColumn, 80, Unit.PCT);
  }

  public void setListData(List<? extends Quiz> newData) {
    List<Quiz> dataList = dataProvider.getList();
    dataList.clear();
    dataList.addAll(newData);
    dataProvider.refresh();
  }

  public HasCellPreviewHandlers<Quiz> getGrid() {
    return dataGrid;
  }
}
