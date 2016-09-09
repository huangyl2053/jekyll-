/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.kogakugassankyufujissekiout;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakugassankyufujissekiout.KogakugassanKyufujissekiDoSofuReportMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算給付実績情報作成の帳票出力ProcessParameter
 *
 * @reamsid_L DBC-2710-030 wangxue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakugassanKyufujissekiDoSofuReportProcessParameter implements IBatchProcessParameter {

    private RString 出力順ID;
    private FlexibleYearMonth 処理年月;

    /**
     * MyBatisParameter作成です。
     *
     * @return KogakugassanKyufujissekiDoSofuReportMybatisParameter
     */
    public KogakugassanKyufujissekiDoSofuReportMybatisParameter toMybatisParameter() {
        return new KogakugassanKyufujissekiDoSofuReportMybatisParameter();
    }

}
