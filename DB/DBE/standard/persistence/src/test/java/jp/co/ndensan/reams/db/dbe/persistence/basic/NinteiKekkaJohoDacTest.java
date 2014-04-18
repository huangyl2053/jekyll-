/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5002NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5002NinteiKekkaJohoEntityMock;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
    private static final int 最新審査会番号 = 300;

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
        public void 該当の認定結果情報が存在する時_selectは_該当の最新情報を返す() {
            assertThat(sut.select(既存管理番号).getShinsakaiKaisaiNo(), is(最新審査会番号));
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
            assertThat(sut.select(新規管理番号).getShinseishoKanriNo(), is(新規管理番号));
        }

        @Test
        public void 追記型は指定した認定結果情報が存在する時も_insertが_成功する() {
            assertThat(sut.insert(createEntity(AS_既存データ)), is(1));
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

        @Test
        public void 追記型は指定した認定結果情報が存在しない時も_deleteが_成功する() {
            assertThat(sut.delete(createEntity(AS_新規データ)), is(1));
        }
    }

    private static void initializeEntityData() {
        DbT5002NinteiKekkaJohoEntity entity = createEntity(AS_既存データ);
        for (int i = 0; i < 3; i++) {
            entity.setShinsakaiKaisaiNo((i + 1) * 100);
            sut.insert(entity);
        }
    }

    private static DbT5002NinteiKekkaJohoEntity createEntity(int flg) {
        DbT5002NinteiKekkaJohoEntity entity = DbT5002NinteiKekkaJohoEntityMock.getDbT5002NinteiKekkaJohoEntity();
        entity.setShinseishoKanriNo(flg == AS_新規データ ? 新規管理番号 : 既存管理番号);
        return entity;
    }
}
