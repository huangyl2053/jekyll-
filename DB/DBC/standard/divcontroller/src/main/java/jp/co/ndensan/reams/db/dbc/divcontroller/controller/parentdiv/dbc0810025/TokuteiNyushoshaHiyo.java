/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0810025;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiNyushoshaKaigoServiceHiyo;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810025.TokuteiNyushoshaHiyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0810025.TokuteiNyushoshaHiyoHandler;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShikibetsuNoKanriEntity;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払い状況照会_特定診療費のクラスです。
 *
 * @author wangkanglei
 */
public class TokuteiNyushoshaHiyo {

    public ResponseData<TokuteiNyushoshaHiyoDiv> onLoad(TokuteiNyushoshaHiyoDiv div) {
        // TODO　サービス提供証明書画面ViewState
        FlexibleYearMonth サービス年月 = new FlexibleYearMonth(new RString("200405"));
        HihokenshaNo 被保険者番号 = new HihokenshaNo("1");
        RString 整理番号 = new RString("123456");
        JigyoshaNo 事業者番号 = new JigyoshaNo("2");
        RString 様式番号 = new RString("2345");
        RString 申請日 = new RString("20151124");
        RString 明細番号 = new RString("3456");
        RString 証明書 = new RString("証明書");
        // TODO「介護宛名情報」共有子Divの初期化
//        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.状態, ShikibetsuCode.class);
//        div.getPanelCcd().getCcdKaigoAtenaInfo().load(識別コード);

        // TODO 「介護資格系基本情報」共有子Div の初期化
        if (!被保険者番号.isEmpty()) {
            // TODO load----initialize
            div.getPanelCcd().getCcdKaigoShikakuKihon().initialize(被保険者番号);
        } else {
            div.getPanelCcd().getCcdKaigoShikakuKihon().setVisible(false);
        }
        getHandler(div).setヘッダーエリア(サービス年月, 事業者番号, 申請日, 明細番号, 証明書);
        // TODO　申請書検索ViewSate．様式番号
//        RString 様式番号 =ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        // TODO 特定入所者費用データの取得
        List<ShokanTokuteiNyushoshaKaigoServiceHiyo> serviceHiyoList = ShokanbaraiJyokyoShokai.createInstance()
                .getTokuteyiNyushosyaKaigoserviceHiyo(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null);
        if (serviceHiyoList == null || serviceHiyoList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        getHandler(div).set特定入所者費用一覧グリッド(serviceHiyoList);

        ShikibetsuNoKanriEntity shikibetsuNoKanriEntity = ShokanbaraiJyokyoShokai.createInstance()
                .getShikibetsubangoKanri(サービス年月, 様式番号);
        getHandler(div).setボタン表示制御処理(shikibetsuNoKanriEntity, サービス年月);
        div.getPanelTokutei().getPanelMeisai().setVisible(false);
        return createResponse(div);
    }

    public ResponseData<TokuteiNyushoshaHiyoDiv> onClick_btnKihonInfo(TokuteiNyushoshaHiyoDiv div) {
        return createResponse(div);
    }

    public ResponseData<TokuteiNyushoshaHiyoDiv> onClick_btnKyufuhiMeisai(TokuteiNyushoshaHiyoDiv div) {
        return createResponse(div);
    }

    public ResponseData<TokuteiNyushoshaHiyoDiv> onClick_btnTokuteiShinryouhi(TokuteiNyushoshaHiyoDiv div) {
        return createResponse(div);
    }

    public ResponseData<TokuteiNyushoshaHiyoDiv> onClick_btnServiceKeikakuhi(TokuteiNyushoshaHiyoDiv div) {
        return createResponse(div);
    }

    public ResponseData<TokuteiNyushoshaHiyoDiv> onClick_btnGoukeiInfo(TokuteiNyushoshaHiyoDiv div) {
        return createResponse(div);
    }

    public ResponseData<TokuteiNyushoshaHiyoDiv> onClick_btnKyufuhiMeisaiJyutoku(TokuteiNyushoshaHiyoDiv div) {
        return createResponse(div);
    }

    public ResponseData<TokuteiNyushoshaHiyoDiv> onClick_btnKinkyujiShisetsuRyoyo(TokuteiNyushoshaHiyoDiv div) {
        return createResponse(div);
    }

    public ResponseData<TokuteiNyushoshaHiyoDiv> onClick_btnKinkyujiShoteiShikkan(TokuteiNyushoshaHiyoDiv div) {
        return createResponse(div);
    }

    public ResponseData<TokuteiNyushoshaHiyoDiv> onClick_btnShokujiHiyo(TokuteiNyushoshaHiyoDiv div) {
        return createResponse(div);
    }

    public ResponseData<TokuteiNyushoshaHiyoDiv> onClick_btnSeikyugakuShukei(TokuteiNyushoshaHiyoDiv div) {
        return createResponse(div);
    }

    public ResponseData<TokuteiNyushoshaHiyoDiv> onClick_btnShafukukeigengaku(TokuteiNyushoshaHiyoDiv div) {
        return createResponse(div);
    }

    public ResponseData<TokuteiNyushoshaHiyoDiv> onClick_dgdTokuteiYichiran(TokuteiNyushoshaHiyoDiv div) {
        FlexibleYearMonth サービス年月 = new FlexibleYearMonth(new RString("200405"));
        getHandler(div).set特定入所者費用照会パネル(サービス年月);
        div.getPanelTokutei().getPanelMeisai().setVisible(true);
        return createResponse(div);
    }

    public ResponseData<TokuteiNyushoshaHiyoDiv> onClick_btnclose(TokuteiNyushoshaHiyoDiv div) {
        div.getPanelTokutei().getPanelMeisai().setVisible(false);
        return createResponse(div);
    }

    public ResponseData<TokuteiNyushoshaHiyoDiv> onClick_btnBack(TokuteiNyushoshaHiyoDiv div) {
        // TODO DBC0810014_サービス提供証明書画面へ遷移する
        return createResponse(div);
    }

    private TokuteiNyushoshaHiyoHandler getHandler(TokuteiNyushoshaHiyoDiv div) {
        return new TokuteiNyushoshaHiyoHandler(div);
    }

    private ResponseData<TokuteiNyushoshaHiyoDiv> createResponse(TokuteiNyushoshaHiyoDiv div) {
        return ResponseData.of(div).respond();
    }
}
