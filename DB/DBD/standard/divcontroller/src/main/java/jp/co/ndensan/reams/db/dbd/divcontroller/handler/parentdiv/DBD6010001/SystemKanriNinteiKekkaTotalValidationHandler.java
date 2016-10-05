/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD6010001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD6010001.SystemKanriNinteiKekkaTotalDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.binding.ViewControl;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * システム管理登録（認定結果通知書文言変更）のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBD-3760-010 tz_chengpeng
 */
public class SystemKanriNinteiKekkaTotalValidationHandler {

    private final SystemKanriNinteiKekkaTotalDiv div;

    /**
     * コンストラクタです。
     *
     * @param div SystemKanriNinteiKekkaTotalDiv
     */
    public SystemKanriNinteiKekkaTotalValidationHandler(SystemKanriNinteiKekkaTotalDiv div) {
        this.div = div;
    }

    /**
     * ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new SystemKanriNinteiKekkaTotalValidator(div).validate();
        validateResult.add(createDictionary().check(messages));

        return validateResult;
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(SystemKanriNinteiKekkaTotalValidationMessage.更新対象のデータがない, get付加情報())
                .build();
    }

    private List<ViewControl> get付加情報() {
        List<ViewControl> viewControls = new ArrayList<>();
        viewControls.add(div.getSystemKanri().getSystemKanriNinteiKekka().getTxtFukaJoho1());
        viewControls.add(div.getSystemKanri().getSystemKanriNinteiKekka().getTxtFukaJoho2());
        viewControls.add(div.getSystemKanri().getSystemKanriNinteiKekka().getTxtFukaJoho3());
        viewControls.add(div.getSystemKanri().getSystemKanriNinteiKekka().getTxtFukaJoho4());
        viewControls.add(div.getSystemKanri().getSystemKanriNinteiKekka().getTxtFukaJoho5());
        viewControls.add(div.getSystemKanri().getSystemKanriNinteiKekka().getTxtFukaJoho6());
        viewControls.add(div.getSystemKanri().getSystemKanriNinteiKekka().getTxtFukaJoho7());
        viewControls.add(div.getSystemKanri().getSystemKanriNinteiKekka().getTxtFukaJoho8());
        viewControls.add(div.getSystemKanri().getSystemKanriNinteiKekka().getTxtFukaJoho9());
        return viewControls;
    }
}
