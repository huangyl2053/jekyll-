/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.realservice;

import jp.co.ndensan.reams.db.dbd.business.INinteiKekkaJoho;
import jp.co.ndensan.reams.db.dbd.entity.basic.DbT4102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.basic.helper.DbT4102NinteiKekkaJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbd.persistence.basic.DbT4102HokenshaNinteiKekkaJohoDac;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author n8223
 */
@RunWith(Enclosed.class)
public class HokenshaNinteiKekkaJohoManagerTest {

    private static final ShinseishoKanriNo 申請管理番号 = DbT4102NinteiKekkaJohoEntityGenerator.DEFAULT_申請書管理番号;
    private static final ShinseishoKanriNo notFound申請管理番号 = new ShinseishoKanriNo("92345678901234567");

    public HokenshaNinteiKekkaJohoManagerTest() {
    }

    /**
     * Test of find要介護認定結果情報 method, of class HokenshaNinteiKekkaJohoManager.
     */
    public static class testFind要介護認定結果情報 extends DbdTestBase {

        private HokenshaNinteiKekkaJohoManager sut;
        private DbT4102HokenshaNinteiKekkaJohoDac dac;

        @Before
        public void setUp() {
            dac = mock(DbT4102HokenshaNinteiKekkaJohoDac.class);
            sut = new HokenshaNinteiKekkaJohoManager(dac);
        }

        private static INinteiKekkaJoho createBusiness(ShinseishoKanriNo 申請管理番号) {
            INinteiKekkaJoho business = mock(INinteiKekkaJoho.class);
            when(business.get申請書管理番号()).thenReturn(申請管理番号);
            return business;
        }

        @Test
        public void testFind要介護認定結果情報は_該当の情報がないとき_Optionalのemptyを返す() {
            Optional<DbT4102NinteiKekkaJohoEntity> entity = Optional.empty();
            Optional<INinteiKekkaJoho> business = Optional.empty();

            when(dac.selectByKey(notFound申請管理番号)).thenReturn(entity);
            Optional<INinteiKekkaJoho> result = sut.find要介護認定結果情報(notFound申請管理番号);
            assertThat(result, is(business));

        }

        @Test
        public void testFind要介護認定結果情報は_該当の情報があるとき_該当情報を返す() {
            ShinseishoKanriNo DEFAULT_申請管理番号 = new ShinseishoKanriNo("00000000000000002");
            INinteiKekkaJoho business = createBusiness(DEFAULT_申請管理番号);

            Optional<DbT4102NinteiKekkaJohoEntity> entity = Optional.ofNullable(DbT4102NinteiKekkaJohoEntityGenerator.createDbT4102NinteiKekkaJohoEntity());

            when(dac.selectByKey(申請管理番号)).thenReturn(entity);
            Optional<INinteiKekkaJoho> result = sut.find要介護認定結果情報(申請管理番号);
            assertThat(result.get().get申請書管理番号(), is(business.get申請書管理番号()));

        }

    }

}
