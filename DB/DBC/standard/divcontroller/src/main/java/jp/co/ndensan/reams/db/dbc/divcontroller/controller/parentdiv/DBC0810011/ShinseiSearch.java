/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0810011;

import static jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810011.DBC0810011TransitionEventName.住宅改修費支給申請;
import static jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810011.DBC0810011TransitionEventName.償還払い費支給申請;
import static jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810011.DBC0810011TransitionEventName.福祉用具購入費支給;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810011.ShinseiSearchDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0600011.PnlTotalParameter;
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
 * 償還払い状況照会_申請情報検索
 *
 * @reamsid_L DBC-1010-130 panhe
 */
public class ShinseiSearch {

    private static final RString 照会 = new RString("照会");
    private static final RString 照会_モード = new RString("照会モード");
    private static final RString 参照 = new RString("参照");
    private static final RString 判定_21C = new RString("21C");
    private static final RString 判定_21D = new RString("21D");

    /**
     * 初期表示
     *
     * @param div ShinseiSearchDiv
     * @return ResponseData
     */
    public ResponseData<ShinseiSearchDiv> onLoad(ShinseiSearchDiv div) {
        TaishoshaKey 引継ぎデータ = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        ShikibetsuCode 識別コード = 引継ぎデータ.get識別コード();
        div.getPanelAtenaShikaku().getCcdKaigoAtenalInfo().initialize(識別コード);
        ViewStateHolder.put(ViewStateKeys.識別コード, 識別コード);
        HihokenshaNo 被保険者番号 = 引継ぎデータ.get被保険者番号();
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
        if (被保険者番号 != null) {
            div.getPanelAtenaShikaku().getCcdKaigoShikakuKihon().initialize(被保険者番号);
        }
        div.getPanelShokan().getCcdShokanShinseiList().initialize(照会, 被保険者番号, FlexibleYearMonth.MIN, FlexibleYearMonth.MAX);
        return ResponseData.of(div).respond();
    }

    /**
     * 選択ボタン
     *
     * @param div ShinseiSearchDiv
     * @return ResponseData<ShinseiSearchDiv>
     */
    public ResponseData<ShinseiSearchDiv> onClick_SelectButton(ShinseiSearchDiv div) {
        RString yoshikiNo = ViewStateHolder.get(ViewStateKeys.様式番号, RString.class);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        FlexibleYearMonth サービス年月 = new FlexibleYearMonth((new RDate(
                ViewStateHolder.get(ViewStateKeys.サービス年月, RString.class).
                toString())).getYearMonth().toDateString());
        RString 整理番号 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
        JigyoshaNo 事業者番号 = ViewStateHolder.get(ViewStateKeys.事業者番号, JigyoshaNo.class);
        RString 明細番号 = ViewStateHolder.get(ViewStateKeys.明細番号, RString.class);
        if (yoshikiNo.startsWith(判定_21C)) {
            ViewStateHolder.put(ViewStateKeys.状態, 参照);
            PnlTotalParameter parameter = new PnlTotalParameter(被保険者番号, サービス年月, 整理番号,
                    事業者番号, yoshikiNo, 明細番号);
            ViewStateHolder.put(ViewStateKeys.検索キー, parameter);
            return ResponseData.of(div).forwardWithEventName(福祉用具購入費支給).parameter(判定_21C);
        } else if (yoshikiNo.startsWith(判定_21D)) {
            ViewStateHolder.put(ViewStateKeys.表示モード, 照会_モード);
            ViewStateHolder.put(ViewStateKeys.サービス提供年月, サービス年月);
            ViewStateHolder.put(ViewStateKeys.整理番号, 整理番号);
            return ResponseData.of(div).forwardWithEventName(住宅改修費支給申請).parameter(判定_21D);
        } else {
            return ResponseData.of(div).forwardWithEventName(償還払い費支給申請).respond();
        }
    }
}
