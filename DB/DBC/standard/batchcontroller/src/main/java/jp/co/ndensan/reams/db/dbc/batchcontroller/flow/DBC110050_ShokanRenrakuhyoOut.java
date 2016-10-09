/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110050.GetPanTeiToDaiSyou2Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110050.GetPanTeiToDaiSyouProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110050.ShokanRenrakuhyoOutGetHokenshaNoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110050.ShokanRenrakuhyoOutGetSofuDataProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110050.ShokanRenrakuhyoOutHihokenshaHanteiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110050.ShokanRenrakuhyoOutHokenshaTorikomiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110050.ShokanRenrakuhyoOutInsFukushiYoguTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110050.ShokanRenrakuhyoOutInsJutakuTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110050.ShokanRenrakuhyoOutInsKeikakuTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110050.ShokanRenrakuhyoOutInsKihonTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110050.ShokanRenrakuhyoOutInsMeisaiJutokuTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110050.ShokanRenrakuhyoOutInsMeisaiTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110050.ShokanRenrakuhyoOutInsShafukuTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110050.ShokanRenrakuhyoOutInsShisetsuRyoyoTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110050.ShokanRenrakuhyoOutInsShokujiTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110050.ShokanRenrakuhyoOutInsShoteiShikkanTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110050.ShokanRenrakuhyoOutInsShukeiTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110050.ShokanRenrakuhyoOutInsTokubetsuRyoyohiTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110050.ShokanRenrakuhyoOutInsTokuteiNyushoTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110050.ShokanRenrakuhyoOutInsTokuteiShiryohiTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110050.ShokanRenrakuhyoOutSofuFileSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110050.ShokanRenrakuhyoOutputReport2Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110050.ShokanRenrakuhyoOutputReportProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110050.ShokanRenrakuhyoUpdateDB2Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110050.ShokanRenrakuhyoUpdateDBProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.HokenshaKyufujissekiOutDoErrorProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.HokenshaKyufujissekiOutGetBeforeKanyuYMDProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.HokenshaKyufujissekiOutGetHihokenshaAtenaProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.HokenshaKyufujissekiOutGetHihokenshaNameProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.HokenshaKyufujissekiOutGetHihokenshaNoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.HokenshaKyufujissekiOutGetOldHihokenshaNoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.HokenshaKyufujissekiOutListSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.HokenshaKyufujissekiOutSetHihokenshaNoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDoInterfaceKanriKousinProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110050.DBC110050_ShokanRenrakuhyoOutParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_SakuseiErrorListType;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc110050.ShokanRenrakuhyoOutProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc110050.ShokanRenrakuhyoOutputReportProcessParam;
import jp.co.ndensan.reams.db.dbc.definition.processprm.hokenshakyufujissekiout.HokenshaKyufujissekiOutGetHihokenshaNoProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.hokenshakyufujissekiout.HokenshaKyufujissekiOutListSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.FlowEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.HokenshaNoShutokuEntity;
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
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還連絡票情報作成のバッチFlowです。
 *
 * @reamsid_L DBC-2570-030 wangxue
 */
public class DBC110050_ShokanRenrakuhyoOut extends BatchFlowBase<DBC110050_ShokanRenrakuhyoOutParameter> {

