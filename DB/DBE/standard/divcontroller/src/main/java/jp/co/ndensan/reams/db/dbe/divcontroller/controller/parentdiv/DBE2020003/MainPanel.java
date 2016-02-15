/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.DBE2020003;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020003.DBE2020003StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020003.MainPanelDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2020003.MainPanelHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2020003.MainPanelValidatisonHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
    private static final RString 画面番号 = new RString("03");
    private static final RString モード = new RString("1");
    private static final RString 地区コード = new RString("00003");

    /**
     * onLoadの処理を行います。
     *
     * @param div 認定調査スケジュール登録3Div
     * @return ResponseData
     */
    public ResponseData<MainPanelDiv> onLoad(MainPanelDiv div) {
        ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録_モード, モード);
        ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録_地区コード, 地区コード);
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
     * 条件をクリアするをボタン押下。
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
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        if (validate(div, pairs)) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        if (スケジュール編集初期化.equals(ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_モード, RString.class))) {
            getHandler(div).検索対象未定者リスト();
            return ResponseData.of(div).setState(DBE2020003StateName.スケジュール編集);
        }
        if (スケジュール照会初期化.equals(ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_モード, RString.class))) {
            getHandler(div).該当者一覧照会リスト();
            return ResponseData.of(div).setState(DBE2020003StateName.スケジュール照会);
        }
        if (未定者管理初期化.equals(ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_モード, RString.class))) {
            getHandler(div).検索対象未定者リスト();
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
            ViewStateHolder.put(ViewStateKeys.モード, スケジュール照会初期化);

        }
        if (未定者管理初期化.equals(ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_モード, RString.class))) {
            ViewStateHolder.put(ViewStateKeys.モード, 未定者管理初期化);
        }
        if (スケジュール編集初期化.equals(ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_モード, RString.class))) {
            ViewStateHolder.put(ViewStateKeys.モード, スケジュール編集初期化);
        }
        ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録_画面番号03, 画面番号);
        ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録_申請書管理番号, div.getDgResultList().getSelectedItems().get(0).getShinseishoKanriNo());
        ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録_対象者区分, div.getSearchConditionPanel().getRadScheduleShokai().getSelectedKey());

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

    private MainPanelValidatisonHandler getalidatisonHandler() {
        return new MainPanelValidatisonHandler();
    }

    private boolean validate(MainPanelDiv div, ValidationMessageControlPairs pairs) {
        boolean チェック結果 = false;
        FlexibleDate 認定申請日開始日 = div.getSearchConditionPanel().getTxtNinteiShinseiYMDFrom().getValue().isEmpty()
                ? FlexibleDate.MIN : div.getSearchConditionPanel().getTxtNinteiShinseiYMDFrom().getValue();
        FlexibleDate 認定申請日終了日 = div.getSearchConditionPanel().getTxtNinteiShinseiYMDTo().getValue().isEmpty()
                ? FlexibleDate.MIN : div.getSearchConditionPanel().getTxtNinteiShinseiYMDTo().getValue();
        if (認定申請日終了日.isBefore(認定申請日開始日)) {
            pairs.add(getalidatisonHandler().認定申請日の前後順());
            チェック結果 = true;
        }
        FlexibleDate 認定調査日開始日 = div.getSearchConditionPanel().getTxtNinteiChosaYMDFrom().getValue().isEmpty()
                ? FlexibleDate.MIN : div.getSearchConditionPanel().getTxtNinteiChosaYMDFrom().getValue();
        FlexibleDate 認定調査日終了日 = div.getSearchConditionPanel().getTxtNinteiChosaYMDTo().getValue().isEmpty()
                ? FlexibleDate.MIN : div.getSearchConditionPanel().getTxtNinteiChosaYMDTo().getValue();
        if (認定調査日終了日.isBefore(認定調査日開始日)) {
            pairs.add(getalidatisonHandler().認定調査日の前後順());
            チェック結果 = true;
        }
        return チェック結果;
    }
}
