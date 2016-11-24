/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0010015;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiTokuteiSinryoTokubetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiTokuteiSinryohi;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHeaderAll;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiParam;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010015.DBC0010015TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010015.TokuteiShinryohiMainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010015.TokuteiShinryohiInfoPanelHandler;
import jp.co.ndensan.reams.db.dbc.service.core.kyufujissekishokai.KyufuJissekiShokaiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 給付実績照会_(DBC0010015)特定診療費のcontrollerです
 *
 * @reamsid_L DBC-2970-070 guoqilin
 */
public class TokuteiShinryohiMain {

    /**
     * 画面初期化のメソッドです。
     *
     * @param div TokuteiShinryohiMainDiv
     * @return ResponseData<TokuteiShinryohiMainDiv>
     */
    public ResponseData<TokuteiShinryohiMainDiv> onLoad(TokuteiShinryohiMainDiv div) {
        KyufuJissekiParam para = ViewStateHolder.get(ViewStateKeys.給付実績データパラメータ, KyufuJissekiParam.class);
        KyufuJissekiHeaderAll 給付実績基本情報 = ViewStateHolder.get(ViewStateKeys.給付実績基本情報データ, KyufuJissekiHeaderAll.class);
        div.getCcdKyufuJissekiHeader().set給付実績基本情報データ(給付実績基本情報);
        List<KyufujissekiTokuteiSinryohi> 給付実績特定診療費データList = KyufuJissekiShokaiFinder.createInstance().get給付実績特定診療費データ(
                para.get入力識別番号(), para.get被保険者番号(), para.getサービス提供年月(), para.get事業所番号(), para.get通し番号());
        List<KyufujissekiTokuteiSinryoTokubetsuRyoyo> 給付実績特定診療費_特別療養費List = KyufuJissekiShokaiFinder.createInstance()
                .get給付実績特定診療費_特別療養費データ(
                        para.get入力識別番号(), para.get被保険者番号(), para.getサービス提供年月(), para.get事業所番号(), para.get通し番号());
        getHandler(div).onLoad(給付実績特定診療費_特別療養費List, 給付実績特定診療費データList, para.getサービス提供年月());
        ShikibetsuNoKanri 識別番号管理データ = ViewStateHolder.get(ViewStateKeys.識別番号管理, ShikibetsuNoKanri.class);
        getHandler(div).clear制御性(識別番号管理データ);
        div.getTekiyoPanelPanel().setIsOpen(false);
        return createResponse(div);
    }

    /**
     * 摘要項目ボタン押下
     *
     * @param div TokuteiShinryohiMainDiv
     * @return ResponseData
     */
    public ResponseData onClick_Tekiyo(TokuteiShinryohiMainDiv div) {
        RString サービス提供年月 = div.getCcdKyufuJissekiHeader().getサービス提供年月().getYearMonth().toDateString();
        getHandler(div).get摘要(new FlexibleYearMonth(サービス提供年月));
        div.getTekiyoPanelPanel().setIsOpen(true);
        return createResponse(div);
    }

    /**
     * 摘要パネル（TekiyoPanel）閉じる。
     *
     * @param div TokuteiShinryohiMainDiv
     * @return ResponseData
     */
    public ResponseData close_TekiyoPanelPanel(TokuteiShinryohiMainDiv div) {
        div.getTekiyoPanelPanel().setIsOpen(false);
        return createResponse(div);
    }

    private TokuteiShinryohiInfoPanelHandler getHandler(TokuteiShinryohiMainDiv div) {
        return new TokuteiShinryohiInfoPanelHandler(div);
    }

    private ResponseData<TokuteiShinryohiMainDiv> createResponse(TokuteiShinryohiMainDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 基本情報ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnKihon(TokuteiShinryohiMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010015TransitionEventName.基本情報).respond();
    }

    /**
     * 明細集計ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnMeisaiShukei(TokuteiShinryohiMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010015TransitionEventName.明細_集計).respond();
    }

    /**
     * 緊急時施設療養費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnKinkyujiShisetsuRyoyo(TokuteiShinryohiMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010015TransitionEventName.緊急時施設療養費).respond();
    }

    /**
     * 食事費用ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnShokuji(TokuteiShinryohiMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010015TransitionEventName.食事費用).respond();
    }

    /**
     * 福祉用具購入費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnFukushiYoguKonyu(TokuteiShinryohiMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010015TransitionEventName.福祉用具購入費).respond();
    }

    /**
     * 特定入所者費用ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnTokuteiNyushosha(TokuteiShinryohiMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010015TransitionEventName.特定入所者費用).respond();
    }

    /**
     * 高額介護サービス費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnKogakuKaigoService(TokuteiShinryohiMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010015TransitionEventName.高額介護サービス費).respond();
    }

    /**
     * 所定疾患施設療養費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnTokuteiShinryo(TokuteiShinryohiMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010015TransitionEventName.所定疾患施設療養費).respond();
    }

    /**
     * 居宅サービス計画費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnKyotakuServiceKeikaku(TokuteiShinryohiMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010015TransitionEventName.居宅サービス計画費).respond();
    }

    /**
     * 住宅改修費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnJutakuKaishu(TokuteiShinryohiMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010015TransitionEventName.住宅改修費).respond();
    }

    /**
     * ケアマネジメント費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnCareManagement(TokuteiShinryohiMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010015TransitionEventName.ケアマネジメント費).respond();
    }

    /**
     * 社福軽減費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnShafukuKeigen(TokuteiShinryohiMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010015TransitionEventName.社福軽減費).respond();
    }

    /**
     * 給付実績一覧に戻るを押します。
     *
     * @param div 画面情報
     * @return ResponseData<TokuteiShinryohiMainDiv>
     */
    public ResponseData onClick_btnReturn(TokuteiShinryohiMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010015TransitionEventName.給付実績照会検索一覧).respond();
    }
}
