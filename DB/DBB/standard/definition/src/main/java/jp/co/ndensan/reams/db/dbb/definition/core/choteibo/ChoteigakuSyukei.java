/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.core.choteibo;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 段階調定額集計クラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChoteigakuSyukei {

    private FlexibleYear 調定年度 = FlexibleYear.EMPTY;
    private FlexibleYear 賦課年度 = FlexibleYear.EMPTY;
    private Decimal 特別徴収当月末の調定額集計 = Decimal.ZERO;
    private Decimal 特別徴収前月末の調定額集計 = Decimal.ZERO;
    private Decimal 普通徴収当月末の調定額集計 = Decimal.ZERO;
    private Decimal 普通徴収前月末の調定額集計 = Decimal.ZERO;
}
