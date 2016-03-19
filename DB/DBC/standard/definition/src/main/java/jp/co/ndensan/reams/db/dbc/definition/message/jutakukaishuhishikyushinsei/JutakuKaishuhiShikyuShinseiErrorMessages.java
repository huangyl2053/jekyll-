/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.message.jutakukaishuhishikyushinsei;

import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 住宅改修費支給申請一括審査・決定 Messages
 */
public enum JutakuKaishuhiShikyuShinseiErrorMessages implements IValidationMessage {

    支給申請日FROMと支給申請日TOの必須チェック(UrErrorMessages.必須項目_追加メッセージあり, "支給申請日（FROM)と支給申請日（TO)"),
    支給申請日FROMと支給申請日TOの有効性チェック(DbzErrorMessages.期間が不正_未来日付不可, "支給申請日（FROM)", "支給申請日（TO)"),
    データ選択のチェック(UrErrorMessages.対象行を選択),
    未審査のチェック(DbcErrorMessages.未審査有りで保存不可);

    private final Message message;

    private JutakuKaishuhiShikyuShinseiErrorMessages(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }

}
