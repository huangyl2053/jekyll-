/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokunenpoyoshiki1to2;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 根拠リストCSVのEntityクラスです。
 *
 * @reamsid_L DBU-5610-030 chengsanyuan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KonkyoListCsvEntity {

    @CsvField(order = 1, name = "データ区分")
    private RString データ区分;
    @CsvField(order = 2, name = "集計区分")
    private RString 集計区分;
    @CsvField(order = 3, name = "表番号")
    private RString 表番号;
    @CsvField(order = 4, name = "集計番号")
    private RString 集計番号;
    @CsvField(order = 5, name = "集計単位")
    private RString 集計単位;
    @CsvField(order = 6, name = "縦番号")
    private RString 縦番号;
    @CsvField(order = 7, name = "横番号")
    private RString 横番号;
    @CsvField(order = 8, name = "調定年度")
    private RString 調定年度;
    @CsvField(order = 9, name = "通知書番号")
    private RString 通知書番号;
    @CsvField(order = 10, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 11, name = "課税区分")
    private RString 課税区分;
    @CsvField(order = 12, name = "世帯課税区分")
    private RString 世帯課税区分;
    @CsvField(order = 13, name = "合計所得金額")
    private RString 合計所得金額;
    @CsvField(order = 14, name = "所得段階")
    private RString 所得段階;
    @CsvField(order = 15, name = "保険料算定段階1")
    private RString 保険料算定段階1;
    @CsvField(order = 16, name = "保険料算定段階2")
    private RString 保険料算定段階2;
    @CsvField(order = 17, name = "市町村コード")
    private RString 市町村コード;
    @CsvField(order = 18, name = "旧市町村コード")
    private RString 旧市町村コード;
}
