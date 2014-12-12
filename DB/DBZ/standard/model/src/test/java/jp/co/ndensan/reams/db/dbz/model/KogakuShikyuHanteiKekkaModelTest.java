/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3057KogakuShikyuHanteiKekkaEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KogakuShikyuHanteiKekkaModel}のテストクラスです。
 *
 * @author LDNS 周杏月
 */
@RunWith(Enclosed.class)
public class KogakuShikyuHanteiKekkaModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KogakuShikyuHanteiKekkaModel sut;

        @BeforeClass
        public static void test() {
            sut = new KogakuShikyuHanteiKekkaModel();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            sut.setサービス提供年月(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_サービス提供年月);
            assertThat(sut.getサービス提供年月(), is(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            sut.set証記載保険者番号(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_証記載保険者番号);
            assertThat(sut.get証記載保険者番号(), is(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の決定年月日は_設定した値と同じ決定年月日を返す() {
            sut.set決定年月日(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_決定年月日);
            assertThat(sut.get決定年月日(), is(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_決定年月日));
        }

        @Test
        public void 戻り値の本人支払額は_設定した値と同じ本人支払額を返す() {
            sut.set本人支払額(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_本人支払額);
            assertThat(sut.get本人支払額(), is(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_本人支払額));
        }

        @Test
        public void 戻り値の支給区分コードは_設定した値と同じ支給区分コードを返す() {
            sut.set支給区分コード(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_支給区分コード);
            assertThat(sut.get支給区分コード(), is(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_支給区分コード));
        }

        @Test
        public void 戻り値の支給金額は_設定した値と同じ支給金額を返す() {
            sut.set支給金額(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_支給金額);
            assertThat(sut.get支給金額(), is(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_支給金額));
        }

        @Test
        public void 戻り値の不支給理由は_設定した値と同じ不支給理由を返す() {
            sut.set不支給理由(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_不支給理由);
            assertThat(sut.get不支給理由(), is(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_不支給理由));
        }

        @Test
        public void 戻り値の支払方法区分コードは_設定した値と同じ支払方法区分コードを返す() {
            sut.set支払方法区分コード(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_支払方法区分コード);
            assertThat(sut.get支払方法区分コード(), is(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_支払方法区分コード));
        }

        @Test
        public void 戻り値の支払場所は_設定した値と同じ支払場所を返す() {
            sut.set支払場所(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_支払場所);
            assertThat(sut.get支払場所(), is(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_支払場所));
        }

        @Test
        public void 戻り値の支払期間開始年月日は_設定した値と同じ支払期間開始年月日を返す() {
            sut.set支払期間開始年月日(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_支払期間開始年月日);
            assertThat(sut.get支払期間開始年月日(), is(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_支払期間開始年月日));
        }

        @Test
        public void 戻り値の支払期間終了年月日は_設定した値と同じ支払期間終了年月日を返す() {
            sut.set支払期間終了年月日(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_支払期間終了年月日);
            assertThat(sut.get支払期間終了年月日(), is(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_支払期間終了年月日));
        }

        @Test
        public void 戻り値の閉庁内容は_設定した値と同じ閉庁内容を返す() {
            sut.set閉庁内容(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_閉庁内容);
            assertThat(sut.get閉庁内容(), is(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_閉庁内容));
        }

        @Test
        public void 戻り値の支払窓口開始時間は_設定した値と同じ支払窓口開始時間を返す() {
            sut.set支払窓口開始時間(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_支払窓口開始時間);
            assertThat(sut.get支払窓口開始時間(), is(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_支払窓口開始時間));
        }

        @Test
        public void 戻り値の支払窓口終了時間は_設定した値と同じ支払窓口終了時間を返す() {
            sut.set支払窓口終了時間(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_支払窓口終了時間);
            assertThat(sut.get支払窓口終了時間(), is(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_支払窓口終了時間));
        }

        @Test
        public void 戻り値の受領委任契約番号は_設定した値と同じ受領委任契約番号を返す() {
            sut.set受領委任契約番号(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_受領委任契約番号);
            assertThat(sut.get受領委任契約番号(), is(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_受領委任契約番号));
        }

        @Test
        public void 戻り値の審査方法区分は_設定した値と同じ審査方法区分を返す() {
            sut.set審査方法区分(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_審査方法区分);
            assertThat(sut.get審査方法区分(), is(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_審査方法区分));
        }

        @Test
        public void 戻り値の判定結果送付年月は_設定した値と同じ判定結果送付年月を返す() {
            sut.set判定結果送付年月(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_判定結果送付年月);
            assertThat(sut.get判定結果送付年月(), is(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_判定結果送付年月));
        }

        @Test
        public void 戻り値の再送付フラグは_設定した値と同じ再送付フラグを返す() {
            sut.set再送付フラグ(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_再送付フラグ);
            assertThat(sut.get再送付フラグ(), is(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_再送付フラグ));
        }

        @Test
        public void 戻り値の判定結果送付不要フラグは_設定した値と同じ判定結果送付不要フラグを返す() {
            sut.set判定結果送付不要フラグ(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_判定結果送付不要フラグ);
            assertThat(sut.get判定結果送付不要フラグ(), is(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_判定結果送付不要フラグ));
        }

        @Test
        public void 戻り値の審査結果反映区分は_設定した値と同じ審査結果反映区分を返す() {
            sut.set審査結果反映区分(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_審査結果反映区分);
            assertThat(sut.get審査結果反映区分(), is(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_審査結果反映区分));
        }

        @Test
        public void 戻り値の決定通知書作成年月日は_設定した値と同じ決定通知書作成年月日を返す() {
            sut.set決定通知書作成年月日(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_決定通知書作成年月日);
            assertThat(sut.get決定通知書作成年月日(), is(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_決定通知書作成年月日));
        }

        @Test
        public void 戻り値の振込明細書作成年月日は_設定した値と同じ振込明細書作成年月日を返す() {
            sut.set振込明細書作成年月日(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_振込明細書作成年月日);
            assertThat(sut.get振込明細書作成年月日(), is(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_振込明細書作成年月日));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KogakuShikyuHanteiKekkaModel sut = new KogakuShikyuHanteiKekkaModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

       // @Test
        // public void 状態Modifinedの取得確認() {
        // KogakuShikyuHanteiKekkaModel sut = new KogakuShikyuHanteiKekkaModel();
        //sut.setEntity(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.createDbT3057KogakuShikyuHanteiKekkaEntity());
           // sut.getEntity().initializeMd5();
            // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
            //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            KogakuShikyuHanteiKekkaModel sut = new KogakuShikyuHanteiKekkaModel();
            sut.setEntity(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.createDbT3057KogakuShikyuHanteiKekkaEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KogakuShikyuHanteiKekkaModel sut = new KogakuShikyuHanteiKekkaModel();
            sut.setEntity(DbT3057KogakuShikyuHanteiKekkaEntityGenerator.createDbT3057KogakuShikyuHanteiKekkaEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
