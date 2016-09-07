/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD4940001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4940001.NinteiShinseiTorokuTorikeshiShosaiDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.binding.ViewControl;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 要介護認定取消画面のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBD-2090-010 lit
 */
public class NinteiShinseiTorokuTorikeshiShosaiValidationHandler {

    private final NinteiShinseiTorokuTorikeshiShosaiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div NinteiShinseiTorokuTorikeshiShosaiDiv
     */
    public NinteiShinseiTorokuTorikeshiShosaiValidationHandler(NinteiShinseiTorokuTorikeshiShosaiDiv div) {
        this.div = div;
    }

    /**
     * ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new NinteiShinseiTorokuTorikeshiShosaiValidator(div).validate();
        validateResult.add(createDictionary().check(messages));

        return validateResult;
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(NinteiShinseiTorokuTorikeshiShosaiValidationMessage.異動事由が未選択チェック, get異動事由())
                .add(NinteiShinseiTorokuTorikeshiShosaiValidationMessage.理由が未入力チェック, get理由())
                .add(NinteiShinseiTorokuTorikeshiShosaiValidationMessage.更新チェック, new ArrayList<ViewControl>())
                .build();

    }

    private List<ViewControl> get異動事由() {
        List<ViewControl> viewControls = new ArrayList();
        // TODO. get項目できない。
//        viewControls.add(div.getCcdSonotaJoho().get);
        return viewControls;
    }

    private List<ViewControl> get理由() {
        List<ViewControl> viewControls = new ArrayList();
        // TODO. get項目できない。
//        viewControls.add(div.getCcdSonotaJoho().get);
        return viewControls;
    }

}
