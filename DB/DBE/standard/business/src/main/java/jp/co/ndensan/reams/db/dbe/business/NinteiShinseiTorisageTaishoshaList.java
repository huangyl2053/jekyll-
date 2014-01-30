/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.Iterator;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;

/**
 * 認定申請取下げ対象者のリストを扱うクラスです。
 *
 * @author n8178 城間篤人
 */
public class NinteiShinseiTorisageTaishoshaList implements Iterable {

    private final List<NinteiShinseiTorisageTaishosha> taishoshaList;

    /**
     * 引数から認定申請取下げ対象者のリストを受け取るコンストラクタです。
     *
     * @param taishoshaList
     */
    public NinteiShinseiTorisageTaishoshaList(List<NinteiShinseiTorisageTaishosha> taishoshaList) {
        this.taishoshaList = taishoshaList;
    }

    /**
     * 指定した申請書管理番号に対応した認定申請取下げ対象者を返します。<br />
     * 対応する対象者がいない場合、nullが返ります。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 認定申請取下げ対象者
     */
    public NinteiShinseiTorisageTaishosha get認定申請取下げ対象者(ShinseishoKanriNo 申請書管理番号) {
        for (NinteiShinseiTorisageTaishosha taishosha : taishoshaList) {
            if (taishosha.get申請書管理No().equals(申請書管理番号)) {
                return taishosha;
            }
        }
        return null;
    }

    /**
     * 認定申請取下げ対象者リストのサイズを返します。
     *
     * @return
     */
    public int size() {
        return taishoshaList.size();
    }

    @Override
    public Iterator iterator() {
        return taishoshaList.iterator();
    }
}
