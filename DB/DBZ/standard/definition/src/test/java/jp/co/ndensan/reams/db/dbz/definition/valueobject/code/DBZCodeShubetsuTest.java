/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject.code;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * {@link DBZCodeShubetsu}のテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class DBZCodeShubetsuTest {

    public static class getCodeShubetsuTest extends DbzTestBase {

        @Test
        public void 調定事由コードの場合_getCodeShubetsuは0001を返す() {
            assertThat(DBZCodeShubetsu.調定事由コード.getCodeShubetsu(), is(new CodeShubetsu("0001")));
        }
    }

    public static class getSubGyomuCodeTest extends DbzTestBase {

        @Test
        public void getSubGyomuCodeはDBZを返す() {
            assertThat(DBZCodeShubetsu.調定事由コード.getSubGyomuCode(), is(SubGyomuCode.DBZ介護共通));
        }
    }

    public static class getReturnTypeTest extends DbzTestBase {

        @Test
        public void 調定事由コードの場合_getReturnTypeはChoteiJiyuCodeを返す() {
            assertThat(DBZCodeShubetsu.調定事由コード.getReturnType().getName(), is(ChoteiJiyuCode.class.getName()));
        }
    }
}
