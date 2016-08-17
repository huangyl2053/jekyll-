/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0080011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.soufujouhou.SoufuJouhouBusiness;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0080011.SoufuJouhouDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBC0080011_再審査申立送付情報照会のバリデーションクラスです。
 *
 * @reamsid_L DBC-3050-010 zhangzhiming
 */
public class SoufuJouhouValidationHandler {

    private final SoufuJouhouDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public SoufuJouhouValidationHandler(SoufuJouhouDiv div) {
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
            validationMessages.add(new ValidationMessageControlPair(new SoufuJouhouValidationHandler.RRVMessages(
                    UrErrorMessages.必須, "取扱年月")));
        }
        return validationMessages;
    }

    /**
     * 再審査申立書情報を取得します。
     *
     * @param 再審査申立書情報 再審査申立書情報
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 再審査申立書情報(List<SoufuJouhouBusiness> 再審査申立書情報) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (再審査申立書情報.isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(new SoufuJouhouValidationHandler.RRVMessages(
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
