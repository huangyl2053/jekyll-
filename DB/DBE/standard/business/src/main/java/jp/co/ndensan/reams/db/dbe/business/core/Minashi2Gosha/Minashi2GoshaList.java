/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.Minashi2Gosha;

import java.util.Iterator;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;

/**
 * みなし2号者のListです。
 *
 * @author n8178 城間篤人
 */
public class Minashi2GoshaList implements Iterable<Minashi2Gosha> {

    private final List<Minashi2Gosha> goshaList;

    /**
     * 引数からみなし2号者のリストを受け取り、インスタンスを生成します。
     *
     * @param minashi2GoshaList みなし2号者のList
     */
    public Minashi2GoshaList(List<Minashi2Gosha> minashi2GoshaList) {
        requireNonNull(minashi2GoshaList, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("みなし2号者List", getClass().getName()));
        this.goshaList = minashi2GoshaList;
    }

    /**
     * Listのサイズを返します。
     *
     * @return サイズ
     */
    public int size() {
        return goshaList.size();
    }

    /**
     * Listが空であるか否かを判断します。
     *
     * @return 空ならtrue
     */
    public boolean isEmpty() {
        return goshaList.isEmpty();
    }

    @Override
    public Iterator<Minashi2Gosha> iterator() {
        return goshaList.iterator();
    }

}
