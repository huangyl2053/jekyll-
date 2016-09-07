/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110120.SaishinsaMoshitateDoDBKoushinProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110120.SaishinsaMoshitateDoIchiranhyoSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110120.SaishinsaMoshitateDoSofuFileSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110120.SaishinsaMoshitateDoSofuJogaiFlagSetteiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110120.SaishinsaMoshitateGetHokenshaNoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110120.SaishinsaMoshitateGetJigyoshaNameProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110120.SaishinsaMoshitateGetServiceCodeNameProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110120.SaishinsaMoshitateGetServiceNaiyouNameProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110120.SaishinsaMoshitateGetServiceTeikyoShuruiNameProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110120.SaishinsaMoshitateGetShiteiServiceJigyoshaNameProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110120.SaishinsaMoshitateGetShoKisaiHokenshaNameProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110120.SaishinsaMoshitateGetSoufuDataProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110120.SaishinsaMoshitateReadHokenshaNoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110130.HokenshaKyufujissekiOutListSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDoInterfaceKanriKousinProcess;
import jp.co.ndensan.reams.db.dbc.business.core.saishinsamoshitateshouut.SaishinsaMoshitateshoOutSofuDataGetReturnEntity;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110120.DBC110120_SaishinsaMoshitateshoOutParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_SakuseiErrorListType;
import jp.co.ndensan.reams.db.dbc.definition.processprm.hokenshakyufujissekiout.HokenshaKyufujissekiOutListSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.saishinsamoshitateshoout.SaishinsaMoshitateDoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.saishinsamoshitateshoout.SaishinsaMoshitateGetSoufuDataProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護給付費再審査申立書情報作成のバッチ処理フロー
 *
 * @reamsid_L DBC-2540-030 liuhui
 */
public class DBC110120_SaishinsaMoshitateshoOut extends BatchFlowBase<DBC110120_SaishinsaMoshitateshoOutParameter> {

    private static final String 送付対象データ取得 = "getSoufuData";
    private static final String 新旧被保険者番号変換 = "doShinkyuHihokenshaNoHenkan";
    private static final RString 新旧被保険者番号変換_ID = new RString("HokenshaKyufujissekiOutChangeHihokenshaNoFlow");
    private static final String 保険者番号取込 = "readHokenshaNo";
    private static final String 宛名情報取得 = "getMeisyoJoho";
    private static final RString 宛名情報取得_ID = new RString("HokenshaKyufujissekiOutHihokenshaAtenaFlow");
    private static final String 送付除外区分設定 = "doSofuJogaiFlagSettei";
    private static final String 保険者番号取得 = "getHokenshaNo";
    private static final String 送付ファイル作成 = "doSofuFileSakusei";
    private static final String 証記載保険者名取得 = "getShoKisaiHokenshaName";
    private static final String 介護事業者指定サービス名称取得 = "getShiteiServiceJigyoshaName";
    private static final String 介護事業者名称取得 = "getJigyoshaName";
    private static final String サービス種類名称取得 = "getServiceTeikyoShuruiName";
    private static final String 介護サービス内容名称取得 = "getServiceNaiyouName";
    private static final String 特定診療サービスコード名称取得 = "getServiceCodeName";
    private static final String 一覧表作成 = "doIchiranhyoSakusei";
    private static final String DB更新 = "doDBKoushin";
    private static final String 国保連インタフェース管理更新 = "doInterfaceKanriKousin";
    private static final String 処理結果リスト作成 = "doShoriKekkaListSakusei";

    private static RString 交換情報識別番号;
    private int レコード件数合計 = 0;
    private List<SharedFileDescriptor> 送付ファイルエントリ情報List;
    private List<RString> hokenshaNoList = new ArrayList<>();
    private SaishinsaMoshitateshoOutSofuDataGetReturnEntity returnEntity;
    private SaishinsaMoshitateGetSoufuDataProcessParameter parameter;

