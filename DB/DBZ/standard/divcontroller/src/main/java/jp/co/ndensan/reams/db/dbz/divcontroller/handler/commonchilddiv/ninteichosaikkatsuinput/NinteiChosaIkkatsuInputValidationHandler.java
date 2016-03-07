/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.ninteichosaikkatsuinput;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiChosaIkkatsuInput.NinteiChosaIkkatsuInput.NinteiChosaIkkatsuInputDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 共有子Div「NinteiChosaIkkatsuInput」の抽象ValidationHandlerクラスです。
 *
 */
public class NinteiChosaIkkatsuInputValidationHandler {

    private final NinteiChosaIkkatsuInputDiv div;

    /**
     * コンストラクタです。
     *
     * @param div NinteiChosaIkkatsuInputDiv
     */
    public NinteiChosaIkkatsuInputValidationHandler(NinteiChosaIkkatsuInputDiv div) {
        this.div = div;
    }

    /**
     * 確認するボタンを押下するとき、バリデーションチェックを行う。
     *
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs validateForAction() {
        ValidationMessageControlPairs validationMessage = new ValidationMessageControlPairs();
        if (div.getChkDay().getSelectedItems().isEmpty()) {
            validationMessage.add(new ValidationMessageControlPair(IdocheckMessages.validation曜日));
        }
        RString 調査スケジュール最大時間枠 = BusinessConfig.get(ConfigNameDBE.調査スケジュール最大時間枠, SubGyomuCode.DBE認定支援);
        if (!調査スケジュール最大時間枠.isNullOrEmpty()) {
            List<RString> list = new ArrayList<>();
            list.add(div.getChkJikanwaku1().getSelectedKeys().get(0));
            list.add(div.getChkJikanwaku2().getSelectedKeys().get(0));
            list.add(div.getChkJikanwaku3().getSelectedKeys().get(0));
            list.add(div.getChkJikanwaku4().getSelectedKeys().get(0));
            list.add(div.getChkJikanwaku5().getSelectedKeys().get(0));
            list.add(div.getChkJikanwaku6().getSelectedKeys().get(0));
            list.add(div.getChkJikanwaku7().getSelectedKeys().get(0));
            list.add(div.getChkJikanwaku8().getSelectedKeys().get(0));
            list.add(div.getChkJikanwaku9().getSelectedKeys().get(0));
            list.add(div.getChkJikanwaku10().getSelectedKeys().get(0));
            if (list.isEmpty()) {
                validationMessage.add(new ValidationMessageControlPair(IdocheckMessages.validation時間枠));
            }
        }
        return validationMessage;
    }

    private static enum IdocheckMessages implements IValidationMessage {

        validation曜日(UrErrorMessages.必須項目_追加メッセージあり, "曜日"),
        validation時間枠(UrErrorMessages.選択されていない, "時間枠");

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
