/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0600011;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 福祉用具購入費支給申請_検索のParameterです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class PnlTotalParameter implements Serializable {

    private static final long serialVersionUID = -6680438140785085186L;

    private final HihokenshaNo hiHokenshaNo;
    private final FlexibleYearMonth teikyoYM;
    private final RString serialNo;
    private final JigyoshaNo jigyosyaNo;
    private final RString yoshikiNo;
    private final RString meisaiNo;

    /**
     *
     * @param hiHokenshaNo hiHokenshaNo
     * @param teikyoYM teikyoYM
     * @param serialNo serialNo
     * @param jigyosyaNo jigyosyaNo
     * @param yoshikiNo yoshikiNo
     * @param meisaiNo meisaiNo
     */
    public PnlTotalParameter(HihokenshaNo hiHokenshaNo, FlexibleYearMonth teikyoYM,
            RString serialNo, JigyoshaNo jigyosyaNo, RString yoshikiNo, RString meisaiNo) {
        this.hiHokenshaNo = hiHokenshaNo;
        this.teikyoYM = teikyoYM;
        this.serialNo = serialNo;
        this.jigyosyaNo = jigyosyaNo;
        this.yoshikiNo = yoshikiNo;
        this.meisaiNo = meisaiNo;

    }

}
