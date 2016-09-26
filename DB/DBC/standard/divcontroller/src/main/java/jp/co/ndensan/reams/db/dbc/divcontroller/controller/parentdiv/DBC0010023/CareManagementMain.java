/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0010023;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKihon;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiCareManagementHiBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHedajyoho2;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiPrmBusiness;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010023.CareManagementMainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010023.DBC0010023TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010023.CareManagementHandler;
import jp.co.ndensan.reams.db.dbc.service.core.kyufujissekishokai.KyufuJissekiShokaiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 給付実績照会のケアマネジメント費のcontrollerです
 *
 * @reamsid_L DBC-2970-150 guoqilin
 */
public class CareManagementMain {

    private static final int INT_ZERO = 0;

    /**
     * 画面初期化のメソッドです。
     *
     * @param div CareManagementMainDiv
     * @return ResponseData<CareManagementMainDiv>
     */
    public ResponseData<CareManagementMainDiv> onLoad(CareManagementMainDiv div) {
        KyufuJissekiPrmBusiness 給付実績情報照会情報 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        FlexibleYearMonth サービス提供年月 = ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class);
        List<KyufujissekiKihon> 給付実績基本情報 = 給付実績情報照会情報.getCsData_A();
        RString 整理番号 = get整理番号(給付実績基本情報);
        NyuryokuShikibetsuNo 識別番号検索キー = get識別番号(給付実績基本情報);
        div.getCcdKyufuJissekiHeader().initialize(
                給付実績情報照会情報.getKojinKakuteiKey().get被保険者番号(), サービス提供年月,
                整理番号, 識別番号検索キー);
        List<ShikibetsuNoKanri> 識別番号管理データリスト = KyufuJissekiShokaiFinder.createInstance().getShikibetsuBangoKanri(
                サービス提供年月, 識別番号検索キー).records();
        if (!識別番号管理データリスト.isEmpty()) {
            getHandler(div).clear制御性(識別番号管理データリスト.get(0), サービス提供年月);
        }
        List<KyufuJissekiCareManagementHiBusiness> ケアマネジメント費 = 給付実績情報照会情報.getCsData_M();
        List<KyufuJissekiHedajyoho2> 事業者番号リスト = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報,
                KyufuJissekiPrmBusiness.class).getCommonHeader().get給付実績ヘッダ情報2();
        getHandler(div).set給付実績ケアマネジメント費データ(ケアマネジメント費, サービス提供年月, 事業者番号リスト);
        return createResponse(div);
    }

    /**
     * 前月ボタン押下のメソッドです。
     *
     * @param div CareManagementMainDiv
     * @return ResponseData
     */
    public ResponseData<CareManagementMainDiv> onClick_btnZengetsu(CareManagementMainDiv div) {
        KyufuJissekiPrmBusiness 給付実績情報照会情報 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        List<KyufuJissekiCareManagementHiBusiness> ケアマネジメント費 = 給付実績情報照会情報.getCsData_M();
        List<KyufuJissekiHedajyoho2> 事業者番号リスト = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報,
                KyufuJissekiPrmBusiness.class).getCommonHeader().get給付実績ヘッダ情報2();
        getHandler(div).change年月(new RString("前月"), ケアマネジメント費, 事業者番号リスト);
        FlexibleYearMonth 提供年月 = new FlexibleYearMonth(div.getCcdKyufuJissekiHeader().getサービス提供年月().getYearMonth().toDateString());
        ViewStateHolder.put(ViewStateKeys.サービス提供年月, 提供年月);
        return createResponse(div);
    }

    /**
     * 次月ボタン押下のメソッドです。
     *
     * @param div CareManagementMainDiv
     * @return ResponseData
     */
    public ResponseData<CareManagementMainDiv> onClick_btnJigetsu(CareManagementMainDiv div) {
        KyufuJissekiPrmBusiness 給付実績情報照会情報 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        List<KyufuJissekiCareManagementHiBusiness> ケアマネジメント費 = 給付実績情報照会情報.getCsData_M();
        List<KyufuJissekiHedajyoho2> 事業者番号リスト = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報,
                KyufuJissekiPrmBusiness.class).getCommonHeader().get給付実績ヘッダ情報2();
        getHandler(div).change年月(new RString("次月"), ケアマネジメント費, 事業者番号リスト);
        FlexibleYearMonth 提供年月 = new FlexibleYearMonth(div.getCcdKyufuJissekiHeader().getサービス提供年月().getYearMonth().toDateString());
        ViewStateHolder.put(ViewStateKeys.サービス提供年月, 提供年月);
        return createResponse(div);
    }

    /**
     * 「前事業者」ボタン押下のメソッドです。
     *
     * @param div CareManagementMainDiv
     * @return ResponseData<CareManagementMainDiv>
     */
    public ResponseData<CareManagementMainDiv> onClick_MaeJigyosha(CareManagementMainDiv div) {
        KyufuJissekiPrmBusiness 給付実績情報照会情報 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        List<KyufuJissekiCareManagementHiBusiness> ケアマネジメント費 = 給付実績情報照会情報.getCsData_M();
        List<KyufuJissekiHedajyoho2> 事業者番号リスト = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報,
                KyufuJissekiPrmBusiness.class).getCommonHeader().get給付実績ヘッダ情報2();
        getHandler(div).change事業者(new RString("前事業者"), 事業者番号リスト, ケアマネジメント費);
        return createResponse(div);
    }

    /**
     * 「後事業者」ボタン押下のメソッドです。
     *
     * @param div CareManagementMainDiv
     * @return ResponseData<CareManagementMainDiv>
     */
    public ResponseData<CareManagementMainDiv> onClick_AtoJigyosha(CareManagementMainDiv div) {
        KyufuJissekiPrmBusiness 給付実績情報照会情報 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        List<KyufuJissekiCareManagementHiBusiness> ケアマネジメント費 = 給付実績情報照会情報.getCsData_M();
        List<KyufuJissekiHedajyoho2> 事業者番号リスト = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報,
                KyufuJissekiPrmBusiness.class).getCommonHeader().get給付実績ヘッダ情報2();
        getHandler(div).change事業者(new RString("後事業者"), 事業者番号リスト, ケアマネジメント費);
        return createResponse(div);
    }

    /**
     * 基本情報ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnKihon(CareManagementMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010023TransitionEventName.基本情報).respond();
    }

    /**
     * 明細集計ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnMeisaiShukei(CareManagementMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010023TransitionEventName.明細_集計).respond();
    }

    /**
     * 緊急時施設療養費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnKinkyujiShisetsuRyoyo(CareManagementMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010023TransitionEventName.緊急時施設療養費).respond();
    }

    /**
     * 所定疾患施設療養費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnShoteiShikkanShisetsuRyoyo(CareManagementMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010023TransitionEventName.所定疾患施設療養費).respond();
    }

    /**
     * 食事費用ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnShokuji(CareManagementMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010023TransitionEventName.食事費用).respond();
    }

    /**
     * 福祉用具購入費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnFukushiYoguKonyu(CareManagementMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010023TransitionEventName.福祉用具購入費).respond();
    }

    /**
     * 特定入所者費用ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnTokuteiNyushosha(CareManagementMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010023TransitionEventName.特定入所者費用).respond();
    }

    /**
     * 高額介護サービス費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnKogakuKaigoService(CareManagementMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010023TransitionEventName.高額介護サービス費).respond();
    }

    /**
     * 特定診療費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnTokuteiShinryo(CareManagementMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010023TransitionEventName.特定診療費).respond();
    }

    /**
     * 居宅サービス計画費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnKyotakuServiceKeikaku(CareManagementMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010023TransitionEventName.居宅サービス計画費).respond();
    }

    /**
     * 住宅改修費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnJutakuKaishu(CareManagementMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010023TransitionEventName.住宅改修費).respond();
    }

    /**
     * 社福軽減費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnShafukuKeigen(CareManagementMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010023TransitionEventName.社福軽減費).respond();
    }

    /**
     * 給付実績一覧に戻るを押します。
     *
     * @param div 画面情報
     * @return ResponseData<CareManagementMainDiv>
     */
    public ResponseData onClick_btnReturn(CareManagementMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010023TransitionEventName.給付実績照会検索一覧).respond();
    }

    private RString get整理番号(List<KyufujissekiKihon> 給付実績基本情報) {
        return 給付実績基本情報.get(INT_ZERO).get整理番号();
    }

    private NyuryokuShikibetsuNo get識別番号(List<KyufujissekiKihon> 給付実績基本情報) {
        return 給付実績基本情報.get(INT_ZERO).get入力識別番号();
    }

    private CareManagementHandler getHandler(CareManagementMainDiv div) {
        return new CareManagementHandler(div);
    }

    private ResponseData<CareManagementMainDiv> createResponse(CareManagementMainDiv div) {
        return ResponseData.of(div).respond();
    }
}
