/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehikyufutaishoshatoroku;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;

/**
 * 給付実績基本抽出03を抽出用パラメータクラスです。
 *
 * @reamsid_L DBC-2010-040 jianglaisheng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class InsKyufuJissekiKihonKogakuTmp4Param implements IMyBatisParameter {

    private FlexibleYearMonth 最古のサービス提供年月;
    private FlexibleYearMonth 最新のサービス提供年月;

    /**
     * コンストラクタです
     *
     * @param 最古のサービス提供年月 FlexibleYearMonth
     * @param 最新のサービス提供年月 FlexibleYearMonth
     */
    public InsKyufuJissekiKihonKogakuTmp4Param(FlexibleYearMonth 最古のサービス提供年月,
            FlexibleYearMonth 最新のサービス提供年月) {
        this.最古のサービス提供年月 = 最古のサービス提供年月;
        this.最新のサービス提供年月 = 最新のサービス提供年月;
    }
}
