/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2700011;

import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2700011.TorikomiFuairuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2700011.TorikomiFuairuDivSpec;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 給付費単位数表標準マスタ取込画面のValidationHandlerです。
 *
 * @reamsid_L DBC-3400-010 x_zhaowen
 */
public class TorikomiFuairuValidationHandler {

    private final TorikomiFuairuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div TorikomiFuairuDiv
     */
    public TorikomiFuairuValidationHandler(TorikomiFuairuDiv div) {
        this.div = div;
    }

    /**
     * アップロードファイル未指定チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateForアップロードファイル未指定(ValidationMessageControlPairs pairs) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        NoInputMessages checkMessage = new NoInputMessages(DbzErrorMessages.ファイル指定なし);
        messages.add(ValidateChain.validateStart(div).
                ifNot(TorikomiFuairuDivSpec.アップロードファイル未指定チェック)
                .thenAdd(checkMessage).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                checkMessage, div.getUplAppurodoFuairu()).build().check(messages));
        return pairs;
    }

    /**
     * アップロードファイル項目数チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateForアップロードファイル項目数(ValidationMessageControlPairs pairs) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        NoInputMessages checkMessage = new NoInputMessages(DbcErrorMessages.介護給付費単位数表標準マスタ項目数相違);
        messages.add(ValidateChain.validateStart(div).
                ifNot(TorikomiFuairuDivSpec.アップロードファイル項目数チェック)
                .thenAdd(checkMessage).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                checkMessage, div.getUplAppurodoFuairu()).build().check(messages));
        return pairs;
    }

    private static final class NoInputMessages implements IValidationMessage {

        private final Message message;

        private NoInputMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
