/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0810022;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShikibetsuNoKanriResult;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanMeisaiResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810022.KyufuShiharayiMeisaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0810022.KyufuShiharayiMeisaiHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0810014.ServiceTeiKyoShomeishoParameter;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 償還払い状況照会_給付費明細
 *
 * @reamsid_L DBC-1010-050 quxiaodong
 */
public class KyufuShiharayiMeisai {

    /**
     *
     * onLoad事件
     *
     * @param div KyufuShiharayiMeisaiDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiDiv> onLoad(KyufuShiharayiMeisaiDiv div) {
        ServiceTeiKyoShomeishoParameter parameter = ViewStateHolder.get(
                ViewStateKeys.基本情報パラメータ, ServiceTeiKyoShomeishoParameter.class);
        FlexibleYearMonth サービス年月 = parameter.getServiceTeikyoYM();
        HihokenshaNo 被保険者番号 = parameter.getHiHokenshaNo();
        RString 整理番号 = parameter.getSeiriNp();
        RString 明細番号 = parameter.getMeisaiNo();
        RString 証明書 = parameter.getServiceYM();
        JigyoshaNo 事業者番号 = parameter.getJigyoshaNo();
        RString 様式番号 = ViewStateHolder.get(ViewStateKeys.様式番号, RString.class);
        RString 申請日 = ViewStateHolder.get(ViewStateKeys.申請日, RString.class);
        TaishoshaKey 引継ぎデータ = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        ShikibetsuCode 識別コード = 引継ぎデータ.get識別コード();
        div.getPanelOne().getCcdKaigoAtenaInfo().initialize(識別コード);
        if (!被保険者番号.isEmpty()) {
            div.getPanelOne().getCcdKaigoShikakuKihon().initialize(被保険者番号);
        } else {
            div.getPanelOne().getCcdKaigoShikakuKihon().setVisible(false);
        }
        getHandler(div).setヘッダーエリア(サービス年月, 事業者番号, 申請日, 明細番号, 証明書);
        List<ShokanMeisaiResult> entityList = ShokanbaraiJyokyoShokai.createInstance().
                getShokanbarayiSeikyuMeisayiList(
                        被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null, null);
        
        getHandler(div).initialize(entityList);        
        ShikibetsuNoKanriResult shikibetsuNoKanriEntity = ShokanbaraiJyokyoShokai.createInstance()
                .getShikibetsubangoKanri(サービス年月, 様式番号);
        getHandler(div).setボタン表示制御処理(shikibetsuNoKanriEntity, サービス年月);
        div.getPanelFour().setVisible(false);

        return createResponse(div);
    }

    /**
     *
     * @param div KyufuShiharayiMeisaiDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiDiv> onClick_selectButton(KyufuShiharayiMeisaiDiv div) {
        getHandler(div).set給付費明細();
        div.getPanelFour().setVisible(true);
        return createResponse(div);

    }

    /**
     * 「閉じる」ボタン上
     *
     * @param div KyufuShiharayiMeisaiDiv
     * @return ResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiDiv> onClick_btnCloseUp(KyufuShiharayiMeisaiDiv div) {
        div.getPanelThree().getPanelFour().setVisible(false);
        return createResponse(div);
    }

    private KyufuShiharayiMeisaiHandler getHandler(KyufuShiharayiMeisaiDiv div) {
        return new KyufuShiharayiMeisaiHandler(div);
    }

    private ResponseData<KyufuShiharayiMeisaiDiv> createResponse(KyufuShiharayiMeisaiDiv div) {
        return ResponseData.of(div).respond();
    }
}
