/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD301020.HikazeiNennkinnTaishousyaUpdateProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD301020.MiDouteiDataCreateProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD301020.SokyuuFuicchiCsvProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD301020.SokyuuGaitouIchirannCsvProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD301020.SokyuuSeinenngappiCsvProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD301020.DBD301020_SokyuHikazeiNenkinTaishoshaDoteiParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd8100202.HikazeNenkinTaishoshaDouteiBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 遡及非課税年金対象者同定フロークラスです．
 *
 * @reamsid_L DBD-4910-050 x_lilh
 */
public class DBD301020_SokyuHikazeiNenkinTaishoshaDotei extends BatchFlowBase<DBD301020_SokyuHikazeiNenkinTaishoshaDoteiParameter> {

    /**
     * 非課税年金対象者同定フロー
     */
    private static final RString HIKAIFLOW = new RString("HikazeNenkinTaishoshaDouteiFlow");

    private static final String 未同定データ作成 = "未同定データ作成";
    private static final String 非課税年金対象者同定 = "非課税年金対象者同定";
    private static final String 非課税年金対象者情報_遡及該当一覧CSV = "非課税年金対象者情報_遡及該当一覧CSV";
    private static final String 非課税年金対象者情報_遡及不一致CSV = "非課税年金対象者情報_遡及不一致CSV";
    private static final String 非課税年金対象者情報_生年月日CSV = "非課税年金対象者情報_生年月日CSV";
    private static final String 非課税年金対象者更新 = "非課税年金対象者更新";
    private static final RString テスト処理 = new RString("1");

    @Override
    protected void defineFlow() {
        executeStep(未同定データ作成);
        executeStep(非課税年金対象者同定);
        executeStep(非課税年金対象者情報_遡及該当一覧CSV);
        executeStep(非課税年金対象者情報_遡及不一致CSV);
        executeStep(非課税年金対象者情報_生年月日CSV);
        if (!テスト処理.equals(getParameter().getテスト処理())) {
            executeStep(非課税年金対象者更新);
        }
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
        return otherBatchFlow(HIKAIFLOW, SubGyomuCode.DBD介護受給,
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
        DBD301020_SokyuHikazeiNenkinTaishoshaDoteiParameter batchParameter = getParameter();
        HikazeNenkinTaishoshaDouteiBatchParameter subParameter = new HikazeNenkinTaishoshaDouteiBatchParameter();
        subParameter.set年度(batchParameter.get処理年度());
        subParameter.set対象月(batchParameter.get処理月());
        subParameter.set処理区分(batchParameter.get処理区分());
        return subParameter;
    }
}
