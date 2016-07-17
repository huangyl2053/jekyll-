/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow.DBC120090;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120090.ShokanShikyuKetteiDoDBTorokuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120090.ShokanShikyuKetteiDoIchiranhyoSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120090.ShokanShikyuKetteiReadCsvFileProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120170.KohifutanshaDeleteReveicedFileProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120170.KohifutanshaDoHihokenshaKanrenProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120170.KohifutanshaDoInterfaceKanriKousinProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120170.KohifutanshaDoShoriKekkaListSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120170.KohifutanshaGetFileProcess;
import jp.co.ndensan.reams.db.dbc.business.core.kokuhorenkyoutsuu.KokuhorenKyoutsuuFileGetReturnEntity;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.shokanshikyuketteiin.DBC120090_ShokanShikyuKetteiInBacthParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_TorikomiErrorListType;
import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kagoketteikohifutanshain.KohifutanshaDeleteReveicedFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kagoketteikohifutanshain.KohifutanshaDoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kagoketteikohifutanshain.KohifutanshaDoInterfaceKanriKousinProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kagoketteikohifutanshain.KohifutanshaDoShoriKekkaListSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kagoketteikohifutanshain.KohifutanshaGetFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukyufuketteiin.KogakuKyufuKetteiDoDBTorokuProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukyufuketteiin.KogakuKyufuKetteiReadCsvFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.FlowEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払支給決定情報取込のバッチです。
 *
 * @reamsid_L DBC-0980-330 gongliang
 */
public class DBC120090_ShokanShikyuKetteiInFlow extends BatchFlowBase<DBC120090_ShokanShikyuKetteiInBacthParameter> {

    private static final String ファイル取得 = "getFile";
    private static final String CSVファイル取込 = "readCsvFile";
    private static final String 被保険者関連処理 = "doHihokenshaKanren";
    private static final String マスタ登録 = "doMasterToroku";
    private static final String 国保連インタフェース管理更新 = "doInterfaceKanriKousin";
    private static final String 一覧表作成 = "doIchiranhyoSakusei";
    private static final String 処理結果リスト作成 = "doShoriKekkaListSakusei";
    private static final String 取込済ファイル削除 = "deleteReveicedFile";

    private static final RString ファイル格納フォルダ名 = new RString("DBC120090");
    private static final RString 帳票ID = new RString("DBC200021_ShokanbaraiShikyuKetteishaIchiran");

    private KokuhorenKyoutsuuFileGetReturnEntity returnEntity;
    private FlowEntity flowEntity;

    private static RString 交換情報識別番号;

