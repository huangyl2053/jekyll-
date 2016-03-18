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

/**
 * 期別のデータEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class KibetsuDataEntity {

    /**
     * 調定年度
     */
    private FlexibleYear choteiNendo;
    /**
     * 調定年度
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
     * 調定額
     */
    private Decimal choteigaku;
}
