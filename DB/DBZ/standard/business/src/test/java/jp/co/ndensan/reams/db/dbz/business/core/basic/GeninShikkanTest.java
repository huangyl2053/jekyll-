/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5300GeninShikkanEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5300GeninShikkanEntityGenerator;
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
 * {@link GeninShikkan}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class GeninShikkanTest extends DbzTestBase {

    private static DbT5300GeninShikkanEntity GeninShikkanEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShinseishoKanriNo 申請書管理番号;
    private static int 連番;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        申請書管理番号 = DbT5300GeninShikkanEntityGenerator.DEFAULT_申請書管理番号;
        連番 = DbT5300GeninShikkanEntityGenerator.DEFAULT_連番;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static GeninShikkan sut;

        @BeforeClass
        public static void setUpClass() {
            GeninShikkanEntity = DbT5300GeninShikkanEntityGenerator.createDbT5300GeninShikkanEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 申請書管理番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new GeninShikkan(null, 連番);
        }

        @Test
        public void 指定したキーが保持するDbT5300GeninShikkanEntityにセットされている() {
            sut = new GeninShikkan(申請書管理番号, 連番);
            assertThat(sut.get申請書管理番号(), is(申請書管理番号));
            assertThat(sut.get連番(), is(連番));
        }

        @Test
        public void 指定したキーが保持するGeninShikkanIdentifierにセットされている() {
            sut = new GeninShikkan(申請書管理番号, 連番);
            assertThat(sut.identifier().get申請書管理番号(), is(申請書管理番号));
            assertThat(sut.identifier().get連番(), is(連番));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static GeninShikkan sut;

        @BeforeClass
        public static void setUpClass() {
            GeninShikkanEntity = DbT5300GeninShikkanEntityGenerator.createDbT5300GeninShikkanEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new GeninShikkan(null);
        }

        @Test
        public void 指定したDbT5300GeninShikkanEntityのキー情報を識別子が持つ() {

            sut = new GeninShikkan(GeninShikkanEntity);

            assertThat(sut.identifier().get申請書管理番号(), is(申請書管理番号));
            assertThat(sut.identifier().get連番(), is(連番));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static GeninShikkan sut;

        @BeforeClass
        public static void setUpClass() {
            GeninShikkanEntity = DbT5300GeninShikkanEntityGenerator.createDbT5300GeninShikkanEntity();

            sut = new GeninShikkan(GeninShikkanEntity);
        }

        @Test
        public void get申請書管理番号は_entityが持つ申請書管理番号を返す() {
            assertThat(sut.get申請書管理番号(), is(GeninShikkanEntity.getShinseishoKanriNo()));
        }

        @Test
        public void get連番は_entityが持つ連番を返す() {
            assertThat(sut.get連番(), is(GeninShikkanEntity.getRemban()));
        }

        @Test
        public void get主たる原因疾患フラグは_entityが持つ主たる原因疾患フラグを返す() {
            assertThat(sut.get主たる原因疾患フラグ(), is(GeninShikkanEntity.getIsShutaruGeninShikkan()));
        }

        @Test
        public void get原因疾患コードは_entityが持つ原因疾患コードを返す() {
            assertThat(sut.get原因疾患コード(), is(GeninShikkanEntity.getGeninShikkanCode()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static GeninShikkan sut;

        @BeforeClass
        public static void setUpClass() {
            GeninShikkanEntity = DbT5300GeninShikkanEntityGenerator.createDbT5300GeninShikkanEntity();

            sut = new GeninShikkan(GeninShikkanEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(GeninShikkanEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static GeninShikkan sut;

        @BeforeClass
        public static void setUpClass() {
            GeninShikkanEntity = DbT5300GeninShikkanEntityGenerator.createDbT5300GeninShikkanEntity();

            sut = new GeninShikkan(GeninShikkanEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static GeninShikkan sut;
        private static GeninShikkan result;

        @BeforeClass
        public static void setUpClass() {
            GeninShikkanEntity = DbT5300GeninShikkanEntityGenerator.createDbT5300GeninShikkanEntity();

        }

        @Test
        public void GeninShikkanが保持するDbT5300GeninShikkanEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりGeninShikkanが保持するDbT5300GeninShikkanEntityのEntityDataStateがDeletedに指定されたGeninShikkanが返る() {
            sut = TestSupport.setStateGeninShikkan(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void GeninShikkanが保持するDbT5300GeninShikkanEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりGeninShikkanが保持するDbT5300GeninShikkanEntityのEntityDataStateがDeletedに指定されたGeninShikkanが返る() {
            sut = TestSupport.setStateGeninShikkan(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void GeninShikkanが保持するDbT5300GeninShikkanEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりGeninShikkanが保持するDbT5300GeninShikkanEntityのEntityDataStateがDeletedに指定されたGeninShikkanが返る() {
            sut = TestSupport.setStateGeninShikkan(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void GeninShikkanが保持するDbT5300GeninShikkanEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateGeninShikkan(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static GeninShikkan setStateGeninShikkan(EntityDataState parentState) {
            GeninShikkanEntity.setState(parentState);
            return new GeninShikkan(GeninShikkanEntity);
        }
    }
}
