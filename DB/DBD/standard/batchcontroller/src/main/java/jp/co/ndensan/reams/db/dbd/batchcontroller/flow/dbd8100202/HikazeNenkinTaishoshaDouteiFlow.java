/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow.dbd8100202;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd8100202.ChofukuTorikomiDataDeleteShoriProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd8100202.HikazeNenkinTaishoFirProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd8100202.JissekiDataIchijiSakuseiProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd8100202.NenkinNoCheckListProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd8100202.ShimeiKanaTotsugoGaitousyaNasiProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd8100202.ShimeiKanaTotsugoKensuProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd8100202.ShimeiKanaTotsugoResultProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd8100202.ShimeiKanaTotsugoSedProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd8100202.ShimeiKanaTotsugoTouItuninProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd8100202.HikazeNenkinTaishoshaDouteiBatchParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd8100202.JissekiDataIchijiSakuseiProcessParamter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 非課税年金対象者同定フロークラスです．
 *
 * @reamsid_L DBD-4910-040 x_lilh
 */
public class HikazeNenkinTaishoshaDouteiFlow extends BatchFlowBase<HikazeNenkinTaishoshaDouteiBatchParameter> {

    private static final String 実績データ一時作成 = "実績データ一時作成";
    private static final String 重複取込データ除外処理 = "重複取込データ除外処理";
    private static final String 年金番号突合_非課税年金対象者情報１_登録 = "年金番号突合_非課税年金対象者情報１_登録";
    private static final String 年金番号チェックリスト = "年金番号チェックリスト";
    private static final String 年金番号突合_該当年金情報なし = "年金番号突合_該当年金情報なし";
    private static final String 氏名カナ突合_該当者なし情報 = "氏名カナ突合_該当者なし情報";
    private static final String 氏名カナ突合結果件数一時 = "氏名カナ突合結果件数一時";
    private static final String 氏名カナ突合結果一時 = "氏名カナ突合結果一時";
    private static final String 氏名カナ突合_非課税年金対象者情報２_登録 = "氏名カナ突合_非課税年金対象者情報２_登録";
    private static final String 氏名カナ突合_同一人情報_登録 = "氏名カナ突合_同一人情報_登録";

    @Override
    protected void defineFlow() {
        executeStep(実績データ一時作成);
        executeStep(重複取込データ除外処理);
        executeStep(年金番号突合_非課税年金対象者情報１_登録);
        executeStep(年金番号突合_該当年金情報なし);
        executeStep(氏名カナ突合結果一時);
        executeStep(氏名カナ突合結果件数一時);
        executeStep(氏名カナ突合_非課税年金対象者情報２_登録);
        executeStep(氏名カナ突合_該当者なし情報);
        executeStep(氏名カナ突合_同一人情報_登録);
    }

    /**
     * 実績データ一時作成.
     *
     * @return IBatchFlowCommand
     */
    @Step(実績データ一時作成)
    protected IBatchFlowCommand jissekiDataIchijiSakuseiProcess() {
        return loopBatch(JissekiDataIchijiSakuseiProcess.class)
                .arguments(createProcessParameter())
                .define();
    }

    /**
     * 重複取込データ除外処理
     *
     * @return IBatchFlowCommand
     */
    @Step(重複取込データ除外処理)
    protected IBatchFlowCommand chofukuTorikomiDataDeleteShoriProcess() {
        return loopBatch(ChofukuTorikomiDataDeleteShoriProcess.class).arguments(createProcessParameter()).define();
    }

    /**
     * 年金番号突合_非課税年金対象者情報１_登録
     *
     * @return IBatchFlowCommand
     */
    @Step(年金番号突合_非課税年金対象者情報１_登録)
    protected IBatchFlowCommand hikazeNenkinTaishoFirProcess() {
        return loopBatch(HikazeNenkinTaishoFirProcess.class).arguments(getParameter().toHikazeNenkinTaishoFirProcessParameter()).define();
    }

    /**
     * 年金番号突合_該当年金情報なし
     *
     * @return IBatchFlowCommand
     */
    @Step(年金番号突合_該当年金情報なし)
    protected IBatchFlowCommand nenkinNoTotsugoGaitouJohoNasiProcess() {
        return loopBatch(HikazeNenkinTaishoFirProcess.class).define();
    }

    /**
     * 年金番号チェックリスト
     *
     * @return IBatchFlowCommand
     */
    @Step(年金番号チェックリスト)
    protected IBatchFlowCommand nenkinNoCheckListProcess() {
        return loopBatch(NenkinNoCheckListProcess.class).arguments(getParameter().toNenkinNoCheckListProcessParmeter()).define();
    }

    /**
     * 氏名カナ突合結果一時
     *
     * @return IBatchFlowCommand
     */
    @Step(氏名カナ突合結果一時)
    protected IBatchFlowCommand shimeiKanaTotsugoResultProcess() {
        return loopBatch(ShimeiKanaTotsugoResultProcess.class).define();
    }

    /**
     * 氏名カナ突合結果件数一時
     *
     * @return IBatchFlowCommand
     */
    @Step(氏名カナ突合結果件数一時)
    protected IBatchFlowCommand shimeiKanaTotsugoKensuProcess() {
        return loopBatch(ShimeiKanaTotsugoKensuProcess.class).define();
    }

    /**
     * 氏名カナ突合_非課税年金対象者情報２_登録
     *
     * @return IBatchFlowCommand
     */
    @Step(氏名カナ突合_非課税年金対象者情報２_登録)
    protected IBatchFlowCommand shimeiKanaTotsugoSedProcess() {
        return loopBatch(ShimeiKanaTotsugoSedProcess.class)
                .arguments(getParameter().toShimeiKanaTotsugoSedProcessParameter())
                .define();
    }

    /**
     * 氏名カナ突合_該当者なし情報
     *
     * @return IBatchFlowCommand
     */
    @Step(氏名カナ突合_該当者なし情報)
    protected IBatchFlowCommand shimeiKanaTotsugoGaitousyaNasiProcess() {
        return loopBatch(ShimeiKanaTotsugoGaitousyaNasiProcess.class)
                .arguments(getParameter().toShimeiKanaTotsugoGaitousyaNasiProcessParameter())
                .define();
    }

    /**
     * 氏名カナ突合_同一人情報_登録
     *
     * @return IBatchFlowCommand
     */
    @Step(氏名カナ突合_同一人情報_登録)
    protected IBatchFlowCommand shimeiKanaTotsugoTouItuninProcess() {
        return loopBatch(ShimeiKanaTotsugoTouItuninProcess.class)
                .arguments(getParameter().toShimeiKanaTotsugoTouItuninProcessParameter())
                .define();
    }

    private JissekiDataIchijiSakuseiProcessParamter createProcessParameter() {
        HikazeNenkinTaishoshaDouteiBatchParameter parameter = getParameter();
        return parameter.toJissekiDataIchijiSakuseiProcessParamter();
    }
}
