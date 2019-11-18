package com.titanium.framework.utils;

import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;

public class CucumberUtil {
    private static List<DataCollection> dataCollection = new ArrayList<>();

    public static List<DataCollection> convertDataTableToDic(DataTable table){
        List<List<String>> data = table.asLists();

        int rowNumber = 0;

        for (List<String> col : data ) {
            for (int colIndex = 0; colIndex < col.size(); colIndex++){
                dataCollection.add(rowNumber, new DataCollection(data.get(0).get(colIndex), col.get(colIndex), rowNumber));
            }
            rowNumber ++;
        }

        return dataCollection;
    }

    public static String getCellValueWithRowIndex(String columnName, int rowNumber) {
        final String[] columnValue = {null};
        dataCollection.forEach(x -> {
            if(x.columnName.equals(columnName) && x.rowNumber == rowNumber){
                columnValue[0] = x.columnValue;
            }
        });
        return columnValue[0];
    }

    private static class DataCollection{
        private String columnName;
        private String columnValue;
        private int rowNumber;

        public DataCollection(String columnName, String columnValue, int rowNumber) {
            this.columnName = columnName;
            this.columnValue = columnValue;
            this.rowNumber = rowNumber;
        }
    }
}
