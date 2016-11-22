/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import java.io.File;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120050.KyufuJissekiInDoIchiranhyoSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120050.KyufuJissekiInDoSaiShoriJunbiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120050.KyufuJissekiInGetJigyoshaNameProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120050.KyufuJissekiInGetNameProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120050.KyufuJissekiInGetToosibangoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120050.KyufuJissekiInHenkyakuD8KousinProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120050.KyufuJissekiInHenkyakuD8TorikeshiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120050.KyufuJissekiInHenkyakuH1DeleteProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120050.KyufuJissekiInHenkyakuH1KousinProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120050.KyufuJissekiInHenkyakuH1TorikeshiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120050.KyufuJissekiInMasterTorokuD1Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120050.KyufuJissekiInMasterTorokuD2Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120050.KyufuJissekiInMasterTorokuD31Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120050.KyufuJissekiInMasterTorokuD32Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120050.KyufuJissekiInMasterTorokuD4Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120050.KyufuJissekiInMasterTorokuD5Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120050.KyufuJissekiInMasterTorokuD6Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120050.KyufuJissekiInMasterTorokuD7Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120050.KyufuJissekiInMasterTorokuD8Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120050.KyufuJissekiInMasterTorokuD9Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120050.KyufuJissekiInMasterTorokuDAProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120050.KyufuJissekiInMasterTorokuDBProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120050.KyufuJissekiInMasterTorokuDCProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120050.KyufuJissekiInMasterTorokuDDProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120050.KyufuJissekiInMasterTorokuH1Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120050.KyufuJissekiInMasterTorokuT1Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120050.KyufuJissekiInReadCsvFileProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120050.KyufuJissekiInReadCsvProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDeleteReveicedFileProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDoHihokenshaKanrenProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDoInterfaceKanriKousinProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDoShoriKekkaListSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuGetFileProcess;
import jp.co.ndensan.reams.db.dbc.business.core.kokuhorenkyoutsuu.KokuhorenKyoutsuuFileGetReturnEntity;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC120050.DBC120050_KyufuJissekiInParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_TorikomiErrorListType;
import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc120050.KyufuJissekiInMasterTorokuProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuDeleteReveicedFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuDoShoriKekkaListSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuGetFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kyufujissekiin.KyufuJissekiInDoIchiranhyoSakuseiProcessParameter;
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
 * 給付実績情報取込のバッチ処理フロー
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
public class DBC120050_KyufuJissekiIn extends BatchFlowBase<DBC120050_KyufuJissekiInParameter> {

    private static final String ファイル取得 = "getFile";
    private static final String CSVファイル取込 = "readCsvFile";
    private static final String CSVファイル取込チェック = "checkCsvFile";
    private static final String 事業者名称取得 = "getJigyoshaName";
    private static final String 入力識別名称取得 = "getName";
    private static final String 返却データ削除_H1更新 = "deleteHenkyakuH1Kousin";
    private static final String 返却データ削除_H1取消 = "deleteHenkyakuH1Torikeshi";
    private static final String 返却データ削除_H1削除 = "deleteHenkyakuH1Sakujyo";
    private static final String 返却データ削除_D8更新 = "deleteHenkyakuD8Kousin";
    private static final String 返却データ削除_D8取消 = "deleteHenkyakuD8Torikeshi";
    private static final String 通し番号の採番 = "getToosibango";
    private static final String マスタ登録_H1 = "doMasterTorokuH1";
    private static final String マスタ登録_D1 = "doMasterTorokuD1";
    private static final String マスタ登録_D2 = "doMasterTorokuD2";
    private static final String マスタ登録_D31 = "doMasterTorokuD31";
    private static final String マスタ登録_D32 = "doMasterTorokuD32";
    private static final String マスタ登録_D4 = "doMasterTorokuD4";
    private static final String マスタ登録_D5 = "doMasterTorokuD5";
    private static final String マスタ登録_D6 = "doMasterTorokuD6";
    private static final String マスタ登録_D7 = "doMasterTorokuD7";
    private static final String マスタ登録_D8 = "doMasterTorokuD8";
    private static final String マスタ登録_D9 = "doMasterTorokuD9";
    private static final String マスタ登録_DA = "doMasterTorokuDA";
    private static final String マスタ登録_DB = "doMasterTorokuDB";
    private static final String マスタ登録_DC = "doMasterTorokuDC";
    private static final String マスタ登録_DD = "doMasterTorokuDD";
    private static final String マスタ登録_T1 = "doMasterTorokuT1";
    private static final String 再処理準備 = "doSaiShoriJunbi";
    private static final String 被保険者関連処理 = "doHihokenshaKanren";
    private static final String 国保連インタフェース管理更新 = "doInterfaceKanriKousin";
    private static final String 一覧表作成 = "doIchiranhyoSakusei";
    private static final String 処理結果リスト作成 = "doShoriKekkaListSakusei";
    private static final String 取込済ファイル削除 = "deleteReveicedFile";
    private static final RString ファイル格納フォルダ名 = new RString("DBC120050");

