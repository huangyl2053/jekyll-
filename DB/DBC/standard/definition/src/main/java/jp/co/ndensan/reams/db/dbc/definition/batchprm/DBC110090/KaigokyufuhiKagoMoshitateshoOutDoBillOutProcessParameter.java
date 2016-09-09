/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110090;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護給付費過誤申立書作成の帳票出力Processパラメータです。
 *
 * @reamsid_L DBC-2530-030 jiangwenkai
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigokyufuhiKagoMoshitateshoOutDoBillOutProcessParameter implements IBatchProcessParameter {

    private ReportId 帳票ID;
    private RString 出力順ID;
    private FlexibleYearMonth 処理年月;
    private RDateTime システム日付;
    private RString コード;

}
