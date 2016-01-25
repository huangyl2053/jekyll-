/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.jigyohokokunenpo;

import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 修正データを格納のパラメタークラスです。
 *
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TempJigyoHokokuNenpoDetalParameter {

    private final Decimal 縦番号;
    private final Decimal 横番号;
    private final Decimal 集計結果値;

    private TempJigyoHokokuNenpoDetalParameter(Decimal 縦番号, Decimal 横番号, Decimal 集計結果値) {
        this.縦番号 = 縦番号;
        this.横番号 = 横番号;
        this.集計結果値 = 集計結果値;
    }

    /**
     * 修正データを格納のパラメタークラスを生成します。
     *
     * @param 縦番号 縦番号
     * @param 横番号 横番号
     * @param 集計結果値 集計結果値
     * @return JigyoHokokuNenpoDetalParameter 修正データを格納のパラメタークラスです。
     */
    public static TempJigyoHokokuNenpoDetalParameter createParameterForTempParam(Decimal 縦番号, Decimal 横番号, Decimal 集計結果値) {
        return new TempJigyoHokokuNenpoDetalParameter(縦番号, 横番号, 集計結果値);
    }
}
