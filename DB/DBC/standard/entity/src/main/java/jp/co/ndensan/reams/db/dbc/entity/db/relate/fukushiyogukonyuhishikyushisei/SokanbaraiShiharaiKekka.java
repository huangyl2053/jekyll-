/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.fukushiyogukonyuhishikyushisei;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払支払結果
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SokanbaraiShiharaiKekka implements Serializable {

    private Decimal 費用額合計;
    private Decimal 保険対象費用額;
    private int 保険給付額;
    private int 利用者負担額;
}
