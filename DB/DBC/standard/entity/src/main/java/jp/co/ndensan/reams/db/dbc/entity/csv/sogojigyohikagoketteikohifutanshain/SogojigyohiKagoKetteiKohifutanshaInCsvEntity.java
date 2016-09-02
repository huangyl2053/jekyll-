/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.entity.csv.sogojigyohikagoketteikohifutanshain;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 総合事業費過誤決定通知書情報取込（公費負担者分）の帳票CSVEntity
 *
 * @reamsid_L DBC-2810-030 liuhui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SogojigyohiKagoKetteiKohifutanshaInCsvEntity {
    
    @CsvField(order = 10, name = "取込年月")
    private RString 取込年月;
    @CsvField(order = 20, name = "作成日時")
    private RString 作成日時;
    @CsvField(order = 30, name = "公費負担者番号")
    private RString 公費負担者番号;
    @CsvField(order = 40, name = "公費負担者名")
    private RString 公費負担者名;
    @CsvField(order = 50, name = "取扱年月")
    private RString 取扱年月;
    @CsvField(order = 60, name = "事業者番号")
    private RString 事業者番号;
    @CsvField(order = 70, name = "事業者名")
    private RString 事業者名;
    @CsvField(order = 80, name = "公費受給者番号")
    private RString 公費受給者番号;
    @CsvField(order = 90, name = "公費受給者氏名")
    private RString 公費受給者氏名;
    @CsvField(order = 100, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 110, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 120, name = "サービス提供年月")
    private RString サービス提供年月;
    @CsvField(order = 130, name = "サービス種類コード")
    private RString サービス種類コード;
    @CsvField(order = 140, name = "サービス種類名")
    private RString サービス種類名;
    @CsvField(order = 150, name = "過誤申立事由コード")
    private RString 過誤申立事由コード;
    @CsvField(order = 160, name = "過誤申立事由")
    private RString 過誤申立事由;
    @CsvField(order = 170, name = "単位数")
    private RString 単位数;
    @CsvField(order = 180, name = "公費負担額")
    private RString 負担額;
    @CsvField(order = 190, name = "総合事業費・件数")
    private RString 総合事業費_件数;
    @CsvField(order = 200, name = "総合事業費・単位数")
    private RString 総合事業費_単位数;
    @CsvField(order = 210, name = "総合事業費・公費負担額")
    private RString 総合事業費_負担額;
    
}
