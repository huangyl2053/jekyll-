/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.jutakukaishusikyushinsei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 償還払支給申請MyBatisパラメータクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class UpShokanShinseiParameter {

    private final HihokenshaNo 被保険者番号;
    private final FlexibleYearMonth サービス提供年月;
    private final RString 整理番号;
    private final RString 支給申請審査区分;
    private final RString 審査方法区分;
    private final FlexibleDate 審査年月日;
    private final RString 審査結果;

    /**
     * コンストラクタです。
     *
     */
    private UpShokanShinseiParameter(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            RString 支給申請審査区分,
            RString 審査方法区分,
            FlexibleDate 審査年月日,
            RString 審査結果) {
        this.被保険者番号 = 被保険者番号;
        this.サービス提供年月 = サービス提供年月;
        this.整理番号 = 整理番号;
        this.支給申請審査区分 = 支給申請審査区分;
        this.審査方法区分 = 審査方法区分;
        this.審査年月日 = 審査年月日;
        this.審査結果 = 審査結果;
    }

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 支給申請審査区分
     * @param 審査方法区分
     * @param 審査年月日
     * @param 審査結果
     * @return
     */
    public static UpShokanShinseiParameter createSelectByKeyParam(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            RString 支給申請審査区分,
            RString 審査方法区分,
            FlexibleDate 審査年月日,
            RString 審査結果) {
        return new UpShokanShinseiParameter(被保険者番号, サービス提供年月, 整理番号, 支給申請審査区分,
                審査方法区分, 審査年月日, 審査結果);
    }
}
