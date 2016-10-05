/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakugassankyufujissekiout;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;

/**
 * 高額合算給付実績情報作成のDB更新MybatisParameter
 *
 * @reamsid_L DBC-2710-030 wangxue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakugassanKyufujissekiUpdateDBMybatisParameter implements IMyBatisParameter {

    private FlexibleYearMonth 処理年月;

    /**
     * インスタンスを生成します。
     *
     * @param 処理年月 FlexibleYearMonth
     */
    public KogakugassanKyufujissekiUpdateDBMybatisParameter(FlexibleYearMonth 処理年月) {
        this.処理年月 = 処理年月;
    }

}
