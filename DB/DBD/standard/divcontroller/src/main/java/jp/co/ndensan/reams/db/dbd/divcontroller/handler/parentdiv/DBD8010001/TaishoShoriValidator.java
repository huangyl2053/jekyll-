/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD8010001;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010001.TaishoShoriPanelDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 *
 * 非課税年金対象者情報アップロード画面の入力チェッククラスです。
 *
 * @reamsid_L DBD-4920-010 lit
 */
public class TaishoShoriValidator implements IValidatable {

    private final TaishoShoriPanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div TaishoShoriPanelDiv
     */
    public TaishoShoriValidator(TaishoShoriPanelDiv div) {
        this.div = div;
    }

    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(TaishoShoriSpec.編集なしチェック)
                .thenAdd(TaishoShoriValidationMessage.市町村コードチェック)
                .ifNot(TaishoShoriSpec.処理状態チェック_処理済)
                .thenAdd(TaishoShoriValidationMessage.市町村コードチェック)
                .ifNot(TaishoShoriSpec.処理状態チェック_処理なし)
                .thenAdd(TaishoShoriValidationMessage.市町村コードチェック)
                .messages());
        return messages;
    }

    /**
     * ファイル内容のチェック
     *
     * @return バリデーション突合結果
     */
    public IValidationMessages validateファイル内容() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(TaishoShoriSpec.市町村コードチェック)
                .thenAdd(TaishoShoriValidationMessage.市町村コードチェック)
                .ifNot(TaishoShoriSpec.月次ファイル通知内容チェック)
                .thenAdd(TaishoShoriValidationMessage.月次ファイル通知内容チェック)
                .ifNot(TaishoShoriSpec.年次ファイル通知内容チェック)
                .thenAdd(TaishoShoriValidationMessage.年次ファイル通知内容チェック)
                .messages());
        return messages;
    }

    /**
     * ファイル値のチェック
     *
     * @return バリデーション突合結果
     */
    public IValidationMessages validateファイル値() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(TaishoShoriSpec.アップロードファイル未指定チェック)
                .thenAdd(TaishoShoriValidationMessage.アップロードファイル未指定チェック)
                .messages());
        return messages;
    }

    /**
     * 調定年度のチェック
     *
     * @return バリデーション突合結果
     */
    public IValidationMessages validate調定年度() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(TaishoShoriSpec.調定年度チェック)
                .thenAdd(TaishoShoriValidationMessage.調定年度チェック)
                .messages());
        return messages;
    }
}
