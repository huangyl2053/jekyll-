/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import java.io.File;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120110.KogakuGassanJikofutangakuDoMasterTorokuMeisaiInsertProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120110.KogakuGassanJikofutangakuDoMasterTorokuMeisaiUpdateProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120110.KogakuGassanJikofutangakuDoMasterTorokuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120110.KogakuGassanJikofutangakuDoMasterTorokuSaiShoriProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120110.KogakuGassanJikofutangakuKakunDoIchiranhyoSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC640011.KogakuGassanJikofutangakuShomeishoInProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDeleteReveicedFileProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDoHihokenshaKanrenProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDoInterfaceKanriKousinProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDoShoriKekkaListSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuGetFileProcess;
import jp.co.ndensan.reams.db.dbc.business.core.kokuhorenkyoutsuu.KokuhorenKyoutsuuFileGetReturnEntity;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC120110.DBC120110_KogakuGassanJikofutangakuKakuninInParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_TorikomiErrorListType;
import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc120110.KogakuGassanJikofutangakuDoMasterTorokuProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kagoketteikohifutanshain.KohifutanshaDoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakugassanjikofutangakushomeishoin.KogakuGassanJikofutangakuShomeishoInProcessParamerter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuDeleteReveicedFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuDoShoriKekkaListSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuGetFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassanjikofutangakushomeishoin.KogakuGassanJikofutangakuShomeishoFlowEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 37J_高額合算自己負担額確認情報取込のバッチ処理フロー。
 *
 * @reamsid_L DBC-2650-010 chenjie
 */
public class DBC120110_KogakuGassanJikofutangakuKakuninIn extends BatchFlowBase<DBC120110_KogakuGassanJikofutangakuKakuninInParameter> {

    private static final String ファイル取得 = "getFile";
    private static final String CSVファイル取込 = "readCsvFile";
    private static final String 被保険者関連処理 = "doHihokenshaKanren";
    private static final String マスタ登録_再処理準備 = "doMasterTorokuSaiShori";
    private static final String マスタ登録_マスタ更新 = "doMasterToroku";
    private static final String マスタ登録_明細のマスタ追加 = "doMasterTorokuMeisaiInsert";
    private static final String マスタ登録_明細のマスタ更新 = "doMasterTorokuMeisaiUpdate";
    private static final String 国保連インタフェース管理更新 = "doInterfaceKanriKousin";
    private static final String 一覧表作成 = "doIchiranhyoSakusei";
    private static final String 処理結果リスト作成 = "doShoriKekkaListSakusei";
    private static final String 取込済ファイル削除 = "deleteReveicedFile";
    private static final RString ファイル格納フォルダ名 = new RString("DBC120110");

    private static ReportId 帳票ID;
    private static RString 交換情報識別番号;
    private RString ファイル絶対パース;
    private KogakuGassanJikofutangakuShomeishoFlowEntity flowEntity;
    private KokuhorenKyoutsuuFileGetReturnEntity returnEntity;
    private KogakuGassanJikofutangakuShomeishoInProcessParamerter csvparameter;

