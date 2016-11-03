package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5130001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsakaiiinjoho.ShinsakaiIinJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001.ShinsakaiIinJohoTorokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001.dgShinsaInJohoIchiran_Row;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakaiiinjoho.shinsakaiiinjoho.ShinsakaiIinJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBECodeShubetsu;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001.ShinsakaiIinJohoSpec;
import jp.co.ndensan.reams.uz.uza.ui.binding.ViewControl;

/**
 * 介護認定審査会委員情報のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBE-0110-010 wangxiaodong
 */
public class ShinsakaiIinJohoTorokuValidationHandler {

    private final ShinsakaiIinJohoTorokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 調査委託先/調査員入力共有子のエンティティ
     */
    public ShinsakaiIinJohoTorokuValidationHandler(ShinsakaiIinJohoTorokuDiv div) {
        this.div = div;
    }

    /**
     * 審査会委員入力情報をチェックします。
     *
     * @param is更新モード boolean
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 審査会委員情報入力チェック(boolean is更新モード) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (!is更新モード) {
            boolean is重複コード = is重複コード(div.getTxtShinsainCode().getValue());
            if (is重複コード) {
                validationMessages.add(new ValidationMessageControlPair(ShinsakaiIinJohoTorokuValidationMessage.既に登録済));
            }
        }
        
        List<ViewControl> shinsaIinYMD = new ArrayList<>();
        shinsaIinYMD.add(div.getTxtShinsaIinYMDFrom());
        shinsaIinYMD.add(div.getTxtShinsaIinYMDTo());
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(ShinsakaiIinJohoSpec.審査会委員開始日終了日の大小チェック)
            .thenAdd(ShinsakaiIinJohoTorokuValidationMessage.終了日が開始日以前).messages());
        validationMessages.add(new ValidationMessageControlDictionaryBuilder().add(ShinsakaiIinJohoTorokuValidationMessage.終了日が開始日以前,
                shinsaIinYMD).build().check(messages));
        
        if (div.getCcdshinsakaiChikuCode().getCode() != null && !div.getCcdshinsakaiChikuCode().getCode().isEmpty()) {
            UzT0007CodeEntity 地区コード = CodeMaster.getCode(SubGyomuCode.DBE認定支援, DBECodeShubetsu.審査会地区コード.getコード(),
                    div.getCcdshinsakaiChikuCode().getCode(), FlexibleDate.getNowDate());
            if (地区コード == null) {
                validationMessages.add(new ValidationMessageControlPair(ShinsakaiIinJohoTorokuValidationMessage.コードマスタなし));
            }
        }
        return validationMessages;
    }
    
    /**
     * 審査会委員開始日・終了日の大小チェック。
     * 
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 審査会委員開始日終了日の大小チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        List<ViewControl> shinsaIinYMD = new ArrayList<>();
        shinsaIinYMD.add(div.getTxtShinsaIinYMDFrom());
        shinsaIinYMD.add(div.getTxtShinsaIinYMDTo());
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(ShinsakaiIinJohoSpec.審査会委員開始日終了日の大小チェック)
            .thenAdd(ShinsakaiIinJohoTorokuValidationMessage.終了日が開始日以前).messages());
        validationMessages.add(new ValidationMessageControlDictionaryBuilder().add(ShinsakaiIinJohoTorokuValidationMessage.終了日が開始日以前,
                shinsaIinYMD).build().check(messages));

        return validationMessages;

    }
    
    private boolean is重複コード(RString 審査会委員コード) {
        for (dgShinsaInJohoIchiran_Row row : div.getDgShinsaInJohoIchiran().getDataSource()) {
            if (審査会委員コード.equals(row.getShinsainCode())) {
                return true;
            }
        }
        int count = ShinsakaiIinJohoManager.createInstance().get審査会委員カウント(
                ShinsakaiIinJohoMapperParameter.createParamByShinsakaiIinCode(審査会委員コード));
        return 0 < count;
    }

    private enum ShinsakaiIinJohoTorokuValidationMessage implements IValidationMessage {

        既に登録済(UrErrorMessages.既に登録済, "審査会委員コード"),
        終了日が開始日以前(UrErrorMessages.終了日が開始日以前),
        コードマスタなし(UrErrorMessages.コードマスタなし);

        private final Message message;

        private ShinsakaiIinJohoTorokuValidationMessage(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
