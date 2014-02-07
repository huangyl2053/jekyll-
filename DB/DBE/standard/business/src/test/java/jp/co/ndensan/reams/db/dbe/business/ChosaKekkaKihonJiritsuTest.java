/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaKekkaKubunJiritsu;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 要介護認定調査（基本調査自立度）の情報を保持するクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class ChosaKekkaKihonJiritsuTest {

    public static class コンストラクタ {

        @Test(expected = NullPointerException.class)
        public void 認知症高齢者の日常生活自立度がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihonJiritsu(
                    null,
                    ChosaKekkaKubunJiritsu.ShogaiNichijoSeikatsu.自立);
        }

        @Test(expected = NullPointerException.class)
        public void 障害高齢者の日常生活自立度がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihonJiritsu(
                    ChosaKekkaKubunJiritsu.NinchishoNichijoSeikatsu.自立,
                    null);
        }
    }
}
