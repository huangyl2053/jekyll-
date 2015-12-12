/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choshuyuyo.DbT2006ChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.helper.DbT2006ChoshuYuyoEntityGenerator;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.helper.DbT2006ChoshuYuyoEntityGenerator.DEFAULT_履歴番号;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.helper.DbT2006ChoshuYuyoEntityGenerator.DEFAULT_調定年度;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.helper.DbT2006ChoshuYuyoEntityGenerator.DEFAULT_賦課年度;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.helper.DbT2006ChoshuYuyoEntityGenerator.DEFAULT_通知書番号;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT2006ChoshuYuyoDac}のテストです。
 */
@Ignore
@RunWith(Enclosed.class)
public class DbT2006ChoshuYuyoDacTest extends DbbTestDacBase {

    private static final TsuchishoNo 通知書番号_01 = new TsuchishoNo("2");
    private static final TsuchishoNo 通知書番号_02 = new TsuchishoNo("3");
    private static final TsuchishoNo 通知書番号_03 = new TsuchishoNo("4");
    private static DbT2006ChoshuYuyoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT2006ChoshuYuyoDac.class);
    }

    public static class selectByKeyのテスト extends DbbTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    通知書番号_01,
                    DEFAULT_履歴番号);
            TestSupport.insert(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    通知書番号_02,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 調定年度がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 賦課年度がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_調定年度,
                    null,
                    DEFAULT_通知書番号,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 通知書番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    null,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 履歴番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT2006ChoshuYuyoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    通知書番号_01,
                    DEFAULT_履歴番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT2006ChoshuYuyoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    通知書番号_03,
                    DEFAULT_履歴番号);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbbTestDacBase {

        @Test
        public void 介護賦課徴収猶予が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    通知書番号_01,
                    DEFAULT_履歴番号);
            TestSupport.insert(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    通知書番号_02,
                    DEFAULT_履歴番号);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 介護賦課徴収猶予が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbbTestDacBase {

        @Test
        public void 介護賦課徴収猶予エンティティを渡すと_insertは_介護賦課徴収猶予を追加する() {
            TestSupport.insert(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    DEFAULT_履歴番号);

            assertThat(sut.selectByKey(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    DEFAULT_履歴番号), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbbTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 介護賦課徴収猶予エンティティを渡すと_updateは_介護賦課徴収猶予を更新する() {
            DbT2006ChoshuYuyoEntity updateRecord = sut.selectByKey(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    DEFAULT_履歴番号);
            updateRecord.setShinseiJiyu(new RString("1"));

            sut.save(updateRecord);

            DbT2006ChoshuYuyoEntity updatedRecord = sut.selectByKey(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    DEFAULT_履歴番号);

            assertThat(updateRecord.getShinseiJiyu(), is(updatedRecord.getShinseiJiyu()));
        }
    }

    public static class deleteのテスト extends DbbTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 介護賦課徴収猶予エンティティを渡すと_deleteは_介護賦課徴収猶予を削除する() {
            DbT2006ChoshuYuyoEntity deletedEntity = sut.selectByKey(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    DEFAULT_履歴番号);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    DEFAULT_履歴番号), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                FlexibleYear 調定年度,
                FlexibleYear 賦課年度,
                TsuchishoNo 通知書番号,
                Decimal 履歴番号) {
            DbT2006ChoshuYuyoEntity entity = DbT2006ChoshuYuyoEntityGenerator.createDbT2006ChoshuYuyoEntity();
            entity.setChoteiNendo(調定年度);
            entity.setFukaNendo(賦課年度);
            entity.setTsuchishoNo(通知書番号);
            entity.setRirekiNo(履歴番号);
            sut.save(entity);
        }
    }
}
