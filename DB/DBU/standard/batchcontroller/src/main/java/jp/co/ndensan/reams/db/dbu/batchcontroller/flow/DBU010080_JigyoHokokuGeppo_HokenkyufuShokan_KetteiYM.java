/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010080.JigyoHokokuShiryouReportDBU300009Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010080.JigyoHokokuShiryouReportDBU300010Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010080.JigyoHokokuShiryouReportDBU300017Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010080.JigyoHokokuShiryouReportDBU300021Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010080.JigyoHokokuShiryouReportDBU300022Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010080.JigyoHokokuShiryouTorokuKaigoKyufuInsertProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010080.JigyoHokokuShiryouTorokuKaigoKyufuInsertTwoProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010080.JigyoHokokuShiryouTorokuKaigoKyufuProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010080.JigyoHokokuShiryouTorokuTokuteiNyusyoInsertProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010080.JigyoHokokuShiryouTorokuTokuteiNyusyoProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010080.ShoriKekkaKakuninListFutanWariaiProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010080.ShoriKekkaKakuninListSakuseiKubunProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010080.ShoriKekkaKakuninListShichosonProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010080.ShoriKekkaKakuninListZengoKyufurituProcess;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU010080.DBU010080_JigyoHokokuGeppo_HokenkyufuShokan_KetteiYMParameter;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.PrintControlKubun;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 保険給付【償還_決定】のバッチフロークラスです。
 *
 * @reamsid_L DBU-5570-030 xuyannan
 */
