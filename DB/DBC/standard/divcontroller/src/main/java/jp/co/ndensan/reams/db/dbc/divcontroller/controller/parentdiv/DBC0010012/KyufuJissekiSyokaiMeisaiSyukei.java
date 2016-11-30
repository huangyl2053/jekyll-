/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0010012;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiShukei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHeaderAll;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiParam;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiPrmBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiMeisaiBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiMeisaiJushochiTokureiBusiness;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010012.KyufuJissekiSyokaiMeisaiSyukeiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010012.KyufuJissekiSyokaiMeisaiSyukeiHandler;
import jp.co.ndensan.reams.db.dbc.service.core.kyufujissekishokai.KyufuJissekiShokaiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 給付実績照会_明細集計画面処理クラスです。
 *
 * @reamsid_L DBC-2970-040 wangxiaodong
 */
public class KyufuJissekiSyokaiMeisaiSyukei {

    /**
     * 画面の初期化メソッドです。
     *
     * @param div KyufuJissekiSyokaiMeisaiSyukeiDiv
     * @return 給付実績照会_明細集計画面
     */
    public ResponseData<KyufuJissekiSyokaiMeisaiSyukeiDiv> onLoad(KyufuJissekiSyokaiMeisaiSyukeiDiv div) {
        KyufuJissekiParam para = ViewStateHolder.get(ViewStateKeys.給付実績データパラメータ, KyufuJissekiParam.class);
        KyufuJissekiHeaderAll 給付実績基本情報 = ViewStateHolder.get(ViewStateKeys.給付実績基本情報データ, KyufuJissekiHeaderAll.class);
        div.getCcdKyufuJissekiHeader().set給付実績基本情報データ(給付実績基本情報);
        KyufuJissekiSyokaiMeisaiSyukeiHandler handler = getHandler(div);
        KyufuJissekiPrmBusiness 給付実績情報照会情報 = KyufuJissekiShokaiFinder.createInstance().
                get検索集計と明細と住所地データ(
                        para.get被保険者番号(), para.getサービス提供年月(), para.get入力識別番号(), para.get事業所番号(), para.get通し番号());
        List<KyufujissekiShukei> 集計データ = 給付実績情報照会情報.getCsData_Z();
        List<KyufujissekiMeisaiBusiness> 明細データ = 給付実績情報照会情報.getCsData_B();
        List<KyufujissekiMeisaiJushochiTokureiBusiness> 住所地特例データ = 給付実績情報照会情報.getCsData_N();
        RString 様式番号 = div.getCcdKyufuJissekiHeader().get様式番号();
        handler.onLoad(集計データ, 明細データ, 住所地特例データ, para.getサービス提供年月(), 様式番号);
        ShikibetsuNoKanri 識別番号管理データ = ViewStateHolder.get(ViewStateKeys.識別番号管理, ShikibetsuNoKanri.class);
        handler.setButton(識別番号管理データ);
        return ResponseData.of(div).respond();
    }

    private KyufuJissekiSyokaiMeisaiSyukeiHandler getHandler(KyufuJissekiSyokaiMeisaiSyukeiDiv div) {
        return new KyufuJissekiSyokaiMeisaiSyukeiHandler(div);
    }
}
