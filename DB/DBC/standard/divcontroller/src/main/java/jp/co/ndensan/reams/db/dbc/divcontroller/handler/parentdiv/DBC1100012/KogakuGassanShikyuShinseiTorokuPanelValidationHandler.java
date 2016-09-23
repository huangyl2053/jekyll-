/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1100012;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1100012.KogakuGassanShikyuShinseiTorokuPanelDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionary;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.ViewControl;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBCMN61001-12_高額合算支給申請書登録(申請情報検索)のValidationHandlerです。
 *
 * @reamsid_L DBC-2040-010 lihang
 */
public class KogakuGassanShikyuShinseiTorokuPanelValidationHandler {

    private final KogakuGassanShikyuShinseiTorokuPanelDiv div;
    private static final RString 介護支給申請書整理番号チェックオン時介護支給申請書整理番号
            = new RString("介護支給申請書整理番号チェックオン時、介護支給申請書整理番号");
    private static final RString 医療支給申請書整理番号チェックオン時医療支給申請書整理番号
            = new RString("医療支給申請書整理番号チェックオン時、医療支給申請書整理番号");
    private static final RString 介護支給申請書整理番号4整理番号
            = new RString("介護支給申請書整理番号4（整理番号）");
    private static final RString 医療支給申請書整理番号３証記載保険者番号
            = new RString("医療支給申請書整理番号３（証記載保険者番号）");
    private static final RString 医療支給申請書整理番号４整理番号
            = new RString("医療支給申請書整理番号４（整理番号）");
    private static final RString 六 = new RString("6");

    /**
     * コンストラクタです。
     *
     * @param div KogakuGassanShikyuShinseiTorokuPanelDiv
     */
    public KogakuGassanShikyuShinseiTorokuPanelValidationHandler(KogakuGassanShikyuShinseiTorokuPanelDiv div) {
        this.div = div;
    }

    /**
     * validateチェック
     *
     * @return validPairs ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validate() {

        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        IValidationMessages messages = ValidationMessagesFactory.createInstance();

        messages.add(ValidateChain.validateStart(div).
                ifNot(KogakuGassanShikyuShinseiTorokuPanelSpec.終了日が開始日以前).
                thenAdd(KjcheckMessages.終了日が開始日以前).
                ifNot(KogakuGassanShikyuShinseiTorokuPanelSpec.介護支給申請書整理番号必須).
                thenAdd(KjcheckMessages.介護支給申請書整理番号必須).
                ifNot(KogakuGassanShikyuShinseiTorokuPanelSpec.介護支給申請書整理番号各項目の桁数チェック1).
                thenAdd(KjcheckMessages.介護支給申請書整理番号各項目の桁数チェック1).
                ifNot(KogakuGassanShikyuShinseiTorokuPanelSpec.医療支給申請書整理番号必須).
                thenAdd(KjcheckMessages.医療支給申請書整理番号必須).
                ifNot(KogakuGassanShikyuShinseiTorokuPanelSpec.医療支給申請書整理番号各項目の桁数チェック1).
                thenAdd(KjcheckMessages.医療支給申請書整理番号各項目の桁数チェック1).
                ifNot(KogakuGassanShikyuShinseiTorokuPanelSpec.医療支給申請書整理番号各項目の桁数チェック2).
                thenAdd(KjcheckMessages.医療支給申請書整理番号各項目の桁数チェック2).messages());
        validPairs.add(createDictionary().check(messages));
        return validPairs;
    }

    private ValidationDictionary createDictionary() {

        List<ViewControl> viewControl1 = new ArrayList();
        viewControl1.add(div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtKaigoShikyuShinseishoSeiriBango1());
        viewControl1.add(div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtKaigoShikyuShinseishoSeiriBango2());
        viewControl1.add(div.getKogakuGassanShikyuShinseiTorokuSearch().getDdlKaigoShikyuShinseishoSeiriBango3());
        viewControl1.add(div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtKaigoShikyuShinseishoSeiriBango4());
        List<ViewControl> viewControl2 = new ArrayList();
        viewControl2.add(div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtIryoShikyuShinseishoSeiriBango1());
        viewControl2.add(div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtIryoShikyuShinseishoSeiriBango2());
        viewControl2.add(div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtIryoShikyuShinseishoSeiriBango3());
        viewControl2.add(div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtIryoShikyuShinseishoSeiriBango4());
        return new ValidationDictionaryBuilder()
                .add(KjcheckMessages.終了日が開始日以前, div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtShinseiYMD())
                .add(KjcheckMessages.介護支給申請書整理番号必須, viewControl1)
                .add(KjcheckMessages.介護支給申請書整理番号各項目の桁数チェック1,
                        div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtKaigoShikyuShinseishoSeiriBango4())
                .add(KjcheckMessages.医療支給申請書整理番号必須, viewControl2)
                .add(KjcheckMessages.医療支給申請書整理番号各項目の桁数チェック1,
                        div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtIryoShikyuShinseishoSeiriBango3())
                .add(KjcheckMessages.医療支給申請書整理番号各項目の桁数チェック2,
                        div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtIryoShikyuShinseishoSeiriBango4())
                .build();
    }

    private static enum KjcheckMessages implements IValidationMessage {

        終了日が開始日以前(UrErrorMessages.終了日が開始日以前),
        介護支給申請書整理番号必須(UrErrorMessages.必須, 介護支給申請書整理番号チェックオン時介護支給申請書整理番号.toString()),
        介護支給申請書整理番号各項目の桁数チェック1(UrErrorMessages.桁数が不正, 介護支給申請書整理番号4整理番号.toString(), 六.toString()),
        医療支給申請書整理番号必須(UrErrorMessages.必須, 医療支給申請書整理番号チェックオン時医療支給申請書整理番号.toString()),
        医療支給申請書整理番号各項目の桁数チェック1(UrErrorMessages.桁数が不正, 医療支給申請書整理番号３証記載保険者番号.toString(), 六.toString()),
        医療支給申請書整理番号各項目の桁数チェック2(UrErrorMessages.桁数が不正, 医療支給申請書整理番号４整理番号.toString(), 六.toString());
        private final Message message;

        private KjcheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
