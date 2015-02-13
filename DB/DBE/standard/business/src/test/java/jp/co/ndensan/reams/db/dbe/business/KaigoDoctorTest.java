/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.ur.urz.business.IDoctor;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;

/**
 * 介護医師の情報を扱うクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class KaigoDoctorTest extends DbeTestBase {

    public static class コンストラクタ extends DbeTestBase {

        private static IDoctor doctor;
        private static IShujii shujii;
        private static KaigoIryoKikan facility;

        @Before
        public void setUp() {
            doctor = mock(IDoctor.class);
            shujii = mock(IShujii.class);
            facility = mock(KaigoIryoKikan.class);
        }

        @Test(expected = NullPointerException.class)
        public void 医師がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            //TODO KaigoDoctorコメントアウトされている
//            KaigoDoctor sut = new KaigoDoctor(null, shujii, facility);

        }

        @Test(expected = NullPointerException.class)
        public void 主治医がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            //TODO KaigoDoctorコメントアウトされている
//            KaigoDoctor sut = new KaigoDoctor(doctor, null, facility);
        }

        @Test(expected = NullPointerException.class)
        public void 介護医療機関がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            //TODO KaigoDoctorコメントアウトされている
//            KaigoDoctor sut = new KaigoDoctor(doctor, shujii, null);
        }
    }
}
