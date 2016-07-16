/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT2003KibetsuEntityGenerator;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT2003KibetsuEntityGenerator.DEFAULT_履歴番号;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT2003KibetsuEntityGenerator.DEFAULT_徴収方法;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT2003KibetsuEntityGenerator.DEFAULT_期;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT2003KibetsuEntityGenerator.DEFAULT_調定年度;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT2003KibetsuEntityGenerator.DEFAULT_賦課年度;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT2003KibetsuEntityGenerator.DEFAULT_通知書番号;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestDacBase;
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
 * {@link DbT2003KibetsuDac}のテストです。
 */
@Ignore
@RunWith(Enclosed.class)
public class DbT2003KibetsuDacTest extends DbxTestDacBase {

    private static final TsuchishoNo 通知書番号_01 = new TsuchishoNo("2");
    private static final TsuchishoNo 通知書番号_02 = new TsuchishoNo("3");
    private static final TsuchishoNo 通知書番号_03 = new TsuchishoNo("4");
    private static DbT2003KibetsuDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT2003KibetsuDac.class);
    }

    public static class selectByKeyのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    通知書番号_01,
                    DEFAULT_履歴番号,
                    DEFAULT_徴収方法,
                    DEFAULT_期);
            TestSupport.insert(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    通知書番号_02,
                    DEFAULT_履歴番号,
                    DEFAULT_徴収方法,
                    DEFAULT_期);
        }

        @Test(expected = NullPointerException.class)
        public void 調定年度がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    DEFAULT_履歴番号,
                    DEFAULT_徴収方法,
                    DEFAULT_期);
        }

        @Test(expected = NullPointerException.class)
        public void 賦課年度がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_調定年度,
                    null,
                    DEFAULT_通知書番号,
                    DEFAULT_履歴番号,
                    DEFAULT_徴収方法,
                    DEFAULT_期);
        }

        @Test(expected = NullPointerException.class)
        public void 通知書番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    null,
                    DEFAULT_履歴番号,
                    DEFAULT_徴収方法,
                    DEFAULT_期);
        }

//        @Test(expected = NullPointerException.class)
//        public void 履歴番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
//            sut.selectByKey(
//                    DEFAULT_調定年度,
//                    DEFAULT_賦課年度,
//                    DEFAULT_通知書番号,
//                    null,
//                    DEFAULT_徴収方法,
//                    DEFAULT_期);
//        }
        @Test(expected = NullPointerException.class)
        public void 徴収方法がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    DEFAULT_履歴番号,
                    null,
                    DEFAULT_期);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT2003KibetsuEntity insertedRecord = sut.selectByKey(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    通知書番号_01,
                    DEFAULT_履歴番号,
                    DEFAULT_徴収方法,
                    DEFAULT_期);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT2003KibetsuEntity insertedRecord = sut.selectByKey(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    通知書番号_03,
                    DEFAULT_履歴番号,
                    DEFAULT_徴収方法,
                    DEFAULT_期);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbxTestDacBase {

        @Test
        public void 介護期別が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    通知書番号_01,
                    DEFAULT_履歴番号,
                    DEFAULT_徴収方法,
                    DEFAULT_期);
            TestSupport.insert(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    通知書番号_02,
                    DEFAULT_履歴番号,
                    DEFAULT_徴収方法,
                    DEFAULT_期);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 介護期別が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbxTestDacBase {

        @Test
        public void 介護期別エンティティを渡すと_insertは_介護期別を追加する() {
            TestSupport.insert(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    DEFAULT_履歴番号,
                    DEFAULT_徴収方法,
                    DEFAULT_期);

            assertThat(sut.selectByKey(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    DEFAULT_履歴番号,
                    DEFAULT_徴収方法,
                    DEFAULT_期), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    DEFAULT_履歴番号,
                    DEFAULT_徴収方法,
                    DEFAULT_期);
        }

        @Test
        public void 介護期別エンティティを渡すと_updateは_介護期別を更新する() {
            DbT2003KibetsuEntity updateRecord = sut.selectByKey(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    DEFAULT_履歴番号,
                    DEFAULT_徴収方法,
                    DEFAULT_期);
            updateRecord.setChoteiId(new Decimal(75));

            sut.save(updateRecord);

            DbT2003KibetsuEntity updatedRecord = sut.selectByKey(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    DEFAULT_履歴番号,
                    DEFAULT_徴収方法,
                    DEFAULT_期);

            assertThat(updateRecord.getChoteiId(), is(updatedRecord.getChoteiId()));
        }
    }

    public static class deleteのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    DEFAULT_履歴番号,
                    DEFAULT_徴収方法,
                    DEFAULT_期);
        }

        @Test
        public void 介護期別エンティティを渡すと_deleteは_介護期別を削除する() {
            DbT2003KibetsuEntity deletedEntity = sut.selectByKey(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    DEFAULT_履歴番号,
                    DEFAULT_徴収方法,
                    DEFAULT_期);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    DEFAULT_履歴番号,
                    DEFAULT_徴収方法,
                    DEFAULT_期), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                FlexibleYear 調定年度,
                FlexibleYear 賦課年度,
                TsuchishoNo 通知書番号,
                int 履歴番号,
                RString 徴収方法,
                int 期) {
            DbT2003KibetsuEntity entity = DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity();
            entity.setChoteiNendo(調定年度);
            entity.setFukaNendo(賦課年度);
            entity.setTsuchishoNo(通知書番号);
            entity.setRirekiNo(履歴番号);
            entity.setChoshuHouhou(徴収方法);
            entity.setKi(期);
            sut.save(entity);
        }
    }
}
