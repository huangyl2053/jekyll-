/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.SochimotoSochisakiKubun.措置元;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator;
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
 * {@link GappeiNaiJutokushaShinKyuNoHenkan}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class GappeiNaiJutokushaShinKyuNoHenkanTest extends DbzTestBase {

    private static DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity GappeiNaiJutokushaShinKyuNoHenkanEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static GappeiNaiJutokushaShinKyuNoHenkan sut;

        @Before
        public void setUp() {
            GappeiNaiJutokushaShinKyuNoHenkanEntity = DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.createDbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity();
            GappeiNaiJutokushaShinKyuNoHenkanEntity.setXXX(主キー名1);
            GappeiNaiJutokushaShinKyuNoHenkanEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new GappeiNaiJutokushaShinKyuNoHenkan(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new GappeiNaiJutokushaShinKyuNoHenkan(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityにセットされている() {
            sut = new GappeiNaiJutokushaShinKyuNoHenkan(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するGappeiNaiJutokushaShinKyuNoHenkanIdentifierにセットされている() {
            sut = new GappeiNaiJutokushaShinKyuNoHenkan(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static GappeiNaiJutokushaShinKyuNoHenkan sut;

        @Before
        public void setUp() {
            GappeiNaiJutokushaShinKyuNoHenkanEntity = DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.createDbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity();
            GappeiNaiJutokushaShinKyuNoHenkanEntity.setXXX(主キー名1);
            GappeiNaiJutokushaShinKyuNoHenkanEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new GappeiNaiJutokushaShinKyuNoHenkan(null);
        }

        @Test
        public void 指定したDbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityのキー情報を識別子が持つ() {

            sut = new GappeiNaiJutokushaShinKyuNoHenkan(GappeiNaiJutokushaShinKyuNoHenkanEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static GappeiNaiJutokushaShinKyuNoHenkan sut;

        @Before
        public void setUp() {
            GappeiNaiJutokushaShinKyuNoHenkanEntity = DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.createDbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity();
            GappeiNaiJutokushaShinKyuNoHenkanEntity.setXXX(主キー名1);
            GappeiNaiJutokushaShinKyuNoHenkanEntity.setXXX(主キー名2);

            sut = new GappeiNaiJutokushaShinKyuNoHenkan(GappeiNaiJutokushaShinKyuNoHenkanEntity);
        }

        @Test
        public void get識別コードは_entityが持つ識別コードを返す() {
            assertThat(sut.get識別コード(), is(GappeiNaiJutokushaShinKyuNoHenkanEntity.getShikibetsuCode()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(GappeiNaiJutokushaShinKyuNoHenkanEntity.getRirekiNo()));
        }

        @Test
        public void get識別コード（措置元
        ）は_entityが持つ識別コード
        （措置元

        ）を返す() {
            assertThat(sut.get識別コード（措置元
            ）(), is(GappeiNaiJutokushaShinKyuNoHenkanEntity.getShikibetsuCodeSochiMoto())


        );
        }

        @Test
        public void get市町村コードは_entityが持つ市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(GappeiNaiJutokushaShinKyuNoHenkanEntity.getShichosonCode()));
        }

        @Test
        public void get市町村コード（措置元
        ）は_entityが持つ市町村コード
        （措置元

        ）を返す() {
            assertThat(sut.get市町村コード（措置元
            ）(), is(GappeiNaiJutokushaShinKyuNoHenkanEntity.getShichosonCodeSochiMoto())


        );
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(GappeiNaiJutokushaShinKyuNoHenkanEntity.getHihokenshaNo()));
        }

        @Test
        public void get被保険者番号（措置元
        ）は_entityが持つ被保険者番号
        （措置元

        ）を返す() {
            assertThat(sut.get被保険者番号（措置元
            ）(), is(GappeiNaiJutokushaShinKyuNoHenkanEntity.getHihokenshaNoSochiMoto())


        );
        }

        @Test
        public void get開始年月日は_entityが持つ開始年月日を返す() {
            assertThat(sut.get開始年月日(), is(GappeiNaiJutokushaShinKyuNoHenkanEntity.getKaishiYMD()));
        }

        @Test
        public void get終了年月日は_entityが持つ終了年月日を返す() {
            assertThat(sut.get終了年月日(), is(GappeiNaiJutokushaShinKyuNoHenkanEntity.getShuryoYMD()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static GappeiNaiJutokushaShinKyuNoHenkan sut;

        @Before
        public void setUp() {
            GappeiNaiJutokushaShinKyuNoHenkanEntity = DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.createDbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity();
            GappeiNaiJutokushaShinKyuNoHenkanEntity.setXXX(主キー名1);
            GappeiNaiJutokushaShinKyuNoHenkanEntity.setXXX(主キー名2);

            sut = new GappeiNaiJutokushaShinKyuNoHenkan(GappeiNaiJutokushaShinKyuNoHenkanEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(GappeiNaiJutokushaShinKyuNoHenkanEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static GappeiNaiJutokushaShinKyuNoHenkan sut;

        @Before
        public void setUp() {
            GappeiNaiJutokushaShinKyuNoHenkanEntity = DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.createDbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity();
            GappeiNaiJutokushaShinKyuNoHenkanEntity.setXXX(主キー名1);
            GappeiNaiJutokushaShinKyuNoHenkanEntity.setXXX(主キー名2);

            sut = new GappeiNaiJutokushaShinKyuNoHenkan(GappeiNaiJutokushaShinKyuNoHenkanEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static GappeiNaiJutokushaShinKyuNoHenkan sut;
        private static GappeiNaiJutokushaShinKyuNoHenkan result;

        @Before
        public void setUp() {
            GappeiNaiJutokushaShinKyuNoHenkanEntity = DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.createDbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity();
            GappeiNaiJutokushaShinKyuNoHenkanEntity.setXXX(主キー名1);
            GappeiNaiJutokushaShinKyuNoHenkanEntity.setXXX(主キー名2);

        }

        @Test
        public void GappeiNaiJutokushaShinKyuNoHenkanが保持するDbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりGappeiNaiJutokushaShinKyuNoHenkanが保持するDbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityのEntityDataStateがDeletedに指定されたGappeiNaiJutokushaShinKyuNoHenkanが返る() {
            sut = TestSupport.setStateGappeiNaiJutokushaShinKyuNoHenkan(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void GappeiNaiJutokushaShinKyuNoHenkanが保持するDbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりGappeiNaiJutokushaShinKyuNoHenkanが保持するDbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityのEntityDataStateがDeletedに指定されたGappeiNaiJutokushaShinKyuNoHenkanが返る() {
            sut = TestSupport.setStateGappeiNaiJutokushaShinKyuNoHenkan(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void GappeiNaiJutokushaShinKyuNoHenkanが保持するDbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりGappeiNaiJutokushaShinKyuNoHenkanが保持するDbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityのEntityDataStateがDeletedに指定されたGappeiNaiJutokushaShinKyuNoHenkanが返る() {
            sut = TestSupport.setStateGappeiNaiJutokushaShinKyuNoHenkan(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void GappeiNaiJutokushaShinKyuNoHenkanが保持するDbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateGappeiNaiJutokushaShinKyuNoHenkan(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static GappeiNaiJutokushaShinKyuNoHenkan setStateGappeiNaiJutokushaShinKyuNoHenkan(EntityDataState parentState) {
            GappeiNaiJutokushaShinKyuNoHenkanEntity.setState(parentState);
            return new GappeiNaiJutokushaShinKyuNoHenkan(GappeiNaiJutokushaShinKyuNoHenkanEntity);
        }
    }
}
