/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110060.KogakugassanShikyushinseishoOutGetSofuTaishoDataProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110060.KogakugassanShikyushinseishoOutHokenshaShutokuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110060.KogakugassanShikyushinseishoOutInsertKozaProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110060.KogakugassanShikyushinseishoOutSetHokenshameiKoikiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110060.KogakugassanShikyushinseishoOutSetHokenshameiTanitsuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110060.KogakugassanShikyushinseishoOutShinseishoReportProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110060.KogakugassanShikyushinseishoOutSofuFileSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110060.KogakugassanShikyushinseishoOutSoufuSetteiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110060.KogakugassanShikyushinseishoOutUpdateShinseishoMiSofuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110060.KogakugassanShikyushinseishoOutUpdateShinseishoSofuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.HokenshaKyufujissekiOutDoErrorProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.HokenshaKyufujissekiOutGetHihokenshaAtenaProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.HokenshaKyufujissekiOutListSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDoInterfaceKanriKousinProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110060.DBC110060_KogakugassanShikyushinseishoOutParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_SakuseiErrorListType;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc110060.KogakugassanShikyushinseishoOutProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.hokenshakyufujissekiout.HokenshaKyufujissekiOutListSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110060.HokenshaShutokuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassankyufujissekiout.SofuTaishoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.KaigoDonyuKubun;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算支給申請書情報作成のバッチflowです。
 *
 * @reamsid_L DBC-2630-030 wangxue
 */
public class DBC110060_KogakugassanShikyushinseishoOut extends BatchFlowBase<DBC110060_KogakugassanShikyushinseishoOutParameter> {

    private static final String 送付対象データ取得 = "getSofuTaishoData";
    private static final String 被保険者_宛名情報取得 = "getHihokenshaAtena";
    private static final String エラー登録 = "doError";
    private static final String 送付除外区分設定 = "soufuSettei";
    private static final String 口座情報登録確認 = "insertKozaJyoho";
    private static final String 証記載保険者名取得_単一 = "setHokenshameiTanitsu";
    private static final String 証記載保険者名取得_広域 = "setHokenshameiKoiki";
    private static final String 保険者番号の取得 = "hokenshaShutoku";
    private static final String 送付ファイル作成 = "sofuFileSakusei";
    private static final String 帳票出力 = "shinseishoReport";
    private static final String DB更新_送付済 = "updateShinseishoSofu";
    private static final String DB更新_未送付 = "updateShinseishoMiSofu";
    private static final String 国保連インタフェース管理更新 = "kokuhorenkyoutsuDoInterfaceKanriKousinProcess";
    private static final String 処理結果リスト作成 = "kokuhorenkyoutsuDoShoriKekkaListSakuseiProcess";

    private static final RString MSG_導入形態コード = new RString("導入形態コード");

    private static final int INDEX_0 = 0;

    private KogakugassanShikyushinseishoOutProcessParameter processParameter;
    private HokenshaShutokuEntity returnEntity;
    private int 総出力件数;
    private List<SharedFileDescriptor> エントリList;
    private RString 交換情報識別番号;
    private SofuTaishoEntity sofuEntity;

