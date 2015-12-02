package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.JigyoshaNyuryokuGudieCommonChildDiv;

import jp.co.ndensan.reams.db.dba.definition.enumeratedtype.message.Dbamn00000ErrorMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 事業者・施設選択入力ガイドDivのHandlerクラスです。
 */
public class validationHandler {

    public static ValidationMessageControlPairs 終了日が開始日以前のチェック() {

        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(Dbamn00000ErrorMessages.終了日が開始日以前));
        return validationMessages;
    }
}
