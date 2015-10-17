/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.business.core.KyotakuKeikakuJikoSakuseiGokei;
import jp.co.ndensan.reams.db.dbz.business.core.KyotakuKeikakuJikoSakuseiGokeiBuilder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyotakuKeikakuJikoSakuseiGokeiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyotakuKeikakuJikoSakuseiGokeiBuilderTest extends DbzTestBase {

    private static DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity KyotakuKeikakuJikoSakuseiGokeiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 被保険者番号;
    private static FlexibleYearMonth 対象年月;
    private static Decimal 履歴番号;
    private static RString 居宅サービス区分;
    private static JigyoshaNo 事業者番号;
    private static ServiceShuruiCode サービス種類コード;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        被保険者番号 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_被保険者番号;
        対象年月 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_対象年月;
        履歴番号 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_履歴番号;
        居宅サービス区分 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_居宅サービス区分;
        事業者番号 = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_サービス提供事業者番号;
        サービス種類コード = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_サービス種類コード;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static KyotakuKeikakuJikoSakuseiGokeiBuilder sut;
        private static KyotakuKeikakuJikoSakuseiGokei business;

        @Before
        public void setUp() {
            KyotakuKeikakuJikoSakuseiGokeiEntity = new DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity();
            KyotakuKeikakuJikoSakuseiGokeiEntity.setHihokenshaNo(被保険者番号);
            KyotakuKeikakuJikoSakuseiGokeiEntity.setTaishoYM(対象年月);
            KyotakuKeikakuJikoSakuseiGokeiEntity.setRirekiNo(履歴番号);
            KyotakuKeikakuJikoSakuseiGokeiEntity.setKyotakuServiceKubun(居宅サービス区分);
            KyotakuKeikakuJikoSakuseiGokeiEntity.setServiceTeikyoJigyoshaNo(事業者番号);
            KyotakuKeikakuJikoSakuseiGokeiEntity.setServiceShuruiCode(サービス種類コード);

            business = new KyotakuKeikakuJikoSakuseiGokei(KyotakuKeikakuJikoSakuseiGokeiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の対象年月は_設定した値と同じ対象年月を返す() {
            business = sut.set対象年月(DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_対象年月).build();
            assertThat(business.get対象年月(), is(DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_対象年月));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の居宅サービス区分は_設定した値と同じ居宅サービス区分を返す() {
            business = sut.set居宅サービス区分(DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_居宅サービス区分).build();
            assertThat(business.get居宅サービス区分(), is(DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_居宅サービス区分));
        }

        @Test
        public void 戻り値のサービス提供事業者番号は_設定した値と同じサービス提供事業者番号を返す() {
            business = sut.setサービス提供事業者番号(DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_サービス提供事業者番号).build();
            assertThat(business.getサービス提供事業者番号(), is(DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_サービス提供事業者番号));
        }

        @Test
        public void 戻り値のサービス種類コードは_設定した値と同じサービス種類コードを返す() {
            business = sut.setサービス種類コード(DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_サービス種類コード).build();
            assertThat(business.getサービス種類コード(), is(DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_サービス種類コード));
        }

        @Test
        public void 戻り値の給付計画単位数は_設定した値と同じ給付計画単位数を返す() {
            business = sut.set給付計画単位数(DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_給付計画単位数).build();
            assertThat(business.get給付計画単位数(), is(DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_給付計画単位数));
        }

    }
}
