/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7002BemmeiNaiyoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link BemmeiNaiyoModel}のテストクラスです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class BemmeiNaiyoModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static BemmeiNaiyoModel sut;

        @BeforeClass
        public static void test() {
            sut = new BemmeiNaiyoModel();
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            sut.set証記載保険者番号(DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_証記載保険者番号);
            assertThat(sut.get証記載保険者番号(), is(DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            sut.set識別コード(DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_識別コード);
            assertThat(sut.get識別コード(), is(DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の原処分被保険者番号は_設定した値と同じ原処分被保険者番号を返す() {
            sut.set原処分被保険者番号(DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_原処分被保険者番号);
            assertThat(sut.get原処分被保険者番号(), is(DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_原処分被保険者番号));
        }

        @Test
        public void 戻り値の審査請求届出日は_設定した値と同じ審査請求届出日を返す() {
            sut.set審査請求届出日(DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_審査請求届出日);
            assertThat(sut.get審査請求届出日(), is(DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_審査請求届出日));
        }

        @Test
        public void 戻り値の弁明書作成日は_設定した値と同じ弁明書作成日を返す() {
            sut.set弁明書作成日(DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_弁明書作成日);
            assertThat(sut.get弁明書作成日(), is(DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_弁明書作成日));
        }

        @Test
        public void 戻り値の審査請求に係る処分内容は_設定した値と同じ審査請求に係る処分内容を返す() {
            sut.set審査請求に係る処分内容(DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_審査請求に係る処分内容);
            assertThat(sut.get審査請求に係る処分内容(), is(DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_審査請求に係る処分内容));
        }

        @Test
        public void 戻り値の弁明内容は_設定した値と同じ弁明内容を返す() {
            sut.set弁明内容(DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_弁明内容);
            assertThat(sut.get弁明内容(), is(DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_弁明内容));
        }

        @Test
        public void 戻り値の弁明書作成日提出日は_設定した値と同じ弁明書作成日提出日を返す() {
            sut.set弁明書作成日提出日(DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_弁明書作成日提出日);
            assertThat(sut.get弁明書作成日提出日(), is(DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_弁明書作成日提出日));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            BemmeiNaiyoModel sut = new BemmeiNaiyoModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            BemmeiNaiyoModel sut = new BemmeiNaiyoModel();
            sut.setEntity(DbT7002BemmeiNaiyoEntityGenerator.createDbT7002BemmeiNaiyoEntity());

            sut.getEntity().initializeMd5();

            //TODO  主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            BemmeiNaiyoModel sut = new BemmeiNaiyoModel();
            sut.setEntity(DbT7002BemmeiNaiyoEntityGenerator.createDbT7002BemmeiNaiyoEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            BemmeiNaiyoModel sut = new BemmeiNaiyoModel();
            sut.setEntity(DbT7002BemmeiNaiyoEntityGenerator.createDbT7002BemmeiNaiyoEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
