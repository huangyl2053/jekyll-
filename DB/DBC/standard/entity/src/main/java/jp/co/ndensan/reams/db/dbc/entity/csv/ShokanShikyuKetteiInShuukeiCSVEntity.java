/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払請求集計一時テーブル
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanShikyuKetteiInShuukeiCSVEntity {

    @CsvField(order = 10, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 20, name = "サービス提供年月")
    private RString サービス提供年月;
    @CsvField(order = 30, name = "整理番号")
    private RString 整理番号;
    @CsvField(order = 40, name = "事業所番号")
    private RString 事業所番号;
    @CsvField(order = 50, name = "サービス種類コード")
    private RString サービス種類コード;
    @CsvField(order = 60, name = "支払方法区分コード")
    private RString 支払方法区分コード;
    @CsvField(order = 70, name = "単位数_金額")
    private RString 単位数_金額;
    @CsvField(order = 80, name = "支払金額")
    private RString 支払金額;
    @CsvField(order = 90, name = "増減単位数")
    private RString 増減単位数;
    @CsvField(order = 100, name = "増減理由")
    private RString 増減理由;

}
