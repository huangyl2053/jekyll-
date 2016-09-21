/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 振込エラーリストCSV出力クラスです．
 *
 * @reamsid_L DBC-5010-030 x_lilh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FurikomiErrorListCsvEntity {

    @CsvField(order = 1, name = "作成日時")
    private RString 作成日時;
    @CsvField(order = 2, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 3, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 4, name = "被保険者氏名")
    private RString 被保険者氏名;
    @CsvField(order = 5, name = "郵便番号")
    private RString 郵便番号;
    @CsvField(order = 6, name = "住所")
    private RString 住所;
    @CsvField(order = 7, name = "識別コード")
    private RString 識別コード;
    @CsvField(order = 8, name = "口座ID")
    private RString 口座ID;
    @CsvField(order = 9, name = "決定通知番号")
    private RString 決定通知番号;
    @CsvField(order = 10, name = "振込金額")
    private RString 振込金額;
    @CsvField(order = 11, name = "データ区分")
    private RString データ区分;
}
