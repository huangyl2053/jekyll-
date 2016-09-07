/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.taino;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 支払方法変更滞納の識別子です。
 *
 * @reamsid_L DBD-9999-013 huangh
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class ShiharaiHohoHenkoTainoIdentifier implements Serializable {

    private final ShoKisaiHokenshaNo 証記載保険者番号;
    private final HihokenshaNo 被保険者番号;
    private final RString 管理区分;
    private final int 履歴番号;
    private final RString 滞納判定区分;
    private final int 連番;
    private final FlexibleYear 調定年度;
    private final FlexibleYear 賦課年度;
    private final TsuchishoNo 通知書番号;
    private final RString 特徴_普徴区分;
    private final RString 収納期_月;

    /**
     * コンストラクタです。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 管理区分 管理区分
     * @param 履歴番号 履歴番号
     * @param 滞納判定区分 滞納判定区分
     * @param 連番 連番
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param 特徴_普徴区分 特徴_普徴区分
     * @param 収納期_月 収納期_月
     */
    public ShiharaiHohoHenkoTainoIdentifier(ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            RString 管理区分,
            int 履歴番号,
            RString 滞納判定区分,
            int 連番,
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号,
            RString 特徴_普徴区分,
            RString 収納期_月) {
        this.証記載保険者番号 = 証記載保険者番号;
        this.被保険者番号 = 被保険者番号;
        this.管理区分 = 管理区分;
        this.履歴番号 = 履歴番号;
        this.滞納判定区分 = 滞納判定区分;
        this.連番 = 連番;
        this.調定年度 = 調定年度;
        this.賦課年度 = 賦課年度;
        this.通知書番号 = 通知書番号;
        this.特徴_普徴区分 = 特徴_普徴区分;
        this.収納期_月 = 収納期_月;
    }
    private static final long serialVersionUID = -6998094535184347002L;
}
