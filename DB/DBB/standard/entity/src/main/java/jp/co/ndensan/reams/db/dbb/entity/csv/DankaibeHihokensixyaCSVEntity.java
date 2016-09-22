/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.csv;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 段階別被保険者数一覧。
 *
 * @reamsid_L DBB-1820-040 dingminghao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DankaibeHihokensixyaCSVEntity {

    @CsvField(order = 1, name = "賦課年度")
    private RString 賦課年度;
    @CsvField(order = 2, name = "市町村コード")
    private RString 市町村コード;
    @CsvField(order = 3, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 4, name = "識別コード")
    private RString 識別コード;
    @CsvField(order = 5, name = "資格取得日")
    private RString 資格取得日;
    @CsvField(order = 6, name = "資格喪失日")
    private RString 資格喪失日;
    @CsvField(order = 7, name = "賦課基準日")
    private RString 賦課基準日;
    @CsvField(order = 8, name = "保険者設定段階")
    private RString 保険者設定段階;
    @CsvField(order = 9, name = "標準設定段階")
    private RString 標準設定段階;
    @CsvField(order = 10, name = "合計所得金額")
    private RString 合計所得金額;
    @CsvField(order = 11, name = "年金収入額")
    private RString 年金収入額;
    @CsvField(order = 12, name = "生保開始日")
    private RString 生保開始日;
    @CsvField(order = 13, name = "生保終了日")
    private RString 生保終了日;
    @CsvField(order = 14, name = "老年開始日")
    private RString 老年開始日;
    @CsvField(order = 15, name = "老年終了日")
    private RString 老年終了日;
}
