/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5122TsuchishoHakkoJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5122TsuchishoHakkoJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link TsuchishoHakkoJoho}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class TsuchishoHakkoJohoTest extends DbeTestBase {

    private static DbT5122TsuchishoHakkoJohoEntity TsuchishoHakkoJohoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT5122TsuchishoHakkoJohoEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT5122TsuchishoHakkoJohoEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbeTestBase {

        private static TsuchishoHakkoJoho sut;

        @BeforeClass
        public static void setUpClass() {
            TsuchishoHakkoJohoEntity = DbT5122TsuchishoHakkoJohoEntityGenerator.createDbT5122TsuchishoHakkoJohoEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new TsuchishoHakkoJoho(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new TsuchishoHakkoJoho(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT5122TsuchishoHakkoJohoEntityにセットされている() {
            sut = new TsuchishoHakkoJoho(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するTsuchishoHakkoJohoIdentifierにセットされている() {
            sut = new TsuchishoHakkoJoho(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbeTestBase {

        private static TsuchishoHakkoJoho sut;

        @BeforeClass
        public static void setUpClass() {
            TsuchishoHakkoJohoEntity = DbT5122TsuchishoHakkoJohoEntityGenerator.createDbT5122TsuchishoHakkoJohoEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new TsuchishoHakkoJoho(null);
        }

        @Test
        public void 指定したDbT5122TsuchishoHakkoJohoEntityのキー情報を識別子が持つ() {

            sut = new TsuchishoHakkoJoho(TsuchishoHakkoJohoEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbeTestBase {

        private static TsuchishoHakkoJoho sut;

        @BeforeClass
        public static void setUpClass() {
            TsuchishoHakkoJohoEntity = DbT5122TsuchishoHakkoJohoEntityGenerator.createDbT5122TsuchishoHakkoJohoEntity();

            sut = new TsuchishoHakkoJoho(TsuchishoHakkoJohoEntity);
        }

        @Test
        public void get申請書管理番号は_entityが持つ申請書管理番号を返す() {
            assertThat(sut.get申請書管理番号(), is(TsuchishoHakkoJohoEntity.getShinseishoKanriNo()));
        }

        @Test
        public void get通知区分は_entityが持つ通知区分を返す() {
            assertThat(sut.get通知区分(), is(TsuchishoHakkoJohoEntity.getTsuchiKubun()));
        }

        @Test
        public void get通知理由は_entityが持つ通知理由を返す() {
            assertThat(sut.get通知理由(), is(TsuchishoHakkoJohoEntity.getTsuchiRiyu()));
        }

        @Test
        public void get通知年月日は_entityが持つ通知年月日を返す() {
            assertThat(sut.get通知年月日(), is(TsuchishoHakkoJohoEntity.getTsuchiYMD()));
        }

        @Test
        public void get通知開始年月日は_entityが持つ通知開始年月日を返す() {
            assertThat(sut.get通知開始年月日(), is(TsuchishoHakkoJohoEntity.getTsuchiKaishiYMD()));
        }

        @Test
        public void get通知終了年月日は_entityが持つ通知終了年月日を返す() {
            assertThat(sut.get通知終了年月日(), is(TsuchishoHakkoJohoEntity.getTsuchiShuryoYMD()));
        }

        @Test
        public void get通知区分期限は_entityが持つ通知区分期限を返す() {
            assertThat(sut.get通知区分期限(), is(TsuchishoHakkoJohoEntity.getTsuchiKubunKigenYMD()));
        }

        @Test
        public void get通知完了年月日は_entityが持つ通知完了年月日を返す() {
            assertThat(sut.get通知完了年月日(), is(TsuchishoHakkoJohoEntity.getTsuchiKanryoYMD()));
        }
    }

    public static class toEntityテスト extends DbeTestBase {

        private static TsuchishoHakkoJoho sut;

        @BeforeClass
        public static void setUpClass() {
            TsuchishoHakkoJohoEntity = DbT5122TsuchishoHakkoJohoEntityGenerator.createDbT5122TsuchishoHakkoJohoEntity();

            sut = new TsuchishoHakkoJoho(TsuchishoHakkoJohoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(TsuchishoHakkoJohoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbeTestBase {

        private static TsuchishoHakkoJoho sut;

        @BeforeClass
        public static void setUpClass() {
            TsuchishoHakkoJohoEntity = DbT5122TsuchishoHakkoJohoEntityGenerator.createDbT5122TsuchishoHakkoJohoEntity();

            sut = new TsuchishoHakkoJoho(TsuchishoHakkoJohoEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbeTestBase {

        private static TsuchishoHakkoJoho sut;
        private static TsuchishoHakkoJoho result;

        @BeforeClass
        public static void setUpClass() {
            TsuchishoHakkoJohoEntity = DbT5122TsuchishoHakkoJohoEntityGenerator.createDbT5122TsuchishoHakkoJohoEntity();

        }

        @Test
        public void TsuchishoHakkoJohoが保持するDbT5122TsuchishoHakkoJohoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりTsuchishoHakkoJohoが保持するDbT5122TsuchishoHakkoJohoEntityのEntityDataStateがDeletedに指定されたTsuchishoHakkoJohoが返る() {
            sut = TestSupport.setStateTsuchishoHakkoJoho(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void TsuchishoHakkoJohoが保持するDbT5122TsuchishoHakkoJohoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりTsuchishoHakkoJohoが保持するDbT5122TsuchishoHakkoJohoEntityのEntityDataStateがDeletedに指定されたTsuchishoHakkoJohoが返る() {
            sut = TestSupport.setStateTsuchishoHakkoJoho(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void TsuchishoHakkoJohoが保持するDbT5122TsuchishoHakkoJohoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりTsuchishoHakkoJohoが保持するDbT5122TsuchishoHakkoJohoEntityのEntityDataStateがDeletedに指定されたTsuchishoHakkoJohoが返る() {
            sut = TestSupport.setStateTsuchishoHakkoJoho(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void TsuchishoHakkoJohoが保持するDbT5122TsuchishoHakkoJohoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateTsuchishoHakkoJoho(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static TsuchishoHakkoJoho setStateTsuchishoHakkoJoho(EntityDataState parentState) {
            TsuchishoHakkoJohoEntity.setState(parentState);
            return new TsuchishoHakkoJoho(TsuchishoHakkoJohoEntity);
        }
    }
}
