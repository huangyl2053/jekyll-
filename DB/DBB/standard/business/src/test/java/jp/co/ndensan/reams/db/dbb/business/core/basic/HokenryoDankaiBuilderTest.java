/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import jp.co.ndensan.reams.db.dbx.business.core.basic.HokenryoDankaiBuilder;
import jp.co.ndensan.reams.db.dbx.business.core.basic.HokenryoDankai;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2013HokenryoDankaiEntity;
import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2013HokenryoDankaiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.DankaiIndex;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link HokenryoDankaiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class HokenryoDankaiBuilderTest extends DbbTestBase {

    private static DbT2013HokenryoDankaiEntity HokenryoDankaiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleYear 賦課年度;
    private static RString 段階index;
    private static RString ランク区分;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        賦課年度 = DbT2013HokenryoDankaiEntityGenerator.DEFAULT_賦課年度;
        段階index = DbT2013HokenryoDankaiEntityGenerator.DEFAULT_段階インデックス;
    }

    public static class getterSetterTest extends DbbTestBase {

        private static HokenryoDankaiBuilder sut;
        private static HokenryoDankai business;

        @Before
        public void setUp() {
            HokenryoDankaiEntity = new DbT2013HokenryoDankaiEntity();
            HokenryoDankaiEntity.setFukaNendo(賦課年度);
            HokenryoDankaiEntity.setDankaiIndex(段階index);

            business = new HokenryoDankai(HokenryoDankaiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の賦課年度は_設定した値と同じ賦課年度を返す() {
            business = sut.set賦課年度(DbT2013HokenryoDankaiEntityGenerator.DEFAULT_賦課年度).build();
            assertThat(business.get賦課年度(), is(DbT2013HokenryoDankaiEntityGenerator.DEFAULT_賦課年度));
        }

        @Test
        public void 戻り値の段階インデックスは_設定した値と同じ段階インデックスを返す() {
            business = sut.set段階インデックス(DbT2013HokenryoDankaiEntityGenerator.DEFAULT_段階インデックス).build();
            assertThat(business.get段階インデックス(), is(DbT2013HokenryoDankaiEntityGenerator.DEFAULT_段階インデックス));
        }

        @Test
        public void 戻り値のランク区分は_設定した値と同じランク区分を返す() {
            business = sut.setランク区分(DbT2013HokenryoDankaiEntityGenerator.DEFAULT_ランク区分).build();
            assertThat(business.getランク区分(), is(DbT2013HokenryoDankaiEntityGenerator.DEFAULT_ランク区分));
        }

        @Test
        public void 戻り値の段階区分は_設定した値と同じ段階区分を返す() {
            business = sut.set段階区分(DbT2013HokenryoDankaiEntityGenerator.DEFAULT_段階区分).build();
            assertThat(business.get段階区分(), is(DbT2013HokenryoDankaiEntityGenerator.DEFAULT_段階区分));
        }

        @Test
        public void 戻り値の保険料率は_設定した値と同じ保険料率を返す() {
            business = sut.set保険料率(DbT2013HokenryoDankaiEntityGenerator.DEFAULT_保険料率).build();
            assertThat(business.get保険料率(), is(DbT2013HokenryoDankaiEntityGenerator.DEFAULT_保険料率));
        }

        @Test
        public void 戻り値の特例表記は_設定した値と同じ特例表記を返す() {
            business = sut.set特例表記(DbT2013HokenryoDankaiEntityGenerator.DEFAULT_特例表記).build();
            assertThat(business.get特例表記(), is(DbT2013HokenryoDankaiEntityGenerator.DEFAULT_特例表記));
        }

    }
}
