/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigoservicehikyufutaishoshatoroku;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;

/**
 * 高額介護サービス費給付額算出のバックアップ用MyBatisパラメータクラスです。
 *
 * @reamsid_L DBC-2010-070 tianshuai
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class KogakuKaigoServicehiKyufugakuSanshutsuParameter {

    private final HihokenshaNo 被保険者番号;
    private final FlexibleYearMonth 年月From;
    private final FlexibleYearMonth 年月To;
    private final FlexibleYearMonth 処理年月;
    private final FlexibleYearMonth サービス年月;
    private final LasdecCode 市町村コード;

    private KogakuKaigoServicehiKyufugakuSanshutsuParameter(HihokenshaNo 被保険者番号, FlexibleYearMonth 年月From,
            FlexibleYearMonth 年月To, FlexibleYearMonth 処理年月, FlexibleYearMonth サービス年月, LasdecCode 市町村コード) {
        this.被保険者番号 = 被保険者番号;
        this.年月From = 年月From;
        this.年月To = 年月To;
        this.処理年月 = 処理年月;
        this.サービス年月 = サービス年月;
        this.市町村コード = 市町村コード;
    }

    /**
     * 高額介護サービス費給付額算出のバックアップパラメータ作成
     *
     * @param 被保険者番号 被保険者番号
     * @param 年月From 年月From
     * @param 年月To 年月To
     * @param 処理年月 処理年月
     * @param サービス年月 サービス年月
     * @param 市町村コード 市町村コード
     * @return KogakuKaigoServicehiKyufugakuSanshutsuParameter
     */
    public static KogakuKaigoServicehiKyufugakuSanshutsuParameter createParameter(HihokenshaNo 被保険者番号, FlexibleYearMonth 年月From,
            FlexibleYearMonth 年月To, FlexibleYearMonth 処理年月, FlexibleYearMonth サービス年月, LasdecCode 市町村コード) {
        return new KogakuKaigoServicehiKyufugakuSanshutsuParameter(被保険者番号, 年月From, 年月To, 処理年月, サービス年月, 市町村コード);
    }
}
