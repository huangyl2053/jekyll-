/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC6100011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC6100011.KyufuTaishoshaScheduleSetteiPanelDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionary;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 高額介護サービス費給付対象者-スケジュール設定のバリデーションハンドラークラス。
 *
 * @reamsid_L DBC-2010-010 wangkanglei
 */
public class KyufuTaishoshaScheduleSetteiPanelValidationHandler {

    private final KyufuTaishoshaScheduleSetteiPanelDiv div;
    private static final RString 開始年月 = new RString("審査年月期間(開始年月)");
    private static final RString 終了年月 = new RString("審査年月期間(終了年月)");

    /**
     * コンストラクタです。
     *
     * @param div 画面Div
     */
    public KyufuTaishoshaScheduleSetteiPanelValidationHandler(KyufuTaishoshaScheduleSetteiPanelDiv div) {
        this.div = div;
    }

    /**
     * 審査年月期間(開始年月)と審査年月期間(終了年月)の前後順バリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs 前後順チェックValidate() {
        IValidationMessages messages = new ControlValidator(div).validate();
        return createDictionary().check(messages);
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(KyufuTaishoshaScheduleSetteiPanelValidationMessages.前後関係逆転チェック,
                        div.getTxtShinsaNengetsuTo(), div.getTxtShinsaNengetsuFrom())
                .build();
    }

    private static class ControlValidator {

        private final KyufuTaishoshaScheduleSetteiPanelDiv div;

        public ControlValidator(KyufuTaishoshaScheduleSetteiPanelDiv div) {
            this.div = div;
        }

        /**
         * 審査年月期間(開始年月)と審査年月期間(終了年月)の前後順バリデーションチェックです。
         *
         * @return バリデーション突合結果
         */
        public IValidationMessages validate() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(KyufuTaishoshaScheduleSetteiPanelSpec.開始年月と終了年月の前後順チェック)
                    .thenAdd(KyufuTaishoshaScheduleSetteiPanelValidationMessages.前後関係逆転チェック)
                    .messages());
            return messages;
        }
    }

    private static enum KyufuTaishoshaScheduleSetteiPanelValidationMessages implements IValidationMessage {

        前後関係逆転チェック(UrErrorMessages.前後関係逆転, 開始年月.toString(), 終了年月.toString());

        private final Message message;

        KyufuTaishoshaScheduleSetteiPanelValidationMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
