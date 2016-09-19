/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyodojukyushainsub;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 共同処理用受給者情報のCSVEntityクラスです。
 *
 * @reamsid_L DBC-2780-011 lishengli
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyoudouShori5D4CsvEntity implements Serializable {

    @CsvField(order = 1, name = "レコード種別")
    private RString レコード種別;
    @CsvField(order = 2, name = "レコード番号")
    private RString レコード番号;
    @CsvField(order = 3, name = "ボリューム通番")
    private RString ボリューム通番;
    @CsvField(order = 4, name = "レコード件数")
    private RString レコード件数;
    @CsvField(order = 5, name = "テータ種別")
    private RString テータ種別;
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
    @CsvField(order = 13, name = "ブラング")
    private RString ブラング;
    @CsvField(order = 14, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 15, name = "異動年月日")
    private RString 異動年月日;
    @CsvField(order = 16, name = "訂正年月日")
    private RString 訂正年月日;
    @CsvField(order = 17, name = "異動区分コード")
    private RString 異動区分コード;
    @CsvField(order = 18, name = "異動事由")
    private RString 異動事由;
    @CsvField(order = 19, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 20, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 21, name = "保険給付支払の一時差止の開始年月日")
    private RString 保険給付支払の一時差止の開始年月日;
    @CsvField(order = 22, name = "保険給付支払の一時差止の終了年月日")
    private RString 保険給付支払の一時差止の終了年月日;
    @CsvField(order = 23, name = "保険給付支払の一時差止区分")
    private RString 保険給付支払の一時差止区分;
    @CsvField(order = 24, name = "保険給付支払の一時差止金額")
    private RString 保険給付支払の一時差止金額;

}
