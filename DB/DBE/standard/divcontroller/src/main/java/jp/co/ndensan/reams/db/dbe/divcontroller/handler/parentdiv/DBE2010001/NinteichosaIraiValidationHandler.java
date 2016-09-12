/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2010001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2010001.NinteichosaIraiDiv;
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
 * 完了処理・認定調査依頼のValidationHandlerクラスです。
 *
 * @reamsid_L DBE-0300-010 dingyi
 */
public class NinteichosaIraiValidationHandler {

    private final NinteichosaIraiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 完了処理・認定調査依頼Div
     */
    public NinteichosaIraiValidationHandler(NinteichosaIraiDiv div) {
        this.div = div;
    }

    /**
     * 「一覧を出力する」ボタンを押下する場合、入力チェックを実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 入力チェック_btnDataOutput() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (!(!RString.isNullOrEmpty(div.getCcdTaskList().一覧件数())
                && Integer.parseInt(div.getCcdTaskList().一覧件数().toString()) > 0)) {
            validationMessages.add(new ValidationMessageControlPair(RRVMessages.該当データなし));
        } else if (div.getCcdTaskList().getCheckbox() == null || div.getCcdTaskList().getCheckbox().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(RRVMessages.対象行を選択));
        }
        return validationMessages;
    }

    /**
     * 「調査機関を割付ける(自動)」ボタンを押下する場合、入力チェックを実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 入力チェック_btnIraiAuto() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        List<dgNinteiTaskList_Row> 選択されたデータ = div.getCcdTaskList().getCheckbox();
        if (!(!RString.isNullOrEmpty(div.getCcdTaskList().一覧件数())
                && Integer.parseInt(div.getCcdTaskList().一覧件数().toString()) > 0)) {
            validationMessages.add(new ValidationMessageControlPair(RRVMessages.該当データなし));
        } else if (選択されたデータ == null || 選択されたデータ.isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(RRVMessages.対象行を選択));
        } else {
            if (is異なった保険者(選択されたデータ)) {
                validationMessages.add(new ValidationMessageControlPair(RRVMessages.複数選択不可_保険者));
            }
            if (is委托先非空(選択されたデータ)) {
                validationMessages.add(new ValidationMessageControlPair(RRVMessages.選択必須));
            }
        }
        return validationMessages;
    }

    /**
     * 「調査機関を割付ける(手動)」ボタンを押下する場合、入力チェックを実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 入力チェック_btnWaritukeShudo() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (!(!RString.isNullOrEmpty(div.getCcdTaskList().一覧件数())
                && Integer.parseInt(div.getCcdTaskList().一覧件数().toString()) > 0)) {
            validationMessages.add(new ValidationMessageControlPair(RRVMessages.該当データなし));
        } else if (div.getCcdTaskList().getCheckbox() == null || div.getCcdTaskList().getCheckbox().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(RRVMessages.対象行を選択));
        } else {
            if (is異なった保険者(div.getCcdTaskList().getCheckbox())) {
                validationMessages.add(new ValidationMessageControlPair(RRVMessages.複数選択不可_保険者));
            }
            if (div.getCcdTaskList().getCheckbox().size() > 1) {
                validationMessages.add(new ValidationMessageControlPair(RRVMessages.複数選択不可_認定調査票入手一覧));
            }
        }
        return validationMessages;
    }

    /**
     * 「調査依頼を完了する」ボタンを押下する場合、入力チェックを実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 入力チェック_btnChousaIraiKanryo() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (!(!RString.isNullOrEmpty(div.getCcdTaskList().一覧件数())
                && Integer.parseInt(div.getCcdTaskList().一覧件数().toString()) > 0)) {
            validationMessages.add(new ValidationMessageControlPair(RRVMessages.該当データなし));
        } else if (div.getCcdTaskList().getCheckbox() == null || div.getCcdTaskList().getCheckbox().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(RRVMessages.対象行を選択));
        } else {
            for (dgNinteiTaskList_Row row : div.getCcdTaskList().getCheckbox()) {
                if (RString.isNullOrEmpty(row.getKonkaiChosaItakusaki()) || RString.isNullOrEmpty(row.getKonkaiChosain())) {
                    validationMessages.add(new ValidationMessageControlPair(RRVMessages.理由付き完了不可));
                }
                if (row.getChosaIraiKigen().getValue() == null) {
                    validationMessages.add(new ValidationMessageControlPair(RRVMessages.理由付き完了不可_認定調査期限年月日));
                }
                if (row.getChosaIraishoHakkoDay().getValue() == null) {
                    validationMessages.add(new ValidationMessageControlPair(RRVMessages.理由付き完了不可_依頼書出力年月日));
                }
                if (row.getChosaIraiDataShutsuryokuDay().getValue() == null) {
                    validationMessages.add(new ValidationMessageControlPair(RRVMessages.理由付き完了不可_調査票等出力年月日));
                }
            }
        }
        return validationMessages;
    }

    /**
     * 「調査機関を割付ける(自動)」ボタンを押下する場合、認定調査委託先情報件数チェックを実行します。
     *
     * @param 認定調査委託先情報件数 認定調査委託先情報件数
     * @return ValidationMessageControlPair
     */
    public ValidationMessageControlPair 認定調査委託先情報件数チェック(int 認定調査委託先情報件数) {
        if (認定調査委託先情報件数 == 0) {
            return new ValidationMessageControlPair(RRVMessages.存在しない);
        }
        return null;
    }

