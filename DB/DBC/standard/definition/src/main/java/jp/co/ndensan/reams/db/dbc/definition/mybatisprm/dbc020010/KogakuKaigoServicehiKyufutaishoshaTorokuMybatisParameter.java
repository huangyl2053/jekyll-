/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc020010;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額介護サービス費給付額算出のMyBatisParameterクラスです。
 *
 * @reamsid_L DBC-2010-070 tianshuai
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuKaigoServicehiKyufutaishoshaTorokuMybatisParameter implements IMyBatisParameter {

    private FlexibleYearMonth 処理年月;

    /**
     * コンストラクタです。
     *
     * @param 処理年月 FlexibleYearMonth
     */
    public KogakuKaigoServicehiKyufutaishoshaTorokuMybatisParameter(
            FlexibleYearMonth 処理年月) {
        this.処理年月 = 処理年月;
    }
}
