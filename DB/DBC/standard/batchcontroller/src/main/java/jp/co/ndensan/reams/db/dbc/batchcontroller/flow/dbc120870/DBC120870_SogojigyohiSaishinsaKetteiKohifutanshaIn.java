/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow.dbc120870;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120200.SaishinsaKohifutanshaReadCsvFileProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120870.SogojigyohiSaishinsaDoDbTorokuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120870.SogojigyohiSaishinsaDoIchiranhyoSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDeleteReveicedFileProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDoHihokenshaKanrenProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDoInterfaceKanriKousinProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDoShoriKekkaListSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuGetFileProcess;
import jp.co.ndensan.reams.db.dbc.business.core.kokuhorenkyoutsuu.KokuhorenKyoutsuuFileGetReturnEntity;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.kokuhorenkyoutsu.KokuhorenKyoutsuBatchParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_TorikomiErrorListType;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kagoketteikohifutanshain.KohifutanshaDoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kagoketteikohifutanshain.KohifutanshaDoMasterTorokuProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kagoketteikohifutanshain.KohifutanshaReadCsvFileProcessParameter;
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
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 総合事業費再審査決定通知書情報取込（公費負担者分）のバッチ処理フロー
 *
 * @reamsid_L DBC-4730-030 liuxiaoyu
 */
