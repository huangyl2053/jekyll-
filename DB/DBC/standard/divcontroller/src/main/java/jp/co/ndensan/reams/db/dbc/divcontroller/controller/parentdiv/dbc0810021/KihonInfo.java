/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0810021;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810021.KihonInfoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0810021.KihonInfoHandler;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.KaigoJigyoshaReturnEntity;
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
 *
 * 償還払い状況照会_基本情報画面のクラスです。
 *
 * @author wangkanglei
 */
public class KihonInfo {

    public ResponseData<KihonInfoDiv> onLoad(KihonInfoDiv div) {

        // TODO 引き継ぎデータの取得
        ShikibetsuCode 識別コード = new ShikibetsuCode(new RString("123456"));
        FlexibleYearMonth サービス年月 = new FlexibleYearMonth(new RString("200905"));
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

        List<ShokanKihon> shokanKihonList = ShokanbaraiJyokyoShokai.createInstance()
                .getShokanbarayiSeikyukihonDetail(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        if (shokanKihonList == null || shokanKihonList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }

        KaigoJigyoshaReturnEntity kaigoJigyoshaEntity = ShokanbaraiJyokyoShokai.createInstance()
                .getKaigoJigyoshaInfo(サービス年月, 事業者番号);
        getHandler(div).set基本内容エリア(shokanKihonList, kaigoJigyoshaEntity, サービス年月);

        ShikibetsuNoKanriEntity shikibetsuNoKanriEntity = ShokanbaraiJyokyoShokai.createInstance()
                .getShikibetsubangoKanri(サービス年月, 様式番号);
        getHandler(div).setボタン表示制御処理(shikibetsuNoKanriEntity, サービス年月);

        return createResponse(div);
    }

    public ResponseData<KihonInfoDiv> onClick_btnKyufuhiMeisaiDown(KihonInfoDiv div) {
        // TODO DBC0810022_給付費明細画面へ遷移する
        return createResponse(div);
    }

    public ResponseData<KihonInfoDiv> onClick_btnTokuteiShinryohi(KihonInfoDiv div) {
        // TODO DBC0810023_特定診療費画面へ遷移する
        return createResponse(div);
    }

    public ResponseData<KihonInfoDiv> onClick_btnServiceKeikakuhi(KihonInfoDiv div) {
        // TODO DBC0810024_サービス計画費画面へ遷移する
        return createResponse(div);
    }

    public ResponseData<KihonInfoDiv> onClick_btnTokuteiNyushosyaHiyo(KihonInfoDiv div) {
        // TODO DBC0810025_特定入所者費用画面へ遷移する
        return createResponse(div);
    }

    public ResponseData<KihonInfoDiv> onClick_btnGokeiInfo(KihonInfoDiv div) {
        // TODO DBC0810026_合計情報画面へ遷移する
        return createResponse(div);
    }

    public ResponseData<KihonInfoDiv> onClick_btnKyufuhiMeisaiJyutoku(KihonInfoDiv div) {
        // TODO DBC0810032_給付費明細(住所地特例)画面へ遷移する
        return createResponse(div);
    }

    public ResponseData<KihonInfoDiv> onClick_btnKinkyujiShisetuRyoyouhi(KihonInfoDiv div) {
        // TODO DBC0810027_緊急時施設療養費画面へ遷移する
        return createResponse(div);
    }

    public ResponseData<KihonInfoDiv> onClick_btnKinkyujiShoteiShikkan(KihonInfoDiv div) {
        // TODO DBC0810028_緊急時・所定疾患画面へ遷移する
        return createResponse(div);
    }

    public ResponseData<KihonInfoDiv> onClick_btnSyokujiHiyo(KihonInfoDiv div) {
        // TODO DBC0810029_食事費用画面へ遷移する
        return createResponse(div);
    }

    public ResponseData<KihonInfoDiv> onClick_btnSeikyugakuShukei(KihonInfoDiv div) {
        // TODO DBC0810030_請求額集計画面へ遷移する
        return createResponse(div);
    }

    public ResponseData<KihonInfoDiv> onClick_btnShafukuKeigenGaku(KihonInfoDiv div) {
        // TODO DBC0810031_社福軽減額画面へ遷移する
        return createResponse(div);
    }

    public ResponseData<KihonInfoDiv> onClick_btnBack(KihonInfoDiv div) {
        // TODO DBC0810014_サービス提供証明書画面へ遷移する
        return createResponse(div);
    }

    private KihonInfoHandler getHandler(KihonInfoDiv div) {
        return new KihonInfoHandler(div);
    }

    private ResponseData<KihonInfoDiv> createResponse(KihonInfoDiv div) {
        return ResponseData.of(div).respond();
    }
}
