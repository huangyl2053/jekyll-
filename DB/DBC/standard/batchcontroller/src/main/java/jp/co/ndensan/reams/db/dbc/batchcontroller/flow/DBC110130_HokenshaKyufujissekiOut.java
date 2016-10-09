/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.DelDataRecordTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.HokenshaKyufujissekiGetJigyoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.HokenshaKyufujissekiGetShikibetProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.HokenshaKyufujissekiOutDoErrorProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.HokenshaKyufujissekiOutGetBeforeKanyuYMDProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.HokenshaKyufujissekiOutGetHihokenshaAtenaProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.HokenshaKyufujissekiOutGetHihokenshaNameProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.HokenshaKyufujissekiOutGetHihokenshaNoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.HokenshaKyufujissekiOutGetOldHihokenshaNoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.HokenshaKyufujissekiOutListSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.HokenshaKyufujissekiOutSetHihokenshaNoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.HokenshaKyufujissekiReadDataProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.HokenshaKyufujissekiReadKongakuDataProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.HokenshaKyufujissekiReprotProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.InsDataRecordTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.InsFukushiYoguTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.InsJutakuTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.InsJutokuTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.InsKihonTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.InsKinkyujiTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.InsKogakuTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.InsKyotakuTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.InsMeisaiTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.InsShafukuTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.InsShokujiTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.InsShoteiShikkanTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.InsShukeiTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.InsTokubetsuRyoyohiTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.InsTokuteiShiryohiTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.InsTokuteiTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.KyufujissekiKihonSyuuyakuDoKeyGakuninProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.KyufujissekiKihonSyuuyakuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.KyufujissekiKihonSyuuyakuShinsaYMGakuninProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.KyufujissekiKongakuSyuuyakuDoKeyGakuninProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.KyufujissekiKongakuSyuuyakuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.KyufujissekiKongakuSyuuyakuShinsaYMGakuninProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.KyufujissekiNoShikibetsuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.KyufujissekiSetteiKunbunProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.UpdDataRecordTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110130.HihokenshaToKyufuKihonProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110130.HihokenshaToKyufuKogakuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.kokuhorenkyoutsu.KokuhorenkyoutsuDoInterfaceKanriKousinProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110130.DBC110130_HokenshaKyufujissekiOutParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_SakuseiErrorListType;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhoreninterface.ConfigKeysKokuhorenSofu;
import jp.co.ndensan.reams.db.dbc.definition.processprm.hokenshakyufujisseki.HokenshaKyufujissekiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.hokenshakyufujissekiout.HokenshaKyufujissekiOutGetHihokenshaNoProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.hokenshakyufujissekiout.HokenshaKyufujissekiOutListSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kokuhorenkyotsu.KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.FlowEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hokenshakyufujisseki.IHokenshaKyufujissekiMapper;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.KaigoDonyuKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.gappeijoho.gappeijoho.GappeiCityJohoBFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 保険者保有給付実績情報作成のバッチflowです。
 *
 * @reamsid_L DBC-2460-010 gongliang
 */
public class DBC110130_HokenshaKyufujissekiOut extends BatchFlowBase<DBC110130_HokenshaKyufujissekiOutParameter> {

