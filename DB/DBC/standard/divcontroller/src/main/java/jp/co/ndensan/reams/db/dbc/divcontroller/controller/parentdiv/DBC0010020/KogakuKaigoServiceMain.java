/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0010020;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKogakuKaigoServicehi;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHeader;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiKogakuKaigoServicehiJyohou;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010020.DBC0010020TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010020.KogakuKaigoServiceMainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010020.KogakuKaigoServiceHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 給付実績照会の高額介護サービス費のcontrollerです
 *
 * @reamsid_L DBC-2970-120 guoqilin
 */
public class KogakuKaigoServiceMain {

    /**
     * 画面初期化のメソッドです。
     *
     * @param div KogakuKaigoServiceMainDiv
     * @return ResponseData<KogakuKaigoServiceMainDiv>
     */
    public ResponseData<KogakuKaigoServiceMainDiv> onLoad(KogakuKaigoServiceMainDiv div) {
        KyufuJissekiHeader 給付実績基本情報子Divデータ
                = ViewStateHolder.get(ViewStateKeys.給付実績基本情報子Div, KyufuJissekiHeader.class);
        div.getCcdKyufuJissekiHeader().set被保情報(給付実績基本情報子Divデータ);
        //KyufuJissekiPrmBusiness 給付実績情報照会情報 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        FlexibleYearMonth サービス提供年月 = ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class);
//        List<KyufujissekiKihon> 給付実績基本情報 = getCsData_A();
//        RString 整理番号 = get整理番号(給付実績基本情報);
//        NyuryokuShikibetsuNo 識別番号検索キー = get識別番号(給付実績基本情報);
//        div.getCcdKyufuJissekiHeader().initialize(
//                給付実績情報照会情報.getKojinKakuteiKey().get被保険者番号(), サービス提供年月,
//                整理番号, 識別番号検索キー);
//        set給付実績ヘッダ情報2(サービス提供年月, 整理番号, 識別番号検索キー);
//        List<ShikibetsuNoKanri> 識別番号管理データリスト = KyufuJissekiShokaiFinder.createInstance().getShikibetsuBangoKanri(
//                サービス提供年月, 識別番号検索キー).records();
//        if (!識別番号管理データリスト.isEmpty()) {
//            getHandler(div).clear制御性(識別番号管理データリスト.get(0));
//        }
        getHandler(div).set給付実績高額介護サービス費データ(get給付実績高額介護サービス費データ(サービス提供年月, div));
        前月次月ボタン(div);
        return createResponse(div);
    }

    /**
     * 前月ボタン押下
     *
     * @param div KogakuKaigoServiceMainDiv
     * @return ResponseData
     */
    public ResponseData<KogakuKaigoServiceMainDiv> onClick_Zengatsu(KogakuKaigoServiceMainDiv div) {
        int currentIndex = Integer.parseInt(div.getHiddenCurrentIndex().toString()) - 1;
        getHandler(div).set給付実績高額介護サービス費データ(get給付実績高額介護サービス費データ(div, currentIndex));
        前月次月ボタン(div);
        return createResponse(div);
    }

    private void 前月次月ボタン(KogakuKaigoServiceMainDiv div) {
        int currentIndex = Integer.parseInt(div.getHiddenCurrentIndex().toString());
        int totalIndex = Integer.parseInt(div.getHiddenTotalIndex().toString());
        div.getBtnZengetsu().setDisabled(currentIndex == 0);
        div.getBtnJigetsu().setDisabled(currentIndex == totalIndex);
    }

    /**
     * 次月ボタン押下
     *
     * @param div KogakuKaigoServiceMainDiv
     * @return ResponseData
     */
    public ResponseData<KogakuKaigoServiceMainDiv> onClick_btnJigetsu(KogakuKaigoServiceMainDiv div) {
        int currentIndex = Integer.parseInt(div.getHiddenCurrentIndex().toString()) + 1;
        getHandler(div).set給付実績高額介護サービス費データ(get給付実績高額介護サービス費データ(div, currentIndex));
        前月次月ボタン(div);
        return createResponse(div);
    }

