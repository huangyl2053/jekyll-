/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100201;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 非課税年金対象者情報一覧CSV作成出力用Entityクラスです．
 *
 * @reamsid_L DBD-4910-030 x_lilh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HikazeiNennkinTaishouSyaJohoListCsvOutEntity {

    @CsvField(order = 1, name = "市町村コード")
    private RString 市町村コード;
    @CsvField(order = 2, name = "年金保険者コード")
    private RString 年金保険者コード;
    @CsvField(order = 3, name = "通知内容コード")
    private RString 通知内容コード;
    @CsvField(order = 4, name = "予備１")
    private RString 予備１;
    @CsvField(order = 5, name = "制度コード")
    private RString 制度コード;
    @CsvField(order = 6, name = "作成年月日")
    private RString 作成年月日;
    @CsvField(order = 7, name = "基礎年金番号")
    private RString 基礎年金番号;
    @CsvField(order = 8, name = "年金コード")
    private RString 年金コード;
    @CsvField(order = 9, name = "予備２")
    private RString 予備２;
    @CsvField(order = 10, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 11, name = "性別")
    private RString 性別;
    @CsvField(order = 12, name = "カナ氏名")
    private RString カナ氏名;
    @CsvField(order = 13, name = "漢字氏名")
    private RString 漢字氏名;
    @CsvField(order = 14, name = "郵便番号")
    private RString 郵便番号;
    @CsvField(order = 15, name = "カナ住所")
    private RString カナ住所;
    @CsvField(order = 16, name = "漢字住所")
    private RString 漢字住所;
    @CsvField(order = 17, name = "対象年")
    private RString 対象年;
    @CsvField(order = 18, name = "訂正表示")
    private RString 訂正表示;
    @CsvField(order = 19, name = "各種区分")
    private RString 各種区分;
    @CsvField(order = 20, name = "処理結果")
    private RString 処理結果;
    @CsvField(order = 21, name = "予備３")
    private RString 予備３;
    @CsvField(order = 22, name = "予備４")
    private RString 予備４;
    @CsvField(order = 23, name = "金額１")
    private RString 金額１;
    @CsvField(order = 24, name = "金額予備１")
    private RString 金額予備１;
    @CsvField(order = 25, name = "金額予備２")
    private RString 金額予備２;
    @CsvField(order = 26, name = "予備５")
    private RString 予備５;
    @CsvField(order = 27, name = "共済年金証書記号番号")
    private RString 共済年金証書記号番号;
}
