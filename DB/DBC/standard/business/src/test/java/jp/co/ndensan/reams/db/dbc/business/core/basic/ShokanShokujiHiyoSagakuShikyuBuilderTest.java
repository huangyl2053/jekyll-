/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

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
 * {@link ShokanShokujiHiyoSagakuShikyuBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShokanShokujiHiyoSagakuShikyuBuilderTest extends DbcTestBase {

    private static DbT3044ShokanShokujiHiyoSagakuShikyuEntity ShokanShokujiHiyoSagakuShikyuEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends FdaTestBase {

        private static ShokanShokujiHiyoSagakuShikyuBuilder sut;
        private static ShokanShokujiHiyoSagakuShikyu business;

        @Before
        public void setUp() {
            ShokanShokujiHiyoSagakuShikyuEntity = new DbT3044ShokanShokujiHiyoSagakuShikyuEntity();
            ShokanShokujiHiyoSagakuShikyuEntity.setXXX(主キー名1);
            ShokanShokujiHiyoSagakuShikyuEntity.setXXX(主キー名2);

            business = new ShokanShokujiHiyoSagakuShikyu(ShokanShokujiHiyoSagakuShikyuEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。
        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            business = sut.setサービス提供年月(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_サービス提供年月).build();
            assertThat(business.getサービス提供年月(), is(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            business = sut.set整理番号(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_整理番号).build();
            assertThat(business.get整理番号(), is(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の事業者番号は_設定した値と同じ事業者番号を返す() {
            business = sut.set事業者番号(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_事業者番号).build();
            assertThat(business.get事業者番号(), is(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_事業者番号));
        }

        @Test
        public void 戻り値の様式番号は_設定した値と同じ様式番号を返す() {
            business = sut.set様式番号(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_様式番号).build();
            assertThat(business.get様式番号(), is(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_様式番号));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の差額金額は_設定した値と同じ差額金額を返す() {
            business = sut.set差額金額(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_差額金額).build();
            assertThat(business.get差額金額(), is(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_差額金額));
        }

        @Test
        public void 戻り値の支給区分コードは_設定した値と同じ支給区分コードを返す() {
            business = sut.set支給区分コード(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_支給区分コード).build();
            assertThat(business.get支給区分コード(), is(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_支給区分コード));
        }

        @Test
        public void 戻り値の点数／金額は_設定した値と同じ点数／金額を返す() {
            business = sut.set点数／金額(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_点数／金額).build();
            assertThat(business.get点数／金額(), is(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_点数／金額));
        }

        @Test
        public void 戻り値の支給金額は_設定した値と同じ支給金額を返す() {
            business = sut.set支給金額(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_支給金額).build();
            assertThat(business.get支給金額(), is(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_支給金額));
        }

        @Test
        public void 戻り値の支給・不支給理由は_設定した値と同じ支給・不支給理由を返す() {
            business = sut.set支給・不支給理由(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_支給・不支給理由).build();
            assertThat(business.get支給・不支給理由(), is(DbT3044ShokanShokujiHiyoSagakuShikyuEntityGenerator.DEFAULT_支給・不支給理由));
        }

    }
}
