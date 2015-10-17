/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.enumeratedtype;

import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.KaigoHokenNyushoShisetsuBunrui;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 介護保険入所施設分類のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class KaigoHokenNyushoShisetsuBunruiTest {

    public static class toValueのテスト extends DbxTestBase {

        @Test
        public void 引数に11を渡したとき_介護保険施設が返る() {
            assertThat(KaigoHokenNyushoShisetsuBunrui.toValue(new RString("11")),
                    is(KaigoHokenNyushoShisetsuBunrui.介護保険施設));
        }

        @Test
        public void 引数に12を渡したとき_介護保険施設が返る() {
            assertThat(KaigoHokenNyushoShisetsuBunrui.toValue(new RString("12")),
                    is(KaigoHokenNyushoShisetsuBunrui.住所地特例対象施設));
        }

        @Test
        public void 引数に21を渡したとき_介護保険施設が返る() {
            assertThat(KaigoHokenNyushoShisetsuBunrui.toValue(new RString("21")),
                    is(KaigoHokenNyushoShisetsuBunrui.適用除外施設));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 引数に_対応する項目が存在しない値を渡したとき_IllegalArgumentExceptionが発生する() {
            KaigoHokenNyushoShisetsuBunrui.toValue(new RString("4771"));
        }
    }

    public static class valueOfのテスト extends DbxTestBase {

        @Test
        public void LDNS_介護事業者種別が住所地特例対象施設の場合_valueOfは_住所地特例対象施設を返す() {
            assertThat(KaigoHokenNyushoShisetsuBunrui.valueOf("住所地特例対象施設"), is(KaigoHokenNyushoShisetsuBunrui.住所地特例対象施設));
        }
    }
}
