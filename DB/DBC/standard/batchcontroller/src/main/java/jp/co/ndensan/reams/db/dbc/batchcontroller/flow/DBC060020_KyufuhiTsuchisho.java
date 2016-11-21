/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import java.io.File;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC060020.KyufuhiTsuchishoKouikiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC060020.KyufuhiTsuchishoReadCsvFileProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC060020.KyufuhiTsuchishoReportDBC100041Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC060020.KyufuhiTsuchishoReportDBC100042Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC060020.KyufuhiTsuchishoReportDBC100043Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC060020.KyufuhiTsuchishoReportDBC200044Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC060020.KyufuhiTsuchishoTanitsuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC060020.KyufuhiTuchiHakkoIchiranProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDeleteReveicedFileProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDoShoriKekkaListSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuGetFileProcess;
import jp.co.ndensan.reams.db.dbc.business.core.kokuhorenkyoutsuu.KokuhorenKyoutsuuFileGetReturnEntity;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC060020.DBC060020_KyufuhiTsuchishoParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_TorikomiErrorListType;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuCsvFileReadProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuDeleteReveicedFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuDoShoriKekkaListSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuGetFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoHanyoManager;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付費通知書作成(一括)クラスです。
 *
 * @reamsid_L DBC-2280-030 lizhuoxuan
 */
public class DBC060020_KyufuhiTsuchisho extends BatchFlowBase<DBC060020_KyufuhiTsuchishoParameter> {

    private static final String ファイル取得 = "getFile";
    private static final String CSVファイル取込 = "readCsvFile";
    private static final String 処理結果リスト作成 = "doShoriKekkaListSakusei";
    private static final String 取込済ファイル削除 = "deleteReveicedFile";
    private static final String 介護保険給付費通知書作成 = "dbc100041";
    private static final String 被保険者番号変換単一 = "hiHokenshaNoHenkan";
    private static final String 被保険者番号変換広域 = "hiHokenshaNoKouiki";
    private static final String CSVファイル作成 = "kyufuhituchihakkoichirancsv";
    private static final String 介護保険給付費通知書_ｼｰﾗﾀｲﾌﾟ = "dbc100042";
    private static final String 介護保険給付費通知書_福祉用具貸与品目 = "dbc100043";
    private static final String 給付費通知発行一覧表 = "dbc200044";
    private static final RString 帳票制御汎用キー_帳票タイプ = new RString("帳票タイプ");
    private static final RString 帳票タイプ_A4 = new RString("1");
    private static final RString 帳票タイプ_シーラ = new RString("2");
    private static final RString 給付費通知情報が取り込む = new RString("1");

    private KokuhorenKyoutsuuFileGetReturnEntity returnEntity;
    private boolean flag = true;
    private RString csvFullPath;
    private boolean isFirst;
    private boolean isLast;
    private static final RString 交換情報識別番号 = new RString("322");
    private static final RString ファイル格納フォルダ名 = new RString("DBC060020");

    @Override
    protected void defineFlow() {
        executeStep(ファイル取得);
        returnEntity
                = getResult(KokuhorenKyoutsuuFileGetReturnEntity.class, new RString(ファイル取得),
                        KokuhorenkyoutsuGetFileProcess.PARAMETER_OUT_RETURNENTITY);
        for (int i = 0; i < returnEntity.getFileNameList().size(); i++) {
            String filePath = returnEntity.get保存先フォルダのパス() + File.separator
                    + returnEntity.getFileNameList().get(i);
            File path = new File(filePath);
            csvFullPath = new RString(path.getPath());
            isFirst = (0 == i);
            isLast = ((returnEntity.getFileNameList().size() - 1) == i);
            executeStep(CSVファイル取込);
            if (flag) {
                flag = getResult(Boolean.class, new RString(CSVファイル取込),
                        KyufuhiTsuchishoReadCsvFileProcess.PARAMETER_OUT_FLOWENTITY);
            } else {
                executeStep(処理結果リスト作成);
                executeStep(取込済ファイル削除);
            }
        }
        RDate now = RDate.getNowDate();
        if (new RString("1").equals(DbBusinessConfig
                .get(ConfigNameDBU.合併情報管理_合併情報区分, now, SubGyomuCode.DBU介護統計報告))) {
            保険者構成();
        }

        ChohyoSeigyoHanyoManager 帳票制御汎用Manager = new ChohyoSeigyoHanyoManager();
        RString 帳票タイプ = RString.EMPTY;
        ChohyoSeigyoHanyo 帳票制御汎帳票タイプ = 帳票制御汎用Manager.get帳票制御汎用(
                SubGyomuCode.DBC介護給付,
                ReportIdDBC.DBC100042.getReportId(),
                FlexibleYear.MIN,
                帳票制御汎用キー_帳票タイプ);
        if (帳票制御汎帳票タイプ != null) {
            帳票タイプ = 帳票制御汎帳票タイプ.get設定値();
        }
        if (帳票タイプ_A4.equals(帳票タイプ)) {
            executeStep(介護保険給付費通知書作成);
        }
        if (帳票タイプ_シーラ.equals(帳票タイプ)) {
            executeStep(介護保険給付費通知書_ｼｰﾗﾀｲﾌﾟ);
        }
        if (給付費通知情報が取り込む.equals(getParameter().get福祉用具貸与ページ出力区分())) {
            executeStep(介護保険給付費通知書_福祉用具貸与品目);
        }
        executeStep(給付費通知発行一覧表);
        executeStep(CSVファイル作成);
    }

    private void 保険者構成() {
        if (new RString("1").equals(getParameter().get保険者構成())) {
            executeStep(被保険者番号変換単一);
        } else if (new RString("2").equals(getParameter().get保険者構成())) {
            executeStep(被保険者番号変換広域);
        }
    }

