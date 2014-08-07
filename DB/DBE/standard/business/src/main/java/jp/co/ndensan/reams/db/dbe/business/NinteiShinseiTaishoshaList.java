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

/**
 * 認定申請の対象になる者（被保険者、みなし2号者など）のリストです。
 *
 * @author n8178 城間篤人
 */
public class NinteiShinseiTaishoshaList implements Iterable<INinteiShinseiTaishosha> {

    private final List<INinteiShinseiTaishosha> ninteiShinseiTaishoshaList;

    /**
     * 引数から被保険者Listとみなし2号Listを受け取り、両方のListを結合したインスタンスを生成します。
     *
     * @param hihokenshaList 被保険者List
     * @param minashi2GoshaList みなし2号者List
     */
    public NinteiShinseiTaishoshaList(HihokenshaList hihokenshaList, Minashi2GoshaList minashi2GoshaList) {
        ninteiShinseiTaishoshaList = new ArrayList<>();
        toNinteiShinseiTaishoshaList(hihokenshaList);
        toNinteiShinseiTaishoshaList(minashi2GoshaList);
    }

    private void toNinteiShinseiTaishoshaList(Iterable<? extends INinteiShinseiTaishosha> taishoshaList) {
        if (taishoshaList == null) {
            return;
        }

        for (INinteiShinseiTaishosha taishosha : taishoshaList) {
            ninteiShinseiTaishoshaList.add(taishosha);
        }
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