    @Override
    protected void defineFlow() {

        送付ファイルエントリ情報List = new ArrayList<>();
        parameter = new SaishinsaMoshitateGetSoufuDataProcessParameter();
        parameter.set再処理区分(getParameter().get再処理区分());
        parameter.set処理年月(new FlexibleYearMonth(getParameter().get処理年月().toDateString()));
        RDate now = RDate.getNowDate();
        交換情報識別番号 = DbBusinessConfig.get(
                ConfigNameDBC.国保連送付_再審査申立書情報_交換情報識別番号,
                now, SubGyomuCode.DBC介護給付);
        executeStep(送付対象データ取得);
        returnEntity
                = getResult(SaishinsaMoshitateshoOutSofuDataGetReturnEntity.class, new RString(送付対象データ取得),
                        SaishinsaMoshitateGetSoufuDataProcess.PARAMETER_OUT_FLOWENTITY);
        if (0 == returnEntity.getレコード件数合算()) {
            executeStep(国保連インタフェース管理更新);
            executeStep(処理結果リスト作成);
        } else {
            executeStep(新旧被保険者番号変換);
            executeStep(保険者番号取込);
            executeStep(宛名情報取得);
            executeStep(送付除外区分設定);
            executeStep(保険者番号取得);
            hokenshaNoList = getResult(
                    List.class, new RString(保険者番号取得), SaishinsaMoshitateGetHokenshaNoProcess.PARAMETER_OUT_OUTPUTENTRY);
            for (int i = 0; i < hokenshaNoList.size(); i++) {
                parameter.set保険者番号(hokenshaNoList.get(i));
                executeStep(送付ファイル作成);
                int レコード件数 = getResult(
                        Integer.class, new RString(送付ファイル作成), SaishinsaMoshitateDoSofuFileSakuseiProcess.PARAMETER_OUT_OUTPUTCOUNT);
                レコード件数合計 = レコード件数合計 + レコード件数;
                List<SharedFileDescriptor> エントリ情報List = (ArrayList<SharedFileDescriptor>) getResult(
                        List.class, new RString(送付ファイル作成), SaishinsaMoshitateDoSofuFileSakuseiProcess.PARAMETER_OUT_OUTPUTENTRY);
                送付ファイルエントリ情報List.addAll(エントリ情報List);
            }
            executeStep(証記載保険者名取得);
            executeStep(介護事業者指定サービス名称取得);
            executeStep(介護事業者名称取得);
            executeStep(サービス種類名称取得);
            executeStep(介護サービス内容名称取得);
            executeStep(特定診療サービスコード名称取得);
            executeStep(一覧表作成);
            executeStep(DB更新);
            executeStep(国保連インタフェース管理更新);
            executeStep(処理結果リスト作成);
        }
    }

    /**
     * 送付対象データ取得です。
     *
     * @return callGetSoufuTaisyoDataProcess
     */
    @Step(送付対象データ取得)
    protected IBatchFlowCommand callGetSoufuDataProcess() {
        return loopBatch(SaishinsaMoshitateGetSoufuDataProcess.class).arguments(parameter).define();
    }

    /**
     * 新旧被保険者番号変換です。
     *
     * @return IBatchFlowCommand
     */
    @Step(新旧被保険者番号変換)
    protected IBatchFlowCommand callDoShinkyuHihokenshaNoHenkanProcess() {
        return otherBatchFlow(新旧被保険者番号変換_ID, SubGyomuCode.DBC介護給付, null).define();
    }

    /**
     * 保険者番号取込です。
     *
     * @return SaishinsaMoshitateReadHokenshaNoProcess
     */
    @Step(保険者番号取込)
    protected IBatchFlowCommand callReadHokenshaNoProcess() {
        return loopBatch(SaishinsaMoshitateReadHokenshaNoProcess.class).define();
    }

    /**
     * 宛名情報取得です。
     *
     * @return IBatchFlowCommand
     */
    @Step(宛名情報取得)
    protected IBatchFlowCommand callGetMeisyoJohoProcess() {
        return otherBatchFlow(宛名情報取得_ID, SubGyomuCode.DBC介護給付, null).define();
    }

    /**
     * 送付除外区分設定です。
     *
     * @return SaishinsaMoshitateDoSofuJogaiFlagSetteiProcess
     */
    @Step(送付除外区分設定)
    protected IBatchFlowCommand callDoSofuJogaiFlagSetteiProcess() {
        return loopBatch(SaishinsaMoshitateDoSofuJogaiFlagSetteiProcess.class).define();
    }

    /**
     * 保険者番号取得です。
     *
     * @return SaishinsaMoshitateGetHokenshaNoProcess
     */
    @Step(保険者番号取得)
    protected IBatchFlowCommand callGetHokenshaNoProcess() {
        return loopBatch(SaishinsaMoshitateGetHokenshaNoProcess.class).define();
    }

