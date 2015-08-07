/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT7120TokuteiShinryoServiceCodeEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7120TokuteiShinryoServiceCodeEntityGenerator;
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
 * {@link TokuteiShinryoServiceCode}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class TokuteiShinryoServiceCodeTest extends DbcTestBase {

    private static DbT7120TokuteiShinryoServiceCodeEntity TokuteiShinryoServiceCodeEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT7120TokuteiShinryoServiceCodeEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static TokuteiShinryoServiceCode sut;

        @Before
        public void setUp() {
            TokuteiShinryoServiceCodeEntity = DbT7120TokuteiShinryoServiceCodeEntityGenerator.createDbT7120TokuteiShinryoServiceCodeEntity();
            TokuteiShinryoServiceCodeEntity.setXXX(主キー名1);
            TokuteiShinryoServiceCodeEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new TokuteiShinryoServiceCode(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new TokuteiShinryoServiceCode(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT7120TokuteiShinryoServiceCodeEntityにセットされている() {
            sut = new TokuteiShinryoServiceCode(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するTokuteiShinryoServiceCodeIdentifierにセットされている() {
            sut = new TokuteiShinryoServiceCode(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static TokuteiShinryoServiceCode sut;

        @Before
        public void setUp() {
            TokuteiShinryoServiceCodeEntity = DbT7120TokuteiShinryoServiceCodeEntityGenerator.createDbT7120TokuteiShinryoServiceCodeEntity();
            TokuteiShinryoServiceCodeEntity.setXXX(主キー名1);
            TokuteiShinryoServiceCodeEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new TokuteiShinryoServiceCode(null);
        }

        @Test
        public void 指定したDbT7120TokuteiShinryoServiceCodeEntityのキー情報を識別子が持つ() {

            sut = new TokuteiShinryoServiceCode(TokuteiShinryoServiceCodeEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static TokuteiShinryoServiceCode sut;

        @Before
        public void setUp() {
            TokuteiShinryoServiceCodeEntity = DbT7120TokuteiShinryoServiceCodeEntityGenerator.createDbT7120TokuteiShinryoServiceCodeEntity();
            TokuteiShinryoServiceCodeEntity.setXXX(主キー名1);
            TokuteiShinryoServiceCodeEntity.setXXX(主キー名2);

            sut = new TokuteiShinryoServiceCode(TokuteiShinryoServiceCodeEntity);
        }

        @Test
        public void getサービス種類コードは_entityが持つサービス種類コードを返す() {
            assertThat(sut.getサービス種類コード(), is(TokuteiShinryoServiceCodeEntity.getServiceShuruiCode()));
        }

        @Test
        public void getサービス項目コードは_entityが持つサービス項目コードを返す() {
            assertThat(sut.getサービス項目コード(), is(TokuteiShinryoServiceCodeEntity.getServiceKomokuCode()));
        }

        @Test
        public void get適用開始年月は_entityが持つ適用開始年月を返す() {
            assertThat(sut.get適用開始年月(), is(TokuteiShinryoServiceCodeEntity.getTekiyoKaishiYM()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(TokuteiShinryoServiceCodeEntity.getRirekiNo()));
        }

        @Test
        public void get適用終了年月は_entityが持つ適用終了年月を返す() {
            assertThat(sut.get適用終了年月(), is(TokuteiShinryoServiceCodeEntity.getTekiyoShuryoYM()));
        }

        @Test
        public void getサービス名称は_entityが持つサービス名称を返す() {
            assertThat(sut.getサービス名称(), is(TokuteiShinryoServiceCodeEntity.getServiceMeisho()));
        }

        @Test
        public void get単位数は_entityが持つ単位数を返す() {
            assertThat(sut.get単位数(), is(TokuteiShinryoServiceCodeEntity.getTaniSu()));
        }

        @Test
        public void get単位数識別は_entityが持つ単位数識別を返す() {
            assertThat(sut.get単位数識別(), is(TokuteiShinryoServiceCodeEntity.getTaniSuShikibetsu()));
        }

        @Test
        public void get算定単位は_entityが持つ算定単位を返す() {
            assertThat(sut.get算定単位(), is(TokuteiShinryoServiceCodeEntity.getSanteiTani()));
        }

        @Test
        public void get合成識別区分は_entityが持つ合成識別区分を返す() {
            assertThat(sut.get合成識別区分(), is(TokuteiShinryoServiceCodeEntity.getGoseiShikibetsuKubun()));
        }

        @Test
        public void get特定診療区分コードは_entityが持つ特定診療区分コードを返す() {
            assertThat(sut.get特定診療区分コード(), is(TokuteiShinryoServiceCodeEntity.getTokuteiShinryoKubunCode()));
        }

        @Test
        public void get特定診療項目コードは_entityが持つ特定診療項目コードを返す() {
            assertThat(sut.get特定診療項目コード(), is(TokuteiShinryoServiceCodeEntity.getTokuteiShinryoKomokuCode()));
        }

        @Test
        public void get算定制約期間は_entityが持つ算定制約期間を返す() {
            assertThat(sut.get算定制約期間(), is(TokuteiShinryoServiceCodeEntity.getSanteiSeiyakuKikan()));
        }

        @Test
        public void get算定制約回数は_entityが持つ算定制約回数を返す() {
            assertThat(sut.get算定制約回数(), is(TokuteiShinryoServiceCodeEntity.getSanteiSeiyakuKaisu()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static TokuteiShinryoServiceCode sut;

        @Before
        public void setUp() {
            TokuteiShinryoServiceCodeEntity = DbT7120TokuteiShinryoServiceCodeEntityGenerator.createDbT7120TokuteiShinryoServiceCodeEntity();
            TokuteiShinryoServiceCodeEntity.setXXX(主キー名1);
            TokuteiShinryoServiceCodeEntity.setXXX(主キー名2);

            sut = new TokuteiShinryoServiceCode(TokuteiShinryoServiceCodeEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(TokuteiShinryoServiceCodeEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static TokuteiShinryoServiceCode sut;

        @Before
        public void setUp() {
            TokuteiShinryoServiceCodeEntity = DbT7120TokuteiShinryoServiceCodeEntityGenerator.createDbT7120TokuteiShinryoServiceCodeEntity();
            TokuteiShinryoServiceCodeEntity.setXXX(主キー名1);
            TokuteiShinryoServiceCodeEntity.setXXX(主キー名2);

            sut = new TokuteiShinryoServiceCode(TokuteiShinryoServiceCodeEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static TokuteiShinryoServiceCode sut;
        private static TokuteiShinryoServiceCode result;

        @Before
        public void setUp() {
            TokuteiShinryoServiceCodeEntity = DbT7120TokuteiShinryoServiceCodeEntityGenerator.createDbT7120TokuteiShinryoServiceCodeEntity();
            TokuteiShinryoServiceCodeEntity.setXXX(主キー名1);
            TokuteiShinryoServiceCodeEntity.setXXX(主キー名2);

        }

        @Test
        public void TokuteiShinryoServiceCodeが保持するDbT7120TokuteiShinryoServiceCodeEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりTokuteiShinryoServiceCodeが保持するDbT7120TokuteiShinryoServiceCodeEntityのEntityDataStateがDeletedに指定されたTokuteiShinryoServiceCodeが返る() {
            sut = TestSupport.setStateTokuteiShinryoServiceCode(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void TokuteiShinryoServiceCodeが保持するDbT7120TokuteiShinryoServiceCodeEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりTokuteiShinryoServiceCodeが保持するDbT7120TokuteiShinryoServiceCodeEntityのEntityDataStateがDeletedに指定されたTokuteiShinryoServiceCodeが返る() {
            sut = TestSupport.setStateTokuteiShinryoServiceCode(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void TokuteiShinryoServiceCodeが保持するDbT7120TokuteiShinryoServiceCodeEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりTokuteiShinryoServiceCodeが保持するDbT7120TokuteiShinryoServiceCodeEntityのEntityDataStateがDeletedに指定されたTokuteiShinryoServiceCodeが返る() {
            sut = TestSupport.setStateTokuteiShinryoServiceCode(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void TokuteiShinryoServiceCodeが保持するDbT7120TokuteiShinryoServiceCodeEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateTokuteiShinryoServiceCode(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static TokuteiShinryoServiceCode setStateTokuteiShinryoServiceCode(EntityDataState parentState) {
            TokuteiShinryoServiceCodeEntity.setState(parentState);
            return new TokuteiShinryoServiceCode(TokuteiShinryoServiceCodeEntity);
        }
    }
}
