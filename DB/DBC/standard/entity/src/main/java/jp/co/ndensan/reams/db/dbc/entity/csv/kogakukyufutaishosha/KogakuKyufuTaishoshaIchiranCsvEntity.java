/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.kogakukyufutaishosha;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票のCSVファイル作成のCsvEntity
 *
 * @reamsid_L DBC-0980-360 chenaoqi
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuKyufuTaishoshaIchiranCsvEntity {

    @CsvField(order = 10, name = "処理年月")
    private RString 処理年月;
    @CsvField(order = 20, name = "作成日時")
    private RString 作成日時;
    @CsvField(order = 30, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 40, name = "証記載保険者名")
    private RString 証記載保険者名;
    @CsvField(order = 50, name = "通知書番号")
    private RString 通知書番号;
    @CsvField(order = 60, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 70, name = "被保険者氏名")
    private RString 被保険者氏名;
    @CsvField(order = 80, name = "サービス提供年月")
    private RString サービス提供年月;
    @CsvField(order = 90, name = "事業者番号")
    private RString 事業者番号;
    @CsvField(order = 100, name = "事業者名")
    private RString 事業者名;
    @CsvField(order = 110, name = "サービス種類コード")
    private RString サービス種類コード;
    @CsvField(order = 120, name = "サービス種類名")
    private RString サービス種類名;
    @CsvField(order = 130, name = "サービス費用合計額")
    private RString サービス費用合計額;
    @CsvField(order = 140, name = "利用者負担額")
    private RString 利用者負担額;
    @CsvField(order = 150, name = "資格喪失日")
    private RString 資格喪失日;
    @CsvField(order = 160, name = "備考")
    private RString 備考;
    @CsvField(order = 170, name = "サービス費用合計額合計")
    private RString サービス費用合計額合計;
    @CsvField(order = 180, name = "利用者負担額合計")
    private RString 利用者負担額合計;
    @CsvField(order = 190, name = "算定基準額")
    private RString 算定基準額;
    @CsvField(order = 200, name = "支払済金額合計")
    private RString 支払済金額合計;
    @CsvField(order = 210, name = "高額支給額")
    private RString 高額支給額;

}
