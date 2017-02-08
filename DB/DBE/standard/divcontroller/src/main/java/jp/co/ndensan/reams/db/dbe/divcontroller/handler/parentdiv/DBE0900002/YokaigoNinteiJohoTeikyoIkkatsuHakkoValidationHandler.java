/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0900002;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0900002.YokaigoNinteiJohoTeikyoIkkatsuHakkoDiv;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 要介護認定情報提供いかつ発行のバリデーションハンドラークラスです。
 *
 * @author N3212 竹内 和紀
 */
public class YokaigoNinteiJohoTeikyoIkkatsuHakkoValidationHandler {

    private static final RString 二次判定日 = new RString("0");
    private static final RString 被保険者番号 = new RString("1");
    private final YokaigoNinteiJohoTeikyoIkkatsuHakkoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div YokaigoNinteiJohoTeikyoIkkatsuHakkoDiv
     */
    public YokaigoNinteiJohoTeikyoIkkatsuHakkoValidationHandler(YokaigoNinteiJohoTeikyoIkkatsuHakkoDiv div) {
        this.div = div;
    }

    /**
     * 検索するボタンクリック時のバリデーションチェックです。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validate検索() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (div.getRadKensakuKomoku().getSelectedKey().equals(二次判定日)) {
            if (div.getTxtNijiHanteibi().getFromValue() == null || div.getTxtNijiHanteibi().getToValue() == null) {
                validationMessages.add(new ValidationMessageControlPair(ValidationMessages.二次判定日入力必須, div.getTxtNijiHanteibi()));
            }
        } else if (div.getRadKensakuKomoku().getSelectedKey().equals(被保険者番号)) {
            if (div.getTxtHihokenshaNo().getValue() == null) {
                validationMessages.add(new ValidationMessageControlPair(ValidationMessages.被保険者番号入力必須, div.getTxtHihokenshaNo()));
            }
        }
        return validationMessages;
    }

    /**
     * 実行するボタンクリック時のバリデーションチェックです。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateバッチ実行() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (div.getDgShinseiList().getSelectedItems().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(ValidationMessages.対象者未選択, div.getDgShinseiList()));
        }
        if (!div.getChkNinteiChosahyo().isAllSelected()
                && !div.getChkTokkiJiko().isAllSelected()
                && !div.getChkShujiiIkensho().isAllSelected()
                && !div.getChkSonotaShiryo().isAllSelected()
                && !div.getChkIchijiHanteiKekka().isAllSelected()) {
            validationMessages.add(new ValidationMessageControlPair(ValidationMessages.帳票未選択, div.getPrintChohyoSelect()));
        }
        return validationMessages;
    }

    private static enum ValidationMessages implements IValidationMessage {

        二次判定日入力必須(UrErrorMessages.必須, "二次判定日"),
        被保険者番号入力必須(UrErrorMessages.必須, "被保険者番号"),
        対象者未選択(UrErrorMessages.対象者を選択),
        主治医未同意データが存在するため発行不可(DbzErrorMessages.実行不可, "主治医の同意がない", "発行"),
        帳票未選択(UrErrorMessages.選択されていない, "帳票");

        private final Message message;

        private ValidationMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
