/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0820012;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import lombok.Getter;

/**
 * 償還払費申請検索キーParameter
 *
 * @reamsid_L DBC-1030-160 xupeng
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class ShikyuShinseiDetailParameter implements Serializable {

    private static final long serialVersionUID = 1L;
    private final RString 処理モード;
    private final RString 被保険者番号;
    private final RYearMonth サービス提供年月;
    private final RString 整理番号;
    private final RString 申請日;

    /**
     * ShikyuShinseiDetailParameter
     *
     * @param 処理モード RString
     * @param 被保険者番号 RString
     * @param サービス提供年月 RYearMonth
     * @param 整理番号 RString
     * @param 申請日 RString
     */
    public ShikyuShinseiDetailParameter(RString 処理モード, RString 被保険者番号, RYearMonth サービス提供年月,
            RString 整理番号, RString 申請日) {
        this.処理モード = 処理モード;
        this.被保険者番号 = 被保険者番号;
        this.サービス提供年月 = サービス提供年月;
        this.整理番号 = 整理番号;
        this.申請日 = 申請日;
    }
}
