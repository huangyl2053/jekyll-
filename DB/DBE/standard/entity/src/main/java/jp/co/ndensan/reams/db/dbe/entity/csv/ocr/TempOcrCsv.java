/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.csv.ocr;

/**
 * OCRのCSVデータに共通の列定義です。
 *
 * 一時テーブルにCSVデータをインポートした際に、その値を参照するのに用います。
 */
enum TempOcrCsv {

    /**
     * OCR帳票を識別するためのID
     */
    ocrID(0),
    /**
     * 取り込んだシートを識別するためのID
     *
     * ('YYYYMMDD nnnnnn'の形式.YYYYMMDDは取り込んだ日付, nnnnnnは6桁0埋めの連番)
     */
    sheetID(1),
    /**
     * 証記載保険者番号
     */
    hokenshaNo(2),
    /**
     * 申請日
     */
    shinseiYMD(3),
    /**
     * 被保険者番号
     */
    hihokenshaNo(4);

    private final int theIndex;

    private TempOcrCsv(int index) {
        this.theIndex = index;
    }

    int index() {
        return this.theIndex;
    }
}
