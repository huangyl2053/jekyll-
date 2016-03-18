/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 段階合計一時テーブルEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class DankaiGokeiEntity implements IDbAccessable {

    /**
     * 調定年度
     */
    private FlexibleYear choteiNendo;
    /**
     * 賦課年度
     */
    private FlexibleYear fukaNendo;
    /**
     * 徴収方法
     */
    private RString choshuHouhou;
    /**
     * 当月フラグ
     */
    private int dogetsuFlag;
    /**
     * 前月末の全部件数の合計
     */
    private Decimal zengetsusueKensuCount;
    /**
     * 前月末の全部調定額の合計
     */
    private Decimal zengetsusueChoteigakuCount;
    /**
     * 増の全部件数の合計
     */
    private Decimal fueZennbuKennsuuGokei;
    /**
     * 増の全部調定額の合計
     */
    private Decimal fueZennbuChoteigakuGokei;
    /**
     * 減の全部件数の合計
     */
    private Decimal genZennbuKennsuuGokei;
    /**
     * 減の全部調定額の合計
     */
    private Decimal genZennbuChoteigakuGokei;
    /**
     * 当月末の全部件数の合計
     */
    private Decimal dogetsusueKensuCount;
    /**
     * 当月末の全部調定額の合計
     */
    private Decimal dogetsusueChoteigakuCount;
    /**
     * 特徴者数の合計
     */
    private Decimal tokuchosyaKensuCount;
    /**
     * 普徴者数の合計
     */
    private Decimal fuchosyaKensuCount;
    /**
     * 内併徴者数の合計
     */
    private Decimal naiheisyaKensuCount;
}
