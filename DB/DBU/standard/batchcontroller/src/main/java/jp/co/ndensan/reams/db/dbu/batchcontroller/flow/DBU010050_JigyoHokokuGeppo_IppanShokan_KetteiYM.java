/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010050.JigyoHokokuGeppoIppanShokanDBU011200Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010050.JigyoHokokuGeppoIppanShokanDBU011391Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010050.JigyoHokokuGeppoIppanShokanDBU011392Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010050.JigyoHokokuGeppoIppanShokanDBU011393Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010050.JigyoHokokuGeppoIppanShokanDBU011400Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010050.JigyoHokokuGeppoIppanShokanDBU200002Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010050.JigyoHokokuGeppoIppanShokanDBU300006Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010050.JigyoHokokuGeppoIppanShokanDBU300007Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010050.JigyoHokokuGeppoIppanShokanTorokuProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010050.JigyoHokokuKetteiYMTokeiMotoDataProcess;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU010050.DBU010050_JigyoHokokuGeppo_IppanShokan_KetteiYMParamter;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.PrintControlKubun;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.ShukeiNo;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 事業報告月報_一般状況のバッチフロークラスです。
 *
 * @reamsid_L DBU-5550-030 suguangjun
 */
public class DBU010050_JigyoHokokuGeppo_IppanShokan_KetteiYM extends BatchFlowBase<DBU010050_JigyoHokokuGeppo_IppanShokan_KetteiYMParamter> {

    private static final String 事業報告償還分決定年月統計元データ = "事業報告償還分決定年月統計元データ";
    private static final String 帳票出力_処理確認リスト = "帳票出力_処理確認リスト";
    private static final String 根拠CSV作成_DBU011200 = "根拠CSV作成_DBU011200";
    private static final String 根拠CSV作成_DBU011400 = "根拠CSV作成_DBU011400";
    private static final String 根拠CSV作成_DBU011391 = "根拠CSV作成_DBU011391";
    private static final String 根拠CSV作成_DBU011392 = "根拠CSV作成_DBU011392";
    private static final String 根拠CSV作成_DBU011393 = "根拠CSV作成_DBU011393";
    private static final String 事業報告統計データ登録 = "事業報告統計データ登録";
    private static final String DBU300006報告月報_一般状況 = "DBU300006報告月報_一般状況";
    private static final String DBU300007報告月報_一般状況 = "DBU300007報告月報_一般状況";
    private DBU010050_JigyoHokokuGeppo_IppanShokan_KetteiYMParamter parameter;
    private FileSpoolManager manager;

