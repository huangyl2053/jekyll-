/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0810031;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShikibetsuNoKanriResult;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanShakaiFukushiHojinKeigengakuResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810031.ShafukuKeigenGakuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0810031.ShafukuKeigenGakuHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0810014.ServiceTeiKyoShomeishoParameter;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
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
 *
 * 償還払い状況照会_社福軽減額画面クラスです。
 *
 * @reamsid_L DBC-1010-100 xuhao
 */
public class ShafukuKeigenGaku {

    /**
     * 償還払い状況照会_社福軽減額画面を画面初期化処理しました。
     *
     * @param div 社福軽減額画面Div
     * @return response
     */
    public ResponseData<ShafukuKeigenGakuDiv> onLoad(ShafukuKeigenGakuDiv div) {
        ServiceTeiKyoShomeishoParameter parameter = ViewStateHolder.get(
                ViewStateKeys.基本情報パラメータ, ServiceTeiKyoShomeishoParameter.class);
        FlexibleYearMonth サービス年月 = parameter.getServiceTeikyoYM();
        HihokenshaNo 被保険者番号 = parameter.getHiHokenshaNo();
        RString 整理番号 = parameter.getSeiriNp();
        JigyoshaNo 事業者番号 = parameter.getJigyoshaNo();
        RString 明細番号 = parameter.getMeisaiNo();
        RString 証明書 = parameter.getServiceYM();

        TaishoshaKey 引継ぎデータ = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        ShikibetsuCode 識別コード = 引継ぎデータ.get識別コード();
        RString 様式番号 = ViewStateHolder.get(ViewStateKeys.様式番号, RString.class);
        RDate 申請日 = new RDate(ViewStateHolder.get(ViewStateKeys.申請日, RString.class).toString());
        div.getPanelCcd().getCcdKaigoAtenaInfo().initialize(識別コード);
        if (!被保険者番号.isEmpty()) {
            div.getPanelCcd().getCcdKaigoShikakuKihon().initialize(被保険者番号);
        } else {
            div.getPanelCcd().getCcdKaigoShikakuKihon().setVisible(false);
        }

        div.getPanelHead().getTxtServiceTeikyoYM().setValue(new RDate(サービス年月.wareki().toDateString().toString()));
        div.getPanelHead().getTxtShinseiYMD().setValue(new RDate(申請日.wareki().toDateString().toString()));
        div.getPanelHead().getTxtJigyoshaBango().setValue(事業者番号.getColumnValue());
        div.getPanelHead().getTxtMeisaiBango().setValue(明細番号);
        div.getPanelHead().getTxtShomeisho().setValue(証明書);
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().setVisible(false);

        List<ShokanShakaiFukushiHojinKeigengakuResult> shokanShakaiList
                = ShokanbaraiJyokyoShokai.createInstance().getSeikyuShakaifukushiHoujinKeigengaku(
                        被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null);

        getHandler(div).initialize(shokanShakaiList);
        div.getPanelHead().getBtnGoukeiInfo().setDisabled(false);
        div.getPanelHead().getBtnShafukukeigengaku().setDisabled(true);
        ShikibetsuNoKanriResult shikibetsuNoKanriEntity
                = ShokanbaraiJyokyoShokai.createInstance().getShikibetsubangoKanri(サービス年月, 様式番号);
        getHandler(div).setボタン表示制御処理(shikibetsuNoKanriEntity, サービス年月);
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_btnClose
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuDiv> onClick_btnClose(ShafukuKeigenGakuDiv div) {
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().setVisible(false);
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_selectButton
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShafukuKeigenGakuDiv> onClick_selectButton(ShafukuKeigenGakuDiv div) {
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().setVisible(true);
        getHandler(div).selectButton();
        return ResponseData.of(div).respond();
    }

    private ShafukuKeigenGakuHandler getHandler(ShafukuKeigenGakuDiv div) {
        return new ShafukuKeigenGakuHandler(div);
    }
}
