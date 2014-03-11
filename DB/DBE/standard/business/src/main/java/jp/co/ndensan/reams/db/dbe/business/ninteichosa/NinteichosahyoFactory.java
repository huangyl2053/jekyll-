/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.ninteichosa;

import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.NinteichosahyoRegulation;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.KoroshoIFKubun;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.NinteichosaItemGroup;

/**
 * 要介護認定調査の調査票を扱うクラスのファクトリークラスです。
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
     * 要介護認定調査の調査票（サービス状況）を扱うクラスのインスタンスを生成します。
     *
     * @param 厚労省IF識別区分 厚労省IF識別区分
     * @return 要介護認定調査の調査票（サービス状況）を扱うクラスのインスタンス
     */
    public static Ninteichosahyo createサービス状況Instance(KoroshoIFKubun 厚労省IF識別区分) {
        switch (厚労省IF識別区分) {
            case V06A:
                return new Ninteichosahyo(new NinteichosahyoRegulation.Of2006().getサービス状況調査定義(), NinteichosaItemGroup.Of2006.values());
            case V09A:
                return new Ninteichosahyo(new NinteichosahyoRegulation.Of2009().getサービス状況調査定義(), NinteichosaItemGroup.Of2009.values());
            default:
                return null;
        }
    }

    /**
     * 要介護認定調査の調査票（基本情報）を扱うクラスのインスタンスを生成します。
     *
     * @param 厚労省IF識別区分 厚労省IF識別区分
     * @return 要介護認定調査の調査票（基本情報）を扱うクラスのインスタンス
     */
    public static Ninteichosahyo create基本情報Instance(KoroshoIFKubun 厚労省IF識別区分) {
        switch (厚労省IF識別区分) {
            case V06A:
                return new Ninteichosahyo(new NinteichosahyoRegulation.Of2006().get基本調査定義(), NinteichosaItemGroup.Of2006.values());
            case V09A:
                return new Ninteichosahyo(new NinteichosahyoRegulation.Of2009().get基本調査定義(), NinteichosaItemGroup.Of2009.values());
            default:
                return null;
        }
    }
}
