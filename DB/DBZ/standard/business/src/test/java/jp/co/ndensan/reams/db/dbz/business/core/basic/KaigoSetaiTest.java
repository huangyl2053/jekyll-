/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7014KaigoSetaiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7014KaigoSetaiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
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
 * {@link KaigoSetai}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KaigoSetaiTest extends DbzTestBase {

    private static DbT7014KaigoSetaiEntity KaigoSetaiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7014KaigoSetaiEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT7014KaigoSetaiEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static KaigoSetai sut;

        @Before
        public void setUp() {
            KaigoSetaiEntity = DbT7014KaigoSetaiEntityGenerator.createDbT7014KaigoSetaiEntity();
            KaigoSetaiEntity.setXXX(主キー名1);
            KaigoSetaiEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KaigoSetai(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KaigoSetai(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT7014KaigoSetaiEntityにセットされている() {
            sut = new KaigoSetai(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKaigoSetaiIdentifierにセットされている() {
            sut = new KaigoSetai(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static KaigoSetai sut;

        @Before
        public void setUp() {
            KaigoSetaiEntity = DbT7014KaigoSetaiEntityGenerator.createDbT7014KaigoSetaiEntity();
            KaigoSetaiEntity.setXXX(主キー名1);
            KaigoSetaiEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KaigoSetai(null);
        }

        @Test
        public void 指定したDbT7014KaigoSetaiEntityのキー情報を識別子が持つ() {

            sut = new KaigoSetai(KaigoSetaiEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static KaigoSetai sut;

        @Before
        public void setUp() {
            KaigoSetaiEntity = DbT7014KaigoSetaiEntityGenerator.createDbT7014KaigoSetaiEntity();
            KaigoSetaiEntity.setXXX(主キー名1);
            KaigoSetaiEntity.setXXX(主キー名2);

            sut = new KaigoSetai(KaigoSetaiEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KaigoSetaiEntity.getHihokenshaNo()));
        }

        @Test
        public void get管理識別区分は_entityが持つ管理識別区分を返す() {
            assertThat(sut.get管理識別区分(), is(KaigoSetaiEntity.getKanriShikibetsuKubun()));
        }

        @Test
        public void get世帯把握基準年月日は_entityが持つ世帯把握基準年月日を返す() {
            assertThat(sut.get世帯把握基準年月日(), is(KaigoSetaiEntity.getSetaiHaakuKijunYMD()));
        }

        @Test
        public void get世帯員管理連番は_entityが持つ世帯員管理連番を返す() {
            assertThat(sut.get世帯員管理連番(), is(KaigoSetaiEntity.getSetaiInkanriRenban()));
        }

        @Test
        public void get世帯員識別コードは_entityが持つ世帯員識別コードを返す() {
            assertThat(sut.get世帯員識別コード(), is(KaigoSetaiEntity.getSetaiInshikibetsuCode()));
        }

        @Test
        public void get本人区分は_entityが持つ本人区分を返す() {
            assertThat(sut.get本人区分(), is(KaigoSetaiEntity.getHonninKubun()));
        }

        @Test
        public void get課税年度は_entityが持つ課税年度を返す() {
            assertThat(sut.get課税年度(), is(KaigoSetaiEntity.getKazeiNendo()));
        }

        @Test
        public void get課税非課税区分は_entityが持つ課税非課税区分を返す() {
            assertThat(sut.get課税非課税区分(), is(KaigoSetaiEntity.getKazeiHikazeiKubun()));
        }

        @Test
        public void get合計所得金額は_entityが持つ合計所得金額を返す() {
            assertThat(sut.get合計所得金額(), is(KaigoSetaiEntity.getGokeiShotokuKingaku()));
        }

        @Test
        public void get課税年金収入額は_entityが持つ課税年金収入額を返す() {
            assertThat(sut.get課税年金収入額(), is(KaigoSetaiEntity.getKazeiNenkinShunyugaku()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static KaigoSetai sut;

        @Before
        public void setUp() {
            KaigoSetaiEntity = DbT7014KaigoSetaiEntityGenerator.createDbT7014KaigoSetaiEntity();
            KaigoSetaiEntity.setXXX(主キー名1);
            KaigoSetaiEntity.setXXX(主キー名2);

            sut = new KaigoSetai(KaigoSetaiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KaigoSetaiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static KaigoSetai sut;

        @Before
        public void setUp() {
            KaigoSetaiEntity = DbT7014KaigoSetaiEntityGenerator.createDbT7014KaigoSetaiEntity();
            KaigoSetaiEntity.setXXX(主キー名1);
            KaigoSetaiEntity.setXXX(主キー名2);

            sut = new KaigoSetai(KaigoSetaiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static KaigoSetai sut;
        private static KaigoSetai result;

        @Before
        public void setUp() {
            KaigoSetaiEntity = DbT7014KaigoSetaiEntityGenerator.createDbT7014KaigoSetaiEntity();
            KaigoSetaiEntity.setXXX(主キー名1);
            KaigoSetaiEntity.setXXX(主キー名2);

        }

        @Test
        public void KaigoSetaiが保持するDbT7014KaigoSetaiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKaigoSetaiが保持するDbT7014KaigoSetaiEntityのEntityDataStateがDeletedに指定されたKaigoSetaiが返る() {
            sut = TestSupport.setStateKaigoSetai(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KaigoSetaiが保持するDbT7014KaigoSetaiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKaigoSetaiが保持するDbT7014KaigoSetaiEntityのEntityDataStateがDeletedに指定されたKaigoSetaiが返る() {
            sut = TestSupport.setStateKaigoSetai(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KaigoSetaiが保持するDbT7014KaigoSetaiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKaigoSetaiが保持するDbT7014KaigoSetaiEntityのEntityDataStateがDeletedに指定されたKaigoSetaiが返る() {
            sut = TestSupport.setStateKaigoSetai(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KaigoSetaiが保持するDbT7014KaigoSetaiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKaigoSetai(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KaigoSetai setStateKaigoSetai(EntityDataState parentState) {
            KaigoSetaiEntity.setState(parentState);
            return new KaigoSetai(KaigoSetaiEntity);
        }
    }
}
