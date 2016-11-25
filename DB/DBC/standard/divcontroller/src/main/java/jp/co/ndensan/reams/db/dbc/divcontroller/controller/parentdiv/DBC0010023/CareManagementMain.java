/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0010023;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiCareManagementHiBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHeaderAll;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiParam;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010023.CareManagementMainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010023.DBC0010023TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010023.CareManagementHandler;
import jp.co.ndensan.reams.db.dbc.service.core.kyufujissekishokai.KyufuJissekiShokaiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 給付実績照会のケアマネジメント費のcontrollerです
 *
 * @reamsid_L DBC-2970-150 guoqilin
 */
public class CareManagementMain {

    /**
     * 画面初期化のメソッドです。
     *
     * @param div CareManagementMainDiv
     * @return ResponseData<CareManagementMainDiv>
     */
    public ResponseData<CareManagementMainDiv> onLoad(CareManagementMainDiv div) {
        KyufuJissekiHeaderAll 子Div給付実績基本情報
                = ViewStateHolder.get(ViewStateKeys.給付実績基本情報データ, KyufuJissekiHeaderAll.class);
        div.getCcdKyufuJissekiHeader().set給付実績基本情報データ(子Div給付実績基本情報);
        KyufuJissekiParam para = ViewStateHolder.get(ViewStateKeys.給付実績データパラメータ, KyufuJissekiParam.class);
        FlexibleYearMonth サービス提供年月 = ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class);
        List<KyufuJissekiCareManagementHiBusiness> 給付実績ケアマネジメント費データ
                = KyufuJissekiShokaiFinder.createInstance().get給付実績ケアマネジメント費データ(
                        para.get入力識別番号(), para.get被保険者番号(), サービス提供年月, para.get事業所番号(), para.get通し番号());
        ShikibetsuNoKanri 識別番号管理データ = ViewStateHolder.get(ViewStateKeys.識別番号管理, ShikibetsuNoKanri.class);
        getHandler(div).set給付実績ケアマネジメント費データ(給付実績ケアマネジメント費データ, 識別番号管理データ);
        return createResponse(div);
    }

    /**
     * 基本情報ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnKihon(CareManagementMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010023TransitionEventName.基本情報).respond();
    }

    /**
     * 明細集計ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnMeisaiShukei(CareManagementMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010023TransitionEventName.明細_集計).respond();
    }

    /**
     * 緊急時施設療養費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnKinkyujiShisetsuRyoyo(CareManagementMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010023TransitionEventName.緊急時施設療養費).respond();
    }

    /**
     * 所定疾患施設療養費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnShoteiShikkanShisetsuRyoyo(CareManagementMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010023TransitionEventName.所定疾患施設療養費).respond();
    }

    /**
     * 食事費用ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnShokuji(CareManagementMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010023TransitionEventName.食事費用).respond();
    }

    /**
     * 福祉用具購入費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnFukushiYoguKonyu(CareManagementMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010023TransitionEventName.福祉用具購入費).respond();
    }

    /**
     * 特定入所者費用ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnTokuteiNyushosha(CareManagementMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010023TransitionEventName.特定入所者費用).respond();
    }

    /**
     * 高額介護サービス費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnKogakuKaigoService(CareManagementMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010023TransitionEventName.高額介護サービス費).respond();
    }

    /**
     * 特定診療費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnTokuteiShinryo(CareManagementMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010023TransitionEventName.特定診療費).respond();
    }

    /**
     * 居宅サービス計画費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnKyotakuServiceKeikaku(CareManagementMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010023TransitionEventName.居宅サービス計画費).respond();
    }

    /**
     * 住宅改修費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnJutakuKaishu(CareManagementMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010023TransitionEventName.住宅改修費).respond();
    }

    /**
     * 社福軽減費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnShafukuKeigen(CareManagementMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010023TransitionEventName.社福軽減費).respond();
    }

    /**
     * 給付実績一覧に戻るを押します。
     *
     * @param div 画面情報
     * @return ResponseData<CareManagementMainDiv>
     */
    public ResponseData onClick_btnReturn(CareManagementMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010023TransitionEventName.給付実績照会検索一覧).respond();
    }

    private CareManagementHandler getHandler(CareManagementMainDiv div) {
        return new CareManagementHandler(div);
    }

    private ResponseData<CareManagementMainDiv> createResponse(CareManagementMainDiv div) {
        return ResponseData.of(div).respond();
    }
}
