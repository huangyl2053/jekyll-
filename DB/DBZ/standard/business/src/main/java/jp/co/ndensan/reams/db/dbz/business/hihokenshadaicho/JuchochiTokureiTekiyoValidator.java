/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.hihokenshadaicho;

import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.model.validations.IValidatable;
import jp.co.ndensan.reams.ur.urz.model.validations.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import static java.util.Objects.requireNonNull;

/**
 * 被保険者台帳に対して、最新の住所地特例適用登録を行う際に必要なバリデーションです。
 *
 * @author n8178 城間篤人
 */
public class JuchochiTokureiTekiyoValidator {

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
        IValidatable setNewestHihokenshaDaicho(HihokenshaDaichoModel hihokenshaDaicho);
    }

    private static class _JuchochiTokureiTekiyoTorokuValidator implements IValidatable, INewestHihokenshaDaichoSetter {

        private final FlexibleDate tekiyoDate;
        private HihokenshaDaichoModel newestHihokenshaDaicho;

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
        public IValidatable setNewestHihokenshaDaicho(HihokenshaDaichoModel newestHihokenshaDaicho) {
            requireNonNull(newestHihokenshaDaicho, UrSystemErrorMessages.値がnull.getReplacedMessage("最新の被保険者台帳Model"));
            this.newestHihokenshaDaicho = newestHihokenshaDaicho;
            return this;
        }

        @Override
        public IValidationMessages validate() {
            //TODO #55852
            //１）以下のバリデーションチェックを行う。
            //適用日 ＜ 最新履歴データの資格取得日
            //適用日 ＜ 最新履歴データの資格変更日
            //適用日 ＜ 最新履歴データの住所地特例解除日
            //２）チェックに当てはまった場合、以下のメッセージを表示する。
            //　メッセージID：DBAE00002（最新の住所地特例情報として追加することはできません。）
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
