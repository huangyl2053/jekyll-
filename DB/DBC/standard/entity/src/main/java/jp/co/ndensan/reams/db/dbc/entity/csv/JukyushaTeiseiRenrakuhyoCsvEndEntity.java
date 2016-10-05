/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 帳票設計_DBCZV00002_受給者訂正連絡票（CSV）CsvEndEntity
 *
 * @reamsid_L DBC-2720-091 surun
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyushaTeiseiRenrakuhyoCsvEndEntity {

    @CsvField(order = 10, name = "レコード種別")
    private RString レコード種別;
    @CsvField(order = 20, name = "レコード番号（連）")
    private RString レコード番号連;
    @CsvField(order = 30, name = "ブランク")
    private RString ブランク;

}
