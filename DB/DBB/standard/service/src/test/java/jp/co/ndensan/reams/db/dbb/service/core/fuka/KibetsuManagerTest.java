/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.fuka;

import jp.co.ndensan.reams.db.dbb.business.core.fuka.Kibetsu;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT2003KibetsuEntityGenerator;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT2003KibetsuDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link KibetsuManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KibetsuManagerTest {

    private static DbT2003KibetsuDac dac;
    private static KibetsuManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT2003KibetsuDac.class);
        sut = new KibetsuManager(dac);
    }

    public static class save介護期別 extends DbbTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT2003KibetsuEntity.class))).thenReturn(1);

            DbT2003KibetsuEntity entity = DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity();
            Kibetsu 介護期別 = new Kibetsu(entity);

            assertThat(sut.save介護期別(介護期別), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT2003KibetsuEntity.class))).thenReturn(0);

            DbT2003KibetsuEntity entity = DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity();
            Kibetsu 介護期別 = new Kibetsu(entity);

            assertThat(sut.save介護期別(介護期別), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT2003KibetsuEntity.class))).thenReturn(1);

            DbT2003KibetsuEntity entity = DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity();
            entity.initializeMd5();
            Kibetsu 介護期別 = new Kibetsu(entity);
            介護期別 = 介護期別.createBuilderForEdit().set調定ID(new Decimal("11")).build();

            assertThat(sut.save介護期別(介護期別), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT2003KibetsuEntity.class))).thenReturn(0);

            DbT2003KibetsuEntity entity = DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity();
            entity.initializeMd5();
            Kibetsu 介護期別 = new Kibetsu(entity);
            介護期別 = 介護期別.createBuilderForEdit().set調定ID(new Decimal("11")).build();

            assertThat(sut.save介護期別(介護期別), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT2003KibetsuEntity.class))).thenReturn(1);

            DbT2003KibetsuEntity entity = DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity();
            entity.initializeMd5();
            Kibetsu 介護期別 = new Kibetsu(entity);
            介護期別 = 介護期別.deleted();

            assertThat(sut.save介護期別(介護期別), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT2003KibetsuEntity.class))).thenReturn(0);

            DbT2003KibetsuEntity entity = DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity();
            entity.initializeMd5();
            Kibetsu 介護期別 = new Kibetsu(entity);
            介護期別 = 介護期別.deleted();

            assertThat(sut.save介護期別(介護期別), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT2003KibetsuEntity entity = DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity();
            entity.initializeMd5();
            Kibetsu 介護期別 = new Kibetsu(entity);

            assertThat(sut.save介護期別(介護期別), is(false));
        }
    }
}
