/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100203;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 非課税年金対象者情報_遡及該当一覧CSVEntityクラスです．
 *
 * @reamsid_L DBD-4910-050 x_lilh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SokyuuGaitouIchirannCsvEntity {

    @CsvField(order = 1, name = "市町村コード")
    private RString 市町村コード;
    @CsvField(order = 2, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 3, name = "年金保険者コード")
    private RString 年金保険者コード;
    @CsvField(order = 4, name = "年金保険者名称")
    private RString 年金保険者名称;
    @CsvField(order = 5, name = "基礎年金番号")
    private RString 基礎年金番号;
    @CsvField(order = 6, name = "基礎年金番号変更")
    private RString 基礎年金番号変更;
    @CsvField(order = 7, name = "年金コード")
    private RString 年金コード;
    @CsvField(order = 8, name = "年金名称")
    private RString 年金名称;
    @CsvField(order = 9, name = "対象年")
    private RString 対象年;
    @CsvField(order = 10, name = "識別コード")
    private RString 識別コード;
    @CsvField(order = 11, name = "世帯コード")
    private RString 世帯コード;
    @CsvField(order = 12, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 13, name = "性別コード")
    private RString 性別コード;
    @CsvField(order = 14, name = "性別")
    private RString 性別;
    @CsvField(order = 15, name = "カナ氏名市町村データ")
    private RString カナ氏名市町村データ;
    @CsvField(order = 16, name = "カナ氏名年金保険者データ")
    private RString カナ氏名年金保険者データ;
    @CsvField(order = 17, name = "漢字氏名")
    private RString 漢字氏名;
    @CsvField(order = 18, name = "郵便番号")
    private RString 郵便番号;
    @CsvField(order = 19, name = "住所")
    private RString 住所;
    @CsvField(order = 20, name = "訂正表示コード")
    private RString 訂正表示コード;
    @CsvField(order = 21, name = "訂正表示")
    private RString 訂正表示;
    @CsvField(order = 22, name = "各種区分コード")
    private RString 各種区分コード;
    @CsvField(order = 23, name = "各種区分")
    private RString 各種区分;
    @CsvField(order = 24, name = "処理結果コード")
    private RString 処理結果コード;
    @CsvField(order = 25, name = "処理結果")
    private RString 処理結果;
    @CsvField(order = 26, name = "金額")
    private RString 金額;
}
