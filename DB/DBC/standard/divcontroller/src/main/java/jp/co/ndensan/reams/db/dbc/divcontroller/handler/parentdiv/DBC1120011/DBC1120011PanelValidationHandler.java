/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1120011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1120011.DBC1120011PanelDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionary;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
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
 * 画面設計_DBCMN62006_自己負担額計算（一括）のクラスです。
 *
 * @reamsid_L DBC-2060-010 chenyadong
 */
public class DBC1120011PanelValidationHandler {

    private final DBC1120011PanelDiv div;
    private static final RString 出力順 = new RString("出力順");
    private static final RString 申請対象開始日 = new RString("申請対象日(開始日)");
    private static final RString 申請対象終了日 = new RString("申請対象日(終了日)");

    /**
     * コンストラクタです。
     *
     * @param div DBC1120011PanelDiv
     */
    public DBC1120011PanelValidationHandler(DBC1120011PanelDiv div) {
        this.div = div;
    }

    /**
     * validateチェック
     *
     * @return validPairs ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validate() {

        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(KokuhorenTorikomiListSpec.申請対象開始日小さい申請対象終了日).
                thenAdd(IdocheckMessages.申請対象開始日小さい申請対象終了日).
                ifNot(KokuhorenTorikomiListSpec.必須設定項目_出力順).
                thenAdd(IdocheckMessages.必須設定項目_出力順).
                messages());
        validPairs.add(createDictionary().check(messages));
        return validPairs;
    }

    private ValidationDictionary createDictionary() {

        return new ValidationDictionaryBuilder()
                .add(IdocheckMessages.申請対象開始日小さい申請対象終了日, div.getTxtShinseiTaishoYMD())
                .add(IdocheckMessages.必須設定項目_出力順, div.getJikoFutangakuKeisanKekkaIchiranhyoPanelPublish()).
                build();
    }

    private static enum KokuhorenTorikomiListSpec implements IPredicate<DBC1120011PanelDiv> {

        申請対象開始日小さい申請対象終了日 {
                    @Override
                    public boolean apply(DBC1120011PanelDiv div) {
                        if (!div.getTxtShinseiTaishoYMD().getFromValue().toString().isEmpty()) {
                            return div.getTxtShinseiTaishoYMD().getFromValue().
                            compareTo(div.getTxtShinseiTaishoYMD().getToValue()) < 0;
                        } else {
                            return true;
                        }
                    }
                },
        必須設定項目_出力順 {
                    @Override
                    public boolean apply(DBC1120011PanelDiv div) {
                        return div.getCcdChohyoShutsuryokujun().get出力順ID() != null
                        && div.getCcdChohyoShutsuryokujun().get出力順ID() != 0;
                    }
                };
    }

    private enum IdocheckMessages implements IValidationMessage {

        申請対象開始日小さい申請対象終了日(UrErrorMessages.期間が不正_追加メッセージあり２, 申請対象開始日.toString(),
                申請対象終了日.toString()),
        必須設定項目_出力順(UrErrorMessages.出力順序を指定);
        private final Message message;

        private IdocheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
