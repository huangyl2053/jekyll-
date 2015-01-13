/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.model;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbV3104KokuhorenTorikomiJohoEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KokuhorenTorikomiJohoModel}のテストクラスです。
 *
 * @author n2810 久保里史
 */
@RunWith(Enclosed.class)
public class KokuhorenTorikomiJohoModelTest extends DbcTestBase {

    private static final RYearMonth DEFAULT_処理年月 = new RYearMonth("201504");
    private static final RString DEFAULT_交換情報識別番号 = new RString("121");
    private static final RString DEFAULT_当月処理状態区分 = new RString("1");
    private static final RString DEFAULT_前月処理状態区分 = new RString("2");
    private static final RString DEFAULT_前々月処理状態区分 = new RString("3");

    public static class getterSetterTest extends DbcTestBase {

        private static KokuhorenTorikomiJohoModel sut;

        @BeforeClass
        public static void test() {
            sut = new KokuhorenTorikomiJohoModel();
        }

        @Test
        public void 戻り値の処理年月は_設定した値と同じ処理年月を返す() {
            sut.set処理年月(DEFAULT_処理年月);
            assertThat(sut.get処理年月(), is(DEFAULT_処理年月));
        }

        @Test
        public void 戻り値の交換情報識別番号は_設定した値と同じ交換情報識別番号を返す() {
            sut.set交換情報識別番号(DEFAULT_交換情報識別番号);
            assertThat(sut.get交換情報識別番号(), is(DEFAULT_交換情報識別番号));
        }

        @Test
        public void 戻り値の当月処理状態区分は_設定した値と同じ当月処理状態区分を返す() {
            sut.set当月処理状態区分(DEFAULT_当月処理状態区分);
            assertThat(sut.get当月処理状態区分(), is(DEFAULT_当月処理状態区分));
        }

        @Test
        public void 戻り値の前月処理状態区分は_設定した値と同じ前月処理状態区分を返す() {
            sut.set前月処理状態区分(DEFAULT_前月処理状態区分);
            assertThat(sut.get前月処理状態区分(), is(DEFAULT_前月処理状態区分));
        }

        @Test
        public void 戻り値の前々月処理状態区分は_設定した値と同じ前々月処理状態区分を返す() {
            sut.set前々月処理状態区分(DEFAULT_前々月処理状態区分);
            assertThat(sut.get前々月処理状態区分(), is(DEFAULT_前々月処理状態区分));
        }
    }

    public static class getStateTest extends DbcTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KokuhorenTorikomiJohoModel sut = new KokuhorenTorikomiJohoModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }
//
//        @Test
//        public void 状態Modifinedの取得確認() {
//            KokuhorenTorikomiJohoModel sut = new KokuhorenTorikomiJohoModel();
//            sut.setEntity(DbV3104KokuhorenTorikomiJohoEntityGenerator.createDbV3104KokuhorenTorikomiJohoEntity());
//
//            sut.getEntity().initializeMd5();
//
//            // 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//
//            assertThat(sut.getState(), is(EntityDataState.Modified));
//        }
//
//        @Test
//        public void 状態Unchangedの取得確認() {
//            KokuhorenTorikomiJohoModel sut = new KokuhorenTorikomiJohoModel();
//            sut.setEntity(DbV3104KokuhorenTorikomiJohoEntityGenerator.createDbV3104KokuhorenTorikomiJohoEntity());
//
//            sut.getEntity().initializeMd5();
//
//            assertThat(sut.getState(), is(EntityDataState.Unchanged));
//        }
//
//        @Test
//        public void 状態Deletedの取得確認() {
//            KokuhorenTorikomiJohoModel sut = new KokuhorenTorikomiJohoModel();
//            sut.setEntity(DbV3104KokuhorenTorikomiJohoEntityGenerator.createDbV3104KokuhorenTorikomiJohoEntity());
//
//            sut.getEntity().initializeMd5();
//
//            sut.setDeletedState(true);
//
//            assertThat(sut.getState(), is(EntityDataState.Deleted));
//        }
    }
}
