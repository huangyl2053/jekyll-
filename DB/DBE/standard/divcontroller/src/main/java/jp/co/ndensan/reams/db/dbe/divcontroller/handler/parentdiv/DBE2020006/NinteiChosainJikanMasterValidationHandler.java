/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2020006;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020006.NinteiChosainJikanMasterDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 認定調査スケジュール登録6のバリデーションハンドラークラスです。
 */
public class NinteiChosainJikanMasterValidationHandler {

    private final NinteiChosainJikanMasterDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 認定調査スケジュール登録6Div
     */
    public NinteiChosainJikanMasterValidationHandler(NinteiChosainJikanMasterDiv div) {
        this.div = div;
    }

    /**
     * 「設定年月の時間枠を検索する」ボタンを押下するとき、バリデーションチェックを行う。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateForSearch() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getDdlTaishoChiku().getSelectedKey() == null
                || div.getDdlTaishoChiku().getSelectedKey().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.地区リストチェック));
        }
        return validPairs;
    }

    /**
     * 「登録する」ボタンを押下するとき、バリデーションチェックを行う。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateForCreate() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getMainPanel().getTxtBiko().getValue() == null
                || div.getMainPanel().getTxtBiko().getValue().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.備考欄チェック));
        }
        return validPairs;
    }

    /**
     * 「削除する」ボタンを押下するとき、バリデーションチェックを行う。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateForDelete() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getMainPanel().getTxtBiko().getValue() == null
                || div.getMainPanel().getTxtBiko().getValue().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.備考欄チェック));
        }
        return validPairs;
    }

    /**
     * 「保存する」ボタンを押下するとき、バリデーションチェックを行う。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateForSave() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        // TODO　凌護行 前前排他制限のPKが無し、Redmine#78243回答まち、2016/03/08
        LockingKey lockingKey = new LockingKey(new RString("ShikakuShutokuJogaishaToroku"));
        if (!RealInitialLocker.tryGetLock(lockingKey)) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.前排他制御チェック));
        }
        return validPairs;
    }

    private static enum RRVMessages implements IValidationMessage {

        地区リストチェック(UrErrorMessages.選択されていない, "地区"),
        備考欄チェック(UrErrorMessages.必須, "備考"),
        前排他制御チェック(UrErrorMessages.排他_バッチ実行中で更新不可);
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
