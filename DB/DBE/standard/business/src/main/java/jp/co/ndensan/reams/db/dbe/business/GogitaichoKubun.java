/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaichoKubunCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.Messages;

/**
 * 合議体長区分を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class GogitaichoKubun {

    private final GogitaichoKubunCode 区分コード;
    private final RString 区分名称;

    /**
     * 引数からメンバを受け取り、インスタンスを生成します。
     *
     * @param 区分コード 合議体長区分コード
     * @param 区分名称 合議体長区分名称
     * @throws NullPointerException 引数のいずれかにnullが渡されたとき
     */
    public GogitaichoKubun(GogitaichoKubunCode 区分コード, RString 区分名称) throws NullPointerException {
        this.区分コード = requireNonNull(区分コード, Messages.E00003.replace("区分コード", getClass().getName().toString()).getMessage());
        this.区分名称 = requireNonNull(区分名称, Messages.E00003.replace("区分名称", getClass().getName().toString()).getMessage());
    }

    /**
     * 合議体長区分を表すコードを返します。
     *
     * @return 合議体長区分
     */
    public GogitaichoKubunCode get区分コード() {
        return 区分コード;
    }

    /**
     * 区分に割り当てられた名称を返します。
     *
     * @return 合議体長区分名称
     */
    public RString get区分名称() {
        return 区分名称;
    }
}
