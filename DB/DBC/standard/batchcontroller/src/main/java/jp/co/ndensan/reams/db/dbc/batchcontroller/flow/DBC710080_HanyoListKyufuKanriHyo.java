/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC710080.HanyoListKyufuKanriHyoNoRenbanOutputProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC710080.HanyoListKyufuKanriHyoOutputProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710080.DBC710080_HanyoListKyufuKanriHyoParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc710080.HanyoListKyufuKanriHyoProcessParameter;
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
 * 汎用リスト(給付管理票)のバッチ用パラメータフロークラスです。
 *
 * @reamsid_L DBC-3096-020 pengxingyi
 */
public class DBC710080_HanyoListKyufuKanriHyo extends BatchFlowBase<DBC710080_HanyoListKyufuKanriHyoParameter> {

    private static final String 給付管理票 = "HanyoListKyufuKanriHyoOutputProcess";
    private static final String 給付管理票_連番しない = "HanyoListKyufuKanriHyoNoRenbanOutputProcess";
    private RDateTime システム日時;

    @Override
    protected void defineFlow() {
        システム日時 = RDateTime.now();
        if (getParameter().is連番付加()) {
            executeStep(給付管理票);
        } else {
            executeStep(給付管理票_連番しない);
        }
    }

    @Step(給付管理票)
    IBatchFlowCommand hanyoListKyufuKanriHyoOutputProcess() {
        return loopBatch(HanyoListKyufuKanriHyoOutputProcess.class)
                .arguments(getProcessParameter())
                .define();
    }

    @Step(給付管理票_連番しない)
    IBatchFlowCommand hanyoListKyufuKanriHyoNoRenbanOutputProcess() {
        return loopBatch(HanyoListKyufuKanriHyoNoRenbanOutputProcess.class)
                .arguments(getProcessParameter())
                .define();
    }

    private HanyoListKyufuKanriHyoProcessParameter getProcessParameter() {
        HanyoListKyufuKanriHyoProcessParameter param = new HanyoListKyufuKanriHyoProcessParameter();
        if (getParameter().get給付対象年月From() != null) {
            param.set給付対象年月From(new FlexibleDate(getParameter().get給付対象年月From().toDateString()).getYearMonth());
        }
        if (getParameter().get給付対象年月To() != null) {
            param.set給付対象年月To(new FlexibleDate(getParameter().get給付対象年月To().toDateString()).getYearMonth());
        }
        param.set居宅支援事業者コード(getParameter().get居宅支援事業者コード());
        param.set居宅支援事業者名(getParameter().get居宅支援事業者名());
        param.set委託先支援事業者コード(getParameter().get委託先支援事業者コード());
        param.set委託先支援事業者名(getParameter().get委託先支援事業者名());
        param.set明細行出力有無(getParameter().get明細行出力有無());
        param.set項目名付加(getParameter().is項目名付加());
        param.set連番付加(getParameter().is連番付加());
        param.set日付スラッシュ付加(getParameter().is日付スラッシュ付加());
        param.set保険者コード(getParameter().get保険者コード());
        param.set出力順(getParameter().get出力順());
        param.set出力項目(getParameter().get出力項目());
        param.setシステム日時(システム日時);
        param.setシステム日付(new FlexibleDate(システム日時.getDate().toDateString()));
        param.setSearchKey(new ShikibetsuTaishoPSMSearchKeyBuilder(
                GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先).setデータ取得区分(DataShutokuKubun.直近レコード).build());
        return param;
    }
}
