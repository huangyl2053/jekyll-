/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiIinShikakuCode;
import jp.co.ndensan.reams.ur.urz.definition.Messages;

/**
 * 審査会委員資格を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class ShinsakaiIinShikaku {

    private final ShinsakaiIinShikakuCode 区分コード;
    private final RString 区分名称;

    /**
     * 引数からメンバを受け取り、インスタンスを生成します。
     *
     * @param 区分コード 審査会委員資格コード
     * @param 区分名称 審査会委員資格名称
     * @throws NullPointerException 引数のいずれかにnullが渡されたとき
     */
    public ShinsakaiIinShikaku(ShinsakaiIinShikakuCode 区分コード, RString 区分名称) throws NullPointerException {
        this.区分コード = requireNonNull(区分コード, Messages.E00003.replace("区分コード", getClass().getName().toString()).getMessage());
        this.区分名称 = requireNonNull(区分名称, Messages.E00003.replace("区分名称", getClass().getName().toString()).getMessage());
    }

    /**
     * 審査会委員資格を表すコードを返します。
     *
     * @return 審査会委員資格
     */
    public ShinsakaiIinShikakuCode get区分コード() {
        return 区分コード;
    }

    /**
     * 区分に割り当てられた名称を返します。
     *
     * @return 審査会委員資格名称
     */
    public RString get区分名称() {
        return 区分名称;
    }
}
