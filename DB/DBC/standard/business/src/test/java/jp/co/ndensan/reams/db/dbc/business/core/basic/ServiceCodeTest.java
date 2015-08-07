/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT7119ServiceCodeEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.helper.DbT7119ServiceCodeEntityGenerator;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceCode;
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
 * {@link ServiceCode}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ServiceCodeTest extends DbcTestBase {

    private static DbT7119ServiceCodeEntity ServiceCodeEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7119ServiceCodeEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT7119ServiceCodeEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static ServiceCode sut;

        @Before
        public void setUp() {
            ServiceCodeEntity = DbT7119ServiceCodeEntityGenerator.createDbT7119ServiceCodeEntity();
            ServiceCodeEntity.setXXX(主キー名1);
            ServiceCodeEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ServiceCode(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ServiceCode(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT7119ServiceCodeEntityにセットされている() {
            sut = new ServiceCode(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するServiceCodeIdentifierにセットされている() {
            sut = new ServiceCode(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static ServiceCode sut;

        @Before
        public void setUp() {
            ServiceCodeEntity = DbT7119ServiceCodeEntityGenerator.createDbT7119ServiceCodeEntity();
            ServiceCodeEntity.setXXX(主キー名1);
            ServiceCodeEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ServiceCode(null);
        }

        @Test
        public void 指定したDbT7119ServiceCodeEntityのキー情報を識別子が持つ() {

            sut = new ServiceCode(ServiceCodeEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static ServiceCode sut;

        @Before
        public void setUp() {
            ServiceCodeEntity = DbT7119ServiceCodeEntityGenerator.createDbT7119ServiceCodeEntity();
            ServiceCodeEntity.setXXX(主キー名1);
            ServiceCodeEntity.setXXX(主キー名2);

            sut = new ServiceCode(ServiceCodeEntity);
        }

        @Test
        public void getサービス種類コードは_entityが持つサービス種類コードを返す() {
            assertThat(sut.getサービス種類コード(), is(ServiceCodeEntity.getServiceShuruiCode()));
        }

        @Test
        public void getサービス項目コードは_entityが持つサービス項目コードを返す() {
            assertThat(sut.getサービス項目コード(), is(ServiceCodeEntity.getServiceKomokuCode()));
        }

        @Test
        public void get適用開始年月は_entityが持つ適用開始年月を返す() {
            assertThat(sut.get適用開始年月(), is(ServiceCodeEntity.getTekiyoKaishiYM()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(ServiceCodeEntity.getRirekiNo()));
        }

        @Test
        public void get適用終了年月は_entityが持つ適用終了年月を返す() {
            assertThat(sut.get適用終了年月(), is(ServiceCodeEntity.getTekiyoShuryoYM()));
        }

        @Test
        public void getサービス名称は_entityが持つサービス名称を返す() {
            assertThat(sut.getサービス名称(), is(ServiceCodeEntity.getServiceMeisho()));
        }

        @Test
        public void get単位数は_entityが持つ単位数を返す() {
            assertThat(sut.get単位数(), is(ServiceCodeEntity.getTaniSu()));
        }

        @Test
        public void get限度額対象外フラグは_entityが持つ限度額対象外フラグを返す() {
            assertThat(sut.get限度額対象外フラグ(), is(ServiceCodeEntity.getGendoGakuTaishogaiFlag()));
        }

        @Test
        public void get単位数識別コードは_entityが持つ単位数識別コードを返す() {
            assertThat(sut.get単位数識別コード(), is(ServiceCodeEntity.getTaniSuShikibetsuCode()));
        }

        @Test
        public void get外部サービス利用型区分は_entityが持つ外部サービス利用型区分を返す() {
            assertThat(sut.get外部サービス利用型区分(), is(ServiceCodeEntity.getGaibuServiceRiyogataKubun()));
        }

        @Test
        public void get特別地域加算フラグは_entityが持つ特別地域加算フラグを返す() {
            assertThat(sut.get特別地域加算フラグ(), is(ServiceCodeEntity.getTokubetsuChiikiKasanFlag()));
        }

        @Test
        public void get利用者負担定率／定額区分は_entityが持つ利用者負担定率

        ／定額区分を返す() {
            assertThat(sut.get利用者負担定率
            ／定額区分()
            , is(ServiceCodeEntity.getTeiRitsu_TeiGakuKubun())


        );
        }

        @Test
        public void get利用者負担額は_entityが持つ利用者負担額を返す() {
            assertThat(sut.get利用者負担額(), is(ServiceCodeEntity.getRiyoshaFutanGaku()));
        }

        @Test
        public void get給付率は_entityが持つ給付率を返す() {
            assertThat(sut.get給付率(), is(ServiceCodeEntity.getKyufuRitsu()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static ServiceCode sut;

        @Before
        public void setUp() {
            ServiceCodeEntity = DbT7119ServiceCodeEntityGenerator.createDbT7119ServiceCodeEntity();
            ServiceCodeEntity.setXXX(主キー名1);
            ServiceCodeEntity.setXXX(主キー名2);

            sut = new ServiceCode(ServiceCodeEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ServiceCodeEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static ServiceCode sut;

        @Before
        public void setUp() {
            ServiceCodeEntity = DbT7119ServiceCodeEntityGenerator.createDbT7119ServiceCodeEntity();
            ServiceCodeEntity.setXXX(主キー名1);
            ServiceCodeEntity.setXXX(主キー名2);

            sut = new ServiceCode(ServiceCodeEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static ServiceCode sut;
        private static ServiceCode result;

        @Before
        public void setUp() {
            ServiceCodeEntity = DbT7119ServiceCodeEntityGenerator.createDbT7119ServiceCodeEntity();
            ServiceCodeEntity.setXXX(主キー名1);
            ServiceCodeEntity.setXXX(主キー名2);

        }

        @Test
        public void ServiceCodeが保持するDbT7119ServiceCodeEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりServiceCodeが保持するDbT7119ServiceCodeEntityのEntityDataStateがDeletedに指定されたServiceCodeが返る() {
            sut = TestSupport.setStateServiceCode(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ServiceCodeが保持するDbT7119ServiceCodeEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりServiceCodeが保持するDbT7119ServiceCodeEntityのEntityDataStateがDeletedに指定されたServiceCodeが返る() {
            sut = TestSupport.setStateServiceCode(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ServiceCodeが保持するDbT7119ServiceCodeEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりServiceCodeが保持するDbT7119ServiceCodeEntityのEntityDataStateがDeletedに指定されたServiceCodeが返る() {
            sut = TestSupport.setStateServiceCode(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ServiceCodeが保持するDbT7119ServiceCodeEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateServiceCode(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ServiceCode setStateServiceCode(EntityDataState parentState) {
            ServiceCodeEntity.setState(parentState);
            return new ServiceCode(ServiceCodeEntity);
        }
    }
}
