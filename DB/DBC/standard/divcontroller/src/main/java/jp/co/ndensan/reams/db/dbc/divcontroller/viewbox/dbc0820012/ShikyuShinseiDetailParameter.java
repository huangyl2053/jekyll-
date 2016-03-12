/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0820012;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 償還払費申請検索キーParameter
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class ShikyuShinseiDetailParameter implements Serializable {

    private static final long serialVersionUID = 1L;
    private final HihokenshaNo hiHokenshaNo;
    private final FlexibleYearMonth serviceTeikyoYM;
    private final RString seiriNo;

    /**
     * ShikyuShinseiDetailParameter
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @param 整理番号 RString
     */
    public ShikyuShinseiDetailParameter(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月,
            RString 整理番号) {
        this.hiHokenshaNo = 被保険者番号;
        this.serviceTeikyoYM = サービス提供年月;
        this.seiriNo = 整理番号;
    }
}
