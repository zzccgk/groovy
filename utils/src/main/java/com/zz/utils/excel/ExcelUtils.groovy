package com.zz.utils.excel

import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.util.CellAddress

/**
 * Created by ccgk on 2017/9/7.
 */
class ExcelUtils {
    static getRow(Sheet sheet, int i) {
        return sheet.getRow(i) ? sheet.getRow(i) : sheet.createRow(i)
    }

    static Cell getCell(Row row, int i) {
        return row.getCell(i) ? row.getCell(i) : row.createCell(i)
    }

    static Cell getCell(Sheet sheet, int r, int l) {
        return getCell(getRow(sheet, r), l)
    }

    static Cell getCell(Sheet sheet,String address){
        def add = new CellAddress(address)
        getCell(sheet,add.row,add.column)
    }
}
