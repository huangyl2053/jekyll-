/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.kogakugassankyufujissekiout;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakugassankyufujissekiout.KogakugassanKyufujissekiGetSofuTaishoDataMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算給付実績情報作成の送付対象データ取得ProcessParameter
 *
 * @reamsid_L DBC-2710-030 wangxue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakugassanKyufujissekiGetSofuTaishoDataProcessParameter implements IBatchProcessParameter {

    private FlexibleYearMonth 処理年月;
    private RString 再処理区分;
    private RString 交換情報識別番号;

    /**
     * MybatisParameter取得です。
     *
     * @return {@link KogakugassanKyufujissekiGetSofuTaishoDataMybatisParameter}
     */
    public KogakugassanKyufujissekiGetSofuTaishoDataMybatisParameter toMybatisParameter() {

        return new KogakugassanKyufujissekiGetSofuTaishoDataMybatisParameter(処理年月, 再処理区分, 交換情報識別番号);
    }

}
