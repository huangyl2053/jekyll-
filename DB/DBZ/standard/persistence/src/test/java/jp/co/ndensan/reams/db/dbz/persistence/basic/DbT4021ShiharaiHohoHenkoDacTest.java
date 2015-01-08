/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT4021ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT4021ShiharaiHohoHenkoEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT4021ShiharaiHohoHenkoEntityGenerator.*;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT4021ShiharaiHohoHenkoDac}のテストです。
 *
 * @author n8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class DbT4021ShiharaiHohoHenkoDacTest extends DbzTestDacBase {

    private static DbT4021ShiharaiHohoHenkoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT4021ShiharaiHohoHenkoDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_管理区分.code(),
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 証記載保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_被保険者番号,
                    DEFAULT_管理区分.code(),
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    null,
                    DEFAULT_管理区分.code(),
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 管理区分がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    null,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 処理日時がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_管理区分.code(),
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT4021ShiharaiHohoHenkoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_管理区分.code(),
                    DEFAULT_処理日時);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT4021ShiharaiHohoHenkoEntity insertedRecord = sut.selectByKey(
                    new ShoKisaiHokenshaNo("123450"),
                    DEFAULT_被保険者番号,
                    DEFAULT_管理区分.code(),
                    DEFAULT_処理日時);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 支払方法変更が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_管理区分.code(),
                    DEFAULT_処理日時);
            assertThat(sut.selectAll().size(), is(1));
        }

        @Test
        public void 支払方法変更が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 支払方法変更エンティティを渡すと_insertは_支払方法変更を追加する() {
            TestSupport.insert(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_管理区分.code(),
                    DEFAULT_処理日時);

            assertThat(sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_管理区分.code(),
                    DEFAULT_処理日時), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_管理区分.code(),
                    DEFAULT_処理日時);
        }

        @Test
        public void 支払方法変更エンティティを渡すと_updateは_支払方法変更を更新する() {
            DbT4021ShiharaiHohoHenkoEntity updateRecord = DbT4021ShiharaiHohoHenkoEntityGenerator.createDbT4021ShiharaiHohoHenkoEntity();
            updateRecord.setBemmei_RiyuCode(new RString("9"));

            sut.update(updateRecord);

            DbT4021ShiharaiHohoHenkoEntity updatedRecord = sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_管理区分.code(),
                    DEFAULT_処理日時);

            assertThat(updateRecord.getBemmei_RiyuCode(), is(updatedRecord.getBemmei_RiyuCode()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_管理区分.code(),
                    DEFAULT_処理日時);
        }

        @Test
        public void 支払方法変更エンティティを渡すと_deleteは_支払方法変更を削除する() {
            sut.delete(sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_管理区分.code(),
                    DEFAULT_処理日時));
            assertThat(sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_管理区分.code(),
                    DEFAULT_処理日時), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                ShoKisaiHokenshaNo 証記載保険者番号,
                HihokenshaNo 被保険者番号,
                RString 管理区分,
                YMDHMS 処理日時) {
            DbT4021ShiharaiHohoHenkoEntity entity = DbT4021ShiharaiHohoHenkoEntityGenerator.createDbT4021ShiharaiHohoHenkoEntity();
            entity.setShoKisaiHokenshaNo(証記載保険者番号);
            entity.setHihokenshaNo(被保険者番号);
            entity.setKanriKubun(管理区分);
            entity.setShoriTimestamp(処理日時);
            sut.insert(entity);
        }
    }
}
