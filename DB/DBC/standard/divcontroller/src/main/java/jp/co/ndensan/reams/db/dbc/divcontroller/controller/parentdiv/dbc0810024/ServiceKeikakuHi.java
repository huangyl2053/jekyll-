/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0810024;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShikibetsuNoKanriResult;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanServicePlan200004Result;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanServicePlan200604Result;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanServicePlan200904Result;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810024.ServiceKeikakuHiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0810024.ServiceKeikakuHiHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0810014.ServiceTeiKyoShomeishoParameter;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 償還払い状況照会_サービス計画費のクラスです。
 */
public class ServiceKeikakuHi {

    private static final FlexibleYearMonth サービス年月_200904 = new FlexibleYearMonth("200904");
    private static final FlexibleYearMonth サービス年月_200903 = new FlexibleYearMonth("200903");
    private static final FlexibleYearMonth サービス年月_200604 = new FlexibleYearMonth("200604");

    /**
     * 画面初期化onLoad
     *
     * @param div ServiceKeikakuHiDiv
     * @return 償還払い状況照会_サービス計画費画面
     */
    public ResponseData<ServiceKeikakuHiDiv> onLoad(ServiceKeikakuHiDiv div) {

        ServiceTeiKyoShomeishoParameter parmeter = new ServiceTeiKyoShomeishoParameter(
                new HihokenshaNo("000000003"), new FlexibleYearMonth(new RString("201501")),
                new RString("1111"), new JigyoshaNo("3333"), new RString("事業者名"),
                new RString("4444"), new RString("証明書"));
        ViewStateHolder.put(ViewStateKeys.基本情報パラメータ, parmeter);
        ViewStateHolder.put(ViewStateKeys.識別コード, new ShikibetsuCode("000000000000010"));
        ViewStateHolder.put(ViewStateKeys.様式番号, new RString("2222"));
        ServiceTeiKyoShomeishoParameter parameter = ViewStateHolder.get(
                ViewStateKeys.基本情報パラメータ, ServiceTeiKyoShomeishoParameter.class);
        HihokenshaNo 被保険者番号 = parameter.getHiHokenshaNo();
        FlexibleYearMonth サービス年月 = parameter.getServiceTeikyoYM();
        RString 整理番号 = parameter.getSeiriNp();
        JigyoshaNo 事業者番号 = parameter.getJigyoshaNo();
        RString 明細番号 = parameter.getMeisaiNo();
        RString 証明書 = parameter.getServiceYM();
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        RString 様式番号 = ViewStateHolder.get(ViewStateKeys.様式番号, RString.class);
        RString 申請日 = new RString("20160118");

        ShikibetsuNoKanriResult shikibetsuNoKanriEntity = ShokanbaraiJyokyoShokai.createInstance()
                .getShikibetsubangoKanri(サービス年月, 様式番号);
        getHandler(div).setボタン表示制御処理(shikibetsuNoKanriEntity.getEntity(), サービス年月);
        div.getPanelCcd().getCcdKaigoAtenaInfo().onLoad(識別コード);
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
            div.getPanelCcd().getCcdKaigoShikakuKihon().onLoad(被保険者番号);
        } else {
            div.getPanelCcd().getCcdKaigoShikakuKihon().setVisible(false);
        }
        if (サービス年月_200904.isBefore(サービス年月)) {
            List<ShokanServicePlan200904Result> entity200904List
                    = ShokanbaraiJyokyoShokai.createInstance().getServiceKeikaku200904(
                            被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null);
            div.getPanelServiceKeikakuhiDown().setDisplayNone(true);
            div.getPanelServiceKeikakuhiUp1().setVisible(true);
            checkNull(entity200904List);
            getHandler(div).onLoad(
                    entity200904List,
                    サービス年月,
                    事業者番号,
                    様式番号,
                    申請日,
                    明細番号,
                    証明書);
        } else {
            div.getPanelServiceKeikakuhiDown().setVisible(true);
            div.getPanelServiceKeikakuhiUp1().setDisplayNone(true);
            if (サービス年月_200604.isBefore(サービス年月) && !サービス年月_200903.isBefore(サービス年月)) {
                List<ShokanServicePlan200604Result> entity200604List
                        = ShokanbaraiJyokyoShokai.createInstance().getServiceKeikaku200604(
                                被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null);
                checkNull(entity200604List);
                getHandler(div).onLoad(
                        entity200604List.get(0),
                        サービス年月,
                        事業者番号,
                        様式番号,
                        申請日,
                        明細番号,
                        証明書);
            } else {
                List<ShokanServicePlan200004Result> entity200004List
                        = ShokanbaraiJyokyoShokai.createInstance().getServiceKeikaku200004(
                                被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null);
                checkNull(entity200004List);
                getHandler(div).onLoad20004(
                        entity200004List.get(0),
                        サービス年月,
                        事業者番号,
                        様式番号,
                        申請日,
                        明細番号,
                        証明書);
            }
        }
        return createResponse(div);
    }

    /**
     * 「閉じる」ボタンを押下した際に実行します。
     *
     * @param div ServiceKeikakuHiDiv
     * @return 償還払い状況照会_サービス計画費画面
     */
    public ResponseData<ServiceKeikakuHiDiv> onClick_btnClose(ServiceKeikakuHiDiv div) {
        div.getPanelServiceKeikakuhiUp1().setVisible(false);
        return createResponse(div);
    }

    /**
     * 「選択」ボタンを押下した際に実行します。
     *
     * @param div ServiceKeikakuHiDiv
     * @return 償還払い状況照会_サービス計画費画面
     */
    public ResponseData<ServiceKeikakuHiDiv> onClick_SelectButton(ServiceKeikakuHiDiv div) {
        ServiceTeiKyoShomeishoParameter parameter = ViewStateHolder.get(
                ViewStateKeys.基本情報パラメータ, ServiceTeiKyoShomeishoParameter.class);
        FlexibleYearMonth サービス年月 = parameter.getServiceTeikyoYM();
        HihokenshaNo 被保険者番号 = parameter.getHiHokenshaNo();
        RString 整理番号 = parameter.getSeiriNp();
        JigyoshaNo 事業者番号 = parameter.getJigyoshaNo();
        RString 明細番号 = parameter.getMeisaiNo();
        RString 様式番号 = ViewStateHolder.get(ViewStateKeys.様式番号, RString.class);
        RString 連番 = div.getPanelServiceKeikakuhiUp1().getDgdYichiran().getClickedItem().getDefaultDataName7();

        List<ShokanServicePlan200904Result> entity200904List = ShokanbaraiJyokyoShokai.createInstance()
                .getServiceKeikaku200904(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, 連番);
        checkNull(entity200904List);
        getHandler(div).onClick_SelectButton(entity200904List.get(0));
        return createResponse(div);
    }

    private void checkNull(List list) {
        if (list == null || list.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
    }

    private ServiceKeikakuHiHandler getHandler(ServiceKeikakuHiDiv div) {
        return new ServiceKeikakuHiHandler(div);
    }

    private ResponseData<ServiceKeikakuHiDiv> createResponse(ServiceKeikakuHiDiv div) {
        return ResponseData.of(div).respond();
    }
}
