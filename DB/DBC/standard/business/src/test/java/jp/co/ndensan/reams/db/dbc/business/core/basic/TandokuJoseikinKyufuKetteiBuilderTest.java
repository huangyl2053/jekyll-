/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3097TandokuJoseikinKyufuKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3097TandokuJoseikinKyufuKetteiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link TandokuJoseikinKyufuKetteiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class TandokuJoseikinKyufuKetteiBuilderTest extends DbcTestBase {

    private static DbT3097TandokuJoseikinKyufuKetteiEntity TandokuJoseikinKyufuKetteiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static FlexibleDate 主キー名2;
    private static Decimal 主キー名3;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_受付年月日;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static TandokuJoseikinKyufuKetteiBuilder sut;
        private static TandokuJoseikinKyufuKettei business;

        @Before
        public void setUp() {
            TandokuJoseikinKyufuKetteiEntity = new DbT3097TandokuJoseikinKyufuKetteiEntity();
            TandokuJoseikinKyufuKetteiEntity.setHihokenshaNo(主キー名1);
            TandokuJoseikinKyufuKetteiEntity.setUketsukeYMD(主キー名2);

            business = new TandokuJoseikinKyufuKettei(TandokuJoseikinKyufuKetteiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の受付年月日は_設定した値と同じ受付年月日を返す() {
            business = sut.set受付年月日(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_受付年月日).build();
            assertThat(business.get受付年月日(), is(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_受付年月日));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の決定年月日は_設定した値と同じ決定年月日を返す() {
            business = sut.set決定年月日(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_決定年月日).build();
            assertThat(business.get決定年月日(), is(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_決定年月日));
        }

        @Test
        public void 戻り値の適用開始年月日は_設定した値と同じ適用開始年月日を返す() {
            business = sut.set適用開始年月日(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_適用開始年月日).build();
            assertThat(business.get適用開始年月日(), is(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_適用開始年月日));
        }

        @Test
        public void 戻り値の有効期限は_設定した値と同じ有効期限を返す() {
            business = sut.set有効期限(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_有効期限).build();
            assertThat(business.get有効期限(), is(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_有効期限));
        }

        @Test
        public void 戻り値の利用者負担_決定区分は_設定した値と同じ利用者負担_決定区分を返す() {
            business = sut.set利用者負担_決定区分(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_利用者負担_決定区分).build();
            assertThat(business.get利用者負担_決定区分(), is(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_利用者負担_決定区分));
        }

        @Test
        public void 戻り値の利用者負担_不承認理由は_設定した値と同じ利用者負担_不承認理由を返す() {
            business = sut.set利用者負担_不承認理由(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_利用者負担_不承認理由).build();
            assertThat(business.get利用者負担_不承認理由(), is(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_利用者負担_不承認理由));
        }

        @Test
        public void 戻り値の公費受給者番号は_設定した値と同じ公費受給者番号を返す() {
            business = sut.set公費受給者番号(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_公費受給者番号).build();
            assertThat(business.get公費受給者番号(), is(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_公費受給者番号));
        }

        @Test
        public void 戻り値の公費負担者番号は_設定した値と同じ公費負担者番号を返す() {
            business = sut.set公費負担者番号(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_公費負担者番号).build();
            assertThat(business.get公費負担者番号(), is(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_公費負担者番号));
        }

        @Test
        public void 戻り値の給付率は_設定した値と同じ給付率を返す() {
            business = sut.set給付率(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_給付率).build();
            assertThat(business.get給付率(), is(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_給付率));
        }

        @Test
        public void 戻り値の受給者番号は_設定した値と同じ受給者番号を返す() {
            business = sut.set受給者番号(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_受給者番号).build();
            assertThat(business.get受給者番号(), is(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_受給者番号));
        }

        @Test
        public void 戻り値の経過措置は_設定した値と同じ経過措置を返す() {
            business = sut.set経過措置(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_経過措置).build();
            assertThat(business.get経過措置(), is(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_経過措置));
        }

        @Test
        public void 戻り値の国軽減は_設定した値と同じ国軽減を返す() {
            business = sut.set国軽減(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_国軽減).build();
            assertThat(business.get国軽減(), is(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_国軽減));
        }

        @Test
        public void 戻り値の社会福祉法人軽減は_設定した値と同じ社会福祉法人軽減を返す() {
            business = sut.set社会福祉法人軽減(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_社会福祉法人軽減).build();
            assertThat(business.get社会福祉法人軽減(), is(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_社会福祉法人軽減));
        }

        @Test
        public void 戻り値の特別地域加算は_設定した値と同じ特別地域加算を返す() {
            business = sut.set特別地域加算(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_特別地域加算).build();
            assertThat(business.get特別地域加算(), is(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_特別地域加算));
        }

        @Test
        public void 戻り値の保留区分_滞納は_設定した値と同じ保留区分_滞納を返す() {
            business = sut.set保留区分_滞納(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_保留区分_滞納).build();
            assertThat(business.get保留区分_滞納(), is(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_保留区分_滞納));
        }

        @Test
        public void 戻り値の保留区分_認定申請中は_設定した値と同じ保留区分_認定申請中を返す() {
            business = sut.set保留区分_認定申請中(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_保留区分_認定申請中).build();
            assertThat(business.get保留区分_認定申請中(), is(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_保留区分_認定申請中));
        }

        @Test
        public void 戻り値の保留区分_認定有効期限切れは_設定した値と同じ保留区分_認定有効期限切れを返す() {
            business = sut.set保留区分_認定有効期限切れ(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_保留区分_認定有効期限切れ).build();
            assertThat(business.get保留区分_認定有効期限切れ(), is(DbT3097TandokuJoseikinKyufuKetteiEntityGenerator.DEFAULT_保留区分_認定有効期限切れ));
        }

    }
}
