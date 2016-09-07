/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0810015;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810015.ShokanbarayiKeteiInfoDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
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
 * 償還払い状況照会_償還払決定情報のクラスです。
 *
 * @reamsid_L DBC-1010-110 xuhao
 */
public class ShokanbarayiKeteiInfo {

    /**
     * 償還払い状況照会_償還払決定情報のonLoad
     *
     * @param div 画面DIV
     * @return 償還払い状況照会
     */
    public ResponseData<ShokanbarayiKeteiInfoDiv> onLoad(ShokanbarayiKeteiInfoDiv div) {
        FlexibleYearMonth サービス年月 = new FlexibleYearMonth((new RDate(ViewStateHolder.get(
                ViewStateKeys.サービス年月, RString.class).toString())).getYearMonth().toDateString());
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        RString 整理番号 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
        RString 業務区分 = new RString("03");
        RString 画面モード = new RString("照会");

        TaishoshaKey 引継ぎデータ = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        ShikibetsuCode 識別コード = 引継ぎデータ.get識別コード();

        div.getPanelOne().getCcdKaigoAtenaInfo().initialize(識別コード);
        if (!被保険者番号.isEmpty()) {
            div.getPanelOne().getCcdKaigoShikakuKihon().initialize(被保険者番号);
        } else {
            div.getPanelOne().getCcdKaigoShikakuKihon().setVisible(false);
        }
        div.getPanelTwo().getTxtServiceTeikyoYM().setValue(new RDate(サービス年月.wareki().toDateString().toString()));
        div.getPanelTwo().getTxtSeiriBango().setValue(整理番号);
        div.getPanelTwo().getCcdShokanbaraiketteiJoho().loadInitialize(
                被保険者番号, サービス年月, 整理番号, 業務区分, 画面モード);
        int count = div.getPanelTwo().getCcdShokanbaraiketteiJoho().getCount();
        if (count == 0) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        div.getPanelTwo().getBtnShokanbariKeteiInfo().setDisabled(true);
        return ResponseData.of(div).respond();
    }

}
