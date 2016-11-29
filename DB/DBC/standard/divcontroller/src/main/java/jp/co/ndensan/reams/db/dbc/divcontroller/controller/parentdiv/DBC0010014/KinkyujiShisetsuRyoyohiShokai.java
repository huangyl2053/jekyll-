/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0010014;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiShoteiShikkanShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHeaderAll;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiParam;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010014.DBC0010014TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010014.KinkyujiShisetsuRyoyohiShokaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010014.KinkyujiShisetsuRyoyohiShokaiHandler;
import jp.co.ndensan.reams.db.dbc.service.core.kyufujissekishokai.KyufuJissekiShokaiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 給付実績の所定疾患施設療養費を照会の画面処理クラスです。
 *
 * @reamsid_L DBC-2970-060 zhaoyao
 */
public class KinkyujiShisetsuRyoyohiShokai {

    /**
     * 画面の初期化です。
     *
     * @param div 画面情報
     * @return ResponseData<KinkyujiShisetsuRyoyohiShokaiDiv>
     */
    public ResponseData<KinkyujiShisetsuRyoyohiShokaiDiv> onLoad(KinkyujiShisetsuRyoyohiShokaiDiv div) {
        KyufuJissekiParam para = ViewStateHolder.get(ViewStateKeys.給付実績データパラメータ, KyufuJissekiParam.class);
        KyufuJissekiHeaderAll 給付実績基本情報 = ViewStateHolder.get(ViewStateKeys.給付実績基本情報データ, KyufuJissekiHeaderAll.class);
        div.getCcdKyufuJissekiHeader().set給付実績基本情報データ(給付実績基本情報);
        List<KyufujissekiShoteiShikkanShisetsuRyoyo> 給付実績緊急時施設療養データ取得List = KyufuJissekiShokaiFinder.createInstance()
                .ge給付実績所定疾患施設療養費等データ(
                        para.get入力識別番号(), para.get被保険者番号(), para.getサービス提供年月(), para.get事業所番号(), para.get通し番号());
        getHandler(div).setKinkyujiShisetsuRyoyohi(給付実績緊急時施設療養データ取得List);
        ShikibetsuNoKanri 識別番号管理データ = ViewStateHolder.get(ViewStateKeys.識別番号管理, ShikibetsuNoKanri.class);
        getHandler(div).setButton(識別番号管理データ);
        div.getKyufuJissekiTekiyoPanel().setIsOpen(false);
        return ResponseData.of(div).respond();
    }

    /**
     * 摘要の設定です。
     *
     * @param div 画面情報
     * @return ResponseData<KinkyujiShisetsuRyoyohiShokaiDiv>
     */
    public ResponseData<KinkyujiShisetsuRyoyohiShokaiDiv> onClick_btnTekiyo(KinkyujiShisetsuRyoyohiShokaiDiv div) {
        div.getKyufuJissekiTekiyoPanel().setIsOpen(true);
        RString txtTeikiyo = div.getDgKinkyujiShisetsuRyoyohi().getActiveRow().getTxtTekiyo();
        div.getKyufuJissekiTekiyoPanel().getTxtTekiyo().setValue(txtTeikiyo);
        return ResponseData.of(div).respond();
    }

    /**
     * 閉じるボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<KinkyujiShisetsuRyoyohiShokaiDiv>
     */
    public ResponseData<KinkyujiShisetsuRyoyohiShokaiDiv> onClick_btnKyufuJissekiTekiyoClose(KinkyujiShisetsuRyoyohiShokaiDiv div) {
        div.getKyufuJissekiTekiyoPanel().setIsOpen(false);
        return ResponseData.of(div).respond();
    }

    /**
     * 基本情報ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnKihon(KinkyujiShisetsuRyoyohiShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010014TransitionEventName.基本情報).respond();
    }

    /**
     * 明細集計ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnMeisaiShukei(KinkyujiShisetsuRyoyohiShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010014TransitionEventName.明細_集計).respond();
    }

    /**
     * 緊急時施設療養費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnKinkyujiShisetsuRyoyo(KinkyujiShisetsuRyoyohiShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010014TransitionEventName.緊急時施設療養費).respond();
    }

    /**
     * 食事費用ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnShokuji(KinkyujiShisetsuRyoyohiShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010014TransitionEventName.食事費用).respond();
    }

    /**
     * 福祉用具購入費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnFukushiYoguKonyu(KinkyujiShisetsuRyoyohiShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010014TransitionEventName.福祉用具購入費).respond();
    }

    /**
     * 特定入所者費用ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnTokuteiNyushosha(KinkyujiShisetsuRyoyohiShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010014TransitionEventName.特定入所者費用).respond();
    }

    /**
     * 高額介護サービス費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnKogakuKaigoService(KinkyujiShisetsuRyoyohiShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010014TransitionEventName.高額介護サービス費).respond();
    }

    /**
     * 特定診療費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnTokuteiShinryo(KinkyujiShisetsuRyoyohiShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010014TransitionEventName.特定診療費).respond();
    }

    /**
     * 居宅サービス計画費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnKyotakuServiceKeikaku(KinkyujiShisetsuRyoyohiShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010014TransitionEventName.居宅サービス計画費).respond();
    }

    /**
     * 住宅改修費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnJutakuKaishu(KinkyujiShisetsuRyoyohiShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010014TransitionEventName.住宅改修費).respond();
    }

    /**
     * ケアマネジメント費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnCareManagement(KinkyujiShisetsuRyoyohiShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010014TransitionEventName.ケアマネジメント費).respond();
    }

    /**
     * 社福軽減費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnShafukuKeigen(KinkyujiShisetsuRyoyohiShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010014TransitionEventName.社福軽減費).respond();
    }

    /**
     * 給付実績一覧に戻るを押します。
     *
     * @param div 画面情報
     * @return ResponseData<KinkyujiShisetsuRyoyohiShokaiDiv>
     */
    public ResponseData onClick_btnReturn(KinkyujiShisetsuRyoyohiShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010014TransitionEventName.給付実績照会検索一覧).respond();
    }

    private KinkyujiShisetsuRyoyohiShokaiHandler getHandler(KinkyujiShisetsuRyoyohiShokaiDiv div) {
        return new KinkyujiShisetsuRyoyohiShokaiHandler(div);
    }
}
