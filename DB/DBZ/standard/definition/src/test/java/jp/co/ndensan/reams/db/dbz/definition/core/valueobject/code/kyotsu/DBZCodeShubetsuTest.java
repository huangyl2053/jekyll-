/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.valueobject.code.kyotsu;

import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.code.kyotsu.HokenryoChoshuYuyoShurui;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.code.kyotsu.HokenryoGemmenTorikeshiShurui;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.code.kyotsu.TokubetsuChoshuTeishiJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.code.kyotsu.HokenryoGemmenShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.ChoteiJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.code.kyotsu.HokenryoChoshuYuyoTorikeshiShurui;
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
        public void 保険料減免種類の場合_getCodeShubetsuは0002を返す() {
            assertThat(DBZCodeShubetsu.保険料減免種類.getCodeShubetsu(), is(new CodeShubetsu("0002")));
        }
        @Test
        public void 保険料徴収猶予種類の場合_getCodeShubetsuは0003を返す() {
            assertThat(DBZCodeShubetsu.保険料徴収猶予種類.getCodeShubetsu(), is(new CodeShubetsu("0003")));
        }
        @Test
        public void 保険料減免取消種類の場合_getCodeShubetsuは0004を返す() {
            assertThat(DBZCodeShubetsu.保険料減免取消種類.getCodeShubetsu(), is(new CodeShubetsu("0004")));
        }
        @Test
        public void 保険料徴収猶予取消種類の場合_getCodeShubetsuは0005を返す() {
            assertThat(DBZCodeShubetsu.保険料徴収猶予取消種類.getCodeShubetsu(), is(new CodeShubetsu("0005")));
        }
        @Test
        public void 特別徴収停止事由の場合_getCodeShubetsuは0006を返す() {
            assertThat(DBZCodeShubetsu.特別徴収停止事由.getCodeShubetsu(), is(new CodeShubetsu("0006")));
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
        public void 保険料減免種類の場合_getReturnTypeはHokenryoGemmenShuruiを返す() {
            assertThat(DBZCodeShubetsu.保険料減免種類.getReturnType().getName(), is(HokenryoGemmenShurui.class.getName()));
        }
        @Test
        public void 保険料徴収猶予種類の場合_getReturnTypeはHokenryoChoshuYuyoShuruiを返す() {
            assertThat(DBZCodeShubetsu.保険料徴収猶予種類.getReturnType().getName(), is(HokenryoChoshuYuyoShurui.class.getName()));
        }
        @Test
        public void 保険料減免取消種類の場合_getReturnTypeはHokenryoGemmenTorikeshiShuruiを返す() {
            assertThat(DBZCodeShubetsu.保険料減免取消種類.getReturnType().getName(), is(HokenryoGemmenTorikeshiShurui.class.getName()));
        }
        @Test
        public void 保険料徴収猶予取消種類の場合_getReturnTypeはHokenryoChoshuYuyoTorikeshiShuruiを返す() {
            assertThat(DBZCodeShubetsu.保険料徴収猶予取消種類.getReturnType().getName(), is(HokenryoChoshuYuyoTorikeshiShurui.class.getName()));
        }
        @Test
        public void 特別徴収停止事由の場合_getReturnTypeはTokubetsuChoshuTeishiJiyuを返す() {
            assertThat(DBZCodeShubetsu.特別徴収停止事由.getReturnType().getName(), is(TokubetsuChoshuTeishiJiyu.class.getName()));
        }
    }
}
