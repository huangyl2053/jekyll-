/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanbaraijyokyoshokai;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払決定一覧検索用MyBatisパラメータクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ShokanbaraiJyokyoShokaiParameter {

    private final HihokenshaNo hiHokenshaNo;
    private final FlexibleYearMonth serviceTeikyoYM;
    private final RString seiriNo;
    private final RString yoshikiNo;
    private final JigyoshaNo jigyoshaNo;
    private final RString meisaiNo;
    private final RString renban;
    private final ServiceShuruiCode serviceShuruiCode;
    private final ServiceKomokuCode serviceKomokuCode;

    /**
     * 初期化
     *
     * @param hiHokenshaNo HihokenshaNo
     * @param serviceTeikyoYM FlexibleYearMonth
     * @param seiriNo RString
     * @param yoshikiNo RString
     * @param jigyoshaNo JigyoshaNo
     * @param meisaiNo RString
     * @param remban RString
     * @param serviceShuruiCode ServiceShuruiCode
     * @param serviceKomokuCode ServiceKomokuCode
     */
    private ShokanbaraiJyokyoShokaiParameter(
            HihokenshaNo hiHokenshaNo,
            FlexibleYearMonth serviceTeikyoYM,
            RString seiriNo,
            RString yoshikiNo,
            JigyoshaNo jigyoshaNo,
            RString meisaiNo,
            RString renban,
            ServiceShuruiCode serviceShuruiCode,
            ServiceKomokuCode serviceKomokuCode
    ) {
        this.hiHokenshaNo = hiHokenshaNo;
        this.serviceTeikyoYM = serviceTeikyoYM;
        this.seiriNo = seiriNo;
        this.yoshikiNo = yoshikiNo;
        this.jigyoshaNo = jigyoshaNo;
        this.meisaiNo = meisaiNo;
        this.renban = renban;
        this.serviceShuruiCode = serviceShuruiCode;
        this.serviceKomokuCode = serviceKomokuCode;
    }

    /**
     * パラメータを生成します。
     *
     * @param hihokenshaNo HihokenshaNo
     * @param serviceTeikyoYM FlexibleYearMonth
     * @param seiriNo RString
     * @param yoshikiNo RString
     * @param jigyoshaNo JigyoshaNo
     * @param meisaiNo RString
     * @param renban RString
     * @param serviceShuruiCode ServiceShuruiCode
     * @param serviceKomokuCode ServiceKomokuCode
     * @return ShokanbaraiJyokyoShokaiParameter
     */
    public static ShokanbaraiJyokyoShokaiParameter createMybatisParam(
            HihokenshaNo hihokenshaNo,
            FlexibleYearMonth serviceTeikyoYM,
            RString seiriNo,
            RString yoshikiNo,
            JigyoshaNo jigyoshaNo,
            RString meisaiNo,
            RString renban,
            ServiceShuruiCode serviceShuruiCode,
            ServiceKomokuCode serviceKomokuCode
    ) {
        return new ShokanbaraiJyokyoShokaiParameter(
                hihokenshaNo,
                serviceTeikyoYM,
                seiriNo,
                yoshikiNo,
                jigyoshaNo,
                meisaiNo,
                renban,
                serviceShuruiCode,
                serviceKomokuCode
        );
    }
}
