/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU030070.JigyoHokokuNenpoHokenkyufuGenbutsuUpdateProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU030070.JigyoHokokuNenpoReportDBU300021Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU030070.JigyoHokokuNenpoReportDBU300022Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU030070.JigyoHokokuNenpoReportDBU300109Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU030070.JigyoHokokuNenpoReportDBU300110Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU030070.JigyoHokokuNenpoReportDBU300111Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU030070.JigyoHokokuNenpoReportDBU300112Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU030070.JigyoHokokuNenpoReportDBU300113Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU030070.JigyoHokokuNenpoReportDBU300114Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU030070.JigyoHokokuNenpoReportDBU300115Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU030070.JigyoHokokuNenpoReportDBU300116Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU030070.JigyoHokokuNenpoReportDBU300117Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU030070.JigyoHokokuNenpoReportDBU300118Process;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU030070.DBU030070_JigyoHokokuNenpo_HokenkyufuGenbutsuParameter;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.PrintControlKubun;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 事業状況報告資料（年報）作成　保険給付決定状況のバッチフロークラスです。
 *
 * @reamsid_L DBU-5600-050 lishengli
 */
public class DBU030070_JigyoHokokuNenpo_HokenkyufuGenbutsu extends BatchFlowBase<DBU030070_JigyoHokokuNenpo_HokenkyufuGenbutsuParameter> {

    private static final String 事業報告統計データ登録 = "事業報告統計データ登録";
    private static final String 介護事業状況報告年報_様式2_109 = "介護事業状況報告年報_様式2_109";
    private static final String 介護事業状況報告年報_様式2_110 = "介護事業状況報告年報_様式2_110";
    private static final String 介護事業状況報告月報_保険給付決定状況_様式2_21 = "介護事業状況報告月報_保険給付決定状況_様式2_21";
    private static final String 介護事業状況報告月報_保険給付決定状況_様式2_22 = "介護事業状況報告月報_保険給付決定状況_様式2_22";
    private static final String 介護事業状況報告年報_様式2_2_111 = "介護事業状況報告年報_様式2_2_111";
    private static final String 介護事業状況報告年報_様式2_2_112 = "介護事業状況報告年報_様式2_2_112";
    private static final String 介護事業状況報告年報_様式2_3_113 = "介護事業状況報告年報_様式2_3_113";
    private static final String 介護事業状況報告年報_様式2_3_114 = "介護事業状況報告年報_様式2_3_114";
    private static final String 介護事業状況報告年報_様式2_4_115 = "介護事業状況報告年報_様式2_4_115";
    private static final String 介護事業状況報告年報_様式2_4_116 = "介護事業状況報告年報_様式2_4_116";
    private static final String 介護事業状況報告年報_様式2_5_117 = "介護事業状況報告年報_様式2_5_117";
    private static final String 介護事業状況報告年報_様式2_6_118 = "介護事業状況報告年報_様式2_6_118";

    @Override
    protected void defineFlow() {
        if (PrintControlKubun.集計のみ.getコード().equals(getParameter().getプリントコントロール区分())) {
            executeStep(事業報告統計データ登録);
        } else if (PrintControlKubun.集計後印刷.getコード().equals(getParameter().getプリントコントロール区分())) {
            executeStep(事業報告統計データ登録);
            executeStep(介護事業状況報告年報_様式2_109);
            executeStep(介護事業状況報告年報_様式2_110);
            executeStep(介護事業状況報告月報_保険給付決定状況_様式2_21);
            executeStep(介護事業状況報告月報_保険給付決定状況_様式2_22);
            executeStep(介護事業状況報告年報_様式2_2_111);
            executeStep(介護事業状況報告年報_様式2_2_112);
            executeStep(介護事業状況報告年報_様式2_3_113);
            executeStep(介護事業状況報告年報_様式2_3_114);
            executeStep(介護事業状況報告年報_様式2_4_115);
            executeStep(介護事業状況報告年報_様式2_4_116);
            executeStep(介護事業状況報告年報_様式2_5_117);
            executeStep(介護事業状況報告年報_様式2_6_118);
        } else if (PrintControlKubun.過去分の印刷.getコード().equals(getParameter().getプリントコントロール区分())) {
            executeStep(介護事業状況報告年報_様式2_109);
            executeStep(介護事業状況報告年報_様式2_110);
            executeStep(介護事業状況報告月報_保険給付決定状況_様式2_21);
            executeStep(介護事業状況報告月報_保険給付決定状況_様式2_22);
            executeStep(介護事業状況報告年報_様式2_2_111);
            executeStep(介護事業状況報告年報_様式2_2_112);
            executeStep(介護事業状況報告年報_様式2_3_113);
            executeStep(介護事業状況報告年報_様式2_3_114);
            executeStep(介護事業状況報告年報_様式2_4_115);
            executeStep(介護事業状況報告年報_様式2_4_116);
            executeStep(介護事業状況報告年報_様式2_5_117);
            executeStep(介護事業状況報告年報_様式2_6_118);
        }
    }

