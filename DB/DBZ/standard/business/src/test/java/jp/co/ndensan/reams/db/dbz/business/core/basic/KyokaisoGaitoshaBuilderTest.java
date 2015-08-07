/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.business.core.KyokaisoGaitosha;
import jp.co.ndensan.reams.db.dbz.business.core.KyokaisoGaitoshaBuilder;
import jp.co.ndensan.reams.fd.fdz.testhelper.FdaTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyokaisoGaitoshaBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyokaisoGaitoshaBuilderTest extends DbzTestBase {

    private static DbT1006KyokaisoGaitoshaEntity KyokaisoGaitoshaEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends FdaTestBase {

        private static KyokaisoGaitoshaBuilder sut;
        private static KyokaisoGaitosha business;

        @Before
        public void setUp() {
            KyokaisoGaitoshaEntity = new DbT1006KyokaisoGaitoshaEntity();
            KyokaisoGaitoshaEntity.setXXX(主キー名1);
            KyokaisoGaitoshaEntity.setXXX(主キー名2);

            business = new KyokaisoGaitosha(KyokaisoGaitoshaEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。
        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の適用開始年月日は_設定した値と同じ適用開始年月日を返す() {
            business = sut.set適用開始年月日(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_適用開始年月日).build();
            assertThat(business.get適用開始年月日(), is(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_適用開始年月日));
        }

        @Test
        public void 戻り値の適用終了年月日は_設定した値と同じ適用終了年月日を返す() {
            business = sut.set適用終了年月日(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_適用終了年月日).build();
            assertThat(business.get適用終了年月日(), is(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_適用終了年月日));
        }

        @Test
        public void 戻り値の境界層措置決定年月日は_設定した値と同じ境界層措置決定年月日を返す() {
            business = sut.set境界層措置決定年月日(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_境界層措置決定年月日).build();
            assertThat(business.get境界層措置決定年月日(), is(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_境界層措置決定年月日));
        }

        @Test
        public void 戻り値の給付額減額記載解除フラグは_設定した値と同じ給付額減額記載解除フラグを返す() {
            business = sut.set給付額減額記載解除フラグ(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_給付額減額記載解除フラグ).build();
            assertThat(business.get給付額減額記載解除フラグ(), is(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_給付額減額記載解除フラグ));
        }

        @Test
        public void 戻り値の標準負担額額該当フラグは_設定した値と同じ標準負担額額該当フラグを返す() {
            business = sut.set標準負担額額該当フラグ(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_標準負担額額該当フラグ).build();
            assertThat(business.get標準負担額額該当フラグ(), is(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_標準負担額額該当フラグ));
        }

        @Test
        public void 戻り値の標準負担軽減後負担額は_設定した値と同じ標準負担軽減後負担額を返す() {
            business = sut.set標準負担軽減後負担額(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_標準負担軽減後負担額).build();
            assertThat(business.get標準負担軽減後負担額(), is(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_標準負担軽減後負担額));
        }

        @Test
        public void 戻り値の居住費等負担額減額該当フラグは_設定した値と同じ居住費等負担額減額該当フラグを返す() {
            business = sut.set居住費等負担額減額該当フラグ(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_居住費等負担額減額該当フラグ).build();
            assertThat(business.get居住費等負担額減額該当フラグ(), is(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_居住費等負担額減額該当フラグ));
        }

        @Test
        public void 戻り値の居住費軽減後居室種類コードは_設定した値と同じ居住費軽減後居室種類コードを返す() {
            business = sut.set居住費軽減後居室種類コード(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_居住費軽減後居室種類コード).build();
            assertThat(business.get居住費軽減後居室種類コード(), is(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_居住費軽減後居室種類コード));
        }

        @Test
        public void 戻り値の居住費軽減後負担額は_設定した値と同じ居住費軽減後負担額を返す() {
            business = sut.set居住費軽減後負担額(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_居住費軽減後負担額).build();
            assertThat(business.get居住費軽減後負担額(), is(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_居住費軽減後負担額));
        }

        @Test
        public void 戻り値の食費負担額減額該当フラグは_設定した値と同じ食費負担額減額該当フラグを返す() {
            business = sut.set食費負担額減額該当フラグ(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_食費負担額減額該当フラグ).build();
            assertThat(business.get食費負担額減額該当フラグ(), is(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_食費負担額減額該当フラグ));
        }

        @Test
        public void 戻り値の食費軽減後負担額は_設定した値と同じ食費軽減後負担額を返す() {
            business = sut.set食費軽減後負担額(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_食費軽減後負担額).build();
            assertThat(business.get食費軽減後負担額(), is(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_食費軽減後負担額));
        }

        @Test
        public void 戻り値の高額ｻｰﾋﾞｽ費上限額減額該当フラグは_設定した値と同じ高額ｻｰﾋﾞｽ費上限額減額該当フラグを返す() {
            business = sut.set高額ｻｰﾋﾞｽ費上限額減額該当フラグ(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_高額ｻｰﾋﾞｽ費上限額減額該当フラグ).build();
            assertThat(business.get高額ｻｰﾋﾞｽ費上限額減額該当フラグ(), is(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_高額ｻｰﾋﾞｽ費上限額減額該当フラグ));
        }

        @Test
        public void 戻り値の高額ｻｰﾋﾞｽ費減額後上限額は_設定した値と同じ高額ｻｰﾋﾞｽ費減額後上限額を返す() {
            business = sut.set高額ｻｰﾋﾞｽ費減額後上限額(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_高額ｻｰﾋﾞｽ費減額後上限額).build();
            assertThat(business.get高額ｻｰﾋﾞｽ費減額後上限額(), is(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_高額ｻｰﾋﾞｽ費減額後上限額));
        }

        @Test
        public void 戻り値の保険料納付減額フラグは_設定した値と同じ保険料納付減額フラグを返す() {
            business = sut.set保険料納付減額フラグ(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_保険料納付減額フラグ).build();
            assertThat(business.get保険料納付減額フラグ(), is(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_保険料納付減額フラグ));
        }

    }
}
