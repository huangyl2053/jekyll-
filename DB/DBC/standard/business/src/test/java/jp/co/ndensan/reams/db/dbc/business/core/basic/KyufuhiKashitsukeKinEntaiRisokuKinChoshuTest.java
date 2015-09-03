/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
 * {@link KyufuhiKashitsukeKinEntaiRisokuKinChoshu}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufuhiKashitsukeKinEntaiRisokuKinChoshuTest extends DbcTestBase {

    private static DbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static RString 主キー名2;
    private static Decimal 主キー名3;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntityGenerator.DEFAULT_貸付管理番号;
        主キー名3 = DbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KyufuhiKashitsukeKinEntaiRisokuKinChoshu sut;

        @Before
        public void setUp() {
            KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity = DbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntityGenerator.createDbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity();
            KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity.setHihokenshaNo(主キー名1);
            KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity.setKashitsukeKanriNo(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufuhiKashitsukeKinEntaiRisokuKinChoshu(null, 主キー名2, 主キー名3);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufuhiKashitsukeKinEntaiRisokuKinChoshu(主キー名1, null, 主キー名3);
        }

        @Test
        public void 指定したキーが保持するDbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntityにセットされている() {
            sut = new KyufuhiKashitsukeKinEntaiRisokuKinChoshu(主キー名1, 主キー名2, 主キー名3);
            assertThat(sut.get被保険者番号(), is(主キー名1));
            assertThat(sut.get貸付管理番号(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKyufuhiKashitsukeKinEntaiRisokuKinChoshuIdentifierにセットされている() {
            sut = new KyufuhiKashitsukeKinEntaiRisokuKinChoshu(主キー名1, 主キー名2, 主キー名3);
            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().get貸付管理番号(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KyufuhiKashitsukeKinEntaiRisokuKinChoshu sut;

        @Before
        public void setUp() {
            KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity = DbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntityGenerator.createDbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity();
            KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity.setHihokenshaNo(主キー名1);
            KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity.setKashitsukeKanriNo(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KyufuhiKashitsukeKinEntaiRisokuKinChoshu(null);
        }

        @Test
        public void 指定したDbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntityのキー情報を識別子が持つ() {

            sut = new KyufuhiKashitsukeKinEntaiRisokuKinChoshu(KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity);

            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().get貸付管理番号(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KyufuhiKashitsukeKinEntaiRisokuKinChoshu sut;

        @Before
        public void setUp() {
            KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity = DbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntityGenerator.createDbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity();
            KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity.setHihokenshaNo(主キー名1);
            KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity.setKashitsukeKanriNo(主キー名2);

            sut = new KyufuhiKashitsukeKinEntaiRisokuKinChoshu(KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity.getHihokenshaNo()));
        }

        @Test
        public void get貸付管理番号は_entityが持つ貸付管理番号を返す() {
            assertThat(sut.get貸付管理番号(), is(KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity.getKashitsukeKanriNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity.getRirekiNo()));
        }

        @Test
        public void get延滞利息金徴収年月日は_entityが持つ延滞利息金徴収年月日を返す() {
            assertThat(sut.get延滞利息金徴収年月日(), is(KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity.getEntaiRisokuKinChoshuYMD()));
        }

        @Test
        public void get延滞利息徴収金額は_entityが持つ延滞利息徴収金額を返す() {
            assertThat(sut.get延滞利息徴収金額(), is(KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity.getEntaiRisokuChoshuKingaku()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static KyufuhiKashitsukeKinEntaiRisokuKinChoshu sut;

        @Before
        public void setUp() {
            KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity = DbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntityGenerator.createDbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity();
            KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity.setHihokenshaNo(主キー名1);
            KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity.setKashitsukeKanriNo(主キー名2);

            sut = new KyufuhiKashitsukeKinEntaiRisokuKinChoshu(KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static KyufuhiKashitsukeKinEntaiRisokuKinChoshu sut;

        @Before
        public void setUp() {
            KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity = DbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntityGenerator.createDbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity();
            KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity.setHihokenshaNo(主キー名1);
            KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity.setKashitsukeKanriNo(主キー名2);

            sut = new KyufuhiKashitsukeKinEntaiRisokuKinChoshu(KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static KyufuhiKashitsukeKinEntaiRisokuKinChoshu sut;
        private static KyufuhiKashitsukeKinEntaiRisokuKinChoshu result;

        @Before
        public void setUp() {
            KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity = DbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntityGenerator.createDbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity();
            KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity.setHihokenshaNo(主キー名1);
            KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity.setKashitsukeKanriNo(主キー名2);

        }

        @Test
        public void KyufuhiKashitsukeKinEntaiRisokuKinChoshuが保持するDbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKyufuhiKashitsukeKinEntaiRisokuKinChoshuが保持するDbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntityのEntityDataStateがDeletedに指定されたKyufuhiKashitsukeKinEntaiRisokuKinChoshuが返る() {
            sut = TestSupport.setStateKyufuhiKashitsukeKinEntaiRisokuKinChoshu(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufuhiKashitsukeKinEntaiRisokuKinChoshuが保持するDbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKyufuhiKashitsukeKinEntaiRisokuKinChoshuが保持するDbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntityのEntityDataStateがDeletedに指定されたKyufuhiKashitsukeKinEntaiRisokuKinChoshuが返る() {
            sut = TestSupport.setStateKyufuhiKashitsukeKinEntaiRisokuKinChoshu(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufuhiKashitsukeKinEntaiRisokuKinChoshuが保持するDbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKyufuhiKashitsukeKinEntaiRisokuKinChoshuが保持するDbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntityのEntityDataStateがDeletedに指定されたKyufuhiKashitsukeKinEntaiRisokuKinChoshuが返る() {
            sut = TestSupport.setStateKyufuhiKashitsukeKinEntaiRisokuKinChoshu(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KyufuhiKashitsukeKinEntaiRisokuKinChoshuが保持するDbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKyufuhiKashitsukeKinEntaiRisokuKinChoshu(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KyufuhiKashitsukeKinEntaiRisokuKinChoshu setStateKyufuhiKashitsukeKinEntaiRisokuKinChoshu(EntityDataState parentState) {
            KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity.setState(parentState);
            return new KyufuhiKashitsukeKinEntaiRisokuKinChoshu(KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity);
        }
    }
}
