/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.realservice;

import db.dbd.definition.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.db.dbd.business.IShujiiIryokikanJoho;
import jp.co.ndensan.reams.db.dbd.entity.basic.DbT4911ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.basic.helper.DbT4911ShujiiIryoKikanJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbd.persistence.basic.DbT4911ShujiiIryoKikanJohoDac;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {@link HokenshaShujiiIryokikanManager}のテストクラスです。
 *
 * @author N8235 船山 洋介
 */
@RunWith(Enclosed.class)
public class HokenshaShujiiIryokikanManagerTest {

    public static class find主治医医療機関 extends DbdTestBase {

        public static final LasdecCode Found市町村コード = new LasdecCode("100001");
        public static final ShujiiIryokikanCode Found主治医医療機関コード = new ShujiiIryokikanCode("1000000001");
        public static final LasdecCode notFound市町村コード = new LasdecCode("999999");

        private HokenshaShujiiIryokikanManager sut;
        private DbT4911ShujiiIryoKikanJohoDac dac;

        @Before
        public void setUp() {
            dac = mock(DbT4911ShujiiIryoKikanJohoDac.class);
            sut = new HokenshaShujiiIryokikanManager(dac);
        }

        private static IShujiiIryokikanJoho createBusiness(
                LasdecCode 市町村コード, ShujiiIryokikanCode 主治医医療機関コード) {
            IShujiiIryokikanJoho business = mock(IShujiiIryokikanJoho.class);
            when(business.get市町村コード()).thenReturn(市町村コード);
            when(business.get主治医医療機関コード()).thenReturn(主治医医療機関コード);
            return business;
        }

        @Test
        public void find認定申請情報は_該当の情報がない時_Optionalのemptyを返す() {
            Optional<IShujiiIryokikanJoho> empty = Optional.empty();
            Optional<DbT4911ShujiiIryoKikanJohoEntity> entity = Optional.empty();
            when(dac.selectByKey(notFound市町村コード, Found主治医医療機関コード)).thenReturn(entity);
            Optional<IShujiiIryokikanJoho> result = sut.find主治医医療機関(notFound市町村コード, Found主治医医療機関コード);

            assertThat(result, is(empty));
        }

        @Test
        public void find認定申請情報は_該当の情報がある時_該当情報を返す() {
            when(dac.selectByKey(Found市町村コード, Found主治医医療機関コード)).thenReturn(
                    Optional.ofNullable(DbT4911ShujiiIryoKikanJohoEntityGenerator.createDbT4911ShujiiIryoKikanJohoEntity()));
            Optional<IShujiiIryokikanJoho> result = sut.find主治医医療機関(Found市町村コード, Found主治医医療機関コード);
            assertThat(result.get().get主治医医療機関コード(), is(createBusiness(Found市町村コード, Found主治医医療機関コード).get主治医医療機関コード()));
        }
    }
}
