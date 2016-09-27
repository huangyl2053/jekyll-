/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1310001;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1310001.JukyushaDaichoDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 画面設計_DBDGM13003_汎用リスト出力(受給者台帳)の入力チェッククラスです。
 *
 * @reamsid_L DBD-1800-010 liwul
 */
public class _JukyushaDaichoPanelValidator implements IValidatable {

    private final JukyushaDaichoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ドメインオブジェクトを取り出したい{@link JukyushaDaichoDiv}
     */
    public _JukyushaDaichoPanelValidator(JukyushaDaichoDiv div) {
        this.div = div;
    }

    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(JukyushaDaichoPanelSpec.実行するボタンクリック1)
                .thenAdd(JukyushaDaichoPanelValidationMessage.実行するボタンクリック1)
                .ifNot(JukyushaDaichoPanelSpec.実行するボタンクリック2)
                .thenAdd(JukyushaDaichoPanelValidationMessage.実行するボタンクリック2)
                .ifNot(JukyushaDaichoPanelSpec.実行するボタンクリック3)
                .thenAdd(JukyushaDaichoPanelValidationMessage.実行するボタンクリック3)
                .ifNot(JukyushaDaichoPanelSpec.実行するボタンクリック4)
                .thenAdd(JukyushaDaichoPanelValidationMessage.実行するボタンクリック4)
                .ifNot(JukyushaDaichoPanelSpec.実行するボタンクリック5)
                .thenAdd(JukyushaDaichoPanelValidationMessage.実行するボタンクリック5)
                .ifNot(JukyushaDaichoPanelSpec.実行するボタンクリック6)
                .thenAdd(JukyushaDaichoPanelValidationMessage.実行するボタンクリック6)
                .ifNot(JukyushaDaichoPanelSpec.実行するボタンクリック7)
                .thenAdd(JukyushaDaichoPanelValidationMessage.実行するボタンクリック7)
                .ifNot(JukyushaDaichoPanelSpec.実行するボタンクリック8)
                .thenAdd(JukyushaDaichoPanelValidationMessage.実行するボタンクリック8)
                .messages());
        return messages;
    }
}
