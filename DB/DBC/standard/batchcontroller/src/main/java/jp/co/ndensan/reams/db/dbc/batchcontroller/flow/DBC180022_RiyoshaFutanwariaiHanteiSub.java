/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180022.FutanWariaiHanteiNenziProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180022.HanteiTaishoshaTuikaProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180022.SeikatsuHogoGaitoJohoTempProcess;
import jp.co.ndensan.reams.db.dbd.business.core.riyoshafutanwariaihantei.RiyoshaFutanWariaiHanteiUtil;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD180022.DBD180022_RiyoshaFutanwariaiHanteiSubParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd180020.DBD180020ProcessParameter;
import jp.co.ndensan.reams.db.dbd.service.core.riyoshafutanwariaihantei.RiyoshaFutanWariaiHantei;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;

/**
 * バッチ設計_DBCMNK1002_利用者負担割合判定（共通）のクラスです。
 *
 * @reamsid_L DBC-4950-030 liuyang
 */
public class DBC180022_RiyoshaFutanwariaiHanteiSub extends BatchFlowBase<DBD180022_RiyoshaFutanwariaiHanteiSubParameter> {

    private static final int NUM12 = 12;
    private static final RString 年次 = new RString("1");
    private static final RString 異動 = new RString("2");
    private static final RString BATCHID_WORK2 = new RString("DBC180023_RiyoshaFutanwariaiHanteiSubTaishoshaTsuika");
    private static final RString BATCHID_WORK4 = new RString("DBC180024_RiyoshaFutanwariaiHanteiSubTsukibetsuTaishosha");
    private static final RString BATCHID_WORK7 = new RString("DBC180025_RiyoshaFutanwariaiHanteiSubGetsujiShori");
    private static final String FLOW_WORK2 = "work2";
    private static final String FLOW_WORK3 = "work3";
    private static final String FLOW_WORK4 = "work4";
    private static final String FLOW_WORK5 = "work5";
    private static final String FLOW_WORK51 = "work51";
    private static final String FLOW_WORK6 = "work6";
    private static final String FLOW_WORK7 = "work7";
    private DBD180020ProcessParameter prm;
    private DBD180020ProcessParameter loopPrm;
    private DBD180020ProcessParameter processPrm;
    private RiyoshaFutanWariaiHanteiUtil util;
    private RiyoshaFutanWariaiHantei service;
    private RString shoriKubun;

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
        processPrm = util.toProcessParameter(getParameter());
        shoriKubun = getParameter().getShoriKubun();
        prm = util.toProcessParameter(getParameter(), false, 0);
    }

    @Override
    protected void defineFlow() {
        executeStep(FLOW_WORK2);
        executeStep(FLOW_WORK3);
        executeStep(FLOW_WORK4);
        if (異動.equals(shoriKubun)) {
            for (int i = 0; i < NUM12; i++) {
                loopPrm = util.toProcessParameter(getParameter(), true, i);
                executeStep(FLOW_WORK5);
            }
            executeStep(FLOW_WORK7);
        }
        if (年次.equals(shoriKubun)) {
            executeStep(FLOW_WORK51);
            executeStep(FLOW_WORK6);
        }
    }

    @Step(FLOW_WORK2)
    IBatchFlowCommand work2() {
        return otherBatchFlow(BATCHID_WORK2, SubGyomuCode.DBC介護給付,
                getParameter().toDBC180023_RiyoshaFutanwariaiHanteiSubTaishoshaTsuikaParameter()).define();
    }

    @Step(FLOW_WORK3)
    IBatchFlowCommand work3() {
        return loopBatch(HanteiTaishoshaTuikaProcess.class).arguments(processPrm).define();
    }

    @Step(FLOW_WORK4)
    IBatchFlowCommand work4() {
        return otherBatchFlow(BATCHID_WORK4, SubGyomuCode.DBC介護給付,
                getParameter().toDBC180024_RiyoshaFutanwariaiHanteiSubTsukibetsuTaishoshaParameter()).define();
    }

    @Step(FLOW_WORK5)
    IBatchFlowCommand work5() {
        return loopBatch(SeikatsuHogoGaitoJohoTempProcess.class).arguments(loopPrm).define();
    }

    @Step(FLOW_WORK51)
    IBatchFlowCommand work51() {
        return loopBatch(SeikatsuHogoGaitoJohoTempProcess.class).arguments(prm).define();
    }

    @Step(FLOW_WORK6)
    IBatchFlowCommand work6() {
        return loopBatch(FutanWariaiHanteiNenziProcess.class).arguments(processPrm).define();
    }

    @Step(FLOW_WORK7)
    IBatchFlowCommand work7() {
        return otherBatchFlow(BATCHID_WORK7, SubGyomuCode.DBC介護給付,
                getParameter().toDBC180025_RiyoshaFutanwariaiHanteiSubGetsujiShoriParameter()).define();
    }
}
