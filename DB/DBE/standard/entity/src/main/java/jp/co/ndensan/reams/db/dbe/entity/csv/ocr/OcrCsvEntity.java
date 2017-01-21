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
 * OCRのCSVデータを扱います。
 */
@lombok.Getter
@lombok.Setter
public class OcrCsvEntity implements IDbAccessable {

    private RString ocrID;
    private RString sheetID;
    private RString hokenshaNo;
    private RString shinseiYMD;
    private RString hihokenshaNo;
    private RString csvData;

    public OcrCsvEntity() {
    }

    /**
     * CSV1レコードの値を指定してインスタンスを生成します。
     *
     * 全フォーマットに共通の項目を各フィールドに設定します。
     *
     * @param csvData CSV1レコード
     */
    public OcrCsvEntity(RString csvData) {
        List<RString> columns = csvData.split(",");
        this.setOcrID(getOrDefault(columns, OcrCsv.ocrID.index(), RString.EMPTY));
        this.setSheetID(getOrDefault(columns, OcrCsv.sheetID.index(), RString.EMPTY));
        this.setHokenshaNo(getOrDefault(columns, OcrCsv.hokenshaNo.index(), RString.EMPTY));
        this.setHihokenshaNo(getOrDefault(columns, OcrCsv.hihokenshaNo.index(), RString.EMPTY));
        this.setShinseiYMD(getOrDefault(columns, OcrCsv.shinseiYMD.index(), RString.EMPTY));
        this.setCsvData(csvData);
    }

    private static <T> T getOrDefault(List<T> list, int index, T defaultValue) {
        if (index <= list.size()) {
            return defaultValue;
        }
        T value = list.get(index);
        return value == null ? defaultValue : value;
    }
}
