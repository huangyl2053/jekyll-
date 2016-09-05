/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU030100.JigyoHokokuNenpoHokenkyufuKogakuUpdateProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU030100.JigyoHokokuNenpoReportDBU300119Process;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU030100.DBU030100_JigyoHokokuNenpo_HokenkyufuKogakuParameter;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.PrintControlKubun;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 事業状況報告資料（年報）作成　保険給付決定状況(高額分)のバッチフロークラスです。
 *
 * @reamsid_L DBU-5600-060 lishengli
 */
public class DBU030100_JigyoHokokuNenpo_HokenkyufuKogaku extends BatchFlowBase<DBU030100_JigyoHokokuNenpo_HokenkyufuKogakuParameter> {

    private static final String 事業報告統計データ登録 = "事業報告統計データ登録";
    private static final String 介護事業状況報告年報_様式2_7 = "介護事業状況報告年報_様式2_7";

    @Override
    protected void defineFlow() {
        if (PrintControlKubun.集計のみ.getコード().equals(getParameter().getプリントコントロール区分())) {
            executeStep(事業報告統計データ登録);
        } else if (PrintControlKubun.集計後印刷.getコード().equals(getParameter().getプリントコントロール区分())) {
            executeStep(事業報告統計データ登録);
            executeStep(介護事業状況報告年報_様式2_7);
        } else if (PrintControlKubun.過去分の印刷.getコード().equals(getParameter().getプリントコントロール区分())) {
            executeStep(介護事業状況報告年報_様式2_7);
        }
    }

    /**
     * 事業報告統計データの登録処理です。
     *
     * @return JigyoHokokuNenpoHokenkyufuKogakuUpdateProcess
     */
    @Step(事業報告統計データ登録)
    protected IBatchFlowCommand create事業報告統計データ登録プロセス() {
        return loopBatch(JigyoHokokuNenpoHokenkyufuKogakuUpdateProcess.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 帳票設計_DBU300109_介護事業状況報告年報（様式2）の出力処理です。
     *
     * @return JigyoHokokuNenpoReportDBU300119Process
     */
    @Step(介護事業状況報告年報_様式2_7)
    protected IBatchFlowCommand create介護事業状況報告年報_様式2_7_119帳票出力プロセス() {
        return loopBatch(JigyoHokokuNenpoReportDBU300119Process.class).arguments(getParameter().toProcessParamter()).define();
    }
}
