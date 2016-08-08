/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ビジネス設計_DBCMNK3001_負担割合証ソースファイル作成（service）CSVEntity
 *
 * @reamsid_L DBC-4990-031 pengxingyi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FutanwariaiShoHakkoIchiranCSVEntity {

    @CsvField(order = 10, name = "連番")
    private RString 連番;
    @CsvField(order = 20, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 30, name = "送付先住所")
    private RString 送付先住所;
    @CsvField(order = 40, name = "被保険者氏名")
    private RString 被保険者氏名;
    @CsvField(order = 50, name = "判定日")
    private RString 判定日;
    @CsvField(order = 60, name = "開始年月日")
    private RString 開始年月日;
    @CsvField(order = 70, name = "終了年月日")
    private RString 終了年月日;
    @CsvField(order = 80, name = "負担割合")
    private RString 負担割合;
    @CsvField(order = 90, name = "判定区分")
    private RString 判定区分;
    @CsvField(order = 100, name = "発行済")
    private RString 発行済;
    @CsvField(order = 110, name = "事業対象者・受給者区分")
    private RString 事業対象者受給者区分;
    @CsvField(order = 120, name = "資格区分")
    private RString 資格区分;
    @CsvField(order = 130, name = "証記載保険者番号")
    private RString 証記載保険者番号;

}
