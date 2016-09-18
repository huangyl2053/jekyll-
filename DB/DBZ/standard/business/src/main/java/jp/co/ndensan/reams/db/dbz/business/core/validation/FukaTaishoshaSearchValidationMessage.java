/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.validation;

import jp.co.ndensan.reams.db.dbz.business.config.GaitoshaKensakuConfig;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 賦課対象者検索のバリデーションメッセージを定義している列挙型です。
 *
 * @author n8300 姜井図
 */
public enum FukaTaishoshaSearchValidationMessage implements IValidationMessage {

    /**
     * 「最大取得件数上限超過」を表す列挙体です。
     */
    最大取得件数上限超過(UrErrorMessages.未指定.getMessage().replace("1以上、表示件数上限" + new GaitoshaKensakuConfig().get最大取得件数() + "以下を")),
    /**
     * 「検索条件未指定」を表す列挙体です。
     */
    検索条件未指定(UrErrorMessages.未指定.getMessage().replace("検索条件を")),
    /**
     * 「対象者が存在しない」を表す列挙体です。
     */
    対象者が存在しない(UrErrorMessages.対象者が存在しない.getMessage());

    private final transient Message message;

    private FukaTaishoshaSearchValidationMessage(Message message) {
        this.message = message;
    }

    @Override
    public Message getMessage() {
        return message;
    }

}
