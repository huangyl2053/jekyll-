/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1000064;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000064.ShinseishoHakkoDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 基準収入額適用申請書_年次分作成のバリデーションハンドラークラス。
 *
 * @reamsid_L DBC-4630-010 lihang
 */
public class ShinseishoHakkoValidationHandler {

    private final ShinseishoHakkoDiv div;
    private static final RString 処理年度 = new RString("処理年度");
    private static final RString 平成27年度以降 = new RString("平成27年度以降");
    private static final RString 出力順を = new RString("出力順を");
    private static final FlexibleDate 年度 = new FlexibleDate("2015");

    /**
     * コンストラクタです。
     *
     * @param div ShinseishoHakkoDiv
     */
    public ShinseishoHakkoValidationHandler(ShinseishoHakkoDiv div) {
        this.div = div;
    }

    /**
     * get入力チェック。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs get入力チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getTxtShoriNendo().getValue().isBefore(年度)) {
            validPairs.add(new ValidationMessageControlPair(
                    new ShinseishoHakkoValidationHandler.ShinseishoHakkoValidationMessages(
                            UrErrorMessages.項目に対する制約, 処理年度.toString(), 平成27年度以降.toString()),
                    div.getChushutsuJoken2().getTxtShoriNendo()));
        }
        return validPairs;
    }

    private static class ShinseishoHakkoValidationMessages implements IValidationMessage {

        private final Message message;

        ShinseishoHakkoValidationMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
