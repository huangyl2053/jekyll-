/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.ninteichosa;

import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.NinteichosahyoRegulation;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.NinteichosaItemGroup;

/**
 * 要介護認定調査の調査票を扱うクラスのファクトリークラスです。
 *
 * @author N8156 宮本 康
 */
public final class NinteichosahyoFactory {

    private static final int NENDO_2006 = 2006;
    private static final int NENDO_2009 = 2009;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private NinteichosahyoFactory() {
    }

    /**
     * 要介護認定調査の調査票（サービス状況）を扱うクラスのインスタンスを生成します。
     *
     * @param 調査票改定年度 調査票改定年度
     * @return 要介護認定調査の調査票（サービス状況）を扱うクラスのインスタンス
     */
    public static Ninteichosahyo createサービス状況Instance(int 調査票改定年度) {
        switch (調査票改定年度) {
            case NENDO_2006:
                return new Ninteichosahyo(new NinteichosahyoRegulation.Of2006().getサービス状況調査定義(), NinteichosaItemGroup.Of2006.values());
            case NENDO_2009:
                return new Ninteichosahyo(new NinteichosahyoRegulation.Of2009().getサービス状況調査定義(), NinteichosaItemGroup.Of2009.values());
            default:
                return null;
        }
    }

    /**
     * 要介護認定調査の調査票（基本情報）を扱うクラスのインスタンスを生成します。
     *
     * @param 調査票改定年度 調査票改定年度
     * @return 要介護認定調査の調査票（基本情報）を扱うクラスのインスタンス
     */
    public static Ninteichosahyo create基本情報Instance(int 調査票改定年度) {
        switch (調査票改定年度) {
            case NENDO_2006:
                return new Ninteichosahyo(new NinteichosahyoRegulation.Of2006().get基本調査定義(), NinteichosaItemGroup.Of2006.values());
            case NENDO_2009:
                return new Ninteichosahyo(new NinteichosahyoRegulation.Of2009().get基本調査定義(), NinteichosaItemGroup.Of2009.values());
            default:
                return null;
        }
    }
}
