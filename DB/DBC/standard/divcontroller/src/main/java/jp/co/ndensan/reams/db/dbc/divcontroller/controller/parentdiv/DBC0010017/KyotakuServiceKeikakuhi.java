/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0010017;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHedajyoho2;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiPrmBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiKyotakuServiceBusiness;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010017.DBC0010017TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010017.KyotakuServiceKeikakuhiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010017.KyotakuServiceKeikakuhiHandler;
import jp.co.ndensan.reams.db.dbc.service.core.kyufujissekishokai.KyufuJissekiShokaiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 居宅サービス計画費表示です。
 *
 * @reamsid_L DBC-2970-090 wangrenze
 */
public class KyotakuServiceKeikakuhi {

    /**
     * 画面の初期化メソッドです。
     *
     * @param div KyotakuServiceKeikakuhiDiv
     * @return 居宅サービス計画費表示画面
     */
    public ResponseData<KyotakuServiceKeikakuhiDiv> onLoad(KyotakuServiceKeikakuhiDiv div) {
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
        List<KyufujissekiKyotakuServiceBusiness> 給付実績居宅サービス計画費list = 引き継ぎ情報.getCsData_F();
        RString 事業者番号 = div.getCcdKyufuJissekiHeader().get事業者番号();
        RString 様式番号 = div.getCcdKyufuJissekiHeader().get様式番号();
        RString 実績区分コード = div.getCcdKyufuJissekiHeader().get実績区分コード();
        RDate サービス提供 = div.getCcdKyufuJissekiHeader().getサービス提供年月();
        List<KyufuJissekiHedajyoho2> 事業者番号リスト = 引き継ぎ情報.getCommonHeader().get給付実績ヘッダ情報2();
        getHandler(div).check事業者btn(事業者番号リスト, 整理番号, 事業者番号, 様式番号, サービス提供.toDateString(), 実績区分コード);
        List<KyufujissekiKyotakuServiceBusiness> 居宅サービス計画費データ = getHandler(div).get給付実績データ(給付実績居宅サービス計画費list,
                整理番号, 事業者番号, 様式番号, サービス提供.getYearMonth().toDateString());
        getHandler(div).setDataGrid(居宅サービス計画費データ, サービス提供年月);
        return createResponse(div);
    }

