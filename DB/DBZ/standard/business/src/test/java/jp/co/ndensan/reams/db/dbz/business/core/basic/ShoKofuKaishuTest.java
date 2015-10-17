/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7037ShoKofuKaishuEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7037ShoKofuKaishuEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
    private static HihokenshaNo 被保険者番号;
    private static RString 交付証種類;
    private static int 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        被保険者番号 = DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_被保険者番号;
        交付証種類 = DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_交付証種類;
        履歴番号 = DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static ShoKofuKaishu sut;

        @Before
        public void setUp() {
            ShoKofuKaishuEntity = DbT7037ShoKofuKaishuEntityGenerator.createDbT7037ShoKofuKaishuEntity();
            ShoKofuKaishuEntity.setHihokenshaNo(被保険者番号);
            ShoKofuKaishuEntity.setKofuShoShurui(交付証種類);
            ShoKofuKaishuEntity.setRirekiNo(履歴番号);

        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShoKofuKaishu(null, 交付証種類, 履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 交付証種類がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShoKofuKaishu(被保険者番号, null, 履歴番号);
        }

        @Test
        public void 指定したキーが保持するDbT7037ShoKofuKaishuEntityにセットされている() {
            sut = new ShoKofuKaishu(被保険者番号, 交付証種類, 履歴番号);
            assertThat(sut.get被保険者番号(), is(被保険者番号));
            assertThat(sut.get交付証種類(), is(交付証種類));
            assertThat(sut.get履歴番号(), is(履歴番号));
        }

        @Test
        public void 指定したキーが保持するShoKofuKaishuIdentifierにセットされている() {
            sut = new ShoKofuKaishu(被保険者番号, 交付証種類, 履歴番号);
            assertThat(sut.identifier().get被保険者番号(), is(被保険者番号));
            assertThat(sut.identifier().get交付証種類(), is(交付証種類));
            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static ShoKofuKaishu sut;

        @Before
        public void setUp() {
            ShoKofuKaishuEntity = DbT7037ShoKofuKaishuEntityGenerator.createDbT7037ShoKofuKaishuEntity();
            ShoKofuKaishuEntity.setHihokenshaNo(被保険者番号);
            ShoKofuKaishuEntity.setKofuShoShurui(交付証種類);
            ShoKofuKaishuEntity.setRirekiNo(履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ShoKofuKaishu(null);
        }

        @Test
        public void 指定したDbT7037ShoKofuKaishuEntityのキー情報を識別子が持つ() {

            sut = new ShoKofuKaishu(ShoKofuKaishuEntity);

            assertThat(sut.identifier().get被保険者番号(), is(被保険者番号));
            assertThat(sut.identifier().get交付証種類(), is(交付証種類));
            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static ShoKofuKaishu sut;

        @Before
        public void setUp() {
            ShoKofuKaishuEntity = DbT7037ShoKofuKaishuEntityGenerator.createDbT7037ShoKofuKaishuEntity();
            ShoKofuKaishuEntity.setHihokenshaNo(被保険者番号);
            ShoKofuKaishuEntity.setKofuShoShurui(交付証種類);
            ShoKofuKaishuEntity.setRirekiNo(履歴番号);

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
            ShoKofuKaishuEntity.setHihokenshaNo(被保険者番号);
            ShoKofuKaishuEntity.setKofuShoShurui(交付証種類);
            ShoKofuKaishuEntity.setRirekiNo(履歴番号);

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
            ShoKofuKaishuEntity.setHihokenshaNo(被保険者番号);
            ShoKofuKaishuEntity.setKofuShoShurui(交付証種類);
            ShoKofuKaishuEntity.setRirekiNo(履歴番号);

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
            ShoKofuKaishuEntity.setHihokenshaNo(被保険者番号);
            ShoKofuKaishuEntity.setKofuShoShurui(交付証種類);
            ShoKofuKaishuEntity.setRirekiNo(履歴番号);

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