    /**
     * 送付ファイル作成です。
     *
     * @return SaishinsaMoshitateDoSofuFileSakuseiProcess
     */
    @Step(送付ファイル作成)
    protected IBatchFlowCommand callDoSofuFileSakuseiProcess() {
        return loopBatch(SaishinsaMoshitateDoSofuFileSakuseiProcess.class).arguments(parameter).define();
    }

    /**
     * 証記載保険者名取得です。
     *
     * @return SaishinsaMoshitateGetShoKisaiHokenshaNameProcess
     */
    @Step(証記載保険者名取得)
    protected IBatchFlowCommand callGetShoKisaiHokenshaNameProcess() {
        return loopBatch(SaishinsaMoshitateGetShoKisaiHokenshaNameProcess.class).define();
    }

    /**
     * 介護事業者指定サービス名称取得です。
     *
     * @return SaishinsaMoshitateGetShiteiServiceJigyoshaNameProcess
     */
    @Step(介護事業者指定サービス名称取得)
    protected IBatchFlowCommand callGetShiteiServiceJigyoshaNameProcess() {
        return loopBatch(SaishinsaMoshitateGetShiteiServiceJigyoshaNameProcess.class).define();
    }

    /**
     * 介護事業者名称取得です。
     *
     * @return SaishinsaMoshitateGetJigyoshaNameProcess
     */
    @Step(介護事業者名称取得)
    protected IBatchFlowCommand callGetJigyoshaNameProcess() {
        return loopBatch(SaishinsaMoshitateGetJigyoshaNameProcess.class).define();
    }

    /**
     * サービス種類名称取得です。
     *
     * @return SaishinsaMoshitateGetServiceTeikyoShuruiNameProcess
     */
    @Step(サービス種類名称取得)
    protected IBatchFlowCommand callGetServiceTeikyoShuruiNameProcess() {
        return loopBatch(SaishinsaMoshitateGetServiceTeikyoShuruiNameProcess.class).define();
    }

    /**
     * 介護サービス内容名称取得です。
     *
     * @return SaishinsaMoshitateGetServiceNaiyouNameProcess
     */
    @Step(介護サービス内容名称取得)
    protected IBatchFlowCommand callGetServiceNaiyouNameProcess() {
        return loopBatch(SaishinsaMoshitateGetServiceNaiyouNameProcess.class).define();
    }

    /**
     * 特定診療サービスコード名称取得です。
     *
     * @return SaishinsaMoshitateGetServiceCodeNameProcess
     */
    @Step(特定診療サービスコード名称取得)
    protected IBatchFlowCommand callGetServiceCodeNameProcess() {
        return loopBatch(SaishinsaMoshitateGetServiceCodeNameProcess.class).define();
    }

    /**
     * 一覧表作成です。
     *
     * @return SaishinsaMoshitateDoIchiranhyoSakuseiProcess
     */
    @Step(一覧表作成)
    protected IBatchFlowCommand callDoIchiranhyoSakuseiProcess() {
        SaishinsaMoshitateDoIchiranhyoSakuseiProcessParameter parameter = new SaishinsaMoshitateDoIchiranhyoSakuseiProcessParameter();
        parameter.setサブ業務コード(SubGyomuCode.DBC介護給付);
        parameter.set帳票ID(new ReportId(ReportIdDBC.DBC200047.getReportId().getColumnValue()));
        parameter.set出力順ID(Long.valueOf(getParameter().get出力順ID().toString()));
        parameter.set処理年月(getParameter().get処理年月());
        parameter.setシステム日付(RDateTime.now());
        return loopBatch(SaishinsaMoshitateDoIchiranhyoSakuseiProcess.class).arguments(parameter).define();
    }

    /**
     * DB更新です。
     *
     * @return SaishinsaMoshitateDoDBKoushinProcess
     */
    @Step(DB更新)
    protected IBatchFlowCommand callDoDBKoushinProcess() {
        return loopBatch(SaishinsaMoshitateDoDBKoushinProcess.class).arguments(parameter).define();
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
        parameter.setエラーリストタイプ(KokuhorenJoho_SakuseiErrorListType.リストタイプ5);
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
                // TODO QA1449
                list.add(entry.getSharedFileName().toRString());
            }
            param.setFileNameList(list);
        }
        return param;
    }
}