    private static final String 送付対象データ取得_基本 = "callGetDataKihonProcess";
    private static final String 送付対象データ取得_高額 = "callGetDataKongakuProcess";
    private static final String 給付実績データ_基本集約_同一キー確認 = "kyufujissekiKihonSyuuyakuDoKeyGakunin";
    private static final String 給付実績データ_基本集約_審査年月確認 = "kyufujissekiKihonSyuuyakuShinsaYMGakunin";
    private static final String 給付実績データ_基本集約 = "kyufujissekiKihonSyuuyaku";
    private static final String 給付実績データ_高額集約_同一キー確認 = "kyufujissekiKongakuSyuuyakuDoKeyGakunin";
    private static final String 給付実績データ_高額集約_審査年月確認 = "kyufujissekiKongakuSyuuyakuShinsaYMGakunin";
    private static final String 給付実績データ_高額集約 = "kyufujissekiKongakuSyuuyaku";
    private static final String 変換結果取込_高額 = "hihokenshaToKyufuKogaku";
    private static final String 変換結果取込_基本 = "hihokenshaToKyufuKihon";
    private static final String 設定区分の取得 = "kyufujissekiSetteiKunbun";
    private static final String 識別番号がない給付基本があれば_エラー = "kyufujissekiNoShikibetsuProcess";
    private static final String 基本データの取得 = "insKihonTempProcess";
    private static final String 明細データの取得 = "insMeisaiTempProcess";
    private static final String 緊急時施設療養データの取得 = "insKinkyujiTempProcess";
    private static final String 所定疾患施設療養費等データの取得 = "insShoteiShikkanTempProcess";
    private static final String 特定診療費データの取得 = "insTokuteiShiryohiTempProcess";
    private static final String 特定診療費_特別療養費データの取得 = "insTokubetsuRyoyohiTempProcess";
    private static final String 食事費用データの取得 = "insShokujiTempProcess";
    private static final String 居宅サービス計画費データの取得 = "insKyotakuTempProcess";
    private static final String 福祉用具販売費データの取得 = "insFukushiYoguTempProcess";
    private static final String 住宅改修費データの取得 = "insJutakuTempProcess";
    private static final String 集計データの取得 = "insShukeiTempProcess";
    private static final String 特定入所者介護サービス費用データの取得 = "insTokuteiTempProcess";
    private static final String 社会福祉法人軽減額データの取得 = "insShafukuTempProcess";
    private static final String 明細_住所地特例データの取得 = "insJutokuTempProcess";
    private static final String 高額一時データデータの取得 = "insKogakuTempProcess";
    private static final String 送付ファイル作成 = "insDataRecordTempProcess";
    private static final String 事業者名称取得 = "hokenshaKyufujissekiGetJigyoProcess";
    private static final String 入力識別名称取得 = "hokenshaKyufujissekiGetShikibetProcess";
    private static final String 帳票出力 = "hokenshaKyufujissekiReprotProcess";
    private static final String 給付実績基本と各TBL更新 = "updDataRecordTempProcess";
    private static final String 給付実績基本と各TBL削除 = "delDataRecordTempProcess";

    private static final String 国保連インタフェース管理更新 = "kokuhorenkyoutsuDoInterfaceKanriKousinProcess";
    private static final String 処理結果リスト作成 = "kokuhorenkyoutsuDoShoriKekkaListSakuseiProcess";

    private static final String 被保険者番号変換対象データの取得 = "getHihokenshaNoDataInformation";
    private static final String 広域加入日以前のデータを取得 = "getHihokenshaNoBeforeKanyuYMDData";
    private static final String 保険者番号の設定 = "setHihokenshaNo";
    private static final String 旧被保険者番号の取得 = "getOldHihokenshaNo";
    private static final String 保険者名の取得 = "getHihokenshaName";
    private static final RString MSG_導入形態コード = new RString("導入形態コード");
    private static final RString MSG_被保険者番号変換基準日の取得 = new RString("被保険者番号変換基準日の取得");

    private static final String 被保険者_宛名情報取得 = "getHihokenshaAtena";
    private static final String エラー登録 = "doError";
    private FlowEntity flowEntity;
    private DonyuKeitaiCode 導入形態コード;
    private FlexibleDate 変換基準日;
    private int 総出力件数;
    private List<SharedFileDescriptor> エントリ情報List;

    private static final RString データがある = new RString("1");
    private static final RString 再処理区分_1 = new RString("1");
    private static final int INT_0 = 0;

    private HokenshaKyufujissekiProcessParameter processParameter;

