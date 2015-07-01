/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.realservice.HokenshaChosainManager;
import jp.co.ndensan.reams.db.dbz.business.HokenshaChosainJoho;
import jp.co.ndensan.reams.db.dbz.business.IChosainJoho;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT4913ChosainJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT4913ChosainJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT4913ChosainJohoDac;
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
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link HokenshaChosainManager}のテストクラスです。
 *
 * @author n8223　朴義一
 */
@RunWith(Enclosed.class)
public class HokenshaChosainManagerTest {

    private static final LasdecCode 市町村コード = new LasdecCode("123456");
    private static final ChosaItakusakiCode 認定調査委託先コード = new ChosaItakusakiCode("1234567890");
    private static final ChosainCode 認定調査員コード = new ChosainCode("12345678");

    private static final LasdecCode notFound市町村コード = new LasdecCode("525345");
    private static final ChosaItakusakiCode notFound認定調査委託先コード = new ChosaItakusakiCode("5234567890");
    private static final ChosainCode notFound認定調査員コード = new ChosainCode("52345678");

    private static HokenshaChosainManager sut;
    private static DbT4913ChosainJohoDac dac;

    public HokenshaChosainManagerTest() {
    }

    /**
     * Test of find調査員情報 method, of class HokenshaChosainManager.
     */
    public static class testFind調査員情報 extends DbdTestBase {

        @Before
        public void setUp() {
            dac = mock(DbT4913ChosainJohoDac.class);
            sut = new HokenshaChosainManager(dac);
        }

        private static IChosainJoho createBusiness(LasdecCode 市町村コード, ChosaItakusakiCode 認定調査委託先コード, ChosainCode 認定調査員コード) {

            IChosainJoho business = mock(IChosainJoho.class);
            when(business.get市町村コード()).thenReturn(市町村コード);
            when(business.get認定調査委託先コード()).thenReturn(認定調査委託先コード);
            when(business.get認定調査員コード()).thenReturn(認定調査員コード);

            return business;
        }

        @Test
        public void testFind調査員情報_該当の情報がないとき_Optionalのemptyを返す() {
            Optional<DbT4913ChosainJohoEntity> entity = Optional.empty();
            Optional<IChosainJoho> business = Optional.empty();

            when(dac.selectByKey(notFound市町村コード, notFound認定調査委託先コード, notFound認定調査員コード)).thenReturn(entity);
            Optional<IChosainJoho> result = sut.find調査員情報(notFound市町村コード, notFound認定調査委託先コード, notFound認定調査員コード);
            assertThat(result, is(business));

        }

        @Test
        public void testFind調査員情報_該当の情報があるとき_該当情報を返す() {
            LasdecCode DEFAULT_市町村コード = new LasdecCode("123456");;
            ChosaItakusakiCode DEFAULT_認定調査委託先コード = new ChosaItakusakiCode("1234567890");;
            ChosainCode DEFAULT_認定調査員コード = new ChosainCode("12345678");;

            IChosainJoho business = createBusiness(DEFAULT_市町村コード, DEFAULT_認定調査委託先コード, DEFAULT_認定調査員コード);

            Optional<DbT4913ChosainJohoEntity> entity = Optional.ofNullable(DbT4913ChosainJohoEntityGenerator.createDbT4913ChosainJohoEntity());

            when(dac.selectByKey(市町村コード, 認定調査委託先コード, 認定調査員コード)).thenReturn(entity);
            Optional<IChosainJoho> result = sut.find調査員情報(市町村コード, 認定調査委託先コード, 認定調査員コード);
            assertThat(result.get().get市町村コード().value(), is(business.get市町村コード().value()));
        }

    }

    public static class testSave調査員情報 extends DbdTestBase {

        @Before
        public void setUp() {
            dac = mock(DbT4913ChosainJohoDac.class);
            sut = new HokenshaChosainManager(dac);
        }

        @Test
        public void insertに成功すると1が返る() {
            when(dac.insert(any(DbT4913ChosainJohoEntity.class))).thenReturn(1);
            IChosainJoho hokenshaChosainjoho = new HokenshaChosainJoho(DbT4913ChosainJohoEntityGenerator.createDbT4913ChosainJohoEntity());
            assertThat(sut.save調査員(hokenshaChosainjoho), is(1));
        }

        @Test
        public void updateに成功すると1が返る() {
            when(dac.update(any(DbT4913ChosainJohoEntity.class))).thenReturn(1);
            HokenshaChosainJoho hokenshaChosainjoho = new HokenshaChosainJoho(DbT4913ChosainJohoEntityGenerator.createDbT4913ChosainJohoEntity());
            hokenshaChosainjoho.getEntity().initializeMd5();
            //編集
            HokenshaChosainJoho.Builder createBuilderForEdit = hokenshaChosainjoho.createBuilderForEdit();
            createBuilderForEdit.setSeibetsu(new RString("2"));
            IChosainJoho build = createBuilderForEdit.build();
            assertThat(sut.save調査員(build), is(1));
        }

        @Test
        public void deleteに成功すると1が返る() {
            when(dac.delete(any(DbT4913ChosainJohoEntity.class))).thenReturn(1);
            HokenshaChosainJoho hokenshaChosainjoho = new HokenshaChosainJoho(DbT4913ChosainJohoEntityGenerator.createDbT4913ChosainJohoEntity());
            hokenshaChosainjoho.getEntity().initializeMd5();
            hokenshaChosainjoho.setDeletedState(true);

            assertThat(sut.save調査員(hokenshaChosainjoho), is(1));
        }

        @Test
        public void ビジネスクラスの状態がUnchangedの場合_ApplicationExceptionが発生する() {
            HokenshaChosainJoho hokenshaChosainjoho = new HokenshaChosainJoho(DbT4913ChosainJohoEntityGenerator.createDbT4913ChosainJohoEntity());
            hokenshaChosainjoho.getEntity().initializeMd5();
            sut.save調査員(hokenshaChosainjoho);
        }
    }

}
