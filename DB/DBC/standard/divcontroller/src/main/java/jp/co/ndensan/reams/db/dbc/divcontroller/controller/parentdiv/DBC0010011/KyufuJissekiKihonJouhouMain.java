/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0010011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKihon;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHedajyoho2;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiPrmBusiness;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010011.KyufuJissekiKihonJouhouMainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010011.KyufuJissekiKihonJouhouMainHandler;
import jp.co.ndensan.reams.db.dbc.service.core.kyufujissekishokai.KyufuJissekiShokaiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 給付実績照会_基本情報画面
 *
 * @reamsid_L DBC-2970-030 linghuhang
 */
public class KyufuJissekiKihonJouhouMain {

    /**
     * 画面の初期化メソッドです。
     *
     * @param div 給付実績照会基本情報画面のDIVです。
     * @return 給付実績照会基本情報画面
     */
    public ResponseData<KyufuJissekiKihonJouhouMainDiv> onLoad(KyufuJissekiKihonJouhouMainDiv div) {
        KyufuJissekiPrmBusiness 給付実績情報照会情報
                = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        FlexibleYearMonth サービス提供年月
                = ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class);
        RString 整理番号 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
        NyuryokuShikibetsuNo 識別番号検索キー
                = ViewStateHolder.get(ViewStateKeys.識別番号検索キー, NyuryokuShikibetsuNo.class);
        List<ShikibetsuNoKanri> 識別番号管理データ = KyufuJissekiShokaiFinder.createInstance().
                getShikibetsuBangoKanri(サービス提供年月, 識別番号検索キー).records();
        RString サービス種類コード
                = ViewStateHolder.get(ViewStateKeys.サービス種類コード, RString.class);
        getHandler(div).onLoad(給付実績情報照会情報, サービス提供年月,
                整理番号, 識別番号検索キー, 識別番号管理データ, サービス種類コード);
        return ResponseData.of(div).respond();
    }

    /**
     * 「合計情報」ボタンを押下する場合、画面を表示します。
     *
     * @param div 給付実績照会基本情報画面のDIVです
     * @return 給付実績照会基本情報画面
     */
    public ResponseData<KyufuJissekiKihonJouhouMainDiv> onClick_KihonGokei(KyufuJissekiKihonJouhouMainDiv div) {
        div.getKyufuJissekiKihonGokeiPanel().setIsOpen(true);
        return ResponseData.of(div).respond();
    }

    /**
     * 「前事業者」ボタンを押下する場合、画面を表示します。
     *
     * @param div 給付実績照会基本情報画面のDIVです
     * @return 給付実績照会基本情報画面
     */
    public ResponseData<KyufuJissekiKihonJouhouMainDiv> onClick_MaeJigyosha(KyufuJissekiKihonJouhouMainDiv div) {
        KyufuJissekiPrmBusiness 給付実績情報照会情報
                = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        List<KyufuJissekiHedajyoho2> 給付実績ヘッダ情報2 = 給付実績情報照会情報.getCommonHeader().get給付実績ヘッダ情報2();
        List<KyufujissekiKihon> 給付実績基本情報 = 給付実績情報照会情報.getCsData_A();
        getHandler(div).onClick_MaeJigyosha(給付実績ヘッダ情報2, 給付実績基本情報);
        return ResponseData.of(div).respond();
    }

    /**
     * 「後事業者」ボタンを押下する場合、画面を表示します。
     *
     * @param div 給付実績照会基本情報画面のDIVです
     * @return 給付実績照会基本情報画面
     */
    public ResponseData<KyufuJissekiKihonJouhouMainDiv> onClick_AtoJigyosha(KyufuJissekiKihonJouhouMainDiv div) {
        KyufuJissekiPrmBusiness 給付実績情報照会情報
                = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        List<KyufuJissekiHedajyoho2> 給付実績ヘッダ情報2 = 給付実績情報照会情報.getCommonHeader().get給付実績ヘッダ情報2();
        List<KyufujissekiKihon> 給付実績基本情報 = 給付実績情報照会情報.getCsData_A();
        getHandler(div).onClick_AtoJigyosha(給付実績ヘッダ情報2, 給付実績基本情報);
        return ResponseData.of(div).respond();
    }

    /**
     * 「前月」ボタンを押下する場合、画面を表示します。
     *
     * @param div 給付実績照会基本情報画面のDIVです
     * @return 給付実績照会基本情報画面
     */
    public ResponseData<KyufuJissekiKihonJouhouMainDiv> onClick_Zengetsu(KyufuJissekiKihonJouhouMainDiv div) {
        FlexibleYearMonth サービス提供年月
                = ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class);
        RString 整理番号 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
        NyuryokuShikibetsuNo 識別番号検索キー
                = ViewStateHolder.get(ViewStateKeys.識別番号検索キー, NyuryokuShikibetsuNo.class);
        KyufuJissekiPrmBusiness 給付実績情報照会情報
                = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        List<KyufujissekiKihon> 給付実績基本情報 = 給付実績情報照会情報.getCsData_A();
        HihokenshaNo 被保険者番号 = 給付実績情報照会情報.getKojinKakuteiKey().get被保険者番号();
        getHandler(div).onClick_Zengetsu(サービス提供年月, 給付実績基本情報, 被保険者番号, 整理番号, 識別番号検索キー);
        return ResponseData.of(div).respond();
    }

    /**
     * 「次月」ボタンを押下する場合、画面を表示します。
     *
     * @param div 給付実績照会基本情報画面のDIVです
     * @return 給付実績照会基本情報画面
     */
    public ResponseData<KyufuJissekiKihonJouhouMainDiv> onClick_Jigetsu(KyufuJissekiKihonJouhouMainDiv div) {
        FlexibleYearMonth サービス提供年月
                = ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class);
        RString 整理番号 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
        NyuryokuShikibetsuNo 識別番号検索キー
                = ViewStateHolder.get(ViewStateKeys.識別番号検索キー, NyuryokuShikibetsuNo.class);
        KyufuJissekiPrmBusiness 給付実績情報照会情報
                = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        List<KyufujissekiKihon> 給付実績基本情報 = 給付実績情報照会情報.getCsData_A();
        HihokenshaNo 被保険者番号 = 給付実績情報照会情報.getKojinKakuteiKey().get被保険者番号();
        getHandler(div).onClick_Jigetsu(サービス提供年月, 給付実績基本情報, 被保険者番号, 整理番号, 識別番号検索キー);
        return ResponseData.of(div).respond();
    }

    private KyufuJissekiKihonJouhouMainHandler getHandler(KyufuJissekiKihonJouhouMainDiv div) {
        return new KyufuJissekiKihonJouhouMainHandler(div);
    }
}
