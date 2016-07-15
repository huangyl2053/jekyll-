/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE4010001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4010001.ShinsakaiTorokuDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiTaskList.YokaigoNinteiTaskList.dgNinteiTaskList_Row;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 完了処理・介護認定審査会登録のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBE-0340-010 linghuhang
 */
public class ShinsakaiTorokuValidationHandler {

    private final RString 介護認定審査会割当後 = new RString("2");
    private final ShinsakaiTorokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 介護認定審査会登録Div
     */
    public ShinsakaiTorokuValidationHandler(ShinsakaiTorokuDiv div) {
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
     * 割付可能チェックを行う。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 割付可能チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        List<dgNinteiTaskList_Row> 選択データ = div.getCcdTaskList().getCheckbox();
        for (dgNinteiTaskList_Row データ : 選択データ) {
            if (データ.getShinsakaiwaritukeDay().getValue() != null) {
                validPairs.add(new ValidationMessageControlPair(RRVMessages.割付可能チェック));
                break;
            }
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
            if (データ.getShinsakaiwaritukeDay().getValue() == null) {
                validPairs.add(new ValidationMessageControlPair(RRVMessages.完了処理事前チェック));
                break;
            }
        }
        return validPairs;
    }

    /**
     * 完了済みデータチェックを行う。
     *
     * @param validPairs ValidationMessageControlPairs
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 完了済みデータチェック(ValidationMessageControlPairs validPairs) {
        List<dgNinteiTaskList_Row> 選択データ = div.getCcdTaskList().getCheckbox();
        for (dgNinteiTaskList_Row データ : 選択データ) {
            if (データ.getShinsakaiKanryoDay().getValue() != null) {
                validPairs.add(new ValidationMessageControlPair(RRVMessages.完了済みデータチェック));
                break;
            }
        }
        return validPairs;
    }

    /**
     * マスキング完了チェックを行う。
     *
     * @param validPairs ValidationMessageControlPairs
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs マスキング完了チェック(ValidationMessageControlPairs validPairs) {
        List<dgNinteiTaskList_Row> 選択データ = div.getCcdTaskList().getCheckbox();
        RDate 適用基準日 = RDate.getNowDate();
        RString カスタム = DbBusinessConfig.get(ConfigNameDBE.マスキングチェックタイミング, 適用基準日, SubGyomuCode.DBE認定支援);
        if (介護認定審査会割当後.equals(カスタム)) {
            for (dgNinteiTaskList_Row データ : 選択データ) {
                if (データ.getMaskingKanryoDay().getValue() == null) {
                    validPairs.add(new ValidationMessageControlPair(RRVMessages.マスキング完了チェック));
                    break;
                }
            }
        }
        return validPairs;
    }

    private static enum RRVMessages implements IValidationMessage {

        存在チェック(UrErrorMessages.該当データなし),
        対象行を選択チェック(UrErrorMessages.対象行を選択),
        一覧を選択チェック(DbeErrorMessages.複数選択不可, "審査会登録一覧"),
        割付可能チェック(DbeErrorMessages.審査会割付不可),
        完了処理事前チェック(DbzErrorMessages.理由付き完了不可, "審査会未割付"),
        完了済みデータチェック(DbzErrorMessages.理由付き完了不可, "完了済みデータ"),
        マスキング完了チェック(DbzErrorMessages.理由付き完了不可, "マスキング未完了");
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
