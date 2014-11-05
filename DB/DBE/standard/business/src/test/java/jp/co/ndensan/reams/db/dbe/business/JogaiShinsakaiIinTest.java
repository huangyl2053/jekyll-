/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiIinCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 除外対象審査会委員クラスのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class JogaiShinsakaiIinTest {

    private static JogaiShinsakaiIin sut;

    public static class constructor extends DbeTestBase {

        private ShoKisaiHokenshaNo 証記載被保険者番号;
        private HihokenshaNo 被保険者番号;
        private int 管理番号;
        private ShinsakaiIin 除外対象審査会委員;

        @Before
        public void setUp() {
            証記載被保険者番号 = new ShoKisaiHokenshaNo(new RString("123456"));
            被保険者番号 = new HihokenshaNo(new RString("0123456789"));
            管理番号 = 1;
            除外対象審査会委員 = createShinsakaiIinMock(new RString("12345678"));
        }

        @Test(expected = NullPointerException.class)
        public void 証記載番号にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new JogaiShinsakaiIin(null, 被保険者番号, 管理番号, 除外対象審査会委員);
            fail();
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new JogaiShinsakaiIin(証記載被保険者番号, null, 管理番号, 除外対象審査会委員);
            fail();
        }

        @Test(expected = IllegalArgumentException.class)
        public void 管理番号に0以下の値が渡されたとき_IllegalArgumentExceptionが発生する() {
            sut = new JogaiShinsakaiIin(証記載被保険者番号, 被保険者番号, 0, 除外対象審査会委員);
            fail();
        }

        @Test(expected = NullPointerException.class)
        public void 除外対象審査会委員コードにnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new JogaiShinsakaiIin(証記載被保険者番号, 被保険者番号, 管理番号, null);
            fail();
        }

        private ShinsakaiIin createShinsakaiIinMock(RString 審査会委員コード) {
            ShinsakaiIin iin = mock(ShinsakaiIin.class);
            ShinsakaiIinCode code = new ShinsakaiIinCode(審査会委員コード);
            when(iin.get審査会委員コード()).thenReturn(code);
            return iin;
        }
    }

}
