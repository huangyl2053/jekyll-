/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.dbc120920;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 審査決定請求明細表情報取込共通処理（CSVファイル取込）のMeisaiクラスです
 *
 * @reamsid_L DBC-2500-013 jiangxiaolong
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SogojigyohiShinsaKetteiCsvFileMeisaiEntity {

    @CsvField(order = 10, name = "レコード種別")
    private RString レコード種別;
    @CsvField(order = 20, name = "レコード番号")
    private RString レコード番号;
    @CsvField(order = 30, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 40, name = "帳票レコード種別")
    private RString 帳票レコード種別;
    @CsvField(order = 50, name = "事業所番号")
    private RString 事業所番号;
    @CsvField(order = 60, name = "事業所名")
    private RString 事業所名;
    @CsvField(order = 70, name = "サービス提供年月")
    private RString サービス提供年月;
    @CsvField(order = 80, name = "サービス種類コード")
    private RString サービス種類コード;
    @CsvField(order = 90, name = "サービス種類名")
    private RString サービス種類名;
    @CsvField(order = 100, name = "件数")
    private RString 件数;
    @CsvField(order = 110, name = "日数・回数")
    private RString 日数_回数;
    @CsvField(order = 120, name = "単位数")
    private RString 単位数;
    @CsvField(order = 130, name = "金額")
    private RString 金額;
    @CsvField(order = 140, name = "介護給付費/総合事業費")
    private RString 介護給付費_総合事業費;
    @CsvField(order = 150, name = "利用者負担額")
    private RString 利用者負担額;
    @CsvField(order = 160, name = "公費負担額")
    private RString 公費負担額;
    @CsvField(order = 170, name = "ブランク")
    private RString ブランク;
}
