/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import java.io.File;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120060.KyufuJissekiKoshinDoIchiranhyoSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120060.KyufuJissekiKoshinGetJigyoshaNameProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120060.KyufuJissekiKoshinGetNameProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120060.KyufuJissekiKoshinReadCsvFileProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDeleteReveicedFileProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDoHihokenshaKanrenProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDoInterfaceKanriKousinProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDoShoriKekkaListSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuGetFileProcess;
import jp.co.ndensan.reams.db.dbc.business.core.kokuhorenkyoutsuu.KokuhorenKyoutsuuFileGetReturnEntity;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.kokuhorenkyoutsu.KokuhorenKyoutsuBatchParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_TorikomiErrorListType;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuDeleteReveicedFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuDoShoriKekkaListSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuGetFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kyufujissekikoshinin.KyufuJissekiKoshinDoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kyufujissekikoshinin.KyufuJissekiKoshinReadCsvFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
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
 * 給付実績更新結果情報取込のバッチ処理フロー
 *
 * @reamsid_L DBC-2470-010 liuhui
 */
public class DBC120060_KyufuJissekiKoshinIn extends BatchFlowBase<KokuhorenKyoutsuBatchParameter> {

    private static final String ファイル取得 = "getFile";
    private static final String CSVファイル取込 = "readCsvFile";
    private static final String 事業者名称取得 = "getJigyoshaName";
    private static final String 入力識別名称取得 = "getName";
    private static final String 被保険者関連処理 = "doHihokenshaKanren";
    private static final String 国保連インタフェース管理更新 = "doInterfaceKanriKousin";
    private static final String 一覧表作成 = "doIchiranhyoSakusei";
    private static final String 処理結果リスト作成 = "doShoriKekkaListSakusei";
    private static final String 取込済ファイル削除 = "deleteReveicedFile";
    private static final RString ファイル格納フォルダ名 = new RString("DBC120060");

    private KokuhorenKyoutsuuFileGetReturnEntity returnEntity;
    private FlowEntity flowEntity;
    private RString csvFullPath;
    private int レコード件数合算 = 0;
    private boolean isLast = false;
    private static RString 交換情報識別番号;

