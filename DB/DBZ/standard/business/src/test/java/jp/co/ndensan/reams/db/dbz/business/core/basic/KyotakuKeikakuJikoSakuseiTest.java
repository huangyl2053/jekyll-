/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.business.core.KyotakuKeikakuJikoSakusei;
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
 * {@link KyotakuKeikakuJikoSakusei}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyotakuKeikakuJikoSakuseiTest extends DbzTestBase {

    private static DbT3007KyotakuKeikakuJikoSakuseiEntity KyotakuKeikakuJikoSakuseiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static KyotakuKeikakuJikoSakusei sut;

        @Before
        public void setUp() {
            KyotakuKeikakuJikoSakuseiEntity = DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.createDbT3007KyotakuKeikakuJikoSakuseiEntity();
            KyotakuKeikakuJikoSakuseiEntity.setXXX(主キー名1);
            KyotakuKeikakuJikoSakuseiEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyotakuKeikakuJikoSakusei(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyotakuKeikakuJikoSakusei(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT3007KyotakuKeikakuJikoSakuseiEntityにセットされている() {
            sut = new KyotakuKeikakuJikoSakusei(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKyotakuKeikakuJikoSakuseiIdentifierにセットされている() {
            sut = new KyotakuKeikakuJikoSakusei(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static KyotakuKeikakuJikoSakusei sut;

        @Before
        public void setUp() {
            KyotakuKeikakuJikoSakuseiEntity = DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.createDbT3007KyotakuKeikakuJikoSakuseiEntity();
            KyotakuKeikakuJikoSakuseiEntity.setXXX(主キー名1);
            KyotakuKeikakuJikoSakuseiEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KyotakuKeikakuJikoSakusei(null);
        }

        @Test
        public void 指定したDbT3007KyotakuKeikakuJikoSakuseiEntityのキー情報を識別子が持つ() {

            sut = new KyotakuKeikakuJikoSakusei(KyotakuKeikakuJikoSakuseiEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static KyotakuKeikakuJikoSakusei sut;

        @Before
        public void setUp() {
            KyotakuKeikakuJikoSakuseiEntity = DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.createDbT3007KyotakuKeikakuJikoSakuseiEntity();
            KyotakuKeikakuJikoSakuseiEntity.setXXX(主キー名1);
            KyotakuKeikakuJikoSakuseiEntity.setXXX(主キー名2);

            sut = new KyotakuKeikakuJikoSakusei(KyotakuKeikakuJikoSakuseiEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KyotakuKeikakuJikoSakuseiEntity.getHihokenshaNo()));
        }

        @Test
        public void get対象年月は_entityが持つ対象年月を返す() {
            assertThat(sut.get対象年月(), is(KyotakuKeikakuJikoSakuseiEntity.getTaishoYM()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(KyotakuKeikakuJikoSakuseiEntity.getRirekiNo()));
        }

        @Test
        public void get居宅・総合事業区分は_entityが持つ居宅・総合事業区分を返す() {
            assertThat(sut.get居宅・総合事業区分(), is(KyotakuKeikakuJikoSakuseiEntity.getKyotaku_SogoJigyoKubun()));
        }

        @Test
        public void get適用開始年月日は_entityが持つ適用開始年月日を返す() {
            assertThat(sut.get適用開始年月日(), is(KyotakuKeikakuJikoSakuseiEntity.getTekiyoKaishiYMD()));
        }

        @Test
        public void get適用終了年月日は_entityが持つ適用終了年月日を返す() {
            assertThat(sut.get適用終了年月日(), is(KyotakuKeikakuJikoSakuseiEntity.getTekiyoShuryoYMD()));
        }

        @Test
        public void get作成区分コードは_entityが持つ作成区分コードを返す() {
            assertThat(sut.get作成区分コード(), is(KyotakuKeikakuJikoSakuseiEntity.getSakuseiKubunCode()));
        }

        @Test
        public void get計画作成年月日は_entityが持つ計画作成年月日を返す() {
            assertThat(sut.get計画作成年月日(), is(KyotakuKeikakuJikoSakuseiEntity.getKeikakuSakuseiYMD()));
        }

        @Test
        public void get計画変更年月日は_entityが持つ計画変更年月日を返す() {
            assertThat(sut.get計画変更年月日(), is(KyotakuKeikakuJikoSakuseiEntity.getKeikakuHenkoYMD()));
        }

        @Test
        public void get計画変更事由は_entityが持つ計画変更事由を返す() {
            assertThat(sut.get計画変更事由(), is(KyotakuKeikakuJikoSakuseiEntity.getKeikakuHenkoJiyu()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static KyotakuKeikakuJikoSakusei sut;

        @Before
        public void setUp() {
            KyotakuKeikakuJikoSakuseiEntity = DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.createDbT3007KyotakuKeikakuJikoSakuseiEntity();
            KyotakuKeikakuJikoSakuseiEntity.setXXX(主キー名1);
            KyotakuKeikakuJikoSakuseiEntity.setXXX(主キー名2);

            sut = new KyotakuKeikakuJikoSakusei(KyotakuKeikakuJikoSakuseiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KyotakuKeikakuJikoSakuseiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static KyotakuKeikakuJikoSakusei sut;

        @Before
        public void setUp() {
            KyotakuKeikakuJikoSakuseiEntity = DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.createDbT3007KyotakuKeikakuJikoSakuseiEntity();
            KyotakuKeikakuJikoSakuseiEntity.setXXX(主キー名1);
            KyotakuKeikakuJikoSakuseiEntity.setXXX(主キー名2);

            sut = new KyotakuKeikakuJikoSakusei(KyotakuKeikakuJikoSakuseiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static KyotakuKeikakuJikoSakusei sut;
        private static KyotakuKeikakuJikoSakusei result;

        @Before
        public void setUp() {
            KyotakuKeikakuJikoSakuseiEntity = DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.createDbT3007KyotakuKeikakuJikoSakuseiEntity();
            KyotakuKeikakuJikoSakuseiEntity.setXXX(主キー名1);
            KyotakuKeikakuJikoSakuseiEntity.setXXX(主キー名2);

        }

        @Test
        public void KyotakuKeikakuJikoSakuseiが保持するDbT3007KyotakuKeikakuJikoSakuseiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKyotakuKeikakuJikoSakuseiが保持するDbT3007KyotakuKeikakuJikoSakuseiEntityのEntityDataStateがDeletedに指定されたKyotakuKeikakuJikoSakuseiが返る() {
            sut = TestSupport.setStateKyotakuKeikakuJikoSakusei(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyotakuKeikakuJikoSakuseiが保持するDbT3007KyotakuKeikakuJikoSakuseiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKyotakuKeikakuJikoSakuseiが保持するDbT3007KyotakuKeikakuJikoSakuseiEntityのEntityDataStateがDeletedに指定されたKyotakuKeikakuJikoSakuseiが返る() {
            sut = TestSupport.setStateKyotakuKeikakuJikoSakusei(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyotakuKeikakuJikoSakuseiが保持するDbT3007KyotakuKeikakuJikoSakuseiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKyotakuKeikakuJikoSakuseiが保持するDbT3007KyotakuKeikakuJikoSakuseiEntityのEntityDataStateがDeletedに指定されたKyotakuKeikakuJikoSakuseiが返る() {
            sut = TestSupport.setStateKyotakuKeikakuJikoSakusei(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KyotakuKeikakuJikoSakuseiが保持するDbT3007KyotakuKeikakuJikoSakuseiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKyotakuKeikakuJikoSakusei(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KyotakuKeikakuJikoSakusei setStateKyotakuKeikakuJikoSakusei(EntityDataState parentState) {
            KyotakuKeikakuJikoSakuseiEntity.setState(parentState);
            return new KyotakuKeikakuJikoSakusei(KyotakuKeikakuJikoSakuseiEntity);
        }
    }
}
