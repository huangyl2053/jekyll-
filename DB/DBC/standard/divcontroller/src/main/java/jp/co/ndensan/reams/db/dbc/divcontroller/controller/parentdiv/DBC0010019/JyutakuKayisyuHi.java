/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0010019;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHeaderAll;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiParam;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiJutakuKaishuhiBusiness;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010019.JyutakuKayisyuHiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010019.JyutakuKayisyuHiHandler;
import jp.co.ndensan.reams.db.dbc.service.core.kyufujissekishokai.KyufuJissekiShokaiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBCMN11002_給付実績照会_(DBC0010019)住宅改修費のControllerです。
 *
 * @reamsid_L DBC-2970-110 lishengli
 */
public class JyutakuKayisyuHi {

    /**
     * 画面の初期化メソッドです。
     *
     * @param div JyutakuKayisyuHiDiv
     * @return 住宅改修費表示画面
     */
    public ResponseData<JyutakuKayisyuHiDiv> onLoad(JyutakuKayisyuHiDiv div) {
        KyufuJissekiHeaderAll 子Div給付実績基本情報
                = ViewStateHolder.get(ViewStateKeys.給付実績基本情報データ, KyufuJissekiHeaderAll.class);
        div.getCcdKyufuJissekiHeader().set給付実績基本情報データ(子Div給付実績基本情報);
        KyufuJissekiParam para = ViewStateHolder.get(ViewStateKeys.給付実績データパラメータ, KyufuJissekiParam.class);
        FlexibleYearMonth サービス提供年月 = ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class);
        List<KyufujissekiJutakuKaishuhiBusiness> 給付実績住宅改修費データ
                = KyufuJissekiShokaiFinder.createInstance().get給付実績住宅改修費データ(
                        para.get入力識別番号(), para.get被保険者番号(), サービス提供年月, para.get事業所番号(), para.get通し番号());
        ShikibetsuNoKanri 識別番号管理データ = ViewStateHolder.get(ViewStateKeys.識別番号管理, ShikibetsuNoKanri.class);
        getHandler(div).setボタン状態(識別番号管理データ);
        getHandler(div).setデータグリッド(給付実績住宅改修費データ);
        return ResponseData.of(div).respond();
    }

    private JyutakuKayisyuHiHandler getHandler(JyutakuKayisyuHiDiv div) {
        return new JyutakuKayisyuHiHandler(div);
    }
}
