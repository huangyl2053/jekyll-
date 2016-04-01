/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0810011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810011.ShinseiSearchDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 償還払い状況照会_申請情報検索
 */
public class ShinseiSearch {

    private static final RString 照会 = new RString("照会");

    /**
     * 初期表示
     *
     * @param div ShinseiSearchDiv
     * @return ResponseData
     */
    public ResponseData<ShinseiSearchDiv> onLoad(ShinseiSearchDiv div) {
        // TODO ダミー値を設定
        ViewStateHolder.put(ViewStateKeys.識別コード, new ShikibetsuCode("000000000000010"));
        ViewStateHolder.put(ViewStateKeys.被保険者番号, new HihokenshaNo("000000003"));

        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        div.getPanelAtenaShikaku().getCcdKaigoAtenalInfo().onLoad(識別コード);

        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        div.getPanelAtenaShikaku().getCcdKaigoShikakuKihon().initialize(被保険者番号);

        div.getPanelShokan().getCcdShokanShinseiList().initialize(照会, 被保険者番号, FlexibleYearMonth.MIN, FlexibleYearMonth.MAX);

        return ResponseData.of(div).respond();
    }
}
