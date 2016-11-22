/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0010018;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKihon;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiCommonHeader;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHedajyoho2;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiPrmBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiFukushiYoguHanbaihiBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiFukushiYoguHanbaihiJyohou;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiKihonJyohou;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010018.DBC0010018TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010018.FukushiYoguKonyuhiShokaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010018.FukushiYoguKonyuhiShokaiHandler;
import jp.co.ndensan.reams.db.dbc.service.core.kyufujissekishokai.KyufuJissekiShokaiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 給付実績の福祉用具購入費を照会の画面処理クラスです。
 *
 * @reamsid_L DBC-2970-100 zhaoyao
 */
public class FukushiYoguKonyuhiShokai {

    private static final int INT_ZERO = 0;

    /**
     * 画面の初期化です。
     *
     * @param div 画面情報
     * @return ResponseData<FukushiYoguKonyuhiShokaiDiv>
     */
    public ResponseData<FukushiYoguKonyuhiShokaiDiv> onLoad(FukushiYoguKonyuhiShokaiDiv div) {
        KyufuJissekiPrmBusiness 給付実績情報照会情報
                = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        FlexibleYearMonth サービス提供年月
                = ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class);
        KyufujissekiKihon 給付実績基本情報 = getCsData_A();
        RString 整理番号 = 給付実績基本情報.get整理番号();
        NyuryokuShikibetsuNo 識別番号検索キー = 給付実績基本情報.get入力識別番号();
        div.getCcdKyufuJissekiHeader().initialize(
                給付実績情報照会情報.getKojinKakuteiKey().get被保険者番号(),
                サービス提供年月,
                整理番号,
                識別番号検索キー);
        List<ShikibetsuNoKanri> 識別番号管理データリスト = KyufuJissekiShokaiFinder.createInstance().getShikibetsuBangoKanri(
                サービス提供年月, 識別番号検索キー).records();
        if (!識別番号管理データリスト.isEmpty()) {
            getHandler(div).setButton(識別番号管理データリスト.get(0));
        }
        getHandler(div).onLoad(getCsData_G(), 整理番号, div.getCcdKyufuJissekiHeader().get事業者番号(),
                div.getCcdKyufuJissekiHeader().get様式番号(), サービス提供年月.toDateString());
        List<KyufuJissekiHedajyoho2> 事業者番号リスト = get給付実績ヘッダ情報2(サービス提供年月, 整理番号, 識別番号検索キー);
        RString 事業者番号 = div.getCcdKyufuJissekiHeader().get事業者番号();
        RString 様式番号 = div.getCcdKyufuJissekiHeader().get様式番号();
        RString 実績区分コード = div.getCcdKyufuJissekiHeader().get実績区分コード();
        getHandler(div).setJigyoshaBtn(事業者番号リスト, 整理番号,
                事業者番号, 様式番号, サービス提供年月.toDateString(), 実績区分コード);
        return ResponseData.of(div).respond();
    }

    /**
     * 前事業者ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<FukushiYoguKonyuhiShokaiDiv>
     */
    public ResponseData<FukushiYoguKonyuhiShokaiDiv> onClick_btnMaeJigyosha(FukushiYoguKonyuhiShokaiDiv div) {
        KyufuJissekiPrmBusiness 給付実績情報照会情報 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        getHandler(div).change事業者(new RString("前事業者"),
                給付実績情報照会情報.getCommonHeader().get給付実績ヘッダ情報2(),
                getCsData_G());
        return ResponseData.of(div).respond();
    }

    /**
     * 後事業者ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<FukushiYoguKonyuhiShokaiDiv>
     */
    public ResponseData<FukushiYoguKonyuhiShokaiDiv> onClick_btnAtoJigyosha(FukushiYoguKonyuhiShokaiDiv div) {
        KyufuJissekiPrmBusiness 給付実績情報照会情報 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        getHandler(div).change事業者(new RString("後事業者"),
                給付実績情報照会情報.getCommonHeader().get給付実績ヘッダ情報2(),
                getCsData_G());
        return ResponseData.of(div).respond();
    }

    /**
     * 前月ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<FukushiYoguKonyuhiShokaiDiv>
     */
    public ResponseData<FukushiYoguKonyuhiShokaiDiv> onClick_btnZengetsu(FukushiYoguKonyuhiShokaiDiv div) {
        KyufuJissekiPrmBusiness 給付実績情報照会情報 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        KyufujissekiKihon 給付実績基本情報 = getCsData_A();
        RString 整理番号 = 給付実績基本情報.get整理番号();
        NyuryokuShikibetsuNo 識別番号検索キー = 給付実績基本情報.get入力識別番号();
        FlexibleYearMonth 提供年月
                = ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class);
        getHandler(div).change年月(new RString("前月"), getCsData_G(),
                get給付実績ヘッダ情報2(getHandler(div).get今提供年月(new RString("前月"), getCsData_G(), 提供年月),
                        整理番号, 識別番号検索キー),
                提供年月,
                整理番号,
                給付実績情報照会情報.getKojinKakuteiKey().get被保険者番号(),
                識別番号検索キー);
        FlexibleYearMonth 今提供年月 = getHandler(div).get今提供年月(new RString("前月"), getCsData_G(), 提供年月);
        ViewStateHolder.put(ViewStateKeys.サービス提供年月, 今提供年月);
        return ResponseData.of(div).respond();
    }

    /**
     * 次月ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<FukushiYoguKonyuhiShokaiDiv>
     */
    public ResponseData<FukushiYoguKonyuhiShokaiDiv> onClick_btnJigetsu(FukushiYoguKonyuhiShokaiDiv div) {
        KyufuJissekiPrmBusiness 給付実績情報照会情報 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        KyufujissekiKihon 給付実績基本情報 = getCsData_A();
        RString 整理番号 = 給付実績基本情報.get整理番号();
        NyuryokuShikibetsuNo 識別番号検索キー = 給付実績基本情報.get入力識別番号();
        FlexibleYearMonth 提供年月
                = ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class);
        getHandler(div).change年月(new RString("次月"), getCsData_G(),
                get給付実績ヘッダ情報2(getHandler(div).get今提供年月(new RString("次月"), getCsData_G(), 提供年月),
                        整理番号, 識別番号検索キー),
                提供年月,
                整理番号,
                給付実績情報照会情報.getKojinKakuteiKey().get被保険者番号(),
                識別番号検索キー);
        FlexibleYearMonth 今提供年月 = getHandler(div).get今提供年月(new RString("次月"), getCsData_G(), 提供年月);
        ViewStateHolder.put(ViewStateKeys.サービス提供年月, 今提供年月);
        return ResponseData.of(div).respond();
    }

    /**
     * 基本情報ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnKihon(FukushiYoguKonyuhiShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010018TransitionEventName.基本情報).respond();
    }

    /**
     * 明細集計ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnMeisaiShukei(FukushiYoguKonyuhiShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010018TransitionEventName.明細_集計).respond();
    }

    /**
     * 緊急時施設療養費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnKinkyujiShisetsuRyoyo(FukushiYoguKonyuhiShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010018TransitionEventName.緊急時施設療養費).respond();
    }

    /**
     * 所定疾患施設療養費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnFukushiYoguKonyu(FukushiYoguKonyuhiShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010018TransitionEventName.所定疾患施設療養費).respond();
    }

    /**
     * 食事費用ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnShokuji(FukushiYoguKonyuhiShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010018TransitionEventName.食事費用).respond();
    }

    /**
     * 特定入所者費用ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnTokuteiNyushosha(FukushiYoguKonyuhiShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010018TransitionEventName.特定入所者費用).respond();
    }

    /**
     * 高額介護サービス費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnKogakuKaigoService(FukushiYoguKonyuhiShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010018TransitionEventName.高額介護サービス費).respond();
    }

    /**
     * 特定診療費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnTokuteiShinryo(FukushiYoguKonyuhiShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010018TransitionEventName.特定診療費).respond();
    }

    /**
     * 居宅サービス計画費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnKyotakuServiceKeikaku(FukushiYoguKonyuhiShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010018TransitionEventName.居宅サービス計画費).respond();
    }

    /**
     * 住宅改修費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnJutakuKaishu(FukushiYoguKonyuhiShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010018TransitionEventName.住宅改修費).respond();
    }

    /**
     * ケアマネジメント費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnCareManagement(FukushiYoguKonyuhiShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010018TransitionEventName.ケアマネジメント費).respond();
    }

    /**
     * 社福軽減費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnShafukuKeigen(FukushiYoguKonyuhiShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010018TransitionEventName.社福軽減費).respond();
    }

    /**
     * 給付実績一覧に戻るを押します。
     *
     * @param div 画面情報
     * @return ResponseData<FukushiYoguKonyuhiShokaiDiv>
     */
    public ResponseData onClick_btnReturn(FukushiYoguKonyuhiShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010018TransitionEventName.給付実績照会検索一覧).respond();
    }

    private FukushiYoguKonyuhiShokaiHandler getHandler(FukushiYoguKonyuhiShokaiDiv div) {
        return new FukushiYoguKonyuhiShokaiHandler(div);
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

    private KyufujissekiKihon getCsData_A() {
        return ViewStateHolder.get(ViewStateKeys.給付実績基本情報,
                KyufujissekiKihonJyohou.class).getCsData_A().get(INT_ZERO).get給付実績基本データ();
    }

    private List<KyufujissekiFukushiYoguHanbaihiBusiness> getCsData_G() {
        return ViewStateHolder.get(ViewStateKeys.給付実績福祉用具情報,
                KyufujissekiFukushiYoguHanbaihiJyohou.class).getCsData_G();
    }
}
