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
 * {@link ShokanFukushiYoguHanbaihiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShokanFukushiYoguHanbaihiBuilderTest extends DbcTestBase {

    private static DbT3048ShokanFukushiYoguHanbaihiEntity ShokanFukushiYoguHanbaihiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends FdaTestBase {

        private static ShokanFukushiYoguHanbaihiBuilder sut;
        private static ShokanFukushiYoguHanbaihi business;

        @Before
        public void setUp() {
            ShokanFukushiYoguHanbaihiEntity = new DbT3048ShokanFukushiYoguHanbaihiEntity();
            ShokanFukushiYoguHanbaihiEntity.setXXX(主キー名1);
            ShokanFukushiYoguHanbaihiEntity.setXXX(主キー名2);

            business = new ShokanFukushiYoguHanbaihi(ShokanFukushiYoguHanbaihiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。
        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            business = sut.setサービス提供年月(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_サービス提供年月).build();
            assertThat(business.getサービス提供年月(), is(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            business = sut.set整理番号(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_整理番号).build();
            assertThat(business.get整理番号(), is(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の事業者番号は_設定した値と同じ事業者番号を返す() {
            business = sut.set事業者番号(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_事業者番号).build();
            assertThat(business.get事業者番号(), is(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_事業者番号));
        }

        @Test
        public void 戻り値の様式番号は_設定した値と同じ様式番号を返す() {
            business = sut.set様式番号(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_様式番号).build();
            assertThat(business.get様式番号(), is(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_様式番号));
        }

        @Test
        public void 戻り値の順次番号は_設定した値と同じ順次番号を返す() {
            business = sut.set順次番号(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_順次番号).build();
            assertThat(business.get順次番号(), is(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_順次番号));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値のサービスコードは_設定した値と同じサービスコードを返す() {
            business = sut.setサービスコード(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_サービスコード).build();
            assertThat(business.getサービスコード(), is(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_サービスコード));
        }

        @Test
        public void 戻り値の福祉用具販売年月日は_設定した値と同じ福祉用具販売年月日を返す() {
            business = sut.set福祉用具販売年月日(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_福祉用具販売年月日).build();
            assertThat(business.get福祉用具販売年月日(), is(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_福祉用具販売年月日));
        }

        @Test
        public void 戻り値の福祉用具商品名は_設定した値と同じ福祉用具商品名を返す() {
            business = sut.set福祉用具商品名(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_福祉用具商品名).build();
            assertThat(business.get福祉用具商品名(), is(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_福祉用具商品名));
        }

        @Test
        public void 戻り値の福祉用具種目コードは_設定した値と同じ福祉用具種目コードを返す() {
            business = sut.set福祉用具種目コード(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_福祉用具種目コード).build();
            assertThat(business.get福祉用具種目コード(), is(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_福祉用具種目コード));
        }

        @Test
        public void 戻り値の福祉用具製造事業者名は_設定した値と同じ福祉用具製造事業者名を返す() {
            business = sut.set福祉用具製造事業者名(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_福祉用具製造事業者名).build();
            assertThat(business.get福祉用具製造事業者名(), is(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_福祉用具製造事業者名));
        }

        @Test
        public void 戻り値の福祉用具販売事業者名は_設定した値と同じ福祉用具販売事業者名を返す() {
            business = sut.set福祉用具販売事業者名(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_福祉用具販売事業者名).build();
            assertThat(business.get福祉用具販売事業者名(), is(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_福祉用具販売事業者名));
        }

        @Test
        public void 戻り値の購入金額は_設定した値と同じ購入金額を返す() {
            business = sut.set購入金額(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_購入金額).build();
            assertThat(business.get購入金額(), is(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_購入金額));
        }

        @Test
        public void 戻り値の品目コードは_設定した値と同じ品目コードを返す() {
            business = sut.set品目コード(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_品目コード).build();
            assertThat(business.get品目コード(), is(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_品目コード));
        }

        @Test
        public void 戻り値の審査方法区分コードは_設定した値と同じ審査方法区分コードを返す() {
            business = sut.set審査方法区分コード(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_審査方法区分コード).build();
            assertThat(business.get審査方法区分コード(), is(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_審査方法区分コード));
        }

        @Test
        public void 戻り値の差額金額は_設定した値と同じ差額金額を返す() {
            business = sut.set差額金額(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_差額金額).build();
            assertThat(business.get差額金額(), is(DbT3048ShokanFukushiYoguHanbaihiEntityGenerator.DEFAULT_差額金額));
        }

    }
}
