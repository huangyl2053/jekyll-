/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0010016;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKihon;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiShokujiHiyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiCommonHeader;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHedajyoho2;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiKihonShukeiRelate;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiPrmBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiKihonJyohou;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiMeisaiBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiMeisaiJyohou;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiShokujiHiyoJyohou;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010016.DBC0010016TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010016.ShokujiHiyoShokaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010016.ShokujiHiyoShokaiHandler;
import jp.co.ndensan.reams.db.dbc.service.core.kyufujissekishokai.KyufuJissekiShokaiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 給付実績照会_(DBC0010016)食事費用のcontrollerです
 *
 * @reamsid_L DBC-2970-080 zhaoran
 */
public class ShokujiHiyoShokai {

    private static final int INT_ZERO = 0;

    /**
     * 画面の初期化です。
     *
     * @param div 画面情報
     * @return ResponseData<ShokujiHiyoShokaiDiv>
     */
    public ResponseData<ShokujiHiyoShokaiDiv> onLoad(ShokujiHiyoShokaiDiv div) {
        KyufuJissekiPrmBusiness 給付実績情報照会情報 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        FlexibleYearMonth サービス提供年月 = ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class);
        List<KyufujissekiKihon> 給付実績基本情報 = get給付実績基本情報();
        RString 整理番号 = get整理番号(給付実績基本情報);
        NyuryokuShikibetsuNo 識別番号検索キー = get識別番号(給付実績基本情報);
        div.getCcdKyufuJissekiHeader().initialize(
                給付実績情報照会情報.getKojinKakuteiKey().get被保険者番号(),
                サービス提供年月,
                整理番号,
                識別番号検索キー);
        List<ShikibetsuNoKanri> 識別番号管理データ取得 = KyufuJissekiShokaiFinder.createInstance().getShikibetsuBangoKanri(
                サービス提供年月, 識別番号検索キー).records();
        getHandler(div).setDataGrid(getCsData_E(), getCsData_B(), getCsData_E(), サービス提供年月);
        if (識別番号管理データ取得 != null && !識別番号管理データ取得.isEmpty()) {
            getHandler(div).setButton(識別番号管理データ取得.get(0));
        }
        RString 事業者番号 = div.getCcdKyufuJissekiHeader().get事業者番号();
        RString 実績区分コード = div.getCcdKyufuJissekiHeader().get実績区分コード();
        List<KyufuJissekiHedajyoho2> 事業者番号リスト = 給付実績情報照会情報.getCommonHeader().get給付実績ヘッダ情報2();
        getHandler(div).setJigyoshaBtn(事業者番号リスト, 整理番号, 事業者番号, 識別番号検索キー.value(), サービス提供年月.toDateString(), 実績区分コード);
        return ResponseData.of(div).respond();
    }

    /**
     * 「前事業者」ボタン押下
     *
     * @param div 画面情報
     * @return ResponseData<ShokujiHiyoShokaiDiv>
     */
    public ResponseData<ShokujiHiyoShokaiDiv> onClick_MaeJigyosha(ShokujiHiyoShokaiDiv div) {
        List<KyufuJissekiHedajyoho2> 事業者番号リスト
                = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class)
                .getCommonHeader().get給付実績ヘッダ情報2();
        getHandler(div).change事業者(new RString("前事業者"), 事業者番号リスト, getCsData_E(), getCsData_B(), getCsData_E());
        return ResponseData.of(div).respond();
    }

    /**
     * 「後事業者」ボタン押下
     *
     * @param div 画面情報
     * @return ResponseData<ShokujiHiyoShokaiDiv>
     */
    public ResponseData<ShokujiHiyoShokaiDiv> onClick_AtoJigyosha(ShokujiHiyoShokaiDiv div) {
        List<KyufuJissekiHedajyoho2> 事業者番号リスト
                = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class)
                .getCommonHeader().get給付実績ヘッダ情報2();
        getHandler(div).change事業者(new RString("後事業者"), 事業者番号リスト, getCsData_E(), getCsData_B(), getCsData_E());
        return ResponseData.of(div).respond();
    }

    /**
     * 「前月」ボタン押下
     *
     * @param div 画面情報
     * @return ResponseData<ShokujiHiyoShokaiDiv>
     */
    public ResponseData<ShokujiHiyoShokaiDiv> onClick_btnZengetsu(ShokujiHiyoShokaiDiv div) {
        KyufuJissekiPrmBusiness 給付実績情報照会情報 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        FlexibleYearMonth サービス提供年月 = ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class);
        List<KyufujissekiKihon> 給付実績基本情報 = get給付実績基本情報();
        RString 整理番号 = get整理番号(給付実績基本情報);
        NyuryokuShikibetsuNo 識別番号 = get識別番号(給付実績基本情報);
        getHandler(div).change年月(new RString("前月"), 給付実績情報照会情報,
                サービス提供年月,
                整理番号, 給付実績情報照会情報.getKojinKakuteiKey().get被保険者番号(), 識別番号,
                getCsData_E(), getCsData_B(), getCsData_E());
        FlexibleYearMonth 画面提供年月 = getHandler(div).get前月サービス提供年月(getCsData_E(), サービス提供年月);
        ViewStateHolder.put(ViewStateKeys.サービス提供年月, 画面提供年月);
        RString 事業者番号 = div.getCcdKyufuJissekiHeader().get事業者番号();
        RString 実績区分コード = div.getCcdKyufuJissekiHeader().get実績区分コード();
        get給付実績ヘッダ情報2(画面提供年月, 整理番号, 識別番号);
        List<KyufuJissekiHedajyoho2> 事業者番号リスト = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報,
                KyufuJissekiPrmBusiness.class).getCommonHeader().get給付実績ヘッダ情報2();
        getHandler(div).setJigyoshaBtn(事業者番号リスト, 整理番号, 事業者番号, 識別番号.value(),
                画面提供年月.toDateString(), 実績区分コード);
        return ResponseData.of(div).respond();
    }

    /**
     * 「次月」ボタン押下
     *
     * @param div 画面情報
     * @return ResponseData<ShokujiHiyoShokaiDiv>
     */
    public ResponseData<ShokujiHiyoShokaiDiv> onClick_btnJigetsu(ShokujiHiyoShokaiDiv div) {
        KyufuJissekiPrmBusiness 給付実績情報照会情報 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        FlexibleYearMonth サービス提供年月 = ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class);
        List<KyufujissekiKihon> 給付実績基本情報 = get給付実績基本情報();
        RString 整理番号 = get整理番号(給付実績基本情報);
        NyuryokuShikibetsuNo 識別番号 = get識別番号(給付実績基本情報);
        getHandler(div).change年月(new RString("次月"), 給付実績情報照会情報,
                サービス提供年月,
                整理番号, 給付実績情報照会情報.getKojinKakuteiKey().get被保険者番号(), 識別番号,
                getCsData_E(), getCsData_B(), getCsData_E());
        FlexibleYearMonth 画面提供年月 = getHandler(div).get次月サービス提供年月(getCsData_E(), サービス提供年月);
        ViewStateHolder.put(ViewStateKeys.サービス提供年月, 画面提供年月);
        RString 事業者番号 = div.getCcdKyufuJissekiHeader().get事業者番号();
        RString 実績区分コード = div.getCcdKyufuJissekiHeader().get実績区分コード();
        get給付実績ヘッダ情報2(画面提供年月, 整理番号, 識別番号);
        List<KyufuJissekiHedajyoho2> 事業者番号リスト = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報,
                KyufuJissekiPrmBusiness.class).getCommonHeader().get給付実績ヘッダ情報2();
        getHandler(div).setJigyoshaBtn(事業者番号リスト, 整理番号, 事業者番号, 識別番号.value(),
                画面提供年月.toDateString(), 実績区分コード);
        return ResponseData.of(div).respond();
    }

    /**
     * 基本情報ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnKihon(ShokujiHiyoShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010016TransitionEventName.基本情報).respond();
    }

    /**
     * 明細集計ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnMeisaiShukei(ShokujiHiyoShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010016TransitionEventName.明細_集計).respond();
    }

    /**
     * 緊急時施設療養費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnKinkyujiShisetsuRyoyo(ShokujiHiyoShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010016TransitionEventName.緊急時施設療養費).respond();
    }

    /**
     * 所定疾患施設療養費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnShoteiShikkanShisetsuRyoyo(ShokujiHiyoShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010016TransitionEventName.所定疾患施設療養費).respond();
    }

    /**
     * 福祉用具購入費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnFukushiYoguKonyu(ShokujiHiyoShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010016TransitionEventName.福祉用具購入費).respond();
    }

    /**
     * 特定入所者費用ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnTokuteiNyushosha(ShokujiHiyoShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010016TransitionEventName.特定入所者費用).respond();
    }

    /**
     * 高額介護サービス費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnKogakuKaigoService(ShokujiHiyoShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010016TransitionEventName.高額介護サービス費).respond();
    }

    /**
     * 特定診療費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnTokuteiShinryo(ShokujiHiyoShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010016TransitionEventName.特定診療費).respond();
    }

    /**
     * 居宅サービス計画費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnKyotakuServiceKeikaku(ShokujiHiyoShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010016TransitionEventName.居宅サービス計画費).respond();
    }

    /**
     * 住宅改修費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnJutakuKaishu(ShokujiHiyoShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010016TransitionEventName.住宅改修費).respond();
    }

    /**
     * ケアマネジメント費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnCareManagement(ShokujiHiyoShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010016TransitionEventName.ケアマネジメント費).respond();
    }

    /**
     * 社福軽減費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnShafukuKeigen(ShokujiHiyoShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010016TransitionEventName.社福軽減費).respond();
    }

    /**
     * 給付実績一覧に戻るを押します。
     *
     * @param div 画面情報
     * @return ResponseData<ShokujiHiyoShokaiDiv>
     */
    public ResponseData onClick_btnReturn(ShokujiHiyoShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010016TransitionEventName.給付実績照会検索一覧).respond();
    }

    private ShokujiHiyoShokaiHandler getHandler(ShokujiHiyoShokaiDiv div) {
        return new ShokujiHiyoShokaiHandler(div);
    }

    private List<KyufujissekiKihon> get給付実績基本情報() {
        List<KyufuJissekiKihonShukeiRelate> entityList
                = ViewStateHolder.get(ViewStateKeys.給付実績基本情報, KyufujissekiKihonJyohou.class).getCsData_A();
        List<KyufujissekiKihon> 給付実績基本情報List = new ArrayList<>();
        for (KyufuJissekiKihonShukeiRelate entity : entityList) {
            給付実績基本情報List.add(entity.get給付実績基本データ());
        }
        return 給付実績基本情報List;
    }

    private RString get整理番号(List<KyufujissekiKihon> 給付実績基本情報) {
        return 給付実績基本情報.get(INT_ZERO).get整理番号();
    }

    private NyuryokuShikibetsuNo get識別番号(List<KyufujissekiKihon> 給付実績基本情報) {
        return 給付実績基本情報.get(INT_ZERO).get入力識別番号();
    }

    private List<KyufujissekiMeisaiBusiness> getCsData_B() {
        return ViewStateHolder.get(ViewStateKeys.給付実績サービス明細情報,
                KyufujissekiMeisaiJyohou.class).getCsData_B();
    }

    private List<KyufujissekiShokujiHiyo> getCsData_E() {
        return ViewStateHolder.get(ViewStateKeys.給付実績食事費用情報,
                KyufujissekiShokujiHiyoJyohou.class).getCsData_E();
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
