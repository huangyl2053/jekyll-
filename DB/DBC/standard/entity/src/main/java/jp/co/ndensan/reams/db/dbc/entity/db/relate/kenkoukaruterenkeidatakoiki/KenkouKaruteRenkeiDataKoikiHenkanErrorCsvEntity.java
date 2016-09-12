/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kenkoukaruterenkeidatakoiki;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * センター送信データ出力CSVEntityクラスです。
 *
 * @reamsid_L DBE-1520-020 wangxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KenkouKaruteRenkeiDataKoikiHenkanErrorCsvEntity {

    @CsvField(order = 1, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 2, name = "異動日 ")
    private RString 異動日;
    @CsvField(order = 3, name = "市町村コード")
    private RString 市町村コード;
    @CsvField(order = 4, name = "識別コード")
    private RString 識別コード;
    @CsvField(order = 5, name = "資格取得年月日")
    private RString 資格取得年月日;
    @CsvField(order = 6, name = "資格喪失年月日")
    private RString 資格喪失年月日;
    @CsvField(order = 7, name = "業務コード")
    private RString 業務コード;
    @CsvField(order = 8, name = "住民種別コード")
    private RString 住民種別コード;
    @CsvField(order = 9, name = "住民状態コード")
    private RString 住民状態コード;
    @CsvField(order = 10, name = "名称")
    private RString 名称;
    @CsvField(order = 11, name = "カナ名称")
    private RString カナ名称;
    @CsvField(order = 12, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 13, name = "性別")
    private RString 性別;
    @CsvField(order = 14, name = "履歴番号")
    private RString 履歴番号;
    @CsvField(order = 15, name = "認定年月日")
    private RString 認定年月日;
    @CsvField(order = 16, name = "喪失年月日")
    private RString 喪失年月日;
    @CsvField(order = 17, name = "認定有効期間開始年月日")
    private RString 認定有効期間開始年月日;
    @CsvField(order = 18, name = "認定有効期間終了年月日")
    private RString 認定有効期間終了年月日;
    @CsvField(order = 19, name = "エラーメッセージ")
    private RString エラーメッセージ;
}
