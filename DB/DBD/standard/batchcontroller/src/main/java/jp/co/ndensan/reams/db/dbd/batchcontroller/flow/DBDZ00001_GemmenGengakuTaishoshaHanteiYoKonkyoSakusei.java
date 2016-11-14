/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBDZ00001.GemmmenGengakuTaishoshaHanteiYoKonkyoSakusei;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBDZ00001.SetaiinHaakuInputSakusei;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBDZ00001.DBDZ00001_GemmenGengakuTaishoshaHanteiYoKonkyoSakuseiParameter;
import jp.co.ndensan.reams.db.dbz.business.config.HizukeConfig;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.DBB002001.DBB002001_SetaiinHaakuParameter;
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
public class DBDZ00001_GemmenGengakuTaishoshaHanteiYoKonkyoSakusei
        extends BatchFlowBase<DBDZ00001_GemmenGengakuTaishoshaHanteiYoKonkyoSakuseiParameter> {

    private static final String 世帯員把握入力 = "SetaiinHaakuInputSakusei";
    private static final String 世帯員把握 = "SetaiShotokuKazeiHanteiFlow";
    private static final String 減免減額対象者判定用根拠作成 = "GemmmenGengakuTaishoshaHanteiYoKonkyoSakusei";
    private static final RString SETSHOTOKUKAZEIHANTEIFLOW = new RString("DBB002001_SetaiinHaaku");

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
        if (getParameter().get所得年度() == null || getParameter().get所得年度().isEmpty()) {
            return loopBatch(SetaiinHaakuInputSakusei.class)
                    .arguments(getParameter().toGemmenGengakuTaishoShaHanteiYoukonSakuseiProcessParameter(new HizukeConfig().get所得年度()))
                    .define();
        } else {
            return loopBatch(SetaiinHaakuInputSakusei.class)
                    .arguments(getParameter().toGemmenGengakuTaishoShaHanteiYoukonSakuseiProcessParameter())
                    .define();
        }

    }

    /**
     * batchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(世帯員把握)
    protected IBatchFlowCommand setaiShotokuKazeiHanteiFlow() {
        return otherBatchFlow(SETSHOTOKUKAZEIHANTEIFLOW, SubGyomuCode.DBB介護賦課, getSetaiShotokuKazeiHanteiBatchParameter()).define();
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

    private DBB002001_SetaiinHaakuParameter getSetaiShotokuKazeiHanteiBatchParameter() {
        return new DBB002001_SetaiinHaakuParameter(SetaiinHaakuKanriShikibetsuKubun.負担限度額.getコード());
    }
}
