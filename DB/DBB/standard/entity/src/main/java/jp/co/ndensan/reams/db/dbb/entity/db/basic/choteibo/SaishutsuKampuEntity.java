/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 歳出還付Entityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class SaishutsuKampuEntity {

    /**
     * 調定年度
     */
    private FlexibleYear choteiNendo;
    /**
     * 賦課年度
     */
    private FlexibleYear fukaNendo;
    /**
     * 特徴歳出還付の件数
     */
    private Decimal tkSaishutsuKampuCount;
    /**
     * 特徴歳出還付の調定額
     */
    private Decimal tkSaishutsuKampuChoteiGaku;
    /**
     * 普徴歳出還付の件数
     */
    private Decimal fuSaishutsuKampuCount;
    /**
     * 普徴歳出還付の調定額
     */
    private Decimal fuSaishutsuKampuChoteiGaku;
}
