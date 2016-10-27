/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0720011;

import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionary;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 住宅改修費支給申請一括審査・決定画面 チェッククラスです
 *
 * @reamsid_L DBC-0991-030 surun
 */
public class JutakuKaishuhiShikyuShinseiPanelVlaidationHandler {

    private final JutakuKaishuhiShikyuShinseiPanelDiv div;
    private static final RString メッセージ_申請日 = new RString("支給申請日（FROM)または支給申請日（TO)");
    private static final RString メッセージ_申請日FROM = new RString("支給申請日（FROM)");
    private static final RString メッセージ_申請日TO = new RString("支給申請日（TO)");
    private static final RString メッセージ_決定日 = new RString("決定日");

    /**
     * コンストラクタです
     *
     * @param div (JutakuKaishuhiShikyuShinseiPanelDiv
     */
    public JutakuKaishuhiShikyuShinseiPanelVlaidationHandler(JutakuKaishuhiShikyuShinseiPanelDiv div) {
        this.div = div;
    }

    /**
     * volidate支給申請日
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs volidate支給申請日() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(JutakuKaishuhiShikyuShinseiPanelSpec.支給申請日入力)
                .thenAdd(JutakuKaishuhiShikyuShinseiErrorMessages.支給申請日FROMと支給申請日TOの必須チェック)
                .ifNot(JutakuKaishuhiShikyuShinseiPanelSpec.支給申請日有効性)
                .thenAdd(JutakuKaishuhiShikyuShinseiErrorMessages.支給申請日FROMと支給申請日TOの有効性チェック)
                .messages());

        return createSearchConditionToMishinsaShikyuShinseiPanelValidatorDictionary().check(messages);
    }

    /**
     * volidateデータ選択
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs volidateデータ選択と決定日() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(JutakuKaishuhiShikyuShinseiPanelSpec.データ選択のチェック)
                .thenAdd(JutakuKaishuhiShikyuShinseiErrorMessages.データ選択のチェック)
                .ifNot(JutakuKaishuhiShikyuShinseiPanelSpec.決定日のチェック)
                .thenAdd(JutakuKaishuhiShikyuShinseiErrorMessages.決定日のチェック)
                .messages());
        return createMishinsaShikyuShinseiListPanelValidatorDictionary().check(messages);
    }

    /**
     * volidateデータ選択と未審査
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs volidateデータ選択と未審査と決定日() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(JutakuKaishuhiShikyuShinseiPanelSpec.データ選択のチェック)
                .thenAdd(JutakuKaishuhiShikyuShinseiErrorMessages.データ選択のチェック)
                .ifNot(JutakuKaishuhiShikyuShinseiPanelSpec.未審査のチェック)
                .thenAdd(JutakuKaishuhiShikyuShinseiErrorMessages.未審査のチェック)
                .ifNot(JutakuKaishuhiShikyuShinseiPanelSpec.決定日のチェック)
                .thenAdd(JutakuKaishuhiShikyuShinseiErrorMessages.決定日のチェック)
                .messages());
        return createMishinsaShinsaButtonDivValidatorDictionary().check(messages);
    }

    /**
     * createSearchConditionToMishinsaShikyuShinseiPanelValidatorDictionary
     *
     * @return ValidationDictionary
     */
    private ValidationMessageControlDictionary createSearchConditionToMishinsaShikyuShinseiPanelValidatorDictionary() {
        return new ValidationMessageControlDictionaryBuilder()
                .add(JutakuKaishuhiShikyuShinseiErrorMessages.支給申請日FROMと支給申請日TOの有効性チェック,
                        div.getSearchConditionToMishinsaShikyuShinseiPanel().getTxtShikyuShinseiDate())
                .add(JutakuKaishuhiShikyuShinseiErrorMessages.支給申請日FROMと支給申請日TOの必須チェック,
                        div.getSearchConditionToMishinsaShikyuShinseiPanel().getTxtShikyuShinseiDate()).build();
    }

    /**
     * createMishinsaShikyuShinseiListPanelValidatorDictionary
     *
     * @return ValidationDictionary
     */
    private ValidationMessageControlDictionary createMishinsaShikyuShinseiListPanelValidatorDictionary() {
        return new ValidationMessageControlDictionaryBuilder()
                .add(JutakuKaishuhiShikyuShinseiErrorMessages.データ選択のチェック,
                        div.getMishinsaShikyuShinseiListPanel().getDgMishinsaShikyuShinsei())
                .add(JutakuKaishuhiShikyuShinseiErrorMessages.決定日のチェック,
                        div.getMishinsaShikyuShinseiListPanel().getTxtKetteiYMD()).build();
    }

    /**
     * createMishinsaShinsaButtonDivValidatorDictionary
     *
     * @return ValidationDictionary
     */
    private ValidationMessageControlDictionary createMishinsaShinsaButtonDivValidatorDictionary() {
        return new ValidationMessageControlDictionaryBuilder()
                .add(JutakuKaishuhiShikyuShinseiErrorMessages.データ選択のチェック,
                        div.getMishinsaShikyuShinseiListPanel().getDgMishinsaShikyuShinsei())
                .add(JutakuKaishuhiShikyuShinseiErrorMessages.未審査のチェック,
                        div.getMishinsaShikyuShinseiListPanel().getDgMishinsaShikyuShinsei())
                .add(JutakuKaishuhiShikyuShinseiErrorMessages.決定日のチェック,
                        div.getMishinsaShikyuShinseiListPanel().getTxtKetteiYMD()).build();
    }

    private static enum JutakuKaishuhiShikyuShinseiErrorMessages implements IValidationMessage {

        支給申請日FROMと支給申請日TOの必須チェック(UrErrorMessages.必須項目_追加メッセージあり, メッセージ_申請日.toString()),
        支給申請日FROMと支給申請日TOの有効性チェック(DbzErrorMessages.期間が不正_未来日付不可, メッセージ_申請日FROM.toString(),
                メッセージ_申請日TO.toString()),
        データ選択のチェック(UrErrorMessages.対象行を選択),
        未審査のチェック(DbcErrorMessages.未審査有りで保存不可),
        決定日のチェック(UrErrorMessages.必須項目_追加メッセージあり, メッセージ_決定日.toString());

        private final Message message;

        private JutakuKaishuhiShikyuShinseiErrorMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }

    }
}