    @Override
    protected void defineFlow() {
        エントリList = new ArrayList<>();
        総出力件数 = INDEX_0;
        processParameter = new KogakugassanShikyushinseishoOutProcessParameter();
        processParameter.set処理年月(new FlexibleYearMonth(getParameter().get処理年月().toDateString()));
        processParameter.set再処理区分(getParameter().get再処理区分());
        RDate date = RDate.getNowDate();
        交換情報識別番号 = DbBusinessConfig.get(ConfigNameDBC.国保連送付_高額合算支給申請書情報_交換情報識別番号,
                date, SubGyomuCode.DBC介護給付);
        executeStep(送付対象データ取得);
        int 合計 = getResult(Integer.class, new RString(送付対象データ取得),
                KogakugassanShikyushinseishoOutGetSofuTaishoDataProcess.PARAMETER_OUT_OUTCOUNT);
        if (INDEX_0 != 合計) {
            executeStep(被保険者_宛名情報取得);
            executeStep(エラー登録);
            executeStep(送付除外区分設定);
            executeStep(口座情報登録確認);
            ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
            if (KaigoDonyuKubun.未導入.code().equals(市町村セキュリティ情報.get介護導入区分())) {
                throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage().replace(
                        MSG_導入形態コード.toString()).toString());
            }
            DonyuKeitaiCode 導入形態コード = DonyuKeitaiCode.toValue(市町村セキュリティ情報.get導入形態コード().value());
            if (DonyuKeitaiCode.事務単一.getCode().equals(導入形態コード.getCode())) {
                executeStep(証記載保険者名取得_単一);
            } else if (DonyuKeitaiCode.事務広域.getCode().equals(導入形態コード.getCode())) {
                executeStep(証記載保険者名取得_広域);
            }
            executeStep(保険者番号の取得);
            returnEntity = getResult(HokenshaShutokuEntity.class, new RString(保険者番号の取得),
                    KogakugassanShikyushinseishoOutHokenshaShutokuProcess.PARAMETER_OUT_RETURNENTITY);
            int size = returnEntity.get保険者番号List().size();
            for (int i = 0; i < size; i++) {
                processParameter.setレコード件数(returnEntity.getレコード件数List().get(i));
                processParameter.set件数(returnEntity.get件数List().get(i));
                processParameter.set保険者番号(returnEntity.get保険者番号List().get(i));
                executeStep(送付ファイル作成);
                sofuEntity = getResult(SofuTaishoEntity.class, new RString(送付ファイル作成),
                        KogakugassanShikyushinseishoOutSofuFileSakuseiProcess.PARAMETER_OUT_OUTRENTURNENTITY);
                総出力件数 = 総出力件数 + sofuEntity.get総出力件数();
                エントリList.add(sofuEntity.getエントリ情報());
            }
            RString 保険者情報_保険者番号 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, date, SubGyomuCode.DBU介護統計報告);
            RString 保険者情報_保険者名称 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者名称, date, SubGyomuCode.DBU介護統計報告);
            processParameter.set保険者情報_保険者番号(保険者情報_保険者番号);
            processParameter.set保険者情報_保険者名称(保険者情報_保険者名称);
            executeStep(帳票出力);
            executeStep(DB更新_送付済);
            executeStep(DB更新_未送付);
        }
        executeStep(国保連インタフェース管理更新);
        executeStep(処理結果リスト作成);
    }

    /**
     * 送付対象データ取得です。
     *
     * @return KogakugassanShikyushinseishoOutGetSofuTaishoDataProcess
     */
    @Step(送付対象データ取得)
    protected IBatchFlowCommand getSofuTaishoData() {
        return loopBatch(KogakugassanShikyushinseishoOutGetSofuTaishoDataProcess.class).arguments(processParameter).define();
    }

    /**
     * 被保険者_宛名情報取得です。
     *
     * @return HokenshaKyufujissekiOutGetHihokenshaAtenaProcess
     */
    @Step(被保険者_宛名情報取得)
    protected IBatchFlowCommand callGetHihokenshaAtenaProcess() {
        return loopBatch(HokenshaKyufujissekiOutGetHihokenshaAtenaProcess.class).define();

    }

    /**
     * エラー登録です。
     *
     * @return HokenshaKyufujissekiOutDoErrorProcess
     */
    @Step(エラー登録)
    protected IBatchFlowCommand callDoErrorrProcess() {
        return loopBatch(HokenshaKyufujissekiOutDoErrorProcess.class).define();

    }

    /**
     * 送付除外区分設定です。
     *
     * @return KogakugassanShikyushinseishoOutSoufuSetteiProcess
     */
    @Step(送付除外区分設定)
    protected IBatchFlowCommand soufuSettei() {
        return loopBatch(KogakugassanShikyushinseishoOutSoufuSetteiProcess.class).define();
    }

    /**
     * 口座情報登録確認です。
     *
     * @return KogakugassanShikyushinseishoOutInsertKozaProcess
     */
    @Step(口座情報登録確認)
    protected IBatchFlowCommand insertKozaJyoho() {
        return loopBatch(KogakugassanShikyushinseishoOutInsertKozaProcess.class).define();
    }

    /**
     * 証記載保険者名取得_広域です。
     *
     * @return KogakugassanShikyushinseishoOutSetHokenshameiTanitsuProcess
     */
    @Step(証記載保険者名取得_単一)
    protected IBatchFlowCommand setHokenshameiTanitsu() {
        return loopBatch(KogakugassanShikyushinseishoOutSetHokenshameiTanitsuProcess.class).define();
    }

    /**
     * 証記載保険者名取得_広域です。
     *
     * @return KogakugassanShikyushinseishoOutSetHokenshameiKoikiProcess
     */
    @Step(証記載保険者名取得_広域)
    protected IBatchFlowCommand setHokenshameiKoiki() {
        return loopBatch(KogakugassanShikyushinseishoOutSetHokenshameiKoikiProcess.class).define();
    }

    /**
     * 保険者番号の取得です。
     *
     * @return KogakugassanShikyushinseishoOutHokenshaShutokuProcess
     */
    @Step(保険者番号の取得)
    protected IBatchFlowCommand hokenshaShutoku() {
        return loopBatch(KogakugassanShikyushinseishoOutHokenshaShutokuProcess.class).define();
    }

    /**
     * 送付ファイル作成です。
     *
     * @return KogakugassanShikyushinseishoOutSofuFileSakuseiProcess
     */
    @Step(送付ファイル作成)
    protected IBatchFlowCommand sofuFileSakusei() {
        return loopBatch(KogakugassanShikyushinseishoOutSofuFileSakuseiProcess.class).arguments(processParameter).define();
    }

    /**
     * 帳票出力です。
     *
     * @return KogakugassanShikyushinseishoOutShinseishoReportProcess
     */
    @Step(帳票出力)
    protected IBatchFlowCommand shinseishoReport() {
        return loopBatch(KogakugassanShikyushinseishoOutShinseishoReportProcess.class).arguments(processParameter).define();
    }

    /**
     * DB更新_送付済です。
     *
     * @return KogakugassanShikyushinseishoOutUpdateShinseishoSofuProcess
     */
    @Step(DB更新_送付済)
    protected IBatchFlowCommand updateShinseishoSofu() {
        return loopBatch(KogakugassanShikyushinseishoOutUpdateShinseishoSofuProcess.class).arguments(processParameter).define();
    }

    /**
     * DB更新_未送付です。
     *
     * @return KogakugassanShikyushinseishoOutUpdateShinseishoSofuProcess
     */
    @Step(DB更新_未送付)
    protected IBatchFlowCommand updateShinseishoMiSofu() {
        return loopBatch(KogakugassanShikyushinseishoOutUpdateShinseishoMiSofuProcess.class).define();
    }

    /**
     * 国保連インタフェース管理更新操作です。
     *
     * @return IBatchFlowCommand
     */
    @Step(国保連インタフェース管理更新)
    protected IBatchFlowCommand callKokuhorenkyoutsuDoInterfaceKanriKousinProcess() {
        return simpleBatch(KokuhorenkyoutsuDoInterfaceKanriKousinProcess.class).arguments(getParam()).define();
    }

    /**
     * 処理結果リスト作成操作です。
     *
     * @return IBatchFlowCommand
     */
    @Step(処理結果リスト作成)
    protected IBatchFlowCommand callKokuhorenkyoutsuDoShoriKekkaListSakuseiProcess() {
        HokenshaKyufujissekiOutListSakuseiProcessParameter parameter = new HokenshaKyufujissekiOutListSakuseiProcessParameter();
        parameter.setエラーリストタイプ(KokuhorenJoho_SakuseiErrorListType.リストタイプ1);
        return loopBatch(HokenshaKyufujissekiOutListSakuseiProcess.class).arguments(parameter).define();
    }

    private KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter getParam() {
        KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter param = new KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter();
        param.set処理年月(new FlexibleYearMonth(getParameter().get処理年月().toDateString()));
        param.set交換情報識別番号(交換情報識別番号);
        if (INDEX_0 != 総出力件数) {
            param.set処理対象年月(new FlexibleYearMonth(getParameter().get処理年月().toDateString()));
            param.setレコード件数合計(総出力件数);
            List<RString> fileNamelist = new ArrayList<>();
            for (SharedFileDescriptor sdf : エントリList) {
                RString fileName = sdf.getSharedFileName().toRString();
                fileNamelist.add(fileName);
            }
            param.setFileNameList(fileNamelist);
        } else {
            param.set処理対象年月(new FlexibleYearMonth(getParameter().get処理年月().toDateString()));
            param.setレコード件数合計(0);
            param.setFileNameList(Collections.EMPTY_LIST);
        }
        return param;
    }

}
