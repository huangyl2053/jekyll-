/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition;

import java.util.Objects;
//TODO n3327 三浦凌　ICodeAssignedItemが参照でいないのでコメントアウト。方針が決まったら、修正する。
//import jp.co.ndensan.reams.ur.urz.business.ICodeAssignedItem;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;

/**
 * 病院、診療所、助産所といった、医療機関の区分を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class IryoKikanKubun { //implements ICodeAssignedItem {

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
        requireNonNull(コード, UrSystemErrorMessages.値がnull.getReplacedMessage("コード", getClass().getName()));
        requireNonNull(名称, UrSystemErrorMessages.値がnull.getReplacedMessage("名称", getClass().getName()));
        requireNonNull(略称, UrSystemErrorMessages.値がnull.getReplacedMessage("略称", getClass().getName()));

        this.code = コード;
        this.name = 名称;
        this.shortName = 略称;
    }

    /**
     * コードを返します。
     *
     * @return コード
     */
    //@Override
    public RString getCode() {
        return code;
    }

    /**
     * 名称を返します。
     *
     * @return 名称
     */
    //@Override
    public RString getName() {
        return name;
    }

    /**
     * 略称を返します。
     *
     * @return 略称
     */
    //@Override
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
