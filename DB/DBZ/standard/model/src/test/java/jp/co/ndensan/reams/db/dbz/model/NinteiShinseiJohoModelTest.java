/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

//TODO n8235 船山洋介 受給者台帳・認定申請結果情報・認定申請情報のテーブルが変更されたため、最新化が必要
//import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5001NinteiShinseiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link NinteiShinseiJohoModel}のテストクラスです。
 *
 * @author n8187 久保田 英男
 */
//TODO n8235 船山洋介 受給者台帳・認定申請結果情報・認定申請情報のテーブルが変更されたため、最新化が必要
//@RunWith(Enclosed.class)
//public class NinteiShinseiJohoModelTest extends DbzTestBase {
//
//    public static class getterSetterTest extends DbzTestBase {
//
//        private static NinteiShinseiJohoModel sut;
//
//        @BeforeClass
//        public static void test() {
//            sut = new NinteiShinseiJohoModel();
//        }
//
//        @Test
//        public void 戻り値の申請書管理番号は_設定した値と同じ申請書管理番号を返す() {
//            sut.set申請書管理番号(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_申請書管理番号);
//            assertThat(sut.get申請書管理番号(), is(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_申請書管理番号));
//        }
//
//        @Test
//        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
//            sut.set処理日時(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_処理日時);
//            assertThat(sut.get処理日時(), is(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_処理日時));
//        }
//
//        @Test
//        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
//            sut.set証記載保険者番号(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_証記載保険者番号);
//            assertThat(sut.get証記載保険者番号(), is(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_証記載保険者番号));
//        }
//
//        @Test
//        public void 戻り値の支所コードは_設定した値と同じ支所コードを返す() {
//            sut.set支所コード(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_支所コード);
//            assertThat(sut.get支所コード(), is(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_支所コード));
//        }
//
//        @Test
//        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
//            sut.set被保険者番号(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_被保険者番号);
//            assertThat(sut.get被保険者番号(), is(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_被保険者番号));
//        }
//
//        @Test
//        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
//            sut.set識別コード(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_識別コード);
//            assertThat(sut.get識別コード(), is(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_識別コード));
//        }
//
//        @Test
//        public void 戻り値の認定申請年月日は_設定した値と同じ認定申請年月日を返す() {
//            sut.set認定申請年月日(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_認定申請年月日);
//            assertThat(sut.get認定申請年月日(), is(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_認定申請年月日));
//        }
//
//        @Test
//        public void 戻り値の認定申請枝番コードは_設定した値と同じ認定申請枝番コードを返す() {
//            sut.set認定申請枝番コード(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_認定申請枝番コード);
//            assertThat(sut.get認定申請枝番コード(), is(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_認定申請枝番コード));
//        }
//
//        @Test
//        public void 戻り値の認定申請区分申請時コードは_設定した値と同じ認定申請区分申請時コードを返す() {
//            sut.set認定申請区分申請時コード(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_認定申請区分申請時コード);
//            assertThat(sut.get認定申請区分申請時コード(), is(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_認定申請区分申請時コード));
//        }
//
//        @Test
//        public void 戻り値の認定申請区分法令コードは_設定した値と同じ認定申請区分法令コードを返す() {
//            sut.set認定申請区分法令コード(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_認定申請区分法令コード);
//            assertThat(sut.get認定申請区分法令コード(), is(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_認定申請区分法令コード));
//        }
//
//        @Test
//        public void 戻り値の認定申請有効区分は_設定した値と同じ認定申請有効区分を返す() {
//            sut.set認定申請有効区分(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_認定申請有効区分);
//            assertThat(sut.get認定申請有効区分(), is(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_認定申請有効区分));
//        }
//
//        @Test
//        public void 戻り値の要介護申請要支援申請の区分は_設定した値と同じ要介護申請要支援申請の区分を返す() {
//            sut.set要介護申請要支援申請の区分(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_要介護申請要支援申請の区分);
//            assertThat(sut.get要介護申請要支援申請の区分(), is(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_要介護申請要支援申請の区分)
//            );
//        }
//
//        @Test
//        public void 戻り値の認定申請理由は_設定した値と同じ認定申請理由を返す() {
//            sut.set認定申請理由(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_認定申請理由);
//            assertThat(sut.get認定申請理由(), is(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_認定申請理由));
//        }
//
//        @Test
//        public void 戻り値の前回要介護状態区分コードは_設定した値と同じ前回要介護状態区分コードを返す() {
//            sut.set前回要介護状態区分コード(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_前回要介護状態区分コード);
//            assertThat(sut.get前回要介護状態区分コード(), is(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_前回要介護状態区分コード));
//        }
//
//        @Test
//        public void 戻り値の前回認定有効期間は_設定した値と同じ前回認定有効期間を返す() {
//            sut.set前回認定有効期間(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_前回認定有効期間);
//            assertThat(sut.get前回認定有効期間(), is(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_前回認定有効期間));
//        }
//
//        @Test
//        public void 戻り値の情報提供への同意有無は_設定した値と同じ情報提供への同意有無を返す() {
//            sut.set情報提供への同意有無(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_情報提供への同意有無);
//            assertThat(sut.has情報提供への同意(), is(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_情報提供への同意有無));
//        }
//
//        @Test
//        public void 戻り値の認定調査依頼履歴番号は_設定した値と同じ認定調査依頼履歴番号を返す() {
//            sut.set認定調査依頼履歴番号(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_認定調査依頼履歴番号);
//            assertThat(sut.get認定調査依頼履歴番号(), is(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_認定調査依頼履歴番号));
//        }
//
//        @Test
//        public void 戻り値の認定調査識別コードは_設定した値と同じ認定調査識別コードを返す() {
//            sut.set認定調査識別コード(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_認定調査識別コード);
//            assertThat(sut.get認定調査識別コード(), is(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_認定調査識別コード));
//        }
//
//        @Test
//        public void 戻り値の主治医意見書作成依頼履歴番号は_設定した値と同じ主治医意見書作成依頼履歴番号を返す() {
//            sut.set主治医意見書作成依頼履歴番号(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_主治医意見書作成依頼履歴番号);
//            assertThat(sut.get主治医意見書作成依頼履歴番号(), is(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_主治医意見書作成依頼履歴番号));
//        }
//
//        @Test
//        public void 戻り値の介護医療機関コードは_設定した値と同じ介護医療機関コードを返す() {
//            sut.set介護医療機関コード(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_介護医療機関コード);
//            assertThat(sut.get介護医療機関コード(), is(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_介護医療機関コード));
//        }
//
//        @Test
//        public void 戻り値の介護医師コードは_設定した値と同じ介護医師コードを返す() {
//            sut.set介護医師コード(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_介護医師コード);
//            assertThat(sut.get介護医師コード(), is(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_介護医師コード));
//        }
//
//        @Test
//        public void 戻り値のみなし要介護区分コードは_設定した値と同じみなし要介護区分コードを返す() {
//            sut.setみなし要介護区分コード(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_みなし要介護区分コード);
//            assertThat(sut.getみなし要介護区分コード(), is(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_みなし要介護区分コード));
//        }
//
//        @Test
//        public void 戻り値の認定延期通知発行に対する同意有無は_設定した値と同じ認定延期通知発行に対する同意有無を返す() {
//            sut.set認定延期通知発行に対する同意有無(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_認定延期通知発行に対する同意有無);
//            assertThat(sut.has認定延期通知発行に対する同意(), is(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_認定延期通知発行に対する同意有無));
//        }
//
//        @Test
//        public void 戻り値の施設入所の有無は_設定した値と同じ施設入所の有無を返す() {
//            sut.set施設入所の有無(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_施設入所の有無);
//            assertThat(sut.has施設入所(), is(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_施設入所の有無));
//        }
//
//        @Test
//        public void 戻り値の市町村連絡事項は_設定した値と同じ市町村連絡事項を返す() {
//            sut.set市町村連絡事項(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_市町村連絡事項);
//            assertThat(sut.get市町村連絡事項(), is(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_市町村連絡事項));
//        }
//
//        @Test
//        public void 戻り値の取下げ区分コードは_設定した値と同じ取下げ区分コードを返す() {
//            sut.set取下げ区分コード(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_取下げ区分コード);
//            assertThat(sut.get取下げ区分コード(), is(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_取下げ区分コード));
//        }
//
//        @Test
//        public void 戻り値の取下げ理由は_設定した値と同じ取下げ理由を返す() {
//            sut.set取下げ理由(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_取下げ理由);
//            assertThat(sut.get取下げ理由(), is(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_取下げ理由));
//        }
//
//        @Test
//        public void 戻り値の取下げ年月日は_設定した値と同じ取下げ年月日を返す() {
//            sut.set取下げ年月日(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_取下げ年月日);
//            assertThat(sut.get取下げ年月日(), is(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_取下げ年月日));
//        }
//
//        @Test
//        public void 戻り値の審査継続区分は_設定した値と同じ審査継続区分を返す() {
//            sut.set審査継続区分(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_審査継続区分);
//            assertThat(sut.is審査継続(), is(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_審査継続区分));
//        }
//
//        @Test
//        public void 戻り値の要介護認定審査会優先振分区分コードは_設定した値と同じ要介護認定審査会優先振分区分コードを返す() {
//            sut.set要介護認定審査会優先振分区分コード(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_要介護認定審査会優先振分区分コード);
//            assertThat(sut.get要介護認定審査会優先振分区分コード(), is(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_要介護認定審査会優先振分区分コード));
//        }
//
//        @Test
//        public void 戻り値のIF送付年月日は_設定した値と同じIF送付年月日を返す() {
//            sut.setIF送付年月日(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_IF送付年月日);
//            assertThat(sut.getIF送付年月日(), is(DbT5001NinteiShinseiJohoEntityGenerator.DEFAULT_IF送付年月日));
//        }
//    }
//
//    public static class getStateTest extends DbzTestBase {
//
//        @Test
//        public void 状態Addedの取得確認() {
//            NinteiShinseiJohoModel sut = new NinteiShinseiJohoModel();
//
//            assertThat(sut.getState(), is(EntityDataState.Added));
//        }
//
//        @Test
//        public void 状態Modifinedの取得確認() {
//            NinteiShinseiJohoModel sut = new NinteiShinseiJohoModel();
//            sut.setEntity(DbT5001NinteiShinseiJohoEntityGenerator.createDbT5001NinteiShinseiJohoEntity());
//
//            sut.getEntity().initializeMd5();
//
//            // 主キー以外の項目を変更してください
//            sut.getEntity().setMinashiCode(new RString("3"));
//
//            assertThat(sut.getState(), is(EntityDataState.Modified));
//        }
//
//        @Test
//        public void 状態Unchangedの取得確認() {
//            NinteiShinseiJohoModel sut = new NinteiShinseiJohoModel();
//            sut.setEntity(DbT5001NinteiShinseiJohoEntityGenerator.createDbT5001NinteiShinseiJohoEntity());
//
//            sut.getEntity().initializeMd5();
//
//            assertThat(sut.getState(), is(EntityDataState.Unchanged));
//        }
//
//        @Test
//        public void 状態Deletedの取得確認() {
//            NinteiShinseiJohoModel sut = new NinteiShinseiJohoModel();
//            sut.setEntity(DbT5001NinteiShinseiJohoEntityGenerator.createDbT5001NinteiShinseiJohoEntity());
//
//            sut.getEntity().initializeMd5();
//
//            sut.setDeletedState(true);
//
//            assertThat(sut.getState(), is(EntityDataState.Deleted));
//        }
//    }
//}
