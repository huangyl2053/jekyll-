/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.valueobject;

import java.util.Objects;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
//TODO n3327 三浦凌 ICodeAssinedItemがdefinitionへ移動されたら、当該インタフェースを実装する。
//import jp.co.ndensan.reams.ur.urz.business.ICodeAssignedItem;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住所地特例解除事由のクラスです。
 *
 * @author N3327 三浦 凌
 */
public class JushochitokureiKaijoJiyu { //implements ICodeAssignedItem {

    private final RString code;
    private final RString name;

    /**
     * 空の住所地特例解除事由を生成します。
     */
    public JushochitokureiKaijoJiyu() {
        code = RString.EMPTY;
        name = RString.EMPTY;
    }

    /**
     * 指定のコードと名称をもった住所地特例解除事由を生成します。
     *
     * @param code コード
     * @param name 名称
     */
    public JushochitokureiKaijoJiyu(RString code, RString name) {
        RString className = new RString("住所地特例解除事由");
        this.code = Objects.requireNonNull(code, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("コード", className.toString()).evalute());
        this.name = Objects.requireNonNull(name, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("名称", className.toString()).evalute());
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
