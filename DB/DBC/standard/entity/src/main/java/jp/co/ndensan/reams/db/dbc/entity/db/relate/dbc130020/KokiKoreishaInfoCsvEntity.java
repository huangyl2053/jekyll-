/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc130020;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 後期高齢者情報のCsvEntityクラスです。
 *
 * @reamsid_L DBC-3020-040 qinzhen
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KokiKoreishaInfoCsvEntity {

    @CsvField(order = 10, name = "市町村コード")
    private RString 市町村コード;
    @CsvField(order = 20, name = "IN住民コード")
    private RString 住民コード;
    @CsvField(order = 30, name = "履歴番号")
    private RString 履歴番号;
    @CsvField(order = 40, name = "後期高齢保険者番号（市町村）")
    private RString 後期高齢保険者番号_市町村;
    @CsvField(order = 50, name = "後期高齢保険者番号（広域）")
    private RString 後期高齢保険者番号_広域;
    @CsvField(order = 60, name = "後期高齢被保険者番号")
    private RString 後期高齢被保険者番号;
    @CsvField(order = 70, name = "資格取得事由コード")
    private RString 資格取得事由コード;
    @CsvField(order = 80, name = "資格取得年月日")
    private RString 資格取得年月日;
    @CsvField(order = 90, name = "資格喪失事由コード")
    private RString 資格喪失事由コード;
    @CsvField(order = 100, name = "資格喪失年月日")
    private RString 資格喪失年月日;
    @CsvField(order = 110, name = "保険者適用開始年月日")
    private RString 保険者適用開始年月日;
    @CsvField(order = 120, name = "保険者適用終了年月日")
    private RString 保険者適用終了年月日;
    @CsvField(order = 130, name = "個人区分コード")
    private RString 個人区分コード;
    @CsvField(order = 140, name = "登録区分")
    private RString 登録区分;
    @CsvField(order = 150, name = "更新コード")
    private RString 更新コード;
    @CsvField(order = 160, name = "氏名")
    private RString 氏名;
    @CsvField(order = 170, name = "カナ氏名")
    private RString カナ氏名;
    @CsvField(order = 180, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 190, name = "性別コード")
    private RString 性別コード;
    @CsvField(order = 200, name = "郵便番号")
    private RString 郵便番号;
    @CsvField(order = 210, name = "住所")
    private RString 住所;
    @CsvField(order = 220, name = "住所コード")
    private RString 住所コード;
    @CsvField(order = 230, name = "行政区")
    private RString 行政区;
    @CsvField(order = 240, name = "行政区コード")
    private RString 行政区コード;
    @CsvField(order = 250, name = "エラーコード")
    private RString エラーコード;
    @CsvField(order = 260, name = "エラー文言")
    private RString エラー文言;

}
