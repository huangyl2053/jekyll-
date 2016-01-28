/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.fukushiyogukonyuhishikyushisei;

import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * @author GC 張鋭
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SokanbaraiShiharaiKekka {

    private Decimal 費用額合計;
    private Decimal 保険対象費用額;
    private Decimal 保険給付額;
    private Decimal 利用者負担額;
}
