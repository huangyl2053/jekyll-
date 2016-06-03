/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5250001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5250001.HanteiKekkaJohoShutsuryokuDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 判定結果情報出力（介護認定審査会）のチェッククラスです。
 *
 * @reamsid_L DBE-0180-010 xuyannan
 */
public class HanteiKekkaJohoShutsuryokuValidationHandler {

    private final HanteiKekkaJohoShutsuryokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 判定結果情報出力（介護認定審査会）
     */
    public HanteiKekkaJohoShutsuryokuValidationHandler(HanteiKekkaJohoShutsuryokuDiv div) {
        this.div = div;
    }

    /**
     * データ空チェックです。
     *
     * @param validPairs メッセージ
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs データ空チェック(ValidationMessageControlPairs validPairs) {
        if (0 == div.getCcdIShinsakaiIchiranList().get一覧件数()) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.Validate審査会データ空チェック));
        }
        return validPairs;
    }

    /**
     * 未選択チェックです。
     *
     * @param validPairs メッセージ
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 未選択チェック(ValidationMessageControlPairs validPairs) {
        if (div.getCcdIShinsakaiIchiranList().get開催番号List().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.Validate審査会未選択チェック));
        }
        return validPairs;
    }

    private static enum RRVMessages implements IValidationMessage {

        Validate審査会データ空チェック(UrErrorMessages.対象データなし_追加メッセージあり, "審査会"),
        Validate審査会未選択チェック(UrErrorMessages.選択されていない, "審査会");
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
