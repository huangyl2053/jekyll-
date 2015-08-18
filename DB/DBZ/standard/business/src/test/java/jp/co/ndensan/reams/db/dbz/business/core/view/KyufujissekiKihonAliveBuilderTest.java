/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.view;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbV3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbV3017KyufujissekiKihonEntityGenerator;
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
 * {@link KyufujissekiKihonAliveBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufujissekiKihonAliveBuilderTest extends DbzTestBase {

    private static DbV3017KyufujissekiKihonEntity KyufujissekiKihonAliveEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShikibetsuCode 交換情報識別番号;
    private static ShikibetsuCode 入力識別番号;
    private static RString レコード種別コード;
    private static HokenshaNo 証記載保険者番号;
    private static HihokenshaNo 被保険者番号;
    private static FlexibleYearMonth サービス提供年月;
    private static JigyoshaNo 事業所番号;
    private static RString 給付実績情報作成区分コード;
    private static RString 給付実績区分コード;
    private static RString 通し番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        交換情報識別番号 = DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_交換情報識別番号;
        入力識別番号 = DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_入力識別番号;
        レコード種別コード = DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_レコード種別コード;
        証記載保険者番号 = DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_証記載保険者番号;
        被保険者番号 = DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_被保険者番号;
        サービス提供年月 = DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_サービス提供年月;
        事業所番号 = DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_事業所番号;
        給付実績情報作成区分コード = DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_給付実績情報作成区分コード;
        給付実績区分コード = DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_給付実績区分コード;
        通し番号 = DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_通し番号;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static KyufujissekiKihonAliveBuilder sut;
        private static KyufujissekiKihonAlive business;

        @Before
        public void setUp() {
            KyufujissekiKihonAliveEntity = new DbV3017KyufujissekiKihonEntity();

            business = new KyufujissekiKihonAlive(KyufujissekiKihonAliveEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の交換情報識別番号は_設定した値と同じ交換情報識別番号を返す() {
            business = sut.set交換情報識別番号(DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_交換情報識別番号).build();
            assertThat(business.get交換情報識別番号(), is(DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_交換情報識別番号));
        }

        @Test
        public void 戻り値の入力識別番号は_設定した値と同じ入力識別番号を返す() {
            business = sut.set入力識別番号(DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_入力識別番号).build();
            assertThat(business.get入力識別番号(), is(DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_入力識別番号));
        }

        @Test
        public void 戻り値のレコード種別コードは_設定した値と同じレコード種別コードを返す() {
            business = sut.setレコード種別コード(DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_レコード種別コード).build();
            assertThat(business.getレコード種別コード(), is(DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_レコード種別コード));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            business = sut.set証記載保険者番号(DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_証記載保険者番号).build();
            assertThat(business.get証記載保険者番号(), is(DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            business = sut.setサービス提供年月(DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_サービス提供年月).build();
            assertThat(business.getサービス提供年月(), is(DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の事業所番号は_設定した値と同じ事業所番号を返す() {
            business = sut.set事業所番号(DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_事業所番号).build();
            assertThat(business.get事業所番号(), is(DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_事業所番号));
        }

        @Test
        public void 戻り値の給付実績情報作成区分コードは_設定した値と同じ給付実績情報作成区分コードを返す() {
            business = sut.set給付実績情報作成区分コード(DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_給付実績情報作成区分コード).build();
            assertThat(business.get給付実績情報作成区分コード(), is(DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_給付実績情報作成区分コード));
        }

        @Test
        public void 戻り値の給付実績区分コードは_設定した値と同じ給付実績区分コードを返す() {
            business = sut.set給付実績区分コード(DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_給付実績区分コード).build();
            assertThat(business.get給付実績区分コード(), is(DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_給付実績区分コード));
        }

        @Test
        public void 戻り値の通し番号は_設定した値と同じ通し番号を返す() {
            business = sut.set通し番号(DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_通し番号).build();
            assertThat(business.get通し番号(), is(DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_通し番号));
        }

    }
}
