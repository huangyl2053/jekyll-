/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.basic;

import jp.co.ndensan.reams.db.dbx.business.core.kibetsu.KibetsuBuilder;
import jp.co.ndensan.reams.db.dbx.business.core.kibetsu.Kibetsu;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT2003KibetsuEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
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
 * {@link KibetsuBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KibetsuBuilderTest extends DbxTestBase {

    private static DbT2003KibetsuEntity KibetsuEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleYear 調定年度;
    private static FlexibleYear 賦課年度;
    private static TsuchishoNo 通知書番号;
    private static Decimal 履歴番号;
    private static RString 徴収方法;
    private static int 期;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        調定年度 = DbT2003KibetsuEntityGenerator.DEFAULT_調定年度;
        賦課年度 = DbT2003KibetsuEntityGenerator.DEFAULT_賦課年度;
    }

    public static class getterSetterTest extends DbxTestBase {

        private static KibetsuBuilder sut;
        private static Kibetsu business;

        @Before
        public void setUp() {
            KibetsuEntity = new DbT2003KibetsuEntity();
            KibetsuEntity.setChoteiNendo(調定年度);
            KibetsuEntity.setFukaNendo(賦課年度);

            business = new Kibetsu(KibetsuEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の調定年度は_設定した値と同じ調定年度を返す() {
            business = sut.set調定年度(DbT2003KibetsuEntityGenerator.DEFAULT_調定年度).build();
            assertThat(business.get調定年度(), is(DbT2003KibetsuEntityGenerator.DEFAULT_調定年度));
        }

        @Test
        public void 戻り値の賦課年度は_設定した値と同じ賦課年度を返す() {
            business = sut.set賦課年度(DbT2003KibetsuEntityGenerator.DEFAULT_賦課年度).build();
            assertThat(business.get賦課年度(), is(DbT2003KibetsuEntityGenerator.DEFAULT_賦課年度));
        }

        @Test
        public void 戻り値の通知書番号は_設定した値と同じ通知書番号を返す() {
            business = sut.set通知書番号(DbT2003KibetsuEntityGenerator.DEFAULT_通知書番号).build();
            assertThat(business.get通知書番号(), is(DbT2003KibetsuEntityGenerator.DEFAULT_通知書番号));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT2003KibetsuEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT2003KibetsuEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の徴収方法は_設定した値と同じ徴収方法を返す() {
            business = sut.set徴収方法(DbT2003KibetsuEntityGenerator.DEFAULT_徴収方法).build();
            assertThat(business.get徴収方法(), is(DbT2003KibetsuEntityGenerator.DEFAULT_徴収方法));
        }

        @Test
        public void 戻り値の期は_設定した値と同じ期を返す() {
            business = sut.set期(DbT2003KibetsuEntityGenerator.DEFAULT_期).build();
            assertThat(business.get期(), is(DbT2003KibetsuEntityGenerator.DEFAULT_期));
        }

        @Test
        public void 戻り値の調定IDは_設定した値と同じ調定IDを返す() {
            business = sut.set調定ID(DbT2003KibetsuEntityGenerator.DEFAULT_調定ID).build();
            assertThat(business.get調定ID(), is(DbT2003KibetsuEntityGenerator.DEFAULT_調定ID));
        }

    }
}
