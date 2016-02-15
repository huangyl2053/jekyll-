/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jutakukaishusikyushinsei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払支給申請情報取得MyBatisパラメータクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JutakukaishuSikyuShinseiKey {

    private final HihokenshaNo 被保険者番号;
    private final FlexibleYearMonth サービス提供年月;
    private final RString 整理番号;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     */
    protected JutakukaishuSikyuShinseiKey(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月,
            RString 整理番号) {
        this.被保険者番号 = 被保険者番号;
        this.サービス提供年月 = サービス提供年月;
        this.整理番号 = 整理番号;

    }

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @return
     */
    public static JutakukaishuSikyuShinseiKey createSelectByKeyParam(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 整理番号) {
        return new JutakukaishuSikyuShinseiKey(被保険者番号, サービス提供年月, 整理番号);
    }

}
