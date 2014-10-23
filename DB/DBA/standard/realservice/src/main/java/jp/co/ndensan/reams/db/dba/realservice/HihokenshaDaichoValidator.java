/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.realservice;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.model.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.model.util.items.IItemList;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.model.IDateOfBirth;
import jp.co.ndensan.reams.ur.urz.model.validations.IValidatable;
import jp.co.ndensan.reams.ur.urz.model.validations.IValidationMessages;
import static jp.co.ndensan.reams.ur.urz.model.validations.ValidationChain.validateFollowingItems;

/**
 * 資格取得処理で利用するバリデーションチェック処理を提供するクラスです。
 *
 * @author n8178 城間篤人
 */
public class HihokenshaDaichoValidator implements IValidatable {

    private final IItemList<HihokenshaDaichoModel> hihokenshaDaichoModelList;
    private final IDateOfBirth dateOfBirth;

    /**
     * コンストラクタです。
     *
     * @param hihokenshaDaichoModelList 被保険者台帳ModelList
     * @param dateOfBirth 生年月日
     * @throw NullPointerException 引数のいずれかにNullが渡された場合
     * @throw IllegalArgumentException 引数から渡された被保険者台帳ModelListが空だった場合
     */
    public HihokenshaDaichoValidator(IItemList<HihokenshaDaichoModel> hihokenshaDaichoModelList, IDateOfBirth dateOfBirth)
            throws NullPointerException, IllegalArgumentException {
        requireNonNull(hihokenshaDaichoModelList, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("引数のmodelList", getClass().getSimpleName()));
        requireNonNull(dateOfBirth, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("生年月日", getClass().getSimpleName()));

        if (hihokenshaDaichoModelList.isEmpty()) {
            throw new IllegalArgumentException(UrSystemErrorMessages.値がempty.getReplacedMessage("引数のmodelList"));
        }

        this.hihokenshaDaichoModelList = hihokenshaDaichoModelList;
        this.dateOfBirth = dateOfBirth;
    }

    //TODO #52997 外部からDacを受け取る、Test用コンストラクタを作成する。
    //HihokenshaDaichoValidator(IItemList<HihokenshaDaichoModel> hihokenshaDaichoModelList, IDateOfBirth dateOfBirth, HihokenshaDaichoDac){
    //}
    @Override
    public IValidationMessages validate() {
        return validateFollowingItems()
                // TODO #52997 バリデーション処理を実装する
                //1, 被保険者番号が登録済み ならメッセージを返す。
                //.then(address)
                //
                //2, 取得日 < 前の履歴データの喪失日 ならメッセージを返す。
                // thenはIValidatable、IValidatableWithContextの他にIValidationMessagesを返すメソッドも受け取れる
                //
                //3, 資格取得対象者の年齢が、資格取得可能 ならメッセージを返す。
                //.then(validateExistence(address.getChoiki()))
                //
                //4, 他市町村住所地特例テーブルに対象者の該当データが存在する場合、入力した取得日が、他市町村住所地特例該当データの適用日と解除日の期間に含まれる場合、メッセージを返す。
                //メッセージID：URZE00025（期間が重複しています。）
                //
                //5, 適用除外者テーブルに対象者の該当データが存在する場合、入力した取得日が、適用除外者該当データの適用日と解除日の期間に含まれる場合、メッセージを返す。
                //メッセージID：URZE00025（期間が重複しています。）
                //
                // 終了
                .end();
    }
}
