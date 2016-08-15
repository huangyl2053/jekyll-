/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.sogojigyohikagoketteiin;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票のCSVファイル作成のCsvEntity
 *
 * @reamsid_L　DBC-2550-010 jianglaishen
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SogojigyohiKagoKetteiInCsvEntity {

    @CsvField(order = 10, name = "処理年月")
    private RString 処理年月;
    @CsvField(order = 20, name = "作成日時")
    private RString 作成日時;
    @CsvField(order = 30, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 40, name = "証記載保険者名")
    private RString 証記載保険者名;
    @CsvField(order = 50, name = "取扱年月")
    private RString 取扱年月;
    @CsvField(order = 60, name = "事業者番号")
    private RString 事業者番号;
    @CsvField(order = 70, name = "事業者名")
    private RString 事業者名;
    @CsvField(order = 80, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 90, name = "被保険者名")
    private RString 被保険者名;
    @CsvField(order = 100, name = "サービス提供年月")
    private RString サービス提供年月;
    @CsvField(order = 110, name = "サービス種類コード")
    private RString サービス種類コード;
    @CsvField(order = 120, name = "サービス種類名")
    private RString サービス種類名;
    @CsvField(order = 130, name = "過誤申立事由コード")
    private RString 過誤申立事由コード;
    @CsvField(order = 140, name = "過誤申立事由")
    private RString 過誤申立事由;
    @CsvField(order = 150, name = "単位数")
    private RString 単位数;
    @CsvField(order = 160, name = "負担額")
    private RString 負担額;
    @CsvField(order = 170, name = "総合事業費_件数")
    private RString 総合事業費_件数;
    @CsvField(order = 180, name = "総合事業費_単位数")
    private RString 総合事業費_単位数;
    @CsvField(order = 190, name = "総合事業費_負担額")
    private RString 総合事業費_負担額;
}
