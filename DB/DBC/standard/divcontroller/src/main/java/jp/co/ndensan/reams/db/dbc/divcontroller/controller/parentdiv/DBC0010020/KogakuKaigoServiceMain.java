/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0010020;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKogakuKaigoServicehi;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiPrmBusiness;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010020.DBC0010020TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010020.KogakuKaigoServiceMainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010020.KogakuKaigoServiceHandler;
import jp.co.ndensan.reams.db.dbc.service.core.kyufujissekishokai.KyufuJissekiShokaiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 給付実績照会の高額介護サービス費のcontrollerです
 *
 * @reamsid_L DBC-2970-120 guoqilin
 */
public class KogakuKaigoServiceMain {

    /**
     * 画面初期化のメソッドです。
     *
     * @param div KogakuKaigoServiceMainDiv
     * @return ResponseData<KogakuKaigoServiceMainDiv>
     */
    public ResponseData<KogakuKaigoServiceMainDiv> onLoad(KogakuKaigoServiceMainDiv div) {
        KyufuJissekiPrmBusiness 給付実績情報照会情報 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        FlexibleYearMonth サービス提供年月 = ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class);
        NyuryokuShikibetsuNo 識別番号検索キー = ViewStateHolder.get(ViewStateKeys.識別番号検索キー, NyuryokuShikibetsuNo.class);
        div.getCcdKyufuJissekiHeader().initialize(
                給付実績情報照会情報.getKojinKakuteiKey().get被保険者番号(), サービス提供年月,
                ViewStateHolder.get(ViewStateKeys.整理番号, RString.class), 識別番号検索キー);
        List<ShikibetsuNoKanri> 識別番号管理データリスト = KyufuJissekiShokaiFinder.createInstance().getShikibetsuBangoKanri(
                サービス提供年月, 識別番号検索キー).records();
        if (!識別番号管理データリスト.isEmpty()) {
            getHandler(div).clear制御性(識別番号管理データリスト.get(0), サービス提供年月);
        }
        List<KyufujissekiKogakuKaigoServicehi> 高額介護サービス費 = 給付実績情報照会情報.getCsData_I();
        getHandler(div).set給付実績高額介護サービス費データ(高額介護サービス費, サービス提供年月);
        return createResponse(div);
    }

    /**
     * 前月ボタン押下
     *
     * @param div KogakuKaigoServiceMainDiv
     * @return ResponseData
     */
    public ResponseData<KogakuKaigoServiceMainDiv> onClick_Zengatsu(KogakuKaigoServiceMainDiv div) {
        KyufuJissekiPrmBusiness 給付実績情報照会情報 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        List<KyufujissekiKogakuKaigoServicehi> 高額介護サービス費 = 給付実績情報照会情報.getCsData_I();
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth(div.getCcdKyufuJissekiHeader().getサービス提供年月().getYearMonth().toDateString());
        NyuryokuShikibetsuNo 識別番号検索キー = ViewStateHolder.get(ViewStateKeys.識別番号検索キー, NyuryokuShikibetsuNo.class);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報,
                KyufuJissekiPrmBusiness.class).getKojinKakuteiKey().get被保険者番号();
        RString 整理番号 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
        getHandler(div).change年月(new RString("前月"), 高額介護サービス費,
                サービス提供年月, 整理番号,
                被保険者番号, 識別番号検索キー);
        return createResponse(div);
    }

    /**
     * 次月ボタン押下
     *
     * @param div KogakuKaigoServiceMainDiv
     * @return ResponseData
     */
    public ResponseData<KogakuKaigoServiceMainDiv> onClick_btnJigetsu(KogakuKaigoServiceMainDiv div) {
        KyufuJissekiPrmBusiness 給付実績情報照会情報 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        List<KyufujissekiKogakuKaigoServicehi> 高額介護サービス費 = 給付実績情報照会情報.getCsData_I();
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth(div.getCcdKyufuJissekiHeader().getサービス提供年月().getYearMonth().toDateString());
        NyuryokuShikibetsuNo 識別番号検索キー = ViewStateHolder.get(ViewStateKeys.識別番号検索キー, NyuryokuShikibetsuNo.class);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報,
                KyufuJissekiPrmBusiness.class).getKojinKakuteiKey().get被保険者番号();
        RString 整理番号 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
        getHandler(div).change年月(new RString("次月"), 高額介護サービス費, サービス提供年月, 整理番号, 被保険者番号, 識別番号検索キー);
        return createResponse(div);
    }

    /**
     * 基本情報ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnKihon(KogakuKaigoServiceMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010020TransitionEventName.基本情報).respond();
    }

    /**
     * 明細集計ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnMeisaiShukei(KogakuKaigoServiceMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010020TransitionEventName.明細_集計).respond();
    }

    /**
     * 緊急時施設療養費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnKinkyujiShisetsuRyoyo(KogakuKaigoServiceMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010020TransitionEventName.緊急時施設療養費).respond();
    }

    /**
     * 所定疾患施設療養費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnShoteiShikkanShisetsuRyoyo(KogakuKaigoServiceMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010020TransitionEventName.所定疾患施設療養費).respond();
    }

    /**
     * 食事費用ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnShokuji(KogakuKaigoServiceMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010020TransitionEventName.食事費用).respond();
    }

    /**
     * 福祉用具購入費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnFukushiYoguKonyu(KogakuKaigoServiceMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010020TransitionEventName.福祉用具購入費).respond();
    }

    /**
     * 特定入所者費用ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnTokuteiNyushosha(KogakuKaigoServiceMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010020TransitionEventName.特定入所者費用).respond();
    }

    /**
     * 特定診療費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnTokuteiShinryo(KogakuKaigoServiceMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010020TransitionEventName.特定診療費).respond();
    }

    /**
     * 居宅サービス計画費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnKyotakuServiceKeikaku(KogakuKaigoServiceMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010020TransitionEventName.居宅サービス計画費).respond();
    }

    /**
     * 住宅改修費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnJutakuKaishu(KogakuKaigoServiceMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010020TransitionEventName.住宅改修費).respond();
    }

    /**
     * ケアマネジメント費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnCareManagement(KogakuKaigoServiceMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010020TransitionEventName.ケアマネジメント費).respond();
    }

    /**
     * 社福軽減費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnShafukuKeigen(KogakuKaigoServiceMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010020TransitionEventName.社福軽減費).respond();
    }

    /**
     * 給付実績一覧に戻るを押します。
     *
     * @param div 画面情報
     * @return ResponseData<KogakuKaigoServiceMainDiv>
     */
    public ResponseData onClick_btnReturn(KogakuKaigoServiceMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010020TransitionEventName.給付実績照会検索一覧).respond();
    }

    private KogakuKaigoServiceHandler getHandler(KogakuKaigoServiceMainDiv div) {
        return new KogakuKaigoServiceHandler(div);
    }

    private ResponseData<KogakuKaigoServiceMainDiv> createResponse(KogakuKaigoServiceMainDiv div) {
        return ResponseData.of(div).respond();
    }
}
