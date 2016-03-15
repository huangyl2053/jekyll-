/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0600011;

import java.io.Serializable;
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
    private final RString teikyoYM;
    private final RString serialNo;
    private final RString jigyosyaNo;
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
    public PnlTotalParameter(RString hiHokenshaNo, RString teikyoYM,
            RString serialNo, RString jigyosyaNo, RString yoshikiNo, RString meisaiNo) {
        this.hiHokenshaNo = hiHokenshaNo;
        this.teikyoYM = teikyoYM;
        this.serialNo = serialNo;
        this.jigyosyaNo = jigyosyaNo;
        this.yoshikiNo = yoshikiNo;
        this.meisaiNo = meisaiNo;

    }

}
