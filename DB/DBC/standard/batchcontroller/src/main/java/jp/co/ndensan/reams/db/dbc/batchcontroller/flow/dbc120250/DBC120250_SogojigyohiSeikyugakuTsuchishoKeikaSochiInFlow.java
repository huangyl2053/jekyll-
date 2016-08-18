/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow.dbc120250;

import java.io.File;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120250.SogojigyohiSeiDoIchiranhyoSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120250.SogojigyohiSeikyugakuTsuchishoKeikaSochiReadCsvFileProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120890.SogojigyohiSeikyugakuTsuchishoInReadCsvFileProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDeleteReveicedFileProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDoInterfaceKanriKousinProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDoShoriKekkaListSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuGetFileProcess;
import jp.co.ndensan.reams.db.dbc.business.core.kokuhorenkyoutsuu.KokuhorenKyoutsuuFileGetReturnEntity;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.kokuhorenkyoutsu.KokuhorenKyoutsuBatchParameter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.sogojigyohiseikyugakutsuchishokeikasochiin.SogojigyohiSeiDoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_TorikomiErrorListType;
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
 * 総合事業費（経過措置）請求額通知書情報取込のバッチ処理フロークラスです
 *
 * @reamsid_L DBC-2480-011 jiangxiaolong
 */
public class DBC120250_SogojigyohiSeikyugakuTsuchishoKeikaSochiInFlow
        extends BatchFlowBase<KokuhorenKyoutsuBatchParameter> {

    private static final String ファイル取得 = "getFile";
    private static final String CSVファイル取込 = "readCsvFile";
    private static final String 国保連インタフェース管理更新 = "doInterfaceKanriKousin";
    private static final String 処理結果リスト作成 = "doShoriKekkaListSakusei";
    private static final String 取込済ファイル削除 = "deleteReveicedFile";
    private static final String 一覧表作成 = "doIchiranhyoSakusei";
    private RString csvFullPath;
    private static final RString ファイル格納フォルダ名 = new RString("DBC120250");
    private int レコード件数合算;
    private FlowEntity flowEntity;
    private KokuhorenKyoutsuuFileGetReturnEntity returnEntity;

    private static RString 交換情報識別番号;

    @Override
    protected void defineFlow() {
        try {
            RDate now = RDate.getNowDate();
            交換情報識別番号 = DbBusinessConfig.get(
                    ConfigNameDBC.国保連取込_総合事業費経過措置請求額通知書情報_交換情報識別番号,
                    now, SubGyomuCode.DBC介護給付);
            executeStep(ファイル取得);
            returnEntity
                    = getResult(KokuhorenKyoutsuuFileGetReturnEntity.class, new RString(ファイル取得),
                            KokuhorenkyoutsuGetFileProcess.PARAMETER_OUT_RETURNENTITY);
            for (int i = 0; i < returnEntity.getFileNameList().size(); i++) {
                String filePath = returnEntity.get保存先フォルダのパス() + File.separator
                        + returnEntity.getFileNameList().get(i);
                File path = new File(filePath);
                csvFullPath = new RString(path.getPath());
                executeStep(CSVファイル取込);
                flowEntity = getResult(FlowEntity.class, new RString(CSVファイル取込),
                        SogojigyohiSeikyugakuTsuchishoInReadCsvFileProcess.PARAMETER_OUT_FLOWENTITY);
                レコード件数合算 = flowEntity.get明細データ登録件数();
            }
            executeStep(CSVファイル取込);
            flowEntity = getResult(FlowEntity.class, new RString(CSVファイル取込),
                    SogojigyohiSeikyugakuTsuchishoKeikaSochiReadCsvFileProcess.PARAMETER_OUT_FLOWENTITY);
            if (0 == flowEntity.get明細データ登録件数()) {
                executeStep(国保連インタフェース管理更新);
                executeStep(処理結果リスト作成);
            } else {
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
     * ファイル取得メソッドです。
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
     * CSVファイル取込メソッドです。
     *
     * @return SogojigyohiSeikyugakuTsuchishoKeikaSochiReadCsvFileProcess
     */
    @Step(CSVファイル取込)
    protected IBatchFlowCommand callReadCsvFileProcess() {
        KokuhorenkyotsuCsvFileReadProcessParameter parameter = new KokuhorenkyotsuCsvFileReadProcessParameter();
        parameter.set処理年月(getParameter().getShoriYM());
        parameter.set保存先パース(csvFullPath);
        parameter.setレコード件数合算(レコード件数合算);
        return loopBatch(SogojigyohiSeikyugakuTsuchishoInReadCsvFileProcess.class).arguments(parameter).define();
    }

    /**
     * 国保連インタフェース管理更新メソッドです。
     *
     * @return KokuhorenkyoutsuDoInterfaceKanriKousinProcess
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
     * 一覧表作成メソッドです。
     *
     * @return KohifutanshaDoIchiranhyoSakuseiProcess
     */
    @Step(一覧表作成)
    protected IBatchFlowCommand callDoIchiranhyoSakuseiProcess() {
        SogojigyohiSeiDoIchiranhyoSakuseiProcessParameter parameter = new SogojigyohiSeiDoIchiranhyoSakuseiProcessParameter();
        parameter.setシステム日付(RDateTime.now());
        return loopBatch(SogojigyohiSeiDoIchiranhyoSakuseiProcess.class).arguments(parameter).define();
    }

    /**
     * 処理結果リスト作成メソッドです。
     *
     * @return KokuhorenkyoutsuDoShoriKekkaListSakuseiProcess
     */
    @Step(処理結果リスト作成)
    protected IBatchFlowCommand callDoShoriKekkaListSakuseiProcess() {
        KokuhorenkyotsuDoShoriKekkaListSakuseiProcessParameter parameter
                = new KokuhorenkyotsuDoShoriKekkaListSakuseiProcessParameter();
        parameter.setエラーリストタイプ(KokuhorenJoho_TorikomiErrorListType.リストタイプ0);
        return simpleBatch(KokuhorenkyoutsuDoShoriKekkaListSakuseiProcess.class).arguments(parameter).define();
    }

    /**
     * 取込済ファイル削除メソッドです。
     *
     * @return KokuhorenkyoutsuDeleteReveicedFileProcess
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
