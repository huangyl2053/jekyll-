/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1300011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1300011.KyufuTsuchiGenmenHoseiTorokuDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionary;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *画面設計_DBCMN71001_給付費通知減免情報補正登録のValidationHandlerです。
 * 
 * @reamsid_L DBC-2260-010 guyan
 */
public class KyufuTsuchiGenmenHoseiTorokuValidationHandler {
    
    private final KyufuTsuchiGenmenHoseiTorokuDiv div;
    
    /**
     * コンストラクタです。
     *
     * @param div {@link ShikyugakuKeisanKekkaTorokuDiv}
     */
    public KyufuTsuchiGenmenHoseiTorokuValidationHandler(KyufuTsuchiGenmenHoseiTorokuDiv div) {
        this.div = div;
    }
    
    /**
     *「検索する」ボタン押下時のチェックです。
     * 
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validate検索する() {
        IValidationMessages message = new KyufuTsuchiGenmenHoseiTorokuValidator(div).validate検索する();
        return create検索するDictionary().check(message);
    }

    private ValidationDictionary create検索するDictionary() {
        return new ValidationDictionaryBuilder()
                .add(KyufuTsuchiGenmenHoseiTorokuMessage.最大取得件数不正, div.getKyufuTsuchiGenmenHoseiTorokuSearch().getTextBoxNumKensuu())
                .build();
    }
    
    /**
     *「補正情報を確定する」ボタン
     * 
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validate確定する() {
        IValidationMessages message = new KyufuTsuchiGenmenHoseiTorokuValidator(div).validate確定する();
        return create確定するDictionary().check(message);
    }

    private ValidationDictionary create確定するDictionary() {
        return new ValidationDictionaryBuilder()
                .add(KyufuTsuchiGenmenHoseiTorokuMessage.サービス年月入力, div.getKyufuTsuchiGenmenHoseiTorokuDetail().getTextBoxDateSaabisu())
                .add(KyufuTsuchiGenmenHoseiTorokuMessage.証記載保険者番号入力, div.getKyufuTsuchiGenmenHoseiTorokuDetail())
                .add(KyufuTsuchiGenmenHoseiTorokuMessage.事業者入力, div.getKyufuTsuchiGenmenHoseiTorokuDetail())
                .add(KyufuTsuchiGenmenHoseiTorokuMessage.サービス種類入力, div.getKyufuTsuchiGenmenHoseiTorokuDetail())
                .add(KyufuTsuchiGenmenHoseiTorokuMessage.利用者負担額合計入力, div.getKyufuTsuchiGenmenHoseiTorokuDetail().getTextBoxFudangoukei())
                .add(KyufuTsuchiGenmenHoseiTorokuMessage.サービス費用合計入力, div.getKyufuTsuchiGenmenHoseiTorokuDetail().getTextBoxNumHiyouGoukei())
                .build();
    }
    
}
