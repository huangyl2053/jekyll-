/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow.dbc120130;

import java.io.File;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120130.KogakuGassanJSaiSyoriJyunbiDoInsertProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120130.KogakuGassanJSaiSyoriJyunbiDoMasterProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120130.KogakuGassanJSaiSyoriJyunbiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120130.KogakuGassanJikofutangakuShomeishoIchiranhyoSakusei;
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
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
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
    private boolean isLast;
    private int レコード件数合算;

    private KokuhorenKyoutsuuFileGetReturnEntity returnEntity;
    private KogakuGassanJikofutangakuShomeishoInProcessParamerter parameter;

    @Override
    protected void defineFlow() {
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
            if (i == size - 1) {
                isLast = true;
            }
            executeStep(CSVファイル取込);
            flowEntity = getResult(KogakuGassanJikofutangakuShomeishoFlowEntity.class, new RString(CSVファイル取込),
                    KogakuGassanJikofutangakuShomeishoInProcess.PARAMETER_OUT_FLOWENTITY);
            if (null != flowEntity) {
                レコード件数合算 = flowEntity.get高額合算自己負担額一時TBL登録件数();
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
        parameter.setPath(csvFullPath);
        parameter.set処理年月(getParameter().getShoriYM());
        parameter.set連番(レコード件数合算);
        parameter.setさいごファイルフラグ(isLast);
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
        KogakuGassanJikofutangakuDoMasterTorokuProcessParameter parameter = new KogakuGassanJikofutangakuDoMasterTorokuProcessParameter();
        parameter.set処理年月(getParameter().getShoriYM());
        return loopBatch(KogakuGassanJSaiSyoriJyunbiProcess.class).arguments(parameter).define();
    }

    /**
     * マスタ登録_マスタ更新です。
     *
     * @return KogakuGassanJikofutangakuDoMasterTorokuProcess
     */
    @Step(マスタ登録_マスタ更新)
    protected IBatchFlowCommand callDoMasterTorokuProcess() {
        KogakuGassanJikofutangakuDoMasterTorokuProcessParameter parameter = new KogakuGassanJikofutangakuDoMasterTorokuProcessParameter();
        parameter.set処理年月(getParameter().getShoriYM());
        return loopBatch(KogakuGassanJSaiSyoriJyunbiDoMasterProcess.class).arguments(parameter).define();
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
        parameter.set帳票ID(new ReportId(ReportIdDBC.DBC200034.getReportId().getColumnValue()));
        parameter.set出力順ID(Long.valueOf(getParameter().getShutsuryokujunId().toString()));
        parameter.set処理年月(getParameter().getShoriYM());
        parameter.setシステム日付(RDateTime.now());
        return loopBatch(KogakuGassanJikofutangakuShomeishoIchiranhyoSakusei.class).arguments(parameter).
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
