/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0010013;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKinkyuShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHedajyoho2;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiPrmBusiness;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010013.DBC0010013TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010013.KinnkyuujiShisetsuRyouyouhiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010013.KinnkyuujiShisetsuRyouyouhiHandler;
import jp.co.ndensan.reams.db.dbc.service.core.kyufujissekishokai.KyufuJissekiShokaiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
        KyufuJissekiPrmBusiness 引き継ぎ情報 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        RString 整理番号 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
        FlexibleYearMonth サービス提供年月 = ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class);
        NyuryokuShikibetsuNo 識別番号 = ViewStateHolder.get(ViewStateKeys.識別番号検索キー, NyuryokuShikibetsuNo.class);
        getHandler(div).load共有子Div(引き継ぎ情報, 整理番号, サービス提供年月, 識別番号);
        List<ShikibetsuNoKanri> 識別番号管理 = KyufuJissekiShokaiFinder.createInstance().getShikibetsuBangoKanri(
                サービス提供年月, 識別番号).records();
        if (!識別番号管理.isEmpty()) {
            getHandler(div).setButton(サービス提供年月, 識別番号管理.get(0));
        }
        List<KyufujissekiKinkyuShisetsuRyoyo> 給付実績緊急時施設療養データ取得 = ViewStateHolder
                .get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class).getCsData_C();
        RString 事業者番号 = div.getCcdKyufuJissekiHeader().get事業者番号();
        RString 実績区分コード = div.getCcdKyufuJissekiHeader().get実績区分コード();
        List<KyufuJissekiHedajyoho2> 事業者番号リスト = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報,
                KyufuJissekiPrmBusiness.class).getCommonHeader().get給付実績ヘッダ情報2();
        getHandler(div).check事業者btn(事業者番号リスト, 整理番号, 事業者番号, 識別番号.value(), サービス提供年月.toDateString(), 実績区分コード);
        getHandler(div).setDataGrid(給付実績緊急時施設療養データ取得);
        div.getKyufuJissekiTekiyoPanel().setIsOpen(false);
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
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class).getKojinKakuteiKey().get被保険者番号();
        List<KyufujissekiKinkyuShisetsuRyoyo> 給付実績緊急時施設療養データ取得 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報,
                KyufuJissekiPrmBusiness.class).getCsData_C();
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth(div.getCcdKyufuJissekiHeader().getサービス提供年月()
                .getYearMonth().toDateString());
        RString 整理番号 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
        NyuryokuShikibetsuNo 識別番号検索キー = ViewStateHolder.get(ViewStateKeys.識別番号検索キー, NyuryokuShikibetsuNo.class);
        getHandler(div).change年月(new RString("前月"), 給付実績緊急時施設療養データ取得, サービス提供年月,
                整理番号, 被保険者番号, 識別番号検索キー);
        FlexibleYearMonth 提供年月 = new FlexibleYearMonth(div.getCcdKyufuJissekiHeader().getサービス提供年月().getYearMonth().toDateString());
        ViewStateHolder.put(ViewStateKeys.サービス提供年月, 提供年月);
        RString 事業者番号 = div.getCcdKyufuJissekiHeader().get事業者番号();
        RString 実績区分コード = div.getCcdKyufuJissekiHeader().get実績区分コード();
        List<KyufuJissekiHedajyoho2> 事業者番号リスト = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報,
                KyufuJissekiPrmBusiness.class).getCommonHeader().get給付実績ヘッダ情報2();
        getHandler(div).check事業者btn(事業者番号リスト, 整理番号, 事業者番号, 識別番号検索キー.value(),
                提供年月.toDateString(), 実績区分コード);
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
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class).getKojinKakuteiKey().get被保険者番号();
        List<KyufujissekiKinkyuShisetsuRyoyo> 給付実績緊急時施設療養データ取得 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報,
                KyufuJissekiPrmBusiness.class).getCsData_C();
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth(div.getCcdKyufuJissekiHeader().getサービス提供年月()
                .getYearMonth().toDateString());
        RString 整理番号 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
        NyuryokuShikibetsuNo 識別番号検索キー = ViewStateHolder.get(ViewStateKeys.識別番号検索キー, NyuryokuShikibetsuNo.class);
        getHandler(div).change年月(new RString("次月"), 給付実績緊急時施設療養データ取得, サービス提供年月,
                整理番号, 被保険者番号, 識別番号検索キー);
        FlexibleYearMonth 提供年月 = new FlexibleYearMonth(div.getCcdKyufuJissekiHeader().getサービス提供年月().getYearMonth().toDateString());
        ViewStateHolder.put(ViewStateKeys.サービス提供年月, 提供年月);
        RString 事業者番号 = div.getCcdKyufuJissekiHeader().get事業者番号();
        RString 実績区分コード = div.getCcdKyufuJissekiHeader().get実績区分コード();
        List<KyufuJissekiHedajyoho2> 事業者番号リスト = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報,
                KyufuJissekiPrmBusiness.class).getCommonHeader().get給付実績ヘッダ情報2();
        getHandler(div).check事業者btn(事業者番号リスト, 整理番号, 事業者番号, 識別番号検索キー.value(),
                提供年月.toDateString(), 実績区分コード);
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
        List<KyufuJissekiHedajyoho2> 事業者番号リスト = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報,
                KyufuJissekiPrmBusiness.class).getCommonHeader().get給付実績ヘッダ情報2();
        List<KyufujissekiKinkyuShisetsuRyoyo> 給付実績緊急時施設療養データ取得 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報,
                KyufuJissekiPrmBusiness.class).getCsData_C();
        getHandler(div).change事業者(new RString("前事業者"), 事業者番号リスト, 給付実績緊急時施設療養データ取得);
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
        List<KyufuJissekiHedajyoho2> 事業者番号リスト = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報,
                KyufuJissekiPrmBusiness.class).getCommonHeader().get給付実績ヘッダ情報2();
        List<KyufujissekiKinkyuShisetsuRyoyo> 給付実績緊急時施設療養データ取得 = ViewStateHolder
                .get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class).getCsData_C();
        getHandler(div).change事業者(new RString("後事業者"), 事業者番号リスト, 給付実績緊急時施設療養データ取得);

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
