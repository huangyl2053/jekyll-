/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo;

import jp.co.ndensan.reams.db.dbb.entity.db.basic.choshuyuyo.DbT2006ChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.helper.DbT2006ChoshuYuyoEntityGenerator;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.helper.DbT2007KibetsuChoshuYuyoEntityGenerator;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choshuyuyo.ChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
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
 * {@link ChoshuYuyoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ChoshuYuyoBuilderTest extends DbbTestBase {

    private static DbT2006ChoshuYuyoEntity choshuYuyoEntity;
    private static FlexibleYear 調定年度;
    private static FlexibleYear 賦課年度;
    private static TsuchishoNo 通知書番号;
    private static Decimal 履歴番号;
    private static RString 徴収方法;
    private static int 期;

    @BeforeClass
    public static void setUpClass() {
        調定年度 = DbT2006ChoshuYuyoEntityGenerator.DEFAULT_調定年度;
        賦課年度 = DbT2006ChoshuYuyoEntityGenerator.DEFAULT_賦課年度;
        通知書番号 = DbT2006ChoshuYuyoEntityGenerator.DEFAULT_通知書番号;
        履歴番号 = DbT2006ChoshuYuyoEntityGenerator.DEFAULT_履歴番号;
        徴収方法 = DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_徴収方法;
        期 = DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_期;
    }

    public static class SeishinTechoNiniテスト extends DbbTestBase {

        private static ChoshuYuyoBuilder sut;
        private static ChoshuYuyo business;
        private static KibetsuChoshuYuyo kibetsuChoshuYuyo;

        @Before
        public void setUp() {
            choshuYuyoEntity = DbT2006ChoshuYuyoEntityGenerator.createDbT2006ChoshuYuyoEntity();
            choshuYuyoEntity.setChoteiNendo(調定年度);
            choshuYuyoEntity.setFukaNendo(賦課年度);
            choshuYuyoEntity.setTsuchishoNo(通知書番号);
            choshuYuyoEntity.setRirekiNo(履歴番号);

            ChoshuYuyoEntity relateEntity = new ChoshuYuyoEntity();
            relateEntity.set介護賦課徴収猶予Entity(choshuYuyoEntity);
            business = new ChoshuYuyo(relateEntity);
            kibetsuChoshuYuyo = new KibetsuChoshuYuyo(調定年度, 賦課年度, 通知書番号, 履歴番号, 徴収方法, 期);
            sut = business.createBuilderForEdit();
        }

        @Test
        public void 介護賦課徴収猶予に紐づくことが可能な子テーブル情報をsetKibetsuChoshuYuyoで設定した場合_設定済みの子テーブル情報が返る() {
            business = sut.setKibetsuChoshuYuyo(kibetsuChoshuYuyo).build();
            assertThat(business.getKibetsuChoshuYuyoList().size(), is(1));
        }
    }

    public static class getterSetterTest extends DbbTestBase {

        private static ChoshuYuyoBuilder sut;
        private static ChoshuYuyo business;

        @Before
        public void setUp() {
            choshuYuyoEntity = new DbT2006ChoshuYuyoEntity();
            choshuYuyoEntity.setChoteiNendo(調定年度);
            choshuYuyoEntity.setFukaNendo(賦課年度);
            choshuYuyoEntity.setTsuchishoNo(通知書番号);
            choshuYuyoEntity.setRirekiNo(履歴番号);

            ChoshuYuyoEntity relateEntity = new ChoshuYuyoEntity();
            relateEntity.set介護賦課徴収猶予Entity(choshuYuyoEntity);
            business = new ChoshuYuyo(relateEntity);

            sut = business.createBuilderForEdit();
        }

        @Test
        public void 戻り値の徴収猶予申請年月日は_設定した値と同じ徴収猶予申請年月日を返す() {
            business = sut.set徴収猶予申請年月日(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_徴収猶予申請年月日).build();
            assertThat(business.get徴収猶予申請年月日(), is(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_徴収猶予申請年月日));
        }

        @Test
        public void 戻り値の徴収猶予決定年月日は_設定した値と同じ徴収猶予決定年月日を返す() {
            business = sut.set徴収猶予決定年月日(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_徴収猶予決定年月日).build();
            assertThat(business.get徴収猶予決定年月日(), is(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_徴収猶予決定年月日));
        }

        @Test
        public void 戻り値の徴収猶予取消年月日は_設定した値と同じ徴収猶予取消年月日を返す() {
            business = sut.set徴収猶予取消年月日(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_徴収猶予取消年月日).build();
            assertThat(business.get徴収猶予取消年月日(), is(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_徴収猶予取消年月日));
        }

        @Test
        public void 戻り値の徴収猶予状態区分は_設定した値と同じ徴収猶予状態区分を返す() {
            business = sut.set徴収猶予状態区分(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_徴収猶予状態区分).build();
            assertThat(business.get徴収猶予状態区分(), is(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_徴収猶予状態区分));
        }

        @Test
        public void 戻り値の徴収猶予作成区分は_設定した値と同じ徴収猶予作成区分を返す() {
            business = sut.set徴収猶予作成区分(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_徴収猶予作成区分).build();
            assertThat(business.get徴収猶予作成区分(), is(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_徴収猶予作成区分));
        }

        @Test
        public void 戻り値の申請事由は_設定した値と同じ申請事由を返す() {
            business = sut.set申請事由(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_申請事由).build();
            assertThat(business.get申請事由(), is(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_申請事由));
        }

        @Test
        public void 戻り値の徴収猶予種類コードは_設定した値と同じ徴収猶予種類コードを返す() {
            business = sut.set徴収猶予種類コード(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_徴収猶予種類コード).build();
            assertThat(business.get徴収猶予種類コード(), is(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_徴収猶予種類コード));
        }

        @Test
        public void 戻り値の徴収猶予事由は_設定した値と同じ徴収猶予事由を返す() {
            business = sut.set徴収猶予事由(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_徴収猶予事由).build();
            assertThat(business.get徴収猶予事由(), is(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_徴収猶予事由));
        }

        @Test
        public void 戻り値の徴収猶予取消種類コードは_設定した値と同じ徴収猶予取消種類コードを返す() {
            business = sut.set徴収猶予取消種類コード(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_徴収猶予取消種類コード).build();
            assertThat(business.get徴収猶予取消種類コード(), is(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_徴収猶予取消種類コード));
        }

        @Test
        public void 戻り値の徴収猶予取消事由は_設定した値と同じ徴収猶予取消事由を返す() {
            business = sut.set徴収猶予取消事由(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_徴収猶予取消事由).build();
            assertThat(business.get徴収猶予取消事由(), is(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_徴収猶予取消事由));
        }

    }
}
