/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120041.CreateTmptableProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120041.IchiTmpTableTorokuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120830.KokuhorenKyodoJukyushaInProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDeleteReveicedFileProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDoHihokenshaKanrenProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDoShoriKekkaListSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuGetFileProcess;
import jp.co.ndensan.reams.db.dbc.business.core.kokuhorenkyoutsuu.KokuhorenKyoutsuuFileGetReturnEntity;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC120830.DBC120830_KokuhorenKyodoJukyushaInParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_TorikomiErrorListType;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyodojukyushain.KokuhorenKyodoJukyushaInGetIdProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuDeleteReveicedFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuDoShoriKekkaListSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuGetFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 国保連保有共同処理用受給者情報一覧取込のバッチ処理フロー
 *
 * @reamsid_L DBC-2920-010 liuxiaoyu
 */
public class DBC120830_KokuhorenKyodoJukyushaIn
        extends BatchFlowBase<DBC120830_KokuhorenKyodoJukyushaInParameter> {

    private static final String ファイル取得 = "getFile";
    private static final String 被保険者関連処理 = "doHihokenshaKanren";
    private static final String 一覧表作成 = "doIchiranhyoSakusei";
    private static final String 処理結果リスト作成 = "doShoriKekkaListSakusei";
    private static final String 取込済ファイル削除 = "deleteReveicedFile";
    private static final RString ファイル格納フォルダ名 = new RString("DBC120830");

    private static final String 一時TBLの登録 = "一時TBLの登録";
    private static final String 一時TBL基本情報作成 = "一時TBL基本情報作成";
    private RString 保存先フォルダのパス;
    private Integer レコード総件数;
    private List<RString> ファイル名List;
    private List<SharedFileEntryDescriptor> entityList;
    private RString ファイル名;
    private KokuhorenKyoutsuuFileGetReturnEntity returnEntity;
    private RString 処理対象年月;
    private static RString 交換情報識別番号;

    @Override
    protected void defineFlow() {
        try {
            交換情報識別番号 = DbBusinessConfig.get(ConfigNameDBC.国保連取込_共同処理用受給者情報一覧_交換情報識別番号,
                    RDate.getNowDate(), SubGyomuCode.DBC介護給付);
            executeStep(ファイル取得);
            レコード総件数 = 0;
            returnEntity
                    = getResult(KokuhorenKyoutsuuFileGetReturnEntity.class, new RString(ファイル取得),
                            KokuhorenkyoutsuGetFileProcess.PARAMETER_OUT_RETURNENTITY);
            ファイル名List = returnEntity.getFileNameList();
            保存先フォルダのパス = returnEntity.get保存先フォルダのパス().toRString();
            entityList = returnEntity.getEntityList();
            for (RString csvファイル名 : ファイル名List) {
                ファイル名 = csvファイル名;
                try {
                    executeStep(一時TBL基本情報作成);
                    レコード総件数 = レコード総件数 + checkNull(getResult(Integer.class, new RString(一時TBL基本情報作成),
                            CreateTmptableProcess.レコード件数));
                    if (RString.isNullOrEmpty(処理対象年月)) {
                        処理対象年月 = getResult(RString.class, new RString(一時TBL基本情報作成), CreateTmptableProcess.処理対象年月);
                    }
                } catch (Exception e) {
                    throw new BatchInterruptedException(e.getMessage());
                }
            }
            executeStep(一時TBLの登録);
            int 登録件数 = getResult(Integer.class, new RString(一時TBLの登録), IchiTmpTableTorokuProcess.登録件数);
            if (登録件数 == 0) {
                executeStep(処理結果リスト作成);
            } else {
                executeStep(被保険者関連処理);
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
     * 一時TBL基本情報作成処理Processです。
     *
     * @return CreateTmptableProcess
     */
    @Step(一時TBL基本情報作成)
    protected IBatchFlowCommand createTmptableProcess() {
        return loopBatch(CreateTmptableProcess.class)
                .arguments(getParameter().toKyufuJissekiInProcessParameter(保存先フォルダのパス, ファイル名)).define();
    }

    /**
     * 一時TBLの登録Processです。
     *
     * @return IchiTmpTableTorokuProcess
     */
    @Step(一時TBLの登録)
    protected IBatchFlowCommand ichiTmpTableTorokuProcess() {
        return loopBatch(IchiTmpTableTorokuProcess.class).define();
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
     * 被保険者関連処理です。
     *
     * @return バッチコマンド
     */
    @Step(被保険者関連処理)
    protected IBatchFlowCommand callDoHihokenshaKanrenProcess() {
        return simpleBatch(KokuhorenkyoutsuDoHihokenshaKanrenProcess.class).define();
    }

    /**
     * 一覧表作成です。
     *
     * @return バッチコマンド
     *
     */
    @Step(一覧表作成)
    protected IBatchFlowCommand callDoIchiranhyoSakuseiProcess() {
        KokuhorenKyodoJukyushaInGetIdProcessParameter parameter = new KokuhorenKyodoJukyushaInGetIdProcessParameter();
        parameter.setサブ業務コード(SubGyomuCode.DBC介護給付);
        parameter.set帳票ID(ReportIdDBC.DBC200057.getReportId());
        parameter.set出力順ID(getParameter().getShutsuryokujunId());
        return loopBatch(KokuhorenKyodoJukyushaInProcess.class).arguments(parameter)
                .define();
    }

    /**
     * 処理結果リスト作成です。
     *
     * @return バッチコマンド
     *
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
     * @return バッチコマンド
     *
     */
    @Step(取込済ファイル削除)
    protected IBatchFlowCommand callDeleteReveicedFileProcess() {
        KokuhorenkyotsuDeleteReveicedFileProcessParameter parameter
                = new KokuhorenkyotsuDeleteReveicedFileProcessParameter();
        parameter.set処理年月(FlexibleDate.getNowDate().getYearMonth());
        parameter.set保存先フォルダ(保存先フォルダのパス);
        parameter.setエントリ情報List(entityList);
        return simpleBatch(KokuhorenkyoutsuDeleteReveicedFileProcess.class).arguments(parameter).define();
    }

    private Integer checkNull(Integer レコード件数) {
        if (レコード件数 != null) {
            return レコード件数;
        }
        return 0;
    }

}
