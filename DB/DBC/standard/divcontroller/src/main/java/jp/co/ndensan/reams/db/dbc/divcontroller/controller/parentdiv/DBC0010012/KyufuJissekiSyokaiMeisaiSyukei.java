/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0010012;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKihon;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiShukei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiCommonHeader;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHedajyoho2;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiPrmBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiKihonJyohou;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiMeisaiBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiMeisaiJushochiTokureiBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiMeisaiJushochiTokureiJyohou;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiMeisaiJyohou;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiShukeiJyohou;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010012.KyufuJissekiSyokaiMeisaiSyukeiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010012.KyufuJissekiSyokaiMeisaiSyukeiHandler;
import jp.co.ndensan.reams.db.dbc.service.core.kyufujissekishokai.KyufuJissekiShokaiFinder;
import jp.co.ndensan.reams.db.dbc.service.core.kyufujissekisyokaimeisaisyukei.KyufuJissekiSyokaiMeisaiSyukeiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 給付実績照会_明細集計画面処理クラスです。
 *
 * @reamsid_L DBC-2970-040 wangxiaodong
 */
public class KyufuJissekiSyokaiMeisaiSyukei {

    private static final int INT_ZERO = 0;

    /**
     * 画面の初期化メソッドです。
     *
     * @param div KyufuJissekiSyokaiMeisaiSyukeiDiv
     * @return 給付実績照会_明細集計画面
     */
    public ResponseData<KyufuJissekiSyokaiMeisaiSyukeiDiv> onLoad(KyufuJissekiSyokaiMeisaiSyukeiDiv div) {
        KyufuJissekiPrmBusiness 給付実績情報照会情報 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        FlexibleYearMonth サービス提供年月 = ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class);
        KyufujissekiKihon 給付実績基本情報 = getCsData_A();
        RString 整理番号 = 給付実績基本情報.get整理番号();
        NyuryokuShikibetsuNo 識別番号 = 給付実績基本情報.get入力識別番号();
        HihokenshaNo 被保険者番号 = 給付実績情報照会情報.getKojinKakuteiKey().get被保険者番号();
        div.getCcdKyufuJissekiHeader().initialize(被保険者番号, サービス提供年月, 整理番号, 識別番号);
        KyufuJissekiSyokaiMeisaiSyukeiHandler handler = getHandler(div);
        RString 様式番号 = div.getCcdKyufuJissekiHeader().get様式番号();
        RString 事業者番号 = div.getCcdKyufuJissekiHeader().get事業者番号();
        handler.onLoad(getCsData_Z(), getCsData_B(), getCsData_N(),
                整理番号, サービス提供年月, 様式番号, 事業者番号,
                KyufuJissekiSyokaiMeisaiSyukeiFinder.createInstance().get保険者情報().records());
        List<ShikibetsuNoKanri> 識別番号管理リスト = KyufuJissekiShokaiFinder.createInstance().getShikibetsuBangoKanri(
                サービス提供年月, 識別番号).records();
        if (識別番号管理リスト != null && !識別番号管理リスト.isEmpty()) {
            handler.setButton(識別番号管理リスト.get(0), サービス提供年月);
        }
        RString 実績区分コード = div.getCcdKyufuJissekiHeader().get実績区分コード();
        List<KyufuJissekiHedajyoho2> 事業者番号リスト = get給付実績ヘッダ情報2(サービス提供年月, 整理番号, 識別番号);
        handler.check事業者Btn(事業者番号リスト, 整理番号, 事業者番号, 様式番号, サービス提供年月.toDateString(), 実績区分コード);
        return ResponseData.of(div).respond();
    }

    /**
     * 「前月」ボタンをクリックします。
     *
     * @param div KyufuJissekiSyokaiMeisaiSyukeiDiv
     * @return 給付実績照会_明細集計画面
     */
    public ResponseData<KyufuJissekiSyokaiMeisaiSyukeiDiv> onClick_btnZengetsu(KyufuJissekiSyokaiMeisaiSyukeiDiv div) {
        KyufuJissekiPrmBusiness 給付実績情報照会情報 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        KyufujissekiKihon 給付実績基本情報 = getCsData_A();
        RString 整理番号 = 給付実績基本情報.get整理番号();
        NyuryokuShikibetsuNo 識別番号 = 給付実績基本情報.get入力識別番号();
        FlexibleYearMonth 提供年月
                = ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class);
        getHandler(div).change年月(new RString("前月"), 給付実績情報照会情報.getKojinKakuteiKey().get被保険者番号(),
                getCsData_Z(), getCsData_B(), getCsData_N(),
                get給付実績ヘッダ情報2(getHandler(div).get今提供年月(new RString("前月"), getCsData_Z(), getCsData_B(), 提供年月),
                        整理番号, 識別番号),
                提供年月, 整理番号, 識別番号,
                KyufuJissekiSyokaiMeisaiSyukeiFinder.createInstance().get保険者情報().records());
        FlexibleYearMonth 今提供年月 = getHandler(div).get今提供年月(new RString("前月"), getCsData_Z(), getCsData_B(), 提供年月);
        ViewStateHolder.put(ViewStateKeys.サービス提供年月, 今提供年月);
        return ResponseData.of(div).respond();
    }

    /**
     * 「次月」ボタンをクリックします。
     *
     * @param div KyufuJissekiSyokaiMeisaiSyukeiDiv
     * @return 給付実績照会_明細集計画面
     */
    public ResponseData<KyufuJissekiSyokaiMeisaiSyukeiDiv> onClick_btnJigetsu(KyufuJissekiSyokaiMeisaiSyukeiDiv div) {
        KyufuJissekiPrmBusiness 給付実績情報照会情報 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        KyufujissekiKihon 給付実績基本情報 = getCsData_A();
        RString 整理番号 = 給付実績基本情報.get整理番号();
        NyuryokuShikibetsuNo 識別番号 = 給付実績基本情報.get入力識別番号();
        FlexibleYearMonth 提供年月
                = ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class);
        getHandler(div).change年月(new RString("次月"), 給付実績情報照会情報.getKojinKakuteiKey().get被保険者番号(),
                getCsData_Z(), getCsData_B(), getCsData_N(),
                get給付実績ヘッダ情報2(getHandler(div).get今提供年月(new RString("次月"), getCsData_Z(), getCsData_B(), 提供年月),
                        整理番号, 識別番号),
                提供年月, 整理番号, 識別番号,
                KyufuJissekiSyokaiMeisaiSyukeiFinder.createInstance().get保険者情報().records());
        FlexibleYearMonth 今提供年月 = getHandler(div).get今提供年月(new RString("次月"), getCsData_Z(), getCsData_B(), 提供年月);
        ViewStateHolder.put(ViewStateKeys.サービス提供年月, 今提供年月);
        return ResponseData.of(div).respond();
    }

    /**
     * 「前事業者」ボタンをクリックします。
     *
     * @param div KyufuJissekiSyokaiMeisaiSyukeiDiv
     * @return 給付実績照会_明細集計画面
     */
    public ResponseData<KyufuJissekiSyokaiMeisaiSyukeiDiv> onClick_btnMaeJigyosha(KyufuJissekiSyokaiMeisaiSyukeiDiv div) {
        KyufuJissekiPrmBusiness 給付実績情報照会情報 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        getHandler(div).change事業者(new RString("前事業者"),
                給付実績情報照会情報.getCommonHeader().get給付実績ヘッダ情報2(),
                getCsData_Z(), getCsData_B(), getCsData_N(),
                KyufuJissekiSyokaiMeisaiSyukeiFinder.createInstance().get保険者情報().records());
        return ResponseData.of(div).respond();
    }

    /**
     * 「次事業者」ボタンをクリックします。
     *
     * @param div KyufuJissekiSyokaiMeisaiSyukeiDiv
     * @return 給付実績照会_明細集計画面
     */
    public ResponseData<KyufuJissekiSyokaiMeisaiSyukeiDiv> onClick_btnAtoJigyosha(KyufuJissekiSyokaiMeisaiSyukeiDiv div) {
        KyufuJissekiPrmBusiness 給付実績情報照会情報 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        getHandler(div).change事業者(new RString("後事業者"),
                給付実績情報照会情報.getCommonHeader().get給付実績ヘッダ情報2(),
                getCsData_Z(), getCsData_B(), getCsData_N(),
                KyufuJissekiSyokaiMeisaiSyukeiFinder.createInstance().get保険者情報().records());
        return ResponseData.of(div).respond();
    }

    private KyufujissekiKihon getCsData_A() {
        return ViewStateHolder.get(ViewStateKeys.給付実績基本情報, KyufujissekiKihonJyohou.class)
                .getCsData_A().get(INT_ZERO).get給付実績基本データ();
    }

    private List<KyufujissekiMeisaiBusiness> getCsData_B() {
        return ViewStateHolder.get(ViewStateKeys.給付実績サービス明細情報, KyufujissekiMeisaiJyohou.class).getCsData_B();
    }

    private List<KyufujissekiMeisaiJushochiTokureiBusiness> getCsData_N() {
        return ViewStateHolder.get(ViewStateKeys.給付実績明細_住所地特例,
                KyufujissekiMeisaiJushochiTokureiJyohou.class).getCsData_N();
    }

    private List<KyufujissekiShukei> getCsData_Z() {
        return ViewStateHolder.get(ViewStateKeys.給付実績集計情報, KyufujissekiShukeiJyohou.class).getCsData_Z();
    }

    private KyufuJissekiSyokaiMeisaiSyukeiHandler getHandler(KyufuJissekiSyokaiMeisaiSyukeiDiv div) {
        return new KyufuJissekiSyokaiMeisaiSyukeiHandler(div);
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
}
