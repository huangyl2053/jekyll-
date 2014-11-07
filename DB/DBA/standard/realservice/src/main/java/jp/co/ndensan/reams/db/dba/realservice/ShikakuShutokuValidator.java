/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.realservice;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.model.HihokenshaDaichoModel;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.model.IDateOfBirth;
import jp.co.ndensan.reams.ur.urz.model.validations.IValidatable;
import jp.co.ndensan.reams.ur.urz.model.validations.IValidationMessages;
import static jp.co.ndensan.reams.ur.urz.model.validations.ValidationChain.validateFollowingItems;

/**
 * 資格取得処理で利用するバリデーションチェック処理を提供するクラスです。<br/>
 * <pre>
 * 使用例：
 * ShikakuShutokuValidator.setValidationTarget(targetModel)
 *      .setBeforeData(beforeModel).setDateOfBirth(dateOfBirth).validate();
 * </pre>
 *
 * @author n8178 城間篤人
 */
public final class ShikakuShutokuValidator {

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private ShikakuShutokuValidator() {
    }

    /**
     * バリデーションチェックの対象となる被保険者台帳Modelを設定します。
     *
     * @param validationTarget バリデーションチェック対象の被保険者台帳Model
     * @return 前履歴の被保険者台帳Modelを渡すためのクラス
     */
    public static IBeforeDataSetter setValidationTarget(HihokenshaDaichoModel validationTarget) {
        return new _ShikakuShutokuValidator(validationTarget);
    }

    /**
     * バリデーションチェックで比較対象となる、1つ前の履歴情報を設定する機能を提供することを示すインターフェースです。
     */
    public interface IBeforeDataSetter {

        /**
         * バリデーションチェックで比較対象となる、1つ前の履歴のデータを設定します。
         *
         * @param beforeData 1つ前の履歴データの被保険者台帳Model
         * @return 生年月日を渡すためのクラス
         */
        IDateOfBirthSetter setBeforeData(HihokenshaDaichoModel beforeData);
    }

    /**
     * バリデーションチェックで使用する、生年月日を設定する機能を提供するインターフェースです。
     */
    public interface IDateOfBirthSetter {

        /**
         * バリデーションチェックで比較対象となる、資格取得者の生年月日を設定します。
         *
         * @param dateOfBirth 資格取得者の生年月日
         * @return バリデーションチェックを行うクラス
         */
        IValidatable setDateOfBirth(IDateOfBirth dateOfBirth);
    }

    private static class _ShikakuShutokuValidator implements IValidatable, IBeforeDataSetter, IDateOfBirthSetter {

        private final HihokenshaDaichoModel validateTarget;
        private HihokenshaDaichoModel beforeData;
        private IDateOfBirth dateOfBirth;

        /**
         * コンストラクタです。
         *
         * @param validationTarget バリデーションチェック対象の被保険者台帳Model
         */
        public _ShikakuShutokuValidator(HihokenshaDaichoModel validateTarget) {
            requireNonNull(validateTarget, UrSystemErrorMessages.値がnull.getReplacedMessage("バリデーションチェック対象のModel"));
            this.validateTarget = validateTarget;
        }

        @Override
        public IDateOfBirthSetter setBeforeData(HihokenshaDaichoModel beforeData) {
            requireNonNull(validateTarget, UrSystemErrorMessages.値がnull.getReplacedMessage("1つ前の履歴データの被保険者台帳Model"));
            this.beforeData = beforeData;
            return this;
        }

        @Override
        public IValidatable setDateOfBirth(IDateOfBirth dateOfBirth) {
            requireNonNull(validateTarget, UrSystemErrorMessages.値がnull.getReplacedMessage("資格取得者の生年月日"));
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        //TODO #52997 外部からDacを受け取る、Test用コンストラクタを作成する。
        //HihokenshaDaichoValidator(IItemList<HihokenshaDaichoModel> hihokenshaDaichoModelList, IDateOfBirth dateOfBirth, HihokenshaDaichoDac){
        //}
        @Override
        public IValidationMessages validate() {
            return validateFollowingItems()
                    // TODO #52997 バリデーション処理を実装する
                    //1, validationTargetが持つ被保険者番号が既に登録済み ならメッセージを返す。
                    //      メッセージID：URZE00016（%1は既に登録されているため使用できません。）%1:被保険者番号
                    //こちらのバリデーションは当該クラスの中にprivateMethodを用意し、その中で実装してください。
                    //データアクセスが必要なチェックのためDacが必要です。
                    //
                    //2, validationTargetの取得日 < 前の履歴データ(BeforeData)の喪失日 ならメッセージを返す。
                    //こちらのバリデーションは、ShikakuTokusoDateValidetorに処理を移譲してください。
                    //
                    //3, 資格取得対象者の年齢が、資格取得可能 ならメッセージを返す。
                    //こちらのバリデーションは、NenreiTotatsuValidetorに処理を移譲してください。
                    //
                    //4, 他市町村住所地特例テーブルに対象者の該当データが存在する時、
                    //   入力した取得日が、他市町村住所地特例該当データの適用日と解除日の期間に含まれる場合、メッセージを返す。
                    //      メッセージID：URZE00025（期間が重複しています。）
                    //こちらのバリデーションは当該クラスの中にprivateMethodを用意し、その中で実装してください。
                    //データアクセスが必要なチェックのためDacが必要です。
                    //
                    //5, 適用除外者テーブルに対象者の該当データが存在する時
                    //   入力した取得日が、適用除外者該当データの適用日と解除日の期間に含まれる場合、メッセージを返す。
                    //      メッセージID：URZE00025（期間が重複しています。）
                    //こちらのバリデーションは当該クラスの中にprivateMethodを用意し、その中で実装してください。
                    //データアクセスが必要なチェックのためDacが必要です。
                    //
                    .end();
        }

    }
}
