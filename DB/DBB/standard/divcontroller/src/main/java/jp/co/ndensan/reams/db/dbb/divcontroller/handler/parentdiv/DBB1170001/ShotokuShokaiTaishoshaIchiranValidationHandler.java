/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB1170001;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1170001.ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranDiv;
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

/**
 * 画面設計_DBBGM51001_所得照会状況一覧のバリデーションハンドラークラス
 *
 * @reamsid_L DBB-1700-010 zhangrui
 */
public class ShotokuShokaiTaishoshaIchiranValidationHandler {

    private static final RString 抽出基準年度メッセージ = new RString("抽出基準年度");
    private static final RString 抽出期間FROM年月日メッセージ = new RString("抽出期間（FROM）年月日");
    private static final RString 抽出期間FROM時分秒メッセージ = new RString("抽出期間（FROM）時分秒");
    private static final RString 抽出期間TO年月日メッセージ = new RString("抽出期間（TO）年月日");
    private static final RString 抽出期間TO時分秒メッセージ = new RString("抽出期間（TO）時分秒");

    private final ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranDiv div;

    /**
     * コンストラクタ
     *
     * @param div ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranDiv
     */
    public ShotokuShokaiTaishoshaIchiranValidationHandler(ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranDiv div) {
        this.div = div;
    }

    /**
     * 実行と条件保存ボタンクリック時のバリデーションチェック。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate() {
        IValidationMessages messages = new ControlValidator(div).validate();
        return createDictionary().check(messages);
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(ShotokuShokaiTaishoshaIchiranValidationMessages.抽出基準年度のチェック, div.getTxtChushutsuKijunNendo())
                .add(ShotokuShokaiTaishoshaIchiranValidationMessages.抽出期間FROM年月日のチェック, div.getTxtChushutsuStYMD())
                .add(ShotokuShokaiTaishoshaIchiranValidationMessages.抽出期間FROM時分秒のチェック, div.getTxtChushutsuStTime())
                .add(ShotokuShokaiTaishoshaIchiranValidationMessages.抽出期間TO年月日のチェック, div.getTxtChushutsuEdYMD())
                .add(ShotokuShokaiTaishoshaIchiranValidationMessages.抽出期間TO時分秒のチェック, div.getTxtChushutsuEdTime())
                .add(ShotokuShokaiTaishoshaIchiranValidationMessages.日付関係のチェック,
                        div.getTxtChushutsuStYMD(), div.getTxtChushutsuStTime(), div.getTxtChushutsuEdYMD(), div.getTxtChushutsuEdTime())
                .build();
    }

    private static class ControlValidator {

        private final ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranDiv div;

        public ControlValidator(ShotokuShokaihyoIkkatsuHakkoTaishoshaIchiranDiv div) {
            this.div = div;
        }

        /**
         * 「 実行と条件保存ボタンクリック時のバリデーションチェック。
         *
         * @return バリデーション突合結果
         */
        public IValidationMessages validate() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(ShotokuShokaiTaishoshaIchiranSpec.抽出基準年度)
                    .thenAdd(ShotokuShokaiTaishoshaIchiranValidationMessages.抽出基準年度のチェック)
                    .ifNot(ShotokuShokaiTaishoshaIchiranSpec.抽出期間FROM年月日)
                    .thenAdd(ShotokuShokaiTaishoshaIchiranValidationMessages.抽出期間FROM年月日のチェック)
                    .ifNot(ShotokuShokaiTaishoshaIchiranSpec.抽出期間FROM時分秒)
                    .thenAdd(ShotokuShokaiTaishoshaIchiranValidationMessages.抽出期間FROM時分秒のチェック)
                    .ifNot(ShotokuShokaiTaishoshaIchiranSpec.抽出期間TO年月日)
                    .thenAdd(ShotokuShokaiTaishoshaIchiranValidationMessages.抽出期間TO年月日のチェック)
                    .ifNot(ShotokuShokaiTaishoshaIchiranSpec.抽出期間TO時分秒)
                    .thenAdd(ShotokuShokaiTaishoshaIchiranValidationMessages.抽出期間TO時分秒のチェック)
                    .ifNot(ShotokuShokaiTaishoshaIchiranSpec.日付関係)
                    .thenAdd(ShotokuShokaiTaishoshaIchiranValidationMessages.日付関係のチェック)
                    .messages());
            return messages;
        }

    }

    private static enum ShotokuShokaiTaishoshaIchiranValidationMessages implements IValidationMessage {

        抽出基準年度のチェック(UrErrorMessages.必須, 抽出基準年度メッセージ.toString()),
        抽出期間FROM年月日のチェック(UrErrorMessages.必須, 抽出期間FROM年月日メッセージ.toString()),
        抽出期間FROM時分秒のチェック(UrErrorMessages.必須, 抽出期間FROM時分秒メッセージ.toString()),
        抽出期間TO年月日のチェック(UrErrorMessages.必須, 抽出期間TO年月日メッセージ.toString()),
        抽出期間TO時分秒のチェック(UrErrorMessages.必須, 抽出期間TO時分秒メッセージ.toString()),
        日付関係のチェック(UrErrorMessages.終了日が開始日以前);
        private final Message message;

        ShotokuShokaiTaishoshaIchiranValidationMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
