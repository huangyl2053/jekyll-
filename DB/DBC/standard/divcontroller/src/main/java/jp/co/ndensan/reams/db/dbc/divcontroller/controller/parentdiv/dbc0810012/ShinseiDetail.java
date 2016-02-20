/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0810012;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810012.ShinseiDetailDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0810012.ShinseiDetailHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0810014.ServiceTeiKyoShomeishoParameter;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 償還払い状況照会_申請情報照会画面クラスです
 */
public class ShinseiDetail {

    /**
     * 償還払い状況照会_申請情報照会画面初期化する
     *
     * @param div 緊急時・所定疾患画面Div
     * @return response
     */
    public ResponseData<ShinseiDetailDiv> onLoad(ShinseiDetailDiv div) {
        // TODO 引き継ぎデータの取得
        ServiceTeiKyoShomeishoParameter parmeter = new ServiceTeiKyoShomeishoParameter(
                new HihokenshaNo("000000003"), new FlexibleYearMonth(new RString("201601")),
                new RString("0000000003"), new JigyoshaNo("0000000003"), new RString("事業者名"),
                new RString("0003"), new RString("証明書"));
        ViewStateHolder.put(ViewStateKeys.基本情報パラメータ, parmeter);

        ServiceTeiKyoShomeishoParameter parameter = ViewStateHolder.get(
                ViewStateKeys.基本情報パラメータ, ServiceTeiKyoShomeishoParameter.class);
        FlexibleYearMonth サービス年月 = parameter.getServiceTeikyoYM();
        HihokenshaNo 被保険者番号 = parameter.getHiHokenshaNo();
        RString 整理番号 = parameter.getSeiriNp();

        //TODO 申請情報検索ViewState．決定日
        ViewStateHolder.put(ViewStateKeys.決定日, new RDate("20151224"));
        RDate 決定日 = ViewStateHolder.get(ViewStateKeys.決定日, RDate.class);
        if (決定日 == null) {
            div.getPanelHead().getBtnShokanBaraiKeteiInfo().setDisabled(true);
        }

        //介護宛名情報」共有子Divの初期化
//        div.getPanelUp().getCcdKaigoAtenaInfo().onLoad(new ShikibetsuCode("000003"));
        //介護資格系基本情報」共有子Div の初期化
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
//            div.getPanelUp().getCcdKaigoShikakuKihon().onLoad(被保険者番号);
        } else {
            div.getPanelUp().getCcdKaigoAtenaInfo().setVisible(false);
        }
        ShinseiDetailHandler handler = getHandler(div);
        handler.initPanelHead(サービス年月, 整理番号);

        //償還払支給申請詳細データ取得
        ShokanbaraiJyokyoShokai finder = ShokanbaraiJyokyoShokai.createInstance();
        List<ShokanShinsei> businessList = finder.getShokanbaraiShinseiJyohoDetail(
                被保険者番号, サービス年月, 整理番号);
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