    /**
     * 「前月」ボタンを押下、画面遷移する。
     *
     * @param div KyotakuServiceKeikakuhiDiv
     * @return 前月
     */
    public ResponseData<KyotakuServiceKeikakuhiDiv> onClick_btnZengetsu(KyotakuServiceKeikakuhiDiv div) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class).getKojinKakuteiKey().get被保険者番号();
        List<KyufujissekiKyotakuServiceBusiness> 給付実績居宅サービス計画費list = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報,
                KyufuJissekiPrmBusiness.class).getCsData_F();
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth(div.getCcdKyufuJissekiHeader().getサービス提供年月().getYearMonth().toDateString());
        RString 整理番号 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
        NyuryokuShikibetsuNo 識別番号検索キー = ViewStateHolder.get(ViewStateKeys.識別番号検索キー, NyuryokuShikibetsuNo.class);
        getHandler(div).change年月(new RString("前月"), 給付実績居宅サービス計画費list, サービス提供年月,
                整理番号, 被保険者番号, 識別番号検索キー);
        return createResponse(div);
    }

    /**
     * 「次月」ボタンを押下、画面遷移する。
     *
     * @param div KyotakuServiceKeikakuhiDiv
     * @return 次月
     */
    public ResponseData<KyotakuServiceKeikakuhiDiv> onClick_btnJigetsu(KyotakuServiceKeikakuhiDiv div) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class).getKojinKakuteiKey().get被保険者番号();
        List<KyufujissekiKyotakuServiceBusiness> 給付実績居宅サービス計画費list = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報,
                KyufuJissekiPrmBusiness.class).getCsData_F();
        RString 整理番号 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
        NyuryokuShikibetsuNo 識別番号検索キー = ViewStateHolder.get(ViewStateKeys.識別番号検索キー, NyuryokuShikibetsuNo.class);
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth(div.getCcdKyufuJissekiHeader().getサービス提供年月().getYearMonth().toDateString());
        getHandler(div).change年月(new RString("次月"), 給付実績居宅サービス計画費list, サービス提供年月, 整理番号,
                被保険者番号, 識別番号検索キー);
        return createResponse(div);
    }

    /**
     * 「前事業者」ボタンを押下、画面遷移する。
     *
     * @param div KyotakuServiceKeikakuhiDiv
     * @return 前事業者
     */
    public ResponseData<KyotakuServiceKeikakuhiDiv> onClick_btnMaeJigyosha(KyotakuServiceKeikakuhiDiv div) {
        List<KyufuJissekiHedajyoho2> 事業者番号リスト = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報,
                KyufuJissekiPrmBusiness.class).getCommonHeader().get給付実績ヘッダ情報2();
        List<KyufujissekiKyotakuServiceBusiness> 給付実績居宅サービス計画費list = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報,
                KyufuJissekiPrmBusiness.class).getCsData_F();
        getHandler(div).change事業者(new RString("前事業者"), 事業者番号リスト, 給付実績居宅サービス計画費list);
        return createResponse(div);
    }

    /**
     * 「後事業者」ボタンを押下、画面遷移する。
     *
     * @param div KyotakuServiceKeikakuhiDiv
     * @return 後事業者
     */
    public ResponseData<KyotakuServiceKeikakuhiDiv> onClick_btnAtoJigyosha(KyotakuServiceKeikakuhiDiv div) {
        List<KyufuJissekiHedajyoho2> 事業者番号リスト = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報,
                KyufuJissekiPrmBusiness.class).getCommonHeader().get給付実績ヘッダ情報2();
        List<KyufujissekiKyotakuServiceBusiness> 給付実績居宅サービス計画費list = ViewStateHolder
                .get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class).getCsData_F();
        getHandler(div).change事業者(new RString("後事業者"), 事業者番号リスト, 給付実績居宅サービス計画費list);

        return createResponse(div);
    }

    /**
     * 「基本情報」ボタンを押下、画面遷移する。
     *
     * @param div KyotakuServiceKeikakuhiDiv
     * @return div
     */
    public ResponseData<KyotakuServiceKeikakuhiDiv> onClick_btnKihon(KyotakuServiceKeikakuhiDiv div) {

        return ResponseData.of(div).forwardWithEventName(DBC0010017TransitionEventName.基本情報).respond();
    }

    /**
     * 「明細_集計」ボタンを押下、画面遷移する。
     *
     * @param div KyotakuServiceKeikakuhiDiv
     * @return div
     */
    public ResponseData<KyotakuServiceKeikakuhiDiv> onClick_btnMeisaiShukei(KyotakuServiceKeikakuhiDiv div) {

        return ResponseData.of(div).forwardWithEventName(DBC0010017TransitionEventName.明細_集計).respond();
    }

    /**
     * 「所定疾患施設療養費」ボタンを押下、画面遷移する。
     *
     * @param div KyotakuServiceKeikakuhiDiv
     * @return div
     */
    public ResponseData<KyotakuServiceKeikakuhiDiv> onClick_btnShoteiShikkanShisetsuRyoyo(KyotakuServiceKeikakuhiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010017TransitionEventName.所定疾患施設療養費).respond();
    }

    /**
     * 「特定診療費」ボタンを押下、画面遷移する。
     *
     * @param div KyotakuServiceKeikakuhiDiv
     * @return div
     */
    public ResponseData<KyotakuServiceKeikakuhiDiv> onClick_btnTokuteiShinryo(KyotakuServiceKeikakuhiDiv div) {

        return ResponseData.of(div).forwardWithEventName(DBC0010017TransitionEventName.特定診療費).respond();
    }

    /**
     * 「食事費用」ボタンを押下、画面遷移する。
     *
     * @param div KyotakuServiceKeikakuhiDiv
     * @return div
     */
    public ResponseData<KyotakuServiceKeikakuhiDiv> onClick_btnShokuji(KyotakuServiceKeikakuhiDiv div) {

        return ResponseData.of(div).forwardWithEventName(DBC0010017TransitionEventName.食事費用).respond();
    }

    /**
     * 「緊急時施設療養費」ボタンを押下、画面遷移する。
     *
     * @param div KyotakuServiceKeikakuhiDiv
     * @return div
     */
    public ResponseData<KyotakuServiceKeikakuhiDiv> onClick_btnKinkyujiShisetsuRyoyo(KyotakuServiceKeikakuhiDiv div) {

        return ResponseData.of(div).forwardWithEventName(DBC0010017TransitionEventName.緊急時施設療養費).respond();
    }

    /**
     * 「福祉用具購入費」ボタンを押下、画面遷移する。
     *
     * @param div KyotakuServiceKeikakuhiDiv
     * @return div
     */
    public ResponseData<KyotakuServiceKeikakuhiDiv> onClick_btnFukushiYoguKonyu(KyotakuServiceKeikakuhiDiv div) {

        return ResponseData.of(div).forwardWithEventName(DBC0010017TransitionEventName.福祉用具購入費).respond();
    }

    /**
     * 「住宅改修費」ボタンを押下、画面遷移する。
     *
     * @param div KyotakuServiceKeikakuhiDiv
     * @return div
     */
    public ResponseData<KyotakuServiceKeikakuhiDiv> onClick_btnJutakuKaishu(KyotakuServiceKeikakuhiDiv div) {

        return ResponseData.of(div).forwardWithEventName(DBC0010017TransitionEventName.住宅改修費).respond();
    }

    /**
     * 「高額介護サービス費」ボタンを押下、画面遷移する。
     *
     * @param div KyotakuServiceKeikakuhiDiv
     * @return div
     */
    public ResponseData<KyotakuServiceKeikakuhiDiv> onClick_btnKogakuKaigoService(KyotakuServiceKeikakuhiDiv div) {

        return ResponseData.of(div).forwardWithEventName(DBC0010017TransitionEventName.高額介護サービス費).respond();
    }

    /**
     * 「特定入所者費用」ボタンを押下、画面遷移する。
     *
     * @param div KyotakuServiceKeikakuhiDiv
     * @return div
     */
    public ResponseData<KyotakuServiceKeikakuhiDiv> onClick_btnTokuteiNyushosha(KyotakuServiceKeikakuhiDiv div) {

        return ResponseData.of(div).forwardWithEventName(DBC0010017TransitionEventName.特定入所者費用).respond();
    }

    /**
     * 「ケアマネジメント費」ボタンを押下、画面遷移する。
     *
     * @param div KyotakuServiceKeikakuhiDiv
     * @return div
     */
    public ResponseData<KyotakuServiceKeikakuhiDiv> onClick_btnCareManagement(KyotakuServiceKeikakuhiDiv div) {

        return ResponseData.of(div).forwardWithEventName(DBC0010017TransitionEventName.ケアマネジメント費).respond();
    }

    /**
     * 「社福軽減費」ボタンを押下、画面遷移する。
     *
     * @param div KyotakuServiceKeikakuhiDiv
     * @return div
     */
    public ResponseData<KyotakuServiceKeikakuhiDiv> onClick_btnShafukuKeigen(KyotakuServiceKeikakuhiDiv div) {

        return ResponseData.of(div).forwardWithEventName(DBC0010017TransitionEventName.社福軽減費).respond();
    }

    private KyotakuServiceKeikakuhiHandler getHandler(KyotakuServiceKeikakuhiDiv div) {
        return new KyotakuServiceKeikakuhiHandler(div);
    }

    private ResponseData<KyotakuServiceKeikakuhiDiv> createResponse(KyotakuServiceKeikakuhiDiv div) {
        return ResponseData.of(div).respond();
    }

}
