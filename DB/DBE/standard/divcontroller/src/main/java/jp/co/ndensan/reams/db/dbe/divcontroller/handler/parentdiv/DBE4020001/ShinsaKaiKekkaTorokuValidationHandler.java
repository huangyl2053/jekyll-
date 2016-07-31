/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE4020001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4020001.ShinsaKaiKekkaTorokuDiv;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiTaskList.YokaigoNinteiTaskList.dgNinteiTaskList_Row;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 完了処理・審査会結果登録のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBE-0350-010 linghuhang
 */
public class ShinsaKaiKekkaTorokuValidationHandler {

    private final ShinsaKaiKekkaTorokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 審査会結果登録Div
     */
    public ShinsaKaiKekkaTorokuValidationHandler(ShinsaKaiKekkaTorokuDiv div) {
        this.div = div;
    }

    /**
     * 存在チェックを行う。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 存在チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (new RString("0").equals(div.getCcdTaskList().一覧件数())) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.存在チェック));
        }
        return validPairs;
    }

    /**
     * 選択チェックを行う。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 選択チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getCcdTaskList().getCheckbox() == null || div.getCcdTaskList().getCheckbox().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.対象行を選択チェック));
        }
        return validPairs;
    }

    /**
     * 完了処理事前チェックを行う。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 完了処理事前チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        List<dgNinteiTaskList_Row> 選択データ = div.getCcdTaskList().getCheckbox();
        for (dgNinteiTaskList_Row データ : 選択データ) {
            if (データ.getNijihanteiKekkaToroku().getValue() == null) {
                validPairs.add(new ValidationMessageControlPair(RRVMessages.完了処理事前チェック));
                break;
            }
        }
        return validPairs;
    }

    private static enum RRVMessages implements IValidationMessage {

        存在チェック(UrErrorMessages.該当データなし),
        対象行を選択チェック(UrErrorMessages.対象行を選択),
        完了処理事前チェック(DbzErrorMessages.理由付き完了不可, "審査会結果未確定");
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
