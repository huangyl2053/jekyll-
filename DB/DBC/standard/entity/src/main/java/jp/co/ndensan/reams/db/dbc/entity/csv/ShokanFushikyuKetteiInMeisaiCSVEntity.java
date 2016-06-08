/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払不支給決定情報の明細部。
 *
 * @reamsid_L DBC-2590-010 xuhao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanFushikyuKetteiInMeisaiCSVEntity {

    @CsvField(order = 10, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 20, name = "帳票レコード種別")
    private RString 帳票レコード種別;
    @CsvField(order = 30, name = "no")
    private RString no;
    @CsvField(order = 40, name = "整理番号")
    private RString 整理番号;
    @CsvField(order = 50, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 60, name = "被保険者氏名_漢字")
    private RString 被保険者氏名_漢字;
    @CsvField(order = 70, name = "サービス提供年月")
    private RString サービス提供年月;
    @CsvField(order = 80, name = "事業所番号")
    private RString 事業所番号;
    @CsvField(order = 90, name = "事業所名_漢字")
    private RString 事業所名_漢字;
    @CsvField(order = 100, name = "サービス種類コード")
    private RString サービス種類コード;
    @CsvField(order = 110, name = "サービス種類名")
    private RString サービス種類名;
    @CsvField(order = 120, name = "単位数_金額")
    private RString 単位数_金額;
    @CsvField(order = 130, name = "備考１")
    private RString 備考１;
    @CsvField(order = 140, name = "備考２")
    private RString 備考２;
    @CsvField(order = 150, name = "支払区分コード")
    private RString 支払区分コード;

}
