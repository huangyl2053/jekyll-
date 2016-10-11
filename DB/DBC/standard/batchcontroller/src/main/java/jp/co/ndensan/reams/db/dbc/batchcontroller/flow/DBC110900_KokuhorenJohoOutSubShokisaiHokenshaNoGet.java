/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110900.HihokenshaTempUpdateKouikiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110900.HihokenshaTempUpdateProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110900.DBC110900_KokuhorenJohoOutSubShokisaiHokenshaNoGetParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kakohorenjyohosakusei.HihokenshaTempUpdateProcessParameter;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.KaigoDonyuKubun;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.db.dbz.business.core.gappeijoho.gappeijoho.GappeiCityJyoho;
import jp.co.ndensan.reams.db.dbz.service.core.gappeijoho.gappeijoho.GappeiCityJohoBFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 国保連情報作成共通処理（証記載保険者番号取得）のクラスです。
 *
 * @reamsid_L DBC-2840-031 sunhaidi
 */
public class DBC110900_KokuhorenJohoOutSubShokisaiHokenshaNoGet
        extends BatchFlowBase<DBC110900_KokuhorenJohoOutSubShokisaiHokenshaNoGetParameter> {

    private static final String FLOW_WORK1 = "work1";
    private static final String FLOW_WORK2 = "work2";
    private static final String FLOW_WORK3 = "work3";
    private static final RString 表示有無区分 = new RString("1");
    private HihokenshaTempUpdateProcessParameter loopPrm;

    @Override
    protected void defineFlow() {
        ShichosonSecurityJoho shichosonSecurityJoho = ShichosonSecurityJohoFinder.createInstance().getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (shichosonSecurityJoho == null) {
            return;
        }
        KaigoDonyuKubun 介護導入区分 = shichosonSecurityJoho.get介護導入区分();
        List<GappeiCityJyoho> gappeiCityJyohoList;
        DonyuKeitaiCode 導入形態コード = shichosonSecurityJoho.get導入形態コード();
        if (介護導入区分 != null && KaigoDonyuKubun.未導入.equals(介護導入区分)) {
            throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage().evaluate());
        } else {
            gappeiCityJyohoList = GappeiCityJohoBFinder.createInstance().getSaishintannitsugappeijoho(表示有無区分).records();
        }
        if (導入形態コード != null
                && (DonyuKeitaiCode.事務単一.equals(導入形態コード) || DonyuKeitaiCode.認定単一.equals(導入形態コード))) {
            loopPrm = new HihokenshaTempUpdateProcessParameter();
            if (gappeiCityJyohoList.isEmpty()) {
                executeStep(FLOW_WORK1);
            } else {
                FlexibleYearMonth サービス提供年月 = gappeiCityJyohoList.get(0).get国保連データ連携開始年月日().getYearMonth();
                loopPrm.setサービス提供年月(サービス提供年月);
                loopPrm.set合併年月日(gappeiCityJyohoList.get(0).get合併日());
                loopPrm.set地域番号(gappeiCityJyohoList.get(0).get合併情報番号());
                executeStep(FLOW_WORK2);
            }
        } else {
            executeStep(FLOW_WORK3);
        }
    }

    @Step(FLOW_WORK1)
    IBatchFlowCommand work1() {
        return loopBatch(HihokenshaTempUpdateProcess.class).arguments(loopPrm).define();
    }

    @Step(FLOW_WORK2)
    IBatchFlowCommand work2() {
        return loopBatch(HihokenshaTempUpdateProcess.class).arguments(loopPrm).define();
    }

    @Step(FLOW_WORK3)
    IBatchFlowCommand work3() {
        return loopBatch(HihokenshaTempUpdateKouikiProcess.class).define();
    }
}
