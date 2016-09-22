/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.HokenshaKyufujissekiOutGetBeforeKanyuYMDProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.HokenshaKyufujissekiOutGetHihokenshaNameProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.HokenshaKyufujissekiOutGetHihokenshaNoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.HokenshaKyufujissekiOutGetOldHihokenshaNoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130.HokenshaKyufujissekiOutSetHihokenshaNoProcess;
import jp.co.ndensan.reams.db.dbc.definition.processprm.hokenshakyufujissekiout.HokenshaKyufujissekiOutGetHihokenshaNoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.FlowEntity;
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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 国保連情報作成共通処理（新旧被保険者番号変換）クラスです
 *
 * @reamsid_L DBC-2460-012 jiangwenkai
 */
public class HokenshaKyufujissekiOutChangeHihokenshaNoFlow extends BatchFlowBase {

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

    @Override
    protected void defineFlow() {
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

}