    private KokuhorenKyoutsuuFileGetReturnEntity returnEntity;
    private FlowEntity flowEntity;
    private FlowEntity flowEntity2;
    private RString csvFullPath;
    private boolean isLast = false;
    private static RString 交換情報識別番号;
    private KyufuJissekiInMasterTorokuProcessParameter proParameter;

    @Override
    protected void defineFlow() {
        try {
            RDate now = RDate.getNowDate();
            交換情報識別番号 = DbBusinessConfig.get(
                    ConfigNameDBC.国保連取込_給付実績情報_交換情報識別番号,
                    now, SubGyomuCode.DBC介護給付);
            executeStep(ファイル取得);
            returnEntity
                    = getResult(KokuhorenKyoutsuuFileGetReturnEntity.class, new RString(ファイル取得),
                            KokuhorenkyoutsuGetFileProcess.PARAMETER_OUT_RETURNENTITY);
            int size = returnEntity.getFileNameList().size();
            flowEntity = new FlowEntity();
            flowEntity2 = new FlowEntity();

            for (int i = 0; i < size; i++) {
                if (i == size - 1) {
                    isLast = true;
                }
                String filePath = returnEntity.get保存先フォルダのパス() + File.separator
                        + returnEntity.getFileNameList().get(i);
                File path = new File(filePath);
                csvFullPath = new RString(path.getPath());
                executeStep(CSVファイル取込);
                flowEntity = getResult(FlowEntity.class, new RString(CSVファイル取込),
                        KyufuJissekiInReadCsvFileProcess.PARAMETER_OUT_FLOWENTITY);

                executeStep(CSVファイル取込チェック);
                flowEntity2 = getResult(FlowEntity.class, new RString(CSVファイル取込チェック),
                        KyufuJissekiInReadCsvProcess.PARAMETER_OUT_FLOWENTITY);
            }
            if (0 == flowEntity2.get明細データ登録件数()) {
                executeStep(国保連インタフェース管理更新);
                executeStep(処理結果リスト作成);
            } else {
                executeStep(事業者名称取得);
                executeStep(入力識別名称取得);
                if (SaiShoriKubun.再処理.equals(getParameter().getSaishoriKubun())) {
                    executeStep(再処理準備);
                }
                executeStep(返却データ削除_H1更新);
                executeStep(返却データ削除_H1取消);
                executeStep(返却データ削除_H1削除);
                executeStep(返却データ削除_D8更新);
                executeStep(返却データ削除_D8取消);
                executeStep(通し番号の採番);
                Long 番号 = getResult(Long.class, new RString(通し番号の採番),
                        KyufuJissekiInGetToosibangoProcess.PARAMETER_OUT_BANGO);
                proParameter = new KyufuJissekiInMasterTorokuProcessParameter();
                proParameter.set番号(番号);
                executeStep(マスタ登録_H1);
                executeStep(マスタ登録_D1);
                executeStep(マスタ登録_D2);
                executeStep(マスタ登録_D31);
                executeStep(マスタ登録_D32);
                executeStep(マスタ登録_D4);
                executeStep(マスタ登録_D5);
                executeStep(マスタ登録_D6);
                executeStep(マスタ登録_D7);
                executeStep(マスタ登録_D8);
                executeStep(マスタ登録_D9);
                executeStep(マスタ登録_DA);
                executeStep(マスタ登録_DB);
                executeStep(マスタ登録_DC);
                executeStep(マスタ登録_DD);
                executeStep(マスタ登録_T1);
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
     * @return バッチコマンド
     */
    @Step(ファイル取得)
    protected IBatchFlowCommand callGetFileProcess() {
        KokuhorenkyotsuGetFileProcessParameter parameter = new KokuhorenkyotsuGetFileProcessParameter();
        parameter.set交換情報識別番号(交換情報識別番号);
        parameter.setファイル格納フォルダ名(ファイル格納フォルダ名);
        parameter.setLoginUserID(getParameter().getLoginUserId());
        return simpleBatch(KokuhorenkyoutsuGetFileProcess.class).arguments(parameter).define();
    }

    /**
     * CSVファイル取込です。
     *
     * @return バッチコマンド
     */
    @Step(CSVファイル取込)
    protected IBatchFlowCommand callReadCsvFileProcess() {
        KyufuJissekiKoshinReadCsvFileProcessParameter parameter = new KyufuJissekiKoshinReadCsvFileProcessParameter();
        parameter.set処理年月(getParameter().getShoriYM());
        parameter.set保存先フォルダ(csvFullPath);
        parameter.setエントリ情報List(returnEntity.getFileNameList());
        parameter.set連番(flowEntity.get集計データ登録件数());
        parameter.setデータ登録件数(flowEntity.get明細データ登録件数());
        parameter.setLast(isLast);
        return loopBatch(KyufuJissekiInReadCsvFileProcess.class).arguments(parameter).define();
    }

    /**
     * CSVファイル取込です。
     *
     * @return バッチコマンド
     */
    @Step(CSVファイル取込チェック)
    protected IBatchFlowCommand callCheckCsvFileProcess() {
        KyufuJissekiKoshinReadCsvFileProcessParameter parameter = new KyufuJissekiKoshinReadCsvFileProcessParameter();
        parameter.set処理年月(getParameter().getShoriYM());
        parameter.set保存先フォルダ(csvFullPath);
        parameter.setエントリ情報List(returnEntity.getFileNameList());
        parameter.set連番(flowEntity2.get集計データ登録件数());
        parameter.setデータ登録件数(flowEntity2.get明細データ登録件数());
        parameter.set明細登録件数(flowEntity.get明細データ登録件数());
        parameter.setLast(isLast);
        return loopBatch(KyufuJissekiInReadCsvProcess.class).arguments(parameter).define();
    }

    /**
     * 事業者名称取得です。
     *
     * @return バッチコマンド
     */
    @Step(事業者名称取得)
    protected IBatchFlowCommand callGetJigyoshaNameProcess() {
        return loopBatch(KyufuJissekiInGetJigyoshaNameProcess.class).define();
    }

    /**
     * 入力識別名称取得です。
     *
     * @return バッチコマンド
     */
    @Step(入力識別名称取得)
    protected IBatchFlowCommand callGetNameProcess() {
        return loopBatch(KyufuJissekiInGetNameProcess.class).define();
    }

    /**
     * 返却データ削除・給付実績H1の新規、修正データの場合です。
     *
     * @return バッチコマンド
     */
    @Step(返却データ削除_H1更新)
    protected IBatchFlowCommand callDeleteHenkyakuH1KousinProcess() {
        return loopBatch(KyufuJissekiInHenkyakuH1KousinProcess.class).define();
    }

    /**
     * 返却データ削除・給付実績H1の取消データの場合です。
     *
     * @return バッチコマンド
     */
    @Step(返却データ削除_H1取消)
    protected IBatchFlowCommand callDeleteHenkyakuH1TorikeshiProcess() {
        return loopBatch(KyufuJissekiInHenkyakuH1TorikeshiProcess.class).define();
    }

    /**
     * 返却データ削除・給付実績H1の関連データを削除する。
     *
     * @return バッチコマンド
     */
    @Step(返却データ削除_H1削除)
    protected IBatchFlowCommand callDeleteHenkyakuH1Sakujyo() {
        return simpleBatch(KyufuJissekiInHenkyakuH1DeleteProcess.class).define();
    }

    /**
     * 返却データ削除・給付実績D8の新規、修正データの場合です。
     *
     * @return バッチコマンド
     */
    @Step(返却データ削除_D8更新)
    protected IBatchFlowCommand callDeleteHenkyakuD8KousinProcess() {
        return loopBatch(KyufuJissekiInHenkyakuD8KousinProcess.class).define();
    }

    /**
     * 返却データ削除・給付実績D8の取消データの場合です。
     *
     * @return バッチコマンド
     */
    @Step(返却データ削除_D8取消)
    protected IBatchFlowCommand callDeleteHenkyakuD8TorikeshiProcess() {
        return loopBatch(KyufuJissekiInHenkyakuD8TorikeshiProcess.class).define();
    }

    /**
     * 通し番号の採番です。
     *
     * @return バッチコマンド
     */
    @Step(通し番号の採番)
    protected IBatchFlowCommand callGetToosibangoProcess() {
        return simpleBatch(KyufuJissekiInGetToosibangoProcess.class).define();
    }

    /**
     * マスタ登録_H1です。
     *
     * @return バッチコマンド
     */
    @Step(マスタ登録_H1)
    protected IBatchFlowCommand callDoMasterTorokuH1Process() {
        return loopBatch(KyufuJissekiInMasterTorokuH1Process.class).arguments(proParameter).define();
    }

    /**
     * マスタ登録_D1です。
     *
     * @return バッチコマンド
     */
    @Step(マスタ登録_D1)
    protected IBatchFlowCommand callDoMasterTorokuD1Process() {
        return loopBatch(KyufuJissekiInMasterTorokuD1Process.class).arguments(proParameter).define();
    }

    /**
     * マスタ登録_D2です。
     *
     * @return バッチコマンド
     */
    @Step(マスタ登録_D2)
    protected IBatchFlowCommand callDoMasterTorokuD2Process() {
        return loopBatch(KyufuJissekiInMasterTorokuD2Process.class).arguments(proParameter).define();
    }

    /**
     * マスタ登録_D3・1です。
     *
     * @return バッチコマンド
     */
    @Step(マスタ登録_D31)
    protected IBatchFlowCommand callDoMasterTorokuD31Process() {
        return loopBatch(KyufuJissekiInMasterTorokuD31Process.class).arguments(proParameter).define();
    }

    /**
     * マスタ登録_D3・2です。
     *
     * @return バッチコマンド
     */
    @Step(マスタ登録_D32)
    protected IBatchFlowCommand callDoMasterTorokuD32Process() {
        return loopBatch(KyufuJissekiInMasterTorokuD32Process.class).arguments(proParameter).define();
    }

    /**
     * マスタ登録_D4です。
     *
     * @return バッチコマンド
     */
    @Step(マスタ登録_D4)
    protected IBatchFlowCommand callDoMasterTorokuD4Process() {
        return loopBatch(KyufuJissekiInMasterTorokuD4Process.class).arguments(proParameter).define();
    }

    /**
     * マスタ登録_D5です。
     *
     * @return バッチコマンド
     */
    @Step(マスタ登録_D5)
    protected IBatchFlowCommand callDoMasterTorokuD5Process() {
        return loopBatch(KyufuJissekiInMasterTorokuD5Process.class).arguments(proParameter).define();
    }

    /**
     * マスタ登録_D6です。
     *
     * @return バッチコマンド
     */
    @Step(マスタ登録_D6)
    protected IBatchFlowCommand callDoMasterTorokuD6Process() {
        return loopBatch(KyufuJissekiInMasterTorokuD6Process.class).arguments(proParameter).define();
    }

    /**
     * マスタ登録_D7です。
     *
     * @return バッチコマンド
     */
    @Step(マスタ登録_D7)
    protected IBatchFlowCommand callDoMasterTorokuD7Process() {
        return loopBatch(KyufuJissekiInMasterTorokuD7Process.class).arguments(proParameter).define();
    }

    /**
     * マスタ登録_D8です。
     *
     * @return バッチコマンド
     */
    @Step(マスタ登録_D8)
    protected IBatchFlowCommand callDoMasterTorokuD8Process() {
        return loopBatch(KyufuJissekiInMasterTorokuD8Process.class).arguments(proParameter).define();
    }

    /**
     * マスタ登録_D9です。
     *
     * @return バッチコマンド
     */
    @Step(マスタ登録_D9)
    protected IBatchFlowCommand callDoMasterTorokuD9Process() {
        return loopBatch(KyufuJissekiInMasterTorokuD9Process.class).arguments(proParameter).define();
    }

    /**
     * マスタ登録_DAです。
     *
     * @return バッチコマンド
     */
    @Step(マスタ登録_DA)
    protected IBatchFlowCommand callDoMasterTorokuDAProcess() {
        return loopBatch(KyufuJissekiInMasterTorokuDAProcess.class).arguments(proParameter).define();
    }

    /**
     * マスタ登録_DBです。
     *
     * @return バッチコマンド
     */
    @Step(マスタ登録_DB)
    protected IBatchFlowCommand callDoMasterTorokuDBProcess() {
        return loopBatch(KyufuJissekiInMasterTorokuDBProcess.class).arguments(proParameter).define();
    }

    /**
     * マスタ登録_DCです。
     *
     * @return バッチコマンド
     */
    @Step(マスタ登録_DC)
    protected IBatchFlowCommand callDoMasterTorokuDCProcess() {
        return loopBatch(KyufuJissekiInMasterTorokuDCProcess.class).arguments(proParameter).define();
    }

    /**
     * マスタ登録_DDです。
     *
     * @return バッチコマンド
     */
    @Step(マスタ登録_DD)
    protected IBatchFlowCommand callDoMasterTorokuDDProcess() {
        return loopBatch(KyufuJissekiInMasterTorokuDDProcess.class).arguments(proParameter).define();
    }

    /**
     * マスタ登録_T1です。
     *
     * @return バッチコマンド
     */
    @Step(マスタ登録_T1)
    protected IBatchFlowCommand callDoMasterTorokuT1Process() {
        return loopBatch(KyufuJissekiInMasterTorokuT1Process.class).arguments(proParameter).define();
    }

    /**
     * 再処理準備です。
     *
     * @return バッチコマンド
     */
    @Step(再処理準備)
    protected IBatchFlowCommand callDoSaiShoriJunbiProcess() {
        KyufuJissekiInMasterTorokuProcessParameter parameter = new KyufuJissekiInMasterTorokuProcessParameter();
        parameter.set処理年月(getParameter().getShoriYM());
        return simpleBatch(KyufuJissekiInDoSaiShoriJunbiProcess.class).arguments(parameter).define();
    }

    /**
     * 被保険者関連処理です。
     *
     * @return バッチコマンド
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
        parameter.setレコード件数合計(flowEntity.get明細データ登録件数());
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
        KyufuJissekiInDoIchiranhyoSakuseiProcessParameter parameter
                = new KyufuJissekiInDoIchiranhyoSakuseiProcessParameter();
        parameter.setサブ業務コード(SubGyomuCode.DBC介護給付);
        parameter.set帳票ID(new ReportId(ReportIdDBC.DBC200007.getReportId().getColumnValue()));
        parameter.set出力順ID(Long.valueOf(getParameter().getShutsuryokujunId().toString()));
        parameter.set処理年月(getParameter().getShoriYM());
        parameter.setシステム日付(RDateTime.now());
        return loopBatch(KyufuJissekiInDoIchiranhyoSakuseiProcess.class).arguments(parameter).
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
        parameter.setエラーリストタイプ(KokuhorenJoho_TorikomiErrorListType.リストタイプ3);
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
