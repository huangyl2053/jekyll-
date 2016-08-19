/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow.dbd8100203;

import static jp.co.ndensan.reams.db.dbd.batchcontroller.flow.dbd8100201.HikazeiNennkinTaishouSyaJohoTorikomiFlow.HIKAZENENKINTAISHOSHADOUTEIFLOW;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd8100203.HikazeiNennkinnTaishousyaUpdateProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd8100203.MiDouteiDataCreateProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd8100203.SokyuuFuicchiCsvProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd8100203.SokyuuGaitouIchirannCsvProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd8100203.SokyuuSeinenngappiCsvProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd8100202.HikazeNenkinTaishoshaDouteiBatchParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd8100203.SokyuHikazeiNenkinBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;

/**
 * 遡及非課税年金対象者同定フロークラスです．
 *
 * @reamsid_L DBD-4910-050 x_lilh
 */
public class SokyuHikazeiNenkinTaishousyaDouteiFlow extends BatchFlowBase<SokyuHikazeiNenkinBatchParameter> {

    private static final String 未同定データ作成 = "未同定データ作成";
    private static final String 非課税年金対象者同定 = "非課税年金対象者同定";
    private static final String 非課税年金対象者情報_遡及該当一覧CSV = "非課税年金対象者情報_遡及該当一覧CSV";
    private static final String 非課税年金対象者情報_遡及不一致CSV = "非課税年金対象者情報_遡及不一致CSV";
    private static final String 非課税年金対象者情報_生年月日CSV = "非課税年金対象者情報_生年月日CSV";
    private static final String 非課税年金対象者更新 = "非課税年金対象者更新";

    @Override
    protected void defineFlow() {
        executeStep(未同定データ作成);
        executeStep(非課税年金対象者同定);
        executeStep(非課税年金対象者情報_遡及該当一覧CSV);
        executeStep(非課税年金対象者情報_遡及不一致CSV);
        executeStep(非課税年金対象者情報_生年月日CSV);
        executeStep(非課税年金対象者更新);
    }

    /**
     * 未同定データ作成.
     *
     * @return IBatchFlowCommand
     */
    @Step(未同定データ作成)
    protected IBatchFlowCommand jissekiDataIchijiSakuseiProcess() {
        return loopBatch(MiDouteiDataCreateProcess.class).define();
    }

    /**
     * 非課税年金対象者同定
     *
     * @return IBatchFlowCommand
     */
    @Step(非課税年金対象者同定)
    protected IBatchFlowCommand callHikazeNenkinTaishoshaDouteiFlow() {
        return otherBatchFlow(HIKAZENENKINTAISHOSHADOUTEIFLOW, SubGyomuCode.DBD介護受給,
                createHikazeNenkinTaishoshaDouteiBatchParameter()).define();
    }

    /**
     * 非課税年金対象者情報_遡及該当一覧CSV
     *
     * @return IBatchFlowCommand
     */
    @Step(非課税年金対象者情報_遡及該当一覧CSV)
    protected IBatchFlowCommand sokyuuGaitouIchirannCsvProcess() {
        return loopBatch(SokyuuGaitouIchirannCsvProcess.class).arguments(getParameter().toSokyuuGaitouIchirannCsvProcessParameter()).define();
    }

    /**
     * 非課税年金対象者情報_遡及不一致CSV.
     *
     * @return IBatchFlowCommand
     */
    @Step(非課税年金対象者情報_遡及不一致CSV)
    protected IBatchFlowCommand sokyuuFuicchiCsvProcess() {
        return loopBatch(SokyuuFuicchiCsvProcess.class).arguments(getParameter().toSokyuuFuicchiCsvProcessParameter()).define();
    }

    /**
     * 非課税年金対象者情報_生年月日CSV.
     *
     * @return IBatchFlowCommand
     */
    @Step(非課税年金対象者情報_生年月日CSV)
    protected IBatchFlowCommand sokyuuSeinenngappiCsvProcess() {
        return loopBatch(SokyuuSeinenngappiCsvProcess.class).arguments(getParameter().toSokyuuSeinenngappiCsvProcessParameter()).define();
    }

    /**
     * 非課税年金対象者更新.
     *
     * @return IBatchFlowCommand
     */
    @Step(非課税年金対象者更新)
    protected IBatchFlowCommand hikazeiNennkinnTaishousyaUpdateProcess() {
        return loopBatch(HikazeiNennkinnTaishousyaUpdateProcess.class).define();
    }

    private HikazeNenkinTaishoshaDouteiBatchParameter createHikazeNenkinTaishoshaDouteiBatchParameter() {
        SokyuHikazeiNenkinBatchParameter batchParameter = getParameter();
        HikazeNenkinTaishoshaDouteiBatchParameter subParameter = new HikazeNenkinTaishoshaDouteiBatchParameter();
        subParameter.set年度(batchParameter.get処理年度());
        subParameter.set対象月(batchParameter.get処理月());
        subParameter.set処理区分(batchParameter.get処理区分());
        return subParameter;
    }
}
