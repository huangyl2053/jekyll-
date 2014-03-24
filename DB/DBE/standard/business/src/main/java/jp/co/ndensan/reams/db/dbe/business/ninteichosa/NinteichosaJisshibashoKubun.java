/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.ninteichosa;

import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.NinteichosaJisshibashoKubunCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import static java.util.Objects.requireNonNull;

/**
 * 要介護認定調査の実施場所区分を扱うクラスです。
 *
 * @author N8156 宮本 康
 */
public class NinteichosaJisshibashoKubun {

    private final NinteichosaJisshibashoKubunCode code;
    private final RString name;
    private final RString shortName;

    /**
     * インスタンスを生成します。
     *
     * @param code コード
     * @param name 名称
     * @param shortName 略称
     */
    public NinteichosaJisshibashoKubun(NinteichosaJisshibashoKubunCode code, RString name, RString shortName) {
        this.code = requireNonNull(code, Messages.E00001.replace("コード").getMessage());
        this.name = requireNonNull(name, Messages.E00001.replace("名称").getMessage());
        this.shortName = requireNonNull(shortName, Messages.E00001.replace("略称").getMessage());
    }

    /**
     * コードを返します。
     *
     * @return コード
     */
    public NinteichosaJisshibashoKubunCode getCode() {
        return code;
    }

    /**
     * 名称を返します。
     *
     * @return 名称
     */
    public RString getName() {
        return name;
    }

    /**
     * 略称を返します。
     *
     * @return 略称
     */
    public RString getShortName() {
        return shortName;
    }
}
