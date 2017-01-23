/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2040001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2040001.ShujiiIkenshoIraiTaishoIchiranDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2040001.dgNinteiTaskList_Row;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 完了処理・主治医意見書依頼のValidationHandlerクラスです。
 *
 * @reamsid_L DBE-0320-010 lishengli
 */
public class ShujiiIkenshoIraiTaishoIchiranValidationHandler {

    private final ShujiiIkenshoIraiTaishoIchiranDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ShujiiIkenshoIraiTaishoIchiranDiv
     */
    public ShujiiIkenshoIraiTaishoIchiranValidationHandler(ShujiiIkenshoIraiTaishoIchiranDiv div) {
        this.div = div;
    }

    /**
     * 「一覧を出力する」ボタンクリック時のバリデーションチェックです。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateBtnYitiranSyuturyokuClick() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (div.getDgNinteiTaskList().getDataSource() == null || div.getDgNinteiTaskList().getDataSource().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(ValidationMessages.該当データなし));
        } else if (div.getDgNinteiTaskList().getSelectedItems() == null || div.getDgNinteiTaskList().getSelectedItems().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(ValidationMessages.対象行を選択));
        }
        return validationMessages;
    }

    /**
     * 「依頼書等を印刷する」ボタンクリック時のバリデーションチェックです。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateBtnIraishoToOutputClick() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (div.getDgNinteiTaskList().getDataSource() == null || div.getDgNinteiTaskList().getDataSource().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(ValidationMessages.該当データなし));
        } else if (div.getDgNinteiTaskList().getSelectedItems() == null || div.getDgNinteiTaskList().getSelectedItems().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(ValidationMessages.対象行を選択));
        } else {
            List<dgNinteiTaskList_Row> selected = div.getDgNinteiTaskList().getSelectedItems();
            for (dgNinteiTaskList_Row row : selected) {
                if (row.getIkenshoIraiDay().getValue() == null) {
                    validationMessages.add(new ValidationMessageControlPair(ValidationMessages.医療機関_主治医未割付));
                    break;
                }
            }
        }
        return validationMessages;
    }

    /**
     * 「意見書作成を依頼する」ボタンクリック時のバリデーションチェックです。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateBtnIraisuruClick() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (div.getDgNinteiTaskList().getDataSource() == null || div.getDgNinteiTaskList().getDataSource().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(ValidationMessages.該当データなし));
        } else if (div.getDgNinteiTaskList().getSelectedItems() == null || div.getDgNinteiTaskList().getSelectedItems().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(ValidationMessages.対象行を選択));
        } else {
            if (is異なった保険者(div.getDgNinteiTaskList().getSelectedItems())) {
                validationMessages.add(new ValidationMessageControlPair(ValidationMessages.複数選択不可_保険者));
            }
        }
        return validationMessages;
    }

    /**
     * 「依頼する」ボタンクリック時のバリデーションチェックです。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateBtnIraiKakuteiClick() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (RString.isNullOrEmpty(div.getCcdShujiiInput().getTxtShujiiCode().getValue())) {
            validationMessages.add(new ValidationMessageControlPair(ValidationMessages.主治医入力必須));
        }
        return validationMessages;
    }

    /**
     * 「意見書依頼を保存する」ボタンクリック時のバリデーションチェックです。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateBtnUpdateClick() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        List<dgNinteiTaskList_Row> changedRowList = new ArrayList<>();
        for (dgNinteiTaskList_Row row : div.getDgNinteiTaskList().getDataSource()) {
            if (row.getRowState().equals(RowState.Modified)) {
                changedRowList.add(row);
            }
        }
        if (changedRowList.isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(ValidationMessages.該当データなし));
        }
        return validationMessages;
    }

    /**
     * 「意見書依頼を完了する」ボタンクリック時のバリデーションチェックです。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateBtnChousaIraiKanryoClick() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (div.getDgNinteiTaskList().getDataSource() == null || div.getDgNinteiTaskList().getDataSource().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(ValidationMessages.該当データなし));
        } else if (div.getDgNinteiTaskList().getSelectedItems() == null || div.getDgNinteiTaskList().getSelectedItems().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(ValidationMessages.対象行を選択));
        } else {
            for (dgNinteiTaskList_Row row : div.getDgNinteiTaskList().getSelectedItems()) {
                if (RString.isNullOrEmpty(row.getKonkaiShujiiIryokikan()) || RString.isNullOrEmpty(row.getKonkaiShujii())) {
                    validationMessages.add(new ValidationMessageControlPair(ValidationMessages.主治医意見書作成依頼一覧選択行の完了処理事前チェック));
                }
                if (row.getIkenshoIraiDay().getValue() == null) {
                    validationMessages.add(new ValidationMessageControlPair(ValidationMessages.依頼日が未確定の完了必須チェック));
                }
                if (row.getIkenshoIraiIkenshoShutsuryokuDay().getValue() == null) {
                    validationMessages.add(new ValidationMessageControlPair(ValidationMessages.意見書書発行日が未確定の完了必須チェック));
                }
                if (row.getIkenshoIraiIraishoHakkoDay().getValue() == null) {
                    validationMessages.add(new ValidationMessageControlPair(ValidationMessages.意見書出力年月日が未確定の完了必須チェック));
                }
            }
        }
        return validationMessages;
    }

    private static enum ValidationMessages implements IValidationMessage {

        該当データなし(UrErrorMessages.該当データなし),
        対象行を選択(UrErrorMessages.対象行を選択),
        主治医意見書作成依頼一覧選択行の完了処理事前チェック(DbzErrorMessages.理由付き完了不可, "意見書作成依頼先が未確定"),
        依頼期限が未確定の完了必須チェック(DbzErrorMessages.理由付き完了不可,
                "依頼期限が未確定"),
        依頼日が未確定の完了必須チェック(DbzErrorMessages.理由付き完了不可,
                "依頼日が未確定"),
        意見書書発行日が未確定の完了必須チェック(DbzErrorMessages.理由付き完了不可,
                "意見書書発行日が未確定"),
        意見書出力年月日が未確定の完了必須チェック(DbzErrorMessages.理由付き完了不可,
                "意見書出力年月日が未確定"),
        医療機関_主治医未割付(DbeErrorMessages.帳票印刷不可, "医療機関・主治医が割りつけられていない"),
        複数選択不可_保険者(DbeErrorMessages.複数選択不可, "保険者"),
        主治医入力必須(UrErrorMessages.必須, "主治医");

        private final Message message;

        private ValidationMessages(IMessageGettable message, String... replacements) {
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
}
