/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link GappeiNaiJutokushaShinKyuNoHenkan}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class GappeiNaiJutokushaShinKyuNoHenkanTest extends DbzTestBase {

    private static DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity gappeiNaiJutokushaShinKyuNoHenkanEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShikibetsuCode 識別コード;
    private static RString 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        識別コード = DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_識別コード;
        履歴番号 = DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static GappeiNaiJutokushaShinKyuNoHenkan sut;

        @Before
        public void setUp() {
            gappeiNaiJutokushaShinKyuNoHenkanEntity = DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.createDbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity();
            gappeiNaiJutokushaShinKyuNoHenkanEntity.setShikibetsuCode(識別コード);
            gappeiNaiJutokushaShinKyuNoHenkanEntity.setRirekiNo(履歴番号);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 識別コードがnullである場合に_NullPointerExceptionが発生する() {
            sut = new GappeiNaiJutokushaShinKyuNoHenkan(null, 履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 履歴番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new GappeiNaiJutokushaShinKyuNoHenkan(識別コード, null);
        }

        @Test
        public void 指定したキーが保持するDbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityにセットされている() {
            sut = new GappeiNaiJutokushaShinKyuNoHenkan(識別コード, 履歴番号);
            assertThat(sut.get識別コード(), is(識別コード));
            assertThat(sut.get履歴番号(), is(履歴番号));
        }

        @Test
        public void 指定したキーが保持するGappeiNaiJutokushaShinKyuNoHenkanIdentifierにセットされている() {
            sut = new GappeiNaiJutokushaShinKyuNoHenkan(識別コード, 履歴番号);
            assertThat(sut.identifier().get識別コード(), is(識別コード));
            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static GappeiNaiJutokushaShinKyuNoHenkan sut;

        @Before
        public void setUp() {
            gappeiNaiJutokushaShinKyuNoHenkanEntity = DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.createDbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity();
            gappeiNaiJutokushaShinKyuNoHenkanEntity.setShikibetsuCode(識別コード);
            gappeiNaiJutokushaShinKyuNoHenkanEntity.setRirekiNo(履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new GappeiNaiJutokushaShinKyuNoHenkan(null);
        }

        @Test
        public void 指定したDbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityのキー情報を識別子が持つ() {

            sut = new GappeiNaiJutokushaShinKyuNoHenkan(gappeiNaiJutokushaShinKyuNoHenkanEntity);

            assertThat(sut.identifier().get識別コード(), is(識別コード));
            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static GappeiNaiJutokushaShinKyuNoHenkan sut;

        @Before
        public void setUp() {
            gappeiNaiJutokushaShinKyuNoHenkanEntity = DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.createDbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity();
            gappeiNaiJutokushaShinKyuNoHenkanEntity.setShikibetsuCode(識別コード);
            gappeiNaiJutokushaShinKyuNoHenkanEntity.setRirekiNo(履歴番号);

            sut = new GappeiNaiJutokushaShinKyuNoHenkan(gappeiNaiJutokushaShinKyuNoHenkanEntity);
        }

        @Test
        public void get識別コードは_entityが持つ識別コードを返す() {
            assertThat(sut.get識別コード(), is(gappeiNaiJutokushaShinKyuNoHenkanEntity.getShikibetsuCode()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(gappeiNaiJutokushaShinKyuNoHenkanEntity.getRirekiNo()));
        }

        @Test
        public void get識別コード_措置元は_entityが持つ識別コード_措置元を返す() {
            assertThat(sut.get識別コード_措置元(), is(gappeiNaiJutokushaShinKyuNoHenkanEntity.getShikibetsuCodeSochiMoto())
            );
        }

        @Test
        public void get市町村コードは_entityが持つ市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(gappeiNaiJutokushaShinKyuNoHenkanEntity.getShichosonCode()));
        }

        @Test
        public void get市町村コード_措置元は_entityが持つ市町村コード_措置元を返す() {
            assertThat(sut.get市町村コード_措置元(), is(gappeiNaiJutokushaShinKyuNoHenkanEntity.getShichosonCodeSochiMoto()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(gappeiNaiJutokushaShinKyuNoHenkanEntity.getHihokenshaNo()));
        }

        @Test
        public void get被保険者番号_措置元は_entityが持つ被保険者番号_措置元を返す() {
            assertThat(sut.get被保険者番号_措置元(), is(gappeiNaiJutokushaShinKyuNoHenkanEntity.getHihokenshaNoSochiMoto()));
        }

        @Test
        public void get開始年月日は_entityが持つ開始年月日を返す() {
            assertThat(sut.get開始年月日(), is(gappeiNaiJutokushaShinKyuNoHenkanEntity.getKaishiYMD()));
        }

        @Test
        public void get終了年月日は_entityが持つ終了年月日を返す() {
            assertThat(sut.get終了年月日(), is(gappeiNaiJutokushaShinKyuNoHenkanEntity.getShuryoYMD()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static GappeiNaiJutokushaShinKyuNoHenkan sut;

        @Before
        public void setUp() {
            gappeiNaiJutokushaShinKyuNoHenkanEntity = DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.createDbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity();
            gappeiNaiJutokushaShinKyuNoHenkanEntity.setShikibetsuCode(識別コード);
            gappeiNaiJutokushaShinKyuNoHenkanEntity.setRirekiNo(履歴番号);

            sut = new GappeiNaiJutokushaShinKyuNoHenkan(gappeiNaiJutokushaShinKyuNoHenkanEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(gappeiNaiJutokushaShinKyuNoHenkanEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static GappeiNaiJutokushaShinKyuNoHenkan sut;

        @Before
        public void setUp() {
            gappeiNaiJutokushaShinKyuNoHenkanEntity = DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.createDbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity();
            gappeiNaiJutokushaShinKyuNoHenkanEntity.setShikibetsuCode(識別コード);
            gappeiNaiJutokushaShinKyuNoHenkanEntity.setRirekiNo(履歴番号);

            sut = new GappeiNaiJutokushaShinKyuNoHenkan(gappeiNaiJutokushaShinKyuNoHenkanEntity);
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
            gappeiNaiJutokushaShinKyuNoHenkanEntity = DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.createDbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity();
            gappeiNaiJutokushaShinKyuNoHenkanEntity.setShikibetsuCode(識別コード);
            gappeiNaiJutokushaShinKyuNoHenkanEntity.setRirekiNo(履歴番号);

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
            gappeiNaiJutokushaShinKyuNoHenkanEntity.setState(parentState);
            return new GappeiNaiJutokushaShinKyuNoHenkan(gappeiNaiJutokushaShinKyuNoHenkanEntity);
        }
    }
}
