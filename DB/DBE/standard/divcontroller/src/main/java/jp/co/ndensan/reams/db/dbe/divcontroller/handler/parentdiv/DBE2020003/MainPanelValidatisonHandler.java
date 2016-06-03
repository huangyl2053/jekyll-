/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2020003;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020003.NinteiChosaSchedule3MainDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * MainPaneValidationMessageバリデーションメッセージを定義している列挙型です。
 *
 * @reamsid_L DBE-0020-030 wanghui
 *
 */
public class MainPanelValidatisonHandler {

    private final NinteiChosaSchedule3MainDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 認定調査スケジュール情報Div
     */
    public MainPanelValidatisonHandler(NinteiChosaSchedule3MainDiv div) {
        this.div = div;
    }

    /**
     * 画面で認定申請日Fromと認定申請日To全て入力時、認定申請日From＞認定申請日Toの場合、エラーとする。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 認定申請日の前後順() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        認定申請日(validPairs);
        return validPairs;
    }

    /**
     * 「検索するボタンをボタン押下。入力チェックを行う。
     *
     *
     * @return バリデーション結果
     */
    private void 認定申請日(ValidationMessageControlPairs validPairs) {
        FlexibleDate 認定申請日開始日 = div.getSearchConditionPanel().getTxtNinteiShinseiYMDFrom().getValue().isEmpty()
                ? FlexibleDate.MIN : div.getSearchConditionPanel().getTxtNinteiShinseiYMDFrom().getValue();
        FlexibleDate 認定申請日終了日 = div.getSearchConditionPanel().getTxtNinteiShinseiYMDTo().getValue().isEmpty()
                ? FlexibleDate.MIN : div.getSearchConditionPanel().getTxtNinteiShinseiYMDTo().getValue();
        if (認定申請日終了日.isBefore(認定申請日開始日)) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.認定申請日の前後順,
                    div.getSearchConditionPanel().getTxtNinteiShinseiYMDFrom()));
        }
    }

    /**
     * 「検索するボタンをボタン押下。入力チェックを行う。
     *
     *
     * @param validPairs ValidationMessageControlPairs
     * @return バリデーション結果
     */
    private void 認定調査日(ValidationMessageControlPairs validPairs) {
        FlexibleDate 認定調査日開始日 = div.getSearchConditionPanel().getTxtNinteiChosaYMDFrom().getValue().isEmpty()
                ? FlexibleDate.MIN : div.getSearchConditionPanel().getTxtNinteiChosaYMDFrom().getValue();
        FlexibleDate 認定調査日終了日 = div.getSearchConditionPanel().getTxtNinteiChosaYMDTo().getValue().isEmpty()
                ? FlexibleDate.MIN : div.getSearchConditionPanel().getTxtNinteiChosaYMDTo().getValue();
        if (認定調査日終了日.isBefore(認定調査日開始日)) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.認定調査日の前後順,
                    div.getSearchConditionPanel().getTxtNinteiChosaYMDFrom()));
        }
    }

    /**
     * 画面で認定調査日Fromと認定調査日To全て入力時、認定調査日From＞認定調査日Toの場合、エラーとする。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 認定調査日の前後順() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        認定調査日(validPairs);
        return validPairs;
    }

    /**
     * 画面で認定調査日Fromと認定調査日To全て入力時、認定調査日From＞認定調査日Toの場合、エラーとする。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs データ空のチェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        データ空チェック(validPairs);
        return validPairs;
    }

    /**
     * データ空チェック
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs データ空チェック(ValidationMessageControlPairs validPairs) {
        if (div.getResultListPanel().getDgResultList().getDataSource() == null
                || div.getResultListPanel().getDgResultList().getDataSource().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.Validate対象者一覧未表示,
                    div.getResultListPanel().getDgResultList()));
        }
        return validPairs;
    }

    private static enum RRVMessages implements IValidationMessage {

        Validate対象者一覧未表示(UrErrorMessages.該当データなし),
        認定申請日の前後順(UrErrorMessages.終了日が開始日以前),
        認定調査日の前後順(UrErrorMessages.終了日が開始日以前);
        private final Message message;

        private RRVMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
