/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT7118SogoJigyoShuruiShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7118SogoJigyoShuruiShikyuGendoGakuEntityGenerator;
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
 * {@link SogoJigyoShuruiShikyuGendoGaku}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class SogoJigyoShuruiShikyuGendoGakuTest extends DbcTestBase {

    private static DbT7118SogoJigyoShuruiShikyuGendoGakuEntity SogoJigyoShuruiShikyuGendoGakuEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7118SogoJigyoShuruiShikyuGendoGakuEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT7118SogoJigyoShuruiShikyuGendoGakuEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static SogoJigyoShuruiShikyuGendoGaku sut;

        @Before
        public void setUp() {
            SogoJigyoShuruiShikyuGendoGakuEntity = DbT7118SogoJigyoShuruiShikyuGendoGakuEntityGenerator.createDbT7118SogoJigyoShuruiShikyuGendoGakuEntity();
            SogoJigyoShuruiShikyuGendoGakuEntity.setXXX(主キー名1);
            SogoJigyoShuruiShikyuGendoGakuEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new SogoJigyoShuruiShikyuGendoGaku(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new SogoJigyoShuruiShikyuGendoGaku(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT7118SogoJigyoShuruiShikyuGendoGakuEntityにセットされている() {
            sut = new SogoJigyoShuruiShikyuGendoGaku(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するSogoJigyoShuruiShikyuGendoGakuIdentifierにセットされている() {
            sut = new SogoJigyoShuruiShikyuGendoGaku(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static SogoJigyoShuruiShikyuGendoGaku sut;

        @Before
        public void setUp() {
            SogoJigyoShuruiShikyuGendoGakuEntity = DbT7118SogoJigyoShuruiShikyuGendoGakuEntityGenerator.createDbT7118SogoJigyoShuruiShikyuGendoGakuEntity();
            SogoJigyoShuruiShikyuGendoGakuEntity.setXXX(主キー名1);
            SogoJigyoShuruiShikyuGendoGakuEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new SogoJigyoShuruiShikyuGendoGaku(null);
        }

        @Test
        public void 指定したDbT7118SogoJigyoShuruiShikyuGendoGakuEntityのキー情報を識別子が持つ() {

            sut = new SogoJigyoShuruiShikyuGendoGaku(SogoJigyoShuruiShikyuGendoGakuEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static SogoJigyoShuruiShikyuGendoGaku sut;

        @Before
        public void setUp() {
            SogoJigyoShuruiShikyuGendoGakuEntity = DbT7118SogoJigyoShuruiShikyuGendoGakuEntityGenerator.createDbT7118SogoJigyoShuruiShikyuGendoGakuEntity();
            SogoJigyoShuruiShikyuGendoGakuEntity.setXXX(主キー名1);
            SogoJigyoShuruiShikyuGendoGakuEntity.setXXX(主キー名2);

            sut = new SogoJigyoShuruiShikyuGendoGaku(SogoJigyoShuruiShikyuGendoGakuEntity);
        }

        @Test
        public void getサービス種類コードは_entityが持つサービス種類コードを返す() {
            assertThat(sut.getサービス種類コード(), is(SogoJigyoShuruiShikyuGendoGakuEntity.getServiceShuruiCode()));
        }

        @Test
        public void get要介護状態区分は_entityが持つ要介護状態区分を返す() {
            assertThat(sut.get要介護状態区分(), is(SogoJigyoShuruiShikyuGendoGakuEntity.getYoKaigoJotaiKubun()));
        }

        @Test
        public void get適用開始年月は_entityが持つ適用開始年月を返す() {
            assertThat(sut.get適用開始年月(), is(SogoJigyoShuruiShikyuGendoGakuEntity.getTekiyoKaishiYM()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(SogoJigyoShuruiShikyuGendoGakuEntity.getRirekiNo()));
        }

        @Test
        public void get適用終了年月は_entityが持つ適用終了年月を返す() {
            assertThat(sut.get適用終了年月(), is(SogoJigyoShuruiShikyuGendoGakuEntity.getTekiyoShuryoYM()));
        }

        @Test
        public void get支給限度単位数は_entityが持つ支給限度単位数を返す() {
            assertThat(sut.get支給限度単位数(), is(SogoJigyoShuruiShikyuGendoGakuEntity.getShikyuGendoTaniSu()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static SogoJigyoShuruiShikyuGendoGaku sut;

        @Before
        public void setUp() {
            SogoJigyoShuruiShikyuGendoGakuEntity = DbT7118SogoJigyoShuruiShikyuGendoGakuEntityGenerator.createDbT7118SogoJigyoShuruiShikyuGendoGakuEntity();
            SogoJigyoShuruiShikyuGendoGakuEntity.setXXX(主キー名1);
            SogoJigyoShuruiShikyuGendoGakuEntity.setXXX(主キー名2);

            sut = new SogoJigyoShuruiShikyuGendoGaku(SogoJigyoShuruiShikyuGendoGakuEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(SogoJigyoShuruiShikyuGendoGakuEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static SogoJigyoShuruiShikyuGendoGaku sut;

        @Before
        public void setUp() {
            SogoJigyoShuruiShikyuGendoGakuEntity = DbT7118SogoJigyoShuruiShikyuGendoGakuEntityGenerator.createDbT7118SogoJigyoShuruiShikyuGendoGakuEntity();
            SogoJigyoShuruiShikyuGendoGakuEntity.setXXX(主キー名1);
            SogoJigyoShuruiShikyuGendoGakuEntity.setXXX(主キー名2);

            sut = new SogoJigyoShuruiShikyuGendoGaku(SogoJigyoShuruiShikyuGendoGakuEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static SogoJigyoShuruiShikyuGendoGaku sut;
        private static SogoJigyoShuruiShikyuGendoGaku result;

        @Before
        public void setUp() {
            SogoJigyoShuruiShikyuGendoGakuEntity = DbT7118SogoJigyoShuruiShikyuGendoGakuEntityGenerator.createDbT7118SogoJigyoShuruiShikyuGendoGakuEntity();
            SogoJigyoShuruiShikyuGendoGakuEntity.setXXX(主キー名1);
            SogoJigyoShuruiShikyuGendoGakuEntity.setXXX(主キー名2);

        }

        @Test
        public void SogoJigyoShuruiShikyuGendoGakuが保持するDbT7118SogoJigyoShuruiShikyuGendoGakuEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりSogoJigyoShuruiShikyuGendoGakuが保持するDbT7118SogoJigyoShuruiShikyuGendoGakuEntityのEntityDataStateがDeletedに指定されたSogoJigyoShuruiShikyuGendoGakuが返る() {
            sut = TestSupport.setStateSogoJigyoShuruiShikyuGendoGaku(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void SogoJigyoShuruiShikyuGendoGakuが保持するDbT7118SogoJigyoShuruiShikyuGendoGakuEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりSogoJigyoShuruiShikyuGendoGakuが保持するDbT7118SogoJigyoShuruiShikyuGendoGakuEntityのEntityDataStateがDeletedに指定されたSogoJigyoShuruiShikyuGendoGakuが返る() {
            sut = TestSupport.setStateSogoJigyoShuruiShikyuGendoGaku(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void SogoJigyoShuruiShikyuGendoGakuが保持するDbT7118SogoJigyoShuruiShikyuGendoGakuEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりSogoJigyoShuruiShikyuGendoGakuが保持するDbT7118SogoJigyoShuruiShikyuGendoGakuEntityのEntityDataStateがDeletedに指定されたSogoJigyoShuruiShikyuGendoGakuが返る() {
            sut = TestSupport.setStateSogoJigyoShuruiShikyuGendoGaku(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void SogoJigyoShuruiShikyuGendoGakuが保持するDbT7118SogoJigyoShuruiShikyuGendoGakuEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateSogoJigyoShuruiShikyuGendoGaku(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static SogoJigyoShuruiShikyuGendoGaku setStateSogoJigyoShuruiShikyuGendoGaku(EntityDataState parentState) {
            SogoJigyoShuruiShikyuGendoGakuEntity.setState(parentState);
            return new SogoJigyoShuruiShikyuGendoGaku(SogoJigyoShuruiShikyuGendoGakuEntity);
        }
    }
}
