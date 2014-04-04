/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.ICodeWrapValueObject;
import jp.co.ndensan.reams.ur.urz.business.CodeAssignedItem;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link Code Code}を継承したValueObjcetを扱うために、{@link CodeAssignedItem CodeAssignedItem}を拡張したクラスです。
 *
 * @author N3327 三浦 凌
 * @param <V> {@link Code Code}を継承したクラス
 */
public abstract class KaigoCodeAssignedItem<V extends ICodeWrapValueObject> extends CodeAssignedItem {

    private final V extendedCode;

    /**
     * すべてのメンバを設定するコンストラクタです。
     *
     * @param extendedCode CodeをwrapしたValueObjcet
     * @param code {@link Code Code}
     * @param codeMeisho コード名称
     * @param codeRyakusho コード略称
     * @param option1 任意情報1
     * @param option2 任意情報2
     * @param option3 任意情報3
     */
    public KaigoCodeAssignedItem(V extendedCode, Code code, RString codeMeisho, RString codeRyakusho,
            RString option1, RString option2, RString option3) {
        super(code, codeMeisho, codeRyakusho, option1, option2, option3);
        this.extendedCode = extendedCode;
    }

    /**
     * 任意情報を利用しない場合のコンストラクタです。
     *
     * @param extendedCode CodeをwrapしたValueObjcet
     * @param code {@link Code Code}
     * @param codeMeisho コード名称
     * @param codeRyakusho コード略称
     */
    public KaigoCodeAssignedItem(V extendedCode, Code code, RString codeMeisho, RString codeRyakusho) {
        super(code, codeMeisho, codeRyakusho);
        this.extendedCode = extendedCode;
    }

    /**
     * このクラスが保持する、CodeをwrapしたValueObjcetの値を返します。
     * <p> {@link CodeAssignedItem#getOption1() CodeAssignedItemの任意情報}と同じように、 『何が返るかがメソッド名から明確になるメソッドを実装し、内部では当メソッドに委譲して』
     * ください。すると、わかりやすい名称のメソッドで、CodeをwrapしたValueObjcetの値を取得できます。
     * </p>
     *
     * @return CodeをwrapしたValueObjcet
     */
    protected V getExtendedCode() {
        return this.extendedCode;
    }
}
