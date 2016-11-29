/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0010013;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKinkyuShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHeaderAll;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiParam;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010013.DBC0010013TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010013.KinnkyuujiShisetsuRyouyouhiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010013.KinnkyuujiShisetsuRyouyouhiHandler;
import jp.co.ndensan.reams.db.dbc.service.core.kyufujissekishokai.KyufuJissekiShokaiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 緊急時施設療養費表示です。
 *
 * @reamsid_L DBC-2970-050 wangrenze
 */
public class KinnkyuujiShisetsuRyouyouhi {

    /**
     * 画面の初期化メソッドです。
     *
     * @param div KinnkyuujiShisetsuRyouyouhiDiv
     * @return 緊急時施設療養費表示画面
     */
    public ResponseData<KinnkyuujiShisetsuRyouyouhiDiv> onLoad(KinnkyuujiShisetsuRyouyouhiDiv div) {
        KyufuJissekiParam para = ViewStateHolder.get(ViewStateKeys.給付実績データパラメータ, KyufuJissekiParam.class);
        KyufuJissekiHeaderAll 給付実績基本情報 = ViewStateHolder.get(ViewStateKeys.給付実績基本情報データ, KyufuJissekiHeaderAll.class);
        div.getCcdKyufuJissekiHeader().set給付実績基本情報データ(給付実績基本情報);
        List<KyufujissekiKinkyuShisetsuRyoyo> 給付実績緊急時施設療養List = KyufuJissekiShokaiFinder.createInstance()
                .get給付実績緊急時施設療養データ(
                        para.get入力識別番号(), para.get被保険者番号(), para.getサービス提供年月(), para.get事業所番号(), para.get通し番号());
        getHandler(div).onLoad(給付実績緊急時施設療養List);
        ShikibetsuNoKanri 識別番号管理データ = ViewStateHolder.get(ViewStateKeys.識別番号管理, ShikibetsuNoKanri.class);
        getHandler(div).setButton(識別番号管理データ);
        div.getKyufuJissekiTekiyoPanel().setIsOpen(false);
        return createResponse(div);
    }

    /**
     * 「摘要」ボタンを押下、画面遷移する。
     *
     * @param div KinnkyuujiShisetsuRyouyouhiDiv
     * @return div
     */
    public ResponseData<KinnkyuujiShisetsuRyouyouhiDiv> onClick_btnTekiyo(KinnkyuujiShisetsuRyouyouhiDiv div) {
        div.getTxtTekiyo().setValue(getHandler(div).set摘要データ(div.getDgKinkyujiShisetsuRyoyohi().getActiveRow()));

        if (!div.getKyufuJissekiTekiyoPanel().isIsOpen()) {
            getHandler(div).changeState();
        }
        return createResponse(div);
    }

    /**
     * 「閉じる」ボタンを押下、画面遷移する。
     *
     * @param div KinnkyuujiShisetsuRyouyouhiDiv
     * @return div
     */
    public ResponseData<KinnkyuujiShisetsuRyouyouhiDiv> onClick_btnKyufuJissekiTekiyoClose(KinnkyuujiShisetsuRyouyouhiDiv div) {
        if (div.getKyufuJissekiTekiyoPanel().isIsOpen()) {
            getHandler(div).checkState();
        }

        return createResponse(div);
    }

    /**
     * 「基本情報」ボタンを押下、画面遷移する。
     *
     * @param div KinnkyuujiShisetsuRyouyouhiDiv
     * @return div
     */
    public ResponseData<KinnkyuujiShisetsuRyouyouhiDiv> onClick_btnKihon(KinnkyuujiShisetsuRyouyouhiDiv div) {

        return ResponseData.of(div).forwardWithEventName(DBC0010013TransitionEventName.基本情報).respond();
    }

    /**
     * 「明細_集計」ボタンを押下、画面遷移する。
     *
     * @param div KinnkyuujiShisetsuRyouyouhiDiv
     * @return div
     */
    public ResponseData<KinnkyuujiShisetsuRyouyouhiDiv> onClick_btnMeisaiShukei(KinnkyuujiShisetsuRyouyouhiDiv div) {

        return ResponseData.of(div).forwardWithEventName(DBC0010013TransitionEventName.明細_集計).respond();
    }

