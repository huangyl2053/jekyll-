/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0010022;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHeaderAll;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiParam;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiShakaiFukushiHojinKeigengakuBusiness;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010022.DBC0010022TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010022.ShakaiFukushiHojinKeigengakuShokaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010022.ShakaiFukushiHojinKeigengakuShokaiHandler;
import jp.co.ndensan.reams.db.dbc.service.core.kyufujissekishokai.KyufuJissekiShokaiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 給付実績の社会福祉法人軽減額を照会の画面処理クラスです。
 *
 * @reamsid_L DBC-2970-140 zhaoyao
 */
public class ShakaiFukushiHojinKeigengakuShokai {

    /**
     * 画面の初期化です。
     *
     * @param div 画面情報
     * @return ResponseData<ShakaiFukushiHojinKeigengakuShokaiDiv>
     */
    public ResponseData<ShakaiFukushiHojinKeigengakuShokaiDiv> onLoad(ShakaiFukushiHojinKeigengakuShokaiDiv div) {
        KyufuJissekiHeaderAll 子Div給付実績基本情報
                = ViewStateHolder.get(ViewStateKeys.給付実績基本情報データ, KyufuJissekiHeaderAll.class);
        div.getCcdKyufuJissekiHeader().set給付実績基本情報データ(子Div給付実績基本情報);
        KyufuJissekiParam para = ViewStateHolder.get(ViewStateKeys.給付実績データパラメータ, KyufuJissekiParam.class);
        FlexibleYearMonth サービス提供年月 = ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class);
        List<KyufuJissekiShakaiFukushiHojinKeigengakuBusiness> 給付実績社会福祉法人軽減額データ
                = KyufuJissekiShokaiFinder.createInstance().get給付実績社会福祉法人軽減額データ(
                        para.get入力識別番号(), para.get被保険者番号(), サービス提供年月, para.get事業所番号(), para.get通し番号());
        ShikibetsuNoKanri 識別番号管理データ = ViewStateHolder.get(ViewStateKeys.識別番号管理, ShikibetsuNoKanri.class);
        getHandler(div).setButton(識別番号管理データ);
        getHandler(div).onLoad(給付実績社会福祉法人軽減額データ);
        return ResponseData.of(div).respond();
    }

    /**
     * 基本情報ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnKihon(ShakaiFukushiHojinKeigengakuShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010022TransitionEventName.基本情報).respond();
    }

    /**
     * 明細集計ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnMeisaiShukei(ShakaiFukushiHojinKeigengakuShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010022TransitionEventName.明細_集計).respond();
    }

    /**
     * 緊急時施設療養費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnKinkyujiShisetsuRyoyo(ShakaiFukushiHojinKeigengakuShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010022TransitionEventName.緊急時施設療養費).respond();
    }

    /**
     * 所定疾患施設療養費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnShoteiShikkanShisetsuRyoyo(ShakaiFukushiHojinKeigengakuShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010022TransitionEventName.所定疾患施設療養費).respond();
    }

    /**
     * 特定診療費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnTokuteiShinryo(ShakaiFukushiHojinKeigengakuShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010022TransitionEventName.特定診療費).respond();
    }

    /**
     * 食事費用ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnShokuji(ShakaiFukushiHojinKeigengakuShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010022TransitionEventName.食事費用).respond();
    }

    /**
     * 居宅サービス計画費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnKyotakuServiceKeikaku(ShakaiFukushiHojinKeigengakuShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010022TransitionEventName.居宅サービス計画費).respond();
    }

    /**
     * 福祉用具購入費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnFukushiYoguKonyu(ShakaiFukushiHojinKeigengakuShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010022TransitionEventName.福祉用具購入費).respond();
    }

    /**
     * 住宅改修費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnJutakuKaishu(ShakaiFukushiHojinKeigengakuShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010022TransitionEventName.住宅改修費).respond();
    }

    /**
     * 高額介護サービス費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnKogakuKaigoService(ShakaiFukushiHojinKeigengakuShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010022TransitionEventName.高額介護サービス費).respond();
    }

    /**
     * 特定入所者費用ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnTokuteiNyushosha(ShakaiFukushiHojinKeigengakuShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010022TransitionEventName.特定入所者費用).respond();
    }

    /**
     * ケアマネジメント費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnCareManagement(ShakaiFukushiHojinKeigengakuShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010022TransitionEventName.ケアマネジメント費).respond();
    }

    /**
     * 給付実績一覧に戻るを押します。
     *
     * @param div 画面情報
     * @return ResponseData<ShakaiFukushiHojinKeigengakuShokaiDiv>
     */
    public ResponseData onClick_btnReturn(ShakaiFukushiHojinKeigengakuShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010022TransitionEventName.給付実績照会検索一覧).respond();
    }

    private ShakaiFukushiHojinKeigengakuShokaiHandler getHandler(ShakaiFukushiHojinKeigengakuShokaiDiv div) {
        return new ShakaiFukushiHojinKeigengakuShokaiHandler(div);
    }
}
