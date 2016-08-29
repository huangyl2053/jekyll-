/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0010012;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHedajyoho2;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiPrmBusiness;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010012.KyufuJissekiSyokaiMeisaiSyukeiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010012.KyufuJissekiSyokaiMeisaiSyukeiHandler;
import jp.co.ndensan.reams.db.dbc.service.core.kyufujissekishokai.KyufuJissekiShokaiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 給付実績照会_明細集計画面処理クラスです。
 *
 * @reamsid_L DBC-2970-040 wangxiaodong
 */
public class KyufuJissekiSyokaiMeisaiSyukei {

    /**
     * 画面の初期化メソッドです。
     *
     * @param div KyufuJissekiSyokaiMeisaiSyukeiDiv
     * @return 給付実績照会_明細集計画面
     */
    public ResponseData<KyufuJissekiSyokaiMeisaiSyukeiDiv> onLoad(KyufuJissekiSyokaiMeisaiSyukeiDiv div) {

        KyufuJissekiPrmBusiness 引き継ぎ情報 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        RString 整理番号 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
        FlexibleYearMonth サービス提供年月 = ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class);
        NyuryokuShikibetsuNo 識別番号 = ViewStateHolder.get(ViewStateKeys.識別番号検索キー, NyuryokuShikibetsuNo.class);
        KyufuJissekiSyokaiMeisaiSyukeiHandler handler = getHandler(div);
        handler.load共有子Div(引き継ぎ情報.getKojinKakuteiKey().get被保険者番号(), 整理番号, サービス提供年月, 識別番号);
        ShikibetsuNoKanri 識別番号管理 = KyufuJissekiShokaiFinder.createInstance().getShikibetsuBangoKanri(
                サービス提供年月, 識別番号).records().get(0);
        handler.setButton(識別番号管理, サービス提供年月, 識別番号);
//        List<KyufujissekiMeisai> 給付実績明細情報 = 引き継ぎ情報.getCsData_B();
        RString 事業者番号 = div.getCcdKyufuJissekiHeader().get事業者番号();
        RString 様式番号 = div.getCcdKyufuJissekiHeader().get様式番号();
        RString 実績区分コード = div.getCcdKyufuJissekiHeader().get実績区分コード();
        RDate サービス提供 = div.getCcdKyufuJissekiHeader().getサービス提供年月();
        List<KyufuJissekiHedajyoho2> 事業者番号リスト = 引き継ぎ情報.getCommonHeader().get給付実績ヘッダ情報2();
        handler.check事業者btn(事業者番号リスト, 整理番号, 事業者番号, 様式番号, サービス提供.toDateString(), 実績区分コード);
//        List<KyufujissekiKinkyuShisetsuRyoyo> 緊急時施設療養データ = handler.get給付実績データ(給付実績明細情報,
//                整理番号, 事業者番号, 様式番号, サービス提供.getYearMonth().toDateString());
//        handler.setDataGrid(緊急時施設療養データ);

