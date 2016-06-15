/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.parentdiv.DBZ0400002;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ0400002.ChohyoSeigyoMaintenacePanelDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ0400002.dgCyohyoSeigyo_Row;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * 帳票制御メンテナンスのvalidationHandlerです。
 *
 * @reamsid_L DBA-1201-030 yaodongsheng
 */
public class ChohyoSeigyoMaintenaceValidationHandler {

    private final ChohyoSeigyoMaintenacePanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ChohyoSeigyoMaintenace
     */
    public ChohyoSeigyoMaintenaceValidationHandler(ChohyoSeigyoMaintenacePanelDiv div) {
        this.div = div;
    }

    /**
     *
     * 保存可否をチェックします。
     *
     * @param row dgCyohyoSeigyo_Row
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 保存可否Check(dgCyohyoSeigyo_Row row) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        boolean eraNashi = false;
        List<UzT0007CodeEntity> entityList = CodeMaster.getCode(new SubGyomuCode(row.getStrCodeMasterSubCode()),
                new CodeShubetsu(row.getStrCodeMasterShubetsu()));
        for (UzT0007CodeEntity entity : entityList) {
            if (entity.getコード().value().equals(row.getTxtSetteichi().getValue())) {
                eraNashi = true;
                break;
            }
        }
        if (!eraNashi) {
            RStringBuilder message = new RStringBuilder();
            validationMessages.add(new ValidationMessageControlPair(
                    new ChohyoSeigyoMaintenaceValidationHandler.ValidationMessage(
                            UrErrorMessages.入力値が不正_追加メッセージあり, message.append(row.getStrKomoku()).append("の設定値").toString()),
                    div.getDgCyohyoSeigyo()));
        }
        return validationMessages;
    }

    private static final class ValidationMessage implements IValidationMessage {

        private final Message message;

        private ValidationMessage(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
