/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.view;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV3016KyufujissekiShuruiDetailEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbV3016KyufujissekiShuruiDetailEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyufujissekiShuruiDetailBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufujissekiShuruiDetailBuilderTest extends DbzTestBase {

    private static DbV3016KyufujissekiShuruiDetailEntity KyufujissekiShuruiDetailEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShikibetsuCode 交換情報識別番号;
    private static ShikibetsuCode 入力識別番号;
    private static RString レコード種別コード;
    private static HokenshaNo 証記載保険者番号;
    private static HihokenshaNo 被保険者番号;
    private static FlexibleYearMonth サービス提供年月;
    private static JigyoshaNo 事業所番号;
    private static RString 通し番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        交換情報識別番号 = DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_交換情報識別番号;
        入力識別番号 = DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_入力識別番号;
        レコード種別コード = DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_レコード種別コード;
        証記載保険者番号 = DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_証記載保険者番号;
        被保険者番号 = DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_被保険者番号;
        サービス提供年月 = DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_サービス提供年月;
        事業所番号 = DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_事業所番号;
        通し番号 = DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_通し番号;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static KyufujissekiShuruiDetailBuilder sut;
        private static KyufujissekiShuruiDetail business;

        @Before
        public void setUp() {
            KyufujissekiShuruiDetailEntity = new DbV3016KyufujissekiShuruiDetailEntity();

            business = new KyufujissekiShuruiDetail(KyufujissekiShuruiDetailEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の交換情報識別番号は_設定した値と同じ交換情報識別番号を返す() {
            business = sut.set交換情報識別番号(DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_交換情報識別番号).build();
            assertThat(business.get交換情報識別番号(), is(DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_交換情報識別番号));
        }

        @Test
        public void 戻り値の入力識別番号は_設定した値と同じ入力識別番号を返す() {
            business = sut.set入力識別番号(DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_入力識別番号).build();
            assertThat(business.get入力識別番号(), is(DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_入力識別番号));
        }

        @Test
        public void 戻り値のレコード種別コードは_設定した値と同じレコード種別コードを返す() {
            business = sut.setレコード種別コード(DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_レコード種別コード).build();
            assertThat(business.getレコード種別コード(), is(DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_レコード種別コード));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            business = sut.set証記載保険者番号(DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_証記載保険者番号).build();
            assertThat(business.get証記載保険者番号(), is(DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            business = sut.setサービス提供年月(DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_サービス提供年月).build();
            assertThat(business.getサービス提供年月(), is(DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の事業所番号は_設定した値と同じ事業所番号を返す() {
            business = sut.set事業所番号(DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_事業所番号).build();
            assertThat(business.get事業所番号(), is(DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_事業所番号));
        }

        @Test
        public void 戻り値の通し番号は_設定した値と同じ通し番号を返す() {
            business = sut.set通し番号(DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_通し番号).build();
            assertThat(business.get通し番号(), is(DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_通し番号));
        }

        @Test
        public void 戻り値のサービス種類コードは_設定した値と同じサービス種類コードを返す() {
            business = sut.setサービス種類コード(DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_サービス種類コード).build();
            assertThat(business.getサービス種類コード(), is(DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_サービス種類コード));
        }

        @Test
        public void 戻り値の保険_利用者負担額は_設定した値と同じ保険_利用者負担額を返す() {
            business = sut.set保険_利用者負担額(DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_保険_利用者負担額).build();
            assertThat(business.get保険_利用者負担額(), is(DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_保険_利用者負担額));
        }

        @Test
        public void 戻り値の後_単位数合計は_設定した値と同じ後_単位数合計を返す() {
            business = sut.set後_単位数合計(DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_後_単位数合計).build();
            assertThat(business.get後_単位数合計(), is(DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_後_単位数合計));
        }

        @Test
        public void 戻り値の後_保険請求分請求額は_設定した値と同じ後_保険請求分請求額を返す() {
            business = sut.set後_保険請求分請求額(DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_後_保険請求分請求額).build();
            assertThat(business.get後_保険請求分請求額(), is(DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_後_保険請求分請求額));
        }

        @Test
        public void 戻り値の後_保険_出来高単位数合計は_設定した値と同じ後_保険_出来高単位数合計を返す() {
            business = sut.set後_保険_出来高単位数合計(DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_後_保険_出来高単位数合計).build();
            assertThat(business.get後_保険_出来高単位数合計(), is(DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_後_保険_出来高単位数合計));
        }

        @Test
        public void 戻り値のサービスコードは_設定した値と同じサービスコードを返す() {
            business = sut.setサービスコード(DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_サービスコード).build();
            assertThat(business.getサービスコード(), is(DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_サービスコード));
        }

        @Test
        public void 戻り値の後_サービス単位数合計は_設定した値と同じ後_サービス単位数合計を返す() {
            business = sut.set後_サービス単位数合計(DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_後_サービス単位数合計).build();
            assertThat(business.get後_サービス単位数合計(), is(DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_後_サービス単位数合計));
        }

        @Test
        public void 戻り値の後_単位数は_設定した値と同じ後_単位数を返す() {
            business = sut.set後_単位数(DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_後_単位数).build();
            assertThat(business.get後_単位数(), is(DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_後_単位数));
        }

    }
}
