/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0600011;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class PnlTotalParameter implements Serializable {

    private static final long serialVersionUID = -6680438140785085186L;

    private final RString hiHokenshaNo;
    private final FlexibleDate serviceTeikyoYM;
    private final RString seiriNp;
    private final RString jigyoshaNo;
    private final RString yoshikiNo;
    private final RString meisaiNo;

    /**
     *
     * @param hiHokenshaNo
     * @param serviceTeikyoYM
     * @param seiriNp
     * @param jigyoshaNo
     * @param yoshikiNo
     * @param meisaiNo
     */
    public PnlTotalParameter(RString hiHokenshaNo, FlexibleDate serviceTeikyoYM,
            RString seiriNp, RString jigyoshaNo, RString yoshikiNo, RString meisaiNo) {
        this.hiHokenshaNo = hiHokenshaNo;
        this.serviceTeikyoYM = serviceTeikyoYM;
        this.seiriNp = seiriNp;
        this.jigyoshaNo = jigyoshaNo;
        this.yoshikiNo = yoshikiNo;
        this.meisaiNo = meisaiNo;

    }

}
