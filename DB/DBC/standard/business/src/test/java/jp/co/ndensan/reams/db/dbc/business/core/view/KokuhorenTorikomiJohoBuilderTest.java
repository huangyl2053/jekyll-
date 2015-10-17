/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.view;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbV3104KokuhorenTorikomiJohoEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbV3104KokuhorenTorikomiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KokuhorenTorikomiJohoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KokuhorenTorikomiJohoBuilderTest extends DbcTestBase {

    private static DbV3104KokuhorenTorikomiJohoEntity KokuhorenTorikomiJohoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleYearMonth 処理年月;
    private static RString 交換情報識別番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        処理年月 = DbV3104KokuhorenTorikomiJohoEntityGenerator.DEFAULT_処理年月;
        交換情報識別番号 = DbV3104KokuhorenTorikomiJohoEntityGenerator.DEFAULT_交換情報識別番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static KokuhorenTorikomiJohoBuilder sut;
        private static KokuhorenTorikomiJoho business;

        @Before
        public void setUp() {
            KokuhorenTorikomiJohoEntity = new DbV3104KokuhorenTorikomiJohoEntity();

            business = new KokuhorenTorikomiJoho(KokuhorenTorikomiJohoEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の処理年月は_設定した値と同じ処理年月を返す() {
            business = sut.set処理年月(DbV3104KokuhorenTorikomiJohoEntityGenerator.DEFAULT_処理年月).build();
            assertThat(business.get処理年月(), is(DbV3104KokuhorenTorikomiJohoEntityGenerator.DEFAULT_処理年月));
        }

        @Test
        public void 戻り値の交換情報識別番号は_設定した値と同じ交換情報識別番号を返す() {
            business = sut.set交換情報識別番号(DbV3104KokuhorenTorikomiJohoEntityGenerator.DEFAULT_交換情報識別番号).build();
            assertThat(business.get交換情報識別番号(), is(DbV3104KokuhorenTorikomiJohoEntityGenerator.DEFAULT_交換情報識別番号));
        }

        @Test
        public void 戻り値の処理状態区分は_設定した値と同じ処理状態区分を返す() {
            business = sut.set処理状態区分(DbV3104KokuhorenTorikomiJohoEntityGenerator.DEFAULT_処理状態区分).build();
            assertThat(business.get処理状態区分(), is(DbV3104KokuhorenTorikomiJohoEntityGenerator.DEFAULT_処理状態区分));
        }

        @Test
        public void 戻り値の前_処理状態区分は_設定した値と同じ前_処理状態区分を返す() {
            business = sut.set前_処理状態区分(DbV3104KokuhorenTorikomiJohoEntityGenerator.DEFAULT_前_処理状態区分).build();
            assertThat(business.get前_処理状態区分(), is(DbV3104KokuhorenTorikomiJohoEntityGenerator.DEFAULT_前_処理状態区分));
        }

        @Test
        public void 戻り値の前々_処理状態区分は_設定した値と同じ前々_処理状態区分を返す() {
            business = sut.set前々_処理状態区分(DbV3104KokuhorenTorikomiJohoEntityGenerator.DEFAULT_前々_処理状態区分).build();
            assertThat(business.get前々_処理状態区分(), is(DbV3104KokuhorenTorikomiJohoEntityGenerator.DEFAULT_前々_処理状態区分));
        }

        @Test
        public void 戻り値の処理実施日時は_設定した値と同じ処理実施日時を返す() {
            business = sut.set処理実施日時(DbV3104KokuhorenTorikomiJohoEntityGenerator.DEFAULT_処理実施日時).build();
            assertThat(business.get処理実施日時(), is(DbV3104KokuhorenTorikomiJohoEntityGenerator.DEFAULT_処理実施日時));
        }

        @Test
        public void 戻り値の再処理可能区分は_設定した値と同じ再処理可能区分を返す() {
            business = sut.set再処理可能区分(DbV3104KokuhorenTorikomiJohoEntityGenerator.DEFAULT_再処理可能区分).build();
            assertThat(business.get再処理可能区分(), is(DbV3104KokuhorenTorikomiJohoEntityGenerator.DEFAULT_再処理可能区分));
        }

    }
}
