/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow.dbd8100201;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd8100201.FuicchiCsvProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd8100201.GaitouIchirannCsvProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd8100201.HikazeiNennkinTaishouSyaJohoCsvCreateProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd8100201.HikazeiNennkinnTaishouSyaDeleteProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd8100201.HikazeiNennkinnTaishouSyaUpdateProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd8100201.NennkinnBanngouCsvProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd8100201.SeinenngappiCsvProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd8100201.SyoriHidukeKanriMasterUpdateProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd8100201.TorikomiProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd8100201.HikazeiNennkinTaishouSyaJohoTorikomiBatchParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd8100202.HikazeNenkinTaishoshaDouteiBatchParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd8100201.TorikomiProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 非課税年金対象者情報取込フロークラスです．
 *
 * @reamsid_L DBD-4910-040 x_lilh
 */
public class HikazeiNennkinTaishouSyaJohoTorikomiFlow extends BatchFlowBase<HikazeiNennkinTaishouSyaJohoTorikomiBatchParameter> {

    public static final RString 出力区分_0 = new RString("0");
    public static final RString テスト処理_1 = new RString("1");
    public static final RString HIKAZENENKINTAISHOSHADOUTEIFLOW = new RString("HikazeNenkinTaishoshaDouteiFlow");

    private static final String 取込データ一時作成 = "取込データ一時作成";
    private static final String 非課税年金対象者同定 = "非課税年金対象者同定";
    private static final String 非課税年金対象者情報一覧CSV作成 = "非課税年金対象者情報一覧CSV作成";
    private static final String 非課税年金対象者情報_該当一覧CSV = "非課税年金対象者情報_該当一覧CSV";
    private static final String 非課税年金対象者情報_不一致CSV = "非課税年金対象者情報_不一致CSV";
    private static final String 非課税年金対象者情報_生年月日CSV = "非課税年金対象者情報_生年月日CSV";
    private static final String 非課税年金対象者情報_年金番号CSV = "非課税年金対象者情報_年金番号CSV";
    private static final String 削除非課税年金対象者 = "削除非課税年金対象者";
    private static final String 更新非課税年金対象者 = "更新非課税年金対象者";
    private static final String 処理日付管理マスタ更新 = "処理日付管理マスタ更新";

    @Override
    protected void defineFlow() {
        executeStep(取込データ一時作成);
        executeStep(非課税年金対象者同定);
        executeStep(非課税年金対象者情報一覧CSV作成);
        executeStep(非課税年金対象者情報_該当一覧CSV);
        executeStep(非課税年金対象者情報_不一致CSV);
        executeStep(非課税年金対象者情報_生年月日CSV);
        executeStep(非課税年金対象者情報_年金番号CSV);
        executeStep(削除非課税年金対象者);
        executeStep(更新非課税年金対象者);
        executeStep(処理日付管理マスタ更新);
    }

    @Step(取込データ一時作成)
    protected IBatchFlowCommand reportProcess() {
        return loopBatch(TorikomiProcess.class)
                .arguments(createProcessParameter())
                .define();
    }

    @Step(非課税年金対象者同定)
    protected IBatchFlowCommand callHikazeNenkinTaishoshaDouteiFlow() {
        return otherBatchFlow(HIKAZENENKINTAISHOSHADOUTEIFLOW, SubGyomuCode.DBD介護受給,
                createHikazeNenkinTaishoshaDouteiBatchParameter()).define();
    }

    @Step(非課税年金対象者情報一覧CSV作成)
    protected IBatchFlowCommand hikazeiNennkinTaishouSyaJohoCsvCreateProcess() {
        return loopBatch(HikazeiNennkinTaishouSyaJohoCsvCreateProcess.class).define();
    }

    @Step(非課税年金対象者情報_該当一覧CSV)
    protected IBatchFlowCommand gaitouIchirannCsvProcess() {
        return loopBatch(GaitouIchirannCsvProcess.class).define();
    }

    @Step(非課税年金対象者情報_不一致CSV)
    protected IBatchFlowCommand fuicchiCsvProcess() {
        return loopBatch(FuicchiCsvProcess.class).define();
    }

    @Step(非課税年金対象者情報_生年月日CSV)
    protected IBatchFlowCommand seinenngappiCsvProcess() {
        return loopBatch(SeinenngappiCsvProcess.class).define();
    }

    @Step(非課税年金対象者情報_年金番号CSV)
    protected IBatchFlowCommand nennkinnBanngouCsvProcess() {
        return loopBatch(NennkinnBanngouCsvProcess.class).define();
    }

    @Step(削除非課税年金対象者)
    protected IBatchFlowCommand hikazeiNennkinnTaishouSyaDeleteProcess() {
        return loopBatch(HikazeiNennkinnTaishouSyaDeleteProcess.class).define();
    }

    @Step(更新非課税年金対象者)
    protected IBatchFlowCommand hikazeiNennkinnTaishouSyaUpdateProcess() {
        return loopBatch(HikazeiNennkinnTaishouSyaUpdateProcess.class).define();
    }

    @Step(処理日付管理マスタ更新)
    protected IBatchFlowCommand syoriHidukeKanriMasterUpdateProcess() {
        return loopBatch(SyoriHidukeKanriMasterUpdateProcess.class).define();
    }

    private TorikomiProcessParameter createProcessParameter() {
        HikazeiNennkinTaishouSyaJohoTorikomiBatchParameter parameter = getParameter();
        return parameter.toTorikomiProcessParameter();
    }

    private HikazeNenkinTaishoshaDouteiBatchParameter createHikazeNenkinTaishoshaDouteiBatchParameter() {
        HikazeiNennkinTaishouSyaJohoTorikomiBatchParameter batchParameter = getParameter();
        HikazeNenkinTaishoshaDouteiBatchParameter subParameter = new HikazeNenkinTaishoshaDouteiBatchParameter();
        subParameter.set年度(batchParameter.get処理年度());
        subParameter.set対象月(batchParameter.get対象月());
        subParameter.set処理区分(batchParameter.get処理区分());
        return subParameter;
    }
}
