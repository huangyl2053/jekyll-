/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820027;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820027.KinkyujiShisetuRyoyohiPanelDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionary;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)のバリデーションハンドラークラス。
 *
 * @reamsid_L DBC-1030-060 xupeng
 */
public class KinkyujiShisetuRyoyohiPanelValidationHandler {

    private final KinkyujiShisetuRyoyohiPanelDiv div;

    /**
     * コンストラクタ
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)画面Div
     */
    public KinkyujiShisetuRyoyohiPanelValidationHandler(KinkyujiShisetuRyoyohiPanelDiv div) {
        this.div = div;
    }

    /**
     * 確定ボタンをクリックする前のチェック
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validateチェック() {
        IValidationMessages message = new KinkyujiShisetuRyoyohiPanelValidator(div).validate();
        return createDictionaryチェック().check(message);
    }

    private ValidationDictionary createDictionaryチェック() {
        return new ValidationDictionaryBuilder()
                .add(KinkyujiShisetuRyoyohiPanelValidationMessage.往診医療機関名の入力チェック, div.getTxtOshinYiryokikanName())
                .add(KinkyujiShisetuRyoyohiPanelValidationMessage.往診日数の入力チェック, div.getTxtOshinNissu())
                .add(KinkyujiShisetuRyoyohiPanelValidationMessage.特定治療合計のチェック, div.getTxtKinkyuShisetsuRyoyohiTotalTanisu())
                .add(KinkyujiShisetuRyoyohiPanelValidationMessage.緊急時傷病名2の入力チェック, div.getTxtKinkyuShobyoName2())
                .add(KinkyujiShisetuRyoyohiPanelValidationMessage.緊急時傷病名3の入力チェック, div.getTxtKinkyuShobyoName3())
                .add(KinkyujiShisetuRyoyohiPanelValidationMessage.緊急時治療管理単位数の入力チェック, div.getTxtkinkyuChiryoKanriTanisu())
                .add(KinkyujiShisetuRyoyohiPanelValidationMessage.緊急時治療管理小計のチェック, div.getTxtkinkyuChiryoKanriSubTotal())
                .add(KinkyujiShisetuRyoyohiPanelValidationMessage.緊急時治療管理日数の入力チェック, div.getTxtkinkyuChiryoKanriNissu())
                .add(KinkyujiShisetuRyoyohiPanelValidationMessage.緊急時治療開始日2の入力チェック, div.getTxtKinkyuJiryoStartYMD2())
                .add(KinkyujiShisetuRyoyohiPanelValidationMessage.緊急時治療開始日3の入力チェック, div.getTxtKinkyuJiryoStartYMD3())
                .add(KinkyujiShisetuRyoyohiPanelValidationMessage.通院医療機関名の入力チェック, div.getTxtTuyinYiryokikanName())
                .add(KinkyujiShisetuRyoyohiPanelValidationMessage.通院日数の入力チェック, div.getTxtTuyinNissu())
                .build();
    }

    /**
     * 証明書チェック
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validate証明書チェック() {
        IValidationMessages message = new KinkyujiShisetuRyoyohiPanelValidator(div).validate証明書チェック();
        return createDictionary証明書チェック().check(message);
    }

    private ValidationDictionary createDictionary証明書チェック() {
        return new ValidationDictionaryBuilder()
                .add(KinkyujiShisetuRyoyohiPanelValidationMessage.証明書入力済チェック, div.getPanelHead())
                .build();
    }

}
