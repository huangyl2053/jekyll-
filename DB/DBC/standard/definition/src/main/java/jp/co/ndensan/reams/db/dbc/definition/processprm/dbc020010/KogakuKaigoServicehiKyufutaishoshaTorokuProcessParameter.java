/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc020010;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc020010.KogakuKaigoServicehiKyufutaishoshaTorokuMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額介護サービス費給付額算出のProcessParameter
 *
 * @reamsid_L DBC-2010-070 tianshuai
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class KogakuKaigoServicehiKyufutaishoshaTorokuProcessParameter implements IBatchProcessParameter {

    private FlexibleYearMonth 処理年月;

    /**
     * 高額介護サービス費給付額算出のMybatisParameterを作成する。
     *
     * @return KogakuKaigoServicehiKyufutaishoshaTorokuMybatisParameter
     */
    public KogakuKaigoServicehiKyufutaishoshaTorokuMybatisParameter toMybatisParameter() {
        return new KogakuKaigoServicehiKyufutaishoshaTorokuMybatisParameter(処理年月);
    }
}