    /**
     * 基本情報ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnKihon(KogakuKaigoServiceMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010020TransitionEventName.基本情報).respond();
    }

    /**
     * 明細集計ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnMeisaiShukei(KogakuKaigoServiceMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010020TransitionEventName.明細_集計).respond();
    }

    /**
     * 緊急時施設療養費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnKinkyujiShisetsuRyoyo(KogakuKaigoServiceMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010020TransitionEventName.緊急時施設療養費).respond();
    }

    /**
     * 所定疾患施設療養費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnShoteiShikkanShisetsuRyoyo(KogakuKaigoServiceMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010020TransitionEventName.所定疾患施設療養費).respond();
    }

    /**
     * 食事費用ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnShokuji(KogakuKaigoServiceMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010020TransitionEventName.食事費用).respond();
    }

    /**
     * 福祉用具購入費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnFukushiYoguKonyu(KogakuKaigoServiceMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010020TransitionEventName.福祉用具購入費).respond();
    }

    /**
     * 特定入所者費用ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnTokuteiNyushosha(KogakuKaigoServiceMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010020TransitionEventName.特定入所者費用).respond();
    }

    /**
     * 特定診療費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnTokuteiShinryo(KogakuKaigoServiceMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010020TransitionEventName.特定診療費).respond();
    }

    /**
     * 居宅サービス計画費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnKyotakuServiceKeikaku(KogakuKaigoServiceMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010020TransitionEventName.居宅サービス計画費).respond();
    }

    /**
     * 住宅改修費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnJutakuKaishu(KogakuKaigoServiceMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010020TransitionEventName.住宅改修費).respond();
    }

    /**
     * ケアマネジメント費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnCareManagement(KogakuKaigoServiceMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010020TransitionEventName.ケアマネジメント費).respond();
    }

    /**
     * 社福軽減費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnShafukuKeigen(KogakuKaigoServiceMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010020TransitionEventName.社福軽減費).respond();
    }

    /**
     * 給付実績一覧に戻るを押します。
     *
     * @param div 画面情報
     * @return ResponseData<KogakuKaigoServiceMainDiv>
     */
    public ResponseData onClick_btnReturn(KogakuKaigoServiceMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010020TransitionEventName.給付実績照会検索一覧).respond();
    }

    private KogakuKaigoServiceHandler getHandler(KogakuKaigoServiceMainDiv div) {
        return new KogakuKaigoServiceHandler(div);
    }

    private ResponseData<KogakuKaigoServiceMainDiv> createResponse(KogakuKaigoServiceMainDiv div) {
        return ResponseData.of(div).respond();
    }

    private KyufujissekiKogakuKaigoServicehi get給付実績高額介護サービス費データ(FlexibleYearMonth サービス提供年月, KogakuKaigoServiceMainDiv div) {
        List<KyufujissekiKogakuKaigoServicehi> csData_I
                = ViewStateHolder.get(ViewStateKeys.給付実績高額明細管理情報, KyufujissekiKogakuKaigoServicehiJyohou.class).getCsData_I();
        div.setHiddenTotalIndex(new RString(csData_I.size() - 1));
        int index = 0;
        for (KyufujissekiKogakuKaigoServicehi csData : csData_I) {
            if (サービス提供年月.equals(csData.getサービス提供年月())) {
                div.setHiddenCurrentIndex(new RString(index));
                return csData;
            }
            index++;
        }
        return null;
    }

    private KyufujissekiKogakuKaigoServicehi get給付実績高額介護サービス費データ(KogakuKaigoServiceMainDiv div, int currentIndex) {
        List<KyufujissekiKogakuKaigoServicehi> csData_I
                = ViewStateHolder.get(ViewStateKeys.給付実績高額明細管理情報, KyufujissekiKogakuKaigoServicehiJyohou.class).getCsData_I();
        div.setHiddenCurrentIndex(new RString(currentIndex));
        return csData_I.get(currentIndex);
    }
}
