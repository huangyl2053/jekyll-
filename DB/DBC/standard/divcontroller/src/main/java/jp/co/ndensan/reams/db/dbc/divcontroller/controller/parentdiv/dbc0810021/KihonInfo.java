/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0810021;

import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.KaigoJigyoshaReturnEntity;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShikibetsuNoKanriResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810021.KihonInfoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0810021.KihonInfoHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0810014.ServiceTeiKyoShomeishoParameter;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 償還払い状況照会_基本情報画面のクラスです。
 */
public class KihonInfo {

    /**
     * 画面初期化
     *
     * @param div KihonInfoDiv
     * @return ResponseData
     */
    public ResponseData<KihonInfoDiv> onLoad(KihonInfoDiv div) {

        // TODO 引き継ぎデータの取得
        ServiceTeiKyoShomeishoParameter parmeter = new ServiceTeiKyoShomeishoParameter(
                new HihokenshaNo("000000003"), new FlexibleYearMonth(new RString("201203")),
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
        ViewStateHolder.put(ViewStateKeys.識別コード, new ShikibetsuCode("000000000000010"));
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        // TODO 申請書検索ViewSate．様式番号
        ViewStateHolder.put(ViewStateKeys.様式番号, new RString("0003"));
        RString 様式番号 = ViewStateHolder.get(ViewStateKeys.様式番号, RString.class);
        // TODO 申請検索画面ViewState. 申請日
        ViewStateHolder.put(ViewStateKeys.申請日, new RString("20151124"));

        div.getPanelCcd().getCcdKaigoAtenaInfo().onLoad(識別コード);
        if (!被保険者番号.isEmpty()) {
            div.getPanelCcd().getCcdKaigoShikakuKihon().onLoad(被保険者番号);
        } else {
            div.getPanelCcd().getCcdKaigoShikakuKihon().setVisible(false);
        }
        getHandler(div).setヘッダーエリア(サービス年月, 事業者番号,
                ViewStateHolder.get(ViewStateKeys.申請日, RString.class), 明細番号, 証明書);

        ShokanKihon shokanKihon = ShokanbaraiJyokyoShokai.createInstance()
                .getShokanbarayiSeikyukihonDetail(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        if (shokanKihon == null) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        KaigoJigyoshaReturnEntity kaigoJigyoshaEntity = ShokanbaraiJyokyoShokai.createInstance()
                .getKaigoJigyoshaInfo(サービス年月, 事業者番号);
        getHandler(div).set基本内容エリア(shokanKihon, kaigoJigyoshaEntity, サービス年月);

        ShikibetsuNoKanriResult shikibetsuNoKanriEntity = ShokanbaraiJyokyoShokai.createInstance()
                .getShikibetsubangoKanri(サービス年月, 様式番号);
        getHandler(div).setボタン表示制御処理(shikibetsuNoKanriEntity.getEntity(), サービス年月);

        return createResponse(div);
    }

    private KihonInfoHandler getHandler(KihonInfoDiv div) {
        return new KihonInfoHandler(div);
    }

    private ResponseData<KihonInfoDiv> createResponse(KihonInfoDiv div) {
        return ResponseData.of(div).respond();
    }
}
