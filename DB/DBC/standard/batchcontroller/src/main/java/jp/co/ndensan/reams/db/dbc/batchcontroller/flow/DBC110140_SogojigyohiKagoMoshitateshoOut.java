/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110090.KaigokyufuhiKagoMoshitateshoOutDoBillOutProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110090.KaigokyufuhiKagoMoshitateshoOutDoErrorProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110090.KaigokyufuhiKagoMoshitateshoOutGetHihokenshaNoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110090.KaigokyufuhiKagoMoshitateshoOutGetKagoMoshitateListProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110090.KaigokyufuhiKagoMoshitateshoOutGetjigyoshaNameProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110090.KaigokyufuhiKagoMoshitateshoOutSetSofuJogaiFlagProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110090.KaigokyufuhiKagoMoshitateshoOutSoufuFairuSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110090.KaigokyufuhiKagoMoshitateshoOutUpdateMiSofuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110090.KaigokyufuhiKagoMoshitateshoOutUpdateSofuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110090.KaigokyufuhiKagoMoshitateshoOutgetCitySingleProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110090.KaigokyufuhiKagoMoshitateshoOutgetCityWideAreaProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110130.HokenshaKyufujissekiOutDoErrorProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110130.HokenshaKyufujissekiOutGetBeforeKanyuYMDProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110130.HokenshaKyufujissekiOutGetHihokenshaAtenaProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110130.HokenshaKyufujissekiOutGetHihokenshaNameProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110130.HokenshaKyufujissekiOutGetHihokenshaNoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110130.HokenshaKyufujissekiOutGetOldHihokenshaNoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110130.HokenshaKyufujissekiOutListSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110130.HokenshaKyufujissekiOutSetHihokenshaNoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDoInterfaceKanriKousinProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110090.KaigokyufuhiKagoMoshitateshoGetKagoMoshitateListProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110090.KaigokyufuhiKagoMoshitateshoOutDoBillOutProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110090.KaigokyufuhiKagoMoshitateshoSoufuFairuSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110140.DBC110140_SogojigyohiKagoMoshitateshoOutParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_SakuseiErrorListType;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhoreninterface.ConfigKeysKokuhorenSofu;
import jp.co.ndensan.reams.db.dbc.definition.processprm.hokenshakyufujissekiout.HokenshaKyufujissekiOutGetHihokenshaNoProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.hokenshakyufujissekiout.HokenshaKyufujissekiOutListSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.FlowEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110090.DbWT1731KagoMoshitateTempEntity;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.KaigoDonyuKubun;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.db.dbz.service.core.gappeijoho.gappeijoho.GappeiCityJohoBFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 総合事業費過誤申立書情報作成のバッチ処理フロークラスです
 *
 * @reamsid_L DBC-2530-032 jiangwenkai
 */
public class DBC110140_SogojigyohiKagoMoshitateshoOut extends BatchFlowBase<DBC110140_SogojigyohiKagoMoshitateshoOutParameter> {

    private static final String 送付対象データ取得 = "getKagoMoshitateList";
    private static final String 保険者番号取込 = "getHihokenshaNo";
    private static final String 被保険者_宛名情報取得 = "getHihokenshaAtena";
    private static final String エラー登録 = "doError";

    private static final String 送付除外区分設定 = "setSofuJogaiFlag";
    private static final String 事業者名称取得 = "getjigyoshaName";
    private static final String 市町村セキュリティ情報取得_単一 = "getCityVillagesInformationSingle";
    private static final String 市町村セキュリティ情報取得_広域 = "getCityVillagesInformationWideArea";
    private static final String 帳票出力 = "doBillOut";
    private static final String 保険者番号の取得 = "getHihokenshaNoError";
    private static final String 送付ファイル作成 = "soufuFairuSakusei";
    private static final String DB更新_送付済 = "updateKogakuGassanSofu";
    private static final String DB更新_未送付 = "updateKogakuGassanMiSofu";

    private static final String 国保連インタフェース管理更新 = "doInterfaceKanriKousin";
    private static final String 処理結果リスト作成 = "doShoriKekkaListSakusei";
    private static final RString MSG_導入形態コード = new RString("導入形態コード");

