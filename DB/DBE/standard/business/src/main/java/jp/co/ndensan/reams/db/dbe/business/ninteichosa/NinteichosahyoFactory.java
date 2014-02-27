/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.ninteichosa;

import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.ChosahyoRegulation;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosahyoItemGroup;

/**
 * 要介護認定調査の調査票情報を扱うクラスのファクトリークラスです。
 *
 * @author N8156 宮本 康
 */
public final class NinteichosahyoFactory {

    private static final int NENDO_2006 = 2006;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private NinteichosahyoFactory() {
    }

    /**
     * 要介護認定調査の調査票情報を扱うクラスのインスタンスを生成します。
     *
     * @param 調査票改定年度 調査票改定年度
     * @return 要介護認定調査の調査票情報を扱うクラスのインスタンス
     */
    public static Ninteichosahyo createInstance(int 調査票改定年度) {
        switch (調査票改定年度) {
            case NENDO_2006:
                return new Ninteichosahyo(new ChosahyoRegulation.Of2006().get調査票定義(), ChosahyoItemGroup.Of2006.values());
            default:
                return null;
        }
    }
}
