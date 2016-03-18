/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 段階情報一時Entityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class DanKaiEntity implements IDbAccessable {

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
     * 段階
     */
    private RString dankai;
    /**
     * 徴収方法
     */
    private RString choshuHouhou;
    /**
     * 調定ID
     */
    private Decimal choteiId;
    /**
     * 当月フラグ
     */
    private int dogetsuFlag;
    /**
     * 該当する段階の前月末の調定額
     */
    private Decimal zengetsusueChoteigaku;
    /**
     * 該当する段階の増の調定額
     */
    private Decimal fueChoteigaku;
    /**
     * 該当する段階の減の調定額
     */
    private Decimal genChoteigaku;
    /**
     * 該当する段階の当月末の調定額
     */
    private Decimal dogetsusueChoteigaku;

}
