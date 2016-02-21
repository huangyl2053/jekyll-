/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0810022;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShikibetsuNoKanriResult;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanMeisaiResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810022.KyufuShiharayiMeisaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0810022.KyufuShiharayiMeisaiHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0810014.ServiceTeiKyoShomeishoParameter;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * @author quxiaodong
 */
public class KyufuShiharayiMeisai {

    public ResponseData<KyufuShiharayiMeisaiDiv> onLoad(KyufuShiharayiMeisaiDiv div) {

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

        RString 明細番号 = parameter.getMeisaiNo();
        RString 証明書 = parameter.getServiceYM();
        JigyoshaNo 事業者番号 = parameter.getJigyoshaNo();
        // TODO 該当者検索画面ViewState．識別コード
        ViewStateHolder.put(ViewStateKeys.識別コード, new ShikibetsuCode("2"));
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        // TODO 申請書検索ViewSate．様式番号
        ViewStateHolder.put(ViewStateKeys.様式番号, new RString("0003"));
        RString 様式番号 = ViewStateHolder.get(ViewStateKeys.様式番号, RString.class);
        // TODO 申請検索画面ViewState. 申請日
        ViewStateHolder.put(ViewStateKeys.申請日, new RString("20151124"));
        ServiceShuruiCode サービス種類コード = new ServiceShuruiCode("222222");
        div.getPanelOne().getCcdKaigoAtenaInfo().load(識別コード);
        //  div.getPanelOne().getCcdKaigoShikakuKihon().load(LasdecCode.EMPTY, 識別コード);
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
            // TODO 凌護行 param不正、 QA回答まち
            //     div.getPanelOne().getCcdKaigoShikakuKihon().load(LasdecCode.EMPTY, 識別コード);
        } else {
            div.getPanelOne().getCcdKaigoShikakuKihon().setVisible(false);

        }
        getHandler(div).setヘッダーエリア(サービス年月, 事業者番号,
                ViewStateHolder.get(ViewStateKeys.申請日, RString.class), 明細番号, 証明書);
        List<ShokanMeisaiResult> entityList = ShokanbaraiJyokyoShokai.createInstance().getShokanbarayiSeikyuMeisayiList(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, 様式番号, サービス種類コード);
        if (entityList == null || entityList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        getHandler(div).initialize(entityList);
        ShikibetsuNoKanriResult shikibetsuNoKanriEntity = ShokanbaraiJyokyoShokai.createInstance()
                .getShikibetsubangoKanri(サービス年月, 様式番号);
        getHandler(div).setボタン表示制御処理(shikibetsuNoKanriEntity, サービス年月);
        div.getPanelFour().setVisible(false);

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
        getHandler(div).set給付費明細();
        div.getPanelFour().setVisible(true);
        return createResponse(div);

    }

    private KyufuShiharayiMeisaiHandler getHandler(KyufuShiharayiMeisaiDiv div) {
        return new KyufuShiharayiMeisaiHandler(div);
    }

    private ResponseData<KyufuShiharayiMeisaiDiv> createResponse(KyufuShiharayiMeisaiDiv div) {
        return ResponseData.of(div).respond();
    }
}
