/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5914SonotaKikanJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5914SonotaKikanJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShoKisaiHokenshaNo;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link SonotaKikanJoho}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class SonotaKikanJohoTest extends DbeTestBase {

    private static DbT5914SonotaKikanJohoEntity SonotaKikanJohoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShoKisaiHokenshaNo 証記載保険者番号;
    private static RString その他機関コード;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        証記載保険者番号 = DbT5914SonotaKikanJohoEntityGenerator.DEFAULT_証記載保険者番号;
        その他機関コード = DbT5914SonotaKikanJohoEntityGenerator.DEFAULT_その他機関コード;
    }

    public static class 主キーコンストラクタテスト extends DbeTestBase {

        private static SonotaKikanJoho sut;

        @BeforeClass
        public static void setUpClass() {
            SonotaKikanJohoEntity = DbT5914SonotaKikanJohoEntityGenerator.createDbT5914SonotaKikanJohoEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 証記載保険者番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new SonotaKikanJoho(null, その他機関コード);
        }

        @Test(expected = NullPointerException.class)
        public void その他機関コードがnullである場合に_NullPointerExceptionが発生する() {
            sut = new SonotaKikanJoho(証記載保険者番号, null);
        }

        @Test
        public void 指定したキーが保持するDbT5914SonotaKikanJohoEntityにセットされている() {
            sut = new SonotaKikanJoho(証記載保険者番号, その他機関コード);
            assertThat(sut.get証記載保険者番号(), is(証記載保険者番号));
            assertThat(sut.getその他機関コード(), is(その他機関コード));
        }

        @Test
        public void 指定したキーが保持するSonotaKikanJohoIdentifierにセットされている() {
            sut = new SonotaKikanJoho(証記載保険者番号, その他機関コード);
            assertThat(sut.identifier().get証記載保険者番号(), is(証記載保険者番号));
            assertThat(sut.identifier().getその他機関コード(), is(その他機関コード));
        }
    }

    public static class Entityコンストラクタテスト extends DbeTestBase {

        private static SonotaKikanJoho sut;

        @BeforeClass
        public static void setUpClass() {
            SonotaKikanJohoEntity = DbT5914SonotaKikanJohoEntityGenerator.createDbT5914SonotaKikanJohoEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new SonotaKikanJoho(null);
        }

        @Test
        public void 指定したDbT5914SonotaKikanJohoEntityのキー情報を識別子が持つ() {

            sut = new SonotaKikanJoho(SonotaKikanJohoEntity);

            assertThat(sut.identifier().get証記載保険者番号(), is(証記載保険者番号));
            assertThat(sut.identifier().getその他機関コード(), is(その他機関コード));
        }
    }

    public static class getterテスト extends DbeTestBase {

        private static SonotaKikanJoho sut;

        @BeforeClass
        public static void setUpClass() {
            SonotaKikanJohoEntity = DbT5914SonotaKikanJohoEntityGenerator.createDbT5914SonotaKikanJohoEntity();

            sut = new SonotaKikanJoho(SonotaKikanJohoEntity);
        }

        @Test
        public void get証記載保険者番号は_entityが持つ証記載保険者番号を返す() {
            assertThat(sut.get証記載保険者番号(), is(SonotaKikanJohoEntity.getShoKisaiHokenshaNo()));
        }

        @Test
        public void getその他機関コードは_entityが持つその他機関コードを返す() {
            assertThat(sut.getその他機関コード(), is(SonotaKikanJohoEntity.getSonotaKikanCode()));
        }

        @Test
        public void get機関名称は_entityが持つ機関名称を返す() {
            assertThat(sut.get機関名称(), is(SonotaKikanJohoEntity.getKikanMeisho()));
        }

        @Test
        public void get機関名称カナは_entityが持つ機関名称カナを返す() {
            assertThat(sut.get機関名称カナ(), is(SonotaKikanJohoEntity.getKikanMeishoKana()));
        }

        @Test
        public void get郵便番号は_entityが持つ郵便番号を返す() {
            assertThat(sut.get郵便番号(), is(SonotaKikanJohoEntity.getYubinNo()));
        }

        @Test
        public void get住所は_entityが持つ住所を返す() {
            assertThat(sut.get住所(), is(SonotaKikanJohoEntity.getJusho()));
        }

        @Test
        public void get住所カナは_entityが持つ住所カナを返す() {
            assertThat(sut.get住所カナ(), is(SonotaKikanJohoEntity.getJushoKana()));
        }

        @Test
        public void get電話番号は_entityが持つ電話番号を返す() {
            assertThat(sut.get電話番号(), is(SonotaKikanJohoEntity.getTelNo()));
        }

        @Test
        public void get調査委託区分は_entityが持つ調査委託区分を返す() {
            assertThat(sut.get調査委託区分(), is(SonotaKikanJohoEntity.getChosaItakuKubun()));
        }

        @Test
        public void get割付定員は_entityが持つ割付定員を返す() {
            assertThat(sut.get割付定員(), is(SonotaKikanJohoEntity.getWaritsukeTeiin()));
        }

        @Test
        public void get割付地区は_entityが持つ割付地区を返す() {
            assertThat(sut.get割付地区(), is(SonotaKikanJohoEntity.getWaritsukeChiku()));
        }

        @Test
        public void get機関の区分は_entityが持つ機関の区分を返す() {
            assertThat(sut.get機関の区分(), is(SonotaKikanJohoEntity.getKikanKubun()));
        }

        @Test
        public void get廃止フラグは_entityが持つ廃止フラグを返す() {
            assertThat(sut.get廃止フラグ(), is(SonotaKikanJohoEntity.getHaishiFlag()));
        }
    }

    public static class toEntityテスト extends DbeTestBase {

        private static SonotaKikanJoho sut;

        @BeforeClass
        public static void setUpClass() {
            SonotaKikanJohoEntity = DbT5914SonotaKikanJohoEntityGenerator.createDbT5914SonotaKikanJohoEntity();

            sut = new SonotaKikanJoho(SonotaKikanJohoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(SonotaKikanJohoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbeTestBase {

        private static SonotaKikanJoho sut;

        @BeforeClass
        public static void setUpClass() {
            SonotaKikanJohoEntity = DbT5914SonotaKikanJohoEntityGenerator.createDbT5914SonotaKikanJohoEntity();

            sut = new SonotaKikanJoho(SonotaKikanJohoEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbeTestBase {

        private static SonotaKikanJoho sut;
        private static SonotaKikanJoho result;

        @BeforeClass
        public static void setUpClass() {
            SonotaKikanJohoEntity = DbT5914SonotaKikanJohoEntityGenerator.createDbT5914SonotaKikanJohoEntity();

        }

        @Test
        public void SonotaKikanJohoが保持するDbT5914SonotaKikanJohoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりSonotaKikanJohoが保持するDbT5914SonotaKikanJohoEntityのEntityDataStateがDeletedに指定されたSonotaKikanJohoが返る() {
            sut = TestSupport.setStateSonotaKikanJoho(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void SonotaKikanJohoが保持するDbT5914SonotaKikanJohoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりSonotaKikanJohoが保持するDbT5914SonotaKikanJohoEntityのEntityDataStateがDeletedに指定されたSonotaKikanJohoが返る() {
            sut = TestSupport.setStateSonotaKikanJoho(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void SonotaKikanJohoが保持するDbT5914SonotaKikanJohoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりSonotaKikanJohoが保持するDbT5914SonotaKikanJohoEntityのEntityDataStateがDeletedに指定されたSonotaKikanJohoが返る() {
            sut = TestSupport.setStateSonotaKikanJoho(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void SonotaKikanJohoが保持するDbT5914SonotaKikanJohoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateSonotaKikanJoho(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static SonotaKikanJoho setStateSonotaKikanJoho(EntityDataState parentState) {
            SonotaKikanJohoEntity.setState(parentState);
            return new SonotaKikanJoho(SonotaKikanJohoEntity);
        }
    }
}
