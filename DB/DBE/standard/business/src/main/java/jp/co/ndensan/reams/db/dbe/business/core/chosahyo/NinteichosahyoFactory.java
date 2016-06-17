/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.chosahyo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.KoroshoIFKubun;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyo.INinteichosaItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyo.NinteichosaItemGroupOf2006;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyo.NinteichosaItemGroupOf2009;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyo.NinteichosaItemKubunOfGaikyo;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyo.NinteichosaItemKubunOfKihon;

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
     * 要介護認定調査の調査票（サービス状況）を扱うクラスのインスタンスを生成します。<br />
     * 指定した厚労省IF識別区分に該当する調査票が存在しない場合、空のNinteichosahyoを返します。
     *
     * @param 厚労省IF識別区分 厚労省IF識別区分
     * @return 認定調査票（サービス状況）を扱うクラスのインスタンスを返します。
     */
    public static Ninteichosahyo<NinteichosaItemKubunOfGaikyo, INinteichosaItem> createサービス状況Instance(KoroshoIFKubun 厚労省IF識別区分) {
        List<INinteichosaItemGroup> list = new ArrayList<>();
        switch (厚労省IF識別区分) {
            case V06A:

                for (INinteichosaItemGroup item : NinteichosaItemGroupOf2006.values()) {
                    if (!item.isKihonChosaGroup()) {
                        list.add(item);
                    }
                }
                return new Ninteichosahyo(new NinteichosahyoRegulationOf2006().getサービス状況調査定義(),
                        list);

            case V09A:

                for (INinteichosaItemGroup item : NinteichosaItemGroupOf2009.values()) {
                    if (!item.isKihonChosaGroup()) {
                        list.add(item);
                    }
                }
                return new Ninteichosahyo(new NinteichosahyoRegulationOf2009().getサービス状況調査定義(),
                        list);

            default:
                return new Ninteichosahyo(Collections.EMPTY_MAP, Collections.EMPTY_LIST);
        }
    }

    /**
     * 要介護認定調査の調査票（基本調査）を扱うクラスのインスタンスを生成します。<br />
     * 指定した厚労省IF識別区分に該当する調査票が存在しない場合、空のNinteichosahyoを返します。
     *
     * @param 厚労省IF識別区分 厚労省IF識別区分
     * @return 認定調査票（基本調査）を扱うクラスのインスタンスを返します。
     */
    public static Ninteichosahyo<NinteichosaItemKubunOfKihon, INinteichosaItem> create基本調査Instance(KoroshoIFKubun 厚労省IF識別区分) {
        List<INinteichosaItemGroup> list = new ArrayList<>();
        switch (厚労省IF識別区分) {
            case V06A:
//                return new Ninteichosahyo(new NinteichosahyoRegulationOf2006().get基本調査定義(),
//                        toListOfKihonChosaGroup(NinteichosaItemGroupOf2006.values()));

                for (INinteichosaItemGroup item : NinteichosaItemGroupOf2006.values()) {
                    if (item.isKihonChosaGroup()) {
                        list.add(item);
                    }
                }
                return new Ninteichosahyo(new NinteichosahyoRegulationOf2006().get基本調査定義(),
                        list);

            case V09A:

                for (INinteichosaItemGroup item : NinteichosaItemGroupOf2009.values()) {
                    if (item.isKihonChosaGroup()) {
                        list.add(item);
                    }
                }
                return new Ninteichosahyo(new NinteichosahyoRegulationOf2009().get基本調査定義(),
                        list);
            default:
                return new Ninteichosahyo(Collections.EMPTY_MAP, Collections.EMPTY_LIST);
        }
    }

}
