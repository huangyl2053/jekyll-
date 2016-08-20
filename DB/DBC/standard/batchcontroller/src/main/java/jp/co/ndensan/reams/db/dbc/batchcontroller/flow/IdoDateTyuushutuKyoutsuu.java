/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.HihokenshaDaichoIdoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.JukyushaDaichoIdoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.KaigoShotokuIdoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.SeikatsuHogoJukyushaIdoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.ShikibetsuTaishoIdoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.SogoJigyoTaishoshaIdoProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.dbc180020.DBC180020_IdoRiyoshaFutanwariaiHanteiParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc180020.IdoDateTyuushutuKyoutsuuProcessParameter;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * バッチ設計_DBCMNK1002_異動データ抽出（共通）のクラスです。
 *
 * @reamsid_L DBC-4950-033 pengxingyi
 */
public class IdoDateTyuushutuKyoutsuu extends BatchFlowBase<DBC180020_IdoRiyoshaFutanwariaiHanteiParameter> {

    private static final String 受給者台帳異動 = "JukyushaDaichoIdoProcess";
    private static final String 総合事業対象者異動 = "SogoJigyoTaishoshaIdoProcess";
    private static final String 被保険者台帳異動 = "HihokenshaDaichoIdoProcess";
    private static final String 介護所得異動 = "KaigoShotokuIdoProcess";
    private static final String 宛名識別対象異動 = "ShikibetsuTaishoIdoProcess";
    private static final String 生活保護受給者異動 = "SeikatsuHogoJukyushaIdoProcess";

    private static final int NUM_1 = 1;
    private static final int NUM_7 = 7;
    private static final int NUM_8 = 8;
    private static final int NUM_31 = 31;

    @Override
    protected void defineFlow() {
        executeStep(受給者台帳異動);
        executeStep(総合事業対象者異動);
        executeStep(被保険者台帳異動);
        executeStep(介護所得異動);
        executeStep(宛名識別対象異動);
        executeStep(生活保護受給者異動);
    }

    /**
     * 受給者台帳異動データ抽出です。
     *
     * @return IBatchFlowCommand
     */
    @Step(受給者台帳異動)
    protected IBatchFlowCommand jukyushaDaichoIdoProcess() {
        return loopBatch(JukyushaDaichoIdoProcess.class)
                .arguments(getProcessParameter())
                .define();
    }

    /**
     * 総合事業対象者異動データ抽出です。
     *
     * @return IBatchFlowCommand
     */
    @Step(総合事業対象者異動)
    protected IBatchFlowCommand sogoJigyoTaishoshaIdoProcess() {
        return loopBatch(SogoJigyoTaishoshaIdoProcess.class)
                .arguments(getProcessParameter())
                .define();
    }

    /**
     * 被保険者台帳異動データ抽出です。
     *
     * @return IBatchFlowCommand
     */
    @Step(被保険者台帳異動)
    protected IBatchFlowCommand hihokenshaDaichoIdoProcess() {
        return loopBatch(HihokenshaDaichoIdoProcess.class)
                .arguments(getProcessParameter())
                .define();
    }

    /**
     * 介護所得異動データ抽出です。
     *
     * @return IBatchFlowCommand
     */
    @Step(介護所得異動)
    protected IBatchFlowCommand kaigoShotokuIdoProcess() {
        return loopBatch(KaigoShotokuIdoProcess.class)
                .arguments(getProcessParameter())
                .define();
    }

    /**
     * 宛名識別対象異動データ抽出です。
     *
     * @return IBatchFlowCommand
     */
    @Step(宛名識別対象異動)
    protected IBatchFlowCommand shikibetsuTaishoIdoProcess() {
        return loopBatch(ShikibetsuTaishoIdoProcess.class)
                .arguments(getProcessParameter())
                .define();
    }

    /**
     * 生活保護受給者異動データ抽出です。
     *
     * @return IBatchFlowCommand
     */
    @Step(生活保護受給者異動)
    protected IBatchFlowCommand seikatsuHogoJukyushaIdoProcess() {
        return loopBatch(SeikatsuHogoJukyushaIdoProcess.class)
                .arguments(getProcessParameter())
                .define();
    }

    private IdoDateTyuushutuKyoutsuuProcessParameter getProcessParameter() {
        IdoDateTyuushutuKyoutsuuProcessParameter param = new IdoDateTyuushutuKyoutsuuProcessParameter();
        param.set対象年度(getParameter().getTaishoNendo());
        param.set抽出開始日時(getParameter().getChushutsuKaishiNichiji());
        param.set抽出終了日時(getParameter().getChushutsuShuryonichiNichiji());
        param.set対象年度開始日(new FlexibleDate(getParameter().getTaishoNendo().getYearValue(), NUM_8, NUM_1));
        param.set対象年度終了日(new FlexibleDate(getParameter().getTaishoNendo().getYearValue() + NUM_1, NUM_7, NUM_31));
        param.setSearchKey(new ShikibetsuTaishoPSMSearchKeyBuilder(
                GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先).build());
        return param;
    }

}
