/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.nenreikaikyuriyojokyo;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 処理結果確認リストCsvEntity
 *
 * @reamsid_L DBC-3470-030 xuyongchao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class SyorikekkaCyouHyouEucCsvEntity {

    @CsvField(order = 10, name = "作成日時")
    private RString 作成日時;
    @CsvField(order = 20, name = "処理名")
    private RString 処理名;
    @CsvField(order = 30, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 40, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 50, name = "被保険者氏名")
    private RString 被保険者氏名;
    @CsvField(order = 60, name = "サービス提供年月")
    private RString サービス提供年月;
    @CsvField(order = 70, name = "事業者番号")
    private RString 事業者番号;
    @CsvField(order = 80, name = "入力識別番号")
    private RString 入力識別番号;
    @CsvField(order = 90, name = "通し番号")
    private RString 通し番号;
    @CsvField(order = 100, name = "サービス種類コード")
    private RString サービス種類コード;
    @CsvField(order = 110, name = "エラー内容")
    private RString エラー内容;
    @CsvField(order = 120, name = "備考")
    private RString 備考;

}
