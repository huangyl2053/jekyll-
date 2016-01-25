/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0810023;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiShinryoTokubetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiShinryohi;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810023.TokuteiShinryohiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810023.dgdTokuteiShinryohi_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0810023.TokuteiShinryohiHandler;
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
 * 償還払い状況照会_特定診療費画面のクラスです。
 *
 * @author wangkanglei
 */
public class TokuteiShinryohi {

    public ResponseData<TokuteiShinryohiDiv> onLoad(TokuteiShinryohiDiv div) {
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
//        div.getPanelOne().getCcdKaigoAtenaInfo().load(識別コード);
        // TODO 「介護資格系基本情報」共有子Div の初期化
        if (!被保険者番号.isEmpty()) {
            // TODO load----initialize
            div.getPanelOne().getCcdKaigoShikakuKihon().initialize(被保険者番号);
        } else {
            div.getPanelOne().getCcdKaigoShikakuKihon().setVisible(false);
        }
        getHandler(div).setヘッダーエリア(サービス年月, 事業者番号, 申請日, 明細番号, 証明書);

        if (サービス年月.isBeforeOrEquals(new FlexibleYearMonth("200503"))) {
            div.getDgdTokuteiShinryohi().setVisible(false);
            div.getDdgToteishinryoTokubetushinryo().setVisible(true);
            div.getPanelFour().setVisible(false);
            div.getPanelFive().setVisible(false);
            List<ShokanTokuteiShinryohi> shokanTokuteiShinryohiList = ShokanbaraiJyokyoShokai.createInstance()
                    .getTokuteiShinryohiData(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null);
            if (shokanTokuteiShinryohiList == null || shokanTokuteiShinryohiList.isEmpty()) {
                throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
            }
            getHandler(div).set特定診療費一覧グリッド(shokanTokuteiShinryohiList);
        }
        if (new FlexibleYearMonth("200504").isBeforeOrEquals(サービス年月)) {
            div.getDgdTokuteiShinryohi().setVisible(true);
            div.getDdgToteishinryoTokubetushinryo().setVisible(false);
            div.getPanelFour().setVisible(false);
            div.getPanelFive().setVisible(false);
            List<ShokanTokuteiShinryoTokubetsuRyoyo> shokanTokuteiShinryoTokubetsuRyoyoList = ShokanbaraiJyokyoShokai.createInstance()
                    .getTokuteyiShinnryouhiTokubeturyoyohi(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null);
            if (shokanTokuteiShinryoTokubetsuRyoyoList == null || shokanTokuteiShinryoTokubetsuRyoyoList.isEmpty()) {
                throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
            }
            getHandler(div).set特定診療費_特別診療費一覧グリッド(shokanTokuteiShinryoTokubetsuRyoyoList);
        }
        ShikibetsuNoKanriEntity shikibetsuNoKanriEntity = ShokanbaraiJyokyoShokai.createInstance()
                .getShikibetsubangoKanri(サービス年月, 様式番号);
        getHandler(div).setボタン表示制御処理(shikibetsuNoKanriEntity, サービス年月);

        return createResponse(div);
    }

