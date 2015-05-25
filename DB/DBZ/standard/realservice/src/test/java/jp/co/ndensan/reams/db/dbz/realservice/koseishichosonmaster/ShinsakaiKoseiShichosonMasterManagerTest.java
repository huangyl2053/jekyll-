/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.koseishichosonmaster;

import jp.co.ndensan.reams.db.dbz.business.koseishichosonmaster.IKoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5051KoseiShichosonMasterEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT5051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link ShinsakaiKoseiShichosonMasterManager}のテストクラスです。
 *
 * @author n8223　朴義一
 */
@RunWith(Enclosed.class)
public class ShinsakaiKoseiShichosonMasterManagerTest {

    private static final RString 市町村識別ID = DbT5051KoseiShichosonMasterEntityGenerator.DEFAULT_市町村識別ID;
    private static final RString notFound市町村識別ID = new RString("2");

    public ShinsakaiKoseiShichosonMasterManagerTest() {
    }

    /**
     * Test of find構成市町村 method, of class ShinsakaiKoseiShichosonMasterManager
     */
    public static class testFind構成市町村 extends DbzTestBase {

        private ShinsakaiKoseiShichosonMasterManager sut;
        private DbT5051KoseiShichosonMasterDac dac;

        @Before
        public void setUp() {
            dac = mock(DbT5051KoseiShichosonMasterDac.class);
            sut = new ShinsakaiKoseiShichosonMasterManager(dac);
        }

        private static IKoseiShichosonMaster createBusines(RString DEFAULT_市町村識別ID) {
            IKoseiShichosonMaster business = mock(IKoseiShichosonMaster.class);
            when(business.get市町村識別ID()).thenReturn(DEFAULT_市町村識別ID);
            return business;
        }

        @Test
        public void testFind構成市町村_該当の情報がないとき_Optionalのemptyを返す() {
            Optional<DbT5051KoseiShichosonMasterEntity> entity = Optional.empty();
            Optional<IKoseiShichosonMaster> business = Optional.empty();

            when(dac.selectByKey(notFound市町村識別ID)).thenReturn(entity);
            Optional<IKoseiShichosonMaster> result = sut.find構成市町村(notFound市町村識別ID);
            assertThat(result, is(business));
        }

        @Test
        public void testFind構成市町村_該当の情報があるとき_該当情報を返す() {
            System.out.println("Find構成市町村");
            RString DEFAULT_市町村識別ID = new RString("1");
            IKoseiShichosonMaster business = createBusines(DEFAULT_市町村識別ID);
            when(dac.selectByKey(市町村識別ID)).thenReturn(
                    Optional.ofNullable(DbT5051KoseiShichosonMasterEntityGenerator.createDbT5051KoseiShichosonMasterEntity()));
            Optional<IKoseiShichosonMaster> result = sut.find構成市町村(市町村識別ID);
            assertThat(result.get().get市町村識別ID(), is(business.get市町村識別ID()));
        }

    }

}
