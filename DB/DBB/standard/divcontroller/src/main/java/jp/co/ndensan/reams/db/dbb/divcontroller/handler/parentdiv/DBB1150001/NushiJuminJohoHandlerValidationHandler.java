/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB1150001;

import jp.co.ndensan.reams.db.dbb.definition.message.DbbErrorMessages;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1150001.NushiJuminJohoDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionary;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBBGM51002_所得照会票作成
 *
 * @reamsid_L DBB-1710-010 xuhao
 */
public class NushiJuminJohoHandlerValidationHandler {

    private final NushiJuminJohoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div NushiJuminJohoDiv
     */
    public NushiJuminJohoHandlerValidationHandler(NushiJuminJohoDiv div) {
        this.div = div;
    }

    /**
     * 世帯員未選択チェック
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate() {
        IValidationMessages messages = new ControlValidator(div)
                .validate();
        return createDictionary().check(messages);
    }

    /**
     * バリデーション突合結果
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate住所一致() {
        IValidationMessages messages = new ControlValidator(div)
                .validate住所一致();
        return createDictionary住所一致().check(messages);
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(NushiJuminJohoHandlerValidationMessages.世帯員未選択, div.getShotokuShokaiHyoHakkoIchiranPanel().getDgShotokuShokaiHyoHakko())
                .build();
    }

    private ValidationDictionary createDictionary住所一致() {
        return new ValidationDictionaryBuilder()
                .add(NushiJuminJohoHandlerValidationMessages.照会先不正, div.getHakkoKakuninPanel().getDgHakkoKakunin())
                .add(NushiJuminJohoHandlerValidationMessages.現住所不正, div.getHakkoKakuninPanel().getDgHakkoKakunin())
                .build();
    }

    private static class ControlValidator {

        private final NushiJuminJohoDiv div;

        public ControlValidator(NushiJuminJohoDiv div) {
            this.div = div;
        }

        /**
         * 選択世帯員の印字内容を確認するボタンクリック時のバリデーションチェック。
         *
         * @return バリデーション突合結果
         */
        public IValidationMessages validate() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(NushiJuminJohoHandlerSpec.世帯員選択)
                    .thenAdd(NushiJuminJohoHandlerValidationMessages.世帯員未選択)
                    .messages());
            return messages;
        }

        /**
         * 住所一致チェック
         *
         * @return バリデーション突合結果
         */
        public IValidationMessages validate住所一致() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(NushiJuminJohoHandlerSpec.照会先不正)
                    .thenAdd(NushiJuminJohoHandlerValidationMessages.照会先不正)
                    .messages());
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(NushiJuminJohoHandlerSpec.現住所不正)
                    .thenAdd(NushiJuminJohoHandlerValidationMessages.現住所不正)
                    .messages());
            return messages;
        }
    }

    private static enum NushiJuminJohoHandlerValidationMessages implements IValidationMessage {

        世帯員未選択(UrErrorMessages.選択されていない, "世帯員"),
        照会先不正(DbbErrorMessages.所得照会_照会先不正),
        現住所不正(DbbErrorMessages.所得照会_現住所不正);
        private final Message message;

        NushiJuminJohoHandlerValidationMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

}
