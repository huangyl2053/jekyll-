/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import java.io.File;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120880.SogojigyohiShikakuDoIchiranhyoSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDeleteReveicedFileProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDoHihokenshaKanrenProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDoInterfaceKanriKousinProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDoShoriKekkaListSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuGetFileProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.shikakushogohyojyoho.ShikakuShogohyoJyohoReadCsvFileProcess;
import jp.co.ndensan.reams.db.dbc.business.core.kokuhorenkyoutsuu.KokuhorenKyoutsuuFileGetReturnEntity;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC120880.DBC120880_SogojigyohiShikakuShogohyoInParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_TorikomiErrorListType;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuDeleteReveicedFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuDoShoriKekkaListSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuGetFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.shikakushogohyojyoho.ShikakuShogohyoJyohoReadCsvFileParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.FlowEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 総合事業費資格照合表情報取込ののバッチ処理フロー
 *
 * @reamsid_L DBC-2890-012 wangxue
 */
public class DBC120880_SogojigyohiShikakuShogohyoIn extends BatchFlowBase<DBC120880_SogojigyohiShikakuShogohyoInParameter> {

    private static final String ファイル取得 = "getFile";
    private static final String CSVファイル取込 = "readerCsvFile";
    private static final String 被保険者関連処理 = "doHihokenshaKanren";
    private static final String 国保連インタフェース管理更新 = "doInterfaceKanriKousin";
    private static final String 帳票出力 = "doIchiranhyoSakusei";
    private static final String 処理結果リスト作成 = "doShoriKekkaListSakusei";
    private static final String 取込済ファイル削除 = "deleteReveicedFile";

    private static final RString ファイル格納フォルダ名 = new RString("DBC120880");
    private RString 交換情報識別番号;
    private KokuhorenKyoutsuuFileGetReturnEntity returnEntity;
    private FlowEntity flowEntity;
    private RString csvFullPath;
    private int 登録件数 = 0;
    private int レコード件数合計 = 0;
    private boolean isLast = false;

    @Override
    protected void defineFlow() {
        try {
            RDate nowDate = RDate.getNowDate();
            交換情報識別番号 = DbBusinessConfig.get(ConfigNameDBC.国保連取込_総合事業費資格照合表情報_交換情報識別番号,
                    nowDate, SubGyomuCode.DBC介護給付);
            executeStep(ファイル取得);
            returnEntity = getResult(KokuhorenKyoutsuuFileGetReturnEntity.class, new RString(ファイル取得),
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
                        ShikakuShogohyoJyohoReadCsvFileProcess.PARAMETER_OUT_FLOWENTITY);
                登録件数 = flowEntity.get明細データ登録件数();
                レコード件数合計 = flowEntity.getCodeNum();
            }
            if (0 == 登録件数) {
                executeStep(国保連インタフェース管理更新);
                executeStep(処理結果リスト作成);
            } else {
                executeStep(被保険者関連処理);
                executeStep(国保連インタフェース管理更新);
                executeStep(帳票出力);
                executeStep(処理結果リスト作成);
            }
        } finally {
            if (null != returnEntity) {
                executeStep(取込済ファイル削除);
            }
        }
    }

    /**
     * ファイル取得
     *
     * @return KokuhorenkyoutsuGetFileProcess
     */
    @Step(ファイル取得)
    protected IBatchFlowCommand getFile() {
        KokuhorenkyotsuGetFileProcessParameter parameter = new KokuhorenkyotsuGetFileProcessParameter();
        parameter.setファイル格納フォルダ名(ファイル格納フォルダ名);
        parameter.set交換情報識別番号(交換情報識別番号);
        parameter.setLoginUserID(getParameter().getLoginUserId());
        return simpleBatch(KokuhorenkyoutsuGetFileProcess.class).arguments(parameter).define();
    }

    /**
     * CSVファイル取込
     *
     * @return ShikakuShogohyoJyohoReadCsvFileProcess
     */
    @Step(CSVファイル取込)
    protected IBatchFlowCommand readerCsvFile() {
        ShikakuShogohyoJyohoReadCsvFileParameter parameter = new ShikakuShogohyoJyohoReadCsvFileParameter();
        parameter.setエントリ情報List(returnEntity.getFileNameList());
        parameter.set保存先フォルダ(csvFullPath);
        parameter.setLast(isLast);
        parameter.set連番(登録件数);
        parameter.setCodeNum(レコード件数合計);
        return loopBatch(ShikakuShogohyoJyohoReadCsvFileProcess.class).arguments(parameter).define();
    }

    /**
     * 被保険者関連処理です。
     *
     * @return KokuhorenkyoutsuDoHihokenshaKanrenProcess
     */
    @Step(被保険者関連処理)
    protected IBatchFlowCommand doHihokenshaKanren() {
        return simpleBatch(KokuhorenkyoutsuDoHihokenshaKanrenProcess.class).define();
    }

    /**
     * 国保連インタフェース管理更新
     *
     * @return KokuhorenkyoutsuDoInterfaceKanriKousinProcess
     */
    @Step(国保連インタフェース管理更新)
    protected IBatchFlowCommand doInterfaceKanriKousin() {
        KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter parameter = new KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter();
        parameter.set処理年月(getParameter().getShoriYM());
        parameter.set交換情報識別番号(交換情報識別番号);
        parameter.set処理対象年月(flowEntity.getShoriYM());
        parameter.setレコード件数合計(レコード件数合計);
        parameter.setFileNameList(returnEntity.getFileNameList());
        return simpleBatch(KokuhorenkyoutsuDoInterfaceKanriKousinProcess.class).arguments(parameter).define();
    }

    /**
     * 帳票出力
     *
     * @return SogojigyohiShikakuDoIchiranhyoSakuseiProcess
     */
    @Step(帳票出力)
    protected IBatchFlowCommand doIchiranhyoSakusei() {
        return loopBatch(SogojigyohiShikakuDoIchiranhyoSakuseiProcess.class).define();
    }

    /**
     * 処理結果リスト作成
     *
     * @return KokuhorenkyoutsuDoShoriKekkaListSakuseiProcess
     */
    @Step(処理結果リスト作成)
    protected IBatchFlowCommand doShoriKekkaListSakusei() {
        KokuhorenkyotsuDoShoriKekkaListSakuseiProcessParameter parameter
                = new KokuhorenkyotsuDoShoriKekkaListSakuseiProcessParameter();
        parameter.setエラーリストタイプ(KokuhorenJoho_TorikomiErrorListType.リストタイプ0);
        return simpleBatch(KokuhorenkyoutsuDoShoriKekkaListSakuseiProcess.class).arguments(parameter).define();
    }

    /**
     * 取込済ファイル削除
     *
     * @return KokuhorenkyoutsuDeleteReveicedFileProcess
     */
    @Step(取込済ファイル削除)
    protected IBatchFlowCommand deleteReveicedFile() {

        KokuhorenkyotsuDeleteReveicedFileProcessParameter parameter = new KokuhorenkyotsuDeleteReveicedFileProcessParameter();
        parameter.set処理年月(getParameter().getShoriYM());
        parameter.set保存先フォルダ(returnEntity.get保存先フォルダのパス().toRString());
        parameter.setエントリ情報List(returnEntity.getEntityList());
        return simpleBatch(KokuhorenkyoutsuDeleteReveicedFileProcess.class).arguments(parameter).define();
    }
}
