/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0810031;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810031.ShafukuKeigenGakuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0810031.ShafukuKeigenGakuHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0810014.ServiceTeiKyoShomeishoParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShikibetsuNoKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShokanShakaiFukushiHojinKeigengakuEntity;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * 償還払い状況照会_社福軽減額画面クラスです。
 * @author 徐浩
 */
public class ShafukuKeigenGaku {

    /**
     * 償還払い状況照会_社福軽減額画面を画面初期化処理しました。
     *
     * @param div 社福軽減額画面Div
     * @return response
     */
    public ResponseData<ShafukuKeigenGakuDiv> onLoad(ShafukuKeigenGakuDiv div) {
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
        JigyoshaNo 事業者番号 = parameter.getJigyoshaNo();
        RString 明細番号 = parameter.getMeisaiNo();
        RString 証明書 = parameter.getServiceYM();

        // TODO 該当者検索画面ViewState．識別コード
        ViewStateHolder.put(ViewStateKeys.識別コード, new ShikibetsuCode("123456"));
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        // TODO 申請書検索ViewSate．様式番号
        ViewStateHolder.put(ViewStateKeys.様式番号, new RString("0003"));
        RString 様式番号 = ViewStateHolder.get(ViewStateKeys.様式番号, RString.class);
        // TODO 申請検索画面ViewState. 申請日
        ViewStateHolder.put(ViewStateKeys.申請日, new RDate("20161126"));
        RDate 申請日 = ViewStateHolder.get(ViewStateKeys.申請日, RDate.class);
        // KaigoAtenaInfo  「介護宛名情報」共有子Divの初期化
//        div.getPanelCcd().getCcdKaigoAtenaInfo().load(識別コード);
        // KaigoShikakuKihon 「介護資格系基本情報」共有子Div の初期化(这个entity中的load方法没写)
        if (!被保険者番号.isEmpty()) {
//            div.getPanelCcd().getCcdKaigoShikakuKihon().load(LasdecCode.EMPTY, 識別コード);
        } else {
            div.getPanelCcd().getCcdKaigoShikakuKihon().setVisible(false);
        }
        div.getPanelHead().getTxtServiceTeikyoYM().setDomain(new RYearMonth(サービス年月.wareki().toDateString()));
        div.getPanelHead().getTxtShinseiYMD().setValue(new RDate(申請日.wareki().toDateString().toString()));
        div.getPanelHead().getTxtJigyoshaBango().setValue(new RString(事業者番号.toString()));
        div.getPanelHead().getTxtMeisaiBango().setValue(明細番号);
        div.getPanelHead().getTxtShomeisho().setValue(証明書);
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().setVisible(false);
        // TODO 调用别人用的business里面的方法；
        List<ShokanShakaiFukushiHojinKeigengakuEntity> ShokanShakaiFukushiHojinKeigengakuuList 
                = ShokanbaraiJyokyoShokai.createInstance().getSeikyuShakaifukushiHoujinKeigengaku(
                        被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null);
        if (null == ShokanShakaiFukushiHojinKeigengakuuList || 0 == ShokanShakaiFukushiHojinKeigengakuuList.size()) {
                    throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        getHandler(div).initialize(ShokanShakaiFukushiHojinKeigengakuuList);
        div.getPanelHead().getBtnGoukeiInfo().setDisabled(false);
        div.getPanelHead().getBtnShafukukeigengaku().setDisabled(true);
        ShikibetsuNoKanriEntity shikibetsuNoKanriEntity = 
                ShokanbaraiJyokyoShokai.createInstance().getShikibetsubangoKanri(サービス年月, 様式番号);
        getHandler(div).setボタン表示制御処理(shikibetsuNoKanriEntity, サービス年月);
        return ResponseData.of(div).respond();
    }

    public ResponseData<ShafukuKeigenGakuDiv> onClick_btnKihonInfo(ShafukuKeigenGakuDiv div) {
        return ResponseData.of(div).respond();
    }

    public ResponseData<ShafukuKeigenGakuDiv> onClick_btnKyufuhiMeisai(ShafukuKeigenGakuDiv div) {
        return ResponseData.of(div).respond();
    }
    
    public ResponseData<ShafukuKeigenGakuDiv> onClick_btnTokuteiShinryohi(ShafukuKeigenGakuDiv div) {
        return ResponseData.of(div).respond();
    }

    public ResponseData<ShafukuKeigenGakuDiv> onClick_btnServiceKeikakuhi(ShafukuKeigenGakuDiv div) {
        return ResponseData.of(div).respond();
    }

    public ResponseData<ShafukuKeigenGakuDiv> onClick_btnTokuteiNyushosya(ShafukuKeigenGakuDiv div) {
        return ResponseData.of(div).respond();
    }

    public ResponseData<ShafukuKeigenGakuDiv> onClick_btnGoukeiInfo(ShafukuKeigenGakuDiv div) {
        return ResponseData.of(div).respond();
    }

    public ResponseData<ShafukuKeigenGakuDiv> onClick_btnKyufuhiMeisaiJyuchi(ShafukuKeigenGakuDiv div) {
        return ResponseData.of(div).respond();
    }
    
    public ResponseData<ShafukuKeigenGakuDiv> onClick_btnKinkyujiShisetsuRyoyo(ShafukuKeigenGakuDiv div) {
        return ResponseData.of(div).respond();
    }

    public ResponseData<ShafukuKeigenGakuDiv> onClick_btnKinkyujiShoteiShikkan(ShafukuKeigenGakuDiv div) {
        return ResponseData.of(div).respond();
    }
    
    public ResponseData<ShafukuKeigenGakuDiv> onClick_btnShokujiHiyo(ShafukuKeigenGakuDiv div) {
        return ResponseData.of(div).respond();
    }

    public ResponseData<ShafukuKeigenGakuDiv> onClick_btnSeikyugakuShukei(ShafukuKeigenGakuDiv div) {
        return ResponseData.of(div).respond();
    }


    public ResponseData<ShafukuKeigenGakuDiv> onClick_btnClose(ShafukuKeigenGakuDiv div) {
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().setVisible(false);
        return ResponseData.of(div).respond();
    }

    public ResponseData<ShafukuKeigenGakuDiv> onClick_selectButton(ShafukuKeigenGakuDiv div) {
        div.getPanelShafukukenngengaku().getPanelShakaiFukushiShokai().setVisible(true);
        getHandler(div).selectButton();
        return ResponseData.of(div).respond();
    }
    
    public ResponseData<ShafukuKeigenGakuDiv> onClick_btnBack(ShafukuKeigenGakuDiv div) {
        return ResponseData.of(div).respond();
    }

    private ShafukuKeigenGakuHandler getHandler(ShafukuKeigenGakuDiv div) {
        return new ShafukuKeigenGakuHandler(div);
    }
}
