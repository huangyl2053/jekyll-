/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0010015;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKihon;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiTokuteiSinryoTokubetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiTokuteiSinryohi;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiCommonHeader;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHedajyoho2;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiKihonShukeiRelate;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiPrmBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiKihonJyohou;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiTokuteiSinryoTokubetsuRyoyoJyohou;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiTokuteiSinryohiJyohou;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010015.DBC0010015TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010015.TokuteiShinryohiMainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010015.TokuteiShinryohiInfoPanelHandler;
import jp.co.ndensan.reams.db.dbc.service.core.kyufujissekishokai.KyufuJissekiShokaiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 給付実績照会_(DBC0010015)特定診療費のcontrollerです
 *
 * @reamsid_L DBC-2970-070 guoqilin
 */
public class TokuteiShinryohiMain {

    private static final int INT_ZERO = 0;

    /**
     * 画面初期化のメソッドです。
     *
     * @param div TokuteiShinryohiMainDiv
     * @return ResponseData<TokuteiShinryohiMainDiv>
     */
    public ResponseData<TokuteiShinryohiMainDiv> onLoad(TokuteiShinryohiMainDiv div) {
        KyufuJissekiPrmBusiness 給付実績情報照会情報 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        FlexibleYearMonth サービス提供年月 = ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class);
        List<KyufujissekiKihon> 給付実績基本情報 = getCsData_A();
        RString 整理番号 = get整理番号(給付実績基本情報);
        NyuryokuShikibetsuNo 識別番号検索キー = get識別番号(給付実績基本情報);
        div.getCcdKyufuJissekiHeader().initialize(
                給付実績情報照会情報.getKojinKakuteiKey().get被保険者番号(), サービス提供年月,
                整理番号, 識別番号検索キー);
        set給付実績ヘッダ情報2(サービス提供年月, 整理番号, 識別番号検索キー);
        getHandler(div).onLoad(給付実績情報照会情報, サービス提供年月, getCsData_J(), getCsData_D());
        List<ShikibetsuNoKanri> 識別番号管理データリスト = KyufuJissekiShokaiFinder.createInstance().getShikibetsuBangoKanri(
                サービス提供年月, 識別番号検索キー).records();
        if (!識別番号管理データリスト.isEmpty()) {
            getHandler(div).clear制御性(識別番号管理データリスト.get(0));
        }
        div.getTekiyoPanelPanel().setIsOpen(false);
        return createResponse(div);
    }

    /**
     * *
     * 前月ボタン押下
     *
     * @param div TokuteiShinryohiMainDiv
     * @return ResponseData<TokuteiShinryohiMainDiv>
     */
    public ResponseData<TokuteiShinryohiMainDiv> onClick_Zengatsu(TokuteiShinryohiMainDiv div) {
        this.close摘要(div);
        KyufuJissekiPrmBusiness 給付実績情報照会情報 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        FlexibleYearMonth サービス提供年月 = ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class);
        List<KyufujissekiKihon> 給付実績基本情報 = getCsData_A();
        RString 整理番号 = get整理番号(給付実績基本情報);
        NyuryokuShikibetsuNo 識別番号検索キー = get識別番号(給付実績基本情報);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class)
                .getKojinKakuteiKey().get被保険者番号();
        getHandler(div).change年月(new RString("前月"), 給付実績情報照会情報, getCsData_J(), getCsData_D(),
                整理番号, 被保険者番号, 識別番号検索キー, サービス提供年月);
        FlexibleYearMonth 提供年月 = getHandler(div).get今提供年月(new RString("前月"), サービス提供年月, getCsData_J(), getCsData_D());
        set給付実績ヘッダ情報2(提供年月, 整理番号, 識別番号検索キー);
        List<KyufuJissekiHedajyoho2> 事業者番号リスト = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報,
                KyufuJissekiPrmBusiness.class).getCommonHeader().get給付実績ヘッダ情報2();
        getHandler(div).setJigyoshaBtn(事業者番号リスト);
        ViewStateHolder.put(ViewStateKeys.サービス提供年月, 提供年月);
        return createResponse(div);
    }

    /**
     * 次月ボタン押下
     *
     * @param div TokuteiShinryohiMainDiv
     * @return ResponseData<TokuteiShinryohiMainDiv>
     */
    public ResponseData<TokuteiShinryohiMainDiv> onClick_Jigetsu(TokuteiShinryohiMainDiv div) {
        this.close摘要(div);
        KyufuJissekiPrmBusiness 給付実績情報照会情報 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        FlexibleYearMonth サービス提供年月 = ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class);
        List<KyufujissekiKihon> 給付実績基本情報 = getCsData_A();
        RString 整理番号 = get整理番号(給付実績基本情報);
        NyuryokuShikibetsuNo 識別番号検索キー = get識別番号(給付実績基本情報);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class)
                .getKojinKakuteiKey().get被保険者番号();
        getHandler(div).change年月(new RString("次月"), 給付実績情報照会情報, getCsData_J(), getCsData_D(),
                整理番号, 被保険者番号, 識別番号検索キー, サービス提供年月);
        FlexibleYearMonth 提供年月 = getHandler(div).get今提供年月(new RString("次月"), サービス提供年月, getCsData_J(), getCsData_D());
        set給付実績ヘッダ情報2(提供年月, 整理番号, 識別番号検索キー);
        List<KyufuJissekiHedajyoho2> 事業者番号リスト = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報,
                KyufuJissekiPrmBusiness.class).getCommonHeader().get給付実績ヘッダ情報2();
        getHandler(div).setJigyoshaBtn(事業者番号リスト);
        ViewStateHolder.put(ViewStateKeys.サービス提供年月, 提供年月);
        return createResponse(div);
    }

    /**
     * 「前事業者」ボタン押下
     *
     * @param div TokuteiShinryohiMainDiv
     * @return ResponseData<TokuteiShinryohiMainDiv>
     */
    public ResponseData<TokuteiShinryohiMainDiv> onClick_MaeJigyosha(TokuteiShinryohiMainDiv div) {
        this.close摘要(div);
        KyufuJissekiPrmBusiness 給付実績情報照会情報 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        getHandler(div).change事業者(new RString("前事業者"), 給付実績情報照会情報, getCsData_J(), getCsData_D());
        return createResponse(div);
    }

    /**
     * 「後事業者」ボタン押下
     *
     * @param div TokuteiShinryohiMainDiv
     * @return ResponseData<TokuteiShinryohiMainDiv>
     */
    public ResponseData<TokuteiShinryohiMainDiv> onClick_AtoJigyosha(TokuteiShinryohiMainDiv div) {
        this.close摘要(div);
        KyufuJissekiPrmBusiness 給付実績情報照会情報 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        getHandler(div).change事業者(new RString("後事業者"), 給付実績情報照会情報, getCsData_J(), getCsData_D());
        return createResponse(div);
    }

    private void set給付実績ヘッダ情報2(FlexibleYearMonth サービス提供年月,
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
    }

    /**
     * 摘要項目ボタン押下
     *
     * @param div TokuteiShinryohiMainDiv
     * @return ResponseData
     */
    public ResponseData onClick_Tekiyo(TokuteiShinryohiMainDiv div) {
        RString サービス提供年月 = div.getCcdKyufuJissekiHeader().getサービス提供年月().getYearMonth().toDateString();
        getHandler(div).get摘要(new FlexibleYearMonth(サービス提供年月));
        div.getTekiyoPanelPanel().setIsOpen(true);
        return createResponse(div);
    }

    /**
     * 摘要パネル（TekiyoPanel）閉じる。
     *
     * @param div TokuteiShinryohiMainDiv
     * @return ResponseData
     */
    public ResponseData close_TekiyoPanelPanel(TokuteiShinryohiMainDiv div) {
        div.getTekiyoPanelPanel().setIsOpen(false);
        return createResponse(div);
    }

    private TokuteiShinryohiInfoPanelHandler getHandler(TokuteiShinryohiMainDiv div) {
        return new TokuteiShinryohiInfoPanelHandler(div);
    }

    private ResponseData<TokuteiShinryohiMainDiv> createResponse(TokuteiShinryohiMainDiv div) {
        return ResponseData.of(div).respond();
    }

    private void close摘要(TokuteiShinryohiMainDiv div) {
        if (div.getTekiyoPanelPanel().isIsOpen()) {
            div.getTekiyoPanelPanel().setIsOpen(false);
        }
    }

    private RString get整理番号(List<KyufujissekiKihon> 給付実績基本情報) {
        return 給付実績基本情報.get(INT_ZERO).get整理番号();
    }

    private NyuryokuShikibetsuNo get識別番号(List<KyufujissekiKihon> 給付実績基本情報) {
        return 給付実績基本情報.get(INT_ZERO).get入力識別番号();
    }

    /**
     * 基本情報ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnKihon(TokuteiShinryohiMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010015TransitionEventName.基本情報).respond();
    }

    /**
     * 明細集計ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnMeisaiShukei(TokuteiShinryohiMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010015TransitionEventName.明細_集計).respond();
    }

    /**
     * 緊急時施設療養費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnKinkyujiShisetsuRyoyo(TokuteiShinryohiMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010015TransitionEventName.緊急時施設療養費).respond();
    }

    /**
     * 食事費用ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnShokuji(TokuteiShinryohiMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010015TransitionEventName.食事費用).respond();
    }

    /**
     * 福祉用具購入費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnFukushiYoguKonyu(TokuteiShinryohiMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010015TransitionEventName.福祉用具購入費).respond();
    }

    /**
     * 特定入所者費用ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnTokuteiNyushosha(TokuteiShinryohiMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010015TransitionEventName.特定入所者費用).respond();
    }

    /**
     * 高額介護サービス費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnKogakuKaigoService(TokuteiShinryohiMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010015TransitionEventName.高額介護サービス費).respond();
    }

    /**
     * 所定疾患施設療養費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnTokuteiShinryo(TokuteiShinryohiMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010015TransitionEventName.所定疾患施設療養費).respond();
    }

    /**
     * 居宅サービス計画費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnKyotakuServiceKeikaku(TokuteiShinryohiMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010015TransitionEventName.居宅サービス計画費).respond();
    }

    /**
     * 住宅改修費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnJutakuKaishu(TokuteiShinryohiMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010015TransitionEventName.住宅改修費).respond();
    }

    /**
     * ケアマネジメント費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnCareManagement(TokuteiShinryohiMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010015TransitionEventName.ケアマネジメント費).respond();
    }

    /**
     * 社福軽減費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnShafukuKeigen(TokuteiShinryohiMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010015TransitionEventName.社福軽減費).respond();
    }

    /**
     * 給付実績一覧に戻るを押します。
     *
     * @param div 画面情報
     * @return ResponseData<TokuteiShinryohiMainDiv>
     */
    public ResponseData onClick_btnReturn(TokuteiShinryohiMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010015TransitionEventName.給付実績照会検索一覧).respond();
    }

    private List<KyufujissekiKihon> getCsData_A() {
        List<KyufuJissekiKihonShukeiRelate> entityList
                = ViewStateHolder.get(ViewStateKeys.給付実績基本情報, KyufujissekiKihonJyohou.class).getCsData_A();
        List<KyufujissekiKihon> 給付実績基本情報List = new ArrayList<>();
        for (KyufuJissekiKihonShukeiRelate entity : entityList) {
            給付実績基本情報List.add(entity.get給付実績基本データ());
        }
        return 給付実績基本情報List;
    }

    private List<KyufujissekiTokuteiSinryoTokubetsuRyoyo> getCsData_J() {
        return ViewStateHolder.get(ViewStateKeys.給付実績特定診療費_特別療養費,
                KyufujissekiTokuteiSinryoTokubetsuRyoyoJyohou.class).getCsData_J();
    }

    private List<KyufujissekiTokuteiSinryohi> getCsData_D() {
        return ViewStateHolder.get(ViewStateKeys.給付実績特定診療費情報,
                KyufujissekiTokuteiSinryohiJyohou.class).getCsData_D();
    }
}
