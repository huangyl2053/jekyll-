/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.csv.ocr;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * OCRのCSVデータを扱う一時テーブル(TempOcrCsv)と対応するPOJOです。
 */
@lombok.Getter
@lombok.Setter
public class TempOcrCsvEntity implements IDbAccessable {

    private RString ocrID;
    private RString sheetID;
    private RString hokenshaNo;
    private RString shinseiYMD;
    private RString hihokenshaNo;
    private RString csvData;
    private int lineNum;

    public TempOcrCsvEntity() {
    }

    /**
     * CSV1レコードの値を指定してインスタンスを生成します。
     *
     * 全フォーマットに共通の項目を各フィールドに設定します。
     *
     * @param csvData CSV1レコード
     * @param lineNum 行番号
     */
    public TempOcrCsvEntity(RString csvData, int lineNum) {
        List<RString> columns = csvData.split(",");
        this.setOcrID(getOrDefault(columns, TempOcrCsv.ocrID.index(), RString.EMPTY));
        this.setSheetID(getOrDefault(columns, TempOcrCsv.sheetID.index(), RString.EMPTY));
        this.setHokenshaNo(getOrDefault(columns, TempOcrCsv.hokenshaNo.index(), RString.EMPTY));
        this.setHihokenshaNo(getOrDefault(columns, TempOcrCsv.hihokenshaNo.index(), RString.EMPTY));
        this.setShinseiYMD(getOrDefault(columns, TempOcrCsv.shinseiYMD.index(), RString.EMPTY));
        this.setCsvData(csvData);
        this.setLineNum(lineNum);
    }

    private static <T> T getOrDefault(List<T> list, int index, T defaultValue) {
        if (list.size() <= index) {
            return defaultValue;
        }
        T value = list.get(index);
        return value == null ? defaultValue : value;
    }
}
