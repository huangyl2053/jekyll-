/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.syokanbaraihishikyushinseikette;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 償還払費申請検索キーのParameter
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class SyokanbaraihishikyushinseiketteParameter implements Serializable {

    private static final long serialVersionUID = 1L;
    private final HihokenshaNo hiHokenshaNo;
    private final FlexibleYearMonth serviceTeikyoYM;
    private final RString seiriNp;
    private final JigyoshaNo jigyoshaNo;
    private final RString yoshikiNo;
    private final RString meisaiNo;
    private final RString kyufuritsu;

    /**
     * SyokanbaraihishikyushinseiketteParameter
     *
     * @param hiHokenshaNo HihokenshaNo
     * @param serviceTeikyoYM FlexibleYearMonth
     * @param seiriNp RString
     * @param jigyoshaNo JigyoshaNo
     * @param yoshikiNo RString
     * @param meisaiNo RString
     * @param kyufuritsu RString
     */
    public SyokanbaraihishikyushinseiketteParameter(HihokenshaNo hiHokenshaNo, FlexibleYearMonth serviceTeikyoYM,
            RString seiriNp, JigyoshaNo jigyoshaNo, RString yoshikiNo, RString meisaiNo, RString kyufuritsu) {
        this.hiHokenshaNo = hiHokenshaNo;
        this.serviceTeikyoYM = serviceTeikyoYM;
        this.seiriNp = seiriNp;
        this.jigyoshaNo = jigyoshaNo;
        this.yoshikiNo = yoshikiNo;
        this.meisaiNo = meisaiNo;
        this.kyufuritsu = kyufuritsu;
    }
}
