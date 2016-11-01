/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0610011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0610011.YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0610011.YoguKonyuhiShikyuShinseiMishinsaSpec;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 福祉用具購入費支給申請審査 未審査支給申請一覧画面 チェッククラスです
 *
 * @reamsid_L DBC-1020-040 gongliang
 */
public class YoguKonyuhiShikyuShinseiMishinsaValidationHandler {

    private final YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv div;
    private static final RString メッセージ_決定日 = new RString("決定日");

    /**
     * コンストラクタです
     *
     * @param div YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv
     */
    public YoguKonyuhiShikyuShinseiMishinsaValidationHandler(YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv div) {
        this.div = div;
    }

    /**
     * volidateデータ選択
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateデータ選択と決定日() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(YoguKonyuhiShikyuShinseiMishinsaSpec.データ選択のチェック)
                .thenAdd(YoguKonyuhiShikyuShinseiMishinsaErrorMessages.データ選択のチェック)
                .ifNot(YoguKonyuhiShikyuShinseiMishinsaSpec.決定日のチェック)
                .thenAdd(YoguKonyuhiShikyuShinseiMishinsaErrorMessages.決定日のチェック)
                .messages());
        return new ValidationMessageControlDictionaryBuilder()
                .add(YoguKonyuhiShikyuShinseiMishinsaErrorMessages.データ選択のチェック,
                        div.getYoguKonyuhiShikyuShinseiMishinsaResultList().getDgYoguKonyuhiShisaMishinsaShikyuShinseiList())
                .add(YoguKonyuhiShikyuShinseiMishinsaErrorMessages.決定日のチェック,
                        div.getYoguKonyuhiShikyuShinseiMishinsaResultList().getTxtKetteiYMD())
                .build().check(messages);
    }

    private static enum YoguKonyuhiShikyuShinseiMishinsaErrorMessages implements IValidationMessage {

        データ選択のチェック(UrErrorMessages.対象行を選択),
        決定日のチェック(UrErrorMessages.必須項目_追加メッセージあり, メッセージ_決定日.toString());

        private final Message message;

        private YoguKonyuhiShikyuShinseiMishinsaErrorMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }

    }
}
