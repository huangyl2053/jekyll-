/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
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
 * {@link KyufuhiKashitsukekinEntaiRisokuKeisan}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufuhiKashitsukekinEntaiRisokuKeisanTest extends DbcTestBase {

    private static DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity KyufuhiKashitsukekinEntaiRisokuKeisanEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 被保険者番号;
    private static RString 貸付管理番号;
    private static Decimal 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        被保険者番号 = DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityGenerator.DEFAULT_被保険者番号;
        貸付管理番号 = DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityGenerator.DEFAULT_貸付管理番号;
        履歴番号 = DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KyufuhiKashitsukekinEntaiRisokuKeisan sut;

        @Before
        public void setUp() {
            KyufuhiKashitsukekinEntaiRisokuKeisanEntity = DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityGenerator.createDbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity();
            KyufuhiKashitsukekinEntaiRisokuKeisanEntity.setHihokenshaNo(被保険者番号);
            KyufuhiKashitsukekinEntaiRisokuKeisanEntity.setKashitsukeKanriNo(貸付管理番号);
            KyufuhiKashitsukekinEntaiRisokuKeisanEntity.setRirekiNo(履歴番号);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufuhiKashitsukekinEntaiRisokuKeisan(null, 貸付管理番号, 履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 貸付管理番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufuhiKashitsukekinEntaiRisokuKeisan(被保険者番号, null, 履歴番号);
        }

        @Test
        public void 指定したキーが保持するDbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityにセットされている() {
            sut = new KyufuhiKashitsukekinEntaiRisokuKeisan(被保険者番号, 貸付管理番号, 履歴番号);
            assertThat(sut.get被保険者番号(), is(被保険者番号));
            assertThat(sut.get貸付管理番号(), is(貸付管理番号));
            assertThat(sut.get履歴番号(), is(履歴番号));
        }

        @Test
        public void 指定したキーが保持するKyufuhiKashitsukekinEntaiRisokuKeisanIdentifierにセットされている() {
            sut = new KyufuhiKashitsukekinEntaiRisokuKeisan(被保険者番号, 貸付管理番号, 履歴番号);
            assertThat(sut.identifier().get被保険者番号(), is(被保険者番号));
            assertThat(sut.identifier().get貸付管理番号(), is(貸付管理番号));
            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KyufuhiKashitsukekinEntaiRisokuKeisan sut;

        @Before
        public void setUp() {
            KyufuhiKashitsukekinEntaiRisokuKeisanEntity = DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityGenerator.createDbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity();
            KyufuhiKashitsukekinEntaiRisokuKeisanEntity.setHihokenshaNo(被保険者番号);
            KyufuhiKashitsukekinEntaiRisokuKeisanEntity.setKashitsukeKanriNo(貸付管理番号);
            KyufuhiKashitsukekinEntaiRisokuKeisanEntity.setRirekiNo(履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KyufuhiKashitsukekinEntaiRisokuKeisan(null);
        }

        @Test
        public void 指定したDbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityのキー情報を識別子が持つ() {

            sut = new KyufuhiKashitsukekinEntaiRisokuKeisan(KyufuhiKashitsukekinEntaiRisokuKeisanEntity);

            assertThat(sut.identifier().get被保険者番号(), is(被保険者番号));
            assertThat(sut.identifier().get貸付管理番号(), is(貸付管理番号));
            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KyufuhiKashitsukekinEntaiRisokuKeisan sut;

        @Before
        public void setUp() {
            KyufuhiKashitsukekinEntaiRisokuKeisanEntity = DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityGenerator.createDbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity();
            KyufuhiKashitsukekinEntaiRisokuKeisanEntity.setHihokenshaNo(被保険者番号);
            KyufuhiKashitsukekinEntaiRisokuKeisanEntity.setKashitsukeKanriNo(貸付管理番号);
            KyufuhiKashitsukekinEntaiRisokuKeisanEntity.setRirekiNo(履歴番号);

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
            KyufuhiKashitsukekinEntaiRisokuKeisanEntity.setHihokenshaNo(被保険者番号);
            KyufuhiKashitsukekinEntaiRisokuKeisanEntity.setKashitsukeKanriNo(貸付管理番号);
            KyufuhiKashitsukekinEntaiRisokuKeisanEntity.setRirekiNo(履歴番号);

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
            KyufuhiKashitsukekinEntaiRisokuKeisanEntity.setHihokenshaNo(被保険者番号);
            KyufuhiKashitsukekinEntaiRisokuKeisanEntity.setKashitsukeKanriNo(貸付管理番号);
            KyufuhiKashitsukekinEntaiRisokuKeisanEntity.setRirekiNo(履歴番号);

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
            KyufuhiKashitsukekinEntaiRisokuKeisanEntity.setHihokenshaNo(被保険者番号);
            KyufuhiKashitsukekinEntaiRisokuKeisanEntity.setKashitsukeKanriNo(貸付管理番号);
            KyufuhiKashitsukekinEntaiRisokuKeisanEntity.setRirekiNo(履歴番号);

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
