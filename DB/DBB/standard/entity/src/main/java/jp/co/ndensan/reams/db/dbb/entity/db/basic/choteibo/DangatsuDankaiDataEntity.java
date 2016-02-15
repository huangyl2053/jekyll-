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
 * 当月末の段階のデータEntityです。
 */
@lombok.Getter
@lombok.Setter
public class DangatsuDankaiDataEntity {

    /**
     * 調定年度
     */
    private FlexibleYear choteiNendo;
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
     * 該当する段階の当月末の件数の小計
     */
    private Decimal dogetsusueKensuCount;
    /**
     * 該当する段階の当月末の調定額の小計
     */
    private Decimal dogetsusueChoteigakuCount;
    /**
     * 該当する段階の増の件数の小計
     */
    private Decimal fueKensuCount;
    /**
     * 該当する段階の増の調定額の小計
     */
    private Decimal fueChoteigakuCount;
    /**
     * 該当する段階の減の件数の小計
     */
    private Decimal genKensuCount;
    /**
     * 該当する段階の減の調定額の小計
     */
    private Decimal genChoteigakuCount;
}