    @Override
    protected void initialize() {
        総出力件数 = INT_0;
        エントリ情報List = new ArrayList<>();
        processParameter = getParameter().toHokenshaKyufujissekiProcessParameter(YMDHMS.now());
        RDate date = processParameter.getNow().getDate();
        RString 国保連共同処理受託区分_償還 = DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_償還, date, SubGyomuCode.DBC介護給付);
        RString 国保連共同処理受託区分_高額 = DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_高額, date, SubGyomuCode.DBC介護給付);
        processParameter.set国保連共同処理受託区分_償還(国保連共同処理受託区分_償還);
        processParameter.set国保連共同処理受託区分_高額(国保連共同処理受託区分_高額);
    }

    @Override
    protected void defineFlow() {
        executeStep(送付対象データ取得_基本);
        int 基本件数 = getResult(Integer.class, new RString(送付対象データ取得_基本), HokenshaKyufujissekiReadDataProcess.PARAMETER_OUT_件数);
        processParameter.set基本件数(基本件数);
        executeStep(送付対象データ取得_高額);
        if (データがある.equals(getResult(RString.class,
                new RString(送付対象データ取得_高額), HokenshaKyufujissekiReadKongakuDataProcess.PARAMETER_OUT_FLOWFLAG))) {
            if (再処理区分_1.equals(getParameter().getSaishoriKubun())) {
                executeStep(給付実績データ_基本集約_同一キー確認);
                executeStep(給付実績データ_基本集約_審査年月確認);
                executeStep(給付実績データ_基本集約);
                executeStep(給付実績データ_高額集約_同一キー確認);
                executeStep(給付実績データ_高額集約_審査年月確認);
                executeStep(給付実績データ_高額集約);
            }
            call新旧被保険者番号変換();
            executeStep(変換結果取込_基本);
            executeStep(変換結果取込_高額);
            call被保険者_宛名情報取得();
            executeStep(設定区分の取得);
            executeStep(識別番号がない給付基本があれば_エラー);
            List<HokenshaNo> 保険者番号List
                    = InstanceProvider.create(MapperProvider.class).create(IHokenshaKyufujissekiMapper.class).get保険者番号();
            call送付ファイル作成(保険者番号List);
            executeStep(事業者名称取得);
            executeStep(入力識別名称取得);
            executeStep(帳票出力);
            executeStep(給付実績基本と各TBL更新);
            executeStep(給付実績基本と各TBL削除);
        }
        executeStep(国保連インタフェース管理更新);
        executeStep(処理結果リスト作成);
    }

    private void call送付ファイル作成(List<HokenshaNo> 保険者番号List) {
        for (HokenshaNo 保険者番号 : 保険者番号List) {
            processParameter.set保険者番号(保険者番号);
            executeStep(基本データの取得);
            executeStep(明細データの取得);
            executeStep(緊急時施設療養データの取得);
            executeStep(所定疾患施設療養費等データの取得);
            executeStep(特定診療費データの取得);
            executeStep(特定診療費_特別療養費データの取得);
            executeStep(食事費用データの取得);
            executeStep(居宅サービス計画費データの取得);
            executeStep(福祉用具販売費データの取得);
            executeStep(住宅改修費データの取得);
            executeStep(集計データの取得);
            executeStep(特定入所者介護サービス費用データの取得);
            executeStep(社会福祉法人軽減額データの取得);
            executeStep(明細_住所地特例データの取得);
            executeStep(高額一時データデータの取得);
            executeStep(送付ファイル作成);
            int 件数 = getResult(
                    Integer.class, new RString(送付ファイル作成), InsDataRecordTempProcess.PARAMETER_OUT_OUTPUTCOUNT);
            List<SharedFileDescriptor> エントリ情報 = (ArrayList<SharedFileDescriptor>) getResult(
                    List.class, new RString(送付ファイル作成), InsDataRecordTempProcess.PARAMETER_OUT_OUTPUTENTRY);
            エントリ情報List.add(エントリ情報.get(INT_0));
            総出力件数 = 総出力件数 + 件数;
        }
    }

    /**
     * 送付対象データ_基本取得操作です。
     *
     * @return IBatchFlowCommand
     */
    @Step(送付対象データ取得_基本)
    protected IBatchFlowCommand callGetDataKihonProcess() {
        return loopBatch(HokenshaKyufujissekiReadDataProcess.class).arguments(processParameter).define();
    }

    /**
     * 送付対象データ_高額取得操作です。
     *
     * @return IBatchFlowCommand
     */
    @Step(送付対象データ取得_高額)
    protected IBatchFlowCommand callGetDataKongakuProcess() {
        return loopBatch(HokenshaKyufujissekiReadKongakuDataProcess.class).arguments(processParameter).define();
    }

    /**
     * 給付実績基本一時データの同一キー確認操作です。
     *
     * @return IBatchFlowCommand
     */
    @Step(給付実績データ_基本集約_同一キー確認)
    protected IBatchFlowCommand callKyufujissekiKihonSyuuyakuDoKeyGakuninProcess() {
        return loopBatch(KyufujissekiKihonSyuuyakuDoKeyGakuninProcess.class).define();
    }

    /**
     * 給付実績基本一時データの審査年月確認操作です。
     *
     * @return IBatchFlowCommand
     */
    @Step(給付実績データ_基本集約_審査年月確認)
    protected IBatchFlowCommand callKyufujissekiKihonSyuuyakuShinsaYMGakuninProcess() {
        return loopBatch(KyufujissekiKihonSyuuyakuShinsaYMGakuninProcess.class).define();
    }

    /**
     * 給付実績基本一時データの集約操作です。
     *
     * @return IBatchFlowCommand
     */
    @Step(給付実績データ_基本集約)
    protected IBatchFlowCommand callKyufujissekiKihonSyuuyakuProcess() {
        return loopBatch(KyufujissekiKihonSyuuyakuProcess.class).define();
    }

    /**
     * 給付実績高額一時データの同一キー確認操作です。
     *
     * @return IBatchFlowCommand
     */
    @Step(給付実績データ_高額集約_同一キー確認)
    protected IBatchFlowCommand callKyufujissekiKongakuSyuuyakuDoKeyGakuninProcess() {
        return loopBatch(KyufujissekiKongakuSyuuyakuDoKeyGakuninProcess.class).define();
    }

    /**
     * 給付実績高額一時データの審査年月確認操作です。
     *
     * @return IBatchFlowCommand
     */
    @Step(給付実績データ_高額集約_審査年月確認)
    protected IBatchFlowCommand callKyufujissekiKongakuSyuuyakuShinsaYMGakuninProcess() {
        return loopBatch(KyufujissekiKongakuSyuuyakuShinsaYMGakuninProcess.class).define();
    }

    /**
     * 給付実績高額一時データの集約操作です。
     *
     * @return IBatchFlowCommand
     */
    @Step(給付実績データ_高額集約)
    protected IBatchFlowCommand callKyufujissekiKongakuSyuuyakuProcess() {
        return loopBatch(KyufujissekiKongakuSyuuyakuProcess.class).define();
    }

    /**
     * 変換結果取込_基本操作です。
     *
     * @return IBatchFlowCommand
     */
    @Step(変換結果取込_基本)
    protected IBatchFlowCommand callHihokenshaToKyufuKihonProcess() {
        return loopBatch(HihokenshaToKyufuKihonProcess.class).define();
    }

    /**
     * 変換結果取込_高額操作です。
     *
     * @return IBatchFlowCommand
     */
    @Step(変換結果取込_高額)
    protected IBatchFlowCommand callHihokenshaToKyufuKogakuProcess() {
        return loopBatch(HihokenshaToKyufuKogakuProcess.class).define();
    }

    /**
     * 設定区分の取得操作です。
     *
     * @return IBatchFlowCommand
     */
    @Step(設定区分の取得)
    protected IBatchFlowCommand callKyufujissekiSetteiKunbunProcess() {
        return loopBatch(KyufujissekiSetteiKunbunProcess.class).define();
    }

    /**
     * 設定区分の取得操作です。
     *
     * @return IBatchFlowCommand
     */
    @Step(識別番号がない給付基本があれば_エラー)
    protected IBatchFlowCommand callKyufujissekiNoShikibetsuProcess() {
        return loopBatch(KyufujissekiNoShikibetsuProcess.class).define();
    }

    /**
     * 基本データの取得操作です。
     *
     * @return IBatchFlowCommand
     */
    @Step(基本データの取得)
    protected IBatchFlowCommand callInsKihonTempProcess() {
        return loopBatch(InsKihonTempProcess.class).arguments(processParameter).define();
    }

    /**
     * 明細データの取得操作です。
     *
     * @return IBatchFlowCommand
     */
    @Step(明細データの取得)
    protected IBatchFlowCommand callInsMeisaiTempProcess() {
        return loopBatch(InsMeisaiTempProcess.class).arguments(processParameter).define();
    }

    /**
     * 緊急時施設療養データの取得操作です。
     *
     * @return IBatchFlowCommand
     */
    @Step(緊急時施設療養データの取得)
    protected IBatchFlowCommand callInsKinkyujiTempProcess() {
        return loopBatch(InsKinkyujiTempProcess.class).arguments(processParameter).define();
    }

    /**
     * 所定疾患施設療養費等データの取得操作です。
     *
     * @return IBatchFlowCommand
     */
    @Step(所定疾患施設療養費等データの取得)
    protected IBatchFlowCommand callInsShoteiShikkanTempProcess() {
        return loopBatch(InsShoteiShikkanTempProcess.class).arguments(processParameter).define();
    }

    /**
     * 特定診療費データの取得操作です。
     *
     * @return IBatchFlowCommand
     */
    @Step(特定診療費データの取得)
    protected IBatchFlowCommand callInsTokuteiShiryohiTempProcess() {
        return loopBatch(InsTokuteiShiryohiTempProcess.class).arguments(processParameter).define();
    }

    /**
     * 特定診療費_特別療養費データの取得操作です。
     *
     * @return IBatchFlowCommand
     */
    @Step(特定診療費_特別療養費データの取得)
    protected IBatchFlowCommand callInsTokubetsuRyoyohiTempProcess() {
        return loopBatch(InsTokubetsuRyoyohiTempProcess.class).arguments(processParameter).define();
    }

    /**
     * 食事費用データの取得操作です。
     *
     * @return IBatchFlowCommand
     */
    @Step(食事費用データの取得)
    protected IBatchFlowCommand callInsShokujiTempProcess() {
        return loopBatch(InsShokujiTempProcess.class).arguments(processParameter).define();
    }

    /**
     * 居宅サービス計画費データの取得操作です。
     *
     * @return IBatchFlowCommand
     */
    @Step(居宅サービス計画費データの取得)
    protected IBatchFlowCommand callInsKyotakuTempProcess() {
        return loopBatch(InsKyotakuTempProcess.class).arguments(processParameter).define();
    }

    /**
     * 福祉用具販売費データの取得操作です。
     *
     * @return IBatchFlowCommand
     */
    @Step(福祉用具販売費データの取得)
    protected IBatchFlowCommand callInsFukushiYoguTempProcess() {
        return loopBatch(InsFukushiYoguTempProcess.class).arguments(processParameter).define();
    }

    /**
     * 住宅改修費データの取得操作です。
     *
     * @return IBatchFlowCommand
     */
    @Step(住宅改修費データの取得)
    protected IBatchFlowCommand callInsJutakuTempProcess() {
        return loopBatch(InsJutakuTempProcess.class).arguments(processParameter).define();
    }

    /**
     * 集計データの取得操作です。
     *
     * @return IBatchFlowCommand
     */
    @Step(集計データの取得)
    protected IBatchFlowCommand callInsShukeiTempProcess() {
        return loopBatch(InsShukeiTempProcess.class).arguments(processParameter).define();
    }

    /**
     * 特定入所者介護サービス費用データの取得操作です。
     *
     * @return IBatchFlowCommand
     */
    @Step(特定入所者介護サービス費用データの取得)
    protected IBatchFlowCommand callInsTokuteiTempProcess() {
        return loopBatch(InsTokuteiTempProcess.class).arguments(processParameter).define();
    }

    /**
     * 社会福祉法人軽減額データの取得の取得操作です。
     *
     * @return IBatchFlowCommand
     */
    @Step(社会福祉法人軽減額データの取得)
    protected IBatchFlowCommand callInsShafukuTempProcess() {
        return loopBatch(InsShafukuTempProcess.class).arguments(processParameter).define();
    }

    /**
     * 明細_住所地特例データの取得の取得操作です。
     *
     * @return IBatchFlowCommand
     */
    @Step(明細_住所地特例データの取得)
    protected IBatchFlowCommand callInsJutokuTempProcess() {
        return loopBatch(InsJutokuTempProcess.class).arguments(processParameter).define();
    }

    /**
     * 高額一時データデータの取得の取得操作です。
     *
     * @return IBatchFlowCommand
     */
    @Step(高額一時データデータの取得)
    protected IBatchFlowCommand callInsKogakuTempProcess() {
        return loopBatch(InsKogakuTempProcess.class).arguments(processParameter).define();
    }

    /**
     * 送付ファイル作成操作です。
     *
     * @return IBatchFlowCommand
     */
    @Step(送付ファイル作成)
    protected IBatchFlowCommand callInsDataRecordTempProcess() {
        return loopBatch(InsDataRecordTempProcess.class).arguments(processParameter).define();
    }

    /**
     * 事業者名称取得操作です。
     *
     * @return IBatchFlowCommand
     */
    @Step(事業者名称取得)
    protected IBatchFlowCommand callHokenshaKyufujissekiGetJigyoProcess() {
        return loopBatch(HokenshaKyufujissekiGetJigyoProcess.class).define();
    }

    /**
     * 入力識別名称取得操作です。
     *
     * @return IBatchFlowCommand
     */
    @Step(入力識別名称取得)
    protected IBatchFlowCommand callHokenshaKyufujissekiGetShikibetProcess() {
        return loopBatch(HokenshaKyufujissekiGetShikibetProcess.class).define();
    }

    /**
     * 帳票出力操作です。
     *
     * @return IBatchFlowCommand
     */
    @Step(帳票出力)
    protected IBatchFlowCommand callHokenshaKyufujissekiReprotProcess() {
        return loopBatch(HokenshaKyufujissekiReprotProcess.class).arguments(processParameter).define();
    }

    /**
     * 給付実績基本と各TBL更新操作です。
     *
     * @return IBatchFlowCommand
     */
    @Step(給付実績基本と各TBL更新)
    protected IBatchFlowCommand callUpdDataRecordTempProcess() {
        return loopBatch(UpdDataRecordTempProcess.class).arguments(processParameter).define();
    }

    /**
     * 給付実績基本と各TBL削除操作です。
     *
     * @return IBatchFlowCommand
     */
    @Step(給付実績基本と各TBL削除)
    protected IBatchFlowCommand callDelDataRecordTempProcess() {
        return loopBatch(DelDataRecordTempProcess.class).arguments(processParameter).define();
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

    private KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter getParam() {
        KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter param = new KokuhorenkyotsuDoInterfaceKanriKousinProcessParameter();
        param.set処理年月(getParameter().getShoriYM());
        param.set交換情報識別番号(ConfigKeysKokuhorenSofu.給付実績情報.getコード());
        param.set処理対象年月(getParameter().getShoriYM());
        param.setレコード件数合計(総出力件数);
        List<RString> list = new ArrayList<>();
        if (エントリ情報List.isEmpty()) {
            param.setFileNameList(Collections.EMPTY_LIST);
        } else {
            for (SharedFileDescriptor entry : エントリ情報List) {
                list.add(entry.getSharedFileName().toRString());
                param.setFileNameList(list);
            }
        }
        return param;
    }

    /**
     * 処理結果リスト作成操作です。
     *
     * @return IBatchFlowCommand
     */
    @Step(処理結果リスト作成)
    protected IBatchFlowCommand callKokuhorenkyoutsuDoShoriKekkaListSakuseiProcess() {
        HokenshaKyufujissekiOutListSakuseiProcessParameter parameter = new HokenshaKyufujissekiOutListSakuseiProcessParameter();
        parameter.setエラーリストタイプ(KokuhorenJoho_SakuseiErrorListType.リストタイプ3);
        return loopBatch(HokenshaKyufujissekiOutListSakuseiProcess.class).arguments(parameter).define();
    }

    private void call新旧被保険者番号変換() {
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

    private void call被保険者_宛名情報取得() {
        executeStep(被保険者_宛名情報取得);
        executeStep(エラー登録);
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

}
