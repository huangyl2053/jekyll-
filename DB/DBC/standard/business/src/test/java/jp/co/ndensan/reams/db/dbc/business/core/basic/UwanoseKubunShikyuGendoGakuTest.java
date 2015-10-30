/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7113UwanoseKubunShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7113UwanoseKubunShikyuGendoGakuEntityGenerator;
import jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable;
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
 * {@link UwanoseKubunShikyuGendoGaku}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class UwanoseKubunShikyuGendoGakuTest extends DbcTestBase {

    private static DbT7113UwanoseKubunShikyuGendoGakuEntity UwanoseKubunShikyuGendoGakuEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static RString 主キー名1;
    private static FlexibleYearMonth 主キー名2;
    private static int 主キー名3;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7113UwanoseKubunShikyuGendoGakuEntityGenerator.DEFAULT_要介護状態区分;
        主キー名2 = DbT7113UwanoseKubunShikyuGendoGakuEntityGenerator.DEFAULT_適用開始年月;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static UwanoseKubunShikyuGendoGaku sut;

        @Before
        public void setUp() {
            UwanoseKubunShikyuGendoGakuEntity = DbT7113UwanoseKubunShikyuGendoGakuEntityGenerator.createDbT7113UwanoseKubunShikyuGendoGakuEntity();
            UwanoseKubunShikyuGendoGakuEntity.setYoKaigoJotaiKubun(主キー名1);
            UwanoseKubunShikyuGendoGakuEntity.setTekiyoKaishiYM(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new UwanoseKubunShikyuGendoGaku(null, 主キー名2, 主キー名3);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new UwanoseKubunShikyuGendoGaku(主キー名1, null, 主キー名3);
        }

        @Test
        public void 指定したキーが保持するDbT7113UwanoseKubunShikyuGendoGakuEntityにセットされている() {
            sut = new UwanoseKubunShikyuGendoGaku(主キー名1, 主キー名2, 主キー名3);
            assertThat(sut.get要介護状態区分(), is(主キー名1));
            assertThat(sut.get適用開始年月(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するUwanoseKubunShikyuGendoGakuIdentifierにセットされている() {
            sut = new UwanoseKubunShikyuGendoGaku(主キー名1, 主キー名2, 主キー名3);
            assertThat(sut.identifier().get要介護状態区分(), is(主キー名1));
            assertThat(sut.identifier().get適用開始年月(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static UwanoseKubunShikyuGendoGaku sut;

        @Before
        public void setUp() {
            UwanoseKubunShikyuGendoGakuEntity = DbT7113UwanoseKubunShikyuGendoGakuEntityGenerator.createDbT7113UwanoseKubunShikyuGendoGakuEntity();
            UwanoseKubunShikyuGendoGakuEntity.setYoKaigoJotaiKubun(主キー名1);
            UwanoseKubunShikyuGendoGakuEntity.setTekiyoKaishiYM(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new UwanoseKubunShikyuGendoGaku(null);
        }

        @Test
        public void 指定したDbT7113UwanoseKubunShikyuGendoGakuEntityのキー情報を識別子が持つ() {

            sut = new UwanoseKubunShikyuGendoGaku(UwanoseKubunShikyuGendoGakuEntity);

            assertThat(sut.identifier().get要介護状態区分(), is(主キー名1));
            assertThat(sut.identifier().get適用開始年月(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static UwanoseKubunShikyuGendoGaku sut;

        @Before
        public void setUp() {
            UwanoseKubunShikyuGendoGakuEntity = DbT7113UwanoseKubunShikyuGendoGakuEntityGenerator.createDbT7113UwanoseKubunShikyuGendoGakuEntity();
            UwanoseKubunShikyuGendoGakuEntity.setYoKaigoJotaiKubun(主キー名1);
            UwanoseKubunShikyuGendoGakuEntity.setTekiyoKaishiYM(主キー名2);

            sut = new UwanoseKubunShikyuGendoGaku(UwanoseKubunShikyuGendoGakuEntity);
        }

        @Test
        public void get要介護状態区分は_entityが持つ要介護状態区分を返す() {
            assertThat(sut.get要介護状態区分(), is(UwanoseKubunShikyuGendoGakuEntity.getYoKaigoJotaiKubun()));
        }

        @Test
        public void get適用開始年月は_entityが持つ適用開始年月を返す() {
            assertThat(sut.get適用開始年月(), is(UwanoseKubunShikyuGendoGakuEntity.getTekiyoKaishiYM()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(UwanoseKubunShikyuGendoGakuEntity.getRirekiNo()));
        }

        @Test
        public void get適用終了年月は_entityが持つ適用終了年月を返す() {
            assertThat(sut.get適用終了年月(), is(UwanoseKubunShikyuGendoGakuEntity.getTekiyoShuryoYM()));
        }

        @Test
        public void get支給限度単位数は_entityが持つ支給限度単位数を返す() {
            assertThat(sut.get支給限度単位数(), is(UwanoseKubunShikyuGendoGakuEntity.getShikyuGendoTaniSu()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static UwanoseKubunShikyuGendoGaku sut;

        @Before
        public void setUp() {
            UwanoseKubunShikyuGendoGakuEntity = DbT7113UwanoseKubunShikyuGendoGakuEntityGenerator.createDbT7113UwanoseKubunShikyuGendoGakuEntity();
            UwanoseKubunShikyuGendoGakuEntity.setYoKaigoJotaiKubun(主キー名1);
            UwanoseKubunShikyuGendoGakuEntity.setTekiyoKaishiYM(主キー名2);

            sut = new UwanoseKubunShikyuGendoGaku(UwanoseKubunShikyuGendoGakuEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(UwanoseKubunShikyuGendoGakuEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static UwanoseKubunShikyuGendoGaku sut;

        @Before
        public void setUp() {
            UwanoseKubunShikyuGendoGakuEntity = DbT7113UwanoseKubunShikyuGendoGakuEntityGenerator.createDbT7113UwanoseKubunShikyuGendoGakuEntity();
            UwanoseKubunShikyuGendoGakuEntity.setYoKaigoJotaiKubun(主キー名1);
            UwanoseKubunShikyuGendoGakuEntity.setTekiyoKaishiYM(主キー名2);

            sut = new UwanoseKubunShikyuGendoGaku(UwanoseKubunShikyuGendoGakuEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(IsSerializable.serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static UwanoseKubunShikyuGendoGaku sut;
        private static UwanoseKubunShikyuGendoGaku result;

        @Before
        public void setUp() {
            UwanoseKubunShikyuGendoGakuEntity = DbT7113UwanoseKubunShikyuGendoGakuEntityGenerator.createDbT7113UwanoseKubunShikyuGendoGakuEntity();
            UwanoseKubunShikyuGendoGakuEntity.setYoKaigoJotaiKubun(主キー名1);
            UwanoseKubunShikyuGendoGakuEntity.setTekiyoKaishiYM(主キー名2);

        }

        @Test
        public void UwanoseKubunShikyuGendoGakuが保持するDbT7113UwanoseKubunShikyuGendoGakuEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりUwanoseKubunShikyuGendoGakuが保持するDbT7113UwanoseKubunShikyuGendoGakuEntityのEntityDataStateがDeletedに指定されたUwanoseKubunShikyuGendoGakuが返る() {
            sut = TestSupport.setStateUwanoseKubunShikyuGendoGaku(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void UwanoseKubunShikyuGendoGakuが保持するDbT7113UwanoseKubunShikyuGendoGakuEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりUwanoseKubunShikyuGendoGakuが保持するDbT7113UwanoseKubunShikyuGendoGakuEntityのEntityDataStateがDeletedに指定されたUwanoseKubunShikyuGendoGakuが返る() {
            sut = TestSupport.setStateUwanoseKubunShikyuGendoGaku(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void UwanoseKubunShikyuGendoGakuが保持するDbT7113UwanoseKubunShikyuGendoGakuEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりUwanoseKubunShikyuGendoGakuが保持するDbT7113UwanoseKubunShikyuGendoGakuEntityのEntityDataStateがDeletedに指定されたUwanoseKubunShikyuGendoGakuが返る() {
            sut = TestSupport.setStateUwanoseKubunShikyuGendoGaku(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void UwanoseKubunShikyuGendoGakuが保持するDbT7113UwanoseKubunShikyuGendoGakuEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateUwanoseKubunShikyuGendoGaku(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static UwanoseKubunShikyuGendoGaku setStateUwanoseKubunShikyuGendoGaku(EntityDataState parentState) {
            UwanoseKubunShikyuGendoGakuEntity.setState(parentState);
            return new UwanoseKubunShikyuGendoGaku(UwanoseKubunShikyuGendoGakuEntity);
        }
    }
}
