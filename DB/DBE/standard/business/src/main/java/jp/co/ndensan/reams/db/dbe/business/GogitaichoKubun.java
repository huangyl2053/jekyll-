/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.ur.urz.business.ICodeAssignedItem;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.Messages;

/**
 * 合議体（介護認定審査会）の長や長代理、委員などの区分を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class GogitaichoKubun implements ICodeAssignedItem {

    private final RString code;
    private final RString name;
    private final RString shortName;

    /**
     * 空の合議体長区分を取得します。
     */
    public GogitaichoKubun() {
        this.code = RString.EMPTY;
        this.name = RString.EMPTY;
        this.shortName = RString.EMPTY;
    }

    /**
     * コードと名称を持つ合議体長区分を生成します。
     *
     * @param code コード
     * @param name 名称
     * @throws NullPointerException 引数のいずれかにnullが渡されたとき
     */
    public GogitaichoKubun(RString code, RString name) throws NullPointerException {
        this.code = requireNonNull(code, Messages.E00003.replace("コード", getClass().getName()).getMessage());
        this.name = requireNonNull(name, Messages.E00003.replace("名称", getClass().getName()).getMessage());
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
