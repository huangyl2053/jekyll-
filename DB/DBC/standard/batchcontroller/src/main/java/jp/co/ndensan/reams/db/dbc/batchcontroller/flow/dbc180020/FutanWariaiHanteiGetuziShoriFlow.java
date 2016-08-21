/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow.dbc180020;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.dataclear.ClearKonkaiRiyoshaFutanWariaiJohoTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.work7.FutanWariaiHanteiMergeProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.work7.FutanWariaiHanteiTukiziProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.work7.FutanWariaiKonkyoLoginProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.work7.FutanWariaiLoginProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.work7.TsukibetsuFutanWariaiGenTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.work7.TsukibetsuFutanWariaiNewTempProcess;
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
        for (int i = 0; i < kijunbiSize; i++) {
            loopProcessPrm = new RiyoshaFutanWariaiHanteiUtil().toProcessParameter(getParameter(), i);
            executeStep(負担割合判定月次);
        }
        executeStep(負担割合判定マージ);
        executeStep(月別負担割合新の作成);
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
        return loopBatch(FutanWariaiHanteiTukiziProcess.class).arguments(loopProcessPrm).define();
    }

    @Step(負担割合判定マージ)
    IBatchFlowCommand futanWariaiHanteiMergeProcess() {
        return loopBatch(FutanWariaiHanteiMergeProcess.class).arguments(processPrm).define();
    }

    @Step(月別負担割合新の作成)
    IBatchFlowCommand tsukibetsuFutanWariaiNewTempProcess() {
        return loopBatch(TsukibetsuFutanWariaiNewTempProcess.class).arguments(processPrm).define();
    }

    @Step(月別負担割合現の作成)
    IBatchFlowCommand setainTuikaProcess() {
        return loopBatch(TsukibetsuFutanWariaiGenTempProcess.class).arguments(processPrm).define();
    }

    @Step(負担割合登録)
    IBatchFlowCommand futanWariaiLoginProcess() {
        return loopBatch(FutanWariaiLoginProcess.class).arguments(processPrm).define();
    }

    @Step(負担割合根拠登録)
    IBatchFlowCommand futanWariaiKonkyoLoginProcess() {
        return loopBatch(FutanWariaiKonkyoLoginProcess.class).arguments(processPrm).define();
    }

    @Step(CLEAR今回利用者負担割合情報)
    IBatchFlowCommand clearKonkaiRiyoshaFutanWariaiJohoTempProcess() {
        return loopBatch(ClearKonkaiRiyoshaFutanWariaiJohoTempProcess.class).arguments(processPrm).define();
    }
}
