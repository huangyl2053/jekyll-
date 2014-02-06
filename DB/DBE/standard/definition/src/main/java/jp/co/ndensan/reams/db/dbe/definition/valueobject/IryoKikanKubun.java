/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import java.util.Objects;
import jp.co.ndensan.reams.ur.urz.business.ICodeAssignedItem;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.Messages;

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

    /**
     * 引数からメンバを受け取るコンストラクタです。
     *
     * @param コード コード
     * @param 名称 名称
     * @param 略称 略称
     */
    public IryoKikanKubun(RString コード, RString 名称, RString 略称) {
        requireNonNull(コード, Messages.E00003.replace("コード", getClass().getName()).getMessage());
        requireNonNull(名称, Messages.E00003.replace("名称", getClass().getName()).getMessage());
        requireNonNull(略称, Messages.E00003.replace("略称", getClass().getName()).getMessage());

        this.code = コード;
        this.name = 名称;
        this.shortName = 略称;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.code);
        return hash;
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null) {
            return false;
        }
        if (getClass() != 比較対象.getClass()) {
            return false;
        }
        return ((IryoKikanKubun) 比較対象).getCode().equals(code);
    }
}
