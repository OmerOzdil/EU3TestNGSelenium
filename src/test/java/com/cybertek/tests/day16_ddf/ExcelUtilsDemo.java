package com.cybertek.tests.day16_ddf;


import com.cybertek.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilsDemo {

    @Test
    public void readExcelFile(){

        // Create an object from ExcelUtil
        //it accepts two argumnet.
        //Argument 1: location of the file(path)
        //Argumnet 2: sheet that we want to open(sheetName)

        ExcelUtil qa3Short = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx","QA3-short");

        //how many rows in the sheet
        System.out.println("qa3Short.rowCount() = " + qa3Short.rowCount());

        //how many columns we have
        System.out.println("qa3Short.columnCount() = " + qa3Short.columnCount());

        System.out.println("qa3Short.getColumnsNames() = " + qa3Short.getColumnsNames());

        //get all data list of maps
        List<Map<String, String>> dataList = qa3Short.getDataList();

        //get Harber
        System.out.println(dataList.get(8).get("lastname"));
        System.out.println(dataList.get(8).get("username"));

        String[][] dataArray= qa3Short.getDataArray();

        System.out.println(Arrays.deepToString(dataArray));


    }
}
