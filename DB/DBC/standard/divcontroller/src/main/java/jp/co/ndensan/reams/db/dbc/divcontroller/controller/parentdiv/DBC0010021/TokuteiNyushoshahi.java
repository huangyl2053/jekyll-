/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0010021;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHeaderAll;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiParam;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBusiness;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010021.TokuteiNyushoshahiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010021.TokuteiNyushoshahiHandler;
import jp.co.ndensan.reams.db.dbc.service.core.kyufujissekishokai.KyufuJissekiShokaiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 特定入所者費用表示です。
 *
 * @reamsid_L DBC-2970-130 wangrenze
 */
public class TokuteiNyushoshahi {

    /**
     * 画面の初期化メソッドです。
     *
     * @param div TokuteiNyushoshahiDiv
     * @return 特定入所者費用表示画面
     */
    public ResponseData<TokuteiNyushoshahiDiv> onLoad(TokuteiNyushoshahiDiv div) {
        KyufuJissekiHeaderAll 子Div給付実績基本情報
                = ViewStateHolder.get(ViewStateKeys.給付実績基本情報データ, KyufuJissekiHeaderAll.class);
        div.getCcdKyufuJissekiHeader().set給付実績基本情報データ(子Div給付実績基本情報);
        KyufuJissekiParam para = ViewStateHolder.get(ViewStateKeys.給付実績データパラメータ, KyufuJissekiParam.class);
        FlexibleYearMonth サービス提供年月 = ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class);
        List<KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBusiness> 給付実績特定入所者介護サービス費用データ
                = KyufuJissekiShokaiFinder.createInstance().get給付実績特定入所者介護サービス費用データ(
                        para.get入力識別番号(), para.get被保険者番号(), サービス提供年月, para.get事業所番号(), para.get通し番号());
        ShikibetsuNoKanri 識別番号管理データ = ViewStateHolder.get(ViewStateKeys.識別番号管理, ShikibetsuNoKanri.class);
        getHandler(div).setButton(識別番号管理データ);
        getHandler(div).setDataGrid(給付実績特定入所者介護サービス費用データ);
        return createResponse(div);
    }

    private TokuteiNyushoshahiHandler getHandler(TokuteiNyushoshahiDiv div) {
        return new TokuteiNyushoshahiHandler(div);
    }

    private ResponseData<TokuteiNyushoshahiDiv> createResponse(TokuteiNyushoshahiDiv div) {
        return ResponseData.of(div).respond();
    }

}
