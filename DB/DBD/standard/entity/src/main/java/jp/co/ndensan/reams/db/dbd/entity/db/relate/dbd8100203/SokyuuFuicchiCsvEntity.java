/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100203;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 非課税年金対象者情報＿遡及不一致CSVEntityクラスです．
 *
 * @reamsid_L DBD-4910-050 x_lilh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SokyuuFuicchiCsvEntity {

    @CsvField(order = 1, name = "市町村コード")
    private RString 市町村コード;
    @CsvField(order = 2, name = "年金保険者コード")
    private RString 年金保険者コード;
    @CsvField(order = 3, name = "年金保険者名称")
    private RString 年金保険者名称;
    @CsvField(order = 4, name = "基礎年金番号")
    private RString 基礎年金番号;
    @CsvField(order = 5, name = "年金コード")
    private RString 年金コード;
    @CsvField(order = 6, name = "年金名称")
    private RString 年金名称;
    @CsvField(order = 7, name = "対象年")
    private RString 対象年;
    @CsvField(order = 8, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 9, name = "性別コード")
    private RString 性別コード;
    @CsvField(order = 10, name = "性別")
    private RString 性別;
    @CsvField(order = 11, name = "カナ氏名")
    private RString カナ氏名;
    @CsvField(order = 12, name = "漢字氏名")
    private RString 漢字氏名;
    @CsvField(order = 13, name = "郵便番号")
    private RString 郵便番号;
    @CsvField(order = 14, name = "住所")
    private RString 住所;
    @CsvField(order = 15, name = "訂正表示コード")
    private RString 訂正表示コード;
    @CsvField(order = 16, name = "訂正表示")
    private RString 訂正表示;
    @CsvField(order = 17, name = "各種区分コード")
    private RString 各種区分コード;
    @CsvField(order = 18, name = "各種区分")
    private RString 各種区分;
    @CsvField(order = 19, name = "処理結果コード")
    private RString 処理結果コード;
    @CsvField(order = 20, name = "処理結果")
    private RString 処理結果;
    @CsvField(order = 21, name = "金額")
    private RString 金額;
    @CsvField(order = 22, name = "出力事由")
    private RString 出力事由;

}