    @Override
    protected void defineFlow() {
        try {
            帳票ID = ReportIdDBC.DBC200028.getReportId();
            RDate now = RDate.getNowDate();
            RString 処理区分 = RString.EMPTY;
            if (getParameter().get処理区分() != null) {
                処理区分 = getParameter().get処理区分();
            }
            交換情報識別番号 = DbBusinessConfig.get(
                    ConfigNameDBC.国保連取込_高額合算自己負担額確認情報_交換情報識別番号,
                    now, SubGyomuCode.DBC介護給付).concat(処理区分.trim());
            executeStep(ファイル取得);
            returnEntity
                    = getResult(KokuhorenKyoutsuuFileGetReturnEntity.class, new RString(ファイル取得),
                            KokuhorenkyoutsuGetFileProcess.PARAMETER_OUT_RETURNENTITY);
            csvparameter = new KogakuGassanJikofutangakuShomeishoInProcessParamerter();
            String filePath = returnEntity.get保存先フォルダのパス().toString();
            File path = new File(filePath);
            ファイル絶対パース = new RString(path.getPath());
            csvparameter.setPath(ファイル絶対パース);
            for (int i = 0; i < returnEntity.getFileNameList().size(); i++) {
                csvparameter.setFileName(returnEntity.getFileNameList().get(i));
                if (i == 0) {
                    csvparameter.set処理年月(null);
                    csvparameter.set連番(0);
                } else {
                    csvparameter.set処理年月(flowEntity.getShoriYM());
                    csvparameter.set連番(flowEntity.get連番());
                }
                if (i == returnEntity.getFileNameList().size() - 1) {
                    csvparameter.setさいごファイルフラグ(true);
                } else {
                    csvparameter.setさいごファイルフラグ(false);
                }
                executeStep(CSVファイル取込);
                flowEntity = getResult(KogakuGassanJikofutangakuShomeishoFlowEntity.class, new RString(CSVファイル取込),
                        KogakuGassanJikofutangakuShomeishoInProcess.PARAMETER_OUT_FLOWENTITY);
            }
            if (flowEntity.get高額合算自己負担額一時TBL登録件数() == 0) {
                executeStep(国保連インタフェース管理更新);
                executeStep(処理結果リスト作成);
            } else {
                executeStep(被保険者関連処理);
                if (SaiShoriKubun.再処理.equals(getParameter().get再処理区分())) {
                    executeStep(マスタ登録_再処理準備);
                }
                executeStep(マスタ登録_マスタ更新);
                executeStep(マスタ登録_明細のマスタ追加);
                executeStep(マスタ登録_明細のマスタ更新);
                executeStep(国保連インタフェース管理更新);
                executeStep(一覧表作成);
                executeStep(処理結果リスト作成);
            }
        } finally {
            if (null != returnEntity) {
                executeStep(取込済ファイル削除);
            }
        }
    }

    /**
     * ファイル取得です。
     *
     * @return KekkaGetFileProcess
     */
    @Step(ファイル取得)
    protected IBatchFlowCommand callGetFileProcess() {
        KokuhorenkyotsuGetFileProcessParameter parameter = new KokuhorenkyotsuGetFileProcessParameter();
        parameter.set交換情報識別番号(交換情報識別番号);
        parameter.setファイル格納フォルダ名(ファイル格納フォルダ名);
        parameter.setLoginUserID(getParameter().getLoginUserId());
        return simpleBatch(KokuhorenkyoutsuGetFileProcess.class
        ).arguments(parameter).define();
    }

    /**
     * CSVファイル取込です。
     *
     * @return KekkaReadCsvFileProcess
     */
    @Step(CSVファイル取込)
    protected IBatchFlowCommand callReadCsvFileProcess() {
        return loopBatch(KogakuGassanJikofutangakuShomeishoInProcess.class).arguments(csvparameter).define();
    }

    /**
     * 被保険者関連処理です。
     *
     * @return KokuhorenkyoutsuDoHihokenshaKanrenProcess
     */
    @Step(被保険者関連処理)
    protected IBatchFlowCommand callDoHihokenshaKanrenProcess() {
        return simpleBatch(KokuhorenkyoutsuDoHihokenshaKanrenProcess.class
        ).define();
    }

    /**
     * マスタ登録_再処理準備です。
     *
     * @return KogakuGassanJikofutangakuDoMasterTorokuSaiShoriProcess
     */
    @Step(マスタ登録_再処理準備)
    protected IBatchFlowCommand callDoMasterTorokuSaiShoriProcess() {
        KogakuGassanJikofutangakuDoMasterTorokuProcessParameter parameter = new KogakuGassanJikofutangakuDoMasterTorokuProcessParameter();
        parameter.set処理区分(getParameter().get処理区分());
        parameter.set処理年月(getParameter().get処理年月());
        return loopBatch(KogakuGassanJikofutangakuDoMasterTorokuSaiShoriProcess.class).arguments(parameter).define();
    }

    /**
     * マスタ登録_マスタ更新です。
     *
     * @return KogakuGassanJikofutangakuDoMasterTorokuProcess
     */
    @Step(マスタ登録_マスタ更新)
    protected IBatchFlowCommand callDoMasterTorokuProcess() {
        KogakuGassanJikofutangakuDoMasterTorokuProcessParameter parameter = new KogakuGassanJikofutangakuDoMasterTorokuProcessParameter();
        parameter.set再処理区分(getParameter().get再処理区分());
        parameter.set処理年月(getParameter().get処理年月());
        return loopBatch(KogakuGassanJikofutangakuDoMasterTorokuProcess.class).arguments(parameter).define();
    }

