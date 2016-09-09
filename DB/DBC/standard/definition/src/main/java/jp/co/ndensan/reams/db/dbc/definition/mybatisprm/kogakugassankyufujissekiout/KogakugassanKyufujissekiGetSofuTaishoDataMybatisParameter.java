/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakugassankyufujissekiout;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算給付実績情報作成の送付対象データ取得MybatisParameter
 *
 * @reamsid_L DBC-2710-030 wangxue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakugassanKyufujissekiGetSofuTaishoDataMybatisParameter implements IMyBatisParameter {

    private FlexibleYearMonth 処理年月;
    private RString 再処理区分;
    private RString 交換情報識別番号;

    /**
     * インスタンスを生成します。
     *
     * @param 処理年月 FlexibleYearMonth
     * @param 交換情報識別番号 RString
     * @param 再処理区分 RString
     */
    public KogakugassanKyufujissekiGetSofuTaishoDataMybatisParameter(FlexibleYearMonth 処理年月,
            RString 再処理区分, RString 交換情報識別番号) {
        this.交換情報識別番号 = 交換情報識別番号;
        this.再処理区分 = 再処理区分;
        this.処理年月 = 処理年月;
    }

}
