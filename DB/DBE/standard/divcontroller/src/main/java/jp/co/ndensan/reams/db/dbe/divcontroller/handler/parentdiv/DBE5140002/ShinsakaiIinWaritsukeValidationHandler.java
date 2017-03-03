/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5140002;

import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5140002.ShinsakaiIinWaritsukeDiv;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 介護認定審査会開催予定登録のバリデーションチェッククラスです。
 *
 * @reamsid_L DBE-0130-020 xuyannan
 */
public class ShinsakaiIinWaritsukeValidationHandler {

    private final ShinsakaiIinWaritsukeDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 介護認定審査会開催予定登録Div
     */
    public ShinsakaiIinWaritsukeValidationHandler(ShinsakaiIinWaritsukeDiv div) {
        this.div = div;
    }

    /**
     * 「構成一覧から解除する」ボタンを押下するとき、バリデーションチェックを行う。
     *
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs validateForKaijoBtn() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getDgShinsakaiIinKoseiIchiran().getDataSource().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(
                    IdocheckMessages.Validate審査会委員構成一覧データなし, div.getDgShinsakaiIinKoseiIchiran()));
        } else if (div.getDgShinsakaiIinKoseiIchiran().getSelectedItems().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(
                    IdocheckMessages.Validate未選択, div.getDgShinsakaiIinKoseiIchiran()));
        }
        return validPairs;
    }

    /**
     * 「構成一覧に割り付ける」ボタンを押下するとき、バリデーションチェックを行う。
     *
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs validateForWaritukeruBtn() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getDgShinsakaiIinIchiran().getDataSource().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(
                    IdocheckMessages.Validate審査会委員一覧データなし, div.getDgShinsakaiIinIchiran()));
        } else if (div.getDgShinsakaiIinIchiran().getSelectedItems().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(
                    IdocheckMessages.Validate未選択, div.getDgShinsakaiIinIchiran()));
        }
        return validPairs;
    }

    /**
     * 「全体を表示する」ボタンを押下するとき、バリデーションチェックを行う。
     *
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs validateForAllDisplayBtn() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getTxtKijunYMD().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(
                    IdocheckMessages.Validate全体表示不可, div.getTxtKijunYMD()));
        }
        return validPairs;
    }

    /**
     * 「保存する」ボタンを押下するとき、バリデーションチェックを行う。
     *
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs validateForHozonnBtn() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getDgShinsakaiIinKoseiIchiran().getDataSource().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(
                    IdocheckMessages.Validate審査会委員構成一覧データなし, div.getDgShinsakaiIinKoseiIchiran()));
        }
        return validPairs;
    }

    private static enum IdocheckMessages implements IValidationMessage {

        Validate審査会委員構成一覧データなし(UrErrorMessages.対象データなし_追加メッセージあり, "審査会委員構成一覧"),
        Validate未選択(UrErrorMessages.選択されていない, "審査会委員"),
        Validate審査会委員一覧データなし(UrErrorMessages.対象データなし_追加メッセージあり, "審査会委員一覧"),
        Validate一覧は少なくとも5人(DbeErrorMessages.審査会委員構成一覧は少なくとも5人),
        Validate全体表示不可(DbzErrorMessages.実行不可, "基準日が未入力", "全体を表示");
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
