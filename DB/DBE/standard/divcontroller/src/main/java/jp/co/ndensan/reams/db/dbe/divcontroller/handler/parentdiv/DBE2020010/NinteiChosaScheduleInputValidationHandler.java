/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2020010;

import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020010.NinteiChosaScheduleInputDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 認定調査スケジュール登録10のValidationHandlerクラスです。
 */
public class NinteiChosaScheduleInputValidationHandler {

    private final NinteiChosaScheduleInputDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 認定調査スケジュール情報Div
     */
    public NinteiChosaScheduleInputValidationHandler(NinteiChosaScheduleInputDiv div) {
        this.div = div;
    }

    /**
     * 前回履歴の存在しないチェックです。
     *
     * @return ValidationMessageControlPairs
     */
    public static ValidationMessageControlPairs 前回履歴の存在しないチェック() {

        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(RRVMessages.Validate前回履歴));
        return validationMessages;
    }

    /**
     * スケジュール照会のため保存できませんチェックです。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs スケジュール照会のため保存できませんチェック() {

        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(RRVMessages.Validateスケジュール照会のため保存できません));
        return validationMessages;
    }

    /**
     * 備考必須入力項目チェックです。
     *
     * @param validationMessages ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 備考必須入力項目チェック(ValidationMessageControlPairs validationMessages) {

        validationMessages.add(new ValidationMessageControlPair(RRVMessages.Validate必須入力項目, div.getTxtNinteiChosaBiko()));
        return validationMessages;
    }

    /**
     * 申請者予約があるのチェックです。
     *
     * @param validationMessages ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 申請者予約があるのチェック(ValidationMessageControlPairs validationMessages) {

        validationMessages.add(new ValidationMessageControlPair(RRVMessages.Validate予約状況は仮予約または確定, div.getRadYoyakuJokyo()));
        return validationMessages;
    }

    /**
     * 申請者未指定なので予約状況は未定申請者を指定のチェックです。
     *
     * @param validationMessages ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 申請者未指定なので予約状況は未定申請者を指定のチェック(ValidationMessageControlPairs validationMessages) {

        validationMessages.add(new ValidationMessageControlPair(
                RRVMessages.Validate申請者未指定なので予約状況は未定申請者を指定, div.getRadYoyakuJokyo()));
        return validationMessages;
    }

    private static enum RRVMessages implements IValidationMessage {

        Validate前回履歴(UrErrorMessages.存在しない, "前回履歴"),
        Validate必須入力項目(UrErrorMessages.必須, "備考"),
        Validate予約状況は仮予約または確定(DbeErrorMessages.予約状況は仮予約または確定),
        Validate申請者未指定なので予約状況は未定申請者を指定(DbeErrorMessages.申請者未指定なので予約状況は未定申請者を指定),
        Validateスケジュール照会のため保存できません(DbeErrorMessages.スケジュール照会のため保存不可);

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
