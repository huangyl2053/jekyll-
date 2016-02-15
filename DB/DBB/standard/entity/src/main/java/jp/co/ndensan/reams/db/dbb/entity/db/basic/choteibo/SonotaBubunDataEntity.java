/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * その他部分のデータEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class SonotaBubunDataEntity {

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
     * 前月末の全部件数の総計
     */
    private Decimal zengetsusueKensuSoukei;
    /**
     * 前月末の全部調定額の総計
     */
    private Decimal zengetsusueChoteigakuSoukei;
    /**
     * 増の全部件数の総計
     */
    private Decimal fueZennbuKennsuuSoukei;
    /**
     * 増の全部調定額の総計
     */
    private Decimal fueZennbuChoteigakuSoukei;
    /**
     * 減の全部件数の総計
     */
    private Decimal genZennbuKennsuuSoukei;
    /**
     * 減の全部調定額の総計
     */
    private Decimal genZennbuChoteigakuSoukei;
    /**
     * 当月末の全部件数の総計
     */
    private Decimal dogetsusueKensuSoukei;
    /**
     * 当月末の全部調定額の総計
     */
    private Decimal dogetsusueChoteigakuSoukei;
    /**
     * 特徴者数の総計
     */
    private Decimal tokuchosyaKensuSoukei;
    /**
     * 普徴者数の総計
     */
    private Decimal fuchosyaKensuSoukei;
    /**
     * 内併徴者数の総計
     */
    private Decimal naiheisyaKensuSoukei;
}
