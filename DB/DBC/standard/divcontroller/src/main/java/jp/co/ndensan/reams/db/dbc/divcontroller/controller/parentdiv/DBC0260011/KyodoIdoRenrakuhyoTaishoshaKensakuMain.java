/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0260011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyodojukyushataishosha.KyodoJukyushaTaishoshaEntity;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0260011.DBC0260011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0260011.DBC0260011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0260011.KyodoIdoRenrakuhyoTaishoshaKensakuMainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0260011.KyodoIdoRenrakuhyoTaishoshaKensakuMainHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0260011.KyodoIdoRenrakuhyoTaishoshaKensakuMainValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.kyodojukyushataishosha.KyodoJukyushaTaishoshaFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 共同処理用受給者訂正連絡票登録（対象者検索）のクラスです。
 *
 * @reamsid_L DBC-1951-010 wangkanglei
 */
public class KyodoIdoRenrakuhyoTaishoshaKensakuMain {

    private static final RString 共同処理用受給者訂正連絡票登録_メニューID = new RString("DBCMN81004");
    private static final RString 共同処理用受給者異動連絡票作成_メニューID = new RString("DBCMN83002");
    private static final RString 共同処理用受給者異動連絡票情報照会_メニューID = new RString("DBCMN11008");
    private static final RString モード_修正 = new RString("修正モード");
    private static final RString モード_選択 = new RString("選択モード");
    private static final RString KEY_ZERO = new RString("key0");
    private static final int NUM_ZERO = 0;
    private static final RString イベント_対象者特定 = new RString("DBZ0200001_対象者特定");
    private static final RString イベント_終了 = new RString("DBZ0200001_終了");

