/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7037ShoKofuKaishuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.helper.DbT7037ShoKofuKaishuEntityGenerator;
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
 * {@link ShoKofuKaishu}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShoKofuKaishuTest extends DbzTestBase {

    private static DbT7037ShoKofuKaishuEntity ShoKofuKaishuEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static ShoKofuKaishu sut;

        @Before
        public void setUp() {
            ShoKofuKaishuEntity = DbT7037ShoKofuKaishuEntityGenerator.createDbT7037ShoKofuKaishuEntity();
            ShoKofuKaishuEntity.setXXX(主キー名1);
            ShoKofuKaishuEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShoKofuKaishu(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShoKofuKaishu(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT7037ShoKofuKaishuEntityにセットされている() {
            sut = new ShoKofuKaishu(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するShoKofuKaishuIdentifierにセットされている() {
            sut = new ShoKofuKaishu(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static ShoKofuKaishu sut;

        @Before
        public void setUp() {
            ShoKofuKaishuEntity = DbT7037ShoKofuKaishuEntityGenerator.createDbT7037ShoKofuKaishuEntity();
            ShoKofuKaishuEntity.setXXX(主キー名1);
            ShoKofuKaishuEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ShoKofuKaishu(null);
        }

        @Test
        public void 指定したDbT7037ShoKofuKaishuEntityのキー情報を識別子が持つ() {

            sut = new ShoKofuKaishu(ShoKofuKaishuEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static ShoKofuKaishu sut;

        @Before
        public void setUp() {
            ShoKofuKaishuEntity = DbT7037ShoKofuKaishuEntityGenerator.createDbT7037ShoKofuKaishuEntity();
            ShoKofuKaishuEntity.setXXX(主キー名1);
            ShoKofuKaishuEntity.setXXX(主キー名2);

            sut = new ShoKofuKaishu(ShoKofuKaishuEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(ShoKofuKaishuEntity.getHihokenshaNo()));
        }

        @Test
        public void get交付証種類は_entityが持つ交付証種類を返す() {
            assertThat(sut.get交付証種類(), is(ShoKofuKaishuEntity.getKofuShoShurui()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(ShoKofuKaishuEntity.getRirekiNo()));
        }

        @Test
        public void get市町村コードは_entityが持つ市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(ShoKofuKaishuEntity.getShichosonCode()));
        }

        @Test
        public void get識別コードは_entityが持つ識別コードを返す() {
            assertThat(sut.get識別コード(), is(ShoKofuKaishuEntity.getShikibetsuCode()));
        }

        @Test
        public void get交付年月日は_entityが持つ交付年月日を返す() {
            assertThat(sut.get交付年月日(), is(ShoKofuKaishuEntity.getKofuYMD()));
        }

        @Test
        public void get有効期限は_entityが持つ有効期限を返す() {
            assertThat(sut.get有効期限(), is(ShoKofuKaishuEntity.getYukoKigenYMD()));
        }

        @Test
        public void get交付事由は_entityが持つ交付事由を返す() {
            assertThat(sut.get交付事由(), is(ShoKofuKaishuEntity.getKofuJiyu()));
        }

        @Test
        public void get交付理由は_entityが持つ交付理由を返す() {
            assertThat(sut.get交付理由(), is(ShoKofuKaishuEntity.getKofuRiyu()));
        }

        @Test
        public void get回収年月日は_entityが持つ回収年月日を返す() {
            assertThat(sut.get回収年月日(), is(ShoKofuKaishuEntity.getKaishuYMD()));
        }

        @Test
        public void get回収事由は_entityが持つ回収事由を返す() {
            assertThat(sut.get回収事由(), is(ShoKofuKaishuEntity.getKaishuJiyu()));
        }

        @Test
        public void get回収理由は_entityが持つ回収理由を返す() {
            assertThat(sut.get回収理由(), is(ShoKofuKaishuEntity.getKaishuRiyu()));
        }

        @Test
        public void get単票発行有無フラグは_entityが持つ単票発行有無フラグを返す() {
            assertThat(sut.get単票発行有無フラグ(), is(ShoKofuKaishuEntity.getTanpyoHakkoUmuFlag()));
        }

        @Test
        public void get発行処理日時は_entityが持つ発行処理日時を返す() {
            assertThat(sut.get発行処理日時(), is(ShoKofuKaishuEntity.getHakkoShoriTimestamp()));
        }

        @Test
        public void get新様式印書済区分コードは_entityが持つ新様式印書済区分コードを返す() {
            assertThat(sut.get新様式印書済区分コード(), is(ShoKofuKaishuEntity.getShinYoshikiSumiKubunCode()));
        }

        @Test
        public void get証様式区分コードは_entityが持つ証様式区分コードを返す() {
            assertThat(sut.get証様式区分コード(), is(ShoKofuKaishuEntity.getShoYoshikiKubunCode()));
        }

        @Test
        public void get論理削除フラグは_entityが持つ論理削除フラグを返す() {
            assertThat(sut.get論理削除フラグ(), is(ShoKofuKaishuEntity.getLogicalDeletedFlag()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static ShoKofuKaishu sut;

        @Before
        public void setUp() {
            ShoKofuKaishuEntity = DbT7037ShoKofuKaishuEntityGenerator.createDbT7037ShoKofuKaishuEntity();
            ShoKofuKaishuEntity.setXXX(主キー名1);
            ShoKofuKaishuEntity.setXXX(主キー名2);

            sut = new ShoKofuKaishu(ShoKofuKaishuEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ShoKofuKaishuEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static ShoKofuKaishu sut;

        @Before
        public void setUp() {
            ShoKofuKaishuEntity = DbT7037ShoKofuKaishuEntityGenerator.createDbT7037ShoKofuKaishuEntity();
            ShoKofuKaishuEntity.setXXX(主キー名1);
            ShoKofuKaishuEntity.setXXX(主キー名2);

            sut = new ShoKofuKaishu(ShoKofuKaishuEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static ShoKofuKaishu sut;
        private static ShoKofuKaishu result;

        @Before
        public void setUp() {
            ShoKofuKaishuEntity = DbT7037ShoKofuKaishuEntityGenerator.createDbT7037ShoKofuKaishuEntity();
            ShoKofuKaishuEntity.setXXX(主キー名1);
            ShoKofuKaishuEntity.setXXX(主キー名2);

        }

        @Test
        public void ShoKofuKaishuが保持するDbT7037ShoKofuKaishuEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりShoKofuKaishuが保持するDbT7037ShoKofuKaishuEntityのEntityDataStateがDeletedに指定されたShoKofuKaishuが返る() {
            sut = TestSupport.setStateShoKofuKaishu(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShoKofuKaishuが保持するDbT7037ShoKofuKaishuEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりShoKofuKaishuが保持するDbT7037ShoKofuKaishuEntityのEntityDataStateがDeletedに指定されたShoKofuKaishuが返る() {
            sut = TestSupport.setStateShoKofuKaishu(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShoKofuKaishuが保持するDbT7037ShoKofuKaishuEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりShoKofuKaishuが保持するDbT7037ShoKofuKaishuEntityのEntityDataStateがDeletedに指定されたShoKofuKaishuが返る() {
            sut = TestSupport.setStateShoKofuKaishu(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ShoKofuKaishuが保持するDbT7037ShoKofuKaishuEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateShoKofuKaishu(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ShoKofuKaishu setStateShoKofuKaishu(EntityDataState parentState) {
            ShoKofuKaishuEntity.setState(parentState);
            return new ShoKofuKaishu(ShoKofuKaishuEntity);
        }
    }
}
