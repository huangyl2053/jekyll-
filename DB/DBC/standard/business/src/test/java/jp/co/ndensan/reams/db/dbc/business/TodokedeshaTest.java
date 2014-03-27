/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;

/**
 * 届出者のテストクラスです。
 *
 * @author N3317 塚田 萌
 */
@RunWith(Enclosed.class)
public class TodokedeshaTest extends DbcTestBase {

    private static Todokedesha sut;
    private static RString 住所;
    private static RString 事業者名称;
    private static RString 代表者氏名;

    @Before
    public void setUp() {
        住所 = mock(RString.class);
        事業者名称 = mock(RString.class);
        代表者氏名 = mock(RString.class);
    }

    public static class ConstructorTest {

        @Test
        public void 引数に必要な値が渡された時_インスタンスが生成される() {
            sut = new Todokedesha(住所, 事業者名称, 代表者氏名);
            assertThat(sut, is(instanceOf(Todokedesha.class)));
        }
    }
}
