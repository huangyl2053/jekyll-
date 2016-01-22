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
 *
 */
@lombok.Getter
public class ShokanbaraiJyokyoShokaiParameter {

    // 被保険者番号
    private final HihokenshaNo hiHokenshaNo;
    // サービス年月
    private final FlexibleYearMonth serviceTeikyoYM;
    // 整理番号
    private final RString seiriNo;
    // 様式番号
    private final RString yoshikiNo;
    // 事業者番号
    private final JigyoshaNo jigyoshaNo;
    // 明細番号
    private final RString meisaiNo;
    // 連番
    private final RString renban;
    // サービス種類コード　
    private final ServiceShuruiCode serviceShuruiCode;
    // サービス項目コード
    private final ServiceKomokuCode serviceKomokuCode;

    /**
     * 初期化
     *
     * @param hiHokenshaNo
     * @param serviceTeikyoYM
     * @param seiriNo
     * @param yoshikiNo
     * @param jigyoshaNo
     * @param meisaiNo
     * @param remban
     * @param serviceShuruiCode
     * @param serviceKomokuCode
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
