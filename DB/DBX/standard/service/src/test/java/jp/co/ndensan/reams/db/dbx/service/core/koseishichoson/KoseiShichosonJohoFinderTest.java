/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.koseishichoson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7051KoseiShichosonMasterEntityGenerator;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7051KoseiShichosonMasterDac;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

/**
 * {@link KoseiShichosonJohoFinder}のテストです。
 */
@RunWith(Enclosed.class)
public class KoseiShichosonJohoFinderTest {

    public KoseiShichosonJohoFinderTest() {
    }

    public static class createInstanceのtest {

        @Test
        public void testCreateInstance() {
            assertThat(KoseiShichosonJohoFinder.createInstance(), isA(KoseiShichosonJohoFinder.class));
        }
    }

    public static class get全市町村情報のtest {

        private KoseiShichosonJohoFinder sut;
        private DbT7051KoseiShichosonMasterDac dac;
        private List<DbT7051KoseiShichosonMasterEntity> list;

        @Before
        public void setUp() {
            dac = Mockito.mock(DbT7051KoseiShichosonMasterDac.class);
            sut = new KoseiShichosonJohoFinder(dac);
        }

        @Test
        public void get全市町村情報は_dacのselectZenShichosonJohoContainingKyuShichosonと同じsizeのListを返す() {
            list = entities();
            Mockito.when(dac.zenShichosonJoho()).thenReturn(list);
            assertThat(sut.get全市町村情報().size(), is(entities().size()));
        }

        @Test
        public void get全市町村情報は_dacのselectZenShichosonJohoContainingKyuShichosonが空のListを返す時_空のListを返す() {
            list = Collections.emptyList();
            Mockito.when(dac.zenShichosonJoho()).thenReturn(list);
            assertThat(sut.get全市町村情報().isEmpty(), is(true));
        }
    }

    private static List<DbT7051KoseiShichosonMasterEntity> entities() {
        List<DbT7051KoseiShichosonMasterEntity> list = new ArrayList<>();
        list.add(DbT7051KoseiShichosonMasterEntityGenerator.createDbT7051KoseiShichosonMasterEntity());
        list.add(DbT7051KoseiShichosonMasterEntityGenerator.createDbT7051KoseiShichosonMasterEntity());
        return list;
    }

    public static class get現市町村情報のtest {

        private KoseiShichosonJohoFinder sut;
        private DbT7051KoseiShichosonMasterDac dac;
        private List<DbT7051KoseiShichosonMasterEntity> list;

        @Before
        public void setUp() {
            dac = Mockito.mock(DbT7051KoseiShichosonMasterDac.class);
            sut = new KoseiShichosonJohoFinder(dac);
        }

        @Test
        public void get現市町村情報は_dacのselectPresenceShichosonJohoと同じsizeのListを返す() {
            list = entities();
            Mockito.when(dac.genShichosonJoho()).thenReturn(list);
            assertThat(sut.get現市町村情報().size(), is(entities().size()));
        }

        @Test
        public void get現市町村情報は_dacのselectPresenceShichosonJohoが空のListを返す時_空のListを返す() {
            list = Collections.emptyList();
            Mockito.when(dac.genShichosonJoho()).thenReturn(list);
            assertThat(sut.get現市町村情報().isEmpty(), is(true));
        }

    }
}
