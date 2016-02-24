/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0810014;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ServiceTeikyoShomeishoResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810014.ServiceTeikyoShomeishoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0810014.ServiceTeikyoShomeishoHandler;
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
 * 償還払い状況照会_サービス提供証明書のクラスです。
 */
public class ServiceTeikyoShomeisho {

    /**
     * 画面初期化onLoad
     * 
     * @param div ServiceTeikyoShomeishoDiv
     * @return 償還払い状況照会_サービス提供証明書画面
     */
    public ResponseData<ServiceTeikyoShomeishoDiv> onLoad(ServiceTeikyoShomeishoDiv div) {
        // TODO 引き継ぎデータの取得 
        // TODO 詳細画面から遷移の場合 ViewStateより 継ぎデータ
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

        // TODO 該当者検索画面ViewState．識別コード
        ViewStateHolder.put(ViewStateKeys.識別コード, new ShikibetsuCode("123456"));
//        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        RString 決定日 = new RString("");

        // TODO 申請書検索ViewSate．様式番号
        ViewStateHolder.put(ViewStateKeys.様式番号, new RString("0003"));
        RString 様式番号 = ViewStateHolder.get(ViewStateKeys.様式番号, RString.class);

        // TODO「介護宛名情報」共有子Divの初期化
        //div.getPanelOne().getCcdKaigoAtenaInfo().load(識別コード);
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
            div.getPanelOne().getCcdKaigoShikakuKihon().initialize(被保険者番号);
        } else {
            div.getPanelOne().getCcdKaigoShikakuKihon().setVisible(false);
        }

        List<ServiceTeikyoShomeishoResult> serviceTeikyoShomeishoList
                = ShokanbaraiJyokyoShokai.createInstance().getServiceTeikyoShomeishoList(被保険者番号,
                        サービス年月, 整理番号, 様式番号);
        if (serviceTeikyoShomeishoList == null || serviceTeikyoShomeishoList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        getHandler(div).initialize(serviceTeikyoShomeishoList);
        // TODO viewState取得
        getHandler(div).setヘッダ_エリア(サービス年月, 整理番号);

        if (決定日.isEmpty()) {
            div.getPanelTwo().getBtnShokanKeteiInfo().setDisabled(true);
        }
        return createResponse(div);
    }

    /**
     * 選択ボタンを押下した際に実行します。
     *
     * @param div ServiceTeikyoShomeishoDiv
     * @return 基本情報画面
     */
    public ResponseData<ServiceTeikyoShomeishoDiv> onClick_SelectButton(ServiceTeikyoShomeishoDiv div) {
        // TODO DBC0810021＿基本情報画面へ遷移
        getHandler(div).putViewStateHolder();
        return createResponse(div);
    }

    private ServiceTeikyoShomeishoHandler getHandler(ServiceTeikyoShomeishoDiv div) {
        return new ServiceTeikyoShomeishoHandler(div);
    }

    private ResponseData<ServiceTeikyoShomeishoDiv> createResponse(ServiceTeikyoShomeishoDiv div) {
        return ResponseData.of(div).respond();
    }
}