    private static final String 送付対象データ取得 = "getSofuData";
    private static final String 被保険者の判定 = "doHihokenshaHentei";
    private static final String 受給者台帳の取得更新 = "getJyukyushaDaicho";
    private static final String 受給者の判定 = "jyukyushaDaichoHentei";
    private static final String 被保険者番号変換対象データの取得 = "getHihokenshaNoDataInformation";
    private static final String 広域加入日以前のデータを取得 = "getHihokenshaNoBeforeKanyuYMDData";
    private static final String 保険者番号の設定 = "setHihokenshaNo";
    private static final String 旧被保険者番号の取得 = "getOldHihokenshaNo";
    private static final String 保険者名の取得 = "getHihokenshaName";
    private static final String 保険者番号取込 = "doHokenshaToriKomi";
    private static final String 被保険者_宛名情報取得 = "getHihokenshaAtena";
    private static final String エラー登録 = "doError";
    private static final String 保険者番号の取得 = "getHokenshaNo";
    private static final String 償還払請求基本の取得 = "insKihonTempProcess";
    private static final String 償還払請求明細の取得 = "insMeisaiTempProcess";
    private static final String 住所地特例の取得 = "insMeisaiJutokuTempProcess";
    private static final String 緊急時施設療養の取得 = "insShisetsuRyoyoTempProcess";
    private static final String 所定疾患施設療養費等の取得 = "insShoteiShikkanTempProcess";
    private static final String 特定診療費の取得 = "insTokuteiShiryohiTempProcess";
    private static final String 特定診療費_特別療養費の取得 = "insTokubetsuRyoyohiTempProcess";
    private static final String 食事費用の取得 = "insShokujiTempProcess";
    private static final String サービス計画の取得 = "insKeikakuTempProcess";
    private static final String 福祉用具販売費の取得 = "insFukushiYoguTempProcess";
    private static final String 住宅改修の取得 = "insJutakuTempProcess";
    private static final String 償還払請求集計の取得 = "insShukeiTempProcess";
    private static final String 特定入所者介護サービス費用の取得 = "insTokuteiNyushoTempProcess";
    private static final String 社会福祉法人軽減額の取得 = "insShafukuTempProcess";
    private static final String 送付ファイル作成 = "doSofuFileSakusei";
    private static final String 帳票出力_送付済 = "outputReportSofusumi";
    private static final String 帳票出力_未送付 = "outputReportMiSofu";
    private static final String DB更新_送付済 = "updateDBSofusumi";
    private static final String DB更新_未送付 = "updateDBMiSofu";
    private static final String 国保連インタフェース管理更新 = "kokuhorenkyoutsuDoInterfaceKanriKousinProcess";
    private static final String 処理結果リスト作成 = "kokuhorenkyoutsuDoShoriKekkaListSakuseiProcess";
    private static final int INDEX_0 = 0;
    private static final RString MSG_導入形態コード = new RString("導入形態コード");
    private static final RString MSG_被保険者番号変換基準日の取得 = new RString("被保険者番号変換基準日の取得");
    private FlowEntity flowEntity;
    private DonyuKeitaiCode 導入形態コード;
    private FlexibleDate 変換基準日;

    private ShokanRenrakuhyoOutProcessParameter processParameter;
    private List<SharedFileDescriptor> エントリ情報List;
    private int 総出力件数;

    @Override
    protected void initialize() {
        総出力件数 = INDEX_0;
        エントリ情報List = new ArrayList<>();
        processParameter = new ShokanRenrakuhyoOutProcessParameter();
        processParameter.set再処理区分(getParameter().get再処理区分());
        processParameter.set処理年月(new FlexibleYearMonth(getParameter().get処理年月().toDateString()));
    }

    @Override
    protected void defineFlow() {
        executeStep(送付対象データ取得);
        int 送付対象取得合計 = getResult(Integer.class, new RString(送付対象データ取得), ShokanRenrakuhyoOutGetSofuDataProcess.PARAMETER_OUT_OUTCOUNT);
        if (送付対象取得合計 != INDEX_0) {
            executeStep(被保険者の判定);
            executeStep(受給者台帳の取得更新);
            executeStep(受給者の判定);
            getCityVillagesInformation();
            getHihokenshaNoTimeInformation();
            transFlow();
            executeStep(保険者名の取得);
            executeStep(保険者番号取込);
            executeStep(被保険者_宛名情報取得);
            executeStep(エラー登録);
            executeStep(保険者番号の取得);
            List<HokenshaNoShutokuEntity> 保険者番号list = (ArrayList<HokenshaNoShutokuEntity>) getResult(List.class, new RString(保険者番号の取得),
                    ShokanRenrakuhyoOutGetHokenshaNoProcess.PARAMETER_OUT_OUTHOKENSHANO);
            for (HokenshaNoShutokuEntity entity : 保険者番号list) {
                processParameter.set保険者番号(entity.getHokenshaNo());
                processParameter.set件数(entity.getCount());
                executeStep(償還払請求基本の取得);
                executeStep(償還払請求明細の取得);
                executeStep(住所地特例の取得);
                executeStep(緊急時施設療養の取得);
                executeStep(所定疾患施設療養費等の取得);
                executeStep(特定診療費の取得);
                executeStep(特定診療費_特別療養費の取得);
                executeStep(食事費用の取得);
                executeStep(サービス計画の取得);
                executeStep(福祉用具販売費の取得);
                executeStep(住宅改修の取得);
                executeStep(償還払請求集計の取得);
                executeStep(特定入所者介護サービス費用の取得);
                executeStep(社会福祉法人軽減額の取得);
                executeStep(送付ファイル作成);
                総出力件数 = 総出力件数 + getResult(Integer.class, new RString(送付ファイル作成),
                        ShokanRenrakuhyoOutSofuFileSakuseiProcess.PARAMETER_OUT_OUTCOUNT);
                List<SharedFileDescriptor> list = getResult(List.class, new RString(送付ファイル作成),
                        ShokanRenrakuhyoOutSofuFileSakuseiProcess.PARANETER_OUT_OUTPUTENTITY);
                if (list != null && list.size() > INDEX_0) {
                    エントリ情報List.add(list.get(INDEX_0));
                }
            }
            executeStep(帳票出力_送付済);
            executeStep(帳票出力_未送付);
            executeStep(DB更新_送付済);
            executeStep(DB更新_未送付);
        }
        executeStep(国保連インタフェース管理更新);
        executeStep(処理結果リスト作成);
    }

