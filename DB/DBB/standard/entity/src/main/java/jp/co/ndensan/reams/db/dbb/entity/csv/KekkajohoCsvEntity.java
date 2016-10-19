/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.csv;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBB241001_特徴配信データ取り込みの特別徴収結果情報件数表CSVのエンティティクラスです。
 *
 * @reamsid_L DBB-4270-020 chenyadong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KekkajohoCsvEntity {

    @CsvField(order = 1, name = "市町村名称")
    private RString 市町村名称;
    @CsvField(order = 2, name = "義務者コード")
    private RString 義務者コード;
    @CsvField(order = 3, name = "義務者名")
    private RString 義務者名;
    @CsvField(order = 4, name = "該当件数")
    private RString 該当件数;
    @CsvField(order = 5, name = "停止件数")
    private RString 停止件数;
    @CsvField(order = 6, name = "該当金額")
    private RString 該当金額;
    @CsvField(order = 7, name = "停止金額")
    private RString 停止金額;
}
