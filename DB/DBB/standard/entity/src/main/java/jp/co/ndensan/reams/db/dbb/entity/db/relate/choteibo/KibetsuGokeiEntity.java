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
 * 期別合計一時Entityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class KibetsuGokeiEntity {

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
     * 特別徴収の調定額の合計
     */
    private Decimal tobetsuChoteigakuCount;
    /**
     * 普通徴収の調定額の合計
     */
    private Decimal futsuChoteigakuCount;
    /**
     * 特徴と普徴の合計
     */
    private Decimal tobetsuTofutsuChoteigakuCount;
    /**
     * 減免の件数
     */
    private Decimal genmenCount;
    /**
     * 減免の調定額
     */
    private Decimal genmenChoteigaku;
    /**
     * 特徴歳出還付の件数
     */
    private Decimal tkSaishutsuKampuCount;
    /**
     * 特徴歳出還付の調定額
     */
    private Decimal tkSaishutsuKampuChoteigaku;
    /**
     * 普徴歳出還付の件数
     */
    private Decimal fuSaishutsuKampuCount;
    /**
     * 普徴歳出還付の調定額
     */
    private Decimal fuSaishutsuKampuChoteigaku;
}
