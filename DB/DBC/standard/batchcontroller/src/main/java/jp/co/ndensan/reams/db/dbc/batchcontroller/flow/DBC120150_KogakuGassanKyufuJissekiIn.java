/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import java.io.File;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120150.KogakuGassanKyufuJissekiInDoIchiranhyoSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120150.KogakuGassanKyufuJissekiInDoMasterTorokuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120150.KogakuGassanKyufuJissekiInDoMasterTorokuSaiShoriProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120150.KogakuGassanKyufuJissekiInDoMasterTorokuUpdateProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120150.KogakuGassanKyufuJissekiInGetFileProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDeleteReveicedFileProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDoHihokenshaKanrenProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDoInterfaceKanriKousinProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDoShoriKekkaListSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuGetFileProcess;
import jp.co.ndensan.reams.db.dbc.business.core.kokuhorenkyoutsuu.KokuhorenKyoutsuuFileGetReturnEntity;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC120150.DBC120150_KogakuGassanKyufuJissekiInParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_TorikomiErrorListType;
import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakugassankyufujissekiin.KogakuGassanKyufuJissekiInDoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakugassankyufujissekiin.KogakuGassanKyufuJissekiInDoMasterLoginProcessParameter;
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
 * 高額合算給付実績取込のバッチ処理フロークラスです。
 *
 * @reamsid_L DBC-2700-010 wangxingpeng
 */
public class DBC120150_KogakuGassanKyufuJissekiIn extends BatchFlowBase<DBC120150_KogakuGassanKyufuJissekiInParameter> {

    private static final String ファイル取得 = "getFile";
    private static final String CSVファイル取込 = "readCsvFile";
    private static final String 被保険者関連処理 = "doHihokenshaKanren";
    private static final String マスタ登録_再処理準備 = "doMasterTorokuSaiShori";
    private static final String マスタ登録_マスタ更新 = "doMasterTorokuUpdate";
    private static final String マスタ登録_マスタ追加 = "doMasterToroku";
    private static final String 国保連インタフェース管理更新 = "updateInterfaceKanriKousinProcess";
    private static final String 一覧表作成 = "doIchiranhyoSakuseiProcess";
    private static final String 処理結果リスト作成 = "doShoriKekkaListSakusei";
    private static final String 取込済ファイル削除 = "deleteReveicedFile";
    private static final RString ファイル格納フォルダ名 = new RString("DBC120150");
    private RString csvFullPath;
    private int コントロールレコード件数;
    private int 集計件数;
    private int 明細件数;
    private boolean isFirst;
    private boolean isLast;
    private FlowEntity flowEntity;
    private static RString 交換情報識別番号;
    private KokuhorenKyoutsuuFileGetReturnEntity returnEntity;

