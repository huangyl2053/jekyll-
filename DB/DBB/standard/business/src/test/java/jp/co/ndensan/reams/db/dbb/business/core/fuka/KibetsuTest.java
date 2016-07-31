/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.fuka;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT2003KibetsuEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static jp.co.ndensan.reams.uz.uza.testhelper.ByteArraySerializations.canBeCopiedBySerialization;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link Kibetsu}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KibetsuTest extends DbbTestBase {

    private static DbT2003KibetsuEntity kibetsuEntity;
    private static FlexibleYear 調定年度;
    private static FlexibleYear 賦課年度;
    private static TsuchishoNo 通知書番号;
    private static int 履歴番号;
    private static RString 徴収方法;
    private static int 期;

    @BeforeClass
    public static void setUpClass() {
        調定年度 = DbT2003KibetsuEntityGenerator.DEFAULT_調定年度;
        賦課年度 = DbT2003KibetsuEntityGenerator.DEFAULT_賦課年度;
        通知書番号 = DbT2003KibetsuEntityGenerator.DEFAULT_通知書番号;
        履歴番号 = DbT2003KibetsuEntityGenerator.DEFAULT_履歴番号;
        徴収方法 = DbT2003KibetsuEntityGenerator.DEFAULT_徴収方法;
        期 = DbT2003KibetsuEntityGenerator.DEFAULT_期;
    }

    public static class 主キーコンストラクタテスト extends DbbTestBase {

        private static Kibetsu sut;

        @BeforeClass
        public static void setUpClass() {
            kibetsuEntity = DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new Kibetsu(null, 賦課年度, 通知書番号, 履歴番号, 徴収方法, 期);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new Kibetsu(調定年度, null, 通知書番号, 履歴番号, 徴収方法, 期);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名3がnullである場合に_NullPointerExceptionが発生する() {
            sut = new Kibetsu(調定年度, 賦課年度, null, 履歴番号, 徴収方法, 期);
        }

//        @Test(expected = NullPointerException.class)
//        public void 主キー名4がnullである場合に_NullPointerExceptionが発生する() {
//            sut = new Kibetsu(調定年度, 賦課年度, 通知書番号, null, 徴収方法, 期);
//        }
        @Test(expected = NullPointerException.class)
        public void 主キー名5がnullである場合に_NullPointerExceptionが発生する() {
            sut = new Kibetsu(調定年度, 賦課年度, 通知書番号, 履歴番号, null, 期);
        }

        @Test
        public void 指定したキーが保持するDbT2003KibetsuEntityにセットされている() {
            sut = new Kibetsu(調定年度, 賦課年度, 通知書番号, 履歴番号, 徴収方法, 期);
            assertThat(sut.get調定年度(), is(調定年度));
            assertThat(sut.get賦課年度(), is(賦課年度));
            assertThat(sut.get通知書番号(), is(通知書番号));
            assertThat(sut.get履歴番号(), is(履歴番号));
            assertThat(sut.get徴収方法(), is(徴収方法));
            assertThat(sut.get期(), is(期));
        }

        @Test
        public void 指定したキーが保持するKibetsuIdentifierにセットされている() {
            sut = new Kibetsu(調定年度, 賦課年度, 通知書番号, 履歴番号, 徴収方法, 期);
            assertThat(sut.identifier().get調定年度(), is(調定年度));
            assertThat(sut.identifier().get賦課年度(), is(賦課年度));
            assertThat(sut.identifier().get通知書番号(), is(通知書番号));
            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
            assertThat(sut.identifier().get徴収方法(), is(徴収方法));
            assertThat(sut.identifier().get期(), is(期));
        }
    }

    public static class Entityコンストラクタテスト extends DbbTestBase {

        private static Kibetsu sut;

        @BeforeClass
        public static void setUpClass() {
            kibetsuEntity = DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new Kibetsu(null);
        }

        @Test
        public void 指定したDbT2003KibetsuEntityのキー情報を識別子が持つ() {

            sut = new Kibetsu(kibetsuEntity);

            assertThat(sut.identifier().get調定年度(), is(調定年度));
            assertThat(sut.identifier().get賦課年度(), is(賦課年度));
            assertThat(sut.identifier().get通知書番号(), is(通知書番号));
            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
            assertThat(sut.identifier().get徴収方法(), is(徴収方法));
            assertThat(sut.identifier().get期(), is(期));
        }
    }

    public static class getterテスト extends DbbTestBase {

        private static Kibetsu sut;

        @BeforeClass
        public static void setUpClass() {
            kibetsuEntity = DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity();

            sut = new Kibetsu(kibetsuEntity);
        }

        @Test
        public void get調定年度は_entityが持つ調定年度を返す() {
            assertThat(sut.get調定年度(), is(kibetsuEntity.getChoteiNendo()));
        }

        @Test
        public void get賦課年度は_entityが持つ賦課年度を返す() {
            assertThat(sut.get賦課年度(), is(kibetsuEntity.getFukaNendo()));
        }

        @Test
        public void get通知書番号は_entityが持つ通知書番号を返す() {
            assertThat(sut.get通知書番号(), is(kibetsuEntity.getTsuchishoNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(kibetsuEntity.getRirekiNo()));
        }

        @Test
        public void get徴収方法は_entityが持つ徴収方法を返す() {
            assertThat(sut.get徴収方法(), is(kibetsuEntity.getChoshuHouhou()));
        }

        @Test
        public void get期は_entityが持つ期を返す() {
            assertThat(sut.get期(), is(kibetsuEntity.getKi()));
        }

        @Test
        public void get調定IDは_entityが持つ調定IDを返す() {
            assertThat(sut.get調定ID(), is(kibetsuEntity.getChoteiId()));
        }
    }

    public static class toEntityテスト extends DbbTestBase {

        private static Kibetsu sut;

        @BeforeClass
        public static void setUpClass() {
            kibetsuEntity = DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity();

            sut = new Kibetsu(kibetsuEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(kibetsuEntity));
        }
    }

    public static class SerializationProxyテスト extends DbbTestBase {

        private static Kibetsu sut;

        @BeforeClass
        public static void setUpClass() {
            kibetsuEntity = DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity();

            sut = new Kibetsu(kibetsuEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(canBeCopiedBySerialization()));
        }
    }

    public static class deletedテスト extends DbbTestBase {

        private static Kibetsu sut;
        private static Kibetsu result;

        @BeforeClass
        public static void setUpClass() {
            kibetsuEntity = DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity();

        }

        @Test
        public void Kibetsuが保持するDbT2003KibetsuEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKibetsuが保持するDbT2003KibetsuEntityのEntityDataStateがDeletedに指定されたKibetsuが返る() {
            sut = TestSupport.setStateKibetsu(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void Kibetsuが保持するDbT2003KibetsuEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKibetsuが保持するDbT2003KibetsuEntityのEntityDataStateがDeletedに指定されたKibetsuが返る() {
            sut = TestSupport.setStateKibetsu(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void Kibetsuが保持するDbT2003KibetsuEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKibetsuが保持するDbT2003KibetsuEntityのEntityDataStateがDeletedに指定されたKibetsuが返る() {
            sut = TestSupport.setStateKibetsu(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void Kibetsuが保持するDbT2003KibetsuEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKibetsu(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static Kibetsu setStateKibetsu(EntityDataState parentState) {
            kibetsuEntity.setState(parentState);
            return new Kibetsu(kibetsuEntity);
        }
    }
}
