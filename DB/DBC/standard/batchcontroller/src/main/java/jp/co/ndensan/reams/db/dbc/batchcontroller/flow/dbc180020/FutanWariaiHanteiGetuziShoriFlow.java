/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow.dbc180020;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.dataclear.ClearKonkaiRiyoshaFutanWariaiJohoTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.dataclear.ClearRiyoshaFutanWariaiMeisai01TempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.dataclear.ClearRiyoshaFutanWariaiMeisai02TempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.dataclear.ClearRiyoshaFutanWariaiMeisai03TempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.dataclear.ClearRiyoshaFutanWariaiMeisai04TempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.dataclear.ClearRiyoshaFutanWariaiMeisai05TempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.dataclear.ClearRiyoshaFutanWariaiMeisai06TempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.dataclear.ClearRiyoshaFutanWariaiMeisai07TempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.dataclear.ClearRiyoshaFutanWariaiMeisai08TempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.dataclear.ClearRiyoshaFutanWariaiMeisai09TempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.dataclear.ClearRiyoshaFutanWariaiMeisai10TempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.dataclear.ClearRiyoshaFutanWariaiMeisai11TempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.dataclear.ClearRiyoshaFutanWariaiMeisai12TempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.dataclear.ClearRiyoshaFutanWariaiMeisaiTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.dataclear.ClearTsukibetsuFutanWariaiGenTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.dataclear.ClearTsukibetsuFutanWariaiNewTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.work7.Work10Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.work7.Work11Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.work7.Work12Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.work7.Work7Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.work7.Work8Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.work7.Work9Process;
import jp.co.ndensan.reams.db.dbc.business.core.riyoshafutanwariaihantei.RiyoshaFutanWariaiHanteiUtil;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.dbc180020.DBC180020_IdoRiyoshaFutanwariaiHanteiParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc180020.DBC180020ProcessParameter;
import jp.co.ndensan.reams.db.dbc.service.core.riyoshafutanwariaihantei.RiyoshaFutanWariaiHantei;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;

/**
 * バッチ設計_DBCMNK1002_利用者負担割合判定（共通）のフローです。<br/>
 * 負担割合判定（月次）
 *
 * @reamsid_L DBC-4950-030 liuyang
 */
