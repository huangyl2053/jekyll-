/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.basic;

import jp.co.ndensan.reams.db.dbe.persistence.db.basic.ShujiiIkenshoJohoDac;
import jp.co.ndensan.reams.db.dbe.definition.core.valueobject.IkenshosakuseiIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5012ShujiiIkenshoJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.helper.ShujiiIkenshoEntityMock;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
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
import org.junit.Ignore;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * 主治医意見書情報のデータアクセスクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
@Ignore
public class ShujiiIkenshoJohoDacTest {

    private static ShujiiIkenshoJohoDac sut;
    private static final int AS_新規データ = 1;
    private static final int AS_既存データ = 2;
    private static final int AS_更新データ = 3;
    private static final ShinseishoKanriNo 新規管理番号 = new ShinseishoKanriNo(new RString("9999999999"));
    private static final ShinseishoKanriNo 既存管理番号 = new ShinseishoKanriNo(new RString("1234567899"));
    private static final RString 更新前主治医コード = new RString("11111111");
    private static final RString 更新後主治医コード = new RString("22222222");

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(ShujiiIkenshoJohoDac.class);
    }

    public static class select extends DbeTestDacBase {

        @Before
        public void setUp() {
            initializeEntityData();
        }

        @Test
        public void 該当の主治医意見書情報が存在しない時_selectは_NULLを返す() {
            assertThat(sut.select(新規管理番号, createRirekiNo()), nullValue());
        }

        @Test
        public void 該当の主治医意見書情報が存在する時_selectは_該当の情報を返す() {
            assertThat(sut.select(既存管理番号, createRirekiNo()).getShinseishoKanriNo(), is(既存管理番号));
        }
    }

    public static class insertOrUpdate extends DbeTestDacBase {

        @Before
        public void setUp() {
            initializeEntityData();
        }

        @Test
        public void 指定した主治医意見書情報が存在しない時_insertOrUpdateは_指定した情報を追加する() {
            sut.insertOrUpdate(createEntity(AS_新規データ));
            assertThat(sut.select(新規管理番号, createRirekiNo()).getShinseishoKanriNo(), is(新規管理番号));
        }

        @Test
        public void 指定した主治医意見書情報が存在する時_insertOrUpdateは_該当の情報を更新する() {
            sut.insertOrUpdate(createEntity(AS_更新データ));
            assertThat(sut.select(既存管理番号, createRirekiNo()).getShujiiCode(), is(更新後主治医コード));
        }
    }

    public static class insert extends DbeTestDacBase {

        @Before
        public void setUp() {
            initializeEntityData();
        }

        @Test
        public void 指定した主治医意見書情報が存在しない時_insertは_成功する() {
            assertThat(sut.insert(createEntity(AS_新規データ)), is(1));
        }

        @Test
        public void 指定した主治医意見書情報が存在しない時_insertは_指定した情報を追加する() {
            sut.insert(createEntity(AS_新規データ));
            assertThat(sut.select(新規管理番号, createRirekiNo()).getShinseishoKanriNo(), is(新規管理番号));
        }

        @Test(expected = SystemException.class)
        public void 指定した主治医意見書情報が存在する時_insertは_失敗する() {
            sut.insert(createEntity(AS_既存データ));
        }
    }

    public static class update extends DbeTestDacBase {

        @Before
        public void setUp() {
            initializeEntityData();
        }

        @Test
        public void 指定した主治医意見書情報が存在する時_updateは_成功する() {
            assertThat(sut.update(createEntity(AS_既存データ)), is(1));
        }

        @Test
        public void 指定した主治医意見書情報が存在する時_updateは_該当の情報を更新する() {
            sut.update(createEntity(AS_更新データ));
            assertThat(sut.select(既存管理番号, createRirekiNo()).getShujiiCode(), is(更新後主治医コード));
        }

        @Test(expected = _SQLOptimisticLockFaildException.class)
        public void 指定した主治医意見書情報が存在しない時_updateは_失敗する() {
            sut.update(createEntity(AS_新規データ));
        }
    }

    public static class delete extends DbeTestDacBase {

        @Before
        public void setUp() {
            initializeEntityData();
        }

        @Test
        public void 指定した主治医意見書情報が存在する時_deleteは_成功する() {
            assertThat(sut.delete(createEntity(AS_既存データ)), is(1));
        }

        @Test
        public void 指定した主治医意見書情報が存在する時_deleteは_該当の情報を削除する() {
            sut.delete(createEntity(AS_既存データ));
            assertThat(sut.select(既存管理番号, createRirekiNo()), nullValue());
        }

        @Test(expected = _SQLOptimisticLockFaildException.class)
        public void 指定した主治医意見書情報が存在しない時_deleteは_失敗する() {
            sut.delete(createEntity(AS_新規データ));
        }
    }

    private static void initializeEntityData() {
        sut.insert(createEntity(AS_既存データ));
    }

    private static DbT5012ShujiiIkenshoJohoEntity createEntity(int flg) {
        DbT5012ShujiiIkenshoJohoEntity entity = ShujiiIkenshoEntityMock.getDbT5012ShujiiIkenshoJohoEntity();
        entity.setShinseishoKanriNo(flg == AS_新規データ ? 新規管理番号 : 既存管理番号);
        entity.setShujiiCode(flg == AS_更新データ ? 更新後主治医コード : 更新前主治医コード);
        return entity;
    }

    private static IkenshosakuseiIraiRirekiNo createRirekiNo() {
        return new IkenshosakuseiIraiRirekiNo(0);
    }
}
