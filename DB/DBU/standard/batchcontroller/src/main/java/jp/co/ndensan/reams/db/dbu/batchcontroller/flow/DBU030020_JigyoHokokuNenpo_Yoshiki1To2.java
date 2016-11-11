/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU030020.FileSakuseiDataTorokuProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU030020.FukaHihokenshaDaichoProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU030020.JigyoHokokuDataReportDBU300101Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU030020.JigyoHokokuDataReportDBU301125Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU030020.JigyoHokokuHiyouDataReportDBU300121Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU030020.JigyoHokokuKensuDataReportDBU300121Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU030020.JigyoHokokuKyuhuDataReportDBU300121Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU030020.ShichosonTokubetuKyuuhuShukeiProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU030020.ShichosonTokubetuKyuuhuTorokuProcess;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU030020.DBU030020_JigyoHokokuNenpo_Yoshiki1To2Parameter;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.PrintControlKubun;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 事業状況報告年報　様式１・２のバッチフロークラスです。
 *
 * @reamsid_L DBU-5610-030 chengsanyuan
 */
public class DBU030020_JigyoHokokuNenpo_Yoshiki1To2 extends BatchFlowBase<DBU030020_JigyoHokokuNenpo_Yoshiki1To2Parameter> {

    private static final String 介護賦課_被保険者者台帳プロセス = "介護賦課_被保険者者台帳一時テーブル作成";
    private static final String ファイルの作成_集計データ登録プロセス = "ファイルの作成_集計データ登録";
    private static final String 市町村特別給付_データ集計プロセス = "市町村特別給付_データ集計";
    private static final String 市町村特別給付_データ登録プロセス = "市町村特別給付_データ登録";

    private static final String 事業状況報告年報帳票出力_被保険者数プロセス = "事業状況報告年報帳票出力_被保険者数";
    private static final String 事業状況報告年報帳票出力_所得段階プロセス = "事業状況報告年報帳票出力_所得段階";
    private static final String 事業状況報告年報帳票出力_市町村特別給付件数プロセス = "事業状況報告年報帳票出力_市町村特別給付件数";
    private static final String 事業状況報告年報帳票出力_市町村特別給付費用額プロセス = "事業状況報告年報帳票出力_市町村特別給付費用額";
    private static final String 事業状況報告年報帳票出力_市町村特別給付給付額プロセス = "事業状況報告年報帳票出力_市町村特別給付給付額";
    // TODO QA109512未回答ので、実装しない
//    private static final String 根拠CSVファイル作成数プロセス = "根拠CSVファイル作成数";
    private DBU030020_JigyoHokokuNenpo_Yoshiki1To2Parameter parameter;
    private FileSpoolManager manager;

