/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7109KubunShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7109KubunShikyuGendoGakuEntityGenerator;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Ignore;

/**
 * {@link KubunShikyuGendoGaku}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class KubunShikyuGendoGakuTest extends DbcTestBase {

    private static DbT7109KubunShikyuGendoGakuEntity KubunShikyuGendoGakuEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static RString 主キー名1;
    private static FlexibleYearMonth 主キー名2;
    private static int 主キー名3;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7109KubunShikyuGendoGakuEntityGenerator.DEFAULT_要介護状態区分;
        主キー名2 = DbT7109KubunShikyuGendoGakuEntityGenerator.DEFAULT_適用開始年月;
        主キー名3 = DbT7109KubunShikyuGendoGakuEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KubunShikyuGendoGaku sut;

        @Before
        public void setUp() {
            KubunShikyuGendoGakuEntity = DbT7109KubunShikyuGendoGakuEntityGenerator.createDbT7109KubunShikyuGendoGakuEntity();
            KubunShikyuGendoGakuEntity.setYoKaigoJotaiKubun(主キー名1);
            KubunShikyuGendoGakuEntity.setTekiyoKaishiYM(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KubunShikyuGendoGaku(null, 主キー名2, 主キー名3);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KubunShikyuGendoGaku(主キー名1, null, 主キー名3);
        }

        @Test
        public void 指定したキーが保持するDbT7109KubunShikyuGendoGakuEntityにセットされている() {
            sut = new KubunShikyuGendoGaku(主キー名1, 主キー名2, 主キー名3);
            assertThat(sut.get要介護状態区分(), is(主キー名1));
            assertThat(sut.get適用開始年月(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKubunShikyuGendoGakuIdentifierにセットされている() {
            sut = new KubunShikyuGendoGaku(主キー名1, 主キー名2, 主キー名3);
            assertThat(sut.identifier().get要介護状態区分(), is(主キー名1));
            assertThat(sut.identifier().get適用開始年月(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KubunShikyuGendoGaku sut;

        @Before
        public void setUp() {
            KubunShikyuGendoGakuEntity = DbT7109KubunShikyuGendoGakuEntityGenerator.createDbT7109KubunShikyuGendoGakuEntity();
            KubunShikyuGendoGakuEntity.setYoKaigoJotaiKubun(主キー名1);
            KubunShikyuGendoGakuEntity.setTekiyoKaishiYM(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KubunShikyuGendoGaku(null);
        }

        @Test
        public void 指定したDbT7109KubunShikyuGendoGakuEntityのキー情報を識別子が持つ() {

            sut = new KubunShikyuGendoGaku(KubunShikyuGendoGakuEntity);

            assertThat(sut.identifier().get要介護状態区分(), is(主キー名1));
            assertThat(sut.identifier().get適用開始年月(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KubunShikyuGendoGaku sut;

        @Before
        public void setUp() {
            KubunShikyuGendoGakuEntity = DbT7109KubunShikyuGendoGakuEntityGenerator.createDbT7109KubunShikyuGendoGakuEntity();
            KubunShikyuGendoGakuEntity.setYoKaigoJotaiKubun(主キー名1);
            KubunShikyuGendoGakuEntity.setTekiyoKaishiYM(主キー名2);

            sut = new KubunShikyuGendoGaku(KubunShikyuGendoGakuEntity);
        }

        @Test
        public void get要介護状態区分は_entityが持つ要介護状態区分を返す() {
            assertThat(sut.get要介護状態区分(), is(KubunShikyuGendoGakuEntity.getYoKaigoJotaiKubun()));
        }

        @Test
        public void get適用開始年月は_entityが持つ適用開始年月を返す() {
            assertThat(sut.get適用開始年月(), is(KubunShikyuGendoGakuEntity.getTekiyoKaishiYM()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(KubunShikyuGendoGakuEntity.getRirekiNo()));
        }

        @Test
        public void get適用終了年月は_entityが持つ適用終了年月を返す() {
            assertThat(sut.get適用終了年月(), is(KubunShikyuGendoGakuEntity.getTekiyoShuryoYM()));
        }

        @Test
        public void get支給限度単位数は_entityが持つ支給限度単位数を返す() {
            assertThat(sut.get支給限度単位数(), is(KubunShikyuGendoGakuEntity.getShikyuGendoTaniSu()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static KubunShikyuGendoGaku sut;

        @Before
        public void setUp() {
            KubunShikyuGendoGakuEntity = DbT7109KubunShikyuGendoGakuEntityGenerator.createDbT7109KubunShikyuGendoGakuEntity();
            KubunShikyuGendoGakuEntity.setYoKaigoJotaiKubun(主キー名1);
            KubunShikyuGendoGakuEntity.setTekiyoKaishiYM(主キー名2);

            sut = new KubunShikyuGendoGaku(KubunShikyuGendoGakuEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KubunShikyuGendoGakuEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static KubunShikyuGendoGaku sut;

        @Before
        public void setUp() {
            KubunShikyuGendoGakuEntity = DbT7109KubunShikyuGendoGakuEntityGenerator.createDbT7109KubunShikyuGendoGakuEntity();
            KubunShikyuGendoGakuEntity.setYoKaigoJotaiKubun(主キー名1);
            KubunShikyuGendoGakuEntity.setTekiyoKaishiYM(主キー名2);

            sut = new KubunShikyuGendoGaku(KubunShikyuGendoGakuEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static KubunShikyuGendoGaku sut;
        private static KubunShikyuGendoGaku result;

        @Before
        public void setUp() {
            KubunShikyuGendoGakuEntity = DbT7109KubunShikyuGendoGakuEntityGenerator.createDbT7109KubunShikyuGendoGakuEntity();
            KubunShikyuGendoGakuEntity.setYoKaigoJotaiKubun(主キー名1);
            KubunShikyuGendoGakuEntity.setTekiyoKaishiYM(主キー名2);

        }

        @Test
        public void KubunShikyuGendoGakuが保持するDbT7109KubunShikyuGendoGakuEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKubunShikyuGendoGakuが保持するDbT7109KubunShikyuGendoGakuEntityのEntityDataStateがDeletedに指定されたKubunShikyuGendoGakuが返る() {
            sut = TestSupport.setStateKubunShikyuGendoGaku(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KubunShikyuGendoGakuが保持するDbT7109KubunShikyuGendoGakuEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKubunShikyuGendoGakuが保持するDbT7109KubunShikyuGendoGakuEntityのEntityDataStateがDeletedに指定されたKubunShikyuGendoGakuが返る() {
            sut = TestSupport.setStateKubunShikyuGendoGaku(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KubunShikyuGendoGakuが保持するDbT7109KubunShikyuGendoGakuEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKubunShikyuGendoGakuが保持するDbT7109KubunShikyuGendoGakuEntityのEntityDataStateがDeletedに指定されたKubunShikyuGendoGakuが返る() {
            sut = TestSupport.setStateKubunShikyuGendoGaku(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KubunShikyuGendoGakuが保持するDbT7109KubunShikyuGendoGakuEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKubunShikyuGendoGaku(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KubunShikyuGendoGaku setStateKubunShikyuGendoGaku(EntityDataState parentState) {
            KubunShikyuGendoGakuEntity.setState(parentState);
            return new KubunShikyuGendoGaku(KubunShikyuGendoGakuEntity);
        }
    }
}
