/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0810030;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810030.SeikyuGakuShukeiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810030.dgdSeikyugakushukei_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0810030.SeikyuGakuShukeiHandler;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShokanShukeiEntity;
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
 * @author quxiaodong
 */
public class SeikyuGakuShukei {

    public ResponseData<SeikyuGakuShukeiDiv> onLoad(SeikyuGakuShukeiDiv div) {

        ShikibetsuCode 識別コード = new ShikibetsuCode(new RString("123456"));
        FlexibleYearMonth サービス年月 = new FlexibleYearMonth(new RString("200904"));
        HihokenshaNo 被保険者番号 = new HihokenshaNo("1");
        RString 整理番号 = new RString("123456");
        RString 様式番号 = new RString("2345");
        RString 申請日 = new RString("20151124");
        RString 明細番号 = new RString("3456");
        JigyoshaNo 事業者番号 = new JigyoshaNo("2");
        RString 証明書 = new RString("証明書");

        div.getPanelCcd().getCcdKaigoAtenaInfo().load(識別コード);
        //  div.getPanelCcd().getCcdKaigoShikakuKihon().load(LasdecCode.EMPTY, 識別コード);
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
            // TODO 凌護行 param不正、 QA回答まち
            //     div.getPanelCcd().getCcdKaigoShikakuKihon().load(LasdecCode.EMPTY, 識別コード);
        } else {
            div.getPanelCcd().getCcdKaigoShikakuKihon().setVisible(false);

        }
        // TODO ShokanbaraiJyokyoShokai暂无
        List<ShokanShukeiEntity> entityList = ShokanbaraiJyokyoShokai.createInstance().getSeikyuShukeiData(
                被保険者番号,
                サービス年月,
                整理番号,
                事業者番号,
                様式番号,
                明細番号, null);
        if (entityList == null || entityList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        getHandler(div).initialize(entityList);

        return createResponse(div);
    }

    public ResponseData<SeikyuGakuShukeiDiv> onClick_btnKihonInfo(SeikyuGakuShukeiDiv div) {
        // DBC0810021_基本情報画面へ遷移する
        return createResponse(div);

    }

    public ResponseData<SeikyuGakuShukeiDiv> onClick_btnKyufuMeisai(SeikyuGakuShukeiDiv div) {
        // DBC0810032_給付費明細(住所地特例)画面へ遷移する
        return createResponse(div);

    }

    public ResponseData<SeikyuGakuShukeiDiv> onClick_btnTokuteiShinryouhi(SeikyuGakuShukeiDiv div) {
        // DBC0810023_特定診療費画面へ遷移する
        return createResponse(div);

    }

    public ResponseData<SeikyuGakuShukeiDiv> onClick_btnServiceKeikakuhi(SeikyuGakuShukeiDiv div) {
        // DBC0810024_サービス計画費画面へ遷移する
        return createResponse(div);

    }

    public ResponseData<SeikyuGakuShukeiDiv> onClick_btnTokuteiNyushosya(SeikyuGakuShukeiDiv div) {
        // DBC0810025_特定入所者費用画面へ遷移する
        return createResponse(div);

    }

    public ResponseData<SeikyuGakuShukeiDiv> onClick_btnGoukeiInfo(SeikyuGakuShukeiDiv div) {
        // DBC0810026_合計情報画面へ遷移する
        return createResponse(div);

    }

    public ResponseData<SeikyuGakuShukeiDiv> onClick_btnKinkyushisetuRyoyouhi(SeikyuGakuShukeiDiv div) {
        // DBC0810027_緊急時施設療養費画面へ遷移する
        return createResponse(div);

    }

    public ResponseData<SeikyuGakuShukeiDiv> onClick_btnShokujihiyo(SeikyuGakuShukeiDiv div) {
        // DBC0810029_食事費用画面へ遷移する
        return createResponse(div);

    }

    public ResponseData<SeikyuGakuShukeiDiv> onClick_btnSeikyugakuShukei(SeikyuGakuShukeiDiv div) {
        // DBC0810030_請求額集計画面へ遷移する
        return createResponse(div);

    }

    public ResponseData<SeikyuGakuShukeiDiv> onClick_btnShafukukeigenGaku(SeikyuGakuShukeiDiv div) {
        // DBC0810031_社福軽減額画面へ遷移する
        return createResponse(div);

    }

    public ResponseData<SeikyuGakuShukeiDiv> onClick_selectButton(SeikyuGakuShukeiDiv div) {
        ShikibetsuCode 識別コード = new ShikibetsuCode(new RString("123456"));
        FlexibleYearMonth サービス年月 = new FlexibleYearMonth(new RString("200904"));
        HihokenshaNo 被保険者番号 = new HihokenshaNo("1");
        RString 整理番号 = new RString("123456");
        RString 様式番号 = new RString("2345");
        RString 申請日 = new RString("20151124");
        RString 明細番号 = new RString("3456");
        JigyoshaNo 事業者番号 = new JigyoshaNo("2");
        RString 証明書 = new RString("証明書");
        dgdSeikyugakushukei_Row row = div.getPanelSeikyugakuShukei().getDgdSeikyugakushukei().getClickedItem();
        List<ShokanShukeiEntity> entityList = ShokanbaraiJyokyoShokai.createInstance().getSeikyuShukeiData(
                被保険者番号,
                サービス年月,
                整理番号,
                事業者番号,
                様式番号,
                明細番号, null);
        if (entityList == null || entityList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        List<ShokanKihon> list = ShokanbaraiJyokyoShokai.createInstance().getShokanbarayiSeikyukihonDetail(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        getHandler(div).selectButton(entityList, list.get(0));
        return createResponse(div);

    }

    private SeikyuGakuShukeiHandler getHandler(SeikyuGakuShukeiDiv div) {

        return new SeikyuGakuShukeiHandler(div);
    }

    private ResponseData<SeikyuGakuShukeiDiv> createResponse(SeikyuGakuShukeiDiv div) {
        return ResponseData.of(div).respond();
    }

}