    private static final String 被保険者番号変換対象データの取得 = "getHihokenshaNoDataInformation";
    private static final String 広域加入日以前のデータを取得 = "getHihokenshaNoBeforeKanyuYMDData";
    private static final String 保険者番号の設定 = "setHihokenshaNo";
    private static final String 旧被保険者番号の取得 = "getOldHihokenshaNo";
    private static final String 保険者名の取得 = "getHihokenshaName";
    private static final RString MSG_被保険者番号変換基準日の取得 = new RString("被保険者番号変換基準日の取得");
    private FlowEntity flowEntity;
    private FlexibleDate 変換基準日;
    private int 件数合算;
    private int レコード件数合計 = 0;
    private List<SharedFileDescriptor> エントリ情報List;
    private DonyuKeitaiCode 導入形態コード;
    private KaigokyufuhiKagoMoshitateshoSoufuFairuSakuseiProcessParameter soufuFairuParameter;

    private static final RString 書区分コード = new RString("3");
    private static final RString コード = new RString("179");

    @Override
    protected void defineFlow() {
        エントリ情報List = new ArrayList<>();

        executeStep(送付対象データ取得);
        flowEntity = getResult(FlowEntity.class, new RString(送付対象データ取得),
                KaigokyufuhiKagoMoshitateshoOutGetKagoMoshitateListProcess.PARAMETER_OUT_FLOWENTITY);
        件数合算 = flowEntity.getCodeNum();
        if (0 == 件数合算) {
            executeStep(国保連インタフェース管理更新);
            executeStep(処理結果リスト作成);
        } else {
            this.changeHihokenshaNo();
            executeStep(保険者番号取込);
            this.getHihokenshaAtena();
            executeStep(送付除外区分設定);
            executeStep(事業者名称取得);
            if (導入形態コード.is単一()) {
                executeStep(市町村セキュリティ情報取得_単一);
            } else if (導入形態コード.is広域()) {
                executeStep(市町村セキュリティ情報取得_広域);
            }
            executeStep(保険者番号の取得);
            flowEntity = (FlowEntity) getResult(FlowEntity.class, new RString(保険者番号の取得),
                    KaigokyufuhiKagoMoshitateshoOutDoErrorProcess.PARAMETER_OUT_FLOWENTITY);
            if (0 != flowEntity.getCodeNum()) {
                this.soufuFairuParameter = new KaigokyufuhiKagoMoshitateshoSoufuFairuSakuseiProcessParameter();
                this.soufuFairuParameter.setコード(コード);
                this.soufuFairuParameter.set処理年月(new FlexibleYearMonth(getParameter().get処理年月().toDateString()));
                List<DbWT1731KagoMoshitateTempEntity> bWT1731List = getResult(
                        List.class, new RString(保険者番号の取得), KaigokyufuhiKagoMoshitateshoOutDoErrorProcess.PARAMETER_OUT_OUTPUTENTRY);
                for (DbWT1731KagoMoshitateTempEntity dbt : bWT1731List) {
                    this.soufuFairuParameter.set保険者番号(dbt.getHokenshaNo());
                    executeStep(送付ファイル作成);
                    int num = getResult(
                            Integer.class, new RString(送付ファイル作成), KaigokyufuhiKagoMoshitateshoOutSoufuFairuSakuseiProcess.PARAMETER_OUT_OUTPUTCOUNT);
                    レコード件数合計 = レコード件数合計 + num;
                    List<SharedFileDescriptor> list = (ArrayList<SharedFileDescriptor>) getResult(
                            List.class, new RString(送付ファイル作成), KaigokyufuhiKagoMoshitateshoOutSoufuFairuSakuseiProcess.PARAMETER_OUT_OUTPUTENTRY);
                    this.エントリ情報List.addAll(list);
                }
            }
            executeStep(帳票出力);
            executeStep(DB更新_送付済);
            executeStep(DB更新_未送付);
            executeStep(国保連インタフェース管理更新);
            executeStep(処理結果リスト作成);
        }

    }

    private void getHihokenshaAtena() {
        executeStep(被保険者_宛名情報取得);
        executeStep(エラー登録);
    }

