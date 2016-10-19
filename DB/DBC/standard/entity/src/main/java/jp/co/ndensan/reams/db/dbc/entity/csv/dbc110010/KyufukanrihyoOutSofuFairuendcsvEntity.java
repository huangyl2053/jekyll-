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
public class KyufukanrihyoOutSofuFairuendcsvEntity {

    @CsvField(order = 1, name = "レコード種別")
    private RString レコード種別;
    @CsvField(order = 2, name = "レコード番号（連番）")
    private RString レコード番号_連番;

}
