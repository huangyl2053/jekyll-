/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0010013;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010013.DBC0010013TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010013.KinnkyuujiShisetsuRyouyouhiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010013.KinnkyuujiShisetsuRyouyouhiHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

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
//        KyufuJissekiPrm 引き継ぎ情報 = ViewStateHolder.get(ViewStateKeys.資格対象者, KyufuJissekiPrm.class);
//        getHandler(div).load共有子Div(引き継ぎ情報);
        getHandler(div).setDataGrid();
        //   List<Header2> header2 = ViewStateHolder.get(ViewStateKeys.資格対象者, KyufuJissekiPrm.class).getComHeader().getHeader2();
        //  if (!header2.isEmpty()) {
//            List<Header2> 提供年月リスト = ViewStateHolder.get(ViewStateKeys.資格対象者, KyufuJissekiPrm.class).getComHeader().getHeader2();
//            RString 整理番号 = div.getCcdKyufuJissekiHeader().getTxtSeiriNo().getValue();
//            RString 事業者 = div.getCcdKyufuJissekiHeader().getTxtJigyosha().getValue();
//            RDate サービス提供年月 = div.getCcdKyufuJissekiHeader().getTxtTeikyoNengetsu().getValue();
//            RString 样式番号 = div.getCcdKyufuJissekiHeader().getTxtYoshikiNo().getValue();
//            RString 実績区分 = div.getCcdKyufuJissekiHeader().getTxtJissekiKubun().getValue();
//            int index = getHandler(div).get提供年月index(提供年月リスト, サービス提供年月, 整理番号, 事業者, 样式番号, 実績区分);
//            if ((index - 1) < 0) {
//                div.getBtnZengetsu().setDisabled(true);
//                div.getBtnMaeJigyosha().setDisabled(true);
//            }
//            if (提供年月リスト.size() < (index + 1)) {
//                div.getBtnJigetsu().setDisabled(true);
//                div.getBtnAtoJigyosha().setDisabled(true);
//            }
//
//        }
        return createResponse(div);
    }

    /**
     * 「前月」ボタンを押下、画面遷移する。
     *
     * @param div KinnkyuujiShisetsuRyouyouhiDiv
     * @return 前月
     */
    public ResponseData<KinnkyuujiShisetsuRyouyouhiDiv> onClick_btnZengetsu(KinnkyuujiShisetsuRyouyouhiDiv div) {
        if (div.getKyufuJissekiTekiyoPanel().isIsOpen()) {
            getHandler(div).checkState();
        }

        getHandler(div).change年月(new RString("前月"));
        return createResponse(div);
    }

    /**
     * 「次月」ボタンを押下、画面遷移する。
     *
     * @param div KinnkyuujiShisetsuRyouyouhiDiv
     * @return 次月
     */
    public ResponseData<KinnkyuujiShisetsuRyouyouhiDiv> onClick_btnJigetsu(KinnkyuujiShisetsuRyouyouhiDiv div) {
        if (div.getKyufuJissekiTekiyoPanel().isIsOpen()) {
            getHandler(div).checkState();
        }
        getHandler(div).change年月(new RString("次月"));
        return createResponse(div);
    }

    /**
     * 「前事業者」ボタンを押下、画面遷移する。
     *
     * @param div KinnkyuujiShisetsuRyouyouhiDiv
     * @return 前事業者
     */
    public ResponseData<KinnkyuujiShisetsuRyouyouhiDiv> onClick_btnMaeJigyosha(KinnkyuujiShisetsuRyouyouhiDiv div) {
        if (div.getKyufuJissekiTekiyoPanel().isIsOpen()) {
            getHandler(div).checkState();
        }
        getHandler(div).change事業者(new RString("前事業者"));
        return createResponse(div);
    }

    /**
     * 「後事業者」ボタンを押下、画面遷移する。
     *
     * @param div KinnkyuujiShisetsuRyouyouhiDiv
     * @return 後事業者
     */
    public ResponseData<KinnkyuujiShisetsuRyouyouhiDiv> onClick_btnAtoJigyosha(KinnkyuujiShisetsuRyouyouhiDiv div) {
        if (div.getKyufuJissekiTekiyoPanel().isIsOpen()) {
            getHandler(div).checkState();
        }
        getHandler(div).change事業者(new RString("後事業者"));

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
        if (!div.getKyufuJissekiTekiyoPanel().isIsOpen()) {
            getHandler(div).changeState();
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