    /**
     * 事業報告統計データの登録処理です。
     *
     * @return JigyoHokokuNenpoHokenkyufuGenbutsuUpdateProcess
     */
    @Step(事業報告統計データ登録)
    protected IBatchFlowCommand create事業報告統計データ登録プロセス() {
        return loopBatch(JigyoHokokuNenpoHokenkyufuGenbutsuUpdateProcess.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 帳票設計_DBU300109_介護事業状況報告年報（様式2）の出力処理です。
     *
     * @return JigyoHokokuNenpoReportDBU300109Process
     */
    @Step(介護事業状況報告年報_様式2_109)
    protected IBatchFlowCommand create介護事業状況報告年報_様式2_109帳票出力プロセス() {
        return loopBatch(JigyoHokokuNenpoReportDBU300109Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 帳票設計_DBU300110_介護事業状況報告年報（様式2）の出力処理です。
     *
     * @return JigyoHokokuNenpoReportDBU300110Process
     */
    @Step(介護事業状況報告年報_様式2_110)
    protected IBatchFlowCommand create介護事業状況報告年報_様式2_110帳票出力プロセス() {
        return loopBatch(JigyoHokokuNenpoReportDBU300110Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 帳票設計_DBU300021_介護事業状況報告月報・保険給付決定状況（様式2）の出力処理です。
     *
     * @return JigyoHokokuNenpoReportDBU300021Process
     */
    @Step(介護事業状況報告月報_保険給付決定状況_様式2_21)
    protected IBatchFlowCommand create介護事業状況報告月報_保険給付決定状況_様式2_21帳票出力プロセス() {
        return loopBatch(JigyoHokokuNenpoReportDBU300021Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 帳票設計_DBU300022_介護事業状況報告月報・保険給付決定状況（様式2）の出力処理です。
     *
     * @return JigyoHokokuNenpoReportDBU300022Process
     */
    @Step(介護事業状況報告月報_保険給付決定状況_様式2_22)
    protected IBatchFlowCommand create介護事業状況報告月報_保険給付決定状況_様式2_22帳票出力プロセス() {
        return loopBatch(JigyoHokokuNenpoReportDBU300022Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 帳票設計_DBU300111_介護事業状況報告年報（様式2-2）の出力処理です。
     *
     * @return JigyoHokokuNenpoReportDBU300111Process
     */
    @Step(介護事業状況報告年報_様式2_2_111)
    protected IBatchFlowCommand create介護事業状況報告年報_様式2_2_111帳票出力プロセス() {
        return loopBatch(JigyoHokokuNenpoReportDBU300111Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 帳票設計_DBU300112_介護事業状況報告年報（様式2-2）の出力処理です。
     *
     * @return JigyoHokokuNenpoReportDBU300112Process
     */
    @Step(介護事業状況報告年報_様式2_2_112)
    protected IBatchFlowCommand create介護事業状況報告年報_様式2_2_112帳票出力プロセス() {
        return loopBatch(JigyoHokokuNenpoReportDBU300112Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 帳票設計_DBU300113_介護事業状況報告年報（様式2-3）の出力処理です。
     *
     * @return JigyoHokokuNenpoReportDBU300113Process
     */
    @Step(介護事業状況報告年報_様式2_3_113)
    protected IBatchFlowCommand create介護事業状況報告年報_様式2_3_113帳票出力プロセス() {
        return loopBatch(JigyoHokokuNenpoReportDBU300113Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 帳票設計_DBU300114_介護事業状況報告年報（様式2-3）の出力処理です。
     *
     * @return JigyoHokokuNenpoReportDBU300114Process
     */
    @Step(介護事業状況報告年報_様式2_3_114)
    protected IBatchFlowCommand create介護事業状況報告年報_様式2_3_114帳票出力プロセス() {
        return loopBatch(JigyoHokokuNenpoReportDBU300114Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 帳票設計_DBU300115_介護事業状況報告年報（様式2-4）の出力処理です。
     *
     * @return JigyoHokokuNenpoReportDBU300115Process
     */
    @Step(介護事業状況報告年報_様式2_4_115)
    protected IBatchFlowCommand create介護事業状況報告年報_様式2_4_115帳票出力プロセス() {
        return loopBatch(JigyoHokokuNenpoReportDBU300115Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 帳票設計_DBU300116_介護事業状況報告年報（様式2-4）の出力処理です。
     *
     * @return JigyoHokokuNenpoReportDBU300116Process
     */
    @Step(介護事業状況報告年報_様式2_4_116)
    protected IBatchFlowCommand create介護事業状況報告年報_様式2_4_116帳票出力プロセス() {
        return loopBatch(JigyoHokokuNenpoReportDBU300116Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 帳票設計_DBU300117_介護事業状況報告年報（様式2-5）の出力処理です。
     *
     * @return JigyoHokokuNenpoReportDBU300117Process
     */
    @Step(介護事業状況報告年報_様式2_5_117)
    protected IBatchFlowCommand create介護事業状況報告年報_様式2_5_117帳票出力プロセス() {
        return loopBatch(JigyoHokokuNenpoReportDBU300117Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 帳票設計_DBU300118_介護事業状況報告年報（様式2-6）の出力処理です。
     *
     * @return JigyoHokokuNenpoReportDBU300118Process
     */
    @Step(介護事業状況報告年報_様式2_6_118)
    protected IBatchFlowCommand create介護事業状況報告年報_様式2_6_118帳票出力プロセス() {
        return loopBatch(JigyoHokokuNenpoReportDBU300118Process.class).arguments(getParameter().toProcessParamter()).define();
    }

}
