/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.sogojigyohishinsaketteiseikyumeisaikeikasochiin;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 総合事業費（経過措置）審査決定請求明細表情報取込ProcessのParameterクラスです
 *
 * @reamsid_L DBC-2500-011 jiangwenkai
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SogojigyohiShinsaProcessParameter implements IBatchProcessParameter {

    private ReportId 帳票ID;
    private RString 出力順ID;
    private FlexibleYearMonth 処理年月;
    private RDateTime システム日付;
}
