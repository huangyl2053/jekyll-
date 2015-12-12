/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import jp.co.ndensan.reams.db.dbb.entity.db.basic.gemmen.DbT2004GemmenEntity;
import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2004GemmenEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link GemmenBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class GemmenBuilderTest extends DbbTestBase {

    private static DbT2004GemmenEntity GemmenEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleYear 調停年度;
    private static FlexibleYear 賦課年度;
    private static TsuchishoNo 通知書番号;
    private static Decimal 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        調停年度 = DbT2004GemmenEntityGenerator.DEFAULT_調定年度;
        賦課年度 = DbT2004GemmenEntityGenerator.DEFAULT_賦課年度;
    }

    public static class getterSetterTest extends DbbTestBase {

        private static GemmenBuilder sut;
        private static Gemmen business;

        @Before
        public void setUp() {
            GemmenEntity = new DbT2004GemmenEntity();
            GemmenEntity.setChoteiNendo(調停年度);
            GemmenEntity.setFukaNendo(賦課年度);

            business = new Gemmen(GemmenEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の調定年度は_設定した値と同じ調定年度を返す() {
            business = sut.set調定年度(DbT2004GemmenEntityGenerator.DEFAULT_調定年度).build();
            assertThat(business.get調定年度(), is(DbT2004GemmenEntityGenerator.DEFAULT_調定年度));
        }

        @Test
        public void 戻り値の賦課年度は_設定した値と同じ賦課年度を返す() {
            business = sut.set賦課年度(DbT2004GemmenEntityGenerator.DEFAULT_賦課年度).build();
            assertThat(business.get賦課年度(), is(DbT2004GemmenEntityGenerator.DEFAULT_賦課年度));
        }

        @Test
        public void 戻り値の通知書番号は_設定した値と同じ通知書番号を返す() {
            business = sut.set通知書番号(DbT2004GemmenEntityGenerator.DEFAULT_通知書番号).build();
            assertThat(business.get通知書番号(), is(DbT2004GemmenEntityGenerator.DEFAULT_通知書番号));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT2004GemmenEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT2004GemmenEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の減免申請日は_設定した値と同じ減免申請日を返す() {
            business = sut.set減免申請日(DbT2004GemmenEntityGenerator.DEFAULT_減免申請日).build();
            assertThat(business.get減免申請日(), is(DbT2004GemmenEntityGenerator.DEFAULT_減免申請日));
        }

        @Test
        public void 戻り値の減免決定日は_設定した値と同じ減免決定日を返す() {
            business = sut.set減免決定日(DbT2004GemmenEntityGenerator.DEFAULT_減免決定日).build();
            assertThat(business.get減免決定日(), is(DbT2004GemmenEntityGenerator.DEFAULT_減免決定日));
        }

        @Test
        public void 戻り値の減免取消日は_設定した値と同じ減免取消日を返す() {
            business = sut.set減免取消日(DbT2004GemmenEntityGenerator.DEFAULT_減免取消日).build();
            assertThat(business.get減免取消日(), is(DbT2004GemmenEntityGenerator.DEFAULT_減免取消日));
        }

        @Test
        public void 戻り値の減免状態区分は_設定した値と同じ減免状態区分を返す() {
            business = sut.set減免状態区分(DbT2004GemmenEntityGenerator.DEFAULT_減免状態区分).build();
            assertThat(business.get減免状態区分(), is(DbT2004GemmenEntityGenerator.DEFAULT_減免状態区分));
        }

        @Test
        public void 戻り値の減免作成区分は_設定した値と同じ減免作成区分を返す() {
            business = sut.set減免作成区分(DbT2004GemmenEntityGenerator.DEFAULT_減免作成区分).build();
            assertThat(business.get減免作成区分(), is(DbT2004GemmenEntityGenerator.DEFAULT_減免作成区分));
        }

        @Test
        public void 戻り値の申請事由は_設定した値と同じ申請事由を返す() {
            business = sut.set申請事由(DbT2004GemmenEntityGenerator.DEFAULT_申請事由).build();
            assertThat(business.get申請事由(), is(DbT2004GemmenEntityGenerator.DEFAULT_申請事由));
        }

        @Test
        public void 戻り値の減免種類コードは_設定した値と同じ減免種類コードを返す() {
            business = sut.set減免種類コード(DbT2004GemmenEntityGenerator.DEFAULT_減免種類コード).build();
            assertThat(business.get減免種類コード(), is(DbT2004GemmenEntityGenerator.DEFAULT_減免種類コード));
        }

        @Test
        public void 戻り値の減免事由は_設定した値と同じ減免事由を返す() {
            business = sut.set減免事由(DbT2004GemmenEntityGenerator.DEFAULT_減免事由).build();
            assertThat(business.get減免事由(), is(DbT2004GemmenEntityGenerator.DEFAULT_減免事由));
        }

        @Test
        public void 戻り値の減免取消種類コードは_設定した値と同じ減免取消種類コードを返す() {
            business = sut.set減免取消種類コード(DbT2004GemmenEntityGenerator.DEFAULT_減免取消種類コード).build();
            assertThat(business.get減免取消種類コード(), is(DbT2004GemmenEntityGenerator.DEFAULT_減免取消種類コード));
        }

        @Test
        public void 戻り値の減免取消事由は_設定した値と同じ減免取消事由を返す() {
            business = sut.set減免取消事由(DbT2004GemmenEntityGenerator.DEFAULT_減免取消事由).build();
            assertThat(business.get減免取消事由(), is(DbT2004GemmenEntityGenerator.DEFAULT_減免取消事由));
        }

        @Test
        public void 戻り値の申請減免額は_設定した値と同じ申請減免額を返す() {
            business = sut.set申請減免額(DbT2004GemmenEntityGenerator.DEFAULT_申請減免額).build();
            assertThat(business.get申請減免額(), is(DbT2004GemmenEntityGenerator.DEFAULT_申請減免額));
        }

        @Test
        public void 戻り値の決定減免額は_設定した値と同じ決定減免額を返す() {
            business = sut.set決定減免額(DbT2004GemmenEntityGenerator.DEFAULT_決定減免額).build();
            assertThat(business.get決定減免額(), is(DbT2004GemmenEntityGenerator.DEFAULT_決定減免額));
        }

        @Test
        public void 戻り値の取消減免額は_設定した値と同じ取消減免額を返す() {
            business = sut.set取消減免額(DbT2004GemmenEntityGenerator.DEFAULT_取消減免額).build();
            assertThat(business.get取消減免額(), is(DbT2004GemmenEntityGenerator.DEFAULT_取消減免額));
        }

    }
}
