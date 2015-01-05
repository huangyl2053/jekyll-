/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject.code.kyotsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DBZCodeShubetsu}のテストクラスです。
 *
 * @author n3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class DBZCodeShubetsuTest {

    public static class getCodeShubetsuTest extends DbzTestBase {

        @Test
        public void 調定事由の場合_getCodeShubetsuは0001を返す() {
            assertThat(DBZCodeShubetsu.調定事由.getCodeShubetsu(), is(new CodeShubetsu("0001")));
        }

        @Test
        public void 保険料減免事由の場合_getCodeShubetsuは0002を返す() {
            assertThat(DBZCodeShubetsu.保険料減免事由.getCodeShubetsu(), is(new CodeShubetsu("0002")));
        }

        @Test
        public void 保険料徴収猶予事由の場合_getCodeShubetsuは0003を返す() {
            assertThat(DBZCodeShubetsu.保険料徴収猶予事由.getCodeShubetsu(), is(new CodeShubetsu("0003")));
        }

        @Test
        public void 保険料減免取消事由の場合_getCodeShubetsuは0004を返す() {
            assertThat(DBZCodeShubetsu.保険料減免取消事由.getCodeShubetsu(), is(new CodeShubetsu("0004")));
        }

        @Test
        public void 保険料徴収猶予取消事由の場合_getCodeShubetsuは0005を返す() {
            assertThat(DBZCodeShubetsu.保険料徴収猶予取消事由.getCodeShubetsu(), is(new CodeShubetsu("0005")));
        }
    }

    public static class getSubGyomuCodeTest extends DbzTestBase {

        @Test
        public void getSubGyomuCodeはDBZ介護共通を返す() {
            assertThat(DBZCodeShubetsu.調定事由.getSubGyomuCode(), is(SubGyomuCode.DBZ介護共通));
        }
    }

    public static class getReturnTypeTest extends DbzTestBase {

        @Test
        public void 調定事由の場合_getReturnTypeはChoteiJiyuを返す() {
            assertThat(DBZCodeShubetsu.調定事由.getReturnType().getName(), is(ChoteiJiyu.class.getName()));
        }

        @Test
        public void 保険料減免事由の場合_getReturnTypeはHokenryoGemmenJiyuを返す() {
            assertThat(DBZCodeShubetsu.保険料減免事由.getReturnType().getName(), is(HokenryoGemmenJiyu.class.getName()));
        }

        @Test
        public void 保険料徴収猶予事由の場合_getReturnTypeはHokenryoChoshuYuyoJiyuを返す() {
            assertThat(DBZCodeShubetsu.保険料徴収猶予事由.getReturnType().getName(), is(HokenryoChoshuYuyoJiyu.class.getName()));
        }

        @Test
        public void 保険料減免取消事由の場合_getReturnTypeはHokenryoGemmenTorikeshiJiyuを返す() {
            assertThat(DBZCodeShubetsu.保険料減免取消事由.getReturnType().getName(), is(HokenryoGemmenTorikeshiJiyu.class.getName()));
        }

        @Test
        public void 保険料徴収猶予取消事由の場合_getReturnTypeはHokenryoChoshuYuyoTorikeshiJiyuを返す() {
            assertThat(DBZCodeShubetsu.保険料徴収猶予取消事由.getReturnType().getName(), is(HokenryoChoshuYuyoTorikeshiJiyu.class.getName()));
        }
    }
}
