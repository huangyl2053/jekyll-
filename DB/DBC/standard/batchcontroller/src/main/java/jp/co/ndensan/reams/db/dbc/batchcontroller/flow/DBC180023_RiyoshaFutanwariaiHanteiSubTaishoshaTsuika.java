/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180020.ClearSetaiinJohoTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180020.ClearSetainHakuNyuryokuTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180020.HanteiKijunbiSetteiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180020.SetainHakunyuryokuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180020.SetainJohoSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180020.SetainTuikaProcess;
import jp.co.ndensan.reams.db.dbc.business.core.riyoshafutanwariaihantei.HanteiKijunYMDInstance;
import jp.co.ndensan.reams.db.dbc.business.core.riyoshafutanwariaihantei.RiyoshaFutanWariaiHanteiUtil;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC180023.DBC180023_RiyoshaFutanwariaiHanteiSubTaishoshaTsuikaParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc180020.DBC180020ProcessParameter;
import jp.co.ndensan.reams.db.dbc.service.core.riyoshafutanwariaihantei.RiyoshaFutanWariaiHantei;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.DBB002001.DBB002001_SetaiinHaakuParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;

/**
 * バッチ設計_DBCMNK1002_利用者負担割合判定（共通）のフローです。
 *
 * @reamsid_L DBC-4950-030 liuyang
 */
public class DBC180023_RiyoshaFutanwariaiHanteiSubTaishoshaTsuika
        extends BatchFlowBase<DBC180023_RiyoshaFutanwariaiHanteiSubTaishoshaTsuikaParameter> {

    private static final String 判定基準日設定 = "hanteiKijunbiSetteiProcess";
    private static final String CLEAR世帯員情報 = "clearSetaiinJohoTempProcess";
    private static final String CLEAR世帯員把握入力 = "clearSetainHakuNyuryokuTempProcess";
    private static final String 世帯員把握入力 = "setainHakunyuryokuProcess";
    private static final RString 世帯員把握BATCHID = new RString("DBB002001_SetaiinHaaku");
    private static final String 世帯員把握FLOW = "setaiShotokuKazeiHanteiFlow";
    private static final RString 管理識別区分 = new RString("3");
    private static final String 世帯員情報作成 = "setainJohoSakuseiProcess";
    private static final String 世帯員利用者負担割合本人追加 = "setainTuikaProcess";
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
    }

    @Override
    protected void defineFlow() {
        List<RString> hanteiKijunbi = getParameter().getHanteiKijunbi();
        kijunbiSize = hanteiKijunbi == null ? 0 : hanteiKijunbi.size();
        for (int i = 0; i < kijunbiSize; i++) {
            loopProcessPrm = new RiyoshaFutanWariaiHanteiUtil().toProcessParameter(
                    getParameter().toDBC180022_RiyoshaFutanwariaiHanteiSubParameter(), i);
            executeStep(判定基準日設定);
            loopProcessPrm.getHanteiKijunbi().set(i, HanteiKijunYMDInstance.getInstance().get判定基準日());
            executeStep(世帯員把握入力);
            executeStep(世帯員把握FLOW);
            executeStep(世帯員情報作成);
            executeStep(世帯員利用者負担割合本人追加);
            executeStep(CLEAR世帯員把握入力);
            executeStep(CLEAR世帯員情報);
        }
    }

    @Step(判定基準日設定)
    IBatchFlowCommand hanteiKijunbiSetteiProcess() {
        return loopBatch(HanteiKijunbiSetteiProcess.class).arguments(loopProcessPrm).define();
    }

    @Step(CLEAR世帯員情報)
    IBatchFlowCommand clearSetaiinJohoTempProcess() {
        return simpleBatch(ClearSetaiinJohoTempProcess.class).define();
    }

    @Step(CLEAR世帯員把握入力)
    IBatchFlowCommand clearSetainHakuNyuryokuTempProcess() {
        return simpleBatch(ClearSetainHakuNyuryokuTempProcess.class).define();
    }

    @Step(世帯員把握入力)
    IBatchFlowCommand setainHakunyuryokuProcess() {
        return loopBatch(SetainHakunyuryokuProcess.class).arguments(loopProcessPrm).define();
    }

    @Step(世帯員把握FLOW)
    IBatchFlowCommand setaiShotokuKazeiHanteiFlow() {
        return otherBatchFlow(世帯員把握BATCHID, SubGyomuCode.DBZ介護共通,
                new DBB002001_SetaiinHaakuParameter(管理識別区分)).define();
    }

    @Step(世帯員情報作成)
    IBatchFlowCommand setainJohoSakuseiProcess() {
        return loopBatch(SetainJohoSakuseiProcess.class).arguments(loopProcessPrm).define();
    }

    @Step(世帯員利用者負担割合本人追加)
    IBatchFlowCommand setainTuikaProcess() {
        return loopBatch(SetainTuikaProcess.class).arguments(loopProcessPrm).define();
    }
}
