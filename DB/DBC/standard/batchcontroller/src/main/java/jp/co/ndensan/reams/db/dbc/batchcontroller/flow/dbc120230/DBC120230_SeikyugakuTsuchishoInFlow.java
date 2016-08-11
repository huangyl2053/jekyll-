/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow.dbc120070;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120070.KogakuKyufuTaishoshaInDoIchiranhyoSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120070.KogakuKyufuTaishoshaInDoMasterTorokuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120070.KogakuKyufuTaishoshaInReadCsvFileProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120070.KogakuKyufuTaishoshaInSetSedaiShuuyakuBangoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120170.KohifutanshaDeleteReveicedFileProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120170.KohifutanshaDoHihokenshaKanrenProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120170.KohifutanshaDoInterfaceKanriKousinProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120170.KohifutanshaDoShoriKekkaListSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120170.KohifutanshaGetFileProcess;
import jp.co.ndensan.reams.db.dbc.business.core.kokuhorenkyoutsuu.KokuhorenKyoutsuuFileGetReturnEntity;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.kogakukyufutaishoshain.KogakuKyufuTaishoshaInBatchParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_TorikomiErrorListType;
import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kagoketteikohifutanshain.KohifutanshaDeleteReveicedFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kagoketteikohifutanshain.KohifutanshaDoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kagoketteikohifutanshain.KohifutanshaDoInterfaceKanriKousinProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kagoketteikohifutanshain.KohifutanshaDoMasterTorokuProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kagoketteikohifutanshain.KohifutanshaDoShoriKekkaListSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kagoketteikohifutanshain.KohifutanshaGetFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kagoketteikohifutanshain.KohifutanshaReadCsvFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.FlowEntity;
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
 * 高額介護サービス費給付対象者取込みのバッチ処理フロー
 *
 * @reamsid_L DBC-0980-360 chenaoqi
 */
public class DBC120070_KogakuKyufuTaishoshaInFlow extends BatchFlowBase<KogakuKyufuTaishoshaInBatchParameter> {

    private static final String ファイル取得 = "getFile";
    private static final String CSVファイル取込 = "readCsvFile";
    private static final String 被保険者関連処理 = "doHihokenshaKanren";
    private static final String 世帯集約番号設定 = "setSedaiShuuyakuBango";
    private static final String マスタ登録 = "doMasterToroku";
    private static final String 国保連インタフェース管理更新 = "doInterfaceKanriKousin";
    private static final String 一覧表作成 = "doIchiranhyoSakusei";
    private static final String 処理結果リスト作成 = "doShoriKekkaListSakusei";
    private static final String 取込済ファイル削除 = "deleteReveicedFile";

    private static final RString ファイル格納フォルダ名 = new RString("DBC120070");
    private static final RString 帳票ID = new RString("DBC200014_KogakuKyufuTaishoshaIchiran");

    private KokuhorenKyoutsuuFileGetReturnEntity returnEntity;
    private FlowEntity flowEntity;

    private static RString 交換情報識別番号;

