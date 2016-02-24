/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0810030;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShikibetsuNoKanriResult;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanShukeiResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810030.SeikyuGakuShukeiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810030.dgdSeikyugakushukei_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0810030.SeikyuGakuShukeiHandler;
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
 * 償還払い状況照会_請求額集計
 *
 *
 */
public class SeikyuGakuShukei {

    /**
     * onLoad事件
     *
     * @param div SeikyuGakuShukeiDiv
     * @return ResponseData
     */
    public ResponseData<SeikyuGakuShukeiDiv> onLoad(SeikyuGakuShukeiDiv div) {

        ServiceTeiKyoShomeishoParameter parmeter = new ServiceTeiKyoShomeishoParameter(
                new HihokenshaNo("000000033"), new FlexibleYearMonth(new RString("201601")),
                new RString("0000000003"), new JigyoshaNo("0000000003"), new RString("事業者名"),
                new RString("0003"), new RString("証明書"));
        ViewStateHolder.put(ViewStateKeys.基本情報パラメータ, parmeter);
        ServiceTeiKyoShomeishoParameter parameter = ViewStateHolder.get(
                ViewStateKeys.基本情報パラメータ, ServiceTeiKyoShomeishoParameter.class);

        FlexibleYearMonth サービス年月 = parameter.getServiceTeikyoYM();
        HihokenshaNo 被保険者番号 = parameter.getHiHokenshaNo();
        RString 整理番号 = parameter.getSeiriNp();

        RString 明細番号 = parameter.getMeisaiNo();
        RString 証明書 = parameter.getServiceYM();
        JigyoshaNo 事業者番号 = parameter.getJigyoshaNo();
        ViewStateHolder.put(ViewStateKeys.識別コード, new ShikibetsuCode("2"));
//        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        ViewStateHolder.put(ViewStateKeys.様式番号, new RString("0003"));
        RString 様式番号 = ViewStateHolder.get(ViewStateKeys.様式番号, RString.class);
        ViewStateHolder.put(ViewStateKeys.申請日, new RString("20151124"));
//        ServiceShuruiCode サービス種類コード = new ServiceShuruiCode("222222");
        //  div.getPanelCcd().getCcdKaigoShikakuKihon().load(LasdecCode.EMPTY, 識別コード);
        if (!被保険者番号.isEmpty()) {
            div.getPanelCcd().getCcdKaigoShikakuKihon().initialize(被保険者番号);
        } else {
            div.getPanelCcd().getCcdKaigoShikakuKihon().setVisible(false);

        }
        getHandler(div).setヘッダーエリア(サービス年月, 事業者番号,
                ViewStateHolder.get(ViewStateKeys.申請日, RString.class), 明細番号, 証明書);

        List<ShokanShukeiResult> entityList = ShokanbaraiJyokyoShokai.createInstance().getSeikyuShukeiData(
                被保険者番号,
                サービス年月,
                整理番号,
                事業者番号,
                様式番号,
                明細番号, null);
        if (entityList == null || entityList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        div.getPanelSeikyuShokai().setVisible(false);
        getHandler(div).initialize(entityList);
        ShikibetsuNoKanriResult shikibetsuNoKanriEntity = ShokanbaraiJyokyoShokai.createInstance()
                .getShikibetsubangoKanri(サービス年月, 様式番号);
        getHandler(div).setボタン表示制御処理(shikibetsuNoKanriEntity, サービス年月);
        div.getPanelSeikyuShokai().setVisible(false);
        return createResponse(div);
    }

    /**
     * onClick_selectButton事件
     *
     * @param div SeikyuGakuShukeiDiv
     * @return ResponseData
     */
    public ResponseData<SeikyuGakuShukeiDiv> onClick_selectButton(SeikyuGakuShukeiDiv div) {
        div.getPanelSeikyuShokai().setVisible(true);
        ServiceTeiKyoShomeishoParameter parameter = ViewStateHolder.get(
                ViewStateKeys.基本情報パラメータ, ServiceTeiKyoShomeishoParameter.class);
        FlexibleYearMonth サービス年月 = new FlexibleYearMonth(new RString("200904"));
        HihokenshaNo 被保険者番号 = parameter.getHiHokenshaNo();
        RString 整理番号 = parameter.getSeiriNp();
        RString 様式番号 = ViewStateHolder.get(ViewStateKeys.様式番号, RString.class);
        RString 明細番号 = parameter.getMeisaiNo();
        JigyoshaNo 事業者番号 = parameter.getJigyoshaNo();
        dgdSeikyugakushukei_Row row = div.getPanelSeikyugakuShukei().getDgdSeikyugakushukei().getClickedItem();
        List<ShokanShukeiResult> entityList = ShokanbaraiJyokyoShokai.createInstance().getSeikyuShukeiData(
                被保険者番号,
                サービス年月,
                整理番号,
                事業者番号,
                様式番号,
                明細番号,
                row.getDefaultDataName7());
        if (entityList == null || entityList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        ShokanKihon list = ShokanbaraiJyokyoShokai.createInstance().
                getShokanbarayiSeikyukihonDetail(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        getHandler(div).selectButton(entityList, list);

        return createResponse(div);

    }

    /**
     * onClick_btnCloseUp事件
     *
     * @param div SeikyuGakuShukeiDiv
     * @return ResponseData
     */
    public ResponseData<SeikyuGakuShukeiDiv> onClick_btnCloseUp(SeikyuGakuShukeiDiv div) {
        div.getPanelSeikyuShokai().setVisible(false);
        return createResponse(div);
    }

    private SeikyuGakuShukeiHandler getHandler(SeikyuGakuShukeiDiv div) {

        return new SeikyuGakuShukeiHandler(div);
    }

    private ResponseData<SeikyuGakuShukeiDiv> createResponse(SeikyuGakuShukeiDiv div) {
        return ResponseData.of(div).respond();
    }

}
