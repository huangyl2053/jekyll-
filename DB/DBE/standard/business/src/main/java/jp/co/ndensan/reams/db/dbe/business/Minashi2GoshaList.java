/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.Iterator;
import java.util.List;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import static java.util.Objects.requireNonNull;

/**
 * みなし2号者のListです。
 *
 * @author n8178 城間篤人
 */
public class Minashi2GoshaList implements Iterable<Minashi2Gosha> {

    List<Minashi2Gosha> minashi2GoshaList;

    /**
     * 引数からみなし2号者のリストを受け取り、インスタンスを生成します。
     *
     * @param minashi2GoshaList みなし2号者のList
     */
    public Minashi2GoshaList(List<Minashi2Gosha> minashi2GoshaList) {
        requireNonNull(minashi2GoshaList, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("みなし2号者List", getClass().getName()));
        this.minashi2GoshaList = minashi2GoshaList;
    }

    /**
     * Listのサイズを返します。
     *
     * @return
     */
    public int size() {
        return minashi2GoshaList.size();
    }

    /**
     * Listが空であるか否かを判断します。
     *
     * @return 空ならtrue
     */
    public boolean isEmpty() {
        return minashi2GoshaList.isEmpty();
    }

    @Override
    public Iterator<Minashi2Gosha> iterator() {
        return minashi2GoshaList.iterator();
    }

}
