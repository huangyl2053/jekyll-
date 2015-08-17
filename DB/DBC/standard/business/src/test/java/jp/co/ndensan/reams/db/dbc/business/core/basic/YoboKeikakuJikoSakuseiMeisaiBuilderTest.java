/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbz.business.core.basic.YoboKeikakuJikoSakuseiMeisaiBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.YoboKeikakuJikoSakuseiMeisai;
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
 * {@link YoboKeikakuJikoSakuseiMeisaiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class YoboKeikakuJikoSakuseiMeisaiBuilderTest extends DbcTestBase {

    private static DbT3011YoboKeikakuJikoSakuseiMeisaiEntity YoboKeikakuJikoSakuseiMeisaiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends FdaTestBase {

        private static YoboKeikakuJikoSakuseiMeisaiBuilder sut;
        private static YoboKeikakuJikoSakuseiMeisai business;

        @Before
        public void setUp() {
            YoboKeikakuJikoSakuseiMeisaiEntity = new DbT3011YoboKeikakuJikoSakuseiMeisaiEntity();
            YoboKeikakuJikoSakuseiMeisaiEntity.setXXX(主キー名1);
            YoboKeikakuJikoSakuseiMeisaiEntity.setXXX(主キー名2);

            business = new YoboKeikakuJikoSakuseiMeisai(YoboKeikakuJikoSakuseiMeisaiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。
        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の対象年月は_設定した値と同じ対象年月を返す() {
            business = sut.set対象年月(DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_対象年月).build();
            assertThat(business.get対象年月(), is(DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_対象年月));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の居宅サービス区分は_設定した値と同じ居宅サービス区分を返す() {
            business = sut.set居宅サービス区分(DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_居宅サービス区分).build();
            assertThat(business.get居宅サービス区分(), is(DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_居宅サービス区分));
        }

        @Test
        public void 戻り値のサービス提供事業者番号は_設定した値と同じサービス提供事業者番号を返す() {
            business = sut.setサービス提供事業者番号(DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_サービス提供事業者番号).build();
            assertThat(business.getサービス提供事業者番号(), is(DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_サービス提供事業者番号));
        }

        @Test
        public void 戻り値のサービス種類コードは_設定した値と同じサービス種類コードを返す() {
            business = sut.setサービス種類コード(DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_サービス種類コード).build();
            assertThat(business.getサービス種類コード(), is(DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_サービス種類コード));
        }

        @Test
        public void 戻り値のサービス項目コードは_設定した値と同じサービス項目コードを返す() {
            business = sut.setサービス項目コード(DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_サービス項目コード).build();
            assertThat(business.getサービス項目コード(), is(DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_サービス項目コード));
        }

        @Test
        public void 戻り値の単位数は_設定した値と同じ単位数を返す() {
            business = sut.set単位数(DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_単位数).build();
            assertThat(business.get単位数(), is(DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_単位数));
        }

        @Test
        public void 戻り値の回数・日数は_設定した値と同じ回数・日数を返す() {
            business = sut.set回数・日数(DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_回数・日数).build();
            assertThat(business.get回数・日数(), is(DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_回数・日数));
        }

        @Test
        public void 戻り値の種類限度内単位数・日数は_設定した値と同じ種類限度内単位数・日数を返す() {
            business = sut.set種類限度内単位数・日数(DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_種類限度内単位数・日数).build();
            assertThat(business.get種類限度内単位数・日数(), is(DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_種類限度内単位数・日数));
        }

        @Test
        public void 戻り値の種類限度超過単位数・日数は_設定した値と同じ種類限度超過単位数・日数を返す() {
            business = sut.set種類限度超過単位数・日数(DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_種類限度超過単位数・日数).build();
            assertThat(business.get種類限度超過単位数・日数(), is(DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_種類限度超過単位数・日数));
        }

        @Test
        public void 戻り値の区分限度内単位数・日数は_設定した値と同じ区分限度内単位数・日数を返す() {
            business = sut.set区分限度内単位数・日数(DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_区分限度内単位数・日数).build();
            assertThat(business.get区分限度内単位数・日数(), is(DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_区分限度内単位数・日数));
        }

        @Test
        public void 戻り値の区分限度超過単位数・日数は_設定した値と同じ区分限度超過単位数・日数を返す() {
            business = sut.set区分限度超過単位数・日数(DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_区分限度超過単位数・日数).build();
            assertThat(business.get区分限度超過単位数・日数(), is(DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_区分限度超過単位数・日数));
        }

        @Test
        public void 戻り値の単位数単価は_設定した値と同じ単位数単価を返す() {
            business = sut.set単位数単価(DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_単位数単価).build();
            assertThat(business.get単位数単価(), is(DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_単位数単価));
        }

        @Test
        public void 戻り値の給付率は_設定した値と同じ給付率を返す() {
            business = sut.set給付率(DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_給付率).build();
            assertThat(business.get給付率(), is(DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_給付率));
        }

        @Test
        public void 戻り値の割引後適用率は_設定した値と同じ割引後適用率を返す() {
            business = sut.set割引後適用率(DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_割引後適用率).build();
            assertThat(business.get割引後適用率(), is(DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_割引後適用率));
        }

        @Test
        public void 戻り値の割引後適用単位数は_設定した値と同じ割引後適用単位数を返す() {
            business = sut.set割引後適用単位数(DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_割引後適用単位数).build();
            assertThat(business.get割引後適用単位数(), is(DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_割引後適用単位数));
        }

        @Test
        public void 戻り値の定額利用者負担単価金額は_設定した値と同じ定額利用者負担単価金額を返す() {
            business = sut.set定額利用者負担単価金額(DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_定額利用者負担単価金額).build();
            assertThat(business.get定額利用者負担単価金額(), is(DbT3011YoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_定額利用者負担単価金額));
        }

    }
}
