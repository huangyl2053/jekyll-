/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU030030.JigyoHokokuDataReportDBU300001Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU030030.JigyoHokokuDataReportDBU300008Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU030030.JigyoHokokuDataReportDBU300103Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU030030.JigyoHokokuDataReportDBU300104Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU030030.JigyoHokokuDataReportDBU300105Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU030030.JigyoHokokuDataReportDBU300106Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU030030.JigyoHokokuDataTorokuProcess;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU030030.DBU030030_JigyoHokokuNenpo_IppanParameter;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.PrintControlKubun;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 事業状況報告資料（年報）作成　一般状況（１～１１）のバッチフロークラスです。
 *
 * @reamsid_L DBU-5600-030 dingyi
 */
public class DBU030030_JigyoHokokuNenpo_Ippan extends BatchFlowBase<DBU030030_JigyoHokokuNenpo_IppanParameter> {

    private static final String 事業報告統計データ登録 = "事業報告統計データ登録";
    private static final String 帳票出力_介護事業状況報告月報_一般状況_様式1 = "帳票出力_介護事業状況報告月報_一般状況_様式1";
    private static final String 帳票出力_介護事業状況報告年報_様式1_2 = "帳票出力_介護事業状況報告年報_様式1_2";
    private static final String 帳票出力_介護事業状況報告年報_様式1_3 = "帳票出力_介護事業状況報告年報_様式1_3";
    private static final String 帳票出力_介護事業状況報告年報_様式1_4 = "帳票出力_介護事業状況報告年報_様式1_4";
    private static final String 帳票出力_介護事業状況報告年報_様式1_5 = "帳票出力_介護事業状況報告年報_様式1_5";
    private static final String 帳票出力_介護事業状況報告月報_一般状況_別紙 = "帳票出力_介護事業状況報告月報_一般状況_別紙";

    @Override
    protected void defineFlow() {
        if (PrintControlKubun.集計のみ.getコード().equals(getParameter().getプリントコントロール区分())) {
            executeStep(事業報告統計データ登録);
        } else if (PrintControlKubun.集計後印刷.getコード().equals(getParameter().getプリントコントロール区分())) {
            executeStep(事業報告統計データ登録);
            executeStep(帳票出力_介護事業状況報告月報_一般状況_様式1);
            executeStep(帳票出力_介護事業状況報告年報_様式1_2);
            executeStep(帳票出力_介護事業状況報告年報_様式1_3);
            executeStep(帳票出力_介護事業状況報告年報_様式1_4);
            executeStep(帳票出力_介護事業状況報告年報_様式1_5);
            executeStep(帳票出力_介護事業状況報告月報_一般状況_別紙);
        } else if (PrintControlKubun.過去分の印刷.getコード().equals(getParameter().getプリントコントロール区分())) {
            executeStep(帳票出力_介護事業状況報告月報_一般状況_様式1);
            executeStep(帳票出力_介護事業状況報告年報_様式1_2);
            executeStep(帳票出力_介護事業状況報告年報_様式1_3);
            executeStep(帳票出力_介護事業状況報告年報_様式1_4);
            executeStep(帳票出力_介護事業状況報告年報_様式1_5);
            executeStep(帳票出力_介護事業状況報告月報_一般状況_別紙);
        }
    }

    /**
     * 事業報告統計データの登録処理です。
     *
     * @return JigyoHokokuDataTorokuProcess
     */
    @Step(事業報告統計データ登録)
    protected IBatchFlowCommand create事業報告統計データ登録プロセス() {
        return loopBatch(JigyoHokokuDataTorokuProcess.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 介護事業状況報告月報・一般状況（様式1）帳票の出力処理です。
     *
     * @return JigyoHokokuDataTorokuProcess
     */
    @Step(帳票出力_介護事業状況報告月報_一般状況_様式1)
    protected IBatchFlowCommand create事業状況報告月報_一般状況_様式1帳票出力プロセス() {
        return loopBatch(JigyoHokokuDataReportDBU300001Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 介護事業状況報告年報（様式1-2）帳票の出力処理です。
     *
     * @return JigyoHokokuDataTorokuProcess
     */
    @Step(帳票出力_介護事業状況報告年報_様式1_2)
    protected IBatchFlowCommand create事業状況報告年報_様式1_2帳票出力プロセス() {
        return loopBatch(JigyoHokokuDataReportDBU300103Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 介護事業状況報告年報（様式1-3）帳票の出力処理です。
     *
     * @return JigyoHokokuDataTorokuProcess
     */
    @Step(帳票出力_介護事業状況報告年報_様式1_3)
    protected IBatchFlowCommand create事業状況報告年報_様式1_3帳票出力プロセス() {
        return loopBatch(JigyoHokokuDataReportDBU300104Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 介護事業状況報告年報（様式1-4）帳票の出力処理です。
     *
     * @return JigyoHokokuDataTorokuProcess
     */
    @Step(帳票出力_介護事業状況報告年報_様式1_4)
    protected IBatchFlowCommand create事業状況報告年報_様式1_4帳票出力プロセス() {
        return loopBatch(JigyoHokokuDataReportDBU300105Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 介護事業状況報告年報（様式1-5）帳票の出力処理です。
     *
     * @return JigyoHokokuDataTorokuProcess
     */
    @Step(帳票出力_介護事業状況報告年報_様式1_5)
    protected IBatchFlowCommand create事業状況報告年報_様式1_5帳票出力プロセス() {
        return loopBatch(JigyoHokokuDataReportDBU300106Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 介護事業状況報告月報・一般状況（別紙）帳票の出力処理です。
     *
     * @return JigyoHokokuDataTorokuProcess
     */
    @Step(帳票出力_介護事業状況報告月報_一般状況_別紙)
    protected IBatchFlowCommand create事業状況報告月報_一般状況_別紙帳票出力プロセス() {
        return loopBatch(JigyoHokokuDataReportDBU300008Process.class).arguments(getParameter().toProcessParamter()).define();
    }

}
