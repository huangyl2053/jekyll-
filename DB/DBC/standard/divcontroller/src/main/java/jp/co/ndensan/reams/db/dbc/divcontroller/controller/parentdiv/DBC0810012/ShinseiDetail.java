/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0810012;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810012.ShinseiDetailDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0810012.ShinseiDetailHandler;
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
 * 償還払い状況照会_申請情報照会画面クラスです
 *
 * @reamsid_L DBC-1010-170 xupeng
 */
public class ShinseiDetail {

    /**
     * 償還払い状況照会_申請情報照会画面初期化する
     *
     * @param div 償還払い状況照会_申請情報照会画面画面Div
     * @return response
     */
    public ResponseData<ShinseiDetailDiv> onLoad(ShinseiDetailDiv div) {
        TaishoshaKey 引継ぎデータ = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        FlexibleYearMonth サービス年月 = new FlexibleYearMonth((new RDate(
                ViewStateHolder.get(ViewStateKeys.サービス年月, RString.class).
                toString())).getYearMonth().toDateString());
        HihokenshaNo 被保険者番号 = 引継ぎデータ.get被保険者番号();
        RString 整理番号 = ViewStateHolder.get(
                ViewStateKeys.整理番号, RString.class);
        RString 決定日 = ViewStateHolder.get(ViewStateKeys.決定日, RString.class);
        ShikibetsuCode 識別コード = 引継ぎデータ.get識別コード();

        ShinseiDetailHandler handler = getHandler(div);
        List<ShokanShinsei> businessList = handler.initPanelHead(被保険者番号, 識別コード, サービス年月, 整理番号, 決定日);
        if (businessList == null || businessList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        handler.init申請内容(businessList);
        return ResponseData.of(div).respond();
    }

    private ShinseiDetailHandler getHandler(ShinseiDetailDiv div) {
        return ShinseiDetailHandler.of(div);
    }
}
