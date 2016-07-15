/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5020001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5020001.ShokkenTorikeshiIchibuSoshituDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.binding.ViewControl;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 要介護認定処理画面のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBD-1530-010 lit
 */
public class ShokkenTorikeshiIchibuSoshituValidationHandler {

    private final ShokkenTorikeshiIchibuSoshituDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ShokkenTorikeshiIchibuSoshituDiv
     */
    public ShokkenTorikeshiIchibuSoshituValidationHandler(ShokkenTorikeshiIchibuSoshituDiv div) {
        this.div = div;
    }

    /**
     * ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new ShokkenTorikeshiIchibuSoshituValidator(div).validate();
        validateResult.add(createDictionary().check(messages));

        return validateResult;
    }

    /**
     * ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate履歴番号() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new ShokkenTorikeshiIchibuSoshituValidator(div).validate履歴番号();
        validateResult.add(createDictionary().check(messages));

        return validateResult;
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(ShokkenTorikeshiIchibuSoshituValidationMessage.申請日が未入力, get申請日())
                .add(ShokkenTorikeshiIchibuSoshituValidationMessage.認定日が未入力, get認定日())
                .add(ShokkenTorikeshiIchibuSoshituValidationMessage.喪失日が未入力, get喪失日())
                .add(ShokkenTorikeshiIchibuSoshituValidationMessage.要介護度が未入力, get要介護度())
                .add(ShokkenTorikeshiIchibuSoshituValidationMessage.有効開始日が未入力, get有効開始日())
                .add(ShokkenTorikeshiIchibuSoshituValidationMessage.有効終了日が未入力, get有効終了日())
                .add(ShokkenTorikeshiIchibuSoshituValidationMessage.有効開始日と有効終了日の関連チェック, get有効開始日と有効終了日())
                .add(ShokkenTorikeshiIchibuSoshituValidationMessage.前回有効終了日と今回有効開始日の関連チェック, get前回有効終了日と今回有効開始日())
                .add(ShokkenTorikeshiIchibuSoshituValidationMessage.新予防給付適用の60日前のみなし更新チェック, getみなし更新())
                .add(ShokkenTorikeshiIchibuSoshituValidationMessage.受給申請中かの確認チェック, new ArrayList<ViewControl>())
                .build();

    }

    private List<ViewControl> get申請日() {
        List<ViewControl> viewControls = new ArrayList();
        viewControls.add(div.getCcdKaigoNinteiShinseiKihonJohoInput()
                .getKaigoNinteiShinseiKihonJohoInputDiv().getTxtShinseiYMD());
        return viewControls;
    }

    private List<ViewControl> get認定日() {
        List<ViewControl> viewControls = new ArrayList();
        viewControls.add(div.getTxtNinteibiKonkai());
        return viewControls;
    }

    private List<ViewControl> get喪失日() {
        List<ViewControl> viewControls = new ArrayList();
        viewControls.add(div.getTxtSoshitsubi());
        return viewControls;
    }

    private List<ViewControl> get要介護度() {
        List<ViewControl> viewControls = new ArrayList();
        viewControls.add(div.getTxtYokaigodoKonkai());
        return viewControls;
    }

    private List<ViewControl> get有効開始日() {
        List<ViewControl> viewControls = new ArrayList();
        viewControls.add(div.getTxtYukoKaishibiKonkai());
        return viewControls;
    }

    private List<ViewControl> get有効終了日() {
        List<ViewControl> viewControls = new ArrayList();
        viewControls.add(div.getTxtYukoShuryobiKonkai());
        return viewControls;
    }

    private List<ViewControl> get有効開始日と有効終了日() {
        List<ViewControl> viewControls = new ArrayList();
        viewControls.add(div.getTxtYukoKaishibiKonkai());
        viewControls.add(div.getTxtYukoShuryobiKonkai());
        return viewControls;
    }

    private List<ViewControl> get前回有効終了日と今回有効開始日() {
        List<ViewControl> viewControls = new ArrayList();
        viewControls.add(div.getTxtYukoKaishibiKonkai());
        viewControls.add(div.getTxtYukoShuryobiZenkai());
        return viewControls;
    }

    private List<ViewControl> getみなし更新() {
        List<ViewControl> viewControls = new ArrayList();
        // TODO. みなし更新 わからない。
        return viewControls;
    }

}