    /**
     * 画面初期化のメソッドです。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<KyodoIdoRenrakuhyoTaishoshaKensakuMainDiv> onLoad(
            KyodoIdoRenrakuhyoTaishoshaKensakuMainDiv div) {
        RString イベント名 = ResponseHolder.getBeforeEvent();
        if (イベント_対象者特定.equals(イベント名) || イベント_終了.equals(イベント名)) {
            TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
            HihokenshaNo 被保番号 = 資格対象者.get被保険者番号();
            if (被保番号 != null && !被保番号.isEmpty()) {
                div.getTxtSearchHihokenshaNo().setValue(資格対象者.get被保険者番号().getColumnValue());
                getHandler(div).set被保険者名();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索する」ボタンのメソッドです。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<KyodoIdoRenrakuhyoTaishoshaKensakuMainDiv> onClick_btnSearch(
            KyodoIdoRenrakuhyoTaishoshaKensakuMainDiv div) {

        ValidationMessageControlPairs validPairs = getValidationHandler(div).異動日と被保番号Validate();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        RString 表示モード = RString.EMPTY;
        RString 削除データ = RString.EMPTY;
        FlexibleDate 異動日From = null;
        FlexibleDate 異動日To = null;
        RString メニューID = ResponseHolder.getMenuID();
        HihokenshaNo 被保険者番号 = new HihokenshaNo(div.getTxtSearchHihokenshaNo().getValue());
        RDate dateFrom = div.getTxtSearchIdoYMD().getFromValue();
        if (dateFrom != null) {
            異動日From = new FlexibleDate(dateFrom.toDateString());
        }
        RDate dateTo = div.getTxtSearchIdoYMD().getToValue();
        if (dateTo != null) {
            異動日To = new FlexibleDate(dateTo.toDateString());
        }
        boolean is削除データ検索 = false;
        if (共同処理用受給者訂正連絡票登録_メニューID.equals(メニューID)) {
            表示モード = モード_修正;
        } else if (共同処理用受給者異動連絡票作成_メニューID.equals(メニューID)
                || 共同処理用受給者異動連絡票情報照会_メニューID.equals(メニューID)) {
            表示モード = モード_選択;
        }
        List<RString> 削除データ検索 = div.getChkSearchDeleteData().getSelectedKeys();
        if (!削除データ検索.isEmpty() && KEY_ZERO.equals(削除データ検索.get(NUM_ZERO))) {
            削除データ = 削除データ検索.get(NUM_ZERO);
            is削除データ検索 = true;
        }
        List<KyodoJukyushaTaishoshaEntity> 対象者一覧情報List = KyodoJukyushaTaishoshaFinder.createInstance()
                .getTaishosha(被保険者番号, 異動日From, 異動日To, is削除データ検索);
        if (対象者一覧情報List == null || 対象者一覧情報List.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        } else if (対象者一覧情報List.size() == 1) {
            KyodoJukyushaTaishoshaEntity 対象者一覧 = 対象者一覧情報List.get(NUM_ZERO);
            ViewStateHolder.put(ViewStateKeys.一覧検索キー, 対象者一覧);
            return ResponseData.of(div).forwardWithEventName(DBC0260011TransitionEventName.選択).respond();
        } else {
            div.getKyodoIdoRenrakuhyoHenkoResult().getCcdTaishoshaIchiran().initialize(
                    メニューID, 被保険者番号, 異動日From, 異動日To, 表示モード, 削除データ, 対象者一覧情報List);
            return ResponseData.of(div).setState(DBC0260011StateName.対象者一覧);
        }
    }

    /**
     * 「該当者を検索する」ボタンのメソッドです。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<KyodoIdoRenrakuhyoTaishoshaKensakuMainDiv> onClick_btnSearchHihokensha(
            KyodoIdoRenrakuhyoTaishoshaKensakuMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0260011TransitionEventName.該当者検索).respond();
    }

    /**
     * 「条件をクリアする」ボタンのメソッドです。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<KyodoIdoRenrakuhyoTaishoshaKensakuMainDiv> onClick_btnSearchClear(
            KyodoIdoRenrakuhyoTaishoshaKensakuMainDiv div) {
        getHandler(div).click条件をクリア();
        return ResponseData.of(div).respond();
    }

    /**
     * 「再検索する」ボタンのメソッドです。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<KyodoIdoRenrakuhyoTaishoshaKensakuMainDiv> onClick_btnResearch(
            KyodoIdoRenrakuhyoTaishoshaKensakuMainDiv div) {
        return ResponseData.of(div).setState(DBC0260011StateName.検索条件);
    }

    /**
     * 対象者一覧共有子Div．「選択」ボタンのメソッドです。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<KyodoIdoRenrakuhyoTaishoshaKensakuMainDiv> onClick_btnSelect_ccdTaishoshaIchiran(
            KyodoIdoRenrakuhyoTaishoshaKensakuMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0260011TransitionEventName.選択).respond();
    }

    /**
     * 対象者一覧共有子Div．「修正」ボタンのメソッドです。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<KyodoIdoRenrakuhyoTaishoshaKensakuMainDiv> onClick_btnModify_ccdTaishoshaIchiran(
            KyodoIdoRenrakuhyoTaishoshaKensakuMainDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0260011TransitionEventName.選択).respond();
    }

    /**
     * 被保番号のメソッドです。
     *
     * @param div 画面Div
     * @return ResponseData
     */
    public ResponseData<KyodoIdoRenrakuhyoTaishoshaKensakuMainDiv> onBlur_txtSearchHihokenshaNo(
            KyodoIdoRenrakuhyoTaishoshaKensakuMainDiv div) {
        getHandler(div).set被保険者名();
        return ResponseData.of(div).respond();
    }

    private KyodoIdoRenrakuhyoTaishoshaKensakuMainHandler getHandler(KyodoIdoRenrakuhyoTaishoshaKensakuMainDiv div) {
        return KyodoIdoRenrakuhyoTaishoshaKensakuMainHandler.of(div);
    }

    private KyodoIdoRenrakuhyoTaishoshaKensakuMainValidationHandler getValidationHandler(
            KyodoIdoRenrakuhyoTaishoshaKensakuMainDiv div) {
        return new KyodoIdoRenrakuhyoTaishoshaKensakuMainValidationHandler(div);
    }
}
