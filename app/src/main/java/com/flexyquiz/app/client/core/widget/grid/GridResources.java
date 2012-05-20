package com.flexyquiz.app.client.core.widget.grid;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.DataGrid.Style;

public class GridResources implements DataGrid.Resources {

  private DataGrid.Resources defaultResources = GWT.create(DataGrid.Resources.class);
  
  public ImageResource dataGridLoading() {
    return defaultResources.dataGridLoading();
  }

  public ImageResource dataGridSortAscending() {
    return defaultResources.dataGridSortAscending();
  }

  public ImageResource dataGridSortDescending() {
    return defaultResources.dataGridSortDescending();
  }

  public Style dataGridStyle() {
    return new Style() {
      public boolean ensureInjected() {
        return false;
      }

      public String getText() {
        return "";
      }

      public String getName() {
        return "";
      }

      public String dataGridCell() {
        return "na";
      }

      public String dataGridEvenRow() {
        return "na";
      }

      public String dataGridEvenRowCell() {
        return "na";
      }

      public String dataGridFirstColumn() {
        return "na";
      }

      public String dataGridFirstColumnFooter() {
        return "na";
      }

      public String dataGridFirstColumnHeader() {
        return "na";
      }

      public String dataGridFooter() {
        return "na";
      }

      public String dataGridHeader() {
        return "na";
      }

      public String dataGridHoveredRow() {
        return "na";
      }

      public String dataGridHoveredRowCell() {
        return "na";
      }

      public String dataGridKeyboardSelectedCell() {
        return "na";
      }

      public String dataGridKeyboardSelectedRow() {
        return "na";
      }

      public String dataGridKeyboardSelectedRowCell() {
        return "na";
      }

      public String dataGridLastColumn() {
        return "na";
      }

      public String dataGridLastColumnFooter() {
        return "na";
      }

      public String dataGridLastColumnHeader() {
        return "na";
      }

      public String dataGridOddRow() {
        return "na";
      }

      public String dataGridOddRowCell() {
        return "na";
      }

      public String dataGridSelectedRow() {
        return "na";
      }

      public String dataGridSelectedRowCell() {
        return "na";
      }

      public String dataGridSortableHeader() {
        return "na";
      }

      public String dataGridSortedHeaderAscending() {
        return "na";
      }

      public String dataGridSortedHeaderDescending() {
        return "na";
      }

      public String dataGridWidget() {
        return "na";
      }
    };
  }
}
