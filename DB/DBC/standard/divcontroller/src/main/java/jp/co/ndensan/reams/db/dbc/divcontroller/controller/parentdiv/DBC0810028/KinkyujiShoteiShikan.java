/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0810028;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShoteiShikkanShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShikibetsuNoKanriResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810028.KinkyujiShoteiShikanDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0810028.KinkyujiShoteiShikanHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0810014.ServiceTeiKyoShomeishoParameter;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 償還払い状況照会_緊急時・所定疾患画面クラスです
 *
 * @reamsid_L DBC-1010-060 xupeng
 */
public class KinkyujiShoteiShikan {

    /**
     * 償還払い状況照会_緊急時・所定疾患画面初期化する
     *
     * @param div 緊急時・所定疾患画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanDiv> onLoad(KinkyujiShoteiShikanDiv div) {
        ServiceTeiKyoShomeishoParameter parameter = ViewStateHolder.get(
                ViewStateKeys.基本情報パラメータ, ServiceTeiKyoShomeishoParameter.class);
        FlexibleYearMonth サービス年月 = parameter.getServiceTeikyoYM();
        HihokenshaNo 被保険者番号 = parameter.getHiHokenshaNo();
        RString 整理番号 = parameter.getSeiriNp();
        JigyoshaNo 事業者番号 = parameter.getJigyoshaNo();
        RString 明細番号 = parameter.getMeisaiNo();
        RString 証明書 = parameter.getServiceYM();

        TaishoshaKey 引継ぎデータ = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        ShikibetsuCode 識別コード = 引継ぎデータ.get識別コード();
        RString 様式番号 = ViewStateHolder.get(ViewStateKeys.様式番号, RString.class);
        RDate 申請日 = new RDate(ViewStateHolder.get(ViewStateKeys.申請日, RString.class).toString());

        div.getPanelCcd().getCcdKaigoAtenaInfo().initialize(識別コード);
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
            div.getPanelCcd().getCcdKaigoShikakuKihon().initialize(被保険者番号);
        } else {
            div.getPanelCcd().getCcdKaigoAtenaInfo().setVisible(false);
        }
        KinkyujiShoteiShikanHandler handler = getHandler(div);
        handler.initPanelHead(サービス年月, 申請日, 事業者番号, 明細番号,
                証明書, 様式番号);

        ShokanbaraiJyokyoShokai finder = ShokanbaraiJyokyoShokai.createInstance();
        List<ShokanShoteiShikkanShisetsuRyoyo> businessList = finder.getShoteiShikanShisetsuRyoyohiEtcData(
                被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null);
        if (!(businessList == null || businessList.isEmpty())) {
            handler.initDgdKinkyujiShoteiList(businessList);
        }
        ShikibetsuNoKanriResult 識別番号 = finder.getShikibetsubangoKanri(サービス年月, 様式番号);
        handler.setボタン表示制御処理(識別番号);
        div.getPanelDetail().setDisplayNone(true);
        return ResponseData.of(div).respond();
    }

    /**
     * 「選択」ボタン
     *
     * @param div 緊急時・所定疾患画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanDiv> onClick_btnSelectButton(KinkyujiShoteiShikanDiv div) {
        div.getPanelDetail().setDisplayNone(false);
        RString 連番 = div.getDgdKinkyujiShoteiList().getClickedItem().getDefaultDataName8();

        ServiceTeiKyoShomeishoParameter parameter = ViewStateHolder.get(
                ViewStateKeys.基本情報パラメータ, ServiceTeiKyoShomeishoParameter.class);
        FlexibleYearMonth サービス年月 = parameter.getServiceTeikyoYM();
        HihokenshaNo 被保険者番号 = parameter.getHiHokenshaNo();
        RString 整理番号 = parameter.getSeiriNp();
        JigyoshaNo 事業者番号 = parameter.getJigyoshaNo();
        RString 明細番号 = parameter.getMeisaiNo();
        RString 様式番号 = ViewStateHolder.get(ViewStateKeys.様式番号, RString.class);

        ShokanbaraiJyokyoShokai finder = ShokanbaraiJyokyoShokai.createInstance();
        List<ShokanShoteiShikkanShisetsuRyoyo> list = finder.getShoteiShikanShisetsuRyoyohiEtcData(
                被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, 連番);
        getHandler(div).setUp傷病名(list.get(0));
        getHandler(div).setUp往診通院(list.get(0));
        getHandler(div).setUp治療点数(list.get(0));
        return ResponseData.of(div).respond();
    }

    /**
     * 「閉じる」ボタン
     *
     * @param div 緊急時・所定疾患画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanDiv> onClick_btnClose(KinkyujiShoteiShikanDiv div) {
        div.getPanelDetail().setDisplayNone(true);
        return ResponseData.of(div).respond();
    }

    private KinkyujiShoteiShikanHandler getHandler(KinkyujiShoteiShikanDiv div) {
        return KinkyujiShoteiShikanHandler.of(div);
    }
}
