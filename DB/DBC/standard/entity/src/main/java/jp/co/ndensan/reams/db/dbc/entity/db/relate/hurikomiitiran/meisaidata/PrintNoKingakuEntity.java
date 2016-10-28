/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.hurikomiitiran.meisaidata;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 印字様式番号別金額クラスです．
 *
 * @reamsid_L DBC-5010-030 x_lilh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class PrintNoKingakuEntity {

    private int 様式連番;
    private int 名寄せ件数;
    private RString 印字様式名称;
    private RString 印字様式番号;
    private Decimal 様式別集計金額;
    private RString 集計様式番号;
}
