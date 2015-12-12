/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import jp.co.ndensan.reams.db.dbb.entity.db.basic.hokenryorank.DbT2012HokenryoRankEntity;
import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2012HokenryoRankEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link HokenryoRankBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class HokenryoRankBuilderTest extends DbbTestBase {

    private static DbT2012HokenryoRankEntity HokenryoRankEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleYear 賦課年度;
    private static LasdecCode 市町村コード;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        賦課年度 = DbT2012HokenryoRankEntityGenerator.DEFAULT_賦課年度;
        市町村コード = DbT2012HokenryoRankEntityGenerator.DEFAULT_市町村コード;
    }

    public static class getterSetterTest extends DbbTestBase {

        private static HokenryoRankBuilder sut;
        private static HokenryoRank business;

        @Before
        public void setUp() {
            HokenryoRankEntity = new DbT2012HokenryoRankEntity();
            HokenryoRankEntity.setFukaNendo(賦課年度);
            HokenryoRankEntity.setShichosonCode(市町村コード);

            business = new HokenryoRank(HokenryoRankEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の賦課年度は_設定した値と同じ賦課年度を返す() {
            business = sut.set賦課年度(DbT2012HokenryoRankEntityGenerator.DEFAULT_賦課年度).build();
            assertThat(business.get賦課年度(), is(DbT2012HokenryoRankEntityGenerator.DEFAULT_賦課年度));
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            business = sut.set市町村コード(DbT2012HokenryoRankEntityGenerator.DEFAULT_市町村コード).build();
            assertThat(business.get市町村コード(), is(DbT2012HokenryoRankEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値のランク区分は_設定した値と同じランク区分を返す() {
            business = sut.setランク区分(DbT2012HokenryoRankEntityGenerator.DEFAULT_ランク区分).build();
            assertThat(business.getランク区分(), is(DbT2012HokenryoRankEntityGenerator.DEFAULT_ランク区分));
        }

        @Test
        public void 戻り値の遡及年度は_設定した値と同じ遡及年度を返す() {
            business = sut.set遡及年度(DbT2012HokenryoRankEntityGenerator.DEFAULT_遡及年度).build();
            assertThat(business.get遡及年度(), is(DbT2012HokenryoRankEntityGenerator.DEFAULT_遡及年度));
        }

    }
}
