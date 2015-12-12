/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbb.entity.db.relate.choshuyuyo;

import java.util.Arrays;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choshuyuyo.DbT2006ChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choshuyuyo.DbT2007KibetsuChoshuYuyoEntity;
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
public class ChoshuYuyoEntityTest extends DbbTestBase {

    private static ChoshuYuyoEntity sut;

    public static class 新規作成時 extends DbbTestBase {

        @Before
        public void setUp() {
            createEntity();
        }

        @Test
        public void DbT2006ChoshuYuyoEntityの_EntityStateは_Added() {
            assertThat(sut.get介護賦課徴収猶予Entity().getState(), is(EntityDataState.Added));
        }

        @Test
        public void DbT2007KibetsuChoshuYuyoEntityの_EntityStateは_Added() {
            assertThat(sut.get介護期別徴収猶予Entity().get(0).getState(), is(EntityDataState.Added));
        }

    }

    public static class initializeMd5ToEntities後 extends DbbTestBase {

        @Before
        public void setUp() {
            createEntity();
            sut.initializeMd5ToEntities();
        }

        @Test
        public void DbT2006ChoshuYuyoEntityの_EntityStateは_Unchanged() {
            sut.initializeMd5ToEntities();
            assertThat(sut.get介護賦課徴収猶予Entity().getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void DbT2007KibetsuChoshuYuyoEntityの_EntityStateは_Unchanged() {
            assertThat(sut.get介護期別徴収猶予Entity().get(0).getState(), is(EntityDataState.Unchanged));
        }
    }

    private static void createEntity() {
        sut = new ChoshuYuyoEntity();
        sut.set介護賦課徴収猶予Entity(new DbT2006ChoshuYuyoEntity());
        sut.set介護期別徴収猶予Entity(Arrays.asList(new DbT2007KibetsuChoshuYuyoEntity()));
    }
    
}
