/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 調定額の合計Entityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class ChoteigakuGokeiEntity {

    /**
     * 調定年度
     */
    private FlexibleYear choteiNendo;
    /**
     * 賦課年度
     */
    private FlexibleYear fukaNendo;
    /**
     * 段階
     */
    private RString dankai;
    /**
     * 件数の合計
     */
    private Decimal dankaiKensuGokei;
    /**
     * 増の全部調定額の合計
     */
    private Decimal fueZennbuChoteigakuGokei;
    /**
     * 減の全部調定額の合計
     */
    private Decimal genZennbuChoteigakuGokei;
}
