/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820027;

import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)のバリデーションメッセージクラスです。
 *
 * @reamsid_L DBC-1030-060 tangkai
 */
public enum KinkyujiShisetuRyoyohiPanelValidationMessage implements IValidationMessage {

    /**
     * 緊急時傷病名2の入力チェック
     */
    緊急時傷病名2の入力チェック(UrErrorMessages.未入力, "緊急時傷病名②"),
    /**
     * 緊急時治療開始日2の入力チェック
     */
    緊急時治療開始日2の入力チェック(UrErrorMessages.未入力, "緊急時治療開始日②"),
    /**
     * 緊急時傷病名3の入力チェック
     */
    緊急時傷病名3の入力チェック(UrErrorMessages.未入力, "緊急時傷病名③"),
    /**
     * 緊急時治療開始日3の入力チェック
     */
    緊急時治療開始日3の入力チェック(UrErrorMessages.未入力, "緊急時治療開始日③"),
    /**
     * 往診日数の入力チェック
     */
    往診日数の入力チェック(UrErrorMessages.未入力, "往診日数"),
    /**
     * 往診医療機関名の入力チェック
     */
    往診医療機関名の入力チェック(UrErrorMessages.未入力, "往診医療機関名"),
    /**
     * 通院日数の入力チェック
     */
    通院日数の入力チェック(UrErrorMessages.未入力, "通院日数"),
    /**
     * 通院医療機関名の入力チェック
     */
    通院医療機関名の入力チェック(UrErrorMessages.未入力, "通院医療機関名"),
    /**
     * 緊急時治療管理単位数の入力チェック
     */
    緊急時治療管理単位数の入力チェック(UrErrorMessages.未入力, "緊急時治療管理単位数"),
    /**
     * 緊急時治療管理日数の入力チェック
     */
    緊急時治療管理日数の入力チェック(UrErrorMessages.未入力, "緊急時治療管理日数"),
    /**
     * 緊急時治療管理小計のチェック
     */
    緊急時治療管理小計のチェック(UrErrorMessages.未入力, "緊急時治療管理小計"),
    /**
     * 特定治療合計のチェック
     */
    特定治療合計のチェック(UrErrorMessages.未入力, "特定治療合計"),
    /**
     * 証明書入力済チェック
     */
    証明書入力済チェック(DbcErrorMessages.償還払い費支給申請決定_証明書情報未入力);
    private final Message message;

    private KinkyujiShisetuRyoyohiPanelValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    private KinkyujiShisetuRyoyohiPanelValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    /**
     * メッセージを取得します。
     *
     * @return メッセージ
     */
    @Override
    public Message getMessage() {
        return message;
    }

}
