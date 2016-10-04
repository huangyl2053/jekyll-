/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010030.JigyoHokokuGeppoDBU011200Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010030.JigyoHokokuGeppoDBU011391Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010030.JigyoHokokuGeppoDBU011392Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010030.JigyoHokokuGeppoDBU011393Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010030.JigyoHokokuGeppoDBU011400Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010030.JigyoHokokuGeppoDBU031200Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010030.JigyoHokokuGeppoDBU031391Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010030.JigyoHokokuGeppoDBU031392Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010030.JigyoHokokuGeppoDBU031393Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010030.JigyoHokokuGeppoDBU031400Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010030.JigyoHokokuGeppoDataTorokuProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010030.JigyoHokokuGeppoReportDBU300006Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010030.JigyoHokokuGeppoReportDBU300007Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010030.ShoriKekkaKakuninListProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010030.TempJigyoHokokuTokeiMotoDataProcess;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU010030.DBU010030_JigyoHokokuGeppo_IppanGenbutsuParamter;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.PrintControlKubun;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 事業報告月報_一般現物のバッチフロークラスです。
 *
 * @reamsid_L DBU-5540-030 suguangjun
 */
public class DBU010030_JigyoHokokuGeppo_IppanGenbutsu extends BatchFlowBase<DBU010030_JigyoHokokuGeppo_IppanGenbutsuParamter> {

    private static final String 事業報告統計元データ = "事業報告統計元データ";
    private static final String 帳票出力_処理確認リスト = "帳票出力_処理確認リスト";
    private static final String 根拠CSV作成_DBU011200 = "根拠CSV作成_DBU011200";
    private static final String 根拠CSV作成_DBU011400 = "根拠CSV作成_DBU011400";
    private static final String 根拠CSV作成_DBU011391 = "根拠CSV作成_DBU011391";
    private static final String 根拠CSV作成_DBU011392 = "根拠CSV作成_DBU011392";
    private static final String 根拠CSV作成_DBU011393 = "根拠CSV作成_DBU011393";
    private static final String 根拠CSV作成_DBU031200 = "根拠CSV作成_DBU031200";
    private static final String 根拠CSV作成_DBU031400 = "根拠CSV作成_DBU031400";
    private static final String 根拠CSV作成_DBU031391 = "根拠CSV作成_DBU031391";
    private static final String 根拠CSV作成_DBU031392 = "根拠CSV作成_DBU031392";
    private static final String 根拠CSV作成_DBU031393 = "根拠CSV作成_DBU031393";
    private static final String 事業報告統計データ登録 = "事業報告統計データ登録";
    private static final String 新様式一般状況 = "新様式一般状況";
    private static final String 介護保険事業状況報告資料 = "介護保険事業状況報告資料";
    private DBU010030_JigyoHokokuGeppo_IppanGenbutsuParamter parameter;
    private FileSpoolManager manager;

