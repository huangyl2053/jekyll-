/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.kogakugassankyufujissekiout;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakugassankyufujissekiout.KogakugassanKyufujissekiUpdateDBMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;

/**
 * 高額合算給付実績情報作成のDB更新ProcessParameter
 *
 * @reamsid_L DBC-2710-030 wangxue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakugassanKyufujissekiUpdateDBProcessParameter implements IBatchProcessParameter {

    private FlexibleYearMonth 処理年月;

    /**
     * MybatisParameter取得です。
     *
     * @return {@link KogakugassanKyufujissekiUpdateDBMybatisParameter}
     */
    public KogakugassanKyufujissekiUpdateDBMybatisParameter toMybatisParameter() {
        return new KogakugassanKyufujissekiUpdateDBMybatisParameter(処理年月);
    }
}
