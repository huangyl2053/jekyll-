/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0810032;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810032.KyufuShiharayiMeisaiJyuTokuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0810032.KyufuShiharayiMeisaiJyuTokuHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0810014.ServiceTeiKyoShomeishoParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShikibetsuNoKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShokanMeisaiJushochiTokureiEntity;
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
public class KyufuShiharayiMeisaiJyuToku {

    public ResponseData<KyufuShiharayiMeisaiJyuTokuDiv> onLoad(KyufuShiharayiMeisaiJyuTokuDiv div) {
        ServiceTeiKyoShomeishoParameter parmeter = new ServiceTeiKyoShomeishoParameter(
                new HihokenshaNo("000000033"), new FlexibleYearMonth(new RString("201601")),
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

        // div.getPanelOne().getCcdKaigoAtenaInfo().load(識別コード);
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
            // TODO 凌護行 param不正、 QA回答まち
            //     div.getPanelOne().getCcdKaigoShikakuKihon().load(LasdecCode.EMPTY, 識別コード);
        } else {
            div.getPanelOne().getCcdKaigoShikakuKihon().setVisible(false);

        }
        getHandler(div).setヘッダーエリア(サービス年月, 事業者番号,
                ViewStateHolder.get(ViewStateKeys.申請日, RString.class), 明細番号, 証明書);
        List<ShokanMeisaiJushochiTokureiEntity> entityList = ShokanbaraiJyokyoShokai.createInstance().
                getShokanbarayiSeikyuMeisayiJyutokuList(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, 明細番号, サービス種類コード);
        if (entityList == null || entityList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        getHandler(div).initialize(entityList);
        ShikibetsuNoKanriEntity shikibetsuNoKanriEntity = ShokanbaraiJyokyoShokai.createInstance()
                .getShikibetsubangoKanri(サービス年月, 様式番号);
        getHandler(div).setボタン表示制御処理(shikibetsuNoKanriEntity, サービス年月);
        div.getPanelFour().setVisible(false);
        return createResponse(div);
    }

    public ResponseData<KyufuShiharayiMeisaiJyuTokuDiv> onClick_btnKihonInfo(KyufuShiharayiMeisaiJyuTokuDiv div) {
        // DBC0810021_基本情報画面へ遷移する
        return createResponse(div);

    }

    public ResponseData<KyufuShiharayiMeisaiJyuTokuDiv> onClick_btnKyufuMeisai(KyufuShiharayiMeisaiJyuTokuDiv div) {
        // DBC0810032_給付費明細(住所地特例)画面へ遷移する
        return createResponse(div);

    }

    public ResponseData<KyufuShiharayiMeisaiJyuTokuDiv> onClick_btnTokuteiShinryouhi(KyufuShiharayiMeisaiJyuTokuDiv div) {
        // DBC0810023_特定診療費画面へ遷移する
        return createResponse(div);

    }

    public ResponseData<KyufuShiharayiMeisaiJyuTokuDiv> onClick_btnServiceKeikakuhi(KyufuShiharayiMeisaiJyuTokuDiv div) {
        // DBC0810024_サービス計画費画面へ遷移する
        return createResponse(div);

    }

    public ResponseData<KyufuShiharayiMeisaiJyuTokuDiv> onClick_btnTokuteiNyushosya(KyufuShiharayiMeisaiJyuTokuDiv div) {
        // DBC0810025_特定入所者費用画面へ遷移する
        return createResponse(div);

    }

    public ResponseData<KyufuShiharayiMeisaiJyuTokuDiv> onClick_btnGoukeiInfo(KyufuShiharayiMeisaiJyuTokuDiv div) {
        // DBC0810026_合計情報画面へ遷移する
        return createResponse(div);

    }

    public ResponseData<KyufuShiharayiMeisaiJyuTokuDiv> onClick_btnKinkyushisetuRyoyouhi(KyufuShiharayiMeisaiJyuTokuDiv div) {
        // DBC0810027_緊急時施設療養費画面へ遷移する
        return createResponse(div);

    }

    public ResponseData<KyufuShiharayiMeisaiJyuTokuDiv> onClick_btnShokujihiyo(KyufuShiharayiMeisaiJyuTokuDiv div) {
        // DBC0810029_食事費用画面へ遷移する
        return createResponse(div);

    }

    public ResponseData<KyufuShiharayiMeisaiJyuTokuDiv> onClick_btnSeikyugakuShukei(KyufuShiharayiMeisaiJyuTokuDiv div) {
        // DBC0810030_請求額集計画面へ遷移する
        return createResponse(div);

    }

    public ResponseData<KyufuShiharayiMeisaiJyuTokuDiv> onClick_btnShafukukeigenGaku(KyufuShiharayiMeisaiJyuTokuDiv div) {
        // DBC0810031_社福軽減額画面へ遷移する
        return createResponse(div);

    }

    public ResponseData<KyufuShiharayiMeisaiJyuTokuDiv> onClick_selectButton(KyufuShiharayiMeisaiJyuTokuDiv div) {
        getHandler(div).set給付費明細();
        div.getPanelFour().setVisible(true);
        return createResponse(div);

    }

    private KyufuShiharayiMeisaiJyuTokuHandler getHandler(KyufuShiharayiMeisaiJyuTokuDiv div) {
        return new KyufuShiharayiMeisaiJyuTokuHandler(div);
    }

    private ResponseData<KyufuShiharayiMeisaiJyuTokuDiv> createResponse(KyufuShiharayiMeisaiJyuTokuDiv div) {
        return ResponseData.of(div).respond();
    }

}