public class DBC120870_SogojigyohiSaishinsaKetteiKohifutanshaIn
        extends BatchFlowBase<KokuhorenKyoutsuBatchParameter> {

    private static final String ファイル取得 = "getFile";
    private static final String CSVファイル取込 = "readCsvFile";
    private static final String 被保険者関連処理 = "doHihokenshaKanren";
    private static final String マスタ登録 = "doMasterToroku";
    private static final String 国保連インタフェース管理更新 = "doInterfaceKanriKousin";
    private static final String 一覧表作成 = "doIchiranhyoSakusei";
    private static final String 処理結果リスト作成 = "doShoriKekkaListSakusei";
    private static final String 取込済ファイル削除 = "deleteReveicedFile";

    private static final RString ファイル格納フォルダ名 = new RString("DBC120870");
    private static final RString 帳票ID = new RString("DBC200081_SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohi");

    private KokuhorenKyoutsuuFileGetReturnEntity returnEntity;
    private FlowEntity flowEntity;

    private static RString 交換情報識別番号;

    @Override
    protected void defineFlow() {
        try {
            RDate now = RDate.getNowDate();
            交換情報識別番号 = DbBusinessConfig.get(
                    ConfigNameDBC.国保連取込_総合事業費再審査決定通知書公費情報_交換情報識別番号,
                    now, SubGyomuCode.DBC介護給付);
            executeStep(ファイル取得);
            returnEntity
                    = getResult(KokuhorenKyoutsuuFileGetReturnEntity.class, new RString(ファイル取得),
                            KokuhorenkyoutsuGetFileProcess.PARAMETER_OUT_RETURNENTITY);
            executeStep(CSVファイル取込);
            flowEntity = getResult(FlowEntity.class, new RString(CSVファイル取込),
                    SaishinsaKohifutanshaReadCsvFileProcess.PARAMETER_OUT_FLOWENTITY);
            if (0 == flowEntity.get明細データ登録件数() && 0 == flowEntity.get集計データ登録件数()) {
                executeStep(国保連インタフェース管理更新);
                executeStep(処理結果リスト作成);
            } else {
                executeStep(被保険者関連処理);
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
     * @return KokuhorenkyoutsuGetFileProcess
     */
    @Step(ファイル取得)
    protected IBatchFlowCommand callGetFileProcess() {
        KokuhorenkyotsuGetFileProcessParameter parameter = new KokuhorenkyotsuGetFileProcessParameter();
        parameter.set交換情報識別番号(交換情報識別番号);
        parameter.setファイル格納フォルダ名(ファイル格納フォルダ名);
        return simpleBatch(KokuhorenkyoutsuGetFileProcess.class).arguments(parameter).define();
    }

    /**
     * CSVファイル取込です。
     *
     * @return SogojigyohiSaishinsaReadCsvFileProcess
     */
    @Step(CSVファイル取込)
    protected IBatchFlowCommand callReadCsvFileProcess() {
        KohifutanshaReadCsvFileProcessParameter parameter = new KohifutanshaReadCsvFileProcessParameter();
        parameter.set処理年月(getParameter().getShoriYM());
        parameter.set保存先フォルダ(returnEntity.get保存先フォルダのパス().toRString());
        parameter.setエントリ情報List(returnEntity.getFileNameList());
        return simpleBatch(SaishinsaKohifutanshaReadCsvFileProcess.class).arguments(parameter).define();

    }

    /**
     * 被保険者関連処理です。
     *
     * @return KokuhorenkyoutsuDoHihokenshaKanrenProcess
     */
    @Step(被保険者関連処理)
    protected IBatchFlowCommand callDoHihokenshaKanrenProcess() {
        return simpleBatch(KokuhorenkyoutsuDoHihokenshaKanrenProcess.class).define();
    }

    /**
     * マスタ登録です。
     *
     * @return SogojigyohiSaishinsaDoDbTorokuProcess
     */
    @Step(マスタ登録)
    protected IBatchFlowCommand callDoMasterTorokuProcess() {
        KohifutanshaDoMasterTorokuProcessParameter parameter = new KohifutanshaDoMasterTorokuProcessParameter();
        parameter.set処理年月(getParameter().getShoriYM());
        parameter.set再処理区分(getParameter().getSaishoriKubun());
        parameter.set交換情報識別番号(交換情報識別番号);
        return simpleBatch(SogojigyohiSaishinsaDoDbTorokuProcess.class).arguments(parameter).define();
    }

    /**
     * 国保連インタフェース管理更新です。
     *
     * @return KokuhorenkyoutsuDoInterfaceKanriKousinProcess
     *
     */
    @Step(国保連インタフェース管理更新)
    protected IBatchFlowCommand callDoInterfaceKanriKousinProcess() {
        KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter parameter
                = new KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter();
        parameter.set処理年月(getParameter().getShoriYM());
        parameter.set交換情報識別番号(交換情報識別番号);
        parameter.set処理対象年月(flowEntity.getShoriYM());
        parameter.setレコード件数合計(flowEntity.getCodeNum());
        parameter.setFileNameList(returnEntity.getFileNameList());
        return simpleBatch(KokuhorenkyoutsuDoInterfaceKanriKousinProcess.class).arguments(parameter).define();
    }

    /**
     * 一覧表作成です。
     *
     * @return SogojigyohiSaishinsaDoIchiranhyoSakuseiProcess
     *
     */
    @Step(一覧表作成)
    protected IBatchFlowCommand callDoIchiranhyoSakuseiProcess() {
        KohifutanshaDoIchiranhyoSakuseiProcessParameter parameter
                = new KohifutanshaDoIchiranhyoSakuseiProcessParameter();
        parameter.setサブ業務コード(SubGyomuCode.DBC介護給付);
        parameter.set帳票ID(new ReportId(帳票ID));
        parameter.set出力順ID(Long.parseLong(getParameter().getShutsuryokujunId().toString()));
        parameter.set処理年月(getParameter().getShoriYM());
        parameter.setシステム日付(RDate.getNowDateTime());
        return loopBatch(SogojigyohiSaishinsaDoIchiranhyoSakuseiProcess.class).arguments(parameter)
                .define();
    }

    /**
     * 処理結果リスト作成です。
     *
     * @return KokuhorenkyoutsuDoShoriKekkaListSakuseiProcess
     *
     */
    @Step(処理結果リスト作成)
    protected IBatchFlowCommand callDoShoriKekkaListSakuseiProcess() {
        KokuhorenkyotsuDoShoriKekkaListSakuseiProcessParameter parameter
                = new KokuhorenkyotsuDoShoriKekkaListSakuseiProcessParameter();
        parameter.setエラーリストタイプ(KokuhorenJoho_TorikomiErrorListType.リストタイプ1);
        return simpleBatch(KokuhorenkyoutsuDoShoriKekkaListSakuseiProcess.class).arguments(parameter).define();
    }

    /**
     * 取込済ファイル削除です。
     *
     * @return KokuhorenkyoutsuDeleteReveicedFileProcess
     *
     */
    @Step(取込済ファイル削除)
    protected IBatchFlowCommand callDeleteReveicedFileProcess() {
        KokuhorenkyotsuDeleteReveicedFileProcessParameter parameter
                = new KokuhorenkyotsuDeleteReveicedFileProcessParameter();
        parameter.set処理年月(getParameter().getShoriYM());
        parameter.set保存先フォルダ(ファイル格納フォルダ名);
        parameter.setエントリ情報List(returnEntity.getEntityList());
        return simpleBatch(KokuhorenkyoutsuDeleteReveicedFileProcess.class).arguments(parameter).define();

    }
}
