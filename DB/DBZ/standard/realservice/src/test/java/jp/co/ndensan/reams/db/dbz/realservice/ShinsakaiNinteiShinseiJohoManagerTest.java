/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.realservice.ShinsakaiNinteiShinseiJohoManager;
import jp.co.ndensan.reams.db.dbz.business.INinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.business.ShinsakaiNinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5101NinteiShinseiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT5101NinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestBase;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

/**
 * {link ShinsakaiNinteiShinseiJohoManager}のテストクラスです。
 *
 * @author N8235 船山 洋介
 */
@RunWith(Enclosed.class)
public class ShinsakaiNinteiShinseiJohoManagerTest {

    private static final ShinseishoKanriNo notFound申請書管理番号 = new ShinseishoKanriNo("99999999999999999");
    private static final ShinseishoKanriNo Found申請書管理番号 = new ShinseishoKanriNo("00000000000000999");

    private static ShinsakaiNinteiShinseiJohoManager sut;
    private static DbT5101NinteiShinseiJohoDac dac;

    @BeforeClass
    public static void setUp() {
        dac = mock(DbT5101NinteiShinseiJohoDac.class);
        sut = new ShinsakaiNinteiShinseiJohoManager(dac);
    }

    public static class find認定申請情報 extends DbdTestBase {

        private static INinteiShinseiJoho createBusiness(ShinseishoKanriNo 申請書管理番号) {
            INinteiShinseiJoho business = mock(INinteiShinseiJoho.class);
            when(business.get申請書管理番号()).thenReturn(申請書管理番号);
            return business;
        }

        @Test
        public void find認定申請情報は_該当の情報がない時_Optionalのemptyを返す() {
            Optional<INinteiShinseiJoho> empty = Optional.empty();
            Optional<DbT5101NinteiShinseiJohoEntity> entity = Optional.empty();
            when(dac.selectByKey(notFound申請書管理番号)).thenReturn(entity);
            Optional<INinteiShinseiJoho> result = sut.find認定申請情報(notFound申請書管理番号);

            assertThat(result, is(empty));
        }

        @Test
        public void find認定申請情報は_該当の情報がある時_該当情報を返す() {

            when(dac.selectByKey(Found申請書管理番号)).thenReturn(
                    Optional.ofNullable(DbT5101NinteiShinseiJohoEntityGenerator.createDbT5101NinteiShinseiJohoEntity()));
            Optional<INinteiShinseiJoho> result = sut.find認定申請情報(Found申請書管理番号);
            assertThat(result.get().get申請書管理番号().value(), is(createBusiness(Found申請書管理番号).get申請書管理番号().value()));
        }
    }

    public static class save認定申請情報のテスト extends DbdTestBase {

        @Test
        public void insertに成功すると1が返る() {
            when(dac.insert(any(DbT5101NinteiShinseiJohoEntity.class))).thenReturn(1);

            INinteiShinseiJoho renrakusaki = new ShinsakaiNinteiShinseiJoho(DbT5101NinteiShinseiJohoEntityGenerator.createDbT5101NinteiShinseiJohoEntity());

            assertThat(sut.save認定申請情報(renrakusaki), is(1));
        }

        @Test
        public void updateに成功すると1が返る() {
            when(dac.update(any(DbT5101NinteiShinseiJohoEntity.class))).thenReturn(1);

            ShinsakaiNinteiShinseiJoho renrakusaki = new ShinsakaiNinteiShinseiJoho(DbT5101NinteiShinseiJohoEntityGenerator.createDbT5101NinteiShinseiJohoEntity());
            renrakusaki.getEntity().initializeMd5();
            ShinsakaiNinteiShinseiJoho.Builder createBuilderForEdit = renrakusaki.createBuilderForEdit();
            createBuilderForEdit.setEnkiRiyu(RString.HALF_SPACE);
            INinteiShinseiJoho build = createBuilderForEdit.build();

            assertThat(sut.save認定申請情報(build), is(1));
        }

        @Test
        public void deleteに成功すると1が返る() {
            when(dac.delete(any(DbT5101NinteiShinseiJohoEntity.class))).thenReturn(1);

            ShinsakaiNinteiShinseiJoho renrakusaki = new ShinsakaiNinteiShinseiJoho(DbT5101NinteiShinseiJohoEntityGenerator.createDbT5101NinteiShinseiJohoEntity());
            renrakusaki.getEntity().initializeMd5();
            renrakusaki.setDeletedState(true);

            assertThat(sut.save認定申請情報(renrakusaki), is(1));
        }

        @Test(expected = ApplicationException.class)
        public void ビジネスクラスの状態がUnchangedの場合_ApplicationExceptionが発生する() {

            ShinsakaiNinteiShinseiJoho renrakusaki = new ShinsakaiNinteiShinseiJoho(DbT5101NinteiShinseiJohoEntityGenerator.createDbT5101NinteiShinseiJohoEntity());
            renrakusaki.getEntity().initializeMd5();

            sut.save認定申請情報(renrakusaki);
        }
    }

}
