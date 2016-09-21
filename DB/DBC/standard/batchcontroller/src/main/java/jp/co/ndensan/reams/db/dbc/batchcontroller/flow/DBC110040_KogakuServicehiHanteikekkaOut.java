/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110040.KogakuServicehiHanteiDoDBKoushinProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110040.KogakuServicehiHanteiDoIchiranhyoSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110040.KogakuServicehiHanteiDoSofuFileSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110040.KogakuServicehiHanteiDoSofuJogaiFlagSetteiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110040.KogakuServicehiHanteiGetHokenshaNoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110040.KogakuServicehiHanteiGetSoufuDataProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110040.KogakuServicehiHanteiReadHokenshaNoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110130.HokenshaKyufujissekiOutDoErrorProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110130.HokenshaKyufujissekiOutGetBeforeKanyuYMDProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110130.HokenshaKyufujissekiOutGetHihokenshaAtenaProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110130.HokenshaKyufujissekiOutGetHihokenshaNameProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110130.HokenshaKyufujissekiOutGetHihokenshaNoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110130.HokenshaKyufujissekiOutGetOldHihokenshaNoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110130.HokenshaKyufujissekiOutListSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110130.HokenshaKyufujissekiOutSetHihokenshaNoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDoInterfaceKanriKousinProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110040.DBC110040_KogakuServicehiHanteikekkaOutParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_SakuseiErrorListType;
import jp.co.ndensan.reams.db.dbc.definition.processprm.hokenshakyufujissekiout.HokenshaKyufujissekiOutGetHihokenshaNoProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.hokenshakyufujissekiout.HokenshaKyufujissekiOutListSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakuservicehihanteikekkaout.KogakuServicehiHanteiDoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakuservicehihanteikekkaout.KogakuServicehiHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.FlowEntity;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
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
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額サービス費給付判定結果情報作成のバッチ処理フロー
 *
 * @reamsid_L DBC-2610-030 liuhui
 */
public class DBC110040_KogakuServicehiHanteikekkaOut extends BatchFlowBase<DBC110040_KogakuServicehiHanteikekkaOutParameter> {

    private static final String 送付対象データ取得 = "getSoufuData";
    private static final String 保険者番号取込 = "readHokenshaNo";
    private static final String 送付除外区分設定 = "doSofuJogaiFlagSettei";
    private static final String 保険者番号取得 = "getHokenshaNo";
    private static final String 送付ファイル作成 = "doSofuFileSakusei";
    private static final String 一覧表作成 = "doIchiranhyoSakusei";
    private static final String DB更新 = "doDBKoushin";
    private static final String 国保連インタフェース管理更新 = "doInterfaceKanriKousin";
    private static final String 処理結果リスト作成 = "doShoriKekkaListSakusei";

    private static RString 交換情報識別番号;
    private int レコード件数合計 = 0;
    private List<SharedFileDescriptor> 送付ファイルエントリ情報List;
    private List<RString> hokenshaNoList = new ArrayList<>();
    private List<Integer> レコード件数List = new ArrayList<>();
    private KogakuServicehiHanteiProcessParameter parameter;
    private static final String 被保険者番号変換対象データの取得 = "getHihokenshaNoDataInformation";
    private static final String 広域加入日以前のデータを取得 = "getHihokenshaNoBeforeKanyuYMDData";
    private static final String 保険者番号の設定 = "setHihokenshaNo";
    private static final String 旧被保険者番号の取得 = "getOldHihokenshaNo";
    private static final String 保険者名の取得 = "getHihokenshaName";
    private static final RString MSG_導入形態コード = new RString("導入形態コード");
    private static final RString MSG_被保険者番号変換基準日の取得 = new RString("被保険者番号変換基準日の取得");
    private FlowEntity flowEntity;
    private DonyuKeitaiCode 導入形態コード;
    private FlexibleDate 変換基準日;
    private static final String 被保険者_宛名情報取得 = "getHihokenshaAtena";
    private static final String エラー登録 = "doError";

    @Override
    protected void defineFlow() {

        送付ファイルエントリ情報List = new ArrayList<>();
        parameter = new KogakuServicehiHanteiProcessParameter();
        parameter.set再処理区分(getParameter().get再処理区分());
        parameter.set処理年月(new FlexibleYearMonth(getParameter().get処理年月().toDateString()));
        RDate now = RDate.getNowDate();
        交換情報識別番号 = DbBusinessConfig.get(
                ConfigNameDBC.国保連送付_高額介護サービス費給付判定結果情報_交換情報識別番号,
                now, SubGyomuCode.DBC介護給付);
        executeStep(送付対象データ取得);
        int 送付対象データ件数 = getResult(Integer.class, new RString(送付対象データ取得),
                KogakuServicehiHanteiGetSoufuDataProcess.PARAMETER_OUT_OUTPUTCOUNT);
        if (0 == 送付対象データ件数) {
            executeStep(国保連インタフェース管理更新);
            executeStep(処理結果リスト作成);
        } else {
            doShinkyuHihokenshaNoHenkan();
            executeStep(保険者番号取込);
            executeStep(被保険者_宛名情報取得);
            executeStep(エラー登録);
            executeStep(送付除外区分設定);
            executeStep(保険者番号取得);
            hokenshaNoList = getResult(
                    List.class, new RString(保険者番号取得), KogakuServicehiHanteiGetHokenshaNoProcess.PARAMETER_OUT_OUTPUTENTRY);
            レコード件数List = getResult(
                    List.class, new RString(保険者番号取得), KogakuServicehiHanteiGetHokenshaNoProcess.PARAMETER_OUT_OUTPUTCOUNT);
            for (int i = 0; i < hokenshaNoList.size(); i++) {
                parameter.set保険者番号(hokenshaNoList.get(i));
                parameter.setレコード件数(レコード件数List.get(i));
                executeStep(送付ファイル作成);
                int レコード件数 = getResult(
                        Integer.class, new RString(送付ファイル作成), KogakuServicehiHanteiDoSofuFileSakuseiProcess.PARAMETER_OUT_OUTPUTCOUNT);
                レコード件数合計 = レコード件数合計 + レコード件数;
                List<SharedFileDescriptor> エントリ情報List = (ArrayList<SharedFileDescriptor>) getResult(
                        List.class, new RString(送付ファイル作成), KogakuServicehiHanteiDoSofuFileSakuseiProcess.PARAMETER_OUT_OUTPUTENTRY);
                送付ファイルエントリ情報List.addAll(エントリ情報List);
            }
            executeStep(一覧表作成);
            executeStep(DB更新);
            executeStep(国保連インタフェース管理更新);
            executeStep(処理結果リスト作成);
        }
    }