        return ResponseData.of(div).respond();
    }

    /**
     * 「前月」ボタンをクリックします。
     *
     * @param div KyufuJissekiSyokaiMeisaiSyukeiDiv
     * @return 給付実績照会_明細集計画面
     */
    public ResponseData<KyufuJissekiSyokaiMeisaiSyukeiDiv> onClick_btnZengetsu(KyufuJissekiSyokaiMeisaiSyukeiDiv div) {

        return ResponseData.of(div).respond();
    }

    /**
     * 「次月」ボタンをクリックします。
     *
     * @param div KyufuJissekiSyokaiMeisaiSyukeiDiv
     * @return 給付実績照会_明細集計画面
     */
    public ResponseData<KyufuJissekiSyokaiMeisaiSyukeiDiv> onClick_btnJigetsu(KyufuJissekiSyokaiMeisaiSyukeiDiv div) {

        return ResponseData.of(div).respond();
    }

    /**
     * 「前事業者」ボタンをクリックします。
     *
     * @param div KyufuJissekiSyokaiMeisaiSyukeiDiv
     * @return 給付実績照会_明細集計画面
     */
    public ResponseData<KyufuJissekiSyokaiMeisaiSyukeiDiv> onClick_btnMaeJigyosha(KyufuJissekiSyokaiMeisaiSyukeiDiv div) {

        return ResponseData.of(div).respond();
    }

    /**
     * 「次事業者」ボタンをクリックします。
     *
     * @param div KyufuJissekiSyokaiMeisaiSyukeiDiv
     * @return 給付実績照会_明細集計画面
     */
    public ResponseData<KyufuJissekiSyokaiMeisaiSyukeiDiv> onClick_btnAtoJigyosha(KyufuJissekiSyokaiMeisaiSyukeiDiv div) {

        return ResponseData.of(div).respond();
    }

    private KyufuJissekiSyokaiMeisaiSyukeiHandler getHandler(KyufuJissekiSyokaiMeisaiSyukeiDiv div) {
        return new KyufuJissekiSyokaiMeisaiSyukeiHandler(div);
    }

