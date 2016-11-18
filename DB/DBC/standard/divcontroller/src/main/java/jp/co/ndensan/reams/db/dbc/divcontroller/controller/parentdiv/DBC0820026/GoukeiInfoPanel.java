/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0820026;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShokujiHiyo;
import jp.co.ndensan.reams.db.dbc.definition.core.shoukanharaihishinseikensaku.ShoukanharaihishinseimeisaikensakuParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820026.DBC0820026TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820026.GoukeiInfoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820026.GoukeiInfoPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.SikibetuNokennsakuki;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 償還払い費支給申請決定_サービス提供証明書(合計情報）
 *
 * @reamsid_L DBC-1030-070 xuhao
 */
public class GoukeiInfoPanel {

    /**
     * onLoad
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<GoukeiInfoPanelDiv> onLoad(GoukeiInfoPanelDiv div) {
        ShoukanharaihishinseimeisaikensakuParameter meisaiPar = ViewStateHolder.get(ViewStateKeys.明細検索キー,
                ShoukanharaihishinseimeisaikensakuParameter.class);
        HihokenshaNo 被保険者番号 = meisaiPar.get被保険者番号();
        FlexibleYearMonth サービス年月 = meisaiPar.getサービス年月();
        RString 整理番号 = meisaiPar.get整理番号();
        JigyoshaNo 事業者番号 = meisaiPar.get事業者番号();
        RString 様式番号 = meisaiPar.get様式番号();
        RString 明細番号 = meisaiPar.get明細番号();
        RDate 申請日 = meisaiPar.get申請日();

        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        div.getPanelCcd().getCcdKaigoAtenaInfo().initialize(識別コード);
        if (!被保険者番号.isEmpty()) {
            div.getPanelCcd().getCcdKaigoShikakuKihon().initialize(被保険者番号);
        } else {
            div.getPanelCcd().getCcdKaigoShikakuKihon().setVisible(false);
        }

        getHandler(div).set申請共通エリア(サービス年月, 申請日, 事業者番号, 明細番号, 様式番号);

        ShokanKihon shokanKihon = ShokanbaraiJyokyoShokai.createInstance().getShokanbarayiSeikyukihonDetail(
                被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        List<ShokanShokujiHiyo> shokanShokujiHiyoList = ShokanbaraiJyokyoShokai.createInstance().
                getSeikyuShokujiHiyoTanjyunSearch(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null);
        getHandler(div).initialize(shokanKihon, shokanShokujiHiyoList);
        getHandler(div).set合計情報();

        SikibetuNokennsakuki kennsakuki = ViewStateHolder.get(ViewStateKeys.識別番号検索キー, SikibetuNokennsakuki.class);
        ShikibetsuNoKanri entity = SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                .getShikibetsuNoKanri(kennsakuki.getServiceTeikyoYM(), kennsakuki.getSikibetuNo());
        if (entity == null) {
            throw new ApplicationException(UrErrorMessages.データが存在しない.getMessage());
        } else {
            getHandler(div).getボタンを制御(entity, meisaiPar);
        }

        return ResponseData.of(div).respond();
    }

    /**
     * onClick_btnBack
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<GoukeiInfoPanelDiv> onClick_btnBack(GoukeiInfoPanelDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0820026TransitionEventName.一覧に戻る).respond();
    }

    /**
     * 「基本情報」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<GoukeiInfoPanelDiv> onClick_btnKihoninfo(GoukeiInfoPanelDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0820026TransitionEventName.基本情報).respond();
    }

    /**
     * 「給付費明細」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<GoukeiInfoPanelDiv> onClick_btnKyufuMeisai(GoukeiInfoPanelDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0820026TransitionEventName.給付費明細).respond();
    }

    /**
     * 「特定診療費」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<GoukeiInfoPanelDiv> onClick_btnTokuteiShiryohi(GoukeiInfoPanelDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0820026TransitionEventName.特定診療費).respond();
    }

    /**
     * 「サービス計画費」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<GoukeiInfoPanelDiv> onClick_btnServiceKeikakuhi(GoukeiInfoPanelDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0820026TransitionEventName.サービス計画費).respond();
    }

    /**
     * 「特定入所者費用」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<GoukeiInfoPanelDiv> onClick_btnTokuteinyushosha(GoukeiInfoPanelDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0820026TransitionEventName.特定入所者費用).respond();
    }

    /**
     * 「給付費明細（住特）」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<GoukeiInfoPanelDiv> onClick_btnKyufuhiMeisaiJutoku(GoukeiInfoPanelDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0820026TransitionEventName.給付費明細_住特).respond();
    }

    /**
     * 「緊急時・所定疾患」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<GoukeiInfoPanelDiv> onClick_btnKinkyujiShoteiShikan(GoukeiInfoPanelDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0820026TransitionEventName.緊急時_所定疾患).respond();
    }

    /**
     * 「緊急時施設療養費」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<GoukeiInfoPanelDiv> onClick_btnKinkyujiShisetsu(GoukeiInfoPanelDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0820026TransitionEventName.緊急時施設療養費).respond();
    }

    /**
     * 「食事費用」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<GoukeiInfoPanelDiv> onClick_btnShokujihiyo(GoukeiInfoPanelDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0820026TransitionEventName.食事費用).respond();
    }

    /**
     * 「請求額集計」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<GoukeiInfoPanelDiv> onClick_btnSeikyugaku(GoukeiInfoPanelDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0820026TransitionEventName.請求額集計).respond();
    }

    /**
     * 「社福軽減額」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<GoukeiInfoPanelDiv> onClick_btnShafuku(GoukeiInfoPanelDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0820026TransitionEventName.社福軽減額).respond();
    }

    private GoukeiInfoPanelHandler getHandler(GoukeiInfoPanelDiv div) {
        return new GoukeiInfoPanelHandler(div);
    }

}