    @Override
    protected void defineFlow() {
        try {
            RDate now = RDate.getNowDate();
            交換情報識別番号 = DbBusinessConfig.get(
                    ConfigNameDBC.国保連取込_償還払支給決定者一覧情報_交換情報識別番号,
                    now, SubGyomuCode.DBC介護給付);
            executeStep(ファイル取得);
            returnEntity
                    = getResult(KokuhorenKyoutsuuFileGetReturnEntity.class, new RString(ファイル取得),
                            KohifutanshaGetFileProcess.PARAMETER_OUT_RETURNENTITY);
            executeStep(CSVファイル取込);
            flowEntity = getResult(FlowEntity.class, new RString(CSVファイル取込),
                    ShokanShikyuKetteiReadCsvFileProcess.PARAMETER_OUT_FLOWENTITY);
            if (0 == flowEntity.getCodeNum()) {
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
            executeStep(取込済ファイル削除);
        }

    }

    /**
     * ファイル取得処理クラスです。
     *
     * @return CreateGyomuHokenshaJohoGetsujiProcess
     */
    @Step(ファイル取得)
    protected IBatchFlowCommand callGetFileProcess() {
        KohifutanshaGetFileProcessParameter parameter = new KohifutanshaGetFileProcessParameter();
        parameter.set交換情報識別番号(交換情報識別番号);
        parameter.setファイル格納フォルダ名(ファイル格納フォルダ名);
        return simpleBatch(KohifutanshaGetFileProcess.class).arguments(parameter).define();
    }

    /**
     * CSVファイル取込処理クラスです。
     *
     * @return CreateGyomuHokenshaJohoGetsujiProcess
     */
    @Step(CSVファイル取込)
    protected IBatchFlowCommand callReadCsvFileProcess() {
        KogakuKyufuKetteiReadCsvFileProcessParameter parameter = new KogakuKyufuKetteiReadCsvFileProcessParameter();
        RString 処理年月 = getParameter().getShoriYearMonth().getYearMonth().toDateString();
        parameter.set処理年月(new FlexibleYearMonth(処理年月));
        parameter.set保存先フォルダ(returnEntity.get保存先フォルダのパス().toRString());
        parameter.setエントリ情報List(returnEntity.getFileNameList());
        return simpleBatch(ShokanShikyuKetteiReadCsvFileProcess.class).arguments(parameter).define();
    }

    /**
     * 被保険者関連処理クラスです。
     *
     * @return CreateGyomuHokenshaJohoGetsujiProcess
     */
    @Step(被保険者関連処理)
    protected IBatchFlowCommand callDoHihokenshaKanrenProcess() {
        return simpleBatch(KohifutanshaDoHihokenshaKanrenProcess.class).define();
    }

    /**
     * マスタ登録処理クラスです。
     *
     * @return CreateGyomuHokenshaJohoGetsujiProcess
     */
    @Step(マスタ登録)
    protected IBatchFlowCommand callDoMasterTorokuProcess() {
        KogakuKyufuKetteiDoDBTorokuProcessParameter parameter = new KogakuKyufuKetteiDoDBTorokuProcessParameter();
        RString 処理年月 = getParameter().getShoriYearMonth().getYearMonth().toDateString();
        parameter.set処理年月(new FlexibleYearMonth(処理年月));
        parameter.set再処理区分(SaiShoriKubun.valueOf(getParameter().getSaishoriKubun().toString()));
        return simpleBatch(ShokanShikyuKetteiDoDBTorokuProcess.class).arguments(parameter).define();
    }

    /**
     * 国保連インタフェース管理更新処理クラスです。
     *
     * @return CreateGyomuHokenshaJohoGetsujiProcess
     */
    @Step(国保連インタフェース管理更新)
    protected IBatchFlowCommand callDoInterfaceKanriKousinProcess() {
        KohifutanshaDoInterfaceKanriKousinProcessParameter parameter
                = new KohifutanshaDoInterfaceKanriKousinProcessParameter();
        RString 処理年月 = getParameter().getShoriYearMonth().getYearMonth().toDateString();
        parameter.set処理年月(new FlexibleYearMonth(処理年月));
        parameter.set交換情報識別番号(交換情報識別番号);
        parameter.set処理対象年月(flowEntity.getShoriYM());
        parameter.setレコード件数合計(flowEntity.getCodeNum());
        parameter.setFileNameList(returnEntity.getFileNameList());
        return simpleBatch(KohifutanshaDoInterfaceKanriKousinProcess.class).arguments(parameter).define();
    }

    /**
     * 一覧表作成クラスです。
     *
     * @return CreateGyomuHokenshaJohoGetsujiProcess
     */
    @Step(一覧表作成)
    protected IBatchFlowCommand callDoIchiranhyoSakuseiProcess() {
        KohifutanshaDoIchiranhyoSakuseiProcessParameter parameter
                = new KohifutanshaDoIchiranhyoSakuseiProcessParameter();
        parameter.setサブ業務コード(SubGyomuCode.DBC介護給付);
        parameter.set帳票ID(new ReportId(帳票ID));
        parameter.set出力順ID(Long.valueOf(getParameter().getShutsuryokujun().toString()));
        RString 処理年月 = getParameter().getShoriYearMonth().getYearMonth().toDateString();
        parameter.set処理年月(new FlexibleYearMonth(処理年月));
        parameter.setシステム日付(RDateTime.now());
        return simpleBatch(ShokanShikyuKetteiDoIchiranhyoSakuseiProcess.class).arguments(parameter).
                define();
    }

    /**
     * 処理結果リスト作成クラスです。
     *
     * @return CreateGyomuHokenshaJohoGetsujiProcess
     */
    @Step(処理結果リスト作成)
    protected IBatchFlowCommand callDoShoriKekkaListSakuseiProcess() {
        KohifutanshaDoShoriKekkaListSakuseiProcessParameter parameter
                = new KohifutanshaDoShoriKekkaListSakuseiProcessParameter();
        parameter.setエラーリストタイプ(KokuhorenJoho_TorikomiErrorListType.リストタイプ1);
        return simpleBatch(KohifutanshaDoShoriKekkaListSakuseiProcess.class).arguments(parameter).define();
    }

    /**
     * 取込済ファイル削除クラスです。
     *
     * @return CreateGyomuHokenshaJohoGetsujiProcess
     */
    @Step(取込済ファイル削除)
    protected IBatchFlowCommand callDeleteReveicedFileProcess() {
        KohifutanshaDeleteReveicedFileProcessParameter parameter
                = new KohifutanshaDeleteReveicedFileProcessParameter();
        RString 処理年月 = getParameter().getShoriYearMonth().getYearMonth().toDateString();
        parameter.set処理年月(new FlexibleYearMonth(処理年月));
        parameter.set保存先フォルダ(returnEntity.get保存先フォルダのパス().toRString());
        parameter.setエントリ情報List(returnEntity.getEntityList());
        return simpleBatch(KohifutanshaDeleteReveicedFileProcess.class).arguments(parameter).define();
    }
}
