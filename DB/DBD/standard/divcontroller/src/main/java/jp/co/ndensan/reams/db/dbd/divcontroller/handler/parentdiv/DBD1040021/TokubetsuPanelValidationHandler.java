/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1040021;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1040021.TokubetsuPanelDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1040021.TokubetsuPanelDivSpec;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 特別地域加算軽減実績管理リストのチェックです。
 *
 * @reamsid_L DBD-3880-010 xuejm
 */
public class TokubetsuPanelValidationHandler {

    /**
     * 年月範囲開始が非空チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div TokubetsuPanelDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor年月範囲が非空チェック(ValidationMessageControlPairs pairs, TokubetsuPanelDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(TokubetsuPanelDivSpec.年月範囲開始が非空必須チェック)
                .thenAdd(Messagescheck.年月範囲開始が非空必須チェック)
                .ifNot(TokubetsuPanelDivSpec.年月範囲終了が非空必須チェック)
                .thenAdd(Messagescheck.年月範囲終了が非空必須チェック).messages()
        );
        pairs.add(new ValidationMessageControlDictionaryBuilder()
                .add(Messagescheck.年月範囲開始が非空必須チェック, div.getTxtRangeYM())
                .add(Messagescheck.年月範囲終了が非空必須チェック, div.getTxtRangeYM()).build().check(messages));
        return pairs;
    }

    /**
     * 地区２コード大小関係チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div TokubetsuPanelDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor地区２コード大小関係チェック(ValidationMessageControlPairs pairs, TokubetsuPanelDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(TokubetsuPanelDivSpec.地区２コードが大小関係チェック)
                .thenAdd(Messagescheck.地区２コードが大小関係チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder()
                .add(Messagescheck.地区２コードが大小関係チェック, div.getChushutsuJoken()).build().check(messages));
        return pairs;
    }

    /**
     * 地区２コード大小関係チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div TokubetsuPanelDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor住所コードが大小関係チェック(ValidationMessageControlPairs pairs, TokubetsuPanelDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(TokubetsuPanelDivSpec.住所コードが大小関係チェック)
                .thenAdd(Messagescheck.住所コードが大小関係チェック).messages()
        );
        pairs.add(new ValidationMessageControlDictionaryBuilder()
                .add(Messagescheck.住所コードが大小関係チェック, div.getChushutsuJoken()).build().check(messages));
        return pairs;
    }

    /**
     * 行政区コードが大小関係チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div TokubetsuPanelDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor行政区コードが大小関係チェック(ValidationMessageControlPairs pairs, TokubetsuPanelDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(TokubetsuPanelDivSpec.行政区コードが大小関係チェック)
                .thenAdd(Messagescheck.行政区コードが大小関係チェック).messages()
        );
        pairs.add(new ValidationMessageControlDictionaryBuilder()
                .add(Messagescheck.行政区コードが大小関係チェック, div.getChushutsuJoken()).build().check(messages));
        return pairs;
    }

    private static enum Messagescheck implements IValidationMessage {

        年月範囲開始が非空必須チェック(UrErrorMessages.必須, "年月範囲開始"),
        年月範囲終了が非空必須チェック(UrErrorMessages.必須, "年月範囲終了"),
        行政区コードが大小関係チェック(UrErrorMessages.大小関係が不正, "行政区コード"),
        地区２コードが大小関係チェック(UrErrorMessages.大小関係が不正, "地区２コード"),
        住所コードが大小関係チェック(UrErrorMessages.大小関係が不正, "住所コード");

        private final Message message;

        private Messagescheck(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
