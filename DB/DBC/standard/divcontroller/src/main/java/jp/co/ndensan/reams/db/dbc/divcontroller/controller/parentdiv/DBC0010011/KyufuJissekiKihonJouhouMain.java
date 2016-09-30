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
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
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

    private static final int INT_ZERO = 0;
    private static final int INT_ITI = 1;
    private static final int INT_NI = 2;

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
        List<KyufujissekiKihon> 給付実績基本情報 = get給付実績基本情報();
        RString 整理番号 = get整理番号(給付実績基本情報);
        NyuryokuShikibetsuNo 識別番号検索キー = get識別番号(給付実績基本情報);
        List<ShikibetsuNoKanri> 識別番号管理データ = KyufuJissekiShokaiFinder.createInstance().
                getShikibetsuBangoKanri(サービス提供年月, 識別番号検索キー).records();
        div.getCcdKyufuJissekiHeader().initialize(
                給付実績情報照会情報.getKojinKakuteiKey().get被保険者番号(),
                サービス提供年月,
                整理番号,
                識別番号検索キー);
        KyufujissekiKihon 給付実績基本 = get給付実績基本情報(給付実績基本情報, サービス提供年月,
                new JigyoshaNo(div.getCcdKyufuJissekiHeader().get事業者番号()), 整理番号,
                div.getCcdKyufuJissekiHeader().get様式番号(), div.getCcdKyufuJissekiHeader().get実績区分コード());
        List<KyufuJissekiHedajyoho2> 給付実績ヘッダ情報2 = get給付実績ヘッダ情報2();
        getHandler(div).onLoad(サービス提供年月,
                識別番号検索キー, 識別番号管理データ, 給付実績基本情報,
                給付実績ヘッダ情報2, 給付実績基本, get事業所名称(給付実績基本, サービス提供年月),
                get給付分類区分(給付実績基本, サービス提供年月), 整理番号);
        div.getKyufuJissekiKihonGokeiPanel().setIsOpen(false);
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
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth(div.getCcdKyufuJissekiHeader().
                getサービス提供年月().getYearMonth().toDateString());
        List<KyufuJissekiHedajyoho2> 給付実績ヘッダ情報2 = get給付実績ヘッダ情報2();
        List<KyufujissekiKihon> 給付実績基本情報 = get給付実績基本情報();
        int 事業者番号の位置 = get事業者番号の位置(給付実績ヘッダ情報2, div, サービス提供年月);
        if (事業者番号の位置 != 0) {
            KyufuJissekiHedajyoho2 給付実績ヘッダ情報 = 給付実績ヘッダ情報2.get(事業者番号の位置 - INT_ITI);
            set画面の表示(給付実績ヘッダ情報, div, 給付実績基本情報, 給付実績ヘッダ情報2, new RString("前事業者"));
        }
        div.getBtnMaeJigyosha().setDisabled(true);
        if (0 < 事業者番号の位置 - INT_NI && 事業者番号の位置 - INT_NI < 給付実績ヘッダ情報2.size()) {
            div.getBtnMaeJigyosha().setDisabled(false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「後事業者」ボタンを押下する場合、画面を表示します。
     *
     * @param div 給付実績照会基本情報画面のDIVです
     * @return 給付実績照会基本情報画面
     */
    public ResponseData<KyufuJissekiKihonJouhouMainDiv> onClick_AtoJigyosha(KyufuJissekiKihonJouhouMainDiv div) {
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth(div.getCcdKyufuJissekiHeader().
                getサービス提供年月().getYearMonth().toDateString());
        List<KyufuJissekiHedajyoho2> 給付実績ヘッダ情報2 = get給付実績ヘッダ情報2();
        List<KyufujissekiKihon> 給付実績基本情報 = get給付実績基本情報();
        int 事業者番号の位置 = get事業者番号の位置(給付実績ヘッダ情報2, div, サービス提供年月);
        if (事業者番号の位置 + INT_ITI < 給付実績ヘッダ情報2.size()) {
            KyufuJissekiHedajyoho2 給付実績ヘッダ情報 = 給付実績ヘッダ情報2.get(事業者番号の位置 + INT_ITI);
            set画面の表示(給付実績ヘッダ情報, div, 給付実績基本情報, 給付実績ヘッダ情報2, new RString("後事業者"));
        }
        div.getBtnAtoJigyosha().setDisabled(true);
        if (事業者番号の位置 + INT_NI < 給付実績ヘッダ情報2.size()) {
            div.getBtnAtoJigyosha().setDisabled(false);
        }
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
        KyufuJissekiPrmBusiness 給付実績情報照会情報
                = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        List<KyufujissekiKihon> 給付実績基本情報 = 給付実績情報照会情報.getCsData_A();
        HihokenshaNo 被保険者番号 = 給付実績情報照会情報.getKojinKakuteiKey().get被保険者番号();
        List<KyufuJissekiHedajyoho2> 給付実績ヘッダ情報2 = get給付実績ヘッダ情報2();
        int 事業者番号の位置 = get事業者番号の位置(給付実績ヘッダ情報2, div, サービス提供年月);
        if (事業者番号の位置 != 0) {
            KyufuJissekiHedajyoho2 給付実績ヘッダ情報 = 給付実績ヘッダ情報2.get(事業者番号の位置 - INT_ITI);
            FlexibleYearMonth サービス年月 = 給付実績ヘッダ情報.getサービス提供年月();
            RString 給付実績区分コード = 給付実績ヘッダ情報.get給付実績区分コード();
            RString 後整理番号 = 給付実績ヘッダ情報.get整理番号();
            JigyoshaNo 事業所番号 = 給付実績ヘッダ情報.get事業所番号();
            RString 識別番号 = 給付実績ヘッダ情報.get識別番号();
            KyufujissekiKihon 給付実績基本 = get給付実績基本情報(給付実績基本情報, サービス年月,
                    事業所番号, 後整理番号, 識別番号, 給付実績区分コード);
            getHandler(div).onClick_Zengetsu(サービス年月, 給付実績基本, 被保険者番号,
                    後整理番号, new NyuryokuShikibetsuNo(識別番号), get事業所名称(給付実績基本, サービス提供年月),
                    get給付分類区分(給付実績基本, サービス提供年月), 給付実績基本情報, 給付実績ヘッダ情報2);
            ViewStateHolder.put(ViewStateKeys.サービス提供年月, サービス年月);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「次月」ボタンを押下する場合、画面を表示します。
     *
     * @param div 給付実績照会基本情報画面のDIV
     * @return 給付実績照会基本情報画面
     */
    public ResponseData<KyufuJissekiKihonJouhouMainDiv> onClick_Jigetsu(KyufuJissekiKihonJouhouMainDiv div) {
        FlexibleYearMonth サービス提供年月
                = ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class);
        KyufuJissekiPrmBusiness 給付実績情報照会情報
                = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        List<KyufujissekiKihon> 給付実績基本情報 = 給付実績情報照会情報.getCsData_A();
        HihokenshaNo 被保険者番号 = 給付実績情報照会情報.getKojinKakuteiKey().get被保険者番号();
        List<KyufuJissekiHedajyoho2> 給付実績ヘッダ情報2 = get給付実績ヘッダ情報2();
        int 事業者番号の位置 = get事業者番号の位置(給付実績ヘッダ情報2, div, サービス提供年月);
        if (事業者番号の位置 + INT_ITI < 給付実績ヘッダ情報2.size()) {
            KyufuJissekiHedajyoho2 給付実績ヘッダ情報 = 給付実績ヘッダ情報2.get(事業者番号の位置 + INT_ITI);
            FlexibleYearMonth サービス年月 = 給付実績ヘッダ情報.getサービス提供年月();
            RString 給付実績区分コード = 給付実績ヘッダ情報.get給付実績区分コード();
            RString 後整理番号 = 給付実績ヘッダ情報.get整理番号();
            JigyoshaNo 事業所番号 = 給付実績ヘッダ情報.get事業所番号();
            RString 識別番号 = 給付実績ヘッダ情報.get識別番号();
            KyufujissekiKihon 給付実績基本 = get給付実績基本情報(給付実績基本情報, サービス年月,
                    事業所番号, 後整理番号, 識別番号, 給付実績区分コード);
            getHandler(div).onClick_Jigetsu(サービス年月, 給付実績基本, 被保険者番号,
                    後整理番号, new NyuryokuShikibetsuNo(識別番号), get事業所名称(給付実績基本, サービス提供年月),
                    get給付分類区分(給付実績基本, サービス提供年月), 給付実績基本情報, 給付実績ヘッダ情報2);
            ViewStateHolder.put(ViewStateKeys.サービス提供年月, サービス年月);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「閉じる」ボタンを押下する場合、画面を表示します。
     *
     * @param div 給付実績照会基本情報画面のDIV
     * @return 給付実績照会基本情報画面
     */
    public ResponseData<KyufuJissekiKihonJouhouMainDiv> onClick_Close(KyufuJissekiKihonJouhouMainDiv div) {
        div.getKyufuJissekiKihonGokeiPanel().setIsOpen(false);
        return ResponseData.of(div).respond();
    }

    private KyufujissekiKihon get給付実績基本情報(List<KyufujissekiKihon> 給付実績基本情報,
            FlexibleYearMonth サービス提供年月, JigyoshaNo 事業者番号, RString 整理番号, RString 様式番号, RString 実績区分コード) {
        for (KyufujissekiKihon 給付実績基本 : 給付実績基本情報) {
            if (サービス提供年月.equals(給付実績基本.getサービス提供年月())
                    && 事業者番号.equals(給付実績基本.get事業者番号())
                    && 整理番号.equals(給付実績基本.get整理番号())
                    && 様式番号.equals(給付実績基本.get入力識別番号().value())
                    && 実績区分コード.equals(給付実績基本.get給付実績区分コード())) {
                return 給付実績基本;
            }
        }
        return null;
    }

    private int get事業者番号の位置(List<KyufuJissekiHedajyoho2> 事業者番号リスト, KyufuJissekiKihonJouhouMainDiv div,
            FlexibleYearMonth サービス提供年月) {
        RString 事業者番号 = div.getCcdKyufuJissekiHeader().get事業者番号();
        RString 整理番号 = div.getCcdKyufuJissekiHeader().get整理番号();
        RString 様式番号 = div.getCcdKyufuJissekiHeader().get様式番号();
        RString 実績区分コード = div.getCcdKyufuJissekiHeader().get実績区分コード();
        for (int index = 0; index < 事業者番号リスト.size(); index++) {
            if (事業者番号.equals(事業者番号リスト.get(index).get事業所番号().value())
                    && 整理番号.equals(事業者番号リスト.get(index).get整理番号())
                    && 様式番号.equals(事業者番号リスト.get(index).get識別番号())
                    && サービス提供年月.equals(事業者番号リスト.get(index).getサービス提供年月())
                    && 実績区分コード.equals(事業者番号リスト.get(index).get給付実績区分コード())) {
                return index;
            }
        }
        return INT_ZERO;
    }

    private RString get事業所名称(KyufujissekiKihon 給付実績基本, FlexibleYearMonth サービス提供年月) {
        if (給付実績基本 == null) {
            return RString.EMPTY;
        }
        return KyufuJissekiShokaiFinder.createInstance().getJikyoshaName(給付実績基本.get事業者番号(), サービス提供年月);
    }

    private RString get給付分類区分(KyufujissekiKihon 給付実績基本, FlexibleYearMonth サービス提供年月) {
        if (給付実績基本 == null) {
            return RString.EMPTY;
        }
        return KyufuJissekiShokaiFinder.createInstance().get給付分類区分(給付実績基本.get入力識別番号(), サービス提供年月);
    }

    private List<KyufuJissekiHedajyoho2> get給付実績ヘッダ情報2() {
        KyufuJissekiPrmBusiness 給付実績情報照会情報
                = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        return 給付実績情報照会情報.getCommonHeader().get給付実績ヘッダ情報2();
    }

    private List<KyufujissekiKihon> get給付実績基本情報() {
        KyufuJissekiPrmBusiness 給付実績情報照会情報
                = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        return 給付実績情報照会情報.getCsData_A();
    }

    private void set画面の表示(KyufuJissekiHedajyoho2 給付実績ヘッダ情報, KyufuJissekiKihonJouhouMainDiv div,
            List<KyufujissekiKihon> 給付実績基本情報, List<KyufuJissekiHedajyoho2> 給付実績ヘッダ情報２, RString ボタン) {
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth(div.getCcdKyufuJissekiHeader().
                getサービス提供年月().getYearMonth().toDateString());
        RString 給付実績区分コード = 給付実績ヘッダ情報.get給付実績区分コード();
        RString 後整理番号 = 給付実績ヘッダ情報.get整理番号();
        JigyoshaNo 事業所番号 = 給付実績ヘッダ情報.get事業所番号();
        RString 識別番号 = 給付実績ヘッダ情報.get識別番号();
        RString 事業者名称 = 給付実績ヘッダ情報.get事業者名称();
        RString 識別番号名称 = 給付実績ヘッダ情報.get識別番号名称();
        KyufujissekiKihon 給付実績基本 = get給付実績基本情報(給付実績基本情報, サービス提供年月,
                事業所番号, 後整理番号, 識別番号, 給付実績区分コード);
        if (new RString("後事業者").equals(ボタン)) {
            getHandler(div).onClick_Jigyosha(給付実績ヘッダ情報, サービス提供年月,
                    事業所番号, 後整理番号, 識別番号, 給付実績区分コード,
                    事業者名称, 識別番号名称, 給付実績基本, get事業所名称(給付実績基本, サービス提供年月),
                    get給付分類区分(給付実績基本, サービス提供年月), 給付実績基本情報, 給付実績ヘッダ情報２);
        } else {
            getHandler(div).onClick_MaeJigyosha(給付実績ヘッダ情報, サービス提供年月,
                    事業所番号, 後整理番号, 識別番号, 給付実績区分コード,
                    事業者名称, 識別番号名称, 給付実績基本, get事業所名称(給付実績基本, サービス提供年月),
                    get給付分類区分(給付実績基本, サービス提供年月), 給付実績基本情報, 給付実績ヘッダ情報２);
        }
    }

    private RString get整理番号(List<KyufujissekiKihon> 給付実績基本情報) {
        return 給付実績基本情報.get(INT_ZERO).get整理番号();
    }

    private NyuryokuShikibetsuNo get識別番号(List<KyufujissekiKihon> 給付実績基本情報) {
        return 給付実績基本情報.get(INT_ZERO).get入力識別番号();
    }

    private KyufuJissekiKihonJouhouMainHandler getHandler(KyufuJissekiKihonJouhouMainDiv div) {
        return new KyufuJissekiKihonJouhouMainHandler(div);
    }
}
