/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import jp.co.ndensan.reams.ur.urz.business.ICodeAssignedItem;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 病院、診療所、助産所といった、医療機関の区分を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class IryoKikanKubun implements ICodeAssignedItem {

    private final RString code;
    private final RString name;
    private final RString shortName;

    /**
     * 医療機関区分を生成します。
     */
    public IryoKikanKubun() {
        this.code = RString.EMPTY;
        this.name = RString.EMPTY;
        this.shortName = RString.EMPTY;
    }

    @Override
    public RString getCode() {
        return code;
    }

    @Override
    public RString getName() {
        return name;
    }

    @Override
    public RString getShortName() {
        return shortName;
    }
}
