/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1006KyokaisoGaitoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyokaisoGaitoshaModel}のテストクラスです。
 *
 * @author LDNS 鄭雪双
 */
@RunWith(Enclosed.class)
public class KyokaisoGaitoshaModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KyokaisoGaitoshaModel sut;

        @BeforeClass
        public static void test() {
            sut = new KyokaisoGaitoshaModel();
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            sut.set証記載保険者番号(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_証記載保険者番号);
            assertThat(sut.get証記載保険者番号(), is(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の境界層措置決定年月日は_設定した値と同じ境界層措置決定年月日を返す() {
            sut.set境界層措置決定年月日(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_境界層措置決定年月日);
            assertThat(sut.get境界層措置決定年月日(), is(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_境界層措置決定年月日));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の適用開始年月日は_設定した値と同じ適用開始年月日を返す() {
            sut.set適用開始年月日(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_適用開始年月日);
            assertThat(sut.get適用開始年月日(), is(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_適用開始年月日));
        }

        @Test
        public void 戻り値の適用終了年月日は_設定した値と同じ適用終了年月日を返す() {
            sut.set適用終了年月日(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_適用終了年月日);
            assertThat(sut.get適用終了年月日(), is(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_適用終了年月日));
        }

        @Test
        public void 戻り値の給付額減額記載解除フラグは_設定した値と同じ給付額減額記載解除フラグを返す() {
            sut.set給付額減額記載解除フラグ(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_給付額減額記載解除フラグ);
            assertThat(sut.get給付額減額記載解除フラグ(), is(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_給付額減額記載解除フラグ));
        }

        @Test
        public void 戻り値の標準負担額額該当フラグは_設定した値と同じ標準負担額額該当フラグを返す() {
            sut.set標準負担額額該当フラグ(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_標準負担額額該当フラグ);
            assertThat(sut.get標準負担額額該当フラグ(), is(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_標準負担額額該当フラグ));
        }

        @Test
        public void 戻り値の標準負担軽減後負担額は_設定した値と同じ標準負担軽減後負担額を返す() {
            sut.set標準負担軽減後負担額(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_標準負担軽減後負担額);
            assertThat(sut.get標準負担軽減後負担額(), is(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_標準負担軽減後負担額));
        }

        @Test
        public void 戻り値の居住費等負担額減額該当フラグは_設定した値と同じ居住費等負担額減額該当フラグを返す() {
            sut.set居住費等負担額減額該当フラグ(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_居住費等負担額減額該当フラグ);
            assertThat(sut.get居住費等負担額減額該当フラグ(), is(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_居住費等負担額減額該当フラグ));
        }

        @Test
        public void 戻り値の居住費軽減後居室種類コードは_設定した値と同じ居住費軽減後居室種類コードを返す() {
            sut.set居住費軽減後居室種類コード(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_居住費軽減後居室種類コード);
            assertThat(sut.get居住費軽減後居室種類コード(), is(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_居住費軽減後居室種類コード));
        }

        @Test
        public void 戻り値の居住費軽減後負担額は_設定した値と同じ居住費軽減後負担額を返す() {
            sut.set居住費軽減後負担額(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_居住費軽減後負担額);
            assertThat(sut.get居住費軽減後負担額(), is(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_居住費軽減後負担額));
        }

        @Test
        public void 戻り値の食費負担額減額該当フラグは_設定した値と同じ食費負担額減額該当フラグを返す() {
            sut.set食費負担額減額該当フラグ(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_食費負担額減額該当フラグ);
            assertThat(sut.get食費負担額減額該当フラグ(), is(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_食費負担額減額該当フラグ));
        }

        @Test
        public void 戻り値の食費軽減後負担額は_設定した値と同じ食費軽減後負担額を返す() {
            sut.set食費軽減後負担額(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_食費軽減後負担額);
            assertThat(sut.get食費軽減後負担額(), is(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_食費軽減後負担額));
        }

        @Test
        public void 戻り値の高額ｻｰﾋﾞｽ費上限額減額該当フラグは_設定した値と同じ高額ｻｰﾋﾞｽ費上限額減額該当フラグを返す() {
            sut.set高額ｻｰﾋﾞｽ費上限額減額該当フラグ(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_高額ｻｰﾋﾞｽ費上限額減額該当フラグ);
            assertThat(sut.get高額ｻｰﾋﾞｽ費上限額減額該当フラグ(), is(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_高額ｻｰﾋﾞｽ費上限額減額該当フラグ));
        }

        @Test
        public void 戻り値の高額ｻｰﾋﾞｽ費減額後上限額は_設定した値と同じ高額ｻｰﾋﾞｽ費減額後上限額を返す() {
            sut.set高額ｻｰﾋﾞｽ費減額後上限額(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_高額ｻｰﾋﾞｽ費減額後上限額);
            assertThat(sut.get高額ｻｰﾋﾞｽ費減額後上限額(), is(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_高額ｻｰﾋﾞｽ費減額後上限額));
        }

        @Test
        public void 戻り値の保険料納付減額フラグは_設定した値と同じ保険料納付減額フラグを返す() {
            sut.set保険料納付減額フラグ(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_保険料納付減額フラグ);
            assertThat(sut.get保険料納付減額フラグ(), is(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_保険料納付減額フラグ));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KyokaisoGaitoshaModel sut = new KyokaisoGaitoshaModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            KyokaisoGaitoshaModel sut = new KyokaisoGaitoshaModel();
            sut.setEntity(DbT1006KyokaisoGaitoshaEntityGenerator.createDbT1006KyokaisoGaitoshaEntity());

            sut.getEntity().initializeMd5();

            // 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            KyokaisoGaitoshaModel sut = new KyokaisoGaitoshaModel();
            sut.setEntity(DbT1006KyokaisoGaitoshaEntityGenerator.createDbT1006KyokaisoGaitoshaEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KyokaisoGaitoshaModel sut = new KyokaisoGaitoshaModel();
            sut.setEntity(DbT1006KyokaisoGaitoshaEntityGenerator.createDbT1006KyokaisoGaitoshaEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
