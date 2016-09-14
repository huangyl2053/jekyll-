/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA7010001;

import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho.HizukeChushutsuKubun;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA7010001.DvHihokenshaDaichoParamDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 汎用リスト被保険者台帳のクラスです。
 *
 * @reamsid_L DBA-1610-010 linghuhang
 */
public class DvHihokenshaDaichoParamDivValidationHandler {

    private final DvHihokenshaDaichoParamDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 汎用リスト被保険者台帳Div
     */
    public DvHihokenshaDaichoParamDivValidationHandler(DvHihokenshaDaichoParamDiv div) {
        this.div = div;
    }

    /**
     * 実行するボタンを押下するとき、バリデーションチェックを行う。
     *
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs validateForAction() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (HizukeChushutsuKubun.基準日.getコード().equals(div.getRadChushutsuKijunBi().getSelectedKey())
            && div.getTxtKijunDate().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(IdocheckMessages.Validate日付必須, div.getTxtKijunDate()));
        }
        if (HizukeChushutsuKubun.範囲.getコード().equals(div.getRadChushutsuHani().getSelectedKey())
            && div.getTxtChushutsuHani() != null
            && div.getTxtChushutsuHani().getFromValue() != null
            && div.getTxtChushutsuHani().getToValue() != null
            && div.getTxtChushutsuHani().getToValue().isBefore(div.getTxtChushutsuHani().getFromValue())) {
            validPairs.add(new ValidationMessageControlPair(IdocheckMessages.Validate日付不正, div.getTxtChushutsuHani()));
        }
        return validPairs;
    }

    private static enum IdocheckMessages implements IValidationMessage {

        Validate日付必須(UrErrorMessages.必須, "基準日"),
        Validate日付不正(UrErrorMessages.終了日が開始日以前);
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