    /**
     * ファイル取得です。
     *
     * @return KokuhorenkyoutsuGetFileProcess
     */
    @Step(ファイル取得)
    protected IBatchFlowCommand callGetFileProcess() {
        KokuhorenkyotsuGetFileProcessParameter parameter = new KokuhorenkyotsuGetFileProcessParameter();
        parameter.set交換情報識別番号(交換情報識別番号);
        parameter.setファイル格納フォルダ名(ファイル格納フォルダ名);
        parameter.setLoginUserID(getParameter().getLoginUserId());
        return simpleBatch(KokuhorenkyoutsuGetFileProcess.class).arguments(parameter).define();
    }

    /**
     * CSVファイル取込です。
     *
     * @return KyufukanrihyoReadCsvFileProcess
     */
    @Step(CSVファイル取込)
    protected IBatchFlowCommand callReadCsvFileProcess() {
        KokuhorenkyotsuCsvFileReadProcessParameter parameter = new KokuhorenkyotsuCsvFileReadProcessParameter();
        parameter.set処理年月(getParameter().get処理年月日().getYearMonth());
        parameter.set保存先パース(csvFullPath);
        parameter.setFirst(isFirst);
        parameter.setLast(isLast);
        return loopBatch(KyufuhiTsuchishoReadCsvFileProcess.class).arguments(parameter).define();
    }

    /**
     * 処理結果リスト作成です。
     *
     * @return KokuhorenkyoutsuDoShoriKekkaListSakuseiProcess
     */
    @Step(処理結果リスト作成)
    protected IBatchFlowCommand callDoShoriKekkaListSakuseiProcess() {
        KokuhorenkyotsuDoShoriKekkaListSakuseiProcessParameter parameter = new KokuhorenkyotsuDoShoriKekkaListSakuseiProcessParameter();
        parameter.setエラーリストタイプ(KokuhorenJoho_TorikomiErrorListType.リストタイプ1);
        return simpleBatch(KokuhorenkyoutsuDoShoriKekkaListSakuseiProcess.class).arguments(parameter).define();
    }

    /**
     * 取込済ファイル削除です。
     *
     * @return KokuhorenkyoutsuDeleteReveicedFileProcess
     */
    @Step(取込済ファイル削除)
    protected IBatchFlowCommand callDeleteReveicedFileProcess() {
        KokuhorenkyotsuDeleteReveicedFileProcessParameter parameter = new KokuhorenkyotsuDeleteReveicedFileProcessParameter();
        parameter.set処理年月(getParameter().get処理年月日().getYearMonth());
        parameter.set保存先フォルダ(returnEntity.get保存先フォルダのパス().toRString());
        parameter.setエントリ情報List(returnEntity.getEntityList());
        return simpleBatch(KokuhorenkyoutsuDeleteReveicedFileProcess.class).arguments(parameter).define();
    }

    /**
     * 被保険者番号変換です。
     *
     * @return KyufuhiTsuchishoTanitsuProcess
     */
    @Step(被保険者番号変換単一)
    protected IBatchFlowCommand call単一Process() {
        return loopBatch(KyufuhiTsuchishoTanitsuProcess.class).define();
    }

    /**
     * 被保険者番号変換です。
     *
     * @return KyufuhiTsuchishoKouikiProcess
     */
    @Step(被保険者番号変換広域)
    protected IBatchFlowCommand call広域Process() {
        return loopBatch(KyufuhiTsuchishoKouikiProcess.class).define();
    }

    /**
     * 介護保険給付費通知書作成作成です。
     *
     * @return KyufuhiTsuchishoReportDBC100041Process
     */
    @Step(介護保険給付費通知書作成)
    protected IBatchFlowCommand 通知書作成Process() {
        return loopBatch(KyufuhiTsuchishoReportDBC100041Process.class).arguments(getParameter().toProcessParameter()).define();
    }

    /**
     * 介護保険給付費通知書作成作成です。
     *
     * @return KyufuhiTsuchishoReportDBC100042Process
     */
    @Step(介護保険給付費通知書_ｼｰﾗﾀｲﾌﾟ)
    protected IBatchFlowCommand 通知書_ｼｰﾗﾀｲﾌﾟProcess() {
        return loopBatch(KyufuhiTsuchishoReportDBC100042Process.class).arguments(getParameter().toProcessParameter()).define();
    }

    /**
     * 介護保険給付費通知書作成作成です。
     *
     * @return KyufuhiTsuchishoReportDBC100043Process
     */
    @Step(介護保険給付費通知書_福祉用具貸与品目)
    protected IBatchFlowCommand 通知書_福祉用具貸与品目Process() {
        return loopBatch(KyufuhiTsuchishoReportDBC100043Process.class).arguments(getParameter().toProcessParameter()).define();
    }

    /**
     * 給付費通知発行一覧表作成です。
     *
     * @return KyufuhiTsuchishoReportDBC200044Process
     */
    @Step(給付費通知発行一覧表)
    protected IBatchFlowCommand 発行一覧表Process() {
        return loopBatch(KyufuhiTsuchishoReportDBC200044Process.class).arguments(getParameter().toProcessParameter()).define();
    }

    /**
     * 給付費通知発行一覧表のCSVファイル作成です。
     *
     * @return KyufuhiTuchiHakkoIchiranProcess
     */
    @Step(CSVファイル作成)
    protected IBatchFlowCommand csv作成Process() {
        return loopBatch(KyufuhiTuchiHakkoIchiranProcess.class).arguments(getParameter().toProcessParameter()).define();
    }

}
