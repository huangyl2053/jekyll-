/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC710100.HanyoListKagoKekkaNoRenbanOutputProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC710100.HanyoListKagoKekkaOutputProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710100.DBC710100_HanyoListKagoKekkaParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc710100.HanyoListKagoKekkaProcessParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;

/**
 * 汎用リスト出力(過誤結果情報)のバッチ用パラメータフロークラスです。
 *
 * @reamsid_L DBC-3094-020 qinzhen
 */
public class DBC710100_HanyoListKagoKekka extends BatchFlowBase<DBC710100_HanyoListKagoKekkaParameter> {

    private static final String 過誤申立情報 = "hanyoListKagoKekkaOutputProcess";
    private static final String 過誤申立情報_連番しない = "hanyoListKagoKekkaNoRenbanOutputProcess";
    private RDateTime システム日時;

    @Override
    protected void defineFlow() {
        システム日時 = RDateTime.now();
        if (getParameter().is連番付加()) {
            executeStep(過誤申立情報);
        } else {
            executeStep(過誤申立情報_連番しない);
        }
    }

    @Step(過誤申立情報)
    IBatchFlowCommand hanyoListKagoKekkaOutputProcess() {
        return loopBatch(HanyoListKagoKekkaOutputProcess.class)
                .arguments(getProcessParameter())
                .define();
    }

    @Step(過誤申立情報_連番しない)
    IBatchFlowCommand hanyoListKagoKekkaNoRenbanOutputProcess() {
        return loopBatch(HanyoListKagoKekkaNoRenbanOutputProcess.class)
                .arguments(getProcessParameter())
                .define();
    }

    private HanyoListKagoKekkaProcessParameter getProcessParameter() {
        HanyoListKagoKekkaProcessParameter param = new HanyoListKagoKekkaProcessParameter();
        param.set国保連取扱年月From(getParameter().get国保連取扱年月From());
        param.set国保連取扱年月To(getParameter().get国保連取扱年月To());
        param.set保険者区分(getParameter().get保険者区分());
        param.setサービス提供年月From(getParameter().getサービス提供年月From());
        param.setサービス提供年月To(getParameter().getサービス提供年月To());
        param.set事業者コード(new JigyoshaNo(getParameter().get事業者コード()));
        param.set事業者名(getParameter().get事業者名());
        param.set項目名付加(getParameter().is項目名付加());
        param.set連番付加(getParameter().is連番付加());
        param.set日付スラッシュ付加(getParameter().is日付スラッシュ付加());
        param.set保険者コード(getParameter().get保険者コード());
        param.setシステム日時(システム日時);
        param.setシステム日付(new FlexibleDate(システム日時.getDate().toDateString()));
        param.setSearchKey(new ShikibetsuTaishoPSMSearchKeyBuilder(
                GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先).setデータ取得区分(DataShutokuKubun.直近レコード).build());
        return param;
    }
}
