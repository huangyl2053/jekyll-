/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ShobyoIken.ShobyoIken;

import java.util.List;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 共有子Div「ShobyoIken」の抽象ValidationHandlerクラスです。
 *
 */
public class ShobyoIkenValidationHandler {

    private static final RString 追加 = new RString("追加");
    private final ShobyoIkenDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ShobyoIkenDiv
     */
    public ShobyoIkenValidationHandler(ShobyoIkenDiv div) {
        this.div = div;
    }

    /**
     * 確定するボタンを押下するとき、バリデーションチェックを行う。
     *
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs validateForAction() {
        ValidationMessageControlPairs validationMessage = new ValidationMessageControlPairs();
        List<dgGenyin_Row> rowlist = div.getGeninShikkanPanel().getDgGenyin().getDataSource();
        if (追加.equals(div.getGeninShikkanPanel().getGeninShikkanShosai().getJotai())) {
            for (dgGenyin_Row row : rowlist) {
                if (row.getGeninShikkanCode().equals(div.getGeninShikkanPanel().getGeninShikkanShosai().getTxtGeninShikkanCode().getValue())) {
                    validationMessage.add(new ValidationMessageControlPair(IdocheckMessages.validation));
                }
            }
        }
        return validationMessage;
    }

    private static enum IdocheckMessages implements IValidationMessage {

        validation(UrErrorMessages.既に登録済, "原因疾患コード");

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
