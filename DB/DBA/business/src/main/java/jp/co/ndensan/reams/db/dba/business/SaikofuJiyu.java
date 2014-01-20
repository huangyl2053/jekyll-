/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business;

import java.util.Objects;
import jp.co.ndensan.reams.ur.urz.business.ICodeAssignedItem;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者証の再交付事由のクラスです。
 *
 * @author N3327 三浦 凌
 */
public class SaikofuJiyu implements ICodeAssignedItem {

    private final RString code;
    private final RString name;

    /**
     * 空の再交付事由を生成します。
     */
    public SaikofuJiyu() {
        code = RString.EMPTY;
        name = RString.EMPTY;
    }

    /**
     * 指定のコードと名称をもった再交付事由を生成します。
     *
     * @param code コード
     * @param name 名称
     */
    public SaikofuJiyu(RString code, RString name) {
        RString className = new RString("再交付事由");
        this.code = Objects.requireNonNull(code, Messages.E00003.replace("コード", className.toString()).getMessage());
        this.name = Objects.requireNonNull(name, Messages.E00003.replace("名称", className.toString()).getMessage());
    }

    @Override
    public RString getCode() {
        return code;
    }

    @Override
    public RString getName() {
        return name;
    }
}
