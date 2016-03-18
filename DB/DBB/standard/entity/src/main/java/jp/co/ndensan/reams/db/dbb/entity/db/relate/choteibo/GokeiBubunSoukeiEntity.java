/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 合計部分総計一時テーブル
 */
@lombok.Getter
@lombok.Setter
public class GokeiBubunSoukeiEntity implements IDbAccessable {

    /**
     * 徴収方法
     */
    private RString choshuHouhou;
    /**
     * 当月フラグ
     */
    private int dogetsuFlag;
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
