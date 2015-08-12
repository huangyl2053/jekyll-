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
 * {@link KyufujissekiKogakuKaigoServicehiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufujissekiKogakuKaigoServicehiBuilderTest extends DbcTestBase {

    private static DbT3028KyufujissekiKogakuKaigoServicehiEntity KyufujissekiKogakuKaigoServicehiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends FdaTestBase {

        private static KyufujissekiKogakuKaigoServicehiBuilder sut;
        private static KyufujissekiKogakuKaigoServicehi business;

        @Before
        public void setUp() {
            KyufujissekiKogakuKaigoServicehiEntity = new DbT3028KyufujissekiKogakuKaigoServicehiEntity();
            KyufujissekiKogakuKaigoServicehiEntity.setXXX(主キー名1);
            KyufujissekiKogakuKaigoServicehiEntity.setXXX(主キー名2);

            business = new KyufujissekiKogakuKaigoServicehi(KyufujissekiKogakuKaigoServicehiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。
        @Test
        public void 戻り値の交換情報識別番号は_設定した値と同じ交換情報識別番号を返す() {
            business = sut.set交換情報識別番号(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_交換情報識別番号).build();
            assertThat(business.get交換情報識別番号(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_交換情報識別番号));
        }

        @Test
        public void 戻り値の入力識別番号は_設定した値と同じ入力識別番号を返す() {
            business = sut.set入力識別番号(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_入力識別番号).build();
            assertThat(business.get入力識別番号(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_入力識別番号));
        }

        @Test
        public void 戻り値のレコード種別コードは_設定した値と同じレコード種別コードを返す() {
            business = sut.setレコード種別コード(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_レコード種別コード).build();
            assertThat(business.getレコード種別コード(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_レコード種別コード));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            business = sut.set証記載保険者番号(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_証記載保険者番号).build();
            assertThat(business.get証記載保険者番号(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            business = sut.setサービス提供年月(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_サービス提供年月).build();
            assertThat(business.getサービス提供年月(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の通し番号は_設定した値と同じ通し番号を返す() {
            business = sut.set通し番号(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_通し番号).build();
            assertThat(business.get通し番号(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_通し番号));
        }

        @Test
        public void 戻り値の給付実績情報作成区分コードは_設定した値と同じ給付実績情報作成区分コードを返す() {
            business = sut.set給付実績情報作成区分コード(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_給付実績情報作成区分コード).build();
            assertThat(business.get給付実績情報作成区分コード(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_給付実績情報作成区分コード));
        }

        @Test
        public void 戻り値の給付実績区分コードは_設定した値と同じ給付実績区分コードを返す() {
            business = sut.set給付実績区分コード(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_給付実績区分コード).build();
            assertThat(business.get給付実績区分コード(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_給付実績区分コード));
        }

        @Test
        public void 戻り値の受付年月日は_設定した値と同じ受付年月日を返す() {
            business = sut.set受付年月日(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_受付年月日).build();
            assertThat(business.get受付年月日(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_受付年月日));
        }

        @Test
        public void 戻り値の決定年月日は_設定した値と同じ決定年月日を返す() {
            business = sut.set決定年月日(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_決定年月日).build();
            assertThat(business.get決定年月日(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_決定年月日));
        }

        @Test
        public void 戻り値の公費１負担番号は_設定した値と同じ公費１負担番号を返す() {
            business = sut.set公費１負担番号(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_公費１負担番号).build();
            assertThat(business.get公費１負担番号(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_公費１負担番号));
        }

        @Test
        public void 戻り値の公費２負担番号は_設定した値と同じ公費２負担番号を返す() {
            business = sut.set公費２負担番号(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_公費２負担番号).build();
            assertThat(business.get公費２負担番号(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_公費２負担番号));
        }

        @Test
        public void 戻り値の公費３負担番号は_設定した値と同じ公費３負担番号を返す() {
            business = sut.set公費３負担番号(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_公費３負担番号).build();
            assertThat(business.get公費３負担番号(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_公費３負担番号));
        }

        @Test
        public void 戻り値の利用者負担額は_設定した値と同じ利用者負担額を返す() {
            business = sut.set利用者負担額(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_利用者負担額).build();
            assertThat(business.get利用者負担額(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_利用者負担額));
        }

        @Test
        public void 戻り値の公費１負担額は_設定した値と同じ公費１負担額を返す() {
            business = sut.set公費１負担額(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_公費１負担額).build();
            assertThat(business.get公費１負担額(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_公費１負担額));
        }

        @Test
        public void 戻り値の公費２負担額は_設定した値と同じ公費２負担額を返す() {
            business = sut.set公費２負担額(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_公費２負担額).build();
            assertThat(business.get公費２負担額(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_公費２負担額));
        }

        @Test
        public void 戻り値の公費３負担額は_設定した値と同じ公費３負担額を返す() {
            business = sut.set公費３負担額(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_公費３負担額).build();
            assertThat(business.get公費３負担額(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_公費３負担額));
        }

        @Test
        public void 戻り値の支給額は_設定した値と同じ支給額を返す() {
            business = sut.set支給額(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_支給額).build();
            assertThat(business.get支給額(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_支給額));
        }

        @Test
        public void 戻り値の公費１支給額は_設定した値と同じ公費１支給額を返す() {
            business = sut.set公費１支給額(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_公費１支給額).build();
            assertThat(business.get公費１支給額(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_公費１支給額));
        }

        @Test
        public void 戻り値の公費２支給額は_設定した値と同じ公費２支給額を返す() {
            business = sut.set公費２支給額(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_公費２支給額).build();
            assertThat(business.get公費２支給額(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_公費２支給額));
        }

        @Test
        public void 戻り値の公費３支給額は_設定した値と同じ公費３支給額を返す() {
            business = sut.set公費３支給額(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_公費３支給額).build();
            assertThat(business.get公費３支給額(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_公費３支給額));
        }

        @Test
        public void 戻り値の審査年月は_設定した値と同じ審査年月を返す() {
            business = sut.set審査年月(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_審査年月).build();
            assertThat(business.get審査年月(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_審査年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            business = sut.set整理番号(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_整理番号).build();
            assertThat(business.get整理番号(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の送付年月は_設定した値と同じ送付年月を返す() {
            business = sut.set送付年月(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_送付年月).build();
            assertThat(business.get送付年月(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_送付年月));
        }

        @Test
        public void 戻り値の取込年月は_設定した値と同じ取込年月を返す() {
            business = sut.set取込年月(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_取込年月).build();
            assertThat(business.get取込年月(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_取込年月));
        }

        @Test
        public void 戻り値の作成区分は_設定した値と同じ作成区分を返す() {
            business = sut.set作成区分(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_作成区分).build();
            assertThat(business.get作成区分(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_作成区分));
        }

        @Test
        public void 戻り値の管理番号は_設定した値と同じ管理番号を返す() {
            business = sut.set管理番号(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_管理番号).build();
            assertThat(business.get管理番号(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_管理番号));
        }

        @Test
        public void 戻り値の保険者保有給付実績情報削除済フラグは_設定した値と同じ保険者保有給付実績情報削除済フラグを返す() {
            business = sut.set保険者保有給付実績情報削除済フラグ(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_保険者保有給付実績情報削除済フラグ).build();
            assertThat(business.get保険者保有給付実績情報削除済フラグ(), is(DbT3028KyufujissekiKogakuKaigoServicehiEntityGenerator.DEFAULT_保険者保有給付実績情報削除済フラグ));
        }

    }
}
