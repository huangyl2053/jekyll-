/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.ur.urz.divcontroller.validations;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * バリデーションメッセージとコントロールとのマッピングのルールを持つクラスです。<br/>
 * 使用例：<br/>
 * 1.インスタンス生成時にバリデーションメッセージと紐付けするコントロールのコレクションをコンストラクタで渡します。<br/>
 * 2.{@link check}メソッドを用いて、渡されたメッセージに対応するバリデーションメッセージと紐付けするコントロールのコレクションを返します。<br/>
 *
 * @author n8185 上田 典明
 * @jpName バリデーションメッセージ制御ルール
 * @bizDomain 業務共通_コア
 * @category バリデーション
 * @subCategory クライアントバリデーション
 * @mainClass ○
 * @reference
 * @deprecated
 * {@link jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionary}
 * を使用してください。1.12.0で削除されたクラスです。ｄ
 */
@Deprecated
public class ValidationMessageControlDictionary {

    private final Map<Message, ValidationMessageControlPair> checklist;

    /**
     * コンストラクタです。
     *
     * @param validationMessagePairs バリデーションメッセージと紐付けするコントロールのコレクション
     */
    public ValidationMessageControlDictionary(ValidationMessageControlPairs validationMessagePairs) {
        this.checklist = new HashMap<>();
        for (ValidationMessageControlPair pair : validationMessagePairs) {
            this.checklist.put(pair.getMessage(), pair);
        }
    }

    /**
     * コンストラクタです。
     *
     * @param validationMessagePairs バリデーションメッセージと紐付けするコントロールのコレクション
     */
    public ValidationMessageControlDictionary(ValidationMessageControlPair... validationMessagePairs) {
        this.checklist = new HashMap<>();
        for (ValidationMessageControlPair pair : validationMessagePairs) {
            this.checklist.put(pair.getMessage(), pair);
        }
    }

    /**
     * 引数で渡されたバリデーションメッセージに対応するメッセージとコントロールのペアを返します。
     *
     * @param items ペアを取得するバリデーションメッセージのコレクション
     * @return メッセージとコントロールのペアのコレクション
     */
    public ValidationMessageControlPairs check(IValidationMessages items) {
        ValidationMessageControlPairs result = new ValidationMessageControlPairs();
        for (IValidationMessage item : items.getList()) {
            if (checklist.containsKey(item.getMessage())) {
                result.add(checklist.get(item.getMessage()));
            }
        }
        return result;
    }

}
