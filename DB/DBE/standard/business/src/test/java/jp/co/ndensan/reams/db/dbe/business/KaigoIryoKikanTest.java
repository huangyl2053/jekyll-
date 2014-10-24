/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;

/**
 * 介護医療機関クラスのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class KaigoIryoKikanTest extends TestBase {

//    public static class コンストラクタのテスト extends TestBase {
//
//        private IShujiiIryoKikan 主治医医療機関;
//        private IIryoKikan 医療機関;
//
//        @Override
//        public void setUp() {
//            主治医医療機関 = mock(IShujiiIryoKikan.class);
//            医療機関 = mock(IIryoKikan.class);
//        }
//
//        @Test
//        public void 必要項目が引数に渡されたとき_インスタンスが生成される() {
//            KaigoIryoKikan sut = new KaigoIryoKikan(医療機関, 主治医医療機関);
//            assertThat(sut, instanceOf(KaigoIryoKikan.class));
//        }
//
//        @Test(expected = NullPointerException.class)
//        public void 医療機関にnullが渡されたとき_NullPointerExceptionが発生する() {
//            KaigoIryoKikan sut = new KaigoIryoKikan(null, 主治医医療機関);
//        }
//
//        @Test(expected = NullPointerException.class)
//        public void 主治医医療機関にnullが渡されたとき_NullPointerExceptionが発生する() {
//            KaigoIryoKikan sut = new KaigoIryoKikan(医療機関, null);
//        }
//    }
}
