/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 日常生活自立度組み合わせのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class NichijoSeikatsuJiritsudoKumiawaseTest {

    private static NichijoSeikatsuJiritsudoKumiawase sut;

    public static class コンストラクタのテスト extends DbeTestBase {

        private int 自立;
        private int 要支援;
        private int 要介護1;
        private int 要介護2;
        private int 要介護3;
        private int 要介護4;
        private int 要介護5;

        @Before
        public void setUp() {
            自立 = 45;
            要支援 = 15;
            要介護1 = 12;
            要介護2 = 8;
            要介護3 = 7;
            要介護4 = 7;
            要介護5 = 6;
        }

        @Test(expected = IllegalArgumentException.class)
        public void 自立に0より小さい値が渡されたとき_IllegalArgumentExceptionが発生する() {
            sut = new NichijoSeikatsuJiritsudoKumiawase(-1, 要支援, 要介護1, 要介護2, 要介護3, 要介護4, 要介護5);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 要支援に0より小さい値が渡されたとき_IllegalArgumentExceptionが発生する() {
            sut = new NichijoSeikatsuJiritsudoKumiawase(自立, -1, 要介護1, 要介護2, 要介護3, 要介護4, 要介護5);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 要介護1に0より小さい値が渡されたとき_IllegalArgumentExceptionが発生する() {
            sut = new NichijoSeikatsuJiritsudoKumiawase(自立, 要支援, -1, 要介護2, 要介護3, 要介護4, 要介護5);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 要介護2に0より小さい値が渡されたとき_IllegalArgumentExceptionが発生する() {
            sut = new NichijoSeikatsuJiritsudoKumiawase(自立, 要支援, 要介護1, -1, 要介護3, 要介護4, 要介護5);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 要介護3に0より小さい値が渡されたとき_IllegalArgumentExceptionが発生する() {
            sut = new NichijoSeikatsuJiritsudoKumiawase(自立, 要支援, 要介護1, 要介護2, -1, 要介護4, 要介護5);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 要介護4に0より小さい値が渡されたとき_IllegalArgumentExceptionが発生する() {
            sut = new NichijoSeikatsuJiritsudoKumiawase(自立, 要支援, 要介護1, 要介護2, 要介護3, -1, 要介護5);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 要介護5に0より小さい値が渡されたとき_IllegalArgumentExceptionが発生する() {
            sut = new NichijoSeikatsuJiritsudoKumiawase(自立, 要支援, 要介護1, 要介護2, 要介護3, 要介護4, -1);
        }

        @Test
        public void すべての引数に0以上の値が渡されたとき_インスタンスが生成される() {
            sut = new NichijoSeikatsuJiritsudoKumiawase(自立, 要支援, 要介護1, 要介護2, 要介護3, 要介護4, 要介護5);
            assertThat(sut, is(instanceOf(NichijoSeikatsuJiritsudoKumiawase.class)));
        }
    }
}
