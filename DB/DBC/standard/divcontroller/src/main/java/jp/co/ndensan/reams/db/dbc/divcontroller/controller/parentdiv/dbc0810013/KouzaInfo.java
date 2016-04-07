/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0810013;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810013.KouzaInfoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0810013.KouzaInfoHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 償還払い状況照会_口座情報のクラス
 */
public class KouzaInfo {

    /**
     * 画面初期化onLoad
     *
     * @param div KouzaInfoDiv
     * @return 償還払い状況照会_口座情報画面
     */
    public ResponseData<KouzaInfoDiv> onLoad(KouzaInfoDiv div) {

        TaishoshaKey 引継ぎデータ = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        ShikibetsuCode 識別コード = 引継ぎデータ.get識別コード();
        FlexibleYearMonth サービス年月 = new FlexibleYearMonth((new RDate(ViewStateHolder.get(
                ViewStateKeys.償還払申請一覧_サービス年月, RString.class).toString())).getYearMonth().toDateString());
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.償還払申請一覧_被保険者番号, HihokenshaNo.class);
        RString 整理番号 = ViewStateHolder.get(ViewStateKeys.償還払申請一覧_整理番号, RString.class);

        div.getPanelOne().getCcdKaigoAtenaInfo().onLoad(識別コード);
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
            div.getPanelOne().getCcdKaigoShikakuKihon().onLoad(被保険者番号);
        } else {
            div.getPanelOne().getCcdKaigoShikakuKihon().setVisible(false);
        }
        List<ShokanShinsei> shokanShinseiList = ShokanbaraiJyokyoShokai.createInstance()
                .getShokanbaraiShinseiJyohoDetail(被保険者番号, サービス年月, 整理番号);
        if (shokanShinseiList == null || shokanShinseiList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        getHandler(div).setヘッダ_エリア(new RDate(サービス年月.toString()), 整理番号);
        // TODO QAのNo.2(内部番号282) ※共有子div  初期化
//        div.getPanelShinseiNaiyo().getCcdShiharaiHohoJyoho().load(識別コード, 被保険者番号, サービス提供年月
//               , 整理番号, 支払方法区分コード, 支払場所, 支払期間開始年月日
//               , 支払期間終了年月日, 支払窓口開始時間, 支払窓口終了期間, 口座ID, 受領委任契約番号);
        return createResponse(div);
    }

    private KouzaInfoHandler getHandler(KouzaInfoDiv div) {
        return new KouzaInfoHandler(div);
    }

    private ResponseData<KouzaInfoDiv> createResponse(KouzaInfoDiv div) {
        return ResponseData.of(div).respond();
    }
}
