/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import java.io.File;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120130.KogakuGassanJSaiSyoriJyunbiDoInsertProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120130.KogakuGassanJSaiSyoriJyunbiDoMasterProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120130.KogakuGassanJSaiSyoriJyunbiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120130.KogakuGassanJikofutangakuShomeishoIchiranhyoSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC640011.KogakuGassanJikofutangakuShomeishoInProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDeleteReveicedFileProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDoHihokenshaKanrenProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDoInterfaceKanriKousinProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDoShoriKekkaListSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuGetFileProcess;
import jp.co.ndensan.reams.db.dbc.business.core.kokuhorenkyoutsuu.KokuhorenKyoutsuuFileGetReturnEntity;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC120130.DBC120130_KogakuGassanJikofutangakuShomeishoInParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_TorikomiErrorListType;
import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc120110.KogakuGassanJikofutangakuDoMasterTorokuProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakugassanjikofutangakushomeishoin.KogakuGassanJikofutangakuShomeishoInProcessParamerter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuDeleteReveicedFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuDoShoriKekkaListSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuGetFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kyufujissekikoshinin.KyufuJissekiKoshinDoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassanjikofutangakushomeishoin.KogakuGassanJikofutangakuShomeishoFlowEntity;
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
 * 高額合算自己負担額証明書情報取込のバッチ用パラメータクラスです。
 *
 * @reamsid_L DBC-2640-010 zhengshenlei
 */
public class DBC120130_KogakuGassanJikofutangakuShomeishoIn extends BatchFlowBase<DBC120130_KogakuGassanJikofutangakuShomeishoInParameter> {

    private static final String ファイル取得 = "getFile";
    private static final String CSVファイル取込 = "readCsvFile";
    private static RString 交換情報識別番号;
    private static final RString ファイル格納フォルダ名 = new RString("DBC120130");
    private static final String 被保険者関連処理 = "doHihokenshaKanren";
    private static final String 国保連インタフェース管理更新 = "doInterfaceKanriKousin";
    private static final String 一覧表作成 = "doIchiranhyoSakusei";
    private static final String 処理結果リスト作成 = "doShoriKekkaListSakusei";
    private static final String 取込済ファイル削除 = "deleteReveicedFile";
    private KogakuGassanJikofutangakuShomeishoFlowEntity flowEntity;
    private static final String マスタ登録_再処理準備 = "doMasterTorokuSaiShori";
    private static final String マスタ登録_マスタ更新 = "doMasterTorokuUpdate";
    private static final String マスタ登録_マスタ更新_2 = "doMasterTorokuUpdate2";
    private RString csvFullPath;
    private int レコード件数合算;

    private KokuhorenKyoutsuuFileGetReturnEntity returnEntity;
    private KogakuGassanJikofutangakuShomeishoInProcessParamerter parameter;

