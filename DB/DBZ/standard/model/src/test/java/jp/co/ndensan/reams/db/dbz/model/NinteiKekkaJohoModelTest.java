/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5002NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5002NinteiKekkaJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link NinteiKekkaJohoModel}のテストクラスです。
 *
 * @author n8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class NinteiKekkaJohoModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static NinteiKekkaJohoModel sut;

        @BeforeClass
        public static void test() {
            sut = new NinteiKekkaJohoModel();
        }

        @Test
        public void 戻り値の申請書管理番号は_設定した値と同じ申請書管理番号を返す() {
            sut.set申請書管理番号(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_申請書管理番号);
            assertThat(sut.get申請書管理番号(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_申請書管理番号));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            sut.set証記載保険者番号(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_証記載保険者番号);
            assertThat(sut.get証記載保険者番号(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の要介護度認定年月日は_設定した値と同じ要介護度認定年月日を返す() {
            sut.set要介護度認定年月日(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_要介護度認定年月日);
            assertThat(sut.get要介護度認定年月日(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_要介護度認定年月日));
        }

        @Test
        public void 戻り値の要介護状態区分コードは_設定した値と同じ要介護状態区分コードを返す() {
            sut.set要介護状態区分コード(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_要介護状態区分コード);
            assertThat(sut.get要介護状態区分コード(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_要介護状態区分コード));
        }

        @Test
        public void 戻り値の認定有効期間は_設定した値と同じ認定有効期間を返す() {
            sut.set認定有効期間(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_認定有効期間);
            assertThat(sut.get認定有効期間(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_認定有効期間));
        }

        @Test
        public void 戻り値の認定有効期間開始年月日は_設定した値と同じ認定有効期間開始年月日を返す() {
            sut.set認定有効期間開始年月日(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_認定有効期間開始年月日);
            assertThat(sut.get認定有効期間開始年月日(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_認定有効期間開始年月日));
        }

        @Test
        public void 戻り値の認定有効期間終了年月日は_設定した値と同じ認定有効期間終了年月日を返す() {
            sut.set認定有効期間終了年月日(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_認定有効期間終了年月日);
            assertThat(sut.get認定有効期間終了年月日(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_認定有効期間終了年月日));
        }

        @Test
        public void 戻り値の介護保険の特定疾病コードは_設定した値と同じ介護保険の特定疾病コードを返す() {
            sut.set介護保険の特定疾病コード(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護保険の特定疾病コード);
            assertThat(sut.get介護保険の特定疾病コード(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護保険の特定疾病コード));
        }

        @Test
        public void 戻り値の施設入所の有無は_設定した値と同じ施設入所の有無を返す() {
            sut.set施設入所の有無(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_施設入所の有無);
            assertThat(sut.get施設入所の有無(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_施設入所の有無));
        }

        @Test
        public void 戻り値の介護認定審査会開催番号は_設定した値と同じ介護認定審査会開催番号を返す() {
            sut.set介護認定審査会開催番号(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護認定審査会開催番号);
            assertThat(sut.get介護認定審査会開催番号(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護認定審査会開催番号));
        }

        @Test
        public void 戻り値の介護認定審査会意見は_設定した値と同じ介護認定審査会意見を返す() {
            sut.set介護認定審査会意見(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護認定審査会意見);
            assertThat(sut.get介護認定審査会意見(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護認定審査会意見));
        }

        @Test
        public void 戻り値の一次判定結果変更理由は_設定した値と同じ一次判定結果変更理由を返す() {
            sut.set一次判定結果変更理由(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_一次判定結果変更理由);
            assertThat(sut.get一次判定結果変更理由(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_一次判定結果変更理由));
        }

        @Test
        public void 戻り値の要介護状態像例コードは_設定した値と同じ要介護状態像例コードを返す() {
            sut.set要介護状態像例コード(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_要介護状態像例コード);
            assertThat(sut.get要介護状態像例コード(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_要介護状態像例コード));
        }

        @Test
        public void 戻り値の認定審査会意見種類は_設定した値と同じ認定審査会意見種類を返す() {
            sut.set認定審査会意見種類(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_認定審査会意見種類);
            assertThat(sut.get認定審査会意見種類(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_認定審査会意見種類));
        }

        @Test
        public void 戻り値の介護サービス種類01は_設定した値と同じ介護サービス種類01を返す() {
            sut.set介護サービス種類01(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類01);
            assertThat(sut.get介護サービス種類01(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類01));
        }

        @Test
        public void 戻り値の介護サービス種類02は_設定した値と同じ介護サービス種類02を返す() {
            sut.set介護サービス種類02(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類02);
            assertThat(sut.get介護サービス種類02(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類02));
        }

        @Test
        public void 戻り値の介護サービス種類03は_設定した値と同じ介護サービス種類03を返す() {
            sut.set介護サービス種類03(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類03);
            assertThat(sut.get介護サービス種類03(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類03));
        }

        @Test
        public void 戻り値の介護サービス種類04は_設定した値と同じ介護サービス種類04を返す() {
            sut.set介護サービス種類04(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類04);
            assertThat(sut.get介護サービス種類04(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類04));
        }

        @Test
        public void 戻り値の介護サービス種類05は_設定した値と同じ介護サービス種類05を返す() {
            sut.set介護サービス種類05(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類05);
            assertThat(sut.get介護サービス種類05(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類05));
        }

        @Test
        public void 戻り値の介護サービス種類06は_設定した値と同じ介護サービス種類06を返す() {
            sut.set介護サービス種類06(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類06);
            assertThat(sut.get介護サービス種類06(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類06));
        }

        @Test
        public void 戻り値の介護サービス種類07は_設定した値と同じ介護サービス種類07を返す() {
            sut.set介護サービス種類07(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類07);
            assertThat(sut.get介護サービス種類07(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類07));
        }

        @Test
        public void 戻り値の介護サービス種類08は_設定した値と同じ介護サービス種類08を返す() {
            sut.set介護サービス種類08(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類08);
            assertThat(sut.get介護サービス種類08(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類08));
        }

        @Test
        public void 戻り値の介護サービス種類09は_設定した値と同じ介護サービス種類09を返す() {
            sut.set介護サービス種類09(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類09);
            assertThat(sut.get介護サービス種類09(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類09));
        }

        @Test
        public void 戻り値の介護サービス種類10は_設定した値と同じ介護サービス種類10を返す() {
            sut.set介護サービス種類10(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類10);
            assertThat(sut.get介護サービス種類10(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類10));
        }

        @Test
        public void 戻り値の介護サービス種類11は_設定した値と同じ介護サービス種類11を返す() {
            sut.set介護サービス種類11(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類11);
            assertThat(sut.get介護サービス種類11(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類11));
        }

        @Test
        public void 戻り値の介護サービス種類12は_設定した値と同じ介護サービス種類12を返す() {
            sut.set介護サービス種類12(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類12);
            assertThat(sut.get介護サービス種類12(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類12));
        }

        @Test
        public void 戻り値の介護サービス種類13は_設定した値と同じ介護サービス種類13を返す() {
            sut.set介護サービス種類13(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類13);
            assertThat(sut.get介護サービス種類13(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類13));
        }

        @Test
        public void 戻り値の介護サービス種類14は_設定した値と同じ介護サービス種類14を返す() {
            sut.set介護サービス種類14(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類14);
            assertThat(sut.get介護サービス種類14(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類14));
        }

        @Test
        public void 戻り値の介護サービス種類15は_設定した値と同じ介護サービス種類15を返す() {
            sut.set介護サービス種類15(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類15);
            assertThat(sut.get介護サービス種類15(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類15));
        }

        @Test
        public void 戻り値の介護サービス種類16は_設定した値と同じ介護サービス種類16を返す() {
            sut.set介護サービス種類16(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類16);
            assertThat(sut.get介護サービス種類16(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類16));
        }

        @Test
        public void 戻り値の介護サービス種類17は_設定した値と同じ介護サービス種類17を返す() {
            sut.set介護サービス種類17(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類17);
            assertThat(sut.get介護サービス種類17(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類17));
        }

        @Test
        public void 戻り値の介護サービス種類18は_設定した値と同じ介護サービス種類18を返す() {
            sut.set介護サービス種類18(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類18);
            assertThat(sut.get介護サービス種類18(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類18));
        }

        @Test
        public void 戻り値の介護サービス種類19は_設定した値と同じ介護サービス種類19を返す() {
            sut.set介護サービス種類19(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類19);
            assertThat(sut.get介護サービス種類19(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類19));
        }

        @Test
        public void 戻り値の介護サービス種類20は_設定した値と同じ介護サービス種類20を返す() {
            sut.set介護サービス種類20(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類20);
            assertThat(sut.get介護サービス種類20(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類20));
        }

        @Test
        public void 戻り値の介護サービス種類21は_設定した値と同じ介護サービス種類21を返す() {
            sut.set介護サービス種類21(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類21);
            assertThat(sut.get介護サービス種類21(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類21));
        }

        @Test
        public void 戻り値の介護サービス種類22は_設定した値と同じ介護サービス種類22を返す() {
            sut.set介護サービス種類22(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類22);
            assertThat(sut.get介護サービス種類22(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類22));
        }

        @Test
        public void 戻り値の介護サービス種類23は_設定した値と同じ介護サービス種類23を返す() {
            sut.set介護サービス種類23(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類23);
            assertThat(sut.get介護サービス種類23(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類23));
        }

        @Test
        public void 戻り値の介護サービス種類24は_設定した値と同じ介護サービス種類24を返す() {
            sut.set介護サービス種類24(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類24);
            assertThat(sut.get介護サービス種類24(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類24));
        }

        @Test
        public void 戻り値の介護サービス種類25は_設定した値と同じ介護サービス種類25を返す() {
            sut.set介護サービス種類25(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類25);
            assertThat(sut.get介護サービス種類25(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類25));
        }

        @Test
        public void 戻り値の介護サービス種類26は_設定した値と同じ介護サービス種類26を返す() {
            sut.set介護サービス種類26(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類26);
            assertThat(sut.get介護サービス種類26(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類26));
        }

        @Test
        public void 戻り値の介護サービス種類27は_設定した値と同じ介護サービス種類27を返す() {
            sut.set介護サービス種類27(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類27);
            assertThat(sut.get介護サービス種類27(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類27));
        }

        @Test
        public void 戻り値の介護サービス種類28は_設定した値と同じ介護サービス種類28を返す() {
            sut.set介護サービス種類28(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類28);
            assertThat(sut.get介護サービス種類28(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類28));
        }

        @Test
        public void 戻り値の介護サービス種類29は_設定した値と同じ介護サービス種類29を返す() {
            sut.set介護サービス種類29(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類29);
            assertThat(sut.get介護サービス種類29(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類29));
        }

        @Test
        public void 戻り値の介護サービス種類30は_設定した値と同じ介護サービス種類30を返す() {
            sut.set介護サービス種類30(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類30);
            assertThat(sut.get介護サービス種類30(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_介護サービス種類30));
        }

        @Test
        public void 戻り値の要介護認定結果異動事由は_設定した値と同じ要介護認定結果異動事由を返す() {
            sut.set要介護認定結果異動事由(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_要介護認定結果異動事由);
            assertThat(sut.get要介護認定結果異動事由(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_要介護認定結果異動事由));
        }

        @Test
        public void 戻り値の要介護認定結果異動年月日は_設定した値と同じ要介護認定結果異動年月日を返す() {
            sut.set要介護認定結果異動年月日(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_要介護認定結果異動年月日);
            assertThat(sut.get要介護認定結果異動年月日(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_要介護認定結果異動年月日));
        }

        @Test
        public void 戻り値の要介護認定取消理由は_設定した値と同じ要介護認定取消理由を返す() {
            sut.set要介護認定取消理由(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_要介護認定取消理由);
            assertThat(sut.get要介護認定取消理由(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_要介護認定取消理由));
        }

        @Test
        public void 戻り値の要介護認定取消年月日は_設定した値と同じ要介護認定取消年月日を返す() {
            sut.set要介護認定取消年月日(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_要介護認定取消年月日);
            assertThat(sut.get要介護認定取消年月日(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_要介護認定取消年月日));
        }

        @Test
        public void 戻り値の通知区分は_設定した値と同じ通知区分を返す() {
            sut.set通知区分(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_通知区分);
            assertThat(sut.get通知区分(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_通知区分));
        }

        @Test
        public void 戻り値の認定理由は_設定した値と同じ認定理由を返す() {
            sut.set認定理由(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_認定理由);
            assertThat(sut.get認定理由(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_認定理由));
        }

        @Test
        public void 戻り値の審査会メモは_設定した値と同じ審査会メモを返す() {
            sut.set審査会メモ(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_審査会メモ);
            assertThat(sut.get審査会メモ(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_審査会メモ));
        }

        @Test
        public void 戻り値のIF送付年月日は_設定した値と同じIF送付年月日を返す() {
            sut.setIF送付年月日(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_IF送付年月日);
            assertThat(sut.getIF送付年月日(), is(DbT5002NinteiKekkaJohoEntityGenerator.DEFAULT_IF送付年月日));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            NinteiKekkaJohoModel sut = new NinteiKekkaJohoModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            NinteiKekkaJohoModel sut = new NinteiKekkaJohoModel();
            sut.setEntity(DbT5002NinteiKekkaJohoEntityGenerator.createDbT5002NinteiKekkaJohoEntity());

            sut.getEntity().initializeMd5();

            // 主キー以外の項目を変更してください
            sut.getEntity().setKaigoServiceShurui01(new RString("3"));

            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            NinteiKekkaJohoModel sut = new NinteiKekkaJohoModel();
            sut.setEntity(DbT5002NinteiKekkaJohoEntityGenerator.createDbT5002NinteiKekkaJohoEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            NinteiKekkaJohoModel sut = new NinteiKekkaJohoModel();
            sut.setEntity(DbT5002NinteiKekkaJohoEntityGenerator.createDbT5002NinteiKekkaJohoEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
