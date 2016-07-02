/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0810014;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ServiceTeikyoShomeishoResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810014.ServiceTeikyoShomeishoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810014.dgdServiceTeikyoShomeisyo_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0810014.ServiceTeikyoShomeishoHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0810014.ServiceTeiKyoShomeishoParameter;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
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
 * 償還払い状況照会_サービス提供証明書のクラスです。
 *
 * @reamsid_L DBC-1010-020 gongliang
 */
public class ServiceTeikyoShomeisho {

    /**
     * 画面初期化onLoad
     *
     * @param div ServiceTeikyoShomeishoDiv
     * @return 償還払い状況照会_サービス提供証明書画面
     */
    public ResponseData<ServiceTeikyoShomeishoDiv> onLoad(ServiceTeikyoShomeishoDiv div) {

        TaishoshaKey 引継ぎデータ = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        ShikibetsuCode 識別コード = 引継ぎデータ.get識別コード();
        RString 決定日 = ViewStateHolder.get(ViewStateKeys.決定日, RString.class);
        RString 整理番号 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        FlexibleYearMonth サービス年月 = new FlexibleYearMonth((new RDate(ViewStateHolder.get(
                ViewStateKeys.サービス年月, RString.class).toString())).getYearMonth().toDateString());

        div.getPanelOne().getCcdKaigoAtenaInfo().initialize(識別コード);
        if (被保険者番号 == null || 被保険者番号.isEmpty()) {
            div.getPanelOne().getCcdKaigoShikakuKihon().setVisible(false);
            div.getPanelOne().getCcdKaigoShikakuKihon().setDisplayNone(true);
        } else {
            div.getPanelOne().getCcdKaigoShikakuKihon().initialize(被保険者番号);
        }
        List<ServiceTeikyoShomeishoResult> serviceTeikyoShomeishoList
                = ShokanbaraiJyokyoShokai.createInstance().getServiceTeikyoShomeishoList(被保険者番号, サービス年月, 整理番号);
        if (serviceTeikyoShomeishoList == null || serviceTeikyoShomeishoList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        getHandler(div).initialize(serviceTeikyoShomeishoList);
        getHandler(div).setヘッダ_エリア(new RDate(サービス年月.toString()), 整理番号);
        if (決定日.isNullOrEmpty()) {
            div.getPanelTwo().getBtnShokanKeteiInfo().setDisabled(true);
        }
        return createResponse(div);
    }

    /**
     * 選択ボタンを押下した際に実行します。
     *
     * @param div ServiceTeikyoShomeishoDiv
     * @return 基本情報画面
     */
    public ResponseData<ServiceTeikyoShomeishoDiv> onClick_SelectButton(ServiceTeikyoShomeishoDiv div) {
        dgdServiceTeikyoShomeisyo_Row row = div.getPanelShinseiNaiyo().getDgdServiceTeikyoShomeisyo().getClickedItem();
        FlexibleYearMonth サービス年月 = new FlexibleYearMonth((new RDate(ViewStateHolder.get(
                ViewStateKeys.サービス年月, RString.class).toString())).getYearMonth().toDateString());
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        RString 整理番号 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
        JigyoshaNo 事業者番号 = new JigyoshaNo(row.getData1());
        RString 事業者名 = row.getData2();
        RString 明細番号 = row.getData3();
        RString 証明書 = row.getData4();
        ServiceTeiKyoShomeishoParameter parameterHolder = new ServiceTeiKyoShomeishoParameter(
                被保険者番号, サービス年月, 整理番号, 事業者番号, 事業者名, 明細番号, 証明書);
        ViewStateHolder.put(ViewStateKeys.基本情報パラメータ, parameterHolder);
        return createResponse(div);
    }

    private ServiceTeikyoShomeishoHandler getHandler(ServiceTeikyoShomeishoDiv div) {
        return new ServiceTeikyoShomeishoHandler(div);
    }

    private ResponseData<ServiceTeikyoShomeishoDiv> createResponse(ServiceTeikyoShomeishoDiv div) {
        return ResponseData.of(div).respond();
    }
}
