/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0520011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0520011.KokuhoShikakuInfoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0520011.KokuhuShikakuInfoPanelSpec;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面入力のチェックHandler。
 *
 * @reamsid_L DBD-5730-010 tianyh
 */
public class MainPanelValidationHandler {

    /**
     * 資格期間大小関係チェック
     *
     * @param pairs バリデーションコントロール
     * @param div KokuhoShikakuInfoPanelDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 資格期間大小関係チェック(ValidationMessageControlPairs pairs, KokuhoShikakuInfoPanelDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(KokuhuShikakuInfoPanelSpec.資格期間大小関係チェック)
                .thenAdd(jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0520011.MainPanelValidationHandler.NoInputMessages.資格期間大小関係チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0520011.MainPanelValidationHandler.NoInputMessages.資格期間大小関係チェック, div.getMeisaiPanel().getTxtShikakuShutokuYMD(), div.getMeisaiPanel().
                getTxtShikakuSoshitsuYMD()).build().check(messages));
        return pairs;
    }

    private static enum NoInputMessages implements IValidationMessage {

        資格期間大小関係チェック(UrErrorMessages.終了日が開始日以前.getMessage());
        private final Message message;

        private NoInputMessages(Message message, String... replacements) {
            this.message = message.replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
