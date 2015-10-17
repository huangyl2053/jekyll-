/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.core.valueobject;

import java.util.Objects;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住所地特例適用事由のクラスです。
 *
 * @author N3327 三浦 凌
 */
public class JushochitokureiTekiyoJiyu { //implements ICodeAssignedItem {

    private final RString code;
    private final RString name;

    /**
     * 空の住所地特例適用事由を生成します。
     */
    public JushochitokureiTekiyoJiyu() {
        code = RString.EMPTY;
        name = RString.EMPTY;
    }

    /**
     * 指定のコードと名称をもった住所地特例適用事由を生成します。
     *
     * @param code コード
     * @param name 名称
     */
    public JushochitokureiTekiyoJiyu(RString code, RString name) {
        RString className = new RString("住所地特例適用事由");
        this.code = Objects.requireNonNull(code, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("コード", className.toString()));
        this.name = Objects.requireNonNull(name, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("名称", className.toString()));
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
