/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.business.core.KyotakuKeikakuJigyoshaSakuseiBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.KyotakuKeikakuJigyoshaSakusei;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kyotakukeikaku.DbT3006KyotakuKeikakuJigyoshaSakuseiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyotakuKeikakuJigyoshaSakuseiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyotakuKeikakuJigyoshaSakuseiBuilderTest extends DbzTestBase {

    private static DbT3006KyotakuKeikakuJigyoshaSakuseiEntity KyotakuKeikakuJigyoshaSakuseiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 被保険者番号;
    private static FlexibleYearMonth 対象年月;
    private static Decimal 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        被保険者番号 = DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_被保険者番号;
        対象年月 = DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_対象年月;
        履歴番号 = DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static KyotakuKeikakuJigyoshaSakuseiBuilder sut;
        private static KyotakuKeikakuJigyoshaSakusei business;

        @Before
        public void setUp() {
            KyotakuKeikakuJigyoshaSakuseiEntity = new DbT3006KyotakuKeikakuJigyoshaSakuseiEntity();
            KyotakuKeikakuJigyoshaSakuseiEntity.setHihokenshano(被保険者番号);
            KyotakuKeikakuJigyoshaSakuseiEntity.setTaishoYM(対象年月);
            KyotakuKeikakuJigyoshaSakuseiEntity.setRirekiNo(履歴番号);

            business = new KyotakuKeikakuJigyoshaSakusei(KyotakuKeikakuJigyoshaSakuseiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の対象年月は_設定した値と同じ対象年月を返す() {
            business = sut.set対象年月(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_対象年月).build();
            assertThat(business.get対象年月(), is(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_対象年月));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の適用開始年月日は_設定した値と同じ適用開始年月日を返す() {
            business = sut.set適用開始年月日(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_適用開始年月日).build();
            assertThat(business.get適用開始年月日(), is(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_適用開始年月日));
        }

        @Test
        public void 戻り値の適用終了年月日は_設定した値と同じ適用終了年月日を返す() {
            business = sut.set適用終了年月日(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_適用終了年月日).build();
            assertThat(business.get適用終了年月日(), is(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_適用終了年月日));
        }

        @Test
        public void 戻り値の作成区分コードは_設定した値と同じ作成区分コードを返す() {
            business = sut.set作成区分コード(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_作成区分コード).build();
            assertThat(business.get作成区分コード(), is(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_作成区分コード));
        }

        @Test
        public void 戻り値の計画事業者番号は_設定した値と同じ計画事業者番号を返す() {
            business = sut.set計画事業者番号(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_計画事業者番号).build();
            assertThat(business.get計画事業者番号(), is(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_計画事業者番号));
        }

        @Test
        public void 戻り値の委託先事業者番号は_設定した値と同じ委託先事業者番号を返す() {
            business = sut.set委託先事業者番号(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_委託先事業者番号).build();
            assertThat(business.get委託先事業者番号(), is(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_委託先事業者番号));
        }

        @Test
        public void 戻り値の事業者変更年月日は_設定した値と同じ事業者変更年月日を返す() {
            business = sut.set事業者変更年月日(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_事業者変更年月日).build();
            assertThat(business.get事業者変更年月日(), is(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_事業者変更年月日));
        }

        @Test
        public void 戻り値の事業者変更事由は_設定した値と同じ事業者変更事由を返す() {
            business = sut.set事業者変更事由(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_事業者変更事由).build();
            assertThat(business.get事業者変更事由(), is(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.DEFAULT_事業者変更事由));
        }

    }
}
