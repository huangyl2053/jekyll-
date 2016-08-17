/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120240.SeikyugakuTsuchishoKohiInProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc790011.DbWT0002KokuhorenTorikomiErrorTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc790011.SeikyugakuTsuchishoFutanshaInProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDeleteReveicedFileProcess;
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
import jp.co.ndensan.reams.db.dbc.definition.processprm.seikyugakutsuchishofutanshain.SeikyugakuTsuchishoFutanshaInProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.seikyugakutsuchishokohiin.SeikyugakuTsuchishoKohiInProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.FlowEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBCMNF2002-631_介護給付費等請求額通知書情報（公費）取込のバッチ処理フロー
 *
 * @reamsid_L DBC-2790-010 surun
 */
public class DBC120240_SeikyugakuTsuchishoKohiIn
        extends BatchFlowBase<KokuhorenKyoutsuBatchParameter> {

    private static final String ファイル取得 = "getFile";
    private static final String CSVファイル取込 = "readCsvFile";
    private static final String 処理結果リスト一時登録 = "errorTempInsert";
    private static final String 国保連インタフェース管理更新 = "doInterfaceKanriKousin";
    private static final String 一覧表作成 = "doIchiranhyoSakusei";
    private static final String 処理結果リスト作成 = "doShoriKekkaListSakusei";
    private static final String 取込済ファイル削除 = "deleteReveicedFile";
    private static final RString ファイル格納フォルダ名 = new RString("DBC120240");
    private static final int NO_NUM = 0;
    private RString 交換情報識別番号;
    private KokuhorenKyoutsuuFileGetReturnEntity returnEntity;
    private FlowEntity flowEntity;
    private SeikyugakuTsuchishoFutanshaInProcessParameter parameter;
    private int レコード件数の合計;
    private int 一時TBL登録件数;
    private FlexibleYearMonth 処理対象年月;

    @Override
    protected void defineFlow() {
        try {
            RDate now = RDate.getNowDate();
            交換情報識別番号 = DbBusinessConfig.get(
                    ConfigNameDBC.国保連取込_介護給付費等請求額通知書公費情報_交換情報識別番号, now, SubGyomuCode.DBC介護給付);
            executeStep(ファイル取得);
            returnEntity
                    = getResult(KokuhorenKyoutsuuFileGetReturnEntity.class, new RString(ファイル取得),
                            KokuhorenkyoutsuGetFileProcess.PARAMETER_OUT_RETURNENTITY);

            for (int i = NO_NUM; i < returnEntity.getFileNameList().size(); i++) {
                parameter = new SeikyugakuTsuchishoFutanshaInProcessParameter();
                parameter.setPath(returnEntity.get保存先フォルダのパス().toRString());
                parameter.setFileName(returnEntity.getFileNameList().get(i));
                executeStep(CSVファイル取込);
                flowEntity = getResult(FlowEntity.class, new RString(CSVファイル取込),
                        SeikyugakuTsuchishoFutanshaInProcess.PARAMETER_OUT_FLOWENTITY);
                if (flowEntity != null) {
                    処理対象年月 = flowEntity.getShoriYM();
                    レコード件数の合計 = レコード件数の合計 + flowEntity.getCodeNum();
                    一時TBL登録件数 = 一時TBL登録件数 + flowEntity.get明細データ登録件数();
                }
            }
            executeStep(処理結果リスト一時登録);
            if (NO_NUM == 一時TBL登録件数) {
                executeStep(国保連インタフェース管理更新);
                executeStep(処理結果リスト作成);
            } else {
                executeStep(国保連インタフェース管理更新);
                executeStep(一覧表作成);
                executeStep(処理結果リスト作成);
            }
        } finally {
            if (returnEntity != null) {
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
        KokuhorenkyotsuGetFileProcessParameter parameterOne = new KokuhorenkyotsuGetFileProcessParameter();
        parameterOne.set交換情報識別番号(交換情報識別番号);
        parameterOne.setファイル格納フォルダ名(ファイル格納フォルダ名);
        return simpleBatch(KokuhorenkyoutsuGetFileProcess.class).arguments(parameterOne).define();
    }

    /**
     * CSVファイル取込です。
     *
     * @return KohifutanshaReadCsvFileProcess
     */
    @Step(CSVファイル取込)
    protected IBatchFlowCommand callReadCsvFileProcess() {
        return loopBatch(SeikyugakuTsuchishoFutanshaInProcess.class).arguments(parameter).define();
    }

    /**
     * 処理結果リスト一時登録です。
     *
     * @return DbWT0002KokuhorenTorikomiErrorTempProcess
     */
    @Step(処理結果リスト一時登録)
    protected IBatchFlowCommand callErrorTempInsertProcess() {
        return loopBatch(DbWT0002KokuhorenTorikomiErrorTempProcess.class).define();
    }

    /**
     * 国保連インタフェース管理更新です。
     *
     * @return KohifutanshaDoInterfaceKanriKousinProcess
     */
    @Step(国保連インタフェース管理更新)
    protected IBatchFlowCommand callDoInterfaceKanriKousinProcess() {
        KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter parameterTwo = new KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter();
        parameterTwo.set処理年月(getParameter().getShoriYM());
        parameterTwo.set交換情報識別番号(交換情報識別番号);
        parameterTwo.set処理対象年月(処理対象年月);
        parameterTwo.setレコード件数合計(レコード件数の合計);
        if (returnEntity != null) {
            parameterTwo.setFileNameList(returnEntity.getFileNameList());
        }
        return simpleBatch(KokuhorenkyoutsuDoInterfaceKanriKousinProcess.class).arguments(parameterTwo).define();
    }

    /**
     * 一覧表作成です。
     *
     * @return SeikyugakuTsuchishoKohiInProcess
     */
    @Step(一覧表作成)
    protected IBatchFlowCommand callDoIchiranhyoSakuseiProcess() {
        SeikyugakuTsuchishoKohiInProcessParameter parameterThree = new SeikyugakuTsuchishoKohiInProcessParameter();
        parameterThree.setシステム日付(RDateTime.now());
        return loopBatch(SeikyugakuTsuchishoKohiInProcess.class).arguments(parameterThree).define();
    }

    /**
     * 処理結果リスト作成です。
     *
     * @return KohifutanshaDoShoriKekkaListSakuseiProcess
     */
    @Step(処理結果リスト作成)
    protected IBatchFlowCommand callDoShoriKekkaListSakuseiProcess() {
        KokuhorenkyotsuDoShoriKekkaListSakuseiProcessParameter parameterFour = new KokuhorenkyotsuDoShoriKekkaListSakuseiProcessParameter();
        parameterFour.setエラーリストタイプ(KokuhorenJoho_TorikomiErrorListType.リストタイプ0);
        return simpleBatch(KokuhorenkyoutsuDoShoriKekkaListSakuseiProcess.class).arguments(parameterFour).define();
    }

    /**
     * 取込済ファイル削除です。
     *
     * @return KohifutanshaDeleteReveicedFileProcess
     */
    @Step(取込済ファイル削除)
    protected IBatchFlowCommand callDeleteReveicedFileProcess() {
        KokuhorenkyotsuDeleteReveicedFileProcessParameter parameterFive = new KokuhorenkyotsuDeleteReveicedFileProcessParameter();
        parameterFive.set処理年月(getParameter().getShoriYM());
        if (returnEntity != null && returnEntity.get保存先フォルダのパス() != null) {
            parameterFive.set保存先フォルダ(returnEntity.get保存先フォルダのパス().toRString());
        }
        if (returnEntity != null) {
            parameterFive.setエントリ情報List(returnEntity.getEntityList());
        }
        return simpleBatch(KokuhorenkyoutsuDeleteReveicedFileProcess.class).
                arguments(parameterFive).define();
    }

}
