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
 * {@link KyufuhiKashitsukekinEntaiRisokuKeisan}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufuhiKashitsukekinEntaiRisokuKeisanTest extends DbcTestBase {

    private static DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity KyufuhiKashitsukekinEntaiRisokuKeisanEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KyufuhiKashitsukekinEntaiRisokuKeisan sut;

        @Before
        public void setUp() {
            KyufuhiKashitsukekinEntaiRisokuKeisanEntity = DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityGenerator.createDbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity();
            KyufuhiKashitsukekinEntaiRisokuKeisanEntity.setXXX(主キー名1);
            KyufuhiKashitsukekinEntaiRisokuKeisanEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufuhiKashitsukekinEntaiRisokuKeisan(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufuhiKashitsukekinEntaiRisokuKeisan(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityにセットされている() {
            sut = new KyufuhiKashitsukekinEntaiRisokuKeisan(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKyufuhiKashitsukekinEntaiRisokuKeisanIdentifierにセットされている() {
            sut = new KyufuhiKashitsukekinEntaiRisokuKeisan(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KyufuhiKashitsukekinEntaiRisokuKeisan sut;

        @Before
        public void setUp() {
            KyufuhiKashitsukekinEntaiRisokuKeisanEntity = DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityGenerator.createDbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity();
            KyufuhiKashitsukekinEntaiRisokuKeisanEntity.setXXX(主キー名1);
            KyufuhiKashitsukekinEntaiRisokuKeisanEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KyufuhiKashitsukekinEntaiRisokuKeisan(null);
        }

        @Test
        public void 指定したDbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityのキー情報を識別子が持つ() {

            sut = new KyufuhiKashitsukekinEntaiRisokuKeisan(KyufuhiKashitsukekinEntaiRisokuKeisanEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KyufuhiKashitsukekinEntaiRisokuKeisan sut;

        @Before
        public void setUp() {
            KyufuhiKashitsukekinEntaiRisokuKeisanEntity = DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityGenerator.createDbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity();
            KyufuhiKashitsukekinEntaiRisokuKeisanEntity.setXXX(主キー名1);
            KyufuhiKashitsukekinEntaiRisokuKeisanEntity.setXXX(主キー名2);

            sut = new KyufuhiKashitsukekinEntaiRisokuKeisan(KyufuhiKashitsukekinEntaiRisokuKeisanEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KyufuhiKashitsukekinEntaiRisokuKeisanEntity.getHihokenshaNo()));
        }

        @Test
        public void get貸付管理番号は_entityが持つ貸付管理番号を返す() {
            assertThat(sut.get貸付管理番号(), is(KyufuhiKashitsukekinEntaiRisokuKeisanEntity.getKashitsukeKanriNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(KyufuhiKashitsukekinEntaiRisokuKeisanEntity.getRirekiNo()));
        }

        @Test
        public void get貸付金延滞日数は_entityが持つ貸付金延滞日数を返す() {
            assertThat(sut.get貸付金延滞日数(), is(KyufuhiKashitsukekinEntaiRisokuKeisanEntity.getEntaiNissu()));
        }

        @Test
        public void get貸付金延滞利息金額は_entityが持つ貸付金延滞利息金額を返す() {
            assertThat(sut.get貸付金延滞利息金額(), is(KyufuhiKashitsukekinEntaiRisokuKeisanEntity.getEntaiRisokuKingaku()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static KyufuhiKashitsukekinEntaiRisokuKeisan sut;

        @Before
        public void setUp() {
            KyufuhiKashitsukekinEntaiRisokuKeisanEntity = DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityGenerator.createDbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity();
            KyufuhiKashitsukekinEntaiRisokuKeisanEntity.setXXX(主キー名1);
            KyufuhiKashitsukekinEntaiRisokuKeisanEntity.setXXX(主キー名2);

            sut = new KyufuhiKashitsukekinEntaiRisokuKeisan(KyufuhiKashitsukekinEntaiRisokuKeisanEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KyufuhiKashitsukekinEntaiRisokuKeisanEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static KyufuhiKashitsukekinEntaiRisokuKeisan sut;

        @Before
        public void setUp() {
            KyufuhiKashitsukekinEntaiRisokuKeisanEntity = DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityGenerator.createDbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity();
            KyufuhiKashitsukekinEntaiRisokuKeisanEntity.setXXX(主キー名1);
            KyufuhiKashitsukekinEntaiRisokuKeisanEntity.setXXX(主キー名2);

            sut = new KyufuhiKashitsukekinEntaiRisokuKeisan(KyufuhiKashitsukekinEntaiRisokuKeisanEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static KyufuhiKashitsukekinEntaiRisokuKeisan sut;
        private static KyufuhiKashitsukekinEntaiRisokuKeisan result;

        @Before
        public void setUp() {
            KyufuhiKashitsukekinEntaiRisokuKeisanEntity = DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityGenerator.createDbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity();
            KyufuhiKashitsukekinEntaiRisokuKeisanEntity.setXXX(主キー名1);
            KyufuhiKashitsukekinEntaiRisokuKeisanEntity.setXXX(主キー名2);

        }

        @Test
        public void KyufuhiKashitsukekinEntaiRisokuKeisanが保持するDbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKyufuhiKashitsukekinEntaiRisokuKeisanが保持するDbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityのEntityDataStateがDeletedに指定されたKyufuhiKashitsukekinEntaiRisokuKeisanが返る() {
            sut = TestSupport.setStateKyufuhiKashitsukekinEntaiRisokuKeisan(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufuhiKashitsukekinEntaiRisokuKeisanが保持するDbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKyufuhiKashitsukekinEntaiRisokuKeisanが保持するDbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityのEntityDataStateがDeletedに指定されたKyufuhiKashitsukekinEntaiRisokuKeisanが返る() {
            sut = TestSupport.setStateKyufuhiKashitsukekinEntaiRisokuKeisan(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufuhiKashitsukekinEntaiRisokuKeisanが保持するDbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKyufuhiKashitsukekinEntaiRisokuKeisanが保持するDbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityのEntityDataStateがDeletedに指定されたKyufuhiKashitsukekinEntaiRisokuKeisanが返る() {
            sut = TestSupport.setStateKyufuhiKashitsukekinEntaiRisokuKeisan(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KyufuhiKashitsukekinEntaiRisokuKeisanが保持するDbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKyufuhiKashitsukekinEntaiRisokuKeisan(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KyufuhiKashitsukekinEntaiRisokuKeisan setStateKyufuhiKashitsukekinEntaiRisokuKeisan(EntityDataState parentState) {
            KyufuhiKashitsukekinEntaiRisokuKeisanEntity.setState(parentState);
            return new KyufuhiKashitsukekinEntaiRisokuKeisan(KyufuhiKashitsukekinEntaiRisokuKeisanEntity);
        }
    }
}