    @Override
    protected void defineFlow() {
        try {
            RString 処理区分 = RString.EMPTY;
            if (!RString.isNullOrEmpty(getParameter().get処理区分())) {
                処理区分 = getParameter().get処理区分().trim();
            }
            交換情報識別番号 = DbBusinessConfig.get(ConfigNameDBC.国保連取込_高額合算給付実績情報_交換情報識別番号,
                    RDate.getNowDate(), SubGyomuCode.DBC介護給付).concat(処理区分);
            executeStep(ファイル取得);
            returnEntity = getResult(KokuhorenKyoutsuuFileGetReturnEntity.class, new RString(ファイル取得),
                    KokuhorenkyoutsuGetFileProcess.PARAMETER_OUT_RETURNENTITY);

            for (int i = 0; i < returnEntity.getFileNameList().size(); i++) {
                String filePath = returnEntity.get保存先フォルダのパス() + File.separator
                        + returnEntity.getFileNameList().get(i);
                File path = new File(filePath);
                csvFullPath = new RString(path.getPath());
                isFirst = (0 == i);
                isLast = ((returnEntity.getFileNameList().size() - 1) == i);
                executeStep(CSVファイル取込);
                flowEntity = getResult(FlowEntity.class, new RString(CSVファイル取込),
                        KogakuGassanKyufuJissekiInGetFileProcess.PARAMETER_OUT_FLOWENTITY);
                コントロールレコード件数 = flowEntity.getCodeNum();
                集計件数 = flowEntity.get集計データ登録件数();
                明細件数 = flowEntity.get明細データ登録件数();
            }
            if (0 == flowEntity.get集計データ登録件数()) {
                executeStep(国保連インタフェース管理更新);
                executeStep(処理結果リスト作成);
            } else {
                executeStep(被保険者関連処理);
                if (SaiShoriKubun.再処理.equals(getParameter().get再処理区分())) {
                    executeStep(マスタ登録_再処理準備);

                }
                executeStep(マスタ登録_マスタ追加);
                executeStep(マスタ登録_マスタ更新);

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
        parameter.setLoginUserID(getParameter().getLoginUserId());
        return simpleBatch(KokuhorenkyoutsuGetFileProcess.class).arguments(parameter).define();
    }

    /**
     * CSVファイル取込です。
     *
     * @return KogakuGassanKyufuJissekiInGetFileProcess
     */
    @Step(CSVファイル取込)
    protected IBatchFlowCommand callReadCsvFileProcess() {
        KokuhorenkyotsuCsvFileReadProcessParameter parameter = new KokuhorenkyotsuCsvFileReadProcessParameter();
        parameter.set処理年月(getParameter().get処理年月());
        parameter.set保存先パース(csvFullPath);
        parameter.set集計件数合算(集計件数);
        parameter.setFirst(isFirst);
        parameter.setLast(isLast);
        parameter.setレコード件数合算(コントロールレコード件数);
        parameter.set明細件数合算(明細件数);
        return loopBatch(KogakuGassanKyufuJissekiInGetFileProcess.class).arguments(parameter).define();
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
     * @return KogakuGassanKyufuJissekiInDoMasterTorokuSaiShoriProcess
     */
    @Step(マスタ登録_再処理準備)
    protected IBatchFlowCommand callDoMasterTorokuSaiShoriProcess() {
        KogakuGassanKyufuJissekiInDoMasterLoginProcessParameter parameter = new KogakuGassanKyufuJissekiInDoMasterLoginProcessParameter();
        parameter.set処理区分(getParameter().get処理区分());
        parameter.set処理年月(getParameter().get処理年月());
        return simpleBatch(KogakuGassanKyufuJissekiInDoMasterTorokuSaiShoriProcess.class).arguments(parameter).define();

    }

    /**
     * マスタ登録_マスタ追加です。
     *
     * @return KogakuGassanJikofutangakuDoMasterTorokuMeisaiInsertProcess
     */
    @Step(マスタ登録_マスタ追加)
    protected IBatchFlowCommand callDoMasterTorokuProcess() {
        KogakuGassanKyufuJissekiInDoMasterLoginProcessParameter parameter = new KogakuGassanKyufuJissekiInDoMasterLoginProcessParameter();
        parameter.set処理区分(getParameter().get処理区分());
        parameter.set処理年月(getParameter().get処理年月());
        return loopBatch(KogakuGassanKyufuJissekiInDoMasterTorokuProcess.class).arguments(parameter).define();
    }

    /**
     * マスタ登録_マスタ更新です。
     *
     * @return KogakuGassanJikofutangakuDoMasterTorokuMeisaiInsertProcess
     */
    @Step(マスタ登録_マスタ更新)
    protected IBatchFlowCommand callDoMasterTorokuUpdateProcess() {
        KogakuGassanKyufuJissekiInDoMasterLoginProcessParameter parameter = new KogakuGassanKyufuJissekiInDoMasterLoginProcessParameter();
        parameter.set処理区分(getParameter().get処理区分());
        parameter.set処理年月(getParameter().get処理年月());
        return simpleBatch(KogakuGassanKyufuJissekiInDoMasterTorokuUpdateProcess.class).arguments(parameter).define();
    }

    /**
     * 国保連インタフェース管理更新するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(国保連インタフェース管理更新)
    protected IBatchFlowCommand updateInterfaceKanriKousinProcess() {
        KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter parameter
                = new KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter();
        parameter.set処理年月(getParameter().get処理年月());
        parameter.set交換情報識別番号(交換情報識別番号);
        parameter.set処理対象年月(flowEntity.getShoriYM());
        parameter.setレコード件数合計(flowEntity.getCodeNum());
        parameter.setFileNameList(returnEntity.getFileNameList());
        return simpleBatch(KokuhorenkyoutsuDoInterfaceKanriKousinProcess.class).arguments(parameter).define();
    }

    /**
     * 一覧表作成です。
     *
     * @return KogakuGassanKyufuJissekiInDoIchiranhyoSakuseiProcess
     */
    @Step(一覧表作成)
    protected IBatchFlowCommand callDoIchiranhyoSakuseiProcess() {
        KogakuGassanKyufuJissekiInDoIchiranhyoSakuseiProcessParameter parameter
                = new KogakuGassanKyufuJissekiInDoIchiranhyoSakuseiProcessParameter();
        parameter.setシステム日付(RDateTime.now());
        parameter.set処理年月(getParameter().get処理年月());
        parameter.set出力順ID(getParameter().get出力順ID());
        return loopBatch(KogakuGassanKyufuJissekiInDoIchiranhyoSakuseiProcess.class).arguments(parameter).define();
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
        parameter.set処理年月(getParameter().get処理年月());
        parameter.set保存先フォルダ(returnEntity.get保存先フォルダのパス().toRString());
        parameter.setエントリ情報List(returnEntity.getEntityList());
        return simpleBatch(KokuhorenkyoutsuDeleteReveicedFileProcess.class).arguments(parameter).define();
    }
}
