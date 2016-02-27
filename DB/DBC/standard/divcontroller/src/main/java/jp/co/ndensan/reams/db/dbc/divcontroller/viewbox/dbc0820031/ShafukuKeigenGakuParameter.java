/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0820031;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * @author yebangqiang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class ShafukuKeigenGakuParameter implements Serializable {

    private static final long serialVersionUID = -6680438140785085186L;

    private final RString hiHokenshaNo;
    private final RDate serviceTeikyoYM;
    private final RString seiriNp;
    private final RString jigyoshaNo;
    private final RString yoshikiNo;
    private final RString meisaiNo;

    /**
     * ShafukuKeigenGakuParameter
     *
     * @param hiHokenshaNo hiHokenshaNo
     * @param serviceTeikyoYM serviceTeikyoYM
     * @param seiriNp seiriNp
     * @param jigyoshaNo jigyoshaNo
     * @param yoshikiNo yoshikiNo
     * @param meisaiNo meisaiNo
     */
    public ShafukuKeigenGakuParameter(RString hiHokenshaNo, RDate serviceTeikyoYM, RString seiriNp, RString jigyoshaNo, RString yoshikiNo, RString meisaiNo) {
        this.hiHokenshaNo = hiHokenshaNo;
        this.serviceTeikyoYM = serviceTeikyoYM;
        this.seiriNp = seiriNp;
        this.jigyoshaNo = jigyoshaNo;
        this.yoshikiNo = yoshikiNo;
        this.meisaiNo = meisaiNo;
    }

}
