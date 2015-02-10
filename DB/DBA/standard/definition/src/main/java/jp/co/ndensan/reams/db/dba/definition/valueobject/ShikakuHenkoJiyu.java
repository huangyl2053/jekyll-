/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.valueobject;

import java.util.Objects;
//TODO n3327 三浦凌 ICodeAssinedItemがdefinitionへ移動されたら、当該インタフェースを実装する。
//import jp.co.ndensan.reams.ur.urz.business.ICodeAssignedItem;
import jp.co.ndensan.reams.uz.uza.message.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格変更事由のクラスです。
 *
 * @author N3327 三浦 凌
 */
public class ShikakuHenkoJiyu { //implements ICodeAssignedItem {

    private final RString code;
    private final RString name;

    /**
     * 空の資格変更事由を生成します。
     */
    public ShikakuHenkoJiyu() {
        code = RString.EMPTY;
        name = RString.EMPTY;
    }

    /**
     * 指定のコードと名称をもった資格変更事由を生成します。
     *
     * @param code コード
     * @param name 名称
     */
    public ShikakuHenkoJiyu(RString code, RString name) {
        RString className = new RString("資格変更事由");
        this.code = Objects.requireNonNull(code, Messages.E00003.replace("コード", className.toString()).getMessage());
        this.name = Objects.requireNonNull(name, Messages.E00003.replace("名称", className.toString()).getMessage());
    }

    /**
     * コードを取得する。
     *
     * @return コード
     */
    public RString getCode() {
        return code;
    }

    /**
     * 名称を取得する。
     *
     * @return 名称
     */
    public RString getName() {
        return name;
    }
}
