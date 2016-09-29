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
    private FlexibleYearMonth 最新のサービス提供年月;
    private FlexibleYearMonth 最古のサービス提供年月;

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
     *
     * @param 最古のサービス提供年月 FlexibleYearMonth
     * @param 最新のサービス提供年月 FlexibleYearMonth
     */
    public KogakuKaigoKyufuhiTaishoshaTorokuProcessParameter(
            FlexibleYearMonth 最新のサービス提供年月,
            FlexibleYearMonth 最古のサービス提供年月) {
        this.最新のサービス提供年月 = 最新のサービス提供年月;
        this.最古のサービス提供年月 = 最古のサービス提供年月;
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
        parameter.set最新のサービス提供年月(最新のサービス提供年月);
        parameter.set最古のサービス提供年月(最古のサービス提供年月);
        return parameter;
    }

    /**
     * toMyBatisParameterのメソッドです。
     *
     * @return {@link UpdKogakuKokuhorenIFMstMybatisParameter}
     */
    public UpdKogakuKokuhorenIFMstMybatisParameter toCreateUpdKogakuKokuhorenIFMstMybatisParameter() {
        return new UpdKogakuKokuhorenIFMstMybatisParameter(sysYearMonth, sysDate);
    }
}
