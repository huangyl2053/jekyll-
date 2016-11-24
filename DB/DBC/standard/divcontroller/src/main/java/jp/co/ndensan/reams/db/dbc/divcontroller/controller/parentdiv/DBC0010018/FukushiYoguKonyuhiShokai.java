/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0010018;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHeader;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHeaderAll;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiParam;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiFukushiYoguHanbaihiBusiness;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010018.DBC0010018TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010018.FukushiYoguKonyuhiShokaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010018.FukushiYoguKonyuhiShokaiHandler;
import jp.co.ndensan.reams.db.dbc.service.core.kyufujissekishokai.KyufuJissekiShokaiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 給付実績の福祉用具購入費を照会の画面処理クラスです。
 *
 * @reamsid_L DBC-2970-100 zhaoyao
 */
public class FukushiYoguKonyuhiShokai {

    /**
     * 画面の初期化です。
     *
     * @param div 画面情報
     * @return ResponseData<FukushiYoguKonyuhiShokaiDiv>
     */
    public ResponseData<FukushiYoguKonyuhiShokaiDiv> onLoad(FukushiYoguKonyuhiShokaiDiv div) {
        KyufuJissekiHeader 給付実績基本情報子Divデータ
                = ViewStateHolder.get(ViewStateKeys.給付実績基本情報子Div, KyufuJissekiHeader.class);
        div.getCcdKyufuJissekiHeader().set被保情報(給付実績基本情報子Divデータ);
        FlexibleYearMonth サービス提供年月 = ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class);
        KyufuJissekiParam para = ViewStateHolder.get(ViewStateKeys.給付実績データパラメータ, KyufuJissekiParam.class);
        KyufuJissekiHeaderAll 給付実績基本情報 = ViewStateHolder.get(ViewStateKeys.給付実績基本情報データ, KyufuJissekiHeaderAll.class);
        div.getCcdKyufuJissekiHeader().set給付実績基本情報データ(給付実績基本情報);
        List<KyufujissekiFukushiYoguHanbaihiBusiness> 給付実績福祉用具情報 = KyufuJissekiShokaiFinder.createInstance()
                .get給付実績福祉用具販売費データ(para.get入力識別番号(), para.get被保険者番号(), サービス提供年月, para.get事業所番号(), para.get通し番号());
        getHandler(div).onLoad(給付実績福祉用具情報);
        List<ShikibetsuNoKanri> 識別番号管理データリスト = KyufuJissekiShokaiFinder.createInstance().getShikibetsuBangoKanri(
                サービス提供年月, para.get入力識別番号()).records();
        if (!識別番号管理データリスト.isEmpty()) {
            getHandler(div).setButton(識別番号管理データリスト.get(0));
        }
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
}
