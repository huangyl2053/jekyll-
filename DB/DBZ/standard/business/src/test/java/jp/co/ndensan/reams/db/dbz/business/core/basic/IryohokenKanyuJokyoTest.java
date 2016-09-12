/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1008IryohokenKanyuJokyoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1008IryohokenKanyuJokyoEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
 * {@link IryohokenKanyuJokyo}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class IryohokenKanyuJokyoTest extends DbzTestBase {

    private static DbT1008IryohokenKanyuJokyoEntity IryohokenKanyuJokyoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShikibetsuCode 識別コード;
    private static int 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        識別コード = DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_識別コード;
        履歴番号 = DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static IryohokenKanyuJokyo sut;

        @Before
        public void setUp() {
            IryohokenKanyuJokyoEntity = DbT1008IryohokenKanyuJokyoEntityGenerator.createDbT1008IryohokenKanyuJokyoEntity();
            IryohokenKanyuJokyoEntity.setShikibetsuCode(識別コード);
            IryohokenKanyuJokyoEntity.setRirekiNo(履歴番号);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new IryohokenKanyuJokyo(null, 履歴番号);
        }

//        @Test(expected = NullPointerException.class)
//        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
//            sut = new IryohokenKanyuJokyo(識別コード, null);
//        }
        @Test
        public void 指定したキーが保持するDbT1008IryohokenKanyuJokyoEntityにセットされている() {
            sut = new IryohokenKanyuJokyo(識別コード, 履歴番号);
            assertThat(sut.get識別コード(), is(識別コード));
            assertThat(sut.get履歴番号(), is(履歴番号));
        }

        @Test
        public void 指定したキーが保持するIryohokenKanyuJokyoIdentifierにセットされている() {
            sut = new IryohokenKanyuJokyo(識別コード, 履歴番号);
            assertThat(sut.identifier().get識別コード(), is(識別コード));
            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static IryohokenKanyuJokyo sut;

        @Before
        public void setUp() {
            IryohokenKanyuJokyoEntity = DbT1008IryohokenKanyuJokyoEntityGenerator.createDbT1008IryohokenKanyuJokyoEntity();
            IryohokenKanyuJokyoEntity.setShikibetsuCode(識別コード);
            IryohokenKanyuJokyoEntity.setRirekiNo(履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new IryohokenKanyuJokyo(null);
        }

        @Test
        public void 指定したDbT1008IryohokenKanyuJokyoEntityのキー情報を識別子が持つ() {

            sut = new IryohokenKanyuJokyo(IryohokenKanyuJokyoEntity);

            assertThat(sut.identifier().get識別コード(), is(識別コード));
            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static IryohokenKanyuJokyo sut;

        @Before
        public void setUp() {
            IryohokenKanyuJokyoEntity = DbT1008IryohokenKanyuJokyoEntityGenerator.createDbT1008IryohokenKanyuJokyoEntity();
            IryohokenKanyuJokyoEntity.setShikibetsuCode(識別コード);
            IryohokenKanyuJokyoEntity.setRirekiNo(履歴番号);

            sut = new IryohokenKanyuJokyo(IryohokenKanyuJokyoEntity);
        }

        @Test
        public void get識別コードは_entityが持つ識別コードを返す() {
            assertThat(sut.get識別コード(), is(IryohokenKanyuJokyoEntity.getShikibetsuCode()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(IryohokenKanyuJokyoEntity.getRirekiNo()));
        }

        @Test
        public void get市町村コードは_entityが持つ市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(IryohokenKanyuJokyoEntity.getShichosonCode()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(IryohokenKanyuJokyoEntity.getHihokenshaNo()));
        }

        @Test
        public void get医療保険種別コードは_entityが持つ医療保険種別コードを返す() {
            assertThat(sut.get医療保険種別コード(), is(IryohokenKanyuJokyoEntity.getIryoHokenShubetsuCode()));
        }

        @Test
        public void get医療保険者番号は_entityが持つ医療保険者番号を返す() {
            assertThat(sut.get医療保険者番号(), is(IryohokenKanyuJokyoEntity.getIryoHokenshaNo()));
        }

        @Test
        public void get医療保険者名称は_entityが持つ医療保険者名称を返す() {
            assertThat(sut.get医療保険者名称(), is(IryohokenKanyuJokyoEntity.getIryoHokenshaMeisho()));
        }

        @Test
        public void get医療保険記号番号は_entityが持つ医療保険記号番号を返す() {
            assertThat(sut.get医療保険記号番号(), is(IryohokenKanyuJokyoEntity.getIryoHokenKigoNo()));
        }

        @Test
        public void get医療保険加入年月日は_entityが持つ医療保険加入年月日を返す() {
            assertThat(sut.get医療保険加入年月日(), is(IryohokenKanyuJokyoEntity.getIryoHokenKanyuYMD()));
        }

        @Test
        public void get医療保険脱退年月日は_entityが持つ医療保険脱退年月日を返す() {
            assertThat(sut.get医療保険脱退年月日(), is(IryohokenKanyuJokyoEntity.getIryoHokenDattaiYMD()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static IryohokenKanyuJokyo sut;

        @Before
        public void setUp() {
            IryohokenKanyuJokyoEntity = DbT1008IryohokenKanyuJokyoEntityGenerator.createDbT1008IryohokenKanyuJokyoEntity();
            IryohokenKanyuJokyoEntity.setShikibetsuCode(識別コード);
            IryohokenKanyuJokyoEntity.setRirekiNo(履歴番号);

            sut = new IryohokenKanyuJokyo(IryohokenKanyuJokyoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(IryohokenKanyuJokyoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static IryohokenKanyuJokyo sut;

        @Before
        public void setUp() {
            IryohokenKanyuJokyoEntity = DbT1008IryohokenKanyuJokyoEntityGenerator.createDbT1008IryohokenKanyuJokyoEntity();
            IryohokenKanyuJokyoEntity.setShikibetsuCode(識別コード);
            IryohokenKanyuJokyoEntity.setRirekiNo(履歴番号);

            sut = new IryohokenKanyuJokyo(IryohokenKanyuJokyoEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(IsSerializable.serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static IryohokenKanyuJokyo sut;
        private static IryohokenKanyuJokyo result;

        @Before
        public void setUp() {
            IryohokenKanyuJokyoEntity = DbT1008IryohokenKanyuJokyoEntityGenerator.createDbT1008IryohokenKanyuJokyoEntity();
            IryohokenKanyuJokyoEntity.setShikibetsuCode(識別コード);
            IryohokenKanyuJokyoEntity.setRirekiNo(履歴番号);

        }

        @Test
        public void IryohokenKanyuJokyoが保持するDbT1008IryohokenKanyuJokyoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりIryohokenKanyuJokyoが保持するDbT1008IryohokenKanyuJokyoEntityのEntityDataStateがDeletedに指定されたIryohokenKanyuJokyoが返る() {
            sut = TestSupport.setStateIryohokenKanyuJokyo(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void IryohokenKanyuJokyoが保持するDbT1008IryohokenKanyuJokyoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりIryohokenKanyuJokyoが保持するDbT1008IryohokenKanyuJokyoEntityのEntityDataStateがDeletedに指定されたIryohokenKanyuJokyoが返る() {
            sut = TestSupport.setStateIryohokenKanyuJokyo(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void IryohokenKanyuJokyoが保持するDbT1008IryohokenKanyuJokyoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりIryohokenKanyuJokyoが保持するDbT1008IryohokenKanyuJokyoEntityのEntityDataStateがDeletedに指定されたIryohokenKanyuJokyoが返る() {
            sut = TestSupport.setStateIryohokenKanyuJokyo(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void IryohokenKanyuJokyoが保持するDbT1008IryohokenKanyuJokyoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateIryohokenKanyuJokyo(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static IryohokenKanyuJokyo setStateIryohokenKanyuJokyo(EntityDataState parentState) {
            IryohokenKanyuJokyoEntity.setState(parentState);
            return new IryohokenKanyuJokyo(IryohokenKanyuJokyoEntity);
        }
    }
}
