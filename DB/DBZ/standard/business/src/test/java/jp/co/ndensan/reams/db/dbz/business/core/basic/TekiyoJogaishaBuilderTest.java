/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.business.core.TekiyoJogaisha;
import jp.co.ndensan.reams.db.dbz.business.core.TekiyoJogaishaBuilder;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1002TekiyoJogaishaEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1002TekiyoJogaishaEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link TekiyoJogaishaBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class TekiyoJogaishaBuilderTest extends DbzTestBase {

    private static DbT1002TekiyoJogaishaEntity TekiyoJogaishaEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShikibetsuCode 識別コード;
    private static FlexibleDate 異動日;
    private static RString 枝番;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        識別コード = DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_識別コード;
        異動日 = DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_異動日;
        枝番 = DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_枝番;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static TekiyoJogaishaBuilder sut;
        private static TekiyoJogaisha business;

        @Before
        public void setUp() {
            TekiyoJogaishaEntity = new DbT1002TekiyoJogaishaEntity();
            TekiyoJogaishaEntity.setShikibetsuCode(識別コード);
            TekiyoJogaishaEntity.setIdoYMD(異動日);
            TekiyoJogaishaEntity.setEdaNo(枝番);

            business = new TekiyoJogaisha(TekiyoJogaishaEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            business = sut.set識別コード(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_識別コード).build();
            assertThat(business.get識別コード(), is(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の異動日は_設定した値と同じ異動日を返す() {
            business = sut.set異動日(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_異動日).build();
            assertThat(business.get異動日(), is(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_異動日));
        }

        @Test
        public void 戻り値の枝番は_設定した値と同じ枝番を返す() {
            business = sut.set枝番(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_枝番).build();
            assertThat(business.get枝番(), is(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_枝番));
        }

        @Test
        public void 戻り値の異動事由コードは_設定した値と同じ異動事由コードを返す() {
            business = sut.set異動事由コード(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_異動事由コード).build();
            assertThat(business.get異動事由コード(), is(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_異動事由コード));
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            business = sut.set市町村コード(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_市町村コード).build();
            assertThat(business.get市町村コード(), is(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の適用除外適用事由コードは_設定した値と同じ適用除外適用事由コードを返す() {
            business = sut.set適用除外適用事由コード(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_適用除外適用事由コード).build();
            assertThat(business.get適用除外適用事由コード(), is(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_適用除外適用事由コード));
        }

        @Test
        public void 戻り値の適用年月日は_設定した値と同じ適用年月日を返す() {
            business = sut.set適用年月日(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_適用年月日).build();
            assertThat(business.get適用年月日(), is(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_適用年月日));
        }

        @Test
        public void 戻り値の適用届出年月日は_設定した値と同じ適用届出年月日を返す() {
            business = sut.set適用届出年月日(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_適用届出年月日).build();
            assertThat(business.get適用届出年月日(), is(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_適用届出年月日));
        }

        @Test
        public void 戻り値の適用受付年月日は_設定した値と同じ適用受付年月日を返す() {
            business = sut.set適用受付年月日(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_適用受付年月日).build();
            assertThat(business.get適用受付年月日(), is(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_適用受付年月日));
        }

        @Test
        public void 戻り値の適用除外解除事由コードは_設定した値と同じ適用除外解除事由コードを返す() {
            business = sut.set適用除外解除事由コード(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_適用除外解除事由コード).build();
            assertThat(business.get適用除外解除事由コード(), is(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_適用除外解除事由コード));
        }

        @Test
        public void 戻り値の解除年月日は_設定した値と同じ解除年月日を返す() {
            business = sut.set解除年月日(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_解除年月日).build();
            assertThat(business.get解除年月日(), is(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_解除年月日));
        }

        @Test
        public void 戻り値の解除届出年月日は_設定した値と同じ解除届出年月日を返す() {
            business = sut.set解除届出年月日(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_解除届出年月日).build();
            assertThat(business.get解除届出年月日(), is(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_解除届出年月日));
        }

        @Test
        public void 戻り値の解除受付年月日は_設定した値と同じ解除受付年月日を返す() {
            business = sut.set解除受付年月日(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_解除受付年月日).build();
            assertThat(business.get解除受付年月日(), is(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_解除受付年月日));
        }

        @Test
        public void 戻り値の入所通知発行日は_設定した値と同じ入所通知発行日を返す() {
            business = sut.set入所通知発行日(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_入所通知発行日).build();
            assertThat(business.get入所通知発行日(), is(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_入所通知発行日));
        }

        @Test
        public void 戻り値の退所通知発行日は_設定した値と同じ退所通知発行日を返す() {
            business = sut.set退所通知発行日(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_退所通知発行日).build();
            assertThat(business.get退所通知発行日(), is(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_退所通知発行日));
        }

        @Test
        public void 戻り値の変更通知発行日は_設定した値と同じ変更通知発行日を返す() {
            business = sut.set変更通知発行日(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_変更通知発行日).build();
            assertThat(business.get変更通知発行日(), is(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_変更通知発行日));
        }

        @Test
        public void 戻り値の論理削除フラグは_設定した値と同じ論理削除フラグを返す() {
            business = sut.set論理削除フラグ(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_論理削除フラグ).build();
            assertThat(business.get論理削除フラグ(), is(DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_論理削除フラグ));
        }

    }
}
