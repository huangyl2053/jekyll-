/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2800011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2800011.JukyushaTotsugoIraiJohoSakuseiDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBC2800011_受給者突合依頼情報作成ValidationHandlerクラスです。
 *
 * @reamsid_L DBC-2750-010 xuyongchao
 */
public class JukyushaTotsugoIraiValidationHandler {

    private static final RString RSTRING_1 = new RString("1");
    private static final RString RSTRING_2 = new RString("2");
    private static final RString RSTRING_3 = new RString("3");
    private static final RString RSTRING_4 = new RString("4");
    private final JukyushaTotsugoIraiJohoSakuseiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public JukyushaTotsugoIraiValidationHandler(JukyushaTotsugoIraiJohoSakuseiDiv div) {
        this.div = div;
    }

    /**
     * 認定年月の必須チェックです
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 認定年月チェック(ValidationMessageControlPairs validPairs) {
        if ((RSTRING_1.equals(div.getDdlChushutsuKubun().getSelectedKey())
                || RSTRING_2.equals(div.getDdlChushutsuKubun().getSelectedKey())) && (div.getTxtNinteiYM().getValue() == null)) {
            validPairs.add(new ValidationMessageControlPair(JukyushaTotsugoIraiMessages.認定年月チェック));
        }
        return validPairs;
    }

    /**
     * 対象開始年月の必須チェックです
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 対象開始年月チェック(ValidationMessageControlPairs validPairs) {
        if ((RSTRING_3.equals(div.getDdlChushutsuKubun().getSelectedKey())
                || RSTRING_4.equals(div.getDdlChushutsuKubun().getSelectedKey())) && (div.getTxtTaishoYM().getFromValue() == null)) {
            validPairs.add(new ValidationMessageControlPair(JukyushaTotsugoIraiMessages.対象開始年月チェック));
        }
        return validPairs;
    }

    /**
     * 対象終了年月の必須チェックです
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 対象終了年月チェック(ValidationMessageControlPairs validPairs) {
        if ((RSTRING_3.equals(div.getDdlChushutsuKubun().getSelectedKey())
                || RSTRING_4.equals(div.getDdlChushutsuKubun().getSelectedKey())) && (div.getTxtTaishoYM().getToValue() == null)) {
            validPairs.add(new ValidationMessageControlPair(JukyushaTotsugoIraiMessages.対象終了年月チェック));
        }
        return validPairs;
    }

    private static enum JukyushaTotsugoIraiMessages implements IValidationMessage {

        認定年月チェック(UrErrorMessages.必須項目_追加メッセージあり, "認定年月"),
        対象開始年月チェック(UrErrorMessages.必須項目_追加メッセージあり, "対象開始年月"),
        対象終了年月チェック(UrErrorMessages.必須項目_追加メッセージあり, "対象終了年月");

        private final Message message;

        private JukyushaTotsugoIraiMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
