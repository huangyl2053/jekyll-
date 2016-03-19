/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 償還払支給決定情報取込の明細部。
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanShikyuKetteiInMeisaiCSVEntity {

    @CsvField(order = 10, name = "帳票レコード種別")
    private RString 帳票レコード種別;
    @CsvField(order = 20, name = "no")
    private RString no;
    @CsvField(order = 30, name = "整理番号")
    private RString 整理番号;
    @CsvField(order = 40, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 50, name = "被保険者氏名_漢字")
    private RString 被保険者氏名_漢字;
    @CsvField(order = 60, name = "サービス提供年月")
    private RString サービス提供年月;
    @CsvField(order = 70, name = "事業所番号")
    private RString 事業所番号;
    @CsvField(order = 80, name = "事業所名_漢字")
    private RString 事業所名_漢字;
    @CsvField(order = 90, name = "サービス種類コード")
    private RString サービス種類コード;
    @CsvField(order = 100, name = "サービス種類名")
    private RString サービス種類名;
    @CsvField(order = 110, name = "単位数_金額")
    private RString 単位数_金額;
    @CsvField(order = 120, name = "支払金額")
    private RString 支払金額;
    @CsvField(order = 130, name = "増減単位数")
    private RString 増減単位数;
    @CsvField(order = 140, name = "支払方法区分コード")
    private RString 支払方法区分コード;
    @CsvField(order = 150, name = "備考")
    private RString 備考;
}
