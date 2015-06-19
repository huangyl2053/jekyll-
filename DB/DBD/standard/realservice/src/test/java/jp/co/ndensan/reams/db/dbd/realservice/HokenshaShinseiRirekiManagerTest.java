/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.realservice;

import jp.co.ndensan.reams.db.dbd.business.HokenshaShinseiRirekiJoho;
import jp.co.ndensan.reams.db.dbd.business.IShinseiRirekiJoho;
import jp.co.ndensan.reams.db.dbd.entity.basic.DbT4121ShinseiRirekiJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.basic.helper.DbT4121ShinseiRirekiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbd.persistence.basic.DbT4121ShinseiRirekiJohoDac;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestBase;
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
 * {link HokenshaShinseiRirekiManager}のテストクラスです。
 *
 * @author n8223　朴義一
 */
@RunWith(Enclosed.class)
public class HokenshaShinseiRirekiManagerTest extends DbdTestBase {

    private static final ShinseishoKanriNo 申請管理番号 = new ShinseishoKanriNo("12345678901234567");
    private static final ShinseishoKanriNo notFound申請管理番号 = new ShinseishoKanriNo("92345678901234567");

    private static HokenshaShinseiRirekiManager sut;
    private static DbT4121ShinseiRirekiJohoDac dac;

    public HokenshaShinseiRirekiManagerTest() {
    }

    /**
     * Test of find申請履歴情報 method, of class HokenshaShinseiRirekiManager.
     */
    public static class testFind申請履歴情報 extends DbdTestBase {

        @Before
        public void setUp() {
            dac = mock(DbT4121ShinseiRirekiJohoDac.class);
            sut = new HokenshaShinseiRirekiManager(dac);
        }

        private static IShinseiRirekiJoho createBusiness(ShinseishoKanriNo 申請管理番号) {
            IShinseiRirekiJoho business = mock(IShinseiRirekiJoho.class);
            when(business.get申請管理番号()).thenReturn(申請管理番号);
            return business;
        }

        @Test
        public void testFind申請履歴情報は_該当の情報がないとき_Optionalのemptyを返す() {
            Optional<DbT4121ShinseiRirekiJohoEntity> entity = Optional.empty();
            Optional<IShinseiRirekiJoho> business = Optional.empty();

            when(dac.selectByKey(notFound申請管理番号)).thenReturn(entity);
            Optional<IShinseiRirekiJoho> result = sut.find申請履歴情報(notFound申請管理番号);
            assertThat(result, is(business));

        }

        @Test
        public void testFind申請履歴情報は_該当の情報があるとき_該当情報を返す() {
            ShinseishoKanriNo DEFAULT_申請管理番号 = new ShinseishoKanriNo("12345678901234567");
            IShinseiRirekiJoho business = createBusiness(DEFAULT_申請管理番号);

            Optional<DbT4121ShinseiRirekiJohoEntity> entity = Optional.ofNullable(DbT4121ShinseiRirekiJohoEntityGenerator.createDbT4121ShinseiRirekiJohoEntity());

            when(dac.selectByKey(申請管理番号)).thenReturn(entity);
            Optional<IShinseiRirekiJoho> result = sut.find申請履歴情報(申請管理番号);
            assertThat(result.get().get申請管理番号().value(), is(business.get申請管理番号().value()));
        }
    }

    public static class testSave申請履歴情報 extends DbdTestBase {

        @Before
        public void setUp() {
            dac = mock(DbT4121ShinseiRirekiJohoDac.class);
            sut = new HokenshaShinseiRirekiManager(dac);
        }

        @Test
        public void insertに成功すると1が返る() {
            when(dac.insert(any(DbT4121ShinseiRirekiJohoEntity.class))).thenReturn(1);
            IShinseiRirekiJoho shinseiRirekiJoho = new HokenshaShinseiRirekiJoho(DbT4121ShinseiRirekiJohoEntityGenerator.createDbT4121ShinseiRirekiJohoEntity());
            assertThat(sut.save申請履歴(shinseiRirekiJoho), is(1));
        }

        @Test
        public void updateに成功すると1が返る() {
            when(dac.update(any(DbT4121ShinseiRirekiJohoEntity.class))).thenReturn(1);
            HokenshaShinseiRirekiJoho hokenshaShinseiRirekiJoho = new HokenshaShinseiRirekiJoho(DbT4121ShinseiRirekiJohoEntityGenerator.createDbT4121ShinseiRirekiJohoEntity());
            hokenshaShinseiRirekiJoho.getEntity().initializeMd5();

            //編集
            HokenshaShinseiRirekiJoho.Builder createBuilderForEdit = hokenshaShinseiRirekiJoho.createBuilderForEdit();
            createBuilderForEdit.setZenkaiShinseishoKanriNo(notFound申請管理番号);
            IShinseiRirekiJoho build = createBuilderForEdit.build();
            assertThat(sut.save申請履歴(build), is(1));
        }

        @Test
        public void deleteに成功すると1が返る() {
            when(dac.delete(any(DbT4121ShinseiRirekiJohoEntity.class))).thenReturn(1);
            HokenshaShinseiRirekiJoho hokenshaShinseiRirekiJoho = new HokenshaShinseiRirekiJoho(DbT4121ShinseiRirekiJohoEntityGenerator.createDbT4121ShinseiRirekiJohoEntity());
            hokenshaShinseiRirekiJoho.getEntity().initializeMd5();
            hokenshaShinseiRirekiJoho.setDeletedState(true);
            assertThat(sut.save申請履歴(hokenshaShinseiRirekiJoho), is(1));
        }

        @Test
        public void ビジネスクラスの状態がUnchangedの場合_ApplicationExceptionが発生する() {
            HokenshaShinseiRirekiJoho hokenshaShinseiRirekiJoho = new HokenshaShinseiRirekiJoho(DbT4121ShinseiRirekiJohoEntityGenerator.createDbT4121ShinseiRirekiJohoEntity());
            hokenshaShinseiRirekiJoho.getEntity().initializeMd5();
            sut.save申請履歴(hokenshaShinseiRirekiJoho);
        }
    }

}
