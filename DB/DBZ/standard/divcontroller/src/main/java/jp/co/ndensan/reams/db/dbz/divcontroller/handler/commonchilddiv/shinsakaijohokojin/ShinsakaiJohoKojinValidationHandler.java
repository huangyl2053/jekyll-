/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.shinsakaijohokojin;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinsakaiJohoKojin.ShinsakaiJohoKojin.ShinsakaiJohoKojinDiv;
import jp.co.ndensan.reams.db.dbz.service.core.shinsakaijohokojin.ShinsakaiJohoKojinFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 共有子Div「ShinsakaiJohoKojin」の抽象ValidationHandlerクラスです。
 */
public class ShinsakaiJohoKojinValidationHandler {

    private final ShinsakaiJohoKojinDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ShinsakaiJohoKojinDiv
     */
    public ShinsakaiJohoKojinValidationHandler(ShinsakaiJohoKojinDiv div) {
        this.div = div;
    }

    /**
     * 画面項目の初期化を行するとき、バリデーションチェックを行う。
     *
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs validateForAction() {
        ValidationMessageControlPairs validationMessage = new ValidationMessageControlPairs();
        if (ShinsakaiJohoKojinFinder.createInstance().審査会未割当チェック(DataPassingConverter.
                deserialize(div.getHdnShinseishoKanriNo(), ShinseishoKanriNo.class)) == 0) {
            validationMessage.add(new ValidationMessageControlPair(IdocheckMessages.審査会未割当));
        }
        return validationMessage;
    }

    private static enum IdocheckMessages implements IValidationMessage {

        //TODO QA:817 DbErrorMessages.審査会未割当 存在しない
        審査会未割当(UrErrorMessages.データが存在しない);

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
