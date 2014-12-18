/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.hihokenshadaicho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.model.validations.IValidatable;
import jp.co.ndensan.reams.ur.urz.model.validations.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 被保険者台帳に対して、最新の住所地特例解除登録を行う際に必要なバリデーションです。
 *
 * @author n8178 城間篤人
 */
public final class JuchochiTokureiKaijoValidator {

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private JuchochiTokureiKaijoValidator() {
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
        IValidatable setNewestHihokenshaDaicho(HihokenshaDaichoModel hihokenshaDaicho);
    }

    private static class _JuchochiTokureiKaijoTorokuValidator implements IValidatable, INewestHihokenshaDaichoSetter {

        private final FlexibleDate kaijoDate;
        private HihokenshaDaichoModel newestHihokenshaDaicho;

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
        public IValidatable setNewestHihokenshaDaicho(HihokenshaDaichoModel newestHihokenshaDaicho) {
            requireNonNull(newestHihokenshaDaicho, UrSystemErrorMessages.値がnull.getReplacedMessage("最新の被保険者台帳Model"));
            this.newestHihokenshaDaicho = newestHihokenshaDaicho;
            return this;
        }

        @Override
        public IValidationMessages validate() {
            //TODO #55852
            //１）解除処理を行う場合、以下のバリデーションチェックを行う。
            //解除日 ＜ 最新履歴データの資格取得日
            //解除日 ＜ 最新履歴データの資格変更日
            //解除日 ＜ 最新履歴データの住所地特例適用日
            //１－２）チェックに当てはまった場合、以下のメッセージを表示する。
            //　メッセージID：DBAE00002（最新の住所地特例情報として追加することはできません。）
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
