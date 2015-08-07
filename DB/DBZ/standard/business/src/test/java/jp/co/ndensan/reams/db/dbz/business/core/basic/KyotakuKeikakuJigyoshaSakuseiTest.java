/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.business.core.KyotakuKeikakuJigyoshaSakusei;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import static jp.co.ndensan.reams.db.dbz.testhelper.matcher.IsSerializable.serializable;
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
 * {@link KyotakuKeikakuJigyoshaSakusei}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyotakuKeikakuJigyoshaSakuseiTest extends DbzTestBase {

    private static DbT3006KyotakuKeikakuJigyoshaSakuseiEntity KyotakuKeikakuJigyoshaSakuseiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static KyotakuKeikakuJigyoshaSakusei sut;

        @Before
        public void setUp() {
            KyotakuKeikakuJigyoshaSakuseiEntity = DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.createDbT3006KyotakuKeikakuJigyoshaSakuseiEntity();
            KyotakuKeikakuJigyoshaSakuseiEntity.setXXX(主キー名1);
            KyotakuKeikakuJigyoshaSakuseiEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyotakuKeikakuJigyoshaSakusei(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyotakuKeikakuJigyoshaSakusei(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT3006KyotakuKeikakuJigyoshaSakuseiEntityにセットされている() {
            sut = new KyotakuKeikakuJigyoshaSakusei(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKyotakuKeikakuJigyoshaSakuseiIdentifierにセットされている() {
            sut = new KyotakuKeikakuJigyoshaSakusei(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static KyotakuKeikakuJigyoshaSakusei sut;

        @Before
        public void setUp() {
            KyotakuKeikakuJigyoshaSakuseiEntity = DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.createDbT3006KyotakuKeikakuJigyoshaSakuseiEntity();
            KyotakuKeikakuJigyoshaSakuseiEntity.setXXX(主キー名1);
            KyotakuKeikakuJigyoshaSakuseiEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KyotakuKeikakuJigyoshaSakusei(null);
        }

        @Test
        public void 指定したDbT3006KyotakuKeikakuJigyoshaSakuseiEntityのキー情報を識別子が持つ() {

            sut = new KyotakuKeikakuJigyoshaSakusei(KyotakuKeikakuJigyoshaSakuseiEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static KyotakuKeikakuJigyoshaSakusei sut;

        @Before
        public void setUp() {
            KyotakuKeikakuJigyoshaSakuseiEntity = DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.createDbT3006KyotakuKeikakuJigyoshaSakuseiEntity();
            KyotakuKeikakuJigyoshaSakuseiEntity.setXXX(主キー名1);
            KyotakuKeikakuJigyoshaSakuseiEntity.setXXX(主キー名2);

            sut = new KyotakuKeikakuJigyoshaSakusei(KyotakuKeikakuJigyoshaSakuseiEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KyotakuKeikakuJigyoshaSakuseiEntity.getNone()));
        }

        @Test
        public void get対象年月は_entityが持つ対象年月を返す() {
            assertThat(sut.get対象年月(), is(KyotakuKeikakuJigyoshaSakuseiEntity.getTaishoYM()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(KyotakuKeikakuJigyoshaSakuseiEntity.getRirekiNo()));
        }

        @Test
        public void get適用開始年月日は_entityが持つ適用開始年月日を返す() {
            assertThat(sut.get適用開始年月日(), is(KyotakuKeikakuJigyoshaSakuseiEntity.getTekiyoKaishiYMD()));
        }

        @Test
        public void get適用終了年月日は_entityが持つ適用終了年月日を返す() {
            assertThat(sut.get適用終了年月日(), is(KyotakuKeikakuJigyoshaSakuseiEntity.getTekiyoShuryoYMD()));
        }

        @Test
        public void get作成区分コードは_entityが持つ作成区分コードを返す() {
            assertThat(sut.get作成区分コード(), is(KyotakuKeikakuJigyoshaSakuseiEntity.getSakuseiKubunCode()));
        }

        @Test
        public void get計画事業者番号は_entityが持つ計画事業者番号を返す() {
            assertThat(sut.get計画事業者番号(), is(KyotakuKeikakuJigyoshaSakuseiEntity.getKeikakuJigyoshaNo()));
        }

        @Test
        public void get委託先事業者番号は_entityが持つ委託先事業者番号を返す() {
            assertThat(sut.get委託先事業者番号(), is(KyotakuKeikakuJigyoshaSakuseiEntity.getItakusakiJigyoshaNo()));
        }

        @Test
        public void get事業者変更年月日は_entityが持つ事業者変更年月日を返す() {
            assertThat(sut.get事業者変更年月日(), is(KyotakuKeikakuJigyoshaSakuseiEntity.getJigyoshaHenkoYMD()));
        }

        @Test
        public void get事業者変更事由は_entityが持つ事業者変更事由を返す() {
            assertThat(sut.get事業者変更事由(), is(KyotakuKeikakuJigyoshaSakuseiEntity.getJigyoshaHenkoJiyu()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static KyotakuKeikakuJigyoshaSakusei sut;

        @Before
        public void setUp() {
            KyotakuKeikakuJigyoshaSakuseiEntity = DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.createDbT3006KyotakuKeikakuJigyoshaSakuseiEntity();
            KyotakuKeikakuJigyoshaSakuseiEntity.setXXX(主キー名1);
            KyotakuKeikakuJigyoshaSakuseiEntity.setXXX(主キー名2);

            sut = new KyotakuKeikakuJigyoshaSakusei(KyotakuKeikakuJigyoshaSakuseiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KyotakuKeikakuJigyoshaSakuseiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static KyotakuKeikakuJigyoshaSakusei sut;

        @Before
        public void setUp() {
            KyotakuKeikakuJigyoshaSakuseiEntity = DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.createDbT3006KyotakuKeikakuJigyoshaSakuseiEntity();
            KyotakuKeikakuJigyoshaSakuseiEntity.setXXX(主キー名1);
            KyotakuKeikakuJigyoshaSakuseiEntity.setXXX(主キー名2);

            sut = new KyotakuKeikakuJigyoshaSakusei(KyotakuKeikakuJigyoshaSakuseiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static KyotakuKeikakuJigyoshaSakusei sut;
        private static KyotakuKeikakuJigyoshaSakusei result;

        @Before
        public void setUp() {
            KyotakuKeikakuJigyoshaSakuseiEntity = DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.createDbT3006KyotakuKeikakuJigyoshaSakuseiEntity();
            KyotakuKeikakuJigyoshaSakuseiEntity.setXXX(主キー名1);
            KyotakuKeikakuJigyoshaSakuseiEntity.setXXX(主キー名2);

        }

        @Test
        public void KyotakuKeikakuJigyoshaSakuseiが保持するDbT3006KyotakuKeikakuJigyoshaSakuseiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKyotakuKeikakuJigyoshaSakuseiが保持するDbT3006KyotakuKeikakuJigyoshaSakuseiEntityのEntityDataStateがDeletedに指定されたKyotakuKeikakuJigyoshaSakuseiが返る() {
            sut = TestSupport.setStateKyotakuKeikakuJigyoshaSakusei(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyotakuKeikakuJigyoshaSakuseiが保持するDbT3006KyotakuKeikakuJigyoshaSakuseiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKyotakuKeikakuJigyoshaSakuseiが保持するDbT3006KyotakuKeikakuJigyoshaSakuseiEntityのEntityDataStateがDeletedに指定されたKyotakuKeikakuJigyoshaSakuseiが返る() {
            sut = TestSupport.setStateKyotakuKeikakuJigyoshaSakusei(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyotakuKeikakuJigyoshaSakuseiが保持するDbT3006KyotakuKeikakuJigyoshaSakuseiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKyotakuKeikakuJigyoshaSakuseiが保持するDbT3006KyotakuKeikakuJigyoshaSakuseiEntityのEntityDataStateがDeletedに指定されたKyotakuKeikakuJigyoshaSakuseiが返る() {
            sut = TestSupport.setStateKyotakuKeikakuJigyoshaSakusei(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KyotakuKeikakuJigyoshaSakuseiが保持するDbT3006KyotakuKeikakuJigyoshaSakuseiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKyotakuKeikakuJigyoshaSakusei(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KyotakuKeikakuJigyoshaSakusei setStateKyotakuKeikakuJigyoshaSakusei(EntityDataState parentState) {
            KyotakuKeikakuJigyoshaSakuseiEntity.setState(parentState);
            return new KyotakuKeikakuJigyoshaSakusei(KyotakuKeikakuJigyoshaSakuseiEntity);
        }
    }
}
