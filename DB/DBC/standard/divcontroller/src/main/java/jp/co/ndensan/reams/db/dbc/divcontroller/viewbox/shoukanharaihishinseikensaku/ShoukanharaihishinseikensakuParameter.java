/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;

/**
 * 償還払費申請検索キーのParameter。
 *
 * @reamsid_L DBC-1030-020 wangkanglei
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class ShoukanharaihishinseikensakuParameter implements Serializable {

    private static final long serialVersionUID = 1L;
    private final HihokenshaNo hiHokenshaNo;
    private final FlexibleYearMonth serviceTeikyoYM;
    private final RString seiriNp;
    private final JigyoshaNo jigyoshaNo;
    private final RString yoshikiNo;
    private final RString meisaiNo;
    private final Decimal kyufuritsu;

    /**
     * コンストラクタです。
     *
     * @param hiHokenshaNo 被保険者番号
     * @param serviceTeikyoYM サービス年月
     * @param seiriNp 整理番号
     * @param jigyoshaNo 事業者番号
     * @param yoshikiNo 様式番号
     * @param meisaiNo 明細番号
     * @param kyufuritsu 給付率
     */
    public ShoukanharaihishinseikensakuParameter(HihokenshaNo hiHokenshaNo, FlexibleYearMonth serviceTeikyoYM,
            RString seiriNp, JigyoshaNo jigyoshaNo, RString yoshikiNo, RString meisaiNo, Decimal kyufuritsu) {
        this.hiHokenshaNo = hiHokenshaNo;
        this.serviceTeikyoYM = serviceTeikyoYM;
        this.seiriNp = seiriNp;
        this.jigyoshaNo = jigyoshaNo;
        this.yoshikiNo = yoshikiNo;
        this.meisaiNo = meisaiNo;
        this.kyufuritsu = kyufuritsu;
    }
}
