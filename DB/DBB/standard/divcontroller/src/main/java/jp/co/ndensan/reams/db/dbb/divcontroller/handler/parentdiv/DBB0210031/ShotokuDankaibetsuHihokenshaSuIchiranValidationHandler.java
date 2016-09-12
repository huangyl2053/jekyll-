/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0210031;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0210031.ShotokuDankaibetsuHihokenshaSuIchiranDiv;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionary;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBBGM21004_段階別被保険者数一覧表作成
 *
 * @reamsid_L DBB-1820-010 chenyadong
 */
public class ShotokuDankaibetsuHihokenshaSuIchiranValidationHandler {

    private final ShotokuDankaibetsuHihokenshaSuIchiranDiv div;
    private static final RString 資格基準日 = new RString("資格基準日");
    private static final RString 調定基準日 = new RString("調定基準日");
    private static final RString 本算定賦課が実行されない = new RString("本算定賦課が実行されない");
    private static final RString 本処理の実行 = new RString("本処理の実行");

    /**
     * コンストラクタです。
     *
     * @param div ShotokuDankaibetsuHihokenshaSuIchiranDiv
     */
    public ShotokuDankaibetsuHihokenshaSuIchiranValidationHandler(ShotokuDankaibetsuHihokenshaSuIchiranDiv div) {
        this.div = div;
    }

    /**
     * 実行と条件保存ボタンクリック時のバリデーションチェック。
     *
     * @return バリデーション突合結果
     */
    /*  public ValidationMessageControlPairs validate() {
     IValidationMessages messages = new ControlValidator(div).validate();
     return createDictionary().check(messages);
     }*/
    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(ShotokuDankaibetsuHihokenshaSuIchiranValidationMessages.本算定賦課処理_NotEmpty,
                        div.getTxtHonsanteiShoriYMD())
                .add(ShotokuDankaibetsuHihokenshaSuIchiranValidationMessages.資格基準日_入力,
                        div.getTxtShikakuKijunYMD())
                .add(ShotokuDankaibetsuHihokenshaSuIchiranValidationMessages.調定基準日_入力,
                        div.getTxtShikakuKijunYMD())
                .add(ShotokuDankaibetsuHihokenshaSuIchiranValidationMessages.資格基準日より調定基準日_だめ,
                        div.getChushutsuJoken())
                .build();
    }

    /**
     * 「 実行と条件保存ボタンクリック時のバリデーションチェック。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(ShotokuDankaibetsuHihokenshaSuIchiranSpec.本算定賦課処理_NotEmpty)
                .thenAdd(ShotokuDankaibetsuHihokenshaSuIchiranValidationMessages.本算定賦課処理_NotEmpty)
                .ifNot(ShotokuDankaibetsuHihokenshaSuIchiranSpec.資格基準日_入力)
                .thenAdd(ShotokuDankaibetsuHihokenshaSuIchiranValidationMessages.資格基準日_入力)
                .ifNot(ShotokuDankaibetsuHihokenshaSuIchiranSpec.調定基準日_入力)
                .thenAdd(ShotokuDankaibetsuHihokenshaSuIchiranValidationMessages.調定基準日_入力)
                .ifNot(ShotokuDankaibetsuHihokenshaSuIchiranSpec.資格基準日より調定基準日_だめ)
                .thenAdd(ShotokuDankaibetsuHihokenshaSuIchiranValidationMessages.資格基準日より調定基準日_だめ)
                .messages());
        validPairs.add(createDictionary().check(messages));
        return validPairs;
    }

    private static enum ShotokuDankaibetsuHihokenshaSuIchiranSpec implements IPredicate<ShotokuDankaibetsuHihokenshaSuIchiranDiv> {

        本算定賦課処理_NotEmpty {
                    @Override
                    public boolean apply(ShotokuDankaibetsuHihokenshaSuIchiranDiv div) {
                        return div.getTxtHonsanteiShoriYMD().getValue() != null
                        && !div.getTxtHonsanteiShoriYMD().getValue().toString().isEmpty();
                    }
                },
        資格基準日_入力 {
                    @Override
                    public boolean apply(ShotokuDankaibetsuHihokenshaSuIchiranDiv div) {
                        return div.getTxtShikakuKijunYMD().getValue() != null
                        && !div.getTxtShikakuKijunYMD().getValue().toString().isEmpty();
                    }
                },
        調定基準日_入力 {
                    @Override
                    public boolean apply(ShotokuDankaibetsuHihokenshaSuIchiranDiv div) {
                        return div.getTxtChoteiKijunYMD().getValue() != null
                        && !div.getTxtChoteiKijunYMD().getValue().toString().isEmpty();
                    }
                },
        資格基準日より調定基準日_だめ {

                    @Override
                    public boolean apply(ShotokuDankaibetsuHihokenshaSuIchiranDiv div) {
                        return div.getTxtShikakuKijunYMD().getValue().compareTo(div.getTxtChoteiKijunYMD()
                                .getValue()) <= 0;
                    }
                };
    }

    private enum ShotokuDankaibetsuHihokenshaSuIchiranValidationMessages implements IValidationMessage {

        本算定賦課処理_NotEmpty(DbzErrorMessages.実行不可, 本算定賦課が実行されない.toString(), 本処理の実行.toString()), 
        資格基準日_入力(UrErrorMessages.必須, 資格基準日.toString()),
        調定基準日_入力(UrErrorMessages.必須, 調定基準日.toString()),
        資格基準日より調定基準日_だめ(DbzErrorMessages.期間が不正_未来日付不可, 資格基準日.toString(), 調定基準日.toString());
        private final Message message;

        ShotokuDankaibetsuHihokenshaSuIchiranValidationMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }

    }
}
