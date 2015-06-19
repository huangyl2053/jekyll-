/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT4001JukyushaDaichoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link JukyushaDaichoModel}のテストクラスです。
 *
 * @author n8187 久保田 英男
 */
//TODO n8235 船山洋介 受給者台帳・認定申請結果情報・認定申請情報のテーブルが変更されたため、最新化が必要
//@RunWith(Enclosed.class)
//public class JukyushaDaichoModelTest extends DbzTestBase {
//
//    public static class getterSetterTest extends DbzTestBase {
//
//        private static JukyushaDaichoModel sut;
//
//        @BeforeClass
//        public static void test() {
//            sut = new JukyushaDaichoModel();
//        }
//
//        @Test
//        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
//            sut.set証記載保険者番号(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_証記載保険者番号);
//            assertThat(sut.get証記載保険者番号(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_証記載保険者番号));
//        }
//
//        @Test
//        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
//            sut.set被保険者番号(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_被保険者番号);
//            assertThat(sut.get被保険者番号(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_被保険者番号));
//        }
//
//        @Test
//        public void 戻り値の申請書管理番号は_設定した値と同じ申請書管理番号を返す() {
//            sut.set申請書管理番号(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_申請書管理番号);
//            assertThat(sut.get申請書管理番号(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_申請書管理番号));
//        }
//
//        @Test
//        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
//            sut.set処理日時(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_処理日時);
//            assertThat(sut.get処理日時(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_処理日時));
//        }
//
//        @Test
//        public void 戻り値の支所コードは_設定した値と同じ支所コードを返す() {
//            sut.set支所コード(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_支所コード);
//            assertThat(sut.get支所コード(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_支所コード));
//        }
//
//        @Test
//        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
//            sut.set識別コード(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_識別コード);
//            assertThat(sut.get識別コード(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_識別コード));
//        }
//
//        @Test
//        public void 戻り値の地区コードは_設定した値と同じ地区コードを返す() {
//            sut.set地区コード(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_地区コード);
//            assertThat(sut.get地区コード(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_地区コード));
//        }
//
//        @Test
//        public void 戻り値の喪失年月日は_設定した値と同じ喪失年月日を返す() {
//            sut.set喪失年月日(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_喪失年月日);
//            assertThat(sut.get喪失年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_喪失年月日));
//        }
//
//        @Test
//        public void 戻り値の2号特定疾病コードは_設定した値と同じ2号特定疾病コードを返す() {
//            sut.set2号特定疾病コード(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_2号特定疾病コード);
//            assertThat(sut.get2号特定疾病コード(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_2号特定疾病コード));
//        }
//
//        @Test
//        public void 戻り値の直近異動年月日は_設定した値と同じ直近異動年月日を返す() {
//            sut.set直近異動年月日(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_直近異動年月日);
//            assertThat(sut.get直近異動年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_直近異動年月日));
//        }
//
//        @Test
//        public void 戻り値の直近異動事由コードは_設定した値と同じ直近異動事由コードを返す() {
//            sut.set直近異動事由コード(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_直近異動事由コード);
//            assertThat(sut.get直近異動事由コード(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_直近異動事由コード));
//        }
//
//        @Test
//        public void 戻り値の支給限度単位数は_設定した値と同じ支給限度単位数を返す() {
//            sut.set支給限度単位数(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_支給限度単位数);
//            assertThat(sut.get支給限度単位数(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_支給限度単位数));
//        }
//
//        @Test
//        public void 戻り値の支給限度有効開始年月日は_設定した値と同じ支給限度有効開始年月日を返す() {
//            sut.set支給限度有効開始年月日(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_支給限度有効開始年月日);
//            assertThat(sut.get支給限度有効開始年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_支給限度有効開始年月日));
//        }
//
//        @Test
//        public void 戻り値の支給限度有効終了年月日は_設定した値と同じ支給限度有効終了年月日を返す() {
//            sut.set支給限度有効終了年月日(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_支給限度有効終了年月日);
//            assertThat(sut.get支給限度有効終了年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_支給限度有効終了年月日));
//        }
//
//        @Test
//        public void 戻り値の短期入所支給限度日数は_設定した値と同じ短期入所支給限度日数を返す() {
//            sut.set短期入所支給限度日数(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_短期入所支給限度日数);
//            assertThat(sut.get短期入所支給限度日数(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_短期入所支給限度日数));
//        }
//
//        @Test
//        public void 戻り値の短期入所支給限度開始年月日は_設定した値と同じ短期入所支給限度開始年月日を返す() {
//            sut.set短期入所支給限度開始年月日(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_短期入所支給限度開始年月日);
//            assertThat(sut.get短期入所支給限度開始年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_短期入所支給限度開始年月日));
//        }
//
//        @Test
//        public void 戻り値の短期入所支給限度終了年月日は_設定した値と同じ短期入所支給限度終了年月日を返す() {
//            sut.set短期入所支給限度終了年月日(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_短期入所支給限度終了年月日);
//            assertThat(sut.get短期入所支給限度終了年月日(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_短期入所支給限度終了年月日));
//        }
//
//        @Test
//        public void 戻り値の自動割当除外者区分は_設定した値と同じ自動割当除外者区分を返す() {
//            sut.set自動割当除外者区分(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_自動割当除外者区分);
//            assertThat(sut.get自動割当除外者区分(), is(DbT4001JukyushaDaichoEntityGenerator.DEFAULT_自動割当除外者区分));
//        }
//    }
//
//    public static class getStateTest extends DbzTestBase {
//
//        @Test
//        public void 状態Addedの取得確認() {
//            JukyushaDaichoModel sut = new JukyushaDaichoModel();
//
//            assertThat(sut.getState(), is(EntityDataState.Added));
//        }
//
//        @Test
//        public void 状態Modifinedの取得確認() {
//            JukyushaDaichoModel sut = new JukyushaDaichoModel();
//            sut.setEntity(DbT4001JukyushaDaichoEntityGenerator.createDbT4001JukyushaDaichoEntity());
//
//            sut.getEntity().initializeMd5();
//
//            // 主キー以外の項目を変更してください
//            sut.getEntity().setShikyuGendoTanisu(Decimal.ONE);
//
//            assertThat(sut.getState(), is(EntityDataState.Modified));
//        }
//
//        @Test
//        public void 状態Unchangedの取得確認() {
//            JukyushaDaichoModel sut = new JukyushaDaichoModel();
//            sut.setEntity(DbT4001JukyushaDaichoEntityGenerator.createDbT4001JukyushaDaichoEntity());
//
//            sut.getEntity().initializeMd5();
//
//            assertThat(sut.getState(), is(EntityDataState.Unchanged));
//        }
//
//        @Test
//        public void 状態Deletedの取得確認() {
//            JukyushaDaichoModel sut = new JukyushaDaichoModel();
//            sut.setEntity(DbT4001JukyushaDaichoEntityGenerator.createDbT4001JukyushaDaichoEntity());
//
//            sut.getEntity().initializeMd5();
//
//            sut.setDeletedState(true);
//
//            assertThat(sut.getState(), is(EntityDataState.Deleted));
//        }
//    }
//}
