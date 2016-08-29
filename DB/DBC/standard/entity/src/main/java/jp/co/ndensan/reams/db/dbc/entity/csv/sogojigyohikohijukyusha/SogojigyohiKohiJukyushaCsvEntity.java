/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.sogojigyohikohijukyusha;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票のCSVファイル作成のCsvEntity
 *
 * @reamsid_L DBC-4710-030 chenjie
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SogojigyohiKohiJukyushaCsvEntity {

    @CsvField(order = 10, name = "審査年月")
    private RString 審査年月;
    @CsvField(order = 20, name = "作成日時")
    private RString 作成日時;
    @CsvField(order = 30, name = "国保連合会名")
    private RString 国保連合会名;
    @CsvField(order = 40, name = "公費負担者番号")
    private RString 公費負担者番号;
    @CsvField(order = 50, name = "公費負担者名")
    private RString 公費負担者名;
    @CsvField(order = 60, name = "公費受給者番号")
    private RString 公費受給者番号;
    @CsvField(order = 70, name = "サービス提供年月")
    private RString サービス提供年月;
    @CsvField(order = 80, name = "事業者番号")
    private RString 事業者番号;
    @CsvField(order = 90, name = "事業者名")
    private RString 事業者名;
    @CsvField(order = 100, name = "サービスコード")
    private RString サービスコード;
    @CsvField(order = 110, name = "サービス種類名")
    private RString サービス種類名;
    @CsvField(order = 120, name = "サービス項目名")
    private RString サービス項目名;
    @CsvField(order = 130, name = "日数・回数")
    private RString 日数_回数;
    @CsvField(order = 140, name = "公費対象単位数")
    private RString 公費対象単位数;
    @CsvField(order = 150, name = "公費負担金額")
    private RString 公費負担金額;
    @CsvField(order = 160, name = "公費分本人負担額")
    private RString 公費分本人負担額;
    @CsvField(order = 170, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 180, name = "被保険者氏名")
    private RString 被保険者氏名;
    @CsvField(order = 190, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 200, name = "公費対象単位数集計")
    private RString 公費対象単位数集計;
    @CsvField(order = 210, name = "公費負担金額集計")
    private RString 公費負担金額集計;
    @CsvField(order = 220, name = "公費分本人負担額集計")
    private RString 公費分本人負担額集計;
}
