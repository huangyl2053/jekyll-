/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0810029;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShokujiHiyo;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810029.ShokujiHiyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0810029.ShokujiHiyoHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0810014.ServiceTeiKyoShomeishoParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShikibetsuNoKanriEntity;
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
 * 償還払い状況照会_食事費用画面のクラスです。
 *
 * @author wangkanglei
 */
public class ShokujiHiyo {

    private static final FlexibleYearMonth 平成１５年３月 = new FlexibleYearMonth("200303");
    private static final FlexibleYearMonth 平成１５年４月 = new FlexibleYearMonth("200304");
    private static final FlexibleYearMonth 平成17年９月 = new FlexibleYearMonth("200509");
    private static final FlexibleYearMonth 平成17年10月 = new FlexibleYearMonth("200510");

    public ResponseData<ShokujiHiyoDiv> onLoad(ShokujiHiyoDiv div) {
        // TODO 引き継ぎデータの取得
        ServiceTeiKyoShomeishoParameter parmeter = new ServiceTeiKyoShomeishoParameter(
                new HihokenshaNo("000000033"), new FlexibleYearMonth(new RString("200501")),
                new RString("0000000003"), new JigyoshaNo("0000000003"), new RString("事業者名"),
                new RString("0003"), new RString("証明書"));
        ViewStateHolder.put(ViewStateKeys.基本情報パラメータ, parmeter);
        ServiceTeiKyoShomeishoParameter parameter = ViewStateHolder.get(
                ViewStateKeys.基本情報パラメータ, ServiceTeiKyoShomeishoParameter.class);
        FlexibleYearMonth サービス年月 = parameter.getServiceTeikyoYM();
        HihokenshaNo 被保険者番号 = parameter.getHiHokenshaNo();
        RString 整理番号 = parameter.getSeiriNp();
        JigyoshaNo 事業者番号 = parameter.getJigyoshaNo();
        RString 明細番号 = parameter.getMeisaiNo();
        RString 証明書 = parameter.getServiceYM();
        ViewStateHolder.put(ViewStateKeys.サービス年月, parameter.getServiceTeikyoYM());

        // TODO 該当者検索画面ViewState．識別コード
        ViewStateHolder.put(ViewStateKeys.識別コード, new ShikibetsuCode("123456"));
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        // TODO 申請書検索ViewSate．様式番号
        ViewStateHolder.put(ViewStateKeys.様式番号, new RString("0003"));
        RString 様式番号 = ViewStateHolder.get(ViewStateKeys.様式番号, RString.class);
        // TODO 申請検索画面ViewState. 申請日
        ViewStateHolder.put(ViewStateKeys.申請日, new RString("20151124"));

        // TODO「介護宛名情報」共有子Divの初期化
//        div.getPanelCcd().getCcdKaigoAtenaInfo().load(識別コード);
        // TODO 「介護資格系基本情報」共有子Div の初期化
        if (!被保険者番号.isEmpty()) {
            // TODO load----initialize
            div.getPanelCcd().getCcdKaigoShikakuKihon().initialize(被保険者番号);
        } else {
            div.getPanelCcd().getCcdKaigoShikakuKihon().setVisible(false);
        }
        getHandler(div).setヘッダーエリア(サービス年月, 事業者番号,
                ViewStateHolder.get(ViewStateKeys.申請日, RString.class), 明細番号, 証明書);

        if (平成１５年４月.isBeforeOrEquals(サービス年月) && サービス年月.isBeforeOrEquals(平成17年９月)) {
            div.getPanelShokuji().getPanelShoikujiList().setVisible(true);
            div.getPanelShokuji().getPanelShokujiGokei().setVisible(true);
            div.getPanelShokuji().getPanelDetail1().setVisible(false);
            div.getPanelShokuji().getPanelDetail2().setVisible(true);

            List<ShokanMeisai> shokanMeisaiList = ShokanbaraiJyokyoShokai.createInstance()
                    .getShokujiHiyoDataList(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null);
            if (shokanMeisaiList == null || shokanMeisaiList.isEmpty()) {
                throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
            }
            List<ShokanShokujiHiyo> shokanShokujiHiyoList = ShokanbaraiJyokyoShokai.createInstance()
                    .getSeikyuShokujiHiyoTanjyunSearch(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号,
                            null);

            getHandler(div).set食事費用一覧グリッド(shokanMeisaiList, shokanShokujiHiyoList.get(0));
        }

        if (平成17年10月.isBeforeOrEquals(サービス年月)) {
            div.getPanelShokuji().getPanelShoikujiList().setVisible(false);
            div.getPanelShokuji().getPanelShokujiGokei().setVisible(true);
            div.getPanelShokuji().getPanelDetail1().setVisible(false);
            div.getPanelShokuji().getPanelDetail2().setVisible(false);

            List<ShokanShokujiHiyo> shokanShokujiHiyoList = ShokanbaraiJyokyoShokai.createInstance()
                    .getSeikyuShokujiHiyoTanjyunSearch(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号,
                            null);
            if (shokanShokujiHiyoList == null || shokanShokujiHiyoList.isEmpty()) {
                throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
            }
            getHandler(div).set食事費用合計設定パネル(shokanShokujiHiyoList.get(0));
        }

        if (サービス年月.isBeforeOrEquals(平成１５年３月)) {
            div.getPanelShokuji().getPanelShoikujiList().setVisible(false);
            div.getPanelShokuji().getPanelShokujiGokei().setVisible(false);
            div.getPanelShokuji().getPanelDetail1().setVisible(true);
            div.getPanelShokuji().getPanelDetail2().setVisible(false);
            List<ShokanShokujiHiyo> shokanShokujiHiyoList = ShokanbaraiJyokyoShokai.createInstance()
                    .getSeikyuShokujiHiyoTanjyunSearch(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号,
                            null);
            if (shokanShokujiHiyoList == null || shokanShokujiHiyoList.isEmpty()) {
                throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
            }
            getHandler(div).set食事費用パネル１(shokanShokujiHiyoList.get(0));
        }

        ShikibetsuNoKanriEntity shikibetsuNoKanriEntity = ShokanbaraiJyokyoShokai.createInstance()
                .getShikibetsubangoKanri(サービス年月, 様式番号);
        getHandler(div).setボタン表示制御処理(shikibetsuNoKanriEntity, サービス年月);
        return createResponse(div);
    }

    public ResponseData<ShokujiHiyoDiv> onClick_btnCloseGokei(ShokujiHiyoDiv div) {
        div.getPanelShokuji().getPanelShokujiGokei().setVisible(false);
        return createResponse(div);
    }

    public ResponseData<ShokujiHiyoDiv> onClick_btnCloseDown(ShokujiHiyoDiv div) {
        div.getPanelShokuji().getPanelDetail2().setVisible(false);
        return createResponse(div);
    }

    public ResponseData<ShokujiHiyoDiv> onClick_dgList_select(ShokujiHiyoDiv div) {
        getHandler(div).set食事費用パネル２();
        return createResponse(div);
    }

    private ShokujiHiyoHandler getHandler(ShokujiHiyoDiv div) {
        return new ShokujiHiyoHandler(div);
    }

    private ResponseData<ShokujiHiyoDiv> createResponse(ShokujiHiyoDiv div) {
        return ResponseData.of(div).respond();
    }
}
