/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc110050;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc110050.ShokanRenrakuhyoOutMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還連絡票情報作成のProcessParameterです。
 *
 * @reamsid_L DBC-2570-030 wangxue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanRenrakuhyoOutProcessParameter implements IBatchProcessParameter {

    private RString 再処理区分;
    private FlexibleYearMonth 処理年月;

    /**
     * 送付対象データ取得のmybatisParameterを取得する。
     *
     * @return ShokanRenrakuhyoOutMybatisParameter
     */
    public ShokanRenrakuhyoOutMybatisParameter toSofuDataMybatisParameter() {
        return new ShokanRenrakuhyoOutMybatisParameter(再処理区分, 処理年月);
    }

}
