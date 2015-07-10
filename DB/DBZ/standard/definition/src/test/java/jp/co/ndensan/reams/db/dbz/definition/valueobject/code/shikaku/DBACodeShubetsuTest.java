/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject.code.shikaku;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DBACodeShubetsu}のテストクラスです。
 *
 * @author n8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class DBACodeShubetsuTest {

    public static class getCodeShubetsuTest extends DbzTestBase {

        @Test
        public void 医療保険種類の場合_getCodeShubetsuは0001を返す() {
            assertThat(DBACodeShubetsu.医療保険種類.getCodeShubetsu(), is(new CodeShubetsu("0001")));
        }

        @Test
        public void 被保険者証交付事由の場合_getCodeShubetsuは0002を返す() {
            assertThat(DBACodeShubetsu.被保険者証交付事由.getCodeShubetsu(), is(new CodeShubetsu("0002")));
        }

        @Test
        public void 被保険者証回収事由の場合_getCodeShubetsuは0003を返す() {
            assertThat(DBACodeShubetsu.被保険者証回収事由.getCodeShubetsu(), is(new CodeShubetsu("0003")));
        }

        @Test
        public void 資格者証交付事由の場合_getCodeShubetsuは0004を返す() {
            assertThat(DBACodeShubetsu.資格者証交付事由.getCodeShubetsu(), is(new CodeShubetsu("0004")));
        }

        @Test
        public void 資格者証回収事由の場合_getCodeShubetsuは0005を返す() {
            assertThat(DBACodeShubetsu.資格者証回収事由.getCodeShubetsu(), is(new CodeShubetsu("0005")));
        }
    }

    public static class getSubGyomuCodeTest extends DbzTestBase {

        @Test
        public void getSubGyomuCodeはDBA介護資格を返す() {
            assertThat(DBACodeShubetsu.医療保険種類.getSubGyomuCode(), is(SubGyomuCode.DBA介護資格));
        }
    }

    public static class getReturnTypeTest extends DbzTestBase {

        @Test
        public void 医療保険種類の場合_getReturnTypeはIryoHokenShuruiを返す() {
            assertThat(DBACodeShubetsu.医療保険種類.getReturnType().getName(), is(IryoHokenShurui.class.getName()));
        }

        @Test
        public void 被保険者証交付事由の場合_getReturnTypeはHihokenshashoKofuJiyuを返す() {
            assertThat(DBACodeShubetsu.被保険者証交付事由.getReturnType().getName(), is(HihokenshashoKofuJiyu.class.getName()));
        }

        @Test
        public void 被保険者証回収事由の場合_getReturnTypeはHihokenshashoKaishuJiyuを返す() {
            assertThat(DBACodeShubetsu.被保険者証回収事由.getReturnType().getName(), is(HihokenshashoKaishuJiyu.class.getName()));
        }

        @Test
        public void 資格者証交付事由の場合_getReturnTypeはShikakushashoKofuJiyuを返す() {
            assertThat(DBACodeShubetsu.資格者証交付事由.getReturnType().getName(), is(ShikakushashoKofuJiyu.class.getName()));
        }

        @Test
        public void 資格者証回収事由の場合_getReturnTypeはShikakushashoKaishuJiyuを返す() {
            assertThat(DBACodeShubetsu.資格者証回収事由.getReturnType().getName(), is(ShikakushashoKaishuJiyu.class.getName()));
        }
    }
}
