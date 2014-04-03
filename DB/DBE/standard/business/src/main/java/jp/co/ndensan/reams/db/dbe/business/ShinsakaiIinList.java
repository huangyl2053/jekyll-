/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.Iterator;
import java.util.List;

/**
 * 審査会委員リストです。
 *
 * @author n8178 城間篤人
 */
public class ShinsakaiIinList implements Iterable<ShinsakaiIin> {
    //TODO n8178 城間篤人　審査会チケットで必要な分を実装。後の審査会委員チケットで修正される可能性がある 2014年4月

    private List<ShinsakaiIin> 委員List;

    /**
     * 引数から審査会委員のリストを受け取り、インスタンスを生成します。
     *
     * @param 委員List 委員List
     */
    public ShinsakaiIinList(List<ShinsakaiIin> 委員List) {
        this.委員List = 委員List;
    }

    /**
     * リストが空であるか否かを返します。
     *
     * @return 空ならtrue
     */
    public boolean isEmpty() {
        return 委員List.isEmpty();
    }

    /**
     * リストのサイズを整数値で返します。
     *
     * @return サイズ
     */
    public int size() {
        return 委員List.size();
    }

    @Override
    public Iterator<ShinsakaiIin> iterator() {
        return 委員List.iterator();
    }
}
