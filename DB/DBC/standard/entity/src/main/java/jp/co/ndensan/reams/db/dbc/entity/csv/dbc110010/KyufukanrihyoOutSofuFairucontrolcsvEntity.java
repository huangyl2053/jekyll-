/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.dbc110010;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @reamsid_L DBC-2840-030 yaoyahui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufukanrihyoOutSofuFairucontrolcsvEntity {

    @CsvField(order = 1, name = "レコード種別")
    private RString レコード種別;
    @CsvField(order = 2, name = "レコード番号（連番）")
    private RString レコード番号_連番;
    @CsvField(order = 3, name = "ボリュ－ム通番")
    private RString ボリュ_ム通番;
    @CsvField(order = 4, name = "レコード件数")
    private RString レコード件数;
    @CsvField(order = 5, name = "データ種別")
    private RString データ種別;
    @CsvField(order = 6, name = "福祉事務所特定番号")
    private RString 福祉事務所特定番号;
    @CsvField(order = 7, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 8, name = "事業所番号")
    private RString 事業所番号;
    @CsvField(order = 9, name = "都道府県番号")
    private RString 都道府県番号;
    @CsvField(order = 10, name = "媒体区分")
    private RString 媒体区分;
    @CsvField(order = 11, name = "処理対象年月")
    private RString 処理対象年月;
    @CsvField(order = 12, name = "ファイル管理番号")
    private RString ファイル管理番号;
}