public class FutanWariaiHanteiGetuziShoriFlow
        extends BatchFlowBase<DBC180020_IdoRiyoshaFutanwariaiHanteiParameter> {

    private static final String CLEAR利用者負担割合明細08 = "clearRiyoshaFutanWariaiMeisai08TempProcess";
    private static final String CLEAR利用者負担割合明細09 = "clearRiyoshaFutanWariaiMeisai09TempProcess";
    private static final String CLEAR利用者負担割合明細10 = "clearRiyoshaFutanWariaiMeisai10TempProcess";
    private static final String CLEAR利用者負担割合明細11 = "clearRiyoshaFutanWariaiMeisai11TempProcess";
    private static final String CLEAR利用者負担割合明細12 = "clearRiyoshaFutanWariaiMeisai12TempProcess";
    private static final String CLEAR利用者負担割合明細01 = "clearRiyoshaFutanWariaiMeisai01TempProcess";
    private static final String CLEAR利用者負担割合明細02 = "clearRiyoshaFutanWariaiMeisai02TempProcess";
    private static final String CLEAR利用者負担割合明細03 = "clearRiyoshaFutanWariaiMeisai03TempProcess";
    private static final String CLEAR利用者負担割合明細04 = "clearRiyoshaFutanWariaiMeisai04TempProcess";
    private static final String CLEAR利用者負担割合明細05 = "clearRiyoshaFutanWariaiMeisai05TempProcess";
    private static final String CLEAR利用者負担割合明細06 = "clearRiyoshaFutanWariaiMeisai06TempProcess";
    private static final String CLEAR利用者負担割合明細07 = "clearRiyoshaFutanWariaiMeisai07TempProcess";
    private static final String CLEAR利用者負担割合明細 = "clearRiyoshaFutanWariaiMeisaiTempProcess";
    private static final String CLEAR月別負担割合新 = "clearTsukibetsuFutanWariaiNewTempProcess";
    private static final String CLEAR月別負担割合現 = "clearTsukibetsuFutanWariaiGenTempProcess";
    private static final String CLEAR今回利用者負担割合情報 = "clearKonkaiRiyoshaFutanWariaiJohoTempProcess";

    private static final String 負担割合判定月次 = "futanWariaiHanteiGetuziProcess";
    private static final String 負担割合判定マージ = "futanWariaiHanteiMergeProcess";
    private static final String 月別負担割合新の作成 = "tsukibetsuFutanWariaiNewTempProcess";
    private static final String 月別負担割合現の作成 = "tsukibetsuFutanWariaiGenTempProcess";
    private static final String 負担割合登録 = "futanWariaiLoginProcess";
    private static final String 負担割合根拠登録 = "futanWariaiKonkyoLoginProcess";

    private DBC180020ProcessParameter processPrm;
    private int kijunbiSize;
    private DBC180020ProcessParameter loopProcessPrm;
    private RiyoshaFutanWariaiHanteiUtil util;
    private RiyoshaFutanWariaiHantei service;

    @Override
    protected void initialize() {
        service = RiyoshaFutanWariaiHantei.createInstance();
        util = new RiyoshaFutanWariaiHanteiUtil();
        RYear nendo = util.getFlexibleYearRYear(getParameter().getTaishoNendo());
        getParameter().setHanteiKijunbi(service.getHanteiKijunbi(
                util.getFlexibleDateString(getParameter().getKijunbi())));
        getParameter().setTaishoGetsu(service.initializeTaishoGetsu());
        getParameter().set対象開始日(service.getTaishoKaishibi(nendo));
        getParameter().set対象終了日(service.getTaishoShuryobi(nendo));
        List<RString> hanteiKijunbi = getParameter().getHanteiKijunbi();
        kijunbiSize = hanteiKijunbi == null ? 0 : hanteiKijunbi.size();
        processPrm = util.toProcessParameter(getParameter());
    }

    @Override
    protected void defineFlow() {
        List<RString> hanteiKijunbi = getParameter().getHanteiKijunbi();
        kijunbiSize = hanteiKijunbi == null ? 0 : hanteiKijunbi.size();
        executeStep(CLEAR利用者負担割合明細01);
        executeStep(CLEAR利用者負担割合明細02);
        executeStep(CLEAR利用者負担割合明細03);
        executeStep(CLEAR利用者負担割合明細04);
        executeStep(CLEAR利用者負担割合明細05);
        executeStep(CLEAR利用者負担割合明細06);
        executeStep(CLEAR利用者負担割合明細07);
        executeStep(CLEAR利用者負担割合明細08);
        executeStep(CLEAR利用者負担割合明細09);
        executeStep(CLEAR利用者負担割合明細10);
        executeStep(CLEAR利用者負担割合明細11);
        executeStep(CLEAR利用者負担割合明細12);
        for (int i = 0; i < kijunbiSize; i++) {
            loopProcessPrm = new RiyoshaFutanWariaiHanteiUtil().toProcessParameter(getParameter(), i);
            executeStep(負担割合判定月次);
        }
        executeStep(CLEAR利用者負担割合明細);
        executeStep(負担割合判定マージ);
        executeStep(CLEAR月別負担割合新);
        executeStep(月別負担割合新の作成);
        executeStep(CLEAR月別負担割合現);
        executeStep(月別負担割合現の作成);
        if (getParameter().getChushutuKaisu() == null || getParameter().getChushutuKaisu() <= 1) {
            executeStep(CLEAR今回利用者負担割合情報);
        }
        executeStep(負担割合登録);
        if (!getParameter().isTestMode()) {
            executeStep(負担割合根拠登録);
        }
    }

    @Step(負担割合判定月次)
    IBatchFlowCommand futanWariaiHanteiGetuziProcess() {
        return loopBatch(Work7Process.class).arguments(loopProcessPrm).define();
    }

    @Step(負担割合判定マージ)
    IBatchFlowCommand futanWariaiHanteiMergeProcess() {
        return loopBatch(Work8Process.class).arguments(processPrm).define();
    }

    @Step(月別負担割合新の作成)
    IBatchFlowCommand tsukibetsuFutanWariaiNewTempProcess() {
        return loopBatch(Work9Process.class).arguments(processPrm).define();
    }

    @Step(月別負担割合現の作成)
    IBatchFlowCommand setainTuikaProcess() {
        return loopBatch(Work10Process.class).arguments(processPrm).define();
    }

    @Step(負担割合登録)
    IBatchFlowCommand futanWariaiLoginProcess() {
        return loopBatch(Work11Process.class).arguments(processPrm).define();
    }

    @Step(負担割合根拠登録)
    IBatchFlowCommand futanWariaiKonkyoLoginProcess() {
        return loopBatch(Work12Process.class).arguments(processPrm).define();
    }

    @Step(CLEAR今回利用者負担割合情報)
    IBatchFlowCommand clearKonkaiRiyoshaFutanWariaiJohoTempProcess() {
        return loopBatch(ClearKonkaiRiyoshaFutanWariaiJohoTempProcess.class).arguments(processPrm).define();
    }

    @Step(CLEAR月別負担割合現)
    IBatchFlowCommand clearTsukibetsuFutanWariaiGenTempProcess() {
        return loopBatch(ClearTsukibetsuFutanWariaiGenTempProcess.class).arguments(processPrm).define();
    }

    @Step(CLEAR月別負担割合新)
    IBatchFlowCommand clearTsukibetsuFutanWariaiNewTempProcess() {
        return loopBatch(ClearTsukibetsuFutanWariaiNewTempProcess.class).arguments(processPrm).define();
    }

    @Step(CLEAR利用者負担割合明細)
    IBatchFlowCommand clearRiyoshaFutanWariaiMeisaiTempProcess() {
        return loopBatch(ClearRiyoshaFutanWariaiMeisaiTempProcess.class).arguments(processPrm).define();
    }

    @Step(CLEAR利用者負担割合明細08)
    IBatchFlowCommand clearRiyoshaFutanWariaiMeisai08TempProcess() {
        return loopBatch(ClearRiyoshaFutanWariaiMeisai08TempProcess.class).arguments(processPrm).define();
    }

    @Step(CLEAR利用者負担割合明細09)
    IBatchFlowCommand clearRiyoshaFutanWariaiMeisai09TempProcess() {
        return loopBatch(ClearRiyoshaFutanWariaiMeisai09TempProcess.class).arguments(processPrm).define();
    }

    @Step(CLEAR利用者負担割合明細10)
    IBatchFlowCommand clearRiyoshaFutanWariaiMeisai10TempProcess() {
        return loopBatch(ClearRiyoshaFutanWariaiMeisai10TempProcess.class).arguments(processPrm).define();
    }

    @Step(CLEAR利用者負担割合明細11)
    IBatchFlowCommand clearRiyoshaFutanWariaiMeisai11TempProcess() {
        return loopBatch(ClearRiyoshaFutanWariaiMeisai11TempProcess.class).arguments(processPrm).define();
    }

    @Step(CLEAR利用者負担割合明細12)
    IBatchFlowCommand clearRiyoshaFutanWariaiMeisai12TempProcess() {
        return loopBatch(ClearRiyoshaFutanWariaiMeisai12TempProcess.class).arguments(processPrm).define();
    }

    @Step(CLEAR利用者負担割合明細01)
    IBatchFlowCommand clearRiyoshaFutanWariaiMeisai01TempProcess() {
        return loopBatch(ClearRiyoshaFutanWariaiMeisai01TempProcess.class).arguments(processPrm).define();
    }

    @Step(CLEAR利用者負担割合明細02)
    IBatchFlowCommand clearRiyoshaFutanWariaiMeisai02TempProcess() {
        return loopBatch(ClearRiyoshaFutanWariaiMeisai02TempProcess.class).arguments(processPrm).define();
    }

    @Step(CLEAR利用者負担割合明細03)
    IBatchFlowCommand clearRiyoshaFutanWariaiMeisai03TempProcess() {
        return loopBatch(ClearRiyoshaFutanWariaiMeisai03TempProcess.class).arguments(processPrm).define();
    }

    @Step(CLEAR利用者負担割合明細04)
    IBatchFlowCommand clearRiyoshaFutanWariaiMeisai04TempProcess() {
        return loopBatch(ClearRiyoshaFutanWariaiMeisai04TempProcess.class).arguments(processPrm).define();
    }

    @Step(CLEAR利用者負担割合明細05)
    IBatchFlowCommand clearRiyoshaFutanWariaiMeisai05TempProcess() {
        return loopBatch(ClearRiyoshaFutanWariaiMeisai05TempProcess.class).arguments(processPrm).define();
    }

    @Step(CLEAR利用者負担割合明細06)
    IBatchFlowCommand clearRiyoshaFutanWariaiMeisai06TempProcess() {
        return loopBatch(ClearRiyoshaFutanWariaiMeisai06TempProcess.class).arguments(processPrm).define();
    }

    @Step(CLEAR利用者負担割合明細07)
    IBatchFlowCommand clearRiyoshaFutanWariaiMeisai07TempProcess() {
        return loopBatch(ClearRiyoshaFutanWariaiMeisai07TempProcess.class).arguments(processPrm).define();
    }

}
