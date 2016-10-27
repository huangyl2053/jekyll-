/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehikyufutaishoshatoroku;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;

/**
 * 高額介護サービス費給付対象者登録のパラメータです。
 *
 * @reamsid_L DBC-2010-040 jianglaisheng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class InsKyufuJissekiKihonKogakuTmpProcess4Param implements IBatchProcessParameter {

    private FlexibleYearMonth 最古のサービス提供年月;
    private FlexibleYearMonth 最新のサービス提供年月;
    private FlexibleYearMonth 処理年月;

    /**
     * コンストラクタ
     *
     * @param 最古のサービス提供年月 FlexibleYearMonth
     * @param 最新のサービス提供年月 FlexibleYearMonth
     * @param 処理年月 FlexibleYearMonth
     */
    public InsKyufuJissekiKihonKogakuTmpProcess4Param(
            FlexibleYearMonth 最古のサービス提供年月,
            FlexibleYearMonth 最新のサービス提供年月,
            FlexibleYearMonth 処理年月) {
        this.最古のサービス提供年月 = 最古のサービス提供年月;
        this.最新のサービス提供年月 = 最新のサービス提供年月;
        this.処理年月 = 処理年月;
    }
}