    @Override
    protected void defineFlow() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                new EucEntityId("DBU011400"), UzUDE0831EucAccesslogFileType.Csv);
        parameter = getParameter();
        parameter.setCsvFilePath(manager.getEucOutputDirectry());
        parameter.setManager(manager);
        if (PrintControlKubun.集計のみ.getコード().equals(getParameter().getプリントコントロール区分())) {
            executeStep(事業報告償還分決定年月統計元データ);
            executeStep(帳票出力_処理確認リスト);
            executeStep(根拠CSV作成_DBU011200);
            executeStep(根拠CSV作成_DBU011391);
            executeStep(根拠CSV作成_DBU011392);
            executeStep(根拠CSV作成_DBU011393);
            executeStep(根拠CSV作成_DBU011400);
            executeStep(事業報告統計データ登録);
        } else if (PrintControlKubun.集計後印刷.getコード().equals(getParameter().getプリントコントロール区分())) {
            executeStep(事業報告償還分決定年月統計元データ);
            executeStep(帳票出力_処理確認リスト);
            executeStep(根拠CSV作成_DBU011200);
            executeStep(根拠CSV作成_DBU011391);
            executeStep(根拠CSV作成_DBU011392);
            executeStep(根拠CSV作成_DBU011393);
            executeStep(根拠CSV作成_DBU011400);
            executeStep(事業報告統計データ登録);
        } else if (PrintControlKubun.過去分の印刷.getコード().equals(getParameter().getプリントコントロール区分())) {
            executeStep(DBU300006報告月報_一般状況);
            executeStep(DBU300007報告月報_一般状況);
        }
    }

    /**
     * temp事業報告償還分決定年月統計元データ作成処理です。
     *
     * @return JigyoHokokuKetteiYMTokeiMotoDataProcess
     */
    @Step(事業報告償還分決定年月統計元データ)
    protected IBatchFlowCommand create事業報告償還分決定年月統計元データプロセス() {
        return loopBatch(JigyoHokokuKetteiYMTokeiMotoDataProcess.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 処理確認リスト帳票の出力処理です。
     *
     * @return JigyoHokokuGeppoIppanShokanDBU200002Process
     */
    @Step(帳票出力_処理確認リスト)
    protected IBatchFlowCommand create処理確認リスト帳票プロセス() {
        return loopBatch(JigyoHokokuGeppoIppanShokanDBU200002Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 根拠CSV作成_DBU011200の出力処理です。
     *
     * @return JigyoHokokuGeppoIppanShokanDBU011200Process
     */
    @Step(根拠CSV作成_DBU011200)
    protected IBatchFlowCommand create根拠CSV作成_DBU011200プロセス() {
        getParameter().set集計番号(ShukeiNo.一般状況_12_居宅介護_介護予防_サービス受給者数.getコード());
        return loopBatch(JigyoHokokuGeppoIppanShokanDBU011200Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 根拠CSV作成_DBU011400の出力処理です。
     *
     * @return JigyoHokokuDataTorokuProcess
     */
    @Step(根拠CSV作成_DBU011400)
    protected IBatchFlowCommand create根拠CSV作成_DBU011400プロセス() {
        getParameter().set集計番号(ShukeiNo.一般状況_13_地域密着型_介護予防_サービス受給者数.getコード());
        return loopBatch(JigyoHokokuGeppoIppanShokanDBU011400Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 根拠CSV作成_DBU011391の出力処理です。
     *
     * @return JigyoHokokuDataTorokuProcess
     */
    @Step(根拠CSV作成_DBU011391)
    protected IBatchFlowCommand create根拠CSV作成_DBU011391プロセス() {
        getParameter().set集計番号(ShukeiNo.一般状況_14_施設介護サービス受給者数_介護老人福祉施設.getコード());
        return loopBatch(JigyoHokokuGeppoIppanShokanDBU011391Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 根拠CSV作成_DBU011392の出力処理です。
     *
     * @return JigyoHokokuDataTorokuProcess
     */
    @Step(根拠CSV作成_DBU011392)
    protected IBatchFlowCommand create根拠CSV作成_DBU011392プロセス() {
        getParameter().set集計番号(ShukeiNo.一般状況_15_施設介護サービス受給者数_介護老人保健施設.getコード());
        return loopBatch(JigyoHokokuGeppoIppanShokanDBU011392Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 根拠CSV作成_DBU011393の出力処理です。
     *
     * @return JigyoHokokuDataTorokuProcess
     */
    @Step(根拠CSV作成_DBU011393)
    protected IBatchFlowCommand create根拠CSV作成_DBU011393プロセス() {
        getParameter().set集計番号(ShukeiNo.一般状況_16_施設介護サービス受給者数_介護療養型医療施設_総数含む.getコード());
        return loopBatch(JigyoHokokuGeppoIppanShokanDBU011393Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 事業報告統計データ登録処理です。
     *
     * @return JigyoHokokuGeppoIppanShokanTorokuProcess
     */
    @Step(事業報告統計データ登録)
    protected IBatchFlowCommand create事業報告統計データ登録プロセス() {
        return loopBatch(JigyoHokokuGeppoIppanShokanTorokuProcess.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * DBU300006報告月報_一般状況の出力処理です。
     *
     * @return JigyoHokokuDataTorokuProcess
     */
    @Step(DBU300006報告月報_一般状況)
    protected IBatchFlowCommand createDBU300006報告月報_一般状況帳票プロセス() {
        return loopBatch(JigyoHokokuGeppoIppanShokanDBU300006Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 介護保険事業状況報告資料の出力処理です。
     *
     * @return JigyoHokokuDataTorokuProcess
     */
    @Step(DBU300007報告月報_一般状況)
    protected IBatchFlowCommand createDBU300007報告月報_一般状況帳票プロセス() {
        return loopBatch(JigyoHokokuGeppoIppanShokanDBU300007Process.class).arguments(getParameter().toProcessParamter()).define();
    }
}
