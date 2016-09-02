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
import jp.co.ndensan.reams.uz.uza.lang.RString;

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
    private static final String 事業報告統計データ登録 = "事業報告統計データ登録";
    private static final String 新様式一般状況 = "新様式一般状況";
    private static final String 介護保険事業状況報告資料 = "介護保険事業状況報告資料";
    private static final RString 集計番号_DBU011200 = new RString("DBU011200");
    private static final RString 集計番号_DBU011400 = new RString("DBU011400");
    private static final RString 集計番号_DBU011391 = new RString("DBU011391");
    private static final RString 集計番号_DBU011392 = new RString("DBU011392");
    private static final RString 集計番号_DBU011393 = new RString("DBU011393");

    @Override
    protected void defineFlow() {
        if (PrintControlKubun.集計のみ.getコード().equals(getParameter().getプリントコントロール区分())) {
            executeStep(事業報告統計元データ);
            executeStep(帳票出力_処理確認リスト);
            if (集計番号_DBU011200.equals(getParameter().get作成CSVファイルID())) {
                executeStep(根拠CSV作成_DBU011200);
            }
            if (集計番号_DBU011400.equals(getParameter().get作成CSVファイルID())) {
                executeStep(根拠CSV作成_DBU011400);
            }
            if (集計番号_DBU011391.equals(getParameter().get作成CSVファイルID())) {
                executeStep(根拠CSV作成_DBU011391);
            }
            if (集計番号_DBU011392.equals(getParameter().get作成CSVファイルID())) {
                executeStep(根拠CSV作成_DBU011392);
            }
            if (集計番号_DBU011393.equals(getParameter().get作成CSVファイルID())) {
                executeStep(根拠CSV作成_DBU011393);
            }
            executeStep(事業報告統計データ登録);
        } else if (PrintControlKubun.集計後印刷.getコード().equals(getParameter().getプリントコントロール区分())) {
            executeStep(事業報告統計元データ);
            executeStep(帳票出力_処理確認リスト);
            if (集計番号_DBU011200.equals(getParameter().get作成CSVファイルID())) {
                executeStep(根拠CSV作成_DBU011200);
            }
            if (集計番号_DBU011400.equals(getParameter().get作成CSVファイルID())) {
                executeStep(根拠CSV作成_DBU011400);
            }
            if (集計番号_DBU011391.equals(getParameter().get作成CSVファイルID())) {
                executeStep(根拠CSV作成_DBU011391);
            }
            if (集計番号_DBU011392.equals(getParameter().get作成CSVファイルID())) {
                executeStep(根拠CSV作成_DBU011392);
            }
            if (集計番号_DBU011393.equals(getParameter().get作成CSVファイルID())) {
                executeStep(根拠CSV作成_DBU011393);
            }
            executeStep(事業報告統計データ登録);
        } else if (PrintControlKubun.過去分の印刷.getコード().equals(getParameter().getプリントコントロール区分())) {
            executeStep(新様式一般状況);
            executeStep(介護保険事業状況報告資料);
        }
    }

    /**
     * temp事業報告統計元データ作成処理です。
     *
     * @return JigyoHokokuDataTorokuProcess
     */
    @Step(事業報告統計元データ)
    protected IBatchFlowCommand create事業報告統計元データプロセス() {
        return loopBatch(TempJigyoHokokuTokeiMotoDataProcess.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 処理確認リスト帳票の出力処理です。
     *
     * @return JigyoHokokuDataTorokuProcess
     */
    @Step(帳票出力_処理確認リスト)
    protected IBatchFlowCommand create処理確認リスト帳票プロセス() {
        return loopBatch(ShoriKekkaKakuninListProcess.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 根拠CSV作成_DBU011200の出力処理です。
     *
     * @return JigyoHokokuDataTorokuProcess
     */
    @Step(根拠CSV作成_DBU011200)
    protected IBatchFlowCommand create根拠CSV作成_DBU011200プロセス() {
        return loopBatch(JigyoHokokuGeppoDBU011200Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 根拠CSV作成_DBU011400の出力処理です。
     *
     * @return JigyoHokokuDataTorokuProcess
     */
    @Step(根拠CSV作成_DBU011400)
    protected IBatchFlowCommand create根拠CSV作成_DBU011400プロセス() {
        return loopBatch(JigyoHokokuGeppoDBU011400Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 根拠CSV作成_DBU011391の出力処理です。
     *
     * @return JigyoHokokuDataTorokuProcess
     */
    @Step(根拠CSV作成_DBU011391)
    protected IBatchFlowCommand create根拠CSV作成_DBU011391プロセス() {
        return loopBatch(JigyoHokokuGeppoDBU011391Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 根拠CSV作成_DBU011392の出力処理です。
     *
     * @return JigyoHokokuDataTorokuProcess
     */
    @Step(根拠CSV作成_DBU011392)
    protected IBatchFlowCommand create根拠CSV作成_DBU011392プロセス() {
        return loopBatch(JigyoHokokuGeppoDBU011392Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 根拠CSV作成_DBU011393の出力処理です。
     *
     * @return JigyoHokokuDataTorokuProcess
     */
    @Step(根拠CSV作成_DBU011393)
    protected IBatchFlowCommand create根拠CSV作成_DBU011393プロセス() {
        return loopBatch(JigyoHokokuGeppoDBU011393Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 事業報告統計データ登録処理です。
     *
     * @return JigyoHokokuDataTorokuProcess
     */
    @Step(事業報告統計データ登録)
    protected IBatchFlowCommand create事業報告統計データ登録プロセス() {
        return loopBatch(JigyoHokokuGeppoDataTorokuProcess.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 新様式一般状況の出力処理です。
     *
     * @return JigyoHokokuDataTorokuProcess
     */
    @Step(新様式一般状況)
    protected IBatchFlowCommand create新様式一般状況帳票プロセス() {
        return loopBatch(JigyoHokokuGeppoReportDBU300006Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 介護保険事業状況報告資料の出力処理です。
     *
     * @return JigyoHokokuDataTorokuProcess
     */
    @Step(介護保険事業状況報告資料)
    protected IBatchFlowCommand create介護保険事業状況報告資料帳票プロセス() {
        return loopBatch(JigyoHokokuGeppoReportDBU300007Process.class).arguments(getParameter().toProcessParamter()).define();
    }
}