    private void changeHihokenshaNo() {
        this.getCityVillagesInformation();
        this.getHihokenshaNoTimeInformation();
        if (this.変換基準日.isEmpty()) {
            executeStep(保険者番号の設定);
        } else {
            executeStep(被保険者番号変換対象データの取得);
            flowEntity = (FlowEntity) getResult(FlowEntity.class, new RString(被保険者番号変換対象データの取得),
                    HokenshaKyufujissekiOutGetHihokenshaNoProcess.PARAMETER_OUT_FLOWENTITY);
            if (0 == flowEntity.getCodeNum()) {
                executeStep(保険者番号の設定);
            } else {
                this.splitFlow();
            }
        }
        executeStep(保険者名の取得);

    }

    private void splitFlow() {
        if (導入形態コード.is単一()) {
            executeStep(旧被保険者番号の取得);
            executeStep(保険者番号の設定);

        } else {
            executeStep(広域加入日以前のデータを取得);
            flowEntity = (FlowEntity) getResult(FlowEntity.class, new RString(広域加入日以前のデータを取得),
                    HokenshaKyufujissekiOutGetBeforeKanyuYMDProcess.PARAMETER_OUT_FLOWENTITY);
            if (0 == flowEntity.getCodeNum()) {
                executeStep(保険者番号の設定);
            } else {
                executeStep(旧被保険者番号の取得);
                executeStep(保険者番号の設定);
            }
        }
    }

    /**
     * 送付対象データ取得です。
     *
     * @return KaigokyufuhiKagoMoshitateshoOutGetKagoMoshitateListProcess
     */
    @Step(送付対象データ取得)
    protected IBatchFlowCommand callGetKagoMoshitateListProcess() {
        KaigokyufuhiKagoMoshitateshoGetKagoMoshitateListProcessParameter parameter
                = new KaigokyufuhiKagoMoshitateshoGetKagoMoshitateListProcessParameter();
        parameter.set再処理区分(getParameter().get再処理区分());
        parameter.set処理年月(new FlexibleYearMonth(getParameter().get処理年月().toDateString()));
        parameter.set送付対象情報(getParameter().get送付対象情報のｺｰﾄﾞ());
        parameter.set申立書区分コード(書区分コード);
        return loopBatch(KaigokyufuhiKagoMoshitateshoOutGetKagoMoshitateListProcess.class).arguments(parameter).define();
    }

    /**
     * 被保険者番号変換対象データの取得です。
     *
     * @return HokenshaKyufujissekiOutGetHihokenshaNoProcess
     */
    @Step(被保険者番号変換対象データの取得)
    protected IBatchFlowCommand callGetHihokenshaNoDataInformationProcess() {
        HokenshaKyufujissekiOutGetHihokenshaNoProcessParameter parameter = new HokenshaKyufujissekiOutGetHihokenshaNoProcessParameter();
        parameter.set年月(変換基準日);
        return loopBatch(HokenshaKyufujissekiOutGetHihokenshaNoProcess.class).arguments(parameter).define();

    }

    /**
     * 広域加入日以前のデータを取得です。
     *
     * @return HokenshaKyufujissekiOutGetBeforeKanyuYMDProcess
     */
    @Step(広域加入日以前のデータを取得)
    protected IBatchFlowCommand callGetHihokenshaNoBeforeKanyuYMDDataProcess() {
        return loopBatch(HokenshaKyufujissekiOutGetBeforeKanyuYMDProcess.class).define();

    }

    /**
     * 旧被保険者番号の取得です。
     *
     * @return HokenshaKyufujissekiOutGetOldHihokenshaNoProcess
     */
    @Step(旧被保険者番号の取得)
    protected IBatchFlowCommand callGetOldHihokenshaNoProcess() {
        return loopBatch(HokenshaKyufujissekiOutGetOldHihokenshaNoProcess.class).define();

    }

    /**
     * 保険者番号の設定です。
     *
     * @return HokenshaKyufujissekiOutGetHihokenshaNameProcess
     */
    @Step(保険者名の取得)
    protected IBatchFlowCommand callGetHihokenshaNameProcess() {
        return loopBatch(HokenshaKyufujissekiOutGetHihokenshaNameProcess.class).define();

    }

    /**
     * 保険者番号の設定です。
     *
     * @return HokenshaKyufujissekiOutSetHihokenshaNoProcess
     */
    @Step(保険者番号の設定)
    protected IBatchFlowCommand callSetHihokenshaNoProcess() {
        return loopBatch(HokenshaKyufujissekiOutSetHihokenshaNoProcess.class).define();

    }

