/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.HihokenshaList;
import jp.co.ndensan.reams.db.dbz.business.INinteiShinseiTaishosha;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;

/**
 * 認定申請の対象になる者（被保険者、みなし2号者など）のリストです。
 *
 * @author n8178 城間篤人
 */
public class NinteiShinseiTaishoshaList implements Iterable<INinteiShinseiTaishosha> {

    List<INinteiShinseiTaishosha> ninteiShinseiTaishoshaList;

    /**
     * デフォルトコンストラクタです。
     */
    public NinteiShinseiTaishoshaList() {
        ninteiShinseiTaishoshaList = new ArrayList<>();
    }

    /**
     * 引数から被保険者Listとみなし2号Listを受け取り、両方のListを結合したインスタンスを生成します。
     *
     * @param hihokenshaList 被保険者List
     * @param minashi2GoshaList みなし2号者List
     * @throws NullPointerException 引数のいずれかにNullが渡されたとき
     */
    public NinteiShinseiTaishoshaList(HihokenshaList hihokenshaList, Minashi2GoshaList minashi2GoshaList) {
        requireNonNull(hihokenshaList, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("被保険者List", getClass().getName()));
        requireNonNull(hihokenshaList, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("みなし2号者List", getClass().getName()));

        ninteiShinseiTaishoshaList = new ArrayList<>();
        ninteiShinseiTaishoshaList.addAll(toNinteiShinseiTaishoshaList(hihokenshaList));
        ninteiShinseiTaishoshaList.addAll(toNinteiShinseiTaishoshaList(minashi2GoshaList));
    }

    /**
     * 引数から受け取った被保険者Listを、自身に追加します。
     *
     * @param hihokenshaList
     */
    public void addAll(HihokenshaList hihokenshaList) {
        ninteiShinseiTaishoshaList.addAll(toNinteiShinseiTaishoshaList(hihokenshaList));
    }

    /**
     * 引数から受け取ったみなし2号者Listを、自身に追加します。
     *
     * @param minashi2GoshaList
     */
    public void addAll(Minashi2GoshaList minashi2GoshaList) {
        ninteiShinseiTaishoshaList.addAll(toNinteiShinseiTaishoshaList(minashi2GoshaList));
    }

    private List<INinteiShinseiTaishosha> toNinteiShinseiTaishoshaList(HihokenshaList hihokenshaList) {
        List<INinteiShinseiTaishosha> taishoshaList = new ArrayList<>();
        for (INinteiShinseiTaishosha taishosha : hihokenshaList) {
            taishoshaList.add(taishosha);
        }
        return taishoshaList;
    }

    private List<INinteiShinseiTaishosha> toNinteiShinseiTaishoshaList(Minashi2GoshaList minashi2GoshaList) {
        List<INinteiShinseiTaishosha> taishoshaList = new ArrayList<>();
        for (INinteiShinseiTaishosha taishosha : minashi2GoshaList) {
            taishoshaList.add(taishosha);
        }
        return taishoshaList;
    }

    /**
     * Listのサイズを返します。
     *
     * @return Listサイズ
     */
    public int size() {
        return ninteiShinseiTaishoshaList.size();
    }

    /**
     * Listが空であるか否かを返します。
     *
     * @return 空ならtrue
     */
    public boolean isEmpty() {
        return ninteiShinseiTaishoshaList.isEmpty();
    }

    @Override
    public Iterator<INinteiShinseiTaishosha> iterator() {
        return ninteiShinseiTaishoshaList.iterator();
    }

}
