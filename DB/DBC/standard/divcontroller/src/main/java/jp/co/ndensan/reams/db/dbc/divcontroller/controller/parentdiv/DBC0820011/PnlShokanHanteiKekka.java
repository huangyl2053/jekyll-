/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0820011;

import static jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820011.DBC0820011TransitionEventName.償還申請;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820011.PnlShokanHanteiKekkaDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 償還払い費支給申請決定_検索
 *
 * @reamsid_L DBC-1030-140 panhe
 */
public class PnlShokanHanteiKekka {

    private static final RString 申請 = new RString("申請");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 新規 = new RString("新規");

    /**
     * 初期表示
     *
     * @param div PnlShokanHanteiKekkaDiv
     * @return ResponseData
     */
    public ResponseData<PnlShokanHanteiKekkaDiv> onLoad(PnlShokanHanteiKekkaDiv div) {
        TaishoshaKey 引継ぎデータ = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);

        ShikibetsuCode 識別コード = 引継ぎデータ.get識別コード();
        div.getPanelAtenaShikaku().getCcdKaigoAtenalInfo().initialize(識別コード);
        div.getPanelAtenaShikaku().getCcdKaigoShikakuKihon().initialize(識別コード);

        HihokenshaNo 被保険者番号 = 引継ぎデータ.get被保険者番号();
        FlexibleYearMonth 前月 = FlexibleDate.getNowDate().plusMonth(-1).getYearMonth();
        div.getPnlShokanShinseiList().getCcdShokanShinseiList().initialize(申請, 被保険者番号, 前月, 前月);

        return ResponseData.of(div).respond();
    }

    /**
     * 申請を追加ボタン
     *
     * @param div PnlShokanHanteiKekkaDiv
     * @return ResponseData
     */
    public ResponseData<PnlShokanHanteiKekkaDiv> onClick_btnInsert(PnlShokanHanteiKekkaDiv div) {
        ViewStateHolder.put(ViewStateKeys.画面モード, 新規);
        return ResponseData.of(div).forwardWithEventName(償還申請).respond();
    }

    /**
     * 修正ボタン
     *
     * @param div PnlShokanHanteiKekkaDiv
     * @return ResponseData
     */
    public ResponseData<PnlShokanHanteiKekkaDiv> onClick_btnModify(PnlShokanHanteiKekkaDiv div) {
        ViewStateHolder.put(ViewStateKeys.画面モード, 修正);
        return ResponseData.of(div).forwardWithEventName(償還申請).respond();
    }

    /**
     * 削除ボタン
     *
     * @param div PnlShokanHanteiKekkaDiv
     * @return ResponseData
     */
    public ResponseData<PnlShokanHanteiKekkaDiv> onClick_btnDelete(PnlShokanHanteiKekkaDiv div) {
        ViewStateHolder.put(ViewStateKeys.画面モード, 削除);
        return ResponseData.of(div).forwardWithEventName(償還申請).respond();
    }
}
