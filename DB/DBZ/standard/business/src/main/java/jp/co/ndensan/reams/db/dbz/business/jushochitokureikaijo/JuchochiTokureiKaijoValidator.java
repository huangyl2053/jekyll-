/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.jushochitokureikaijo;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.model.validation.IValidatable;
import jp.co.ndensan.reams.ur.urz.model.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 被保険者台帳に対して、最新の住所地特例解除登録を行う際に必要なバリデーションです。
 *
 * @author n8178 城間篤人
 */
public final class JuchochiTokureiKaijoValidator {

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    //private final JushochitokureiKaijo nothing;

//   private JuchochiTokureiKaijoValidator(JushochitokureiKaijo jushochitokureiKaijo) {
    private JuchochiTokureiKaijoValidator() {
        //this.nothing = jushochitokureiKaijo;
    }

    /**
     * 住所地特例の解除日を設定します。
     *
     * @param tekiyoDate 住所地特例解除日
     * @return 最新の被保険者台帳情報を設定するためのインターフェース
     */
    public static INewestHihokenshaDaichoSetter setKaijoDate(FlexibleDate tekiyoDate) {
        return new _JuchochiTokureiKaijoTorokuValidator(tekiyoDate);
    }

    /**
     * バリデーションに使用する、最新の被保険者台帳情報を設定するためのインターフェースです。
     */
    public interface INewestHihokenshaDaichoSetter {

        /**
         * 最新の被保険者台帳情報を設定します。
         *
         * @param hihokenshaDaicho 被保険者台帳情報
         * @return バリデーションクラスを扱うインターフェース
         */
        IValidatable setNewestHihokenshaDaicho(HihokenshaDaicho hihokenshaDaicho);
    }

    private static class _JuchochiTokureiKaijoTorokuValidator implements IValidatable, INewestHihokenshaDaichoSetter {

        private final FlexibleDate kaijoDate;
        private HihokenshaDaicho newestHihokenshaDaicho;

        /**
         * コンストラクタです。
         *
         * @param kaijoDate 解除日
         */
        public _JuchochiTokureiKaijoTorokuValidator(FlexibleDate kaijoDate) {
            requireNonNull(kaijoDate, UrSystemErrorMessages.値がnull.getReplacedMessage("解除日"));
            this.kaijoDate = kaijoDate;
        }

        @Override
        public IValidatable setNewestHihokenshaDaicho(HihokenshaDaicho newestHihokenshaDaicho) {
            requireNonNull(newestHihokenshaDaicho, UrSystemErrorMessages.値がnull.getReplacedMessage("最新の被保険者台帳Model"));
            this.newestHihokenshaDaicho = newestHihokenshaDaicho;
            return this;
        }

        @Override
        public IValidationMessages validate() {
            IValidationMessages validationMessages = ValidationMessagesFactory.createInstance();
            validationMessages.add(
                    ValidateChain.validateStart(kaijoDate)
                    .ifNot(JuchochiTokureiKaijoSpec.解除日が資格取得年月日より前)
                    .thenAdd(JuchochiTokureiKaijoValidatorMessage.住所地特例解除日が_最新履歴の取得日_変更日_住所地特例適用日より前)
                    .messages());
            validationMessages.add(
                    ValidateChain.validateStart(newestHihokenshaDaicho)
                    .ifNot(JuchochiTokureiKaijoSpec.最新の資格変更年月日がNullでないこと)
                    .thenAdd(JuchochiTokureiKaijoValidatorMessage.住所地特例解除日が_最新履歴の取得日_変更日_住所地特例適用日より前)
                    .ifNot(JuchochiTokureiKaijoSpec.最新の適用年月日がNullでないこと)
                    .thenAdd(JuchochiTokureiKaijoValidatorMessage.住所地特例解除日が_最新履歴の取得日_変更日_住所地特例適用日より前)
                    .messages());
            return validationMessages;
        }
    }
}
