/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処理結果確認リストCSV出力クラスです．
 *
 * @reamsid_L DBC-5010-030 x_lilh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShoriKekkaKakuninListCsvEntity {

    @CsvField(order = 1, name = "作成日時")
    private RString 作成日時;
    @CsvField(order = 2, name = "処理名")
    private RString 処理名;
    @CsvField(order = 3, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 4, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 5, name = "エラー内容")
    private RString エラー内容;
    @CsvField(order = 6, name = "備考")
    private RString 備考;
}
