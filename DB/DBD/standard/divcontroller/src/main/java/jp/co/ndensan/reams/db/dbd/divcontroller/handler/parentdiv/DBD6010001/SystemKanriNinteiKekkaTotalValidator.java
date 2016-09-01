/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD6010001;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD6010001.SystemKanriNinteiKekkaTotalDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * システム管理登録（認定結果通知書文言変更）画面の入力チェッククラスです。
 *
 * @reamsid_L DBD-3760-010 tz_chengpeng
 */
public class SystemKanriNinteiKekkaTotalValidator implements IValidatable {

    private final SystemKanriNinteiKekkaTotalDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ShokkenTorikeshiIchibuSoshituDiv
     */
    public SystemKanriNinteiKekkaTotalValidator(SystemKanriNinteiKekkaTotalDiv div) {
        this.div = div;
    }

    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(SystemKanriNinteiKekkaTotalSpec.付加情報_データ更新チェック)
                .thenAdd(SystemKanriNinteiKekkaTotalValidationMessage.更新対象のデータがない)
                .messages());
        return messages;
    }

}
