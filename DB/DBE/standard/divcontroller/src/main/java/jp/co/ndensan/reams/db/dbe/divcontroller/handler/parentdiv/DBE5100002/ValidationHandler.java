/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5100002;

import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5100002.ShinsakaiAutoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5100002.dgShinsakaiIchiran_Row;
import jp.co.ndensan.reams.db.dbz.definition.core.shinsakai.IsGogitaiDummy;
import jp.co.ndensan.reams.db.dbz.definition.core.shinsakai.ShinsakaiShinchokuJokyo;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 審査会自動割付のチェッククラスです。
 *
 * @reamsid_L DBE-1350-030 lizhuoxuan
 */
public class ValidationHandler {

    private final ShinsakaiAutoDiv shinDiv;

    /**
     * コンストラクタです。
     *
     * @param shinDiv ShinsakaiAutoDiv
     */
    public ValidationHandler(ShinsakaiAutoDiv shinDiv) {
        this.shinDiv = shinDiv;
    }

    /**
     * 審査会データ空チェックします。
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 審査会データ空チェック(ValidationMessageControlPairs validPairs) {
        if (shinDiv.getDgShinsakaiIchiran().getDataSource().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.Validate対象者一覧未表示,
                    shinDiv.getDgShinsakaiIchiran()));
        }
        return validPairs;
    }

    /**
     * 審査会未選択チェックします。
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 審査会未選択チェック(ValidationMessageControlPairs validPairs) {
        if (shinDiv.getDgShinsakaiIchiran().getSelectedItems().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.Validate対象者一覧未選択,
                    shinDiv.getDgShinsakaiIchiran()));
        }
        return validPairs;
    }

    /**
     * 審査会開催チェックします。
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 審査会開催チェック(ValidationMessageControlPairs validPairs) {
        for (dgShinsakaiIchiran_Row row : shinDiv.getDgShinsakaiIchiran().getSelectedItems()) {
            if (!ShinsakaiShinchokuJokyo.未開催.get画面表示名称().equals(row.getShinchokuJokyo())
                    && !ShinsakaiShinchokuJokyo.未開催_割付完了.get画面表示名称().equals(row.getShinchokuJokyo())) {
                validPairs.add(new ValidationMessageControlPair(RRVMessages.Validate未開催以外の場合,
                        shinDiv.getDgShinsakaiIchiran()));
                break;
            }
        }
        return validPairs;

    }

    /**
     * ダミー審査会選択不可チェックします。
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs ダミー審査会選択不可(ValidationMessageControlPairs validPairs) {
        for (dgShinsakaiIchiran_Row row : shinDiv.getDgShinsakaiIchiran().getSelectedItems()) {
            if (IsGogitaiDummy.toValue(true).get名称().equals(row.getShinchokuJokyo())) {
                validPairs.add(new ValidationMessageControlPair(RRVMessages.Validateダミーフラグがチェックされた場合,
                        shinDiv.getDgShinsakaiIchiran()));
                break;
            }
        }
        return validPairs;
    }

    private static enum RRVMessages implements IValidationMessage {

        Validate対象者一覧未表示(UrErrorMessages.対象データなし),
        Validate対象者一覧未選択(UrErrorMessages.選択されていない, "審査会"),
        Validate未開催以外の場合(DbeErrorMessages.審査会開催済み),
        Validateダミーフラグがチェックされた場合(DbzErrorMessages.ダミー審査会選択不可);
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
