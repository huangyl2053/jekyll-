/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * 賦課対象者検索用のメニューを定義した列挙型のテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class FukaSearchMenuTest extends DbzTestBase {

    private static final RString 賦課照会 = new RString("DBBMN11001");

    public static class is extends DbzTestBase {

        @Test
        public void 指定したメニューグループに該当するとき_isは_trueを返す() {
            assertThat(FukaSearchMenu.toValue(賦課照会).is(FukaSearchMenuGroup.照会系), is(true));
        }

        @Test
        public void 指定したメニューグループに該当するとき_isは_trueを返す2() {
            assertThat(FukaSearchMenu.toValue(賦課照会).is(FukaSearchMenuGroup.賦課照会系), is(true));
        }

        @Test
        public void 指定したメニューグループに該当しないとき_isは_falseを返す() {
            assertThat(FukaSearchMenu.toValue(賦課照会).is(FukaSearchMenuGroup.更新系), is(false));
        }

        @Test
        public void 指定したメニューグループに該当しないとき_isは_falseを返す2() {
            assertThat(FukaSearchMenu.toValue(賦課照会).is(FukaSearchMenuGroup.通知書発行系), is(false));
        }
    }
}
