/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0070011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.sofujoho.SofujohoBusiness;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 過誤申立送付情報照会のバリデーションクラスです。
 *
 * @reamsid_L DBC-2950-010 jinjue
 */
public class SofujohoValidationHandler {

    private final SofujohoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public SofujohoValidationHandler(SofujohoDiv div) {
        this.div = div;
    }

    /**
     * 取扱年月未入力チェック実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 取扱年月未入力Check() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (div.getTxtSofuYM().getValue() == null) {
            validationMessages.add(new ValidationMessageControlPair(new SofujohoValidationHandler.RRVMessages(
                    UrErrorMessages.必須, "取扱年月")));
        }
        return validationMessages;
    }

    /**
     * 過誤申立送付情報照会を取得します。
     *
     * @param 過誤申立送付情報照会 過誤申立送付情報照会
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 過誤申立送付情報照会(List<SofujohoBusiness> 過誤申立送付情報照会) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (過誤申立送付情報照会.isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(new SofujohoValidationHandler.RRVMessages(
                    UrErrorMessages.データが存在しない)));
        }
        return validationMessages;
    }

    private static final class RRVMessages implements IValidationMessage {

        private final Message message;

        private RRVMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
