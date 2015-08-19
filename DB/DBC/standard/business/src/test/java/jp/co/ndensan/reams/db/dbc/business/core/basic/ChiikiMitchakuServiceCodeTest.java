/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT7121ChiikiMitchakuServiceCodeEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7121ChiikiMitchakuServiceCodeEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ServiceShuruiCode;
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
 * {@link ChiikiMitchakuServiceCode}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ChiikiMitchakuServiceCodeTest extends DbcTestBase {

    private static DbT7121ChiikiMitchakuServiceCodeEntity ChiikiMitchakuServiceCodeEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ServiceShuruiCode 主キー名1;
    private static ServiceKomokuCode 主キー名2;
    private static FlexibleYearMonth 主キー名3;
    private static int 主キー名4;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7121ChiikiMitchakuServiceCodeEntityGenerator.DEFAULT_サービス種類コード;
        主キー名2 = DbT7121ChiikiMitchakuServiceCodeEntityGenerator.DEFAULT_サービス項目コード;
        主キー名3 = DbT7121ChiikiMitchakuServiceCodeEntityGenerator.DEFAULT_適用開始年月;
        主キー名4 = DbT7121ChiikiMitchakuServiceCodeEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static ChiikiMitchakuServiceCode sut;

        @Before
        public void setUp() {
            ChiikiMitchakuServiceCodeEntity = DbT7121ChiikiMitchakuServiceCodeEntityGenerator.createDbT7121ChiikiMitchakuServiceCodeEntity();
            ChiikiMitchakuServiceCodeEntity.setServiceShuruiCode(主キー名1);
            ChiikiMitchakuServiceCodeEntity.setServiceKomokuCode(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ChiikiMitchakuServiceCode(null, 主キー名2, 主キー名3, 主キー名4);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ChiikiMitchakuServiceCode(主キー名1, null, 主キー名3, 主キー名4);
        }

        @Test
        public void 指定したキーが保持するDbT7121ChiikiMitchakuServiceCodeEntityにセットされている() {
            sut = new ChiikiMitchakuServiceCode(主キー名1, 主キー名2, 主キー名3, 主キー名4);
            assertThat(sut.getサービス種類コード(), is(主キー名1));
            assertThat(sut.getサービス項目コード(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するChiikiMitchakuServiceCodeIdentifierにセットされている() {
            sut = new ChiikiMitchakuServiceCode(主キー名1, 主キー名2, 主キー名3, 主キー名4);
            assertThat(sut.identifier().getサービス種類コード(), is(主キー名1));
            assertThat(sut.identifier().getサービス項目コード(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static ChiikiMitchakuServiceCode sut;

        @Before
        public void setUp() {
            ChiikiMitchakuServiceCodeEntity = DbT7121ChiikiMitchakuServiceCodeEntityGenerator.createDbT7121ChiikiMitchakuServiceCodeEntity();
            ChiikiMitchakuServiceCodeEntity.setServiceShuruiCode(主キー名1);
            ChiikiMitchakuServiceCodeEntity.setServiceKomokuCode(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ChiikiMitchakuServiceCode(null);
        }

        @Test
        public void 指定したDbT7121ChiikiMitchakuServiceCodeEntityのキー情報を識別子が持つ() {

            sut = new ChiikiMitchakuServiceCode(ChiikiMitchakuServiceCodeEntity);

            assertThat(sut.identifier().getサービス種類コード(), is(主キー名1));
            assertThat(sut.identifier().getサービス項目コード(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static ChiikiMitchakuServiceCode sut;

        @Before
        public void setUp() {
            ChiikiMitchakuServiceCodeEntity = DbT7121ChiikiMitchakuServiceCodeEntityGenerator.createDbT7121ChiikiMitchakuServiceCodeEntity();
            ChiikiMitchakuServiceCodeEntity.setServiceShuruiCode(主キー名1);
            ChiikiMitchakuServiceCodeEntity.setServiceKomokuCode(主キー名2);

            sut = new ChiikiMitchakuServiceCode(ChiikiMitchakuServiceCodeEntity);
        }

        @Test
        public void getサービス種類コードは_entityが持つサービス種類コードを返す() {
            assertThat(sut.getサービス種類コード(), is(ChiikiMitchakuServiceCodeEntity.getServiceShuruiCode()));
        }

        @Test
        public void getサービス項目コードは_entityが持つサービス項目コードを返す() {
            assertThat(sut.getサービス項目コード(), is(ChiikiMitchakuServiceCodeEntity.getServiceKomokuCode()));
        }

        @Test
        public void get適用開始年月は_entityが持つ適用開始年月を返す() {
            assertThat(sut.get適用開始年月(), is(ChiikiMitchakuServiceCodeEntity.getTekiyoKaishiYM()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(ChiikiMitchakuServiceCodeEntity.getRirekiNo()));
        }

        @Test
        public void get適用終了年月は_entityが持つ適用終了年月を返す() {
            assertThat(sut.get適用終了年月(), is(ChiikiMitchakuServiceCodeEntity.getTekiyoShuryoYM()));
        }

        @Test
        public void getサービス名称は_entityが持つサービス名称を返す() {
            assertThat(sut.getサービス名称(), is(ChiikiMitchakuServiceCodeEntity.getServiceMeisho()));
        }

        @Test
        public void get単位数は_entityが持つ単位数を返す() {
            assertThat(sut.get単位数(), is(ChiikiMitchakuServiceCodeEntity.getTaniSu()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static ChiikiMitchakuServiceCode sut;

        @Before
        public void setUp() {
            ChiikiMitchakuServiceCodeEntity = DbT7121ChiikiMitchakuServiceCodeEntityGenerator.createDbT7121ChiikiMitchakuServiceCodeEntity();
            ChiikiMitchakuServiceCodeEntity.setServiceShuruiCode(主キー名1);
            ChiikiMitchakuServiceCodeEntity.setServiceKomokuCode(主キー名2);

            sut = new ChiikiMitchakuServiceCode(ChiikiMitchakuServiceCodeEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ChiikiMitchakuServiceCodeEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static ChiikiMitchakuServiceCode sut;

        @Before
        public void setUp() {
            ChiikiMitchakuServiceCodeEntity = DbT7121ChiikiMitchakuServiceCodeEntityGenerator.createDbT7121ChiikiMitchakuServiceCodeEntity();
            ChiikiMitchakuServiceCodeEntity.setServiceShuruiCode(主キー名1);
            ChiikiMitchakuServiceCodeEntity.setServiceKomokuCode(主キー名2);

            sut = new ChiikiMitchakuServiceCode(ChiikiMitchakuServiceCodeEntity);
        }

//        @Test
//        public void シリアライズできる() {
//            assertThat(sut, is(serializable()));
//        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static ChiikiMitchakuServiceCode sut;
        private static ChiikiMitchakuServiceCode result;

        @Before
        public void setUp() {
            ChiikiMitchakuServiceCodeEntity = DbT7121ChiikiMitchakuServiceCodeEntityGenerator.createDbT7121ChiikiMitchakuServiceCodeEntity();
            ChiikiMitchakuServiceCodeEntity.setServiceShuruiCode(主キー名1);
            ChiikiMitchakuServiceCodeEntity.setServiceKomokuCode(主キー名2);

        }

        @Test
        public void ChiikiMitchakuServiceCodeが保持するDbT7121ChiikiMitchakuServiceCodeEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりChiikiMitchakuServiceCodeが保持するDbT7121ChiikiMitchakuServiceCodeEntityのEntityDataStateがDeletedに指定されたChiikiMitchakuServiceCodeが返る() {
            sut = TestSupport.setStateChiikiMitchakuServiceCode(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ChiikiMitchakuServiceCodeが保持するDbT7121ChiikiMitchakuServiceCodeEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりChiikiMitchakuServiceCodeが保持するDbT7121ChiikiMitchakuServiceCodeEntityのEntityDataStateがDeletedに指定されたChiikiMitchakuServiceCodeが返る() {
            sut = TestSupport.setStateChiikiMitchakuServiceCode(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ChiikiMitchakuServiceCodeが保持するDbT7121ChiikiMitchakuServiceCodeEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりChiikiMitchakuServiceCodeが保持するDbT7121ChiikiMitchakuServiceCodeEntityのEntityDataStateがDeletedに指定されたChiikiMitchakuServiceCodeが返る() {
            sut = TestSupport.setStateChiikiMitchakuServiceCode(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ChiikiMitchakuServiceCodeが保持するDbT7121ChiikiMitchakuServiceCodeEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateChiikiMitchakuServiceCode(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ChiikiMitchakuServiceCode setStateChiikiMitchakuServiceCode(EntityDataState parentState) {
            ChiikiMitchakuServiceCodeEntity.setState(parentState);
            return new ChiikiMitchakuServiceCode(ChiikiMitchakuServiceCodeEntity);
        }
    }
}
