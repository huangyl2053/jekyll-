/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3081DaisanshaKoiKyufugakuGengakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
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
 * {@link DaisanshaKoiKyufugakuGengakuBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class DaisanshaKoiKyufugakuGengakuBuilderTest extends DbcTestBase {

    private static DbT3081DaisanshaKoiKyufugakuGengakuEntity DaisanshaKoiKyufugakuGengakuEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static RString 主キー名2;
    private static Decimal 主キー名3;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.DEFAULT_第三者行為届出管理番号;
        主キー名3 = DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static DaisanshaKoiKyufugakuGengakuBuilder sut;
        private static DaisanshaKoiKyufugakuGengaku business;

        @Before
        public void setUp() {
            DaisanshaKoiKyufugakuGengakuEntity = new DbT3081DaisanshaKoiKyufugakuGengakuEntity();
            DaisanshaKoiKyufugakuGengakuEntity.setHihokenshaNo(主キー名1);
            DaisanshaKoiKyufugakuGengakuEntity.setTodokedeKanriNo(主キー名2);

            business = new DaisanshaKoiKyufugakuGengaku(DaisanshaKoiKyufugakuGengakuEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の第三者行為届出管理番号は_設定した値と同じ第三者行為届出管理番号を返す() {
            business = sut.set第三者行為届出管理番号(DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.DEFAULT_第三者行為届出管理番号).build();
            assertThat(business.get第三者行為届出管理番号(), is(DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.DEFAULT_第三者行為届出管理番号));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の減額対象金額は_設定した値と同じ減額対象金額を返す() {
            business = sut.set減額対象金額(DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.DEFAULT_減額対象金額).build();
            assertThat(business.get減額対象金額(), is(DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.DEFAULT_減額対象金額));
        }

        @Test
        public void 戻り値の給付額減額期間開始年月日は_設定した値と同じ給付額減額期間開始年月日を返す() {
            business = sut.set給付額減額期間開始年月日(DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.DEFAULT_給付額減額期間開始年月日).build();
            assertThat(business.get給付額減額期間開始年月日(), is(DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.DEFAULT_給付額減額期間開始年月日));
        }

        @Test
        public void 戻り値の給付額減額期間終了年月日は_設定した値と同じ給付額減額期間終了年月日を返す() {
            business = sut.set給付額減額期間終了年月日(DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.DEFAULT_給付額減額期間終了年月日).build();
            assertThat(business.get給付額減額期間終了年月日(), is(DbT3081DaisanshaKoiKyufugakuGengakuEntityGenerator.DEFAULT_給付額減額期間終了年月日));
        }

    }
}
