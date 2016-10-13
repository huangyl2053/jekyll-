/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.henreihoryuin;

import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;

/**
 * 請求明細・給付管理票返戻（保留）一覧表取込のprocessパラメータです。
 *
 * @reamsid_L DBC-2830-010 yaodongsheng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HenreiHoryuInProcessParameter implements IBatchProcessParameter {

    private final FlexibleYearMonth 処理年月;
    private final SaiShoriKubun 再処理区分;
    private final Long 出力順ID;

    /**
     * コンストラクタです。
     *
     * @param 処理年月 処理年月
     * @param 再処理区分 再処理区分
     * @param 出力順ID 出力順ID
     */
    public HenreiHoryuInProcessParameter(FlexibleYearMonth 処理年月,
            SaiShoriKubun 再処理区分,
            Long 出力順ID) {
        this.処理年月 = 処理年月;
        this.再処理区分 = 再処理区分;
        this.出力順ID = 出力順ID;
    }
}
