/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5320001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5320001.NinteiTsuchishoHakkoDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.binding.ViewControl;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 要介護認定通知書発行画面のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBD-1430-010 lit
 */
public class NinteiTsuchishoHakkoValidationHandler {

    private final NinteiTsuchishoHakkoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div NinteiTsuchishoHakkoDiv
     */
    public NinteiTsuchishoHakkoValidationHandler(NinteiTsuchishoHakkoDiv div) {
        this.div = div;
    }

    /**
     * ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new NinteiTsuchishoHakkoValidator(div).validate();
        validateResult.add(createDictionary().check(messages));

        return validateResult;
    }

    /**
     * ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate選択対象() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new NinteiTsuchishoHakkoValidator(div).validate選択対象();
        validateResult.add(createDictionary().check(messages));

        return validateResult;
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(NinteiTsuchishoHakkoValidationMessage.個別印刷0件チェック, get対象一覧())
                .add(NinteiTsuchishoHakkoValidationMessage.個別印刷選択0件チェック, get対象一覧())
                .add(NinteiTsuchishoHakkoValidationMessage.個別印刷選択複数件チェック, get対象一覧())
                .build();

    }

    private List<ViewControl> get対象一覧() {
        List<ViewControl> viewControls = new ArrayList();
        viewControls.add(div.getDgTaishoshaIchiran());
        return viewControls;
    }
}
