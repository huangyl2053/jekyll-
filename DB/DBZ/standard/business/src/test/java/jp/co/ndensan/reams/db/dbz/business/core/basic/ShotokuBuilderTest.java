/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.business.core.Shotoku;
import jp.co.ndensan.reams.db.dbz.business.core.ShotokuBuilder;
import jp.co.ndensan.reams.fd.fdz.testhelper.FdaTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShotokuBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShotokuBuilderTest extends DbzTestBase {

    private static DbT2008ShotokuEntity ShotokuEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT2008ShotokuEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT2008ShotokuEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends FdaTestBase {

        private static ShotokuBuilder sut;
        private static Shotoku business;

        @Before
        public void setUp() {
            ShotokuEntity = new DbT2008ShotokuEntity();
            ShotokuEntity.setXXX(主キー名1);
            ShotokuEntity.setXXX(主キー名2);

            business = new Shotoku(ShotokuEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。
        @Test
        public void 戻り値の所得年度は_設定した値と同じ所得年度を返す() {
            business = sut.set所得年度(DbT2008ShotokuEntityGenerator.DEFAULT_所得年度).build();
            assertThat(business.get所得年度(), is(DbT2008ShotokuEntityGenerator.DEFAULT_所得年度));
        }

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            business = sut.set識別コード(DbT2008ShotokuEntityGenerator.DEFAULT_識別コード).build();
            assertThat(business.get識別コード(), is(DbT2008ShotokuEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT2008ShotokuEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT2008ShotokuEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の非課税区分（住民税減免前）は_設定した値と同じ非課税区分（住民税減免前）を返す() {
            business = sut.set非課税区分（住民税減免前）(DbT2008ShotokuEntityGenerator.DEFAULT_非課税区分（住民税減免前）).build();
            assertThat(business.get非課税区分（住民税減免前）(), is(DbT2008ShotokuEntityGenerator.DEFAULT_非課税区分（住民税減免前）));
        }

        @Test
        public void 戻り値の非課税区分（住民税減免後）は_設定した値と同じ非課税区分（住民税減免後）を返す() {
            business = sut.set非課税区分（住民税減免後）(DbT2008ShotokuEntityGenerator.DEFAULT_非課税区分（住民税減免後）).build();
            assertThat(business.get非課税区分（住民税減免後）(), is(DbT2008ShotokuEntityGenerator.DEFAULT_非課税区分（住民税減免後）));
        }

        @Test
        public void 戻り値の合計所得金額は_設定した値と同じ合計所得金額を返す() {
            business = sut.set合計所得金額(DbT2008ShotokuEntityGenerator.DEFAULT_合計所得金額).build();
            assertThat(business.get合計所得金額(), is(DbT2008ShotokuEntityGenerator.DEFAULT_合計所得金額));
        }

        @Test
        public void 戻り値の公的年金収入額は_設定した値と同じ公的年金収入額を返す() {
            business = sut.set公的年金収入額(DbT2008ShotokuEntityGenerator.DEFAULT_公的年金収入額).build();
            assertThat(business.get公的年金収入額(), is(DbT2008ShotokuEntityGenerator.DEFAULT_公的年金収入額));
        }

        @Test
        public void 戻り値の激変緩和措置区分は_設定した値と同じ激変緩和措置区分を返す() {
            business = sut.set激変緩和措置区分(DbT2008ShotokuEntityGenerator.DEFAULT_激変緩和措置区分).build();
            assertThat(business.get激変緩和措置区分(), is(DbT2008ShotokuEntityGenerator.DEFAULT_激変緩和措置区分));
        }

    }
}
