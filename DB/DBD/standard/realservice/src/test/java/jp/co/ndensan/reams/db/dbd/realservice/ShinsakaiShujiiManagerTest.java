/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.realservice;

import jp.co.ndensan.reams.db.dbd.definition.valueobject.ninteishinsei.ShujiiCode;
import jp.co.ndensan.reams.db.dbd.definition.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.db.dbd.business.IShujiiJoho;
import jp.co.ndensan.reams.db.dbd.business.ShinsakaiShujiiJoho;
import jp.co.ndensan.reams.db.dbd.entity.basic.DbT5912ShujiiJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.basic.helper.DbT5912ShujiiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbd.persistence.basic.DbT5912ShujiiJohoDac;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestBase;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
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
 * {@link ShinsakaiShujiiManager}のテストクラスです。
 *
 * @author N8235 船山 洋介
 */
@RunWith(Enclosed.class)
public class ShinsakaiShujiiManagerTest {

    public static final LasdecCode Found市町村コード = new LasdecCode("100001");
    public static final ShujiiIryokikanCode Found主治医医療機関コード = new ShujiiIryokikanCode("1000000001");
    public static final ShujiiCode Found主治医コード = new ShujiiCode("10000001");

    public static final LasdecCode notFound市町村コード = new LasdecCode("999999");

    private static ShinsakaiShujiiManager sut;
    private static DbT5912ShujiiJohoDac dac;

    @BeforeClass
    public static void setUp() {
        dac = mock(DbT5912ShujiiJohoDac.class);
        sut = new ShinsakaiShujiiManager(dac);
    }

    public static class find主治医医療機関 extends DbdTestBase {

        private static IShujiiJoho createBusiness(
                LasdecCode 市町村コード, ShujiiIryokikanCode 主治医医療機関コード, ShujiiCode 主治医コード) {
            IShujiiJoho business = mock(IShujiiJoho.class);
            when(business.get市町村コード()).thenReturn(市町村コード);
            when(business.get主治医医療機関コード()).thenReturn(主治医医療機関コード);
            when(business.get主治医コード()).thenReturn(主治医コード);

            return business;
        }

        @Test
        public void find認定申請情報は_該当の情報がない時_Optionalのemptyを返す() {
            Optional<IShujiiJoho> empty = Optional.empty();
            Optional<DbT5912ShujiiJohoEntity> entity = Optional.empty();
            when(dac.selectByKey(notFound市町村コード, Found主治医医療機関コード, Found主治医コード)).thenReturn(entity);
            Optional<IShujiiJoho> result = sut.find主治医(notFound市町村コード, Found主治医医療機関コード, Found主治医コード);

            assertThat(result, is(empty));
        }

        @Test
        public void find認定申請情報は_該当の情報がある時_該当情報を返す() {
            when(dac.selectByKey(Found市町村コード, Found主治医医療機関コード, Found主治医コード)).thenReturn(
                    Optional.ofNullable(DbT5912ShujiiJohoEntityGenerator.createDbT5912ShujiiJohoEntity()));
            Optional<IShujiiJoho> result = sut.find主治医(Found市町村コード, Found主治医医療機関コード, Found主治医コード);
            assertThat(result.get().get主治医コード(), is(createBusiness(Found市町村コード, Found主治医医療機関コード, Found主治医コード).get主治医コード()));
        }
    }

    public static class save主治医医療機関のテスト extends DbdTestBase {

        @Test
        public void insertに成功すると1が返る() {
            when(dac.insert(any(DbT5912ShujiiJohoEntity.class))).thenReturn(1);
            ShinsakaiShujiiJoho shinsakaiShujiiJoho = new ShinsakaiShujiiJoho(DbT5912ShujiiJohoEntityGenerator.createDbT5912ShujiiJohoEntity());

            assertThat(sut.save主治医機関情報(shinsakaiShujiiJoho), is(1));
        }

        @Test
        public void updateに成功すると1が返る() {
            when(dac.update(any(DbT5912ShujiiJohoEntity.class))).thenReturn(1);

            ShinsakaiShujiiJoho shinsakaiShujiiJoho = new ShinsakaiShujiiJoho(DbT5912ShujiiJohoEntityGenerator.createDbT5912ShujiiJohoEntity());

            shinsakaiShujiiJoho.getEntity().initializeMd5();
            ShinsakaiShujiiJoho.Builder createBuilderForEdit = shinsakaiShujiiJoho.createBuilderForEdit();
            createBuilderForEdit.setJusho(AtenaJusho.EMPTY);
            IShujiiJoho build = createBuilderForEdit.build();

            assertThat(sut.save主治医機関情報(build), is(1));
        }

        @Test
        public void deleteに成功すると1が返る() {
            when(dac.delete(any(DbT5912ShujiiJohoEntity.class))).thenReturn(1);

            ShinsakaiShujiiJoho shinsakaiShujiiJoho = new ShinsakaiShujiiJoho(DbT5912ShujiiJohoEntityGenerator.createDbT5912ShujiiJohoEntity());
            shinsakaiShujiiJoho.getEntity().initializeMd5();
            shinsakaiShujiiJoho.setDeletedState(true);

            assertThat(sut.save主治医機関情報(shinsakaiShujiiJoho), is(1));
        }

        @Test(expected = ApplicationException.class)
        public void ビジネスクラスの状態がUnchangedの場合_ApplicationExceptionが発生する() {

            ShinsakaiShujiiJoho shinsakaiShujiiJoho = new ShinsakaiShujiiJoho(DbT5912ShujiiJohoEntityGenerator.createDbT5912ShujiiJohoEntity());
            shinsakaiShujiiJoho.getEntity().initializeMd5();

            sut.save主治医機関情報(shinsakaiShujiiJoho);
        }
    }
}
