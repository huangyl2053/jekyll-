/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.shokanfushikyuketteiin;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 償還払不支給決定情報取込のの明細csvEntity。
 *
 * @reamsid_L DBC-2590-010 xuhao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanFushikyuKetteiInCSVMeisaiEntity {

    @CsvField(order = 10, name = "レコード種別")
    private RString codeShubetsu;
    @CsvField(order = 20, name = "レコード番号")
    private RString codeNo;
    @CsvField(order = 30, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 40, name = "帳票レコード種別")
    private RString 帳票レコード種別;
    @CsvField(order = 50, name = "no")
    private RString no;
    @CsvField(order = 60, name = "整理番号")
    private RString 整理番号;
    @CsvField(order = 70, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 80, name = "被保険者氏名_漢字")
    private RString 被保険者氏名_漢字;
    @CsvField(order = 90, name = "サービス提供年月")
    private FlexibleYearMonth サービス提供年月;
    @CsvField(order = 100, name = "事業所番号")
    private RString 事業所番号;
    @CsvField(order = 110, name = "事業所名_漢字")
    private RString 事業所名_漢字;
    @CsvField(order = 120, name = "サービス種類コード")
    private RString サービス種類コード;
    @CsvField(order = 130, name = "サービス種類名")
    private RString サービス種類名;
    @CsvField(order = 140, name = "単位数_金額")
    private Decimal 単位数_金額;
    @CsvField(order = 150, name = "備考1")
    private RString 備考1;
    @CsvField(order = 160, name = "備考2")
    private RString 備考2;
}
