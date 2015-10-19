/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core;

import java.util.Iterator;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 施設入退所状況の情報を保持するクラスです。
 *
 * @author n3331 山邉 大貴
 * @jpName 入所住居リスト
 * @bizDomain 介護
 * @category 施設入退所
 * @subCategory
 * @mainClass
 * @reference
 */
public class NyutaishoJyokyoList implements Iterable<NyushoJyokyo> {

    private final List<NyushoJyokyo> nyushoJyokyoList;

    /**
     * インスタンスを生成します。
     *
     * @param nyushoJyokyoList 入所状況リスト
     */
    public NyutaishoJyokyoList(List<NyushoJyokyo> nyushoJyokyoList) {
        this.nyushoJyokyoList = nyushoJyokyoList;
    }

    /**
     * 基準日における入所状況を取得します。
     *
     * @param 基準日 基準日
     * @return 入所状況
     */
    public NyushoJyokyo get入所状況(FlexibleDate 基準日) {
        for (NyushoJyokyo nyushoJyokyo : nyushoJyokyoList) {
            if (nyushoJyokyo.get入所期間().between(基準日)) {
                return nyushoJyokyo;
            }
        }
        return null;
    }

    @Override
    public Iterator<NyushoJyokyo> iterator() {
        return this.nyushoJyokyoList.iterator();
    }
}
