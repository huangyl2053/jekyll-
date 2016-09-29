/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehikyufutaishoshatoroku;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額介護サービス費給付対象者登録のパラメータです。
 *
 * @reamsid_L DBC-2010-040 jianglaisheng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class InsKyufuJissekiKihonKogakuTmpProcess4Param implements IBatchProcessParameter {

    private RString メニューID;
    private FlexibleYearMonth 審査年月From;
    private FlexibleYearMonth 審査年月To;
    private FlexibleYearMonth 最古のサービス提供年月;
    private FlexibleYearMonth 最新のサービス提供年月;
    private FlexibleYearMonth 処理年月;

    /**
     * コンストラクタ
     *
     * @param メニューID メニューID
     * @param 審査年月From FlexibleYearMonth
     * @param 審査年月To FlexibleYearMonth
     * @param 最古のサービス提供年月 FlexibleYearMonth
     * @param 最新のサービス提供年月 FlexibleYearMonth
     * @param 処理年月 FlexibleYearMonth
     */
    public InsKyufuJissekiKihonKogakuTmpProcess4Param(RString メニューID,
            FlexibleYearMonth 審査年月From,
            FlexibleYearMonth 審査年月To,
            FlexibleYearMonth 最古のサービス提供年月,
            FlexibleYearMonth 最新のサービス提供年月,
            FlexibleYearMonth 処理年月) {
        this.メニューID = メニューID;
        this.審査年月From = 審査年月From;
        this.審査年月To = 審査年月To;
        this.最古のサービス提供年月 = 最古のサービス提供年月;
        this.最新のサービス提供年月 = 最新のサービス提供年月;
        this.処理年月 = 処理年月;
    }
}
