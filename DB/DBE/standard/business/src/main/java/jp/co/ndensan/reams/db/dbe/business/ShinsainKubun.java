/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsainKubunCode;
import jp.co.ndensan.reams.ur.urz.definition.Messages;

/**
 * 審査員区分を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class ShinsainKubun {

    private final ShinsainKubunCode 区分コード;
    private final RString 区分名称;

    /**
     * 引数からメンバを受け取り、インスタンスを生成します。
     *
     * @param 区分コード 審査員区分コード
     * @param 区分名称 審査員区分名称
     * @throws NullPointerException 引数のいずれかにnullが渡されたとき
     */
    public ShinsainKubun(ShinsainKubunCode 区分コード, RString 区分名称) throws NullPointerException {
        this.区分コード = requireNonNull(区分コード, Messages.E00003.replace("区分コード", getClass().getName().toString()).getMessage());
        this.区分名称 = requireNonNull(区分名称, Messages.E00003.replace("区分名称", getClass().getName().toString()).getMessage());
    }

    /**
     * 審査員区分を表すコードを返します。
     *
     * @return 審査員区分
     */
    public ShinsainKubunCode get区分コード() {
        return 区分コード;
    }

    /**
     * 区分に割り当てられた名称を返します。
     *
     * @return 審査員区分名称
     */
    public RString get区分名称() {
        return 区分名称;
    }
}
