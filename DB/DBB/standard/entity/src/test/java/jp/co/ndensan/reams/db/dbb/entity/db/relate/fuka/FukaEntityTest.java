/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbb.entity.db.relate.fuka;

import java.util.Arrays;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.fuka.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.fuka.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 *
 * @author LDNS 張　浩星
 */
@RunWith(Enclosed.class)
public class FukaEntityTest extends DbbTestBase {

    private static FukaEntity sut;

    public static class 新規作成時 extends DbbTestBase {

        @Before
        public void setUp() {
            createEntity();
        }

        @Test
        public void DbT2002FukaEntityの_EntityStateは_Added() {
            assertThat(sut.get介護賦課Entity().getState(), is(EntityDataState.Added));
        }

        @Test
        public void DbT2003KibetsuEntityの_EntityStateは_Added() {
            assertThat(sut.get介護期別Entity().get(0).getState(), is(EntityDataState.Added));
        }

    }

    public static class initializeMd5ToEntities後 extends DbbTestBase {

        @Before
        public void setUp() {
            createEntity();
            sut.initializeMd5ToEntities();
        }

        @Test
        public void DbT2002FukaEntityの_EntityStateは_Unchanged() {
            sut.initializeMd5ToEntities();
            assertThat(sut.get介護賦課Entity().getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void DbT2003KibetsuEntityの_EntityStateは_Unchanged() {
            assertThat(sut.get介護期別Entity().get(0).getState(), is(EntityDataState.Unchanged));
        }
    }

    private static void createEntity() {
        sut = new FukaEntity();
        sut.set介護賦課Entity(new DbT2002FukaEntity());
        sut.set介護期別Entity(Arrays.asList(new DbT2003KibetsuEntity()));
    }
    
}