    /**
     * 保険者番号取込です。
     *
     * @return KaigokyufuhiKagoMoshitateshoOutGetHihokenshaNoProcess
     */
    @Step(保険者番号取込)
    protected IBatchFlowCommand callGetHihokenshaNoProcess() {
        return loopBatch(KaigokyufuhiKagoMoshitateshoOutGetHihokenshaNoProcess.class).define();
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
     * @return KaigokyufuhiKagoMoshitateshoOutSetSofuJogaiFlagProcess
     */
    @Step(送付除外区分設定)
    protected IBatchFlowCommand callSetSofuJogaiFlagProcess() {
        return loopBatch(KaigokyufuhiKagoMoshitateshoOutSetSofuJogaiFlagProcess.class).define();
    }

    /**
     * 事業者名称取得です。
     *
     * @return KaigokyufuhiKagoMoshitateshoOutGetjigyoshaNameProcess
     */
    @Step(事業者名称取得)
    protected IBatchFlowCommand callGetjigyoshaNameProcess() {
        return loopBatch(KaigokyufuhiKagoMoshitateshoOutGetjigyoshaNameProcess.class).define();
    }

    /**
     * 市町村セキュリティ情報取得_単一です。
     *
     * @return KaigokyufuhiKagoMoshitateshoOutgetCitySingleProcess
     */
    @Step(市町村セキュリティ情報取得_単一)
    IBatchFlowCommand callGetCityVillagesInformationSingleProcess() {
        return loopBatch(KaigokyufuhiKagoMoshitateshoOutgetCitySingleProcess.class).define();
    }

    /**
     * 市町村セキュリティ情報取得_広域です。
     *
     * @return KaigokyufuhiKagoMoshitateshoOutgetCityWideAreaProcess
     */
    @Step(市町村セキュリティ情報取得_広域)
    IBatchFlowCommand callGetCityVillagesInformationWideAreaProcess() {
        return loopBatch(KaigokyufuhiKagoMoshitateshoOutgetCityWideAreaProcess.class).define();
    }

    /**
     * エラー登録です。
     *
     * @return KaigokyufuhiKagoMoshitateshoOutDoErrorProcess
     */
    @Step(保険者番号の取得)
    protected IBatchFlowCommand callGetHihokenshaNoErrorProcess() {
        return loopBatch(KaigokyufuhiKagoMoshitateshoOutDoErrorProcess.class).define();

    }

    /**
     * 送付ファイル作成操作です。
     *
     * @return KaigokyufuhiKagoMoshitateshoOutSoufuFairuSakuseiProcess
     */
    @Step(送付ファイル作成)
    protected IBatchFlowCommand callSoufuFairuSakuseiProcess() {

        return loopBatch(KaigokyufuhiKagoMoshitateshoOutSoufuFairuSakuseiProcess.class).arguments(soufuFairuParameter).define();
    }

    /**
     * 帳票出力です。
     *
     * @return KaigokyufuhiKagoMoshitateshoOutDoBillOutProcess
     */
    @Step(帳票出力)
    protected IBatchFlowCommand callDoBillOutProcess() {
        KaigokyufuhiKagoMoshitateshoOutDoBillOutProcessParameter kaigoParameter = new KaigokyufuhiKagoMoshitateshoOutDoBillOutProcessParameter();
        kaigoParameter.setコード(コード);
        kaigoParameter.set処理年月(new FlexibleYearMonth(getParameter().get処理年月().toDateString()));
        kaigoParameter.set帳票ID(ReportIdDBC.DBC200079.getReportId());
        kaigoParameter.set出力順ID(getParameter().get出力順ID());
        kaigoParameter.setシステム日付(RDate.getNowDateTime());
        return loopBatch(KaigokyufuhiKagoMoshitateshoOutDoBillOutProcess.class).arguments(kaigoParameter).define();
    }

    /**
     * DB更新_送付済操作です。
     *
     * @return KaigokyufuhiKagoMoshitateshoOutUpdateSofuProcess
     */
    @Step(DB更新_送付済)
    protected IBatchFlowCommand callUpdateKogakuGassanSofuProcess() {
        KaigokyufuhiKagoMoshitateshoGetKagoMoshitateListProcessParameter parameter
                = new KaigokyufuhiKagoMoshitateshoGetKagoMoshitateListProcessParameter();
        parameter.set再処理区分(getParameter().get再処理区分());
        parameter.set処理年月(new FlexibleYearMonth(getParameter().get処理年月().toDateString()));
        return loopBatch(KaigokyufuhiKagoMoshitateshoOutUpdateSofuProcess.class).arguments(parameter).define();
    }

    /**
     * DB更新_未送付操作です。
     *
     * @return KaigokyufuhiKagoMoshitateshoOutUpdateMiSofuProcess
     */
    @Step(DB更新_未送付)
    protected IBatchFlowCommand callUpdateKogakuGassanMiSofuProcess() {
        return loopBatch(KaigokyufuhiKagoMoshitateshoOutUpdateMiSofuProcess.class).define();
    }

    /**
     * 国保連インタフェース管理更新です。
     *
     * @return KokuhorenkyoutsuDoInterfaceKanriKousinProcess
     */
    @Step(国保連インタフェース管理更新)
    protected IBatchFlowCommand callDoInterfaceKanriKousinProcess() {
        return simpleBatch(KokuhorenkyoutsuDoInterfaceKanriKousinProcess.class).arguments(getParam()).define();
    }

    /**
     * 処理結果リスト作成です。
     *
     * @return HokenshaKyufujissekiOutListSakuseiProcess
     */
    @Step(処理結果リスト作成)
    protected IBatchFlowCommand callDoShoriKekkaListSakuseiProcess() {
        HokenshaKyufujissekiOutListSakuseiProcessParameter parameter = new HokenshaKyufujissekiOutListSakuseiProcessParameter();
        parameter.setエラーリストタイプ(KokuhorenJoho_SakuseiErrorListType.リストタイプ0);
        return loopBatch(HokenshaKyufujissekiOutListSakuseiProcess.class).arguments(parameter).define();
    }

    /**
     * 市町村セキュリティ情報取得です。
     */
    private void getCityVillagesInformation() {
        ShichosonSecurityJoho 介護導入形態 = ShichosonSecurityJohoFinder.createInstance().getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (null != 介護導入形態) {
            KaigoDonyuKubun 介護導入区分 = 介護導入形態.get介護導入区分();
            if (KaigoDonyuKubun.未導入.code().equals(介護導入区分.code())) {
                throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage().replace(
                        MSG_導入形態コード.toString()).toString());
            } else if (KaigoDonyuKubun.導入済.code().equals(介護導入区分.code())) {
                this.導入形態コード = 介護導入形態.get導入形態コード();
            }
        }

    }

