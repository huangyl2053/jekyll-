/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB2710002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbErrorMessages;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710002.TokuchoTaishoshaIchiranDiv;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
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
 * 画面設計_DBBGM81003_1_特徴対象者一覧作成
 *
 * @reamsid_L DBB-1860-010 yangchenbing
 */
public class TokuchoTaishoshaIchiranValidationHandler {

    private static final RString 出力対象 = new RString("出力対象");
    private static final RString 特別徴収開始月が空白 = new RString("特別徴収開始月が空白");
    private static final RString 実行 = new RString("実行");
    private static final RString 最大表示件数 = new RString("最大表示件数");
    private final TokuchoTaishoshaIchiranDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面
     */
    public TokuchoTaishoshaIchiranValidationHandler(TokuchoTaishoshaIchiranDiv div) {
        this.div = div;
    }

    /**
     * 出力対象未選択のチックです。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate出力対象() {
        IValidationMessages message = 出力対象validate();
        return createDictionary出力対象().check(message);
    }

    private ValidationDictionary createDictionary出力対象() {
        List<ViewControl> list = new ArrayList();
        list.add(div.getChkShutsuryokuTaisho());
        return new ValidationDictionaryBuilder().add(TokuchoTaishoshaIchiranValidationMessage.出力対象選択されていない, list).build();
    }

    /**
     * 特別徴収開始月未指定のチックです。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate特別徴収開始月未指定() {
        IValidationMessages message = 特別徴収開始月validate();
        return createDictionary特別徴収開始月().check(message);
    }

    private ValidationDictionary createDictionary特別徴収開始月() {
        List<ViewControl> list = new ArrayList();
        list.add(div.getTxtKaishiYM());
        return new ValidationDictionaryBuilder().add(TokuchoTaishoshaIchiranValidationMessage.実行不可, list).build();
    }

    /**
     * 特別徴収開始月未指定のチックです。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate被保険者() {
        IValidationMessages message = 被保険者validate();
        return createDictionary被保険者().check(message);
    }

    private ValidationDictionary createDictionary被保険者() {
        List<ViewControl> list = new ArrayList();
        list.add(div.getTxtHihokenshaNo());
        return new ValidationDictionaryBuilder().add(TokuchoTaishoshaIchiranValidationMessage.被保険者未選択, list).build();
    }

    /**
     * 最大表示件数のチックです。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate最大表示件数() {
        IValidationMessages message = 最大表示件数validate();
        return createDictionary最大表示件数().check(message);
    }

    private ValidationDictionary createDictionary最大表示件数() {
        List<ViewControl> list = new ArrayList();
        list.add(div.getTxtMaxHyojiKensu());
        return new ValidationDictionaryBuilder().add(TokuchoTaishoshaIchiranValidationMessage.入力値が不正_追加メッセージあり, list).build();
    }

    /**
     * 出力対象未選択のチックです。 {@inheritDoc }
     *
     * @return {@link IValidationMessages}
     */
    private IValidationMessages 出力対象validate() {
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
    private IValidationMessages 特別徴収開始月validate() {
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
    private IValidationMessages 被保険者validate() {
        IValidationMessages message = ValidationMessagesFactory.createInstance();
        message.add(ValidateChain.validateStart(div)
                .ifNot(TokuchoTaishoshaIchiranSpec.被保険者未選択チック)
                .thenAdd(TokuchoTaishoshaIchiranValidationMessage.被保険者未選択)
                .messages());
        return message;
    }

    /**
     * 最大表示件数のチックです. {@inheritDoc }
     *
     * @return {@link IValidationMessages}
     */
    private IValidationMessages 最大表示件数validate() {
        IValidationMessages message = ValidationMessagesFactory.createInstance();
        message.add(ValidateChain.validateStart(div)
                .ifNot(TokuchoTaishoshaIchiranSpec.入力値が不正_追加メッセージありチック)
                .thenAdd(TokuchoTaishoshaIchiranValidationMessage.入力値が不正_追加メッセージあり)
                .messages());
        return message;
    }

    private static enum TokuchoTaishoshaIchiranValidationMessage implements IValidationMessage {

        /**
         * 出力対象選択されていない
         */
        出力対象選択されていない(UrErrorMessages.選択されていない, 出力対象.toString()),
        /**
         * 被保険者未選択
         */
        被保険者未選択(DbbErrorMessages.被保険者未選択),
        /**
         * 実行不可
         */
        実行不可(DbzErrorMessages.実行不可, 特別徴収開始月が空白.toString(), 実行.toString()),
        /**
         * 入力値が不正_追加メッセージあり
         */
        入力値が不正_追加メッセージあり(UrErrorMessages.入力値が不正_追加メッセージあり, 最大表示件数.toString());

        private final Message message;

        /**
         * エラーメッセージを取得する。
         *
         * @return エラーメッセージ
         */
        @Override
        public Message getMessage() {
            return message;
        }

        private TokuchoTaishoshaIchiranValidationMessage(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }
    }
}
