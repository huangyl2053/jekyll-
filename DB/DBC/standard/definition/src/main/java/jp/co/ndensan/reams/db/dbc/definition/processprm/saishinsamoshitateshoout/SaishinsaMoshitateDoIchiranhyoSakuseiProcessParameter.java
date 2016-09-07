/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.saishinsamoshitateshoout;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;

/**
 * SaishinsaMoshitateDoIchiranhyoSakuseiProcessパラメータです。
 *
 * @reamsid_L DBC-2540-030 liuhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SaishinsaMoshitateDoIchiranhyoSakuseiProcessParameter implements IBatchProcessParameter {

    private SubGyomuCode サブ業務コード;
    private ReportId 帳票ID;
    private long 出力順ID;
    private RYearMonth 処理年月;
    private RDateTime システム日付;

}
