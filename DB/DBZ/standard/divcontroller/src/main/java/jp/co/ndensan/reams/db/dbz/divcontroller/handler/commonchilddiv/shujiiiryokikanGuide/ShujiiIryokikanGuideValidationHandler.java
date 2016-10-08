/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//CHECKSTYLE IGNORE PackageName FOR NEXT 1 LINES
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.shujiiiryokikanGuide;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShujiiIryokikanGuide.ShujiiIryokikanGuide.ShujiiIryokikanGuideDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridCellBgColor;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 主治医医療機関＆主治医ガイドのバリデーションチェッククラスです。
 *
 * @reamsid_L DBZ-1300-130 xuyannan
 */
public class ShujiiIryokikanGuideValidationHandler {

    private final ShujiiIryokikanGuideDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public ShujiiIryokikanGuideValidationHandler(ShujiiIryokikanGuideDiv div) {
        this.div = div;
    }

    /**
     * 「検索する」ボタンを押下するとき、バリデーションチェックを行う。
     *
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs validateForMaxKensu() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getTxtMaxKensu().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(
                    IdocheckMessages.Validate必須, div.getTxtMaxKensu()));
        }
        return validPairs;
    }

    /**
     * 選択ボタンを押下するとき、バリデーションチェックを行う。
     *
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs validateForSelectbtn() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (DataGridCellBgColor.bgColorGray.equals(
                div.getDgKensakuKekkaIchiran().getClickedItem().getCellBgColor("iryoKikanJokyo"))) {
            validPairs.add(new ValidationMessageControlPair(
                    IdocheckMessages.Validate選択行が不正, div.getDgKensakuKekkaIchiran()));
        }
        return validPairs;
    }

    private static enum IdocheckMessages implements IValidationMessage {

        Validate必須(UrErrorMessages.必須, "最大表示件数"),
        Validate選択行が不正(UrErrorMessages.選択行が不正);
        private final Message message;

        private IdocheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
