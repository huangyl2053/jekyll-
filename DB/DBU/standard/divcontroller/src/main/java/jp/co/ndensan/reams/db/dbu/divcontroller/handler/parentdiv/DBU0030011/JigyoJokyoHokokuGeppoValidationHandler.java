/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0030011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.shichosonsentaku.ShichosonSelectorModel;
import jp.co.ndensan.reams.db.dba.business.core.shichosonsentaku.ShichosonSelectorResult;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0030011.JigyoJokyoHokokuGeppoDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 様式別連携情報作成処理です。
 *
 * @reamsid_L DBU-4050-010 suguangjun
 */
public class JigyoJokyoHokokuGeppoValidationHandler {

    private final JigyoJokyoHokokuGeppoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public JigyoJokyoHokokuGeppoValidationHandler(JigyoJokyoHokokuGeppoDiv div) {
        this.div = div;
    }

    /**
     * 未選択チェックです
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 過去報告年月未指定チェック(ValidationMessageControlPairs validPairs) {
        if (RString.isNullOrEmpty(div.getJikkoTanni().getDdlKakoHokokuYM().getSelectedKey())) {
            validPairs.add(new ValidationMessageControlPair(JigyoJokyoHokokuGeppoValidationHandler.JigyoJokyoHokokuMessages.過去報告年月チェック));
        }
        return validPairs;
    }

    /**
     * 未選択チェックです
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 市町村チェック(ValidationMessageControlPairs validPairs) {
        ShichosonSelectorModel model = DataPassingConverter.deserialize(div.getKyuShichoson(), ShichosonSelectorModel.class);
        List<ShichosonSelectorResult> list = new ArrayList<>();
        if (model != null) {
            list = model.getList();
        }
        if (new RString("gappei").equals(div.getJikkoTanni().getRadHokenshaKyuShichoson().getSelectedKey())
                || new RString("koseiShichoson").equals(div.getJikkoTanni().getRadKoikiKoseiShichoson().getSelectedKey())
                && list.isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(JigyoJokyoHokokuGeppoValidationHandler.JigyoJokyoHokokuMessages.市町村チェック));
        }
        return validPairs;
    }

    private static enum JigyoJokyoHokokuMessages implements IValidationMessage {

        過去報告年月チェック(UrErrorMessages.必須項目_追加メッセージあり, "過去報告年月が未選択"),
        市町村チェック(UrErrorMessages.必須項目_追加メッセージあり, "対象市町村が未選択");
        private final Message message;

        private JigyoJokyoHokokuMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
