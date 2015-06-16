/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.realservice;

import jp.co.ndensan.reams.db.dbd.business.INinteichosaItakusakiJoho;
import jp.co.ndensan.reams.db.dbd.business.ShinsakaiNinteichosaItakusakiJoho;
import jp.co.ndensan.reams.db.dbd.definition.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbd.entity.basic.DbT5910NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.basic.helper.DbT5910NinteichosaItakusakiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbd.persistence.basic.DbT5910NinteichosaItakusakiJohoDac;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

/**
 * {link ShinsakaiChosaItakusakiManager}のテストクラスです。
 *
 * @author n8223　朴義一
 */
public class ShinsakaiChosaItakusakiManagerTest {

    private static final LasdecCode 市町村コード = new LasdecCode("123456");
    private static final ChosaItakusakiCode 認定調査委託先コード = new ChosaItakusakiCode("1234567890");

    private static final LasdecCode notFound市町村コード = new LasdecCode("523456");
    private static final ChosaItakusakiCode notFound認定調査委託先コード = new ChosaItakusakiCode("1234567891");

    private static ShinsakaiChosaItakusakiManager sut;
    private static DbT5910NinteichosaItakusakiJohoDac dac;

    public ShinsakaiChosaItakusakiManagerTest() {
    }

    /**
     * Test of find調査委託先情報 method, of class ShinsakaiChosaItakusakiManager.
     */
    public static class testFind調査委託先情報 extends DbdTestBase {

        @Before
        public void setUp() {
            dac = mock(DbT5910NinteichosaItakusakiJohoDac.class);
            sut = new ShinsakaiChosaItakusakiManager(dac);
        }

        private INinteichosaItakusakiJoho createBusiness(LasdecCode 市町村コード, ChosaItakusakiCode 認定調査委託先コード) {
            INinteichosaItakusakiJoho business = mock(INinteichosaItakusakiJoho.class);
            when(business.get市町村コード()).thenReturn(市町村コード);
            when(business.get認定調査委託先コード()).thenReturn(認定調査委託先コード);
            return business;

        }

        @Test
        public void testFind調査委託先情報_該当の情報がないとき_Optionalのemptyを返す() {
            Optional<DbT5910NinteichosaItakusakiJohoEntity> entity = Optional.empty();
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

            Optional<DbT5910NinteichosaItakusakiJohoEntity> entity = Optional.ofNullable(DbT5910NinteichosaItakusakiJohoEntityGenerator.createDbT5910NinteichosaItakusakiJohoEntity());

            when(dac.selectByKey(市町村コード, 認定調査委託先コード)).thenReturn(entity);
            Optional<INinteichosaItakusakiJoho> result = sut.find調査委託先情報(市町村コード, 認定調査委託先コード);
            assertThat(result.get().get市町村コード().value(), is(business.get市町村コード().value()));
        }
    }

    public static class testSave調査委託先情報 extends DbdTestBase {

        @Before
        public void setUp() {
            dac = mock(DbT5910NinteichosaItakusakiJohoDac.class);
            sut = new ShinsakaiChosaItakusakiManager(dac);
        }

        @Test
        public void insertに成功すると1が返る() {
            when(dac.insert(any(DbT5910NinteichosaItakusakiJohoEntity.class))).thenReturn(1);
            INinteichosaItakusakiJoho shinsakaiNinteichosaItakusakiJoho = new ShinsakaiNinteichosaItakusakiJoho(DbT5910NinteichosaItakusakiJohoEntityGenerator.createDbT5910NinteichosaItakusakiJohoEntity());
            assertThat(sut.save調査委託先(shinsakaiNinteichosaItakusakiJoho), is(1));
        }

        @Test
        public void updateに成功すると1が返る() {
            when(dac.update(any(DbT5910NinteichosaItakusakiJohoEntity.class))).thenReturn(1);
            ShinsakaiNinteichosaItakusakiJoho shinsakaiNinteichosaItakusakiJoho = new ShinsakaiNinteichosaItakusakiJoho(DbT5910NinteichosaItakusakiJohoEntityGenerator.createDbT5910NinteichosaItakusakiJohoEntity());
            shinsakaiNinteichosaItakusakiJoho.getEntity().initializeMd5();
            //編集
            ShinsakaiNinteichosaItakusakiJoho.Builder createBuilderForEdit = shinsakaiNinteichosaItakusakiJoho.createBuilderForEdit();
            createBuilderForEdit.setJusho(new RString("アドレス"));
            INinteichosaItakusakiJoho build = createBuilderForEdit.build();
            assertThat(sut.save調査委託先(build), is(1));
        }

        @Test
        public void deleteに成功すると1が返る() {
            when(dac.delete(any(DbT5910NinteichosaItakusakiJohoEntity.class))).thenReturn(1);
            ShinsakaiNinteichosaItakusakiJoho shinsakaiNinteichosaItakusakiJoho = new ShinsakaiNinteichosaItakusakiJoho(DbT5910NinteichosaItakusakiJohoEntityGenerator.createDbT5910NinteichosaItakusakiJohoEntity());
            shinsakaiNinteichosaItakusakiJoho.getEntity().initializeMd5();
            shinsakaiNinteichosaItakusakiJoho.setDeletedState(true);

            assertThat(sut.save調査委託先(shinsakaiNinteichosaItakusakiJoho), is(1));
        }

        @Test
        public void ビジネスクラスの状態がUnchangedの場合_ApplicationExceptionが発生する() {
            ShinsakaiNinteichosaItakusakiJoho shinsakaiNinteichosaItakusakiJoho = new ShinsakaiNinteichosaItakusakiJoho(DbT5910NinteichosaItakusakiJohoEntityGenerator.createDbT5910NinteichosaItakusakiJohoEntity());
            shinsakaiNinteichosaItakusakiJoho.getEntity().initializeMd5();
            sut.save調査委託先(shinsakaiNinteichosaItakusakiJoho);
        }
    }

}
