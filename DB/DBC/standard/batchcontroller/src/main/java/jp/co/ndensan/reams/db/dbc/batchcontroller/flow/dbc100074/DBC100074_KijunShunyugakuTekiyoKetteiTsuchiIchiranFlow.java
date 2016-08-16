/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow.dbc100074;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc100074.SpoolKijunShunyugakuTekiyoKetteiProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.kijunshunyugakutekiyokettei.DBC100074_KijunShunyugakuTekiyoKetteiTsuchiIchiranParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kijunshunyugakutekiyokettei.SpoolKijunShunyugakuTekiyoKetteiProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 基準収入額決定通知書発行クラスです。
 *
 * @reamsid_L DBC-4610-030 xuhao
 */
public class DBC100074_KijunShunyugakuTekiyoKetteiTsuchiIchiranFlow
        extends BatchFlowBase<DBC100074_KijunShunyugakuTekiyoKetteiTsuchiIchiranParameter> {

    private static final String 帳票発行処理 = "spoolKijunShunyugakuTekiyoKettei";

    @Override
    protected void defineFlow() {
        executeStep(帳票発行処理);
    }

    /**
     * 帳票発行処理のメソッドです。
     *
     * @return SelectKarisateiTaishoProcess
     */
    @Step(帳票発行処理)
    protected IBatchFlowCommand spoolKijunShunyugakuTekiyoKettei() {
        return loopBatch(SpoolKijunShunyugakuTekiyoKetteiProcess.class).arguments(createParameter()).define();
    }

    private SpoolKijunShunyugakuTekiyoKetteiProcessParameter createParameter() {
        SpoolKijunShunyugakuTekiyoKetteiProcessParameter parameter = new SpoolKijunShunyugakuTekiyoKetteiProcessParameter();
        parameter.set抽出期間(getParameter().get抽出期間());
        parameter.set開始日(getParameter().get開始日());
        parameter.set終了日(getParameter().get終了日());
        parameter.set印書(getParameter().get印書());
        parameter.set作成日(getParameter().get作成日());
        parameter.set文書番号(getParameter().get文書番号());
        parameter.set市町村コード(getParameter().get市町村コード());
        parameter.set市町村名(getParameter().get市町村名());
        parameter.set帳票出力順ID(getParameter().get帳票出力順ID());
        return parameter;
    }

}
