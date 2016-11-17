/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820027;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820027.KinkyujiShisetuRyoyohiPanelDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)のバリデータクラスです。
 *
 * @reamsid_L DBC-1030-060 tangkai
 */
public class KinkyujiShisetuRyoyohiPanelValidator implements IValidatable {

    private final KinkyujiShisetuRyoyohiPanelDiv div;

    /**
     * コンストラクタ
     *
     * @param div 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)画面Div
     */
    public KinkyujiShisetuRyoyohiPanelValidator(KinkyujiShisetuRyoyohiPanelDiv div) {
        this.div = div;
    }

    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(KinkyujiShisetuRyoyohiPanelSpec.往診医療機関名の入力チェック)
                .thenAdd(KinkyujiShisetuRyoyohiPanelValidationMessage.往診医療機関名の入力チェック)
                .ifNot(KinkyujiShisetuRyoyohiPanelSpec.往診日数の入力チェック)
                .thenAdd(KinkyujiShisetuRyoyohiPanelValidationMessage.往診日数の入力チェック)
                .ifNot(KinkyujiShisetuRyoyohiPanelSpec.特定治療合計のチェック)
                .thenAdd(KinkyujiShisetuRyoyohiPanelValidationMessage.特定治療合計のチェック)
                .ifNot(KinkyujiShisetuRyoyohiPanelSpec.緊急時傷病名2の入力チェック)
                .thenAdd(KinkyujiShisetuRyoyohiPanelValidationMessage.緊急時傷病名2の入力チェック)
                .ifNot(KinkyujiShisetuRyoyohiPanelSpec.緊急時傷病名3の入力チェック)
                .thenAdd(KinkyujiShisetuRyoyohiPanelValidationMessage.緊急時傷病名3の入力チェック)
                .ifNot(KinkyujiShisetuRyoyohiPanelSpec.緊急時治療管理単位数の入力チェック)
                .thenAdd(KinkyujiShisetuRyoyohiPanelValidationMessage.緊急時治療管理単位数の入力チェック)
                .ifNot(KinkyujiShisetuRyoyohiPanelSpec.緊急時治療管理小計のチェック)
                .thenAdd(KinkyujiShisetuRyoyohiPanelValidationMessage.緊急時治療管理小計のチェック)
                .ifNot(KinkyujiShisetuRyoyohiPanelSpec.緊急時治療管理日数の入力チェック)
                .thenAdd(KinkyujiShisetuRyoyohiPanelValidationMessage.緊急時治療管理日数の入力チェック)
                .ifNot(KinkyujiShisetuRyoyohiPanelSpec.緊急時治療開始日2の入力チェック)
                .thenAdd(KinkyujiShisetuRyoyohiPanelValidationMessage.緊急時治療開始日2の入力チェック)
                .ifNot(KinkyujiShisetuRyoyohiPanelSpec.緊急時治療開始日3の入力チェック)
                .thenAdd(KinkyujiShisetuRyoyohiPanelValidationMessage.緊急時治療開始日3の入力チェック)
                .ifNot(KinkyujiShisetuRyoyohiPanelSpec.通院医療機関名の入力チェック)
                .thenAdd(KinkyujiShisetuRyoyohiPanelValidationMessage.通院医療機関名の入力チェック)
                .ifNot(KinkyujiShisetuRyoyohiPanelSpec.通院日数の入力チェック)
                .thenAdd(KinkyujiShisetuRyoyohiPanelValidationMessage.通院日数の入力チェック)
                .messages());
        return messages;
    }

}
