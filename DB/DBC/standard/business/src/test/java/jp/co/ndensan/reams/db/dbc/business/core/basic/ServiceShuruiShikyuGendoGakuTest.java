/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7111ServiceShuruiShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7111ServiceShuruiShikyuGendoGakuEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
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

/**
 * {@link ServiceShuruiShikyuGendoGaku}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ServiceShuruiShikyuGendoGakuTest extends DbcTestBase {

    private static DbT7111ServiceShuruiShikyuGendoGakuEntity ServiceShuruiShikyuGendoGakuEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ServiceShuruiCode 主キー名1;
    private static RString 主キー名2;
    private static FlexibleYearMonth 主キー名3;
    private static int 主キー名4;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7111ServiceShuruiShikyuGendoGakuEntityGenerator.DEFAULT_サービス種類コード;
        主キー名2 = DbT7111ServiceShuruiShikyuGendoGakuEntityGenerator.DEFAULT_要介護状態区分;
        主キー名3 = DbT7111ServiceShuruiShikyuGendoGakuEntityGenerator.DEFAULT_適用開始年月;
        主キー名4 = DbT7111ServiceShuruiShikyuGendoGakuEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static ServiceShuruiShikyuGendoGaku sut;

        @Before
        public void setUp() {
            ServiceShuruiShikyuGendoGakuEntity = DbT7111ServiceShuruiShikyuGendoGakuEntityGenerator.createDbT7111ServiceShuruiShikyuGendoGakuEntity();
            ServiceShuruiShikyuGendoGakuEntity.setServiceShuruiCode(主キー名1);
            ServiceShuruiShikyuGendoGakuEntity.setYoKaigoJotaiKubun(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ServiceShuruiShikyuGendoGaku(null, 主キー名2, 主キー名3, 主キー名4);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ServiceShuruiShikyuGendoGaku(主キー名1, null, 主キー名3, 主キー名4);
        }

        @Test
        public void 指定したキーが保持するDbT7111ServiceShuruiShikyuGendoGakuEntityにセットされている() {
            sut = new ServiceShuruiShikyuGendoGaku(主キー名1, 主キー名2, 主キー名3, 主キー名4);
            assertThat(sut.getサービス種類コード(), is(主キー名1));
            assertThat(sut.get要介護状態区分(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するServiceShuruiShikyuGendoGakuIdentifierにセットされている() {
            sut = new ServiceShuruiShikyuGendoGaku(主キー名1, 主キー名2, 主キー名3, 主キー名4);
            assertThat(sut.identifier().getサービス種類コード(), is(主キー名1));
            assertThat(sut.identifier().get要介護状態区分(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static ServiceShuruiShikyuGendoGaku sut;

        @Before
        public void setUp() {
            ServiceShuruiShikyuGendoGakuEntity = DbT7111ServiceShuruiShikyuGendoGakuEntityGenerator.createDbT7111ServiceShuruiShikyuGendoGakuEntity();
            ServiceShuruiShikyuGendoGakuEntity.setServiceShuruiCode(主キー名1);
            ServiceShuruiShikyuGendoGakuEntity.setYoKaigoJotaiKubun(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ServiceShuruiShikyuGendoGaku(null);
        }

        @Test
        public void 指定したDbT7111ServiceShuruiShikyuGendoGakuEntityのキー情報を識別子が持つ() {

            sut = new ServiceShuruiShikyuGendoGaku(ServiceShuruiShikyuGendoGakuEntity);

            assertThat(sut.identifier().getサービス種類コード(), is(主キー名1));
            assertThat(sut.identifier().get要介護状態区分(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static ServiceShuruiShikyuGendoGaku sut;

        @Before
        public void setUp() {
            ServiceShuruiShikyuGendoGakuEntity = DbT7111ServiceShuruiShikyuGendoGakuEntityGenerator.createDbT7111ServiceShuruiShikyuGendoGakuEntity();
            ServiceShuruiShikyuGendoGakuEntity.setServiceShuruiCode(主キー名1);
            ServiceShuruiShikyuGendoGakuEntity.setYoKaigoJotaiKubun(主キー名2);

            sut = new ServiceShuruiShikyuGendoGaku(ServiceShuruiShikyuGendoGakuEntity);
        }

        @Test
        public void getサービス種類コードは_entityが持つサービス種類コードを返す() {
            assertThat(sut.getサービス種類コード(), is(ServiceShuruiShikyuGendoGakuEntity.getServiceShuruiCode()));
        }

        @Test
        public void get要介護状態区分は_entityが持つ要介護状態区分を返す() {
            assertThat(sut.get要介護状態区分(), is(ServiceShuruiShikyuGendoGakuEntity.getYoKaigoJotaiKubun()));
        }

        @Test
        public void get適用開始年月は_entityが持つ適用開始年月を返す() {
            assertThat(sut.get適用開始年月(), is(ServiceShuruiShikyuGendoGakuEntity.getTekiyoKaishuYM()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(ServiceShuruiShikyuGendoGakuEntity.getRirekiNo()));
        }

        @Test
        public void get適用終了年月は_entityが持つ適用終了年月を返す() {
            assertThat(sut.get適用終了年月(), is(ServiceShuruiShikyuGendoGakuEntity.getTekiyoShuryuYM()));
        }

        @Test
        public void get支給限度単位数は_entityが持つ支給限度単位数を返す() {
            assertThat(sut.get支給限度単位数(), is(ServiceShuruiShikyuGendoGakuEntity.getShikyuGendoTaniSu()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static ServiceShuruiShikyuGendoGaku sut;

        @Before
        public void setUp() {
            ServiceShuruiShikyuGendoGakuEntity = DbT7111ServiceShuruiShikyuGendoGakuEntityGenerator.createDbT7111ServiceShuruiShikyuGendoGakuEntity();
            ServiceShuruiShikyuGendoGakuEntity.setServiceShuruiCode(主キー名1);
            ServiceShuruiShikyuGendoGakuEntity.setYoKaigoJotaiKubun(主キー名2);

            sut = new ServiceShuruiShikyuGendoGaku(ServiceShuruiShikyuGendoGakuEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ServiceShuruiShikyuGendoGakuEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static ServiceShuruiShikyuGendoGaku sut;

        @Before
        public void setUp() {
            ServiceShuruiShikyuGendoGakuEntity = DbT7111ServiceShuruiShikyuGendoGakuEntityGenerator.createDbT7111ServiceShuruiShikyuGendoGakuEntity();
            ServiceShuruiShikyuGendoGakuEntity.setServiceShuruiCode(主キー名1);
            ServiceShuruiShikyuGendoGakuEntity.setYoKaigoJotaiKubun(主キー名2);

            sut = new ServiceShuruiShikyuGendoGaku(ServiceShuruiShikyuGendoGakuEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static ServiceShuruiShikyuGendoGaku sut;
        private static ServiceShuruiShikyuGendoGaku result;

        @Before
        public void setUp() {
            ServiceShuruiShikyuGendoGakuEntity = DbT7111ServiceShuruiShikyuGendoGakuEntityGenerator.createDbT7111ServiceShuruiShikyuGendoGakuEntity();
            ServiceShuruiShikyuGendoGakuEntity.setServiceShuruiCode(主キー名1);
            ServiceShuruiShikyuGendoGakuEntity.setYoKaigoJotaiKubun(主キー名2);

        }

        @Test
        public void ServiceShuruiShikyuGendoGakuが保持するDbT7111ServiceShuruiShikyuGendoGakuEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりServiceShuruiShikyuGendoGakuが保持するDbT7111ServiceShuruiShikyuGendoGakuEntityのEntityDataStateがDeletedに指定されたServiceShuruiShikyuGendoGakuが返る() {
            sut = TestSupport.setStateServiceShuruiShikyuGendoGaku(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ServiceShuruiShikyuGendoGakuが保持するDbT7111ServiceShuruiShikyuGendoGakuEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりServiceShuruiShikyuGendoGakuが保持するDbT7111ServiceShuruiShikyuGendoGakuEntityのEntityDataStateがDeletedに指定されたServiceShuruiShikyuGendoGakuが返る() {
            sut = TestSupport.setStateServiceShuruiShikyuGendoGaku(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ServiceShuruiShikyuGendoGakuが保持するDbT7111ServiceShuruiShikyuGendoGakuEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりServiceShuruiShikyuGendoGakuが保持するDbT7111ServiceShuruiShikyuGendoGakuEntityのEntityDataStateがDeletedに指定されたServiceShuruiShikyuGendoGakuが返る() {
            sut = TestSupport.setStateServiceShuruiShikyuGendoGaku(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ServiceShuruiShikyuGendoGakuが保持するDbT7111ServiceShuruiShikyuGendoGakuEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateServiceShuruiShikyuGendoGaku(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ServiceShuruiShikyuGendoGaku setStateServiceShuruiShikyuGendoGaku(EntityDataState parentState) {
            ServiceShuruiShikyuGendoGakuEntity.setState(parentState);
            return new ServiceShuruiShikyuGendoGaku(ServiceShuruiShikyuGendoGakuEntity);
        }
    }
}
