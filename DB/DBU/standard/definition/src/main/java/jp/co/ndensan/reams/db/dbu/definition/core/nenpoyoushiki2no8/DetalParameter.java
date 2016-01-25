/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.core.nenpoyoushiki2no8;

import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * DetalParameterです。
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class DetalParameter {

    private final Decimal 縦番号;
    private final Decimal 横番号;
    private final Decimal 集計結果値;

    private DetalParameter(Decimal 縦番号, Decimal 横番号, Decimal 集計結果値) {
        this.縦番号 = 縦番号;
        this.横番号 = 横番号;
        this.集計結果値 = 集計結果値;
    }

    public static DetalParameter creatDetalParameter(Decimal 縦番号, Decimal 横番号, Decimal 集計結果値) {
        return new DetalParameter(縦番号, 横番号, 集計結果値);
    }
}
