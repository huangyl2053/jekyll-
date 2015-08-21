/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5190NinteiSoshinzumiMasterEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5190NinteiSoshinzumiMasterEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
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
 * {@link NinteiSoshinzumiMaster}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NinteiSoshinzumiMasterTest extends DbeTestBase {

    private static DbT5190NinteiSoshinzumiMasterEntity NinteiSoshinzumiMasterEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShinseishoKanriNo 申請書管理番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        申請書管理番号 = DbT5190NinteiSoshinzumiMasterEntityGenerator.DEFAULT_申請書管理番号;
    }

    public static class 主キーコンストラクタテスト extends DbeTestBase {

        private static NinteiSoshinzumiMaster sut;

        @BeforeClass
        public static void setUpClass() {
            NinteiSoshinzumiMasterEntity = DbT5190NinteiSoshinzumiMasterEntityGenerator.createDbT5190NinteiSoshinzumiMasterEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 申請書管理番号がnullである場合に_NullPointerExceptionが発生する() {
            申請書管理番号 = null;
            sut = new NinteiSoshinzumiMaster(申請書管理番号);
        }

        @Test
        public void 指定したキーが保持するDbT5190NinteiSoshinzumiMasterEntityにセットされている() {
            sut = new NinteiSoshinzumiMaster(申請書管理番号);
            assertThat(sut.get申請書管理番号(), is(申請書管理番号));
        }

        @Test
        public void 指定したキーが保持するNinteiSoshinzumiMasterIdentifierにセットされている() {
            sut = new NinteiSoshinzumiMaster(申請書管理番号);
            assertThat(sut.identifier().get申請書管理番号(), is(申請書管理番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbeTestBase {

        private static NinteiSoshinzumiMaster sut;

        @BeforeClass
        public static void setUpClass() {
            NinteiSoshinzumiMasterEntity = DbT5190NinteiSoshinzumiMasterEntityGenerator.createDbT5190NinteiSoshinzumiMasterEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            申請書管理番号 = null;
            sut = new NinteiSoshinzumiMaster(申請書管理番号);
        }

        @Test
        public void 指定したDbT5190NinteiSoshinzumiMasterEntityのキー情報を識別子が持つ() {

            sut = new NinteiSoshinzumiMaster(NinteiSoshinzumiMasterEntity);

            assertThat(sut.identifier().get申請書管理番号(), is(申請書管理番号));
        }
    }

    public static class getterテスト extends DbeTestBase {

        private static NinteiSoshinzumiMaster sut;

        @BeforeClass
        public static void setUpClass() {
            NinteiSoshinzumiMasterEntity = DbT5190NinteiSoshinzumiMasterEntityGenerator.createDbT5190NinteiSoshinzumiMasterEntity();

            sut = new NinteiSoshinzumiMaster(NinteiSoshinzumiMasterEntity);
        }

        @Test
        public void get申請書管理番号は_entityが持つ申請書管理番号を返す() {
            assertThat(sut.get申請書管理番号(), is(NinteiSoshinzumiMasterEntity.getShinseishoKanriNo()));
        }

        @Test
        public void get同一連番は_entityが持つ同一連番を返す() {
            assertThat(sut.get同一連番(), is(NinteiSoshinzumiMasterEntity.getDoitsuRemban()));
        }

        @Test
        public void get引き渡しフラグは_entityが持つ引き渡しフラグを返す() {
            assertThat(sut.get引き渡しフラグ(), is(NinteiSoshinzumiMasterEntity.getIsHikiwatashi()));
        }

        @Test
        public void get引き渡し日時は_entityが持つ引き渡し日時を返す() {
            assertThat(sut.get引き渡し日時(), is(NinteiSoshinzumiMasterEntity.getHikiwatashiYMDHM()));
        }

        @Test
        public void get引き渡し解除日時は_entityが持つ引き渡し解除日時を返す() {
            assertThat(sut.get引き渡し解除日時(), is(NinteiSoshinzumiMasterEntity.getHikiwatashiKaijoYMDHM()));
        }

        @Test
        public void get引き渡しカウントは_entityが持つ引き渡しカウントを返す() {
            assertThat(sut.get引き渡しカウント(), is(NinteiSoshinzumiMasterEntity.getHikiwatashiCount()));
        }

        @Test
        public void get取り込み日時は_entityが持つ取り込み日時を返す() {
            assertThat(sut.get取り込み日時(), is(NinteiSoshinzumiMasterEntity.getTorikomiYMDHM()));
        }

        @Test
        public void get再送付区分は_entityが持つ再送付区分を返す() {
            assertThat(sut.get再送付区分(), is(NinteiSoshinzumiMasterEntity.getSaiSofuKubun()));
        }

        @Test
        public void get再調査送付区分は_entityが持つ再調査送付区分を返す() {
            assertThat(sut.get再調査送付区分(), is(NinteiSoshinzumiMasterEntity.getSaiChosaSofuKubun()));
        }

        @Test
        public void get再意見書送付区分は_entityが持つ再意見書送付区分を返す() {
            assertThat(sut.get再意見書送付区分(), is(NinteiSoshinzumiMasterEntity.getSaiIkenshoSofuKubun()));
        }
    }

    public static class toEntityテスト extends DbeTestBase {

        private static NinteiSoshinzumiMaster sut;

        @BeforeClass
        public static void setUpClass() {
            NinteiSoshinzumiMasterEntity = DbT5190NinteiSoshinzumiMasterEntityGenerator.createDbT5190NinteiSoshinzumiMasterEntity();

            sut = new NinteiSoshinzumiMaster(NinteiSoshinzumiMasterEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(NinteiSoshinzumiMasterEntity));
        }
    }

    public static class SerializationProxyテスト extends DbeTestBase {

        private static NinteiSoshinzumiMaster sut;

        @BeforeClass
        public static void setUpClass() {
            NinteiSoshinzumiMasterEntity = DbT5190NinteiSoshinzumiMasterEntityGenerator.createDbT5190NinteiSoshinzumiMasterEntity();

            sut = new NinteiSoshinzumiMaster(NinteiSoshinzumiMasterEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbeTestBase {

        private static NinteiSoshinzumiMaster sut;
        private static NinteiSoshinzumiMaster result;

        @BeforeClass
        public static void setUpClass() {
            NinteiSoshinzumiMasterEntity = DbT5190NinteiSoshinzumiMasterEntityGenerator.createDbT5190NinteiSoshinzumiMasterEntity();

        }

        @Test
        public void NinteiSoshinzumiMasterが保持するDbT5190NinteiSoshinzumiMasterEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりNinteiSoshinzumiMasterが保持するDbT5190NinteiSoshinzumiMasterEntityのEntityDataStateがDeletedに指定されたNinteiSoshinzumiMasterが返る() {
            sut = TestSupport.setStateNinteiSoshinzumiMaster(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void NinteiSoshinzumiMasterが保持するDbT5190NinteiSoshinzumiMasterEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりNinteiSoshinzumiMasterが保持するDbT5190NinteiSoshinzumiMasterEntityのEntityDataStateがDeletedに指定されたNinteiSoshinzumiMasterが返る() {
            sut = TestSupport.setStateNinteiSoshinzumiMaster(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void NinteiSoshinzumiMasterが保持するDbT5190NinteiSoshinzumiMasterEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりNinteiSoshinzumiMasterが保持するDbT5190NinteiSoshinzumiMasterEntityのEntityDataStateがDeletedに指定されたNinteiSoshinzumiMasterが返る() {
            sut = TestSupport.setStateNinteiSoshinzumiMaster(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void NinteiSoshinzumiMasterが保持するDbT5190NinteiSoshinzumiMasterEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateNinteiSoshinzumiMaster(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static NinteiSoshinzumiMaster setStateNinteiSoshinzumiMaster(EntityDataState parentState) {
            NinteiSoshinzumiMasterEntity.setState(parentState);
            return new NinteiSoshinzumiMaster(NinteiSoshinzumiMasterEntity);
        }
    }
}
