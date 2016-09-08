/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.validations;

import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * {@link TextBoxFlexibleDate}のバリデーションを行うユーティリティです。
 *
 * @author n8178
 */
public final class TextBoxFlexibleDateValidator {

    private TextBoxFlexibleDateValidator() {
    }

    /**
     * 指定の{@link TextBoxFlexibleDate}に暦上日が設定されている、もしくは未入力であるかを検査します。
     * 暦上日もしくは未入力の場合、空の{@link ValidationMessageControlPairs}を返します。
     * 以外の場合は、エラーメッセージが設定された{@link ValidationMessageControlPairs}を返します。
     *
     * @param txtBoxFlexibleDate 検査対象の{@link TextBoxFlexibleDate}
     * @return {@link ValidationMessageControlPairs}
     */
    public static ValidationMessageControlPairs validate暦上日OrEmpty(TextBoxFlexibleDate txtBoxFlexibleDate) {
        Objects.requireNonNull(txtBoxFlexibleDate);
        FlexibleDate date = txtBoxFlexibleDate.getValue();
        if (date.isEmpty()) {
            return new ValidationMessageControlPairs();
        }
        return validate暦上日(txtBoxFlexibleDate);
    }

    /**
     * 指定の{@link TextBoxFlexibleDate}に暦上日が設定されているかを検査します。未入力の場合も暦上日ではないと判断されます。
     * 暦上日の場合、空の{@link ValidationMessageControlPairs}を返します。
     * 以外の場合は、エラーメッセージが設定された{@link ValidationMessageControlPairs}を返します。
     *
     * @param txtBoxFlexibleDate 検査対象の{@link TextBoxFlexibleDate}
     * @return {@link ValidationMessageControlPairs}
     */
    public static ValidationMessageControlPairs validate暦上日(TextBoxFlexibleDate txtBoxFlexibleDate) {
        Objects.requireNonNull(txtBoxFlexibleDate);
        FlexibleDate date = txtBoxFlexibleDate.getValue();
        ValidationMessageControlPairs result = new ValidationMessageControlPairs();
        if (!date.isValid()) {
            result.add(new ValidationMessageControlPair(DbzErrorMessages.暦上日以外を入力, txtBoxFlexibleDate));
        }
        return result;
    }
}
