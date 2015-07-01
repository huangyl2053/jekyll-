/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.realservice.HokenshaChosaltakusakiJohoManager;
import jp.co.ndensan.reams.db.dbz.business.HokenshaNinteichosaItakusakiJoho;
import jp.co.ndensan.reams.db.dbz.business.INinteichosaItakusakiJoho;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT4910NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT4910NinteichosaItakusakiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT4910NinteichosaItakusakiJohoDac;
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
import static org.mockito.Mockito.any;

/**
 * {link HokenshaChosaltakusakiJohoManager}のテストクラスです。
 *
 * @author n8223　朴義一
 */
@RunWith(Enclosed.class)
public class HokenshaChosaltakusakiJohoManagerTest {

    private static final LasdecCode 市町村コード = new LasdecCode("123456");
    private static final ChosaItakusakiCode 認定調査委託先コード = new ChosaItakusakiCode("1234567890");

    private static final LasdecCode notFound市町村コード = new LasdecCode("123456");
    private static final ChosaItakusakiCode notFound認定調査委託先コード = new ChosaItakusakiCode("1234567890");

    private static HokenshaChosaltakusakiJohoManager sut;
    private static DbT4910NinteichosaItakusakiJohoDac dac;

    public HokenshaChosaltakusakiJohoManagerTest() {
    }

    /**
     * Test of find調査委託先情報 method, of class HokenshaChosaltakusakiJohoManager.
     */
    public static class testFind調査委託先情報 extends DbdTestBase {

        @Before
        public void setUp() {
            dac = mock(DbT4910NinteichosaItakusakiJohoDac.class);
            sut = new HokenshaChosaltakusakiJohoManager(dac);
        }

        private INinteichosaItakusakiJoho createBusiness(LasdecCode 市町村コード, ChosaItakusakiCode 認定調査委託先コード) {
            INinteichosaItakusakiJoho business = mock(INinteichosaItakusakiJoho.class);
            when(business.get市町村コード()).thenReturn(市町村コード);
            when(business.get認定調査委託先コード()).thenReturn(認定調査委託先コード);
            return business;

        }

        @Test
        public void testFind調査委託先情報_該当の情報がないとき_Optionalのemptyを返す() {
            Optional<DbT4910NinteichosaItakusakiJohoEntity> entity = Optional.empty();
            Optional<INinteichosaItakusakiJoho> business = Optional.empty();

            when(dac.selectByKey(notFound市町村コード, notFound認定調査委託先コード)).thenReturn(entity);
            Optional<INinteichosaItakusakiJoho> result = sut.find調査委託先情報(notFound市町村コード, notFound認定調査委託先コード);
            assertThat(result, is(business));
        }

        @Test
        public void testFind調査委託先情報_該該当の情報があるとき_該当情報を返す() {
            LasdecCode DEFAULT_市町村コード = new LasdecCode("123456");
            ChosaItakusakiCode DEFAULT_認定調査委託先コード = new ChosaItakusakiCode("1234567890");

            INinteichosaItakusakiJoho business = createBusiness(DEFAULT_市町村コード, DEFAULT_認定調査委託先コード);

            Optional<DbT4910NinteichosaItakusakiJohoEntity> entity = Optional.ofNullable(DbT4910NinteichosaItakusakiJohoEntityGenerator.createDbT4910NinteichosaItakusakiJohoEntity());

            when(dac.selectByKey(市町村コード, 認定調査委託先コード)).thenReturn(entity);
            Optional<INinteichosaItakusakiJoho> result = sut.find調査委託先情報(市町村コード, 認定調査委託先コード);
            assertThat(result.get().get市町村コード().value(), is(business.get市町村コード().value()));
        }
    }

    public static class testSave調査委託先情報 extends DbdTestBase {

        @Before
        public void setUp() {
            dac = mock(DbT4910NinteichosaItakusakiJohoDac.class);
            sut = new HokenshaChosaltakusakiJohoManager(dac);
        }

        @Test
        public void insertに成功すると1が返る() {
            when(dac.insert(any(DbT4910NinteichosaItakusakiJohoEntity.class))).thenReturn(1);
            INinteichosaItakusakiJoho hokenshaChosainjoho = new HokenshaNinteichosaItakusakiJoho(DbT4910NinteichosaItakusakiJohoEntityGenerator.createDbT4910NinteichosaItakusakiJohoEntity());
            assertThat(sut.save調査委託先(hokenshaChosainjoho), is(1));
        }

        @Test
        public void updateに成功すると1が返る() {
            when(dac.update(any(DbT4910NinteichosaItakusakiJohoEntity.class))).thenReturn(1);
            HokenshaNinteichosaItakusakiJoho hokenshaNinteichosaItakusakiJoho = new HokenshaNinteichosaItakusakiJoho(DbT4910NinteichosaItakusakiJohoEntityGenerator.createDbT4910NinteichosaItakusakiJohoEntity());
            hokenshaNinteichosaItakusakiJoho.getEntity().initializeMd5();
            //編集
            HokenshaNinteichosaItakusakiJoho.Builder createBuilderForEdit = hokenshaNinteichosaItakusakiJoho.createBuilderForEdit();
            createBuilderForEdit.setJusho(new RString("アドレス"));
            INinteichosaItakusakiJoho build = createBuilderForEdit.build();
            assertThat(sut.save調査委託先(build), is(1));
        }

        @Test
        public void deleteに成功すると1が返る() {
            when(dac.delete(any(DbT4910NinteichosaItakusakiJohoEntity.class))).thenReturn(1);
            HokenshaNinteichosaItakusakiJoho hokenshaNinteichosaItakusakiJoho = new HokenshaNinteichosaItakusakiJoho(DbT4910NinteichosaItakusakiJohoEntityGenerator.createDbT4910NinteichosaItakusakiJohoEntity());
            hokenshaNinteichosaItakusakiJoho.getEntity().initializeMd5();
            hokenshaNinteichosaItakusakiJoho.setDeletedState(true);

            assertThat(sut.save調査委託先(hokenshaNinteichosaItakusakiJoho), is(1));
        }

        @Test
        public void ビジネスクラスの状態がUnchangedの場合_ApplicationExceptionが発生する() {
            HokenshaNinteichosaItakusakiJoho hokenshaNinteichosaItakusakiJoho = new HokenshaNinteichosaItakusakiJoho(DbT4910NinteichosaItakusakiJohoEntityGenerator.createDbT4910NinteichosaItakusakiJohoEntity());
            hokenshaNinteichosaItakusakiJoho.getEntity().initializeMd5();
            sut.save調査委託先(hokenshaNinteichosaItakusakiJoho);
        }
    }

}
