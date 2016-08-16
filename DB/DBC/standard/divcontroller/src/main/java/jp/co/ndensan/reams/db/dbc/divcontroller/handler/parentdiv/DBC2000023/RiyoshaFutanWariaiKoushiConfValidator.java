/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2000023;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000023.RiyoshaFutanWariaiKoushiConfDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 「発行する」ボタンを押下時の入力チェックValidatorです。
 * 
 * @reamsid_L DBC-5010-012 lijian
 */
public class RiyoshaFutanWariaiKoushiConfValidator {
    
    private final RiyoshaFutanWariaiKoushiConfDiv div;
    
    /**
     * コンストラクタです。
     *
     * @param div {@link RiyoshaFutanWariaiKoushiConfDiv div}
     */
    public RiyoshaFutanWariaiKoushiConfValidator(RiyoshaFutanWariaiKoushiConfDiv div){
        this.div = div;
    }
    
    /**
     * 発行日未入力チェックです。
     *
     * @return エラーメッセージ
     */
    public IValidationMessages validate発行日入力() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        
        messages.add(ValidateChain.validateStart(div)
                .ifNot(RiyoshaFutanWariaiKoushiConfSpec.発行日未入力入力チェック)
                .thenAdd(RiyoshaFutanWariaiKoushiConfValidationMessage.発行日チェック)
                .messages());
        return messages;
    }
    
    /**
     * 交付日未入力チェックです。
     *
     * @return エラーメッセージ
     */
    public IValidationMessages validate交付日未入力() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        
        messages.add(ValidateChain.validateStart(div)
                .ifNot(RiyoshaFutanWariaiKoushiConfSpec.交付日未入力チェック)
                .thenAdd(RiyoshaFutanWariaiKoushiConfValidationMessage.交付日チェック)
                .messages());
        return messages;
        
    }
    
    /**
     * 交付事由入力チェックです。
     *
     * @return エラーメッセージ
     */
    public IValidationMessages validate交付事由入力(){
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        
        messages.add(ValidateChain.validateStart(div)
                .ifNot(RiyoshaFutanWariaiKoushiConfSpec.交付事由未選択チェック)
                .thenAdd(RiyoshaFutanWariaiKoushiConfValidationMessage.交付事由チェック)
                .messages());
        return messages;
    }

}
