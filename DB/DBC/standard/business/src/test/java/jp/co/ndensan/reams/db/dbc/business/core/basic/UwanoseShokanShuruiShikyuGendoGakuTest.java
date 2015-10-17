/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7115UwanoseShokanShuruiShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7115UwanoseShokanShuruiShikyuGendoGakuEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable;
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
 * {@link UwanoseShokanShuruiShikyuGendoGaku}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class UwanoseShokanShuruiShikyuGendoGakuTest extends DbcTestBase {

    private static DbT7115UwanoseShokanShuruiShikyuGendoGakuEntity UwanoseShokanShuruiShikyuGendoGakuEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ServiceShuruiCode 主キー名1;
    private static FlexibleYearMonth 主キー名2;
    private static int 主キー名3;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7115UwanoseShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_サービス種類コード;
        主キー名2 = DbT7115UwanoseShokanShuruiShikyuGendoGakuEntityGenerator.DEFAULT_適用開始年月;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static UwanoseShokanShuruiShikyuGendoGaku sut;

        @Before
        public void setUp() {
            UwanoseShokanShuruiShikyuGendoGakuEntity = DbT7115UwanoseShokanShuruiShikyuGendoGakuEntityGenerator.createDbT7115UwanoseShokanShuruiShikyuGendoGakuEntity();
            UwanoseShokanShuruiShikyuGendoGakuEntity.setServiceShuruiCode(主キー名1);
            UwanoseShokanShuruiShikyuGendoGakuEntity.setTekiyoKaishiYM(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new UwanoseShokanShuruiShikyuGendoGaku(null, 主キー名2, 主キー名3);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new UwanoseShokanShuruiShikyuGendoGaku(主キー名1, null, 主キー名3);
        }

        @Test
        public void 指定したキーが保持するDbT7115UwanoseShokanShuruiShikyuGendoGakuEntityにセットされている() {
            sut = new UwanoseShokanShuruiShikyuGendoGaku(主キー名1, 主キー名2, 主キー名3);
            assertThat(sut.getサービス種類コード(), is(主キー名1));
            assertThat(sut.get適用開始年月(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するUwanoseShokanShuruiShikyuGendoGakuIdentifierにセットされている() {
            sut = new UwanoseShokanShuruiShikyuGendoGaku(主キー名1, 主キー名2, 主キー名3);
            assertThat(sut.identifier().getサービス種類コード(), is(主キー名1));
            assertThat(sut.identifier().get適用開始年月(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static UwanoseShokanShuruiShikyuGendoGaku sut;

        @Before
        public void setUp() {
            UwanoseShokanShuruiShikyuGendoGakuEntity = DbT7115UwanoseShokanShuruiShikyuGendoGakuEntityGenerator.createDbT7115UwanoseShokanShuruiShikyuGendoGakuEntity();
            UwanoseShokanShuruiShikyuGendoGakuEntity.setServiceShuruiCode(主キー名1);
            UwanoseShokanShuruiShikyuGendoGakuEntity.setTekiyoKaishiYM(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new UwanoseShokanShuruiShikyuGendoGaku(null);
        }

        @Test
        public void 指定したDbT7115UwanoseShokanShuruiShikyuGendoGakuEntityのキー情報を識別子が持つ() {

            sut = new UwanoseShokanShuruiShikyuGendoGaku(UwanoseShokanShuruiShikyuGendoGakuEntity);

            assertThat(sut.identifier().getサービス種類コード(), is(主キー名1));
            assertThat(sut.identifier().get適用開始年月(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static UwanoseShokanShuruiShikyuGendoGaku sut;

        @Before
        public void setUp() {
            UwanoseShokanShuruiShikyuGendoGakuEntity = DbT7115UwanoseShokanShuruiShikyuGendoGakuEntityGenerator.createDbT7115UwanoseShokanShuruiShikyuGendoGakuEntity();
            UwanoseShokanShuruiShikyuGendoGakuEntity.setServiceShuruiCode(主キー名1);
            UwanoseShokanShuruiShikyuGendoGakuEntity.setTekiyoKaishiYM(主キー名2);

            sut = new UwanoseShokanShuruiShikyuGendoGaku(UwanoseShokanShuruiShikyuGendoGakuEntity);
        }

        @Test
        public void getサービス種類コードは_entityが持つサービス種類コードを返す() {
            assertThat(sut.getサービス種類コード(), is(UwanoseShokanShuruiShikyuGendoGakuEntity.getServiceShuruiCode()));
        }

        @Test
        public void get適用開始年月は_entityが持つ適用開始年月を返す() {
            assertThat(sut.get適用開始年月(), is(UwanoseShokanShuruiShikyuGendoGakuEntity.getTekiyoKaishiYM()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(UwanoseShokanShuruiShikyuGendoGakuEntity.getRirekiNo()));
        }

        @Test
        public void get適用終了年月は_entityが持つ適用終了年月を返す() {
            assertThat(sut.get適用終了年月(), is(UwanoseShokanShuruiShikyuGendoGakuEntity.getTekiyoShuryoYM()));
        }

        @Test
        public void get支給限度単位数は_entityが持つ支給限度単位数を返す() {
            assertThat(sut.get支給限度単位数(), is(UwanoseShokanShuruiShikyuGendoGakuEntity.getShikyuGendoTaniSu()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static UwanoseShokanShuruiShikyuGendoGaku sut;

        @Before
        public void setUp() {
            UwanoseShokanShuruiShikyuGendoGakuEntity = DbT7115UwanoseShokanShuruiShikyuGendoGakuEntityGenerator.createDbT7115UwanoseShokanShuruiShikyuGendoGakuEntity();
            UwanoseShokanShuruiShikyuGendoGakuEntity.setServiceShuruiCode(主キー名1);
            UwanoseShokanShuruiShikyuGendoGakuEntity.setTekiyoKaishiYM(主キー名2);

            sut = new UwanoseShokanShuruiShikyuGendoGaku(UwanoseShokanShuruiShikyuGendoGakuEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(UwanoseShokanShuruiShikyuGendoGakuEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static UwanoseShokanShuruiShikyuGendoGaku sut;

        @Before
        public void setUp() {
            UwanoseShokanShuruiShikyuGendoGakuEntity = DbT7115UwanoseShokanShuruiShikyuGendoGakuEntityGenerator.createDbT7115UwanoseShokanShuruiShikyuGendoGakuEntity();
            UwanoseShokanShuruiShikyuGendoGakuEntity.setServiceShuruiCode(主キー名1);
            UwanoseShokanShuruiShikyuGendoGakuEntity.setTekiyoKaishiYM(主キー名2);

            sut = new UwanoseShokanShuruiShikyuGendoGaku(UwanoseShokanShuruiShikyuGendoGakuEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(IsSerializable.serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static UwanoseShokanShuruiShikyuGendoGaku sut;
        private static UwanoseShokanShuruiShikyuGendoGaku result;

        @Before
        public void setUp() {
            UwanoseShokanShuruiShikyuGendoGakuEntity = DbT7115UwanoseShokanShuruiShikyuGendoGakuEntityGenerator.createDbT7115UwanoseShokanShuruiShikyuGendoGakuEntity();
            UwanoseShokanShuruiShikyuGendoGakuEntity.setServiceShuruiCode(主キー名1);
            UwanoseShokanShuruiShikyuGendoGakuEntity.setTekiyoKaishiYM(主キー名2);

        }

        @Test
        public void UwanoseShokanShuruiShikyuGendoGakuが保持するDbT7115UwanoseShokanShuruiShikyuGendoGakuEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりUwanoseShokanShuruiShikyuGendoGakuが保持するDbT7115UwanoseShokanShuruiShikyuGendoGakuEntityのEntityDataStateがDeletedに指定されたUwanoseShokanShuruiShikyuGendoGakuが返る() {
            sut = TestSupport.setStateUwanoseShokanShuruiShikyuGendoGaku(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void UwanoseShokanShuruiShikyuGendoGakuが保持するDbT7115UwanoseShokanShuruiShikyuGendoGakuEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりUwanoseShokanShuruiShikyuGendoGakuが保持するDbT7115UwanoseShokanShuruiShikyuGendoGakuEntityのEntityDataStateがDeletedに指定されたUwanoseShokanShuruiShikyuGendoGakuが返る() {
            sut = TestSupport.setStateUwanoseShokanShuruiShikyuGendoGaku(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void UwanoseShokanShuruiShikyuGendoGakuが保持するDbT7115UwanoseShokanShuruiShikyuGendoGakuEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりUwanoseShokanShuruiShikyuGendoGakuが保持するDbT7115UwanoseShokanShuruiShikyuGendoGakuEntityのEntityDataStateがDeletedに指定されたUwanoseShokanShuruiShikyuGendoGakuが返る() {
            sut = TestSupport.setStateUwanoseShokanShuruiShikyuGendoGaku(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void UwanoseShokanShuruiShikyuGendoGakuが保持するDbT7115UwanoseShokanShuruiShikyuGendoGakuEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateUwanoseShokanShuruiShikyuGendoGaku(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static UwanoseShokanShuruiShikyuGendoGaku setStateUwanoseShokanShuruiShikyuGendoGaku(EntityDataState parentState) {
            UwanoseShokanShuruiShikyuGendoGakuEntity.setState(parentState);
            return new UwanoseShokanShuruiShikyuGendoGaku(UwanoseShokanShuruiShikyuGendoGakuEntity);
        }
    }
}
