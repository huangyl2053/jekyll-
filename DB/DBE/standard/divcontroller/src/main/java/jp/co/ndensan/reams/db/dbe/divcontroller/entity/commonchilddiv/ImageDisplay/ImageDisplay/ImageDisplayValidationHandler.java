/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ImageDisplay.ImageDisplay;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * イメージ情報表示のValidationHandlerクラスです。
 *
 * @reamsid_L DBE-3000-280 jinjue
 */
public class ImageDisplayValidationHandler {

    /**
     * イメージファイル存在チェックを実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs イメージ存在チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(ImageDisplayValidationHandler.ImageValidationMessage.イメージ共有));
        return validationMessages;
    }

    /**
     * 調査票概況イメージファイル存在チェックを実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 調査票概況イメージファイル存在チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(ImageDisplayValidationHandler.ImageValidationMessage.調査票概況));
        return validationMessages;
    }

    /**
     * 主治医意見書イメージファイル存在チェックを実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 主治医意見書イメージファイル存在チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(ImageDisplayValidationHandler.ImageValidationMessage.主治医意見書));
        return validationMessages;
    }

    /**
     * その他資料イメージファイル存在チェックを実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs その他資料イメージファイル存在チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(ImageDisplayValidationHandler.ImageValidationMessage.その他資料));
        return validationMessages;
    }

    private enum ImageValidationMessage implements IValidationMessage {

        イメージ共有(UrErrorMessages.存在しない, "イメージ共有ファイルID"),
        調査票概況(UrErrorMessages.存在しない, "調査票概況のイメージファイル"),
        主治医意見書(UrErrorMessages.存在しない, "主治医意見書のイメージファイル"),
        その他資料(UrErrorMessages.存在しない, "その他資料のイメージファイル");

        private final Message message;

        private ImageValidationMessage(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