    @Override
    protected void defineFlow() {
        try {
            RDate now = RDate.getNowDate();
            交換情報識別番号 = DbBusinessConfig.get(
                    ConfigNameDBC.国保連取込_高額介護サービス費給付対象者一覧表情報_交換情報識別番号,
                    now, SubGyomuCode.DBC介護給付);
            executeStep(ファイル取得);
            returnEntity
                    = getResult(KokuhorenKyoutsuuFileGetReturnEntity.class, new RString(ファイル取得),
                            KohifutanshaGetFileProcess.PARAMETER_OUT_RETURNENTITY);
            executeStep(CSVファイル取込);
            flowEntity = getResult(FlowEntity.class, new RString(CSVファイル取込),
                    KogakuKyufuTaishoshaInReadCsvFileProcess.PARAMETER_OUT_FLOWENTITY);
            if (0 == flowEntity.get明細データ登録件数() && 0 == flowEntity.get集計データ登録件数()) {
                executeStep(国保連インタフェース管理更新);
                executeStep(処理結果リスト作成);
            } else {
                executeStep(被保険者関連処理);
                executeStep(世帯集約番号設定);
                executeStep(マスタ登録);
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
        KohifutanshaGetFileProcessParameter parameter = new KohifutanshaGetFileProcessParameter();
        parameter.set交換情報識別番号(交換情報識別番号);
        parameter.setファイル格納フォルダ名(ファイル格納フォルダ名);
        return simpleBatch(KohifutanshaGetFileProcess.class).arguments(parameter).define();
    }

    /**
     * CSVファイル取込です。
     *
     * @return KohifutanshaReadCsvFileProcess
     */
    @Step(CSVファイル取込)
    protected IBatchFlowCommand callReadCsvFileProcess() {
        KohifutanshaReadCsvFileProcessParameter parameter = new KohifutanshaReadCsvFileProcessParameter();
        parameter.set処理年月(getParameter().get処理年月());
        parameter.set保存先フォルダ(returnEntity.get保存先フォルダのパス().toRString());
        parameter.setエントリ情報List(returnEntity.getFileNameList());
        return simpleBatch(KogakuKyufuTaishoshaInReadCsvFileProcess.class).arguments(parameter).define();
    }

    /**
     * 被保険者関連処理です。
     *
     * @return KohifutanshaDoHihokenshaKanrenProcess
     */
    @Step(被保険者関連処理)
    protected IBatchFlowCommand callDoHihokenshaKanrenProcess() {
        return simpleBatch(KohifutanshaDoHihokenshaKanrenProcess.class).define();
    }

    /**
     * 世帯集約番号設定です。
     *
     * @return KohifutanshaDoMasterTorokuProcess
     */
    @Step(世帯集約番号設定)
    protected IBatchFlowCommand callSetSedaiShuuyakuBangoProcess() {
        return loopBatch(KogakuKyufuTaishoshaInSetSedaiShuuyakuBangoProcess.class).define();
    }

    /**
     * マスタ登録です。
     *
     * @return KogakuKyufuTaishoshaInSetSedaiShuuyakuBangoProcess
     */
    @Step(マスタ登録)
    protected IBatchFlowCommand callDoMasterTorokuProcess() {
        KohifutanshaDoMasterTorokuProcessParameter parameter = new KohifutanshaDoMasterTorokuProcessParameter();
        parameter.set処理年月(getParameter().get処理年月());
        parameter.set再処理区分(SaiShoriKubun.toValue(getParameter().get再処理区分()));
        parameter.set交換情報識別番号(交換情報識別番号);
        return simpleBatch(KogakuKyufuTaishoshaInDoMasterTorokuProcess.class).arguments(parameter).define();
    }

    /**
     * 国保連インタフェース管理更新です。
     *
     * @return KohifutanshaDoInterfaceKanriKousinProcess
     */
    @Step(国保連インタフェース管理更新)
    protected IBatchFlowCommand callDoInterfaceKanriKousinProcess() {
        KohifutanshaDoInterfaceKanriKousinProcessParameter parameter
                = new KohifutanshaDoInterfaceKanriKousinProcessParameter();
        parameter.set処理年月(getParameter().get処理年月());
        parameter.set交換情報識別番号(交換情報識別番号);
        parameter.set処理対象年月(flowEntity.getShoriYM());
        parameter.setレコード件数合計(flowEntity.getCodeNum());
        parameter.setFileNameList(returnEntity.getFileNameList());
        return simpleBatch(KohifutanshaDoInterfaceKanriKousinProcess.class).arguments(parameter).define();
    }

    /**
     * 一覧表作成です。
     *
     * @return KohifutanshaDoIchiranhyoSakuseiProcess
     */
    @Step(一覧表作成)
    protected IBatchFlowCommand callDoIchiranhyoSakuseiProcess() {
        KohifutanshaDoIchiranhyoSakuseiProcessParameter parameter
                = new KohifutanshaDoIchiranhyoSakuseiProcessParameter();
        parameter.setサブ業務コード(SubGyomuCode.DBC介護給付);
        parameter.set帳票ID(new ReportId(帳票ID));
        parameter.set出力順ID(getParameter().get出力順ID());
        parameter.set処理年月(getParameter().get処理年月());
        parameter.setシステム日付(RDateTime.now());
        return simpleBatch(KogakuKyufuTaishoshaInDoIchiranhyoSakuseiProcess.class).arguments(parameter).
                define();
    }

    /**
     * 処理結果リスト作成です。
     *
     * @return KohifutanshaDoShoriKekkaListSakuseiProcess
     */
    @Step(処理結果リスト作成)
    protected IBatchFlowCommand callDoShoriKekkaListSakuseiProcess() {
        KohifutanshaDoShoriKekkaListSakuseiProcessParameter parameter
                = new KohifutanshaDoShoriKekkaListSakuseiProcessParameter();
        parameter.setエラーリストタイプ(KokuhorenJoho_TorikomiErrorListType.リストタイプ1);
        return simpleBatch(KohifutanshaDoShoriKekkaListSakuseiProcess.class).arguments(parameter).define();
    }

    /**
     * 取込済ファイル削除です。
     *
     * @return KohifutanshaDeleteReveicedFileProcess
     */
    @Step(取込済ファイル削除)
    protected IBatchFlowCommand callDeleteReveicedFileProcess() {
        KohifutanshaDeleteReveicedFileProcessParameter parameter
                = new KohifutanshaDeleteReveicedFileProcessParameter();
        parameter.set処理年月(getParameter().get処理年月());
        parameter.set保存先フォルダ(returnEntity.get保存先フォルダのパス().toRString());
        parameter.setエントリ情報List(returnEntity.getEntityList());
        return simpleBatch(KohifutanshaDeleteReveicedFileProcess.class).arguments(parameter).define();
    }
}
