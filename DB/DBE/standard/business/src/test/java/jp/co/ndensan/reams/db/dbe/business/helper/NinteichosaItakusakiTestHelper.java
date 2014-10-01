/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.helper;

import jp.co.ndensan.reams.db.dbe.business.NinteichosaItakusaki;
import static jp.co.ndensan.reams.db.dbe.entity.helper.NinteichosaItakusakiTestHelper.事業者番号;
import static jp.co.ndensan.reams.db.dbe.entity.helper.NinteichosaItakusakiTestHelper.介護事業者状況;
import static jp.co.ndensan.reams.db.dbe.entity.helper.NinteichosaItakusakiTestHelper.介護事業者番号;
import static jp.co.ndensan.reams.db.dbe.entity.helper.NinteichosaItakusakiTestHelper.割付地区;
import static jp.co.ndensan.reams.db.dbe.entity.helper.NinteichosaItakusakiTestHelper.割付定員;
import static jp.co.ndensan.reams.db.dbe.entity.helper.NinteichosaItakusakiTestHelper.市町村コード;
import static jp.co.ndensan.reams.db.dbe.entity.helper.NinteichosaItakusakiTestHelper.機関の区分;
import static jp.co.ndensan.reams.db.dbe.entity.helper.NinteichosaItakusakiTestHelper.調査委託区分;

/**
 * モデルパッケージ作成時にエラーになったため仮作成。対応するときに考える。
 *
 * @author N3317 塚田 萌
 */
public class NinteichosaItakusakiTestHelper {

    /**
     * テスト用認定調査委託先を返します。
     *
     * @return 認定調査委託先
     */
    public static NinteichosaItakusaki create認定調査委託先() {
        NinteichosaItakusaki itakusaki = new NinteichosaItakusaki(
                市町村コード,
                介護事業者番号,
                事業者番号,
                介護事業者状況,
                調査委託区分,
                割付定員,
                割付地区,
                機関の区分);
        return itakusaki;
    }
}
