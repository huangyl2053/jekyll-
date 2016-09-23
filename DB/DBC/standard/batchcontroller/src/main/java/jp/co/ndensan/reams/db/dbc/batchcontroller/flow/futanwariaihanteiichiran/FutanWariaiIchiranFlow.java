/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow.futanwariaihanteiichiran;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.futanwariaihanteiichiran.FutanWariaiHanteiIchiranProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.futanwariaihanteiichiran.KonkaiFutanWariaiIchiranTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.futanwariaihanteiichiran.MaeFutanWariaiHanteiIchiranTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.futanwariaihanteiichiran.UnicodeSwitchProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC180020.DBC180020_IdoRiyoshaFutanwariaiHanteiParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.futanwariaihanteiichiran.FutanWariaiHanteiIchiranProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.futanwariaihanteiichiran.FlowEntity;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 負担割合判定一覧出力（共通）のフローです。
 *
 * @reamsid_L DBC-4980-031 yuanzhenxia
 */
public class FutanWariaiIchiranFlow extends BatchFlowBase<DBC180020_IdoRiyoshaFutanwariaiHanteiParameter> {

    private static final String 今回利用者負担割合判定TEMPへ登録する = "creatKonkaiFutanWariaiIchiranTemp";
    private static final String 前回利用者負担割合判定TEMPへ登録する = "creatMaeFutanWariaiIchiranTemp";
    private static final String 負担割合判定一覧の作成 = "getFutanWariaiData";
    private static final String 文字コードに変換する = "switchUnicode";
    private FutanWariaiHanteiIchiranProcessParameter processParameter;

    @Override
    protected void initialize() {
        processParameter = new FutanWariaiHanteiIchiranProcessParameter(getParameter().getShoriKubun(),
                getParameter().getTaishoNendo(), getParameter().getKijunbi(), getParameter().isTestMode(), getParameter().getShoriNichiji());
    }

    @Override
    protected void defineFlow() {
        executeStep(今回利用者負担割合判定TEMPへ登録する);
        executeStep(前回利用者負担割合判定TEMPへ登録する);
        executeStep(負担割合判定一覧の作成);
        FlowEntity flowEntity = getResult(FlowEntity.class, new RString(負担割合判定一覧の作成),
                FutanWariaiHanteiIchiranProcess.PARAMETER_OUT_FLOWENTITY);
        processParameter.setファイルパス(flowEntity.getファイルパス());
        if (flowEntity.is類字()) {
            executeStep(文字コードに変換する);
        }
    }

    @Step(今回利用者負担割合判定TEMPへ登録する)
    IBatchFlowCommand creatKonkaiFutanWariaiIchiranTemp() {
        return loopBatch(KonkaiFutanWariaiIchiranTempProcess.class).arguments(processParameter).define();
    }

    @Step(前回利用者負担割合判定TEMPへ登録する)
    IBatchFlowCommand creatMaeFutanWariaiIchiranTemp() {
        return loopBatch(MaeFutanWariaiHanteiIchiranTempProcess.class).arguments(processParameter).define();
    }

    @Step(負担割合判定一覧の作成)
    IBatchFlowCommand getFutanWariaiData() {
        return loopBatch(FutanWariaiHanteiIchiranProcess.class).arguments(processParameter).define();

    }

    @Step(文字コードに変換する)
    IBatchFlowCommand switchUnicode() {
        return simpleBatch(UnicodeSwitchProcess.class).arguments(processParameter).define();
    }

}
