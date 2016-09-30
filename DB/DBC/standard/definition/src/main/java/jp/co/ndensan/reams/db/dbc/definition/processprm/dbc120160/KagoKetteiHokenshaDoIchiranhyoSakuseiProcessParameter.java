/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc120160;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 一覧表作成Processパラメータです。
 *
 * @reamsid_L DBC-0980-300 zhangrui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KagoKetteiHokenshaDoIchiranhyoSakuseiProcessParameter implements IBatchProcessParameter {

    private SubGyomuCode サブ業務コード;
    private ReportId 帳票ID;
    private RString 出力順ID;
    private FlexibleYearMonth 処理年月;
    private RDateTime システム日付;
}
