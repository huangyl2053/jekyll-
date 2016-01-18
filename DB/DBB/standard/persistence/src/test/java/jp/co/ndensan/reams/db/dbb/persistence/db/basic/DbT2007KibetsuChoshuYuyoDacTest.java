/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2007KibetsuChoshuYuyoEntityGenerator;
import static jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_履歴番号;
import static jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_徴収方法;
import static jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_期;
import static jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_調定年度;
import static jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_賦課年度;
import static jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_通知書番号;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2007KibetsuChoshuYuyoEntity;
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
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT2007KibetsuChoshuYuyoDac}のテストです。
 */
@RunWith(Enclosed.class)
public class DbT2007KibetsuChoshuYuyoDacTest extends DbbTestDacBase {

    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT2007KibetsuChoshuYuyoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT2007KibetsuChoshuYuyoDac.class);
    }

    public static class selectByKeyのテスト extends DbbTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    DEFAULT_履歴番号,
                    DEFAULT_徴収方法,
                    DEFAULT_期);
            TestSupport.insert(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    DEFAULT_履歴番号,
                    DEFAULT_徴収方法,
                    DEFAULT_期);
        }

        @Test(expected = NullPointerException.class)
        public void 調定年度がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_調定年度,
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
                    DEFAULT_賦課年度,
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
                    DEFAULT_通知書番号,
                    DEFAULT_履歴番号,
                    DEFAULT_徴収方法,
                    DEFAULT_期);
        }

        @Test(expected = NullPointerException.class)
        public void 履歴番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    DEFAULT_履歴番号,
                    DEFAULT_徴収方法,
                    DEFAULT_期);
        }

        @Test(expected = NullPointerException.class)
        public void 徴収方法がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    DEFAULT_履歴番号,
                    DEFAULT_徴収方法,
                    DEFAULT_期);
        }

        @Test(expected = NullPointerException.class)
        public void 期がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    DEFAULT_履歴番号,
                    DEFAULT_徴収方法,
                    DEFAULT_期);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT2007KibetsuChoshuYuyoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    DEFAULT_履歴番号,
                    DEFAULT_徴収方法,
                    DEFAULT_期);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT2007KibetsuChoshuYuyoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    DEFAULT_履歴番号,
                    DEFAULT_徴収方法,
                    DEFAULT_期);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbbTestDacBase {

        @Test
        public void 介護期別徴収猶予が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    DEFAULT_履歴番号,
                    DEFAULT_徴収方法,
                    DEFAULT_期);
            TestSupport.insert(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    DEFAULT_履歴番号,
                    DEFAULT_徴収方法,
                    DEFAULT_期);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 介護期別徴収猶予が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbbTestDacBase {

        @Test
        public void 介護期別徴収猶予エンティティを渡すと_insertは_介護期別徴収猶予を追加する() {
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

    public static class updateのテスト extends DbbTestDacBase {

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
        public void 介護期別徴収猶予エンティティを渡すと_updateは_介護期別徴収猶予を更新する() {
            DbT2007KibetsuChoshuYuyoEntity updateRecord = sut.selectByKey(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    DEFAULT_履歴番号,
                    DEFAULT_徴収方法,
                    DEFAULT_期);
            updateRecord.setChoteiNendo(new FlexibleYear("2000"));

            sut.save(updateRecord);

            DbT2007KibetsuChoshuYuyoEntity updatedRecord = sut.selectByKey(
                    DEFAULT_調定年度,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号,
                    DEFAULT_履歴番号,
                    DEFAULT_徴収方法,
                    DEFAULT_期);

            assertThat(updateRecord.getChoteiNendo(), is(updatedRecord.getChoteiNendo()));
        }
    }

    public static class deleteのテスト extends DbbTestDacBase {

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
        public void 介護期別徴収猶予エンティティを渡すと_deleteは_介護期別徴収猶予を削除する() {
            DbT2007KibetsuChoshuYuyoEntity deletedEntity = sut.selectByKey(
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
                Decimal 履歴番号,
                RString 徴収方法,
                int 期) {
            DbT2007KibetsuChoshuYuyoEntity entity = DbT2007KibetsuChoshuYuyoEntityGenerator.createDbT2007KibetsuChoshuYuyoEntity();
            entity.setChoteiNendo(調定年度);
            entity.setFukaNendo(賦課年度);
            entity.setTsuchishoNo(通知書番号);
            entity.setRirekiNo(履歴番号);
            entity.setChoshuHoho(徴収方法);
            entity.setKi(期);
            sut.save(entity);
        }
    }
}
