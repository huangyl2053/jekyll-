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
 * 段階小計一時Entityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class DankaiShokeiEntity implements IDbAccessable {

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
     * 段階
     */
    private RString dankai;
    /**
     * 当月フラグ
     */
    private int dogetsuFlag;
    /**
     * 該当する段階の前月末の件数
     */
    private Decimal zengetsusueKensu;
    /**
     * 該当する段階の前月末の調定額の小計
     */
    private Decimal zengetsusueChoteigakuCount;
    /**
     * 該当する段階の増の件数
     */
    private Decimal fueKensu;
    /**
     * 該当する段階の増の調定額の小計
     */
    private Decimal fueChoteigakuCount;
    /**
     * 該当する段階の減の件数
     */
    private Decimal genKensu;
    /**
     * 該当する段階の減の調定額の小計
     */
    private Decimal genChoteigakuCount;
    /**
     * 該当する段階の当月末の件数
     */
    private Decimal dogetsusueKensu;
    /**
     * 該当する段階の当月末の調定額の小計
     */
    private Decimal dogetsusueChoteigakuCount;
    /**
     * 該当する段階の特徴者数の件数
     */
    private Decimal tokuchosyaKensu;
    /**
     * 該当する段階の普徴者数の件数
     */
    private Decimal fuchosyaKensu;
    /**
     * 該当する段階の内併徴者数の件数
     */
    private Decimal naiheisyaKensu;
}