//    /**
//     * 「基本情報」ボタンをクリックします。
//     *
//     * @param div KyufuJissekiSyokaiMeisaiSyukeiDiv
//     * @return 基本情報画面画面
//     */
//    public ResponseData<KyufuJissekiSyokaiMeisaiSyukeiDiv> onClick_btnKihon(KyufuJissekiSyokaiMeisaiSyukeiDiv div) {
//
//        return ResponseData.of(div).forwardWithEventName(DBC0010012TransitionEventName.基本情報).respond();
//    }
//
//    /**
//     * 「緊急時施設療養費」ボタンをクリックします。
//     *
//     * @param div KyufuJissekiSyokaiMeisaiSyukeiDiv
//     * @return 緊急時施設療養費画面
//     */
//    public ResponseData<KyufuJissekiSyokaiMeisaiSyukeiDiv> onClick_btnKinkyujiShisetsuRyoyo(KyufuJissekiSyokaiMeisaiSyukeiDiv div) {
//
//        return ResponseData.of(div).forwardWithEventName(DBC0010012TransitionEventName.緊急時施設療養費).respond();
//    }
//
//    /**
//     * 「所定疾患施設療養費」ボタンをクリックします。
//     *
//     * @param div KyufuJissekiSyokaiMeisaiSyukeiDiv
//     * @return 所定疾患施設療養費画面
//     */
//    public ResponseData<KyufuJissekiSyokaiMeisaiSyukeiDiv> onClick_btnShoteiShikkanShisetsuRyoyo(KyufuJissekiSyokaiMeisaiSyukeiDiv div) {
//
//        return ResponseData.of(div).forwardWithEventName(DBC0010012TransitionEventName.所定疾患施設療養費).respond();
//    }
//
//    /**
//     * 「食事費用」ボタンをクリックします。
//     *
//     * @param div KyufuJissekiSyokaiMeisaiSyukeiDiv
//     * @return 食事費用画面
//     */
//    public ResponseData<KyufuJissekiSyokaiMeisaiSyukeiDiv> onClick_btnShokuji(KyufuJissekiSyokaiMeisaiSyukeiDiv div) {
//
//        return ResponseData.of(div).forwardWithEventName(DBC0010012TransitionEventName.食事費用).respond();
//    }
//
//    /**
//     * 「福祉用具購入費」ボタンをクリックします。
//     *
//     * @param div KyufuJissekiSyokaiMeisaiSyukeiDiv
//     * @return 福祉用具購入費画面
//     */
//    public ResponseData<KyufuJissekiSyokaiMeisaiSyukeiDiv> onClick_btnFukushiYoguKonyu(KyufuJissekiSyokaiMeisaiSyukeiDiv div) {
//
//        return ResponseData.of(div).forwardWithEventName(DBC0010012TransitionEventName.福祉用具購入費).respond();
//    }
//
//    /**
//     * 「特定入所者費用」ボタンをクリックします。
//     *
//     * @param div KyufuJissekiSyokaiMeisaiSyukeiDiv
//     * @return 特定入所者費用画面
//     */
//    public ResponseData<KyufuJissekiSyokaiMeisaiSyukeiDiv> onClick_btnTokuteiNyushosha(KyufuJissekiSyokaiMeisaiSyukeiDiv div) {
//
//        return ResponseData.of(div).forwardWithEventName(DBC0010012TransitionEventName.特定入所者費用).respond();
//    }
//
//    /**
//     * 「高額介護サービス費」ボタンをクリックします。
//     *
//     * @param div KyufuJissekiSyokaiMeisaiSyukeiDiv
//     * @return 高額介護サービス費画面
//     */
//    public ResponseData<KyufuJissekiSyokaiMeisaiSyukeiDiv> onClick_btnKogakuKaigoService(KyufuJissekiSyokaiMeisaiSyukeiDiv div) {
//
//        return ResponseData.of(div).forwardWithEventName(DBC0010012TransitionEventName.高額介護サービス費).respond();
//    }
//
//    /**
//     * 「特定診療費」ボタンをクリックします。
//     *
//     * @param div KyufuJissekiSyokaiMeisaiSyukeiDiv
//     * @return 特定診療費画面
//     */
//    public ResponseData<KyufuJissekiSyokaiMeisaiSyukeiDiv> onClick_btnTokuteiShinryo(KyufuJissekiSyokaiMeisaiSyukeiDiv div) {
//
//        return ResponseData.of(div).forwardWithEventName(DBC0010012TransitionEventName.特定診療費).respond();
//    }
//
//    /**
//     * 「居宅サービス計画費」ボタンをクリックします。
//     *
//     * @param div KyufuJissekiSyokaiMeisaiSyukeiDiv
//     * @return 居宅サービス計画費画面
//     */
//    public ResponseData<KyufuJissekiSyokaiMeisaiSyukeiDiv> onClick_btnKyotakuServiceKeikaku(KyufuJissekiSyokaiMeisaiSyukeiDiv div) {
//
//        return ResponseData.of(div).forwardWithEventName(DBC0010012TransitionEventName.居宅サービス計画費).respond();
//    }
//
//    /**
//     * 「住宅改修費」ボタンをクリックします。
//     *
//     * @param div KyufuJissekiSyokaiMeisaiSyukeiDiv
//     * @return 住宅改修費画面
//     */
//    public ResponseData<KyufuJissekiSyokaiMeisaiSyukeiDiv> onClick_btnJutakuKaishu(KyufuJissekiSyokaiMeisaiSyukeiDiv div) {
//
//        return ResponseData.of(div).forwardWithEventName(DBC0010012TransitionEventName.住宅改修費).respond();
//    }
//
//    /**
//     * 「ケアマネジメント費」ボタンをクリックします。
//     *
//     * @param div KyufuJissekiSyokaiMeisaiSyukeiDiv
//     * @return ケアマネジメント費画面
//     */
//    public ResponseData<KyufuJissekiSyokaiMeisaiSyukeiDiv> onClick_btnCareManagement(KyufuJissekiSyokaiMeisaiSyukeiDiv div) {
//
//        return ResponseData.of(div).forwardWithEventName(DBC0010012TransitionEventName.ケアマネジメント費).respond();
//    }
//
//    /**
//     * 「社福軽減費」ボタンをクリックします。
//     *
//     * @param div KyufuJissekiSyokaiMeisaiSyukeiDiv
//     * @return 社福軽減費画面
//     */
//    public ResponseData<KyufuJissekiSyokaiMeisaiSyukeiDiv> onClick_btnShafukuKeigen(KyufuJissekiSyokaiMeisaiSyukeiDiv div) {
//
//        return ResponseData.of(div).forwardWithEventName(DBC0010012TransitionEventName.社福軽減費).respond();
//    }
}
