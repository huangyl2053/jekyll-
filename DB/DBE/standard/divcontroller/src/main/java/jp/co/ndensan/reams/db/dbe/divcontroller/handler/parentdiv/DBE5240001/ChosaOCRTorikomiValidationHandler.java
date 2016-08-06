/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5240001;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 介護認定審査会審査結果登録（OCR)クラスです。
 *
 * @reamsid_L DBE-1560-010 suguangjun
 */
public class ChosaOCRTorikomiValidationHandler {

    /**
     * コンストラクタです。
     *
     */
    public ChosaOCRTorikomiValidationHandler() {
    }

    /**
     * 一覧データの存在チェックを行う。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs check一覧データの存在() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(new ChosaOCRTorikomiValidationHandler.CheckMessages(UrErrorMessages.該当データなし)));
        return validationMessages;
    }

    /**
     * 介護認定審査会審査結果登録一覧対象未選択チェックを行う。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs check一覧対象未選択() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(new ChosaOCRTorikomiValidationHandler.CheckMessages(UrErrorMessages.対象行を選択)));
        return validationMessages;
    }

    private static class CheckMessages implements IValidationMessage {

        private final Message message;

        public CheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
