/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * バッチ処理で作成した帳票用Entityリスト
 */
@lombok.Getter
@lombok.Setter
public class NendoDataEntity {

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
     * 第1期の調定額の小計
     */
    private Decimal dai1kiChoteigakuCount;
    /**
     * 第2期の調定額の小計
     */
    private Decimal dai2kiChoteigakuCount;
    /**
     * 第3期の調定額の小計
     */
    private Decimal dai3kiChoteigakuCount;
    /**
     * 第4期の調定額の小計
     */
    private Decimal dai4kiChoteigakuCount;
    /**
     * 第5期の調定額の小計
     */
    private Decimal dai5kiChoteigakuCount;
    /**
     * 第6期の調定額の小計
     */
    private Decimal dai6kiChoteigakuCount;
    /**
     * 第7期の調定額の小計
     */
    private Decimal dai7kiChoteigakuCount;
    /**
     * 第8期の調定額の小計
     */
    private Decimal dai8kiChoteigakuCount;
    /**
     * 第9期の調定額の小計
     */
    private Decimal dai9kiChoteigakuCount;
    /**
     * 第10期の調定額の小計
     */
    private Decimal dai10kiChoteigakuCount;
    /**
     * 第11期の調定額の小計
     */
    private Decimal dai11kiChoteigakuCount;
    /**
     * 第12期の調定額の小計
     */
    private Decimal dai12kiChoteigakuCount;
    /**
     * 第13期の調定額の小計
     */
    private Decimal dai13kiChoteigakuCount;
    /**
     * 第14期の調定額の小計
     */
    private Decimal dai14kiChoteigakuCount;
    /**
     * List<段階小計>
     */
    private List<DankaiShokeiEntity> dankaiShokeiEntityList;
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
    private Decimal gennmennCount;
    /**
     * 減免の調定額
     */
    private Decimal gennmennChoteigaku;
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
    private Decimal fuSaishutsuKampuCoun;
    /**
     * 普徴歳出還付の調定額
     */
    private Decimal fuSaishutsuKampuChoteigaku;
    /**
     * 当月フラグ
     */
    private int dogetsuFlag;
    /**
     * 前月末の全部件数の合計
     */
    private Decimal zengetsusueZennbuKennsuuGokei;
    /**
     * 前月末の全部調定額の合計
     */
    private Decimal zengetsusueZennbuChoteigakuGokei;
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
    private Decimal dogetsusueZennbuKennsuuGokei;
    /**
     * 当月末の全部調定額の合計
     */
    private Decimal dogetsusueZennbuChoteigakuGokei;
    /**
     * 特徴者数の合計
     */
    private Decimal tokuchosyaSuuGokei;
    /**
     * 普徴者数の合計
     */
    private Decimal fuchosyaSuuGokei;
    /**
     * 内併徴者数の合計
     */
    private Decimal naiheisyaSuuGokei;

}
