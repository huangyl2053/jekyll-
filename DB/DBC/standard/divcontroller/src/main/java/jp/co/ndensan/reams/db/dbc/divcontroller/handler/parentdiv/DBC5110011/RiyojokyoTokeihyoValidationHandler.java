/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC5110011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5110011.RiyojokyoTokeihyoDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBC5110011_年齢階級別利用状況作成のバリデーションクラスです
 *
 *
 * @reamsid_L DBC-3470-010 xuyongchao
 */
public class RiyojokyoTokeihyoValidationHandler {

    private final RiyojokyoTokeihyoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public RiyojokyoTokeihyoValidationHandler(RiyojokyoTokeihyoDiv div) {
        this.div = div;
    }

    /**
     * 未入力チェックです
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 未入力チェック(ValidationMessageControlPairs validPairs) {
        if (div.getTasyoNengetu().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(RiyojokyoTokeihyoMessages.未入力チェック));
        }
        return validPairs;
    }

    private static enum RiyojokyoTokeihyoMessages implements IValidationMessage {

        未入力チェック(UrErrorMessages.必須項目_追加メッセージあり, "対象年月");
        private final Message message;

        private RiyojokyoTokeihyoMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

}
