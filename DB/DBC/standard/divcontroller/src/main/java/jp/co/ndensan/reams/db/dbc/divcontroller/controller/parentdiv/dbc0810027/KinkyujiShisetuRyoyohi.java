/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0810027;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanKinkyuShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShikibetsuNoKanriResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810027.KinkyujiShisetuRyoyohiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0810027.KinkyujiShisetuRyoyohiHandler;
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
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 償還払い状況照会_緊急時施設療養費画面クラスです
 *
 * @author XuPeng
 */
public class KinkyujiShisetuRyoyohi {

    /**
     * 償還払い状況照会_緊急時施設療養費画面初期化する
     *
     * @param div 緊急時施設療養費画面Div
     * @return response
     */
    public ResponseData<KinkyujiShisetuRyoyohiDiv> onLoad(KinkyujiShisetuRyoyohiDiv div) {
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

        // TODO 申請書検索ViewSate．様式番号
        ViewStateHolder.put(ViewStateKeys.様式番号, new RString("0003"));
        RString 様式番号 = ViewStateHolder.get(
                ViewStateKeys.様式番号, RString.class);
        // TODO 申請検索画面ViewState. 申請日
        ViewStateHolder.put(ViewStateKeys.申請日, new RDate("20151223"));
        RDate 申請日 = ViewStateHolder.get(ViewStateKeys.申請日, RDate.class);
        // TODO 該当者検索画面ViewState．識別コード
        ViewStateHolder.put(ViewStateKeys.識別コード, new ShikibetsuCode(new RString("000000000000010")));
        ShikibetsuCode 識別コード = ViewStateHolder.get(
                ViewStateKeys.識別コード, ShikibetsuCode.class);

        //介護宛名情報」共有子Divの初期化\
//        div.getPanelCcd().getCcdKaigoAtenaInfo().onLoad(識別コード);
        //介護資格系基本情報」共有子Div の初期化
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
//            div.getPanelCcd().getCcdKaigoShikakuKihon().onLoad(被保険者番号);
        } else {
            div.getPanelCcd().getCcdKaigoAtenaInfo().setVisible(false);
        }

        KinkyujiShisetuRyoyohiHandler handler = getHandler(div);
        handler.initPanelHead(サービス年月, 申請日, 事業者番号, 明細番号,
                証明書, 様式番号);
        //償還払請求緊急時施設療養データ取得
        ShokanbaraiJyokyoShokai finder = ShokanbaraiJyokyoShokai.createInstance();
        List<ShokanKinkyuShisetsuRyoyo> list = finder.getKinkyujiShisetsuRyoyoData(
                被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null);
        if (list == null || list.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        handler.initDgdKinkyujiShiseturyoyo(list);

        ShikibetsuNoKanriResult 識別番号 = finder.getShikibetsubangoKanri(サービス年月, 様式番号);
        handler.setボタン表示制御処理(識別番号);
        return ResponseData.of(div).respond();
    }

    public ResponseData<KinkyujiShisetuRyoyohiDiv> onClick_btnSelectButton(KinkyujiShisetuRyoyohiDiv div) {
        div.getPanelKinkyujiShiseturyoyoDetail().setDisplayNone(false);
        RString 連番 = div.getDgdKinkyujiShiseturyoyo().getClickedItem().getDefaultDataName5();

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
        List<ShokanKinkyuShisetsuRyoyo> list = finder.getKinkyujiShisetsuRyoyoData(
                被保険者番号, サービス年月, 整理番号, 事業者番号, 明細番号, 様式番号, 連番);
        ShokanKinkyuShisetsuRyoyo result = list.get(0);
        getHandler(div).set傷病名(result);
        getHandler(div).set往診通院(result);
        getHandler(div).set治療点数(result);
        return ResponseData.of(div).respond();
    }

    public ResponseData<KinkyujiShisetuRyoyohiDiv> onClick_btnClose(KinkyujiShisetuRyoyohiDiv div) {
        div.getPanelKinkyujiShiseturyoyoDetail().setDisplayNone(true);
        return ResponseData.of(div).respond();
    }

    private KinkyujiShisetuRyoyohiHandler getHandler(KinkyujiShisetuRyoyohiDiv div) {
        return KinkyujiShisetuRyoyohiHandler.of(div);
    }
}
