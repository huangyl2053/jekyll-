/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0810028;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShoteiShikkanShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810028.KinkyujiShoteiShikanDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0810028.KinkyujiShoteiShikanHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0810014.ServiceTeiKyoShomeishoParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShikibetsuNoKanriEntity;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 償還払い状況照会_緊急時・所定疾患画面クラスです
 *
 * @author XuPeng
 */
public class KinkyujiShoteiShikan {

    /**
     * 償還払い状況照会_緊急時・所定疾患画面初期化する
     *
     * @param div 緊急時・所定疾患画面Div
     * @return response
     */
    public ResponseData<KinkyujiShoteiShikanDiv> onLoad(KinkyujiShoteiShikanDiv div) {
        // TODO 引き継ぎデータの取得
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
        JigyoshaNo 事業者番号 = parameter.getJigyoshaNo();
        RString 明細番号 = parameter.getMeisaiNo();
        RString 証明書 = parameter.getServiceYM();

        // TODO 該当者検索画面ViewState．識別コード
        ViewStateHolder.put(ViewStateKeys.識別コード, new ShikibetsuCode(new RString("123456")));
        ShikibetsuCode 識別コード = ViewStateHolder.get(
                ViewStateKeys.識別コード, ShikibetsuCode.class);
        // TODO 申請書検索ViewSate．様式番号
        ViewStateHolder.put(ViewStateKeys.様式番号, new RString("0003"));
        RString 様式番号 = ViewStateHolder.get(
                ViewStateKeys.様式番号, RString.class);
        // TODO 申請検索画面ViewState. 申請日
        ViewStateHolder.put(ViewStateKeys.申請日, new RDate("20151224"));
        RDate 申請日 = ViewStateHolder.get(ViewStateKeys.申請日, RDate.class);

        //介護宛名情報」共有子Divの初期化
//        div.getPanelCcd().getCcdKaigoAtenaInfo().load(識別コード);
        //介護資格系基本情報」共有子Div の初期化
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
            // TODO load----initialize
            div.getPanelCcd().getCcdKaigoShikakuKihon().initialize(被保険者番号);
        } else {
            div.getPanelCcd().getCcdKaigoAtenaInfo().setVisible(false);
        }
        KinkyujiShoteiShikanHandler handler = getHandler(div);
        handler.initPanelHead(サービス年月, 申請日, 事業者番号, 明細番号,
                証明書, 様式番号);

        //償還払請求所定疾患施設療養費等データ取得
        ShokanbaraiJyokyoShokai finder = ShokanbaraiJyokyoShokai.createInstance();
        List<ShokanShoteiShikkanShisetsuRyoyo> businessList = finder.getKinkyujiShisetsuRyoyoData1(
                被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null);
        if (businessList == null || businessList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        handler.initDgdKinkyujiShoteiList(businessList);
        ShikibetsuNoKanriEntity 識別番号 = finder.getShikibetsubangoKanri(サービス年月, 様式番号);
        handler.setボタン表示制御処理(識別番号);
        return ResponseData.of(div).respond();
    }

    public ResponseData<KinkyujiShoteiShikanDiv> onClick_btnSelectButton(KinkyujiShoteiShikanDiv div) {
        div.getPanelDetail().setDisplayNone(false);
        RString 連番 = div.getDgdKinkyujiShoteiList().getClickedItem().getDefaultDataName8();

        ServiceTeiKyoShomeishoParameter parameter = ViewStateHolder.get(
                ViewStateKeys.基本情報パラメータ, ServiceTeiKyoShomeishoParameter.class);
        FlexibleYearMonth サービス年月 = parameter.getServiceTeikyoYM();
        HihokenshaNo 被保険者番号 = parameter.getHiHokenshaNo();
        RString 整理番号 = parameter.getSeiriNp();
        JigyoshaNo 事業者番号 = parameter.getJigyoshaNo();
        RString 明細番号 = parameter.getMeisaiNo();
        RString 証明書 = parameter.getServiceYM();
        RString 様式番号 = ViewStateHolder.get(ViewStateKeys.様式番号, RString.class);

        ShokanbaraiJyokyoShokai finder = ShokanbaraiJyokyoShokai.createInstance();
        List<ShokanShoteiShikkanShisetsuRyoyo> list = finder.getKinkyujiShisetsuRyoyoData1(
                被保険者番号, サービス年月, 整理番号, 事業者番号, 明細番号, 様式番号, 連番);
        getHandler(div).setUp傷病名(list.get(0));
        getHandler(div).setUp往診通院(list.get(0));
        getHandler(div).setUp治療点数(list.get(0));
        return ResponseData.of(div).respond();
    }

    public ResponseData<KinkyujiShoteiShikanDiv> onClick_btnClose(KinkyujiShoteiShikanDiv div) {
        div.getPanelDetail().setDisplayNone(true);
        return ResponseData.of(div).respond();
    }

    private KinkyujiShoteiShikanHandler getHandler(KinkyujiShoteiShikanDiv div) {
        return KinkyujiShoteiShikanHandler.of(div);
    }
}
