/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;

/**
 * 時効起算日管理の識別子です。
 *
 * @reamsid_L DBD-9999-013 huangh
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class JikoKisambiKanriIdentifier implements Serializable {

    private final ShoKisaiHokenshaNo 証記載保険者番号;
    private final HihokenshaNo 被保険者番号;
    private final RYear 調定年度;
    private final RYear 賦課年度;
    private final RString 特徴_普徴区分;
    private final TsuchishoNo 通知書番号;
    private final RString 収納期_月;
    private final int 履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 特徴_普徴区分 特徴_普徴区分
     * @param 通知書番号 通知書番号
     * @param 収納期_月 収納期_月
     * @param 履歴番号 履歴番号
     */
    public JikoKisambiKanriIdentifier(ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            RYear 調定年度,
            RYear 賦課年度,
            RString 特徴_普徴区分,
            TsuchishoNo 通知書番号,
            RString 収納期_月,
            int 履歴番号) {
        this.証記載保険者番号 = 証記載保険者番号;
        this.被保険者番号 = 被保険者番号;
        this.調定年度 = 調定年度;
        this.賦課年度 = 賦課年度;
        this.特徴_普徴区分 = 特徴_普徴区分;
        this.通知書番号 = 通知書番号;
        this.収納期_月 = 収納期_月;
        this.履歴番号 = 履歴番号;
    }
}
