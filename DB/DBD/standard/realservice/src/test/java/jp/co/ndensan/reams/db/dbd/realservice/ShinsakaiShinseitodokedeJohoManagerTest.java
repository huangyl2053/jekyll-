/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.realservice;

import jp.co.ndensan.reams.db.dbd.business.IShinseitodokedeJoho;
import jp.co.ndensan.reams.db.dbd.business.ShinsakaiShinseitodokedeJoho;
import jp.co.ndensan.reams.db.dbd.entity.basic.DbT5120ShinseitodokedeJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.basic.helper.DbT5120ShinseitodokedeJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbd.persistence.basic.DbT5120ShinsakaiShinseitodokedeJohoDac;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestBase;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

/**
 * {link ShinsakaiShinseitodokedeJohoManager}のテストクラスです。
 *
 * @author n8223 朴義一
 */
@RunWith(Enclosed.class)
public class ShinsakaiShinseitodokedeJohoManagerTest {

    private static final ShinseishoKanriNo 申請管理番号 = new ShinseishoKanriNo("0000000001");
    private static final ShinseishoKanriNo notFound申請管理番号 = new ShinseishoKanriNo("9000000001");

    private static ShinsakaiShinseitodokedeJohoManager sut;
    private static DbT5120ShinsakaiShinseitodokedeJohoDac dac;

    @BeforeClass
    public static void setUp() {
        dac = mock(DbT5120ShinsakaiShinseitodokedeJohoDac.class);
        sut = new ShinsakaiShinseitodokedeJohoManager(dac);
    }

    public ShinsakaiShinseitodokedeJohoManagerTest() {
    }

    /**
     * Test of find申請届出者情報 method, of class ShinsakaiShinseitodokedeJohoManager.
     */
    public static class testFind申請届出者情報 extends DbdTestBase {

        private static IShinseitodokedeJoho createBusiness(ShinseishoKanriNo 申請管理番号) {

            IShinseitodokedeJoho business = mock(IShinseitodokedeJoho.class);
            when(business.get申請書管理番号()).thenReturn(申請管理番号);

            return business;
        }

        @Test
        public void testFind申請届出者情報_該当の情報がないとき_Optionalのemptyを返す() {
            Optional<DbT5120ShinseitodokedeJohoEntity> entity = Optional.empty();
            Optional<IShinseitodokedeJoho> business = Optional.empty();

            when(dac.selectByKey(notFound申請管理番号)).thenReturn(entity);
            Optional<IShinseitodokedeJoho> result = sut.find申請届出者情報(notFound申請管理番号);
            assertThat(result, is(business));
        }

        @Test
        public void testFind申請届出者情報_該当の情報があるとき_該当情報を返す() {
            ShinseishoKanriNo DEFAULT_申請管理番号 = new ShinseishoKanriNo("0000000001");

            IShinseitodokedeJoho business = createBusiness(DEFAULT_申請管理番号);

            Optional<DbT5120ShinseitodokedeJohoEntity> entity = Optional.ofNullable(DbT5120ShinseitodokedeJohoEntityGenerator.createDbT5120ShinseitodokedeJohoEntity());

            when(dac.selectByKey(申請管理番号)).thenReturn(entity);
            Optional<IShinseitodokedeJoho> result = sut.find申請届出者情報(申請管理番号);
            assertThat(result.get().get申請書管理番号().value(), is(business.get申請書管理番号().value()));
        }
    }

    public static class save申請届出者情報のテスト extends DbdTestBase {

        @Test
        public void insertに成功すると1が返る() {
            when(dac.insert(any(DbT5120ShinseitodokedeJohoEntity.class))).thenReturn(1);

            IShinseitodokedeJoho renrakusaki = new ShinsakaiShinseitodokedeJoho(DbT5120ShinseitodokedeJohoEntityGenerator.createDbT5120ShinseitodokedeJohoEntity());

            assertThat(sut.save申請届出者情報(renrakusaki), is(1));
        }

        @Test
        public void updateに成功すると1が返る() {
            when(dac.update(any(DbT5120ShinseitodokedeJohoEntity.class))).thenReturn(1);

            ShinsakaiShinseitodokedeJoho renrakusaki = new ShinsakaiShinseitodokedeJoho(DbT5120ShinseitodokedeJohoEntityGenerator.createDbT5120ShinseitodokedeJohoEntity());
            renrakusaki.getEntity().initializeMd5();
            ShinsakaiShinseitodokedeJoho.Builder createBuilderForEdit = renrakusaki.createBuilderForEdit();
            createBuilderForEdit.setShinseiTodokedeshaShimei(AtenaMeisho.EMPTY);
            IShinseitodokedeJoho build = createBuilderForEdit.build();

            assertThat(sut.save申請届出者情報(build), is(1));
        }

        @Test
        public void deleteに成功すると1が返る() {
            when(dac.delete(any(DbT5120ShinseitodokedeJohoEntity.class))).thenReturn(1);

            ShinsakaiShinseitodokedeJoho renrakusaki = new ShinsakaiShinseitodokedeJoho(DbT5120ShinseitodokedeJohoEntityGenerator.createDbT5120ShinseitodokedeJohoEntity());
            renrakusaki.getEntity().initializeMd5();
            renrakusaki.setDeletedState(true);

            assertThat(sut.save申請届出者情報(renrakusaki), is(1));
        }

        @Test(expected = ApplicationException.class)
        public void ビジネスクラスの状態がUnchangedの場合_ApplicationExceptionが発生する() {

            ShinsakaiShinseitodokedeJoho renrakusaki = new ShinsakaiShinseitodokedeJoho(DbT5120ShinseitodokedeJohoEntityGenerator.createDbT5120ShinseitodokedeJohoEntity());
            renrakusaki.getEntity().initializeMd5();

            sut.save申請届出者情報(renrakusaki);
        }
    }
}
