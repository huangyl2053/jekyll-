/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC120140;

import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算支給（不支給）決定通知書情報取込のバッチパラメータです。
 *
 * @reamsid_L DBC-2690-010 zhangrui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC120140_KogakuGassanShikyuFushikyuKetteiInParameter extends BatchParameterBase {

    private static final long serialVersionUID = 1L;

    @BatchParameter(key = "処理年月", name = "処理年月")
    private FlexibleYearMonth 処理年月;
    @BatchParameter(key = "再処理区分", name = "再処理区分")
    private SaiShoriKubun 再処理区分;
    @BatchParameter(key = "出力順ID", name = "出力順ID")
    private RString 出力順ID;
    @BatchParameter(key = "処理区分", name = "処理区分")
    private RString 処理区分;
    @BatchParameter(key = "loginUserId", name = "loginUserId")
    private RString loginUserId;

}
