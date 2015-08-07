/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT7114UwanoseServiceShuruiShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.helper.DbT7114UwanoseServiceShuruiShikyuGendoGakuEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link UwanoseServiceShuruiShikyuGendoGaku}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class UwanoseServiceShuruiShikyuGendoGakuTest extends DbcTestBase {

    private static DbT7114UwanoseServiceShuruiShikyuGendoGakuEntity UwanoseServiceShuruiShikyuGendoGakuEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7114UwanoseServiceShuruiShikyuGendoGakuEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT7114UwanoseServiceShuruiShikyuGendoGakuEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static UwanoseServiceShuruiShikyuGendoGaku sut;

        @Before
        public void setUp() {
            UwanoseServiceShuruiShikyuGendoGakuEntity = DbT7114UwanoseServiceShuruiShikyuGendoGakuEntityGenerator.createDbT7114UwanoseServiceShuruiShikyuGendoGakuEntity();
            UwanoseServiceShuruiShikyuGendoGakuEntity.setXXX(主キー名1);
            UwanoseServiceShuruiShikyuGendoGakuEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new UwanoseServiceShuruiShikyuGendoGaku(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new UwanoseServiceShuruiShikyuGendoGaku(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT7114UwanoseServiceShuruiShikyuGendoGakuEntityにセットされている() {
            sut = new UwanoseServiceShuruiShikyuGendoGaku(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するUwanoseServiceShuruiShikyuGendoGakuIdentifierにセットされている() {
            sut = new UwanoseServiceShuruiShikyuGendoGaku(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static UwanoseServiceShuruiShikyuGendoGaku sut;

        @Before
        public void setUp() {
            UwanoseServiceShuruiShikyuGendoGakuEntity = DbT7114UwanoseServiceShuruiShikyuGendoGakuEntityGenerator.createDbT7114UwanoseServiceShuruiShikyuGendoGakuEntity();
            UwanoseServiceShuruiShikyuGendoGakuEntity.setXXX(主キー名1);
            UwanoseServiceShuruiShikyuGendoGakuEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new UwanoseServiceShuruiShikyuGendoGaku(null);
        }

        @Test
        public void 指定したDbT7114UwanoseServiceShuruiShikyuGendoGakuEntityのキー情報を識別子が持つ() {

            sut = new UwanoseServiceShuruiShikyuGendoGaku(UwanoseServiceShuruiShikyuGendoGakuEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static UwanoseServiceShuruiShikyuGendoGaku sut;

        @Before
        public void setUp() {
            UwanoseServiceShuruiShikyuGendoGakuEntity = DbT7114UwanoseServiceShuruiShikyuGendoGakuEntityGenerator.createDbT7114UwanoseServiceShuruiShikyuGendoGakuEntity();
            UwanoseServiceShuruiShikyuGendoGakuEntity.setXXX(主キー名1);
            UwanoseServiceShuruiShikyuGendoGakuEntity.setXXX(主キー名2);

            sut = new UwanoseServiceShuruiShikyuGendoGaku(UwanoseServiceShuruiShikyuGendoGakuEntity);
        }

        @Test
        public void getサービス種類コードは_entityが持つサービス種類コードを返す() {
            assertThat(sut.getサービス種類コード(), is(UwanoseServiceShuruiShikyuGendoGakuEntity.getServiceShuruiCode()));
        }

        @Test
        public void get要介護状態区分は_entityが持つ要介護状態区分を返す() {
            assertThat(sut.get要介護状態区分(), is(UwanoseServiceShuruiShikyuGendoGakuEntity.getYoKaigoJotaiKubun()));
        }

        @Test
        public void get適用開始年月は_entityが持つ適用開始年月を返す() {
            assertThat(sut.get適用開始年月(), is(UwanoseServiceShuruiShikyuGendoGakuEntity.getTekiyoKaishiYM()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(UwanoseServiceShuruiShikyuGendoGakuEntity.getRirekiNo()));
        }

        @Test
        public void get適用終了年月は_entityが持つ適用終了年月を返す() {
            assertThat(sut.get適用終了年月(), is(UwanoseServiceShuruiShikyuGendoGakuEntity.getTekiyoShuryoYM()));
        }

        @Test
        public void get支給限度単位数は_entityが持つ支給限度単位数を返す() {
            assertThat(sut.get支給限度単位数(), is(UwanoseServiceShuruiShikyuGendoGakuEntity.getShikyuGendoTaniSu()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static UwanoseServiceShuruiShikyuGendoGaku sut;

        @Before
        public void setUp() {
            UwanoseServiceShuruiShikyuGendoGakuEntity = DbT7114UwanoseServiceShuruiShikyuGendoGakuEntityGenerator.createDbT7114UwanoseServiceShuruiShikyuGendoGakuEntity();
            UwanoseServiceShuruiShikyuGendoGakuEntity.setXXX(主キー名1);
            UwanoseServiceShuruiShikyuGendoGakuEntity.setXXX(主キー名2);

            sut = new UwanoseServiceShuruiShikyuGendoGaku(UwanoseServiceShuruiShikyuGendoGakuEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(UwanoseServiceShuruiShikyuGendoGakuEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static UwanoseServiceShuruiShikyuGendoGaku sut;

        @Before
        public void setUp() {
            UwanoseServiceShuruiShikyuGendoGakuEntity = DbT7114UwanoseServiceShuruiShikyuGendoGakuEntityGenerator.createDbT7114UwanoseServiceShuruiShikyuGendoGakuEntity();
            UwanoseServiceShuruiShikyuGendoGakuEntity.setXXX(主キー名1);
            UwanoseServiceShuruiShikyuGendoGakuEntity.setXXX(主キー名2);

            sut = new UwanoseServiceShuruiShikyuGendoGaku(UwanoseServiceShuruiShikyuGendoGakuEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static UwanoseServiceShuruiShikyuGendoGaku sut;
        private static UwanoseServiceShuruiShikyuGendoGaku result;

        @Before
        public void setUp() {
            UwanoseServiceShuruiShikyuGendoGakuEntity = DbT7114UwanoseServiceShuruiShikyuGendoGakuEntityGenerator.createDbT7114UwanoseServiceShuruiShikyuGendoGakuEntity();
            UwanoseServiceShuruiShikyuGendoGakuEntity.setXXX(主キー名1);
            UwanoseServiceShuruiShikyuGendoGakuEntity.setXXX(主キー名2);

        }

        @Test
        public void UwanoseServiceShuruiShikyuGendoGakuが保持するDbT7114UwanoseServiceShuruiShikyuGendoGakuEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりUwanoseServiceShuruiShikyuGendoGakuが保持するDbT7114UwanoseServiceShuruiShikyuGendoGakuEntityのEntityDataStateがDeletedに指定されたUwanoseServiceShuruiShikyuGendoGakuが返る() {
            sut = TestSupport.setStateUwanoseServiceShuruiShikyuGendoGaku(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void UwanoseServiceShuruiShikyuGendoGakuが保持するDbT7114UwanoseServiceShuruiShikyuGendoGakuEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりUwanoseServiceShuruiShikyuGendoGakuが保持するDbT7114UwanoseServiceShuruiShikyuGendoGakuEntityのEntityDataStateがDeletedに指定されたUwanoseServiceShuruiShikyuGendoGakuが返る() {
            sut = TestSupport.setStateUwanoseServiceShuruiShikyuGendoGaku(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void UwanoseServiceShuruiShikyuGendoGakuが保持するDbT7114UwanoseServiceShuruiShikyuGendoGakuEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりUwanoseServiceShuruiShikyuGendoGakuが保持するDbT7114UwanoseServiceShuruiShikyuGendoGakuEntityのEntityDataStateがDeletedに指定されたUwanoseServiceShuruiShikyuGendoGakuが返る() {
            sut = TestSupport.setStateUwanoseServiceShuruiShikyuGendoGaku(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void UwanoseServiceShuruiShikyuGendoGakuが保持するDbT7114UwanoseServiceShuruiShikyuGendoGakuEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateUwanoseServiceShuruiShikyuGendoGaku(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static UwanoseServiceShuruiShikyuGendoGaku setStateUwanoseServiceShuruiShikyuGendoGaku(EntityDataState parentState) {
            UwanoseServiceShuruiShikyuGendoGakuEntity.setState(parentState);
            return new UwanoseServiceShuruiShikyuGendoGaku(UwanoseServiceShuruiShikyuGendoGakuEntity);
        }
    }
}
