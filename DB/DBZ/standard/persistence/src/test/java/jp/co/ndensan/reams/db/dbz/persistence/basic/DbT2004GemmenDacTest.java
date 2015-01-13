/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ChoteiNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2004GemmenEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2004GemmenEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2004GemmenEntityGenerator.*;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT2004GemmenDac}のテストです。
 *
 * @author LDNS 鄭雪双
 */
@RunWith(Enclosed.class)
public class DbT2004GemmenDacTest extends DbzTestDacBase {

    private static final ChoteiNendo 調定年度2012 = new ChoteiNendo(new FlexibleYear("2012"));
    private static final ChoteiNendo 調定年度2013 = new ChoteiNendo(new FlexibleYear("2013"));
    private static DbT2004GemmenDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT2004GemmenDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    new ChoteiNendo(DEFAULT_調定年度),
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時);
            TestSupport.insert(
                    調定年度2012,
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 調定年度がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 賦課年度がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    new ChoteiNendo(DEFAULT_調定年度),
                    null,
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 通知書番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    new ChoteiNendo(DEFAULT_調定年度),
                    new FukaNendo(DEFAULT_賦課年度),
                    null,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 処理日時がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    new ChoteiNendo(DEFAULT_調定年度),
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_通知書番号,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT2004GemmenEntity insertedRecord = sut.selectByKey(
                    new ChoteiNendo(DEFAULT_調定年度),
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT2004GemmenEntity insertedRecord = sut.selectByKey(
                    調定年度2013,
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 介護賦課減免が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    new ChoteiNendo(DEFAULT_調定年度),
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時);
            TestSupport.insert(
                    調定年度2012,
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 介護賦課減免が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 介護賦課減免エンティティを渡すと_insertは_介護賦課減免を追加する() {
            TestSupport.insert(
                    new ChoteiNendo(DEFAULT_調定年度),
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時);

            assertThat(sut.selectByKey(
                    new ChoteiNendo(DEFAULT_調定年度),
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    new ChoteiNendo(DEFAULT_調定年度),
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時);
        }

        @Test
        public void 介護賦課減免エンティティを渡すと_updateは_介護賦課減免を更新する() {
            DbT2004GemmenEntity updateRecord = DbT2004GemmenEntityGenerator.createDbT2004GemmenEntity();

            updateRecord.setShinseiJiyu(new RString("9"));

            sut.update(updateRecord);

            DbT2004GemmenEntity updatedRecord = sut.selectByKey(
                    new ChoteiNendo(DEFAULT_調定年度),
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時);

            assertThat(updateRecord.getShinseiJiyu(), is(updatedRecord.getShinseiJiyu()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    new ChoteiNendo(DEFAULT_調定年度),
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時);
        }

        @Test
        public void 介護賦課減免エンティティを渡すと_deleteは_介護賦課減免を削除する() {
            sut.delete(sut.selectByKey(
                    new ChoteiNendo(DEFAULT_調定年度),
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時));
            assertThat(sut.selectByKey(
                    new ChoteiNendo(DEFAULT_調定年度),
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                ChoteiNendo 調定年度,
                FukaNendo 賦課年度,
                TsuchishoNo 通知書番号,
                RDateTime 処理日時) {
            DbT2004GemmenEntity entity = DbT2004GemmenEntityGenerator.createDbT2004GemmenEntity();
            entity.setChoteiNendo(調定年度.value());
            entity.setFukaNendo(賦課年度.value());
            entity.setTsuchishoNo(通知書番号);
            entity.setShoriTimestamp(処理日時);
            sut.insert(entity);
        }
    }
}
