/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppoippan;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ファイル出力（根拠CSV）_世帯情報CSVEntityクラスです。
 *
 * @reamsid_L DBE-1520-020 wangxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SyotaiJohoCsvEntity {

    @CsvField(order = 1, name = "データ区分")
    private RString データ区分;
    @CsvField(order = 2, name = "集計区分 ")
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
    @CsvField(order = 8, name = "世帯コード")
    private RString 世帯コード;
    @CsvField(order = 9, name = "市町村コード")
    private RString 市町村コード;
    @CsvField(order = 10, name = "旧市町村コード")
    private RString 旧市町村コード;
}
