/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 期別情報一時Entityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class KibetsuEntity implements IDbAccessable {

    /**
     * 調定年度
     */
    private FlexibleYear choteiNendo;
    /**
     * 賦課年度
     */
    private FlexibleYear fukaNendo;
    /**
     * 通知書番号
     */
    private TsuchishoNo tsuchishoNo;
    /**
     * 履歴番号
     */
    private Decimal rirekiNo;
    /**
     * 被保険者番号
     */
    private HihokenshaNo hihokenshaNo;
    /**
     * 徴収方法
     */
    private RString choshuHouhou;
    /**
     * 期
     */
    private int ki;
    /**
     * 調定ID
     */
    private Decimal choteiId;
    /**
     * 第1期の調定額
     */
    private Decimal dai1kiChoteiGaku;
    /**
     * 第2期の調定額
     */
    private Decimal dai2kiChoteiGaku;
    /**
     * 第3期の調定額
     */
    private Decimal dai3kiChoteiGaku;
    /**
     * 第4期の調定額
     */
    private Decimal dai4kiChoteiGaku;
    /**
     * 第5期の調定額
     */
    private Decimal dai5kiChoteiGaku;
    /**
     * 第6期の調定額
     */
    private Decimal dai6kiChoteiGaku;
    /**
     * 第7期の調定額
     */
    private Decimal dai7kiChoteiGaku;
    /**
     * 第8期の調定額
     */
    private Decimal dai8kiChoteiGaku;
    /**
     * 第9期の調定額
     */
    private Decimal dai9kiChoteiGaku;
    /**
     * 第10期の調定額
     */
    private Decimal dai10kiChoteiGaku;
    /**
     * 第11期の調定額
     */
    private Decimal dai11kiChoteiGaku;
    /**
     * 第12期の調定額
     */
    private Decimal dai12kiChoteiGaku;
    /**
     * 第13期の調定額
     */
    private Decimal dai13kiChoteiGaku;
    /**
     * 第14期の調定額
     */
    private Decimal dai14kiChoteiGaku;
}
