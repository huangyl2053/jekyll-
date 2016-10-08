/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0900021;

import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0900021.SinsaSeikyusyoMeisaiPanelDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 審査請求書登録_登録画面のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBU-1080-060 houtianpeng
 */
public class SinsaSeikyusyoMeisaiValidationHandler {

    private final SinsaSeikyusyoMeisaiPanelDiv div;
    private static final RString 追加 = new RString("追加状態");
    private static final RString 修正 = new RString("修正状態");

    /**
     * コンストラクタです。
     *
     * @param div 審査請求書登録_登録Div
     */
    public SinsaSeikyusyoMeisaiValidationHandler(SinsaSeikyusyoMeisaiPanelDiv div) {
        this.div = div;
    }

    /**
     * 保存するボタンを押下するとき、バリデーションチェックを行う。
     *
     * @param 重複チェック 重複チェック
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateForUpdate(boolean 重複チェック) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();

        if (!重複チェック) {

            validPairs.add(new ValidationMessageControlPair(RRVMessages.審査請求届出日));
        }
        return validPairs;
    }

    /**
     * 保存するボタンを押下するとき、完了メッセージを行う。
     *
     * @param 状態 状態
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateForUpdate(RString 状態) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();

        if (追加.equals(状態)) {

            validPairs.add(new ValidationMessageControlPair(RRVMessages.審査請求届出日));
        }
        if (修正.equals(状態)) {

            validPairs.add(new ValidationMessageControlPair(RRVMessages.審査請求届出日));
        }
        return validPairs;
    }

    /**
     * 審査請求書登録エリアの編集チェック処理です。
     *
     * @param 修正後の値 修正後の値
     * @return 判定結果(true:変更あり,false:変更なし)
     */
    public boolean 変更有無チェック(RString 修正後の値) {
        return !修正後の値.equals(DataPassingConverter.deserialize(div.get修正前の値(), RString.class));
    }

    private static enum RRVMessages implements IValidationMessage {

        審査請求届出日(UrErrorMessages.既に存在, "審査請求届出日");
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
