/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0010019;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiPrmBusiness;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010019.JyutakuKayisyuHiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010019.JyutakuKayisyuHiHandler;
import jp.co.ndensan.reams.db.dbc.service.core.kyufujissekishokai.KyufuJissekiShokaiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
        RString 整理番号 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
        KyufuJissekiPrmBusiness 引き継ぎ情報 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        FlexibleYearMonth サービス提供年月 = ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class);
        NyuryokuShikibetsuNo 識別番号 = ViewStateHolder.get(ViewStateKeys.識別番号検索キー, NyuryokuShikibetsuNo.class);
        getHandler(div).load共有子Div(引き継ぎ情報, 整理番号, サービス提供年月, 識別番号);
        List<ShikibetsuNoKanri> shikibetsuNoKanriList = KyufuJissekiShokaiFinder.createInstance().
                getShikibetsuBangoKanri(サービス提供年月, 識別番号).records();
        getHandler(div).setボタン状態(shikibetsuNoKanriList, サービス提供年月);
        getHandler(div).setデータグリッド(引き継ぎ情報);
        return ResponseData.of(div).respond();
    }

    /**
     * 前月ボタン押下の処理です。
     *
     * @param div JyutakuKayisyuHiDiv
     * @return 住宅改修費表示画面
     */
    public ResponseData<JyutakuKayisyuHiDiv> onClick_BtnZengetsu(JyutakuKayisyuHiDiv div) {
        RString 整理番号 = div.getCcdKyufuJissekiHeader().get整理番号();
        RDate サービス提供年月 = div.getCcdKyufuJissekiHeader().getサービス提供年月();
        RString 様式番号 = div.getCcdKyufuJissekiHeader().get様式番号();
        KyufuJissekiPrmBusiness 引き継ぎ情報 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        FlexibleYearMonth 直近サービス提供年月 = getHandler(div).get直近サービス提供年月(new RString("1"), サービス提供年月, 引き継ぎ情報);
        getHandler(div).load共有子Div(引き継ぎ情報, 整理番号, 直近サービス提供年月, new NyuryokuShikibetsuNo(様式番号));
        getHandler(div).setデータグリッド(引き継ぎ情報);
        FlexibleYearMonth 提供年月 = new FlexibleYearMonth(div.getCcdKyufuJissekiHeader().getサービス提供年月().getYearMonth().toDateString());
        ViewStateHolder.put(ViewStateKeys.サービス提供年月, 提供年月);
        return ResponseData.of(div).respond();
    }

    /**
     * 次月ボタン押下の処理です。
     *
     * @param div JyutakuKayisyuHiDiv
     * @return 住宅改修費表示画面
     */
    public ResponseData<JyutakuKayisyuHiDiv> onClick_BtnJigetsu(JyutakuKayisyuHiDiv div) {
        RString 整理番号 = div.getCcdKyufuJissekiHeader().get整理番号();
        RDate サービス提供年月 = div.getCcdKyufuJissekiHeader().getサービス提供年月();
        RString 様式番号 = div.getCcdKyufuJissekiHeader().get様式番号();
        KyufuJissekiPrmBusiness 引き継ぎ情報 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        FlexibleYearMonth 直近サービス提供年月 = getHandler(div).get直近サービス提供年月(new RString("0"), サービス提供年月, 引き継ぎ情報);
        getHandler(div).load共有子Div(引き継ぎ情報, 整理番号, 直近サービス提供年月, new NyuryokuShikibetsuNo(様式番号));
        getHandler(div).setデータグリッド(引き継ぎ情報);
        FlexibleYearMonth 提供年月 = new FlexibleYearMonth(div.getCcdKyufuJissekiHeader().getサービス提供年月().getYearMonth().toDateString());
        ViewStateHolder.put(ViewStateKeys.サービス提供年月, 提供年月);
        return ResponseData.of(div).respond();
    }

    /**
     * 前事業者ボタン押下の処理です。
     *
     * @param div JyutakuKayisyuHiDiv
     * @return 住宅改修費表示画面
     */
    public ResponseData<JyutakuKayisyuHiDiv> onClick_BtnMaeJigyosha(JyutakuKayisyuHiDiv div) {
        KyufuJissekiPrmBusiness 引き継ぎ情報 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        getHandler(div).chenge事業者(new RString("0"), 引き継ぎ情報);
        return ResponseData.of(div).respond();
    }

    /**
     * 後事業者ボタン押下の処理です。
     *
     * @param div JyutakuKayisyuHiDiv
     * @return 住宅改修費表示画面
     */
    public ResponseData<JyutakuKayisyuHiDiv> onClick_BtnAtoJigyosha(JyutakuKayisyuHiDiv div) {
        KyufuJissekiPrmBusiness 引き継ぎ情報 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        getHandler(div).chenge事業者(new RString("1"), 引き継ぎ情報);
        return ResponseData.of(div).respond();
    }

    private JyutakuKayisyuHiHandler getHandler(JyutakuKayisyuHiDiv div) {
        return new JyutakuKayisyuHiHandler(div);
    }
}
