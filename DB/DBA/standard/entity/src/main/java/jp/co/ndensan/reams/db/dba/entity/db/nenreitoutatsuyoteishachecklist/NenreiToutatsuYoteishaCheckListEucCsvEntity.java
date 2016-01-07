/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.nenreitoutatsuyoteishachecklist;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 年齢到達予定者チェックリストCSV用データEntity。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NenreiToutatsuYoteishaCheckListEucCsvEntity {

    @CsvField(order = 10, name = "連番")
    private RString renban;
    @CsvField(order = 20, name = "被保険者番号")
    private RString hihokenshaNo;
    @CsvField(order = 30, name = "識別コード")
    private RString shikibetsuCode;
    @CsvField(order = 40, name = "カナ氏名")
    private RString kanaMeisho;
    @CsvField(order = 50, name = "氏名")
    private RString meisho;
    @CsvField(order = 60, name = "性別")
    private RString seibetsu;
    @CsvField(order = 70, name = "生年月日")
    private RString seinengappiYMD;
    @CsvField(order = 80, name = "年齢到達日")
    private RString nenreiyotainichi;
    @CsvField(order = 90, name = "資格区分")
    private RString shigekubun;
    @CsvField(order = 100, name = "住特者区分")
    private RString jutosyakubun;
    @CsvField(order = 110, name = "住所コード")
    private RString jushoCode;
    @CsvField(order = 120, name = "住所")
    private RString jusho;
    @CsvField(order = 130, name = "行政区コード")
    private RString gyoseikuCode;
    @CsvField(order = 140, name = "行政区")
    private RString gyoseikuName;
    @CsvField(order = 150, name = "住民種別")
    private RString juminShubetsu;
    @CsvField(order = 160, name = "生活")
    private RString seikatsu;
    @CsvField(order = 170, name = "状態")
    private RString jyotei;
}
