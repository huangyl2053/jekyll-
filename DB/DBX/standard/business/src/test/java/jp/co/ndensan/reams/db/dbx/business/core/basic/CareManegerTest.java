/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.basic;

import jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7064CareManegerEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7064CareManegerEntityGenerator;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
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
 * {@link CareManeger}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class CareManegerTest extends DbxTestBase {

    private static DbT7064CareManegerEntity CareManegerEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static RString 主キー名1;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7064CareManegerEntityGenerator.DEFAULT_介護支援専門員番号;
    }

    public static class 主キーコンストラクタテスト extends DbxTestBase {

        private static CareManeger sut;

        @Before
        public void setUp() {
            CareManegerEntity = DbT7064CareManegerEntityGenerator.createDbT7064CareManegerEntity();
            CareManegerEntity.setKaigoShienSenmoninNo(主キー名1);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new CareManeger((RString) null);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new CareManeger(主キー名1);
        }

        @Test
        public void 指定したキーが保持するDbT7064CareManegerEntityにセットされている() {
            sut = new CareManeger(主キー名1);
            assertThat(sut.get介護支援専門員番号(), is(主キー名1));
        }

        @Test
        public void 指定したキーが保持するCareManegerIdentifierにセットされている() {
            sut = new CareManeger(主キー名1);
            assertThat(sut.identifier().get介護支援専門員番号(), is(主キー名1));
        }
    }

    public static class Entityコンストラクタテスト extends DbxTestBase {

        private static CareManeger sut;

        @Before
        public void setUp() {
            CareManegerEntity = DbT7064CareManegerEntityGenerator.createDbT7064CareManegerEntity();
            CareManegerEntity.setKaigoShienSenmoninNo(主キー名1);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new CareManeger((DbT7064CareManegerEntity) null);
        }

        @Test
        public void 指定したDbT7064CareManegerEntityのキー情報を識別子が持つ() {

            sut = new CareManeger(CareManegerEntity);

            assertThat(sut.identifier().get介護支援専門員番号(), is(主キー名1));
        }
    }

    public static class getterテスト extends DbxTestBase {

        private static CareManeger sut;

        @Before
        public void setUp() {
            CareManegerEntity = DbT7064CareManegerEntityGenerator.createDbT7064CareManegerEntity();
            CareManegerEntity.setKaigoShienSenmoninNo(主キー名1);

            sut = new CareManeger(CareManegerEntity);
        }

        @Test
        public void get介護支援専門員番号は_entityが持つ介護支援専門員番号を返す() {
            assertThat(sut.get介護支援専門員番号(), is(CareManegerEntity.getKaigoShienSenmoninNo()));
        }

        @Test
        public void get介護支援専門員名は_entityが持つ介護支援専門員名を返す() {
            assertThat(sut.get介護支援専門員名(), is(CareManegerEntity.getKaigoShienSenmoninMei()));
        }

        @Test
        public void get介護支援専門員名カナは_entityが持つ介護支援専門員名カナを返す() {
            assertThat(sut.get介護支援専門員名カナ(), is(CareManegerEntity.getKaigoShienSenmoninMeiKana()));
        }

        @Test
        public void get所属事業者番号は_entityが持つ所属事業者番号を返す() {
            assertThat(sut.get所属事業者番号(), is(CareManegerEntity.getShozokuJigyoshaNo()));
        }

        @Test
        public void get有効開始年月日は_entityが持つ有効開始年月日を返す() {
            assertThat(sut.get有効開始年月日(), is(CareManegerEntity.getYukoKaishiDate()));
        }

        @Test
        public void get有効終了年月日は_entityが持つ有効終了年月日を返す() {
            assertThat(sut.get有効終了年月日(), is(CareManegerEntity.getYukoShuryoDate()));
        }
    }

    public static class toEntityテスト extends DbxTestBase {

        private static CareManeger sut;

        @Before
        public void setUp() {
            CareManegerEntity = DbT7064CareManegerEntityGenerator.createDbT7064CareManegerEntity();
            CareManegerEntity.setKaigoShienSenmoninNo(主キー名1);

            sut = new CareManeger(CareManegerEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(CareManegerEntity));
        }
    }

    public static class SerializationProxyテスト extends DbxTestBase {

        private static CareManeger sut;

        @Before
        public void setUp() {
            CareManegerEntity = DbT7064CareManegerEntityGenerator.createDbT7064CareManegerEntity();
            CareManegerEntity.setKaigoShienSenmoninNo(主キー名1);

            sut = new CareManeger(CareManegerEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(IsSerializable.serializable()));
        }
    }

    public static class deletedテスト extends DbxTestBase {

        private static CareManeger sut;
        private static CareManeger result;

        @Before
        public void setUp() {
            CareManegerEntity = DbT7064CareManegerEntityGenerator.createDbT7064CareManegerEntity();
            CareManegerEntity.setKaigoShienSenmoninNo(主キー名1);

        }

        @Test
        public void CareManegerが保持するDbT7064CareManegerEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりCareManegerが保持するDbT7064CareManegerEntityのEntityDataStateがDeletedに指定されたCareManegerが返る() {
            sut = TestSupport.setStateCareManeger(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void CareManegerが保持するDbT7064CareManegerEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりCareManegerが保持するDbT7064CareManegerEntityのEntityDataStateがDeletedに指定されたCareManegerが返る() {
            sut = TestSupport.setStateCareManeger(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void CareManegerが保持するDbT7064CareManegerEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりCareManegerが保持するDbT7064CareManegerEntityのEntityDataStateがDeletedに指定されたCareManegerが返る() {
            sut = TestSupport.setStateCareManeger(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void CareManegerが保持するDbT7064CareManegerEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateCareManeger(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static CareManeger setStateCareManeger(EntityDataState parentState) {
            CareManegerEntity.setState(parentState);
            return new CareManeger(CareManegerEntity);
        }
    }
}
