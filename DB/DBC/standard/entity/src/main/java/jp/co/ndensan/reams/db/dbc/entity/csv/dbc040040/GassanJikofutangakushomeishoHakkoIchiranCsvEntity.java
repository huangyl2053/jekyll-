/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.dbc040040;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 自己負担証明書作成（括）のCsvEntityクラスです。
 *
 * @reamsid_L DBC-2380-030 pengxingyi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GassanJikofutangakushomeishoHakkoIchiranCsvEntity {

    @CsvField(order = 1, name = "発行日時")
    private RString 発行日時;
    @CsvField(order = 2, name = "連番")
    private RString 連番;
    @CsvField(order = 3, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 4, name = "被保険者氏名")
    private RString 被保険者氏名;
    @CsvField(order = 5, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 6, name = "性別")
    private RString 性別;
    @CsvField(order = 7, name = "申請書整理番号")
    private RString 申請書整理番号;
    @CsvField(order = 8, name = "申請対象年度")
    private RString 申請対象年度;
    @CsvField(order = 9, name = "介護加入期間開始")
    private RString 介護加入期間開始;
    @CsvField(order = 10, name = "介護加入期間終了")
    private RString 介護加入期間終了;
    @CsvField(order = 11, name = "自己負担額証明書整理番号")
    private RString 自己負担額証明書整理番号;
    @CsvField(order = 12, name = "自己負担楽合計金額（補正後）")
    private RString 自己負担楽合計金額_補正後;
    @CsvField(order = 13, name = "うち70_74歳の者に係る自己負担額")
    private RString うち70_74歳の者に係る自己負担額;
}