    @Override
    protected void defineFlow() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                new EucEntityId("DBU011393"), UzUDE0831EucAccesslogFileType.Csv);
        parameter = getParameter();
        parameter.setCsvFilePath(manager.getEucOutputDirectry());
        parameter.setManager(manager);
        if (PrintControlKubun.集計のみ.getコード().equals(getParameter().getプリントコントロール区分())) {
            executeStep(事業報告統計元データ);
            executeStep(帳票出力_処理確認リスト);
            if (new RString("1").equals(getParameter().get給付集計区分())) {
                executeStep(根拠CSV作成_DBU011200);
                executeStep(根拠CSV作成_DBU011400);
                executeStep(根拠CSV作成_DBU011391);
                executeStep(根拠CSV作成_DBU011392);
                executeStep(根拠CSV作成_DBU011393);
            } else if (new RString("2").equals(getParameter().get給付集計区分())) {
                executeStep(根拠CSV作成_DBU031200);
                executeStep(根拠CSV作成_DBU031400);
                executeStep(根拠CSV作成_DBU031391);
                executeStep(根拠CSV作成_DBU031392);
                executeStep(根拠CSV作成_DBU031393);
            }
            executeStep(事業報告統計データ登録);
        } else if (PrintControlKubun.集計後印刷.getコード().equals(getParameter().getプリントコントロール区分())) {
            executeStep(事業報告統計元データ);
            executeStep(帳票出力_処理確認リスト);
            if (new RString("1").equals(getParameter().get給付集計区分())) {
                executeStep(根拠CSV作成_DBU011200);
                executeStep(根拠CSV作成_DBU011400);
                executeStep(根拠CSV作成_DBU011391);
                executeStep(根拠CSV作成_DBU011392);
                executeStep(根拠CSV作成_DBU011393);
            } else if (new RString("2").equals(getParameter().get給付集計区分())) {
                executeStep(根拠CSV作成_DBU031200);
                executeStep(根拠CSV作成_DBU031400);
                executeStep(根拠CSV作成_DBU031391);
                executeStep(根拠CSV作成_DBU031392);
                executeStep(根拠CSV作成_DBU031393);
            }
            executeStep(事業報告統計データ登録);
            executeStep(新様式一般状況);
            executeStep(介護保険事業状況報告資料);
        } else if (PrintControlKubun.過去分の印刷.getコード().equals(getParameter().getプリントコントロール区分())) {
            executeStep(新様式一般状況);
            executeStep(介護保険事業状況報告資料);
        }
    }

    /**
     * temp事業報告統計元データ作成処理です。
     *
     * @return TempJigyoHokokuTokeiMotoDataProcess
     */
    @Step(事業報告統計元データ)
    protected IBatchFlowCommand create事業報告統計元データプロセス() {
        return loopBatch(TempJigyoHokokuTokeiMotoDataProcess.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 処理確認リスト帳票の出力処理です。
     *
     * @return ShoriKekkaKakuninListProcess
     */
    @Step(帳票出力_処理確認リスト)
    protected IBatchFlowCommand create処理確認リスト帳票プロセス() {
        return loopBatch(ShoriKekkaKakuninListProcess.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 根拠CSV作成_DBU011200の出力処理です。
     *
     * @return JigyoHokokuGeppoDBU011200Process
     */
    @Step(根拠CSV作成_DBU011200)
    protected IBatchFlowCommand create根拠CSV作成_DBU011200プロセス() {
        return loopBatch(JigyoHokokuGeppoDBU011200Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 根拠CSV作成_DBU011400の出力処理です。
     *
     * @return JigyoHokokuGeppoDBU011400Process
     */
    @Step(根拠CSV作成_DBU011400)
    protected IBatchFlowCommand create根拠CSV作成_DBU011400プロセス() {
        return loopBatch(JigyoHokokuGeppoDBU011400Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 根拠CSV作成_DBU011391の出力処理です。
     *
     * @return JigyoHokokuGeppoDBU011391Process
     */
    @Step(根拠CSV作成_DBU011391)
    protected IBatchFlowCommand create根拠CSV作成_DBU011391プロセス() {
        return loopBatch(JigyoHokokuGeppoDBU011391Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 根拠CSV作成_DBU011392の出力処理です。
     *
     * @return JigyoHokokuGeppoDBU011392Process
     */
    @Step(根拠CSV作成_DBU011392)
    protected IBatchFlowCommand create根拠CSV作成_DBU011392プロセス() {
        return loopBatch(JigyoHokokuGeppoDBU011392Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 根拠CSV作成_DBU011393の出力処理です。
     *
     * @return JigyoHokokuGeppoDBU011393Process
     */
    @Step(根拠CSV作成_DBU011393)
    protected IBatchFlowCommand create根拠CSV作成_DBU011393プロセス() {
        return loopBatch(JigyoHokokuGeppoDBU011393Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 根拠CSV作成_DBU031200の出力処理です。
     *
     * @return JigyoHokokuGeppoDBU031200Process
     */
    @Step(根拠CSV作成_DBU031200)
    protected IBatchFlowCommand create根拠CSV作成_DBU031200プロセス() {
        return loopBatch(JigyoHokokuGeppoDBU031200Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 根拠CSV作成_DBU031400の出力処理です。
     *
     * @return JigyoHokokuGeppoDBU031400Process
     */
    @Step(根拠CSV作成_DBU031400)
    protected IBatchFlowCommand create根拠CSV作成_DBU031400プロセス() {
        return loopBatch(JigyoHokokuGeppoDBU031400Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 根拠CSV作成_DBU031391の出力処理です。
     *
     * @return JigyoHokokuGeppoDBU031391Process
     */
    @Step(根拠CSV作成_DBU031391)
    protected IBatchFlowCommand create根拠CSV作成_DBU031391プロセス() {
        return loopBatch(JigyoHokokuGeppoDBU031391Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 根拠CSV作成_DBU031392の出力処理です。
     *
     * @return JigyoHokokuGeppoDBU031392Process
     */
    @Step(根拠CSV作成_DBU031392)
    protected IBatchFlowCommand create根拠CSV作成_DBU031392プロセス() {
        return loopBatch(JigyoHokokuGeppoDBU031392Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 根拠CSV作成_DBU031393の出力処理です。
     *
     * @return JigyoHokokuGeppoDBU031393Process
     */
    @Step(根拠CSV作成_DBU031393)
    protected IBatchFlowCommand create根拠CSV作成_DBU031393プロセス() {
        return loopBatch(JigyoHokokuGeppoDBU031393Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 事業報告統計データ登録処理です。
     *
     * @return JigyoHokokuGeppoDataTorokuProcess
     */
    @Step(事業報告統計データ登録)
    protected IBatchFlowCommand create事業報告統計データ登録プロセス() {
        return loopBatch(JigyoHokokuGeppoDataTorokuProcess.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 新様式一般状況の出力処理です。
     *
     * @return JigyoHokokuGeppoReportDBU300006Process
     */
    @Step(新様式一般状況)
    protected IBatchFlowCommand create新様式一般状況帳票プロセス() {
        return loopBatch(JigyoHokokuGeppoReportDBU300006Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 介護保険事業状況報告資料の出力処理です。
     *
     * @return JigyoHokokuGeppoReportDBU300007Process
     */
    @Step(介護保険事業状況報告資料)
    protected IBatchFlowCommand create介護保険事業状況報告資料帳票プロセス() {
        return loopBatch(JigyoHokokuGeppoReportDBU300007Process.class).arguments(getParameter().toProcessParamter()).define();
    }
}
