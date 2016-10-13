/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.henreihoryuin;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票のCSVファイル作成のCsvEntity
 *
 * @reamsid_L DBC-2830-010 yaodongsheng
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HenreiHoryuInCsvEntity {

    @CsvField(order = 1, name = "審査年月")
    private RString 審査年月;
    @CsvField(order = 2, name = "作成日時")
    private RString 作成日時;
    @CsvField(order = 3, name = "国保連合会名")
    private RString 国保連合会名;
    @CsvField(order = 4, name = "№")
    private RString 連番;
    @CsvField(order = 5, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 6, name = "保険者名")
    private RString 保険者名;
    @CsvField(order = 7, name = "事業者番号")
    private RString 事業者番号;
    @CsvField(order = 8, name = "事業者名")
    private RString 事業者名;
    @CsvField(order = 9, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 10, name = "被保険者氏名")
    private RString 被保険者氏名;
    @CsvField(order = 11, name = "種別")
    private RString 種別;
    @CsvField(order = 12, name = "サービス提供年月")
    private RString サービス提供年月;
    @CsvField(order = 13, name = "サービス種類コード")
    private RString サービス種類コード;
    @CsvField(order = 14, name = "サービス項目コード等")
    private RString サービス項目コード等;
    @CsvField(order = 15, name = "単位数")
    private RString 単位数;
    @CsvField(order = 16, name = "事由")
    private RString 事由;
    @CsvField(order = 17, name = "内容")
    private RString 内容;
    @CsvField(order = 18, name = "備考")
    private RString 備考;

}
