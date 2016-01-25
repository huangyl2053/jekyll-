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

/**
 * 償還払い状況照会_食事費用画面のクラスです。
 *
 * @author wangkanglei
 */
public class ShokujiHiyo {

    public ResponseData<ShokujiHiyoDiv> onLoad(ShokujiHiyoDiv div) {
        // TODO 引き継ぎデータの取得
        ShikibetsuCode 識別コード = new ShikibetsuCode(new RString("123456"));
        FlexibleYearMonth サービス年月 = new FlexibleYearMonth(new RString("200405"));
        HihokenshaNo 被保険者番号 = new HihokenshaNo("1");
        RString 整理番号 = new RString("123456");
        JigyoshaNo 事業者番号 = new JigyoshaNo("2");
        RString 様式番号 = new RString("2345");
        RString 申請日 = new RString("20151124");
        RString 明細番号 = new RString("3456");
        RString 証明書 = new RString("証明書");
        // TODO「介護宛名情報」共有子Divの初期化
//        div.getPanelCcd().getCcdKaigoAtenaInfo().load(識別コード);
        // TODO 「介護資格系基本情報」共有子Div の初期化
        if (!被保険者番号.isEmpty()) {
            // TODO load----initialize
            div.getPanelCcd().getCcdKaigoShikakuKihon().initialize(被保険者番号);
        } else {
            div.getPanelCcd().getCcdKaigoShikakuKihon().setVisible(false);
        }
        getHandler(div).setヘッダーエリア(サービス年月, 事業者番号, 申請日, 明細番号, 証明書);

        if (new FlexibleYearMonth("200304").isBeforeOrEquals(サービス年月) && サービス年月.isBeforeOrEquals(new FlexibleYearMonth("200509"))) {
            div.getPanelShoikujiList().setVisible(true);
            div.getPanelGokeiSet().setVisible(true);
            div.getPanelDetail1().setVisible(false);
            div.getPanelDetail2().setVisible(true);

            List<ShokanMeisai> shokanMeisaiList = ShokanbaraiJyokyoShokai.createInstance()
                    .getShokujiHiyoDataList(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, 様式番号);
            if (shokanMeisaiList == null || shokanMeisaiList.isEmpty()) {
                throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
            }
            List<ShokanShokujiHiyo> shokanShokujiHiyoList = ShokanbaraiJyokyoShokai.createInstance()
                    .getSeikyuShokujiHiyoTanjyunSearch(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, 様式番号);

            getHandler(div).set食事費用一覧グリッド(shokanMeisaiList, shokanShokujiHiyoList.get(0));
        }

        if (new FlexibleYearMonth("200510").isBeforeOrEquals(サービス年月)) {
            div.getPanelShoikujiList().setVisible(false);
            div.getPanelGokeiSet().setVisible(true);
            div.getPanelDetail1().setVisible(false);
            div.getPanelDetail2().setVisible(false);

            List<ShokanShokujiHiyo> shokanShokujiHiyoList = ShokanbaraiJyokyoShokai.createInstance()
                    .getSeikyuShokujiHiyoTanjyunSearch(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, 様式番号);
            if (shokanShokujiHiyoList == null || shokanShokujiHiyoList.isEmpty()) {
                throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
            }
            getHandler(div).set食事費用合計設定パネル(shokanShokujiHiyoList.get(0));
        }

        if (サービス年月.isBeforeOrEquals(new FlexibleYearMonth("200303"))) {
            div.getPanelShoikujiList().setVisible(false);
            div.getPanelGokeiSet().setVisible(false);
            div.getPanelDetail1().setVisible(true);
            div.getPanelDetail2().setVisible(false);
            List<ShokanShokujiHiyo> shokanShokujiHiyoList = ShokanbaraiJyokyoShokai.createInstance()
                    .getSeikyuShokujiHiyoTanjyunSearch(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, 様式番号);
            if (shokanShokujiHiyoList == null || shokanShokujiHiyoList.isEmpty()) {
                throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
            }
            getHandler(div).set食事費用パネル１(shokanShokujiHiyoList.get(0));
        }

        ShikibetsuNoKanriEntity shikibetsuNoKanriEntity = ShokanbaraiJyokyoShokai.createInstance().getShikibetsubangoKanri(サービス年月, 様式番号);
        getHandler(div).setボタン表示制御処理(shikibetsuNoKanriEntity, サービス年月);
        return createResponse(div);
    }

    public ResponseData<ShokujiHiyoDiv> onClick_btnKihonInfo(ShokujiHiyoDiv div) {
        div.getPanelGokeiSet().setVisible(false);
        return createResponse(div);
    }

    public ResponseData<ShokujiHiyoDiv> onClick_btnKyufuhiMeisai(ShokujiHiyoDiv div) {
        div.getPanelGokeiSet().setVisible(false);
        return createResponse(div);
    }

    public ResponseData<ShokujiHiyoDiv> onClick_btnTokuteiShinryohi(ShokujiHiyoDiv div) {
        div.getPanelGokeiSet().setVisible(false);
        return createResponse(div);
    }

    public ResponseData<ShokujiHiyoDiv> onClick_btnServiceKeikakuhi(ShokujiHiyoDiv div) {
        div.getPanelGokeiSet().setVisible(false);
        return createResponse(div);
    }

    public ResponseData<ShokujiHiyoDiv> onClick_btnTokuteiNyushosya(ShokujiHiyoDiv div) {
        div.getPanelGokeiSet().setVisible(false);
        return createResponse(div);
    }

    public ResponseData<ShokujiHiyoDiv> onClick_btnGoukeiInfo(ShokujiHiyoDiv div) {
        div.getPanelGokeiSet().setVisible(false);
        return createResponse(div);
    }

    public ResponseData<ShokujiHiyoDiv> onClick_btnKyufuhiMeisaiJyutoku(ShokujiHiyoDiv div) {
        div.getPanelGokeiSet().setVisible(false);
        return createResponse(div);
    }

    public ResponseData<ShokujiHiyoDiv> onClick_btnKinkyujiShisetsuRyoyo(ShokujiHiyoDiv div) {
        div.getPanelGokeiSet().setVisible(false);
        return createResponse(div);
    }

    public ResponseData<ShokujiHiyoDiv> onClick_btnKinkyujiShoteiShikkan(ShokujiHiyoDiv div) {
        div.getPanelGokeiSet().setVisible(false);
        return createResponse(div);
    }

    public ResponseData<ShokujiHiyoDiv> onClick_btnSeikyugakuShukei(ShokujiHiyoDiv div) {
        div.getPanelGokeiSet().setVisible(false);
        return createResponse(div);
    }

    public ResponseData<ShokujiHiyoDiv> onClick_btnShafukukeigengaku(ShokujiHiyoDiv div) {
        div.getPanelGokeiSet().setVisible(false);
        return createResponse(div);
    }

    public ResponseData<ShokujiHiyoDiv> onClick_btnCloseGokei(ShokujiHiyoDiv div) {
        div.getPanelGokeiSet().setVisible(false);
        return createResponse(div);
    }

    public ResponseData<ShokujiHiyoDiv> onClick_btnCloseDown(ShokujiHiyoDiv div) {
        div.getPanelDetail2().setVisible(false);
        return createResponse(div);
    }

    public ResponseData<ShokujiHiyoDiv> onClick_btnBack(ShokujiHiyoDiv div) {
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
