/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC120110;

import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 37J_高額合算自己負担額確認情報取込のバッチパラメータです。
 *
 * @reamsid_L DBC-2650-010 chenjie
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC120110_KogakuGassanJikofutangakuKakuninInParameter extends BatchParameterBase {

    @BatchParameter(key = "処理年月", name = "処理年月")
    private FlexibleYearMonth 処理年月;

    @BatchParameter(key = "再処理区分", name = "再処理区分")
    private SaiShoriKubun 再処理区分;

    @BatchParameter(key = "出力順ID", name = "出力順ID")
    private Long 出力順ID;

    @BatchParameter(key = "処理区分", name = "処理区分")
    private RString 処理区分;

    @BatchParameter(key = "loginUserId", name = "loginUserId")
    private RString loginUserId;
}
