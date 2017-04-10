/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180020.ClearKonkaiRiyoshaFutanWariaiJohoTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180020.FutanWariaiHanteiMergeProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180020.FutanWariaiHanteiTukiziProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180020.FutanWariaiKonkyoLoginProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180020.FutanWariaiLoginProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180020.TsukibetsuFutanWariaiGenTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180020.TsukibetsuFutanWariaiNewTempProcess;
import jp.co.ndensan.reams.db.dbd.business.core.riyoshafutanwariaihantei.RiyoshaFutanWariaiHanteiUtil;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD180025.DBD180025_RiyoshaFutanwariaiHanteiSubGetsujiShoriParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd180020.DBD180020ProcessParameter;
import jp.co.ndensan.reams.db.dbd.service.core.riyoshafutanwariaihantei.RiyoshaFutanWariaiHantei;
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
public class DBC180025_RiyoshaFutanwariaiHanteiSubGetsujiShori
        extends BatchFlowBase<DBD180025_RiyoshaFutanwariaiHanteiSubGetsujiShoriParameter> {

    private static final String CLEAR今回利用者負担割合情報 = "clearKonkaiRiyoshaFutanWariaiJohoTempProcess";
    private static final String 負担割合判定月次 = "futanWariaiHanteiGetuziProcess";
    private static final String 負担割合判定マージ = "futanWariaiHanteiMergeProcess";
    private static final String 月別負担割合新の作成 = "tsukibetsuFutanWariaiNewTempProcess";
    private static final String 月別負担割合現の作成 = "tsukibetsuFutanWariaiGenTempProcess";
    private static final String 負担割合登録 = "futanWariaiLoginProcess";
    private static final String 負担割合根拠登録 = "futanWariaiKonkyoLoginProcess";

    private DBD180020ProcessParameter processPrm;
    private int kijunbiSize;
    private DBD180020ProcessParameter loopProcessPrm;
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
        processPrm = util.toProcessParameter(getParameter().toDBC180022_RiyoshaFutanwariaiHanteiSubParameter());
    }

    @Override
    protected void defineFlow() {
        List<RString> hanteiKijunbi = getParameter().getHanteiKijunbi();
        kijunbiSize = hanteiKijunbi == null ? 0 : hanteiKijunbi.size();
        for (int i = 0; i < kijunbiSize; i++) {
            loopProcessPrm = new RiyoshaFutanWariaiHanteiUtil().toProcessParameter(
                    getParameter().toDBC180022_RiyoshaFutanwariaiHanteiSubParameter(), i);
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
        return simpleBatch(ClearKonkaiRiyoshaFutanWariaiJohoTempProcess.class).define();
    }
}
