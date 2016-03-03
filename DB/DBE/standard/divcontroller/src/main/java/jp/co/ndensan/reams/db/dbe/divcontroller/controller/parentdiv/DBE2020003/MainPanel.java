/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2020003;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020003.DBE2020003StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020003.MainPanelDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2020003.MainPanelHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2020003.MainPanelValidatisonHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * 認定調査スケジュール登録3のコントローラです。
 */
public class MainPanel {

    private static final RString スケジュール編集初期化 = new RString("1");
    private static final RString スケジュール照会初期化 = new RString("2");
    private static final RString 未定者管理初期化 = new RString("3");
    private static final RString 対象者区分 = new RString("0");

    /**
     * onLoadの処理を行います。
     *
     * @param div 認定調査スケジュール登録3Div
     * @return ResponseData
     */
    public ResponseData<MainPanelDiv> onLoad(MainPanelDiv div) {
        if (スケジュール編集初期化.equals(ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_モード, RString.class))) {
            getHandler(div).initialize();
            return ResponseData.of(div).setState(DBE2020003StateName.スケジュール編集);
        }
        if (スケジュール照会初期化.equals(ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_モード, RString.class))) {
            getHandler(div).initialize();
            return ResponseData.of(div).setState(DBE2020003StateName.スケジュール照会);
        }
        if (未定者管理初期化.equals(ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_モード, RString.class))) {
            getHandler(div).initialize();
            return ResponseData.of(div).setState(DBE2020003StateName.未定者);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 対象地区　ドロップダウンリストを選択した時。
     *
     * @param div MainPanelDiv
     * @return ResponseData
     */
    public ResponseData<MainPanelDiv> onChange_District(MainPanelDiv div) {
        getHandler(div).set保険者DDL();
        return ResponseData.of(div).respond();
    }

    /**
     * 検索条件エリアボタンを押下。
     *
     * @param div MainPanelDiv
     * @return ResponseData
     */
    public ResponseData<MainPanelDiv> onClick_Condition(MainPanelDiv div) {
        getHandler(div).検索条件クリア();
        return ResponseData.of(div).respond();
    }

    /**
     * 検索するボタンをボタン押下。
     *
     * @param div MainPanelDiv
     * @return ResponseData
     */
    public ResponseData<MainPanelDiv> onClick_Search(MainPanelDiv div) {
        ValidationMessageControlPairs validationMessageControlPairs = getalidatisonHandler(div).認定申請日の前後順();
        if (validationMessageControlPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessageControlPairs).respond();
        }
        ValidationMessageControlPairs validationMessageControl = getalidatisonHandler(div).認定調査日の前後順();
        if (validationMessageControl.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessageControl).respond();
        }
        if (スケジュール編集初期化.equals(ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_モード, RString.class))) {
            getHandler(div).検索対象未定者リスト_モード1();
            return ResponseData.of(div).setState(DBE2020003StateName.スケジュール編集);
        }
        if (スケジュール照会初期化.equals(ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_モード, RString.class))) {
            getHandler(div).該当者一覧照会リスト();
            return ResponseData.of(div).setState(DBE2020003StateName.スケジュール照会);
        }
        if (未定者管理初期化.equals(ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_モード, RString.class))) {
            getHandler(div).検索対象未定者リスト_モード3();
            return ResponseData.of(div).setState(DBE2020003StateName.未定者);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * データグリッドをボタン押下。
     *
     * @param div MainPanelDiv
     * @return ResponseData
     */
    public ResponseData<MainPanelDiv> onClick_Selection(MainPanelDiv div) {
        if (スケジュール照会初期化.equals(ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_モード, RString.class))) {
            ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録_対象者区分, 対象者区分);
        }
        if (未定者管理初期化.equals(ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_モード, RString.class))) {
            ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録_対象者区分, div.getRadMiteishaKanri().getSelectedKey());
        }
        if (スケジュール編集初期化.equals(ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_モード, RString.class))) {
            ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録_対象者区分, div.getRadScheduleEdit().getSelectedKey());
        }
        ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録3_地区コード, div.getDdlTaishoChiku().getSelectedKey());
        ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録3_市町村コード, div.getDdlHokensha().getSelectedKey());
        ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録3_認定調査委託先コード, div.getDgResultList().getSelectedItems().get(0).getNinteiChosaItakusakiCode());
        ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録3_認定調査員コード, div.getDgResultList().getSelectedItems().get(0).getNinteiChosainCode());
        ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録3_設定日, div.getDgResultList().getSelectedItems().get(0).getNinteiChosaYmd().getValue());
        ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録3_時間枠, div.getDgResultList().getSelectedItems().get(0).getNinteiChosaJikanWaku());
        ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録3_予約可否, div.getDgResultList().getSelectedItems().get(0).getYoyakuKaoFlag());
        ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録3_予約状況, div.getDgResultList().getSelectedItems().get(0).getJokyo());
        ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録3_申請書管理番号3, div.getDgResultList().getSelectedItems().get(0).getShinseishoKanriNo());
        ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録_保険者, div.getDdlHokensha().getSelectedKey());
        ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録3_調査員状況02, div.getDgResultList().getSelectedItems().get(0).getJokyo());
        return ResponseData.of(div).respond();
    }

    /**
     * 戻るボタン押下を呼び出し元の画面に戻る。
     *
     * @param div MainPanelDiv
     * @return ResponseData
     */
    public ResponseData<MainPanelDiv> onClick_Modoru(MainPanelDiv div) {
        return ResponseData.of(div).respond();
    }

    private MainPanelHandler getHandler(MainPanelDiv div) {
        return new MainPanelHandler(div);
    }

    private MainPanelValidatisonHandler getalidatisonHandler(MainPanelDiv div) {
        return new MainPanelValidatisonHandler(div);
    }
}
