/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.business.core.KyotakuKeikakuJikoSakuseiBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.KyotakuKeikakuJikoSakusei;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kyotakukeikaku.DbT3007KyotakuKeikakuJikoSakuseiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator;
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
 * {@link KyotakuKeikakuJikoSakuseiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyotakuKeikakuJikoSakuseiBuilderTest extends DbzTestBase {

    private static DbT3007KyotakuKeikakuJikoSakuseiEntity KyotakuKeikakuJikoSakuseiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 被保険者番号;
    private static FlexibleYearMonth 対象年月;
    private static Decimal 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        被保険者番号 = DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_被保険者番号;
        対象年月 = DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_対象年月;
        履歴番号 = DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static KyotakuKeikakuJikoSakuseiBuilder sut;
        private static KyotakuKeikakuJikoSakusei business;

        @Before
        public void setUp() {
            KyotakuKeikakuJikoSakuseiEntity = new DbT3007KyotakuKeikakuJikoSakuseiEntity();
            KyotakuKeikakuJikoSakuseiEntity.setHihokenshaNo(被保険者番号);
            KyotakuKeikakuJikoSakuseiEntity.setTaishoYM(対象年月);
            KyotakuKeikakuJikoSakuseiEntity.setRirekiNo(履歴番号);

            business = new KyotakuKeikakuJikoSakusei(KyotakuKeikakuJikoSakuseiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の対象年月は_設定した値と同じ対象年月を返す() {
            business = sut.set対象年月(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_対象年月).build();
            assertThat(business.get対象年月(), is(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_対象年月));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の居宅_総合事業区分は_設定した値と同じ居宅_総合事業区分を返す() {
            business = sut.set居宅_総合事業区分(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_居宅総合事業区分).build();
            assertThat(business.get居宅_総合事業区分(), is(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_居宅総合事業区分));
        }

        @Test
        public void 戻り値の適用開始年月日は_設定した値と同じ適用開始年月日を返す() {
            business = sut.set適用開始年月日(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_適用開始年月日).build();
            assertThat(business.get適用開始年月日(), is(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_適用開始年月日));
        }

        @Test
        public void 戻り値の適用終了年月日は_設定した値と同じ適用終了年月日を返す() {
            business = sut.set適用終了年月日(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_適用終了年月日).build();
            assertThat(business.get適用終了年月日(), is(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_適用終了年月日));
        }

        @Test
        public void 戻り値の作成区分コードは_設定した値と同じ作成区分コードを返す() {
            business = sut.set作成区分コード(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_作成区分コード).build();
            assertThat(business.get作成区分コード(), is(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_作成区分コード));
        }

        @Test
        public void 戻り値の計画作成年月日は_設定した値と同じ計画作成年月日を返す() {
            business = sut.set計画作成年月日(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_計画作成年月日).build();
            assertThat(business.get計画作成年月日(), is(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_計画作成年月日));
        }

        @Test
        public void 戻り値の計画変更年月日は_設定した値と同じ計画変更年月日を返す() {
            business = sut.set計画変更年月日(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_計画変更年月日).build();
            assertThat(business.get計画変更年月日(), is(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_計画変更年月日));
        }

        @Test
        public void 戻り値の計画変更事由は_設定した値と同じ計画変更事由を返す() {
            business = sut.set計画変更事由(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_計画変更事由).build();
            assertThat(business.get計画変更事由(), is(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_計画変更事由));
        }

    }
}
