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
 * 期別部分のデータEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class KibetsuBubunDataEntity {

    /**
     * 調定年度
     */
    private FlexibleYear choteiNendo;
    /**
     * 徴収方法
     */
    private RString choshuHouhou;

    /**
     * 特別徴収の調定額の総計
     */
    private Decimal tobetsuChoteigakuSoukei;
    /**
     * 普通徴収の調定額の総計
     */
    private Decimal futsuChoteigakuSoukei;
    /**
     * 特徴と普徴の総計
     */
    private Decimal tobetsuTofutsuChoteigakuSoukei;
    /**
     * 減免の件数の総計
     */
    private Decimal genmenSoukei;
    /**
     * 減免の調定額の総計
     */
    private Decimal genmenChoteigakuSoukei;
    /**
     * 特徴歳出還付の件数の総計
     */
    private Decimal tkSaishutsuKampuSoukei;
    /**
     * 特徴歳出還付の調定額の総計
     */
    private Decimal tkSaishutsuKampuChoteigakuSoukei;
    /**
     * 普徴歳出還付の件数の総計
     */
    private Decimal fuSaishutsuKampuSoukei;
    /**
     * 普徴歳出還付の調定額の総計
     */
    private Decimal fuSaishutsuKampuChoteigakuSoukei;
}
