/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820027;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820027.dgdKinkyujiShiseturyoyo_Row;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)のバリデーションハンドラークラス。
 *
 * @reamsid_L DBC-1030-060 xupeng
 */
public class KinkyujiShisetuRyoyohiPanelValidationHandler {

    private static final RString MSG_緊急時傷病名2 = new RString("緊急時傷病名②");
    private static final RString MSG_緊急時治療開始日2 = new RString("緊急時治療開始日②");
    private static final RString MSG_緊急時傷病名3 = new RString("緊急時傷病名③");
    private static final RString MSG_緊急時治療開始日3 = new RString("緊急時治療開始日③");
    private static final RString MSG_往診日数 = new RString("往診日数");
    private static final RString MSG_往診医療機関名 = new RString("往診医療機関名");
    private static final RString MSG_通院日数 = new RString("通院日数");
    private static final RString MSG_通院医療機関名 = new RString("通院医療機関名");
    private static final RString MSG_緊急時治療管理単位数 = new RString("緊急時治療管理単位数");
    private static final RString MSG_緊急時治療管理日数 = new RString("緊急時治療管理日数");
    private static final RString MSG_緊急時治療管理小計 = new RString("緊急時治療管理小計");
    private static final RString MSG_特定治療合計 = new RString("特定治療合計");

    /**
     * 「申請を保存する」のバリデーションチェック。
     *
     * @param row dgdKinkyujiShiseturyoyo_Row
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 必須チェックValidate(dgdKinkyujiShiseturyoyo_Row row) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if ((row.getDefaultDataName2() == null || row.getDefaultDataName2().isEmpty())
                && row.getDefaultDataName5().getValue() != null) {
            validPairs.add(new ValidationMessageControlPair(KarisanteiIdoFukaHandlerValidationMessages.緊急時傷病名2の入力チェック));
        }
        if ((row.getDefaultDataName2() != null && !row.getDefaultDataName2().isEmpty())
                && row.getDefaultDataName5().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(KarisanteiIdoFukaHandlerValidationMessages.緊急時治療開始日2の入力チェック));
        }
        if ((row.getDefaultDataName3() == null || row.getDefaultDataName3().isEmpty())
                && row.getDefaultDataName6().getValue() != null) {
            validPairs.add(new ValidationMessageControlPair(KarisanteiIdoFukaHandlerValidationMessages.緊急時傷病名3の入力チェック));
        }
        if ((row.getDefaultDataName3() != null && !row.getDefaultDataName3().isEmpty())
                && row.getDefaultDataName6().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(KarisanteiIdoFukaHandlerValidationMessages.緊急時治療開始日3の入力チェック));
        }

        return check往診(row, validPairs);
    }

    private ValidationMessageControlPairs check往診(dgdKinkyujiShiseturyoyo_Row row, ValidationMessageControlPairs validPairs) {
        if (row.getDefaultDataName7().getValue() == null
                && (row.getDefaultDataName8() != null && !row.getDefaultDataName8().isEmpty())) {
            validPairs.add(new ValidationMessageControlPair(KarisanteiIdoFukaHandlerValidationMessages.往診日数の入力チェック));
        }
        if (row.getDefaultDataName7() != null
                && (row.getDefaultDataName8() == null || row.getDefaultDataName8().isEmpty())) {
            validPairs.add(new ValidationMessageControlPair(KarisanteiIdoFukaHandlerValidationMessages.往診医療機関名の入力チェック));
        }

        return check通院(row, validPairs);
    }

    private ValidationMessageControlPairs check通院(dgdKinkyujiShiseturyoyo_Row row, ValidationMessageControlPairs validPairs) {
        if (row.getDefaultDataName9().getValue() == null
                && (row.getDefaultDataName10() != null && !row.getDefaultDataName10().isEmpty())) {
            validPairs.add(new ValidationMessageControlPair(KarisanteiIdoFukaHandlerValidationMessages.通院日数の入力チェック));
        }
        if (row.getDefaultDataName9().getValue() != null
                && (row.getDefaultDataName10() == null || row.getDefaultDataName10().isEmpty())) {
            validPairs.add(new ValidationMessageControlPair(KarisanteiIdoFukaHandlerValidationMessages.通院医療機関名の入力チェック));
        }
        return check緊急時治療管理(row, validPairs);
    }

    private ValidationMessageControlPairs check緊急時治療管理(dgdKinkyujiShiseturyoyo_Row row, ValidationMessageControlPairs validPairs) {
        if (row.getDefaultDataName11().getValue() == null && row.getDefaultDataName12().getValue() != null) {
            validPairs.add(new ValidationMessageControlPair(KarisanteiIdoFukaHandlerValidationMessages.緊急時治療管理単位数の入力チェック));
        }
        if (row.getDefaultDataName11().getValue() != null && row.getDefaultDataName12().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(KarisanteiIdoFukaHandlerValidationMessages.緊急時治療管理日数の入力チェック));
        }
        if (row.getDefaultDataName11().getValue() != null && row.getDefaultDataName12().getValue() != null
                && (row.getDefaultDataName13().getValue() == null || Decimal.ZERO.equals(row.getDefaultDataName13().getValue()))) {
            validPairs.add(new ValidationMessageControlPair(KarisanteiIdoFukaHandlerValidationMessages.緊急時治療管理小計のチェック));
        }
        if ((row.getDefaultDataName15().getValue() != null || row.getDefaultDataName16().getValue() != null
                || row.getDefaultDataName17().getValue() != null || row.getDefaultDataName18().getValue() != null
                || row.getDefaultDataName19().getValue() != null)
                && (row.getDefaultDataName14().getValue() == null || Decimal.ZERO.equals(row.getDefaultDataName14().getValue()))) {
            validPairs.add(new ValidationMessageControlPair(KarisanteiIdoFukaHandlerValidationMessages.特定治療合計のチェック));
        }
        return validPairs;
    }

    private static enum KarisanteiIdoFukaHandlerValidationMessages implements IValidationMessage {

        緊急時傷病名2の入力チェック(UrErrorMessages.未入力, MSG_緊急時傷病名2.toString()),
        緊急時治療開始日2の入力チェック(UrErrorMessages.未入力, MSG_緊急時治療開始日2.toString()),
        緊急時傷病名3の入力チェック(UrErrorMessages.未入力, MSG_緊急時傷病名3.toString()),
        緊急時治療開始日3の入力チェック(UrErrorMessages.未入力, MSG_緊急時治療開始日3.toString()),
        往診日数の入力チェック(UrErrorMessages.未入力, MSG_往診日数.toString()),
        往診医療機関名の入力チェック(UrErrorMessages.未入力, MSG_往診医療機関名.toString()),
        通院日数の入力チェック(UrErrorMessages.未入力, MSG_通院日数.toString()),
        通院医療機関名の入力チェック(UrErrorMessages.未入力, MSG_通院医療機関名.toString()),
        緊急時治療管理単位数の入力チェック(UrErrorMessages.未入力, MSG_緊急時治療管理単位数.toString()),
        緊急時治療管理日数の入力チェック(UrErrorMessages.未入力, MSG_緊急時治療管理日数.toString()),
        緊急時治療管理小計のチェック(UrErrorMessages.未入力, MSG_緊急時治療管理小計.toString()),
        特定治療合計のチェック(UrErrorMessages.未入力, MSG_特定治療合計.toString());

        private final Message message;

        KarisanteiIdoFukaHandlerValidationMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
