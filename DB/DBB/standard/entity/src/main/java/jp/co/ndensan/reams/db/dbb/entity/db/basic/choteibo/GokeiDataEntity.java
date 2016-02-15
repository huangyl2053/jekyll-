/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * バッチ処理で作成した帳票用Entityリスト 合計データリスト
 */
@lombok.Getter
@lombok.Setter
public class GokeiDataEntity {

    /**
     * 徴収方法
     */
    private RString choshuHouhou;
    /**
     * 当月フラグ
     */
    private int dogetsuFlag;
    /**
     * 1月の調定額の小計
     */
    private Decimal itigatuChoteigakuCount;
    /**
     * 2月の調定額の小計
     */
    private Decimal nigatuChoteigakuCount;
    /**
     * 3月の調定額の小計
     */
    private Decimal sanngatuChoteigakuCount;
    /**
     * 4月の調定額の小計
     */
    private Decimal sigatuChoteigakuCount;
    /**
     * 5月の調定額の小計
     */
    private Decimal gogatuChoteigakuCount;
    /**
     * 6月の調定額の小計
     */
    private Decimal rokugatsuChoteigakuCount;
    /**
     * 7月の調定額の小計
     */
    private Decimal shichigatuChoteigakuCount;
    /**
     * 8月の調定額の小計
     */
    private Decimal hachigatuChoteigakuCount;
    /**
     * 9月の調定額の小計
     */
    private Decimal kugatuChoteigakuCount;
    /**
     * 10月の調定額の小計
     */
    private Decimal jyuugatuChoteigakuCount;
    /**
     * 11月の調定額の小計
     */
    private Decimal jyuuitigatuChoteigakuCount;
    /**
     * 12月の調定額の小計
     */
    private Decimal juunigatuChoteigakuCount;
    /**
     * 4月の調定額の小計(翌)
     */
    private Decimal sigatuChoteigakuCountYoku;
    /**
     * 5月の調定額の小計(翌)
     */
    private Decimal gogatuChoteigakuCountYoku;
    /**
     * List<合計の段階>
     */
    private List<DankaiGokeiEntity> dankaiGokeigoEntityList;
    /**
     * 特別徴収の調定額の総計
     */
    private Decimal tobetsuChoteiGakuSoukei;
    /**
     * 普通徴収の調定額の総計
     */
    private Decimal futsuChoteigakuSouket;
    /**
     * 特徴と普徴の総計
     */
    private Decimal tobetsuTofutsuChoteiGakuSouket;
    /**
     * 前月末の全部件数の総計
     */
    private Decimal zengetsusueZennbuKennsuuSouket;
    /**
     * 前月末の全部調定額の総計
     */
    private Decimal zengetsusueZennbuChoteigakuSouket;
    /**
     * 増の全部件数の総計
     */
    private Decimal fueZennbuKennsuuSouket;
    /**
     * 増の全部調定額の総計
     */
    private Decimal fueZennbuChoteigakuSouket;
    /**
     * 減の全部件数の総計
     */
    private Decimal genZennbuKennsuuSouket;
    /**
     * 減の全部調定額の総計
     */
    private Decimal genZennbuChoteigakuSouket;
    /**
     * 当月末の全部件数の総計
     */
    private Decimal dogetsusueZennbuKennsuuSouket;
    /**
     * 当月末の全部調定額の総計
     */
    private Decimal dogetsusueZennbuChoteigakuSouket;
    /**
     * 特徴者数の総計
     */
    private Decimal tokuchosyaSuuSouket;
    /**
     * 普徴者数の総計
     */
    private Decimal fuchosyaSuuSouket;
    /**
     * 内併徴者数の総計
     */
    private Decimal naiheisyaSuuSouket;
    /**
     * 減免の件数の総計
     */
    private Decimal gennmennCountSouket;
    /**
     * 減免の調定額の総計
     */
    private Decimal gennmennChoteiGakuSouket;
    /**
     * 特徴歳出還付の件数の総計
     */
    private Decimal tkSaishutsuKampuCountSouket;
    /**
     * 特徴歳出還付の調定額の総計
     */
    private Decimal tkSaishutsuKampuChoteiGakuSouket;
    /**
     * 普徴歳出還付の件数の総計
     */
    private Decimal fuSaishutsuKampuCounSouket;
    /**
     * 普徴歳出還付の調定額の総計
     */
    private Decimal fuSaishutsuKampuChoteiGakuSouket;
}
