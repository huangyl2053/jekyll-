/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import jp.co.ndensan.reams.db.dbb.entity.db.basic.choshuyuyo.DbT2007KibetsuChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2007KibetsuChoshuYuyoEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
 * {@link KibetsuChoshuYuyoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KibetsuChoshuYuyoBuilderTest extends DbbTestBase {

    private static DbT2007KibetsuChoshuYuyoEntity KibetsuChoshuYuyoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
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
        調定年度 = DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_調定年度;
        賦課年度 = DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_賦課年度;
    }

    public static class getterSetterTest extends DbbTestBase {

        private static KibetsuChoshuYuyoBuilder sut;
        private static KibetsuChoshuYuyo business;

        @Before
        public void setUp() {
            KibetsuChoshuYuyoEntity = new DbT2007KibetsuChoshuYuyoEntity();
            KibetsuChoshuYuyoEntity.setChoteiNendo(調定年度);
            KibetsuChoshuYuyoEntity.setFukaNendo(賦課年度);

            business = new KibetsuChoshuYuyo(KibetsuChoshuYuyoEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の調定年度は_設定した値と同じ調定年度を返す() {
            business = sut.set調定年度(DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_調定年度).build();
            assertThat(business.get調定年度(), is(DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_調定年度));
        }

        @Test
        public void 戻り値の賦課年度は_設定した値と同じ賦課年度を返す() {
            business = sut.set賦課年度(DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_賦課年度).build();
            assertThat(business.get賦課年度(), is(DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_賦課年度));
        }

        @Test
        public void 戻り値の通知書番号は_設定した値と同じ通知書番号を返す() {
            business = sut.set通知書番号(DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_通知書番号).build();
            assertThat(business.get通知書番号(), is(DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_通知書番号));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の徴収方法は_設定した値と同じ徴収方法を返す() {
            business = sut.set徴収方法(DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_徴収方法).build();
            assertThat(business.get徴収方法(), is(DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_徴収方法));
        }

        @Test
        public void 戻り値の期は_設定した値と同じ期を返す() {
            business = sut.set期(DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_期).build();
            assertThat(business.get期(), is(DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_期));
        }

        @Test
        public void 戻り値の徴収猶予開始日は_設定した値と同じ徴収猶予開始日を返す() {
            business = sut.set徴収猶予開始日(DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_徴収猶予開始日).build();
            assertThat(business.get徴収猶予開始日(), is(DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_徴収猶予開始日));
        }

        @Test
        public void 戻り値の徴収猶予終了日は_設定した値と同じ徴収猶予終了日を返す() {
            business = sut.set徴収猶予終了日(DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_徴収猶予終了日).build();
            assertThat(business.get徴収猶予終了日(), is(DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_徴収猶予終了日));
        }

    }
}
