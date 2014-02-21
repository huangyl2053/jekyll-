/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.ninteichosa;

import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.NinteichosahyoTeigi;

/**
 * 要介護認定調査票の情報を扱うクラスのファクトリークラスです。
 *
 * @author N8156 宮本 康
 */
public final class NinteichosahyoFactory {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private NinteichosahyoFactory() {
    }

    /**
     * 要介護認定調査票の情報を扱うクラスのインスタンスを生成します。
     *
     * @param 改定年度 改定年度
     * @return 要介護認定調査票の情報を扱うクラスのインスタンス
     */
    public static Ninteichosahyo createInstance(int 改定年度) {
        return new Ninteichosahyo(NinteichosahyoTeigi.get調査票定義(改定年度));
    }
}
