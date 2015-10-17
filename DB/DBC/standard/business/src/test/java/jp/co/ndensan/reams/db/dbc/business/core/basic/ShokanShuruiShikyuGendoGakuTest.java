/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7112ShokanShuruiShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7112ShokanShuruiShikyuGendoGakuEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
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
 * {@link ShokanShuruiShikyuGendoGaku}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShokanShuruiShikyuGendoGakuTest extends DbcTestBase {

    private static DbT7112ShokanShuruiShikyuGendoGakuEntity ShokanShuruiShikyuGendoGakuEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ServiceShuruiCode 主キー名1;
    private static FlexibleYearMonth 主キー名2;
    private static int 主キー名3;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7112ShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_サービス種類コード;
        主キー名2 = DbT7112ShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_適用開始年月;
        主キー名3 = DbT7112ShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static ShokanShuruiShikyuGendoGaku sut;

        @Before
        public void setUp() {
            ShokanShuruiShikyuGendoGakuEntity = DbT7112ShokanShuruiShikyuGendoGakuEntityGenerator.createDbT7112ShokanShuruiShikyuGendoGakuEntity();
            ShokanShuruiShikyuGendoGakuEntity.setServiceShuruiCode(主キー名1);
            ShokanShuruiShikyuGendoGakuEntity.setTekiyoKaishiYM(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShokanShuruiShikyuGendoGaku(null, 主キー名2, 主キー名3);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShokanShuruiShikyuGendoGaku(主キー名1, null, 主キー名3);
        }

        @Test
        public void 指定したキーが保持するDbT7112ShokanShuruiShikyuGendoGakuEntityにセットされている() {
            sut = new ShokanShuruiShikyuGendoGaku(主キー名1, 主キー名2, 主キー名3);
            assertThat(sut.getサービス種類コード(), is(主キー名1));
            assertThat(sut.get適用開始年月(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するShokanShuruiShikyuGendoGakuIdentifierにセットされている() {
            sut = new ShokanShuruiShikyuGendoGaku(主キー名1, 主キー名2, 主キー名3);
            assertThat(sut.identifier().getサービス種類コード(), is(主キー名1));
            assertThat(sut.identifier().get適用開始年月(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static ShokanShuruiShikyuGendoGaku sut;

        @Before
        public void setUp() {
            ShokanShuruiShikyuGendoGakuEntity = DbT7112ShokanShuruiShikyuGendoGakuEntityGenerator.createDbT7112ShokanShuruiShikyuGendoGakuEntity();
            ShokanShuruiShikyuGendoGakuEntity.setServiceShuruiCode(主キー名1);
            ShokanShuruiShikyuGendoGakuEntity.setTekiyoKaishiYM(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ShokanShuruiShikyuGendoGaku(null);
        }

        @Test
        public void 指定したDbT7112ShokanShuruiShikyuGendoGakuEntityのキー情報を識別子が持つ() {

            sut = new ShokanShuruiShikyuGendoGaku(ShokanShuruiShikyuGendoGakuEntity);

            assertThat(sut.identifier().getサービス種類コード(), is(主キー名1));
            assertThat(sut.identifier().get適用開始年月(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static ShokanShuruiShikyuGendoGaku sut;

        @Before
        public void setUp() {
            ShokanShuruiShikyuGendoGakuEntity = DbT7112ShokanShuruiShikyuGendoGakuEntityGenerator.createDbT7112ShokanShuruiShikyuGendoGakuEntity();
            ShokanShuruiShikyuGendoGakuEntity.setServiceShuruiCode(主キー名1);
            ShokanShuruiShikyuGendoGakuEntity.setTekiyoKaishiYM(主キー名2);

            sut = new ShokanShuruiShikyuGendoGaku(ShokanShuruiShikyuGendoGakuEntity);
        }

        @Test
        public void getサービス種類コードは_entityが持つサービス種類コードを返す() {
            assertThat(sut.getサービス種類コード(), is(ShokanShuruiShikyuGendoGakuEntity.getServiceShuruiCode()));
        }

        @Test
        public void get適用開始年月は_entityが持つ適用開始年月を返す() {
            assertThat(sut.get適用開始年月(), is(ShokanShuruiShikyuGendoGakuEntity.getTekiyoKaishiYM()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(ShokanShuruiShikyuGendoGakuEntity.getRirekiNo()));
        }

        @Test
        public void get適用終了年月は_entityが持つ適用終了年月を返す() {
            assertThat(sut.get適用終了年月(), is(ShokanShuruiShikyuGendoGakuEntity.getTekiyoShuryoYM()));
        }

        @Test
        public void get支給限度単位数は_entityが持つ支給限度単位数を返す() {
            assertThat(sut.get支給限度単位数(), is(ShokanShuruiShikyuGendoGakuEntity.getShikyuGendoTaniSu()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static ShokanShuruiShikyuGendoGaku sut;

        @Before
        public void setUp() {
            ShokanShuruiShikyuGendoGakuEntity = DbT7112ShokanShuruiShikyuGendoGakuEntityGenerator.createDbT7112ShokanShuruiShikyuGendoGakuEntity();
            ShokanShuruiShikyuGendoGakuEntity.setServiceShuruiCode(主キー名1);
            ShokanShuruiShikyuGendoGakuEntity.setTekiyoKaishiYM(主キー名2);

            sut = new ShokanShuruiShikyuGendoGaku(ShokanShuruiShikyuGendoGakuEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ShokanShuruiShikyuGendoGakuEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static ShokanShuruiShikyuGendoGaku sut;

        @Before
        public void setUp() {
            ShokanShuruiShikyuGendoGakuEntity = DbT7112ShokanShuruiShikyuGendoGakuEntityGenerator.createDbT7112ShokanShuruiShikyuGendoGakuEntity();
            ShokanShuruiShikyuGendoGakuEntity.setServiceShuruiCode(主キー名1);
            ShokanShuruiShikyuGendoGakuEntity.setTekiyoKaishiYM(主キー名2);

            sut = new ShokanShuruiShikyuGendoGaku(ShokanShuruiShikyuGendoGakuEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static ShokanShuruiShikyuGendoGaku sut;
        private static ShokanShuruiShikyuGendoGaku result;

        @Before
        public void setUp() {
            ShokanShuruiShikyuGendoGakuEntity = DbT7112ShokanShuruiShikyuGendoGakuEntityGenerator.createDbT7112ShokanShuruiShikyuGendoGakuEntity();
            ShokanShuruiShikyuGendoGakuEntity.setServiceShuruiCode(主キー名1);
            ShokanShuruiShikyuGendoGakuEntity.setTekiyoKaishiYM(主キー名2);

        }

        @Test
        public void ShokanShuruiShikyuGendoGakuが保持するDbT7112ShokanShuruiShikyuGendoGakuEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりShokanShuruiShikyuGendoGakuが保持するDbT7112ShokanShuruiShikyuGendoGakuEntityのEntityDataStateがDeletedに指定されたShokanShuruiShikyuGendoGakuが返る() {
            sut = TestSupport.setStateShokanShuruiShikyuGendoGaku(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShokanShuruiShikyuGendoGakuが保持するDbT7112ShokanShuruiShikyuGendoGakuEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりShokanShuruiShikyuGendoGakuが保持するDbT7112ShokanShuruiShikyuGendoGakuEntityのEntityDataStateがDeletedに指定されたShokanShuruiShikyuGendoGakuが返る() {
            sut = TestSupport.setStateShokanShuruiShikyuGendoGaku(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShokanShuruiShikyuGendoGakuが保持するDbT7112ShokanShuruiShikyuGendoGakuEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりShokanShuruiShikyuGendoGakuが保持するDbT7112ShokanShuruiShikyuGendoGakuEntityのEntityDataStateがDeletedに指定されたShokanShuruiShikyuGendoGakuが返る() {
            sut = TestSupport.setStateShokanShuruiShikyuGendoGaku(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ShokanShuruiShikyuGendoGakuが保持するDbT7112ShokanShuruiShikyuGendoGakuEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateShokanShuruiShikyuGendoGaku(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ShokanShuruiShikyuGendoGaku setStateShokanShuruiShikyuGendoGaku(EntityDataState parentState) {
            ShokanShuruiShikyuGendoGakuEntity.setState(parentState);
            return new ShokanShuruiShikyuGendoGaku(ShokanShuruiShikyuGendoGakuEntity);
        }
    }
}
