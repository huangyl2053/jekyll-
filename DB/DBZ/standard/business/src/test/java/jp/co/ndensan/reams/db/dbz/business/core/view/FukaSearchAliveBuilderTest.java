/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.view;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kensaku.DbV7902FukaSearchEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbV7902FukaSearchEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link FukaSearchAliveBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class FukaSearchAliveBuilderTest extends DbzTestBase {

    private static DbV7902FukaSearchEntity FukaSearchAliveEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleYear 調定年度;
    private static FlexibleYear 賦課年度;
    private static TsuchishoNo 通知書番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        調定年度 = DbV7902FukaSearchEntityGenerator.DEFAULT_調定年度;
        賦課年度 = DbV7902FukaSearchEntityGenerator.DEFAULT_賦課年度;
        通知書番号 = DbV7902FukaSearchEntityGenerator.DEFAULT_通知書番号;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static FukaSearchAliveBuilder sut;
        private static FukaSearchAlive business;

        @Before
        public void setUp() {
            FukaSearchAliveEntity = new DbV7902FukaSearchEntity();

            business = new FukaSearchAlive(FukaSearchAliveEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の調定年度は_設定した値と同じ調定年度を返す() {
            business = sut.set調定年度(DbV7902FukaSearchEntityGenerator.DEFAULT_調定年度).build();
            assertThat(business.get調定年度(), is(DbV7902FukaSearchEntityGenerator.DEFAULT_調定年度));
        }

        @Test
        public void 戻り値の賦課年度は_設定した値と同じ賦課年度を返す() {
            business = sut.set賦課年度(DbV7902FukaSearchEntityGenerator.DEFAULT_賦課年度).build();
            assertThat(business.get賦課年度(), is(DbV7902FukaSearchEntityGenerator.DEFAULT_賦課年度));
        }

        @Test
        public void 戻り値の通知書番号は_設定した値と同じ通知書番号を返す() {
            business = sut.set通知書番号(DbV7902FukaSearchEntityGenerator.DEFAULT_通知書番号).build();
            assertThat(business.get通知書番号(), is(DbV7902FukaSearchEntityGenerator.DEFAULT_通知書番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbV7902FukaSearchEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbV7902FukaSearchEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            business = sut.set識別コード(DbV7902FukaSearchEntityGenerator.DEFAULT_識別コード).build();
            assertThat(business.get識別コード(), is(DbV7902FukaSearchEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の被保台帳被保険者番号は_設定した値と同じ被保台帳被保険者番号を返す() {
            business = sut.set被保台帳被保険者番号(DbV7902FukaSearchEntityGenerator.DEFAULT_被保台帳被保険者番号).build();
            assertThat(business.get被保台帳被保険者番号(), is(DbV7902FukaSearchEntityGenerator.DEFAULT_被保台帳被保険者番号));
        }

    }
}
