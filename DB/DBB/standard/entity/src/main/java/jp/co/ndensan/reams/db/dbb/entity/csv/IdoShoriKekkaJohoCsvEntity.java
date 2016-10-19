/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.csv;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBB241001_特徴配信データ取り込みの特別徴収異動処理結果情報件数表CSVのエンティティクラスです。
 *
 * @reamsid_L DBB-4270-020 chenyadong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IdoShoriKekkaJohoCsvEntity {

    @CsvField(order = 1, name = "市町村名称")
    private RString 市町村名称;
    @CsvField(order = 2, name = "義務者コード")
    private RString 義務者コード;
    @CsvField(order = 3, name = "義務者名")
    private RString 義務者名;
    @CsvField(order = 4, name = "該当件数")
    private RString 該当件数;
    @CsvField(order = 5, name = "資格喪失件数")
    private RString 資格喪失件数;
    @CsvField(order = 6, name = "仮徴収額変更件数")
    private RString 仮徴収額変更件数;
    @CsvField(order = 7, name = "住所地特例件数")
    private RString 住所地特例件数;
    @CsvField(order = 8, name = "資格喪失エラー件数")
    private RString 資格喪失エラー件数;
    @CsvField(order = 9, name = "仮徴収額変更エラー件数")
    private RString 仮徴収額変更エラー件数;
    @CsvField(order = 10, name = "住所地特例エラー件数")
    private RString 住所地特例エラー件数;

}
