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
 * 前月末の段階のデータEntityです。
 */
@lombok.Getter
@lombok.Setter
public class ZengatsuDankaiDataEntity {

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
     * 該当する段階の前月末の件数の小計
     */
    private Decimal zengetsusueKensuCount;
    /**
     * 該当する段階の前月末の件数の小計
     */
    private Decimal zengetsusueChoteigakuCount;
}
