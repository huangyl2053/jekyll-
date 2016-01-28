/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import jp.co.ndensan.reams.db.dbb.entity.db.basic.choshuyuyo.DbT2006ChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2006ChoshuYuyoEntityGenerator;
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
 * {@link ChoshuYuyoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ChoshuYuyoBuilderTest extends DbbTestBase {

    private static DbT2006ChoshuYuyoEntity ChoshuYuyoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleYear 調停年度;
    private static FlexibleYear 賦課年度;
    private static TsuchishoNo 通知書番号;
    private static Decimal 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        調停年度 = DbT2006ChoshuYuyoEntityGenerator.DEFAULT_調定年度;
        賦課年度 = DbT2006ChoshuYuyoEntityGenerator.DEFAULT_賦課年度;
    }

    public static class getterSetterTest extends DbbTestBase {

        private static ChoshuYuyoBuilder sut;
        private static ChoshuYuyo business;

        @Before
        public void setUp() {
            ChoshuYuyoEntity = new DbT2006ChoshuYuyoEntity();
            ChoshuYuyoEntity.setChoteiNendo(調停年度);
            ChoshuYuyoEntity.setFukaNendo(賦課年度);

            business = new ChoshuYuyo(ChoshuYuyoEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の調定年度は_設定した値と同じ調定年度を返す() {
            business = sut.set調定年度(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_調定年度).build();
            assertThat(business.get調定年度(), is(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_調定年度));
        }

        @Test
        public void 戻り値の賦課年度は_設定した値と同じ賦課年度を返す() {
            business = sut.set賦課年度(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_賦課年度).build();
            assertThat(business.get賦課年度(), is(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_賦課年度));
        }

        @Test
        public void 戻り値の通知書番号は_設定した値と同じ通知書番号を返す() {
            business = sut.set通知書番号(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_通知書番号).build();
            assertThat(business.get通知書番号(), is(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_通知書番号));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT2006ChoshuYuyoEntityGenerator.DEFAULT_履歴番号));
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
