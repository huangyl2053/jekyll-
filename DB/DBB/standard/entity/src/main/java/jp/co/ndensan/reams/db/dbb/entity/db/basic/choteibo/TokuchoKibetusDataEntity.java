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
 * 特別徴収期別のデータEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class TokuchoKibetusDataEntity {

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
     * 第1期の調定額の合計
     */
    private Decimal dai1kiChoteigakuGokei;
    /**
     * 第2期の調定額の合計
     */
    private Decimal dai2kiChoteigakuGokei;
    /**
     * 第3期の調定額の合計
     */
    private Decimal dai3kiChoteigakuGokei;
    /**
     * 第4期の調定額の合計
     */
    private Decimal dai4kiChoteigakuGokei;
    /**
     * 第5期の調定額の合計
     */
    private Decimal dai5kiChoteigakuGokei;
    /**
     * 第6期の調定額の合計
     */
    private Decimal dai6kiChoteigakuGokei;
}