    /**
     * 「調査機関を割付ける(自動)」ボタンを押下する場合、割付申請者人数チェックを実行します。
     *
     * @param 調査可能人数 調査可能人数
     * @param 割付済人数 割付済人数
     * @return ValidationMessageControlPair
     */
    public ValidationMessageControlPair 割付申請者人数チェック(int 調査可能人数, int 割付済人数) {
        if (調査可能人数 <= 割付済人数) {
            return new ValidationMessageControlPair(RRVMessages.割付可能人数は0です_割付不可);
        }
        return null;
    }

    private static enum RRVMessages implements IValidationMessage {

        該当データなし(UrErrorMessages.該当データなし),
        対象行を選択(UrErrorMessages.対象行を選択),
        複数選択不可_保険者(DbeErrorMessages.複数選択不可, "保険者"),
        選択必須(DbeErrorMessages.選択必須, "未割付のデータ"),
        存在しない(UrErrorMessages.存在しない, "割付可能な調査委託先"),
        割付可能人数は0です_割付不可(DbeErrorMessages.割付可能人数は0です_割付不可),
        複数選択不可_認定調査票入手一覧(DbeErrorMessages.複数選択不可, "認定調査票入手一覧"),
        理由付き完了不可(DbzErrorMessages.理由付き完了不可, "認定調査依頼先が未確定"),
        理由付き完了不可_認定調査期限年月日(DbzErrorMessages.理由付き完了不可, "認定調査期限年月日が未設定"),
        理由付き完了不可_依頼書出力年月日(DbzErrorMessages.理由付き完了不可, "依頼書出力年月日が未設定"),
        理由付き完了不可_調査票等出力年月日(DbzErrorMessages.理由付き完了不可, "調査票等出力年月日が未設定");

        private final Message message;

        private RRVMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

    private boolean is異なった保険者(List<dgNinteiTaskList_Row> 選択されたデータ) {
        RString 保険者 = RString.EMPTY;
        for (dgNinteiTaskList_Row row : 選択されたデータ) {
            if (!RString.isNullOrEmpty(保険者) && !保険者.equals(row.getHokensha())) {
                return true;
            }
            保険者 = row.getHokensha();
        }
        return false;
    }

    private boolean is委托先非空(List<dgNinteiTaskList_Row> 選択されたデータ) {
        for (dgNinteiTaskList_Row row : 選択されたデータ) {
            if (RString.isNullOrEmpty(row.getKonkaiChosaItakusaki())) {
                return false;
            }
        }
        return true;
    }

}
