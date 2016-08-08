/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処理結果確認リストのCSVEntity
 *
 * @reamsid_L DBC-4990-031 pengxingyi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShoriKekkaKakuninListCSVEntity {

    @CsvField(order = 10, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 20, name = "確認内容")
    private RString 確認内容;
}
