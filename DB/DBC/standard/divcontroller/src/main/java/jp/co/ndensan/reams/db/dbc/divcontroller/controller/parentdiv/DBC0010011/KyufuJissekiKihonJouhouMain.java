/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0010011;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKihon;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiCommonHeader;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHeader;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHedajyoho2;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiKihonShukeiRelate;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiPrmBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiKihonJyohou;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010011.KyufuJissekiKihonJouhouMainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010011.KyufuJissekiKihonJouhouMainHandler;
import jp.co.ndensan.reams.db.dbc.service.core.kyufujissekishokai.KyufuJissekiShokaiFinder;
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

    /**
     * 画面の初期化メソッドです。
     *
     * @param div 給付実績照会基本情報画面のDIVです。
     * @return 給付実績照会基本情報画面
     */
    public ResponseData<KyufuJissekiKihonJouhouMainDiv> onLoad(KyufuJissekiKihonJouhouMainDiv div) {
        KyufuJissekiHeader 給付実績基本情報子Divデータ
                = ViewStateHolder.get(ViewStateKeys.給付実績基本情報子Div, KyufuJissekiHeader.class);
        div.getCcdKyufuJissekiHeader().set被保情報(給付実績基本情報子Divデータ);
        FlexibleYearMonth サービス提供年月
                = ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class);
        List<KyufuJissekiKihonShukeiRelate> csData_A = get給付実績基本情報();
//        RString 整理番号 = get整理番号(給付実績基本情報);
//        NyuryokuShikibetsuNo 識別番号検索キー = get識別番号(給付実績基本情報);
//        List<ShikibetsuNoKanri> 識別番号管理データ = KyufuJissekiShokaiFinder.createInstance().
//                getShikibetsuBangoKanri(サービス提供年月, 識別番号検索キー).records();
//        div.getCcdKyufuJissekiHeader().initialize(
//                給付実績情報照会情報.getKojinKakuteiKey().get被保険者番号(),
//                サービス提供年月,
//                整理番号,
//                識別番号検索キー);
        List<KyufuJissekiKihonShukeiRelate> 該当月給付実績基本集計データ = get該当月給付実績基本集計データ(csData_A, サービス提供年月);
//                get給付実績基本情報(給付実績基本情報, サービス提供年月,
//                new JigyoshaNo(div.getCcdKyufuJissekiHeader().get事業者番号()), 整理番号,
//                div.getCcdKyufuJissekiHeader().get様式番号(), div.getCcdKyufuJissekiHeader().get実績区分コード());
        //List<KyufuJissekiHedajyoho2> 給付実績ヘッダ情報2 = get給付実績ヘッダ情報2(サービス提供年月, 整理番号, 識別番号検索キー);
        if (!該当月給付実績基本集計データ.isEmpty()) {
            getHandler(div).onLoad(該当月給付実績基本集計データ.get(0));
        }
