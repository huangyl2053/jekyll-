/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.testhelper.DbcTestBase;
import static jp.co.ndensan.reams.db.dbc.testhelper.matcher.IsSerializable.serializable;
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
 * {@link KyufuhiTuchiHosei}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufuhiTuchiHoseiTest extends DbcTestBase {

    private static DbT3067KyufuhiTuchiHoseiEntity KyufuhiTuchiHoseiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KyufuhiTuchiHosei sut;

        @Before
        public void setUp() {
            KyufuhiTuchiHoseiEntity = DbT3067KyufuhiTuchiHoseiEntityGenerator.createDbT3067KyufuhiTuchiHoseiEntity();
            KyufuhiTuchiHoseiEntity.setXXX(主キー名1);
            KyufuhiTuchiHoseiEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufuhiTuchiHosei(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufuhiTuchiHosei(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT3067KyufuhiTuchiHoseiEntityにセットされている() {
            sut = new KyufuhiTuchiHosei(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKyufuhiTuchiHoseiIdentifierにセットされている() {
            sut = new KyufuhiTuchiHosei(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KyufuhiTuchiHosei sut;

        @Before
        public void setUp() {
            KyufuhiTuchiHoseiEntity = DbT3067KyufuhiTuchiHoseiEntityGenerator.createDbT3067KyufuhiTuchiHoseiEntity();
            KyufuhiTuchiHoseiEntity.setXXX(主キー名1);
            KyufuhiTuchiHoseiEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KyufuhiTuchiHosei(null);
        }

        @Test
        public void 指定したDbT3067KyufuhiTuchiHoseiEntityのキー情報を識別子が持つ() {

            sut = new KyufuhiTuchiHosei(KyufuhiTuchiHoseiEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KyufuhiTuchiHosei sut;

        @Before
        public void setUp() {
            KyufuhiTuchiHoseiEntity = DbT3067KyufuhiTuchiHoseiEntityGenerator.createDbT3067KyufuhiTuchiHoseiEntity();
            KyufuhiTuchiHoseiEntity.setXXX(主キー名1);
            KyufuhiTuchiHoseiEntity.setXXX(主キー名2);

            sut = new KyufuhiTuchiHosei(KyufuhiTuchiHoseiEntity);
        }

        @Test
        public void get証記載保険者番号は_entityが持つ証記載保険者番号を返す() {
            assertThat(sut.get証記載保険者番号(), is(KyufuhiTuchiHoseiEntity.getShokisaiHokenshaNo()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KyufuhiTuchiHoseiEntity.getHiHokenshaNo()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(KyufuhiTuchiHoseiEntity.getServiceTeikyoYM()));
        }

        @Test
        public void get事業所番号は_entityが持つ事業所番号を返す() {
            assertThat(sut.get事業所番号(), is(KyufuhiTuchiHoseiEntity.getJigyoshoNo()));
        }

        @Test
        public void getサービス種類コードは_entityが持つサービス種類コードを返す() {
            assertThat(sut.getサービス種類コード(), is(KyufuhiTuchiHoseiEntity.getServiceShuruiCode()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(KyufuhiTuchiHoseiEntity.getRirekiNo()));
        }

        @Test
        public void getサービス費用合計額は_entityが持つサービス費用合計額を返す() {
            assertThat(sut.getサービス費用合計額(), is(KyufuhiTuchiHoseiEntity.getServiceHiyoTotal()));
        }

        @Test
        public void get利用者負担額は_entityが持つ利用者負担額を返す() {
            assertThat(sut.get利用者負担額(), is(KyufuhiTuchiHoseiEntity.getRiyoshaFutangaku()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static KyufuhiTuchiHosei sut;

        @Before
        public void setUp() {
            KyufuhiTuchiHoseiEntity = DbT3067KyufuhiTuchiHoseiEntityGenerator.createDbT3067KyufuhiTuchiHoseiEntity();
            KyufuhiTuchiHoseiEntity.setXXX(主キー名1);
            KyufuhiTuchiHoseiEntity.setXXX(主キー名2);

            sut = new KyufuhiTuchiHosei(KyufuhiTuchiHoseiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KyufuhiTuchiHoseiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static KyufuhiTuchiHosei sut;

        @Before
        public void setUp() {
            KyufuhiTuchiHoseiEntity = DbT3067KyufuhiTuchiHoseiEntityGenerator.createDbT3067KyufuhiTuchiHoseiEntity();
            KyufuhiTuchiHoseiEntity.setXXX(主キー名1);
            KyufuhiTuchiHoseiEntity.setXXX(主キー名2);

            sut = new KyufuhiTuchiHosei(KyufuhiTuchiHoseiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static KyufuhiTuchiHosei sut;
        private static KyufuhiTuchiHosei result;

        @Before
        public void setUp() {
            KyufuhiTuchiHoseiEntity = DbT3067KyufuhiTuchiHoseiEntityGenerator.createDbT3067KyufuhiTuchiHoseiEntity();
            KyufuhiTuchiHoseiEntity.setXXX(主キー名1);
            KyufuhiTuchiHoseiEntity.setXXX(主キー名2);

        }

        @Test
        public void KyufuhiTuchiHoseiが保持するDbT3067KyufuhiTuchiHoseiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKyufuhiTuchiHoseiが保持するDbT3067KyufuhiTuchiHoseiEntityのEntityDataStateがDeletedに指定されたKyufuhiTuchiHoseiが返る() {
            sut = TestSupport.setStateKyufuhiTuchiHosei(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufuhiTuchiHoseiが保持するDbT3067KyufuhiTuchiHoseiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKyufuhiTuchiHoseiが保持するDbT3067KyufuhiTuchiHoseiEntityのEntityDataStateがDeletedに指定されたKyufuhiTuchiHoseiが返る() {
            sut = TestSupport.setStateKyufuhiTuchiHosei(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufuhiTuchiHoseiが保持するDbT3067KyufuhiTuchiHoseiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKyufuhiTuchiHoseiが保持するDbT3067KyufuhiTuchiHoseiEntityのEntityDataStateがDeletedに指定されたKyufuhiTuchiHoseiが返る() {
            sut = TestSupport.setStateKyufuhiTuchiHosei(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KyufuhiTuchiHoseiが保持するDbT3067KyufuhiTuchiHoseiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKyufuhiTuchiHosei(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KyufuhiTuchiHosei setStateKyufuhiTuchiHosei(EntityDataState parentState) {
            KyufuhiTuchiHoseiEntity.setState(parentState);
            return new KyufuhiTuchiHosei(KyufuhiTuchiHoseiEntity);
        }
    }
}