    @Override
    protected void defineFlow() {
        try {
            交換情報識別番号 = DbBusinessConfig.get(
                    ConfigNameDBC.国保連取込_高額合算自己負担額証明書情報_交換情報識別番号, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
            executeStep(ファイル取得);
            returnEntity
                    = getResult(KokuhorenKyoutsuuFileGetReturnEntity.class,
                            new RString(ファイル取得), KokuhorenkyoutsuGetFileProcess.PARAMETER_OUT_RETURNENTITY);
            parameter = new KogakuGassanJikofutangakuShomeishoInProcessParamerter();
            int size = returnEntity.getFileNameList().size();
            for (int i = 0; i < size; i++) {
                parameter.setFileName(returnEntity.getFileNameList().get(i));
                String filePath = returnEntity.get保存先フォルダのパス() + File.separator;
                File path = new File(filePath);
                csvFullPath = new RString(path.getPath());
                parameter.setPath(csvFullPath);
                if (i == 0) {
                    parameter.set処理年月(null);
                    parameter.set連番(0);
                } else {
                    parameter.set処理年月(flowEntity.getShoriYM());
                    parameter.set連番(flowEntity.get連番());
                }
                if (i == size - 1) {
                    parameter.setさいごファイルフラグ(true);
                } else {
                    parameter.setさいごファイルフラグ(false);
                }
                executeStep(CSVファイル取込);
                flowEntity = getResult(KogakuGassanJikofutangakuShomeishoFlowEntity.class, new RString(CSVファイル取込),
                        KogakuGassanJikofutangakuShomeishoInProcess.PARAMETER_OUT_FLOWENTITY);
                if (null != flowEntity) {
                    レコード件数合算 = レコード件数合算 + flowEntity.getCodeNum();
                    parameter.setレコード件数合算(レコード件数合算);
                }
            }

            if (0 == レコード件数合算) {
                executeStep(国保連インタフェース管理更新);
                executeStep(処理結果リスト作成);
            } else {
                executeStep(被保険者関連処理);
                if (SaiShoriKubun.再処理.equals(getParameter().getSaishoriKubun())) {
                    executeStep(マスタ登録_再処理準備);
                }
                executeStep(マスタ登録_マスタ更新);
                executeStep(マスタ登録_マスタ更新_2);
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
     * @return KohifutanshaGetFileProcess
     */
    @Step(ファイル取得)
    protected IBatchFlowCommand callGetFileProcess() {
        KokuhorenkyotsuGetFileProcessParameter processparameter = new KokuhorenkyotsuGetFileProcessParameter();
        processparameter.set交換情報識別番号(交換情報識別番号);
        processparameter.setファイル格納フォルダ名(ファイル格納フォルダ名);
        processparameter.setLoginUserID(getParameter().getLoginUserId());
        return simpleBatch(KokuhorenkyoutsuGetFileProcess.class).arguments(processparameter).define();
    }

    /**
     * CSVファイル取込です。
     *
     * @return KohifutanshaReadCsvFileProcess
     */
    @Step(CSVファイル取込)
    protected IBatchFlowCommand callReadCsvFileProcess() {
        return loopBatch(KogakuGassanJikofutangakuShomeishoInProcess.class).arguments(parameter).define();
    }

    /**
     * 被保険者関連処理です。
     *
     * @return KohifutanshaDoHihokenshaKanrenProcess
     */
    @Step(被保険者関連処理)
    protected IBatchFlowCommand callDoHihokenshaKanrenProcess() {
        return simpleBatch(KokuhorenkyoutsuDoHihokenshaKanrenProcess.class).define();
    }

    /**
     * マスタ登録_再処理準備です。
     *
     * @return KogakuGassanJikofutangakuDoMasterTorokuSaiShoriProcess
     */
    @Step(マスタ登録_再処理準備)
    protected IBatchFlowCommand callDoMasterTorokuSaiShoriProcess() {
        KogakuGassanJikofutangakuDoMasterTorokuProcessParameter processparameter = new KogakuGassanJikofutangakuDoMasterTorokuProcessParameter();
        processparameter.set処理年月(getParameter().getShoriYM());
        return loopBatch(KogakuGassanJSaiSyoriJyunbiProcess.class).arguments(processparameter).define();
    }

    /**
     * マスタ登録_マスタ更新です。
     *
     * @return KogakuGassanJikofutangakuDoMasterTorokuProcess
     */
    @Step(マスタ登録_マスタ更新)
    protected IBatchFlowCommand callDoMasterTorokuProcess() {
        KogakuGassanJikofutangakuDoMasterTorokuProcessParameter processparameter = new KogakuGassanJikofutangakuDoMasterTorokuProcessParameter();
        processparameter.set処理年月(getParameter().getShoriYM());
        return loopBatch(KogakuGassanJSaiSyoriJyunbiDoMasterProcess.class).arguments(processparameter).define();
    }

    /**
     * マスタ登録_明細のマスタ追加です。
     *
     * @return KogakuGassanJSaiSyoriJyunbiDoInsertProcess
     */
    @Step(マスタ登録_マスタ更新_2)
    protected IBatchFlowCommand callDoMasterTorokuMeisaiInsertProcess() {
        return loopBatch(KogakuGassanJSaiSyoriJyunbiDoInsertProcess.class).define();
    }

    /**
     * 国保連インタフェース管理更新です。
     *
     * @return KohifutanshaDoInterfaceKanriKousinProcess
     */
    @Step(国保連インタフェース管理更新)
    protected IBatchFlowCommand callDoInterfaceKanriKousinProcess() {
        KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter processparameter
                = new KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter();
        processparameter.set処理年月(getParameter().getShoriYM());
        processparameter.set交換情報識別番号(交換情報識別番号);
        processparameter.set処理対象年月(flowEntity.getShoriYM());
        processparameter.setレコード件数合計(レコード件数合算);
        processparameter.setFileNameList(returnEntity.getFileNameList());
        return simpleBatch(KokuhorenkyoutsuDoInterfaceKanriKousinProcess.class).arguments(processparameter).define();
    }

    /**
     * 一覧表作成です。
     *
     * @return KohifutanshaDoIchiranhyoSakuseiProcess
     */
    @Step(一覧表作成)
    protected IBatchFlowCommand callDoIchiranhyoSakuseiProcess() {
        KyufuJissekiKoshinDoIchiranhyoSakuseiProcessParameter processparameter
                = new KyufuJissekiKoshinDoIchiranhyoSakuseiProcessParameter();
        processparameter.setサブ業務コード(SubGyomuCode.DBC介護給付);
        processparameter.set帳票ID(ReportIdDBC.DBC200034.getReportId());
        processparameter.set出力順ID(Long.valueOf(getParameter().getShutsuryokujunId().toString()));
        processparameter.set処理年月(getParameter().getShoriYM());
        processparameter.setシステム日付(RDateTime.now());
        return loopBatch(KogakuGassanJikofutangakuShomeishoIchiranhyoSakuseiProcess.class).arguments(processparameter).
                define();
    }

    /**
     * 処理結果リスト作成です。
     *
     * @return KohifutanshaDoShoriKekkaListSakuseiProcess
     */
    @Step(処理結果リスト作成)
    protected IBatchFlowCommand callDoShoriKekkaListSakuseiProcess() {
        KokuhorenkyotsuDoShoriKekkaListSakuseiProcessParameter processparameter
                = new KokuhorenkyotsuDoShoriKekkaListSakuseiProcessParameter();
        processparameter.setエラーリストタイプ(KokuhorenJoho_TorikomiErrorListType.リストタイプ3);
        return simpleBatch(KokuhorenkyoutsuDoShoriKekkaListSakuseiProcess.class).arguments(processparameter).define();
    }

    /**
     * 取込済ファイル削除です。
     *
     * @return KohifutanshaDeleteReveicedFileProcess
     */
    @Step(取込済ファイル削除)
    protected IBatchFlowCommand callDeleteReveicedFileProcess() {
        KokuhorenkyotsuDeleteReveicedFileProcessParameter processparameter
                = new KokuhorenkyotsuDeleteReveicedFileProcessParameter();
        processparameter.set処理年月(getParameter().getShoriYM());
        processparameter.set保存先フォルダ(returnEntity.get保存先フォルダのパス().toRString());
        processparameter.setエントリ情報List(returnEntity.getEntityList());
        return simpleBatch(KokuhorenkyoutsuDeleteReveicedFileProcess.class).arguments(processparameter).define();
    }
}
