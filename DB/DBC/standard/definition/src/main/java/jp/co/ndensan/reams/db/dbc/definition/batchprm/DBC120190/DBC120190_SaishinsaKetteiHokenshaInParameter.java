/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC120190;

import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 再審査決定通知書情報取込（保険者分）のバッチパラメータです。
 *
 * @reamsid_L DBC-2520-010 chenaoqi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings ("PMD.UnusedPrivateField")
public class DBC120190_SaishinsaKetteiHokenshaInParameter extends BatchParameterBase {

    @BatchParameter (key = "処理年月", name = "処理年月")
    private FlexibleYearMonth 処理年月;

    @BatchParameter (key = "再処理区分", name = "再処理区分")
    private SaiShoriKubun 再処理区分;

    @BatchParameter (key = "出力順ID", name = "出力順ID")
    private RString 出力順ID;

    @BatchParameter(key = "loginUserId", name = "loginUserId")
    private RString loginUserId;
}
