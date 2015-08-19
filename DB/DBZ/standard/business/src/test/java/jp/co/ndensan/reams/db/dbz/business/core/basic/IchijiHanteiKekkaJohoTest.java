/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT4116IchijiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT4116IchijiHanteiKekkaJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link IchijiHanteiKekkaJoho}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class IchijiHanteiKekkaJohoTest extends DbzTestBase {

    private static DbT4116IchijiHanteiKekkaJohoEntity IchijiHanteiKekkaJohoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShinseishoKanriNo 申請書管理番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        申請書管理番号 = DbT4116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_申請書管理番号;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static IchijiHanteiKekkaJoho sut;

        @BeforeClass
        public static void setUpClass() {
            IchijiHanteiKekkaJohoEntity = DbT4116IchijiHanteiKekkaJohoEntityGenerator.createDbT4116IchijiHanteiKekkaJohoEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 申請書管理番号がnullである場合に_NullPointerExceptionが発生する() {
            申請書管理番号 = null;
            sut = new IchijiHanteiKekkaJoho(申請書管理番号);
        }

        @Test
        public void 指定したキーが保持するDbT4116IchijiHanteiKekkaJohoEntityにセットされている() {
            sut = new IchijiHanteiKekkaJoho(申請書管理番号);
            assertThat(sut.get申請書管理番号(), is(申請書管理番号));
        }

        @Test
        public void 指定したキーが保持するIchijiHanteiKekkaJohoIdentifierにセットされている() {
            sut = new IchijiHanteiKekkaJoho(申請書管理番号);

            assertThat(sut.identifier().get申請書管理番号(), is(申請書管理番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static IchijiHanteiKekkaJoho sut;

        @BeforeClass
        public static void setUpClass() {
            IchijiHanteiKekkaJohoEntity = DbT4116IchijiHanteiKekkaJohoEntityGenerator.createDbT4116IchijiHanteiKekkaJohoEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            申請書管理番号 = null;
            sut = new IchijiHanteiKekkaJoho(申請書管理番号);
        }

        @Test
        public void 指定したDbT4116IchijiHanteiKekkaJohoEntityのキー情報を識別子が持つ() {

            sut = new IchijiHanteiKekkaJoho(IchijiHanteiKekkaJohoEntity);

            assertThat(sut.identifier().get申請書管理番号(), is(申請書管理番号));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static IchijiHanteiKekkaJoho sut;

        @BeforeClass
        public static void setUpClass() {
            IchijiHanteiKekkaJohoEntity = DbT4116IchijiHanteiKekkaJohoEntityGenerator.createDbT4116IchijiHanteiKekkaJohoEntity();

            sut = new IchijiHanteiKekkaJoho(IchijiHanteiKekkaJohoEntity);
        }

        @Test
        public void get申請書管理番号は_entityが持つ申請書管理番号を返す() {
            assertThat(sut.get申請書管理番号(), is(IchijiHanteiKekkaJohoEntity.getShinseishoKanriNo()));
        }

        @Test
        public void get仮一次判定区分は_entityが持つ仮一次判定区分を返す() {
            assertThat(sut.get仮一次判定区分(), is(IchijiHanteiKekkaJohoEntity.getKariIchijiHanteiKubun()));
        }

        @Test
        public void get要介護認定一次判定年月日は_entityが持つ要介護認定一次判定年月日を返す() {
            assertThat(sut.get要介護認定一次判定年月日(), is(IchijiHanteiKekkaJohoEntity.getIchijiHanteiYMD()));
        }

        @Test
        public void get要介護認定一次判定結果コードは_entityが持つ要介護認定一次判定結果コードを返す() {
            assertThat(sut.get要介護認定一次判定結果コード(), is(IchijiHanteiKekkaJohoEntity.getIchijiHanteiKekkaCode()));
        }

        @Test
        public void get要介護認定一次判定結果コード_認知症加算は_entityが持つ要介護認定一次判定結果コード_認知症加算を返す() {
            assertThat(sut.get要介護認定一次判定結果コード_認知症加算(), is(IchijiHanteiKekkaJohoEntity.getIchijiHanteiKekkaNinchishoKasanCode()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static IchijiHanteiKekkaJoho sut;

        @BeforeClass
        public static void setUpClass() {
            IchijiHanteiKekkaJohoEntity = DbT4116IchijiHanteiKekkaJohoEntityGenerator.createDbT4116IchijiHanteiKekkaJohoEntity();

            sut = new IchijiHanteiKekkaJoho(IchijiHanteiKekkaJohoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(IchijiHanteiKekkaJohoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static IchijiHanteiKekkaJoho sut;

        @BeforeClass
        public static void setUpClass() {
            IchijiHanteiKekkaJohoEntity = DbT4116IchijiHanteiKekkaJohoEntityGenerator.createDbT4116IchijiHanteiKekkaJohoEntity();

            sut = new IchijiHanteiKekkaJoho(IchijiHanteiKekkaJohoEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static IchijiHanteiKekkaJoho sut;
        private static IchijiHanteiKekkaJoho result;

        @BeforeClass
        public static void setUpClass() {
            IchijiHanteiKekkaJohoEntity = DbT4116IchijiHanteiKekkaJohoEntityGenerator.createDbT4116IchijiHanteiKekkaJohoEntity();

        }

        @Test
        public void IchijiHanteiKekkaJohoが保持するDbT4116IchijiHanteiKekkaJohoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりIchijiHanteiKekkaJohoが保持するDbT4116IchijiHanteiKekkaJohoEntityのEntityDataStateがDeletedに指定されたIchijiHanteiKekkaJohoが返る() {
            sut = TestSupport.setStateIchijiHanteiKekkaJoho(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void IchijiHanteiKekkaJohoが保持するDbT4116IchijiHanteiKekkaJohoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりIchijiHanteiKekkaJohoが保持するDbT4116IchijiHanteiKekkaJohoEntityのEntityDataStateがDeletedに指定されたIchijiHanteiKekkaJohoが返る() {
            sut = TestSupport.setStateIchijiHanteiKekkaJoho(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void IchijiHanteiKekkaJohoが保持するDbT4116IchijiHanteiKekkaJohoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりIchijiHanteiKekkaJohoが保持するDbT4116IchijiHanteiKekkaJohoEntityのEntityDataStateがDeletedに指定されたIchijiHanteiKekkaJohoが返る() {
            sut = TestSupport.setStateIchijiHanteiKekkaJoho(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void IchijiHanteiKekkaJohoが保持するDbT4116IchijiHanteiKekkaJohoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateIchijiHanteiKekkaJoho(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static IchijiHanteiKekkaJoho setStateIchijiHanteiKekkaJoho(EntityDataState parentState) {
            IchijiHanteiKekkaJohoEntity.setState(parentState);
            return new IchijiHanteiKekkaJoho(IchijiHanteiKekkaJohoEntity);
        }
    }
}