    /**
     * 送付対象データ取得です。
     *
     * @return KogakuServicehiHanteiGetSoufuDataProcess
     */
    @Step(送付対象データ取得)
    protected IBatchFlowCommand callGetSoufuDataProcess() {
        return loopBatch(KogakuServicehiHanteiGetSoufuDataProcess.class).arguments(parameter).define();
    }

    /**
     * 保険者番号取込です。
     *
     * @return KogakuServicehiHanteiReadHokenshaNoProcess
     */
    @Step(保険者番号取込)
    protected IBatchFlowCommand callReadHokenshaNoProcess() {
        return loopBatch(KogakuServicehiHanteiReadHokenshaNoProcess.class).define();
    }

    /**
     * 送付除外区分設定です。
     *
     * @return KogakuServicehiHanteiDoSofuJogaiFlagSetteiProcess
     */
    @Step(送付除外区分設定)
    protected IBatchFlowCommand callDoSofuJogaiFlagSetteiProcess() {
        return loopBatch(KogakuServicehiHanteiDoSofuJogaiFlagSetteiProcess.class).define();
    }

    /**
     * 保険者番号取得です。
     *
     * @return KogakuServicehiHanteiGetHokenshaNoProcess
     */
    @Step(保険者番号取得)
    protected IBatchFlowCommand callGetHokenshaNoProcess() {
        return loopBatch(KogakuServicehiHanteiGetHokenshaNoProcess.class).define();
    }

    /**
     * 送付ファイル作成です。
     *
     * @return KogakuServicehiHanteiDoSofuFileSakuseiProcess
     */
    @Step(送付ファイル作成)
    protected IBatchFlowCommand callDoSofuFileSakuseiProcess() {
        return loopBatch(KogakuServicehiHanteiDoSofuFileSakuseiProcess.class).arguments(parameter).define();
    }

    /**
     * 一覧表作成です。
     *
     * @return KogakuServicehiHanteiDoIchiranhyoSakuseiProcess
     */
    @Step(一覧表作成)
    protected IBatchFlowCommand callDoIchiranhyoSakuseiProcess() {
        KogakuServicehiHanteiDoIchiranhyoSakuseiProcessParameter parameter = new KogakuServicehiHanteiDoIchiranhyoSakuseiProcessParameter();
        parameter.setサブ業務コード(SubGyomuCode.DBC介護給付);
        parameter.set帳票ID(new ReportId(ReportIdDBC.DBC200019.getReportId().getColumnValue()));
        parameter.set出力順ID(Long.valueOf(getParameter().get出力順ID().toString()));
        parameter.set処理年月(new FlexibleYearMonth(getParameter().get処理年月().toDateString()));
        parameter.setシステム日付(RDateTime.now());
        return loopBatch(KogakuServicehiHanteiDoIchiranhyoSakuseiProcess.class).arguments(parameter).define();
    }

    /**
     * DB更新です。
     *
     * @return KogakuServicehiHanteiDoDBKoushinProcess
     */
    @Step(DB更新)
    protected IBatchFlowCommand callDoDBKoushinProcess() {
        return loopBatch(KogakuServicehiHanteiDoDBKoushinProcess.class).arguments(parameter).define();
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
        parameter.setエラーリストタイプ(KokuhorenJoho_SakuseiErrorListType.リストタイプ0);
        return loopBatch(HokenshaKyufujissekiOutListSakuseiProcess.class).arguments(parameter).define();
    }

    private KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter getParam() {
        KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter param = new KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter();
        param.set処理年月(new FlexibleYearMonth(getParameter().get処理年月().toDateString()));
        param.set交換情報識別番号(交換情報識別番号);
        param.set処理対象年月(new FlexibleYearMonth(getParameter().get処理年月().toDateString()));
        param.setレコード件数合計(レコード件数合計);
        List<RString> list = new ArrayList<>();
        if (送付ファイルエントリ情報List.isEmpty()) {
            param.setFileNameList(Collections.EMPTY_LIST);
        } else {
            for (SharedFileDescriptor entry : 送付ファイルエントリ情報List) {
                list.add(entry.getSharedFileName().toRString());
            }
            param.setFileNameList(list);
        }
        return param;
    }

    private void doShinkyuHihokenshaNoHenkan() {
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
}
