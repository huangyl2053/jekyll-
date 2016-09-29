/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigokyufuhitaishoshatoroku;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc710100.HanyoListKagoKekkaMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigoservicehikyufutaishoshatoroku.KyufuJissekiKihonKogakuMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigoservicehikyufutaishoshatoroku.UpdKogakuKokuhorenIFMstMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;

/**
 *
 * 高額介護サービス費給付対象者登録のProcess用パラメータクラスです。
 *
 * @reamsid_L DBC-2010-040 huzongcheng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuKaigoKyufuhiTaishoshaTorokuProcessParameter implements IBatchProcessParameter {

    private Long shuturyokuJunn;
    private FlexibleYearMonth shinsaYMFrom;
    private FlexibleYearMonth shinsaYMTo;
    private boolean shuturyokuFlg;
    private FlexibleYearMonth sysYearMonth;
    private YMDHMS sysDate;

    /**
     * コンストラクタです。
     *
     *
     * @param shuturyokuJunn RString
     * @param shinsaYMFrom FlexibleYearMonth
     * @param shinsaYMTo FlexibleYearMonth
     * @param shuturyokuFlg boolean
     */
    public KogakuKaigoKyufuhiTaishoshaTorokuProcessParameter(
            Long shuturyokuJunn,
            FlexibleYearMonth shinsaYMFrom,
            FlexibleYearMonth shinsaYMTo,
            boolean shuturyokuFlg) {
        this.shuturyokuJunn = shuturyokuJunn;
        this.shinsaYMFrom = shinsaYMFrom;
        this.shinsaYMTo = shinsaYMTo;
        this.shuturyokuFlg = shuturyokuFlg;
    }

    /**
     * コンストラクタです。
     */
    public KogakuKaigoKyufuhiTaishoshaTorokuProcessParameter() {
    }

    /**
     * toMyBatisParameterのメソッドです。
     *
     * @return {@link HanyoListKagoKekkaMybatisParameter}
     */
    public KyufuJissekiKihonKogakuMybatisParameter toMybatisParameter() {
        KyufuJissekiKihonKogakuMybatisParameter parameter = new KyufuJissekiKihonKogakuMybatisParameter();
        parameter.set最新のサービス提供年月(shinsaYMFrom);
        parameter.set最古のサービス提供年月(shinsaYMTo);
        return parameter;
    }

    /**
     * toMyBatisParameterのメソッドです。
     *
     * @return {@link UpdKogakuKokuhorenIFMstMybatisParameter}
     */
    public UpdKogakuKokuhorenIFMstMybatisParameter toCreateUpdKogakuKokuhorenIFMstMybatisParameter() {
        return new UpdKogakuKokuhorenIFMstMybatisParameter(shinsaYMFrom, shinsaYMTo, sysYearMonth, sysDate);
    }
}
