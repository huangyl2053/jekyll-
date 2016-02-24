/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.core.choteibo;

import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 段階合計後調定額合計クラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DankaiGakuGokeigo {

    private Decimal 特別徴収当月末の全部件数の合計 = Decimal.ZERO;
    private Decimal 特別徴収当月末の全部調定額の合計 = Decimal.ZERO;
    private Decimal 特別徴収前月末の全部件数の合計 = Decimal.ZERO;
    private Decimal 特別徴収前月末の全部調定額の合計 = Decimal.ZERO;
    private Decimal 普通徴収当月末の全部件数の合計 = Decimal.ZERO;
    private Decimal 普通徴収当月末の全部調定額の合計 = Decimal.ZERO;
    private Decimal 普通徴収前月末の全部件数の合計 = Decimal.ZERO;
    private Decimal 普通徴収前月末の全部調定額の合計 = Decimal.ZERO;
    private Decimal 全て段階の特徴者数の合計 = Decimal.ZERO;
    private Decimal 全て段階の普徴者数の合計 = Decimal.ZERO;
    private Decimal 全て段階の内併徴者数の合計 = Decimal.ZERO;
}
