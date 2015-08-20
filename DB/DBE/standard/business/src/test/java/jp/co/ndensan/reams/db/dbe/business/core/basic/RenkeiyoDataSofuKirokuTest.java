/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5191RenkeiyoDataSofuKirokuEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5191RenkeiyoDataSofuKirokuEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link RenkeiyoDataSofuKiroku}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class RenkeiyoDataSofuKirokuTest extends DbeTestBase {

    private static DbT5191RenkeiyoDataSofuKirokuEntity RenkeiyoDataSofuKirokuEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShinseishoKanriNo 申請書管理番号;
    private static FlexibleDate 資料作成日;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        申請書管理番号 = DbT5191RenkeiyoDataSofuKirokuEntityGenerator.DEFAULT_申請書管理番号;
        資料作成日 = DbT5191RenkeiyoDataSofuKirokuEntityGenerator.DEFAULT_資料作成日;
    }

    public static class 主キーコンストラクタテスト extends DbeTestBase {

        private static RenkeiyoDataSofuKiroku sut;

        @BeforeClass
        public static void setUpClass() {
            RenkeiyoDataSofuKirokuEntity = DbT5191RenkeiyoDataSofuKirokuEntityGenerator.createDbT5191RenkeiyoDataSofuKirokuEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 申請書管理番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new RenkeiyoDataSofuKiroku(null, 資料作成日);
        }

        @Test(expected = NullPointerException.class)
        public void 資料作成日がnullである場合に_NullPointerExceptionが発生する() {
            sut = new RenkeiyoDataSofuKiroku(申請書管理番号, null);
        }

        @Test
        public void 指定したキーが保持するDbT5191RenkeiyoDataSofuKirokuEntityにセットされている() {
            sut = new RenkeiyoDataSofuKiroku(申請書管理番号, 資料作成日);
            assertThat(sut.get申請書管理番号(), is(申請書管理番号));
            assertThat(sut.get資料作成日(), is(資料作成日));
        }

        @Test
        public void 指定したキーが保持するRenkeiyoDataSofuKirokuIdentifierにセットされている() {
            sut = new RenkeiyoDataSofuKiroku(申請書管理番号, 資料作成日);
            assertThat(sut.identifier().get申請書管理番号(), is(申請書管理番号));
            assertThat(sut.identifier().get資料作成日(), is(資料作成日));
        }
    }

    public static class Entityコンストラクタテスト extends DbeTestBase {

        private static RenkeiyoDataSofuKiroku sut;

        @BeforeClass
        public static void setUpClass() {
            RenkeiyoDataSofuKirokuEntity = DbT5191RenkeiyoDataSofuKirokuEntityGenerator.createDbT5191RenkeiyoDataSofuKirokuEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new RenkeiyoDataSofuKiroku(null);
        }

        @Test
        public void 指定したDbT5191RenkeiyoDataSofuKirokuEntityのキー情報を識別子が持つ() {

            sut = new RenkeiyoDataSofuKiroku(RenkeiyoDataSofuKirokuEntity);

            assertThat(sut.identifier().get申請書管理番号(), is(申請書管理番号));
            assertThat(sut.identifier().get資料作成日(), is(資料作成日));
        }
    }

    public static class getterテスト extends DbeTestBase {

        private static RenkeiyoDataSofuKiroku sut;

        @BeforeClass
        public static void setUpClass() {
            RenkeiyoDataSofuKirokuEntity = DbT5191RenkeiyoDataSofuKirokuEntityGenerator.createDbT5191RenkeiyoDataSofuKirokuEntity();

            sut = new RenkeiyoDataSofuKiroku(RenkeiyoDataSofuKirokuEntity);
        }

        @Test
        public void get申請書管理番号は_entityが持つ申請書管理番号を返す() {
            assertThat(sut.get申請書管理番号(), is(RenkeiyoDataSofuKirokuEntity.getShinseishoKanriNo()));
        }

        @Test
        public void get資料作成日は_entityが持つ資料作成日を返す() {
            assertThat(sut.get資料作成日(), is(RenkeiyoDataSofuKirokuEntity.getShiryoSakuseiYMD()));
        }

        @Test
        public void get引渡し区分は_entityが持つ引渡し区分を返す() {
            assertThat(sut.get引渡し区分(), is(RenkeiyoDataSofuKirokuEntity.getHikiwatashiKubun()));
        }

        @Test
        public void get引渡日時は_entityが持つ引渡日時を返す() {
            assertThat(sut.get引渡日時(), is(RenkeiyoDataSofuKirokuEntity.getHikiwatashiTimeStamp()));
        }

        @Test
        public void get再送付区分は_entityが持つ再送付区分を返す() {
            assertThat(sut.get再送付区分(), is(RenkeiyoDataSofuKirokuEntity.getSaiSoufuKubun()));
        }

        @Test
        public void get再調査送付区分は_entityが持つ再調査送付区分を返す() {
            assertThat(sut.get再調査送付区分(), is(RenkeiyoDataSofuKirokuEntity.getSaiChousaSofuKubun()));
        }

        @Test
        public void get再意見書送付区分は_entityが持つ再意見書送付区分を返す() {
            assertThat(sut.get再意見書送付区分(), is(RenkeiyoDataSofuKirokuEntity.getSaiIkenshoSofuKubun()));
        }

        @Test
        public void get再イメージ送付区分は_entityが持つ再イメージ送付区分を返す() {
            assertThat(sut.get再イメージ送付区分(), is(RenkeiyoDataSofuKirokuEntity.getSaiImageSofuKubun()));
        }

        @Test
        public void get再送信年月日は_entityが持つ再送信年月日を返す() {
            assertThat(sut.get再送信年月日(), is(RenkeiyoDataSofuKirokuEntity.getSaiSoshinYMD()));
        }
    }

    public static class toEntityテスト extends DbeTestBase {

        private static RenkeiyoDataSofuKiroku sut;

        @BeforeClass
        public static void setUpClass() {
            RenkeiyoDataSofuKirokuEntity = DbT5191RenkeiyoDataSofuKirokuEntityGenerator.createDbT5191RenkeiyoDataSofuKirokuEntity();

            sut = new RenkeiyoDataSofuKiroku(RenkeiyoDataSofuKirokuEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(RenkeiyoDataSofuKirokuEntity));
        }
    }

    public static class SerializationProxyテスト extends DbeTestBase {

        private static RenkeiyoDataSofuKiroku sut;

        @BeforeClass
        public static void setUpClass() {
            RenkeiyoDataSofuKirokuEntity = DbT5191RenkeiyoDataSofuKirokuEntityGenerator.createDbT5191RenkeiyoDataSofuKirokuEntity();

            sut = new RenkeiyoDataSofuKiroku(RenkeiyoDataSofuKirokuEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbeTestBase {

        private static RenkeiyoDataSofuKiroku sut;
        private static RenkeiyoDataSofuKiroku result;

        @BeforeClass
        public static void setUpClass() {
            RenkeiyoDataSofuKirokuEntity = DbT5191RenkeiyoDataSofuKirokuEntityGenerator.createDbT5191RenkeiyoDataSofuKirokuEntity();

        }

        @Test
        public void RenkeiyoDataSofuKirokuが保持するDbT5191RenkeiyoDataSofuKirokuEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりRenkeiyoDataSofuKirokuが保持するDbT5191RenkeiyoDataSofuKirokuEntityのEntityDataStateがDeletedに指定されたRenkeiyoDataSofuKirokuが返る() {
            sut = TestSupport.setStateRenkeiyoDataSofuKiroku(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void RenkeiyoDataSofuKirokuが保持するDbT5191RenkeiyoDataSofuKirokuEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりRenkeiyoDataSofuKirokuが保持するDbT5191RenkeiyoDataSofuKirokuEntityのEntityDataStateがDeletedに指定されたRenkeiyoDataSofuKirokuが返る() {
            sut = TestSupport.setStateRenkeiyoDataSofuKiroku(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void RenkeiyoDataSofuKirokuが保持するDbT5191RenkeiyoDataSofuKirokuEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりRenkeiyoDataSofuKirokuが保持するDbT5191RenkeiyoDataSofuKirokuEntityのEntityDataStateがDeletedに指定されたRenkeiyoDataSofuKirokuが返る() {
            sut = TestSupport.setStateRenkeiyoDataSofuKiroku(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void RenkeiyoDataSofuKirokuが保持するDbT5191RenkeiyoDataSofuKirokuEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateRenkeiyoDataSofuKiroku(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static RenkeiyoDataSofuKiroku setStateRenkeiyoDataSofuKiroku(EntityDataState parentState) {
            RenkeiyoDataSofuKirokuEntity.setState(parentState);
            return new RenkeiyoDataSofuKiroku(RenkeiyoDataSofuKirokuEntity);
        }
    }
}
