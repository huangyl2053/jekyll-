/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2060001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2060001.NinteichosaKekkaNyushuDiv;
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
 * 完了処理・認定調査結果入手のValidationHandlerクラスです。
 *
 * @reamsid_L DBE-0310-010 dingyi
 */
public class NinteichosaKekkaNyushuValidationHandler {

    private final NinteichosaKekkaNyushuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 完了処理・認定調査結果入手Div
     */
    public NinteichosaKekkaNyushuValidationHandler(NinteichosaKekkaNyushuDiv div) {
        this.div = div;
    }

    /**
     * 「一覧を出力する」ボタンを押下する場合、入力チェックを実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 入力チェック_btnChosakekkaOutput() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (!(!RString.isNullOrEmpty(div.getCcdTaskList().一覧件数())
                && Integer.parseInt(div.getCcdTaskList().一覧件数().toString()) > 0)) {
            validationMessages.add(new ValidationMessageControlPair(RRVMessages.データが存在しない));
        } else if (div.getCcdTaskList().getCheckbox() == null || div.getCcdTaskList().getCheckbox().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(RRVMessages.対象行を選択));
        }
        return validationMessages;
    }

    /**
     * 「モバイルデータを取込む」ボタンを押下する場合、入力チェックを実行します。
     *
     * @param 取込み対象データの件数 取込み対象データの件数
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 入力チェック_btnCyosakekkaInput(int 取込み対象データの件数) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (取込み対象データの件数 == 0) {
            validationMessages.add(new ValidationMessageControlPair(RRVMessages.存在しない));
        }
        return validationMessages;
    }

    /**
     * 「調査結果を登録する」ボタンを押下する場合、入力チェックを実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 入力チェック_btnKekkaTouroku() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (!(!RString.isNullOrEmpty(div.getCcdTaskList().一覧件数())
                && Integer.parseInt(div.getCcdTaskList().一覧件数().toString()) > 0)) {
            validationMessages.add(new ValidationMessageControlPair(RRVMessages.データが存在しない));
        } else {
            if (div.getCcdTaskList().getCheckbox() == null || div.getCcdTaskList().getCheckbox().isEmpty()) {
                validationMessages.add(new ValidationMessageControlPair(RRVMessages.対象行を選択));
            } else if (div.getCcdTaskList().getCheckbox().size() > 1) {
                validationMessages.add(new ValidationMessageControlPair(RRVMessages.複数選択不可));
            }
        }
        return validationMessages;
    }

    /**
     * 「調査票入手を完了する」ボタンを押下する場合、入力チェック実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 入力チェック_btnChousaResultKanryo() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (!(!RString.isNullOrEmpty(div.getCcdTaskList().一覧件数())
                && Integer.parseInt(div.getCcdTaskList().一覧件数().toString()) > 0)) {
            validationMessages.add(new ValidationMessageControlPair(RRVMessages.データが存在しない));
        } else if (div.getCcdTaskList().getCheckbox() == null || div.getCcdTaskList().getCheckbox().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(RRVMessages.対象行を選択));
        } else {
            List<dgNinteiTaskList_Row> 選択されたデータ = div.getCcdTaskList().getCheckbox();
            for (dgNinteiTaskList_Row row : 選択されたデータ) {
                if (row.getChosahyoKanryoDay().getValue() == null) {
                    validationMessages.add(new ValidationMessageControlPair(RRVMessages.理由付き完了不可));
                    break;
                }
            }
        }
        return validationMessages;
    }

    private static enum RRVMessages implements IValidationMessage {

        データが存在しない(UrErrorMessages.データが存在しない),
        対象行を選択(UrErrorMessages.対象行を選択),
        複数選択不可(DbeErrorMessages.複数選択不可, "認定調査票入手一覧"),
        理由付き完了不可(DbzErrorMessages.理由付き完了不可, "調査票未入力"),
        存在しない(UrErrorMessages.存在しない, "モバイル取込対象データ");

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
