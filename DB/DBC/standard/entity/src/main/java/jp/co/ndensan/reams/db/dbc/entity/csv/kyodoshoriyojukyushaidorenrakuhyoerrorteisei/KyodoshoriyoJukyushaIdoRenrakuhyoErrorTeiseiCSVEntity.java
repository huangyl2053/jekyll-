/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.kyodoshoriyojukyushaidorenrakuhyoerrorteisei;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 共同処理用受給者異動連絡票エラー訂正のCSVEntityクラスです。
 *
 * @reamsid_L DBC-2770-070 jinjue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyodoshoriyoJukyushaIdoRenrakuhyoErrorTeiseiCSVEntity {

    @CsvField(order = 1, name = "異動日")
    private FlexibleDate 異動日;
    @CsvField(order = 2, name = "被保番号")
    private RString 被保番号;
    @CsvField(order = 3, name = "かな氏名")
    private RString かな氏名;
    @CsvField(order = 4, name = "項目")
    private RString 項目;
}
