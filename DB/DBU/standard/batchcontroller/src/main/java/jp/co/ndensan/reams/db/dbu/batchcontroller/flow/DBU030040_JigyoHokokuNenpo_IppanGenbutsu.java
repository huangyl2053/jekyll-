/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU030040.JigyoHokokuNenpoIppanGenbutsuDBU300107Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU030040.JigyoHokokuNenpoIppanGenbutsuDBU300108Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU030040.JigyoHokokuNenpoIppanGenbutsuUpdateProcess;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU030040.DBU030040_JigyoHokokuNenpo_IppanGenbutsuParameter;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.PrintControlKubun;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 事業状況報告資料（年報）作成　一般状況（１２～１４）のバッチフロークラスです。
 *
 * @reamsid_L DBU-5600-040 lishengli
 */
public class DBU030040_JigyoHokokuNenpo_IppanGenbutsu extends BatchFlowBase<DBU030040_JigyoHokokuNenpo_IppanGenbutsuParameter> {

    private static final String 事業報告統計データ登録 = "事業報告統計データ登録";
    private static final String 介護事業状況報告年報_一般状況_様式1_5_107 = "介護事業状況報告年報_一般状況_様式1_5_107";
    private static final String 介護事業状況報告年報_一般状況_様式1_5_108 = "介護事業状況報告年報_一般状況_様式1_5_108";

    @Override
    protected void defineFlow() {
        if (PrintControlKubun.集計のみ.getコード().equals(getParameter().getプリントコントロール区分())) {
            executeStep(事業報告統計データ登録);
        } else if (PrintControlKubun.集計後印刷.getコード().equals(getParameter().getプリントコントロール区分())) {
            executeStep(事業報告統計データ登録);
            executeStep(介護事業状況報告年報_一般状況_様式1_5_107);
            executeStep(介護事業状況報告年報_一般状況_様式1_5_108);
        } else if (PrintControlKubun.過去分の印刷.getコード().equals(getParameter().getプリントコントロール区分())) {
            executeStep(介護事業状況報告年報_一般状況_様式1_5_107);
            executeStep(介護事業状況報告年報_一般状況_様式1_5_108);
        }
    }

    /**
     * 事業報告統計データの登録処理です。
     *
     * @return JigyoHokokuNenpoIppanGenbutsuUpdateProcess
     */
    @Step(事業報告統計データ登録)
    protected IBatchFlowCommand create事業報告統計データ登録プロセス() {
        return loopBatch(JigyoHokokuNenpoIppanGenbutsuUpdateProcess.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 帳票設計_DBU300107_介護事業状況報告年報・一般状況帳票の出力処理です。
     *
     * @return JigyoHokokuNenpoIppanGenbutsuDBU300107Process
     */
    @Step(介護事業状況報告年報_一般状況_様式1_5_107)
    protected IBatchFlowCommand create介護事業状況報告年報_一般状況_107帳票出力プロセス() {
        return loopBatch(JigyoHokokuNenpoIppanGenbutsuDBU300107Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 帳票設計_DBU300108_介護事業状況報告年報・一般状況帳票の出力処理です。
     *
     * @return JigyoHokokuNenpoIppanGenbutsuDBU300108Process
     */
    @Step(介護事業状況報告年報_一般状況_様式1_5_108)
    protected IBatchFlowCommand create介護事業状況報告年報_一般状況_108帳票出力プロセス() {
        return loopBatch(JigyoHokokuNenpoIppanGenbutsuDBU300108Process.class).arguments(getParameter().toProcessParamter()).define();
    }
}
