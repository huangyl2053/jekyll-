/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.business.helper.NinteichosaKekkaMock;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 要介護認定調査（基本調査）の情報を保持するクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class ChosaKekkaKihonTest {

    public static class コンストラクタ {

        @Test(expected = NullPointerException.class)
        public void 基本情報1がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon(
                    null,
                    NinteichosaKekkaMock.getSpiedChosaKekkaKihon2Instance(),
                    NinteichosaKekkaMock.getSpiedChosaKekkaKihon3Instance(),
                    NinteichosaKekkaMock.getSpiedChosaKekkaKihon4Instance(),
                    NinteichosaKekkaMock.getSpiedChosaKekkaKihon5Instance(),
                    NinteichosaKekkaMock.getSpiedChosaKekkaKihonIryoInstance(),
                    NinteichosaKekkaMock.getSpiedChosaKekkaKihonJiritsuInstance());
        }

        @Test(expected = NullPointerException.class)
        public void 基本情報2がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon(
                    NinteichosaKekkaMock.getSpiedChosaKekkaKihon1Instance(),
                    null,
                    NinteichosaKekkaMock.getSpiedChosaKekkaKihon3Instance(),
                    NinteichosaKekkaMock.getSpiedChosaKekkaKihon4Instance(),
                    NinteichosaKekkaMock.getSpiedChosaKekkaKihon5Instance(),
                    NinteichosaKekkaMock.getSpiedChosaKekkaKihonIryoInstance(),
                    NinteichosaKekkaMock.getSpiedChosaKekkaKihonJiritsuInstance());
        }

        @Test(expected = NullPointerException.class)
        public void 基本情報3がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon(
                    NinteichosaKekkaMock.getSpiedChosaKekkaKihon1Instance(),
                    NinteichosaKekkaMock.getSpiedChosaKekkaKihon2Instance(),
                    null,
                    NinteichosaKekkaMock.getSpiedChosaKekkaKihon4Instance(),
                    NinteichosaKekkaMock.getSpiedChosaKekkaKihon5Instance(),
                    NinteichosaKekkaMock.getSpiedChosaKekkaKihonIryoInstance(),
                    NinteichosaKekkaMock.getSpiedChosaKekkaKihonJiritsuInstance());
        }

        @Test(expected = NullPointerException.class)
        public void 基本情報4がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon(
                    NinteichosaKekkaMock.getSpiedChosaKekkaKihon1Instance(),
                    NinteichosaKekkaMock.getSpiedChosaKekkaKihon2Instance(),
                    NinteichosaKekkaMock.getSpiedChosaKekkaKihon3Instance(),
                    null,
                    NinteichosaKekkaMock.getSpiedChosaKekkaKihon5Instance(),
                    NinteichosaKekkaMock.getSpiedChosaKekkaKihonIryoInstance(),
                    NinteichosaKekkaMock.getSpiedChosaKekkaKihonJiritsuInstance());
        }

        @Test(expected = NullPointerException.class)
        public void 基本情報5がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon(
                    NinteichosaKekkaMock.getSpiedChosaKekkaKihon1Instance(),
                    NinteichosaKekkaMock.getSpiedChosaKekkaKihon2Instance(),
                    NinteichosaKekkaMock.getSpiedChosaKekkaKihon3Instance(),
                    NinteichosaKekkaMock.getSpiedChosaKekkaKihon4Instance(),
                    null,
                    NinteichosaKekkaMock.getSpiedChosaKekkaKihonIryoInstance(),
                    NinteichosaKekkaMock.getSpiedChosaKekkaKihonJiritsuInstance());
        }

        @Test(expected = NullPointerException.class)
        public void 特別医療情報がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon(
                    NinteichosaKekkaMock.getSpiedChosaKekkaKihon1Instance(),
                    NinteichosaKekkaMock.getSpiedChosaKekkaKihon2Instance(),
                    NinteichosaKekkaMock.getSpiedChosaKekkaKihon3Instance(),
                    NinteichosaKekkaMock.getSpiedChosaKekkaKihon4Instance(),
                    NinteichosaKekkaMock.getSpiedChosaKekkaKihon5Instance(),
                    null,
                    NinteichosaKekkaMock.getSpiedChosaKekkaKihonJiritsuInstance());
        }

        @Test(expected = NullPointerException.class)
        public void 自立度情報がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon(
                    NinteichosaKekkaMock.getSpiedChosaKekkaKihon1Instance(),
                    NinteichosaKekkaMock.getSpiedChosaKekkaKihon2Instance(),
                    NinteichosaKekkaMock.getSpiedChosaKekkaKihon3Instance(),
                    NinteichosaKekkaMock.getSpiedChosaKekkaKihon4Instance(),
                    NinteichosaKekkaMock.getSpiedChosaKekkaKihon5Instance(),
                    NinteichosaKekkaMock.getSpiedChosaKekkaKihonIryoInstance(),
                    null);
        }
    }
}