    /**
     * 被保険者番号変換基準日の取得です。
     */
    private void getHihokenshaNoTimeInformation() {
        GappeiCityJohoBFinder 変換基準日finder = GappeiCityJohoBFinder.createInstance();
        this.変換基準日 = 変換基準日finder.getHihokenshaBangoHenkanKijunbi(GyomuBunrui.介護事務,
                導入形態コード);
        if (null == 変換基準日) {
            throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage().replace(
                    MSG_被保険者番号変換基準日の取得.toString()).toString());

        }
    }

    private KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter getParam() {
        KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter param = new KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter();
        param.set処理年月(new FlexibleYearMonth(getParameter().get処理年月().toDateString()));
        param.set交換情報識別番号(ConfigKeysKokuhorenSofu.過誤申立書情報.getコード());
        param.set処理対象年月(new FlexibleYearMonth(getParameter().get処理年月().toDateString()));
        param.setレコード件数合計(レコード件数合計);
//        List<RString> list = new ArrayList<>();
//        if (エントリ情報List.isEmpty()) {
//            param.setFileNameList(Collections.EMPTY_LIST);
//        } else {
//            for (SharedFileDescriptor entry : エントリ情報List) {
//                // TODO QA1149 value too long for type character varying(20)
//                list.add(entry.getSharedFileName().toRString());
////                list.add(entry.getSharedFileName().toRString().substring(INT_4));
//                param.setFileNameList(list);
//            }
//        }
        param.setFileNameList(Collections.EMPTY_LIST);
        return param;
    }
}
