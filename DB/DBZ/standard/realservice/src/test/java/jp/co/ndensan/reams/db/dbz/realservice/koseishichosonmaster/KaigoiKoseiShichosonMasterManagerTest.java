/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.koseishichosonmaster;

import jp.co.ndensan.reams.db.dbz.business.koseishichosonmaster.IKoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7051KoseiShichosonMasterEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT7051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.hamcrest.CoreMatchers.is;

/**
 * {link KaigoiKoseiShichosonMasterManager}のテストクラスです。
 *
 * @author n8223　朴義一
 */
@RunWith(Enclosed.class)
public class KaigoiKoseiShichosonMasterManagerTest extends DbzTestBase {

    private static final RString 市町村識別ID = DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_市町村識別ID;
    private static final RString notFound市町村識別ID = new RString("2");

    public KaigoiKoseiShichosonMasterManagerTest() {
    }

    /**
     * Test of find構成市町村 method, of class KaigoiKoseiShichosonMasterManager.
     */
    public static class testFind構成市町村 extends DbzTestBase {

        private KaigoiKoseiShichosonMasterManager sut;
        private DbT7051KoseiShichosonMasterDac dac;

        @Before
        public void setUp() {
            dac = mock(DbT7051KoseiShichosonMasterDac.class);
            sut = new KaigoiKoseiShichosonMasterManager(dac);
        }

        private static IKoseiShichosonMaster createBusines(RString DEFAULT_市町村識別ID) {
            IKoseiShichosonMaster business = mock(IKoseiShichosonMaster.class);
            when(business.get市町村識別ID()).thenReturn(DEFAULT_市町村識別ID);
            return business;
        }

        @Test
        public void testFind構成市町村_該当の情報がないとき_Optionalのemptyを返す() {
            Optional<DbT7051KoseiShichosonMasterEntity> entity = Optional.empty();
            Optional<IKoseiShichosonMaster> business = Optional.empty();

            when(dac.selectByKey(notFound市町村識別ID)).thenReturn(entity);
            Optional<IKoseiShichosonMaster> result = sut.find構成市町村(notFound市町村識別ID);
            assertThat(result, is(business));
        }

        @Test
        public void testFind構成市町村_該当の情報があるとき_該当情報を返す() {
            RString DEFAULT_市町村識別ID = new RString("1");
            IKoseiShichosonMaster business = createBusines(DEFAULT_市町村識別ID);

            when(dac.selectByKey(市町村識別ID)).thenReturn(
                    Optional.ofNullable(DbT7051KoseiShichosonMasterEntityGenerator.createDbT7051KoseiShichosonMasterEntity()));
            Optional<IKoseiShichosonMaster> result = sut.find構成市町村(市町村識別ID);
            assertThat(result.get().get市町村識別ID(), is(business.get市町村識別ID()));
        }

    }

}
