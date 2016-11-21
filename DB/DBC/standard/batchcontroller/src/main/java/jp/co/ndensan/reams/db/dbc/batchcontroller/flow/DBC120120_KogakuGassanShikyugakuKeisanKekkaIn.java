/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import java.io.File;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120120.KogakuGassanDeleteKeisanKekkaMeisaiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120120.KogakuGassanDeleteKeisanKekkaProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120120.KogakuGassanInsertMasterMeisaiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120120.KogakuGassanInsertMasterProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120120.KogakuGassanRirekiNoKakuninProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120120.KogakuGassanShikyugakuKeisanKekkaInProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120120.PntKogakuGassanKakuninIchiranProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120120.PntKogakuGassanTorikomiIchiranProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDeleteReveicedFileProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDoHihokenshaKanrenProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDoInterfaceKanriKousinProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDoShoriKekkaListSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuGetFileProcess;
import jp.co.ndensan.reams.db.dbc.business.core.kokuhorenkyoutsuu.KokuhorenKyoutsuuFileGetReturnEntity;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC120120.DBC120120_KogakuGassanShikyugakuKeisanKekkaInParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_TorikomiErrorListType;
import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc120120.KogakuGassanShikyugakuKeisanKekkaInParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuCsvFileReadProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuDeleteReveicedFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuDoShoriKekkaListSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuGetFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.FlowEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計書_DBCMNF2002-386_高額合算支給額計算結果連絡票情報取込のバッチ処理フロークラスです。
 *
 * @reamsid_L DBC-2680-010 xicongwang
 */
public class DBC120120_KogakuGassanShikyugakuKeisanKekkaIn extends BatchFlowBase<DBC120120_KogakuGassanShikyugakuKeisanKekkaInParameter> {

    private static final String ファイル取得 = "loadFileProcess";
    private static final String CSVファイル取込 = "readCsvToTempTableProcess";
    private static final String 被保険者関連処理 = "doHihokenshaKanrenProcess";
    private static final String DB登録_再処理準備_計算結果削除 = "kogakuGassanDeleteKeisanKekkaProcess";
    private static final String DB登録_再処理準備_計算結果明細削除 = "kogakuGassanDeleteKeisanKekkaMeisaiProcess";
    private static final String DB登録_履歴番号確認 = "kogakuGassanRirekiNoKakuninProcess";
    private static final String 計算結果_マスタ登録 = "kogakuGassanInsertMasterProcess";
    private static final String 計算結果明細_マスタ登録 = "kogakuGassanInsertMasterMeisaiProcess";
    private static final String 国保連インタフェース管理更新 = "updateInterfaceKanriKousinProcess";
    private static final String 処理結果リスト作成 = "doShoriKekkaListSakuseiProcess";
    private static final String 取込済ファイル削除 = "deleteReveicedFileProcess";
    private static final String 連絡票情報確認リスト作成 = "pntKogakuGassanKakuninIchiranProcess";
    private static final String 連絡票情報取込一覧表作成 = "pntKogakuGassanTorikomiIchiranProcess";
    private static final RString ファイル格納フォルダ名 = new RString("DBC120120");
    private int コントロールレコード件数;
    private RString csvFullPath;
    private int 集計件数;
    private int 明細件数;
    private boolean isFirst;
    private boolean isLast;

    private FlowEntity flowEntity;
    private KokuhorenKyoutsuuFileGetReturnEntity returnEntity;

    private static RString 交換情報識別番号;

