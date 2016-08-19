/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0010014;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010014.DBC0010014TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010014.KinkyujiShisetsuRyoyohiShokaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010014.dgKinkyujiShisetsuRyoyohi_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

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
//        KojinKakuteiKey 資格対象者情報 = ViewStateHolder.get(ViewStateKeys.資格対象者, KojinKakuteiKey.class);
//
//        HihokenshaNo 被保険者番号 = 資格対象者情報.get被保険者番号().value();
//        div.getCcdKyufuJissekiHeader().initialize(
//                    ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class),
//                    ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class),
//                    ViewStateHolder.get(ViewStateKeys.整理番号, RString.class),
//                    ViewStateHolder.get(ViewStateKeys.識別コード, NyuryokuShikibetsuNo.class));
//        KyufuJissekiPrm KyufuJissekiPrm = ViewStateHolder.get(
//                "給付実績情報照会Entity", KyufuJissekiPrm.class);
//        List<KyufujissekiShoteiShikkanShisetsuRyoyo> 所定疾患施設療養費等データ = KyufuJissekiPrm.get所定疾患施設療養費等データ();
//        getHandler(div).setKinkyujiShisetsuRyoyohi(get所定疾患施設療養費等データ());
//        getHandler(div).setButton(ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class),)
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
        dgKinkyujiShisetsuRyoyohi_Row row = div.getDgKinkyujiShisetsuRyoyohi().getActiveRow();
        div.getKyufuJissekiTekiyoPanel().getTxtTekiyo().setValue(row.getTxtTekiyo());
        return ResponseData.of(div).respond();
    }

    /**
     * 前事業者ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<KinkyujiShisetsuRyoyohiShokaiDiv>
     */
    public ResponseData<KinkyujiShisetsuRyoyohiShokaiDiv> onClick_btnMaeJigyosha(KinkyujiShisetsuRyoyohiShokaiDiv div) {
//        KyufuJissekiPrm KyufuJissekiPrm = ViewStateHolder.get(
//                "給付実績情報照会Entity", KyufuJissekiPrm.class);
//        List<KyufujissekiShoteiShikkanShisetsuRyoyo> 所定疾患施設療養費等データ = KyufuJissekiPrm.get所定疾患施設療養費等データ();
//        getHandler(div).to前事業者(所定疾患施設療養費等データ);
        return ResponseData.of(div).respond();
    }

    /**
     * 後事業者ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<KinkyujiShisetsuRyoyohiShokaiDiv>
     */
    public ResponseData<KinkyujiShisetsuRyoyohiShokaiDiv> onClick_btnAtoJigyosha(KinkyujiShisetsuRyoyohiShokaiDiv div) {
//        KyufuJissekiPrm KyufuJissekiPrm = ViewStateHolder.get(
//                "給付実績情報照会Entity", KyufuJissekiPrm.class);
//        List<KyufujissekiShoteiShikkanShisetsuRyoyo> 所定疾患施設療養費等データ = KyufuJissekiPrm.get所定疾患施設療養費等データ();
//        getHandler(div).to後事業者(所定疾患施設療養費等データ);
        return ResponseData.of(div).respond();
    }

    /**
     * 前月ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<KinkyujiShisetsuRyoyohiShokaiDiv>
     */
    public ResponseData<KinkyujiShisetsuRyoyohiShokaiDiv> onClick_btnZengetsu(KinkyujiShisetsuRyoyohiShokaiDiv div) {
//        KyufuJissekiPrm KyufuJissekiPrm = ViewStateHolder.get(
//                "給付実績情報照会Entity", KyufuJissekiPrm.class);
//        List<KyufujissekiShoteiShikkanShisetsuRyoyo> 所定疾患施設療養費等データ = KyufuJissekiPrm.get所定疾患施設療養費等データ();
//        getHandler(div).to前月(所定疾患施設療養費等データ);
        return ResponseData.of(div).respond();
    }

    /**
     * 次月ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<KinkyujiShisetsuRyoyohiShokaiDiv>
     */
    public ResponseData<KinkyujiShisetsuRyoyohiShokaiDiv> onClick_btnJigetsu(KinkyujiShisetsuRyoyohiShokaiDiv div) {
//        KyufuJissekiPrm KyufuJissekiPrm = ViewStateHolder.get(
//                "給付実績情報照会Entity", KyufuJissekiPrm.class);
//        List<KyufujissekiShoteiShikkanShisetsuRyoyo> 所定疾患施設療養費等データ = KyufuJissekiPrm.get所定疾患施設療養費等データ();
//        getHandler(div).to次月(所定疾患施設療養費等データ);
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
        return ResponseData.of(div).forwardWithEventName(DBC0010014TransitionEventName.明細集計).respond();
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
}
