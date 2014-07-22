/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.Iterator;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;

/**
 * 除外対象審査会委員をリストで扱うクラスです。
 *
 * @author n8178 城間篤人
 */
public class JogaiShinsakaiIinList implements Iterable<JogaiShinsakaiIin> {

    private final List<JogaiShinsakaiIin> 除外審査会委員List;

    /**
     * コンストラクタです。除外審査会委員のリストを受け取り、それを元にインスタンスをせいせいします。
     *
     * @param 除外審査会委員List 除外審査会委員List
     * @throws NullPointerException 引数にnullが渡されたとき
     */
    public JogaiShinsakaiIinList(List<JogaiShinsakaiIin> 除外審査会委員List) throws NullPointerException {
        requireNonNull(除外審査会委員List, UrSystemErrorMessages.値がnull.getReplacedMessage("除外審査会委員List"));
        this.除外審査会委員List = 除外審査会委員List;
    }

    /**
     * 除外審査会委員Listが空であるかどうかを返します。
     *
     * @return 空ならtrue
     */
    public boolean isEmpty() {
        return 除外審査会委員List.isEmpty();
    }

    /**
     * リストのサイズを返します。
     *
     * @return サイズ
     */
    public int size() {
        return 除外審査会委員List.size();
    }

    @Override
    public Iterator<JogaiShinsakaiIin> iterator() {
        return 除外審査会委員List.iterator();
    }

}
