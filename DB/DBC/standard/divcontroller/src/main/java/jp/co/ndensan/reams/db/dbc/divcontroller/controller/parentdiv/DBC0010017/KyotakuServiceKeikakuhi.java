/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0010017;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHeaderAll;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiParam;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiKyotakuServiceBusiness;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010017.KyotakuServiceKeikakuhiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010017.KyotakuServiceKeikakuhiHandler;
import jp.co.ndensan.reams.db.dbc.service.core.kyufujissekishokai.KyufuJissekiShokaiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 居宅サービス計画費表示です。
 *
 * @reamsid_L DBC-2970-090 wangrenze
 */
public class KyotakuServiceKeikakuhi {

    /**
     * 画面の初期化メソッドです。
     *
     * @param div KyotakuServiceKeikakuhiDiv
     * @return 居宅サービス計画費表示画面
     */
    public ResponseData<KyotakuServiceKeikakuhiDiv> onLoad(KyotakuServiceKeikakuhiDiv div) {
        KyufuJissekiHeaderAll 子Div給付実績基本情報
                = ViewStateHolder.get(ViewStateKeys.給付実績基本情報データ, KyufuJissekiHeaderAll.class);
        div.getCcdKyufuJissekiHeader().set給付実績基本情報データ(子Div給付実績基本情報);
        KyufuJissekiParam para = ViewStateHolder.get(ViewStateKeys.給付実績データパラメータ, KyufuJissekiParam.class);
        FlexibleYearMonth サービス提供年月 = ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class);
        List<KyufujissekiKyotakuServiceBusiness> 給付実績居宅サービス計画費データ
                = KyufuJissekiShokaiFinder.createInstance().get給付実績居宅サービス計画費データ(
                        para.get入力識別番号(), para.get被保険者番号(), サービス提供年月, para.get事業所番号(), para.get通し番号());
        ShikibetsuNoKanri 識別番号管理データ = ViewStateHolder.get(ViewStateKeys.識別番号管理, ShikibetsuNoKanri.class);
        getHandler(div).setButton(識別番号管理データ);
        getHandler(div).setDataGrid(給付実績居宅サービス計画費データ, サービス提供年月);
        return createResponse(div);
    }

    private KyotakuServiceKeikakuhiHandler getHandler(KyotakuServiceKeikakuhiDiv div) {
        return new KyotakuServiceKeikakuhiHandler(div);
    }

    private ResponseData<KyotakuServiceKeikakuhiDiv> createResponse(KyotakuServiceKeikakuhiDiv div) {
        return ResponseData.of(div).respond();
    }
}
