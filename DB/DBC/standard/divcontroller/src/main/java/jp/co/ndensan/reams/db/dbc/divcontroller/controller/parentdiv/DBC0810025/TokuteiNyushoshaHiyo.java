/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0810025;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiNyushoshaKaigoServiceHiyo;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShikibetsuNoKanriResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810025.TokuteiNyushoshaHiyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0810025.TokuteiNyushoshaHiyoHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0810014.ServiceTeiKyoShomeishoParameter;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 償還払い状況照会_特定入所者費用のクラスです。
 *
 * @reamsid_L DBC-1010-160 wangkanglei
 */
public class TokuteiNyushoshaHiyo {

    /**
     * 画面初期化のメソッドます。
     *
     * @param div TokuteiNyushoshaHiyoDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiNyushoshaHiyoDiv> onLoad(TokuteiNyushoshaHiyoDiv div) {

        ServiceTeiKyoShomeishoParameter parameter = ViewStateHolder.get(
                ViewStateKeys.基本情報パラメータ, ServiceTeiKyoShomeishoParameter.class);
        FlexibleYearMonth サービス年月 = parameter.getServiceTeikyoYM();
        HihokenshaNo 被保険者番号 = parameter.getHiHokenshaNo();
        RString 整理番号 = parameter.getSeiriNp();
        JigyoshaNo 事業者番号 = parameter.getJigyoshaNo();
        RString 明細番号 = parameter.getMeisaiNo();
        RString 証明書 = parameter.getServiceYM();
        ViewStateHolder.put(ViewStateKeys.サービス提供年月, parameter.getServiceTeikyoYM());
        TaishoshaKey 引継ぎデータ = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        ShikibetsuCode 識別コード = 引継ぎデータ.get識別コード();
        RString 様式番号 = ViewStateHolder.get(ViewStateKeys.様式番号, RString.class);
        RDate 申請日 = new RDate(ViewStateHolder.get(ViewStateKeys.申請日, RString.class).toString());

        div.getPanelCcd().getCcdKaigoAtenaInfo().initialize(識別コード);
        if (!被保険者番号.isEmpty()) {
            div.getPanelCcd().getCcdKaigoShikakuKihon().initialize(被保険者番号);
        } else {
            div.getPanelCcd().getCcdKaigoShikakuKihon().setVisible(false);
        }
        getHandler(div).setヘッダーエリア(サービス年月, 事業者番号, 申請日, 明細番号, 証明書);
        List<ShokanTokuteiNyushoshaKaigoServiceHiyo> serviceHiyoList = ShokanbaraiJyokyoShokai.createInstance()
                .getTokuteyiNyushosyaKaigoserviceHiyo(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号,
                        null);
        if (serviceHiyoList == null || serviceHiyoList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        getHandler(div).set特定入所者費用一覧グリッド(serviceHiyoList);

        ShikibetsuNoKanriResult shikibetsuNoKanriEntity = ShokanbaraiJyokyoShokai.createInstance()
                .getShikibetsubangoKanri(サービス年月, 様式番号);
        if (shikibetsuNoKanriEntity == null) {
            throw new ApplicationException(UrErrorMessages.データが存在しない.getMessage());
        }
        getHandler(div).setボタン表示制御処理(shikibetsuNoKanriEntity.getEntity(), サービス年月);
        div.getPanelTokutei().getPanelMeisai().setVisible(false);
        return createResponse(div);
    }

    /**
     * 特定入所者費用一覧グリッドの「選択」ボタンのメソッドます。
     *
     * @param div TokuteiNyushoshaHiyoDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiNyushoshaHiyoDiv> onClick_dgdTokuteiYichiran(TokuteiNyushoshaHiyoDiv div) {
        getHandler(div).set特定入所者費用照会パネル(ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class));
        div.getPanelTokutei().getPanelMeisai().setVisible(true);
        return createResponse(div);
    }

    /**
     * 「閉じる」ボタンのメソッドます。
     *
     * @param div TokuteiNyushoshaHiyoDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiNyushoshaHiyoDiv> onClick_btnclose(TokuteiNyushoshaHiyoDiv div) {
        div.getPanelTokutei().getPanelMeisai().setVisible(false);
        return createResponse(div);
    }

    private TokuteiNyushoshaHiyoHandler getHandler(TokuteiNyushoshaHiyoDiv div) {
        return new TokuteiNyushoshaHiyoHandler(div);
    }

    private ResponseData<TokuteiNyushoshaHiyoDiv> createResponse(TokuteiNyushoshaHiyoDiv div) {
        return ResponseData.of(div).respond();
    }
}
