/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB2710002;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710002.TokuchoTaishoshaIchiranDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 入力内容が存在しないチェック用クラスです。<br/>
 * 画面設計_DBBGM81003_1_特徴対象者一覧作成
 *
 * @reamsid_L DBB-1860-010 yangchenbing
 */
class TokuchoTaishoshaIchiranValidator {

    private final TokuchoTaishoshaIchiranDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面Div
     */
    public TokuchoTaishoshaIchiranValidator(TokuchoTaishoshaIchiranDiv div) {
        this.div = div;
    }

    /**
     * 出力対象未選択のチックです。 {@inheritDoc }
     *
     * @return {@link IValidationMessages}
     */
    public IValidationMessages 出力対象validate() {
        IValidationMessages message = ValidationMessagesFactory.createInstance();
        message.add(ValidateChain.validateStart(div)
                .ifNot(TokuchoTaishoshaIchiranSpec.出力対象未選択チック)
                .thenAdd(TokuchoTaishoshaIchiranValidationMessage.出力対象選択されていない)
                .messages());
        return message;
    }

    /**
     * 特別徴収開始月未指定のチックです {@inheritDoc }
     *
     * @return {@link IValidationMessages}
     */
    public IValidationMessages 特別徴収開始月validate() {
        IValidationMessages message = ValidationMessagesFactory.createInstance();
        message.add(ValidateChain.validateStart(div)
                .ifNot(TokuchoTaishoshaIchiranSpec.特別徴収開始月未指定チック)
                .thenAdd(TokuchoTaishoshaIchiranValidationMessage.実行不可)
                .messages());
        return message;
    }

    /**
     * 被保険者未選択のチックです. {@inheritDoc }
     *
     * @return {@link IValidationMessages}
     */
    public IValidationMessages 被保険者validate() {
        IValidationMessages message = ValidationMessagesFactory.createInstance();
        message.add(ValidateChain.validateStart(div)
                .ifNot(TokuchoTaishoshaIchiranSpec.被保険者未選択チック)
                .thenAdd(TokuchoTaishoshaIchiranValidationMessage.被保険者未選択)
                .messages());
        return message;
    }
}