    /**
     * マスタ登録_明細のマスタ追加です。
     *
     * @return KogakuGassanJikofutangakuDoMasterTorokuMeisaiInsertProcess
     */
    @Step(マスタ登録_明細のマスタ追加)
    protected IBatchFlowCommand callDoMasterTorokuMeisaiInsertProcess() {
        return loopBatch(KogakuGassanJikofutangakuDoMasterTorokuMeisaiInsertProcess.class).define();
    }

    /**
     * マスタ登録_明細のマスタ更新です。
     *
     * @return KogakuGassanJikofutangakuDoMasterTorokuMeisaiInsertProcess
     */
    @Step(マスタ登録_明細のマスタ更新)
    protected IBatchFlowCommand callDoMasterTorokuMeisaiUpdateProcess() {
        return loopBatch(KogakuGassanJikofutangakuDoMasterTorokuMeisaiUpdateProcess.class).define();
    }

    /**
     * 国保連インタフェース管理更新です。
     *
     * @return KohifutanshaDoInterfaceKanriKousinProcess
     */
    @Step(国保連インタフェース管理更新)
    protected IBatchFlowCommand callDoInterfaceKanriKousinProcess() {
        KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter parameter
                = new KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter();
        parameter.set処理年月(getParameter().get処理年月());
        parameter.set交換情報識別番号(交換情報識別番号);
        parameter.set処理対象年月(flowEntity.getShoriYM());
        parameter.setレコード件数合計(flowEntity.getCodeNum());
        parameter.setFileNameList(returnEntity.getFileNameList());

        return simpleBatch(KokuhorenkyoutsuDoInterfaceKanriKousinProcess.class
        ).arguments(parameter).define();
    }

    /**
     * 一覧表作成です。
     *
     * @return KekkaDoIchiranhyoSakuseiProcess
     */
    @Step(一覧表作成)
    protected IBatchFlowCommand callDoIchiranhyoSakuseiProcess() {
        KohifutanshaDoIchiranhyoSakuseiProcessParameter parameter
                = new KohifutanshaDoIchiranhyoSakuseiProcessParameter();
        parameter.setサブ業務コード(SubGyomuCode.DBC介護給付);
        parameter.set帳票ID(帳票ID);
        parameter.set出力順ID(getParameter().get出力順ID());
        parameter.set処理年月(getParameter().get処理年月());
        parameter.setシステム日付(RDateTime.now());

        return loopBatch(KogakuGassanJikofutangakuKakunDoIchiranhyoSakuseiProcess.class).arguments(parameter).
                define();
    }

    /**
     * 処理結果リスト作成です。
     *
     * @return KohifutanshaDoShoriKekkaListSakuseiProcess
     */
    @Step(処理結果リスト作成)
    protected IBatchFlowCommand callDoShoriKekkaListSakuseiProcess() {
        KokuhorenkyotsuDoShoriKekkaListSakuseiProcessParameter parameter
                = new KokuhorenkyotsuDoShoriKekkaListSakuseiProcessParameter();
        parameter.setエラーリストタイプ(KokuhorenJoho_TorikomiErrorListType.リストタイプ0);

        return simpleBatch(KokuhorenkyoutsuDoShoriKekkaListSakuseiProcess.class
        ).arguments(parameter).define();
    }

    /**
     * 取込済ファイル削除です。
     *
     * @return KohifutanshaDeleteReveicedFileProcess
     */
    @Step(取込済ファイル削除)
    protected IBatchFlowCommand callDeleteReveicedFileProcess() {
        KokuhorenkyotsuDeleteReveicedFileProcessParameter parameter
                = new KokuhorenkyotsuDeleteReveicedFileProcessParameter();
        parameter.set処理年月(getParameter().get処理年月());
        parameter.set保存先フォルダ(returnEntity.get保存先フォルダのパス().toRString());
        parameter.setエントリ情報List(returnEntity.getEntityList());

        return simpleBatch(KokuhorenkyoutsuDeleteReveicedFileProcess.class
        ).arguments(parameter).define();
    }
}
