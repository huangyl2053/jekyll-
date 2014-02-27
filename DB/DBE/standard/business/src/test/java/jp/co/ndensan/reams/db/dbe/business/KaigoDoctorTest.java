/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.ur.urz.business.IDoctor;
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
public class KaigoDoctorTest {

    public static class コンストラクタ {

        @Test(expected = NullPointerException.class)
        public void 医師がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new KaigoDoctor(null, any(IShujii.class), any(KaigoIryoKikan.class));
        }

        @Test(expected = NullPointerException.class)
        public void 主治医がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new KaigoDoctor(any(IDoctor.class), null, any(KaigoIryoKikan.class));
        }

        @Test(expected = NullPointerException.class)
        public void 介護医療機関がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new KaigoDoctor(any(IDoctor.class), any(IShujii.class), null);
        }
    }
}