    @Override
    protected void defineFlow() {
        try {
            RString 処理区分 = RString.EMPTY;
            if (!RString.isNullOrEmpty(getParameter().get処理区分())) {
                処理区分 = getParameter().get処理区分();
            }
            交換情報識別番号 = DbBusinessConfig.get(ConfigNameDBC.国保連取込_高額合算支給額計算結果連絡票情報_交換情報識別番号,
                    RDate.getNowDate(), SubGyomuCode.DBC介護給付).concat(処理区分);

            executeStep(ファイル取得);

            returnEntity = getResult(KokuhorenKyoutsuuFileGetReturnEntity.class, new RString(ファイル取得),
                    KokuhorenkyoutsuGetFileProcess.PARAMETER_OUT_RETURNENTITY);

            for (int i = 0; i < returnEntity.getFileNameList().size(); i++) {
                String filePath = returnEntity.get保存先フォルダのパス() + File.separator
                        + returnEntity.getFileNameList().get(i);
                File path = new File(filePath);
                csvFullPath = new RString(path.getPath());
                isFirst = (0 == i);
                isLast = ((returnEntity.getFileNameList().size() - 1) == i);
                executeStep(CSVファイル取込);
                flowEntity = getResult(FlowEntity.class, new RString(CSVファイル取込),
                        KogakuGassanShikyugakuKeisanKekkaInProcess.PARAMETER_OUT_FLOWENTITY);
                コントロールレコード件数 = flowEntity.getCodeNum();
                集計件数 = flowEntity.get集計データ登録件数();
                明細件数 = flowEntity.get明細データ登録件数();
            }
            if (0 == flowEntity.get集計データ登録件数()) {
                executeStep(国保連インタフェース管理更新);
                executeStep(処理結果リスト作成);
            } else {
                executeStep(被保険者関連処理);
                if (SaiShoriKubun.再処理.equals(getParameter().get再処理区分())) {
                    executeStep(DB登録_再処理準備_計算結果削除);
                    executeStep(DB登録_再処理準備_計算結果明細削除);
                }
                executeStep(DB登録_履歴番号確認);
                executeStep(計算結果_マスタ登録);
                executeStep(計算結果明細_マスタ登録);
                executeStep(国保連インタフェース管理更新);
                executeStep(連絡票情報確認リスト作成);
                executeStep(連絡票情報取込一覧表作成);
                executeStep(処理結果リスト作成);
            }
        } finally {
            if (null != returnEntity) {
                executeStep(取込済ファイル削除);
            }
        }
    }

    /**
     * ファイル取得するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(ファイル取得)
    protected IBatchFlowCommand loadFileProcess() {
        KokuhorenkyotsuGetFileProcessParameter parameter = new KokuhorenkyotsuGetFileProcessParameter();
        parameter.set交換情報識別番号(交換情報識別番号);
        parameter.setファイル格納フォルダ名(ファイル格納フォルダ名);
        parameter.setLoginUserID(getParameter().getLoginUserId());
        return simpleBatch(KokuhorenkyoutsuGetFileProcess.class).arguments(parameter).define();
    }

    /**
     * CSVファイル取込するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(CSVファイル取込)
    protected IBatchFlowCommand readCsvToTempTableProcess() {
        KokuhorenkyotsuCsvFileReadProcessParameter parameter = new KokuhorenkyotsuCsvFileReadProcessParameter();
        parameter.set処理年月(getParameter().get処理年月());
        parameter.set保存先パース(csvFullPath);
        parameter.set集計件数合算(集計件数);
        parameter.setFirst(isFirst);
        parameter.setLast(isLast);
        parameter.setレコード件数合算(コントロールレコード件数);
        parameter.set明細件数合算(明細件数);
        return loopBatch(KogakuGassanShikyugakuKeisanKekkaInProcess.class).arguments(parameter).define();
    }

    /**
     * 被保険者関連処理するです。
     *
     * @return バッチコマンド
     */
    @Step(被保険者関連処理)
    protected IBatchFlowCommand doHihokenshaKanrenProcess() {
        return simpleBatch(KokuhorenkyoutsuDoHihokenshaKanrenProcess.class).define();
    }

