package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.JigyoshaNyuryokuGudieCommonChildDiv;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.message.Dbzmn00000ErrorMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 事業者・施設選択入力ガイドのチェッククラスです。
 */
public class ValidationHandler {

    public static ValidationMessageControlPairs 終了日が開始日以前のチェック() {

        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(Dbzmn00000ErrorMessages.終了日が開始日以前));
        return validationMessages;
    }
}
