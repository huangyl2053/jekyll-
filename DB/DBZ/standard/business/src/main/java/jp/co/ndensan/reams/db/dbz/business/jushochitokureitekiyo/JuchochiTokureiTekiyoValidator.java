/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.jushochitokureitekiyo;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.model.validation.IValidatable;
import jp.co.ndensan.reams.ur.urz.model.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 被保険者台帳に対して、最新の住所地特例適用登録を行う際に必要なバリデーションです。
 *
 * @author n8178 城間篤人
 */
public final class JuchochiTokureiTekiyoValidator {

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private JuchochiTokureiTekiyoValidator() {
    }

    /**
     * 住所地特例の適用日を設定します。
     *
     * @param tekiyoDate 住所地特例適用日
     * @return 最新被保険者台帳情報を設定するためのインターフェース
     */
    public static INewestHihokenshaDaichoSetter setTekiyoDate(FlexibleDate tekiyoDate) {
        return new _JuchochiTokureiTekiyoTorokuValidator(tekiyoDate);
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

    private static class _JuchochiTokureiTekiyoTorokuValidator implements IValidatable, INewestHihokenshaDaichoSetter {

        private final FlexibleDate tekiyoDate;
        private HihokenshaDaicho newestHihokenshaDaicho;

        /**
         * コンストラクタです。
         *
         * @param tekiyoDate 適用日
         */
        public _JuchochiTokureiTekiyoTorokuValidator(FlexibleDate tekiyoDate) {
            requireNonNull(tekiyoDate, UrSystemErrorMessages.値がnull.getReplacedMessage("適用日"));
            this.tekiyoDate = tekiyoDate;
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
                    ValidateChain.validateStart(tekiyoDate)
                    .ifNot(JuchochiTokureiTekiyoSpec.適用日が資格取得年月日より前)
                    .thenAdd(JuchochiTokureiTekiyoValidatorMessage.住所地特例適用日が_最新履歴の取得日_変更日_住所地特例解除日より前)
                    .messages());
            validationMessages.add(
                    ValidateChain.validateStart(newestHihokenshaDaicho)
                    .ifNot(JuchochiTokureiTekiyoSpec.最新の資格変更年月日がNullでないこと)
                    .thenAdd(JuchochiTokureiTekiyoValidatorMessage.住所地特例適用日が_最新履歴の取得日_変更日_住所地特例解除日より前)
                    .ifNot(JuchochiTokureiTekiyoSpec.最新の解除年月日がNullでないこと)
                    .thenAdd(JuchochiTokureiTekiyoValidatorMessage.住所地特例適用日が_最新履歴の取得日_変更日_住所地特例解除日より前)
                    .messages());
            return validationMessages;
        }
    }
}
