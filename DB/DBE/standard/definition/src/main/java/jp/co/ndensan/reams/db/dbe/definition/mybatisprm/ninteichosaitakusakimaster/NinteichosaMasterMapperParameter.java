/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosaitakusakimaster;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * その他機関マスタ用パラメータクラスです。
 *
 * @reamsid_L DBE-1360-010 suguangjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class NinteichosaMasterMapperParameter {

    private final boolean 廃止フラグ;
    private final ShoKisaiHokenshaNo 保険者;
    private final RString 機関コードFrom;
    private final RString 機関コードTo;
    private final RString 機関名称;
    private final RString 機関カナ名称;
    private final RString 調査委託区分;
    private final RString 機関の区分;
    private final Decimal 最大表示件数;

    private final boolean user保険者;
    private final boolean user機関コードFrom;
    private final boolean user機関コードTo;
    private final boolean user機関名称;
    private final boolean user機関カナ名称;
    private final boolean user調査委託区分;
    private final boolean user機関の区分;
    private final boolean user最大表示件数;

    private NinteichosaMasterMapperParameter(
            boolean 廃止フラグ,
            ShoKisaiHokenshaNo 保険者,
            RString 機関コードFrom,
            RString 機関コードTo,
            RString 機関名称,
            RString 機関カナ名称,
            RString 調査委託区分,
            RString 機関の区分,
            Decimal 最大表示件数,
            boolean user保険者,
            boolean user機関コードFrom,
            boolean user機関コードTo,
            boolean user機関名称,
            boolean user機関カナ名称,
            boolean user調査委託区分,
            boolean user機関の区分,
            boolean user最大表示件数
    ) {
        this.廃止フラグ = 廃止フラグ;
        this.保険者 = 保険者;
        this.機関コードFrom = 機関コードFrom;
        this.機関コードTo = 機関コードTo;
        this.機関名称 = 機関名称;
        this.機関カナ名称 = 機関カナ名称;
        this.調査委託区分 = 調査委託区分;
        this.機関の区分 = 機関の区分;
        this.最大表示件数 = 最大表示件数;
        this.user保険者 = user保険者;
        this.user機関コードFrom = user機関コードFrom;
        this.user機関コードTo = user機関コードTo;
        this.user機関名称 = user機関名称;
        this.user機関カナ名称 = user機関カナ名称;
        this.user調査委託区分 = user調査委託区分;
        this.user機関の区分 = user機関の区分;
        this.user最大表示件数 = user最大表示件数;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param 廃止フラグ 廃止フラグ
     * @param 保険者 保険者
     * @param 機関コードFrom 機関コードFrom
     * @param 機関コードTo 機関コードTo
     * @param 機関名称 機関名称
     * @param 機関カナ名称 機関カナ名称
     * @param 調査委託区分 調査委託区分
     * @param 機関の区分 機関の区分
     * @param 最大表示件数 最大表示件数
     * @return 主治医マスタ検索パラメータ
     */
    public static NinteichosaMasterMapperParameter createSelectByKeyParam(
            boolean 廃止フラグ,
            ShoKisaiHokenshaNo 保険者,
            RString 機関コードFrom,
            RString 機関コードTo,
            RString 機関名称,
            RString 機関カナ名称,
            RString 調査委託区分,
            RString 機関の区分,
            Decimal 最大表示件数
    ) {
        return new NinteichosaMasterMapperParameter(廃止フラグ,
                保険者,
                機関コードFrom,
                機関コードTo,
                機関名称,
                機関カナ名称,
                調査委託区分,
                機関の区分,
                最大表示件数,
                保険者 != null && !保険者.isEmpty(),
                機関コードFrom != null && !機関コードFrom.isEmpty(),
                機関コードTo != null && !機関コードTo.isEmpty(),
                機関名称 != null && !機関名称.isEmpty(),
                機関カナ名称 != null && !機関カナ名称.isEmpty(),
                調査委託区分 != null && !調査委託区分.isEmpty(),
                機関の区分 != null && !機関の区分.isEmpty(),
                最大表示件数 != null
        );
    }
}
