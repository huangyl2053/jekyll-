/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhituchihakkoichiran;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 給付費通知書作成(一括)CSV用データEntity。
 *
 * @reamsid_L DBC-2280-030 lizhuoxuan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuhiTuchiHakkoIchiranCsvEntity implements Serializable {

    @CsvField(order = 1, name = "作成日時")
    private RString 作成日時;
    @CsvField(order = 2, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 3, name = "被保険者氏名")
    private RString 被保険者氏名;
    @CsvField(order = 4, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 5, name = "サービス年月")
    private RString サービス年月;
    @CsvField(order = 6, name = "サービス事業者コード")
    private RString サービス事業者コード;
    @CsvField(order = 7, name = "サービス事業者名称")
    private RString サービス事業者名称;
    @CsvField(order = 8, name = "サービス種類コード")
    private RString サービス種類コード;
    @CsvField(order = 9, name = "サービス項目コード")
    private RString サービス項目コード;
    @CsvField(order = 10, name = "サービス名称")
    private RString サービス名称;
    @CsvField(order = 11, name = "サービス日数/回数")
    private RString サービス日数_回数;
    @CsvField(order = 12, name = "利用者負担額")
    private RString 利用者負担額;
    @CsvField(order = 13, name = "サービス費用")
    private RString サービス費用;
    @CsvField(order = 14, name = "要介護度")
    private RString 要介護度;
    @CsvField(order = 15, name = "資格喪失年月日")
    private RString 資格喪失年月日;
    @CsvField(order = 16, name = "資格喪失事由")
    private RString 資格喪失事由;
    @CsvField(order = 17, name = "補正有無")
    private RString 補正有無;
}