    public ResponseData<TokuteiShinryohiDiv> onClick_dgdTokuteiShinryohi(TokuteiShinryohiDiv div) {
        // TODO
        FlexibleYearMonth サービス年月 = new FlexibleYearMonth(new RString("200405"));
        HihokenshaNo 被保険者番号 = new HihokenshaNo("1");
        RString 整理番号 = new RString("123456");
        JigyoshaNo 事業者番号 = new JigyoshaNo("2");
        RString 様式番号 = new RString("2345");
        RString 申請日 = new RString("20151124");
        RString 明細番号 = new RString("3456");
        RString 証明書 = new RString("証明書");
        dgdTokuteiShinryohi_Row row = div.getDgdTokuteiShinryohi().getClickedItem();
        List<ShokanTokuteiShinryoTokubetsuRyoyo> shokanTokuteiShinryoTokubetsuRyoyoList = ShokanbaraiJyokyoShokai.createInstance()
                .getTokuteyiShinnryouhiTokubeturyoyohi(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null);
        if (shokanTokuteiShinryoTokubetsuRyoyoList == null || shokanTokuteiShinryoTokubetsuRyoyoList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        getHandler(div).set特定診療費_特別診療費パネル(shokanTokuteiShinryoTokubetsuRyoyoList, サービス年月);
        div.getPanelFour().setVisible(false);
        div.getPanelFive().setVisible(true);
        return createResponse(div);
    }

    public ResponseData<TokuteiShinryohiDiv> onClick_ddgToteishinryoTokubetushinryo(TokuteiShinryohiDiv div) {
        // TODO
        FlexibleYearMonth サービス年月 = new FlexibleYearMonth(new RString("200405"));
        HihokenshaNo 被保険者番号 = new HihokenshaNo("1");
        RString 整理番号 = new RString("123456");
        JigyoshaNo 事業者番号 = new JigyoshaNo("2");
        RString 様式番号 = new RString("2345");
        RString 申請日 = new RString("20151124");
        RString 明細番号 = new RString("3456");
        RString 証明書 = new RString("証明書");
        List<ShokanTokuteiShinryohi> shokanTokuteiShinryohiList = ShokanbaraiJyokyoShokai.createInstance()
                .getTokuteiShinryohiData(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null);
        if (shokanTokuteiShinryohiList == null || shokanTokuteiShinryohiList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        getHandler(div).set特定診療費パネル(shokanTokuteiShinryohiList);
        div.getPanelFour().setVisible(true);
        div.getPanelFive().setVisible(false);
        return createResponse(div);
    }

    public ResponseData<TokuteiShinryohiDiv> onClick_btnKihoninfo(TokuteiShinryohiDiv div) {
        return createResponse(div);
    }

    public ResponseData<TokuteiShinryohiDiv> onClick_btnKyufuMeisai(TokuteiShinryohiDiv div) {
        return createResponse(div);
    }

    public ResponseData<TokuteiShinryohiDiv> onClick_btnServiceKeikakuhi(TokuteiShinryohiDiv div) {
        return createResponse(div);
    }

    public ResponseData<TokuteiShinryohiDiv> onClick_btnTokuteinyushosha(TokuteiShinryohiDiv div) {
        return createResponse(div);
    }

    public ResponseData<TokuteiShinryohiDiv> onClick_btnGokeiinfo(TokuteiShinryohiDiv div) {
        return createResponse(div);
    }

    public ResponseData<TokuteiShinryohiDiv> onClick_btnKyufuhiMeisaiJyutoku(TokuteiShinryohiDiv div) {
        return createResponse(div);
    }

    public ResponseData<TokuteiShinryohiDiv> onClick_btnKinkyujiShisetsu(TokuteiShinryohiDiv div) {
        return createResponse(div);
    }

    public ResponseData<TokuteiShinryohiDiv> onClick_btnKinkyujiShoteiShikkan(TokuteiShinryohiDiv div) {
        return createResponse(div);
    }

    public ResponseData<TokuteiShinryohiDiv> onClick_btnShokujihiyo(TokuteiShinryohiDiv div) {
        return createResponse(div);
    }

    public ResponseData<TokuteiShinryohiDiv> onClick_btnSeikyugaku(TokuteiShinryohiDiv div) {
        return createResponse(div);
    }

    public ResponseData<TokuteiShinryohiDiv> onClick_btnShafuku(TokuteiShinryohiDiv div) {
        return createResponse(div);
    }

    public ResponseData<TokuteiShinryohiDiv> onClick_btnCloseUp(TokuteiShinryohiDiv div) {
        div.getPanelFour().setVisible(false);
        return createResponse(div);
    }

    public ResponseData<TokuteiShinryohiDiv> onClick_btnCloseDown(TokuteiShinryohiDiv div) {
        div.getPanelFive().setVisible(false);
        return createResponse(div);
    }

    public ResponseData<TokuteiShinryohiDiv> onClick_btnBack(TokuteiShinryohiDiv div) {
        return createResponse(div);
    }

    private TokuteiShinryohiHandler getHandler(TokuteiShinryohiDiv div) {
        return new TokuteiShinryohiHandler(div);
    }

    private ResponseData<TokuteiShinryohiDiv> createResponse(TokuteiShinryohiDiv div) {
        return ResponseData.of(div).respond();
    }
}
