/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ViewExecutionStatus;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.IOptional;
import static jp.co.ndensan.reams.db.dbz.model.validation.ShikakuHenkoValidationMessage.変更日が未入力;
import static jp.co.ndensan.reams.db.dbz.model.validation.ShikakuHenkoValidationMessage.変更事由が未入力;
import static jp.co.ndensan.reams.db.dbz.model.validation.ShikakuHenkoValidationMessage.届出日設定なし;
import static jp.co.ndensan.reams.db.dbz.model.validation.ShikakuHenkoValidationMessage.取得日より前;
import static jp.co.ndensan.reams.db.dbz.model.validation.ShikakuHenkoValidationMessage.喪失日より後;
import static jp.co.ndensan.reams.db.dbz.model.validation.ShikakuHenkoValidationMessage.変更日と前の履歴データの変更日の期間が重複;
import static jp.co.ndensan.reams.db.dbz.model.validation.ShikakuHenkoValidationMessage.変更日と次の履歴データの変更日の期間が重複;
import static jp.co.ndensan.reams.db.dbz.model.validation.ShikakuHenkoValidationMessage.変更日と住所地特例履歴の期間が重複する履歴がある;
import static jp.co.ndensan.reams.db.dbz.model.validation.ShikakuHenkoValidationMessage.変更事由が１号到達で年齢が65歳未満;
import static jp.co.ndensan.reams.db.dbz.model.validation.ShikakuHenkoValidationMessage.変更事由が１号到達以外年齢が40歳未満;
import static jp.co.ndensan.reams.db.dbz.model.validation.ShikakuHenkoValidationMessage.最新の取得日として登録不可;
import jp.co.ndensan.reams.ur.urz.model.context.IContext;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;

/**
 * 呼び出し元が受け取りたい資格変更履歴を一意に特定するための情報を格納するクラスです。
 *
 * @author N8235 船山 洋介
 */
public class ShikakuHenkoRirekiKanriContext implements IContext {

    private final ValidationSpec spec;
    private final ViewExecutionStatus state;
    private final IOptional<HihokenshaDaichoModel> 前履歴;
    private final IOptional<HihokenshaDaichoModel> 次履歴;
    private final IItemList<HihokenshaDaichoModel> 全履歴;

    /**
     * コンストラクタです。
     *
     * @param state 現在のステート
     * @param 前履歴 前履歴
     * @param 次履歴 次履歴
     * @param 全履歴 全履歴
     */
    public ShikakuHenkoRirekiKanriContext(ViewExecutionStatus state,
            IOptional<HihokenshaDaichoModel> 前履歴, IOptional<HihokenshaDaichoModel> 次履歴, IItemList<HihokenshaDaichoModel> 全履歴) {
        this.state = state;
        this.spec = ValidationSpec.toValue(state);
        this.前履歴 = 前履歴;
        this.次履歴 = 次履歴;
        this.全履歴 = 全履歴;
    }

    /**
     * コンストラクタです。
     *
     * @param state 現在のステート
     * @param 前履歴 前履歴
     * @param 次履歴 次履歴
     */
    public ShikakuHenkoRirekiKanriContext(ViewExecutionStatus state, IOptional<HihokenshaDaichoModel> 前履歴, IOptional<HihokenshaDaichoModel> 次履歴) {
        this.state = state;
        this.spec = ValidationSpec.toValue(state);
        this.前履歴 = 前履歴;
        this.次履歴 = 次履歴;
        this.全履歴 = ItemList.empty();
    }

    /**
     * Stateを返します。
     *
     * @return ViewExecutionStatus
     */
    public ViewExecutionStatus getState() {
        return state;
    }

    /**
     * バリデーションチェックを行うか判定します。
     *
     * @param message バリデーションメッセージ
     * @return バリデーションチェックを行う場合：True
     */
    public boolean shouldSkipValidation(IValidationMessage message) {
        return !spec.contains(message);
    }

    /**
     * 資格変更情報の前の（処理日時が古い）履歴を返します。
     *
     * @return IOptional<HihokenshaDaichoModel>
     */
    public IOptional<HihokenshaDaichoModel> get前履歴() {
        return this.前履歴;
    }

    /**
     * 資格変更情報の次の（処理日時が新しい）履歴を表示します。
     *
     * @return IOptional<HihokenshaDaichoModel>
     */
    public IOptional<HihokenshaDaichoModel> get次履歴() {
        return this.次履歴;
    }

    /**
     * 資格変更情報の全履歴を返します。
     *
     * @return IItemList<HihokenshaDaichoModel>
     */
    public IItemList<HihokenshaDaichoModel> get全履歴() {
        return this.全履歴;
    }

    private enum ValidationSpec {

        追加(ViewExecutionStatus.Add, 変更日が未入力, 届出日設定なし, 変更事由が未入力, 変更日と住所地特例履歴の期間が重複する履歴がある,
                変更日と前の履歴データの変更日の期間が重複, 最新の取得日として登録不可),
        修正(ViewExecutionStatus.Modify, 変更日が未入力, 届出日設定なし, 変更事由が未入力, 取得日より前, 喪失日より後,
                変更事由が１号到達以外年齢が40歳未満, 変更事由が１号到達で年齢が65歳未満,
                変更日と次の履歴データの変更日の期間が重複, 変更日と前の履歴データの変更日の期間が重複),
        なし(ViewExecutionStatus.None, null);

        private final ViewExecutionStatus state;
        private final List<IValidationMessage> messages;

        private ValidationSpec(ViewExecutionStatus state, IValidationMessage message, IValidationMessage... any) {
            this.state = state;
            List<IValidationMessage> list = new ArrayList<>();
            list.add(message);
            list.addAll(Arrays.asList(any));
            this.messages = Collections.unmodifiableList(list);
        }

        boolean contains(IValidationMessage messages) {
            return this.messages.contains(messages);
        }

        ViewExecutionStatus getState() {
            return this.state;
        }

        private static ValidationSpec toValue(ViewExecutionStatus e) {
            for (ValidationSpec value : values()) {
                if (value.getState() == e) {
                    return value;
                }
            }
            return なし;
        }
    }
}
