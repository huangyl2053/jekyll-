/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ShobyoIken.ShobyoIken;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * 共有子Div「ShobyoIken」の抽象ValidationHandlerクラスです。
 *
 * @reamsid_L DBE-3000-130 zhengshukai
 */
public class ShobyoIkenValidationHandler {

    private static final RString 追加 = new RString("追加");
    private static final RString 修正 = new RString("修正");
    private static final RString codeShubetsu = new RString("5003");
    private final ShobyoIkenDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ShobyoIkenDiv
     */
    public ShobyoIkenValidationHandler(ShobyoIkenDiv div) {
        this.div = div;
    }

    /**
     * 確定するボタンを押下するとき、バリデーションチェックを行う。
     *
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs validateForAction() {
        ValidationMessageControlPairs validationMessage = new ValidationMessageControlPairs();
        List<UzT0007CodeEntity> codetable = new ArrayList<>();
        codetable = CodeMaster.getCode(SubGyomuCode.DBE認定支援,
                getCodeShubetsu(codeShubetsu), FlexibleDate.getNowDate());
        boolean codeflg = false;
        if (追加.equals(div.getGeninShikkanPanel().getGeninShikkanShosai().getJotai())
                || 修正.equals(div.getGeninShikkanPanel().getGeninShikkanShosai().getJotai())) {
            for (UzT0007CodeEntity codeEntity : codetable) {
                if (codeEntity.getコード().value().equals(div.getGeninShikkanPanel().getGeninShikkanShosai()
                        .getCcdCodeInputGeninShikkan().getCode().getColumnValue())) {
                    codeflg = true;
                }
            }
        }
        if (!codeflg) {
            validationMessage.add(new ValidationMessageControlPair(IdocheckMessages.validation));
        }
        return validationMessage;
    }

    private static enum IdocheckMessages implements IValidationMessage {

        validation(UrErrorMessages.既に登録済, "原因疾患コード");

        private final Message message;

        private IdocheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

    private CodeShubetsu getCodeShubetsu(RString codeShubetsu) {
        return new CodeShubetsu(codeShubetsu);
    }
}
