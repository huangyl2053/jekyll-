/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link JutakuKaishuRiyushoTesuryoMeisaiModel}のテストクラスです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class JutakuKaishuRiyushoTesuryoMeisaiModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static JutakuKaishuRiyushoTesuryoMeisaiModel sut;

        @BeforeClass
        public static void test() {
            sut = new JutakuKaishuRiyushoTesuryoMeisaiModel();
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            sut.set証記載保険者番号(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityGenerator.DEFAULT_証記載保険者番号);
            assertThat(sut.get証記載保険者番号(), is(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            sut.set識別コード(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityGenerator.DEFAULT_識別コード);
            assertThat(sut.get識別コード(), is(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値のサービスコードは_設定した値と同じサービスコードを返す() {
            sut.setサービスコード(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityGenerator.DEFAULT_サービスコード);
            assertThat(sut.getサービスコード(), is(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityGenerator.DEFAULT_サービスコード));
        }

        @Test
        public void 戻り値の介護住宅改修事業者名称は_設定した値と同じ介護住宅改修事業者名称を返す() {
            sut.set介護住宅改修事業者名称(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityGenerator.DEFAULT_介護住宅改修事業者名称);
            assertThat(sut.get介護住宅改修事業者名称(), is(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityGenerator.DEFAULT_介護住宅改修事業者名称));
        }

        @Test
        public void 戻り値の介護住宅改修着工年月日は_設定した値と同じ介護住宅改修着工年月日を返す() {
            sut.set介護住宅改修着工年月日(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityGenerator.DEFAULT_介護住宅改修着工年月日);
            assertThat(sut.get介護住宅改修着工年月日(), is(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityGenerator.DEFAULT_介護住宅改修着工年月日));
        }

        @Test
        public void 戻り値の介護住宅改修住宅所有者は_設定した値と同じ介護住宅改修住宅所有者を返す() {
            sut.set介護住宅改修住宅所有者(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityGenerator.DEFAULT_介護住宅改修住宅所有者);
            assertThat(sut.get介護住宅改修住宅所有者(), is(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityGenerator.DEFAULT_介護住宅改修住宅所有者));
        }

        @Test
        public void 戻り値の改修対象住宅住所は_設定した値と同じ改修対象住宅住所を返す() {
            sut.set改修対象住宅住所(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityGenerator.DEFAULT_改修対象住宅住所);
            assertThat(sut.get改修対象住宅住所(), is(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityGenerator.DEFAULT_改修対象住宅住所));
        }

        @Test
        public void 戻り値の改修内容_箇所及び規模は_設定した値と同じ改修内容_箇所及び規模を返す() {
            sut.set改修内容_箇所及び規模(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityGenerator.DEFAULT_改修内容_箇所及び規模);
            assertThat(sut.get改修内容_箇所及び規模(), is(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityGenerator.DEFAULT_改修内容_箇所及び規模));
        }

        @Test
        public void 戻り値の介護住宅改修理由書作成年月日は_設定した値と同じ介護住宅改修理由書作成年月日を返す() {
            sut.set介護住宅改修理由書作成年月日(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityGenerator.DEFAULT_介護住宅改修理由書作成年月日);
            assertThat(sut.get介護住宅改修理由書作成年月日(), is(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityGenerator.DEFAULT_介護住宅改修理由書作成年月日));
        }

        @Test
        public void 戻り値の介護住宅改修理由書作成事業者番号は_設定した値と同じ介護住宅改修理由書作成事業者番号を返す() {
            sut.set介護住宅改修理由書作成事業者番号(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityGenerator.DEFAULT_介護住宅改修理由書作成事業者番号);
            assertThat(sut.get介護住宅改修理由書作成事業者番号(), is(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityGenerator.DEFAULT_介護住宅改修理由書作成事業者番号));
        }

        @Test
        public void 戻り値の介護住宅改修理由書作成者名は_設定した値と同じ介護住宅改修理由書作成者名を返す() {
            sut.set介護住宅改修理由書作成者名(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityGenerator.DEFAULT_介護住宅改修理由書作成者名);
            assertThat(sut.get介護住宅改修理由書作成者名(), is(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityGenerator.DEFAULT_介護住宅改修理由書作成者名));
        }

        @Test
        public void 戻り値の介護住宅改修理由書作成者資格は_設定した値と同じ介護住宅改修理由書作成者資格を返す() {
            sut.set介護住宅改修理由書作成者資格(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityGenerator.DEFAULT_介護住宅改修理由書作成者資格);
            assertThat(sut.get介護住宅改修理由書作成者資格(), is(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityGenerator.DEFAULT_介護住宅改修理由書作成者資格));
        }

        @Test
        public void 戻り値の介護住宅改修理由書作成申請年月日は_設定した値と同じ介護住宅改修理由書作成申請年月日を返す() {
            sut.set介護住宅改修理由書作成申請年月日(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityGenerator.DEFAULT_介護住宅改修理由書作成申請年月日);
            assertThat(sut.get介護住宅改修理由書作成申請年月日(), is(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityGenerator.DEFAULT_介護住宅改修理由書作成申請年月日));
        }

        @Test
        public void 戻り値の介護住宅改修理由書作成受付年月日は_設定した値と同じ介護住宅改修理由書作成受付年月日を返す() {
            sut.set介護住宅改修理由書作成受付年月日(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityGenerator.DEFAULT_介護住宅改修理由書作成受付年月日);
            assertThat(sut.get介護住宅改修理由書作成受付年月日(), is(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityGenerator.DEFAULT_介護住宅改修理由書作成受付年月日));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            JutakuKaishuRiyushoTesuryoMeisaiModel sut = new JutakuKaishuRiyushoTesuryoMeisaiModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            JutakuKaishuRiyushoTesuryoMeisaiModel sut = new JutakuKaishuRiyushoTesuryoMeisaiModel();
            sut.setEntity(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityGenerator.createDbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity());

            sut.getEntity().initializeMd5();

            //TODO  主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            JutakuKaishuRiyushoTesuryoMeisaiModel sut = new JutakuKaishuRiyushoTesuryoMeisaiModel();
            sut.setEntity(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityGenerator.createDbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            JutakuKaishuRiyushoTesuryoMeisaiModel sut = new JutakuKaishuRiyushoTesuryoMeisaiModel();
            sut.setEntity(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityGenerator.createDbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