    @Override
    protected void defineFlow() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                new EucEntityId("DBU030020"), UzUDE0831EucAccesslogFileType.Csv);
        parameter = getParameter();
        parameter.setCsvFilePath(manager.getEucOutputDirectry());
        parameter.setManager(manager);
        if (PrintControlKubun.集計のみ.getコード().equals(getParameter().getプリントコントロール区分())) {
            executeStep(介護賦課_被保険者者台帳プロセス);
            executeStep(ファイルの作成_集計データ登録プロセス);
            executeStep(市町村特別給付_データ集計プロセス);
            executeStep(市町村特別給付_データ登録プロセス);
            // TODO QA109512未回答ので、実装しない
//            executeStep(根拠CSVファイル作成数プロセス);
        } else if (PrintControlKubun.集計後印刷.getコード().equals(getParameter().getプリントコントロール区分())) {
            executeStep(介護賦課_被保険者者台帳プロセス);
            executeStep(ファイルの作成_集計データ登録プロセス);
            executeStep(市町村特別給付_データ集計プロセス);
            executeStep(市町村特別給付_データ登録プロセス);
            executeStep(事業状況報告年報帳票出力_被保険者数プロセス);
            executeStep(事業状況報告年報帳票出力_所得段階プロセス);
            executeStep(事業状況報告年報帳票出力_市町村特別給付件数プロセス);
            executeStep(事業状況報告年報帳票出力_市町村特別給付費用額プロセス);
            executeStep(事業状況報告年報帳票出力_市町村特別給付給付額プロセス);
            // TODO QA109512未回答ので、実装しない
//            executeStep(根拠CSVファイル作成数プロセス);
        } else if (PrintControlKubun.過去分の印刷.getコード().equals(getParameter().getプリントコントロール区分())) {
            executeStep(事業状況報告年報帳票出力_被保険者数プロセス);
            executeStep(事業状況報告年報帳票出力_所得段階プロセス);
            executeStep(事業状況報告年報帳票出力_市町村特別給付件数プロセス);
            executeStep(事業状況報告年報帳票出力_市町村特別給付費用額プロセス);
            executeStep(事業状況報告年報帳票出力_市町村特別給付給付額プロセス);
        }
    }

    /**
     * 介護賦課_被保険者者台帳の作成処理です。
     *
     * @return JigyoHokokuShiryouTorokuKaigoKyufuInsertProcess
     */
    @Step(介護賦課_被保険者者台帳プロセス)
    protected IBatchFlowCommand create介護賦課_被保険者者台帳プロセス() {
        return loopBatch(FukaHihokenshaDaichoProcess.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * ファイルの作成_集計データ登録プロセスの作成処理です。
     *
     * @return FileSakuseiDataTorokuProcess
     */
    @Step(ファイルの作成_集計データ登録プロセス)
    protected IBatchFlowCommand createファイルの作成_集計データ登録プロセス() {
        return loopBatch(FileSakuseiDataTorokuProcess.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 市町村特別給付_データ集計更新プロセスの作成処理です。
     *
     * @return JigyoHokokuShiryouTorokuKaigoKyufuInsertProcess
     */
    @Step(市町村特別給付_データ集計プロセス)
    protected IBatchFlowCommand create市町村特別給付_データ集計プロセス() {
        return loopBatch(ShichosonTokubetuKyuuhuShukeiProcess.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 市町村特別給付_データ登録プロセスの作成処理です。
     *
     * @return JigyoHokokuShiryouTorokuKaigoKyufuInsertProcess
     */
    @Step(市町村特別給付_データ登録プロセス)
    protected IBatchFlowCommand create市町村特別給付_データ登録プロセス() {
        return loopBatch(ShichosonTokubetuKyuuhuTorokuProcess.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 事業状況報告年報帳票出力_被保険者数プロセスの作成処理です。
     *
     * @return JigyoHokokuShiryouTorokuKaigoKyufuInsertProcess
     */
    @Step(事業状況報告年報帳票出力_被保険者数プロセス)
    protected IBatchFlowCommand create事業状況報告年報帳票出力_被保険者数プロセス() {
        return loopBatch(JigyoHokokuDataReportDBU300101Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 事業状況報告年報帳票出力_所得段階プロセスの作成処理です。
     *
     * @return JigyoHokokuShiryouTorokuKaigoKyufuInsertProcess
     */
    @Step(事業状況報告年報帳票出力_所得段階プロセス)
    protected IBatchFlowCommand create事業状況報告年報帳票出力_所得段階プロセス() {
        return loopBatch(JigyoHokokuDataReportDBU301125Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 事業状況報告年報帳票出力_市町村特別給付件数プロセスの作成処理です。
     *
     * @return JigyoHokokuShiryouTorokuKaigoKyufuInsertProcess
     */
    @Step(事業状況報告年報帳票出力_市町村特別給付件数プロセス)
    protected IBatchFlowCommand create事業状況報告年報帳票出力_市町村特別給付件数プロセス() {
        return loopBatch(JigyoHokokuKensuDataReportDBU300121Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 事業状況報告年報帳票出力_市町村特別給付費用額プロセスの作成処理です。
     *
     * @return JigyoHokokuShiryouTorokuKaigoKyufuInsertProcess
     */
    @Step(事業状況報告年報帳票出力_市町村特別給付費用額プロセス)
    protected IBatchFlowCommand create事業状況報告年報帳票出力_市町村特別給付費用額プロセス() {
        return loopBatch(JigyoHokokuHiyouDataReportDBU300121Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 事業状況報告年報帳票出力_市町村特別給付給付額プロセスの作成処理です。
     *
     * @return JigyoHokokuShiryouTorokuKaigoKyufuInsertProcess
     */
    @Step(事業状況報告年報帳票出力_市町村特別給付給付額プロセス)
    protected IBatchFlowCommand create事業状況報告年報帳票出力_市町村特別給付給付額プロセス() {
        return loopBatch(JigyoHokokuKyuhuDataReportDBU300121Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 根拠CSVファイル作成数プロセスの作成処理です。
     *
     * @return JigyoHokokuShiryouTorokuKaigoKyufuInsertProcess
     */
    // TODO QA109512未回答ので、実装しない
//    @Step(根拠CSVファイル作成数プロセス)
//    protected IBatchFlowCommand create根拠CSVファイル作成数プロセス() {
//        return loopBatch(JigyoHokokuShiryouTorokuKaigoKyufuInsertProcess.class).arguments(getParameter().toProcessParamter()).define();
//    }
}
