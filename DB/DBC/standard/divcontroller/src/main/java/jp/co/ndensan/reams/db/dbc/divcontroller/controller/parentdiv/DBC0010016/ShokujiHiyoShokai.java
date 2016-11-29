/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0010016;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiShokujiHiyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHeaderAll;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiParam;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiMeisaiBusiness;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010016.DBC0010016TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010016.ShokujiHiyoShokaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010016.ShokujiHiyoShokaiHandler;
import jp.co.ndensan.reams.db.dbc.service.core.kyufujissekishokai.KyufuJissekiShokaiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 給付実績照会_(DBC0010016)食事費用のcontrollerです
 *
 * @reamsid_L DBC-2970-080 zhaoran
 */
public class ShokujiHiyoShokai {

    /**
     * 画面の初期化です。
     *
     * @param div 画面情報
     * @return ResponseData<ShokujiHiyoShokaiDiv>
     */
    public ResponseData<ShokujiHiyoShokaiDiv> onLoad(ShokujiHiyoShokaiDiv div) {
        KyufuJissekiParam para = ViewStateHolder.get(ViewStateKeys.給付実績データパラメータ, KyufuJissekiParam.class);
        KyufuJissekiHeaderAll 給付実績基本情報 = ViewStateHolder.get(ViewStateKeys.給付実績基本情報データ, KyufuJissekiHeaderAll.class);
        div.getCcdKyufuJissekiHeader().set給付実績基本情報データ(給付実績基本情報);
        List<KyufujissekiShokujiHiyo> 給付実績食事費用List = KyufuJissekiShokaiFinder.createInstance().get給付実績食事費用データ(
                para.get入力識別番号(), para.get被保険者番号(), para.getサービス提供年月(), para.get事業所番号(), para.get通し番号());
        List<KyufujissekiMeisaiBusiness> 給付実績明細List = KyufuJissekiShokaiFinder.createInstance().get給付実績明細データ(
                para.get入力識別番号(), para.get被保険者番号(), para.getサービス提供年月(), para.get事業所番号(), para.get通し番号());
        getHandler(div).setDataGrid(給付実績食事費用List, 給付実績明細List, para.getサービス提供年月());
        ShikibetsuNoKanri 識別番号管理データ = ViewStateHolder.get(ViewStateKeys.識別番号管理, ShikibetsuNoKanri.class);
        getHandler(div).setButton(識別番号管理データ);
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
}