//        getHandler(div).onLoad(サービス提供年月,
//                識別番号検索キー, 識別番号管理データ, 給付実績基本情報,
//                給付実績ヘッダ情報2, 給付実績基本, get事業所名称(給付実績基本, サービス提供年月),
//                get給付分類区分(給付実績基本, サービス提供年月), 整理番号);
        //div.getKyufuJissekiKihonGokeiPanel().setIsOpen(false);
        return ResponseData.of(div).respond();
    }

    private List<KyufuJissekiKihonShukeiRelate> get該当月給付実績基本集計データ(
            List<KyufuJissekiKihonShukeiRelate> csData_A, FlexibleYearMonth サービス提供年月) {
        List<KyufuJissekiKihonShukeiRelate> 該当月給付実績基本集計データ = new ArrayList<>();
        for (KyufuJissekiKihonShukeiRelate 集計データ : csData_A) {
            if (サービス提供年月.equals(集計データ.get給付実績基本データ().getサービス提供年月())) {
                該当月給付実績基本集計データ.add(集計データ);
            }
        }
        return 該当月給付実績基本集計データ;
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
//        List<KyufujissekiKihon> 給付実績基本情報 = get給付実績基本情報();
//        RString 整理番号 = get整理番号(給付実績基本情報);
//        NyuryokuShikibetsuNo 識別番号検索キー = get識別番号(給付実績基本情報);
//        List<KyufuJissekiHedajyoho2> 給付実績ヘッダ情報2 = get給付実績ヘッダ情報2(サービス提供年月, 整理番号, 識別番号検索キー);
//        int 事業者番号の位置 = get事業者番号の位置(給付実績ヘッダ情報2, div, サービス提供年月);
//        clear画面(div);
//        if (事業者番号の位置 != 0) {
//            KyufuJissekiHedajyoho2 給付実績ヘッダ情報 = 給付実績ヘッダ情報2.get(事業者番号の位置 - INT_ITI);
//            set画面の表示(給付実績ヘッダ情報, div, 給付実績基本情報, 給付実績ヘッダ情報2, new RString("前事業者"));
//        }
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
//        List<KyufujissekiKihon> 給付実績基本情報 = get給付実績基本情報();
//        RString 整理番号 = get整理番号(給付実績基本情報);
//        NyuryokuShikibetsuNo 識別番号検索キー = get識別番号(給付実績基本情報);
//        List<KyufuJissekiHedajyoho2> 給付実績ヘッダ情報2 = get給付実績ヘッダ情報2(サービス提供年月, 整理番号, 識別番号検索キー);
//        int 事業者番号の位置 = get事業者番号の位置(給付実績ヘッダ情報2, div, サービス提供年月);
//        clear画面(div);
//        if (事業者番号の位置 + INT_ITI < 給付実績ヘッダ情報2.size()) {
//            KyufuJissekiHedajyoho2 給付実績ヘッダ情報 = 給付実績ヘッダ情報2.get(事業者番号の位置 + INT_ITI);
//            set画面の表示(給付実績ヘッダ情報, div, 給付実績基本情報, 給付実績ヘッダ情報2, new RString("後事業者"));
//        }
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
//        List<KyufujissekiKihon> 給付実績基本情報 = get給付実績基本情報();
//        HihokenshaNo 被保険者番号 = 給付実績情報照会情報.getKojinKakuteiKey().get被保険者番号();
//        RString 整理番号 = get整理番号(給付実績基本情報);
//        NyuryokuShikibetsuNo 識別番号検索キー = get識別番号(給付実績基本情報);
//        List<FlexibleYearMonth> サービス提供年月リスト = getサービス提供年月リスト(給付実績基本情報);
//        clear画面(div);
//        FlexibleYearMonth 今提供年月 = getサービス提供年月(サービス提供年月リスト, サービス提供年月);
//        if (!今提供年月.isEmpty()) {
//            div.getCcdKyufuJissekiHeader().initialize(
//                    被保険者番号,
//                    今提供年月,
//                    整理番号,
//                    識別番号検索キー);
//            List<KyufuJissekiHedajyoho2> 給付実績ヘッダ情報2 = get給付実績ヘッダ情報2(今提供年月, 整理番号, 識別番号検索キー);
//            KyufujissekiKihon 給付実績基本 = get給付実績基本情報(給付実績基本情報, 今提供年月,
//                    new JigyoshaNo(div.getCcdKyufuJissekiHeader().get事業者番号()),
//                    整理番号, 識別番号検索キー.value(), div.getCcdKyufuJissekiHeader().get実績区分コード());
//            getHandler(div).onClick_Zengetsu(今提供年月, 給付実績基本, 被保険者番号,
//                    整理番号, 識別番号検索キー, get事業所名称(給付実績基本, 今提供年月),
//                    get給付分類区分(給付実績基本, 今提供年月),
//                    給付実績基本情報, 給付実績ヘッダ情報2, サービス提供年月リスト);
//            ViewStateHolder.put(ViewStateKeys.サービス提供年月, 今提供年月);
//        }
        return ResponseData.of(div).respond();
    }

    private FlexibleYearMonth getサービス提供年月(List<FlexibleYearMonth> サービス提供年月リスト,
            FlexibleYearMonth サービス提供年月) {
        Collections.sort(サービス提供年月リスト, new DateComparatorServiceTeikyoYM());
        for (FlexibleYearMonth サービス年月 : サービス提供年月リスト) {
            if (サービス年月.isBefore(サービス提供年月)) {
                return サービス年月;
            }
        }
        return FlexibleYearMonth.EMPTY;
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
//        List<KyufujissekiKihon> 給付実績基本情報 = get給付実績基本情報();
//        HihokenshaNo 被保険者番号 = 給付実績情報照会情報.getKojinKakuteiKey().get被保険者番号();
//        RString 整理番号 = get整理番号(給付実績基本情報);
//        NyuryokuShikibetsuNo 識別番号検索キー = get識別番号(給付実績基本情報);
//        List<FlexibleYearMonth> サービス提供年月リスト = getサービス提供年月リスト(給付実績基本情報);
//        FlexibleYearMonth 今提供年月 = get次月サービス提供年月(サービス提供年月リスト, サービス提供年月);
//        clear画面(div);
//        if (!今提供年月.isEmpty()) {
//            div.getCcdKyufuJissekiHeader().initialize(
//                    被保険者番号,
//                    今提供年月,
//                    整理番号,
//                    識別番号検索キー);
//            List<KyufuJissekiHedajyoho2> 給付実績ヘッダ情報2 = get給付実績ヘッダ情報2(今提供年月, 整理番号, 識別番号検索キー);
//            KyufujissekiKihon 給付実績基本 = get給付実績基本情報(給付実績基本情報, 今提供年月,
//                    new JigyoshaNo(div.getCcdKyufuJissekiHeader().get事業者番号()),
//                    整理番号, 識別番号検索キー.value(), div.getCcdKyufuJissekiHeader().get実績区分コード());
//            getHandler(div).onClick_Jigetsu(今提供年月, 給付実績基本, 被保険者番号,
//                    整理番号, 識別番号検索キー, get事業所名称(給付実績基本, 今提供年月),
//                    get給付分類区分(給付実績基本, 今提供年月),
//                    給付実績基本情報, 給付実績ヘッダ情報2, サービス提供年月リスト);
//            ViewStateHolder.put(ViewStateKeys.サービス提供年月, 今提供年月);
//        }
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
                    && 実績区分コード.equals(給付実績基本.get給付実績情報作成区分コード())) {
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

    private List<KyufuJissekiHedajyoho2> get給付実績ヘッダ情報2(FlexibleYearMonth サービス提供年月,
            RString 整理番号, NyuryokuShikibetsuNo 識別番号検索キー) {
        KyufuJissekiPrmBusiness 給付実績情報照会情報
                = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        List<KyufuJissekiHedajyoho2> 給付実績ヘッダ情報 = new ArrayList<>();
        KyufuJissekiCommonHeader commonHeader = new KyufuJissekiCommonHeader();
        給付実績ヘッダ情報.addAll(KyufuJissekiShokaiFinder.createInstance().getKyufuJissekiHeaderJoho2(
                給付実績情報照会情報.getKojinKakuteiKey().get被保険者番号(), サービス提供年月, 整理番号, 識別番号検索キー).records());
        commonHeader.set給付実績ヘッダ情報2(給付実績ヘッダ情報);
        給付実績情報照会情報.setCommonHeader(commonHeader);
        ViewStateHolder.put(ViewStateKeys.給付実績情報照会情報, 給付実績情報照会情報);
        return 給付実績情報照会情報.getCommonHeader().get給付実績ヘッダ情報2();
    }

    private List<KyufuJissekiKihonShukeiRelate> get給付実績基本情報() {
        return ViewStateHolder.get(ViewStateKeys.給付実績基本情報, KyufujissekiKihonJyohou.class).getCsData_A();
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

    private List<FlexibleYearMonth> getサービス提供年月リスト(List<KyufujissekiKihon> 給付実績基本情報) {
        List<FlexibleYearMonth> 提供年月リスト = new ArrayList<>();
        for (KyufujissekiKihon 給付実績基本 : 給付実績基本情報) {
            FlexibleYearMonth 提供年月 = 給付実績基本.getサービス提供年月();
            if (!提供年月リスト.contains(提供年月)) {
                提供年月リスト.add(提供年月);
            }
        }
        return 提供年月リスト;
    }

    private FlexibleYearMonth get次月サービス提供年月(List<FlexibleYearMonth> サービス提供年月リスト, FlexibleYearMonth サービス提供年月) {
        Collections.sort(サービス提供年月リスト, new DateComparatorServiceYM());
        for (FlexibleYearMonth サービス年月 : サービス提供年月リスト) {
            if (サービス提供年月.isBefore(サービス年月)) {
                return サービス年月;
            }
        }
        return FlexibleYearMonth.EMPTY;
    }

    private void clear画面(KyufuJissekiKihonJouhouMainDiv div) {
        clear申請内容エリア(div);
        clear合計内容エリア(div);
    }

    private void clear申請内容エリア(KyufuJissekiKihonJouhouMainDiv div) {
        div.getTxtKyufuJissekiKihonSakuseiKubun().clearValue();
        div.getTxtKyufuJissekiKihonYokaigodo().clearValue();
        div.getTxtYukoKaishiYMD().clearValue();
        div.getTxtYukoShuryoYMD().clearValue();
        div.getTxtKyufuJissekiKihonShinsaYM().clearValue();
        div.getTxtKyufuJissekiKihonKeikokuKubun().clearValue();
        div.getTxtKyufuJissekiKihonKyusochiNyushoshaTokurei().clearValue();
        div.getTxtServiceTankasu().clearValue();
        div.getTxtHokenryoSeikyuGaku().clearValue();
        div.getTxtRiyoshaFutanGaku().clearValue();
        div.getTxtKyufuJissekiKihonRojinHokenShichosonNo().clearValue();
        div.getTxtKyufuJissekiKihonRojinHokenJukyushaNo().clearValue();
        div.getTxtKyufuJissekiKihonKokiKoreiHokenshaNo().clearValue();
        div.getTxtKyufuJissekiKihonKokiKoreiHihokenshaNo().clearValue();
        div.getTxtKyufuJissekiKihonKokuhoHokenshaNo().clearValue();
        div.getTxtKyufuJissekiKihonKokuhoHihokenshashoNo().clearValue();
        div.getTxtKyufuJissekiKihonKokuhoKojinNo().clearValue();
        div.getTxtKyufuJissekiKihonKyotakuServiceKeikakuSakuseiKubun().clearValue();
        div.getTxtKyufuJissekiKihonJigyoshoNo().clearValue();
        div.getTxtKyufuJissekiKihonJigyoshoName().clearValue();
        div.getTxtKyufuJissekiKihonKaishiYMD().clearValue();
        div.getTxtKyufuJissekiKihonChushiYMD().clearValue();
        div.getTxtKyufuJissekiKihonChushiRiyu().clearValue();
        div.getTxtKyufuJissekiKihonNyushoYMD().clearValue();
        div.getTxtKyufuJissekiKihonNyushoJitsuNissu().clearValue();
        div.getTxtKyufuJissekiKihonTaishoYMD().clearValue();
        div.getTxtKyufuJissekiKihonGaihakuNissu().clearValue();
        div.getTxtKyufuJissekiKihonNyushoMaeJokyo().clearValue();
        div.getTxtKyufuJissekiKihonNyushoAtoJokyo().clearValue();
        div.getTxtKyufuJissekiKihonHokenKyufuRitsu().clearValue();
        div.getTxtKyufuJissekiKihonKohi1KyufuRitsu().clearValue();
        div.getTxtKyufuJissekiKihonKohi2KyufuRitsu().clearValue();
        div.getTxtKyufuJissekiKihonKohi3KyufuRitsu().clearValue();
        div.getTxtKyufuJissekiKihonKohiFutanshaNo1().clearValue();
        div.getTxtKyufuJissekiKihonKohiJukyushaNo1().clearValue();
        div.getTxtKyufuJissekiKihonKohiFutanshaNo2().clearValue();
        div.getTxtKyufuJissekiKihonKohiJukyushaNo2().clearValue();
        div.getTxtKyufuJissekiKihonKohiFutanshaNo3().clearValue();
        div.getTxtKyufuJissekiKihonKohiJukyushaNo3().clearValue();
    }

    private void clear合計内容エリア(KyufuJissekiKihonJouhouMainDiv div) {
        div.getTxtMaeHokenServiceTanisu().clearValue();
        div.getTxtGoHokenServiceTanisu().clearValue();
        div.getTxtMaeKohi1ServiceTanisu().clearValue();
        div.getTxtGoKohi1ServiceTanisu().clearValue();
        div.getTxtMaeKohi2ServiceTanisu().clearValue();
        div.getTxtGoKohi2ServiceTanisu().clearValue();
        div.getTxtMaeKohi3ServiceTanisu().clearValue();
        div.getTxtGoKohi3ServiceTanisu().clearValue();
        div.getTxtMaeHokenHokenSeikyugaku().clearValue();
        div.getTxtGoHokenHokenSeikyugaku().clearValue();
        div.getTxtMaeKohi1HokenSeikyugaku().clearValue();
        div.getTxtGoKohi1HokenSeikyugaku().clearValue();
        div.getTxtMaeKohi2HokenSeikyugaku().clearValue();
        div.getTxtGoKohi2HokenSeikyugaku().clearValue();
        div.getTxtMaeKohi3HokenSeikyugaku().clearValue();
        div.getTxtGoKohi3HokenSeikyugaku().clearValue();
        div.getTxtMaeHokenRiyoshaFutangaku().clearValue();
        div.getTxtGoHokenRiyoshaFutangaku().clearValue();
        div.getTxtMaeKohi1RiyoshaFutangaku().clearValue();
        div.getTxtGoKohi1RiyoshaFutangaku().clearValue();
        div.getTxtMaeKohi2RiyoshaFutangaku().clearValue();
        div.getTxtGoKohi2RiyoshaFutangaku().clearValue();
        div.getTxtMaeKohi3RiyoshaFutangaku().clearValue();
        div.getTxtGoKohi3RiyoshaFutangaku().clearValue();
        div.getTxtMaeHokenKinkyujiShisetsuRyoyohi().clearValue();
        div.getTxtGoHokenKinkyujiShisetsuRyoyohi().clearValue();
        div.getTxtMaeKohi1KinkyujiShisetsuRyoyohi().clearValue();
        div.getTxtGoKohi1KinkyujiShisetsuRyoyohi().clearValue();
        div.getTxtMaeKohi2KinkyujiShisetsuRyoyohi().clearValue();
        div.getTxtGoKohi2KinkyujiShisetsuRyoyohi().clearValue();
        div.getTxtMaeKohi3KinkyujiShisetsuRyoyohi().clearValue();
        div.getTxtGoKohi3KinkyujiShisetsuRyoyohi().clearValue();
        div.getTxtMaeHokenTokuteiShinryohi().clearValue();
        div.getTxtGoHokenTokuteiShinryohi().clearValue();
        div.getTxtMaeKohi1TokuteiShinryohi().clearValue();
        div.getTxtGoKohi1TokuteiShinryohi().clearValue();
        div.getTxtMaeKohi2TokuteiShinryohi().clearValue();
        div.getTxtGoKohi2TokuteiShinryohi().clearValue();
        div.getTxtMaeKohi3TokuteiShinryohi().clearValue();
        div.getTxtGoKohi3TokuteiShinryohi().clearValue();
        div.getTxtMaeHokenTokuteiNyushosha().clearValue();
        div.getTxtGoHokenTokuteiNyushosha().clearValue();
        div.getTxtMaeKohi1TokuteiNyushosha().clearValue();
        div.getTxtGoKohi1TokuteiNyushosha().clearValue();
        div.getTxtMaeKohi2TokuteiNyushosha().clearValue();
        div.getTxtGoKohi2TokuteiNyushosha().clearValue();
        div.getTxtMaeKohi3TokuteiNyushosha().clearValue();
        div.getTxtGoKohi3TokuteiNyushosha().clearValue();
    }

    private static class DateComparatorServiceTeikyoYM implements Comparator<FlexibleYearMonth>, Serializable {

        @Override
        public int compare(FlexibleYearMonth o1, FlexibleYearMonth o2) {
            return o2.compareTo(o1);
        }
    }

    private static class DateComparatorServiceYM implements Comparator<FlexibleYearMonth>, Serializable {

        @Override
        public int compare(FlexibleYearMonth o1, FlexibleYearMonth o2) {
            return o1.compareTo(o2);
        }
    }
}
