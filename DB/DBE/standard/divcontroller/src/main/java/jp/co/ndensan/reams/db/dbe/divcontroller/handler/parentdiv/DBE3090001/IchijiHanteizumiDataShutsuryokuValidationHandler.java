/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE3090001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3090001.IchijiHanteizumiDataShutsuryokuDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 一次判定データ出力ValidationHandlerです。
 *
 * @reamsid_L DBE-1610-010 wanghui
 */
public class IchijiHanteizumiDataShutsuryokuValidationHandler {

    private final IchijiHanteizumiDataShutsuryokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 一次判定データ出力Div
     */
    public IchijiHanteizumiDataShutsuryokuValidationHandler(IchijiHanteizumiDataShutsuryokuDiv div) {
        this.div = div;
    }

    /**
     * 申請日が空の場合、エラーとする。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs get申請日必須入力チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        validate申請日(validPairs);
        return validPairs;
    }

    /**
     * 一次判定日が空の場合、エラーとする。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs get一次判定日必須チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        validate一次判定日(validPairs);
        return validPairs;
    }

    /**
     * 申請日の必須入力チェックを実施します。
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs validate申請日(ValidationMessageControlPairs validPairs) {
        if (div.getTxtShinseibi().getFromValue() == null || div.getTxtShinseibi().getToValue() == null) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.Validate最大表示件数の必須入力チェック,
                    div.getTxtShinseibi()));
        }
        return validPairs;
    }

    /**
     * 申請日の必須入力チェックを実施します。
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs validate一次判定日(ValidationMessageControlPairs validPairs) {
        if (div.getTxtIchijiHanteibi().getFromValue() == null || div.getTxtIchijiHanteibi().getToValue() == null) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.Validate最大表示件数の必須入力チェック,
                    div.getTxtIchijiHanteibi()));
        }
        return validPairs;
    }

    /**
     * 申請日の必須入力チェックを実施します。
     *
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs validate一覧未選択チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getDgIchijiHanteiZumi().getSelectedItems().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(IchijiHanteizumiDataShutsuryokuValidationHandler.RRVMessages.Validate結果一覧未選択, div.getDgIchijiHanteiZumi()));
        }
        return validPairs;
    }

    private static enum RRVMessages implements IValidationMessage {

        Validate最大表示件数の必須入力チェック(UrErrorMessages.必須),
        Validate結果一覧未選択(UrErrorMessages.対象行を選択);
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
