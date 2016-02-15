/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2020003;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020003.MainPanelDiv;
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
 */
public class MainPanelValidatisonHandler {

    private final MainPanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 認定調査スケジュール情報Div
     */
    public MainPanelValidatisonHandler(MainPanelDiv div) {
        this.div = div;
    }

    /**
     * 画面で認定申請日Fromと認定申請日To全て入力時、認定申請日From＞認定申請日Toの場合、エラーとする。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 認定申請日の前後順() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        validate();
        validPairs.add(new ValidationMessageControlPair(RRVMessages.認定申請日の前後順));
        return validPairs;
    }

    public boolean validate() {
        boolean チェック結果 = false;
        FlexibleDate 認定申請日開始日 = div.getSearchConditionPanel().getTxtNinteiShinseiYMDFrom().getValue().isEmpty()
                ? FlexibleDate.MIN : div.getSearchConditionPanel().getTxtNinteiShinseiYMDFrom().getValue();
        FlexibleDate 認定申請日終了日 = div.getSearchConditionPanel().getTxtNinteiShinseiYMDTo().getValue().isEmpty()
                ? FlexibleDate.MIN : div.getSearchConditionPanel().getTxtNinteiShinseiYMDTo().getValue();
        if (認定申請日終了日.isBefore(認定申請日開始日)) {

            チェック結果 = true;
        }
        FlexibleDate 認定調査日開始日 = div.getSearchConditionPanel().getTxtNinteiChosaYMDFrom().getValue().isEmpty()
                ? FlexibleDate.MIN : div.getSearchConditionPanel().getTxtNinteiChosaYMDFrom().getValue();
        FlexibleDate 認定調査日終了日 = div.getSearchConditionPanel().getTxtNinteiChosaYMDTo().getValue().isEmpty()
                ? FlexibleDate.MIN : div.getSearchConditionPanel().getTxtNinteiChosaYMDTo().getValue();
        if (認定調査日終了日.isBefore(認定調査日開始日)) {

            チェック結果 = true;
        }
        return チェック結果;
    }

    /**
     * 画面で認定調査日Fromと認定調査日To全て入力時、認定調査日From＞認定調査日Toの場合、エラーとする。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 認定調査日の前後順() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();

        validPairs.add(new ValidationMessageControlPair(RRVMessages.認定調査日の前後順));
        return validPairs;
    }

    private static enum RRVMessages implements IValidationMessage {

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
