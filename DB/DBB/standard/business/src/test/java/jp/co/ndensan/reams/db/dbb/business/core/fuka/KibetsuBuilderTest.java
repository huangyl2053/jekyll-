/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.fuka;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT2003KibetsuEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KibetsuBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KibetsuBuilderTest extends DbbTestBase {

    private static DbT2003KibetsuEntity kibetsuEntity;

    public static class getterSetterTest extends DbbTestBase {

        private static KibetsuBuilder sut;
        private static Kibetsu business;

        @Before
        public void setUp() {
            kibetsuEntity = new DbT2003KibetsuEntity();

            business = new Kibetsu(kibetsuEntity);

            sut = business.createBuilderForEdit();
        }

        @Test
        public void 戻り値の調定IDは_設定した値と同じ調定IDを返す() {
            business = sut.set調定ID(DbT2003KibetsuEntityGenerator.DEFAULT_調定ID).build();
            assertThat(business.get調定ID(), is(DbT2003KibetsuEntityGenerator.DEFAULT_調定ID));
        }

    }
}
