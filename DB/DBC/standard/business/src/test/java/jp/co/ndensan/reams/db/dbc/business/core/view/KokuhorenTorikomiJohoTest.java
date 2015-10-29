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
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Ignore;

/**
 * {@link KokuhorenTorikomiJoho}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class KokuhorenTorikomiJohoTest extends DbcTestBase {

    private static DbV3104KokuhorenTorikomiJohoEntity KokuhorenTorikomiJohoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleYearMonth 主キー名1;
    private static RString 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbV3104KokuhorenTorikomiJohoEntityGenerator.DEFAULT_処理年月;
        主キー名2 = DbV3104KokuhorenTorikomiJohoEntityGenerator.DEFAULT_交換情報識別番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KokuhorenTorikomiJoho sut;

        @BeforeClass
        public static void setUpClass() {
            KokuhorenTorikomiJohoEntity = DbV3104KokuhorenTorikomiJohoEntityGenerator.createDbV3104KokuhorenTorikomiJohoEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KokuhorenTorikomiJoho(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KokuhorenTorikomiJoho(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbV3104KokuhorenTorikomiJohoEntityにセットされている() {
            sut = new KokuhorenTorikomiJoho(主キー名1, 主キー名2);
            assertThat(sut.get処理年月(), is(主キー名1));
            assertThat(sut.get交換情報識別番号(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKokuhorenTorikomiJohoIdentifierにセットされている() {
            sut = new KokuhorenTorikomiJoho(主キー名1, 主キー名2);
            assertThat(sut.get処理年月(), is(主キー名1));
            assertThat(sut.get交換情報識別番号(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KokuhorenTorikomiJoho sut;

        @BeforeClass
        public static void setUpClass() {
            KokuhorenTorikomiJohoEntity = DbV3104KokuhorenTorikomiJohoEntityGenerator.createDbV3104KokuhorenTorikomiJohoEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KokuhorenTorikomiJoho(null);
        }

        @Test
        public void 指定したDbV3104KokuhorenTorikomiJohoEntityのキー情報を識別子が持つ() {

            sut = new KokuhorenTorikomiJoho(KokuhorenTorikomiJohoEntity);

            assertThat(sut.get処理年月(), is(主キー名1));
            assertThat(sut.get交換情報識別番号(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KokuhorenTorikomiJoho sut;

        @BeforeClass
        public static void setUpClass() {
            KokuhorenTorikomiJohoEntity = DbV3104KokuhorenTorikomiJohoEntityGenerator.createDbV3104KokuhorenTorikomiJohoEntity();

            sut = new KokuhorenTorikomiJoho(KokuhorenTorikomiJohoEntity);
        }

        @Test
        public void get処理年月は_entityが持つ処理年月を返す() {
            assertThat(sut.get処理年月(), is(KokuhorenTorikomiJohoEntity.getShoriYM()));
        }

        @Test
        public void get交換情報識別番号は_entityが持つ交換情報識別番号を返す() {
            assertThat(sut.get交換情報識別番号(), is(KokuhorenTorikomiJohoEntity.getKokanShikibetsuNo()));
        }

        @Test
        public void get処理状態区分は_entityが持つ処理状態区分を返す() {
            assertThat(sut.get処理状態区分(), is(KokuhorenTorikomiJohoEntity.getShoriJotaiKubun()));
        }

        @Test
        public void get前_処理状態区分は_entityが持つ前_処理状態区分を返す() {
            assertThat(sut.get前_処理状態区分(), is(KokuhorenTorikomiJohoEntity.getZen_shorijotaikubun()));
        }

        @Test
        public void get前々_処理状態区分は_entityが持つ前々_処理状態区分を返す() {
            assertThat(sut.get前々_処理状態区分(), is(KokuhorenTorikomiJohoEntity.getZenzen_shorijotaikubun()));
        }

        @Test
        public void get再処理可能区分は_entityが持つ再処理可能区分を返す() {
            assertThat(sut.get再処理可能区分(), is(KokuhorenTorikomiJohoEntity.getSaiShoriKahiKubun()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static KokuhorenTorikomiJoho sut;

        @BeforeClass
        public static void setUpClass() {
            KokuhorenTorikomiJohoEntity = DbV3104KokuhorenTorikomiJohoEntityGenerator.createDbV3104KokuhorenTorikomiJohoEntity();

            sut = new KokuhorenTorikomiJoho(KokuhorenTorikomiJohoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KokuhorenTorikomiJohoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static KokuhorenTorikomiJoho sut;

        @BeforeClass
        public static void setUpClass() {
            KokuhorenTorikomiJohoEntity = DbV3104KokuhorenTorikomiJohoEntityGenerator.createDbV3104KokuhorenTorikomiJohoEntity();

            sut = new KokuhorenTorikomiJoho(KokuhorenTorikomiJohoEntity);
        }

//        @Test
//        public void シリアライズできる() {
//            assertThat(sut, is(serializable()));
//        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static KokuhorenTorikomiJoho sut;
        private static KokuhorenTorikomiJoho result;

        @BeforeClass
        public static void setUpClass() {
            KokuhorenTorikomiJohoEntity = DbV3104KokuhorenTorikomiJohoEntityGenerator.createDbV3104KokuhorenTorikomiJohoEntity();

        }

        @Test
        public void KokuhorenTorikomiJohoが保持するDbV3104KokuhorenTorikomiJohoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKokuhorenTorikomiJohoが保持するDbV3104KokuhorenTorikomiJohoEntityのEntityDataStateがDeletedに指定されたKokuhorenTorikomiJohoが返る() {
            sut = TestSupport.setStateKokuhorenTorikomiJoho(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KokuhorenTorikomiJohoが保持するDbV3104KokuhorenTorikomiJohoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKokuhorenTorikomiJohoが保持するDbV3104KokuhorenTorikomiJohoEntityのEntityDataStateがDeletedに指定されたKokuhorenTorikomiJohoが返る() {
            sut = TestSupport.setStateKokuhorenTorikomiJoho(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KokuhorenTorikomiJohoが保持するDbV3104KokuhorenTorikomiJohoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKokuhorenTorikomiJohoが保持するDbV3104KokuhorenTorikomiJohoEntityのEntityDataStateがDeletedに指定されたKokuhorenTorikomiJohoが返る() {
            sut = TestSupport.setStateKokuhorenTorikomiJoho(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KokuhorenTorikomiJohoが保持するDbV3104KokuhorenTorikomiJohoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKokuhorenTorikomiJoho(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KokuhorenTorikomiJoho setStateKokuhorenTorikomiJoho(EntityDataState parentState) {
            KokuhorenTorikomiJohoEntity.setState(parentState);
            return new KokuhorenTorikomiJoho(KokuhorenTorikomiJohoEntity);
        }
    }
}
