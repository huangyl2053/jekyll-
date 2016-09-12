/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.kaigojuminhyo;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付費通知減免補正一覧表作成のCSVファイル作成のCsvEntity
 *
 * @reamsid_L DBC-2270-030 lijia
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuTsuchiGenmenHoseiCsvEntity {

    @CsvField(order = 10, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 20, name = "被保険者名")
    private RString 被保険者名;
    @CsvField(order = 30, name = "年月")
    private RString 年月;
    @CsvField(order = 40, name = "サービス事業者コード")
    private RString サービス事業者コード;
    @CsvField(order = 50, name = "サービス事業者")
    private RString サービス事業者;
    @CsvField(order = 60, name = "サービス種類コード")
    private RString サービス種類コード;
    @CsvField(order = 70, name = "サービス種類")
    private RString サービス種類;
    @CsvField(order = 80, name = "利用者負担額")
    private RString 利用者負担額;
    @CsvField(order = 90, name = "サービス費用")
    private RString サービス費用;

    /**
     * コンストラクタ
     *
     * @param 被保険者番号 RString
     * @param 被保険者名 RString
     * @param 年月 RString
     * @param サービス事業者コード RString
     * @param サービス事業者 RString
     * @param サービス種類コード RString
     * @param サービス種類 RString
     * @param 利用者負担額 RString
     * @param サービス費用 RString
     */
    public KyufuTsuchiGenmenHoseiCsvEntity(
            RString 被保険者番号,
            RString 被保険者名,
            RString 年月,
            RString サービス事業者コード,
            RString サービス事業者,
            RString サービス種類コード,
            RString サービス種類,
            RString 利用者負担額,
            RString サービス費用
    ) {
        this.被保険者番号 = 被保険者番号;
        this.被保険者名 = 被保険者名;
        this.年月 = 年月;
        this.サービス事業者コード = サービス事業者コード;
        this.サービス事業者 = サービス事業者;
        this.サービス種類コード = サービス種類コード;
        this.サービス種類 = サービス種類;
        this.利用者負担額 = 利用者負担額;
        this.サービス費用 = サービス費用;
    }
}
