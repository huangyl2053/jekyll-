/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.Iterator;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiIinCode;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import static java.util.Objects.requireNonNull;

/**
 * 合議体割当委員のリストを扱うクラスです。
 *
 * @author n8178 城間篤人
 */
public class GogitaiWariateIinList implements Iterable<GogitaiWariateIin> {

    private final List<GogitaiWariateIin> 合議体割当委員List;

    /**
     * 引数からメンバを受け取るコンストラクタです。
     *
     * @param 合議体割当委員List 合議体割当委員List
     */
    public GogitaiWariateIinList(List<GogitaiWariateIin> 合議体割当委員List) {
        this.合議体割当委員List = requireNonNull(合議体割当委員List,
                Messages.E00003.replace("合議体割当委員List", getClass().getName()).getMessage());
    }

    /**
     * 審査員コードを指定し、合議体Listから審査会委員を取得します。
     *
     * @param 審査会委員コード
     * @return 合議体に割り当てられた審査会委員
     */
    public GogitaiWariateIin get合議体割当委員(ShinsakaiIinCode 審査会委員コード) {
        for (GogitaiWariateIin 合議体割当委員 : 合議体割当委員List) {
            if (審査会委員コード.equals(合議体割当委員.get委員情報().get委員コード())) {
                return 合議体割当委員;
            }
        }
        throw new IllegalArgumentException(Messages.E00006.replace("対応する合議体割当委員").getMessage());
    }

    /**
     * リストの要素数を返します。
     *
     * @return リストの要素数
     */
    public int size() {
        return 合議体割当委員List.size();
    }

    /**
     * リストが空か否かを真理値で返します。
     *
     * @return リストが空ならtrue
     */
    public boolean isEmpty() {
        return 合議体割当委員List.isEmpty();
    }

    @Override
    public Iterator iterator() {
        return 合議体割当委員List.iterator();
    }
}