    @Override
    protected void defineFlow() {
        try {
            RDate now = RDate.getNowDate();
            交換情報識別番号 = DbBusinessConfig.get(
                    ConfigNameDBC.国保連取込_給付実績更新結果情報_交換情報識別番号,
                    now, SubGyomuCode.DBC介護給付);
            executeStep(ファイル取得);
            returnEntity
                    = getResult(KokuhorenKyoutsuuFileGetReturnEntity.class, new RString(ファイル取得),
                            KokuhorenkyoutsuGetFileProcess.PARAMETER_OUT_RETURNENTITY);
            int size = returnEntity.getFileNameList().size();
            for (int i = 0; i < size; i++) {
                String filePath = returnEntity.get保存先フォルダのパス() + File.separator
                        + returnEntity.getFileNameList().get(i);
                File path = new File(filePath);
                csvFullPath = new RString(path.getPath());
                if (i == size - 1) {
                    isLast = true;
                }
                executeStep(CSVファイル取込);
                flowEntity = getResult(FlowEntity.class, new RString(CSVファイル取込),
                        KyufuJissekiKoshinReadCsvFileProcess.PARAMETER_OUT_FLOWENTITY);
                if (null != flowEntity) {
                    レコード件数合算 = flowEntity.getCodeNum();
                }
            }
            if (0 == レコード件数合算) {
                executeStep(国保連インタフェース管理更新);
                executeStep(処理結果リスト作成);
            } else {
                executeStep(事業者名称取得);
                executeStep(入力識別名称取得);
                executeStep(被保険者関連処理);
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
        KokuhorenkyotsuGetFileProcessParameter parameter = new KokuhorenkyotsuGetFileProcessParameter();
        parameter.set交換情報識別番号(交換情報識別番号);
        parameter.setファイル格納フォルダ名(ファイル格納フォルダ名);
        return simpleBatch(KokuhorenkyoutsuGetFileProcess.class).arguments(parameter).define();
    }

    /**
     * CSVファイル取込です。
     *
     * @return KohifutanshaReadCsvFileProcess
     */
    @Step(CSVファイル取込)
    protected IBatchFlowCommand callReadCsvFileProcess() {
        KyufuJissekiKoshinReadCsvFileProcessParameter parameter = new KyufuJissekiKoshinReadCsvFileProcessParameter();
        parameter.set処理年月(getParameter().getShoriYM());
        parameter.set保存先フォルダ(csvFullPath);
        parameter.setエントリ情報List(returnEntity.getFileNameList());
        parameter.set連番(レコード件数合算);
        parameter.setLast(isLast);
        return loopBatch(KyufuJissekiKoshinReadCsvFileProcess.class).arguments(parameter).define();
    }

    /**
     * 事業者名称取得です。
     *
     * @return KyufuJissekiKoshinGetJigyoshaNameProcess
     */
    @Step(事業者名称取得)
    protected IBatchFlowCommand callGetJigyoshaNameProcess() {
        return loopBatch(KyufuJissekiKoshinGetJigyoshaNameProcess.class).define();
    }

    /**
     * 入力識別名称取得です。
     *
     * @return KyufuJissekiKoshinGetNameProcess
     */
    @Step(入力識別名称取得)
    protected IBatchFlowCommand callGetNameProcess() {
        return loopBatch(KyufuJissekiKoshinGetNameProcess.class).define();
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
     * 国保連インタフェース管理更新です。
     *
     * @return KohifutanshaDoInterfaceKanriKousinProcess
     */
    @Step(国保連インタフェース管理更新)
    protected IBatchFlowCommand callDoInterfaceKanriKousinProcess() {
        KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter parameter
                = new KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter();
        parameter.set処理年月(getParameter().getShoriYM());
        parameter.set交換情報識別番号(交換情報識別番号);
        parameter.set処理対象年月(flowEntity.getShoriYM());
        parameter.setレコード件数合計(レコード件数合算);
        parameter.setFileNameList(returnEntity.getFileNameList());
        return simpleBatch(KokuhorenkyoutsuDoInterfaceKanriKousinProcess.class).arguments(parameter).define();
    }

    /**
     * 一覧表作成です。
     *
     * @return KohifutanshaDoIchiranhyoSakuseiProcess
     */
    @Step(一覧表作成)
    protected IBatchFlowCommand callDoIchiranhyoSakuseiProcess() {
        KyufuJissekiKoshinDoIchiranhyoSakuseiProcessParameter parameter
                = new KyufuJissekiKoshinDoIchiranhyoSakuseiProcessParameter();
        parameter.setサブ業務コード(SubGyomuCode.DBC介護給付);
        parameter.set帳票ID(new ReportId(ReportIdDBC.DBC200054.getReportId().getColumnValue()));
        parameter.set出力順ID(Long.valueOf(getParameter().getShutsuryokujunId().toString()));
        parameter.set処理年月(getParameter().getShoriYM());
        parameter.setシステム日付(RDateTime.now());
        return loopBatch(KyufuJissekiKoshinDoIchiranhyoSakuseiProcess.class).arguments(parameter).
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
        parameter.setエラーリストタイプ(KokuhorenJoho_TorikomiErrorListType.リストタイプ1);
        return simpleBatch(KokuhorenkyoutsuDoShoriKekkaListSakuseiProcess.class).arguments(parameter).define();
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
        parameter.set処理年月(getParameter().getShoriYM());
        parameter.set保存先フォルダ(returnEntity.get保存先フォルダのパス().toRString());
        parameter.setエントリ情報List(returnEntity.getEntityList());
        return simpleBatch(KokuhorenkyoutsuDeleteReveicedFileProcess.class).arguments(parameter).define();
    }
}