    /**
     * 新旧被保険者番号変換です。
     */
    private void transFlow() {
        if (変換基準日.isEmpty()) {
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
     * 送付対象データ取得です。
     *
     * @return ShokanRenrakuhyoOutGetSofuDataProcess
     */
    @Step(送付対象データ取得)
    protected IBatchFlowCommand getSofuData() {
        return loopBatch(ShokanRenrakuhyoOutGetSofuDataProcess.class).arguments(processParameter).define();
    }

    /**
     * 被保険者の判定です。
     *
     * @return ShokanRenrakuhyoOutHihokenshaHanteiProcess
     */
    @Step(被保険者の判定)
    protected IBatchFlowCommand doHihokenshaHentei() {
        return loopBatch(ShokanRenrakuhyoOutHihokenshaHanteiProcess.class).define();
    }

    /**
     * 受給者台帳の取得更新です。
     *
     * @return GetPanTeiToDaiSyouProcess
     */
    @Step(受給者台帳の取得更新)
    protected IBatchFlowCommand getJyukyushaDaicho() {
        return loopBatch(GetPanTeiToDaiSyouProcess.class).define();
    }

    /**
     * 受給者の判定です。
     *
     * @return GetPanTeiToDaiSyouProcess
     */
    @Step(受給者の判定)
    protected IBatchFlowCommand jyukyushaDaichoHentei() {
        return loopBatch(GetPanTeiToDaiSyou2Process.class).define();
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
     * @return ShokanRenrakuhyoOutHokenshaTorikomiProcess
     */
    @Step(保険者番号取込)
    protected IBatchFlowCommand doHokenshaToriKomi() {
        return loopBatch(ShokanRenrakuhyoOutHokenshaTorikomiProcess.class).define();
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
     * 保険者番号の取得です。
     *
     * @return ShokanRenrakuhyoOutGetHokenshaNoProcess
     */
    @Step(保険者番号の取得)
    protected IBatchFlowCommand getHokenshaNo() {
        return loopBatch(ShokanRenrakuhyoOutGetHokenshaNoProcess.class).define();
    }

    /**
     * 償還払請求基本の取得です。
     *
     * @return ShokanRenrakuhyoOutInsKihonTempProcess
     */
    @Step(償還払請求基本の取得)
    protected IBatchFlowCommand insKihonTempProcess() {
        return loopBatch(ShokanRenrakuhyoOutInsKihonTempProcess.class).arguments(processParameter).define();
    }

    /**
     * 償還払請求明細の取得です。
     *
     * @return ShokanRenrakuhyoOutInsMeisaiTempProcess
     */
    @Step(償還払請求明細の取得)
    protected IBatchFlowCommand insMeisaiTempProcess() {
        return loopBatch(ShokanRenrakuhyoOutInsMeisaiTempProcess.class).arguments(processParameter).define();
    }

    /**
     * 住所地特例の取得です。
     *
     * @return ShokanRenrakuhyoOutInsMeisaiJutokuTempProcess
     */
    @Step(住所地特例の取得)
    protected IBatchFlowCommand insMeisaiJutokuTempProcess() {
        return loopBatch(ShokanRenrakuhyoOutInsMeisaiJutokuTempProcess.class).arguments(processParameter).define();
    }

    /**
     * 緊急時施設療養の取得の取得です。
     *
     * @return ShokanRenrakuhyoOutInsShisetsuRyoyoTempProcess
     */
    @Step(緊急時施設療養の取得)
    protected IBatchFlowCommand insShisetsuRyoyoTempProcess() {
        return loopBatch(ShokanRenrakuhyoOutInsShisetsuRyoyoTempProcess.class).arguments(processParameter).define();
    }

    /**
     * 所定疾患施設療養費等の取得です。
     *
     * @return ShokanRenrakuhyoOutInsShoteiShikkanTempProcess
     */
    @Step(所定疾患施設療養費等の取得)
    protected IBatchFlowCommand insShoteiShikkanTempProcess() {
        return loopBatch(ShokanRenrakuhyoOutInsShoteiShikkanTempProcess.class).arguments(processParameter).define();
    }

    /**
     * 特定診療費の取得です。
     *
     * @return ShokanRenrakuhyoOutInsTokuteiShiryohiTempProcess
     */
    @Step(特定診療費の取得)
    protected IBatchFlowCommand insTokuteiShiryohiTempProcess() {
        return loopBatch(ShokanRenrakuhyoOutInsTokuteiShiryohiTempProcess.class).arguments(processParameter).define();
    }

    /**
     * 特定診療費_特別療養費の取得です。
     *
     * @return ShokanRenrakuhyoOutInsTokubetsuRyoyohiTempProcess
     */
    @Step(特定診療費_特別療養費の取得)
    protected IBatchFlowCommand insTokubetsuRyoyohiTempProcess() {
        return loopBatch(ShokanRenrakuhyoOutInsTokubetsuRyoyohiTempProcess.class).arguments(processParameter).define();
    }

    /**
     * 食事費用の取得です。
     *
     * @return ShokanRenrakuhyoOutInsShokujiTempProcess
     */
    @Step(食事費用の取得)
    protected IBatchFlowCommand insShokujiTempProcess() {
        return loopBatch(ShokanRenrakuhyoOutInsShokujiTempProcess.class).arguments(processParameter).define();
    }

    /**
     * サービス計画の取得です。
     *
     * @return ShokanRenrakuhyoOutInsKeikakuTempProcess
     */
    @Step(サービス計画の取得)
    protected IBatchFlowCommand insKeikakuTempProcess() {
        return loopBatch(ShokanRenrakuhyoOutInsKeikakuTempProcess.class).arguments(processParameter).define();
    }

    /**
     * 福祉用具販売費の取得です。
     *
     * @return ShokanRenrakuhyoOutInsFukushiYoguTempProcess
     */
    @Step(福祉用具販売費の取得)
    protected IBatchFlowCommand insFukushiYoguTempProcess() {
        return loopBatch(ShokanRenrakuhyoOutInsFukushiYoguTempProcess.class).arguments(processParameter).define();
    }

    /**
     * 住宅改修の取得です。
     *
     * @return ShokanRenrakuhyoOutInsJutakuTempProcess
     */
    @Step(住宅改修の取得)
    protected IBatchFlowCommand insJutakuTempProcess() {
        return loopBatch(ShokanRenrakuhyoOutInsJutakuTempProcess.class).arguments(processParameter).define();
    }

    /**
     * 償還払請求集計の取得です。
     *
     * @return ShokanRenrakuhyoOutInsShukeiTempProcess
     */
    @Step(償還払請求集計の取得)
    protected IBatchFlowCommand insShukeiTempProcess() {
        return loopBatch(ShokanRenrakuhyoOutInsShukeiTempProcess.class).arguments(processParameter).define();
    }

    /**
     * 特定入所者介護サービス費用の取得です。
     *
     * @return ShokanRenrakuhyoOutInsTokuteiNyushoTempProcess
     */
    @Step(特定入所者介護サービス費用の取得)
    protected IBatchFlowCommand insTokuteiNyushoTempProcess() {
        return loopBatch(ShokanRenrakuhyoOutInsTokuteiNyushoTempProcess.class).arguments(processParameter).define();
    }

    /**
     * 社会福祉法人軽減額の取得です。
     *
     * @return ShokanRenrakuhyoOutInsShafukuTempProcess
     */
    @Step(社会福祉法人軽減額の取得)
    protected IBatchFlowCommand insShafukuTempProcess() {
        return loopBatch(ShokanRenrakuhyoOutInsShafukuTempProcess.class).arguments(processParameter).define();
    }

    /**
     * 送付ファイル作成です。
     *
     * @return ShokanRenrakuhyoOutSofuFileSakuseiProcess
     */
    @Step(送付ファイル作成)
    protected IBatchFlowCommand doSofuFileSakusei() {
        return loopBatch(ShokanRenrakuhyoOutSofuFileSakuseiProcess.class).arguments(processParameter).define();
    }

    /**
     * 帳票出力_送付済です。
     *
     * @return ShokanRenrakuhyoOutSofuFileSakuseiProcess
     */
    @Step(帳票出力_送付済)
    protected IBatchFlowCommand outputReportSofusumi() {
        ShokanRenrakuhyoOutputReportProcessParam parameter
                = new ShokanRenrakuhyoOutputReportProcessParam(new FlexibleYearMonth(getParameter().get処理年月().toDateString()),
                        new Long(getParameter().get出力順ID().toString()));
        return loopBatch(ShokanRenrakuhyoOutputReportProcess.class).arguments(parameter).define();
    }

    /**
     * 帳票出力_未送付です。
     *
     * @return ShokanRenrakuhyoOutSofuFileSakuseiProcess
     */
    @Step(帳票出力_未送付)
    protected IBatchFlowCommand outputReportMiSofu() {
        ShokanRenrakuhyoOutputReportProcessParam parameter
                = new ShokanRenrakuhyoOutputReportProcessParam(new FlexibleYearMonth(getParameter().get処理年月().toDateString()),
                        new Long(getParameter().get出力順ID().toString()));
        return loopBatch(ShokanRenrakuhyoOutputReport2Process.class).arguments(parameter).define();
    }

    /**
     * DB更新_送付済です。
     *
     * @return ShokanRenrakuhyoOutSofuFileSakuseiProcess
     */
    @Step(DB更新_送付済)
    protected IBatchFlowCommand updateDBSofusumi() {
        ShokanRenrakuhyoOutputReportProcessParam parameter
                = new ShokanRenrakuhyoOutputReportProcessParam(new FlexibleYearMonth(getParameter().get処理年月().toDateString()),
                        new Long(getParameter().get出力順ID().toString()));
        return loopBatch(ShokanRenrakuhyoUpdateDBProcess.class).arguments(parameter).define();
    }

    /**
     * DB更新_未送付です。
     *
     * @return ShokanRenrakuhyoOutSofuFileSakuseiProcess
     */
    @Step(DB更新_未送付)
    protected IBatchFlowCommand updateDBMiSofu() {
        ShokanRenrakuhyoOutputReportProcessParam parameter
                = new ShokanRenrakuhyoOutputReportProcessParam(new FlexibleYearMonth(getParameter().get処理年月().toDateString()),
                        new Long(getParameter().get出力順ID().toString()));
        return loopBatch(ShokanRenrakuhyoUpdateDB2Process.class).arguments(parameter).define();
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
        FlexibleYearMonth 処理年月 = new FlexibleYearMonth(getParameter().get処理年月().toDateString());
        param.set処理年月(処理年月);
        RString 交換情報識別番号 = DbBusinessConfig.get(ConfigNameDBC.国保連送付_償還連絡票情報_交換情報識別番号,
                RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        param.set交換情報識別番号(交換情報識別番号);
        param.set処理対象年月(処理年月);
        if (総出力件数 == INDEX_0) {
            param.setレコード件数合計(INDEX_0);
            param.setFileNameList(Collections.EMPTY_LIST);
        } else {
            param.setレコード件数合計(INDEX_0);
            List<RString> fileNameList = new ArrayList<>();
            for (SharedFileDescriptor entity : エントリ情報List) {
                fileNameList.add(entity.getSharedFileName().toRString());
            }
            param.setFileNameList(fileNameList);
        }
        return param;
    }

}
