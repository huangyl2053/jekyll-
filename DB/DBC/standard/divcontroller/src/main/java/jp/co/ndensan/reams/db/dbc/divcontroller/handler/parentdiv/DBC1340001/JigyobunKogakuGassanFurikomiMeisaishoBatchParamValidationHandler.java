/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1340001;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1340001.JigyobunKogakuGassanFurikomiMeisaishoBatchParamDiv;
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
 * DBCMNN2004_事業合算・事業分振込明細書作成（一括）のクラスです。
 *
 * @reamsid_L DBC-4870-010 zhouchuanlin
 */
public class JigyobunKogakuGassanFurikomiMeisaishoBatchParamValidationHandler {

    private final JigyobunKogakuGassanFurikomiMeisaishoBatchParamDiv div;
    private static final RString 追加メッセージ = new RString("作成日≦依頼日≦振込指定日");

    /**
     * コンストラクタです。
     *
     * @param div PnlTotalPanelDiv
     */
    public JigyobunKogakuGassanFurikomiMeisaishoBatchParamValidationHandler(JigyobunKogakuGassanFurikomiMeisaishoBatchParamDiv div) {
        this.div = div;
    }

    /**
     * 実行と条件保存ボタンクリック時のバリデーションチェック。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate() {
        IValidationMessages messages = new ControlValidator(div).validate();
        return createDictionary().check(messages);
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(JigyobunKogakuGassanFurikomiMeisaishoBatchParamValidationMessages.日付関係のチェック,
                        div.getTyuusyutuHanni().getTxtKonnkaiTaisyouNenngappi())
                .add(JigyobunKogakuGassanFurikomiMeisaishoBatchParamValidationMessages.依頼日範囲のチック,
                        div.getShuturyokuTyouhyou().getTxtSakuseibi(), div.getShuturyokuTyouhyou().getTxtIraibi(), div.getShuturyokuTyouhyou().getTxtFurikomiSiteibi())
                .build();
    }

    private static class ControlValidator {

        private final JigyobunKogakuGassanFurikomiMeisaishoBatchParamDiv div;

        public ControlValidator(JigyobunKogakuGassanFurikomiMeisaishoBatchParamDiv div) {
            this.div = div;
        }

        /**
         * 「 実行と条件保存ボタンクリック時のバリデーションチェック。
         *
         * @return バリデーション突合結果
         */
        public IValidationMessages validate() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(JigyobunKogakuGassanFurikomiMeisaishoBatchParamSpec.日付関係)
                    .thenAdd(JigyobunKogakuGassanFurikomiMeisaishoBatchParamValidationMessages.日付関係のチェック)
                    .ifNot(JigyobunKogakuGassanFurikomiMeisaishoBatchParamSpec.依頼日範囲のチック)
                    .thenAdd(JigyobunKogakuGassanFurikomiMeisaishoBatchParamValidationMessages.依頼日範囲のチック)
                    .messages());
            return messages;
        }
    }

    private static enum JigyobunKogakuGassanFurikomiMeisaishoBatchParamValidationMessages implements IValidationMessage {

        日付関係のチェック(UrErrorMessages.終了日が開始日以前),
        依頼日範囲のチック(UrErrorMessages.入力値が不正_追加メッセージあり, 追加メッセージ.toString());
        private final Message message;

        JigyobunKogakuGassanFurikomiMeisaishoBatchParamValidationMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
