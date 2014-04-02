/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KoroshoIFKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShujiiIkenshoItemGroupOf2009;

/**
 * 主治医意見書を扱うクラスのファクトリークラスです。
 *
 * @author N8156 宮本 康
 */
public final class ShujiiIkenshoFactory {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private ShujiiIkenshoFactory() {
    }

    /**
     * 主治医意見書を扱うクラスのインスタンスを生成します。
     *
     * @param 厚労省IF識別区分 厚労省IF識別区分
     * @return 主治医意見書を扱うクラスのインスタンスを返します。指定した厚労省IF識別区分に該当する調査票が存在しない場合、nullを返します。
     */
    public static ShujiiIkensho create主治医意見書Instance(KoroshoIFKubun 厚労省IF識別区分) {
        switch (厚労省IF識別区分) {
            case V09A:
                return new ShujiiIkensho(new ShujiiIkenshoRegulationOf2009().get意見書定義(), ShujiiIkenshoItemGroupOf2009.values());
            default:
                return null;
        }
    }
}
