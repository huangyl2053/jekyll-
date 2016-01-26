/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0810022;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810022.KyufuShiharayiMeisaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0810022.KyufuShiharayiMeisaiHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author quxiaodong
 */
public class KyufuShiharayiMeisai {

    public ResponseData<KyufuShiharayiMeisaiDiv> onLoad(KyufuShiharayiMeisaiDiv div) {

        ShikibetsuCode 識別コード = new ShikibetsuCode(new RString("123456"));
        FlexibleYearMonth サービス年月 = new FlexibleYearMonth(new RString("200904"));
        HihokenshaNo 被保険者番号 = new HihokenshaNo("1");
        RString 整理番号 = new RString("123456");
        RString 様式番号 = new RString("2345");
        RString 申請日 = new RString("20151124");
        RString 明細番号 = new RString("3456");
        JigyoshaNo 事業者番号 = new JigyoshaNo("2");
        RString 証明書 = new RString("証明書");

        div.getPanelOne().getCcdKaigoAtenaInfo().load(識別コード);
        //  div.getPanelOne().getCcdKaigoShikakuKihon().load(LasdecCode.EMPTY, 識別コード);
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
            // TODO 凌護行 param不正、 QA回答まち
            //     div.getPanelOne().getCcdKaigoShikakuKihon().load(LasdecCode.EMPTY, 識別コード);
        } else {
            div.getPanelOne().getCcdKaigoShikakuKihon().setVisible(false);

        }
        // TODO ShokanbaraiJyokyoShokai暂无
        // ShokanbaraiJyokyoShokai  shjyShokai=new ShokanbaraiJyokyoShokai;
        // List<ShokanMeisaiJushochiTokurei> entityList =shjyShokai.getShokanbarayiSeikyuMeisayiList(サービス年月, 被保険者番号, 整理番号, 事業者番号, 明細番号,様式番号);
        //  if (entityList == null || entityList.isEmpty()) {
        //        throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        //  }
        // getHandler(div).initialize(entityList);

        return createResponse(div);
    }

    /**
     * 基本情報ボタンを押下した際に実行します。<br/>
     * DBC0810021_基本情報画面へ遷移する
     *
     * @param div {@link KyufuShiharayiMeisaiDiv サービス計画費画面Div}
     * @return サービス計画費画面Divを持つResponseData
     */
    public ResponseData<KyufuShiharayiMeisaiDiv> onClick_btnKihonInfo(KyufuShiharayiMeisaiDiv div) {
        // DBC0810021_基本情報画面へ遷移する
        return createResponse(div);

    }

    public ResponseData<KyufuShiharayiMeisaiDiv> onClick_btnKyufuMeisai(KyufuShiharayiMeisaiDiv div) {
        // DBC0810032_給付費明細(住所地特例)画面へ遷移する
        return createResponse(div);

    }

    public ResponseData<KyufuShiharayiMeisaiDiv> onClick_btnTokuteiShinryouhi(KyufuShiharayiMeisaiDiv div) {
        // DBC0810023_特定診療費画面へ遷移する
        return createResponse(div);

    }

    public ResponseData<KyufuShiharayiMeisaiDiv> onClick_btnServiceKeikakuhi(KyufuShiharayiMeisaiDiv div) {
        // DBC0810024_サービス計画費画面へ遷移する
        return createResponse(div);

    }

    public ResponseData<KyufuShiharayiMeisaiDiv> onClick_btnTokuteiNyushosya(KyufuShiharayiMeisaiDiv div) {
        // DBC0810025_特定入所者費用画面へ遷移する
        return createResponse(div);

    }

    public ResponseData<KyufuShiharayiMeisaiDiv> onClick_btnGoukeiInfo(KyufuShiharayiMeisaiDiv div) {
        // DBC0810026_合計情報画面へ遷移する
        return createResponse(div);

    }

    public ResponseData<KyufuShiharayiMeisaiDiv> onClick_btnKinkyushisetuRyoyouhi(KyufuShiharayiMeisaiDiv div) {
        // DBC0810027_緊急時施設療養費画面へ遷移する
        return createResponse(div);

    }

    public ResponseData<KyufuShiharayiMeisaiDiv> onClick_btnShokujihiyo(KyufuShiharayiMeisaiDiv div) {
        // DBC0810029_食事費用画面へ遷移する
        return createResponse(div);

    }

    public ResponseData<KyufuShiharayiMeisaiDiv> onClick_btnSeikyugakuShukei(KyufuShiharayiMeisaiDiv div) {
        // DBC0810030_請求額集計画面へ遷移する
        return createResponse(div);

    }

    public ResponseData<KyufuShiharayiMeisaiDiv> onClick_btnShafukukeigenGaku(KyufuShiharayiMeisaiDiv div) {
        // DBC0810031_社福軽減額画面へ遷移する
        return createResponse(div);

    }

    public ResponseData<KyufuShiharayiMeisaiDiv> onClick_selectButton(KyufuShiharayiMeisaiDiv div) {

        return createResponse(div);

    }

    private KyufuShiharayiMeisaiHandler getHandler(KyufuShiharayiMeisaiDiv div) {
        return new KyufuShiharayiMeisaiHandler(div);
    }

    private ResponseData<KyufuShiharayiMeisaiDiv> createResponse(KyufuShiharayiMeisaiDiv div) {
        return ResponseData.of(div).respond();
    }
}
