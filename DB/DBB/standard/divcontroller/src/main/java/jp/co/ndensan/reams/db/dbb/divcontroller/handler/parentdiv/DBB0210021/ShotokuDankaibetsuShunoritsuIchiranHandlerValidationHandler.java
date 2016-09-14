/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0210021;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0210021.ShotokuDankaibetsuShunoritsuIchiranDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionary;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 画面設計_DBB0210021_保険料段階別収納率一覧表作成のクラスです。
 *
 * @reamsid_L DBB-1630-010 wangxingpeng
 */
public class ShotokuDankaibetsuShunoritsuIchiranHandlerValidationHandler {

    private final ShotokuDankaibetsuShunoritsuIchiranDiv div;
    private static final RString 年齢基準日必須項目チェック = new RString("年齢基準日");
    private static final RString 基準年月必須項目チェック = new RString("基準年月");
    private static final RString 生年月日年齢必須項目チェック = new RString("年齢もしくは生年月日を");

    /**
     * コンストラクタです。
     *
     * @param div ShotokuDankaibetsuShunoritsuIchiranDiv
     */
    public ShotokuDankaibetsuShunoritsuIchiranHandlerValidationHandler(ShotokuDankaibetsuShunoritsuIchiranDiv div) {
        this.div = div;
    }

    /**
     * createInstance
     *
     * @return ShotokuDankaibetsuShunoritsuIchiranHandlerValidationHandler
     */
    public static ShotokuDankaibetsuShunoritsuIchiranHandlerValidationHandler createInstance() {
        return InstanceProvider.create(ShotokuDankaibetsuShunoritsuIchiranHandlerValidationHandler.class);
    }

    /**
     * validateのメソッドです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate() {
        IValidationMessages messages = new ControlValidator(div).validate();
        return dictionary().check(messages);
    }

    private ValidationDictionary dictionary() {
        return new ValidationDictionaryBuilder()
                .add(ShotokuDankaibetsuShunoritsuIchiranHandlerValidationMessages.年齢基準日必須項目,
                        div.getTxtNenreiKijunYMD())
                .add(ShotokuDankaibetsuShunoritsuIchiranHandlerValidationMessages.基準年月必須項目,
                        div.getDdlJukyuKijunY(), div.getDdlJukyuKijunM())
                .add(ShotokuDankaibetsuShunoritsuIchiranHandlerValidationMessages.生年月日年齢必須項目,
                        div.getRadNenrei(), div.getRadUmareYMD()).build();
    }

    private static class ControlValidator {

        private final ShotokuDankaibetsuShunoritsuIchiranDiv div;

        /**
         * コンストラクタです。
         *
         * @param div ShotokuDankaibetsuShunoritsuIchiranDiv
         */
        public ControlValidator(ShotokuDankaibetsuShunoritsuIchiranDiv div) {
            this.div = div;
        }

        /**
         * validateのメソッドです。
         *
         * @return バリデーション突合結果
         */
        public IValidationMessages validate() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(ShotokuDankaibetsuShunoritsuIchiranHandlerSpec.年齢基準日必須項目チェック)
                    .thenAdd(ShotokuDankaibetsuShunoritsuIchiranHandlerValidationMessages.年齢基準日必須項目)
                    .ifNot(ShotokuDankaibetsuShunoritsuIchiranHandlerSpec.基準年月必須項目チェック)
                    .thenAdd(ShotokuDankaibetsuShunoritsuIchiranHandlerValidationMessages.基準年月必須項目)
                    .ifNot(ShotokuDankaibetsuShunoritsuIchiranHandlerSpec.生年月日年齢必須項目チェック)
                    .thenAdd(ShotokuDankaibetsuShunoritsuIchiranHandlerValidationMessages.生年月日年齢必須項目)
                    .messages());
            return messages;
        }
    }

    private static enum ShotokuDankaibetsuShunoritsuIchiranHandlerValidationMessages implements IValidationMessage {

        年齢基準日必須項目(UrErrorMessages.必須, 年齢基準日必須項目チェック.toString()),
        基準年月必須項目(UrErrorMessages.必須, 基準年月必須項目チェック.toString()),
        生年月日年齢必須項目(UrErrorMessages.未指定, 生年月日年齢必須項目チェック.toString());

        private final Message message;

        ShotokuDankaibetsuShunoritsuIchiranHandlerValidationMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