    /**
     * DB登録_再処理準備_計算結果削除するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(DB登録_再処理準備_計算結果削除)
    protected IBatchFlowCommand kogakuGassanDeleteKeisanKekkaProcess() {
        KogakuGassanShikyugakuKeisanKekkaInParameter parameter = new KogakuGassanShikyugakuKeisanKekkaInParameter();
        parameter.set処理年月(getParameter().get処理年月());
        parameter.set処理区分(getParameter().get処理区分());
        return loopBatch(KogakuGassanDeleteKeisanKekkaProcess.class).arguments(parameter).define();
    }

    /**
     * DB登録_再処理準備_計算結果明細削除するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(DB登録_再処理準備_計算結果明細削除)
    protected IBatchFlowCommand kogakuGassanDeleteKeisanKekkaMeisaiProcess() {
        KogakuGassanShikyugakuKeisanKekkaInParameter parameter = new KogakuGassanShikyugakuKeisanKekkaInParameter();
        parameter.set処理年月(getParameter().get処理年月());
        parameter.set処理区分(getParameter().get処理区分());
        return loopBatch(KogakuGassanDeleteKeisanKekkaMeisaiProcess.class).arguments(parameter).define();
    }

    /**
     * DB登録_履歴番号確認するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(DB登録_履歴番号確認)
    protected IBatchFlowCommand kogakuGassanRirekiNoKakuninProcess() {
        return loopBatch(KogakuGassanRirekiNoKakuninProcess.class).define();
    }

    /**
     * 計算結果_マスタ登録するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(計算結果_マスタ登録)
    protected IBatchFlowCommand kogakuGassanInsertMasterProcess() {
        return loopBatch(KogakuGassanInsertMasterProcess.class).define();
    }

    /**
     * 計算結果_マスタ登録するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(計算結果明細_マスタ登録)
    protected IBatchFlowCommand kogakuGassanInsertMasterMeisaiProcess() {
        return loopBatch(KogakuGassanInsertMasterMeisaiProcess.class).define();
    }

    /**
     * 国保連インタフェース管理更新するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(国保連インタフェース管理更新)
    protected IBatchFlowCommand updateInterfaceKanriKousinProcess() {
        KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter parameter
                = new KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter();
        parameter.set処理年月(getParameter().get処理年月());
        parameter.set交換情報識別番号(交換情報識別番号);
        parameter.set処理対象年月(flowEntity.getShoriYM());
        parameter.setレコード件数合計(flowEntity.getCodeNum());
        parameter.setFileNameList(returnEntity.getFileNameList());
        return simpleBatch(KokuhorenkyoutsuDoInterfaceKanriKousinProcess.class).arguments(parameter).define();
    }

    /**
     * 連絡票情報確認リスト作成するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(連絡票情報確認リスト作成)
    protected IBatchFlowCommand pntKogakuGassanKakuninIchiranProcess() {
        KogakuGassanShikyugakuKeisanKekkaInParameter parameter = new KogakuGassanShikyugakuKeisanKekkaInParameter();
        parameter.set作成日時(RDateTime.now());
        parameter.set出力順ID(getParameter().get出力順ID());
        parameter.set処理年月(getParameter().get処理年月());
        return loopBatch(PntKogakuGassanKakuninIchiranProcess.class).arguments(parameter).define();
    }

    /**
     * 連絡票情報取込一覧表作成するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(連絡票情報取込一覧表作成)
    protected IBatchFlowCommand pntKogakuGassanTorikomiIchiranProcess() {
        KogakuGassanShikyugakuKeisanKekkaInParameter parameter = new KogakuGassanShikyugakuKeisanKekkaInParameter();
        parameter.set作成日時(RDateTime.now());
        parameter.set出力順ID(getParameter().get出力順ID());
        parameter.set処理年月(getParameter().get処理年月());
        parameter.set計算結果登録件数(集計件数);
        parameter.set計算結果明細登録件数(明細件数);
        return loopBatch(PntKogakuGassanTorikomiIchiranProcess.class).arguments(parameter).define();
    }

    /**
     * 処理結果リスト作成するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(処理結果リスト作成)
    protected IBatchFlowCommand doShoriKekkaListSakuseiProcess() {
        KokuhorenkyotsuDoShoriKekkaListSakuseiProcessParameter parameter
                = new KokuhorenkyotsuDoShoriKekkaListSakuseiProcessParameter();
        parameter.setエラーリストタイプ(KokuhorenJoho_TorikomiErrorListType.リストタイプ0);
        return simpleBatch(KokuhorenkyoutsuDoShoriKekkaListSakuseiProcess.class).arguments(parameter).define();
    }

    /**
     * 取込済ファイル削除するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(取込済ファイル削除)
    protected IBatchFlowCommand deleteReveicedFileProcess() {
        KokuhorenkyotsuDeleteReveicedFileProcessParameter parameter
                = new KokuhorenkyotsuDeleteReveicedFileProcessParameter();
        parameter.set処理年月(getParameter().get処理年月());
        parameter.set保存先フォルダ(returnEntity.get保存先フォルダのパス().toRString());
        parameter.setエントリ情報List(returnEntity.getEntityList());
        return simpleBatch(KokuhorenkyoutsuDeleteReveicedFileProcess.class).arguments(parameter).define();
    }
}