public class DBU010080_JigyoHokokuGeppo_HokenkyufuShokan_KetteiYM
        extends BatchFlowBase<DBU010080_JigyoHokokuGeppo_HokenkyufuShokan_KetteiYMParameter> {

    private static final String 給付実績集計根拠一時テーブル作成プロセス = "給付実績集計根拠一時テーブル作成";
    private static final String 給付実績集計根拠一時テーブル再作成プロセス = "給付実績集計根拠一時テーブル再作成";
    private static final String 事業報告資料登録_給付実績プロセス = "事業報告資料登録_給付実績";
    private static final String 特定入所者集計根拠テーブル作成プロセス = "特定入所者集計根拠テーブル作成";
    private static final String 事業報告資料登録_特定入所者プロセス = "事業報告資料登録_特定入所者";
    private static final String 事業報告月報様式_01出力プロセス = "事業報告月報様式_01出力";
    private static final String 事業報告月報様式_02出力プロセス = "事業報告月報様式_02出力";
    private static final String 事業報告月報様式_03出力プロセス = "事業報告月報様式_03出力";
    private static final String 事業報告月報様式_04出力プロセス = "事業報告月報様式_04出力";
    private static final String 事業報告複合様式_05出力プロセス = "事業報告複合様式_05出力";
    private static final String 処理結果確認リスト帳票出力_作成区分エラーフラグ分プロセス = "処理結果確認リスト帳票出力_作成区分エラーフラグ分";
    private static final String 処理結果確認リスト帳票出力_負担割合エラーフラグ分プロセス = "処理結果確認リスト帳票出力_負担割合エラーフラグ分";
    private static final String 処理結果確認リスト帳票出力_前後給付率エラーフラグ分プロセス = "処理結果確認リスト帳票出力_前後給付率エラーフラグ分";
    private static final String 処理結果確認リスト帳票出力_市町村コード分プロセス = "処理結果確認リスト帳票出力_市町村コード分";
    private DBU010080_JigyoHokokuGeppo_HokenkyufuShokan_KetteiYMParameter parameter;
    private FileSpoolManager manager;

    @Override
    protected void defineFlow() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                new EucEntityId("DBU010080"), UzUDE0831EucAccesslogFileType.Csv);
        parameter = getParameter();
        parameter.setCsvFilePath(manager.getEucOutputDirectry());
        parameter.setManager(manager);
        if (PrintControlKubun.集計のみ.getコード().equals(getParameter().getプリントコントロール区分())) {
            executeStep(給付実績集計根拠一時テーブル作成プロセス);
            executeStep(給付実績集計根拠一時テーブル再作成プロセス);
            executeStep(事業報告資料登録_給付実績プロセス);
            executeStep(特定入所者集計根拠テーブル作成プロセス);
            executeStep(事業報告資料登録_特定入所者プロセス);
            executeStep(処理結果確認リスト帳票出力_作成区分エラーフラグ分プロセス);
            executeStep(処理結果確認リスト帳票出力_負担割合エラーフラグ分プロセス);
            executeStep(処理結果確認リスト帳票出力_前後給付率エラーフラグ分プロセス);
            executeStep(処理結果確認リスト帳票出力_市町村コード分プロセス);
        } else if (PrintControlKubun.集計後印刷.getコード().equals(getParameter().getプリントコントロール区分())) {
            executeStep(給付実績集計根拠一時テーブル作成プロセス);
            executeStep(給付実績集計根拠一時テーブル再作成プロセス);
            executeStep(事業報告資料登録_給付実績プロセス);
            executeStep(特定入所者集計根拠テーブル作成プロセス);
            executeStep(事業報告資料登録_特定入所者プロセス);
            executeStep(事業報告月報様式_01出力プロセス);
            executeStep(事業報告月報様式_02出力プロセス);
            executeStep(事業報告月報様式_03出力プロセス);
            executeStep(事業報告月報様式_04出力プロセス);
            executeStep(事業報告複合様式_05出力プロセス);
            executeStep(処理結果確認リスト帳票出力_作成区分エラーフラグ分プロセス);
            executeStep(処理結果確認リスト帳票出力_負担割合エラーフラグ分プロセス);
            executeStep(処理結果確認リスト帳票出力_前後給付率エラーフラグ分プロセス);
            executeStep(処理結果確認リスト帳票出力_市町村コード分プロセス);
        } else if (PrintControlKubun.過去分の印刷.getコード().equals(getParameter().getプリントコントロール区分())) {
            executeStep(事業報告月報様式_01出力プロセス);
            executeStep(事業報告月報様式_02出力プロセス);
            executeStep(事業報告月報様式_03出力プロセス);
            executeStep(事業報告月報様式_04出力プロセス);
            executeStep(事業報告複合様式_05出力プロセス);
        }
    }

    /**
     * 給付実績集計根拠一時テーブルの作成処理です。
     *
     * @return JigyoHokokuShiryouTorokuKaigoKyufuInsertProcess
     */
    @Step(給付実績集計根拠一時テーブル作成プロセス)
    protected IBatchFlowCommand create給付実績集計根拠一時テーブル() {
        return loopBatch(JigyoHokokuShiryouTorokuKaigoKyufuInsertProcess.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 給付実績集計根拠一時テーブルの作成処理です。
     *
     * @return JigyoHokokuShiryouTorokuKaigoKyufuInsertProcess
     */
    @Step(給付実績集計根拠一時テーブル再作成プロセス)
    protected IBatchFlowCommand create給付実績集計根拠一時テーブルTwo() {
        return loopBatch(JigyoHokokuShiryouTorokuKaigoKyufuInsertTwoProcess.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 事業報告資料登録_給付実績の登録処理です。
     *
     * @return JigyoHokokuShiryouTorokuKaigoKyufuProcess
     */
    @Step(事業報告資料登録_給付実績プロセス)
    protected IBatchFlowCommand create事業報告資料登録_給付実績() {
        return loopBatch(JigyoHokokuShiryouTorokuKaigoKyufuProcess.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 特定入所者集計根拠テーブルの作成処理です。
     *
     * @return JigyoHokokuShiryouTorokuTokuteiNyusyoInsertProcess
     */
    @Step(特定入所者集計根拠テーブル作成プロセス)
    protected IBatchFlowCommand create特定入所者集計根拠テーブル() {
        return loopBatch(JigyoHokokuShiryouTorokuTokuteiNyusyoInsertProcess.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 事業報告資料登録_特定入所者の登録処理です。
     *
     * @return JigyoHokokuShiryouTorokuTokuteiNyusyoProcess
     */
    @Step(事業報告資料登録_特定入所者プロセス)
    protected IBatchFlowCommand create事業報告資料登録_特定入所者() {
        return loopBatch(JigyoHokokuShiryouTorokuTokuteiNyusyoProcess.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 事業報告月報様式_01の出力処理です。
     *
     * @return JigyoHokokuShiryouReportDBU300009Process
     */
    @Step(事業報告月報様式_01出力プロセス)
    protected IBatchFlowCommand create事業報告月報様式_01出力プロセス() {
        return loopBatch(JigyoHokokuShiryouReportDBU300009Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 事業報告月報様式_02の出力処理です。
     *
     * @return JigyoHokokuShiryouReportDBU300010Process
     */
    @Step(事業報告月報様式_02出力プロセス)
    protected IBatchFlowCommand create事業報告月報様式_02出力プロセス() {
        return loopBatch(JigyoHokokuShiryouReportDBU300010Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 事業報告月報様式_03の出力処理です。
     *
     * @return JigyoHokokuShiryouReportDBU300021Process
     */
    @Step(事業報告月報様式_03出力プロセス)
    protected IBatchFlowCommand create事業報告月報様式_03出力プロセス() {
        return loopBatch(JigyoHokokuShiryouReportDBU300021Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 事業報告月報様式_04の出力処理です。
     *
     * @return JigyoHokokuShiryouReportDBU300022Process
     */
    @Step(事業報告月報様式_04出力プロセス)
    protected IBatchFlowCommand create事業報告月報様式_04出力プロセス() {
        return loopBatch(JigyoHokokuShiryouReportDBU300022Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 事業報告月報様式_05の出力処理です。
     *
     * @return JigyoHokokuShiryouReportDBU300017Process
     */
    @Step(事業報告複合様式_05出力プロセス)
    protected IBatchFlowCommand create事業報告月報様式_05出力プロセス() {
        return loopBatch(JigyoHokokuShiryouReportDBU300017Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 処理結果確認リスト帳票出力_作成区分エラーフラグ分の出力処理です。
     *
     * @return ShoriKekkaKakuninListSakuseiKubunProcess
     */
    @Step(処理結果確認リスト帳票出力_作成区分エラーフラグ分プロセス)
    protected IBatchFlowCommand create処理結果確認リスト帳票出力_作成区分エラーフラグ分() {
        return loopBatch(ShoriKekkaKakuninListSakuseiKubunProcess.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 処理結果確認リスト帳票出力_負担割合エラーフラグ分の出力処理です。
     *
     * @return ShoriKekkaKakuninListFutanWariaiProcess
     */
    @Step(処理結果確認リスト帳票出力_負担割合エラーフラグ分プロセス)
    protected IBatchFlowCommand create処理結果確認リスト帳票出力_負担割合エラーフラグ分() {
        return loopBatch(ShoriKekkaKakuninListFutanWariaiProcess.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 処理結果確認リスト帳票出力_前後給付率エラーフラグ分の出力処理です。
     *
     * @return ShoriKekkaKakuninListZengoKyufurituProcess
     */
    @Step(処理結果確認リスト帳票出力_前後給付率エラーフラグ分プロセス)
    protected IBatchFlowCommand create処理結果確認リスト帳票出力_前後給付率エラーフラグ分() {
        return loopBatch(ShoriKekkaKakuninListZengoKyufurituProcess.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 処理結果確認リスト帳票出力_市町村コード分の出力処理です。
     *
     * @return ShoriKekkaKakuninListShichosonProcess
     */
    @Step(処理結果確認リスト帳票出力_市町村コード分プロセス)
    protected IBatchFlowCommand create処理結果確認リスト帳票出力_市町村コード分() {
        return loopBatch(ShoriKekkaKakuninListShichosonProcess.class).arguments(getParameter().toProcessParamter()).define();
    }
}
