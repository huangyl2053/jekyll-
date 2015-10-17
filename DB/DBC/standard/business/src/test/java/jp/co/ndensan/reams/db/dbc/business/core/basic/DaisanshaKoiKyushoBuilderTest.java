/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3082DaisanshaKoiKyushoEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3082DaisanshaKoiKyushoEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
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
 * {@link DaisanshaKoiKyushoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class DaisanshaKoiKyushoBuilderTest extends DbcTestBase {

    private static DbT3082DaisanshaKoiKyushoEntity DaisanshaKoiKyushoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static RString 主キー名2;
    private static RString 主キー名3;
    private static Decimal 主キー名4;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_第三者行為届出管理番号;
        主キー名3 = DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_第三者行為求償請求番号;
        主キー名4 = DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static DaisanshaKoiKyushoBuilder sut;
        private static DaisanshaKoiKyusho business;

        @Before
        public void setUp() {
            DaisanshaKoiKyushoEntity = new DbT3082DaisanshaKoiKyushoEntity();
            DaisanshaKoiKyushoEntity.setHihokenshaNo(主キー名1);
            DaisanshaKoiKyushoEntity.setTodokedeKanriNo(主キー名2);

            business = new DaisanshaKoiKyusho(DaisanshaKoiKyushoEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の第三者行為届出管理番号は_設定した値と同じ第三者行為届出管理番号を返す() {
            business = sut.set第三者行為届出管理番号(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_第三者行為届出管理番号).build();
            assertThat(business.get第三者行為届出管理番号(), is(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_第三者行為届出管理番号));
        }

        @Test
        public void 戻り値の第三者行為求償請求番号は_設定した値と同じ第三者行為求償請求番号を返す() {
            business = sut.set第三者行為求償請求番号(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_第三者行為求償請求番号).build();
            assertThat(business.get第三者行為求償請求番号(), is(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_第三者行為求償請求番号));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の給付額合計は_設定した値と同じ給付額合計を返す() {
            business = sut.set給付額合計(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_給付額合計).build();
            assertThat(business.get給付額合計(), is(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_給付額合計));
        }

        @Test
        public void 戻り値の過失相殺額は_設定した値と同じ過失相殺額を返す() {
            business = sut.set過失相殺額(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_過失相殺額).build();
            assertThat(business.get過失相殺額(), is(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_過失相殺額));
        }

        @Test
        public void 戻り値の保険給付請求額は_設定した値と同じ保険給付請求額を返す() {
            business = sut.set保険給付請求額(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_保険給付請求額).build();
            assertThat(business.get保険給付請求額(), is(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_保険給付請求額));
        }

        @Test
        public void 戻り値の損害賠償金納入期限は_設定した値と同じ損害賠償金納入期限を返す() {
            business = sut.set損害賠償金納入期限(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_損害賠償金納入期限).build();
            assertThat(business.get損害賠償金納入期限(), is(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_損害賠償金納入期限));
        }

        @Test
        public void 戻り値の請求先郵便番号は_設定した値と同じ請求先郵便番号を返す() {
            business = sut.set請求先郵便番号(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_請求先郵便番号).build();
            assertThat(business.get請求先郵便番号(), is(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_請求先郵便番号));
        }

        @Test
        public void 戻り値の請求先住所は_設定した値と同じ請求先住所を返す() {
            business = sut.set請求先住所(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_請求先住所).build();
            assertThat(business.get請求先住所(), is(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_請求先住所));
        }

        @Test
        public void 戻り値の請求先名称は_設定した値と同じ請求先名称を返す() {
            business = sut.set請求先名称(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_請求先名称).build();
            assertThat(business.get請求先名称(), is(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_請求先名称));
        }

        @Test
        public void 戻り値の請求先部署は_設定した値と同じ請求先部署を返す() {
            business = sut.set請求先部署(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_請求先部署).build();
            assertThat(business.get請求先部署(), is(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_請求先部署));
        }

        @Test
        public void 戻り値の請求先担当者は_設定した値と同じ請求先担当者を返す() {
            business = sut.set請求先担当者(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_請求先担当者).build();
            assertThat(business.get請求先担当者(), is(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_請求先担当者));
        }

        @Test
        public void 戻り値の請求先電話番号は_設定した値と同じ請求先電話番号を返す() {
            business = sut.set請求先電話番号(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_請求先電話番号).build();
            assertThat(business.get請求先電話番号(), is(DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_請求先電話番号));
        }

    }
}
