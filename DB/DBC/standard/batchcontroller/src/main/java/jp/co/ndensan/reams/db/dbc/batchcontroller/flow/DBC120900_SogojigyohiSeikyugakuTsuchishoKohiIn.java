/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120900.TsuchishoKohiDoIchiranhyoSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120900.TsuchishoKohiGetFileProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc790011.DbWT0002KokuhorenTorikomiErrorTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc790011.SeikyugakuTsuchishoFutanshaInProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDeleteReveicedFileProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDoInterfaceKanriKousinProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDoShoriKekkaListSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuGetFileProcess;
import jp.co.ndensan.reams.db.dbc.business.core.kokuhorenkyoutsuu.KokuhorenKyoutsuuFileGetReturnEntity;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.sogojigyohiseikyugakutsuchishokohi.DBC120900_SogojigyohiSeikyugakuTsuchishoKohiInParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_TorikomiErrorListType;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuDeleteReveicedFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuDoShoriKekkaListSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuGetFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.seikyugakutsuchishofutanshain.SeikyugakuTsuchishoFutanshaInProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.sogojigyohiseikyugakutsuchishokohiin.TsuchishoKohiDoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.FlowEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 総合事業費等請求額通知書情報（公費）取込 のバッチ処理フロー
 *
 * @reamsid_L DBC-4700-030 qinzhen
 */
public class DBC120900_SogojigyohiSeikyugakuTsuchishoKohiIn
        extends BatchFlowBase<DBC120900_SogojigyohiSeikyugakuTsuchishoKohiInParameter> {

    private static final String ファイル取得 = "callGetFileProcess";
    private static final String CSVファイル取込 = "callReadCsvFileProcess";
    private static final String 処理結果リスト一時登録 = "errorTempInsert";
    private static final String 国保連インタフェース管理更新 = "callDoInterfaceKanriKousinProcess";
    private static final String 一覧表作成 = "callDoIchiranhyoSakuseiProcess";
    private static final String 処理結果リスト作成 = "callDoShoriKekkaListSakuseiProcess";
    private static final String 取込済ファイル削除 = "callDeleteReveicedFileProcess";
    private SeikyugakuTsuchishoFutanshaInProcessParameter csvParameter;
    private static final int NO_NUM = 0;
    private static final RString ファイル格納フォルダ名 = new RString("DBC120190");
    private int 一時TBL登録件数;
    private FlexibleYearMonth 処理対象年月;

    private KokuhorenKyoutsuuFileGetReturnEntity returnEntity;
    private FlowEntity flowEntity;

    private RString 交換情報識別番号;

    @Override
    protected void defineFlow() {
        try {
            RDate now = RDate.getNowDate();
            交換情報識別番号 = DbBusinessConfig.get(
                    ConfigNameDBC.国保連取込_総合事業費等請求額通知書公費情報_交換情報識別番号, now, SubGyomuCode.DBC介護給付);
            executeStep(ファイル取得);
            returnEntity
                    = getResult(KokuhorenKyoutsuuFileGetReturnEntity.class, new RString(ファイル取得),
                            TsuchishoKohiGetFileProcess.PARAMETER_OUT_RETURNENTITY);
            for (int i = NO_NUM; i < returnEntity.getFileNameList().size(); i++) {
                csvParameter = new SeikyugakuTsuchishoFutanshaInProcessParameter();
                csvParameter.setPath(returnEntity.get保存先フォルダのパス().toRString());
                csvParameter.setFileName(returnEntity.getFileNameList().get(i));
                executeStep(CSVファイル取込);
                flowEntity = getResult(FlowEntity.class, new RString(CSVファイル取込),
                        SeikyugakuTsuchishoFutanshaInProcess.PARAMETER_OUT_FLOWENTITY);
                if (flowEntity != null) {
                    処理対象年月 = flowEntity.getShoriYM();
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
     * @return SeikyugakuTsuchishoFutanshaInProcess
     */
    @Step(CSVファイル取込)
    protected IBatchFlowCommand callReadCsvFileProcess() {
        return loopBatch(SeikyugakuTsuchishoFutanshaInProcess.class).arguments(csvParameter).define();
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
     * 一覧表作成です。
     *
     * @return TsuchishoKohiDoIchiranhyoSakuseiProcess
     */
    @Step(一覧表作成)
    protected IBatchFlowCommand callDoIchiranhyoSakuseiProcess() {
        TsuchishoKohiDoIchiranhyoSakuseiProcessParameter parameter
                = new TsuchishoKohiDoIchiranhyoSakuseiProcessParameter();
        parameter.setシステム日付(YMDHMS.now());
        return loopBatch(TsuchishoKohiDoIchiranhyoSakuseiProcess.class).arguments(parameter).
                define();
    }

    /**
     * 処理結果リスト作成です。
     *
     * @return
     * KokuhorenkyoutsuDeleteReveicedFileProcessKokuhorenkyoutsuDoShoriKekkaListSakuseiProcess
     */
    @Step(処理結果リスト作成)
    protected IBatchFlowCommand callDoShoriKekkaListSakuseiProcess() {
        KokuhorenkyotsuDoShoriKekkaListSakuseiProcessParameter parameter
                = new KokuhorenkyotsuDoShoriKekkaListSakuseiProcessParameter();
        parameter.setエラーリストタイプ(KokuhorenJoho_TorikomiErrorListType.リストタイプ0);
        return simpleBatch(KokuhorenkyoutsuDoShoriKekkaListSakuseiProcess.class).arguments(parameter).define();
    }

    /**
     * 取込済ファイル削除です。
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
