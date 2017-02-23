/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2010001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2010001.NinteichosaIraiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2010001.dgNinteiTaskList_Row;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.definition.enumeratedtype.message.UzErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 完了処理・認定調査依頼のValidationHandlerクラスです。
 *
 * @reamsid_L DBE-0300-010 dingyi
 */
public class NinteichosaIraiValidationHandler {

    private final NinteichosaIraiDiv div;
    private static final RString 修正 = new RString("Modified");
    private static final int 該当なし = 0;

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
        if (div.getDgNinteiTaskList().getDataSource() == null || div.getDgNinteiTaskList().getDataSource().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(RRVMessages.該当データなし));
        } else if (div.getDgNinteiTaskList().getSelectedItems() == null || div.getDgNinteiTaskList().getSelectedItems().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(RRVMessages.対象行を選択));
        }
        return validationMessages;
    }

    /**
     * 「依頼書等を印刷する」ボタンを押下する場合、入力チェックを実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 入力チェック_btnTaOutput() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (div.getDgNinteiTaskList().getDataSource() == null || div.getDgNinteiTaskList().getDataSource().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(RRVMessages.該当データなし));
        } else if (div.getDgNinteiTaskList().getSelectedItems() == null || div.getDgNinteiTaskList().getSelectedItems().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(RRVMessages.対象行を選択));
        } else {
            List<dgNinteiTaskList_Row> selected = div.getDgNinteiTaskList().getSelectedItems();
            for (dgNinteiTaskList_Row row : selected) {
                if (row.getChosaIraiKubun() == null || row.getChosaIraiKubun().isEmpty() || row.getRowState().equals(RowState.Modified)) {
                    validationMessages.add(new ValidationMessageControlPair(RRVMessages.調査依頼未保存のため印刷不可));
                    break;
                }
            }
        }
        return validationMessages;
    }

    /**
     * 「モバイル用データを出力する」ボタンを押下する場合、入力チェックを実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 入力チェック_btnChosainDataOutput(boolean 未保存データ有) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();

        if (div.getDgNinteiTaskList().getDataSource() == null || div.getDgNinteiTaskList().getDataSource().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(RRVMessages.該当データなし));
        } else if (div.getDgNinteiTaskList().getSelectedItems() == null || div.getDgNinteiTaskList().getSelectedItems().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(RRVMessages.対象行を選択));
        } else {
            List<dgNinteiTaskList_Row> selected = div.getDgNinteiTaskList().getSelectedItems();
            RString chosaItakusaki = selected.get(0).getKonkaiChosaItakusaki();
            RString hokenshaCode = selected.get(0).getHokenshaCode();

            for (dgNinteiTaskList_Row row : selected) {
                if (row.getChosaIraiKubun() == null || row.getChosaIraiKubun().isEmpty()) {
                    validationMessages.add(new ValidationMessageControlPair(RRVMessages.認定調査依頼未割付));
                    break;
                }

                if (row.getKonkaiChosaItakusaki() == null || row.getKonkaiChosaItakusaki().isEmpty()) {
                    validationMessages.add(new ValidationMessageControlPair(RRVMessages.委託先未設定));
                    break;
                } else if (!hokenshaCode.equals(row.getHokenshaCode())) {
                    validationMessages.add(new ValidationMessageControlPair(RRVMessages.保険者が同一ではない));
                    break;
                } else if (!chosaItakusaki.equals(row.getKonkaiChosaItakusaki())) {
                    validationMessages.add(new ValidationMessageControlPair(RRVMessages.委託先が同一ではない));
                    break;
                }
            }
        }
        if (未保存データ有) {
            validationMessages.add(new ValidationMessageControlPair(RRVMessages.未保存データあり));
        }

        return validationMessages;
    }

    /**
     * 「調査機関を割付ける(自動)」ボタンを押下する場合、入力チェックを実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 入力チェック_btnJidoWaritsuke() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        List<dgNinteiTaskList_Row> 選択されたデータ = div.getDgNinteiTaskList().getSelectedItems();
        if (div.getDgNinteiTaskList().getDataSource() == null || div.getDgNinteiTaskList().getDataSource().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(RRVMessages.該当データなし));
        } else if (選択されたデータ == null || 選択されたデータ.isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(RRVMessages.対象行を選択));
        } else {
            if (is異なった保険者(選択されたデータ)) {
                validationMessages.add(new ValidationMessageControlPair(RRVMessages.複数選択不可_保険者));
            }
            if (is割付済申請者選択(選択されたデータ)) {
                validationMessages.add(new ValidationMessageControlPair(RRVMessages.割付済申請者選択不可));
            }
        }
        return validationMessages;
    }

    /**
     * 「調査機関を割付ける（手動）」ボタンを押下する場合、入力チェックを実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 入力チェック_btnShudoWaritsuke() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();

        if (div.getDgNinteiTaskList().getDataSource() == null || div.getDgNinteiTaskList().getDataSource().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(RRVMessages.該当データなし));
        } else if (div.getDgNinteiTaskList().getSelectedItems() == null || div.getDgNinteiTaskList().getSelectedItems().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(RRVMessages.対象行を選択));
        } else {
            if (is異なった保険者(div.getDgNinteiTaskList().getSelectedItems())) {
                validationMessages.add(new ValidationMessageControlPair(RRVMessages.複数選択不可_保険者));
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
        if (div.getDgNinteiTaskList().getDataSource() == null || div.getDgNinteiTaskList().getDataSource().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(RRVMessages.該当データなし));
        } else if (div.getDgNinteiTaskList().getSelectedItems() == null || div.getDgNinteiTaskList().getSelectedItems().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(RRVMessages.対象行を選択));
        } else {
            for (dgNinteiTaskList_Row row : div.getDgNinteiTaskList().getSelectedItems()) {
                if (RString.isNullOrEmpty(row.getKonkaiChosaItakusaki())) {
                    validationMessages.add(new ValidationMessageControlPair(RRVMessages.理由付き完了不可));
                }
                if (row.getNinteichosaIraiYmd().getValue() == null) {
                    validationMessages.add(new ValidationMessageControlPair(RRVMessages.理由付き完了不可_認定調査依頼年月日));
                }
                if (row.getChousahyoOutput().getValue() == null) {
                    validationMessages.add(new ValidationMessageControlPair(RRVMessages.理由付き完了不可_調査票等出力年月日));
                }
            }
        }
        return validationMessages;
    }

    /**
     * 「調査依頼を保存する」ボタンを押下する場合、入力チェックを実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 入力チェック_btnUpdate() {
        List<dgNinteiTaskList_Row> ModifyList = new ArrayList<>();
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (div.getDgNinteiTaskList().getDataSource() == null || div.getDgNinteiTaskList().getDataSource().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(RRVMessages.該当データなし));
        } else {

            for (dgNinteiTaskList_Row row : div.getDgNinteiTaskList().getDataSource()) {
                RString 状態 = new RString(row.getRowState().toString());
                if (状態.equals(修正)) {
                    ModifyList.add(row);
                }
            }
            for (dgNinteiTaskList_Row row : ModifyList) {
                if (row.getChosaIraiKubun() == null || row.getChosaIraiKubun().isEmpty()) {
                    validationMessages.add(new ValidationMessageControlPair(RRVMessages.認定調査依頼未割付));
                    break;
                }
            }
            if (ModifyList.size() == 該当なし) {
                validationMessages.add(new ValidationMessageControlPair(RRVMessages.未編集));
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

    /**
     * 最大表示件数が正しい値かチェックします。
     *
     * @return メッセージ
     */
    public ValidationMessageControlPairs check最大表示件数() {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        Decimal 入力値 = div.getTxtMaxCount().getValue();
        if (入力値 == null) {
            pairs.add(new ValidationMessageControlPair(new ValidateMessage(UzErrorMessages.入力値が不正), div.getTxtMaxCount()));
        }
        return pairs;
    }

    /**
     * 「モバイルデータの出力を実行する」ボタンを押下する場合、未保存データがあるかチェックします。
     *
     * @return ValidationMessageControlPair
     */
    public ValidationMessageControlPair check未保存データ() {
        return new ValidationMessageControlPair(RRVMessages.未保存データあり);
    }

    private static enum RRVMessages implements IValidationMessage {

        該当データなし(UrErrorMessages.該当データなし),
        対象行を選択(UrErrorMessages.対象行を選択),
        複数選択不可_保険者(DbeErrorMessages.複数選択不可, "保険者"),
        割付済申請者選択不可(DbeErrorMessages.割付済申請者選択不可),
        選択割付必須(DbeErrorMessages.選択必須, "割付のデータ"),
        存在しない(UrErrorMessages.存在しない, "割付可能な調査委託先"),
        割付可能人数は0です_割付不可(DbeErrorMessages.割付可能人数は0です_割付不可),
        複数選択不可_認定調査票入手一覧(DbeErrorMessages.複数選択不可, "認定調査依頼一覧"),
        理由付き完了不可(DbzErrorMessages.理由付き完了不可, "認定調査依頼先が未確定"),
        理由付き完了不可_認定調査依頼年月日(DbzErrorMessages.理由付き完了不可, "認定調査依頼年月日が未設定"),
        理由付き完了不可_調査票等出力年月日(DbzErrorMessages.理由付き完了不可, "調査票等出力年月日が未設定"),
        認定調査依頼未割付(DbeErrorMessages.認定調査依頼未割付),
        委託先未設定(DbeErrorMessages.委託先未設定),
        保険者が同一ではない(DbeErrorMessages.委託先もしくは保険者が同一ではない, "保険者"),
        委託先が同一ではない(DbeErrorMessages.委託先もしくは保険者が同一ではない, "認定調査委託先"),
        調査依頼未保存のため印刷不可(DbeErrorMessages.未保存で帳票印刷不可, "調査依頼"),
        未保存データあり(DbzErrorMessages.実行不可, "未保存データが存在する", "モバイルデータの出力が実行"),
        未編集(UrErrorMessages.編集なしで更新不可);

        private final Message message;

        private RRVMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

    private static final class ValidateMessage implements IValidationMessage {

        private final Message message;

        private ValidateMessage(IMessageGettable message, String... replacements) {
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

    private boolean is割付済申請者選択(List<dgNinteiTaskList_Row> 選択されたデータ) {
        for (dgNinteiTaskList_Row row : 選択されたデータ) {
            if (!RString.isNullOrEmpty(row.getKonkaiChosaItakusaki())) {
                return true;
            }
        }
        return false;
    }
}
