/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.realservice;

import jp.co.ndensan.reams.db.dbd.definition.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.db.dbd.business.IShujiiIryokikanJoho;
import jp.co.ndensan.reams.db.dbd.business.ShinsakaiShujiiIryoKikanJoho;
import jp.co.ndensan.reams.db.dbd.entity.basic.DbT5911ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.basic.helper.DbT5911ShujiiIryoKikanJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbd.persistence.basic.DbT5911ShujiiIryoKikanJohoDac;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
 * {@link ShinsakaiShujiiIryokikanManager}のテストクラスです。
 *
 * @author N8235 船山 洋介
 */
@RunWith(Enclosed.class)
public class ShinsakaiShujiiIryokikanManagerTest {

    public static final LasdecCode Found市町村コード = new LasdecCode("100001");
    public static final ShujiiIryokikanCode Found主治医医療機関コード = new ShujiiIryokikanCode("1000000001");
    public static final LasdecCode notFound市町村コード = new LasdecCode("999999");

    private static ShinsakaiShujiiIryokikanManager sut;
    private static DbT5911ShujiiIryoKikanJohoDac dac;

    @BeforeClass
    public static void setUp() {
        dac = mock(DbT5911ShujiiIryoKikanJohoDac.class);
        sut = new ShinsakaiShujiiIryokikanManager(dac);
    }

    public static class find主治医医療機関 extends DbdTestBase {

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
            Optional<DbT5911ShujiiIryoKikanJohoEntity> entity = Optional.empty();
            when(dac.selectByKey(notFound市町村コード, Found主治医医療機関コード)).thenReturn(entity);
            Optional<IShujiiIryokikanJoho> result = sut.find主治医医療機関(notFound市町村コード, Found主治医医療機関コード);

            assertThat(result, is(empty));
        }

        @Test
        public void find認定申請情報は_該当の情報がある時_該当情報を返す() {
            when(dac.selectByKey(Found市町村コード, Found主治医医療機関コード)).thenReturn(
                    Optional.ofNullable(DbT5911ShujiiIryoKikanJohoEntityGenerator.createDbT5911ShujiiIryoKikanJohoEntity()));
            Optional<IShujiiIryokikanJoho> result = sut.find主治医医療機関(Found市町村コード, Found主治医医療機関コード);
            assertThat(result.get().get主治医医療機関コード(), is(createBusiness(Found市町村コード, Found主治医医療機関コード).get主治医医療機関コード()));
        }

    }

    public static class save主治医医療機関のテスト extends DbdTestBase {

        @Test
        public void insertに成功すると1が返る() {
            when(dac.insert(any(DbT5911ShujiiIryoKikanJohoEntity.class))).thenReturn(1);
            IShujiiIryokikanJoho hokenshaShujiiIryoKikanJoho = new ShinsakaiShujiiIryoKikanJoho(DbT5911ShujiiIryoKikanJohoEntityGenerator.createDbT5911ShujiiIryoKikanJohoEntity());

            assertThat(sut.save主治医医療機関情報(hokenshaShujiiIryoKikanJoho), is(1));
        }

        @Test
        public void updateに成功すると1が返る() {
            when(dac.update(any(DbT5911ShujiiIryoKikanJohoEntity.class))).thenReturn(1);

            ShinsakaiShujiiIryoKikanJoho hokenshaShujiiIryoKikanJoho = new ShinsakaiShujiiIryoKikanJoho(DbT5911ShujiiIryoKikanJohoEntityGenerator.createDbT5911ShujiiIryoKikanJohoEntity());

            hokenshaShujiiIryoKikanJoho.getEntity().initializeMd5();
            ShinsakaiShujiiIryoKikanJoho.Builder createBuilderForEdit = hokenshaShujiiIryoKikanJoho.createBuilderForEdit();
            createBuilderForEdit.setJusho(RString.HALF_SPACE);
            IShujiiIryokikanJoho build = createBuilderForEdit.build();

            assertThat(sut.save主治医医療機関情報(build), is(1));
        }

        @Test
        public void deleteに成功すると1が返る() {
            when(dac.delete(any(DbT5911ShujiiIryoKikanJohoEntity.class))).thenReturn(1);

            ShinsakaiShujiiIryoKikanJoho hokenshaShujiiIryoKikanJoho = new ShinsakaiShujiiIryoKikanJoho(DbT5911ShujiiIryoKikanJohoEntityGenerator.createDbT5911ShujiiIryoKikanJohoEntity());
            hokenshaShujiiIryoKikanJoho.getEntity().initializeMd5();
            hokenshaShujiiIryoKikanJoho.setDeletedState(true);

            assertThat(sut.save主治医医療機関情報(hokenshaShujiiIryoKikanJoho), is(1));
        }

        @Test(expected = ApplicationException.class)
        public void ビジネスクラスの状態がUnchangedの場合_ApplicationExceptionが発生する() {

            ShinsakaiShujiiIryoKikanJoho hokenshaShujiiIryoKikanJoho = new ShinsakaiShujiiIryoKikanJoho(DbT5911ShujiiIryoKikanJohoEntityGenerator.createDbT5911ShujiiIryoKikanJohoEntity());
            hokenshaShujiiIryoKikanJoho.getEntity().initializeMd5();

            sut.save主治医医療機関情報(hokenshaShujiiIryoKikanJoho);
        }
    }
}