    /**
     * 「所定疾患施設療養費」ボタンを押下、画面遷移する。
     *
     * @param div KinnkyuujiShisetsuRyouyouhiDiv
     * @return div
     */
    public ResponseData<KinnkyuujiShisetsuRyouyouhiDiv> onClick_btnShoteiShikkanShisetsuRyoyo(KinnkyuujiShisetsuRyouyouhiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010013TransitionEventName.所定疾患施設療養費).respond();
    }

    /**
     * 「特定診療費」ボタンを押下、画面遷移する。
     *
     * @param div KinnkyuujiShisetsuRyouyouhiDiv
     * @return div
     */
    public ResponseData<KinnkyuujiShisetsuRyouyouhiDiv> onClick_btnTokuteiShinryo(KinnkyuujiShisetsuRyouyouhiDiv div) {

        return ResponseData.of(div).forwardWithEventName(DBC0010013TransitionEventName.特定診療費).respond();
    }

    /**
     * 「食事費用」ボタンを押下、画面遷移する。
     *
     * @param div KinnkyuujiShisetsuRyouyouhiDiv
     * @return div
     */
    public ResponseData<KinnkyuujiShisetsuRyouyouhiDiv> onClick_btnShokuji(KinnkyuujiShisetsuRyouyouhiDiv div) {

        return ResponseData.of(div).forwardWithEventName(DBC0010013TransitionEventName.食事費用).respond();
    }

    /**
     * 「居宅サービス計画費」ボタンを押下、画面遷移する。
     *
     * @param div KinnkyuujiShisetsuRyouyouhiDiv
     * @return div
     */
    public ResponseData<KinnkyuujiShisetsuRyouyouhiDiv> onClick_btnKyotakuServiceKeikaku(KinnkyuujiShisetsuRyouyouhiDiv div) {

        return ResponseData.of(div).forwardWithEventName(DBC0010013TransitionEventName.居宅サービス計画費).respond();
    }

    /**
     * 「福祉用具購入費」ボタンを押下、画面遷移する。
     *
     * @param div KinnkyuujiShisetsuRyouyouhiDiv
     * @return div
     */
    public ResponseData<KinnkyuujiShisetsuRyouyouhiDiv> onClick_btnFukushiYoguKonyu(KinnkyuujiShisetsuRyouyouhiDiv div) {

        return ResponseData.of(div).forwardWithEventName(DBC0010013TransitionEventName.福祉用具購入費).respond();
    }

    /**
     * 「住宅改修費」ボタンを押下、画面遷移する。
     *
     * @param div KinnkyuujiShisetsuRyouyouhiDiv
     * @return div
     */
    public ResponseData<KinnkyuujiShisetsuRyouyouhiDiv> onClick_btnJutakuKaishu(KinnkyuujiShisetsuRyouyouhiDiv div) {

        return ResponseData.of(div).forwardWithEventName(DBC0010013TransitionEventName.住宅改修費).respond();
    }

    /**
     * 「高額介護サービス費」ボタンを押下、画面遷移する。
     *
     * @param div KinnkyuujiShisetsuRyouyouhiDiv
     * @return div
     */
    public ResponseData<KinnkyuujiShisetsuRyouyouhiDiv> onClick_btnKogakuKaigoService(KinnkyuujiShisetsuRyouyouhiDiv div) {

        return ResponseData.of(div).forwardWithEventName(DBC0010013TransitionEventName.高額介護サービス費).respond();
    }

    /**
     * 「特定入所者費用」ボタンを押下、画面遷移する。
     *
     * @param div KinnkyuujiShisetsuRyouyouhiDiv
     * @return div
     */
    public ResponseData<KinnkyuujiShisetsuRyouyouhiDiv> onClick_btnTokuteiNyushosha(KinnkyuujiShisetsuRyouyouhiDiv div) {

        return ResponseData.of(div).forwardWithEventName(DBC0010013TransitionEventName.特定入所者費用).respond();
    }

    /**
     * 「ケアマネジメント費」ボタンを押下、画面遷移する。
     *
     * @param div KinnkyuujiShisetsuRyouyouhiDiv
     * @return div
     */
    public ResponseData<KinnkyuujiShisetsuRyouyouhiDiv> onClick_btnCareManagement(KinnkyuujiShisetsuRyouyouhiDiv div) {

        return ResponseData.of(div).forwardWithEventName(DBC0010013TransitionEventName.ケアマネジメント費).respond();
    }

    /**
     * 「社福軽減費」ボタンを押下、画面遷移する。
     *
     * @param div KinnkyuujiShisetsuRyouyouhiDiv
     * @return div
     */
    public ResponseData<KinnkyuujiShisetsuRyouyouhiDiv> onClick_btnShafukuKeigen(KinnkyuujiShisetsuRyouyouhiDiv div) {

        return ResponseData.of(div).forwardWithEventName(DBC0010013TransitionEventName.社福軽減費).respond();
    }

    private KinnkyuujiShisetsuRyouyouhiHandler getHandler(KinnkyuujiShisetsuRyouyouhiDiv div) {
        return new KinnkyuujiShisetsuRyouyouhiHandler(div);
    }

    private ResponseData<KinnkyuujiShisetsuRyouyouhiDiv> createResponse(KinnkyuujiShisetsuRyouyouhiDiv div) {
        return ResponseData.of(div).respond();
    }
}
