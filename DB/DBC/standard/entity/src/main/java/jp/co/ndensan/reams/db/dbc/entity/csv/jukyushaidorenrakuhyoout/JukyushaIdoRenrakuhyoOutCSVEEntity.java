/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.jukyushaidorenrakuhyoout;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 共同処理用受給者異動連絡票（CSV）を定義したEntityクラスです。
 *
 * @reamsid_L DBC-2770-080 jinjue
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class JukyushaIdoRenrakuhyoOutCSVEEntity {

    @CsvField(order = 1, name = "レコード種別")
    private final RString レコード種別;

    @CsvField(order = 2, name = "レコード番号連")
    private final RString レコード番号連;

    @CsvField(order = 3, name = "ブランク")
    private final RString ブランク;

    /**
     * コンストラクタです。
     *
     * @param レコード種別 レコード種別
     * @param レコード番号連 レコード番号連
     * @param ブランク ブランク
     */
    public JukyushaIdoRenrakuhyoOutCSVEEntity(
            RString レコード種別,
            RString レコード番号連,
            RString ブランク
    ) {
        this.レコード番号連 = レコード番号連;
        this.レコード種別 = レコード種別;
        this.ブランク = ブランク;
    }
}
