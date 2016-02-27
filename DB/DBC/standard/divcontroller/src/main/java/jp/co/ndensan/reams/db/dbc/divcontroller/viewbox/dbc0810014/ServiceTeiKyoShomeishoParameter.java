/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0810014;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 償還払い状況照会_サービス提供証明書画面のParameter
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class ServiceTeiKyoShomeishoParameter implements Serializable {

    private static final long serialVersionUID = 1L;

    private final HihokenshaNo hiHokenshaNo;
    private final FlexibleYearMonth serviceTeikyoYM;
    private final RString seiriNp;
    private final JigyoshaNo jigyoshaNo;
    private final RString jigyoshaNameKanji;
    private final RString meisaiNo;
    private final RString serviceYM;

    /**
     *
     * @param hiHokenshaNo HihokenshaNo
     * @param serviceTeikyoYM FlexibleYearMonth
     * @param seiriNp RString
     * @param jigyoshaNo JigyoshaNo
     * @param jigyoshaNameKanji RString
     * @param meisaiNo RString
     * @param serviceYM RString
     */
    public ServiceTeiKyoShomeishoParameter(HihokenshaNo hiHokenshaNo, FlexibleYearMonth serviceTeikyoYM,
            RString seiriNp, JigyoshaNo jigyoshaNo, RString jigyoshaNameKanji, RString meisaiNo, RString serviceYM) {
        this.hiHokenshaNo = hiHokenshaNo;
        this.serviceTeikyoYM = serviceTeikyoYM;
        this.seiriNp = seiriNp;
        this.jigyoshaNo = jigyoshaNo;
        this.jigyoshaNameKanji = jigyoshaNameKanji;
        this.meisaiNo = meisaiNo;
        this.serviceYM = serviceYM;
    }
}
