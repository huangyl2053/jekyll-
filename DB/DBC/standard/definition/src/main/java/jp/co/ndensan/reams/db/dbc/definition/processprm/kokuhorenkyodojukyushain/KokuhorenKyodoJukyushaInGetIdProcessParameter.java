/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyodojukyushain;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;

/**
 * DoIchiranhyoSakuseiProcessパラメータです。
 *
 * @reamsid_L DBC-2920-010 liuxiaoyu
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KokuhorenKyodoJukyushaInGetIdProcessParameter implements IBatchProcessParameter {

    private SubGyomuCode サブ業務コード;
    private ReportId 帳票ID;
    private long 出力順ID;

}
