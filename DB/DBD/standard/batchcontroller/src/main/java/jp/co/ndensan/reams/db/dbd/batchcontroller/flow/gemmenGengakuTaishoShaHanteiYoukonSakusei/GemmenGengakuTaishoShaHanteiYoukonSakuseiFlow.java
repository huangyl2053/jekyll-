/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow.gemmenGengakuTaishoShaHanteiYoukonSakusei;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.gemmenGengakuTaishoShaHanteiYoukonSakusei.GemmmenGengakuTaishoshaHanteiYoKonkyoSakusei;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.gemmenGengakuTaishoShaHanteiYoukonSakusei.SetaiinHaakuInputSakusei;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmenGengakuTaishoShaHanteiYoukonSakusei.GemmenGengakuTaishoShaHanteiYoukonSakuseiParameter;
import jp.co.ndensan.reams.db.dbz.business.config.HizukeConfig;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.fuka.SetaiShotokuKazeiHanteiBatchParameter;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SetaiinHaakuKanriShikibetsuKubun;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * DBDBTZ0001_減免減額対象者判定用根拠作成のバッチフロークラスです。
 *
 * @reamsid_L DBD-3710-090 liuwei2
 */
public class GemmenGengakuTaishoShaHanteiYoukonSakuseiFlow extends BatchFlowBase<GemmenGengakuTaishoShaHanteiYoukonSakuseiParameter> {

    private static final String 世帯員把握入力 = "SetaiinHaakuInputSakusei";
    private static final String 世帯員把握 = "SetaiShotokuKazeiHanteiFlow";
    private static final String 減免減額対象者判定用根拠作成 = "GemmmenGengakuTaishoshaHanteiYoKonkyoSakusei";
    private static final RString SETSHOTOKUKAZEIHANTEIFLOW = new RString("SetaiShotokuKazeiHanteiFlow");

    @Override
    protected void defineFlow() {
        executeStep(世帯員把握入力);
        executeStep(世帯員把握);
        executeStep(減免減額対象者判定用根拠作成);
    }

    /**
     * batchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(世帯員把握入力)
    protected IBatchFlowCommand setaiinHaakuInputSakusei() {
        return loopBatch(SetaiinHaakuInputSakusei.class)
                .arguments(getParameter().toGemmenGengakuTaishoShaHanteiYoukonSakuseiProcessParameter())
                .define();
    }

    /**
     * batchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(世帯員把握)
    protected IBatchFlowCommand setaiShotokuKazeiHanteiFlow() {
        return otherBatchFlow(SETSHOTOKUKAZEIHANTEIFLOW, SubGyomuCode.DBZ介護共通, getSetaiShotokuKazeiHanteiBatchParameter()).define();
    }

    /**
     * batchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(減免減額対象者判定用根拠作成)
    protected IBatchFlowCommand gemmmenGengakuTaishoshaHanteiYoKonkyoSakusei() {
        if (getParameter().get所得年度() == null || getParameter().get所得年度().isEmpty()) {
            return loopBatch(GemmmenGengakuTaishoshaHanteiYoKonkyoSakusei.class)
                    .arguments(getParameter().toGemmenGengakuTaishoShaHanteiYoukonSakuseiProcessParameter(new HizukeConfig().get所得年度()))
                    .define();
        } else {
            return loopBatch(GemmmenGengakuTaishoshaHanteiYoKonkyoSakusei.class)
                    .arguments(getParameter().toGemmenGengakuTaishoShaHanteiYoukonSakuseiProcessParameter())
                    .define();
        }
    }

    private SetaiShotokuKazeiHanteiBatchParameter getSetaiShotokuKazeiHanteiBatchParameter() {
        return new SetaiShotokuKazeiHanteiBatchParameter(SetaiinHaakuKanriShikibetsuKubun.負担限度額.getコード());
    }
}
