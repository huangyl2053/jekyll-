/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2000015;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000015.DBCMNK4001PanelAllDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionary;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBCMNK4001_更正対象給付実績一覧のバリデーションハンドラークラス。
 *
 * @reamsid_L DBC-4960-010 dongqianjing
 */
public class DBCMNK4001PanelAllValidationHandler {

    private final DBCMNK4001PanelAllDiv div;
    private static final RString 今回抽出期間 = new RString("今回抽出期間");

    /**
     * コンストラクタです。
     *
     * @param div 画面Div
     */
    public DBCMNK4001PanelAllValidationHandler(DBCMNK4001PanelAllDiv div) {
        this.div = div;
    }

    /**
     * 大小関係が不正のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs 大小関係が不正() {
        IValidationMessages messages = new ControlValidator(div).大小関係validate();
        return create大小関係Dictionary().check(messages);
    }

    private ValidationDictionary create大小関係Dictionary() {
        return new ValidationDictionaryBuilder()
                .add(DBCMNK4001PanelAllValidationHandler.IdocheckMessages.大小関係が不正, div.getTxtKonkaiKaishiDate(),
                        div.getTxtKonkaiKaishiTime()).build();
    }

    private static class ControlValidator {

        private final DBCMNK4001PanelAllDiv div;

        public ControlValidator(DBCMNK4001PanelAllDiv div) {
            this.div = div;
        }

        /**
         * 大小関係バリデーションチェックです。
         *
         * @return バリデーション
         */
        public IValidationMessages 大小関係validate() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(DBCMNK4001PanelAllMainSpec.大小関係が不正チェック)
                    .thenAdd(IdocheckMessages.大小関係が不正)
                    .messages());
            return messages;
        }
    }

    private static enum IdocheckMessages implements IValidationMessage {

        大小関係が不正(UrErrorMessages.大小関係が不正, 今回抽出期間.toString());

        private final Message message;

        IdocheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

    private static enum DBCMNK4001PanelAllMainSpec implements IPredicate<DBCMNK4001PanelAllDiv> {

        /**
         * 大小関係が不正チェックです。
         */
        大小関係が不正チェック {
                    @Override
                    public boolean apply(DBCMNK4001PanelAllDiv div) {
                        return SpecHelper.is大小関係が不正(div);
                    }
                };

        private static class SpecHelper {

            public static boolean is大小関係が不正(DBCMNK4001PanelAllDiv div) {
                YMDHMS 今回抽出期間終了日時 = new YMDHMS(div.getTxtKonkaiShuryoDate().getValue(),
                        div.getTxtKonkaiShuryoTime().getValue());
                YMDHMS 今回抽出期間開始日時 = new YMDHMS(RString.EMPTY);
                if (div.getTxtKonkaiKaishiDate().getValue() != null && div.getTxtKonkaiKaishiTime().getValue() != null) {
                    今回抽出期間開始日時 = new YMDHMS(div.getTxtKonkaiKaishiDate().getValue(),
                            div.getTxtKonkaiKaishiTime().getValue());
                }
                return !今回抽出期間開始日時.isEmpty() && !今回抽出期間終了日時.isBeforeOrEquals(今回抽出期間開始日時);

            }

        }
    }
}
