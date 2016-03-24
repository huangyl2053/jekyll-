/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0820026;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShokujiHiyo;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820026.DBC0820026TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820026.GoukeiInfoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0820026.GoukeiInfoPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.syokanbaraihishikyushinseikette.SikibetuNokennsakuki;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.syokanbaraihishikyushinseikette.SyokanbaraihishikyushinseiketteParameter;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
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
 */
public class GoukeiInfoPanel {

    /**
     * onLoad
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<GoukeiInfoPanelDiv> onLoad(GoukeiInfoPanelDiv div) {
        SyokanbaraihishikyushinseiketteParameter par = new SyokanbaraihishikyushinseiketteParameter(
                new HihokenshaNo("000000003"),
                new FlexibleYearMonth(new RString("201611")),
                new RString("0000000003"),
                new JigyoshaNo("0000000003"),
                new RString("0003"),
                new RString("0003"),
                new RString("10"));
        ViewStateHolder.put(ViewStateKeys.償還払費申請検索キー, par);
        SyokanbaraihishikyushinseiketteParameter paramter = ViewStateHolder.get(ViewStateKeys.償還払費申請検索キー,
                SyokanbaraihishikyushinseiketteParameter.class);
        HihokenshaNo 被保険者番号 = paramter.getHiHokenshaNo();
        FlexibleYearMonth サービス年月 = paramter.getServiceTeikyoYM();
        RString 整理番号 = paramter.getSeiriNp();
        JigyoshaNo 事業者番号 = paramter.getJigyoshaNo();
        RString 明細番号 = paramter.getMeisaiNo();
        ViewStateHolder.put(ViewStateKeys.様式番号, new RString("0003"));
        RString 様式番号 = ViewStateHolder.get(ViewStateKeys.様式番号, RString.class);
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
        ViewStateHolder.put(ViewStateKeys.整理番号, 整理番号);
        SikibetuNokennsakuki key = new SikibetuNokennsakuki(new RString("0004"),
                new FlexibleYearMonth(new RString("201601")));
        ViewStateHolder.put(ViewStateKeys.識別番号検索キー, key);
        ViewStateHolder.put(ViewStateKeys.申請日, new RDate("20151116"));
        RDate 申請日 = ViewStateHolder.get(ViewStateKeys.申請日, RDate.class);

        ShikibetsuCode 識別コード = new ShikibetsuCode("000000000000010");
        div.getPanelCcd().getCcdKaigoAtenaInfo().onLoad(識別コード);
        if (!被保険者番号.isEmpty()) {
            div.getPanelCcd().getCcdKaigoShikakuKihon().onLoad(被保険者番号);
        } else {
            div.getPanelCcd().getCcdKaigoShikakuKihon().setVisible(false);
        }

        div.getPanelHead().getTxtServiceTeikyoYM().setValue(new RDate(サービス年月.wareki().toDateString().toString()));
        div.getPanelHead().getTxtShinseiYMD().setValue(new RDate(申請日.wareki().toDateString().toString()));
        div.getPanelHead().getTxtJigyoshaBango().setValue(事業者番号.getColumnValue());
        div.getPanelHead().getTxtMeisaiBango().setValue(明細番号);
        div.getPanelHead().getTxtShomeisho().setValue(様式番号);
        ShokanKihon shokanKihon = ShokanbaraiJyokyoShokai.createInstance().getShokanbarayiSeikyukihonDetail(
                被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        List<ShokanShokujiHiyo> shokanShokujiHiyoList = ShokanbaraiJyokyoShokai.createInstance().
                getSeikyuShokujiHiyoTanjyunSearch(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null);
        getHandler(div).initialize(shokanKihon, shokanShokujiHiyoList);

        SikibetuNokennsakuki kennsakuki = ViewStateHolder.get(ViewStateKeys.識別番号検索キー, SikibetuNokennsakuki.class);
        ShikibetsuNoKanri entity = SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                .getShikibetsuNoKanri(kennsakuki.getServiceTeikyoYM(), kennsakuki.getSikibetuNo());
        if (entity == null) {
            throw new ApplicationException(UrErrorMessages.データが存在しない.getMessage());
        } else {
            getHandler(div).getボタンを制御(entity);
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
        return ResponseData.of(div).forwardWithEventName(DBC0820026TransitionEventName.サービス計画費).respond();
    }

    /**
     * 「基本情報」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<GoukeiInfoPanelDiv> onClick_btnKihoninfo(GoukeiInfoPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).respond();
    }

    /**
     * 「給付費明細」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<GoukeiInfoPanelDiv> onClick_btnKyufuMeisai(GoukeiInfoPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).respond();
    }

    /**
     * 「特定診療費」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<GoukeiInfoPanelDiv> onClick_btnTokuteiShiryohi(GoukeiInfoPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).respond();
    }

    /**
     * 「サービス計画費」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<GoukeiInfoPanelDiv> onClick_btnServiceKeikakuhi(GoukeiInfoPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).respond();
    }

    /**
     * 「特定入所者費用」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<GoukeiInfoPanelDiv> onClick_btnTokuteinyushosha(GoukeiInfoPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).respond();
    }

    /**
     * 「給付費明細（住特）」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<GoukeiInfoPanelDiv> onClick_btnKyufuhiMeisaiJutoku(GoukeiInfoPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).respond();
    }

    /**
     * 「緊急時・所定疾患」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<GoukeiInfoPanelDiv> onClick_btnKinkyujiShoteiShikan(GoukeiInfoPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).respond();
    }

    /**
     * 「緊急時施設療養費」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<GoukeiInfoPanelDiv> onClick_btnKinkyujiShisetsu(GoukeiInfoPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).respond();
    }

    /**
     * 「食事費用」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<GoukeiInfoPanelDiv> onClick_btnShokujihiyo(GoukeiInfoPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).respond();
    }

    /**
     * 「請求額集計」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<GoukeiInfoPanelDiv> onClick_btnSeikyugaku(GoukeiInfoPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).respond();
    }

    /**
     * 「社福軽減額」ボタン
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<GoukeiInfoPanelDiv> onClick_btnShafuku(GoukeiInfoPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).respond();
    }

    private GoukeiInfoPanelHandler getHandler(GoukeiInfoPanelDiv div) {
        return new GoukeiInfoPanelHandler(div);
    }

}
