/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5224ChikuShichosonEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5224ChikuShichosonEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ChikuShichosonBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ChikuShichosonBuilderTest extends DbzTestBase {

    private static DbT5224ChikuShichosonEntity chikuShichosonEntity;
    private static Code 調査地区コード;
    private static LasdecCode 市町村コード;

    @BeforeClass
    public static void setUpClass() {
        調査地区コード = DbT5224ChikuShichosonEntityGenerator.DEFAULT_調査地区コード;
        市町村コード = DbT5224ChikuShichosonEntityGenerator.DEFAULT_市町村コード;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static ChikuShichosonBuilder sut;
        private static ChikuShichoson business;

        @Before
        public void setUp() {
            chikuShichosonEntity = new DbT5224ChikuShichosonEntity();

            business = new ChikuShichoson(chikuShichosonEntity);

            sut = business.createBuilderForEdit();
        }

        @Test
        public void 戻り値の調査地区コードは_設定した値と同じ調査地区コードを返す() {
            business = sut.set調査地区コード(DbT5224ChikuShichosonEntityGenerator.DEFAULT_調査地区コード).build();
            assertThat(business.get調査地区コード(), is(DbT5224ChikuShichosonEntityGenerator.DEFAULT_調査地区コード));
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            business = sut.set市町村コード(DbT5224ChikuShichosonEntityGenerator.DEFAULT_市町村コード).build();
            assertThat(business.get市町村コード(), is(DbT5224ChikuShichosonEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の優先番号は_設定した値と同じ優先番号を返す() {
            business = sut.set優先番号(DbT5224ChikuShichosonEntityGenerator.DEFAULT_優先番号).build();
            assertThat(business.get優先番号(), is(DbT5224ChikuShichosonEntityGenerator.DEFAULT_優先番号));
        }

        @Test
        public void 戻り値の自地区フラグは_設定した値と同じ自地区フラグを返す() {
            business = sut.set自地区フラグ(DbT5224ChikuShichosonEntityGenerator.DEFAULT_自地区フラグ).build();
            assertThat(business.is自地区フラグ(), is(DbT5224ChikuShichosonEntityGenerator.DEFAULT_自地区フラグ));
        }

    }
}
