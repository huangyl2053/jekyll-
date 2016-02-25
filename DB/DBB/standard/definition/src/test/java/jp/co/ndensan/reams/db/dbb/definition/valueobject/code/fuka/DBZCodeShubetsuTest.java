/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.valueobject.code.fuka;

import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.code.kyotsu.ChoteiJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.code.kyotsu.HokenryoChoshuYuyoShurui;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.code.kyotsu.HokenryoChoshuYuyoTorikeshiShurui;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.code.kyotsu.HokenryoGemmenShurui;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.code.kyotsu.HokenryoGemmenTorikeshiShurui;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.code.kyotsu.TokubetsuChoshuTeishiJiyu;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DBBCodeShubetsu}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class DBZCodeShubetsuTest {

    public static class getCodeShubetsuTest extends DbzTestBase {

        @Test
        public void 調定事由の場合_getCodeShubetsuは0003を返す() {
            assertThat(DBBCodeShubetsu.調定事由.getCodeShubetsu(), is(new CodeShubetsu("0003")));
        }

        @Test
        public void 保険料減免種類の場合_getCodeShubetsuは0004を返す() {
            assertThat(DBBCodeShubetsu.保険料減免種類.getCodeShubetsu(), is(new CodeShubetsu("0004")));
        }

        @Test
        public void 保険料徴収猶予種類の場合_getCodeShubetsuは0005を返す() {
            assertThat(DBBCodeShubetsu.保険料徴収猶予種類.getCodeShubetsu(), is(new CodeShubetsu("0005")));
        }

        @Test
        public void 保険料減免取消種類の場合_getCodeShubetsuは0006を返す() {
            assertThat(DBBCodeShubetsu.保険料減免取消種類.getCodeShubetsu(), is(new CodeShubetsu("0006")));
        }

        @Test
        public void 保険料徴収猶予取消種類の場合_getCodeShubetsuは0007を返す() {
            assertThat(DBBCodeShubetsu.保険料徴収猶予取消種類.getCodeShubetsu(), is(new CodeShubetsu("0007")));
        }

        @Test
        public void 特別徴収停止事由の場合_getCodeShubetsuは0008を返す() {
            assertThat(DBBCodeShubetsu.特別徴収停止事由.getCodeShubetsu(), is(new CodeShubetsu("0008")));
        }
    }

    public static class getSubGyomuCodeTest extends DbzTestBase {

        @Test
        public void getSubGyomuCodeはDBB介護賦課を返す() {
            assertThat(DBBCodeShubetsu.調定事由.getSubGyomuCode(), is(SubGyomuCode.DBB介護賦課));
        }
    }

    public static class getReturnTypeTest extends DbzTestBase {

        @Test
        public void 調定事由の場合_getReturnTypeはChoteiJiyuを返す() {
            assertThat(DBBCodeShubetsu.調定事由.getReturnType().getName(), is(ChoteiJiyu.class.getName()));
        }

        @Test
        public void 保険料減免種類の場合_getReturnTypeはHokenryoGemmenShuruiを返す() {
            assertThat(DBBCodeShubetsu.保険料減免種類.getReturnType().getName(), is(HokenryoGemmenShurui.class.getName()));
        }

        @Test
        public void 保険料徴収猶予種類の場合_getReturnTypeはHokenryoChoshuYuyoShuruiを返す() {
            assertThat(DBBCodeShubetsu.保険料徴収猶予種類.getReturnType().getName(), is(HokenryoChoshuYuyoShurui.class.getName()));
        }

        @Test
        public void 保険料減免取消種類の場合_getReturnTypeはHokenryoGemmenTorikeshiShuruiを返す() {
            assertThat(DBBCodeShubetsu.保険料減免取消種類.getReturnType().getName(), is(HokenryoGemmenTorikeshiShurui.class.getName()));
        }

        @Test
        public void 保険料徴収猶予取消種類の場合_getReturnTypeはHokenryoChoshuYuyoTorikeshiShuruiを返す() {
            assertThat(DBBCodeShubetsu.保険料徴収猶予取消種類.getReturnType().getName(), is(HokenryoChoshuYuyoTorikeshiShurui.class.getName()));
        }

        @Test
        public void 特別徴収停止事由の場合_getReturnTypeはTokubetsuChoshuTeishiJiyuを返す() {
            assertThat(DBBCodeShubetsu.特別徴収停止事由.getReturnType().getName(), is(TokubetsuChoshuTeishiJiyu.class.getName()));
        }
    }
}
