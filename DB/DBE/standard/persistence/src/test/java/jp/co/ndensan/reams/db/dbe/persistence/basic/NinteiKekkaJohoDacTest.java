/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5002NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5002NinteiKekkaJohoEntityMock;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;
import jp.co.ndensan.reams.uz.uza.util.db._SQLOptimisticLockFaildException;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * 要介護認定結果情報のデータアクセスクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class NinteiKekkaJohoDacTest extends DbeTestDacBase {

    private static NinteiKekkaJohoDac sut;
    private static final int AS_新規データ = 1;
    private static final int AS_既存データ = 2;
    private static final ShinseishoKanriNo 新規管理番号 = new ShinseishoKanriNo(new RString("9999999999"));
    private static final ShinseishoKanriNo 既存管理番号 = new ShinseishoKanriNo(new RString("1234567899"));
    private static final int 審査会番号 = 100;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(NinteiKekkaJohoDac.class);
    }

    public static class select extends DbeTestDacBase {

        @Before
        public void setUp() {
            initializeEntityData();
        }

        @Test
        public void 該当の認定結果情報が存在しない時_selectは_NULLを返す() {
            assertThat(sut.select(新規管理番号), nullValue());
        }

        @Test
        public void 該当の認定結果情報が存在する時_selectは_該当の認定結果情報を返す() {
            assertThat(sut.select(既存管理番号).getShinsakaiKaisaiNo(), is(審査会番号));
        }
    }

    public static class insert extends DbeTestDacBase {

        @Before
        public void setUp() {
            initializeEntityData();
        }

        @Test
        public void 指定した認定結果情報が存在しない時_insertは_成功する() {
            assertThat(sut.insert(createEntity(AS_新規データ)), is(1));
        }

        @Test
        public void 指定した認定結果情報が存在しない時_insertは_指定した情報を追加する() {
            sut.insert(createEntity(AS_新規データ));
            assertThat(sut.select(新規管理番号).getShinseishoKanriNo(), is(新規管理番号.value()));
        }

        @Test(expected = SystemException.class)
        public void 認定結果情報が存在する_insertが_失敗する() {
            assertThat(sut.insert(createEntity(AS_既存データ)), is(0));
        }
    }

    public static class delete extends DbeTestDacBase {

        @Before
        public void setUp() {
            initializeEntityData();
        }

        @Test
        public void 指定した認定結果情報が存在する時_deleteは_成功する() {
            assertThat(sut.delete(createEntity(AS_既存データ)), is(1));
        }

        @Test
        public void 指定した認定結果情報が存在する時_deleteは_該当の情報を削除する() {
            sut.delete(createEntity(AS_既存データ));
            assertThat(sut.select(既存管理番号), nullValue());
        }

        @Test(expected = _SQLOptimisticLockFaildException.class)
        public void 指定した認定結果情報が存在しない時_deleteは_失敗する() {
            assertThat(sut.delete(createEntity(AS_新規データ)), is(0));
        }
    }

    private static void initializeEntityData() {
        DbT5002NinteiKekkaJohoEntity entity = createEntity(AS_既存データ);
        entity.setShinsakaiKaisaiNo(審査会番号);
        sut.insert(entity);
    }

    private static DbT5002NinteiKekkaJohoEntity createEntity(int flg) {
        DbT5002NinteiKekkaJohoEntity entity = DbT5002NinteiKekkaJohoEntityMock.getDbT5002NinteiKekkaJohoEntity();
        entity.setShinseishoKanriNo(flg == AS_新規データ ? 新規管理番号.value() : 既存管理番号.value());
        return entity;
    }
}
