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
 * {@link KyufuhiKashitsukeKinChoshu}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufuhiKashitsukeKinChoshuTest extends DbcTestBase {

    private static DbT3092KyufuhiKashitsukeKinChoshuEntity KyufuhiKashitsukeKinChoshuEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KyufuhiKashitsukeKinChoshu sut;

        @Before
        public void setUp() {
            KyufuhiKashitsukeKinChoshuEntity = DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator.createDbT3092KyufuhiKashitsukeKinChoshuEntity();
            KyufuhiKashitsukeKinChoshuEntity.setXXX(主キー名1);
            KyufuhiKashitsukeKinChoshuEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufuhiKashitsukeKinChoshu(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufuhiKashitsukeKinChoshu(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT3092KyufuhiKashitsukeKinChoshuEntityにセットされている() {
            sut = new KyufuhiKashitsukeKinChoshu(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKyufuhiKashitsukeKinChoshuIdentifierにセットされている() {
            sut = new KyufuhiKashitsukeKinChoshu(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KyufuhiKashitsukeKinChoshu sut;

        @Before
        public void setUp() {
            KyufuhiKashitsukeKinChoshuEntity = DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator.createDbT3092KyufuhiKashitsukeKinChoshuEntity();
            KyufuhiKashitsukeKinChoshuEntity.setXXX(主キー名1);
            KyufuhiKashitsukeKinChoshuEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KyufuhiKashitsukeKinChoshu(null);
        }

        @Test
        public void 指定したDbT3092KyufuhiKashitsukeKinChoshuEntityのキー情報を識別子が持つ() {

            sut = new KyufuhiKashitsukeKinChoshu(KyufuhiKashitsukeKinChoshuEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KyufuhiKashitsukeKinChoshu sut;

        @Before
        public void setUp() {
            KyufuhiKashitsukeKinChoshuEntity = DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator.createDbT3092KyufuhiKashitsukeKinChoshuEntity();
            KyufuhiKashitsukeKinChoshuEntity.setXXX(主キー名1);
            KyufuhiKashitsukeKinChoshuEntity.setXXX(主キー名2);

            sut = new KyufuhiKashitsukeKinChoshu(KyufuhiKashitsukeKinChoshuEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KyufuhiKashitsukeKinChoshuEntity.getHihokenshaNo()));
        }

        @Test
        public void get貸付管理番号は_entityが持つ貸付管理番号を返す() {
            assertThat(sut.get貸付管理番号(), is(KyufuhiKashitsukeKinChoshuEntity.getKashitsukeKanriNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(KyufuhiKashitsukeKinChoshuEntity.getRirekiNo()));
        }

        @Test
        public void get貸付金返還徴収方法は_entityが持つ貸付金返還徴収方法を返す() {
            assertThat(sut.get貸付金返還徴収方法(), is(KyufuhiKashitsukeKinChoshuEntity.getHenkanChoshuHoho()));
        }

        @Test
        public void get貸付金返還徴収年月日は_entityが持つ貸付金返還徴収年月日を返す() {
            assertThat(sut.get貸付金返還徴収年月日(), is(KyufuhiKashitsukeKinChoshuEntity.getHenkanChoshuYMD()));
        }

        @Test
        public void get貸付金返還徴収金額は_entityが持つ貸付金返還徴収金額を返す() {
            assertThat(sut.get貸付金返還徴収金額(), is(KyufuhiKashitsukeKinChoshuEntity.getHenkanChoshuKingaku()));
        }

        @Test
        public void get過不足判定結果区分は_entityが持つ過不足判定結果区分を返す() {
            assertThat(sut.get過不足判定結果区分(), is(KyufuhiKashitsukeKinChoshuEntity.getKabusokuHanteiKekkaKubun()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static KyufuhiKashitsukeKinChoshu sut;

        @Before
        public void setUp() {
            KyufuhiKashitsukeKinChoshuEntity = DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator.createDbT3092KyufuhiKashitsukeKinChoshuEntity();
            KyufuhiKashitsukeKinChoshuEntity.setXXX(主キー名1);
            KyufuhiKashitsukeKinChoshuEntity.setXXX(主キー名2);

            sut = new KyufuhiKashitsukeKinChoshu(KyufuhiKashitsukeKinChoshuEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KyufuhiKashitsukeKinChoshuEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static KyufuhiKashitsukeKinChoshu sut;

        @Before
        public void setUp() {
            KyufuhiKashitsukeKinChoshuEntity = DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator.createDbT3092KyufuhiKashitsukeKinChoshuEntity();
            KyufuhiKashitsukeKinChoshuEntity.setXXX(主キー名1);
            KyufuhiKashitsukeKinChoshuEntity.setXXX(主キー名2);

            sut = new KyufuhiKashitsukeKinChoshu(KyufuhiKashitsukeKinChoshuEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static KyufuhiKashitsukeKinChoshu sut;
        private static KyufuhiKashitsukeKinChoshu result;

        @Before
        public void setUp() {
            KyufuhiKashitsukeKinChoshuEntity = DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator.createDbT3092KyufuhiKashitsukeKinChoshuEntity();
            KyufuhiKashitsukeKinChoshuEntity.setXXX(主キー名1);
            KyufuhiKashitsukeKinChoshuEntity.setXXX(主キー名2);

        }

        @Test
        public void KyufuhiKashitsukeKinChoshuが保持するDbT3092KyufuhiKashitsukeKinChoshuEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKyufuhiKashitsukeKinChoshuが保持するDbT3092KyufuhiKashitsukeKinChoshuEntityのEntityDataStateがDeletedに指定されたKyufuhiKashitsukeKinChoshuが返る() {
            sut = TestSupport.setStateKyufuhiKashitsukeKinChoshu(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufuhiKashitsukeKinChoshuが保持するDbT3092KyufuhiKashitsukeKinChoshuEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKyufuhiKashitsukeKinChoshuが保持するDbT3092KyufuhiKashitsukeKinChoshuEntityのEntityDataStateがDeletedに指定されたKyufuhiKashitsukeKinChoshuが返る() {
            sut = TestSupport.setStateKyufuhiKashitsukeKinChoshu(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufuhiKashitsukeKinChoshuが保持するDbT3092KyufuhiKashitsukeKinChoshuEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKyufuhiKashitsukeKinChoshuが保持するDbT3092KyufuhiKashitsukeKinChoshuEntityのEntityDataStateがDeletedに指定されたKyufuhiKashitsukeKinChoshuが返る() {
            sut = TestSupport.setStateKyufuhiKashitsukeKinChoshu(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KyufuhiKashitsukeKinChoshuが保持するDbT3092KyufuhiKashitsukeKinChoshuEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKyufuhiKashitsukeKinChoshu(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KyufuhiKashitsukeKinChoshu setStateKyufuhiKashitsukeKinChoshu(EntityDataState parentState) {
            KyufuhiKashitsukeKinChoshuEntity.setState(parentState);
            return new KyufuhiKashitsukeKinChoshu(KyufuhiKashitsukeKinChoshuEntity);
        }
    }
}
